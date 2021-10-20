package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 * Writes a {@code VerticalOrigin} to a {@link CesiumOutputStream}. A {@code VerticalOrigin} is the vertical origin of an element, which can optionally vary over time. It controls whether the element is bottom-, center-, or top-aligned with the {@code position}.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class VerticalOriginCesiumWriter extends CesiumPropertyWriter<VerticalOriginCesiumWriter>
        implements ICesiumDeletablePropertyWriter, ICesiumVerticalOriginValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code verticalOrigin} property.
    */
    @Nonnull
    public static final String VerticalOriginPropertyName = "verticalOrigin";
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
    private final Lazy<CesiumVerticalOriginValuePropertyAdaptor<VerticalOriginCesiumWriter>> m_asVerticalOrigin;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<VerticalOriginCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public VerticalOriginCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asVerticalOrigin = createAsVerticalOrigin();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected VerticalOriginCesiumWriter(@Nonnull VerticalOriginCesiumWriter existingInstance) {
        super(existingInstance);
        m_asVerticalOrigin = createAsVerticalOrigin();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public VerticalOriginCesiumWriter clone() {
        return new VerticalOriginCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code verticalOrigin}, which is the vertical origin.
    * @param value The vertical origin.
    */
    public final void writeVerticalOrigin(@Nonnull CesiumVerticalOrigin value) {
        final String PropertyName = VerticalOriginPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.verticalOriginToString(value));
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the vertical origin specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the vertical origin specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the vertical origin specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the vertical origin specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumVerticalOriginValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumVerticalOriginValuePropertyAdaptor<VerticalOriginCesiumWriter> asVerticalOrigin() {
        return m_asVerticalOrigin.getValue();
    }

    @Nonnull
    private final Lazy<CesiumVerticalOriginValuePropertyAdaptor<VerticalOriginCesiumWriter>> createAsVerticalOrigin() {
        return new Lazy<CesiumVerticalOriginValuePropertyAdaptor<VerticalOriginCesiumWriter>>(
                new Func1<CesiumVerticalOriginValuePropertyAdaptor<VerticalOriginCesiumWriter>>(this, "createVerticalOrigin") {
                    public CesiumVerticalOriginValuePropertyAdaptor<VerticalOriginCesiumWriter> invoke() {
                        return createVerticalOrigin();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumVerticalOriginValuePropertyAdaptor<VerticalOriginCesiumWriter> createVerticalOrigin() {
        return CesiumValuePropertyAdaptors.<VerticalOriginCesiumWriter> createVerticalOrigin(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<VerticalOriginCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<VerticalOriginCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<VerticalOriginCesiumWriter>>(new Func1<CesiumReferenceValuePropertyAdaptor<VerticalOriginCesiumWriter>>(this, "createReference") {
            public CesiumReferenceValuePropertyAdaptor<VerticalOriginCesiumWriter> invoke() {
                return createReference();
            }
        }, false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<VerticalOriginCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<VerticalOriginCesiumWriter> createReference(this);
    }
}