package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumCartographicDegreesListValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for a list of {@link Cartographic} values.
 * @param <TFrom> The class that implements {@link ICesiumCartographicDegreesListValuePropertyWriter} to adapt.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class CesiumCartographicDegreesListValuePropertyAdaptor<TFrom extends ICesiumCartographicDegreesListValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, Iterable<Cartographic>> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write a list of {@link Cartographic} values.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumCartographicDegreesListValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Iterable<Cartographic>> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}