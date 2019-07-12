package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumShadowModeValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link CesiumShadowMode} values.
 
 

 * @param <TFrom> The class that implements {@link ICesiumShadowModeValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumShadowModeValuePropertyAdaptor<TFrom extends ICesiumShadowModeValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, CesiumShadowMode> {
    /**
    *  
    Initializes a new instance.
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link CesiumShadowMode}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumShadowModeValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, CesiumShadowMode> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}