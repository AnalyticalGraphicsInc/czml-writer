using System;
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
        private readonly Lazy<DoubleCesiumWriter> m_innerHalfAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter("innerHalfAngle"), false);
        private readonly Lazy<DoubleCesiumWriter> m_outerHalfAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter("outerHalfAngle"), false);
        private readonly Lazy<DoubleCesiumWriter> m_radius = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter("radius"), false);
        private readonly Lazy<DoubleCesiumWriter> m_minimumClockAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter("minimumClockAngle"), false);
        private readonly Lazy<DoubleCesiumWriter> m_maximumClockAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter("maximumClockAngle"), false);

        private readonly Lazy<MaterialCesiumWriter> m_capMaterial = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter("capMaterial"), false);
        private readonly Lazy<MaterialCesiumWriter> m_innerMaterial = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter("innerMaterial"), false);
        private readonly Lazy<MaterialCesiumWriter> m_outerMaterial = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter("outerMaterial"), false);
        private readonly Lazy<MaterialCesiumWriter> m_silhouetteMaterial = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter("silhouetteMaterial"), false);

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
