// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>RectangleCoordinates</code> to a <see cref="CesiumOutputStream" />.  A <code>RectangleCoordinates</code> is a set of coordinates describing a cartographic rectangle on the surface of the ellipsoid.
    /// </summary>
    public class RectangleCoordinatesCesiumWriter : CesiumInterpolatablePropertyWriter<RectangleCoordinatesCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>wsenDegrees</code> property.
        /// </summary>
        public const string WsenDegreesPropertyName = "wsenDegrees";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<CartographicExtent>> m_asWsenDegrees;
        private readonly Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public RectangleCoordinatesCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asWsenDegrees = new Lazy<ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(CreateWsenDegreesAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected RectangleCoordinatesCesiumWriter(RectangleCoordinatesCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asWsenDegrees = new Lazy<ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(CreateWsenDegreesAdaptor, false);
            m_asReference = new Lazy<ICesiumValuePropertyWriter<Reference>>(CreateReferenceAdaptor, false);
        }

        /// <inheritdoc />
        public override RectangleCoordinatesCesiumWriter Clone()
        {
            return new RectangleCoordinatesCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <code>wsenDegrees</code>, which is the set of coordinates specified as Cartographic values `[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]`, with values in degrees.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteWsenDegrees(CartographicExtent value)
        {
            const string PropertyName = WsenDegreesPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartographicExtent(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <code>wsenDegrees</code>, which is the set of coordinates specified as Cartographic values `[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]`, with values in degrees.
        /// </summary>
        /// <param name="west">The westernmost longitude.</param>
        /// <param name="south">The southernmost latitude.</param>
        /// <param name="east">The easternmost longitude.</param>
        /// <param name="north">The northernmost latitude.</param>
        public void WriteWsenDegrees(double west, double south, double east, double north)
        {
            WriteWsenDegrees(new CartographicExtent(west, south, east, north));
        }

        /// <summary>
        /// Writes the value expressed as a <code>wsenDegrees</code>, which is the set of coordinates specified as Cartographic values `[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]`, with values in degrees.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteWsenDegrees(IList<JulianDate> dates, IList<CartographicExtent> values)
        {
            WriteWsenDegrees(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <code>wsenDegrees</code>, which is the set of coordinates specified as Cartographic values `[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]`, with values in degrees.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteWsenDegrees(IList<JulianDate> dates, IList<CartographicExtent> values, int startIndex, int length)
        {
            const string PropertyName = WsenDegreesPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartographicExtent(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <code>reference</code>, which is the set of coordinates specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the set of coordinates specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the set of coordinates specified as a reference to another property.
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
        /// Writes the value expressed as a <code>reference</code>, which is the set of coordinates specified as a reference to another property.
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
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>WsenDegrees</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<CartographicExtent> AsWsenDegrees()
        {
            return m_asWsenDegrees.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<CartographicExtent> CreateWsenDegreesAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<RectangleCoordinatesCesiumWriter, CartographicExtent>(this, (me, value) => me.WriteWsenDegrees(value), (me, dates, values, startIndex, length) => me.WriteWsenDegrees(dates, values, startIndex, length));
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
            return new CesiumWriterAdaptor<RectangleCoordinatesCesiumWriter, Reference>(this, (me, value) => me.WriteReference(value));
        }

    }
}
