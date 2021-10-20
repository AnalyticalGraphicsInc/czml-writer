package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumUnitQuaternionValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link UnitQuaternion} values.
 * @param <TFrom> The class that implements {@link ICesiumUnitQuaternionValuePropertyWriter} to adapt.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class CesiumUnitQuaternionValuePropertyAdaptor<TFrom extends ICesiumUnitQuaternionValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, UnitQuaternion> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link UnitQuaternion}.
    * @param writeSamplesCallback The callback to write samples of type {@link UnitQuaternion}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumUnitQuaternionValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, UnitQuaternion> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, UnitQuaternion> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}