package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 * Writes a {@code PathMode} to a {@link CesiumOutputStream}. A {@code PathMode} is whether a path property applies to the whole path or portions of the path.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class PathModeCesiumWriter extends CesiumPropertyWriter<PathModeCesiumWriter>
        implements ICesiumDeletablePropertyWriter, ICesiumPathModeValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code pathMode} property.
    */
    @Nonnull
    public static final String PathModePropertyName = "pathMode";
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
    private final Lazy<CesiumPathModeValuePropertyAdaptor<PathModeCesiumWriter>> m_asPathMode;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<PathModeCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public PathModeCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asPathMode = createAsPathMode();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected PathModeCesiumWriter(@Nonnull PathModeCesiumWriter existingInstance) {
        super(existingInstance);
        m_asPathMode = createAsPathMode();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public PathModeCesiumWriter clone() {
        return new PathModeCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code pathMode}, which is the path mode.
    * @param value The path mode.
    */
    public final void writePathMode(@Nonnull CesiumPathMode value) {
        final String PropertyName = PathModePropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.pathModeToString(value));
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the path mode specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the path mode specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the path mode specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the path mode specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumPathModeValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumPathModeValuePropertyAdaptor<PathModeCesiumWriter> asPathMode() {
        return m_asPathMode.getValue();
    }

    @Nonnull
    private final Lazy<CesiumPathModeValuePropertyAdaptor<PathModeCesiumWriter>> createAsPathMode() {
        return new Lazy<CesiumPathModeValuePropertyAdaptor<PathModeCesiumWriter>>(Func1.<CesiumPathModeValuePropertyAdaptor<PathModeCesiumWriter>> of(this::createPathMode, this, "createPathMode"),
                false);
    }

    @Nonnull
    private final CesiumPathModeValuePropertyAdaptor<PathModeCesiumWriter> createPathMode() {
        return CesiumValuePropertyAdaptors.<PathModeCesiumWriter> createPathMode(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<PathModeCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<PathModeCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<PathModeCesiumWriter>>(Func1.<CesiumReferenceValuePropertyAdaptor<PathModeCesiumWriter>> of(this::createReference, this, "createReference"),
                false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<PathModeCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<PathModeCesiumWriter> createReference(this);
    }
}