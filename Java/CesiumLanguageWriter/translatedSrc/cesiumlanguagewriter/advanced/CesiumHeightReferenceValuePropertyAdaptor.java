package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumHeightReferenceValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for {@link CesiumHeightReference} values.
 
 

 * @param <TFrom> The class that implements {@link ICesiumHeightReferenceValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumHeightReferenceValuePropertyAdaptor<TFrom extends ICesiumHeightReferenceValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, CesiumHeightReference> {
    /**
    *  
    Initializes a new instance.
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link CesiumHeightReference}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumHeightReferenceValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, CesiumHeightReference> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}