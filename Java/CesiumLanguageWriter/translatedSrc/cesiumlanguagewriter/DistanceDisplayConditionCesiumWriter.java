package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Bounds;
import cesiumlanguagewriter.Reference;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code DistanceDisplayCondition} to a {@link CesiumOutputStream}.  A {@code DistanceDisplayCondition} is indicates the visibility of an object based on the distance to the camera.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class DistanceDisplayConditionCesiumWriter extends CesiumInterpolatablePropertyWriter<DistanceDisplayConditionCesiumWriter> {
    /**
    *  
    The name of the {@code distanceDisplayCondition} property.
    

    */
    public static final String DistanceDisplayConditionPropertyName = "distanceDisplayCondition";
    /**
    *  
    The name of the {@code reference} property.
    

    */
    public static final String ReferencePropertyName = "reference";
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Bounds>> m_asDistanceDisplayCondition;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    

    */
    public DistanceDisplayConditionCesiumWriter(String propertyName) {
        super(propertyName);
        m_asDistanceDisplayCondition = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Bounds>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Bounds>>(this, "createDistanceDisplayConditionAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Bounds> invoke() {
                        return createDistanceDisplayConditionAdaptor();
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
    protected DistanceDisplayConditionCesiumWriter(DistanceDisplayConditionCesiumWriter existingInstance) {
        super(existingInstance);
        m_asDistanceDisplayCondition = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Bounds>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Bounds>>(this, "createDistanceDisplayConditionAdaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Bounds> invoke() {
                        return createDistanceDisplayConditionAdaptor();
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
    public DistanceDisplayConditionCesiumWriter clone() {
        return new DistanceDisplayConditionCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code distanceDisplayCondition}, which is the value specified as two values {@code [NearDistance, FarDistance]}, with distances in meters.
    
    

    * @param value The value.
    */
    public final void writeDistanceDisplayCondition(@Nonnull Bounds value) {
        final String PropertyName = DistanceDisplayConditionPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeBounds(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code distanceDisplayCondition}, which is the value specified as two values {@code [NearDistance, FarDistance]}, with distances in meters.
    
    
    

    * @param lowerBound The lower bound.
    * @param upperBound The upper bound.
    */
    public final void writeDistanceDisplayCondition(double lowerBound, double upperBound) {
        writeDistanceDisplayCondition(new Bounds(lowerBound, upperBound));
    }

    /**
    *  
    Writes the value expressed as a {@code distanceDisplayCondition}, which is the value specified as two values {@code [NearDistance, FarDistance]}, with distances in meters.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeDistanceDisplayCondition(List<JulianDate> dates, List<Bounds> values) {
        writeDistanceDisplayCondition(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code distanceDisplayCondition}, which is the value specified as two values {@code [NearDistance, FarDistance]}, with distances in meters.
    
    
    
    
    

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
    *  
    Writes the value expressed as a {@code reference}, which is the value specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the value specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the value specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the value specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code DistanceDisplayCondition} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Bounds> asDistanceDisplayCondition() {
        return m_asDistanceDisplayCondition.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Bounds> createDistanceDisplayConditionAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter, cesiumlanguagewriter.Bounds>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter, cesiumlanguagewriter.Bounds>() {
                    public void invoke(DistanceDisplayConditionCesiumWriter me, Bounds value) {
                        me.writeDistanceDisplayCondition(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter, cesiumlanguagewriter.Bounds>() {
                    public void invoke(DistanceDisplayConditionCesiumWriter me, List<JulianDate> dates, List<Bounds> values, int startIndex, int length) {
                        me.writeDistanceDisplayCondition(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code Reference} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Reference> asReference() {
        return m_asReference.getValue();
    }

    private final ICesiumValuePropertyWriter<Reference> createReferenceAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DistanceDisplayConditionCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(DistanceDisplayConditionCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}