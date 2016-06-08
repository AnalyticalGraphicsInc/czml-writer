// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Color</code> to a <see cref="CesiumOutputStream" />.  A <code>Color</code> is a color.  The color can optionally vary over time.
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
        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ColorCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asRgba = new Lazy<ICesiumInterpolatableValuePropertyWriter<Color>>(CreateRgbaAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected ColorCesiumWriter(ColorCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asRgba = new Lazy<ICesiumInterpolatableValuePropertyWriter<Color>>(CreateRgbaAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <inheritdoc />
        public override ColorCesiumWriter Clone()
        {
            return new ColorCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <code>rgba</code>, which is the color specified as an array of color components [Red, Green, Blue, Alpha] where each component is an integer in the range 0-255.
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
        /// Writes the value expressed as a <code>rgba</code>, which is the color specified as an array of color components [Red, Green, Blue, Alpha] where each component is an integer in the range 0-255.
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
        /// Writes the value expressed as a <code>rgba</code>, which is the color specified as an array of color components [Red, Green, Blue, Alpha] where each component is an integer in the range 0-255.
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
        /// Writes the value expressed as a <code>rgbaf</code>, which is the color specified as an array of color components [Red, Green, Blue, Alpha] where each component is a double in the range 0.0-1.0.
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
        /// Writes the value expressed as a <code>reference</code>, which is the color specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the color specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the color specified as a reference to another property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteReference(string identifier, string propertyName)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, identifier, propertyName);
        }

        /// <summary>
        /// Writes the value expressed as a <code>reference</code>, which is the color specified as a reference to another property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteReference(string identifier, string[] propertyNames)
        {
            const string PropertyName = ReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteReference(Output, identifier, propertyNames);
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
            return new CesiumInterpolatableWriterAdaptor<ColorCesiumWriter, Color>(this, (me, value) => me.WriteRgba(value), (me, dates, values, startIndex, length) => me.WriteRgba(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <code>Reference</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<Reference> AsReference()
        {
            return m_asReference.Value;
        }

        private ICesiumValuePropertyWriter<Reference> CreateReferenceAdaptor()
        {
            return new CesiumWriterAdaptor<ColorCesiumWriter, Reference>(this, (me, value) => me.WriteReference(value));
        }

    }
}
