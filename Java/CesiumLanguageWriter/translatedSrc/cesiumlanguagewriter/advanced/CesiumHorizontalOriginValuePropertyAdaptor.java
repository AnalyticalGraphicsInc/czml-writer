package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumHorizontalOriginValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for {@link CesiumHorizontalOrigin} values.
 * @param <TFrom> The class that implements {@link ICesiumHorizontalOriginValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumHorizontalOriginValuePropertyAdaptor<TFrom extends ICesiumHorizontalOriginValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, CesiumHorizontalOrigin> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link CesiumHorizontalOrigin}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumHorizontalOriginValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, CesiumHorizontalOrigin> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}