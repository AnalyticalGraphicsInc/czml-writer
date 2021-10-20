package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 * Writes a {@code ColorBlendMode} to a {@link CesiumOutputStream}. A {@code ColorBlendMode} is the mode of blending between a target color and an entity's source color.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class ColorBlendModeCesiumWriter extends CesiumPropertyWriter<ColorBlendModeCesiumWriter>
        implements ICesiumDeletablePropertyWriter, ICesiumColorBlendModeValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code colorBlendMode} property.
    */
    @Nonnull
    public static final String ColorBlendModePropertyName = "colorBlendMode";
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
    private final Lazy<CesiumColorBlendModeValuePropertyAdaptor<ColorBlendModeCesiumWriter>> m_asColorBlendMode;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<ColorBlendModeCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public ColorBlendModeCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asColorBlendMode = createAsColorBlendMode();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected ColorBlendModeCesiumWriter(@Nonnull ColorBlendModeCesiumWriter existingInstance) {
        super(existingInstance);
        m_asColorBlendMode = createAsColorBlendMode();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public ColorBlendModeCesiumWriter clone() {
        return new ColorBlendModeCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code colorBlendMode}, which is the color blend mode.
    * @param value The blend mode.
    */
    public final void writeColorBlendMode(@Nonnull CesiumColorBlendMode value) {
        final String PropertyName = ColorBlendModePropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.colorBlendModeToString(value));
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the color blend mode specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the color blend mode specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the color blend mode specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the color blend mode specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumColorBlendModeValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumColorBlendModeValuePropertyAdaptor<ColorBlendModeCesiumWriter> asColorBlendMode() {
        return m_asColorBlendMode.getValue();
    }

    @Nonnull
    private final Lazy<CesiumColorBlendModeValuePropertyAdaptor<ColorBlendModeCesiumWriter>> createAsColorBlendMode() {
        return new Lazy<CesiumColorBlendModeValuePropertyAdaptor<ColorBlendModeCesiumWriter>>(
                new Func1<CesiumColorBlendModeValuePropertyAdaptor<ColorBlendModeCesiumWriter>>(this, "createColorBlendMode") {
                    public CesiumColorBlendModeValuePropertyAdaptor<ColorBlendModeCesiumWriter> invoke() {
                        return createColorBlendMode();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumColorBlendModeValuePropertyAdaptor<ColorBlendModeCesiumWriter> createColorBlendMode() {
        return CesiumValuePropertyAdaptors.<ColorBlendModeCesiumWriter> createColorBlendMode(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<ColorBlendModeCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<ColorBlendModeCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<ColorBlendModeCesiumWriter>>(new Func1<CesiumReferenceValuePropertyAdaptor<ColorBlendModeCesiumWriter>>(this, "createReference") {
            public CesiumReferenceValuePropertyAdaptor<ColorBlendModeCesiumWriter> invoke() {
                return createReference();
            }
        }, false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<ColorBlendModeCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<ColorBlendModeCesiumWriter> createReference(this);
    }
}