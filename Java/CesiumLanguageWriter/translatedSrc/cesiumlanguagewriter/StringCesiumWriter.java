package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 * Writes a {@code String} to a {@link CesiumOutputStream}. A {@code String} is a string value. The string can optionally vary with time.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class StringCesiumWriter extends CesiumPropertyWriter<StringCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumStringValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code string} property.
    */
    @Nonnull
    public static final String StringPropertyName = "string";
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
    private final Lazy<CesiumStringValuePropertyAdaptor<StringCesiumWriter>> m_asString;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<StringCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public StringCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asString = createAsString();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected StringCesiumWriter(@Nonnull StringCesiumWriter existingInstance) {
        super(existingInstance);
        m_asString = createAsString();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public StringCesiumWriter clone() {
        return new StringCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code string}, which is the string value.
    * @param value The value.
    */
    public final void writeString(String value) {
        final String PropertyName = StringPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the string specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the string specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the string specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the string specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumStringValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumStringValuePropertyAdaptor<StringCesiumWriter> asString() {
        return m_asString.getValue();
    }

    @Nonnull
    private final Lazy<CesiumStringValuePropertyAdaptor<StringCesiumWriter>> createAsString() {
        return new Lazy<CesiumStringValuePropertyAdaptor<StringCesiumWriter>>(new Func1<CesiumStringValuePropertyAdaptor<StringCesiumWriter>>(this, "createString") {
            public CesiumStringValuePropertyAdaptor<StringCesiumWriter> invoke() {
                return createString();
            }
        }, false);
    }

    @Nonnull
    private final CesiumStringValuePropertyAdaptor<StringCesiumWriter> createString() {
        return CesiumValuePropertyAdaptors.<StringCesiumWriter> createString(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<StringCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<StringCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<StringCesiumWriter>>(new Func1<CesiumReferenceValuePropertyAdaptor<StringCesiumWriter>>(this, "createReference") {
            public CesiumReferenceValuePropertyAdaptor<StringCesiumWriter> invoke() {
                return createReference();
            }
        }, false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<StringCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<StringCesiumWriter> createReference(this);
    }
}