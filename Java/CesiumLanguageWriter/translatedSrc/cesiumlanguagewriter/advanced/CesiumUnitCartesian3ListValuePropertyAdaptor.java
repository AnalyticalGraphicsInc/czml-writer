package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumUnitCartesian3ListValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for a list of {@link UnitCartesian} values.
 
 

 * @param <TFrom> The class that implements {@link ICesiumUnitCartesian3ListValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumUnitCartesian3ListValuePropertyAdaptor<TFrom extends ICesiumUnitCartesian3ListValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, Iterable<UnitCartesian>> {
    /**
    *  
    Initializes a new instance.
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write a list of {@link UnitCartesian} values.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumUnitCartesian3ListValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Iterable<UnitCartesian>> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}