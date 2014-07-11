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
        /// The name of the <code>repeat</code> property.
        /// </summary>
        public const string RepeatPropertyName = "repeat";

        private readonly Lazy<UriCesiumWriter> m_image = new Lazy<UriCesiumWriter>(() => new UriCesiumWriter(ImagePropertyName), false);

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
        public UriCesiumWriter ImageWriter
        {
            get { return m_image.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>image</code> property.  The <code>image</code> property defines the image to display on the surface.
        /// </summary>
        public UriCesiumWriter OpenImageProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ImageWriter);
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="resource">A resource object describing external data.</param>
        public void WriteImageProperty(CesiumResource resource)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteUri(resource);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="url">The URL of the data.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the URL in the document. For even more control, use the overload that takes a ICesiumUrlResolver.</param>
        public void WriteImageProperty(string url, CesiumResourceBehavior resourceBehavior)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteUri(url, resourceBehavior);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="url">The URL of the data.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.</param>
        /// <param name="resolver">An ICesiumUrlResolver used to build the final URL that will be embedded in the document.</param>
        public void WriteImageProperty(string url, ICesiumUrlResolver resolver)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteUri(url, resolver);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="image">The image.  A data URI will be created for this image, using PNG encoding.</param>
        public void WriteImageProperty(Image image)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteUri(image);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="image">The image.  A data URI will be created for this image.</param>
        /// <param name="imageFormat">The image format to use to encode the image in the data URI.</param>
        public void WriteImageProperty(Image image, CesiumImageFormat imageFormat)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteUri(image, imageFormat);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteImagePropertyReference(Reference value)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteImagePropertyReference(string value)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteImagePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the image to display on the surface.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteImagePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Writes the <code>repeat</code> property.  The <code>repeat</code> property specifies the numger of times the image repeats along each axis.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRepeat(Rectangular value)
        {
            const string PropertyName = RepeatPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian2(Output, value);
        }

        /// <summary>
        /// Writes the <code>repeat</code> property.  The <code>repeat</code> property specifies the numger of times the image repeats along each axis.
        /// </summary>
        /// <param name="x">The X component.</param>
        /// <param name="y">The Y component.</param>
        public void WriteRepeat(double x, double y)
        {
            WriteRepeat(new Rectangular(x, y));
        }

        /// <summary>
        /// Writes the <code>repeat</code> property.  The <code>repeat</code> property specifies the numger of times the image repeats along each axis.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteRepeat(IList<JulianDate> dates, IList<Rectangular> values)
        {
            WriteRepeat(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>repeat</code> property.  The <code>repeat</code> property specifies the numger of times the image repeats along each axis.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteRepeat(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
        {
            const string PropertyName = RepeatPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian2(Output, PropertyName, dates, values, startIndex, length);
        }

    }
}
