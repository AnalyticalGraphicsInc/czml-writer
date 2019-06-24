package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 *  
 Writes a {@code PositionList} to a {@link CesiumOutputStream}. A {@code PositionList} is a list of positions.
 

 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class PositionListCesiumWriter extends CesiumPropertyWriter<PositionListCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumCartesian3ListValuePropertyWriter,
        ICesiumCartographicRadiansListValuePropertyWriter, ICesiumCartographicDegreesListValuePropertyWriter, ICesiumReferenceListValuePropertyWriter {
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
    /**
    *  
    The name of the {@code delete} property.
    

    */
    public static final String DeletePropertyName = "delete";
    private Lazy<CesiumCartesian3ListValuePropertyAdaptor<PositionListCesiumWriter>> m_asCartesian;
    private Lazy<CesiumCartographicRadiansListValuePropertyAdaptor<PositionListCesiumWriter>> m_asCartographicRadians;
    private Lazy<CesiumCartographicDegreesListValuePropertyAdaptor<PositionListCesiumWriter>> m_asCartographicDegrees;
    private Lazy<CesiumReferenceListValuePropertyAdaptor<PositionListCesiumWriter>> m_asReferences;

    /**
    *  
    Initializes a new instance.
    
    

    * @param propertyName The name of the property.
    */
    public PositionListCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asCartesian = createAsCartesian();
        m_asCartographicRadians = createAsCartographicRadians();
        m_asCartographicDegrees = createAsCartographicDegrees();
        m_asReferences = createAsReferences();
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected PositionListCesiumWriter(@Nonnull PositionListCesiumWriter existingInstance) {
        super(existingInstance);
        m_asCartesian = createAsCartesian();
        m_asCartographicRadians = createAsCartographicRadians();
        m_asCartographicDegrees = createAsCartographicDegrees();
        m_asReferences = createAsReferences();
    }

    /**
    *  
    
    Copies this instance and returns the copy.
    
    

    * @return The copy.
    */
    @Override
    public PositionListCesiumWriter clone() {
        return new PositionListCesiumWriter(this);
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
    Writes the value expressed as a {@code references}, which is the list of positions specified as references. Each reference is to a property that defines a single position, which may change with time.
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumCartesian3ListValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumCartesian3ListValuePropertyAdaptor<PositionListCesiumWriter> asCartesian() {
        return m_asCartesian.getValue();
    }

    private final Lazy<CesiumCartesian3ListValuePropertyAdaptor<PositionListCesiumWriter>> createAsCartesian() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartesian3ListValuePropertyAdaptor<PositionListCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartesian3ListValuePropertyAdaptor<PositionListCesiumWriter>>(this, "createCartesian3List") {
                    public cesiumlanguagewriter.advanced.CesiumCartesian3ListValuePropertyAdaptor<PositionListCesiumWriter> invoke() {
                        return createCartesian3List();
                    }
                }, false);
    }

    private final CesiumCartesian3ListValuePropertyAdaptor<PositionListCesiumWriter> createCartesian3List() {
        return CesiumValuePropertyAdaptors.<PositionListCesiumWriter> createCartesian3List(this);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumCartographicRadiansListValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumCartographicRadiansListValuePropertyAdaptor<PositionListCesiumWriter> asCartographicRadians() {
        return m_asCartographicRadians.getValue();
    }

    private final Lazy<CesiumCartographicRadiansListValuePropertyAdaptor<PositionListCesiumWriter>> createAsCartographicRadians() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartographicRadiansListValuePropertyAdaptor<PositionListCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartographicRadiansListValuePropertyAdaptor<PositionListCesiumWriter>>(this, "createCartographicRadiansList") {
                    public cesiumlanguagewriter.advanced.CesiumCartographicRadiansListValuePropertyAdaptor<PositionListCesiumWriter> invoke() {
                        return createCartographicRadiansList();
                    }
                }, false);
    }

    private final CesiumCartographicRadiansListValuePropertyAdaptor<PositionListCesiumWriter> createCartographicRadiansList() {
        return CesiumValuePropertyAdaptors.<PositionListCesiumWriter> createCartographicRadiansList(this);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumCartographicDegreesListValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumCartographicDegreesListValuePropertyAdaptor<PositionListCesiumWriter> asCartographicDegrees() {
        return m_asCartographicDegrees.getValue();
    }

    private final Lazy<CesiumCartographicDegreesListValuePropertyAdaptor<PositionListCesiumWriter>> createAsCartographicDegrees() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartographicDegreesListValuePropertyAdaptor<PositionListCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartographicDegreesListValuePropertyAdaptor<PositionListCesiumWriter>>(this, "createCartographicDegreesList") {
                    public cesiumlanguagewriter.advanced.CesiumCartographicDegreesListValuePropertyAdaptor<PositionListCesiumWriter> invoke() {
                        return createCartographicDegreesList();
                    }
                }, false);
    }

    private final CesiumCartographicDegreesListValuePropertyAdaptor<PositionListCesiumWriter> createCartographicDegreesList() {
        return CesiumValuePropertyAdaptors.<PositionListCesiumWriter> createCartographicDegreesList(this);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumReferenceListValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final CesiumReferenceListValuePropertyAdaptor<PositionListCesiumWriter> asReferences() {
        return m_asReferences.getValue();
    }

    private final Lazy<CesiumReferenceListValuePropertyAdaptor<PositionListCesiumWriter>> createAsReferences() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceListValuePropertyAdaptor<PositionListCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceListValuePropertyAdaptor<PositionListCesiumWriter>>(this, "createReferenceList") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceListValuePropertyAdaptor<PositionListCesiumWriter> invoke() {
                        return createReferenceList();
                    }
                }, false);
    }

    private final CesiumReferenceListValuePropertyAdaptor<PositionListCesiumWriter> createReferenceList() {
        return CesiumValuePropertyAdaptors.<PositionListCesiumWriter> createReferenceList(this);
    }
}