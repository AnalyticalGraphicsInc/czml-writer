package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumCartesian2ValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link Rectangular} values.
 
 

 * @param <TFrom> The class that implements {@link ICesiumCartesian2ValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumCartesian2ValuePropertyAdaptor<TFrom extends ICesiumCartesian2ValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, Rectangular> {
    /**
    *  
    Initializes a new instance.
    
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link Rectangular}.
    * @param writeSamplesCallback The callback to write samples of type {@link Rectangular}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumCartesian2ValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Rectangular> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, Rectangular> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}