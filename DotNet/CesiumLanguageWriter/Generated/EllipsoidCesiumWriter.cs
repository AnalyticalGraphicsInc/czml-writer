// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Ellipsoid</code> to a <see cref="CesiumOutputStream" />.  A <code>Ellipsoid</code> an ellipsoid, which is a closed quadric surface that is a three dimensional analogue of an ellipse.
    /// </summary>
    public class EllipsoidCesiumWriter : CesiumPropertyWriter<EllipsoidCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>radii</code> property.
        /// </summary>
        public const string RadiiPropertyName = "radii";

        /// <summary>
        /// The name of the <code>material</code> property.
        /// </summary>
        public const string MaterialPropertyName = "material";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asRadii;
        private readonly Lazy<MaterialCesiumWriter> m_material = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(MaterialPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public EllipsoidCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asRadii = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateRadiiAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected EllipsoidCesiumWriter(EllipsoidCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asRadii = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateRadiiAdaptor, false);
        }

        /// <inheritdoc />
        public override EllipsoidCesiumWriter Clone()
        {
            return new EllipsoidCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the ellipsoid is shown.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the ellipsoid is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the ellipsoid is shown.
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
        /// Writes the <code>radii</code> property.  The <code>radii</code> property specifies the dimensions of the ellipsoid.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRadii(Cartesian value)
        {
            const string PropertyName = RadiiPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian3(Output, value);
        }

        /// <summary>
        /// Writes the <code>radii</code> property.  The <code>radii</code> property specifies the dimensions of the ellipsoid.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteRadii(IList<JulianDate> dates, IList<Cartesian> values)
        {
            WriteRadii(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>radii</code> property.  The <code>radii</code> property specifies the dimensions of the ellipsoid.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteRadii(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            const string PropertyName = RadiiPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian3(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Gets the writer for the <code>material</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>material</code> property defines the material to display on the surface of the ellipsoid.
        /// </summary>
        public MaterialCesiumWriter MaterialWriter
        {
            get { return m_material.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>material</code> property.  The <code>material</code> property defines the material to display on the surface of the ellipsoid.
        /// </summary>
        public MaterialCesiumWriter OpenMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaterialWriter);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>Radii</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Cartesian> AsRadii()
        {
            return m_asRadii.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Cartesian> CreateRadiiAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<EllipsoidCesiumWriter, Cartesian>(
                this, (me, value) => me.WriteRadii(value), (EllipsoidCesiumWriter me, IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length) => me.WriteRadii(dates, values, startIndex, length));
        }

    }
}
