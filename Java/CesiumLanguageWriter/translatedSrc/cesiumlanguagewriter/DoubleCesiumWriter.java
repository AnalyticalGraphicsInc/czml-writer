package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Double} to a {@link CesiumOutputStream}. A {@code Double} is a floating-point number.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class DoubleCesiumWriter extends CesiumInterpolatablePropertyWriter<DoubleCesiumWriter>
        implements ICesiumDeletablePropertyWriter, ICesiumDoubleValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code number} property.
    */
    @Nonnull
    public static final String NumberPropertyName = "number";
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
    private final Lazy<CesiumDoubleValuePropertyAdaptor<DoubleCesiumWriter>> m_asNumber;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<DoubleCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public DoubleCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asNumber = createAsNumber();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected DoubleCesiumWriter(@Nonnull DoubleCesiumWriter existingInstance) {
        super(existingInstance);
        m_asNumber = createAsNumber();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public DoubleCesiumWriter clone() {
        return new DoubleCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code number}, which is the number.
    * @param value The value.
    */
    public final void writeNumber(double value) {
        final String PropertyName = NumberPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(value);
    }

    /**
    * Writes the value expressed as a {@code number}, which is the number.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeNumber(List<JulianDate> dates, List<Double> values) {
        writeNumber(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code number}, which is the number.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeNumber(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        final String PropertyName = NumberPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeDouble(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the number specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the number specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the number specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the number specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumDoubleValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumDoubleValuePropertyAdaptor<DoubleCesiumWriter> asNumber() {
        return m_asNumber.getValue();
    }

    @Nonnull
    private final Lazy<CesiumDoubleValuePropertyAdaptor<DoubleCesiumWriter>> createAsNumber() {
        return new Lazy<CesiumDoubleValuePropertyAdaptor<DoubleCesiumWriter>>(Func1.<CesiumDoubleValuePropertyAdaptor<DoubleCesiumWriter>> of(this::createDouble, this, "createDouble"), false);
    }

    @Nonnull
    private final CesiumDoubleValuePropertyAdaptor<DoubleCesiumWriter> createDouble() {
        return CesiumValuePropertyAdaptors.<DoubleCesiumWriter> createDouble(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<DoubleCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<DoubleCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<DoubleCesiumWriter>>(Func1.<CesiumReferenceValuePropertyAdaptor<DoubleCesiumWriter>> of(this::createReference, this, "createReference"),
                false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<DoubleCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<DoubleCesiumWriter> createReference(this);
    }
}