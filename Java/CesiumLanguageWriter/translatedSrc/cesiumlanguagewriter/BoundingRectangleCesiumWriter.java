package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code BoundingRectangle} to a {@link CesiumOutputStream}. A {@code BoundingRectangle} is a bounding rectangle specified by a corner, width and height.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class BoundingRectangleCesiumWriter extends CesiumInterpolatablePropertyWriter<BoundingRectangleCesiumWriter> implements ICesiumDeletablePropertyWriter,
        ICesiumBoundingRectangleValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code boundingRectangle} property.
    */
    @Nonnull
    public static final String BoundingRectanglePropertyName = "boundingRectangle";
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
    private final Lazy<CesiumBoundingRectangleValuePropertyAdaptor<BoundingRectangleCesiumWriter>> m_asBoundingRectangle;
    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<BoundingRectangleCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public BoundingRectangleCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asBoundingRectangle = createAsBoundingRectangle();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected BoundingRectangleCesiumWriter(@Nonnull BoundingRectangleCesiumWriter existingInstance) {
        super(existingInstance);
        m_asBoundingRectangle = createAsBoundingRectangle();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public BoundingRectangleCesiumWriter clone() {
        return new BoundingRectangleCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code boundingRectangle}, which is the bounding rectangle specified as {@code [X, Y, Width, Height]}.
    * @param value The value.
    */
    public final void writeBoundingRectangle(@Nonnull BoundingRectangle value) {
        final String PropertyName = BoundingRectanglePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeBoundingRectangle(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code boundingRectangle}, which is the bounding rectangle specified as {@code [X, Y, Width, Height]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBoundingRectangle(List<JulianDate> dates, List<BoundingRectangle> values) {
        writeBoundingRectangle(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code boundingRectangle}, which is the bounding rectangle specified as {@code [X, Y, Width, Height]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeBoundingRectangle(List<JulianDate> dates, List<BoundingRectangle> values, int startIndex, int length) {
        final String PropertyName = BoundingRectanglePropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeBoundingRectangle(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the bounding rectangle specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the bounding rectangle specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the bounding rectangle specified as a reference to another property.
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
    * Writes the value expressed as a {@code reference}, which is the bounding rectangle specified as a reference to another property.
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
    * Returns a wrapper for this instance that implements {@link ICesiumBoundingRectangleValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumBoundingRectangleValuePropertyAdaptor<BoundingRectangleCesiumWriter> asBoundingRectangle() {
        return m_asBoundingRectangle.getValue();
    }

    @Nonnull
    private final Lazy<CesiumBoundingRectangleValuePropertyAdaptor<BoundingRectangleCesiumWriter>> createAsBoundingRectangle() {
        return new Lazy<CesiumBoundingRectangleValuePropertyAdaptor<BoundingRectangleCesiumWriter>>(new Func1<CesiumBoundingRectangleValuePropertyAdaptor<BoundingRectangleCesiumWriter>>(this,
                "createBoundingRectangle") {
            public CesiumBoundingRectangleValuePropertyAdaptor<BoundingRectangleCesiumWriter> invoke() {
                return createBoundingRectangle();
            }
        }, false);
    }

    @Nonnull
    private final CesiumBoundingRectangleValuePropertyAdaptor<BoundingRectangleCesiumWriter> createBoundingRectangle() {
        return CesiumValuePropertyAdaptors.<BoundingRectangleCesiumWriter> createBoundingRectangle(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumReferenceValuePropertyAdaptor<BoundingRectangleCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumReferenceValuePropertyAdaptor<BoundingRectangleCesiumWriter>> createAsReference() {
        return new Lazy<CesiumReferenceValuePropertyAdaptor<BoundingRectangleCesiumWriter>>(new Func1<CesiumReferenceValuePropertyAdaptor<BoundingRectangleCesiumWriter>>(this, "createReference") {
            public CesiumReferenceValuePropertyAdaptor<BoundingRectangleCesiumWriter> invoke() {
                return createReference();
            }
        }, false);
    }

    @Nonnull
    private final CesiumReferenceValuePropertyAdaptor<BoundingRectangleCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<BoundingRectangleCesiumWriter> createReference(this);
    }
}