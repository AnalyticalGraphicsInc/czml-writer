package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.RotationCesiumWriter;
import cesiumlanguagewriter.ScaleCesiumWriter;
import cesiumlanguagewriter.TranslationCesiumWriter;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code NodeTransformation} to a {@link CesiumOutputStream}. A {@code NodeTransformation} is a set of transformations to apply to a particular node in a 3D model.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class NodeTransformationCesiumWriter extends CesiumPropertyWriter<NodeTransformationCesiumWriter> {
    /**
    * The name of the {@code translation} property.
    */
    @Nonnull
    public static final String TranslationPropertyName = "translation";
    /**
    * The name of the {@code rotation} property.
    */
    @Nonnull
    public static final String RotationPropertyName = "rotation";
    /**
    * The name of the {@code scale} property.
    */
    @Nonnull
    public static final String ScalePropertyName = "scale";
    @Nonnull
    private final Lazy<TranslationCesiumWriter> m_translation = new Lazy<TranslationCesiumWriter>(new Func1<TranslationCesiumWriter>() {
        public TranslationCesiumWriter invoke() {
            return new TranslationCesiumWriter(TranslationPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<RotationCesiumWriter> m_rotation = new Lazy<RotationCesiumWriter>(new Func1<RotationCesiumWriter>() {
        public RotationCesiumWriter invoke() {
            return new RotationCesiumWriter(RotationPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ScaleCesiumWriter> m_scale = new Lazy<ScaleCesiumWriter>(new Func1<ScaleCesiumWriter>() {
        public ScaleCesiumWriter invoke() {
            return new ScaleCesiumWriter(ScalePropertyName);
        }
    }, false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public NodeTransformationCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected NodeTransformationCesiumWriter(@Nonnull NodeTransformationCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public NodeTransformationCesiumWriter clone() {
        return new NodeTransformationCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code translation} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code translation} property defines the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    */
    @Nonnull
    public final TranslationCesiumWriter getTranslationWriter() {
        return m_translation.getValue();
    }

    /**
    * Opens and returns the writer for the {@code translation} property. The {@code translation} property defines the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    */
    @Nonnull
    public final TranslationCesiumWriter openTranslationProperty() {
        openIntervalIfNecessary();
        return this.<TranslationCesiumWriter> openAndReturn(getTranslationWriter());
    }

    /**
    * Writes a value for the {@code translation} property as a {@code cartesian} value. The {@code translation} property specifies the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The value.
    */
    public final void writeTranslationProperty(@Nonnull Cartesian value) {
        try (Using<TranslationCesiumWriter> using$0 = new Using<TranslationCesiumWriter>(openTranslationProperty())) {
            final TranslationCesiumWriter writer = using$0.resource;
            writer.writeCartesian(value);
        }
    }

    /**
    * Writes a value for the {@code translation} property as a {@code cartesian} value. The {@code translation} property specifies the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeTranslationProperty(List<JulianDate> dates, List<Cartesian> values) {
        try (Using<TranslationCesiumWriter> using$0 = new Using<TranslationCesiumWriter>(openTranslationProperty())) {
            final TranslationCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values);
        }
    }

    /**
    * Writes a value for the {@code translation} property as a {@code cartesian} value. The {@code translation} property specifies the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeTranslationProperty(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        try (Using<TranslationCesiumWriter> using$0 = new Using<TranslationCesiumWriter>(openTranslationProperty())) {
            final TranslationCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code translation} property as a {@code reference} value. The {@code translation} property specifies the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The reference.
    */
    public final void writeTranslationPropertyReference(Reference value) {
        try (Using<TranslationCesiumWriter> using$0 = new Using<TranslationCesiumWriter>(openTranslationProperty())) {
            final TranslationCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code translation} property as a {@code reference} value. The {@code translation} property specifies the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The reference.
    */
    public final void writeTranslationPropertyReference(String value) {
        try (Using<TranslationCesiumWriter> using$0 = new Using<TranslationCesiumWriter>(openTranslationProperty())) {
            final TranslationCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code translation} property as a {@code reference} value. The {@code translation} property specifies the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeTranslationPropertyReference(String identifier, String propertyName) {
        try (Using<TranslationCesiumWriter> using$0 = new Using<TranslationCesiumWriter>(openTranslationProperty())) {
            final TranslationCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code translation} property as a {@code reference} value. The {@code translation} property specifies the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeTranslationPropertyReference(String identifier, String[] propertyNames) {
        try (Using<TranslationCesiumWriter> using$0 = new Using<TranslationCesiumWriter>(openTranslationProperty())) {
            final TranslationCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code rotation} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code rotation} property defines the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    */
    @Nonnull
    public final RotationCesiumWriter getRotationWriter() {
        return m_rotation.getValue();
    }

    /**
    * Opens and returns the writer for the {@code rotation} property. The {@code rotation} property defines the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    */
    @Nonnull
    public final RotationCesiumWriter openRotationProperty() {
        openIntervalIfNecessary();
        return this.<RotationCesiumWriter> openAndReturn(getRotationWriter());
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code unitQuaternion} value. The {@code rotation} property specifies the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    * @param value The value.
    */
    public final void writeRotationProperty(@Nonnull UnitQuaternion value) {
        try (Using<RotationCesiumWriter> using$0 = new Using<RotationCesiumWriter>(openRotationProperty())) {
            final RotationCesiumWriter writer = using$0.resource;
            writer.writeUnitQuaternion(value);
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code unitQuaternion} value. The {@code rotation} property specifies the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRotationProperty(List<JulianDate> dates, List<UnitQuaternion> values) {
        try (Using<RotationCesiumWriter> using$0 = new Using<RotationCesiumWriter>(openRotationProperty())) {
            final RotationCesiumWriter writer = using$0.resource;
            writer.writeUnitQuaternion(dates, values);
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code unitQuaternion} value. The {@code rotation} property specifies the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRotationProperty(List<JulianDate> dates, List<UnitQuaternion> values, int startIndex, int length) {
        try (Using<RotationCesiumWriter> using$0 = new Using<RotationCesiumWriter>(openRotationProperty())) {
            final RotationCesiumWriter writer = using$0.resource;
            writer.writeUnitQuaternion(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    * @param value The reference.
    */
    public final void writeRotationPropertyReference(Reference value) {
        try (Using<RotationCesiumWriter> using$0 = new Using<RotationCesiumWriter>(openRotationProperty())) {
            final RotationCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    * @param value The reference.
    */
    public final void writeRotationPropertyReference(String value) {
        try (Using<RotationCesiumWriter> using$0 = new Using<RotationCesiumWriter>(openRotationProperty())) {
            final RotationCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeRotationPropertyReference(String identifier, String propertyName) {
        try (Using<RotationCesiumWriter> using$0 = new Using<RotationCesiumWriter>(openRotationProperty())) {
            final RotationCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeRotationPropertyReference(String identifier, String[] propertyNames) {
        try (Using<RotationCesiumWriter> using$0 = new Using<RotationCesiumWriter>(openRotationProperty())) {
            final RotationCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code scale} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code scale} property defines the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    */
    @Nonnull
    public final ScaleCesiumWriter getScaleWriter() {
        return m_scale.getValue();
    }

    /**
    * Opens and returns the writer for the {@code scale} property. The {@code scale} property defines the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    */
    @Nonnull
    public final ScaleCesiumWriter openScaleProperty() {
        openIntervalIfNecessary();
        return this.<ScaleCesiumWriter> openAndReturn(getScaleWriter());
    }

    /**
    * Writes a value for the {@code scale} property as a {@code cartesian} value. The {@code scale} property specifies the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    * @param value The value.
    */
    public final void writeScaleProperty(@Nonnull Cartesian value) {
        try (Using<ScaleCesiumWriter> using$0 = new Using<ScaleCesiumWriter>(openScaleProperty())) {
            final ScaleCesiumWriter writer = using$0.resource;
            writer.writeCartesian(value);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code cartesian} value. The {@code scale} property specifies the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeScaleProperty(List<JulianDate> dates, List<Cartesian> values) {
        try (Using<ScaleCesiumWriter> using$0 = new Using<ScaleCesiumWriter>(openScaleProperty())) {
            final ScaleCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code cartesian} value. The {@code scale} property specifies the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeScaleProperty(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        try (Using<ScaleCesiumWriter> using$0 = new Using<ScaleCesiumWriter>(openScaleProperty())) {
            final ScaleCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    * @param value The reference.
    */
    public final void writeScalePropertyReference(Reference value) {
        try (Using<ScaleCesiumWriter> using$0 = new Using<ScaleCesiumWriter>(openScaleProperty())) {
            final ScaleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    * @param value The reference.
    */
    public final void writeScalePropertyReference(String value) {
        try (Using<ScaleCesiumWriter> using$0 = new Using<ScaleCesiumWriter>(openScaleProperty())) {
            final ScaleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeScalePropertyReference(String identifier, String propertyName) {
        try (Using<ScaleCesiumWriter> using$0 = new Using<ScaleCesiumWriter>(openScaleProperty())) {
            final ScaleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeScalePropertyReference(String identifier, String[] propertyNames) {
        try (Using<ScaleCesiumWriter> using$0 = new Using<ScaleCesiumWriter>(openScaleProperty())) {
            final ScaleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }
}