package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.RotationCesiumWriter;
import cesiumlanguagewriter.ScaleCesiumWriter;
import cesiumlanguagewriter.TranslationCesiumWriter;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code NodeTransformation} to a {@link CesiumOutputStream}. A {@code NodeTransformation} is a set of transformations to apply to a particular node in a 3D model.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class NodeTransformationCesiumWriter extends CesiumPropertyWriter<NodeTransformationCesiumWriter> {
    /**
    * The name of the {@code translation} property.
    */
    public static final String TranslationPropertyName = "translation";
    /**
    * The name of the {@code rotation} property.
    */
    public static final String RotationPropertyName = "rotation";
    /**
    * The name of the {@code scale} property.
    */
    public static final String ScalePropertyName = "scale";
    private Lazy<TranslationCesiumWriter> m_translation = new Lazy<cesiumlanguagewriter.TranslationCesiumWriter>(new Func1<cesiumlanguagewriter.TranslationCesiumWriter>() {
        public cesiumlanguagewriter.TranslationCesiumWriter invoke() {
            return new TranslationCesiumWriter(TranslationPropertyName);
        }
    }, false);
    private Lazy<RotationCesiumWriter> m_rotation = new Lazy<cesiumlanguagewriter.RotationCesiumWriter>(new Func1<cesiumlanguagewriter.RotationCesiumWriter>() {
        public cesiumlanguagewriter.RotationCesiumWriter invoke() {
            return new RotationCesiumWriter(RotationPropertyName);
        }
    }, false);
    private Lazy<ScaleCesiumWriter> m_scale = new Lazy<cesiumlanguagewriter.ScaleCesiumWriter>(new Func1<cesiumlanguagewriter.ScaleCesiumWriter>() {
        public cesiumlanguagewriter.ScaleCesiumWriter invoke() {
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
        {
            TranslationCesiumWriter writer = openTranslationProperty();
            try {
                writer.writeCartesian(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code translation} property as a {@code cartesian} value. The {@code translation} property specifies the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeTranslationProperty(List<JulianDate> dates, List<Cartesian> values) {
        {
            TranslationCesiumWriter writer = openTranslationProperty();
            try {
                writer.writeCartesian(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            TranslationCesiumWriter writer = openTranslationProperty();
            try {
                writer.writeCartesian(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code translation} property as a {@code reference} value. The {@code translation} property specifies the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The reference.
    */
    public final void writeTranslationPropertyReference(Reference value) {
        {
            TranslationCesiumWriter writer = openTranslationProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code translation} property as a {@code reference} value. The {@code translation} property specifies the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param value The reference.
    */
    public final void writeTranslationPropertyReference(String value) {
        {
            TranslationCesiumWriter writer = openTranslationProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code translation} property as a {@code reference} value. The {@code translation} property specifies the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeTranslationPropertyReference(String identifier, String propertyName) {
        {
            TranslationCesiumWriter writer = openTranslationProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code translation} property as a {@code reference} value. The {@code translation} property specifies the translation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeTranslationPropertyReference(String identifier, String[] propertyNames) {
        {
            TranslationCesiumWriter writer = openTranslationProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            RotationCesiumWriter writer = openRotationProperty();
            try {
                writer.writeUnitQuaternion(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code unitQuaternion} value. The {@code rotation} property specifies the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRotationProperty(List<JulianDate> dates, List<UnitQuaternion> values) {
        {
            RotationCesiumWriter writer = openRotationProperty();
            try {
                writer.writeUnitQuaternion(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            RotationCesiumWriter writer = openRotationProperty();
            try {
                writer.writeUnitQuaternion(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    * @param value The reference.
    */
    public final void writeRotationPropertyReference(Reference value) {
        {
            RotationCesiumWriter writer = openRotationProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    * @param value The reference.
    */
    public final void writeRotationPropertyReference(String value) {
        {
            RotationCesiumWriter writer = openRotationProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeRotationPropertyReference(String identifier, String propertyName) {
        {
            RotationCesiumWriter writer = openRotationProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code rotation} property as a {@code reference} value. The {@code rotation} property specifies the rotation to apply to the model node. If not specified, the default value is [0.0, 0.0, 0.0, 1.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeRotationPropertyReference(String identifier, String[] propertyNames) {
        {
            RotationCesiumWriter writer = openRotationProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ScaleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeCartesian(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code cartesian} value. The {@code scale} property specifies the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeScaleProperty(List<JulianDate> dates, List<Cartesian> values) {
        {
            ScaleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeCartesian(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
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
        {
            ScaleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeCartesian(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    * @param value The reference.
    */
    public final void writeScalePropertyReference(Reference value) {
        {
            ScaleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    * @param value The reference.
    */
    public final void writeScalePropertyReference(String value) {
        {
            ScaleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeScalePropertyReference(String identifier, String propertyName) {
        {
            ScaleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    * Writes a value for the {@code scale} property as a {@code reference} value. The {@code scale} property specifies the scaling to apply to the model node. If not specified, the default value is [1.0, 1.0, 1.0].
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeScalePropertyReference(String identifier, String[] propertyNames) {
        {
            ScaleCesiumWriter writer = openScaleProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }
}