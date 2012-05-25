using System;
using System.Drawing;
#if StkComponents
using AGI.Foundation.Cesium.Advanced;
using AGI.Foundation.Coordinates;
using AGI.Foundation.Time;
#else
using CesiumLanguageWriter.Advanced;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing billboard-related properties to a
    /// <topic name="Cesium">Cesium</topic> stream.  A billboard is a viewport-aligned image positioned
    /// in the 3D scene, and is sometimes called a marker.  The billboard is positioned in the scene
    /// by the <see cref="PacketCesiumWriter.OpenPositionProperty">Position</see> property.  Instances of this class should not be created
    /// directly, but should instead be obtained from a <see cref="PacketCesiumWriter"/>.
    /// </summary>
    public class BillboardCesiumWriter : CesiumPropertyWriter<BillboardCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>color</code> property.
        /// </summary>
        public static readonly string ColorPropertyName = "color";

        /// <summary>
        /// The name of the <code>eyeOffset</code> property.
        /// </summary>
        public static readonly string EyeOffsetPropertyName = "eyeOffset";

        /// <summary>
        /// The name of the <code>horizontalOrigin</code> property.
        /// </summary>
        public static readonly string HorizontalOriginPropertyName = "horizontalOrigin";

        /// <summary>
        /// The name of the <code>image</code> property.
        /// </summary>
        public static readonly string ImagePropertyName = "image";

        /// <summary>
        /// The name of the <code>pixelOffset</code> property.
        /// </summary>
        public static readonly string PixelOffsetPropertyName = "pixelOffset";

        /// <summary>
        /// The name of the <code>rotation</code> property.
        /// </summary>
        public static readonly string RotationPropertyName = "rotation";

        /// <summary>
        /// The name of the <code>scale</code> property.
        /// </summary>
        public static readonly string ScalePropertyName = "scale";

        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public static readonly string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>verticalOrigin</code> property.
        /// </summary>
        public static readonly string VerticalOriginPropertyName = "verticalOrigin";

        private readonly Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(ColorPropertyName), false);
        private readonly Lazy<EyeOffsetCesiumWriter> m_eyeOffset = new Lazy<EyeOffsetCesiumWriter>(() => new EyeOffsetCesiumWriter(EyeOffsetPropertyName), false);
        private readonly Lazy<HorizontalOriginCesiumWriter> m_horizontalOrigin = new Lazy<HorizontalOriginCesiumWriter>(() => new HorizontalOriginCesiumWriter(HorizontalOriginPropertyName), false);
        private readonly Lazy<ImageCesiumWriter> m_image = new Lazy<ImageCesiumWriter>(() => new ImageCesiumWriter(ImagePropertyName), false);
        private readonly Lazy<PixelOffsetCesiumWriter> m_pixelOffset = new Lazy<PixelOffsetCesiumWriter>(() => new PixelOffsetCesiumWriter(PixelOffsetPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_rotation = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RotationPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_scale = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ScalePropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<VerticalOriginCesiumWriter> m_verticalOrigin = new Lazy<VerticalOriginCesiumWriter>(() => new VerticalOriginCesiumWriter(VerticalOriginPropertyName), false);
        private readonly Lazy<CustomCesiumWriter> m_custom = new Lazy<CustomCesiumWriter>(() => new CustomCesiumWriter("custom"), false); 

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
        /// Gets the writer for the <code>color</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenColorProperty"/> method for more information.
        /// </summary>
        public ColorCesiumWriter ColorWriter
        {
            get { return m_color.Value; }
        }

        /// <summary>
        /// Opens a property describing the color of the billboard.  This color value is multiplied with the values
        /// of the billboard <see cref="OpenImageProperty"/> to produce the final color.
        /// </summary>
        /// <returns>The writer that is used to write color information.</returns>
        public ColorCesiumWriter OpenColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>color</code> property.
        /// See the documentation for the <see cref="OpenColorProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteColorProperty(Color value)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>eyeOffset</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenEyeOffsetProperty"/> method for more information.
        /// </summary>
        public EyeOffsetCesiumWriter EyeOffsetWriter
        {
            get { return m_eyeOffset.Value; }
        }

        /// <summary>
        /// Opens a property describing the offset in eye coordinates of the billboard origin from the
        /// <see cref="PacketCesiumWriter.OpenPositionProperty"/>.
        /// </summary>
        /// <returns>The writer that is used to write eye offset information.</returns>
        public EyeOffsetCesiumWriter OpenEyeOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EyeOffsetWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>eyeOffset</code> property.
        /// See the documentation for the <see cref="OpenEyeOffsetProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteEyeOffsetProperty(Cartesian value)
        {
            using (var writer = OpenEyeOffsetProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>horizontalOrigin</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenHorizontalOriginProperty"/> method for more information.
        /// </summary>
        public HorizontalOriginCesiumWriter HorizontalOriginWriter
        {
            get { return m_horizontalOrigin.Value; }
        }

        /// <summary>
        /// Opens a property describing the horizontal origin of the billboard image.  It controls whether the
        /// billboard image is left-, center-, or right-aligned with the <see cref="PacketCesiumWriter.OpenPositionProperty"/>.
        /// </summary>
        /// <returns>A writer that is used to write horizontal origin information.</returns>
        public HorizontalOriginCesiumWriter OpenHorizontalOriginProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HorizontalOriginWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>horizontalOrigin</code> property.
        /// See the documentation for the <see cref="OpenHorizontalOriginProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteHorizontalOriginProperty(CesiumHorizontalOrigin value)
        {
            using (var writer = OpenHorizontalOriginProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>image</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenImageProperty"/> method for more information.
        /// </summary>
        public ImageCesiumWriter ImageWriter
        {
            get { return m_image.Value; }
        }

        /// <summary>
        /// Opens a property describing the billboard image.
        /// </summary>
        /// <returns>A writer that is used to write image information.</returns>
        public ImageCesiumWriter OpenImageProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ImageWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>image</code> property.
        /// See the documentation for the <see cref="OpenImageProperty"/> method for more information.
        /// </summary>
        /// <param name="imageUrl">The value of the property.</param>
        public void WriteImageProperty(string imageUrl)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteValue(imageUrl);
            }
        }

        /// <summary>
        /// Writes a constant value for the <code>image</code> property by building a data
        /// URL from a specified image.  See the documentation for the <see cref="OpenImageProperty"/>
        /// method for more information.
        /// </summary>
        /// <param name="image">The image for which to create a data URL.</param>
        public void WriteImageProperty(Image image)
        {
            using (var writer = OpenImageProperty())
            {
                writer.WriteValue(image);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>pixelOffset</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenPixelOffsetProperty"/> method for more information.
        /// </summary>
        public PixelOffsetCesiumWriter PixelOffsetWriter
        {
            get { return m_pixelOffset.Value; }
        }

        /// <summary>
        /// Opens a property describing the offset, in viewport pixels, of the billboard origin from the
        /// <see cref="PacketCesiumWriter.OpenPositionProperty"/>.
        /// </summary>
        /// <returns>The writer that is used to write pixel offset information.</returns>
        public PixelOffsetCesiumWriter OpenPixelOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PixelOffsetWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>pixelOffset</code> property.
        /// See the documentation for the <see cref="OpenPixelOffsetProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WritePixelOffsetProperty(Rectangular value)
        {
            using (var writer = OpenPixelOffsetProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>rotation</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenRotationProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter RotationWriter
        {
            get { return m_rotation.Value; }
        }

        /// <summary>
        /// Opens a property describing the clockwise rotation of the billboard in radians.
        /// </summary>
        /// <returns>A writer that is used to write rotation information.</returns>
        public DoubleCesiumWriter OpenRotationProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RotationWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>rotation</code> property.
        /// See the documentation for the <see cref="OpenRotationProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteRotationProperty(double value)
        {
            using (var writer = OpenRotationProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>scale</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenScaleProperty"/> method for more information.
        /// </summary>
        public DoubleCesiumWriter ScaleWriter
        {
            get { return m_scale.Value; }
        }

        /// <summary>
        /// Opens a property describing the uniform scale of the billbord.  The scale is multiplied with the pixel
        /// size of the billboard's <see cref="OpenImageProperty"/>.  For example, if the scale is 2.0, the billboard will be
        /// rendered with twice the number of pixels, in each direction, of the <see cref="OpenImageProperty"/>.
        /// </summary>
        /// <returns>A writer that is used to write scale information.</returns>
        public DoubleCesiumWriter OpenScaleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ScaleWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>scale</code> property.
        /// See the documentation for the <see cref="OpenScaleProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteScaleProperty(double value)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenShowProperty"/> method for more information.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens a property describing whether or not the billboard is shown.
        /// </summary>
        /// <returns>A writer that is used to write show information.</returns>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>show</code> property.
        /// See the documentation for the <see cref="OpenShowProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteShowProperty(bool value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>verticalOrigin</code> property.  The returned instance must be opened by calling
        /// the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  See the
        /// documentation for the <see cref="OpenVerticalOriginProperty"/> method for more information.
        /// </summary>
        public VerticalOriginCesiumWriter VerticalOriginWriter
        {
            get { return m_verticalOrigin.Value; }
        }

        /// <summary>
        /// Opens a property describing the vertical origin of the billboard image.  It controls whether the
        /// billboard image is bottom-, center-, or top-aligned with the <see cref="PacketCesiumWriter.OpenPositionProperty"/>.
        /// </summary>
        /// <returns>A writer that is used to write vertical origin information.</returns>
        public VerticalOriginCesiumWriter OpenVerticalOriginProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(VerticalOriginWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>verticalOrigin</code> property.
        /// See the documentation for the <see cref="OpenVerticalOriginProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteVerticalOriginProperty(CesiumVerticalOrigin value)
        {
            using (var writer = OpenVerticalOriginProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>custom</code> property.  See the documentation for the 
        /// <see cref="OpenCustomProperty"/> method for more information.  The returned instance must
        /// be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be
        /// used for writing.
        /// </summary>
        public CustomCesiumWriter CustomWriter
        {
            get { return m_custom.Value; }
        }

        /// <summary>
        /// Opens a property containing additional custom properties, optionally over time.
        /// </summary>
        /// <returns>A writer that is used to write custom properties.</returns>
        public CustomCesiumWriter OpenCustomProperty()
        {
            return OpenAndReturn(CustomWriter);
        }
    }
}
