package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumStringValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link String} values.
 
 

 * @param <TFrom> The class that implements {@link ICesiumStringValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumStringValuePropertyAdaptor<TFrom extends ICesiumStringValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, String> {
    /**
    *  
    Initializes a new instance.
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link String}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumStringValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, String> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}