package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumCartesian3ListValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for a list of {@link Cartesian} values.
 
 

 * @param <TFrom> The class that implements {@link ICesiumCartesian3ListValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumCartesian3ListValuePropertyAdaptor<TFrom extends ICesiumCartesian3ListValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, Iterable<Cartesian>> {
    /**
    *  
    Initializes a new instance.
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write a list of {@link Cartesian} values.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumCartesian3ListValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Iterable<Cartesian>> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}