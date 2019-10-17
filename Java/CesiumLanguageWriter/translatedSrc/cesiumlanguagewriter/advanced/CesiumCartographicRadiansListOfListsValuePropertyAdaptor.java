package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumCartographicRadiansListOfListsValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for a list of lists of {@link Cartographic} values.
 * @param <TFrom> The class that implements {@link ICesiumCartographicRadiansListOfListsValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumCartographicRadiansListOfListsValuePropertyAdaptor<TFrom extends ICesiumCartographicRadiansListOfListsValuePropertyWriter> extends
        CesiumWriterAdaptor<TFrom, Iterable<? extends Iterable<Cartographic>>> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write a list of lists of {@link Cartographic} values.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumCartographicRadiansListOfListsValuePropertyAdaptor(@Nonnull TFrom parent,
            @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Iterable<? extends Iterable<Cartographic>>> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}