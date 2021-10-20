package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumUnitCartesian3ValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link UnitCartesian} values.
 * @param <TFrom> The class that implements {@link ICesiumUnitCartesian3ValuePropertyWriter} to adapt.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class CesiumUnitCartesian3ValuePropertyAdaptor<TFrom extends ICesiumUnitCartesian3ValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, UnitCartesian> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link UnitCartesian}.
    * @param writeSamplesCallback The callback to write samples of type {@link UnitCartesian}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumUnitCartesian3ValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, UnitCartesian> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, UnitCartesian> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}