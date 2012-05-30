using System;
using System.Collections.Generic;
using System.Linq;
using System.IO;
using System.Xml;
using System.Text;
using System.Runtime.Serialization.Json;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using CesiumLanguageWriter;

namespace WebGLGlobeJsonToCesiumLanguage
{
    public static class WebGlGlobeJsonConverter
    {
        /// <summary>
        /// The main entry point to convert a WebGL-globe JSON file.
        /// </summary>
        /// <param name="jsonContents">The JSON contents, following the <a href="http://code.google.com/p/webgl-globe/">WebGL Globe data format</a>.</param>
        /// <exception cref="System.ArugmentException">
        /// Coordinates listed in jsonContents must have 3 components.
        /// </exception>
        public static void WebGLGlobeJsonToCesiumLanguage(byte[] jsonContents, CzmlDocument document)
        {
            string jsonString = Encoding.ASCII.GetString(jsonContents);
            JsonTextReader jsReader = new JsonTextReader(new StringReader(jsonString));
            JArray json = (JArray)new JsonSerializer().Deserialize(jsReader);

            foreach (JToken item in json)
            {
                int numCoordinateComponents = item[1].Values().Count();
                if (numCoordinateComponents % 3 != 0)
                {
                    throw new System.ArgumentException("Coordinates listed in jsonContents must have 3 components", "jsonContents");
                }

                Cartographic[] coords = new Cartographic[numCoordinateComponents / 3];
                for (int i = 0, j= 0; i < numCoordinateComponents; i+=3, j++)
                {
                    coords[j] = new Cartographic(Constants.RadiansPerDegree * (double)item[1][i],
                                                 Constants.RadiansPerDegree * (double)item[1][i+1],
                                                 (double)item[1][i+2]);
                }
                Series series = new Series((string)item[0], coords, document);
                series.Write();
            }
        }
    }
}
