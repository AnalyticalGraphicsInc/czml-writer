package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumCartographicRadiansValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link Cartographic} values.
 * @param <TFrom> The class that implements {@link ICesiumCartographicRadiansValuePropertyWriter} to adapt.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class CesiumCartographicRadiansValuePropertyAdaptor<TFrom extends ICesiumCartographicRadiansValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, Cartographic> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link Cartographic}.
    * @param writeSamplesCallback The callback to write samples of type {@link Cartographic}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumCartographicRadiansValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Cartographic> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, Cartographic> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}