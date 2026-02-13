package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 * Writes a {@code SensorVolumePortionToDisplay} to a {@link CesiumOutputStream}. A {@code SensorVolumePortionToDisplay} is the part of a sensor that should be displayed.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class SensorVolumePortionToDisplayCesiumWriter extends CesiumPropertyWriter<SensorVolumePortionToDisplayCesiumWriter>
        implements ICesiumDeletablePropertyWriter, ICesiumSensorVolumePortionToDisplayValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code portionToDisplay} property.
    */
    @Nonnull
    public static final String PortionToDisplayPropertyName = "portionToDisplay";
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
    private final Lazy<CesiumSensorVolumePortionToDisplayValuePropertyAdaptor<SensorVolumePortionToDisplayCesiumWriter>> m_asPortionToDisplay;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<SensorVolumePortionToDisplayCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public SensorVolumePortionToDisplayCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asPortionToDisplay = createAsPortionToDisplay();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected SensorVolumePortionToDisplayCesiumWriter(@Nonnull SensorVolumePortionToDisplayCesiumWriter existingInstance) {
        super(existingInstance);
        m_asPortionToDisplay = createAsPortionToDisplay();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public SensorVolumePortionToDisplayCesiumWriter clone() {
        return new SensorVolumePortionToDisplayCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code portionToDisplay}, which is the part of a sensor to display.
    * @param value The portion of the sensor to display.
    */
    public final void writePortionToDisplay(@Nonnull CesiumSensorVolumePortionToDisplay value) {
        final String PropertyName = PortionToDisplayPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.sensorVolumePortionToDisplayToString(value));
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the part of a sensor to display, specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the part of a sensor to display, specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the part of a sensor to display, specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the part of a sensor to display, specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumSensorVolumePortionToDisplayValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumSensorVolumePortionToDisplayValuePropertyAdaptor<SensorVolumePortionToDisplayCesiumWriter> asPortionToDisplay() {
        return m_asPortionToDisplay.getValue();
    }

    @Nonnull
    private final Lazy<CesiumSensorVolumePortionToDisplayValuePropertyAdaptor<SensorVolumePortionToDisplayCesiumWriter>> createAsPortionToDisplay() {
        return new Lazy<CesiumSensorVolumePortionToDisplayValuePropertyAdaptor<SensorVolumePortionToDisplayCesiumWriter>>(
                Func1.<CesiumSensorVolumePortionToDisplayValuePropertyAdaptor<SensorVolumePortionToDisplayCesiumWriter>> of(this::createSensorVolumePortionToDisplay, this,
                        "createSensorVolumePortionToDisplay"),
                false);
    }

    @Nonnull
    private final CesiumSensorVolumePortionToDisplayValuePropertyAdaptor<SensorVolumePortionToDisplayCesiumWriter> createSensorVolumePortionToDisplay() {
        return CesiumValuePropertyAdaptors.<SensorVolumePortionToDisplayCesiumWriter> createSensorVolumePortionToDisplay(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<SensorVolumePortionToDisplayCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<SensorVolumePortionToDisplayCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<SensorVolumePortionToDisplayCesiumWriter>>(
                Func1.<CesiumReferenceValuePropertyAdaptor<SensorVolumePortionToDisplayCesiumWriter>> of(this::createReference, this, "createReference"), false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<SensorVolumePortionToDisplayCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<SensorVolumePortionToDisplayCesiumWriter> createReference(this);
    }
}