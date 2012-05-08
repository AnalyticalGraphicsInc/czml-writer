using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;
using System.IO;

namespace KmlToCesiumLanguage
{
    public class ImageProcessing
    {
        public static Image GetImage(Stream stream)
        {
            return Image.FromStream(stream);
        }

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

        public static string ToBase64String(Image image)
        {
            byte[] data = Save(image);
            return Convert.ToBase64String(data);
        }
    }
}
