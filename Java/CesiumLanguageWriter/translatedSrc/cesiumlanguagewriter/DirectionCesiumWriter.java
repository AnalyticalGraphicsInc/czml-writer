package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Direction} to a {@link CesiumOutputStream}. A {@code Direction} is a unit vector, in world coordinates, that defines a direction.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class DirectionCesiumWriter extends CesiumInterpolatablePropertyWriter<DirectionCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumSphericalValuePropertyWriter,
        ICesiumUnitSphericalValuePropertyWriter, ICesiumCartesian3ValuePropertyWriter, ICesiumUnitCartesian3ValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code spherical} property.
    */
    @Nonnull
    public static final String SphericalPropertyName = "spherical";
    /**
    * The name of the {@code unitSpherical} property.
    */
    @Nonnull
    public static final String UnitSphericalPropertyName = "unitSpherical";
    /**
    * The name of the {@code cartesian} property.
    */
    @Nonnull
    public static final String CartesianPropertyName = "cartesian";
    /**
    * The name of the {@code unitCartesian} property.
    */
    @Nonnull
    public static final String UnitCartesianPropertyName = "unitCartesian";
    /**
    * The name of the {@code reference} property.
    */
    @Nonnull
    public static final String ReferencePropertyName = "reference";
    /**
    * The name of the {@code delete} property.
    */
    @Nonnull
    public static final String DeletePropertyName = "delete";
    @Nonnull
    private final Lazy<CesiumSphericalValuePropertyAdaptor<DirectionCesiumWriter>> m_asSpherical;
    @Nonnull
    private final Lazy<CesiumUnitSphericalValuePropertyAdaptor<DirectionCesiumWriter>> m_asUnitSpherical;
    @Nonnull
    private final Lazy<CesiumCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>> m_asCartesian;
    @Nonnull
    private final Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>> m_asUnitCartesian;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<DirectionCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public DirectionCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asSpherical = createAsSpherical();
        m_asUnitSpherical = createAsUnitSpherical();
        m_asCartesian = createAsCartesian();
        m_asUnitCartesian = createAsUnitCartesian();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected DirectionCesiumWriter(@Nonnull DirectionCesiumWriter existingInstance) {
        super(existingInstance);
        m_asSpherical = createAsSpherical();
        m_asUnitSpherical = createAsUnitSpherical();
        m_asCartesian = createAsCartesian();
        m_asUnitCartesian = createAsUnitCartesian();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public DirectionCesiumWriter clone() {
        return new DirectionCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code spherical}, which is the direction specified as a spherical value {@code [Clock, Cone, Magnitude]}, with angles in radians and magnitude in meters. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param value The value.
    */
    public final void writeSpherical(@Nonnull Spherical value) {
        final String PropertyName = SphericalPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeSpherical(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code spherical}, which is the direction specified as a spherical value {@code [Clock, Cone, Magnitude]}, with angles in radians and magnitude in meters. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSpherical(List<JulianDate> dates, List<Spherical> values) {
        writeSpherical(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code spherical}, which is the direction specified as a spherical value {@code [Clock, Cone, Magnitude]}, with angles in radians and magnitude in meters. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSpherical(List<JulianDate> dates, List<Spherical> values, int startIndex, int length) {
        final String PropertyName = SphericalPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeSpherical(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code unitSpherical}, which is the direction specified as a unit spherical value {@code [Clock, Cone]}, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param value The value.
    */
    public final void writeUnitSpherical(@Nonnull UnitSpherical value) {
        final String PropertyName = UnitSphericalPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitSpherical(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code unitSpherical}, which is the direction specified as a unit spherical value {@code [Clock, Cone]}, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values) {
        writeUnitSpherical(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code unitSpherical}, which is the direction specified as a unit spherical value {@code [Clock, Cone]}, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values, int startIndex, int length) {
        final String PropertyName = UnitSphericalPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeUnitSpherical(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the direction specified as a three-dimensional Cartesian value {@code [X, Y, Z]}, in world coordinates in meters.
    * @param value The value.
    */
    public final void writeCartesian(@Nonnull Cartesian value) {
        final String PropertyName = CartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian3(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the direction specified as a three-dimensional Cartesian value {@code [X, Y, Z]}, in world coordinates in meters.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
        writeCartesian(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the direction specified as a three-dimensional Cartesian value {@code [X, Y, Z]}, in world coordinates in meters.
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
    * Writes the value expressed as a {@code unitCartesian}, which is the direction specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}, in world coordinates in meters.
    * @param value The value.
    */
    public final void writeUnitCartesian(@Nonnull UnitCartesian value) {
        final String PropertyName = UnitCartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitCartesian3(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code unitCartesian}, which is the direction specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}, in world coordinates in meters.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values) {
        writeUnitCartesian(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code unitCartesian}, which is the direction specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}, in world coordinates in meters.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values, int startIndex, int length) {
        final String PropertyName = UnitCartesianPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeUnitCartesian3(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the direction specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the direction specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the direction specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the direction specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumSphericalValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumSphericalValuePropertyAdaptor<DirectionCesiumWriter> asSpherical() {
        return m_asSpherical.getValue();
    }

    @Nonnull
    private final Lazy<CesiumSphericalValuePropertyAdaptor<DirectionCesiumWriter>> createAsSpherical() {
        return new Lazy<CesiumSphericalValuePropertyAdaptor<DirectionCesiumWriter>>(new Func1<CesiumSphericalValuePropertyAdaptor<DirectionCesiumWriter>>(this, "createSpherical") {
            public CesiumSphericalValuePropertyAdaptor<DirectionCesiumWriter> invoke() {
                return createSpherical();
            }
        }, false);
    }

    @Nonnull
    private final CesiumSphericalValuePropertyAdaptor<DirectionCesiumWriter> createSpherical() {
        return CesiumValuePropertyAdaptors.<DirectionCesiumWriter> createSpherical(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumUnitSphericalValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumUnitSphericalValuePropertyAdaptor<DirectionCesiumWriter> asUnitSpherical() {
        return m_asUnitSpherical.getValue();
    }

    @Nonnull
    private final Lazy<CesiumUnitSphericalValuePropertyAdaptor<DirectionCesiumWriter>> createAsUnitSpherical() {
        return new Lazy<CesiumUnitSphericalValuePropertyAdaptor<DirectionCesiumWriter>>(new Func1<CesiumUnitSphericalValuePropertyAdaptor<DirectionCesiumWriter>>(this, "createUnitSpherical") {
            public CesiumUnitSphericalValuePropertyAdaptor<DirectionCesiumWriter> invoke() {
                return createUnitSpherical();
            }
        }, false);
    }

    @Nonnull
    private final CesiumUnitSphericalValuePropertyAdaptor<DirectionCesiumWriter> createUnitSpherical() {
        return CesiumValuePropertyAdaptors.<DirectionCesiumWriter> createUnitSpherical(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartesian3ValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumCartesian3ValuePropertyAdaptor<DirectionCesiumWriter> asCartesian() {
        return m_asCartesian.getValue();
    }

    @Nonnull
    private final Lazy<CesiumCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>> createAsCartesian() {
        return new Lazy<CesiumCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>>(new Func1<CesiumCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>>(this, "createCartesian3") {
            public CesiumCartesian3ValuePropertyAdaptor<DirectionCesiumWriter> invoke() {
                return createCartesian3();
            }
        }, false);
    }

    @Nonnull
    private final CesiumCartesian3ValuePropertyAdaptor<DirectionCesiumWriter> createCartesian3() {
        return CesiumValuePropertyAdaptors.<DirectionCesiumWriter> createCartesian3(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumUnitCartesian3ValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumUnitCartesian3ValuePropertyAdaptor<DirectionCesiumWriter> asUnitCartesian() {
        return m_asUnitCartesian.getValue();
    }

    @Nonnull
    private final Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>> createAsUnitCartesian() {
        return new Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>>(new Func1<CesiumUnitCartesian3ValuePropertyAdaptor<DirectionCesiumWriter>>(this, "createUnitCartesian3") {
            public CesiumUnitCartesian3ValuePropertyAdaptor<DirectionCesiumWriter> invoke() {
                return createUnitCartesian3();
            }
        }, false);
    }

    @Nonnull
    private final CesiumUnitCartesian3ValuePropertyAdaptor<DirectionCesiumWriter> createUnitCartesian3() {
        return CesiumValuePropertyAdaptors.<DirectionCesiumWriter> createUnitCartesian3(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<DirectionCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<DirectionCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<DirectionCesiumWriter>>(new Func1<CesiumReferenceValuePropertyAdaptor<DirectionCesiumWriter>>(this, "createReference") {
            public CesiumReferenceValuePropertyAdaptor<DirectionCesiumWriter> invoke() {
                return createReference();
            }
        }, false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<DirectionCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<DirectionCesiumWriter> createReference(this);
    }
}