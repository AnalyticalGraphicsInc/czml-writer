package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code LineOffset} to a {@link CesiumOutputStream}. A {@code LineOffset} is the offset of grid lines along each axis, as a percentage from 0 to 1.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class LineOffsetCesiumWriter extends CesiumInterpolatablePropertyWriter<LineOffsetCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumCartesian2ValuePropertyWriter,
        ICesiumReferenceValuePropertyWriter {
    /**
    *  
    The name of the {@code cartesian2} property.
    

    */
    public static final String Cartesian2PropertyName = "cartesian2";
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
    private Lazy<CesiumCartesian2ValuePropertyAdaptor<LineOffsetCesiumWriter>> m_asCartesian2;
    private Lazy<CesiumReferenceValuePropertyAdaptor<LineOffsetCesiumWriter>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public LineOffsetCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asCartesian2 = createAsCartesian2();
        m_asReference = createAsReference();
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected LineOffsetCesiumWriter(@Nonnull LineOffsetCesiumWriter existingInstance) {
        super(existingInstance);
        m_asCartesian2 = createAsCartesian2();
        m_asReference = createAsReference();
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public LineOffsetCesiumWriter clone() {
        return new LineOffsetCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian2}, which is the offset of grid lines along each axis, specified as a percentage from 0 to 1.
    
    

    * @param value The value.
    */
    public final void writeCartesian2(@Nonnull Rectangular value) {
        final String PropertyName = Cartesian2PropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian2(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian2}, which is the offset of grid lines along each axis, specified as a percentage from 0 to 1.
    
    
    

    * @param x The X component.
    * @param y The Y component.
    */
    public final void writeCartesian2(double x, double y) {
        writeCartesian2(new Rectangular(x, y));
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian2}, which is the offset of grid lines along each axis, specified as a percentage from 0 to 1.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesian2(List<JulianDate> dates, List<Rectangular> values) {
        writeCartesian2(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian2}, which is the offset of grid lines along each axis, specified as a percentage from 0 to 1.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartesian2(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        final String PropertyName = Cartesian2PropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartesian2(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the offset of grid lines along each axis specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the offset of grid lines along each axis specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the offset of grid lines along each axis specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the offset of grid lines along each axis specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumCartesian2ValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumCartesian2ValuePropertyAdaptor<LineOffsetCesiumWriter> asCartesian2() {
        return m_asCartesian2.getValue();
    }

    private final Lazy<CesiumCartesian2ValuePropertyAdaptor<LineOffsetCesiumWriter>> createAsCartesian2() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartesian2ValuePropertyAdaptor<LineOffsetCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartesian2ValuePropertyAdaptor<LineOffsetCesiumWriter>>(this, "createCartesian2") {
                    public cesiumlanguagewriter.advanced.CesiumCartesian2ValuePropertyAdaptor<LineOffsetCesiumWriter> invoke() {
                        return createCartesian2();
                    }
                }, false);
    }

    private final CesiumCartesian2ValuePropertyAdaptor<LineOffsetCesiumWriter> createCartesian2() {
        return CesiumValuePropertyAdaptors.<LineOffsetCesiumWriter> createCartesian2(this);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumReferenceValuePropertyAdaptor<LineOffsetCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    private final Lazy<CesiumReferenceValuePropertyAdaptor<LineOffsetCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<LineOffsetCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<LineOffsetCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<LineOffsetCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    private final CesiumReferenceValuePropertyAdaptor<LineOffsetCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<LineOffsetCesiumWriter> createReference(this);
    }
}