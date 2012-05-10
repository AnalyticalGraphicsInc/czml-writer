using System;
using System.Drawing;
using System.IO;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// Used to convert an Image into a base64 string.
    /// </summary>
    public class ImageProcessing
    {
        /// <summary>
        /// Gets the image.
        /// </summary>
        /// <param name="stream">The stream.</param>
        /// <returns></returns>
        public static Image GetImage(Stream stream)
        {
            return Image.FromStream(stream);
        }

        /// <summary>
        /// Saves the specified image.
        /// </summary>
        /// <param name="image">The image.</param>
        /// <returns></returns>
        public static byte[] Save(Image image)
        {
            byte[] data = null;
            using (MemoryStream stream = new MemoryStream())
            {
                image.Save(stream, image.RawFormat);
                data = stream.ToArray();
            }
            return data;
        }

        /// <summary>
        /// Toes the base64 string.
        /// </summary>
        /// <param name="image">The image.</param>
        /// <returns></returns>
        public static string ToBase64String(Image image)
        {
            byte[] data = Save(image);
            return Convert.ToBase64String(data);
        }
    }
}
