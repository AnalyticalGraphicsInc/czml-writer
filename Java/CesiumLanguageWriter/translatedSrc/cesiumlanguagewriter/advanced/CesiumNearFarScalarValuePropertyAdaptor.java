package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumNearFarScalarValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link NearFarScalar} values.
 * @param <TFrom> The class that implements {@link ICesiumNearFarScalarValuePropertyWriter} to adapt.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class CesiumNearFarScalarValuePropertyAdaptor<TFrom extends ICesiumNearFarScalarValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, NearFarScalar> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link NearFarScalar}.
    * @param writeSamplesCallback The callback to write samples of type {@link NearFarScalar}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumNearFarScalarValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, NearFarScalar> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, NearFarScalar> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}