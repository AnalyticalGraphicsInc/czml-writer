// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Cylinder</code> to a <see cref="CesiumOutputStream" />.  A <code>Cylinder</code> is a cylinder.
    /// </summary>
    public class CylinderCesiumWriter : CesiumPropertyWriter<CylinderCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>length</code> property.
        /// </summary>
        public const string LengthPropertyName = "length";

        /// <summary>
        /// The name of the <code>topRadius</code> property.
        /// </summary>
        public const string TopRadiusPropertyName = "topRadius";

        /// <summary>
        /// The name of the <code>bottomRadius</code> property.
        /// </summary>
        public const string BottomRadiusPropertyName = "bottomRadius";

        /// <summary>
        /// The name of the <code>fill</code> property.
        /// </summary>
        public const string FillPropertyName = "fill";

        /// <summary>
        /// The name of the <code>material</code> property.
        /// </summary>
        public const string MaterialPropertyName = "material";

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

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_length = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(LengthPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_topRadius = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(TopRadiusPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_bottomRadius = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(BottomRadiusPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_fill = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(FillPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_material = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(MaterialPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_outline = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(OutlinePropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(OutlineColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OutlineWidthPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public CylinderCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected CylinderCesiumWriter(CylinderCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override CylinderCesiumWriter Clone()
        {
            return new CylinderCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the cylinder is shown.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the cylinder is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the cylinder is shown.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the cylinder is shown.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the cylinder is shown.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the cylinder is shown.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the cylinder is shown.
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
        /// Gets the writer for the <code>length</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>length</code> property defines the length of the cylinder.
        /// </summary>
        public DoubleCesiumWriter LengthWriter
        {
            get { return m_length.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>length</code> property.  The <code>length</code> property defines the length of the cylinder.
        /// </summary>
        public DoubleCesiumWriter OpenLengthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(LengthWriter);
        }

        /// <summary>
        /// Writes a value for the <code>length</code> property as a <code>number</code> value.  The <code>length</code> property specifies the length of the cylinder.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteLengthProperty(double value)
        {
            using (var writer = OpenLengthProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>length</code> property as a <code>number</code> value.  The <code>length</code> property specifies the length of the cylinder.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteLengthProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenLengthProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>length</code> property as a <code>reference</code> value.  The <code>length</code> property specifies the length of the cylinder.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteLengthPropertyReference(Reference value)
        {
            using (var writer = OpenLengthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>length</code> property as a <code>reference</code> value.  The <code>length</code> property specifies the length of the cylinder.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteLengthPropertyReference(string value)
        {
            using (var writer = OpenLengthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>length</code> property as a <code>reference</code> value.  The <code>length</code> property specifies the length of the cylinder.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteLengthPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenLengthProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>length</code> property as a <code>reference</code> value.  The <code>length</code> property specifies the length of the cylinder.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteLengthPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenLengthProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>topRadius</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>topRadius</code> property defines the radius of the top of the cylinder.
        /// </summary>
        public DoubleCesiumWriter TopRadiusWriter
        {
            get { return m_topRadius.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>topRadius</code> property.  The <code>topRadius</code> property defines the radius of the top of the cylinder.
        /// </summary>
        public DoubleCesiumWriter OpenTopRadiusProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(TopRadiusWriter);
        }

        /// <summary>
        /// Writes a value for the <code>topRadius</code> property as a <code>number</code> value.  The <code>topRadius</code> property specifies the radius of the top of the cylinder.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteTopRadiusProperty(double value)
        {
            using (var writer = OpenTopRadiusProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>topRadius</code> property as a <code>number</code> value.  The <code>topRadius</code> property specifies the radius of the top of the cylinder.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteTopRadiusProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenTopRadiusProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>topRadius</code> property as a <code>reference</code> value.  The <code>topRadius</code> property specifies the radius of the top of the cylinder.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteTopRadiusPropertyReference(Reference value)
        {
            using (var writer = OpenTopRadiusProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>topRadius</code> property as a <code>reference</code> value.  The <code>topRadius</code> property specifies the radius of the top of the cylinder.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteTopRadiusPropertyReference(string value)
        {
            using (var writer = OpenTopRadiusProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>topRadius</code> property as a <code>reference</code> value.  The <code>topRadius</code> property specifies the radius of the top of the cylinder.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteTopRadiusPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenTopRadiusProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>topRadius</code> property as a <code>reference</code> value.  The <code>topRadius</code> property specifies the radius of the top of the cylinder.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteTopRadiusPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenTopRadiusProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>bottomRadius</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>bottomRadius</code> property defines the radius of the bottom of the cylinder.
        /// </summary>
        public DoubleCesiumWriter BottomRadiusWriter
        {
            get { return m_bottomRadius.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>bottomRadius</code> property.  The <code>bottomRadius</code> property defines the radius of the bottom of the cylinder.
        /// </summary>
        public DoubleCesiumWriter OpenBottomRadiusProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(BottomRadiusWriter);
        }

        /// <summary>
        /// Writes a value for the <code>bottomRadius</code> property as a <code>number</code> value.  The <code>bottomRadius</code> property specifies the radius of the bottom of the cylinder.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteBottomRadiusProperty(double value)
        {
            using (var writer = OpenBottomRadiusProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>bottomRadius</code> property as a <code>number</code> value.  The <code>bottomRadius</code> property specifies the radius of the bottom of the cylinder.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteBottomRadiusProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenBottomRadiusProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>bottomRadius</code> property as a <code>reference</code> value.  The <code>bottomRadius</code> property specifies the radius of the bottom of the cylinder.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteBottomRadiusPropertyReference(Reference value)
        {
            using (var writer = OpenBottomRadiusProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>bottomRadius</code> property as a <code>reference</code> value.  The <code>bottomRadius</code> property specifies the radius of the bottom of the cylinder.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteBottomRadiusPropertyReference(string value)
        {
            using (var writer = OpenBottomRadiusProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>bottomRadius</code> property as a <code>reference</code> value.  The <code>bottomRadius</code> property specifies the radius of the bottom of the cylinder.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteBottomRadiusPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenBottomRadiusProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>bottomRadius</code> property as a <code>reference</code> value.  The <code>bottomRadius</code> property specifies the radius of the bottom of the cylinder.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteBottomRadiusPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenBottomRadiusProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>fill</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>fill</code> property defines whether or not the cylinder is filled.
        /// </summary>
        public BooleanCesiumWriter FillWriter
        {
            get { return m_fill.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>fill</code> property.  The <code>fill</code> property defines whether or not the cylinder is filled.
        /// </summary>
        public BooleanCesiumWriter OpenFillProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(FillWriter);
        }

        /// <summary>
        /// Writes a value for the <code>fill</code> property as a <code>boolean</code> value.  The <code>fill</code> property specifies whether or not the cylinder is filled.
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
        /// Writes a value for the <code>fill</code> property as a <code>reference</code> value.  The <code>fill</code> property specifies whether or not the cylinder is filled.
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
        /// Writes a value for the <code>fill</code> property as a <code>reference</code> value.  The <code>fill</code> property specifies whether or not the cylinder is filled.
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
        /// Writes a value for the <code>fill</code> property as a <code>reference</code> value.  The <code>fill</code> property specifies whether or not the cylinder is filled.
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
        /// Writes a value for the <code>fill</code> property as a <code>reference</code> value.  The <code>fill</code> property specifies whether or not the cylinder is filled.
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
        /// Gets the writer for the <code>material</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>material</code> property defines the material to display on the surface of the cylinder.
        /// </summary>
        public MaterialCesiumWriter MaterialWriter
        {
            get { return m_material.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>material</code> property.  The <code>material</code> property defines the material to display on the surface of the cylinder.
        /// </summary>
        public MaterialCesiumWriter OpenMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaterialWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>outline</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>outline</code> property defines whether or not the cylinder is outlined.
        /// </summary>
        public BooleanCesiumWriter OutlineWriter
        {
            get { return m_outline.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>outline</code> property.  The <code>outline</code> property defines whether or not the cylinder is outlined.
        /// </summary>
        public BooleanCesiumWriter OpenOutlineProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineWriter);
        }

        /// <summary>
        /// Writes a value for the <code>outline</code> property as a <code>boolean</code> value.  The <code>outline</code> property specifies whether or not the cylinder is outlined.
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
        /// Writes a value for the <code>outline</code> property as a <code>reference</code> value.  The <code>outline</code> property specifies whether or not the cylinder is outlined.
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
        /// Writes a value for the <code>outline</code> property as a <code>reference</code> value.  The <code>outline</code> property specifies whether or not the cylinder is outlined.
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
        /// Writes a value for the <code>outline</code> property as a <code>reference</code> value.  The <code>outline</code> property specifies whether or not the cylinder is outlined.
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
        /// Writes a value for the <code>outline</code> property as a <code>reference</code> value.  The <code>outline</code> property specifies whether or not the cylinder is outlined.
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
        /// Gets the writer for the <code>outlineColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>outlineColor</code> property defines the color of the cylinder outline.
        /// </summary>
        public ColorCesiumWriter OutlineColorWriter
        {
            get { return m_outlineColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>outlineColor</code> property.  The <code>outlineColor</code> property defines the color of the cylinder outline.
        /// </summary>
        public ColorCesiumWriter OpenOutlineColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the cylinder outline.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the cylinder outline.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the cylinder outline.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the cylinder outline.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the cylinder outline.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the cylinder outline.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the cylinder outline.
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
        /// Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the cylinder outline.
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
        /// Gets the writer for the <code>outlineWidth</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>outlineWidth</code> property defines the width of the cylinder outline.
        /// </summary>
        public DoubleCesiumWriter OutlineWidthWriter
        {
            get { return m_outlineWidth.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>outlineWidth</code> property.  The <code>outlineWidth</code> property defines the width of the cylinder outline.
        /// </summary>
        public DoubleCesiumWriter OpenOutlineWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OutlineWidthWriter);
        }

        /// <summary>
        /// Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the cylinder outline.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the cylinder outline.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the cylinder outline.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the cylinder outline.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the cylinder outline.
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
        /// Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the cylinder outline.
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

    }
}
