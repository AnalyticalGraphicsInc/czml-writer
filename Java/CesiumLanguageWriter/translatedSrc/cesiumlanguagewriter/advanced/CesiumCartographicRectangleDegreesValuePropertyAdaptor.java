package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumCartographicRectangleDegreesValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link CartographicExtent} values.
 
 

 * @param <TFrom> The class that implements {@link ICesiumCartographicRectangleDegreesValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumCartographicRectangleDegreesValuePropertyAdaptor<TFrom extends ICesiumCartographicRectangleDegreesValuePropertyWriter> extends
        CesiumInterpolatableWriterAdaptor<TFrom, CartographicExtent> {
    /**
    *  
    Initializes a new instance.
    
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link CartographicExtent}.
    * @param writeSamplesCallback The callback to write samples of type {@link CartographicExtent}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumCartographicRectangleDegreesValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, CartographicExtent> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, CartographicExtent> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}