package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumBooleanValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for {@code boolean} values.
 * @param <TFrom> The class that implements {@link ICesiumBooleanValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumBooleanValuePropertyAdaptor<TFrom extends ICesiumBooleanValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, Boolean> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@code boolean}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumBooleanValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Boolean> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}