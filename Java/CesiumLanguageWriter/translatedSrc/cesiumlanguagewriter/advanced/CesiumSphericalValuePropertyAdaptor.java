package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumSphericalValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link Spherical} values.
 
 

 * @param <TFrom> The class that implements {@link ICesiumSphericalValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumSphericalValuePropertyAdaptor<TFrom extends ICesiumSphericalValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, Spherical> {
    /**
    *  
    Initializes a new instance.
    
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link Spherical}.
    * @param writeSamplesCallback The callback to write samples of type {@link Spherical}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumSphericalValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Spherical> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, Spherical> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}