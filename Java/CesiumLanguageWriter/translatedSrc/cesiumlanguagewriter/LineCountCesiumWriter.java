package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code LineCount} to a {@link CesiumOutputStream}. A {@code LineCount} is the number of grid lines along each axis.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class LineCountCesiumWriter extends CesiumInterpolatablePropertyWriter<LineCountCesiumWriter>
        implements ICesiumDeletablePropertyWriter, ICesiumCartesian2ValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code cartesian2} property.
    */
    @Nonnull
    public static final String Cartesian2PropertyName = "cartesian2";
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
    private final Lazy<CesiumCartesian2ValuePropertyAdaptor<LineCountCesiumWriter>> m_asCartesian2;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<LineCountCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public LineCountCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asCartesian2 = createAsCartesian2();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected LineCountCesiumWriter(@Nonnull LineCountCesiumWriter existingInstance) {
        super(existingInstance);
        m_asCartesian2 = createAsCartesian2();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public LineCountCesiumWriter clone() {
        return new LineCountCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code cartesian2}, which is the number of grid lines along each axis.
    * @param value The value.
    */
    public final void writeCartesian2(@Nonnull Rectangular value) {
        final String PropertyName = Cartesian2PropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian2(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code cartesian2}, which is the number of grid lines along each axis.
    * @param x The X component.
    * @param y The Y component.
    */
    public final void writeCartesian2(double x, double y) {
        writeCartesian2(new Rectangular(x, y));
    }

    /**
    * Writes the value expressed as a {@code cartesian2}, which is the number of grid lines along each axis.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesian2(List<JulianDate> dates, List<Rectangular> values) {
        writeCartesian2(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code cartesian2}, which is the number of grid lines along each axis.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartesian2(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        final String PropertyName = Cartesian2PropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartesian2(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the number of grid lines along each axis specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the number of grid lines along each axis specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the number of grid lines along each axis specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the number of grid lines along each axis specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumCartesian2ValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumCartesian2ValuePropertyAdaptor<LineCountCesiumWriter> asCartesian2() {
        return m_asCartesian2.getValue();
    }

    @Nonnull
    private final Lazy<CesiumCartesian2ValuePropertyAdaptor<LineCountCesiumWriter>> createAsCartesian2() {
        return new Lazy<CesiumCartesian2ValuePropertyAdaptor<LineCountCesiumWriter>>(new Func1<CesiumCartesian2ValuePropertyAdaptor<LineCountCesiumWriter>>(this, "createCartesian2") {
            public CesiumCartesian2ValuePropertyAdaptor<LineCountCesiumWriter> invoke() {
                return createCartesian2();
            }
        }, false);
    }

    @Nonnull
    private final CesiumCartesian2ValuePropertyAdaptor<LineCountCesiumWriter> createCartesian2() {
        return CesiumValuePropertyAdaptors.<LineCountCesiumWriter> createCartesian2(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<LineCountCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<LineCountCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<LineCountCesiumWriter>>(new Func1<CesiumReferenceValuePropertyAdaptor<LineCountCesiumWriter>>(this, "createReference") {
            public CesiumReferenceValuePropertyAdaptor<LineCountCesiumWriter> invoke() {
                return createReference();
            }
        }, false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<LineCountCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<LineCountCesiumWriter> createReference(this);
    }
}