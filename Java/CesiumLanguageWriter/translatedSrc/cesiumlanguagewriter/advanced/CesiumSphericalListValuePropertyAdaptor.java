package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumSphericalListValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for a list of {@link Spherical} values.
 
 

 * @param <TFrom> The class that implements {@link ICesiumSphericalListValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumSphericalListValuePropertyAdaptor<TFrom extends ICesiumSphericalListValuePropertyWriter> extends CesiumWriterAdaptor<TFrom, Iterable<Spherical>> {
    /**
    *  
    Initializes a new instance.
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write a list of {@link Spherical} values.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumSphericalListValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Iterable<Spherical>> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}