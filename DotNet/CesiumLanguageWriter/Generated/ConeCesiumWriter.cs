// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Cone</code> to a <see cref="CesiumOutputStream" />.  A <code>Cone</code> a cone.  A cone starts at a point or apex and extends in a circle of directions which all have the same angular separation from the Z-axis of the object to which the cone is attached.  The cone may be capped at a radial limit, it may have an inner hole, and it may be only a part of a complete cone defined by clock angle limits.
    /// </summary>
    public class ConeCesiumWriter : CesiumPropertyWriter<ConeCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>innerHalfAngle</code> property.
        /// </summary>
        public const string InnerHalfAnglePropertyName = "innerHalfAngle";

        /// <summary>
        /// The name of the <code>outerHalfAngle</code> property.
        /// </summary>
        public const string OuterHalfAnglePropertyName = "outerHalfAngle";

        /// <summary>
        /// The name of the <code>radius</code> property.
        /// </summary>
        public const string RadiusPropertyName = "radius";

        /// <summary>
        /// The name of the <code>minimumClockAngle</code> property.
        /// </summary>
        public const string MinimumClockAnglePropertyName = "minimumClockAngle";

        /// <summary>
        /// The name of the <code>maximumClockAngle</code> property.
        /// </summary>
        public const string MaximumClockAnglePropertyName = "maximumClockAngle";

        /// <summary>
        /// The name of the <code>showIntersection</code> property.
        /// </summary>
        public const string ShowIntersectionPropertyName = "showIntersection";

        /// <summary>
        /// The name of the <code>intersectionColor</code> property.
        /// </summary>
        public const string IntersectionColorPropertyName = "intersectionColor";

        /// <summary>
        /// The name of the <code>intersectionWidth</code> property.
        /// </summary>
        public const string IntersectionWidthPropertyName = "intersectionWidth";

        /// <summary>
        /// The name of the <code>capMaterial</code> property.
        /// </summary>
        public const string CapMaterialPropertyName = "capMaterial";

        /// <summary>
        /// The name of the <code>innerMaterial</code> property.
        /// </summary>
        public const string InnerMaterialPropertyName = "innerMaterial";

        /// <summary>
        /// The name of the <code>outerMaterial</code> property.
        /// </summary>
        public const string OuterMaterialPropertyName = "outerMaterial";

        /// <summary>
        /// The name of the <code>silhouetteMaterial</code> property.
        /// </summary>
        public const string SilhouetteMaterialPropertyName = "silhouetteMaterial";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_innerHalfAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(InnerHalfAnglePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_outerHalfAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OuterHalfAnglePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_radius = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RadiusPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_minimumClockAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(MinimumClockAnglePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_maximumClockAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(MaximumClockAnglePropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_showIntersection = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowIntersectionPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_intersectionColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(IntersectionColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_intersectionWidth = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(IntersectionWidthPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_capMaterial = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(CapMaterialPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_innerMaterial = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(InnerMaterialPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_outerMaterial = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(OuterMaterialPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_silhouetteMaterial = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(SilhouetteMaterialPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ConeCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected ConeCesiumWriter(ConeCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override ConeCesiumWriter Clone()
        {
            return new ConeCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the cone is shown.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the cone is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the cone is shown.
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
        /// Gets the writer for the <code>innerHalfAngle</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>innerHalfAngle</code> property defines the inner half angle of the cone.
        /// </summary>
        public DoubleCesiumWriter InnerHalfAngleWriter
        {
            get { return m_innerHalfAngle.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>innerHalfAngle</code> property.  The <code>innerHalfAngle</code> property defines the inner half angle of the cone.
        /// </summary>
        public DoubleCesiumWriter OpenInnerHalfAngleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(InnerHalfAngleWriter);
        }

        /// <summary>
        /// Writes a value for the <code>innerHalfAngle</code> property as a <code>number</code> value.  The <code>innerHalfAngle</code> property specifies the inner half angle of the cone.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteInnerHalfAngleProperty(double value)
        {
            using (var writer = OpenInnerHalfAngleProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>innerHalfAngle</code> property as a <code>number</code> value.  The <code>innerHalfAngle</code> property specifies the inner half angle of the cone.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteInnerHalfAngleProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenInnerHalfAngleProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>outerHalfAngle</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>outerHalfAngle</code> property defines the outer half angle of the cone.
        /// </summary>
        public DoubleCesiumWriter OuterHalfAngleWriter
        {
            get { return m_outerHalfAngle.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>outerHalfAngle</code> property.  The <code>outerHalfAngle</code> property defines the outer half angle of the cone.
        /// </summary>
        public DoubleCesiumWriter OpenOuterHalfAngleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OuterHalfAngleWriter);
        }

        /// <summary>
        /// Writes a value for the <code>outerHalfAngle</code> property as a <code>number</code> value.  The <code>outerHalfAngle</code> property specifies the outer half angle of the cone.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteOuterHalfAngleProperty(double value)
        {
            using (var writer = OpenOuterHalfAngleProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>outerHalfAngle</code> property as a <code>number</code> value.  The <code>outerHalfAngle</code> property specifies the outer half angle of the cone.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteOuterHalfAngleProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenOuterHalfAngleProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>radius</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>radius</code> property defines the radial limit of the cone.
        /// </summary>
        public DoubleCesiumWriter RadiusWriter
        {
            get { return m_radius.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>radius</code> property.  The <code>radius</code> property defines the radial limit of the cone.
        /// </summary>
        public DoubleCesiumWriter OpenRadiusProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RadiusWriter);
        }

        /// <summary>
        /// Writes a value for the <code>radius</code> property as a <code>number</code> value.  The <code>radius</code> property specifies the radial limit of the cone.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRadiusProperty(double value)
        {
            using (var writer = OpenRadiusProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>radius</code> property as a <code>number</code> value.  The <code>radius</code> property specifies the radial limit of the cone.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteRadiusProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenRadiusProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>minimumClockAngle</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>minimumClockAngle</code> property defines the minimum clock angle limit of the cone.
        /// </summary>
        public DoubleCesiumWriter MinimumClockAngleWriter
        {
            get { return m_minimumClockAngle.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>minimumClockAngle</code> property.  The <code>minimumClockAngle</code> property defines the minimum clock angle limit of the cone.
        /// </summary>
        public DoubleCesiumWriter OpenMinimumClockAngleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MinimumClockAngleWriter);
        }

        /// <summary>
        /// Writes a value for the <code>minimumClockAngle</code> property as a <code>number</code> value.  The <code>minimumClockAngle</code> property specifies the minimum clock angle limit of the cone.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteMinimumClockAngleProperty(double value)
        {
            using (var writer = OpenMinimumClockAngleProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>minimumClockAngle</code> property as a <code>number</code> value.  The <code>minimumClockAngle</code> property specifies the minimum clock angle limit of the cone.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteMinimumClockAngleProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenMinimumClockAngleProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>maximumClockAngle</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>maximumClockAngle</code> property defines the maximum clock angle limit of the cone.
        /// </summary>
        public DoubleCesiumWriter MaximumClockAngleWriter
        {
            get { return m_maximumClockAngle.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>maximumClockAngle</code> property.  The <code>maximumClockAngle</code> property defines the maximum clock angle limit of the cone.
        /// </summary>
        public DoubleCesiumWriter OpenMaximumClockAngleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaximumClockAngleWriter);
        }

        /// <summary>
        /// Writes a value for the <code>maximumClockAngle</code> property as a <code>number</code> value.  The <code>maximumClockAngle</code> property specifies the maximum clock angle limit of the cone.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteMaximumClockAngleProperty(double value)
        {
            using (var writer = OpenMaximumClockAngleProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>maximumClockAngle</code> property as a <code>number</code> value.  The <code>maximumClockAngle</code> property specifies the maximum clock angle limit of the cone.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteMaximumClockAngleProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenMaximumClockAngleProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>showIntersection</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>showIntersection</code> property defines whether or not the intersection of the cone with the Earth is shown.
        /// </summary>
        public BooleanCesiumWriter ShowIntersectionWriter
        {
            get { return m_showIntersection.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>showIntersection</code> property.  The <code>showIntersection</code> property defines whether or not the intersection of the cone with the Earth is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowIntersectionProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowIntersectionWriter);
        }

        /// <summary>
        /// Writes a value for the <code>showIntersection</code> property as a <code>boolean</code> value.  The <code>showIntersection</code> property specifies whether or not the intersection of the cone with the Earth is shown.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowIntersectionProperty(bool value)
        {
            using (var writer = OpenShowIntersectionProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>intersectionColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>intersectionColor</code> property defines the color of the intersection of the cone with the Earth.
        /// </summary>
        public ColorCesiumWriter IntersectionColorWriter
        {
            get { return m_intersectionColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>intersectionColor</code> property.  The <code>intersectionColor</code> property defines the color of the intersection of the cone with the Earth.
        /// </summary>
        public ColorCesiumWriter OpenIntersectionColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(IntersectionColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>intersectionColor</code> property as a <code>rgba</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the cone with the Earth.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteIntersectionColorProperty(Color color)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionColor</code> property as a <code>rgba</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the cone with the Earth.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteIntersectionColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionColor</code> property as a <code>rgba</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the cone with the Earth.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteIntersectionColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionColor</code> property as a <code>rgbaf</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the cone with the Earth.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteIntersectionColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>intersectionWidth</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>intersectionWidth</code> property defines the width of the intersection in pixels.
        /// </summary>
        public DoubleCesiumWriter IntersectionWidthWriter
        {
            get { return m_intersectionWidth.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>intersectionWidth</code> property.  The <code>intersectionWidth</code> property defines the width of the intersection in pixels.
        /// </summary>
        public DoubleCesiumWriter OpenIntersectionWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(IntersectionWidthWriter);
        }

        /// <summary>
        /// Writes a value for the <code>intersectionWidth</code> property as a <code>number</code> value.  The <code>intersectionWidth</code> property specifies the width of the intersection in pixels.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteIntersectionWidthProperty(double value)
        {
            using (var writer = OpenIntersectionWidthProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionWidth</code> property as a <code>number</code> value.  The <code>intersectionWidth</code> property specifies the width of the intersection in pixels.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteIntersectionWidthProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenIntersectionWidthProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>capMaterial</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>capMaterial</code> property defines the material to use to cap the cone at its radial limit.
        /// </summary>
        public MaterialCesiumWriter CapMaterialWriter
        {
            get { return m_capMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>capMaterial</code> property.  The <code>capMaterial</code> property defines the material to use to cap the cone at its radial limit.
        /// </summary>
        public MaterialCesiumWriter OpenCapMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(CapMaterialWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>innerMaterial</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>innerMaterial</code> property defines the material to use for the inner cone.
        /// </summary>
        public MaterialCesiumWriter InnerMaterialWriter
        {
            get { return m_innerMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>innerMaterial</code> property.  The <code>innerMaterial</code> property defines the material to use for the inner cone.
        /// </summary>
        public MaterialCesiumWriter OpenInnerMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(InnerMaterialWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>outerMaterial</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>outerMaterial</code> property defines the material to use for the outer cone.
        /// </summary>
        public MaterialCesiumWriter OuterMaterialWriter
        {
            get { return m_outerMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>outerMaterial</code> property.  The <code>outerMaterial</code> property defines the material to use for the outer cone.
        /// </summary>
        public MaterialCesiumWriter OpenOuterMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OuterMaterialWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>silhouetteMaterial</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>silhouetteMaterial</code> property defines the material to use for the cone's silhouette.
        /// </summary>
        public MaterialCesiumWriter SilhouetteMaterialWriter
        {
            get { return m_silhouetteMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>silhouetteMaterial</code> property.  The <code>silhouetteMaterial</code> property defines the material to use for the cone's silhouette.
        /// </summary>
        public MaterialCesiumWriter OpenSilhouetteMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SilhouetteMaterialWriter);
        }

    }
}
