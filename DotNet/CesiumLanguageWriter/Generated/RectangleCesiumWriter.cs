// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>Rectangle</c> to a <see cref="CesiumOutputStream" />.  A <c>Rectangle</c> is a cartographic rectangle, which conforms to the curvature of the globe and can be placed on the surface or at altitude and can optionally be extruded into a volume.
    /// </summary>
    public class RectangleCesiumWriter : CesiumPropertyWriter<RectangleCesiumWriter>
    {
        /// <summary>
        /// The name of the <c>show</c> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <c>coordinates</c> property.
        /// </summary>
        public const string CoordinatesPropertyName = "coordinates";

        /// <summary>
        /// The name of the <c>height</c> property.
        /// </summary>
        public const string HeightPropertyName = "height";

        /// <summary>
        /// The name of the <c>extrudedHeight</c> property.
        /// </summary>
        public const string ExtrudedHeightPropertyName = "extrudedHeight";

        /// <summary>
        /// The name of the <c>rotation</c> property.
        /// </summary>
        public const string RotationPropertyName = "rotation";

        /// <summary>
        /// The name of the <c>stRotation</c> property.
        /// </summary>
        public const string StRotationPropertyName = "stRotation";

        /// <summary>
        /// The name of the <c>granularity</c> property.
        /// </summary>
        public const string GranularityPropertyName = "granularity";

        /// <summary>
        /// The name of the <c>fill</c> property.
        /// </summary>
        public const string FillPropertyName = "fill";

        /// <summary>
        /// The name of the <c>material</c> property.
        /// </summary>
        public const string MaterialPropertyName = "material";

        /// <summary>
        /// The name of the <c>outline</c> property.
        /// </summary>
        public const string OutlinePropertyName = "outline";

        /// <summary>
        /// The name of the <c>outlineColor</c> property.
        /// </summary>
        public const string OutlineColorPropertyName = "outlineColor";

        /// <summary>
        /// The name of the <c>outlineWidth</c> property.
        /// </summary>
        public const string OutlineWidthPropertyName = "outlineWidth";

        /// <summary>
        /// The name of the <c>closeTop</c> property.
        /// </summary>
        public const string CloseTopPropertyName = "closeTop";

        /// <summary>
        /// The name of the <c>closeBottom</c> property.
        /// </summary>
        public const string CloseBottomPropertyName = "closeBottom";

        /// <summary>
        /// The name of the <c>shadows</c> property.
        /// </summary>
        public const string ShadowsPropertyName = "shadows";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<RectangleCoordinatesCesiumWriter> m_coordinates = new Lazy<RectangleCoordinatesCesiumWriter>(() => new RectangleCoordinatesCesiumWriter(CoordinatesPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_height = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(HeightPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_extrudedHeight = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ExtrudedHeightPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_rotation = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RotationPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_stRotation = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(StRotationPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_granularity = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(GranularityPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_fill = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(FillPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_material = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(MaterialPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_outline = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(OutlinePropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(OutlineColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OutlineWidthPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_closeTop = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(CloseTopPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_closeBottom = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(CloseBottomPropertyName), false);
        private readonly Lazy<ShadowModeCesiumWriter> m_shadows = new Lazy<ShadowModeCesiumWriter>(() => new ShadowModeCesiumWriter(ShadowsPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public RectangleCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected RectangleCesiumWriter(RectangleCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override RectangleCesiumWriter Clone()
        {
            return new RectangleCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <c>show</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>show</c> property defines whether or not the rectangle is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>show</c> property.  The <c>show</c> property defines whether or not the rectangle is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <c>show</c> property as a <c>boolean</c> value.  The <c>show</c> property specifies whether or not the rectangle is shown.  If not specified, the default value is <see langword="true"/>.
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
        /// Writes a value for the <c>show</c> property as a <c>reference</c> value.  The <c>show</c> property specifies whether or not the rectangle is shown.  If not specified, the default value is <see langword="true"/>.
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
        /// Writes a value for the <c>show</c> property as a <c>reference</c> value.  The <c>show</c> property specifies whether or not the rectangle is shown.  If not specified, the default value is <see langword="true"/>.
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
        /// Writes a value for the <c>show</c> property as a <c>reference</c> value.  The <c>show</c> property specifies whether or not the rectangle is shown.  If not specified, the default value is <see langword="true"/>.
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
        /// Writes a value for the <c>show</c> property as a <c>reference</c> value.  The <c>show</c> property specifies whether or not the rectangle is shown.  If not specified, the default value is <see langword="true"/>.
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
        /// Gets the writer for the <c>coordinates</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>coordinates</c> property defines the coordinates of the rectangle.
        /// </summary>
        public RectangleCoordinatesCesiumWriter CoordinatesWriter
        {
            get { return m_coordinates.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>coordinates</c> property.  The <c>coordinates</c> property defines the coordinates of the rectangle.
        /// </summary>
        public RectangleCoordinatesCesiumWriter OpenCoordinatesProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(CoordinatesWriter);
        }

        /// <summary>
        /// Writes a value for the <c>coordinates</c> property as a <c>wsen</c> value.  The <c>coordinates</c> property specifies the coordinates of the rectangle.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteCoordinatesProperty(CartographicExtent value)
        {
            using (var writer = OpenCoordinatesProperty())
            {
                writer.WriteWsen(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>coordinates</c> property as a <c>wsen</c> value.  The <c>coordinates</c> property specifies the coordinates of the rectangle.
        /// </summary>
        /// <param name="west">The westernmost longitude.</param>
        /// <param name="south">The southernmost latitude.</param>
        /// <param name="east">The easternmost longitude.</param>
        /// <param name="north">The northernmost latitude.</param>
        public void WriteCoordinatesProperty(double west, double south, double east, double north)
        {
            using (var writer = OpenCoordinatesProperty())
            {
                writer.WriteWsen(west, south, east, north);
            }
        }

        /// <summary>
        /// Writes a value for the <c>coordinates</c> property as a <c>wsen</c> value.  The <c>coordinates</c> property specifies the coordinates of the rectangle.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCoordinatesProperty(IList<JulianDate> dates, IList<CartographicExtent> values)
        {
            using (var writer = OpenCoordinatesProperty())
            {
                writer.WriteWsen(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>coordinates</c> property as a <c>wsen</c> value.  The <c>coordinates</c> property specifies the coordinates of the rectangle.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteCoordinatesProperty(IList<JulianDate> dates, IList<CartographicExtent> values, int startIndex, int length)
        {
            using (var writer = OpenCoordinatesProperty())
            {
                writer.WriteWsen(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>coordinates</c> property as a <c>wsenDegrees</c> value.  The <c>coordinates</c> property specifies the coordinates of the rectangle.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteCoordinatesPropertyWsenDegrees(CartographicExtent value)
        {
            using (var writer = OpenCoordinatesProperty())
            {
                writer.WriteWsenDegrees(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>coordinates</c> property as a <c>wsenDegrees</c> value.  The <c>coordinates</c> property specifies the coordinates of the rectangle.
        /// </summary>
        /// <param name="west">The westernmost longitude.</param>
        /// <param name="south">The southernmost latitude.</param>
        /// <param name="east">The easternmost longitude.</param>
        /// <param name="north">The northernmost latitude.</param>
        public void WriteCoordinatesPropertyWsenDegrees(double west, double south, double east, double north)
        {
            using (var writer = OpenCoordinatesProperty())
            {
                writer.WriteWsenDegrees(west, south, east, north);
            }
        }

        /// <summary>
        /// Writes a value for the <c>coordinates</c> property as a <c>wsenDegrees</c> value.  The <c>coordinates</c> property specifies the coordinates of the rectangle.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCoordinatesPropertyWsenDegrees(IList<JulianDate> dates, IList<CartographicExtent> values)
        {
            using (var writer = OpenCoordinatesProperty())
            {
                writer.WriteWsenDegrees(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>coordinates</c> property as a <c>wsenDegrees</c> value.  The <c>coordinates</c> property specifies the coordinates of the rectangle.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteCoordinatesPropertyWsenDegrees(IList<JulianDate> dates, IList<CartographicExtent> values, int startIndex, int length)
        {
            using (var writer = OpenCoordinatesProperty())
            {
                writer.WriteWsenDegrees(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>coordinates</c> property as a <c>reference</c> value.  The <c>coordinates</c> property specifies the coordinates of the rectangle.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteCoordinatesPropertyReference(Reference value)
        {
            using (var writer = OpenCoordinatesProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>coordinates</c> property as a <c>reference</c> value.  The <c>coordinates</c> property specifies the coordinates of the rectangle.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteCoordinatesPropertyReference(string value)
        {
            using (var writer = OpenCoordinatesProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>coordinates</c> property as a <c>reference</c> value.  The <c>coordinates</c> property specifies the coordinates of the rectangle.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteCoordinatesPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenCoordinatesProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>coordinates</c> property as a <c>reference</c> value.  The <c>coordinates</c> property specifies the coordinates of the rectangle.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteCoordinatesPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenCoordinatesProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>height</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>height</c> property defines the height of the rectangle.
        /// </summary>
        public DoubleCesiumWriter HeightWriter
        {
            get { return m_height.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>height</c> property.  The <c>height</c> property defines the height of the rectangle.
        /// </summary>
        public DoubleCesiumWriter OpenHeightProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HeightWriter);
        }

        /// <summary>
        /// Writes a value for the <c>height</c> property as a <c>number</c> value.  The <c>height</c> property specifies the height of the rectangle.
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
        /// Writes a value for the <c>height</c> property as a <c>number</c> value.  The <c>height</c> property specifies the height of the rectangle.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteHeightProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenHeightProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>height</c> property as a <c>number</c> value.  The <c>height</c> property specifies the height of the rectangle.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteHeightProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenHeightProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>height</c> property as a <c>reference</c> value.  The <c>height</c> property specifies the height of the rectangle.
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
        /// Writes a value for the <c>height</c> property as a <c>reference</c> value.  The <c>height</c> property specifies the height of the rectangle.
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
        /// Writes a value for the <c>height</c> property as a <c>reference</c> value.  The <c>height</c> property specifies the height of the rectangle.
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
        /// Writes a value for the <c>height</c> property as a <c>reference</c> value.  The <c>height</c> property specifies the height of the rectangle.
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
        /// Gets the writer for the <c>extrudedHeight</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>extrudedHeight</c> property defines the extruded height of the rectangle.
        /// </summary>
        public DoubleCesiumWriter ExtrudedHeightWriter
        {
            get { return m_extrudedHeight.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>extrudedHeight</c> property.  The <c>extrudedHeight</c> property defines the extruded height of the rectangle.
        /// </summary>
        public DoubleCesiumWriter OpenExtrudedHeightProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ExtrudedHeightWriter);
        }

        /// <summary>
        /// Writes a value for the <c>extrudedHeight</c> property as a <c>number</c> value.  The <c>extrudedHeight</c> property specifies the extruded height of the rectangle.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteExtrudedHeightProperty(double value)
        {
            using (var writer = OpenExtrudedHeightProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>extrudedHeight</c> property as a <c>number</c> value.  The <c>extrudedHeight</c> property specifies the extruded height of the rectangle.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteExtrudedHeightProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenExtrudedHeightProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>extrudedHeight</c> property as a <c>number</c> value.  The <c>extrudedHeight</c> property specifies the extruded height of the rectangle.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteExtrudedHeightProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenExtrudedHeightProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>extrudedHeight</c> property as a <c>reference</c> value.  The <c>extrudedHeight</c> property specifies the extruded height of the rectangle.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteExtrudedHeightPropertyReference(Reference value)
        {
            using (var writer = OpenExtrudedHeightProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>extrudedHeight</c> property as a <c>reference</c> value.  The <c>extrudedHeight</c> property specifies the extruded height of the rectangle.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteExtrudedHeightPropertyReference(string value)
        {
            using (var writer = OpenExtrudedHeightProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>extrudedHeight</c> property as a <c>reference</c> value.  The <c>extrudedHeight</c> property specifies the extruded height of the rectangle.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteExtrudedHeightPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenExtrudedHeightProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>extrudedHeight</c> property as a <c>reference</c> value.  The <c>extrudedHeight</c> property specifies the extruded height of the rectangle.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteExtrudedHeightPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenExtrudedHeightProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>rotation</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>rotation</c> property defines the rotation of the rectangle clockwise from north.
        /// </summary>
        public DoubleCesiumWriter RotationWriter
        {
            get { return m_rotation.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>rotation</c> property.  The <c>rotation</c> property defines the rotation of the rectangle clockwise from north.
        /// </summary>
        public DoubleCesiumWriter OpenRotationProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RotationWriter);
        }

        /// <summary>
        /// Writes a value for the <c>rotation</c> property as a <c>number</c> value.  The <c>rotation</c> property specifies the rotation of the rectangle clockwise from north.
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
        /// Writes a value for the <c>rotation</c> property as a <c>number</c> value.  The <c>rotation</c> property specifies the rotation of the rectangle clockwise from north.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteRotationProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenRotationProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>rotation</c> property as a <c>number</c> value.  The <c>rotation</c> property specifies the rotation of the rectangle clockwise from north.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteRotationProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenRotationProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>rotation</c> property as a <c>reference</c> value.  The <c>rotation</c> property specifies the rotation of the rectangle clockwise from north.
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
        /// Writes a value for the <c>rotation</c> property as a <c>reference</c> value.  The <c>rotation</c> property specifies the rotation of the rectangle clockwise from north.
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
        /// Writes a value for the <c>rotation</c> property as a <c>reference</c> value.  The <c>rotation</c> property specifies the rotation of the rectangle clockwise from north.
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
        /// Writes a value for the <c>rotation</c> property as a <c>reference</c> value.  The <c>rotation</c> property specifies the rotation of the rectangle clockwise from north.
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
        /// Gets the writer for the <c>stRotation</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>stRotation</c> property defines the rotation of any applied texture. A positive rotation is counter-clockwise.
        /// </summary>
        public DoubleCesiumWriter StRotationWriter
        {
            get { return m_stRotation.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>stRotation</c> property.  The <c>stRotation</c> property defines the rotation of any applied texture. A positive rotation is counter-clockwise.
        /// </summary>
        public DoubleCesiumWriter OpenStRotationProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(StRotationWriter);
        }

        /// <summary>
        /// Writes a value for the <c>stRotation</c> property as a <c>number</c> value.  The <c>stRotation</c> property specifies the rotation of any applied texture. A positive rotation is counter-clockwise.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteStRotationProperty(double value)
        {
            using (var writer = OpenStRotationProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>stRotation</c> property as a <c>number</c> value.  The <c>stRotation</c> property specifies the rotation of any applied texture. A positive rotation is counter-clockwise.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteStRotationProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenStRotationProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>stRotation</c> property as a <c>number</c> value.  The <c>stRotation</c> property specifies the rotation of any applied texture. A positive rotation is counter-clockwise.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteStRotationProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenStRotationProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>stRotation</c> property as a <c>reference</c> value.  The <c>stRotation</c> property specifies the rotation of any applied texture. A positive rotation is counter-clockwise.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteStRotationPropertyReference(Reference value)
        {
            using (var writer = OpenStRotationProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>stRotation</c> property as a <c>reference</c> value.  The <c>stRotation</c> property specifies the rotation of any applied texture. A positive rotation is counter-clockwise.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteStRotationPropertyReference(string value)
        {
            using (var writer = OpenStRotationProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>stRotation</c> property as a <c>reference</c> value.  The <c>stRotation</c> property specifies the rotation of any applied texture. A positive rotation is counter-clockwise.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteStRotationPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenStRotationProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>stRotation</c> property as a <c>reference</c> value.  The <c>stRotation</c> property specifies the rotation of any applied texture. A positive rotation is counter-clockwise.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteStRotationPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenStRotationProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>granularity</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>granularity</c> property defines the sampling distance, in radians.
        /// </summary>
        public DoubleCesiumWriter GranularityWriter
        {
            get { return m_granularity.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>granularity</c> property.  The <c>granularity</c> property defines the sampling distance, in radians.
        /// </summary>
        public DoubleCesiumWriter OpenGranularityProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(GranularityWriter);
        }

        /// <summary>
        /// Writes a value for the <c>granularity</c> property as a <c>number</c> value.  The <c>granularity</c> property specifies the sampling distance, in radians.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteGranularityProperty(double value)
        {
            using (var writer = OpenGranularityProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>granularity</c> property as a <c>number</c> value.  The <c>granularity</c> property specifies the sampling distance, in radians.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteGranularityProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenGranularityProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>granularity</c> property as a <c>number</c> value.  The <c>granularity</c> property specifies the sampling distance, in radians.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteGranularityProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenGranularityProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>granularity</c> property as a <c>reference</c> value.  The <c>granularity</c> property specifies the sampling distance, in radians.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteGranularityPropertyReference(Reference value)
        {
            using (var writer = OpenGranularityProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>granularity</c> property as a <c>reference</c> value.  The <c>granularity</c> property specifies the sampling distance, in radians.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteGranularityPropertyReference(string value)
        {
            using (var writer = OpenGranularityProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>granularity</c> property as a <c>reference</c> value.  The <c>granularity</c> property specifies the sampling distance, in radians.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteGranularityPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenGranularityProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>granularity</c> property as a <c>reference</c> value.  The <c>granularity</c> property specifies the sampling distance, in radians.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteGranularityPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenGranularityProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>fill</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>fill</c> property defines whether or not the rectangle is filled.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter FillWriter
        {
            get { return m_fill.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>fill</c> property.  The <c>fill</c> property defines whether or not the rectangle is filled.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter OpenFillProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(FillWriter);
        }

        /// <summary>
        /// Writes a value for the <c>fill</c> property as a <c>boolean</c> value.  The <c>fill</c> property specifies whether or not the rectangle is filled.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteFillProperty(bool value)
        {
            using (var writer = OpenFillProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>fill</c> property as a <c>reference</c> value.  The <c>fill</c> property specifies whether or not the rectangle is filled.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteFillPropertyReference(Reference value)
        {
            using (var writer = OpenFillProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>fill</c> property as a <c>reference</c> value.  The <c>fill</c> property specifies whether or not the rectangle is filled.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteFillPropertyReference(string value)
        {
            using (var writer = OpenFillProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>fill</c> property as a <c>reference</c> value.  The <c>fill</c> property specifies whether or not the rectangle is filled.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteFillPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenFillProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>fill</c> property as a <c>reference</c> value.  The <c>fill</c> property specifies whether or not the rectangle is filled.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteFillPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenFillProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>material</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>material</c> property defines the material to display on the surface of the rectangle.
        /// </summary>
        public MaterialCesiumWriter MaterialWriter
        {
            get { return m_material.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>material</c> property.  The <c>material</c> property defines the material to display on the surface of the rectangle.
        /// </summary>
        public MaterialCesiumWriter OpenMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaterialWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>outline</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>outline</c> property defines whether or not the rectangle is outlined.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        public BooleanCesiumWriter OutlineWriter
        {
            get { return m_outline.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>outline</c> property.  The <c>outline</c> property defines whether or not the rectangle is outlined.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        public BooleanCesiumWriter OpenOutlineProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineWriter);
        }

        /// <summary>
        /// Writes a value for the <c>outline</c> property as a <c>boolean</c> value.  The <c>outline</c> property specifies whether or not the rectangle is outlined.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteOutlineProperty(bool value)
        {
            using (var writer = OpenOutlineProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outline</c> property as a <c>reference</c> value.  The <c>outline</c> property specifies whether or not the rectangle is outlined.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteOutlinePropertyReference(Reference value)
        {
            using (var writer = OpenOutlineProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outline</c> property as a <c>reference</c> value.  The <c>outline</c> property specifies whether or not the rectangle is outlined.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteOutlinePropertyReference(string value)
        {
            using (var writer = OpenOutlineProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outline</c> property as a <c>reference</c> value.  The <c>outline</c> property specifies whether or not the rectangle is outlined.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteOutlinePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenOutlineProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outline</c> property as a <c>reference</c> value.  The <c>outline</c> property specifies whether or not the rectangle is outlined.  If not specified, the default value is <see langword="false"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteOutlinePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenOutlineProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>outlineColor</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>outlineColor</c> property defines the color of the rectangle outline.
        /// </summary>
        public ColorCesiumWriter OutlineColorWriter
        {
            get { return m_outlineColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>outlineColor</c> property.  The <c>outlineColor</c> property defines the color of the rectangle outline.
        /// </summary>
        public ColorCesiumWriter OpenOutlineColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineColorWriter);
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgba</c> value.  The <c>outlineColor</c> property specifies the color of the rectangle outline.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteOutlineColorProperty(Color color)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgba</c> value.  The <c>outlineColor</c> property specifies the color of the rectangle outline.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteOutlineColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgba</c> value.  The <c>outlineColor</c> property specifies the color of the rectangle outline.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteOutlineColorProperty(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgba(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgba</c> value.  The <c>outlineColor</c> property specifies the color of the rectangle outline.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteOutlineColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgbaf</c> value.  The <c>outlineColor</c> property specifies the color of the rectangle outline.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteOutlineColorPropertyRgbaf(Color color)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgbaf(color);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgbaf</c> value.  The <c>outlineColor</c> property specifies the color of the rectangle outline.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteOutlineColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgbaf</c> value.  The <c>outlineColor</c> property specifies the color of the rectangle outline.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteOutlineColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgbaf(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>rgbaf</c> value.  The <c>outlineColor</c> property specifies the color of the rectangle outline.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteOutlineColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgbaf(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>reference</c> value.  The <c>outlineColor</c> property specifies the color of the rectangle outline.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteOutlineColorPropertyReference(Reference value)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>reference</c> value.  The <c>outlineColor</c> property specifies the color of the rectangle outline.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteOutlineColorPropertyReference(string value)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>reference</c> value.  The <c>outlineColor</c> property specifies the color of the rectangle outline.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteOutlineColorPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineColor</c> property as a <c>reference</c> value.  The <c>outlineColor</c> property specifies the color of the rectangle outline.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteOutlineColorPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>outlineWidth</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>outlineWidth</c> property defines the width of the rectangle outline.  If not specified, the default value is 1.0.
        /// </summary>
        public DoubleCesiumWriter OutlineWidthWriter
        {
            get { return m_outlineWidth.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>outlineWidth</c> property.  The <c>outlineWidth</c> property defines the width of the rectangle outline.  If not specified, the default value is 1.0.
        /// </summary>
        public DoubleCesiumWriter OpenOutlineWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineWidthWriter);
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>number</c> value.  The <c>outlineWidth</c> property specifies the width of the rectangle outline.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteOutlineWidthProperty(double value)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>number</c> value.  The <c>outlineWidth</c> property specifies the width of the rectangle outline.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteOutlineWidthProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>number</c> value.  The <c>outlineWidth</c> property specifies the width of the rectangle outline.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteOutlineWidthProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>reference</c> value.  The <c>outlineWidth</c> property specifies the width of the rectangle outline.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteOutlineWidthPropertyReference(Reference value)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>reference</c> value.  The <c>outlineWidth</c> property specifies the width of the rectangle outline.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteOutlineWidthPropertyReference(string value)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>reference</c> value.  The <c>outlineWidth</c> property specifies the width of the rectangle outline.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteOutlineWidthPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>outlineWidth</c> property as a <c>reference</c> value.  The <c>outlineWidth</c> property specifies the width of the rectangle outline.  If not specified, the default value is 1.0.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteOutlineWidthPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>closeTop</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>closeTop</c> property defines whether to close the top of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter CloseTopWriter
        {
            get { return m_closeTop.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>closeTop</c> property.  The <c>closeTop</c> property defines whether to close the top of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter OpenCloseTopProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(CloseTopWriter);
        }

        /// <summary>
        /// Writes a value for the <c>closeTop</c> property as a <c>boolean</c> value.  The <c>closeTop</c> property specifies whether to close the top of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteCloseTopProperty(bool value)
        {
            using (var writer = OpenCloseTopProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>closeTop</c> property as a <c>reference</c> value.  The <c>closeTop</c> property specifies whether to close the top of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteCloseTopPropertyReference(Reference value)
        {
            using (var writer = OpenCloseTopProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>closeTop</c> property as a <c>reference</c> value.  The <c>closeTop</c> property specifies whether to close the top of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteCloseTopPropertyReference(string value)
        {
            using (var writer = OpenCloseTopProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>closeTop</c> property as a <c>reference</c> value.  The <c>closeTop</c> property specifies whether to close the top of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteCloseTopPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenCloseTopProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>closeTop</c> property as a <c>reference</c> value.  The <c>closeTop</c> property specifies whether to close the top of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteCloseTopPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenCloseTopProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>closeBottom</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>closeBottom</c> property defines whether to close the bottom of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter CloseBottomWriter
        {
            get { return m_closeBottom.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>closeBottom</c> property.  The <c>closeBottom</c> property defines whether to close the bottom of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter OpenCloseBottomProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(CloseBottomWriter);
        }

        /// <summary>
        /// Writes a value for the <c>closeBottom</c> property as a <c>boolean</c> value.  The <c>closeBottom</c> property specifies whether to close the bottom of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteCloseBottomProperty(bool value)
        {
            using (var writer = OpenCloseBottomProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>closeBottom</c> property as a <c>reference</c> value.  The <c>closeBottom</c> property specifies whether to close the bottom of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteCloseBottomPropertyReference(Reference value)
        {
            using (var writer = OpenCloseBottomProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>closeBottom</c> property as a <c>reference</c> value.  The <c>closeBottom</c> property specifies whether to close the bottom of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteCloseBottomPropertyReference(string value)
        {
            using (var writer = OpenCloseBottomProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>closeBottom</c> property as a <c>reference</c> value.  The <c>closeBottom</c> property specifies whether to close the bottom of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteCloseBottomPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenCloseBottomProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>closeBottom</c> property as a <c>reference</c> value.  The <c>closeBottom</c> property specifies whether to close the bottom of the rectangle.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteCloseBottomPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenCloseBottomProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>shadows</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>shadows</c> property defines whether or not the rectangle casts or receives shadows.  If not specified, the default value is DISABLED.
        /// </summary>
        public ShadowModeCesiumWriter ShadowsWriter
        {
            get { return m_shadows.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>shadows</c> property.  The <c>shadows</c> property defines whether or not the rectangle casts or receives shadows.  If not specified, the default value is DISABLED.
        /// </summary>
        public ShadowModeCesiumWriter OpenShadowsProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShadowsWriter);
        }

        /// <summary>
        /// Writes a value for the <c>shadows</c> property as a <c>shadowMode</c> value.  The <c>shadows</c> property specifies whether or not the rectangle casts or receives shadows.  If not specified, the default value is DISABLED.
        /// </summary>
        /// <param name="value">The shadow mode.</param>
        public void WriteShadowsProperty(CesiumShadowMode value)
        {
            using (var writer = OpenShadowsProperty())
            {
                writer.WriteShadowMode(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>shadows</c> property as a <c>reference</c> value.  The <c>shadows</c> property specifies whether or not the rectangle casts or receives shadows.  If not specified, the default value is DISABLED.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteShadowsPropertyReference(Reference value)
        {
            using (var writer = OpenShadowsProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>shadows</c> property as a <c>reference</c> value.  The <c>shadows</c> property specifies whether or not the rectangle casts or receives shadows.  If not specified, the default value is DISABLED.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteShadowsPropertyReference(string value)
        {
            using (var writer = OpenShadowsProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>shadows</c> property as a <c>reference</c> value.  The <c>shadows</c> property specifies whether or not the rectangle casts or receives shadows.  If not specified, the default value is DISABLED.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteShadowsPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenShadowsProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>shadows</c> property as a <c>reference</c> value.  The <c>shadows</c> property specifies whether or not the rectangle casts or receives shadows.  If not specified, the default value is DISABLED.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteShadowsPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenShadowsProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

    }
}
