// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>StripeMaterial</code> to a <see cref="CesiumOutputStream" />.  A <code>StripeMaterial</code> fills the surface with alternating colors.
    /// </summary>
    public class StripeMaterialCesiumWriter : CesiumPropertyWriter<StripeMaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>orientation</code> property.
        /// </summary>
        public const string OrientationPropertyName = "orientation";

        /// <summary>
        /// The name of the <code>evenColor</code> property.
        /// </summary>
        public const string EvenColorPropertyName = "evenColor";

        /// <summary>
        /// The name of the <code>oddColor</code> property.
        /// </summary>
        public const string OddColorPropertyName = "oddColor";

        /// <summary>
        /// The name of the <code>offset</code> property.
        /// </summary>
        public const string OffsetPropertyName = "offset";

        /// <summary>
        /// The name of the <code>repeat</code> property.
        /// </summary>
        public const string RepeatPropertyName = "repeat";

        private readonly Lazy<StripeOrientationCesiumWriter> m_orientation = new Lazy<StripeOrientationCesiumWriter>(() => new StripeOrientationCesiumWriter(OrientationPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_evenColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(EvenColorPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_oddColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(OddColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_offset = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OffsetPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_repeat = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RepeatPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public StripeMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected StripeMaterialCesiumWriter(StripeMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override StripeMaterialCesiumWriter Clone()
        {
            return new StripeMaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>orientation</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>orientation</code> property defines the value indicating if the stripes are horizontal or vertical.
        /// </summary>
        public StripeOrientationCesiumWriter OrientationWriter
        {
            get { return m_orientation.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>orientation</code> property.  The <code>orientation</code> property defines the value indicating if the stripes are horizontal or vertical.
        /// </summary>
        public StripeOrientationCesiumWriter OpenOrientationProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OrientationWriter);
        }

        /// <summary>
        /// Writes a value for the <code>orientation</code> property as a <code>StripeOrientation</code> value.  The <code>orientation</code> property specifies the value indicating if the stripes are horizontal or vertical.
        /// </summary>
        /// <param name="value">The orientation.</param>
        public void WriteOrientationProperty(CesiumStripeOrientation value)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteStripeOrientation(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>evenColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>evenColor</code> property defines the even color.
        /// </summary>
        public ColorCesiumWriter EvenColorWriter
        {
            get { return m_evenColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>evenColor</code> property.  The <code>evenColor</code> property defines the even color.
        /// </summary>
        public ColorCesiumWriter OpenEvenColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EvenColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>evenColor</code> property as a <code>rgba</code> value.  The <code>evenColor</code> property specifies the even color.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteEvenColorProperty(Color color)
        {
            using (var writer = OpenEvenColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <code>evenColor</code> property as a <code>rgba</code> value.  The <code>evenColor</code> property specifies the even color.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteEvenColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenEvenColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>evenColor</code> property as a <code>rgba</code> value.  The <code>evenColor</code> property specifies the even color.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteEvenColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenEvenColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>evenColor</code> property as a <code>rgbaf</code> value.  The <code>evenColor</code> property specifies the even color.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteEvenColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenEvenColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>oddColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>oddColor</code> property defines the odd color.
        /// </summary>
        public ColorCesiumWriter OddColorWriter
        {
            get { return m_oddColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>oddColor</code> property.  The <code>oddColor</code> property defines the odd color.
        /// </summary>
        public ColorCesiumWriter OpenOddColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OddColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>oddColor</code> property as a <code>rgba</code> value.  The <code>oddColor</code> property specifies the odd color.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteOddColorProperty(Color color)
        {
            using (var writer = OpenOddColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <code>oddColor</code> property as a <code>rgba</code> value.  The <code>oddColor</code> property specifies the odd color.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteOddColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenOddColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>oddColor</code> property as a <code>rgba</code> value.  The <code>oddColor</code> property specifies the odd color.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteOddColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenOddColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>oddColor</code> property as a <code>rgbaf</code> value.  The <code>oddColor</code> property specifies the odd color.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteOddColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenOddColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>offset</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>offset</code> property defines the value indicating where in the pattern to begin drawing; with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between.
        /// </summary>
        public DoubleCesiumWriter OffsetWriter
        {
            get { return m_offset.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>offset</code> property.  The <code>offset</code> property defines the value indicating where in the pattern to begin drawing; with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between.
        /// </summary>
        public DoubleCesiumWriter OpenOffsetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OffsetWriter);
        }

        /// <summary>
        /// Writes a value for the <code>offset</code> property as a <code>number</code> value.  The <code>offset</code> property specifies the value indicating where in the pattern to begin drawing; with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteOffsetProperty(double value)
        {
            using (var writer = OpenOffsetProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>offset</code> property as a <code>number</code> value.  The <code>offset</code> property specifies the value indicating where in the pattern to begin drawing; with 0.0 being the beginning of the even color, 1.0 the beginning of the odd color, 2.0 being the even color again, and any multiple or fractional values being in between.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteOffsetProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenOffsetProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>repeat</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>repeat</code> property defines the number of time the stripes repeat.
        /// </summary>
        public DoubleCesiumWriter RepeatWriter
        {
            get { return m_repeat.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>repeat</code> property.  The <code>repeat</code> property defines the number of time the stripes repeat.
        /// </summary>
        public DoubleCesiumWriter OpenRepeatProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RepeatWriter);
        }

        /// <summary>
        /// Writes a value for the <code>repeat</code> property as a <code>number</code> value.  The <code>repeat</code> property specifies the number of time the stripes repeat.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRepeatProperty(double value)
        {
            using (var writer = OpenRepeatProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>repeat</code> property as a <code>number</code> value.  The <code>repeat</code> property specifies the number of time the stripes repeat.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteRepeatProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenRepeatProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

    }
}
