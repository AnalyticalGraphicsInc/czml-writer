using System;
using System.Drawing;
using System.IO;
using System.Web;
using System.Web.Routing;
using CesiumLanguageWriter;

namespace ExampleCesiumLanguageServer
{
    /// <summary>
    /// This is a sample handler that uses CesiumLanguageWriter to return CZML in response
    /// to an HTTP request.  In this case it returns a handful of yellow dots that could have
    /// easily been computed client-side in JavaScript, but, the point here is to demonstrate
    /// returning CZML from a server that may have access to data needed by the client.
    /// </summary>
    public class InfoHandler : IHttpHandler, IRouteHandler
    {
        /// <summary>
        /// This handles the HTTP request by writing some example CZML into the response.
        /// </summary>
        /// <param name="context">The current HttpContext</param>
        public void ProcessRequest(HttpContext context)
        {
            // A more complex example could examine context.Request here for
            // inputs coming from the client-side application.

            // Set the response type for CZML, which is JSON.
            context.Response.ContentType = "application/json";

            // Create an output stream writer for the response.
            using (var outputStream = new StreamWriter(context.Response.OutputStream))
            {
                var cesiumWriter = new CesiumStreamWriter();
                var output = new CesiumOutputStream(outputStream);

                // Since this is a demo, turning on PrettyFormatting makes the response easier to view
                // with web browser developer tools.  It just adds whitespace and newlines to the response,
                // so production environments would typically leave this turned off.
                output.PrettyFormatting = true;

                // The whole body of CZML must be wrapped in a JSON array, opened here.
                output.WriteStartSequence();

                // The first packet (JSON object) of CZML must be the document packet.
                using (var entity = cesiumWriter.OpenPacket(output))
                {
                    entity.WriteId("document");
                    entity.WriteVersion("1.0");
                }

                // Now we generate some sample points and send them down.
                for (int y = -3; y <= 3; ++y)
                {
                    double lat = y * 10.0;
                    for (int x = -18; x <= 18; ++x)
                    {
                        double lon = x * 9.99999999;

                        // Open a new CZML packet for each point.
                        using (var entity = cesiumWriter.OpenPacket(output))
                        {
                            entity.WriteId("point " + (x * 10) + " " + (y * 10));

                            using (var position = entity.OpenPositionProperty())
                            {
                                position.WriteCartographicDegrees(new Cartographic(lon, lat, 0.0));
                            }

                            using (var point = entity.OpenPointProperty())
                            {
                                point.WritePixelSizeProperty(10.0);
                                point.WriteColorProperty(Color.Yellow);
                            }

                            // Click any dot in Cesium Viewer to read its description.
                            using (var description = entity.OpenDescriptionProperty())
                            {
                                description.WriteString(
                                    "<table class=\"cesium-infoBox-defaultTable\"><tbody>" +
                                    "<tr><td>Longitude</td><td>" + lon.ToString("0") + " degrees</td></tr>" +
                                    "<tr><td>Latitude</td><td>" + lat.ToString("0") + " degrees</td></tr>" +
                                    "</tbody></table>");
                            }
                        }
                    }
                }

                // Close the JSON array that wraps the entire CZML document.
                output.WriteEndSequence();
            }
        }

        public bool IsReusable
        {
            // Return false if your handler cannot be reused for another request, true if it can.
            get { return true; }
        }

        /// <summary>
        /// Gets the IHttpHandler for this route, which is always "this" because this class
        /// is a combination of IHttpHandler and IRouteHandler.  All routing requests are routed
        /// to itself for HTTP handling.  See Global.asax.cs to route requests here.
        /// </summary>
        /// <param name="requestContext">The current request context</param>
        /// <returns>this</returns>
        public IHttpHandler GetHttpHandler(RequestContext requestContext)
        {
            return this;
        }
    }
}
