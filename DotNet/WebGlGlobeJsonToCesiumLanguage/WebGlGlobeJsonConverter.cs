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
        public static void WebGlGlobeJsonToCesiumLanguage(TextReader jsonContents, CzmlDocument document)
        {
            JsonTextReader jsReader = new JsonTextReader(jsonContents);
            JArray json = (JArray)new JsonSerializer().Deserialize(jsReader);

            foreach (JToken item in json)
            {                
                if (item[1].Values().Count() % 3 != 0)
                {
                    throw new System.ArgumentException("coordinates data must contain a multiple of 3 element", "jsonContents");
                }

                int numCoords = item[1].Values().Count() / 3;
                Cartographic[] coords = new Cartographic[numCoords];
                for (int i = 0, j = 0; i < numCoords; i += 3, j++)
                {
                    coords[j] = new Cartographic((double)item[1][i], (double)item[1][i + 1], (double)item[1][i + 2]);
                }

                Series series = new Series((string)item[0], coords, document);
                series.Write();
            }
        }
    }
}
