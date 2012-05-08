using System;
using System.Drawing;
#if StkComponents
using AGI.Foundation.Cesium.Advanced;
#else
using CesiumLanguageWriter.Advanced;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing cone-related properties to a
    /// <topic name="Cesium">Cesium</topic> stream.  A cone starts at a point and extends in a circle
    /// of directions which all have the same angular separation from a reference direction.  The cone may
    /// be capped at a radial limit, it may have an inner hole, and it may be only a part of a complete
    /// cone defined by clock angle limits.
    /// </summary>
    public class ConeCesiumWriter : CesiumPropertyWriter<ConeCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public static readonly string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>innerHalfAngle</code> property.
        /// </summary>
        public static readonly string InnerHalfAnglePropertyName = "innerHalfAngle";

        /// <summary>
        /// The name of the <code>outerHalfAngle</code> property.
        /// </summary>
        public static readonly string OuterHalfAnglePropertyName = "outerHalfAngle";

        /// <summary>
        /// The name of the <code>radius</code> property.
        /// </summary>
        public static readonly string RadiusPropertyName = "radius";

        /// <summary>
        /// The name of the <code>minimumClockAngle</code> property.
        /// </summary>
        public static readonly string MinimumClockAnglePropertyName = "minimumClockAngle";

        /// <summary>
        /// The name of the <code>maximumClockAngle</code> property.
        /// </summary>
        public static readonly string MaximumClockAnglePropertyName = "maximumClockAngle";

        /// <summary>
        /// The name of the <code>showIntersection</code> property.
        /// </summary>
        public static readonly string ShowIntersectionPropertyName = "showIntersection";

        /// <summary>
        /// The name of the <code>intersectionColor</code> property.
        /// </summary>
        public static readonly string IntersectionColorPropertyName = "intersectionColor";

        /// <summary>
        /// The name of the <code>erosion</code> property.
        /// </summary>
        public static readonly string ErosionPropertyName = "erosion";

        /// <summary>
        /// The name of the <code>capMaterial</code> property.
        /// </summary>
        public static readonly string CapMaterialPropertyName = "capMaterial";

        /// <summary>
        /// The name of the <code>innerMaterial</code> property.
        /// </summary>
        public static readonly string InnerMaterialPropertyName = "innerMaterial";

        /// <summary>
        /// The name of the <code>outerMaterial</code> property.
        /// </summary>
        public static readonly string OuterMaterialPropertyName = "outerMaterial";

        /// <summary>
        /// The name of the <code>silhouetteMaterial</code> property.
        /// </summary>
        public static readonly string SilhouetteMaterialPropertyName = "silhouetteMaterial";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);

        private readonly Lazy<DoubleCesiumWriter> m_innerHalfAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(InnerHalfAnglePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_outerHalfAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OuterHalfAnglePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_radius = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RadiusPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_minimumClockAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(MinimumClockAnglePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_maximumClockAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(MaximumClockAnglePropertyName), false);

        private readonly Lazy<BooleanCesiumWriter> m_showIntersection = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowIntersectionPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_intersectionColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(IntersectionColorPropertyName), false); 
        private readonly Lazy<DoubleCesiumWriter> m_erosion = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ErosionPropertyName), false);
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
        /// Gets a writer for writing the <code>show</code> property.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>show</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>show</code> property.
        /// See the documentation for the <see cref="OpenShowProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteShowProperty(bool value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets a writer for writing the <code>innerHalfAngle</code> property.
        /// </summary>
        public DoubleCesiumWriter InnerHalfAngleWriter
        {
            get { return m_innerHalfAngle.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>innerHalfAngle</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public DoubleCesiumWriter OpenInnerHalfAngleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(InnerHalfAngleWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>innerHalfAngle</code> property.
        /// See the documentation for the <see cref="OpenInnerHalfAngleProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteInnerHalfAngleProperty(double value)
        {
            using (var writer = OpenInnerHalfAngleProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets a writer for writing the <code>outerHalfAngle</code> property.
        /// </summary>
        public DoubleCesiumWriter OuterHalfAngleWriter
        {
            get { return m_outerHalfAngle.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>outerHalfAngle</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public DoubleCesiumWriter OpenOuterHalfAngleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OuterHalfAngleWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>outerHalfAngle</code> property.
        /// See the documentation for the <see cref="OpenOuterHalfAngleProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteOuterHalfAngleProperty(double value)
        {
            using (var writer = OpenOuterHalfAngleProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets a writer for writing the <code>radius</code> property.
        /// </summary>
        public DoubleCesiumWriter RadiusWriter
        {
            get { return m_radius.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>radius</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public DoubleCesiumWriter OpenRadiusProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RadiusWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>radius</code> property.
        /// See the documentation for the <see cref="OpenRadiusProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteRadiusProperty(double value)
        {
            using (var writer = OpenRadiusProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets a writer for writing the <code>minimumClockAngle</code> property.
        /// </summary>
        public DoubleCesiumWriter MinimumClockAngleWriter
        {
            get { return m_minimumClockAngle.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>minimumClockAngle</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public DoubleCesiumWriter OpenMinimumClockAngleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MinimumClockAngleWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>minimumClockAngle</code> property.
        /// See the documentation for the <see cref="OpenMinimumClockAngleProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteMinimumClockAngleProperty(double value)
        {
            using (var writer = OpenMinimumClockAngleProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets a writer for writing the <code>maximumClockAngle</code> property.
        /// </summary>
        public DoubleCesiumWriter MaximumClockAngleWriter
        {
            get { return m_maximumClockAngle.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>maximumClockAngle</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public DoubleCesiumWriter OpenMaximumClockAngleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaximumClockAngleWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>maximumClockAngle</code> property.
        /// See the documentation for the <see cref="OpenMaximumClockAngleProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteMaximumClockAngleProperty(double value)
        {
            using (var writer = OpenMaximumClockAngleProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets a writer for writing the <code>showIntersection</code> property.
        /// </summary>
        public BooleanCesiumWriter ShowIntersectionWriter
        {
            get { return m_showIntersection.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>showIntersection</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public BooleanCesiumWriter OpenShowIntersectionProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowIntersectionWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>showIntersection</code> property.
        /// See the documentation for the <see cref="OpenShowIntersectionProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteShowIntersectionProperty(bool value)
        {
            using (var writer = OpenShowIntersectionProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets a writer for writing the <code>intersectionColor</code> property.
        /// </summary>
        public ColorCesiumWriter IntersectionColorWriter
        {
            get { return m_intersectionColor.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>intersectionColor</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public ColorCesiumWriter OpenIntersectionColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(IntersectionColorWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>intersectionColor</code> property.
        /// See the documentation for the <see cref="OpenIntersectionColorProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteIntersectionColorProperty(Color value)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets a writer for writing the <code>erosion</code> property.
        /// </summary>
        public DoubleCesiumWriter ErosionWriter
        {
            get { return m_erosion.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>erosion</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public DoubleCesiumWriter OpenErosionProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ErosionWriter);
        }

        /// <summary>
        /// Writes a constant value for the <code>erosion</code> property.
        /// See the documentation for the <see cref="OpenErosionProperty"/> method for more information.
        /// </summary>
        /// <param name="value">The value of the property.</param>
        public void WriteErosionProperty(double value)
        {
            using (var writer = OpenErosionProperty())
            {
                writer.WriteValue(value);
            }
        }

        /// <summary>
        /// Gets a writer for writing the <code>capMaterial</code> property.
        /// </summary>
        public MaterialCesiumWriter CapMaterialWriter
        {
            get { return m_capMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>capMaterial</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public MaterialCesiumWriter OpenCapMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(CapMaterialWriter);
        }

        /// <summary>
        /// Gets a writer for writing the <code>innerMaterial</code> property.
        /// </summary>
        public MaterialCesiumWriter InnerMaterialWriter
        {
            get { return m_innerMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>innerMaterial</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public MaterialCesiumWriter OpenInnerMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(InnerMaterialWriter);
        }

        /// <summary>
        /// Gets a writer for writing the <code>outerMaterial</code> property.
        /// </summary>
        public MaterialCesiumWriter OuterMaterialWriter
        {
            get { return m_outerMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>outerMaterial</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public MaterialCesiumWriter OpenOuterMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OuterMaterialWriter);
        }

        /// <summary>
        /// Gets a writer for writing the <code>silhouetteMaterial</code> property.
        /// </summary>
        public MaterialCesiumWriter SilhouetteMaterialWriter
        {
            get { return m_silhouetteMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>silhouetteMaterial</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public MaterialCesiumWriter OpenSilhouetteMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SilhouetteMaterialWriter);
        }
    }
}
