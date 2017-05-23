package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.NearFarScalar;
import cesiumlanguagewriter.Reference;
import java.util.List;

/**
 *  
 Writes a {@code NearFarScalar} to a {@link CesiumOutputStream}.  A {@code NearFarScalar} is a numeric value which will be linearly interpolated between two values based on an object's distance from the camera, in eye coordinates.  The computed value will interpolate between the near value and the far value while the camera distance falls between the near distance and the far distance, and will be clamped to the near or far value while the distance is less than the near distance or greater than the far distance, respectively.
 

 */
@SuppressWarnings("unused")
public class NearFarScalarCesiumWriter extends CesiumInterpolatablePropertyWriter<NearFarScalarCesiumWriter> {
    /**
    *  
    The name of the {@code nearFarScalar} property.
    

    */
    public static final String NearFarScalarPropertyName = "nearFarScalar";
    /**
    *  
    The name of the {@code reference} property.
    

    */
    public static final String ReferencePropertyName = "reference";
    private Lazy<ICesiumInterpolatableValuePropertyWriter<NearFarScalar>> m_asNearFarScalar;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    

    */
    public NearFarScalarCesiumWriter(String propertyName) {
        super(propertyName);
        m_asNearFarScalar = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<NearFarScalar>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<NearFarScalar>>(this, "createNearFarScalarAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<NearFarScalar> invoke() {
                        return createNearFarScalarAdaptor();
                    }
                }, false);
        m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
                "createReferenceAdaptor", new Class[] {}) {
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
    protected NearFarScalarCesiumWriter(NearFarScalarCesiumWriter existingInstance) {
        super(existingInstance);
        m_asNearFarScalar = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<NearFarScalar>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<NearFarScalar>>(this, "createNearFarScalarAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<NearFarScalar> invoke() {
                        return createNearFarScalarAdaptor();
                    }
                }, false);
        m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
                "createReferenceAdaptor", new Class[] {}) {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
                return createReferenceAdaptor();
            }
        }, false);
    }

    @Override
    public NearFarScalarCesiumWriter clone() {
        return new NearFarScalarCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code nearFarScalar}, which is the value specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}, with distances in eye coordinates in meters.
    
    

    * @param value The value.
    */
    public final void writeNearFarScalar(NearFarScalar value) {
        final String PropertyName = NearFarScalarPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeNearFarScalar(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code nearFarScalar}, which is the value specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}, with distances in eye coordinates in meters.
    
    
    
    
    

    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public final void writeNearFarScalar(double nearDistance, double nearValue, double farDistance, double farValue) {
        writeNearFarScalar(new NearFarScalar(nearDistance, nearValue, farDistance, farValue));
    }

    /**
    *  
    Writes the value expressed as a {@code nearFarScalar}, which is the value specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}, with distances in eye coordinates in meters.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeNearFarScalar(List<JulianDate> dates, List<NearFarScalar> values) {
        writeNearFarScalar(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code nearFarScalar}, which is the value specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}, with distances in eye coordinates in meters.
    
    
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code NearFarScalar} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<NearFarScalar> asNearFarScalar() {
        return m_asNearFarScalar.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<NearFarScalar> createNearFarScalarAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.NearFarScalarCesiumWriter, cesiumlanguagewriter.NearFarScalar>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.NearFarScalarCesiumWriter, cesiumlanguagewriter.NearFarScalar>() {
                    public void invoke(NearFarScalarCesiumWriter me, NearFarScalar value) {
                        me.writeNearFarScalar(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.NearFarScalarCesiumWriter, cesiumlanguagewriter.NearFarScalar>() {
                    public void invoke(NearFarScalarCesiumWriter me, List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
                        me.writeNearFarScalar(dates, values, startIndex, length);
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
        return new CesiumWriterAdaptor<cesiumlanguagewriter.NearFarScalarCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.NearFarScalarCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(NearFarScalarCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}