package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code AlignedAxis} to a {@link CesiumOutputStream}. A {@code AlignedAxis} is an aligned axis represented by a unit vector which can optionally vary over time.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class AlignedAxisCesiumWriter extends CesiumInterpolatablePropertyWriter<AlignedAxisCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumUnitCartesian3ValuePropertyWriter,
        ICesiumUnitSphericalValuePropertyWriter, ICesiumReferenceValuePropertyWriter, ICesiumVelocityReferenceValuePropertyWriter {
    /**
    * The name of the {@code unitCartesian} property.
    */
    @Nonnull
    public static final String UnitCartesianPropertyName = "unitCartesian";
    /**
    * The name of the {@code unitSpherical} property.
    */
    @Nonnull
    public static final String UnitSphericalPropertyName = "unitSpherical";
    /**
    * The name of the {@code reference} property.
    */
    @Nonnull
    public static final String ReferencePropertyName = "reference";
    /**
    * The name of the {@code velocityReference} property.
    */
    @Nonnull
    public static final String VelocityReferencePropertyName = "velocityReference";
    /**
    * The name of the {@code delete} property.
    */
    @Nonnull
    public static final String DeletePropertyName = "delete";
    @Nonnull
    private final Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<AlignedAxisCesiumWriter>> m_asUnitCartesian;
    @Nonnull
    private final Lazy<CesiumUnitSphericalValuePropertyAdaptor<AlignedAxisCesiumWriter>> m_asUnitSpherical;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>> m_asReference;
    @Nonnull
    private final Lazy<CesiumVelocityReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>> m_asVelocityReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public AlignedAxisCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asUnitCartesian = createAsUnitCartesian();
        m_asUnitSpherical = createAsUnitSpherical();
        m_asReference = createAsReference();
        m_asVelocityReference = createAsVelocityReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected AlignedAxisCesiumWriter(@Nonnull AlignedAxisCesiumWriter existingInstance) {
        super(existingInstance);
        m_asUnitCartesian = createAsUnitCartesian();
        m_asUnitSpherical = createAsUnitSpherical();
        m_asReference = createAsReference();
        m_asVelocityReference = createAsVelocityReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public AlignedAxisCesiumWriter clone() {
        return new AlignedAxisCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code unitCartesian}, which is the axis specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}, in world coordinates.
    * @param value The value.
    */
    public final void writeUnitCartesian(@Nonnull UnitCartesian value) {
        final String PropertyName = UnitCartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitCartesian3(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code unitCartesian}, which is the axis specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}, in world coordinates.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values) {
        writeUnitCartesian(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code unitCartesian}, which is the axis specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}, in world coordinates.
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
    * Writes the value expressed as a {@code unitSpherical}, which is the axis specified as a unit spherical value {@code [Clock, Cone]}, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param value The value.
    */
    public final void writeUnitSpherical(@Nonnull UnitSpherical value) {
        final String PropertyName = UnitSphericalPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitSpherical(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code unitSpherical}, which is the axis specified as a unit spherical value {@code [Clock, Cone]}, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values) {
        writeUnitSpherical(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code unitSpherical}, which is the axis specified as a unit spherical value {@code [Clock, Cone]}, in radians. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
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
    * Writes the value expressed as a {@code reference}, which is the axis specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the axis specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the axis specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the axis specified as a reference to another property.
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
    * Writes the value expressed as a {@code velocityReference}, which is the axis specified as the normalized velocity vector of a position property. The reference must be to a {@code position} property.
    * @param value The reference.
    */
    public final void writeVelocityReference(Reference value) {
        final String PropertyName = VelocityReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code velocityReference}, which is the axis specified as the normalized velocity vector of a position property. The reference must be to a {@code position} property.
    * @param value The reference.
    */
    public final void writeVelocityReference(String value) {
        final String PropertyName = VelocityReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code velocityReference}, which is the axis specified as the normalized velocity vector of a position property. The reference must be to a {@code position} property.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeVelocityReference(String identifier, String propertyName) {
        final String PropertyName = VelocityReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), identifier, propertyName);
    }

    /**
    * Writes the value expressed as a {@code velocityReference}, which is the axis specified as the normalized velocity vector of a position property. The reference must be to a {@code position} property.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeVelocityReference(String identifier, String[] propertyNames) {
        final String PropertyName = VelocityReferencePropertyName;
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
    * Returns a wrapper for this instance that implements {@link ICesiumUnitCartesian3ValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumUnitCartesian3ValuePropertyAdaptor<AlignedAxisCesiumWriter> asUnitCartesian() {
        return m_asUnitCartesian.getValue();
    }

    @Nonnull
    private final Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<AlignedAxisCesiumWriter>> createAsUnitCartesian() {
        return new Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<AlignedAxisCesiumWriter>>(new Func1<CesiumUnitCartesian3ValuePropertyAdaptor<AlignedAxisCesiumWriter>>(this, "createUnitCartesian3") {
            public CesiumUnitCartesian3ValuePropertyAdaptor<AlignedAxisCesiumWriter> invoke() {
                return createUnitCartesian3();
            }
        }, false);
    }

    @Nonnull
    private final CesiumUnitCartesian3ValuePropertyAdaptor<AlignedAxisCesiumWriter> createUnitCartesian3() {
        return CesiumValuePropertyAdaptors.<AlignedAxisCesiumWriter> createUnitCartesian3(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumUnitSphericalValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumUnitSphericalValuePropertyAdaptor<AlignedAxisCesiumWriter> asUnitSpherical() {
        return m_asUnitSpherical.getValue();
    }

    @Nonnull
    private final Lazy<CesiumUnitSphericalValuePropertyAdaptor<AlignedAxisCesiumWriter>> createAsUnitSpherical() {
        return new Lazy<CesiumUnitSphericalValuePropertyAdaptor<AlignedAxisCesiumWriter>>(new Func1<CesiumUnitSphericalValuePropertyAdaptor<AlignedAxisCesiumWriter>>(this, "createUnitSpherical") {
            public CesiumUnitSphericalValuePropertyAdaptor<AlignedAxisCesiumWriter> invoke() {
                return createUnitSpherical();
            }
        }, false);
    }

    @Nonnull
    private final CesiumUnitSphericalValuePropertyAdaptor<AlignedAxisCesiumWriter> createUnitSpherical() {
        return CesiumValuePropertyAdaptors.<AlignedAxisCesiumWriter> createUnitSpherical(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>>(new Func1<CesiumReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>>(this, "createReference") {
            public CesiumReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter> invoke() {
                return createReference();
            }
        }, false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<AlignedAxisCesiumWriter> createReference(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumVelocityReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumVelocityReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter> asVelocityReference() {
        return m_asVelocityReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumVelocityReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>> createAsVelocityReference() {
        return new Lazy<CesiumVelocityReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>>(
                new Func1<CesiumVelocityReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter>>(this, "createVelocityReference") {
                    public CesiumVelocityReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter> invoke() {
                        return createVelocityReference();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumVelocityReferenceValuePropertyAdaptor<AlignedAxisCesiumWriter> createVelocityReference() {
        return CesiumValuePropertyAdaptors.<AlignedAxisCesiumWriter> createVelocityReference(this);
    }
}