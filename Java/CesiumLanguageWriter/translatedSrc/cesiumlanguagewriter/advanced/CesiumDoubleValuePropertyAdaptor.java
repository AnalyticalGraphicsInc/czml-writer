package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumDoubleValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@code double} values.
 * @param <TFrom> The class that implements {@link ICesiumDoubleValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumDoubleValuePropertyAdaptor<TFrom extends ICesiumDoubleValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, Double> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@code double}.
    * @param writeSamplesCallback The callback to write samples of type {@code double}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumDoubleValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Double> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, Double> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}