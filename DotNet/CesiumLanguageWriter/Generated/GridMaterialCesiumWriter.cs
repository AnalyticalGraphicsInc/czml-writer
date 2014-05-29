// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>GridMaterial</code> to a <see cref="CesiumOutputStream" />.  A <code>GridMaterial</code> fills the surface with a two dimensional grid.
    /// </summary>
    public class GridMaterialCesiumWriter : CesiumPropertyWriter<GridMaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>color</code> property.
        /// </summary>
        public const string ColorPropertyName = "color";

        /// <summary>
        /// The name of the <code>cellAlpha</code> property.
        /// </summary>
        public const string CellAlphaPropertyName = "cellAlpha";

        /// <summary>
        /// The name of the <code>rowCount</code> property.
        /// </summary>
        public const string RowCountPropertyName = "rowCount";

        /// <summary>
        /// The name of the <code>columnCount</code> property.
        /// </summary>
        public const string ColumnCountPropertyName = "columnCount";

        /// <summary>
        /// The name of the <code>rowThickness</code> property.
        /// </summary>
        public const string RowThicknessPropertyName = "rowThickness";

        /// <summary>
        /// The name of the <code>columnThickness</code> property.
        /// </summary>
        public const string ColumnThicknessPropertyName = "columnThickness";

        /// <summary>
        /// The name of the <code>rowOffset</code> property.
        /// </summary>
        public const string RowOffsetPropertyName = "rowOffset";

        /// <summary>
        /// The name of the <code>columnOffset</code> property.
        /// </summary>
        public const string ColumnOffsetPropertyName = "columnOffset";

        private readonly Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(ColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_cellAlpha = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(CellAlphaPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_rowCount = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RowCountPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_columnCount = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ColumnCountPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_rowThickness = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RowThicknessPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_columnThickness = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ColumnThicknessPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_rowOffset = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RowOffsetPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_columnOffset = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ColumnOffsetPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public GridMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected GridMaterialCesiumWriter(GridMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override GridMaterialCesiumWriter Clone()
        {
            return new GridMaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>color</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>color</code> property defines the color of the surface.
        /// </summary>
        public ColorCesiumWriter ColorWriter
        {
            get { return m_color.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>color</code> property.  The <code>color</code> property defines the color of the surface.
        /// </summary>
        public ColorCesiumWriter OpenColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the surface.
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
        /// Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the surface.
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
        /// Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the surface.
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
        /// Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the surface.
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
        /// Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the surface.
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
        /// Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the surface.
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
        /// Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the surface.
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
        /// Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the surface.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The heirarchy of properties to be indexed on the referenced object.</param>
        public void WriteColorPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>cellAlpha</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>cellAlpha</code> property defines alpha value for the space between grid lines.  This will be combined with the color alpha.
        /// </summary>
        public DoubleCesiumWriter CellAlphaWriter
        {
            get { return m_cellAlpha.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>cellAlpha</code> property.  The <code>cellAlpha</code> property defines alpha value for the space between grid lines.  This will be combined with the color alpha.
        /// </summary>
        public DoubleCesiumWriter OpenCellAlphaProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(CellAlphaWriter);
        }

        /// <summary>
        /// Writes a value for the <code>cellAlpha</code> property as a <code>number</code> value.  The <code>cellAlpha</code> property specifies alpha value for the space between grid lines.  This will be combined with the color alpha.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteCellAlphaProperty(double value)
        {
            using (var writer = OpenCellAlphaProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>cellAlpha</code> property as a <code>number</code> value.  The <code>cellAlpha</code> property specifies alpha value for the space between grid lines.  This will be combined with the color alpha.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteCellAlphaProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenCellAlphaProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>cellAlpha</code> property as a <code>reference</code> value.  The <code>cellAlpha</code> property specifies alpha value for the space between grid lines.  This will be combined with the color alpha.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteCellAlphaPropertyReference(Reference value)
        {
            using (var writer = OpenCellAlphaProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>cellAlpha</code> property as a <code>reference</code> value.  The <code>cellAlpha</code> property specifies alpha value for the space between grid lines.  This will be combined with the color alpha.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteCellAlphaPropertyReference(string value)
        {
            using (var writer = OpenCellAlphaProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>cellAlpha</code> property as a <code>reference</code> value.  The <code>cellAlpha</code> property specifies alpha value for the space between grid lines.  This will be combined with the color alpha.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteCellAlphaPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenCellAlphaProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>cellAlpha</code> property as a <code>reference</code> value.  The <code>cellAlpha</code> property specifies alpha value for the space between grid lines.  This will be combined with the color alpha.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The heirarchy of properties to be indexed on the referenced object.</param>
        public void WriteCellAlphaPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenCellAlphaProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>rowCount</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>rowCount</code> property defines the number of horizontal grid lines.
        /// </summary>
        public DoubleCesiumWriter RowCountWriter
        {
            get { return m_rowCount.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>rowCount</code> property.  The <code>rowCount</code> property defines the number of horizontal grid lines.
        /// </summary>
        public DoubleCesiumWriter OpenRowCountProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RowCountWriter);
        }

        /// <summary>
        /// Writes a value for the <code>rowCount</code> property as a <code>number</code> value.  The <code>rowCount</code> property specifies the number of horizontal grid lines.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRowCountProperty(double value)
        {
            using (var writer = OpenRowCountProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowCount</code> property as a <code>number</code> value.  The <code>rowCount</code> property specifies the number of horizontal grid lines.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteRowCountProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenRowCountProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowCount</code> property as a <code>reference</code> value.  The <code>rowCount</code> property specifies the number of horizontal grid lines.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteRowCountPropertyReference(Reference value)
        {
            using (var writer = OpenRowCountProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowCount</code> property as a <code>reference</code> value.  The <code>rowCount</code> property specifies the number of horizontal grid lines.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteRowCountPropertyReference(string value)
        {
            using (var writer = OpenRowCountProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowCount</code> property as a <code>reference</code> value.  The <code>rowCount</code> property specifies the number of horizontal grid lines.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteRowCountPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenRowCountProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowCount</code> property as a <code>reference</code> value.  The <code>rowCount</code> property specifies the number of horizontal grid lines.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The heirarchy of properties to be indexed on the referenced object.</param>
        public void WriteRowCountPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenRowCountProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>columnCount</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>columnCount</code> property defines the number of vertical grid lines.
        /// </summary>
        public DoubleCesiumWriter ColumnCountWriter
        {
            get { return m_columnCount.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>columnCount</code> property.  The <code>columnCount</code> property defines the number of vertical grid lines.
        /// </summary>
        public DoubleCesiumWriter OpenColumnCountProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColumnCountWriter);
        }

        /// <summary>
        /// Writes a value for the <code>columnCount</code> property as a <code>number</code> value.  The <code>columnCount</code> property specifies the number of vertical grid lines.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteColumnCountProperty(double value)
        {
            using (var writer = OpenColumnCountProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnCount</code> property as a <code>number</code> value.  The <code>columnCount</code> property specifies the number of vertical grid lines.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteColumnCountProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenColumnCountProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnCount</code> property as a <code>reference</code> value.  The <code>columnCount</code> property specifies the number of vertical grid lines.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteColumnCountPropertyReference(Reference value)
        {
            using (var writer = OpenColumnCountProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnCount</code> property as a <code>reference</code> value.  The <code>columnCount</code> property specifies the number of vertical grid lines.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteColumnCountPropertyReference(string value)
        {
            using (var writer = OpenColumnCountProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnCount</code> property as a <code>reference</code> value.  The <code>columnCount</code> property specifies the number of vertical grid lines.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteColumnCountPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenColumnCountProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnCount</code> property as a <code>reference</code> value.  The <code>columnCount</code> property specifies the number of vertical grid lines.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The heirarchy of properties to be indexed on the referenced object.</param>
        public void WriteColumnCountPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenColumnCountProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>rowThickness</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>rowThickness</code> property defines the thickness of horizontal grid lines, in pixels.
        /// </summary>
        public DoubleCesiumWriter RowThicknessWriter
        {
            get { return m_rowThickness.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>rowThickness</code> property.  The <code>rowThickness</code> property defines the thickness of horizontal grid lines, in pixels.
        /// </summary>
        public DoubleCesiumWriter OpenRowThicknessProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RowThicknessWriter);
        }

        /// <summary>
        /// Writes a value for the <code>rowThickness</code> property as a <code>number</code> value.  The <code>rowThickness</code> property specifies the thickness of horizontal grid lines, in pixels.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRowThicknessProperty(double value)
        {
            using (var writer = OpenRowThicknessProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowThickness</code> property as a <code>number</code> value.  The <code>rowThickness</code> property specifies the thickness of horizontal grid lines, in pixels.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteRowThicknessProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenRowThicknessProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowThickness</code> property as a <code>reference</code> value.  The <code>rowThickness</code> property specifies the thickness of horizontal grid lines, in pixels.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteRowThicknessPropertyReference(Reference value)
        {
            using (var writer = OpenRowThicknessProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowThickness</code> property as a <code>reference</code> value.  The <code>rowThickness</code> property specifies the thickness of horizontal grid lines, in pixels.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteRowThicknessPropertyReference(string value)
        {
            using (var writer = OpenRowThicknessProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowThickness</code> property as a <code>reference</code> value.  The <code>rowThickness</code> property specifies the thickness of horizontal grid lines, in pixels.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteRowThicknessPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenRowThicknessProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowThickness</code> property as a <code>reference</code> value.  The <code>rowThickness</code> property specifies the thickness of horizontal grid lines, in pixels.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The heirarchy of properties to be indexed on the referenced object.</param>
        public void WriteRowThicknessPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenRowThicknessProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>columnThickness</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>columnThickness</code> property defines the thickness of vertical grid lines, in pixels.
        /// </summary>
        public DoubleCesiumWriter ColumnThicknessWriter
        {
            get { return m_columnThickness.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>columnThickness</code> property.  The <code>columnThickness</code> property defines the thickness of vertical grid lines, in pixels.
        /// </summary>
        public DoubleCesiumWriter OpenColumnThicknessProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColumnThicknessWriter);
        }

        /// <summary>
        /// Writes a value for the <code>columnThickness</code> property as a <code>number</code> value.  The <code>columnThickness</code> property specifies the thickness of vertical grid lines, in pixels.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteColumnThicknessProperty(double value)
        {
            using (var writer = OpenColumnThicknessProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnThickness</code> property as a <code>number</code> value.  The <code>columnThickness</code> property specifies the thickness of vertical grid lines, in pixels.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteColumnThicknessProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenColumnThicknessProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnThickness</code> property as a <code>reference</code> value.  The <code>columnThickness</code> property specifies the thickness of vertical grid lines, in pixels.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteColumnThicknessPropertyReference(Reference value)
        {
            using (var writer = OpenColumnThicknessProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnThickness</code> property as a <code>reference</code> value.  The <code>columnThickness</code> property specifies the thickness of vertical grid lines, in pixels.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteColumnThicknessPropertyReference(string value)
        {
            using (var writer = OpenColumnThicknessProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnThickness</code> property as a <code>reference</code> value.  The <code>columnThickness</code> property specifies the thickness of vertical grid lines, in pixels.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteColumnThicknessPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenColumnThicknessProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnThickness</code> property as a <code>reference</code> value.  The <code>columnThickness</code> property specifies the thickness of vertical grid lines, in pixels.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The heirarchy of properties to be indexed on the referenced object.</param>
        public void WriteColumnThicknessPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenColumnThicknessProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>rowOffset</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>rowOffset</code> property defines the offset of horizontal grid lines, as a percentage from 0 to 1.
        /// </summary>
        public DoubleCesiumWriter RowOffsetWriter
        {
            get { return m_rowOffset.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>rowOffset</code> property.  The <code>rowOffset</code> property defines the offset of horizontal grid lines, as a percentage from 0 to 1.
        /// </summary>
        public DoubleCesiumWriter OpenRowOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RowOffsetWriter);
        }

        /// <summary>
        /// Writes a value for the <code>rowOffset</code> property as a <code>number</code> value.  The <code>rowOffset</code> property specifies the offset of horizontal grid lines, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRowOffsetProperty(double value)
        {
            using (var writer = OpenRowOffsetProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowOffset</code> property as a <code>number</code> value.  The <code>rowOffset</code> property specifies the offset of horizontal grid lines, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteRowOffsetProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenRowOffsetProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowOffset</code> property as a <code>reference</code> value.  The <code>rowOffset</code> property specifies the offset of horizontal grid lines, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteRowOffsetPropertyReference(Reference value)
        {
            using (var writer = OpenRowOffsetProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowOffset</code> property as a <code>reference</code> value.  The <code>rowOffset</code> property specifies the offset of horizontal grid lines, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteRowOffsetPropertyReference(string value)
        {
            using (var writer = OpenRowOffsetProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowOffset</code> property as a <code>reference</code> value.  The <code>rowOffset</code> property specifies the offset of horizontal grid lines, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteRowOffsetPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenRowOffsetProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>rowOffset</code> property as a <code>reference</code> value.  The <code>rowOffset</code> property specifies the offset of horizontal grid lines, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The heirarchy of properties to be indexed on the referenced object.</param>
        public void WriteRowOffsetPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenRowOffsetProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>columnOffset</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>columnOffset</code> property defines the offset of vertical grid lines, as a percentage from 0 to 1.
        /// </summary>
        public DoubleCesiumWriter ColumnOffsetWriter
        {
            get { return m_columnOffset.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>columnOffset</code> property.  The <code>columnOffset</code> property defines the offset of vertical grid lines, as a percentage from 0 to 1.
        /// </summary>
        public DoubleCesiumWriter OpenColumnOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColumnOffsetWriter);
        }

        /// <summary>
        /// Writes a value for the <code>columnOffset</code> property as a <code>number</code> value.  The <code>columnOffset</code> property specifies the offset of vertical grid lines, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteColumnOffsetProperty(double value)
        {
            using (var writer = OpenColumnOffsetProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnOffset</code> property as a <code>number</code> value.  The <code>columnOffset</code> property specifies the offset of vertical grid lines, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteColumnOffsetProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenColumnOffsetProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnOffset</code> property as a <code>reference</code> value.  The <code>columnOffset</code> property specifies the offset of vertical grid lines, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteColumnOffsetPropertyReference(Reference value)
        {
            using (var writer = OpenColumnOffsetProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnOffset</code> property as a <code>reference</code> value.  The <code>columnOffset</code> property specifies the offset of vertical grid lines, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteColumnOffsetPropertyReference(string value)
        {
            using (var writer = OpenColumnOffsetProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnOffset</code> property as a <code>reference</code> value.  The <code>columnOffset</code> property specifies the offset of vertical grid lines, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteColumnOffsetPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenColumnOffsetProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>columnOffset</code> property as a <code>reference</code> value.  The <code>columnOffset</code> property specifies the offset of vertical grid lines, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The heirarchy of properties to be indexed on the referenced object.</param>
        public void WriteColumnOffsetPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenColumnOffsetProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

    }
}
