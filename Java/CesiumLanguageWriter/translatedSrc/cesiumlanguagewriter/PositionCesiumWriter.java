package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Position} to a {@link CesiumOutputStream}. A {@code Position} is defines a position. The position can optionally vary over time.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class PositionCesiumWriter extends CesiumInterpolatablePropertyWriter<PositionCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumCartesian3ValuePropertyWriter,
        ICesiumCartographicRadiansValuePropertyWriter, ICesiumCartographicDegreesValuePropertyWriter, ICesiumCartesian3VelocityValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code referenceFrame} property.
    */
    public static final String ReferenceFramePropertyName = "referenceFrame";
    /**
    * The name of the {@code cartesian} property.
    */
    public static final String CartesianPropertyName = "cartesian";
    /**
    * The name of the {@code cartographicRadians} property.
    */
    public static final String CartographicRadiansPropertyName = "cartographicRadians";
    /**
    * The name of the {@code cartographicDegrees} property.
    */
    public static final String CartographicDegreesPropertyName = "cartographicDegrees";
    /**
    * The name of the {@code cartesianVelocity} property.
    */
    public static final String CartesianVelocityPropertyName = "cartesianVelocity";
    /**
    * The name of the {@code reference} property.
    */
    public static final String ReferencePropertyName = "reference";
    /**
    * The name of the {@code delete} property.
    */
    public static final String DeletePropertyName = "delete";
    private Lazy<CesiumCartesian3ValuePropertyAdaptor<PositionCesiumWriter>> m_asCartesian;
    private Lazy<CesiumCartographicRadiansValuePropertyAdaptor<PositionCesiumWriter>> m_asCartographicRadians;
    private Lazy<CesiumCartographicDegreesValuePropertyAdaptor<PositionCesiumWriter>> m_asCartographicDegrees;
    private Lazy<CesiumCartesian3VelocityValuePropertyAdaptor<PositionCesiumWriter>> m_asCartesianVelocity;
    private Lazy<CesiumReferenceValuePropertyAdaptor<PositionCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public PositionCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asCartesian = createAsCartesian();
        m_asCartographicRadians = createAsCartographicRadians();
        m_asCartographicDegrees = createAsCartographicDegrees();
        m_asCartesianVelocity = createAsCartesianVelocity();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected PositionCesiumWriter(@Nonnull PositionCesiumWriter existingInstance) {
        super(existingInstance);
        m_asCartesian = createAsCartesian();
        m_asCartographicRadians = createAsCartographicRadians();
        m_asCartographicDegrees = createAsCartographicDegrees();
        m_asCartesianVelocity = createAsCartesianVelocity();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public PositionCesiumWriter clone() {
        return new PositionCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code referenceFrame}, which is the reference frame in which cartesian positions are specified. Possible values are "FIXED" and "INERTIAL". If not specified, the default value is FIXED.
    * @param value The value.
    */
    public final void writeReferenceFrame(String value) {
        final String PropertyName = ReferenceFramePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the position specified as a three-dimensional Cartesian value, {@code [X, Y, Z]}, in meters relative to the {@code referenceFrame}.
    * @param value The value.
    */
    public final void writeCartesian(@Nonnull Cartesian value) {
        final String PropertyName = CartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian3(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the position specified as a three-dimensional Cartesian value, {@code [X, Y, Z]}, in meters relative to the {@code referenceFrame}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
        writeCartesian(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the position specified as a three-dimensional Cartesian value, {@code [X, Y, Z]}, in meters relative to the {@code referenceFrame}.
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
    * Writes the value expressed as a {@code cartographicRadians}, which is the position specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in radians and Height is in meters.
    * @param value The interval.
    */
    public final void writeCartographicRadians(@Nonnull Cartographic value) {
        final String PropertyName = CartographicRadiansPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographic(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code cartographicRadians}, which is the position specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in radians and Height is in meters.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartographicRadians(List<JulianDate> dates, List<Cartographic> values) {
        writeCartographicRadians(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code cartographicRadians}, which is the position specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in radians and Height is in meters.
    * @param dates The dates at which the value is specified.
    * @param values The position corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartographicRadians(List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
        final String PropertyName = CartographicRadiansPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartographic(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code cartographicDegrees}, which is the position specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees and Height is in meters.
    * @param value The interval.
    */
    public final void writeCartographicDegrees(@Nonnull Cartographic value) {
        final String PropertyName = CartographicDegreesPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographic(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code cartographicDegrees}, which is the position specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees and Height is in meters.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartographicDegrees(List<JulianDate> dates, List<Cartographic> values) {
        writeCartographicDegrees(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code cartographicDegrees}, which is the position specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees and Height is in meters.
    * @param dates The dates at which the value is specified.
    * @param values The position corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartographicDegrees(List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
        final String PropertyName = CartographicDegreesPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartographic(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code cartesianVelocity}, which is the position and velocity specified as a three-dimensional Cartesian value and its derivative, {@code [X, Y, Z, dX, dY, dZ]}, in meters relative to the {@code referenceFrame}.
    * @param value The value.
    */
    public final void writeCartesianVelocity(@Nonnull Motion1<Cartesian> value) {
        final String PropertyName = CartesianVelocityPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian3Velocity(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code cartesianVelocity}, which is the position and velocity specified as a three-dimensional Cartesian value and its derivative, {@code [X, Y, Z, dX, dY, dZ]}, in meters relative to the {@code referenceFrame}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesianVelocity(List<JulianDate> dates, List<Motion1<Cartesian>> values) {
        writeCartesianVelocity(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code cartesianVelocity}, which is the position and velocity specified as a three-dimensional Cartesian value and its derivative, {@code [X, Y, Z, dX, dY, dZ]}, in meters relative to the {@code referenceFrame}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartesianVelocity(List<JulianDate> dates, List<Motion1<Cartesian>> values, int startIndex, int length) {
        final String PropertyName = CartesianVelocityPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartesian3Velocity(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the position specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the position specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the position specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the position specified as a reference to another property.
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
    public final CesiumCartesian3ValuePropertyAdaptor<PositionCesiumWriter> asCartesian() {
        return m_asCartesian.getValue();
    }

    private final Lazy<CesiumCartesian3ValuePropertyAdaptor<PositionCesiumWriter>> createAsCartesian() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartesian3ValuePropertyAdaptor<PositionCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartesian3ValuePropertyAdaptor<PositionCesiumWriter>>(this, "createCartesian3") {
                    public cesiumlanguagewriter.advanced.CesiumCartesian3ValuePropertyAdaptor<PositionCesiumWriter> invoke() {
                        return createCartesian3();
                    }
                }, false);
    }

    private final CesiumCartesian3ValuePropertyAdaptor<PositionCesiumWriter> createCartesian3() {
        return CesiumValuePropertyAdaptors.<PositionCesiumWriter> createCartesian3(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartographicRadiansValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumCartographicRadiansValuePropertyAdaptor<PositionCesiumWriter> asCartographicRadians() {
        return m_asCartographicRadians.getValue();
    }

    private final Lazy<CesiumCartographicRadiansValuePropertyAdaptor<PositionCesiumWriter>> createAsCartographicRadians() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartographicRadiansValuePropertyAdaptor<PositionCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartographicRadiansValuePropertyAdaptor<PositionCesiumWriter>>(this, "createCartographicRadians") {
                    public cesiumlanguagewriter.advanced.CesiumCartographicRadiansValuePropertyAdaptor<PositionCesiumWriter> invoke() {
                        return createCartographicRadians();
                    }
                }, false);
    }

    private final CesiumCartographicRadiansValuePropertyAdaptor<PositionCesiumWriter> createCartographicRadians() {
        return CesiumValuePropertyAdaptors.<PositionCesiumWriter> createCartographicRadians(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartographicDegreesValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumCartographicDegreesValuePropertyAdaptor<PositionCesiumWriter> asCartographicDegrees() {
        return m_asCartographicDegrees.getValue();
    }

    private final Lazy<CesiumCartographicDegreesValuePropertyAdaptor<PositionCesiumWriter>> createAsCartographicDegrees() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartographicDegreesValuePropertyAdaptor<PositionCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartographicDegreesValuePropertyAdaptor<PositionCesiumWriter>>(this, "createCartographicDegrees") {
                    public cesiumlanguagewriter.advanced.CesiumCartographicDegreesValuePropertyAdaptor<PositionCesiumWriter> invoke() {
                        return createCartographicDegrees();
                    }
                }, false);
    }

    private final CesiumCartographicDegreesValuePropertyAdaptor<PositionCesiumWriter> createCartographicDegrees() {
        return CesiumValuePropertyAdaptors.<PositionCesiumWriter> createCartographicDegrees(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartesian3VelocityValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumCartesian3VelocityValuePropertyAdaptor<PositionCesiumWriter> asCartesianVelocity() {
        return m_asCartesianVelocity.getValue();
    }

    private final Lazy<CesiumCartesian3VelocityValuePropertyAdaptor<PositionCesiumWriter>> createAsCartesianVelocity() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartesian3VelocityValuePropertyAdaptor<PositionCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartesian3VelocityValuePropertyAdaptor<PositionCesiumWriter>>(this, "createCartesian3Velocity") {
                    public cesiumlanguagewriter.advanced.CesiumCartesian3VelocityValuePropertyAdaptor<PositionCesiumWriter> invoke() {
                        return createCartesian3Velocity();
                    }
                }, false);
    }

    private final CesiumCartesian3VelocityValuePropertyAdaptor<PositionCesiumWriter> createCartesian3Velocity() {
        return CesiumValuePropertyAdaptors.<PositionCesiumWriter> createCartesian3Velocity(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumReferenceValuePropertyAdaptor<PositionCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    private final Lazy<CesiumReferenceValuePropertyAdaptor<PositionCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<PositionCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<PositionCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<PositionCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    private final CesiumReferenceValuePropertyAdaptor<PositionCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<PositionCesiumWriter> createReference(this);
    }
}