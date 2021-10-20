package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumCartesian2ListValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for a list of {@link Rectangular} values.
 * @param <TFrom> The class that implements {@link ICesiumCartesian2ListValuePropertyWriter} to adapt.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class CesiumCartesian2ListValuePropertyAdaptor<TFrom extends ICesiumCartesian2ListValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, Iterable<Rectangular>> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write a list of {@link Rectangular} values.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumCartesian2ListValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Iterable<Rectangular>> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}