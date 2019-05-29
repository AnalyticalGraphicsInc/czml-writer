package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.awt.Color;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumRgbaValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link Color} values.
 
 

 * @param <TFrom> The class that implements {@link ICesiumRgbaValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumRgbaValuePropertyAdaptor<TFrom extends ICesiumRgbaValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, Color> {
    /**
    *  
    Initializes a new instance.
    
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link Color}.
    * @param writeSamplesCallback The callback to write samples of type {@link Color}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumRgbaValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Color> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, Color> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}