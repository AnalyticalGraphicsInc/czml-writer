// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Ellipse</code> to a <see cref="CesiumOutputStream" />.  A <code>Ellipse</code> defines an ellipse, which is a closed curve on the surface of the Earth
    /// </summary>
    public class EllipseCesiumWriter : CesiumPropertyWriter<EllipseCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>semiMajorAxis</code> property.
        /// </summary>
        public const string SemiMajorAxisPropertyName = "semiMajorAxis";

        /// <summary>
        /// The name of the <code>semiMinorAxis</code> property.
        /// </summary>
        public const string SemiMinorAxisPropertyName = "semiMinorAxis";

        /// <summary>
        /// The name of the <code>bearing</code> property.
        /// </summary>
        public const string BearingPropertyName = "bearing";

        private readonly Lazy<DoubleCesiumWriter> m_semiMajorAxis = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(SemiMajorAxisPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_semiMinorAxis = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(SemiMinorAxisPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_bearing = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(BearingPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public EllipseCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected EllipseCesiumWriter(EllipseCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override EllipseCesiumWriter Clone()
        {
            return new EllipseCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>semiMajorAxis</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>semiMajorAxis</code> property defines the length of the ellipse's semi-major axis in meters.
        /// </summary>
        public DoubleCesiumWriter SemiMajorAxisWriter
        {
            get { return m_semiMajorAxis.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>semiMajorAxis</code> property.  The <code>semiMajorAxis</code> property defines the length of the ellipse's semi-major axis in meters.
        /// </summary>
        public DoubleCesiumWriter OpenSemiMajorAxisProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SemiMajorAxisWriter);
        }

        /// <summary>
        /// Writes a value for the <code>semiMajorAxis</code> property as a <code>number</code> value.  The <code>semiMajorAxis</code> property specifies the length of the ellipse's semi-major axis in meters.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteSemiMajorAxisProperty(double value)
        {
            using (var writer = OpenSemiMajorAxisProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>semiMajorAxis</code> property as a <code>number</code> value.  The <code>semiMajorAxis</code> property specifies the length of the ellipse's semi-major axis in meters.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteSemiMajorAxisProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenSemiMajorAxisProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>semiMinorAxis</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>semiMinorAxis</code> property defines the length of the ellipse's semi-minor axis in meters.
        /// </summary>
        public DoubleCesiumWriter SemiMinorAxisWriter
        {
            get { return m_semiMinorAxis.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>semiMinorAxis</code> property.  The <code>semiMinorAxis</code> property defines the length of the ellipse's semi-minor axis in meters.
        /// </summary>
        public DoubleCesiumWriter OpenSemiMinorAxisProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SemiMinorAxisWriter);
        }

        /// <summary>
        /// Writes a value for the <code>semiMinorAxis</code> property as a <code>number</code> value.  The <code>semiMinorAxis</code> property specifies the length of the ellipse's semi-minor axis in meters.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteSemiMinorAxisProperty(double value)
        {
            using (var writer = OpenSemiMinorAxisProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>semiMinorAxis</code> property as a <code>number</code> value.  The <code>semiMinorAxis</code> property specifies the length of the ellipse's semi-minor axis in meters.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteSemiMinorAxisProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenSemiMinorAxisProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>bearing</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>bearing</code> property defines the angle from north (clockwise) in radians.
        /// </summary>
        public DoubleCesiumWriter BearingWriter
        {
            get { return m_bearing.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>bearing</code> property.  The <code>bearing</code> property defines the angle from north (clockwise) in radians.
        /// </summary>
        public DoubleCesiumWriter OpenBearingProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(BearingWriter);
        }

        /// <summary>
        /// Writes a value for the <code>bearing</code> property as a <code>number</code> value.  The <code>bearing</code> property specifies the angle from north (clockwise) in radians.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteBearingProperty(double value)
        {
            using (var writer = OpenBearingProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>bearing</code> property as a <code>number</code> value.  The <code>bearing</code> property specifies the angle from north (clockwise) in radians.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteBearingProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenBearingProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

    }
}
