package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 * Writes a {@code DoubleList} to a {@link CesiumOutputStream}. A {@code DoubleList} is a list of floating-point numbers.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class DoubleListCesiumWriter extends CesiumPropertyWriter<DoubleListCesiumWriter>
        implements ICesiumDeletablePropertyWriter, ICesiumDoubleListValuePropertyWriter, ICesiumReferenceListValuePropertyWriter {
    /**
    * The name of the {@code array} property.
    */
    @Nonnull
    public static final String ArrayPropertyName = "array";
    /**
    * The name of the {@code references} property.
    */
    @Nonnull
    public static final String ReferencesPropertyName = "references";
    /**
    * The name of the {@code delete} property.
    */
    @Nonnull
    public static final String DeletePropertyName = "delete";
    @Nonnull
    private final Lazy<CesiumDoubleListValuePropertyAdaptor<DoubleListCesiumWriter>> m_asArray;
    @Nonnull
    private final Lazy<CesiumReferenceListValuePropertyAdaptor<DoubleListCesiumWriter>> m_asReferences;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public DoubleListCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asArray = createAsArray();
        m_asReferences = createAsReferences();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected DoubleListCesiumWriter(@Nonnull DoubleListCesiumWriter existingInstance) {
        super(existingInstance);
        m_asArray = createAsArray();
        m_asReferences = createAsReferences();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public DoubleListCesiumWriter clone() {
        return new DoubleListCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code array}, which is the list of values specified as an array of numbers.
    * @param values The values.
    */
    public final void writeArray(Iterable<Double> values) {
        final String PropertyName = ArrayPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeDoubleList(getOutput(), values);
    }

    /**
    * Writes the value expressed as a {@code references}, which is the list of values specified as references. Each reference is to a property that defines a single value, which may change with time.
    * @param references The list of references.
    */
    public final void writeReferences(Iterable<Reference> references) {
        final String PropertyName = ReferencesPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReferences(getOutput(), references);
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
    * Returns a wrapper for this instance that implements {@link ICesiumDoubleListValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumDoubleListValuePropertyAdaptor<DoubleListCesiumWriter> asArray() {
        return m_asArray.getValue();
    }

    @Nonnull
    private final Lazy<CesiumDoubleListValuePropertyAdaptor<DoubleListCesiumWriter>> createAsArray() {
        return new Lazy<CesiumDoubleListValuePropertyAdaptor<DoubleListCesiumWriter>>(new Func1<CesiumDoubleListValuePropertyAdaptor<DoubleListCesiumWriter>>(this, "createDoubleList") {
            public CesiumDoubleListValuePropertyAdaptor<DoubleListCesiumWriter> invoke() {
                return createDoubleList();
            }
        }, false);
    }

    @Nonnull
    private final CesiumDoubleListValuePropertyAdaptor<DoubleListCesiumWriter> createDoubleList() {
        return CesiumValuePropertyAdaptors.<DoubleListCesiumWriter> createDoubleList(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceListValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceListValuePropertyAdaptor<DoubleListCesiumWriter> asReferences() {
        return m_asReferences.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceListValuePropertyAdaptor<DoubleListCesiumWriter>> createAsReferences() {
        return new Lazy<CesiumReferenceListValuePropertyAdaptor<DoubleListCesiumWriter>>(new Func1<CesiumReferenceListValuePropertyAdaptor<DoubleListCesiumWriter>>(this, "createReferenceList") {
            public CesiumReferenceListValuePropertyAdaptor<DoubleListCesiumWriter> invoke() {
                return createReferenceList();
            }
        }, false);
    }

    @Nonnull
    private final CesiumReferenceListValuePropertyAdaptor<DoubleListCesiumWriter> createReferenceList() {
        return CesiumValuePropertyAdaptors.<DoubleListCesiumWriter> createReferenceList(this);
    }
}