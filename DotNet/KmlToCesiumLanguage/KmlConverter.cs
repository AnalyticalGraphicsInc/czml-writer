using System;
using System.IO;
using System.Linq;
using System.Xml.Linq;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using ICSharpCode.SharpZipLib.Zip;

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
        /// <param name="prettyFormatting">If true, produces larger, more readable.  False by default.</param>
        public static void KmlToCesiumLanguage(TextReader inputReader,
                                               TextWriter outputWriter,
                                               bool prettyFormatting = false)
        {
            CzmlDocument document = new CzmlDocument(outputWriter);
            document.CesiumOutputStream.PrettyFormatting = prettyFormatting;
            document.CesiumOutputStream.WriteStartSequence();
            Convert(inputReader, document);
            document.CesiumOutputStream.WriteEndSequence();
        }

        /// <summary>
        /// Converts a KMZ file to CZML.
        /// </summary>
        /// <param name="inputStream">A stream for a KMZ file.</param>
        /// <param name="outputWriter">A writer that will receive the converted CZML document.</param>
        /// <param name="prettyFormatting">If true, produces larger, more readable.  False by default.</param>
        public static void KmzToCesiumLanguage(Stream inputStream,
                                               TextWriter outputWriter,
                                               bool prettyFormatting = false)
        {
            CzmlDocument document = new CzmlDocument(outputWriter);

            byte[] kmlData = null;
            using (ZipInputStream zipStream = new ZipInputStream(inputStream))
            {
                ZipEntry zipEntry;
                while ((zipEntry = zipStream.GetNextEntry()) != null)
                {
                    if (zipEntry.IsFile)
                    {
                        string fileName = zipEntry.Name;
                        string extension = Path.GetExtension(fileName);
                        if (".kml".Equals(extension, StringComparison.OrdinalIgnoreCase))
                        {
                            kmlData = new byte[zipEntry.Size];
                            zipStream.Read(kmlData, (int)zipEntry.Offset, (int)zipEntry.Size);
                            continue;
                        }

                        CesiumImageFormat? imageFormat = InferImageFormat(fileName);
                        if (imageFormat != null && !document.ImageResolver.ContainsUrl(fileName))
                        {
                            byte[] imageData = new byte[zipEntry.Size];
                            zipStream.Read(imageData, (int)zipEntry.Offset, (int)zipEntry.Size);
                            using (Stream imageStream = new MemoryStream(imageData))
                            {
                                string dataUrl = CesiumFormattingHelper.ImageToDataUri(imageStream, imageFormat.Value);
                                document.ImageResolver.AddUrl(fileName, dataUrl);
                            }
                        }
                    }
                }
            }

            document.CesiumOutputStream.PrettyFormatting = prettyFormatting;
            document.CesiumOutputStream.WriteStartSequence();

            using (Stream kmlStream = new MemoryStream(kmlData))
            using (StreamReader kmlStreamReader = new StreamReader(kmlStream))
            {
                Convert(kmlStreamReader, document);
            }

            document.CesiumOutputStream.WriteEndSequence();
        }

        private static CesiumImageFormat? InferImageFormat(string fileName)
        {
            string extension = Path.GetExtension(fileName);
            if (".jpg".Equals(extension, StringComparison.OrdinalIgnoreCase) || ".jpeg".Equals(extension, StringComparison.OrdinalIgnoreCase))
                return CesiumImageFormat.Jpeg;
            if (".png".Equals(extension, StringComparison.OrdinalIgnoreCase))
                return CesiumImageFormat.Png;
            if (".gif".Equals(extension, StringComparison.OrdinalIgnoreCase))
                return CesiumImageFormat.Gif;
            if (".bmp".Equals(extension, StringComparison.OrdinalIgnoreCase))
                return CesiumImageFormat.Bmp;
            return null;
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