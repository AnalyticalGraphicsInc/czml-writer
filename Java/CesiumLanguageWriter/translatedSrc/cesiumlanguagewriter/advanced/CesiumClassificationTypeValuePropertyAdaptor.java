package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumClassificationTypeValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for {@link CesiumClassificationType} values.
 * @param <TFrom> The class that implements {@link ICesiumClassificationTypeValuePropertyWriter} to adapt.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class CesiumClassificationTypeValuePropertyAdaptor<TFrom extends ICesiumClassificationTypeValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, CesiumClassificationType> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link CesiumClassificationType}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumClassificationTypeValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, CesiumClassificationType> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}