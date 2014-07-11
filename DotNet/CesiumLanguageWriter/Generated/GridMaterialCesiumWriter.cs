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
        /// The name of the <code>lineCount</code> property.
        /// </summary>
        public const string LineCountPropertyName = "lineCount";

        /// <summary>
        /// The name of the <code>lineThickness</code> property.
        /// </summary>
        public const string LineThicknessPropertyName = "lineThickness";

        /// <summary>
        /// The name of the <code>lineOffset</code> property.
        /// </summary>
        public const string LineOffsetPropertyName = "lineOffset";

        private readonly Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(ColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_cellAlpha = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(CellAlphaPropertyName), false);

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
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
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
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteCellAlphaPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenCellAlphaProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Writes the <code>lineCount</code> property.  The <code>lineCount</code> property specifies the number of grid lines along each axis.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteLineCount(Rectangular value)
        {
            const string PropertyName = LineCountPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian2(Output, value);
        }

        /// <summary>
        /// Writes the <code>lineCount</code> property.  The <code>lineCount</code> property specifies the number of grid lines along each axis.
        /// </summary>
        /// <param name="x">The X component.</param>
        /// <param name="y">The Y component.</param>
        public void WriteLineCount(double x, double y)
        {
            WriteLineCount(new Rectangular(x, y));
        }

        /// <summary>
        /// Writes the <code>lineCount</code> property.  The <code>lineCount</code> property specifies the number of grid lines along each axis.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteLineCount(IList<JulianDate> dates, IList<Rectangular> values)
        {
            WriteLineCount(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>lineCount</code> property.  The <code>lineCount</code> property specifies the number of grid lines along each axis.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteLineCount(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
        {
            const string PropertyName = LineCountPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian2(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the <code>lineThickness</code> property.  The <code>lineThickness</code> property specifies the thickness of grid lines along each axis, in pixels.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteLineThickness(Rectangular value)
        {
            const string PropertyName = LineThicknessPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian2(Output, value);
        }

        /// <summary>
        /// Writes the <code>lineThickness</code> property.  The <code>lineThickness</code> property specifies the thickness of grid lines along each axis, in pixels.
        /// </summary>
        /// <param name="x">The X component.</param>
        /// <param name="y">The Y component.</param>
        public void WriteLineThickness(double x, double y)
        {
            WriteLineThickness(new Rectangular(x, y));
        }

        /// <summary>
        /// Writes the <code>lineThickness</code> property.  The <code>lineThickness</code> property specifies the thickness of grid lines along each axis, in pixels.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteLineThickness(IList<JulianDate> dates, IList<Rectangular> values)
        {
            WriteLineThickness(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>lineThickness</code> property.  The <code>lineThickness</code> property specifies the thickness of grid lines along each axis, in pixels.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteLineThickness(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
        {
            const string PropertyName = LineThicknessPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian2(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the <code>lineOffset</code> property.  The <code>lineOffset</code> property specifies the offset of grid lines along each axis, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteLineOffset(Rectangular value)
        {
            const string PropertyName = LineOffsetPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian2(Output, value);
        }

        /// <summary>
        /// Writes the <code>lineOffset</code> property.  The <code>lineOffset</code> property specifies the offset of grid lines along each axis, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="x">The X component.</param>
        /// <param name="y">The Y component.</param>
        public void WriteLineOffset(double x, double y)
        {
            WriteLineOffset(new Rectangular(x, y));
        }

        /// <summary>
        /// Writes the <code>lineOffset</code> property.  The <code>lineOffset</code> property specifies the offset of grid lines along each axis, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteLineOffset(IList<JulianDate> dates, IList<Rectangular> values)
        {
            WriteLineOffset(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>lineOffset</code> property.  The <code>lineOffset</code> property specifies the offset of grid lines along each axis, as a percentage from 0 to 1.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteLineOffset(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
        {
            const string PropertyName = LineOffsetPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian2(Output, PropertyName, dates, values, startIndex, length);
        }

    }
}
