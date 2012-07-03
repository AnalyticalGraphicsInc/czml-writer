using System.IO;
using System.Drawing;
using System.Linq;
using CesiumLanguageWriter;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace WebGLGlobeJsonToCesiumLanguage
{
    public static class WebGLGlobeJsonConverter
    {
        /// <summary>
        /// The main entry point to convert a WebGL-globe JSON file.
        /// </summary>
        /// <param name="jsonContents">The JSON contents.</param>
        /// <param name="color">An optional color to use to visually represent the data. The default color is blue.</param>
        /// <param name="heightScalar">An optional value used to scale the height component of each coordinate.</param>
        public static void WebGLGlobeJsonToCesiumLanguage(TextReader jsonContents,
                                                          CzmlDocument document,
                                                          double heightScalar = 1.0)
        {
            JsonTextReader jsReader = new JsonTextReader(jsonContents);
            JArray json = (JArray)new JsonSerializer().Deserialize(jsReader);

            document.CesiumOutputStream.WriteStartSequence();

            foreach (JToken item in json)
            {
                int numCoordinateComponents = item[1].Values().Count();
                if (numCoordinateComponents % 3 != 0)
                {
                    throw new System.ArgumentException("Coordinates listed in jsonContents must have 3 components.", "jsonContents");
                }

                Cartographic[] coords = new Cartographic[numCoordinateComponents / 3];
                for (int i = 0, j = 0; i < numCoordinateComponents; i += 3, j++)
                {
                    coords[j] = new Cartographic((double)item[1][i + 1], (double)item[1][i], (double)item[1][i + 2]);
                }

                Series series = new Series((string)item[0], coords, document, heightScalar);
                series.Write();
            }

            document.CesiumOutputStream.WriteEndSequence();
        }
    }
}