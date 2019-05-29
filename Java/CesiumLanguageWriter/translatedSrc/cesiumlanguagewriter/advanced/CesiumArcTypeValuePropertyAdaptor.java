package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumArcTypeValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for {@link CesiumArcType} values.
 
 

 * @param <TFrom> The class that implements {@link ICesiumArcTypeValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumArcTypeValuePropertyAdaptor<TFrom extends ICesiumArcTypeValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, CesiumArcType> {
    /**
    *  
    Initializes a new instance.
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link CesiumArcType}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumArcTypeValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, CesiumArcType> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}