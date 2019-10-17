package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumBoundingRectangleValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link BoundingRectangle} values.
 * @param <TFrom> The class that implements {@link ICesiumBoundingRectangleValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumBoundingRectangleValuePropertyAdaptor<TFrom extends ICesiumBoundingRectangleValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, BoundingRectangle> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link BoundingRectangle}.
    * @param writeSamplesCallback The callback to write samples of type {@link BoundingRectangle}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumBoundingRectangleValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, BoundingRectangle> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, BoundingRectangle> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}