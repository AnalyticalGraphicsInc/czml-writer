using System;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Xml.Linq;
using CesiumLanguageWriter;
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

            document.CesiumOutputStream.PrettyFormatting = prettyFormatting;

            document.CesiumOutputStream.WriteStartSequence();

            using (ZipFile zipFile = ZipFile.Read(inputStream))
            {
                foreach (ZipEntry entry in zipFile)
                {
                    string fileName = entry.FileName;
                    CesiumImageFormat? imageFormat = InferImageFormat(fileName);

                    if (imageFormat != null && !document.ImageResolver.ContainsUrl(fileName))
                    {
                        using (Stream stream = entry.OpenReader())
                        {
                            string dataUrl = CesiumFormattingHelper.ImageToDataUri(stream, imageFormat.Value);
                            document.ImageResolver.AddUrl(fileName, dataUrl);
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

            var namespaceDeclarations = kmlDocument.Root.Attributes()
                .Where(a => a.IsNamespaceDeclaration)
                .GroupBy(a => a.Name.Namespace == XNamespace.None ? String.Empty : a.Name.LocalName, a => XNamespace.Get(a.Value))
                .ToDictionary(g => g.Key, g => g.First());
            foreach (var ns in namespaceDeclarations)
                document.NamespaceDeclarations.Add(ns.Key, ns.Value);

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