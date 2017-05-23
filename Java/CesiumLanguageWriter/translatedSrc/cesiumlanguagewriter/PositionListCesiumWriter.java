package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a {@code PositionList} to a {@link CesiumOutputStream}.  A {@code PositionList} is a list of positions.
 

 */
@SuppressWarnings("unused")
public class PositionListCesiumWriter extends CesiumPropertyWriter<PositionListCesiumWriter> {
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
    The name of the {@code references} property.
    

    */
    public static final String ReferencesPropertyName = "references";
    private Lazy<ICesiumValuePropertyWriter<Iterable<Cartesian>>> m_asCartesian;
    private Lazy<ICesiumValuePropertyWriter<Iterable<Cartographic>>> m_asCartographicRadians;
    private Lazy<ICesiumValuePropertyWriter<Iterable<Cartographic>>> m_asCartographicDegrees;
    private Lazy<ICesiumValuePropertyWriter<Iterable<Reference>>> m_asReferences;

    /**
    *  
    Initializes a new instance.
    

    */
    public PositionListCesiumWriter(String propertyName) {
        super(propertyName);
        m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartesian>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartesian>>>(this, "createCartesianAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartesian>> invoke() {
                        return createCartesianAdaptor();
                    }
                }, false);
        m_asCartographicRadians = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartographic>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartographic>>>(this, "createCartographicRadiansAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartographic>> invoke() {
                        return createCartographicRadiansAdaptor();
                    }
                }, false);
        m_asCartographicDegrees = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartographic>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartographic>>>(this, "createCartographicDegreesAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartographic>> invoke() {
                        return createCartographicDegreesAdaptor();
                    }
                }, false);
        m_asReferences = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Reference>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Reference>>>(this, "createReferencesAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Reference>> invoke() {
                        return createReferencesAdaptor();
                    }
                }, false);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected PositionListCesiumWriter(PositionListCesiumWriter existingInstance) {
        super(existingInstance);
        m_asCartesian = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartesian>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartesian>>>(this, "createCartesianAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartesian>> invoke() {
                        return createCartesianAdaptor();
                    }
                }, false);
        m_asCartographicRadians = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartographic>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartographic>>>(this, "createCartographicRadiansAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartographic>> invoke() {
                        return createCartographicRadiansAdaptor();
                    }
                }, false);
        m_asCartographicDegrees = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartographic>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartographic>>>(this, "createCartographicDegreesAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Cartographic>> invoke() {
                        return createCartographicDegreesAdaptor();
                    }
                }, false);
        m_asReferences = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Reference>>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Reference>>>(this, "createReferencesAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Iterable<Reference>> invoke() {
                        return createReferencesAdaptor();
                    }
                }, false);
    }

    @Override
    public PositionListCesiumWriter clone() {
        return new PositionListCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code referenceFrame}, which is the reference frame in which cartesian positions are specified. Possible values are "FIXED" and "INERTIAL".  If not specified, the default value is FIXED.
    
    

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
    Writes the value expressed as a {@code cartesian}, which is the list of positions specified as three-dimensional Cartesian values, {@code [X, Y, Z, X, Y, Z, ...]}, in meters relative to the {@code referenceFrame}.
    
    

    * @param values The values.
    */
    public final void writeCartesian(Iterable<Cartesian> values) {
        final String PropertyName = CartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian3List(getOutput(), values);
    }

    /**
    *  
    Writes the value expressed as a {@code cartographicRadians}, which is the list of positions specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height, Longitude, Latitude, Height, ...]}, where Longitude and Latitude are in radians and Height is in meters.
    
    

    * @param values The values.
    */
    public final void writeCartographicRadians(Iterable<Cartographic> values) {
        final String PropertyName = CartographicRadiansPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographicList(getOutput(), values);
    }

    /**
    *  
    Writes the value expressed as a {@code cartographicDegrees}, which is the list of positions specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height, Longitude, Latitude, Height, ...]}, where Longitude and Latitude are in degrees and Height is in meters.
    
    

    * @param values The values.
    */
    public final void writeCartographicDegrees(Iterable<Cartographic> values) {
        final String PropertyName = CartographicDegreesPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographicList(getOutput(), values);
    }

    /**
    *  
    Writes the value expressed as a {@code references}, which is the list of positions specified as references.  Each reference is to a property that defines a single position, which may change with time.
    
    

    * @param references The list of references.
    */
    public final void writeReferences(Iterable<Reference> references) {
        final String PropertyName = ReferencesPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReferences(getOutput(), references);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code Cartesian} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Iterable<Cartesian>> asCartesian() {
        return m_asCartesian.getValue();
    }

    private final ICesiumValuePropertyWriter<Iterable<Cartesian>> createCartesianAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.PositionListCesiumWriter, Iterable<Cartesian>>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionListCesiumWriter, Iterable<Cartesian>>() {
                    public void invoke(PositionListCesiumWriter me, Iterable<Cartesian> value) {
                        me.writeCartesian(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code CartographicRadians} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Iterable<Cartographic>> asCartographicRadians() {
        return m_asCartographicRadians.getValue();
    }

    private final ICesiumValuePropertyWriter<Iterable<Cartographic>> createCartographicRadiansAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.PositionListCesiumWriter, Iterable<Cartographic>>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionListCesiumWriter, Iterable<Cartographic>>() {
                    public void invoke(PositionListCesiumWriter me, Iterable<Cartographic> value) {
                        me.writeCartographicRadians(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code CartographicDegrees} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Iterable<Cartographic>> asCartographicDegrees() {
        return m_asCartographicDegrees.getValue();
    }

    private final ICesiumValuePropertyWriter<Iterable<Cartographic>> createCartographicDegreesAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.PositionListCesiumWriter, Iterable<Cartographic>>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionListCesiumWriter, Iterable<Cartographic>>() {
                    public void invoke(PositionListCesiumWriter me, Iterable<Cartographic> value) {
                        me.writeCartographicDegrees(value);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code References} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Iterable<Reference>> asReferences() {
        return m_asReferences.getValue();
    }

    private final ICesiumValuePropertyWriter<Iterable<Reference>> createReferencesAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.PositionListCesiumWriter, Iterable<Reference>>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.PositionListCesiumWriter, Iterable<Reference>>() {
                    public void invoke(PositionListCesiumWriter me, Iterable<Reference> value) {
                        me.writeReferences(value);
                    }
                });
    }
}