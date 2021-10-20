package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code BoxDimensions} to a {@link CesiumOutputStream}. A {@code BoxDimensions} is the width, depth, and height of a box.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class BoxDimensionsCesiumWriter extends CesiumInterpolatablePropertyWriter<BoxDimensionsCesiumWriter>
        implements ICesiumDeletablePropertyWriter, ICesiumCartesian3ValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code cartesian} property.
    */
    @Nonnull
    public static final String CartesianPropertyName = "cartesian";
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
    private final Lazy<CesiumCartesian3ValuePropertyAdaptor<BoxDimensionsCesiumWriter>> m_asCartesian;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<BoxDimensionsCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public BoxDimensionsCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asCartesian = createAsCartesian();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected BoxDimensionsCesiumWriter(@Nonnull BoxDimensionsCesiumWriter existingInstance) {
        super(existingInstance);
        m_asCartesian = createAsCartesian();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public BoxDimensionsCesiumWriter clone() {
        return new BoxDimensionsCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the dimensions specified as a three-dimensional Cartesian value {@code [X, Y, Z]}, with X representing width, Y representing depth, and Z representing height, in world coordinates in meters.
    * @param value The value.
    */
    public final void writeCartesian(@Nonnull Cartesian value) {
        final String PropertyName = CartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian3(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the dimensions specified as a three-dimensional Cartesian value {@code [X, Y, Z]}, with X representing width, Y representing depth, and Z representing height, in world coordinates in meters.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
        writeCartesian(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the dimensions specified as a three-dimensional Cartesian value {@code [X, Y, Z]}, with X representing width, Y representing depth, and Z representing height, in world coordinates in meters.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        final String PropertyName = CartesianPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartesian3(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the dimensions specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the dimensions specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the dimensions specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the dimensions specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumCartesian3ValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumCartesian3ValuePropertyAdaptor<BoxDimensionsCesiumWriter> asCartesian() {
        return m_asCartesian.getValue();
    }

    @Nonnull
    private final Lazy<CesiumCartesian3ValuePropertyAdaptor<BoxDimensionsCesiumWriter>> createAsCartesian() {
        return new Lazy<CesiumCartesian3ValuePropertyAdaptor<BoxDimensionsCesiumWriter>>(new Func1<CesiumCartesian3ValuePropertyAdaptor<BoxDimensionsCesiumWriter>>(this, "createCartesian3") {
            public CesiumCartesian3ValuePropertyAdaptor<BoxDimensionsCesiumWriter> invoke() {
                return createCartesian3();
            }
        }, false);
    }

    @Nonnull
    private final CesiumCartesian3ValuePropertyAdaptor<BoxDimensionsCesiumWriter> createCartesian3() {
        return CesiumValuePropertyAdaptors.<BoxDimensionsCesiumWriter> createCartesian3(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<BoxDimensionsCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<BoxDimensionsCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<BoxDimensionsCesiumWriter>>(new Func1<CesiumReferenceValuePropertyAdaptor<BoxDimensionsCesiumWriter>>(this, "createReference") {
            public CesiumReferenceValuePropertyAdaptor<BoxDimensionsCesiumWriter> invoke() {
                return createReference();
            }
        }, false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<BoxDimensionsCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<BoxDimensionsCesiumWriter> createReference(this);
    }
}