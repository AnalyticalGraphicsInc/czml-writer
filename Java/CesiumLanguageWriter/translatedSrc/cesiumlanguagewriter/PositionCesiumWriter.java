package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Cartesian;
import cesiumlanguagewriter.Cartographic;
import cesiumlanguagewriter.Motion1;
import cesiumlanguagewriter.Reference;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code Position} to a {@link CesiumOutputStream}. A {@code Position} is defines a position. The position can optionally vary over time.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class PositionCesiumWriter extends CesiumInterpolatablePropertyWriter<PositionCesiumWriter> {
    /**
    *  
    The name of the {@code referenceFrame} property.
    

    */
    public static final String ReferenceFramePropertyName = "referenceFrame";
    /**
    *  
    The name of the {@code cartesian} property.
    

    */
    public static final String CartesianPropertyName = "cartesian";
    /**
    *  
    The name of the {@code cartographicRadians} property.
    

    */
    public static final String CartographicRadiansPropertyName = "cartographicRadians";
    /**
    *  
    The name of the {@code cartographicDegrees} property.
    

    */
    public static final String CartographicDegreesPropertyName = "cartographicDegrees";
    /**
    *  
    The name of the {@code cartesianVelocity} property.
    

    */
    public static final String CartesianVelocityPropertyName = "cartesianVelocity";
    /**
    *  
    The name of the {@code reference} property.
    

    */
    public static final String ReferencePropertyName = "reference";
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicRadians;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicDegrees;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>>> m_asCartesianVelocity;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public PositionCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
                        return createCartesianAdaptor();
                    }
                }, false);
        m_asCartographicRadians = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(this, "createCartographicRadiansAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic> invoke() {
                        return createCartographicRadiansAdaptor();
                    }
                }, false);
        m_asCartographicDegrees = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(this, "createCartographicDegreesAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic> invoke() {
                        return createCartographicDegreesAdaptor();
                    }
                }, false);
        m_asCartesianVelocity = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>>>(this, "createCartesianVelocityAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>> invoke() {
                        return createCartesianVelocityAdaptor();
                    }
                }, false);
        m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
                "createReferenceAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
                return createReferenceAdaptor();
            }
        }, false);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected PositionCesiumWriter(@Nonnull PositionCesiumWriter existingInstance) {
        super(existingInstance);
        m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian>>(this, "createCartesianAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartesian> invoke() {
                        return createCartesianAdaptor();
                    }
                }, false);
        m_asCartographicRadians = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(this, "createCartographicRadiansAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic> invoke() {
                        return createCartographicRadiansAdaptor();
                    }
                }, false);
        m_asCartographicDegrees = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic>>(this, "createCartographicDegreesAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Cartographic> invoke() {
                        return createCartographicDegreesAdaptor();
                    }
                }, false);
        m_asCartesianVelocity = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>>>(this, "createCartesianVelocityAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>> invoke() {
                        return createCartesianVelocityAdaptor();
                    }
                }, false);
        m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
                "createReferenceAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
                return createReferenceAdaptor();
            }
        }, false);
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public PositionCesiumWriter clone() {
        return new PositionCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code referenceFrame}, which is the reference frame in which cartesian positions are specified. Possible values are "FIXED" and "INERTIAL". If not specified, the default value is FIXED.
    
    

    * @param value The value.
    */
    public final void writeReferenceFrame(String value) {
        final String PropertyName = ReferenceFramePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian}, which is the position specified as a three-dimensional Cartesian value, {@code [X, Y, Z]}, in meters relative to the {@code referenceFrame}.
    
    

    * @param value The value.
    */
    public final void writeCartesian(@Nonnull Cartesian value) {
        final String PropertyName = CartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian3(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian}, which is the position specified as a three-dimensional Cartesian value, {@code [X, Y, Z]}, in meters relative to the {@code referenceFrame}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
        writeCartesian(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian}, which is the position specified as a three-dimensional Cartesian value, {@code [X, Y, Z]}, in meters relative to the {@code referenceFrame}.
    
    
    
    
    

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
    *  
    Writes the value expressed as a {@code cartographicRadians}, which is the position specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in radians and Height is in meters.
    
    

    * @param value The interval.
    */
    public final void writeCartographicRadians(@Nonnull Cartographic value) {
        final String PropertyName = CartographicRadiansPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographic(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code cartographicRadians}, which is the position specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in radians and Height is in meters.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartographicRadians(List<JulianDate> dates, List<Cartographic> values) {
        writeCartographicRadians(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code cartographicRadians}, which is the position specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in radians and Height is in meters.
    
    
    
    
    

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
    *  
    Writes the value expressed as a {@code cartographicDegrees}, which is the position specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees and Height is in meters.
    
    

    * @param value The interval.
    */
    public final void writeCartographicDegrees(@Nonnull Cartographic value) {
        final String PropertyName = CartographicDegreesPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographic(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code cartographicDegrees}, which is the position specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees and Height is in meters.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartographicDegrees(List<JulianDate> dates, List<Cartographic> values) {
        writeCartographicDegrees(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code cartographicDegrees}, which is the position specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees and Height is in meters.
    
    
    
    
    

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
    *  
    Writes the value expressed as a {@code cartesianVelocity}, which is the position and velocity specified as a three-dimensional Cartesian value and its derivative, {@code [X, Y, Z, dX, dY, dZ]}, in meters relative to the {@code referenceFrame}.
    
    

    * @param value The value.
    */
    public final void writeCartesianVelocity(@Nonnull Motion1<Cartesian> value) {
        final String PropertyName = CartesianVelocityPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian3Velocity(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code cartesianVelocity}, which is the position and velocity specified as a three-dimensional Cartesian value and its derivative, {@code [X, Y, Z, dX, dY, dZ]}, in meters relative to the {@code referenceFrame}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesianVelocity(List<JulianDate> dates, List<Motion1<Cartesian>> values) {
        writeCartesianVelocity(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code cartesianVelocity}, which is the position and velocity specified as a three-dimensional Cartesian value and its derivative, {@code [X, Y, Z, dX, dY, dZ]}, in meters relative to the {@code referenceFrame}.
    
    
    
    
    

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
    *  
    Writes the value expressed as a {@code reference}, which is the position specified as a reference to another property.
    
    

    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the position specified as a reference to another property.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the position specified as a reference to another property.
    
    
    

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
    *  
    Writes the value expressed as a {@code reference}, which is the position specified as a reference to another property.
    
    
    

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
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code Cartesian} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Cartesian> asCartesian() {
        return m_asCartesian.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Cartesian> createCartesianAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartesian>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartesian>() {
                    public void invoke(PositionCesiumWriter me, Cartesian value) {
                        me.writeCartesian(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartesian>() {
                    public void invoke(PositionCesiumWriter me, List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
                        me.writeCartesian(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code CartographicRadians} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Cartographic> asCartographicRadians() {
        return m_asCartographicRadians.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Cartographic> createCartographicRadiansAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartographic>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartographic>() {
                    public void invoke(PositionCesiumWriter me, Cartographic value) {
                        me.writeCartographicRadians(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartographic>() {
                    public void invoke(PositionCesiumWriter me, List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
                        me.writeCartographicRadians(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code CartographicDegrees} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Cartographic> asCartographicDegrees() {
        return m_asCartographicDegrees.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Cartographic> createCartographicDegreesAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartographic>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartographic>() {
                    public void invoke(PositionCesiumWriter me, Cartographic value) {
                        me.writeCartographicDegrees(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Cartographic>() {
                    public void invoke(PositionCesiumWriter me, List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
                        me.writeCartographicDegrees(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code CartesianVelocity} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>> asCartesianVelocity() {
        return m_asCartesianVelocity.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Motion1<Cartesian>> createCartesianVelocityAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Motion1<Cartesian>>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Motion1<Cartesian>>() {
                    public void invoke(PositionCesiumWriter me, Motion1<Cartesian> value) {
                        me.writeCartesianVelocity(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Motion1<Cartesian>>() {
                    public void invoke(PositionCesiumWriter me, List<JulianDate> dates, List<Motion1<Cartesian>> values, int startIndex, int length) {
                        me.writeCartesianVelocity(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code Reference} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Reference> asReference() {
        return m_asReference.getValue();
    }

    private final ICesiumValuePropertyWriter<Reference> createReferenceAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(PositionCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}