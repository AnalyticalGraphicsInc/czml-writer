using System;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Xml.Linq;
using CesiumLanguageWriter.Advanced;
using Ionic.Zip;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// The entry point to convert a KML file.
    /// </summary>
    public static class KmlConverter
    {
        /// <summary>
        /// Converts a KML document to CZML.
        /// </summary>
        /// <param name="inputReader">A reader for a KML document.</param>
        /// <param name="outputWriter">A writer that will receive the converted CZML document.</param>
        public static void KmlToCesiumLanguage(TextReader inputReader, TextWriter outputWriter)
        {
            CzmlDocument document = new CzmlDocument(outputWriter);

            document.CesiumOutputStream.WriteStartSequence();
            Convert(inputReader, document);
            document.CesiumOutputStream.WriteEndSequence();
        }

        /// <summary>
        /// Converts a KMZ file to CZML.
        /// </summary>
        /// <param name="inputStream">A stream for a KMZ file.</param>
        /// <param name="outputWriter">A writer that will receive the converted CZML document.</param>
        public static void KmzToCesiumLanguage(Stream inputStream, TextWriter outputWriter)
        {
            CzmlDocument document = new CzmlDocument(outputWriter);

            document.CesiumOutputStream.WriteStartSequence();

            using (ZipFile zipFile = ZipFile.Read(inputStream))
            {
                foreach (ZipEntry entry in zipFile)
                {
                    string fileName = entry.FileName;
                    string extension = Path.GetExtension(fileName);

                    if (".jpg".Equals(extension, StringComparison.OrdinalIgnoreCase) ||
                        ".png".Equals(extension, StringComparison.OrdinalIgnoreCase) ||
                        ".gif".Equals(extension, StringComparison.OrdinalIgnoreCase))
                    {
                        if (!document.ImageMap.ContainsKey(fileName))
                        {
                            using (Stream stream = entry.OpenReader())
                            using (Image image = Image.FromStream(stream))
                            {
                                string dataUrl = CesiumFormattingHelper.ImageToDataUrl(image);
                                document.ImageMap.Add(fileName, dataUrl);
                            }
                        }
                    }
                }

                foreach (ZipEntry entry in zipFile)
                {
                    string extension = Path.GetExtension(entry.FileName);
                    if (".kml".Equals(extension, StringComparison.OrdinalIgnoreCase))
                    {
                        using (Stream stream = entry.OpenReader())
                        using (StreamReader streamReader = new StreamReader(stream))
                            Convert(streamReader, document);
                    }
                }
            }

            document.CesiumOutputStream.WriteEndSequence();
        }

        private static void Convert(TextReader inputReader, CzmlDocument document)
        {
            XDocument kmlDocument = XDocument.Load(inputReader);
            document.Namespace = kmlDocument.Root.GetDefaultNamespace();
            var features = kmlDocument.Descendants()
                .Where(o => o.Name == document.Namespace + "Placemark" || o.Name == document.Namespace + "GroundOverlay")
                .Select(o => FeatureFactory.Create(o, document));
            foreach (var feature in features)
            {
                feature.WritePacket();
            }
        }
    }
}