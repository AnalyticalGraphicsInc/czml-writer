package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumCornerTypeValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for {@link CesiumCornerType} values.
 * @param <TFrom> The class that implements {@link ICesiumCornerTypeValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumCornerTypeValuePropertyAdaptor<TFrom extends ICesiumCornerTypeValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, CesiumCornerType> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link CesiumCornerType}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumCornerTypeValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, CesiumCornerType> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}