package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumCartesian3ValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link Cartesian} values.
 * @param <TFrom> The class that implements {@link ICesiumCartesian3ValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumCartesian3ValuePropertyAdaptor<TFrom extends ICesiumCartesian3ValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, Cartesian> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link Cartesian}.
    * @param writeSamplesCallback The callback to write samples of type {@link Cartesian}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumCartesian3ValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Cartesian> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, Cartesian> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}