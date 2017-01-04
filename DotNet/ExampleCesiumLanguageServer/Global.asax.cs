using System;
using System.Web;
using System.Web.Routing;

namespace ExampleCesiumLanguageServer
{
    public class Global : HttpApplication
    {
        protected void Application_Start(object sender, EventArgs e)
        {
            // This example application has one custom route on path "info" that returns
            // some sample CZML points written by CesiumLanguageWriter.  The route is
            // added here, and implemented in InfoHandler.cs.  The same path "info" also
            // appears in index.html, which adds a CzmlDataSource from this path.
            RouteTable.Routes.Add(new Route("info", new InfoHandler()));
        }
    }
}