package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Boolean} to a {@link CesiumOutputStream}. A {@code Boolean} is a boolean value.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class BooleanCesiumWriter extends CesiumPropertyWriter<BooleanCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumBooleanValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code boolean} property.
    */
    @Nonnull
    public static final String BooleanPropertyName = "boolean";
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
    private final Lazy<CesiumBooleanValuePropertyAdaptor<BooleanCesiumWriter>> m_asBoolean;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<BooleanCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public BooleanCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asBoolean = createAsBoolean();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected BooleanCesiumWriter(@Nonnull BooleanCesiumWriter existingInstance) {
        super(existingInstance);
        m_asBoolean = createAsBoolean();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public BooleanCesiumWriter clone() {
        return new BooleanCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code boolean}, which is the boolean value.
    * @param value The value.
    */
    public final void writeBoolean(boolean value) {
        final String PropertyName = BooleanPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the boolean specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the boolean specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the boolean specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the boolean specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumBooleanValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumBooleanValuePropertyAdaptor<BooleanCesiumWriter> asBoolean() {
        return m_asBoolean.getValue();
    }

    @Nonnull
    private final Lazy<CesiumBooleanValuePropertyAdaptor<BooleanCesiumWriter>> createAsBoolean() {
        return new Lazy<CesiumBooleanValuePropertyAdaptor<BooleanCesiumWriter>>(new Func1<CesiumBooleanValuePropertyAdaptor<BooleanCesiumWriter>>(this, "createBoolean") {
            public CesiumBooleanValuePropertyAdaptor<BooleanCesiumWriter> invoke() {
                return createBoolean();
            }
        }, false);
    }

    @Nonnull
    private final CesiumBooleanValuePropertyAdaptor<BooleanCesiumWriter> createBoolean() {
        return CesiumValuePropertyAdaptors.<BooleanCesiumWriter> createBoolean(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<BooleanCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<BooleanCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<BooleanCesiumWriter>>(new Func1<CesiumReferenceValuePropertyAdaptor<BooleanCesiumWriter>>(this, "createReference") {
            public CesiumReferenceValuePropertyAdaptor<BooleanCesiumWriter> invoke() {
                return createReference();
            }
        }, false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<BooleanCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<BooleanCesiumWriter> createReference(this);
    }
}