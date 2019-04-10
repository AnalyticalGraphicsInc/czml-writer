package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Reference;
import cesiumlanguagewriter.UnitCartesian;
import cesiumlanguagewriter.UnitSpherical;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code AlignedAxis} to a {@link CesiumOutputStream}. A {@code AlignedAxis} is an aligned axis represented by a unit vector which can optionally vary over time.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class AlignedAxisCesiumWriter extends CesiumInterpolatablePropertyWriter<AlignedAxisCesiumWriter> {
    /**
    *  
    The name of the {@code unitCartesian} property.
    

    */
    public static final String UnitCartesianPropertyName = "unitCartesian";
    /**
    *  
    The name of the {@code unitSpherical} property.
    

    */
    public static final String UnitSphericalPropertyName = "unitSpherical";
    /**
    *  
    The name of the {@code reference} property.
    

    */
    public static final String ReferencePropertyName = "reference";
    /**
    *  
    The name of the {@code velocityReference} property.
    

    */
    public static final String VelocityReferencePropertyName = "velocityReference";
    /**
    *  
    The name of the {@code delete} property.
    

    */
    public static final String DeletePropertyName = "delete";
    private Lazy<ICesiumInterpolatableValuePropertyWriter<UnitCartesian>> m_asUnitCartesian;
    private Lazy<ICesiumInterpolatableValuePropertyWriter<UnitSpherical>> m_asUnitSpherical;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asVelocityReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public AlignedAxisCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asUnitCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(this, "createUnitCartesianAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian> invoke() {
                        return createUnitCartesianAdaptor();
                    }
                }, false);
        m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(this, "createUnitSphericalAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical> invoke() {
                        return createUnitSphericalAdaptor();
                    }
                }, false);
        m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
                "createReferenceAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
                return createReferenceAdaptor();
            }
        }, false);
        m_asVelocityReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
                "createVelocityReferenceAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
                return createVelocityReferenceAdaptor();
            }
        }, false);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected AlignedAxisCesiumWriter(@Nonnull AlignedAxisCesiumWriter existingInstance) {
        super(existingInstance);
        m_asUnitCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(this, "createUnitCartesianAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitCartesian> invoke() {
                        return createUnitCartesianAdaptor();
                    }
                }, false);
        m_asUnitSpherical = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(this, "createUnitSphericalAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<UnitSpherical> invoke() {
                        return createUnitSphericalAdaptor();
                    }
                }, false);
        m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
                "createReferenceAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
                return createReferenceAdaptor();
            }
        }, false);
        m_asVelocityReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
                "createVelocityReferenceAdaptor") {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
                return createVelocityReferenceAdaptor();
            }
        }, false);
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public AlignedAxisCesiumWriter clone() {
        return new AlignedAxisCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code unitCartesian}, which is the axis specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}, in world coordinates.
    
    

    * @param value The value.
    */
    public final void writeUnitCartesian(@Nonnull UnitCartesian value) {
        final String PropertyName = UnitCartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitCartesian3(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code unitCartesian}, which is the axis specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}, in world coordinates.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values) {
        writeUnitCartesian(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code unitCartesian}, which is the axis specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}, in world coordinates.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values, int startIndex, int length) {
        final String PropertyName = UnitCartesianPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeUnitCartesian3(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code unitSpherical}, which is the axis specified as a unit spherical value {@code [Clock, Cone]}, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    

    * @param value The value.
    */
    public final void writeUnitSpherical(@Nonnull UnitSpherical value) {
        final String PropertyName = UnitSphericalPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitSpherical(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code unitSpherical}, which is the axis specified as a unit spherical value {@code [Clock, Cone]}, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values) {
        writeUnitSpherical(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code unitSpherical}, which is the axis specified as a unit spherical value {@code [Clock, Cone]}, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values, int startIndex, int length) {
        final String PropertyName = UnitSphericalPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeUnitSpherical(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the axis specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the axis specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the axis specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the axis specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code velocityReference}, which is the axis specified as the normalized velocity vector of a position property. The reference must be to a {@code position} property.
    
    

    * @param value The reference.
    */
    public final void writeVelocityReference(Reference value) {
        final String PropertyName = VelocityReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code velocityReference}, which is the axis specified as the normalized velocity vector of a position property. The reference must be to a {@code position} property.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeVelocityReference(String value) {
        final String PropertyName = VelocityReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code velocityReference}, which is the axis specified as the normalized velocity vector of a position property. The reference must be to a {@code position} property.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeVelocityReference(String identifier, String propertyName) {
        final String PropertyName = VelocityReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), identifier, propertyName);
    }

    /**
    *  
    Writes the value expressed as a {@code velocityReference}, which is the axis specified as the normalized velocity vector of a position property. The reference must be to a {@code position} property.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeVelocityReference(String identifier, String[] propertyNames) {
        final String PropertyName = VelocityReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), identifier, propertyNames);
    }

    /**
    *  
    Writes the value expressed as a {@code delete}, which is whether the client should delete existing samples or interval data for this property. Data will be deleted for the containing interval, or if there is no containing interval, then all data. If true, all other properties in this property will be ignored.
    
    

    * @param value The value.
    */
    public final void writeDelete(boolean value) {
        final String PropertyName = DeletePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code UnitCartesian} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<UnitCartesian> asUnitCartesian() {
        return m_asUnitCartesian.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<UnitCartesian> createUnitCartesianAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.AlignedAxisCesiumWriter, cesiumlanguagewriter.UnitCartesian>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.AlignedAxisCesiumWriter, cesiumlanguagewriter.UnitCartesian>() {
                    public void invoke(AlignedAxisCesiumWriter me, UnitCartesian value) {
                        me.writeUnitCartesian(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.AlignedAxisCesiumWriter, cesiumlanguagewriter.UnitCartesian>() {
                    public void invoke(AlignedAxisCesiumWriter me, List<JulianDate> dates, List<UnitCartesian> values, int startIndex, int length) {
                        me.writeUnitCartesian(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code UnitSpherical} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<UnitSpherical> asUnitSpherical() {
        return m_asUnitSpherical.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<UnitSpherical> createUnitSphericalAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.AlignedAxisCesiumWriter, cesiumlanguagewriter.UnitSpherical>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.AlignedAxisCesiumWriter, cesiumlanguagewriter.UnitSpherical>() {
                    public void invoke(AlignedAxisCesiumWriter me, UnitSpherical value) {
                        me.writeUnitSpherical(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.AlignedAxisCesiumWriter, cesiumlanguagewriter.UnitSpherical>() {
                    public void invoke(AlignedAxisCesiumWriter me, List<JulianDate> dates, List<UnitSpherical> values, int startIndex, int length) {
                        me.writeUnitSpherical(dates, values, startIndex, length);
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
        return new CesiumWriterAdaptor<cesiumlanguagewriter.AlignedAxisCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.AlignedAxisCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(AlignedAxisCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code VelocityReference} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Reference> asVelocityReference() {
        return m_asVelocityReference.getValue();
    }

    private final ICesiumValuePropertyWriter<Reference> createVelocityReferenceAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.AlignedAxisCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.AlignedAxisCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(AlignedAxisCesiumWriter me, Reference value) {
                        me.writeVelocityReference(value);
                    }
                });
    }
}