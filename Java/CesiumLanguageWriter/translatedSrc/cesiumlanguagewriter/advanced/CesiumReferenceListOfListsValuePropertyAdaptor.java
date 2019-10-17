package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumReferenceListOfListsValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for a list of lists of {@link Reference} values.
 * @param <TFrom> The class that implements {@link ICesiumReferenceListOfListsValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumReferenceListOfListsValuePropertyAdaptor<TFrom extends ICesiumReferenceListOfListsValuePropertyWriter> extends
        CesiumWriterAdaptor<TFrom, Iterable<? extends Iterable<? extends Reference>>> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write a list of lists of {@link Reference} values.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumReferenceListOfListsValuePropertyAdaptor(@Nonnull TFrom parent,
            @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Iterable<? extends Iterable<? extends Reference>>> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}