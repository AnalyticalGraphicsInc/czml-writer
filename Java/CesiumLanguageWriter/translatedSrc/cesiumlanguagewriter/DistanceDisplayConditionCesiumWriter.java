package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code DistanceDisplayCondition} to a {@link CesiumOutputStream}. A {@code DistanceDisplayCondition} is indicates the visibility of an object based on the distance to the camera.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class DistanceDisplayConditionCesiumWriter extends CesiumInterpolatablePropertyWriter<DistanceDisplayConditionCesiumWriter> implements ICesiumDeletablePropertyWriter,
        ICesiumDistanceDisplayConditionValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code distanceDisplayCondition} property.
    */
    public static final String DistanceDisplayConditionPropertyName = "distanceDisplayCondition";
    /**
    * The name of the {@code reference} property.
    */
    public static final String ReferencePropertyName = "reference";
    /**
    * The name of the {@code delete} property.
    */
    public static final String DeletePropertyName = "delete";
    private Lazy<CesiumDistanceDisplayConditionValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter>> m_asDistanceDisplayCondition;
    private Lazy<CesiumReferenceValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public DistanceDisplayConditionCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asDistanceDisplayCondition = createAsDistanceDisplayCondition();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected DistanceDisplayConditionCesiumWriter(@Nonnull DistanceDisplayConditionCesiumWriter existingInstance) {
        super(existingInstance);
        m_asDistanceDisplayCondition = createAsDistanceDisplayCondition();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public DistanceDisplayConditionCesiumWriter clone() {
        return new DistanceDisplayConditionCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code distanceDisplayCondition}, which is the value specified as two values {@code [NearDistance, FarDistance]}, with distances in meters.
    * @param value The value.
    */
    public final void writeDistanceDisplayCondition(@Nonnull Bounds value) {
        final String PropertyName = DistanceDisplayConditionPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeBounds(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code distanceDisplayCondition}, which is the value specified as two values {@code [NearDistance, FarDistance]}, with distances in meters.
    * @param lowerBound The lower bound.
    * @param upperBound The upper bound.
    */
    public final void writeDistanceDisplayCondition(double lowerBound, double upperBound) {
        writeDistanceDisplayCondition(new Bounds(lowerBound, upperBound));
    }

    /**
    * Writes the value expressed as a {@code distanceDisplayCondition}, which is the value specified as two values {@code [NearDistance, FarDistance]}, with distances in meters.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDistanceDisplayCondition(List<JulianDate> dates, List<Bounds> values) {
        writeDistanceDisplayCondition(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code distanceDisplayCondition}, which is the value specified as two values {@code [NearDistance, FarDistance]}, with distances in meters.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeDistanceDisplayCondition(List<JulianDate> dates, List<Bounds> values, int startIndex, int length) {
        final String PropertyName = DistanceDisplayConditionPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeBounds(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the value specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the value specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the value specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the value specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumDistanceDisplayConditionValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumDistanceDisplayConditionValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter> asDistanceDisplayCondition() {
        return m_asDistanceDisplayCondition.getValue();
    }

    private final Lazy<CesiumDistanceDisplayConditionValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter>> createAsDistanceDisplayCondition() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumDistanceDisplayConditionValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumDistanceDisplayConditionValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter>>(this, "createDistanceDisplayCondition") {
                    public cesiumlanguagewriter.advanced.CesiumDistanceDisplayConditionValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter> invoke() {
                        return createDistanceDisplayCondition();
                    }
                }, false);
    }

    private final CesiumDistanceDisplayConditionValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter> createDistanceDisplayCondition() {
        return CesiumValuePropertyAdaptors.<DistanceDisplayConditionCesiumWriter> createDistanceDisplayCondition(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumReferenceValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    private final Lazy<CesiumReferenceValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    private final CesiumReferenceValuePropertyAdaptor<DistanceDisplayConditionCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<DistanceDisplayConditionCesiumWriter> createReference(this);
    }
}