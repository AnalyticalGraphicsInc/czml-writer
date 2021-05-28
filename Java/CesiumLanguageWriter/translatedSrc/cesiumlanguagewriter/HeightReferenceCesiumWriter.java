package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import javax.annotation.Nonnull;

/**
 * Writes a {@code HeightReference} to a {@link CesiumOutputStream}. A {@code HeightReference} is the height reference of an object, which indicates if the object's position is relative to terrain or not.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class HeightReferenceCesiumWriter extends CesiumPropertyWriter<HeightReferenceCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumHeightReferenceValuePropertyWriter,
        ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code heightReference} property.
    */
    @Nonnull
    public static final String HeightReferencePropertyName = "heightReference";
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
    private final Lazy<CesiumHeightReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>> m_asHeightReference;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public HeightReferenceCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asHeightReference = createAsHeightReference();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected HeightReferenceCesiumWriter(@Nonnull HeightReferenceCesiumWriter existingInstance) {
        super(existingInstance);
        m_asHeightReference = createAsHeightReference();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public HeightReferenceCesiumWriter clone() {
        return new HeightReferenceCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code heightReference}, which is the height reference.
    * @param value The height reference.
    */
    public final void writeHeightReference(@Nonnull CesiumHeightReference value) {
        final String PropertyName = HeightReferencePropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(CesiumFormattingHelper.heightReferenceToString(value));
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the height reference specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the height reference specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the height reference specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the height reference specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumHeightReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumHeightReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter> asHeightReference() {
        return m_asHeightReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumHeightReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>> createAsHeightReference() {
        return new Lazy<CesiumHeightReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>>(new Func1<CesiumHeightReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>>(this,
                "createHeightReference") {
            public CesiumHeightReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter> invoke() {
                return createHeightReference();
            }
        }, false);
    }

    @Nonnull
    private final CesiumHeightReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter> createHeightReference() {
        return CesiumValuePropertyAdaptors.<HeightReferenceCesiumWriter> createHeightReference(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>>(new Func1<CesiumReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter>>(this, "createReference") {
            public CesiumReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter> invoke() {
                return createReference();
            }
        }, false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<HeightReferenceCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<HeightReferenceCesiumWriter> createReference(this);
    }
}