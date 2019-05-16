package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Rectangular;
import cesiumlanguagewriter.Reference;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code LineThickness} to a {@link CesiumOutputStream}. A {@code LineThickness} is the thickness of grid lines along each axis, in pixels.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class LineThicknessCesiumWriter extends CesiumInterpolatablePropertyWriter<LineThicknessCesiumWriter> {
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
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Rectangular>> m_asCartesian2;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public LineThicknessCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asCartesian2 = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(this, "createCartesian2Adaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular> invoke() {
                        return createCartesian2Adaptor();
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
    protected LineThicknessCesiumWriter(@Nonnull LineThicknessCesiumWriter existingInstance) {
        super(existingInstance);
        m_asCartesian2 = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular>>(this, "createCartesian2Adaptor") {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Rectangular> invoke() {
                        return createCartesian2Adaptor();
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
    public LineThicknessCesiumWriter clone() {
        return new LineThicknessCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian2}, which is the thickness specified as a two-dimensional Cartesian value {@code [X, Y]}, in pixels.
    
    

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
    Writes the value expressed as a {@code cartesian2}, which is the thickness specified as a two-dimensional Cartesian value {@code [X, Y]}, in pixels.
    
    
    

    * @param x The X component.
    * @param y The Y component.
    */
    public final void writeCartesian2(double x, double y) {
        writeCartesian2(new Rectangular(x, y));
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian2}, which is the thickness specified as a two-dimensional Cartesian value {@code [X, Y]}, in pixels.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesian2(List<JulianDate> dates, List<Rectangular> values) {
        writeCartesian2(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code cartesian2}, which is the thickness specified as a two-dimensional Cartesian value {@code [X, Y]}, in pixels.
    
    
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the thickness specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the thickness specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the thickness specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the thickness specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code Cartesian2} format. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Rectangular> asCartesian2() {
        return m_asCartesian2.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Rectangular> createCartesian2Adaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.LineThicknessCesiumWriter, cesiumlanguagewriter.Rectangular>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.LineThicknessCesiumWriter, cesiumlanguagewriter.Rectangular>() {
                    public void invoke(LineThicknessCesiumWriter me, Rectangular value) {
                        me.writeCartesian2(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.LineThicknessCesiumWriter, cesiumlanguagewriter.Rectangular>() {
                    public void invoke(LineThicknessCesiumWriter me, List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
                        me.writeCartesian2(dates, values, startIndex, length);
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
        return new CesiumWriterAdaptor<cesiumlanguagewriter.LineThicknessCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.LineThicknessCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(LineThicknessCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}