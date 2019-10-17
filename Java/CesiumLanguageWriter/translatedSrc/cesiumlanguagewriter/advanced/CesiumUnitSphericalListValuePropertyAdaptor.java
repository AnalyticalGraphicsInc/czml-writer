package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumUnitSphericalListValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for a list of {@link UnitSpherical} values.
 * @param <TFrom> The class that implements {@link ICesiumUnitSphericalListValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumUnitSphericalListValuePropertyAdaptor<TFrom extends ICesiumUnitSphericalListValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, Iterable<UnitSpherical>> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write a list of {@link UnitSpherical} values.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumUnitSphericalListValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Iterable<UnitSpherical>> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}