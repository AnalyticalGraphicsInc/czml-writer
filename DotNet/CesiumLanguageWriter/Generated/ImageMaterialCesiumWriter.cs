// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>ImageMaterial</code> to a <see cref="CesiumOutputStream" />.  A <code>ImageMaterial</code> fills the surface with an image.
    /// </summary>
    public class ImageMaterialCesiumWriter : CesiumPropertyWriter<ImageMaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>image</code> property.
        /// </summary>
        public const string ImagePropertyName = "image";

        /// <summary>
        /// The name of the <code>horizontalRepeat</code> property.
        /// </summary>
        public const string HorizontalRepeatPropertyName = "horizontalRepeat";

        /// <summary>
        /// The name of the <code>verticalRepeat</code> property.
        /// </summary>
        public const string VerticalRepeatPropertyName = "verticalRepeat";

        private readonly Lazy<ImageCesiumWriter> m_image = new Lazy<ImageCesiumWriter>(() => new ImageCesiumWriter(ImagePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_horizontalRepeat = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(HorizontalRepeatPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_verticalRepeat = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(VerticalRepeatPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ImageMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected ImageMaterialCesiumWriter(ImageMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override ImageMaterialCesiumWriter Clone()
        {
            return new ImageMaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>image</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>image</code> property defines the image to display on the surface.
        /// </summary>
        public ImageCesiumWriter ImageWriter
        {
            get { return m_image.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>image</code> property.  The <code>image</code> property defines the image to display on the surface.
        /// </summary>
        public ImageCesiumWriter OpenImageProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ImageWriter);
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="resource">A resource object describing the image.</param>
        public void WriteImageProperty(CesiumResource resource)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteImage(resource);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="url">The URL of the image.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the image in the document. For even more control, use the overload that takes a ICesiumUrlResolver.</param>
        public void WriteImageProperty(string url, CesiumResourceBehavior resourceBehavior)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteImage(url, resourceBehavior);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="url">The URL of the image.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.</param>
        /// <param name="resolver">An ICesiumUrlResolver used to build the final URL that will be embedded in the document.</param>
        public void WriteImageProperty(string url, ICesiumUrlResolver resolver)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteImage(url, resolver);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="image">The image.  A data URI will be created for this image, using PNG encoding.</param>
        public void WriteImageProperty(Image image)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteImage(image);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="image">The image.  A data URI will be created for this image.</param>
        /// <param name="imageFormat">The image format to use to encode the image in the data URI.</param>
        public void WriteImageProperty(Image image, CesiumImageFormat imageFormat)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteImage(image, imageFormat);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>horizontalRepeat</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>horizontalRepeat</code> property defines the number of times the image is repeated horizontally.
        /// </summary>
        public DoubleCesiumWriter HorizontalRepeatWriter
        {
            get { return m_horizontalRepeat.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>horizontalRepeat</code> property.  The <code>horizontalRepeat</code> property defines the number of times the image is repeated horizontally.
        /// </summary>
        public DoubleCesiumWriter OpenHorizontalRepeatProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HorizontalRepeatWriter);
        }

        /// <summary>
        /// Writes a value for the <code>horizontalRepeat</code> property as a <code>number</code> value.  The <code>horizontalRepeat</code> property specifies the number of times the image is repeated horizontally.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteHorizontalRepeatProperty(double value)
        {
            using (var writer = OpenHorizontalRepeatProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>horizontalRepeat</code> property as a <code>number</code> value.  The <code>horizontalRepeat</code> property specifies the number of times the image is repeated horizontally.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteHorizontalRepeatProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenHorizontalRepeatProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>verticalRepeat</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>verticalRepeat</code> property defines the number of times the image is repeated vertically.
        /// </summary>
        public DoubleCesiumWriter VerticalRepeatWriter
        {
            get { return m_verticalRepeat.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>verticalRepeat</code> property.  The <code>verticalRepeat</code> property defines the number of times the image is repeated vertically.
        /// </summary>
        public DoubleCesiumWriter OpenVerticalRepeatProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(VerticalRepeatWriter);
        }

        /// <summary>
        /// Writes a value for the <code>verticalRepeat</code> property as a <code>number</code> value.  The <code>verticalRepeat</code> property specifies the number of times the image is repeated vertically.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteVerticalRepeatProperty(double value)
        {
            using (var writer = OpenVerticalRepeatProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>verticalRepeat</code> property as a <code>number</code> value.  The <code>verticalRepeat</code> property specifies the number of times the image is repeated vertically.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteVerticalRepeatProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenVerticalRepeatProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

    }
}
