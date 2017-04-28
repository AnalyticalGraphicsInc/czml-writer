// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>PolylineDashMaterial</c> to a <see cref="CesiumOutputStream" />.  A <c>PolylineDashMaterial</c> is a material that fills the surface of a line with a pattern of dashes.
    /// </summary>
    public class PolylineDashMaterialCesiumWriter : CesiumPropertyWriter<PolylineDashMaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <c>color</c> property.
        /// </summary>
        public const string ColorPropertyName = "color";

        /// <summary>
        /// The name of the <c>gapColor</c> property.
        /// </summary>
        public const string GapColorPropertyName = "gapColor";

        /// <summary>
        /// The name of the <c>dashLength</c> property.
        /// </summary>
        public const string DashLengthPropertyName = "dashLength";

        /// <summary>
        /// The name of the <c>dashPattern</c> property.
        /// </summary>
        public const string DashPatternPropertyName = "dashPattern";

        private readonly Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(ColorPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_gapColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(GapColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_dashLength = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(DashLengthPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_dashPattern = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(DashPatternPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PolylineDashMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected PolylineDashMaterialCesiumWriter(PolylineDashMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PolylineDashMaterialCesiumWriter Clone()
        {
            return new PolylineDashMaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <c>color</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>color</c> property defines the color of the dashes on the line.
        /// </summary>
        public ColorCesiumWriter ColorWriter
        {
            get { return m_color.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>color</c> property.  The <c>color</c> property defines the color of the dashes on the line.
        /// </summary>
        public ColorCesiumWriter OpenColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColorWriter);
        }

        /// <summary>
        /// Writes a value for the <c>color</c> property as a <c>rgba</c> value.  The <c>color</c> property specifies the color of the dashes on the line.
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
        /// Writes a value for the <c>color</c> property as a <c>rgba</c> value.  The <c>color</c> property specifies the color of the dashes on the line.
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
        /// Writes a value for the <c>color</c> property as a <c>rgba</c> value.  The <c>color</c> property specifies the color of the dashes on the line.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteColorProperty(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgba(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>color</c> property as a <c>rgba</c> value.  The <c>color</c> property specifies the color of the dashes on the line.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>color</c> property as a <c>rgbaf</c> value.  The <c>color</c> property specifies the color of the dashes on the line.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteColorPropertyRgbaf(Color color)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgbaf(color);
            }
        }

        /// <summary>
        /// Writes a value for the <c>color</c> property as a <c>rgbaf</c> value.  The <c>color</c> property specifies the color of the dashes on the line.
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
        /// Writes a value for the <c>color</c> property as a <c>rgbaf</c> value.  The <c>color</c> property specifies the color of the dashes on the line.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgbaf(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>color</c> property as a <c>rgbaf</c> value.  The <c>color</c> property specifies the color of the dashes on the line.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenColorProperty())
            {
                writer.WriteRgbaf(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>color</c> property as a <c>reference</c> value.  The <c>color</c> property specifies the color of the dashes on the line.
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
        /// Writes a value for the <c>color</c> property as a <c>reference</c> value.  The <c>color</c> property specifies the color of the dashes on the line.
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
        /// Writes a value for the <c>color</c> property as a <c>reference</c> value.  The <c>color</c> property specifies the color of the dashes on the line.
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
        /// Writes a value for the <c>color</c> property as a <c>reference</c> value.  The <c>color</c> property specifies the color of the dashes on the line.
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
        /// Gets the writer for the <c>gapColor</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>gapColor</c> property defines the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        public ColorCesiumWriter GapColorWriter
        {
            get { return m_gapColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>gapColor</c> property.  The <c>gapColor</c> property defines the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        public ColorCesiumWriter OpenGapColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(GapColorWriter);
        }

        /// <summary>
        /// Writes a value for the <c>gapColor</c> property as a <c>rgba</c> value.  The <c>gapColor</c> property specifies the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteGapColorProperty(Color color)
        {
            using (var writer = OpenGapColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gapColor</c> property as a <c>rgba</c> value.  The <c>gapColor</c> property specifies the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteGapColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenGapColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gapColor</c> property as a <c>rgba</c> value.  The <c>gapColor</c> property specifies the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteGapColorProperty(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenGapColorProperty())
            {
                writer.WriteRgba(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gapColor</c> property as a <c>rgba</c> value.  The <c>gapColor</c> property specifies the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteGapColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenGapColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gapColor</c> property as a <c>rgbaf</c> value.  The <c>gapColor</c> property specifies the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteGapColorPropertyRgbaf(Color color)
        {
            using (var writer = OpenGapColorProperty())
            {
                writer.WriteRgbaf(color);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gapColor</c> property as a <c>rgbaf</c> value.  The <c>gapColor</c> property specifies the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteGapColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenGapColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gapColor</c> property as a <c>rgbaf</c> value.  The <c>gapColor</c> property specifies the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteGapColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> values)
        {
            using (var writer = OpenGapColorProperty())
            {
                writer.WriteRgbaf(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gapColor</c> property as a <c>rgbaf</c> value.  The <c>gapColor</c> property specifies the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteGapColorPropertyRgbaf(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenGapColorProperty())
            {
                writer.WriteRgbaf(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gapColor</c> property as a <c>reference</c> value.  The <c>gapColor</c> property specifies the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteGapColorPropertyReference(Reference value)
        {
            using (var writer = OpenGapColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gapColor</c> property as a <c>reference</c> value.  The <c>gapColor</c> property specifies the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteGapColorPropertyReference(string value)
        {
            using (var writer = OpenGapColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gapColor</c> property as a <c>reference</c> value.  The <c>gapColor</c> property specifies the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteGapColorPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenGapColorProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gapColor</c> property as a <c>reference</c> value.  The <c>gapColor</c> property specifies the color of the gaps between dashes on the line.  The default is transparent.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteGapColorPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenGapColorProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>dashLength</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>dashLength</c> property defines the length in screen-space pixels of a single dash and gap pattern.  If not specified, the default value is 16.
        /// </summary>
        public DoubleCesiumWriter DashLengthWriter
        {
            get { return m_dashLength.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>dashLength</c> property.  The <c>dashLength</c> property defines the length in screen-space pixels of a single dash and gap pattern.  If not specified, the default value is 16.
        /// </summary>
        public DoubleCesiumWriter OpenDashLengthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(DashLengthWriter);
        }

        /// <summary>
        /// Writes a value for the <c>dashLength</c> property as a <c>number</c> value.  The <c>dashLength</c> property specifies the length in screen-space pixels of a single dash and gap pattern.  If not specified, the default value is 16.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteDashLengthProperty(double value)
        {
            using (var writer = OpenDashLengthProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>dashLength</c> property as a <c>number</c> value.  The <c>dashLength</c> property specifies the length in screen-space pixels of a single dash and gap pattern.  If not specified, the default value is 16.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteDashLengthProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenDashLengthProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>dashLength</c> property as a <c>number</c> value.  The <c>dashLength</c> property specifies the length in screen-space pixels of a single dash and gap pattern.  If not specified, the default value is 16.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteDashLengthProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenDashLengthProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>dashLength</c> property as a <c>reference</c> value.  The <c>dashLength</c> property specifies the length in screen-space pixels of a single dash and gap pattern.  If not specified, the default value is 16.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteDashLengthPropertyReference(Reference value)
        {
            using (var writer = OpenDashLengthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>dashLength</c> property as a <c>reference</c> value.  The <c>dashLength</c> property specifies the length in screen-space pixels of a single dash and gap pattern.  If not specified, the default value is 16.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteDashLengthPropertyReference(string value)
        {
            using (var writer = OpenDashLengthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>dashLength</c> property as a <c>reference</c> value.  The <c>dashLength</c> property specifies the length in screen-space pixels of a single dash and gap pattern.  If not specified, the default value is 16.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteDashLengthPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenDashLengthProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>dashLength</c> property as a <c>reference</c> value.  The <c>dashLength</c> property specifies the length in screen-space pixels of a single dash and gap pattern.  If not specified, the default value is 16.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteDashLengthPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenDashLengthProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>dashPattern</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>dashPattern</c> property defines a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0).  The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash.  If not specified, the default value is 255.
        /// </summary>
        public DoubleCesiumWriter DashPatternWriter
        {
            get { return m_dashPattern.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>dashPattern</c> property.  The <c>dashPattern</c> property defines a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0).  The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash.  If not specified, the default value is 255.
        /// </summary>
        public DoubleCesiumWriter OpenDashPatternProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(DashPatternWriter);
        }

        /// <summary>
        /// Writes a value for the <c>dashPattern</c> property as a <c>number</c> value.  The <c>dashPattern</c> property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0).  The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash.  If not specified, the default value is 255.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteDashPatternProperty(double value)
        {
            using (var writer = OpenDashPatternProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>dashPattern</c> property as a <c>number</c> value.  The <c>dashPattern</c> property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0).  The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash.  If not specified, the default value is 255.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteDashPatternProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenDashPatternProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>dashPattern</c> property as a <c>number</c> value.  The <c>dashPattern</c> property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0).  The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash.  If not specified, the default value is 255.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteDashPatternProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenDashPatternProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>dashPattern</c> property as a <c>reference</c> value.  The <c>dashPattern</c> property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0).  The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash.  If not specified, the default value is 255.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteDashPatternPropertyReference(Reference value)
        {
            using (var writer = OpenDashPatternProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>dashPattern</c> property as a <c>reference</c> value.  The <c>dashPattern</c> property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0).  The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash.  If not specified, the default value is 255.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteDashPatternPropertyReference(string value)
        {
            using (var writer = OpenDashPatternProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>dashPattern</c> property as a <c>reference</c> value.  The <c>dashPattern</c> property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0).  The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash.  If not specified, the default value is 255.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteDashPatternPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenDashPatternProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>dashPattern</c> property as a <c>reference</c> value.  The <c>dashPattern</c> property specifies a 16-bit bitfield representing which portions along a single dashLength are the dash (1) and which are the gap (0).  The default value, 255 (0000000011111111), indicates 50% gap followed by 50% dash.  If not specified, the default value is 255.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteDashPatternPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenDashPatternProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

    }
}
