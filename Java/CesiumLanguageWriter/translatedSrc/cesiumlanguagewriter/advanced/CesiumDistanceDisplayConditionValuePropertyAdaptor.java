package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumDistanceDisplayConditionValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link Bounds} values.
 * @param <TFrom> The class that implements {@link ICesiumDistanceDisplayConditionValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumDistanceDisplayConditionValuePropertyAdaptor<TFrom extends ICesiumDistanceDisplayConditionValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, Bounds> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link Bounds}.
    * @param writeSamplesCallback The callback to write samples of type {@link Bounds}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumDistanceDisplayConditionValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Bounds> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, Bounds> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}