package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumLabelStyleValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for {@link CesiumLabelStyle} values.
 * @param <TFrom> The class that implements {@link ICesiumLabelStyleValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumLabelStyleValuePropertyAdaptor<TFrom extends ICesiumLabelStyleValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, CesiumLabelStyle> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link CesiumLabelStyle}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumLabelStyleValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, CesiumLabelStyle> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}