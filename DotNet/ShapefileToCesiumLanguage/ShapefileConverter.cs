using System.Drawing;
using Shapefile;

namespace ShapefileToCesiumLanguage
{
    public static class ShapefileConverter
    {
        /// <summary>
        /// Converts a Shapefile to CZML.
        /// </summary>
        /// <param name="shapefile">The ShapefileReader to convert.</param>
        /// <param name="document">The CzmlDocument to write to.</param>
        /// <param name="color">An optional color for the shapes in the shapefile.</param>
        public static void ShapefileToCesiumLanguage(ShapefileReader shapefile, CzmlDocument document, Color? color = null)
        {
            document.CesiumOutputStream.WriteStartSequence();
            Color c = color.HasValue ? color.Value : Color.Blue;
            Convert(shapefile, document, c);
            document.CesiumOutputStream.WriteEndSequence();
        }

        private static void Convert(ShapefileReader shapefile, CzmlDocument document, Color color)
        {
            foreach (Shape shape in shapefile) 
            {
                ShapeFactory.Create(shape, document, color).Write();
            }
        }
    }
}
