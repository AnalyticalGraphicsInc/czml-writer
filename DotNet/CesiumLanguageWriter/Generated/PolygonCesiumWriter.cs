// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Polygon</code> to a <see cref="CesiumOutputStream" />.  A <code>Polygon</code> is a polygon, which is a closed figure on the surface of the Earth.
    /// </summary>
    public class PolygonCesiumWriter : CesiumPropertyWriter<PolygonCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>positions</code> property.
        /// </summary>
        public const string PositionsPropertyName = "positions";

        /// <summary>
        /// The name of the <code>material</code> property.
        /// </summary>
        public const string MaterialPropertyName = "material";

        /// <summary>
        /// The name of the <code>height</code> property.
        /// </summary>
        public const string HeightPropertyName = "height";

        /// <summary>
        /// The name of the <code>extrudedHeight</code> property.
        /// </summary>
        public const string ExtrudedHeightPropertyName = "extrudedHeight";

        /// <summary>
        /// The name of the <code>granularity</code> property.
        /// </summary>
        public const string GranularityPropertyName = "granularity";

        /// <summary>
        /// The name of the <code>stRotation</code> property.
        /// </summary>
        public const string StRotationPropertyName = "stRotation";

        /// <summary>
        /// The name of the <code>fill</code> property.
        /// </summary>
        public const string FillPropertyName = "fill";

        /// <summary>
        /// The name of the <code>outline</code> property.
        /// </summary>
        public const string OutlinePropertyName = "outline";

        /// <summary>
        /// The name of the <code>outlineColor</code> property.
        /// </summary>
        public const string OutlineColorPropertyName = "outlineColor";

        /// <summary>
        /// The name of the <code>outlineWidth</code> property.
        /// </summary>
        public const string OutlineWidthPropertyName = "outlineWidth";

        /// <summary>
        /// The name of the <code>perPositionHeight</code> property.
        /// </summary>
        public const string PerPositionHeightPropertyName = "perPositionHeight";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<PositionListCesiumWriter> m_positions = new Lazy<PositionListCesiumWriter>(() => new PositionListCesiumWriter(PositionsPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_material = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(MaterialPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_height = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(HeightPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_extrudedHeight = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ExtrudedHeightPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_granularity = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(GranularityPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_stRotation = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(StRotationPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_fill = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(FillPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_outline = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(OutlinePropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(OutlineColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OutlineWidthPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_perPositionHeight = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(PerPositionHeightPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PolygonCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected PolygonCesiumWriter(PolygonCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PolygonCesiumWriter Clone()
        {
            return new PolygonCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the polygon is shown.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the polygon is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the polygon is shown.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the polygon is shown.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the polygon is shown.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the polygon is shown.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the polygon is shown.
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
        /// Gets the writer for the <code>positions</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>positions</code> property defines the array of positions defining a simple polygon.
        /// </summary>
        public PositionListCesiumWriter PositionsWriter
        {
            get { return m_positions.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>positions</code> property.  The <code>positions</code> property defines the array of positions defining a simple polygon.
        /// </summary>
        public PositionListCesiumWriter OpenPositionsProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PositionsWriter);
        }

        /// <summary>
        /// Writes a value for the <code>positions</code> property as a <code>cartesian</code> value.  The <code>positions</code> property specifies the array of positions defining a simple polygon.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WritePositionsProperty(IEnumerable<Cartesian> values)
        {
            using (var writer = OpenPositionsProperty())
            {
                writer.WriteCartesian(values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>positions</code> property as a <code>cartographicRadians</code> value.  The <code>positions</code> property specifies the array of positions defining a simple polygon.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WritePositionsPropertyCartographicRadians(IEnumerable<Cartographic> values)
        {
            using (var writer = OpenPositionsProperty())
            {
                writer.WriteCartographicRadians(values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>positions</code> property as a <code>cartographicDegrees</code> value.  The <code>positions</code> property specifies the array of positions defining a simple polygon.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WritePositionsPropertyCartographicDegrees(IEnumerable<Cartographic> values)
        {
            using (var writer = OpenPositionsProperty())
            {
                writer.WriteCartographicDegrees(values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>positions</code> property as a <code>references</code> value.  The <code>positions</code> property specifies the array of positions defining a simple polygon.
        /// </summary>
        /// <param name="references">The list of references.</param>
        public void WritePositionsPropertyReferences(IEnumerable<Reference> references)
        {
            using (var writer = OpenPositionsProperty())
            {
                writer.WriteReferences(references);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>material</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>material</code> property defines the material to use to fill the polygon.
        /// </summary>
        public MaterialCesiumWriter MaterialWriter
        {
            get { return m_material.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>material</code> property.  The <code>material</code> property defines the material to use to fill the polygon.
        /// </summary>
        public MaterialCesiumWriter OpenMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaterialWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>height</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>height</code> property defines the height of the polygon when `perPositionHeight` is false.
        /// </summary>
        public DoubleCesiumWriter HeightWriter
        {
            get { return m_height.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>height</code> property.  The <code>height</code> property defines the height of the polygon when `perPositionHeight` is false.
        /// </summary>
        public DoubleCesiumWriter OpenHeightProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HeightWriter);
        }

        /// <summary>
        /// Writes a value for the <code>height</code> property as a <code>number</code> value.  The <code>height</code> property specifies the height of the polygon when `perPositionHeight` is false.
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
        /// Writes a value for the <code>height</code> property as a <code>number</code> value.  The <code>height</code> property specifies the height of the polygon when `perPositionHeight` is false.
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
        /// Writes a value for the <code>height</code> property as a <code>reference</code> value.  The <code>height</code> property specifies the height of the polygon when `perPositionHeight` is false.
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
        /// Writes a value for the <code>height</code> property as a <code>reference</code> value.  The <code>height</code> property specifies the height of the polygon when `perPositionHeight` is false.
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
        /// Writes a value for the <code>height</code> property as a <code>reference</code> value.  The <code>height</code> property specifies the height of the polygon when `perPositionHeight` is false.
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
        /// Writes a value for the <code>height</code> property as a <code>reference</code> value.  The <code>height</code> property specifies the height of the polygon when `perPositionHeight` is false.
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
        /// Gets the writer for the <code>extrudedHeight</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>extrudedHeight</code> property defines the extruded height of the polygon.
        /// </summary>
        public DoubleCesiumWriter ExtrudedHeightWriter
        {
            get { return m_extrudedHeight.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>extrudedHeight</code> property.  The <code>extrudedHeight</code> property defines the extruded height of the polygon.
        /// </summary>
        public DoubleCesiumWriter OpenExtrudedHeightProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ExtrudedHeightWriter);
        }

        /// <summary>
        /// Writes a value for the <code>extrudedHeight</code> property as a <code>number</code> value.  The <code>extrudedHeight</code> property specifies the extruded height of the polygon.
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
        /// Writes a value for the <code>extrudedHeight</code> property as a <code>number</code> value.  The <code>extrudedHeight</code> property specifies the extruded height of the polygon.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteExtrudedHeightProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenExtrudedHeightProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>extrudedHeight</code> property as a <code>reference</code> value.  The <code>extrudedHeight</code> property specifies the extruded height of the polygon.
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
        /// Writes a value for the <code>extrudedHeight</code> property as a <code>reference</code> value.  The <code>extrudedHeight</code> property specifies the extruded height of the polygon.
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
        /// Writes a value for the <code>extrudedHeight</code> property as a <code>reference</code> value.  The <code>extrudedHeight</code> property specifies the extruded height of the polygon.
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
        /// Writes a value for the <code>extrudedHeight</code> property as a <code>reference</code> value.  The <code>extrudedHeight</code> property specifies the extruded height of the polygon.
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
        /// Gets the writer for the <code>granularity</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>granularity</code> property defines the sampling distance, in radians.
        /// </summary>
        public DoubleCesiumWriter GranularityWriter
        {
            get { return m_granularity.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>granularity</code> property.  The <code>granularity</code> property defines the sampling distance, in radians.
        /// </summary>
        public DoubleCesiumWriter OpenGranularityProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(GranularityWriter);
        }

        /// <summary>
        /// Writes a value for the <code>granularity</code> property as a <code>number</code> value.  The <code>granularity</code> property specifies the sampling distance, in radians.
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
        /// Writes a value for the <code>granularity</code> property as a <code>number</code> value.  The <code>granularity</code> property specifies the sampling distance, in radians.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteGranularityProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenGranularityProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>granularity</code> property as a <code>reference</code> value.  The <code>granularity</code> property specifies the sampling distance, in radians.
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
        /// Writes a value for the <code>granularity</code> property as a <code>reference</code> value.  The <code>granularity</code> property specifies the sampling distance, in radians.
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
        /// Writes a value for the <code>granularity</code> property as a <code>reference</code> value.  The <code>granularity</code> property specifies the sampling distance, in radians.
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
        /// Writes a value for the <code>granularity</code> property as a <code>reference</code> value.  The <code>granularity</code> property specifies the sampling distance, in radians.
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
        /// Gets the writer for the <code>stRotation</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>stRotation</code> property defines the rotation of any applied texture. A positive rotation is counter-clockwise.
        /// </summary>
        public DoubleCesiumWriter StRotationWriter
        {
            get { return m_stRotation.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>stRotation</code> property.  The <code>stRotation</code> property defines the rotation of any applied texture. A positive rotation is counter-clockwise.
        /// </summary>
        public DoubleCesiumWriter OpenStRotationProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(StRotationWriter);
        }

        /// <summary>
        /// Writes a value for the <code>stRotation</code> property as a <code>number</code> value.  The <code>stRotation</code> property specifies the rotation of any applied texture. A positive rotation is counter-clockwise.
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
        /// Writes a value for the <code>stRotation</code> property as a <code>number</code> value.  The <code>stRotation</code> property specifies the rotation of any applied texture. A positive rotation is counter-clockwise.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteStRotationProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenStRotationProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>stRotation</code> property as a <code>reference</code> value.  The <code>stRotation</code> property specifies the rotation of any applied texture. A positive rotation is counter-clockwise.
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
        /// Writes a value for the <code>stRotation</code> property as a <code>reference</code> value.  The <code>stRotation</code> property specifies the rotation of any applied texture. A positive rotation is counter-clockwise.
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
        /// Writes a value for the <code>stRotation</code> property as a <code>reference</code> value.  The <code>stRotation</code> property specifies the rotation of any applied texture. A positive rotation is counter-clockwise.
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
        /// Writes a value for the <code>stRotation</code> property as a <code>reference</code> value.  The <code>stRotation</code> property specifies the rotation of any applied texture. A positive rotation is counter-clockwise.
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
        /// Gets the writer for the <code>fill</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>fill</code> property defines whether or not the polygon is filled.
        /// </summary>
        public BooleanCesiumWriter FillWriter
        {
            get { return m_fill.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>fill</code> property.  The <code>fill</code> property defines whether or not the polygon is filled.
        /// </summary>
        public BooleanCesiumWriter OpenFillProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(FillWriter);
        }

        /// <summary>
        /// Writes a value for the <code>fill</code> property as a <code>boolean</code> value.  The <code>fill</code> property specifies whether or not the polygon is filled.
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
        /// Writes a value for the <code>fill</code> property as a <code>reference</code> value.  The <code>fill</code> property specifies whether or not the polygon is filled.
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
        /// Writes a value for the <code>fill</code> property as a <code>reference</code> value.  The <code>fill</code> property specifies whether or not the polygon is filled.
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
        /// Writes a value for the <code>fill</code> property as a <code>reference</code> value.  The <code>fill</code> property specifies whether or not the polygon is filled.
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
        /// Writes a value for the <code>fill</code> property as a <code>reference</code> value.  The <code>fill</code> property specifies whether or not the polygon is filled.
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
        /// Gets the writer for the <code>outline</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>outline</code> property defines whether or not the polygon is outlined.
        /// </summary>
        public BooleanCesiumWriter OutlineWriter
        {
            get { return m_outline.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>outline</code> property.  The <code>outline</code> property defines whether or not the polygon is outlined.
        /// </summary>
        public BooleanCesiumWriter OpenOutlineProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineWriter);
        }

        /// <summary>
        /// Writes a value for the <code>outline</code> property as a <code>boolean</code> value.  The <code>outline</code> property specifies whether or not the polygon is outlined.
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
        /// Writes a value for the <code>outline</code> property as a <code>reference</code> value.  The <code>outline</code> property specifies whether or not the polygon is outlined.
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
        /// Writes a value for the <code>outline</code> property as a <code>reference</code> value.  The <code>outline</code> property specifies whether or not the polygon is outlined.
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
        /// Writes a value for the <code>outline</code> property as a <code>reference</code> value.  The <code>outline</code> property specifies whether or not the polygon is outlined.
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
        /// Writes a value for the <code>outline</code> property as a <code>reference</code> value.  The <code>outline</code> property specifies whether or not the polygon is outlined.
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
        /// Gets the writer for the <code>outlineColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>outlineColor</code> property defines the color of the polygon outline.
        /// </summary>
        public ColorCesiumWriter OutlineColorWriter
        {
            get { return m_outlineColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>outlineColor</code> property.  The <code>outlineColor</code> property defines the color of the polygon outline.
        /// </summary>
        public ColorCesiumWriter OpenOutlineColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the polygon outline.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the polygon outline.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the polygon outline.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteOutlineColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenOutlineColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the polygon outline.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the polygon outline.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the polygon outline.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the polygon outline.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the polygon outline.
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
        /// Gets the writer for the <code>outlineWidth</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>outlineWidth</code> property defines the width of the polygon outline.
        /// </summary>
        public DoubleCesiumWriter OutlineWidthWriter
        {
            get { return m_outlineWidth.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>outlineWidth</code> property.  The <code>outlineWidth</code> property defines the width of the polygon outline.
        /// </summary>
        public DoubleCesiumWriter OpenOutlineWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineWidthWriter);
        }

        /// <summary>
        /// Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the polygon outline.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the polygon outline.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteOutlineWidthProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenOutlineWidthProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the polygon outline.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the polygon outline.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the polygon outline.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the polygon outline.
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
        /// Gets the writer for the <code>perPositionHeight</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>perPositionHeight</code> property defines whether to use the height of each position to define the polygon or to use `height` as a constant height above the surface.
        /// </summary>
        public BooleanCesiumWriter PerPositionHeightWriter
        {
            get { return m_perPositionHeight.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>perPositionHeight</code> property.  The <code>perPositionHeight</code> property defines whether to use the height of each position to define the polygon or to use `height` as a constant height above the surface.
        /// </summary>
        public BooleanCesiumWriter OpenPerPositionHeightProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PerPositionHeightWriter);
        }

        /// <summary>
        /// Writes a value for the <code>perPositionHeight</code> property as a <code>boolean</code> value.  The <code>perPositionHeight</code> property specifies whether to use the height of each position to define the polygon or to use `height` as a constant height above the surface.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WritePerPositionHeightProperty(bool value)
        {
            using (var writer = OpenPerPositionHeightProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>perPositionHeight</code> property as a <code>reference</code> value.  The <code>perPositionHeight</code> property specifies whether to use the height of each position to define the polygon or to use `height` as a constant height above the surface.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WritePerPositionHeightPropertyReference(Reference value)
        {
            using (var writer = OpenPerPositionHeightProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>perPositionHeight</code> property as a <code>reference</code> value.  The <code>perPositionHeight</code> property specifies whether to use the height of each position to define the polygon or to use `height` as a constant height above the surface.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WritePerPositionHeightPropertyReference(string value)
        {
            using (var writer = OpenPerPositionHeightProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>perPositionHeight</code> property as a <code>reference</code> value.  The <code>perPositionHeight</code> property specifies whether to use the height of each position to define the polygon or to use `height` as a constant height above the surface.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WritePerPositionHeightPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenPerPositionHeightProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>perPositionHeight</code> property as a <code>reference</code> value.  The <code>perPositionHeight</code> property specifies whether to use the height of each position to define the polygon or to use `height` as a constant height above the surface.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WritePerPositionHeightPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenPerPositionHeightProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

    }
}
