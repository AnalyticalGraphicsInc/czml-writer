package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumReferenceValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link Reference} values.
 * @param <TFrom> The class that implements {@link ICesiumReferenceValuePropertyWriter} to adapt.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class CesiumReferenceValuePropertyAdaptor<TFrom extends ICesiumReferenceValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, Reference> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link Reference}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumReferenceValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Reference> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}