package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code Rotation} to a {@link CesiumOutputStream}. A {@code Rotation} is defines a rotation that transforms a vector expressed in one axes and transforms it to another.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class RotationCesiumWriter extends CesiumInterpolatablePropertyWriter<RotationCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumUnitQuaternionValuePropertyWriter,
        ICesiumReferenceValuePropertyWriter {
    /**
    *  
    The name of the {@code unitQuaternion} property.
    

    */
    public static final String UnitQuaternionPropertyName = "unitQuaternion";
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
    private Lazy<CesiumUnitQuaternionValuePropertyAdaptor<RotationCesiumWriter>> m_asUnitQuaternion;
    private Lazy<CesiumReferenceValuePropertyAdaptor<RotationCesiumWriter>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public RotationCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asUnitQuaternion = createAsUnitQuaternion();
        m_asReference = createAsReference();
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected RotationCesiumWriter(@Nonnull RotationCesiumWriter existingInstance) {
        super(existingInstance);
        m_asUnitQuaternion = createAsUnitQuaternion();
        m_asReference = createAsReference();
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public RotationCesiumWriter clone() {
        return new RotationCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code unitQuaternion}, which is the rotation specified as a 4-dimensional unit magnitude quaternion, specified as {@code [X, Y, Z, W]}.
    
    

    * @param value The value.
    */
    public final void writeUnitQuaternion(@Nonnull UnitQuaternion value) {
        final String PropertyName = UnitQuaternionPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitQuaternion(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code unitQuaternion}, which is the rotation specified as a 4-dimensional unit magnitude quaternion, specified as {@code [X, Y, Z, W]}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeUnitQuaternion(List<JulianDate> dates, List<UnitQuaternion> values) {
        writeUnitQuaternion(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code unitQuaternion}, which is the rotation specified as a 4-dimensional unit magnitude quaternion, specified as {@code [X, Y, Z, W]}.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeUnitQuaternion(List<JulianDate> dates, List<UnitQuaternion> values, int startIndex, int length) {
        final String PropertyName = UnitQuaternionPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeUnitQuaternion(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the rotation specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the rotation specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the rotation specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the rotation specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumUnitQuaternionValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumUnitQuaternionValuePropertyAdaptor<RotationCesiumWriter> asUnitQuaternion() {
        return m_asUnitQuaternion.getValue();
    }

    private final Lazy<CesiumUnitQuaternionValuePropertyAdaptor<RotationCesiumWriter>> createAsUnitQuaternion() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumUnitQuaternionValuePropertyAdaptor<RotationCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumUnitQuaternionValuePropertyAdaptor<RotationCesiumWriter>>(this, "createUnitQuaternion") {
                    public cesiumlanguagewriter.advanced.CesiumUnitQuaternionValuePropertyAdaptor<RotationCesiumWriter> invoke() {
                        return createUnitQuaternion();
                    }
                }, false);
    }

    private final CesiumUnitQuaternionValuePropertyAdaptor<RotationCesiumWriter> createUnitQuaternion() {
        return CesiumValuePropertyAdaptors.<RotationCesiumWriter> createUnitQuaternion(this);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumReferenceValuePropertyAdaptor<RotationCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    private final Lazy<CesiumReferenceValuePropertyAdaptor<RotationCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<RotationCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<RotationCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<RotationCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    private final CesiumReferenceValuePropertyAdaptor<RotationCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<RotationCesiumWriter> createReference(this);
    }
}