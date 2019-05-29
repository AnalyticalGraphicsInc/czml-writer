package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumCartographicDegreesValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link Cartographic} values.
 
 

 * @param <TFrom> The class that implements {@link ICesiumCartographicDegreesValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumCartographicDegreesValuePropertyAdaptor<TFrom extends ICesiumCartographicDegreesValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, Cartographic> {
    /**
    *  
    Initializes a new instance.
    
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link Cartographic}.
    * @param writeSamplesCallback The callback to write samples of type {@link Cartographic}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumCartographicDegreesValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Cartographic> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, Cartographic> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}