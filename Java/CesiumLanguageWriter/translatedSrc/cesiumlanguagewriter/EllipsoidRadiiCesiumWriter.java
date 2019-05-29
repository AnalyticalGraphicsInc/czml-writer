package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code EllipsoidRadii} to a {@link CesiumOutputStream}. A {@code EllipsoidRadii} is the radii of an ellipsoid.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class EllipsoidRadiiCesiumWriter extends CesiumInterpolatablePropertyWriter<EllipsoidRadiiCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumCartesian3ValuePropertyWriter,
        ICesiumReferenceValuePropertyWriter {
    /**
    *  
    The name of the {@code cartesian} property.
    

    */
    public static final String CartesianPropertyName = "cartesian";
    /**
    *  
    The name of the {@code reference} property.
    

    */
    public static final String ReferencePropertyName = "reference";
    /**
    *  
    The name of the {@code delete} property.
    

    */
    public static final String DeletePropertyName = "delete";
    private Lazy<CesiumCartesian3ValuePropertyAdaptor<EllipsoidRadiiCesiumWriter>> m_asCartesian;
    private Lazy<CesiumReferenceValuePropertyAdaptor<EllipsoidRadiiCesiumWriter>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public EllipsoidRadiiCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asCartesian = createAsCartesian();
        m_asReference = createAsReference();
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected EllipsoidRadiiCesiumWriter(@Nonnull EllipsoidRadiiCesiumWriter existingInstance) {
        super(existingInstance);
        m_asCartesian = createAsCartesian();
        m_asReference = createAsReference();
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public EllipsoidRadiiCesiumWriter clone() {
        return new EllipsoidRadiiCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian}, which is the radii specified as a three-dimensional Cartesian value {@code [X, Y, Z]}, in world coordinates in meters.
    
    

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
    Writes the value expressed as a {@code cartesian}, which is the radii specified as a three-dimensional Cartesian value {@code [X, Y, Z]}, in world coordinates in meters.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
        writeCartesian(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian}, which is the radii specified as a three-dimensional Cartesian value {@code [X, Y, Z]}, in world coordinates in meters.
    
    
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the radii specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the radii specified as a reference to another property.
    
    

    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the radii specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the radii specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumCartesian3ValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumCartesian3ValuePropertyAdaptor<EllipsoidRadiiCesiumWriter> asCartesian() {
        return m_asCartesian.getValue();
    }

    private final Lazy<CesiumCartesian3ValuePropertyAdaptor<EllipsoidRadiiCesiumWriter>> createAsCartesian() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartesian3ValuePropertyAdaptor<EllipsoidRadiiCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartesian3ValuePropertyAdaptor<EllipsoidRadiiCesiumWriter>>(this, "createCartesian3") {
                    public cesiumlanguagewriter.advanced.CesiumCartesian3ValuePropertyAdaptor<EllipsoidRadiiCesiumWriter> invoke() {
                        return createCartesian3();
                    }
                }, false);
    }

    private final CesiumCartesian3ValuePropertyAdaptor<EllipsoidRadiiCesiumWriter> createCartesian3() {
        return CesiumValuePropertyAdaptors.<EllipsoidRadiiCesiumWriter> createCartesian3(this);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumReferenceValuePropertyAdaptor<EllipsoidRadiiCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    private final Lazy<CesiumReferenceValuePropertyAdaptor<EllipsoidRadiiCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<EllipsoidRadiiCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<EllipsoidRadiiCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<EllipsoidRadiiCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    private final CesiumReferenceValuePropertyAdaptor<EllipsoidRadiiCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<EllipsoidRadiiCesiumWriter> createReference(this);
    }
}