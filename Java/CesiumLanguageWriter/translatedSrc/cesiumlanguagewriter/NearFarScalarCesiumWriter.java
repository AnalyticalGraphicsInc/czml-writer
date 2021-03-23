package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code NearFarScalar} to a {@link CesiumOutputStream}. A {@code NearFarScalar} is a numeric value which will be linearly interpolated between two values based on an object's distance from the camera, in eye coordinates. The computed value will interpolate between the near value and the far value while the camera distance falls between the near distance and the far distance, and will be clamped to the near or far value while the distance is less than the near distance or greater than the far distance, respectively.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class NearFarScalarCesiumWriter extends CesiumInterpolatablePropertyWriter<NearFarScalarCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumNearFarScalarValuePropertyWriter,
        ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code nearFarScalar} property.
    */
    @Nonnull
    public static final String NearFarScalarPropertyName = "nearFarScalar";
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
    private final Lazy<CesiumNearFarScalarValuePropertyAdaptor<NearFarScalarCesiumWriter>> m_asNearFarScalar;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<NearFarScalarCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public NearFarScalarCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asNearFarScalar = createAsNearFarScalar();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected NearFarScalarCesiumWriter(@Nonnull NearFarScalarCesiumWriter existingInstance) {
        super(existingInstance);
        m_asNearFarScalar = createAsNearFarScalar();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public NearFarScalarCesiumWriter clone() {
        return new NearFarScalarCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code nearFarScalar}, which is the value specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}, with distances in eye coordinates in meters.
    * @param value The value.
    */
    public final void writeNearFarScalar(@Nonnull NearFarScalar value) {
        final String PropertyName = NearFarScalarPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeNearFarScalar(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code nearFarScalar}, which is the value specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}, with distances in eye coordinates in meters.
    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public final void writeNearFarScalar(double nearDistance, double nearValue, double farDistance, double farValue) {
        writeNearFarScalar(new NearFarScalar(nearDistance, nearValue, farDistance, farValue));
    }

    /**
    * Writes the value expressed as a {@code nearFarScalar}, which is the value specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}, with distances in eye coordinates in meters.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeNearFarScalar(List<JulianDate> dates, List<NearFarScalar> values) {
        writeNearFarScalar(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code nearFarScalar}, which is the value specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}, with distances in eye coordinates in meters.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeNearFarScalar(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
        final String PropertyName = NearFarScalarPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeNearFarScalar(getOutput(), PropertyName, dates, values, startIndex, length);
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
    * Returns a wrapper for this instance that implements {@link ICesiumNearFarScalarValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumNearFarScalarValuePropertyAdaptor<NearFarScalarCesiumWriter> asNearFarScalar() {
        return m_asNearFarScalar.getValue();
    }

    @Nonnull
    private final Lazy<CesiumNearFarScalarValuePropertyAdaptor<NearFarScalarCesiumWriter>> createAsNearFarScalar() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumNearFarScalarValuePropertyAdaptor<NearFarScalarCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumNearFarScalarValuePropertyAdaptor<NearFarScalarCesiumWriter>>(this, "createNearFarScalar") {
                    public cesiumlanguagewriter.advanced.CesiumNearFarScalarValuePropertyAdaptor<NearFarScalarCesiumWriter> invoke() {
                        return createNearFarScalar();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumNearFarScalarValuePropertyAdaptor<NearFarScalarCesiumWriter> createNearFarScalar() {
        return CesiumValuePropertyAdaptors.<NearFarScalarCesiumWriter> createNearFarScalar(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<NearFarScalarCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<NearFarScalarCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<NearFarScalarCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<NearFarScalarCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<NearFarScalarCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<NearFarScalarCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<NearFarScalarCesiumWriter> createReference(this);
    }
}