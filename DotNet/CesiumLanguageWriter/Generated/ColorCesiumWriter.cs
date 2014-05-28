// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Color</code> to a <see cref="CesiumOutputStream" />.  A <code>Color</code> defines a a color.  The color can optionally vary over time.
    /// </summary>
    public class ColorCesiumWriter : CesiumInterpolatablePropertyWriter<ColorCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>rgba</code> property.
        /// </summary>
        public const string RgbaPropertyName = "rgba";

        /// <summary>
        /// The name of the <code>rgbaf</code> property.
        /// </summary>
        public const string RgbafPropertyName = "rgbaf";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Color>> m_asRgba;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ColorCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asRgba = new Lazy<ICesiumInterpolatableValuePropertyWriter<Color>>(CreateRgbaAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected ColorCesiumWriter(ColorCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asRgba = new Lazy<ICesiumInterpolatableValuePropertyWriter<Color>>(CreateRgbaAdaptor, false);
        }

        /// <inheritdoc />
        public override ColorCesiumWriter Clone()
        {
            return new ColorCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>rgba</code> property.  The <code>rgba</code> property specifies the color specified as an array of color components [Red, Green, Blue, Alpha] where each component is in the range 0-255. If the array has four elements, the color is constant. If it has five or more elements, they are time-tagged samples arranged as [Time, Red, Green, Blue, Alpha, Time, Red, Green, Blue, Alpha, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteRgba(Color color)
        {
            const string PropertyName = RgbaPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteRgba(Output, color);
        }

        /// <summary>
        /// Writes the <code>rgba</code> property.  The <code>rgba</code> property specifies the color specified as an array of color components [Red, Green, Blue, Alpha] where each component is in the range 0-255. If the array has four elements, the color is constant. If it has five or more elements, they are time-tagged samples arranged as [Time, Red, Green, Blue, Alpha, Time, Red, Green, Blue, Alpha, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteRgba(int red, int green, int blue, int alpha)
        {
            const string PropertyName = RgbaPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteRgba(Output, red, green, blue, alpha);
        }

        /// <summary>
        /// Writes the <code>rgba</code> property.  The <code>rgba</code> property specifies the color specified as an array of color components [Red, Green, Blue, Alpha] where each component is in the range 0-255. If the array has four elements, the color is constant. If it has five or more elements, they are time-tagged samples arranged as [Time, Red, Green, Blue, Alpha, Time, Red, Green, Blue, Alpha, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteRgba(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            const string PropertyName = RgbaPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteRgba(Output, PropertyName, dates, colors, startIndex, length);
        }

        /// <summary>
        /// Writes the <code>rgbaf</code> property.  The <code>rgbaf</code> property specifies the color specified as an array of color components [Red, Green, Blue, Alpha] where each component is in the range 0.0-1.0. If the array has four elements, the color is constant. If it has five or more elements, they are time-tagged samples arranged as [Time, Red, Green, Blue, Alpha, Time, Red, Green, Blue, Alpha, ...], where Time is an ISO 8601 date and time string or seconds since epoch.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteRgbaf(float red, float green, float blue, float alpha)
        {
            const string PropertyName = RgbafPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteRgbaf(Output, red, green, blue, alpha);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteReference(Reference value)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteReference(string value)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, value);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="id">The earliest date of the interval.</param>
        /// <param name="propertyName">The latest date of the interval.</param>
        public void WriteReference(string id, string propertyName)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, id, propertyName);
        }

        /// <summary>
        /// Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="id">The earliest date of the interval.</param>
        /// <param name="propertyNames">The latest date of the interval.</param>
        public void WriteReference(string id, string[] propertyNames)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, id, propertyNames);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>Rgba</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Color> AsRgba()
        {
            return m_asRgba.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Color> CreateRgbaAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<ColorCesiumWriter, Color>(
                this, (me, value) => me.WriteRgba(value), (ColorCesiumWriter me, IList<JulianDate> dates, IList<Color> values, int startIndex, int length) => me.WriteRgba(dates, values, startIndex, length));
        }

    }
}
