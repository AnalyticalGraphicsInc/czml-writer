package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 * Writes a {@code ArcType} to a {@link CesiumOutputStream}. A {@code ArcType} is the type of an arc.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class ArcTypeCesiumWriter extends CesiumPropertyWriter<ArcTypeCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumArcTypeValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code arcType} property.
    */
    @Nonnull
    public static final String ArcTypePropertyName = "arcType";
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
    private final Lazy<CesiumArcTypeValuePropertyAdaptor<ArcTypeCesiumWriter>> m_asArcType;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<ArcTypeCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public ArcTypeCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asArcType = createAsArcType();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected ArcTypeCesiumWriter(@Nonnull ArcTypeCesiumWriter existingInstance) {
        super(existingInstance);
        m_asArcType = createAsArcType();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public ArcTypeCesiumWriter clone() {
        return new ArcTypeCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code arcType}, which is the arc type.
    * @param value The type of an arc.
    */
    public final void writeArcType(@Nonnull CesiumArcType value) {
        final String PropertyName = ArcTypePropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.arcTypeToString(value));
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the arc type specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the arc type specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the arc type specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the arc type specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumArcTypeValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumArcTypeValuePropertyAdaptor<ArcTypeCesiumWriter> asArcType() {
        return m_asArcType.getValue();
    }

    @Nonnull
    private final Lazy<CesiumArcTypeValuePropertyAdaptor<ArcTypeCesiumWriter>> createAsArcType() {
        return new Lazy<CesiumArcTypeValuePropertyAdaptor<ArcTypeCesiumWriter>>(Func1.<CesiumArcTypeValuePropertyAdaptor<ArcTypeCesiumWriter>> of(this::createArcType, this, "createArcType"), false);
    }

    @Nonnull
    private final CesiumArcTypeValuePropertyAdaptor<ArcTypeCesiumWriter> createArcType() {
        return CesiumValuePropertyAdaptors.<ArcTypeCesiumWriter> createArcType(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<ArcTypeCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<ArcTypeCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<ArcTypeCesiumWriter>>(Func1.<CesiumReferenceValuePropertyAdaptor<ArcTypeCesiumWriter>> of(this::createReference, this, "createReference"),
                false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<ArcTypeCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<ArcTypeCesiumWriter> createReference(this);
    }
}