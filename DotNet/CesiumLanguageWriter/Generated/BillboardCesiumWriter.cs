// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Billboard</code> to a <see cref="CesiumOutputStream" />.  A <code>Billboard</code> specifies a billboard, or viewport-aligned image. The billboard is positioned in the scene by the `position` property. A billboard is sometimes called a marker.
    /// </summary>
    public class BillboardCesiumWriter : CesiumPropertyWriter<BillboardCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>color</code> property.
        /// </summary>
        public const string ColorPropertyName = "color";

        /// <summary>
        /// The name of the <code>eyeOffset</code> property.
        /// </summary>
        public const string EyeOffsetPropertyName = "eyeOffset";

        /// <summary>
        /// The name of the <code>horizontalOrigin</code> property.
        /// </summary>
        public const string HorizontalOriginPropertyName = "horizontalOrigin";

        /// <summary>
        /// The name of the <code>image</code> property.
        /// </summary>
        public const string ImagePropertyName = "image";

        /// <summary>
        /// The name of the <code>pixelOffset</code> property.
        /// </summary>
        public const string PixelOffsetPropertyName = "pixelOffset";

        /// <summary>
        /// The name of the <code>scale</code> property.
        /// </summary>
        public const string ScalePropertyName = "scale";

        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>verticalOrigin</code> property.
        /// </summary>
        public const string VerticalOriginPropertyName = "verticalOrigin";

        private readonly Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(ColorPropertyName), false);
        private readonly Lazy<EyeOffsetCesiumWriter> m_eyeOffset = new Lazy<EyeOffsetCesiumWriter>(() => new EyeOffsetCesiumWriter(EyeOffsetPropertyName), false);
        private readonly Lazy<HorizontalOriginCesiumWriter> m_horizontalOrigin = new Lazy<HorizontalOriginCesiumWriter>(() => new HorizontalOriginCesiumWriter(HorizontalOriginPropertyName), false);
        private readonly Lazy<ImageCesiumWriter> m_image = new Lazy<ImageCesiumWriter>(() => new ImageCesiumWriter(ImagePropertyName), false);
        private readonly Lazy<PixelOffsetCesiumWriter> m_pixelOffset = new Lazy<PixelOffsetCesiumWriter>(() => new PixelOffsetCesiumWriter(PixelOffsetPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_scale = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ScalePropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<VerticalOriginCesiumWriter> m_verticalOrigin = new Lazy<VerticalOriginCesiumWriter>(() => new VerticalOriginCesiumWriter(VerticalOriginPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public BillboardCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected BillboardCesiumWriter(BillboardCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override BillboardCesiumWriter Clone()
        {
            return new BillboardCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>color</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>color</code> property defines the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
        /// </summary>
        public ColorCesiumWriter ColorWriter
        {
            get { return m_color.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>color</code> property.  The <code>color</code> property defines the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
        /// </summary>
        public ColorCesiumWriter OpenColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteColorProperty(Color color)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>eyeOffset</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>eyeOffset</code> property defines the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        public EyeOffsetCesiumWriter EyeOffsetWriter
        {
            get { return m_eyeOffset.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>eyeOffset</code> property.  The <code>eyeOffset</code> property defines the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        public EyeOffsetCesiumWriter OpenEyeOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EyeOffsetWriter);
        }

        /// <summary>
        /// Writes a value for the <code>eyeOffset</code> property as a <code>cartesian</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteEyeOffsetProperty(Cartesian value)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteCartesian(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>eyeOffset</code> property as a <code>cartesian</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteEyeOffsetProperty(IList<JulianDate> dates, IList<Cartesian> values)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteCartesian(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>eyeOffset</code> property as a <code>cartesian</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteEyeOffsetProperty(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteCartesian(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>horizontalOrigin</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>horizontalOrigin</code> property defines the horizontal origin of the billboard.  It controls whether the billboard image is left-, center-, or right-aligned with the `position`.
        /// </summary>
        public HorizontalOriginCesiumWriter HorizontalOriginWriter
        {
            get { return m_horizontalOrigin.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>horizontalOrigin</code> property.  The <code>horizontalOrigin</code> property defines the horizontal origin of the billboard.  It controls whether the billboard image is left-, center-, or right-aligned with the `position`.
        /// </summary>
        public HorizontalOriginCesiumWriter OpenHorizontalOriginProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HorizontalOriginWriter);
        }

        /// <summary>
        /// Writes a value for the <code>horizontalOrigin</code> property as a <code>horizontalOrigin</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the billboard.  It controls whether the billboard image is left-, center-, or right-aligned with the `position`.
        /// </summary>
        /// <param name="value">The horizontal origin.</param>
        public void WriteHorizontalOriginProperty(CesiumHorizontalOrigin value)
        {
            using (var writer = OpenHorizontalOriginProperty())
            {
                writer.WriteHorizontalOrigin(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>image</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>image</code> property defines the image displayed on the billboard, expressed as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        public ImageCesiumWriter ImageWriter
        {
            get { return m_image.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>image</code> property.  The <code>image</code> property defines the image displayed on the billboard, expressed as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        public ImageCesiumWriter OpenImageProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ImageWriter);
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image displayed on the billboard, expressed as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="url">The URL of the image.  If this URL is not a data URI, it will be downloaded and embedded in the document, using a thread-local cache to avoid downloading the same image multiple times.  For more control over how the image is referenced in the document, use the overload that takes a ICesiumUrlResolver.</param>
        public void WriteImageProperty(string url)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteImage(url);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image displayed on the billboard, expressed as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
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
        /// Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image displayed on the billboard, expressed as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
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
        /// Writes a value for the <code>image</code> property as a <code>image</code> value.  The <code>image</code> property specifies the image displayed on the billboard, expressed as a URL.  For broadest client compatibility, the URL should be accessible via Cross-Origin Resource Sharing (CORS).  The URL may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
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
        /// Gets the writer for the <code>pixelOffset</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>pixelOffset</code> property defines the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
        /// </summary>
        public PixelOffsetCesiumWriter PixelOffsetWriter
        {
            get { return m_pixelOffset.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>pixelOffset</code> property.  The <code>pixelOffset</code> property defines the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
        /// </summary>
        public PixelOffsetCesiumWriter OpenPixelOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PixelOffsetWriter);
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WritePixelOffsetProperty(Rectangular value)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteCartesian2(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
        /// </summary>
        /// <param name="x">The X component.</param>
        /// <param name="y">The Y component.</param>
        public void WritePixelOffsetProperty(double x, double y)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteCartesian2(x, y);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePixelOffsetProperty(IList<JulianDate> dates, IList<Rectangular> values)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteCartesian2(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffset</code> property as a <code>cartesian2</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WritePixelOffsetProperty(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteCartesian2(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>scale</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>scale</code> property defines the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.
        /// </summary>
        public DoubleCesiumWriter ScaleWriter
        {
            get { return m_scale.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>scale</code> property.  The <code>scale</code> property defines the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.
        /// </summary>
        public DoubleCesiumWriter OpenScaleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ScaleWriter);
        }

        /// <summary>
        /// Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteScaleProperty(double value)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteScaleProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the billboard is shown.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the billboard is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the billboard is shown.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowProperty(bool value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>verticalOrigin</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>verticalOrigin</code> property defines the vertical origin of the billboard.  It controls whether the billboard image is bottom-, center-, or top-aligned with the `position`.
        /// </summary>
        public VerticalOriginCesiumWriter VerticalOriginWriter
        {
            get { return m_verticalOrigin.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>verticalOrigin</code> property.  The <code>verticalOrigin</code> property defines the vertical origin of the billboard.  It controls whether the billboard image is bottom-, center-, or top-aligned with the `position`.
        /// </summary>
        public VerticalOriginCesiumWriter OpenVerticalOriginProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(VerticalOriginWriter);
        }

        /// <summary>
        /// Writes a value for the <code>verticalOrigin</code> property as a <code>verticalOrigin</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the billboard.  It controls whether the billboard image is bottom-, center-, or top-aligned with the `position`.
        /// </summary>
        /// <param name="value">The vertical origin.</param>
        public void WriteVerticalOriginProperty(CesiumVerticalOrigin value)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteVerticalOrigin(value);
            }
        }

    }
}
