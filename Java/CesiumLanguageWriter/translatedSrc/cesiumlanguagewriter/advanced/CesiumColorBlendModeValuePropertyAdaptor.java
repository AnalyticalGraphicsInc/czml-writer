package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumColorBlendModeValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for {@link CesiumColorBlendMode} values.
 * @param <TFrom> The class that implements {@link ICesiumColorBlendModeValuePropertyWriter} to adapt.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class CesiumColorBlendModeValuePropertyAdaptor<TFrom extends ICesiumColorBlendModeValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, CesiumColorBlendMode> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link CesiumColorBlendMode}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumColorBlendModeValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, CesiumColorBlendMode> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}