package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumVerticalOriginValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link CesiumVerticalOrigin} values.
 * @param <TFrom> The class that implements {@link ICesiumVerticalOriginValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumVerticalOriginValuePropertyAdaptor<TFrom extends ICesiumVerticalOriginValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, CesiumVerticalOrigin> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link CesiumVerticalOrigin}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumVerticalOriginValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, CesiumVerticalOrigin> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}