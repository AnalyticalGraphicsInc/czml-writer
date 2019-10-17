package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumStripeOrientationValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link CesiumStripeOrientation} values.
 * @param <TFrom> The class that implements {@link ICesiumStripeOrientationValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumStripeOrientationValuePropertyAdaptor<TFrom extends ICesiumStripeOrientationValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, CesiumStripeOrientation> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link CesiumStripeOrientation}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumStripeOrientationValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, CesiumStripeOrientation> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}