package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumUriValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link CesiumResource} values.
 * @param <TFrom> The class that implements {@link ICesiumUriValuePropertyWriter} to adapt.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class CesiumUriValuePropertyAdaptor<TFrom extends ICesiumUriValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, CesiumResource> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link CesiumResource}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumUriValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, CesiumResource> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}