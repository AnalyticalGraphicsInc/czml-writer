package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 * Writes a {@code PositionListOfLists} to a {@link CesiumOutputStream}. A {@code PositionListOfLists} is a list of lists of positions.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class PositionListOfListsCesiumWriter extends CesiumPropertyWriter<PositionListOfListsCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumCartesian3ListOfListsValuePropertyWriter,
        ICesiumCartographicRadiansListOfListsValuePropertyWriter, ICesiumCartographicDegreesListOfListsValuePropertyWriter, ICesiumReferenceListOfListsValuePropertyWriter {
    /**
    * The name of the {@code cartesian} property.
    */
    public static final String CartesianPropertyName = "cartesian";
    /**
    * The name of the {@code cartographicRadians} property.
    */
    public static final String CartographicRadiansPropertyName = "cartographicRadians";
    /**
    * The name of the {@code cartographicDegrees} property.
    */
    public static final String CartographicDegreesPropertyName = "cartographicDegrees";
    /**
    * The name of the {@code references} property.
    */
    public static final String ReferencesPropertyName = "references";
    /**
    * The name of the {@code delete} property.
    */
    public static final String DeletePropertyName = "delete";
    private Lazy<CesiumCartesian3ListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>> m_asCartesian;
    private Lazy<CesiumCartographicRadiansListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>> m_asCartographicRadians;
    private Lazy<CesiumCartographicDegreesListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>> m_asCartographicDegrees;
    private Lazy<CesiumReferenceListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>> m_asReferences;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public PositionListOfListsCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asCartesian = createAsCartesian();
        m_asCartographicRadians = createAsCartographicRadians();
        m_asCartographicDegrees = createAsCartographicDegrees();
        m_asReferences = createAsReferences();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected PositionListOfListsCesiumWriter(@Nonnull PositionListOfListsCesiumWriter existingInstance) {
        super(existingInstance);
        m_asCartesian = createAsCartesian();
        m_asCartographicRadians = createAsCartographicRadians();
        m_asCartographicDegrees = createAsCartographicDegrees();
        m_asReferences = createAsReferences();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public PositionListOfListsCesiumWriter clone() {
        return new PositionListOfListsCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the list of lists of positions specified as three-dimensional Cartesian values, {@code [X, Y, Z, X, Y, Z, ...]}, in meters relative to the {@code referenceFrame}.
    * @param values The values.
    */
    public final void writeCartesian(Iterable<? extends Iterable<Cartesian>> values) {
        final String PropertyName = CartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian3ListOfLists(getOutput(), values);
    }

    /**
    * Writes the value expressed as a {@code cartographicRadians}, which is the list of lists of positions specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height, Longitude, Latitude, Height, ...]}, where Longitude and Latitude are in radians and Height is in meters.
    * @param values The values.
    */
    public final void writeCartographicRadians(Iterable<? extends Iterable<Cartographic>> values) {
        final String PropertyName = CartographicRadiansPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographicListOfLists(getOutput(), values);
    }

    /**
    * Writes the value expressed as a {@code cartographicDegrees}, which is the list of lists of positions specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height, Longitude, Latitude, Height, ...]}, where Longitude and Latitude are in degrees and Height is in meters.
    * @param values The values.
    */
    public final void writeCartographicDegrees(Iterable<? extends Iterable<Cartographic>> values) {
        final String PropertyName = CartographicDegreesPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographicListOfLists(getOutput(), values);
    }

    /**
    * Writes the value expressed as a {@code references}, which is the list of lists of positions specified as references. Each reference is to a property that defines a single position, which may change with time.
    * @param references The list of lists of references.
    */
    public final void writeReferences(Iterable<? extends Iterable<? extends Reference>> references) {
        final String PropertyName = ReferencesPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReferenceListOfLists(getOutput(), references);
    }

    /**
    * Writes the value expressed as a {@code delete}, which is whether the client should delete existing samples or interval data for this property. Data will be deleted for the containing interval, or if there is no containing interval, then all data. If true, all other properties in this property will be ignored.
    * @param value The value.
    */
    public final void writeDelete(boolean value) {
        final String PropertyName = DeletePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartesian3ListOfListsValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumCartesian3ListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter> asCartesian() {
        return m_asCartesian.getValue();
    }

    private final Lazy<CesiumCartesian3ListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>> createAsCartesian() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartesian3ListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartesian3ListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>>(this, "createCartesian3ListOfLists") {
                    public cesiumlanguagewriter.advanced.CesiumCartesian3ListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter> invoke() {
                        return createCartesian3ListOfLists();
                    }
                }, false);
    }

    private final CesiumCartesian3ListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter> createCartesian3ListOfLists() {
        return CesiumValuePropertyAdaptors.<PositionListOfListsCesiumWriter> createCartesian3ListOfLists(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartographicRadiansListOfListsValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumCartographicRadiansListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter> asCartographicRadians() {
        return m_asCartographicRadians.getValue();
    }

    private final Lazy<CesiumCartographicRadiansListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>> createAsCartographicRadians() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartographicRadiansListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartographicRadiansListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>>(this, "createCartographicRadiansListOfLists") {
                    public cesiumlanguagewriter.advanced.CesiumCartographicRadiansListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter> invoke() {
                        return createCartographicRadiansListOfLists();
                    }
                }, false);
    }

    private final CesiumCartographicRadiansListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter> createCartographicRadiansListOfLists() {
        return CesiumValuePropertyAdaptors.<PositionListOfListsCesiumWriter> createCartographicRadiansListOfLists(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartographicDegreesListOfListsValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumCartographicDegreesListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter> asCartographicDegrees() {
        return m_asCartographicDegrees.getValue();
    }

    private final Lazy<CesiumCartographicDegreesListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>> createAsCartographicDegrees() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartographicDegreesListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartographicDegreesListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>>(this, "createCartographicDegreesListOfLists") {
                    public cesiumlanguagewriter.advanced.CesiumCartographicDegreesListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter> invoke() {
                        return createCartographicDegreesListOfLists();
                    }
                }, false);
    }

    private final CesiumCartographicDegreesListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter> createCartographicDegreesListOfLists() {
        return CesiumValuePropertyAdaptors.<PositionListOfListsCesiumWriter> createCartographicDegreesListOfLists(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceListOfListsValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumReferenceListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter> asReferences() {
        return m_asReferences.getValue();
    }

    private final Lazy<CesiumReferenceListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>> createAsReferences() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter>>(this, "createReferenceListOfLists") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter> invoke() {
                        return createReferenceListOfLists();
                    }
                }, false);
    }

    private final CesiumReferenceListOfListsValuePropertyAdaptor<PositionListOfListsCesiumWriter> createReferenceListOfLists() {
        return CesiumValuePropertyAdaptors.<PositionListOfListsCesiumWriter> createReferenceListOfLists(this);
    }
}