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

namespace WebGlGlobeJsonToCesiumLanguage
{
    public class WebGlGlobeJsonConverter
    {
        /// <summary>
        /// The main entry point to convert a WebGL-globe JSON file.
        /// </summary>
        /// <param name="jsonContents">The JSON contents.</param>
        public static void WebGlGlobeJsonToCesiumLanguage(byte[] jsonContents, CzmlDocument document)
        {
            string jsonString = Encoding.ASCII.GetString(jsonContents);
            JsonTextReader jsReader = new JsonTextReader(new StringReader(jsonString));
            JArray json = (JArray)new JsonSerializer().Deserialize(jsReader);

            foreach (JToken item in json)
            {
                int numCoords = item[1].Values().Count();
                double[] coords = new double[numCoords];
                for (int j = 0; j < numCoords; j++)
                {
                    coords[j] = (double)item[1][j];
                }
                Series series = new Series((string)item[0], coords, document);
                series.Write();
            }
        }
    }
}
