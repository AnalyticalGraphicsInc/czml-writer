using System.Collections.Generic;
using System.Linq;
using System.Xml.Linq;
using System.Xml;
using System.Drawing;
using CesiumLanguageWriter.Advanced;
using System.IO;
using System.IO.Compression;
using Ionic.Zip;
using System;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// The entry point to convert a kml file.
    /// </summary>
    public static class KmlConverter
    {
        /// <summary>
        /// Converts an kml document to CZML.
        /// </summary>
        /// <param name="kmlContents">The KML contents.</param>
        /// <param name="document">The czml document.</param>
        public static void KmlToCesiumLanguage(byte[] kmlContents, CzmlDocument document)
        {
            document.CesiumOutputStream.WriteStartSequence();
            Convert(kmlContents, document);
            document.CesiumOutputStream.WriteEndSequence();
        }

        /// <summary>
        /// Converts a kmz file to CZML.
        /// </summary>
        /// <param name="kmzContents">The content of the kmz file.</param>
        /// <param name="document">The czml document.</param>
        public static void KmzToCesiumLanguage(byte[] kmzContents, CzmlDocument document)
        {
            List<byte[]> documents = new List<byte[]>();
            using (ZipFile zip = ZipFile.Read(new MemoryStream(kmzContents)))
            {
                foreach(ZipEntry entry in zip)
                {
                    MemoryStream memoryStream = new MemoryStream();
                    entry.Extract(memoryStream);
                    memoryStream.Position = 0;
                    if (entry.FileName.Contains(".kml"))
                    {
                        long size = memoryStream.Length;
                        byte[] data = new byte[size];
                        memoryStream.Read(data, 0, data.Length);
                        documents.Add(data);
                    }

                    if (entry.FileName.Contains(".jpg") || entry.FileName.Contains(".png") || entry.FileName.Contains(".gif"))
                    {
                        if (!document.ImageMap.ContainsKey(entry.FileName))
                        {
                            document.ImageMap.Add(entry.FileName, CesiumFormattingHelper.ImageToDataUrl(Image.FromStream(memoryStream)));
                        }
                    }
                }
            }
            document.CesiumOutputStream.WriteStartSequence();
            foreach (byte[] kmlContents in documents)
            {
                Convert(kmlContents, document);
            }
            document.CesiumOutputStream.WriteEndSequence();
        }

        private static void Convert(byte[] kmlContents, CzmlDocument document)
        {
            using (MemoryStream stream = new MemoryStream(kmlContents))
            {
                XDocument kmlDocument = XDocument.Load(stream);
                document.Namespace = kmlDocument.Root.GetDefaultNamespace();
                var placemarks = kmlDocument.Descendants(document.Namespace + "Placemark").Select(o => new Placemark(o, document));
                foreach (var placemark in placemarks)
                {
                    placemark.Write();
                }
            }
        }
    }
}
