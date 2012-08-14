using System;
using System.Collections.Generic;
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
        /// <param name="parentUri">The parent URI.</param>
        public static void KmlToCesiumLanguage(TextReader inputReader,
                                               TextWriter outputWriter,
                                               bool prettyFormatting = false,
                                               Uri parentUri = null)
        {
            CzmlDocument document = new CzmlDocument(parentUri);
            var features = CreateFeatureWrappers(inputReader, document);
            using (var outputstream = new CesiumOutputStream(outputWriter))
            {
                outputstream.PrettyFormatting = prettyFormatting;
                outputstream.WriteStartSequence();
                foreach(var feature in features)
                {
                    feature.WritePacket(outputstream);
                }
                outputstream.WriteEndSequence();
            }
        }

        /// <summary>
        /// Converts a KMZ file to CZML.
        /// </summary>
        /// <param name="inputStream">A stream for a KMZ file.</param>
        /// <param name="outputWriter">A writer that will receive the converted CZML document.</param>
        /// <param name="prettyFormatting">If true, produces larger, more readable.  False by default.</param>
        /// <param name="parentUri">The parent URI.</param>
        public static void KmzToCesiumLanguage(Stream inputStream,
                                               TextWriter outputWriter,
                                               bool prettyFormatting = false,
                                               Uri parentUri = null)
        {
            CzmlDocument document = new CzmlDocument(parentUri);
            var features = CreateFeatureWrappers(inputStream, document);
            using (var outputstream = new CesiumOutputStream(outputWriter))
            {
                outputstream.PrettyFormatting = prettyFormatting;
                outputstream.WriteStartSequence();
                foreach (var feature in features)
                {
                    feature.WritePacket(outputstream);
                }
                outputstream.WriteEndSequence();
            }
        }

        /// <summary>
        /// A helper function that creates wrappers around kml feature elements. Use this function if you want more control of the czml output.
        /// </summary>
        /// <param name="inputReader">The text reader to the kml document.</param>
        /// <param name="document">Stores needed data about the kml document.</param>
        /// <returns>List of Feature wrapper classes.</returns>
        public static IEnumerable<Feature> CreateFeatureWrappers(TextReader inputReader, CzmlDocument document)
        {
            XDocument kmlDocument = XDocument.Load(inputReader);
            document.Namespace = kmlDocument.Root.GetDefaultNamespace();
            return kmlDocument.Descendants()
                .Where(o => o.Name == document.Namespace + "Placemark" || o.Name == document.Namespace + "GroundOverlay" || o.Name == document.Namespace + "NetworkLink")
                .Select(o => FeatureFactory.Create(o, document));
        }


        /// <summary>
        /// A helper function that reads in a kmz file and creates wrappers around kml feature elements. Use this function if you want more control of the czml output.
        /// </summary>
        /// <param name="inputStream">The kmz input stream.</param>
        /// <param name="document">Stores needed data about the kml document.</param>
        /// <returns>
        /// List of Feature wrapper classes.
        /// </returns>
        public static IEnumerable<Feature> CreateFeatureWrappers(Stream inputStream, CzmlDocument document)
        {
            var features = new List<Feature>();
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
                            {
                            features.AddRange(CreateFeatureWrappers(streamReader, document));
                                }
                            }
                        }
                    }
            return features;
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
    }
}