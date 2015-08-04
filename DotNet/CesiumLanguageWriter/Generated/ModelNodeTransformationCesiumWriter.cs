// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>ModelNodeTransformation</code> to a <see cref="CesiumOutputStream" />.  A <code>ModelNodeTransformation</code> direct manipulaton of a particular node in a 3D model.
    /// </summary>
    public class ModelNodeTransformationCesiumWriter : CesiumInterpolatablePropertyWriter<ModelNodeTransformationCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>scale</code> property.
        /// </summary>
        public const string ScalePropertyName = "scale";

        /// <summary>
        /// The name of the <code>translation</code> property.
        /// </summary>
        public const string TranslationPropertyName = "translation";

        /// <summary>
        /// The name of the <code>rotation</code> property.
        /// </summary>
        public const string RotationPropertyName = "rotation";

        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asScale;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asTranslation;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>> m_asRotation;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ModelNodeTransformationCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asScale = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateScaleAdaptor, false);
            m_asTranslation = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateTranslationAdaptor, false);
            m_asRotation = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(CreateRotationAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected ModelNodeTransformationCesiumWriter(ModelNodeTransformationCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asScale = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateScaleAdaptor, false);
            m_asTranslation = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateTranslationAdaptor, false);
            m_asRotation = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(CreateRotationAdaptor, false);
        }

        /// <inheritdoc />
        public override ModelNodeTransformationCesiumWriter Clone()
        {
            return new ModelNodeTransformationCesiumWriter(this);
        }

        /// <summary>
        /// Writes the <code>scale</code> property.  The <code>scale</code> property specifies the scaling applied to the model node.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteScale(Cartesian value)
        {
            const string PropertyName = ScalePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian3(Output, value);
        }

        /// <summary>
        /// Writes the <code>scale</code> property.  The <code>scale</code> property specifies the scaling applied to the model node.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteScale(IList<JulianDate> dates, IList<Cartesian> values)
        {
            WriteScale(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>scale</code> property.  The <code>scale</code> property specifies the scaling applied to the model node.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteScale(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            const string PropertyName = ScalePropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian3(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the <code>translation</code> property.  The <code>translation</code> property specifies the translation applied to the model node.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteTranslation(Cartesian value)
        {
            const string PropertyName = TranslationPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian3(Output, value);
        }

        /// <summary>
        /// Writes the <code>translation</code> property.  The <code>translation</code> property specifies the translation applied to the model node.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteTranslation(IList<JulianDate> dates, IList<Cartesian> values)
        {
            WriteTranslation(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>translation</code> property.  The <code>translation</code> property specifies the translation applied to the model node.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteTranslation(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            const string PropertyName = TranslationPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian3(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the <code>rotation</code> property.  The <code>rotation</code> property specifies the rotation to apply to the model node.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRotation(UnitQuaternion value)
        {
            const string PropertyName = RotationPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteUnitQuaternion(Output, value);
        }

        /// <summary>
        /// Writes the <code>rotation</code> property.  The <code>rotation</code> property specifies the rotation to apply to the model node.
        /// </summary>
        /// <param name="dates">The dates at which the rotation is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteRotation(IList<JulianDate> dates, IList<UnitQuaternion> values)
        {
            WriteRotation(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>rotation</code> property.  The <code>rotation</code> property specifies the rotation to apply to the model node.
        /// </summary>
        /// <param name="dates">The dates at which the rotation is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteRotation(IList<JulianDate> dates, IList<UnitQuaternion> values, int startIndex, int length)
        {
            const string PropertyName = RotationPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteUnitQuaternion(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>Scale</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Cartesian> AsScale()
        {
            return m_asScale.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Cartesian> CreateScaleAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<ModelNodeTransformationCesiumWriter, Cartesian>(
                this, (me, value) => me.WriteScale(value), (ModelNodeTransformationCesiumWriter me, IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length) => me.WriteScale(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>Translation</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Cartesian> AsTranslation()
        {
            return m_asTranslation.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Cartesian> CreateTranslationAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<ModelNodeTransformationCesiumWriter, Cartesian>(
                this, (me, value) => me.WriteTranslation(value), (ModelNodeTransformationCesiumWriter me, IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length) => me.WriteTranslation(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <code>Rotation</code> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> AsRotation()
        {
            return m_asRotation.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> CreateRotationAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<ModelNodeTransformationCesiumWriter, UnitQuaternion>(
                this, (me, value) => me.WriteRotation(value), (ModelNodeTransformationCesiumWriter me, IList<JulianDate> dates, IList<UnitQuaternion> values, int startIndex, int length) => me.WriteRotation(dates, values, startIndex, length));
        }

    }
}
