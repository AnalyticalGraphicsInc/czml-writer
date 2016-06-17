// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Billboard</code> to a <see cref="CesiumOutputStream" />.  A <code>Billboard</code> is a billboard, or viewport-aligned image.  The billboard is positioned in the scene by the `position` property.  A billboard is sometimes called a marker.
    /// </summary>
    public class BillboardCesiumWriter : CesiumPropertyWriter<BillboardCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>image</code> property.
        /// </summary>
        public const string ImagePropertyName = "image";

        /// <summary>
        /// The name of the <code>scale</code> property.
        /// </summary>
        public const string ScalePropertyName = "scale";

        /// <summary>
        /// The name of the <code>pixelOffset</code> property.
        /// </summary>
        public const string PixelOffsetPropertyName = "pixelOffset";

        /// <summary>
        /// The name of the <code>eyeOffset</code> property.
        /// </summary>
        public const string EyeOffsetPropertyName = "eyeOffset";

        /// <summary>
        /// The name of the <code>horizontalOrigin</code> property.
        /// </summary>
        public const string HorizontalOriginPropertyName = "horizontalOrigin";

        /// <summary>
        /// The name of the <code>verticalOrigin</code> property.
        /// </summary>
        public const string VerticalOriginPropertyName = "verticalOrigin";

        /// <summary>
        /// The name of the <code>color</code> property.
        /// </summary>
        public const string ColorPropertyName = "color";

        /// <summary>
        /// The name of the <code>rotation</code> property.
        /// </summary>
        public const string RotationPropertyName = "rotation";

        /// <summary>
        /// The name of the <code>alignedAxis</code> property.
        /// </summary>
        public const string AlignedAxisPropertyName = "alignedAxis";

        /// <summary>
        /// The name of the <code>sizeInMeters</code> property.
        /// </summary>
        public const string SizeInMetersPropertyName = "sizeInMeters";

        /// <summary>
        /// The name of the <code>width</code> property.
        /// </summary>
        public const string WidthPropertyName = "width";

        /// <summary>
        /// The name of the <code>height</code> property.
        /// </summary>
        public const string HeightPropertyName = "height";

        /// <summary>
        /// The name of the <code>scaleByDistance</code> property.
        /// </summary>
        public const string ScaleByDistancePropertyName = "scaleByDistance";

        /// <summary>
        /// The name of the <code>translucencyByDistance</code> property.
        /// </summary>
        public const string TranslucencyByDistancePropertyName = "translucencyByDistance";

        /// <summary>
        /// The name of the <code>pixelOffsetScaleByDistance</code> property.
        /// </summary>
        public const string PixelOffsetScaleByDistancePropertyName = "pixelOffsetScaleByDistance";

        /// <summary>
        /// The name of the <code>imageSubRegion</code> property.
        /// </summary>
        public const string ImageSubRegionPropertyName = "imageSubRegion";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<UriCesiumWriter> m_image = new Lazy<UriCesiumWriter>(() => new UriCesiumWriter(ImagePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_scale = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ScalePropertyName), false);
        private readonly Lazy<PixelOffsetCesiumWriter> m_pixelOffset = new Lazy<PixelOffsetCesiumWriter>(() => new PixelOffsetCesiumWriter(PixelOffsetPropertyName), false);
        private readonly Lazy<EyeOffsetCesiumWriter> m_eyeOffset = new Lazy<EyeOffsetCesiumWriter>(() => new EyeOffsetCesiumWriter(EyeOffsetPropertyName), false);
        private readonly Lazy<HorizontalOriginCesiumWriter> m_horizontalOrigin = new Lazy<HorizontalOriginCesiumWriter>(() => new HorizontalOriginCesiumWriter(HorizontalOriginPropertyName), false);
        private readonly Lazy<VerticalOriginCesiumWriter> m_verticalOrigin = new Lazy<VerticalOriginCesiumWriter>(() => new VerticalOriginCesiumWriter(VerticalOriginPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(ColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_rotation = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RotationPropertyName), false);
        private readonly Lazy<AlignedAxisCesiumWriter> m_alignedAxis = new Lazy<AlignedAxisCesiumWriter>(() => new AlignedAxisCesiumWriter(AlignedAxisPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_sizeInMeters = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(SizeInMetersPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_width = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(WidthPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_height = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(HeightPropertyName), false);
        private readonly Lazy<NearFarScalarCesiumWriter> m_scaleByDistance = new Lazy<NearFarScalarCesiumWriter>(() => new NearFarScalarCesiumWriter(ScaleByDistancePropertyName), false);
        private readonly Lazy<NearFarScalarCesiumWriter> m_translucencyByDistance = new Lazy<NearFarScalarCesiumWriter>(() => new NearFarScalarCesiumWriter(TranslucencyByDistancePropertyName), false);
        private readonly Lazy<NearFarScalarCesiumWriter> m_pixelOffsetScaleByDistance = new Lazy<NearFarScalarCesiumWriter>(() => new NearFarScalarCesiumWriter(PixelOffsetScaleByDistancePropertyName), false);
        private readonly Lazy<BoundingRectangleCesiumWriter> m_imageSubRegion = new Lazy<BoundingRectangleCesiumWriter>(() => new BoundingRectangleCesiumWriter(ImageSubRegionPropertyName), false);

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
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the billboard is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the billboard is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the billboard is shown.  If not specified, the default value is <see langword="true"/>.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the billboard is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteShowPropertyReference(Reference value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the billboard is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteShowPropertyReference(string value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the billboard is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteShowPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the billboard is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteShowPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>image</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>image</code> property defines the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        public UriCesiumWriter ImageWriter
        {
            get { return m_image.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>image</code> property.  The <code>image</code> property defines the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        public UriCesiumWriter OpenImageProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ImageWriter);
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
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
        /// Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="uri">The URI of the data.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.</param>
        public void WriteImageProperty(Uri uri, CesiumResourceBehavior resourceBehavior)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteUri(uri, resourceBehavior);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="uri">The URI of the data.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.</param>
        public void WriteImageProperty(string uri, CesiumResourceBehavior resourceBehavior)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteUri(uri, resourceBehavior);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="uri">The URI of the data.  The provided ICesiumUriResolver will be used to build the final URI embedded in the document.</param>
        /// <param name="resolver">An ICesiumUriResolver used to build the final URI that will be embedded in the document.</param>
        public void WriteImageProperty(Uri uri, ICesiumUriResolver resolver)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteUri(uri, resolver);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="uri">The URI of the data.  The provided ICesiumUriResolver will be used to build the final URI embedded in the document.</param>
        /// <param name="resolver">An ICesiumUriResolver used to build the final URI that will be embedded in the document.</param>
        public void WriteImageProperty(string uri, ICesiumUriResolver resolver)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteUri(uri, resolver);
            }
        }

        /// <summary>
        /// Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
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
        /// Writes a value for the <code>image</code> property as a <code>uri</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
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
        /// Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
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
        /// Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
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
        /// Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
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
        /// Writes a value for the <code>image</code> property as a <code>reference</code> value.  The <code>image</code> property specifies the URI of the image displayed on the billboard.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
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
        /// Gets the writer for the <code>scale</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>scale</code> property defines the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
        /// </summary>
        public DoubleCesiumWriter ScaleWriter
        {
            get { return m_scale.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>scale</code> property.  The <code>scale</code> property defines the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
        /// </summary>
        public DoubleCesiumWriter OpenScaleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ScaleWriter);
        }

        /// <summary>
        /// Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
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
        /// Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
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
        /// Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteScalePropertyReference(Reference value)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteScalePropertyReference(string value)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteScalePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the billboard.  The scale is multiplied with the pixel size of the billboard's `image`.  For example, if the scale is 2.0, the billboard will be rendered with twice the number of pixels, in each direction, of the `image`.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteScalePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteReference(identifier, propertyNames);
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
        /// <param name="dates">The dates at which the value is specified.</param>
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
        /// <param name="dates">The dates at which the value is specified.</param>
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
        /// Writes a value for the <code>pixelOffset</code> property as a <code>reference</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WritePixelOffsetPropertyReference(Reference value)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffset</code> property as a <code>reference</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WritePixelOffsetPropertyReference(string value)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffset</code> property as a <code>reference</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WritePixelOffsetPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffset</code> property as a <code>reference</code> value.  The <code>pixelOffset</code> property specifies the offset, in viewport pixels, of the billboard origin from the `position`.  A pixel offset is the number of pixels up and to the right to place the billboard, relative to the `position`.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WritePixelOffsetPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteReference(identifier, propertyNames);
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
        /// <param name="dates">The dates at which the value is specified.</param>
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
        /// <param name="dates">The dates at which the value is specified.</param>
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
        /// Writes a value for the <code>eyeOffset</code> property as a <code>reference</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteEyeOffsetPropertyReference(Reference value)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>eyeOffset</code> property as a <code>reference</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteEyeOffsetPropertyReference(string value)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>eyeOffset</code> property as a <code>reference</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteEyeOffsetPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>eyeOffset</code> property as a <code>reference</code> value.  The <code>eyeOffset</code> property specifies the eye offset of the billboard, which is the offset in eye coordinates at which to place the billboard relative to the `position` property.  Eye coordinates are a left-handed coordinate system where the X-axis points toward the viewer's right, the Y-axis points up, and the Z-axis points into the screen.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteEyeOffsetPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>horizontalOrigin</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>horizontalOrigin</code> property defines the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
        /// </summary>
        public HorizontalOriginCesiumWriter HorizontalOriginWriter
        {
            get { return m_horizontalOrigin.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>horizontalOrigin</code> property.  The <code>horizontalOrigin</code> property defines the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
        /// </summary>
        public HorizontalOriginCesiumWriter OpenHorizontalOriginProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HorizontalOriginWriter);
        }

        /// <summary>
        /// Writes a value for the <code>horizontalOrigin</code> property as a <code>horizontalOrigin</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
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
        /// Writes a value for the <code>horizontalOrigin</code> property as a <code>reference</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteHorizontalOriginPropertyReference(Reference value)
        {
            using (var writer = OpenHorizontalOriginProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>horizontalOrigin</code> property as a <code>reference</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteHorizontalOriginPropertyReference(string value)
        {
            using (var writer = OpenHorizontalOriginProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>horizontalOrigin</code> property as a <code>reference</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteHorizontalOriginPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenHorizontalOriginProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>horizontalOrigin</code> property as a <code>reference</code> value.  The <code>horizontalOrigin</code> property specifies the horizontal origin of the billboard, which determines whether the billboard image is left-, center-, or right-aligned with the `position`.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteHorizontalOriginPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenHorizontalOriginProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>verticalOrigin</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>verticalOrigin</code> property defines the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
        /// </summary>
        public VerticalOriginCesiumWriter VerticalOriginWriter
        {
            get { return m_verticalOrigin.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>verticalOrigin</code> property.  The <code>verticalOrigin</code> property defines the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
        /// </summary>
        public VerticalOriginCesiumWriter OpenVerticalOriginProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(VerticalOriginWriter);
        }

        /// <summary>
        /// Writes a value for the <code>verticalOrigin</code> property as a <code>verticalOrigin</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="value">The vertical origin.</param>
        public void WriteVerticalOriginProperty(CesiumVerticalOrigin value)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteVerticalOrigin(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>verticalOrigin</code> property as a <code>reference</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteVerticalOriginPropertyReference(Reference value)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>verticalOrigin</code> property as a <code>reference</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteVerticalOriginPropertyReference(string value)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>verticalOrigin</code> property as a <code>reference</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteVerticalOriginPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>verticalOrigin</code> property as a <code>reference</code> value.  The <code>verticalOrigin</code> property specifies the vertical origin of the billboard, which determines whether the billboard image is bottom-, center-, or top-aligned with the `position`.  If not specified, the default value is CENTER.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteVerticalOriginPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
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
        /// Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteColorPropertyReference(Reference value)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteColorPropertyReference(string value)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteColorPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the billboard.  This color value is multiplied with the values of the billboard's "image" to produce the final color.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteColorPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>rotation</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>rotation</code> property defines the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
        /// </summary>
        public DoubleCesiumWriter RotationWriter
        {
            get { return m_rotation.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>rotation</code> property.  The <code>rotation</code> property defines the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
        /// </summary>
        public DoubleCesiumWriter OpenRotationProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RotationWriter);
        }

        /// <summary>
        /// Writes a value for the <code>rotation</code> property as a <code>number</code> value.  The <code>rotation</code> property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRotationProperty(double value)
        {
            using (var writer = OpenRotationProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rotation</code> property as a <code>number</code> value.  The <code>rotation</code> property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteRotationProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenRotationProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rotation</code> property as a <code>reference</code> value.  The <code>rotation</code> property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteRotationPropertyReference(Reference value)
        {
            using (var writer = OpenRotationProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rotation</code> property as a <code>reference</code> value.  The <code>rotation</code> property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteRotationPropertyReference(string value)
        {
            using (var writer = OpenRotationProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rotation</code> property as a <code>reference</code> value.  The <code>rotation</code> property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteRotationPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenRotationProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rotation</code> property as a <code>reference</code> value.  The <code>rotation</code> property specifies the rotation of the billboard, in radians, counter-clockwise from the alignedAxis.  If not specified, the default value is 0.0.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteRotationPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenRotationProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>alignedAxis</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>alignedAxis</code> property defines the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
        /// </summary>
        public AlignedAxisCesiumWriter AlignedAxisWriter
        {
            get { return m_alignedAxis.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>alignedAxis</code> property.  The <code>alignedAxis</code> property defines the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
        /// </summary>
        public AlignedAxisCesiumWriter OpenAlignedAxisProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(AlignedAxisWriter);
        }

        /// <summary>
        /// Writes a value for the <code>alignedAxis</code> property as a <code>cartesian</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteAlignedAxisProperty(Cartesian value)
        {
            using (var writer = OpenAlignedAxisProperty())
            {
                writer.WriteCartesian(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>alignedAxis</code> property as a <code>cartesian</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteAlignedAxisProperty(IList<JulianDate> dates, IList<Cartesian> values)
        {
            using (var writer = OpenAlignedAxisProperty())
            {
                writer.WriteCartesian(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>alignedAxis</code> property as a <code>cartesian</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteAlignedAxisProperty(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            using (var writer = OpenAlignedAxisProperty())
            {
                writer.WriteCartesian(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>alignedAxis</code> property as a <code>reference</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteAlignedAxisPropertyReference(Reference value)
        {
            using (var writer = OpenAlignedAxisProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>alignedAxis</code> property as a <code>reference</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteAlignedAxisPropertyReference(string value)
        {
            using (var writer = OpenAlignedAxisProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>alignedAxis</code> property as a <code>reference</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteAlignedAxisPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenAlignedAxisProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>alignedAxis</code> property as a <code>reference</code> value.  The <code>alignedAxis</code> property specifies the aligned axis is the unit vector, in world coordinates, that the billboard up vector points towards.  The default is the zero vector, which means the billboard is aligned to the screen up vector.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteAlignedAxisPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenAlignedAxisProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>sizeInMeters</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>sizeInMeters</code> property defines whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        public BooleanCesiumWriter SizeInMetersWriter
        {
            get { return m_sizeInMeters.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>sizeInMeters</code> property.  The <code>sizeInMeters</code> property defines whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        public BooleanCesiumWriter OpenSizeInMetersProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SizeInMetersWriter);
        }

        /// <summary>
        /// Writes a value for the <code>sizeInMeters</code> property as a <code>boolean</code> value.  The <code>sizeInMeters</code> property specifies whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteSizeInMetersProperty(bool value)
        {
            using (var writer = OpenSizeInMetersProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>sizeInMeters</code> property as a <code>reference</code> value.  The <code>sizeInMeters</code> property specifies whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteSizeInMetersPropertyReference(Reference value)
        {
            using (var writer = OpenSizeInMetersProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>sizeInMeters</code> property as a <code>reference</code> value.  The <code>sizeInMeters</code> property specifies whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteSizeInMetersPropertyReference(string value)
        {
            using (var writer = OpenSizeInMetersProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>sizeInMeters</code> property as a <code>reference</code> value.  The <code>sizeInMeters</code> property specifies whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteSizeInMetersPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenSizeInMetersProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>sizeInMeters</code> property as a <code>reference</code> value.  The <code>sizeInMeters</code> property specifies whether this billboard's size (`width` and `height`) should be measured in meters, otherwise size is measured in pixels.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteSizeInMetersPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenSizeInMetersProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>width</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>width</code> property defines the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        public DoubleCesiumWriter WidthWriter
        {
            get { return m_width.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>width</code> property.  The <code>width</code> property defines the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        public DoubleCesiumWriter OpenWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(WidthWriter);
        }

        /// <summary>
        /// Writes a value for the <code>width</code> property as a <code>number</code> value.  The <code>width</code> property specifies the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteWidthProperty(double value)
        {
            using (var writer = OpenWidthProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>width</code> property as a <code>number</code> value.  The <code>width</code> property specifies the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteWidthProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenWidthProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteWidthPropertyReference(Reference value)
        {
            using (var writer = OpenWidthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteWidthPropertyReference(string value)
        {
            using (var writer = OpenWidthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteWidthPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenWidthProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteWidthPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenWidthProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>height</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>height</code> property defines the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        public DoubleCesiumWriter HeightWriter
        {
            get { return m_height.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>height</code> property.  The <code>height</code> property defines the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        public DoubleCesiumWriter OpenHeightProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HeightWriter);
        }

        /// <summary>
        /// Writes a value for the <code>height</code> property as a <code>number</code> value.  The <code>height</code> property specifies the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteHeightProperty(double value)
        {
            using (var writer = OpenHeightProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>height</code> property as a <code>number</code> value.  The <code>height</code> property specifies the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteHeightProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenHeightProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>height</code> property as a <code>reference</code> value.  The <code>height</code> property specifies the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteHeightPropertyReference(Reference value)
        {
            using (var writer = OpenHeightProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>height</code> property as a <code>reference</code> value.  The <code>height</code> property specifies the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteHeightPropertyReference(string value)
        {
            using (var writer = OpenHeightProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>height</code> property as a <code>reference</code> value.  The <code>height</code> property specifies the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteHeightPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenHeightProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>height</code> property as a <code>reference</code> value.  The <code>height</code> property specifies the height of the billboard, in pixels (or meters, if `sizeInMeters` is true). By default, the native width of the image is used.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteHeightPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenHeightProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>scaleByDistance</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>scaleByDistance</code> property defines how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
        /// </summary>
        public NearFarScalarCesiumWriter ScaleByDistanceWriter
        {
            get { return m_scaleByDistance.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>scaleByDistance</code> property.  The <code>scaleByDistance</code> property defines how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
        /// </summary>
        public NearFarScalarCesiumWriter OpenScaleByDistanceProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ScaleByDistanceWriter);
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteScaleByDistanceProperty(NearFarScalar value)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
        /// </summary>
        /// <param name="nearDistance">The lower bound of the camera distance range.</param>
        /// <param name="nearValue">The value to use at the lower bound of the camera distance range.</param>
        /// <param name="farDistance">The upper bound of the camera distance range.</param>
        /// <param name="farValue">The value to use at the upper bound of the camera distance range.</param>
        public void WriteScaleByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(nearDistance, nearValue, farDistance, farValue);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteScaleByDistanceProperty(IList<JulianDate> dates, IList<NearFarScalar> values)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteScaleByDistanceProperty(IList<JulianDate> dates, IList<NearFarScalar> values, int startIndex, int length)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteScaleByDistancePropertyReference(Reference value)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteScaleByDistancePropertyReference(string value)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteScaleByDistancePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scaleByDistance</code> property as a <code>reference</code> value.  The <code>scaleByDistance</code> property specifies how the billboard's scale should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `scale`.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteScaleByDistancePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenScaleByDistanceProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>translucencyByDistance</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>translucencyByDistance</code> property defines how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        public NearFarScalarCesiumWriter TranslucencyByDistanceWriter
        {
            get { return m_translucencyByDistance.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>translucencyByDistance</code> property.  The <code>translucencyByDistance</code> property defines how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        public NearFarScalarCesiumWriter OpenTranslucencyByDistanceProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(TranslucencyByDistanceWriter);
        }

        /// <summary>
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteTranslucencyByDistanceProperty(NearFarScalar value)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteNearFarScalar(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="nearDistance">The lower bound of the camera distance range.</param>
        /// <param name="nearValue">The value to use at the lower bound of the camera distance range.</param>
        /// <param name="farDistance">The upper bound of the camera distance range.</param>
        /// <param name="farValue">The value to use at the upper bound of the camera distance range.</param>
        public void WriteTranslucencyByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteNearFarScalar(nearDistance, nearValue, farDistance, farValue);
            }
        }

        /// <summary>
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteTranslucencyByDistanceProperty(IList<JulianDate> dates, IList<NearFarScalar> values)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteNearFarScalar(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteTranslucencyByDistanceProperty(IList<JulianDate> dates, IList<NearFarScalar> values, int startIndex, int length)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteNearFarScalar(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteTranslucencyByDistancePropertyReference(Reference value)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteTranslucencyByDistancePropertyReference(string value)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteTranslucencyByDistancePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>translucencyByDistance</code> property as a <code>reference</code> value.  The <code>translucencyByDistance</code> property specifies how the billboard's translucency should change based on the billboard's distance from the camera.  This scalar value should range from 0 to 1.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteTranslucencyByDistancePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenTranslucencyByDistanceProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>pixelOffsetScaleByDistance</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>pixelOffsetScaleByDistance</code> property defines how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
        /// </summary>
        public NearFarScalarCesiumWriter PixelOffsetScaleByDistanceWriter
        {
            get { return m_pixelOffsetScaleByDistance.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>pixelOffsetScaleByDistance</code> property.  The <code>pixelOffsetScaleByDistance</code> property defines how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
        /// </summary>
        public NearFarScalarCesiumWriter OpenPixelOffsetScaleByDistanceProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PixelOffsetScaleByDistanceWriter);
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WritePixelOffsetScaleByDistanceProperty(NearFarScalar value)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
        /// </summary>
        /// <param name="nearDistance">The lower bound of the camera distance range.</param>
        /// <param name="nearValue">The value to use at the lower bound of the camera distance range.</param>
        /// <param name="farDistance">The upper bound of the camera distance range.</param>
        /// <param name="farValue">The value to use at the upper bound of the camera distance range.</param>
        public void WritePixelOffsetScaleByDistanceProperty(double nearDistance, double nearValue, double farDistance, double farValue)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(nearDistance, nearValue, farDistance, farValue);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePixelOffsetScaleByDistanceProperty(IList<JulianDate> dates, IList<NearFarScalar> values)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>nearFarScalar</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WritePixelOffsetScaleByDistanceProperty(IList<JulianDate> dates, IList<NearFarScalar> values, int startIndex, int length)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteNearFarScalar(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>reference</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WritePixelOffsetScaleByDistancePropertyReference(Reference value)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>reference</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WritePixelOffsetScaleByDistancePropertyReference(string value)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>reference</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WritePixelOffsetScaleByDistancePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>pixelOffsetScaleByDistance</code> property as a <code>reference</code> value.  The <code>pixelOffsetScaleByDistance</code> property specifies how the billboard's pixel offset should change based on the billboard's distance from the camera.  This scalar value will be multiplied by `pixelOffset`.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WritePixelOffsetScaleByDistancePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenPixelOffsetScaleByDistanceProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>imageSubRegion</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>imageSubRegion</code> property defines a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
        /// </summary>
        public BoundingRectangleCesiumWriter ImageSubRegionWriter
        {
            get { return m_imageSubRegion.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>imageSubRegion</code> property.  The <code>imageSubRegion</code> property defines a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
        /// </summary>
        public BoundingRectangleCesiumWriter OpenImageSubRegionProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ImageSubRegionWriter);
        }

        /// <summary>
        /// Writes a value for the <code>imageSubRegion</code> property as a <code>cartesian</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteImageSubRegionProperty(BoundingRectangle value)
        {
            using (var writer = OpenImageSubRegionProperty())
            {
                writer.WriteCartesian(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>imageSubRegion</code> property as a <code>cartesian</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteImageSubRegionProperty(IList<JulianDate> dates, IList<BoundingRectangle> values)
        {
            using (var writer = OpenImageSubRegionProperty())
            {
                writer.WriteCartesian(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>imageSubRegion</code> property as a <code>cartesian</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteImageSubRegionProperty(IList<JulianDate> dates, IList<BoundingRectangle> values, int startIndex, int length)
        {
            using (var writer = OpenImageSubRegionProperty())
            {
                writer.WriteCartesian(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>imageSubRegion</code> property as a <code>reference</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteImageSubRegionPropertyReference(Reference value)
        {
            using (var writer = OpenImageSubRegionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>imageSubRegion</code> property as a <code>reference</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteImageSubRegionPropertyReference(string value)
        {
            using (var writer = OpenImageSubRegionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>imageSubRegion</code> property as a <code>reference</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteImageSubRegionPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenImageSubRegionProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>imageSubRegion</code> property as a <code>reference</code> value.  The <code>imageSubRegion</code> property specifies a sub-region of the image which will be used for the billboard, rather than the entire image, measured in pixels from the bottom-left.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteImageSubRegionPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenImageSubRegionProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

    }
}
