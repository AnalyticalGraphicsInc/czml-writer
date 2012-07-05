using System;
using System.IO;
using System.Linq;
using CesiumLanguageWriter;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace WebGLGlobeJsonToCesiumLanguage
{
    public static class WebGLGlobeJsonConverter
    {
        /// <summary>
        /// Converts a WebGL Globe JSON document to CZML.
        /// </summary>
        /// <param name="inputReader">A reader for a WebGL Globe JSON document.</param>
        /// <param name="outputWriter">A writer that will receive the converted CZML document.</param>
        /// <param name="prettyFormatting">If true, produces larger, more readable.  False by default.</param>
        /// <param name="heightScalar">An optional value used to scale the height component of each coordinate.</param>
        public static void WebGLGlobeJsonToCesiumLanguage(TextReader inputReader,
                                                          TextWriter outputWriter,
                                                          bool prettyFormatting = false,
                                                          double heightScalar = 1.0)
        {
            CzmlDocument document = new CzmlDocument(outputWriter);

            document.CesiumOutputStream.PrettyFormatting = prettyFormatting;

            document.CesiumOutputStream.WriteStartSequence();

            JsonSerializer serializer = new JsonSerializer();
            using (JsonReader jsonReader = new JsonTextReader(inputReader))
            {
                JArray jsonArray = (JArray)serializer.Deserialize(jsonReader);

                foreach (JToken item in jsonArray)
                {
                    int numCoordinateComponents = item[1].Values().Count();
                    if (numCoordinateComponents % 3 != 0)
                    {
                        throw new ArgumentException("Coordinates listed in jsonContents must have 3 components.", "inputReader");
                    }

                    Cartographic[] coords = new Cartographic[numCoordinateComponents / 3];
                    for (int i = 0, j = 0; i < numCoordinateComponents; i += 3, j++)
                    {
                        coords[j] = new Cartographic((double)item[1][i + 1], (double)item[1][i], (double)item[1][i + 2]);
                    }

                    Series series = new Series((string)item[0], coords, document, heightScalar);
                    series.Write();
                }
            }

            document.CesiumOutputStream.WriteEndSequence();
        }
    }
}