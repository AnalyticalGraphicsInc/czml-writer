// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>AlignedAxis</code> to a <see cref="CesiumOutputStream" />.  A <code>AlignedAxis</code> defines an aligned axis which can optionally vary over time.
    /// </summary>
    public class AlignedAxisCesiumWriter : CesiumInterpolatablePropertyWriter<AlignedAxisCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>cartesian</code> property.
        /// </summary>
        public const string CartesianPropertyName = "cartesian";

        /// <summary>
        /// The name of the <code>reference</code> property.
        /// </summary>
        public const string ReferencePropertyName = "reference";

        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
        private readonly Lazy<ReferenceCesiumWriter> m_reference = new Lazy<ReferenceCesiumWriter>(() => new ReferenceCesiumWriter(ReferencePropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public AlignedAxisCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateCartesianAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected AlignedAxisCesiumWriter(AlignedAxisCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateCartesianAdaptor, false);
        }

        /// <inheritdoc />
        public override AlignedAxisCesiumWriter Clone()
        {
            return new AlignedAxisCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the axis specified as a unit Cartesian `[X, Y, Z]` in world coordinates in  meters.  If the array has three elements, the eye offset is constant.  If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteCartesian(Cartesian value)
        {
            const string PropertyName = CartesianPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian3(Output, value);
        }

        /// <summary>
        /// Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the axis specified as a unit Cartesian `[X, Y, Z]` in world coordinates in  meters.  If the array has three elements, the eye offset is constant.  If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values)
        {
            WriteCartesian(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>cartesian</code> property.  The <code>cartesian</code> property specifies the axis specified as a unit Cartesian `[X, Y, Z]` in world coordinates in  meters.  If the array has three elements, the eye offset is constant.  If it has four or more elements, they are time-tagged samples arranged as `[Time, X, Y, Z, Time, X, Y, Z, Time, X, Y, Z, ...]`, where _Time_ is an ISO 8601 date and time string or seconds since `epoch`.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            const string PropertyName = CartesianPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian3(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Gets the writer for the <code>reference</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>reference</code> property defines a reference property.
        /// </summary>
        public ReferenceCesiumWriter ReferenceWriter
        {
            get { return m_reference.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>reference</code> property.  The <code>reference</code> property defines a reference property.
        /// </summary>
        public ReferenceCesiumWriter OpenReferenceProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ReferenceWriter);
        }

        /// <summary>
        /// Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteReferenceProperty(Reference value)
        {
            using (var writer = OpenReferenceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteReferenceProperty(string value)
        {
            using (var writer = OpenReferenceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteReferenceProperty(string identifier, string propertyName)
        {
            using (var writer = OpenReferenceProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>reference</code> property as a <code>reference</code> value.  The <code>reference</code> property specifies a reference property.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The heirarchy of properties to be indexed on the referenced object.</param>
        public void WriteReferenceProperty(string identifier, string[] propertyNames)
        {
            using (var writer = OpenReferenceProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>Cartesian</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Cartesian> AsCartesian()
        {
            return m_asCartesian.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Cartesian> CreateCartesianAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<AlignedAxisCesiumWriter, Cartesian>(
                this, (me, value) => me.WriteCartesian(value), (AlignedAxisCesiumWriter me, IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length) => me.WriteCartesian(dates, values, startIndex, length));
        }

    }
}
