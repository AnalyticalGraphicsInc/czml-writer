package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumUnitSphericalValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link UnitSpherical} values.
 * @param <TFrom> The class that implements {@link ICesiumUnitSphericalValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumUnitSphericalValuePropertyAdaptor<TFrom extends ICesiumUnitSphericalValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, UnitSpherical> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link UnitSpherical}.
    * @param writeSamplesCallback The callback to write samples of type {@link UnitSpherical}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumUnitSphericalValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, UnitSpherical> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, UnitSpherical> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}