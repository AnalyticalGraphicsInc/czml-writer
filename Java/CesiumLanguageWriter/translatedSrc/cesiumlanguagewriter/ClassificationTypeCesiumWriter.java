package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 * Writes a {@code ClassificationType} to a {@link CesiumOutputStream}. A {@code ClassificationType} is whether a classification affects terrain, 3D Tiles, or both.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class ClassificationTypeCesiumWriter extends CesiumPropertyWriter<ClassificationTypeCesiumWriter>
        implements ICesiumDeletablePropertyWriter, ICesiumClassificationTypeValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code classificationType} property.
    */
    @Nonnull
    public static final String ClassificationTypePropertyName = "classificationType";
    /**
    * The name of the {@code reference} property.
    */
    @Nonnull
    public static final String ReferencePropertyName = "reference";
    /**
    * The name of the {@code delete} property.
    */
    @Nonnull
    public static final String DeletePropertyName = "delete";
    @Nonnull
    private final Lazy<CesiumClassificationTypeValuePropertyAdaptor<ClassificationTypeCesiumWriter>> m_asClassificationType;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<ClassificationTypeCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public ClassificationTypeCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asClassificationType = createAsClassificationType();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected ClassificationTypeCesiumWriter(@Nonnull ClassificationTypeCesiumWriter existingInstance) {
        super(existingInstance);
        m_asClassificationType = createAsClassificationType();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public ClassificationTypeCesiumWriter clone() {
        return new ClassificationTypeCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code classificationType}, which is the classification type, which indicates whether a classification affects terrain, 3D Tiles, or both.
    * @param value The classification type.
    */
    public final void writeClassificationType(@Nonnull CesiumClassificationType value) {
        final String PropertyName = ClassificationTypePropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.classificationTypeToString(value));
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the classification type specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the classification type specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the classification type specified as a reference to another property.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeReference(String identifier, String propertyName) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), identifier, propertyName);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the classification type specified as a reference to another property.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeReference(String identifier, String[] propertyNames) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), identifier, propertyNames);
    }

    /**
    * Writes the value expressed as a {@code delete}, which is whether the client should delete existing samples or interval data for this property. Data will be deleted for the containing interval, or if there is no containing interval, then all data. If true, all other properties in this property will be ignored.
    * @param value The value.
    */
    public final void writeDelete(boolean value) {
        final String PropertyName = DeletePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumClassificationTypeValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumClassificationTypeValuePropertyAdaptor<ClassificationTypeCesiumWriter> asClassificationType() {
        return m_asClassificationType.getValue();
    }

    @Nonnull
    private final Lazy<CesiumClassificationTypeValuePropertyAdaptor<ClassificationTypeCesiumWriter>> createAsClassificationType() {
        return new Lazy<CesiumClassificationTypeValuePropertyAdaptor<ClassificationTypeCesiumWriter>>(
                Func1.<CesiumClassificationTypeValuePropertyAdaptor<ClassificationTypeCesiumWriter>> of(this::createClassificationType, this, "createClassificationType"), false);
    }

    @Nonnull
    private final CesiumClassificationTypeValuePropertyAdaptor<ClassificationTypeCesiumWriter> createClassificationType() {
        return CesiumValuePropertyAdaptors.<ClassificationTypeCesiumWriter> createClassificationType(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<ClassificationTypeCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<ClassificationTypeCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<ClassificationTypeCesiumWriter>>(
                Func1.<CesiumReferenceValuePropertyAdaptor<ClassificationTypeCesiumWriter>> of(this::createReference, this, "createReference"), false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<ClassificationTypeCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<ClassificationTypeCesiumWriter> createReference(this);
    }
}