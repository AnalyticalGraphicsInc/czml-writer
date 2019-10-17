package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 * Writes a {@code DirectionList} to a {@link CesiumOutputStream}. A {@code DirectionList} is a list of directions.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class DirectionListCesiumWriter extends CesiumPropertyWriter<DirectionListCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumSphericalListValuePropertyWriter,
        ICesiumUnitSphericalListValuePropertyWriter, ICesiumCartesian3ListValuePropertyWriter, ICesiumUnitCartesian3ListValuePropertyWriter {
    /**
    * The name of the {@code spherical} property.
    */
    public static final String SphericalPropertyName = "spherical";
    /**
    * The name of the {@code unitSpherical} property.
    */
    public static final String UnitSphericalPropertyName = "unitSpherical";
    /**
    * The name of the {@code cartesian} property.
    */
    public static final String CartesianPropertyName = "cartesian";
    /**
    * The name of the {@code unitCartesian} property.
    */
    public static final String UnitCartesianPropertyName = "unitCartesian";
    /**
    * The name of the {@code delete} property.
    */
    public static final String DeletePropertyName = "delete";
    private Lazy<CesiumSphericalListValuePropertyAdaptor<DirectionListCesiumWriter>> m_asSpherical;
    private Lazy<CesiumUnitSphericalListValuePropertyAdaptor<DirectionListCesiumWriter>> m_asUnitSpherical;
    private Lazy<CesiumCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter>> m_asCartesian;
    private Lazy<CesiumUnitCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter>> m_asUnitCartesian;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public DirectionListCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asSpherical = createAsSpherical();
        m_asUnitSpherical = createAsUnitSpherical();
        m_asCartesian = createAsCartesian();
        m_asUnitCartesian = createAsUnitCartesian();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected DirectionListCesiumWriter(@Nonnull DirectionListCesiumWriter existingInstance) {
        super(existingInstance);
        m_asSpherical = createAsSpherical();
        m_asUnitSpherical = createAsUnitSpherical();
        m_asCartesian = createAsCartesian();
        m_asUnitCartesian = createAsUnitCartesian();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public DirectionListCesiumWriter clone() {
        return new DirectionListCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code spherical}, which is the list of directions specified as spherical values {@code [Clock, Cone, Magnitude, Clock, Cone, Magnitude, ...]}, with angles in radians and magnitude in meters. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param values The values.
    */
    public final void writeSpherical(Iterable<Spherical> values) {
        final String PropertyName = SphericalPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeSphericalList(getOutput(), values);
    }

    /**
    * Writes the value expressed as a {@code unitSpherical}, which is the list of directions specified as unit spherical values {@code [Clock, Cone, Clock, Cone, ...]}, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param values The values.
    */
    public final void writeUnitSpherical(Iterable<UnitSpherical> values) {
        final String PropertyName = UnitSphericalPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitSphericalList(getOutput(), values);
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the list of directions specified as three-dimensional Cartesian values {@code [X, Y, Z, X, Y, Z, ...]}, in world coordinates in meters.
    * @param values The values.
    */
    public final void writeCartesian(Iterable<Cartesian> values) {
        final String PropertyName = CartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian3List(getOutput(), values);
    }

    /**
    * Writes the value expressed as a {@code unitCartesian}, which is the list of directions specified as three-dimensional unit magnitude Cartesian values, {@code [X, Y, Z, X, Y, Z, ...]}, in world coordinates in meters.
    * @param values The values.
    */
    public final void writeUnitCartesian(Iterable<UnitCartesian> values) {
        final String PropertyName = UnitCartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitCartesian3List(getOutput(), values);
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
    * Returns a wrapper for this instance that implements {@link ICesiumSphericalListValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumSphericalListValuePropertyAdaptor<DirectionListCesiumWriter> asSpherical() {
        return m_asSpherical.getValue();
    }

    private final Lazy<CesiumSphericalListValuePropertyAdaptor<DirectionListCesiumWriter>> createAsSpherical() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumSphericalListValuePropertyAdaptor<DirectionListCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumSphericalListValuePropertyAdaptor<DirectionListCesiumWriter>>(this, "createSphericalList") {
                    public cesiumlanguagewriter.advanced.CesiumSphericalListValuePropertyAdaptor<DirectionListCesiumWriter> invoke() {
                        return createSphericalList();
                    }
                }, false);
    }

    private final CesiumSphericalListValuePropertyAdaptor<DirectionListCesiumWriter> createSphericalList() {
        return CesiumValuePropertyAdaptors.<DirectionListCesiumWriter> createSphericalList(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumUnitSphericalListValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumUnitSphericalListValuePropertyAdaptor<DirectionListCesiumWriter> asUnitSpherical() {
        return m_asUnitSpherical.getValue();
    }

    private final Lazy<CesiumUnitSphericalListValuePropertyAdaptor<DirectionListCesiumWriter>> createAsUnitSpherical() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumUnitSphericalListValuePropertyAdaptor<DirectionListCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumUnitSphericalListValuePropertyAdaptor<DirectionListCesiumWriter>>(this, "createUnitSphericalList") {
                    public cesiumlanguagewriter.advanced.CesiumUnitSphericalListValuePropertyAdaptor<DirectionListCesiumWriter> invoke() {
                        return createUnitSphericalList();
                    }
                }, false);
    }

    private final CesiumUnitSphericalListValuePropertyAdaptor<DirectionListCesiumWriter> createUnitSphericalList() {
        return CesiumValuePropertyAdaptors.<DirectionListCesiumWriter> createUnitSphericalList(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartesian3ListValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter> asCartesian() {
        return m_asCartesian.getValue();
    }

    private final Lazy<CesiumCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter>> createAsCartesian() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter>>(this, "createCartesian3List") {
                    public cesiumlanguagewriter.advanced.CesiumCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter> invoke() {
                        return createCartesian3List();
                    }
                }, false);
    }

    private final CesiumCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter> createCartesian3List() {
        return CesiumValuePropertyAdaptors.<DirectionListCesiumWriter> createCartesian3List(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumUnitCartesian3ListValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumUnitCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter> asUnitCartesian() {
        return m_asUnitCartesian.getValue();
    }

    private final Lazy<CesiumUnitCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter>> createAsUnitCartesian() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumUnitCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumUnitCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter>>(this, "createUnitCartesian3List") {
                    public cesiumlanguagewriter.advanced.CesiumUnitCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter> invoke() {
                        return createUnitCartesian3List();
                    }
                }, false);
    }

    private final CesiumUnitCartesian3ListValuePropertyAdaptor<DirectionListCesiumWriter> createUnitCartesian3List() {
        return CesiumValuePropertyAdaptors.<DirectionListCesiumWriter> createUnitCartesian3List(this);
    }
}