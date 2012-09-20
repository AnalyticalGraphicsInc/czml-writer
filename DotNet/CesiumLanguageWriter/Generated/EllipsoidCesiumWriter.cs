// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Ellipsoid</code> to a <see cref="CesiumOutputStream" />.  A <code>Ellipsoid</code> defines a closed quadric surface that is a three dimensional analogue of an ellipse.
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
        private readonly Lazy<EllipsoidRadiiCesiumWriter> m_radii = new Lazy<EllipsoidRadiiCesiumWriter>(() => new EllipsoidRadiiCesiumWriter(RadiiPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_material = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(MaterialPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public EllipsoidCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected EllipsoidCesiumWriter(EllipsoidCesiumWriter existingInstance)
            : base(existingInstance)
        {
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
        /// Gets the writer for the <code>radii</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>radii</code> property defines the dimensions of the ellipsoid.
        /// </summary>
        public EllipsoidRadiiCesiumWriter RadiiWriter
        {
            get { return m_radii.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>radii</code> property.  The <code>radii</code> property defines the dimensions of the ellipsoid.
        /// </summary>
        public EllipsoidRadiiCesiumWriter OpenRadiiProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RadiiWriter);
        }

        /// <summary>
        /// Writes a value for the <code>radii</code> property as a <code>cartesian</code> value.  The <code>radii</code> property specifies the dimensions of the ellipsoid.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRadiiProperty(Cartesian value)
        {
            using (var writer = OpenRadiiProperty())
            {
                writer.WriteCartesian(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>radii</code> property as a <code>cartesian</code> value.  The <code>radii</code> property specifies the dimensions of the ellipsoid.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteRadiiProperty(IList<JulianDate> dates, IList<Cartesian> values)
        {
            using (var writer = OpenRadiiProperty())
            {
                writer.WriteCartesian(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>radii</code> property as a <code>cartesian</code> value.  The <code>radii</code> property specifies the dimensions of the ellipsoid.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteRadiiProperty(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            using (var writer = OpenRadiiProperty())
            {
                writer.WriteCartesian(dates, values, startIndex, length);
            }
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

    }
}
