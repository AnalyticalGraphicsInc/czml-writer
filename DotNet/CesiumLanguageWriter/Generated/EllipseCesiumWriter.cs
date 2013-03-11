// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Ellipse</code> to a <see cref="CesiumOutputStream" />.  A <code>Ellipse</code> defines an ellipse, which is a closed curve on the surface of the Earth
    /// </summary>
    public class EllipseCesiumWriter : CesiumPropertyWriter<EllipseCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

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

        /// <summary>
        /// The name of the <code>color</code> property.
        /// </summary>
        public const string ColorPropertyName = "color";

        /// <summary>
        /// The name of the <code>material</code> property.
        /// </summary>
        public const string MaterialPropertyName = "material";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_semiMajorAxis = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(SemiMajorAxisPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_semiMinorAxis = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(SemiMinorAxisPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_bearing = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(BearingPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_color = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(ColorPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_material = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(MaterialPropertyName), false);

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
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the ellipse is shown.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the ellipse is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the ellipse is shown.
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

        /// <summary>
        /// Gets the writer for the <code>color</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>color</code> property defines the color of the outer line of the ellipse.
        /// </summary>
        public ColorCesiumWriter ColorWriter
        {
            get { return m_color.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>color</code> property.  The <code>color</code> property defines the color of the outer line of the ellipse.
        /// </summary>
        public ColorCesiumWriter OpenColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the outer line of the ellipse.
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
        /// Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the outer line of the ellipse.
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
        /// Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the outer line of the ellipse.
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
        /// Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the outer line of the ellipse.
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
        /// Gets the writer for the <code>material</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>material</code> property defines the material to display in the ellipse.
        /// </summary>
        public MaterialCesiumWriter MaterialWriter
        {
            get { return m_material.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>material</code> property.  The <code>material</code> property defines the material to display in the ellipse.
        /// </summary>
        public MaterialCesiumWriter OpenMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaterialWriter);
        }

    }
}
