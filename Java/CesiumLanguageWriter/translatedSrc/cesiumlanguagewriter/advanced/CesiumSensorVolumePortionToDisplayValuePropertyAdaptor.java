package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Adapts a class that implements {@link ICesiumSensorVolumePortionToDisplayValuePropertyWriter} to implement
 {@link ICesiumPropertyWriter} for {@link CesiumSensorVolumePortionToDisplay} values.
 
 

 * @param <TFrom> The class that implements {@link ICesiumSensorVolumePortionToDisplayValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumSensorVolumePortionToDisplayValuePropertyAdaptor<TFrom extends ICesiumSensorVolumePortionToDisplayValuePropertyWriter> extends
        CesiumWriterAdaptor<TFrom, CesiumSensorVolumePortionToDisplay> {
    /**
    *  
    Initializes a new instance.
    
    
    
    

    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link CesiumSensorVolumePortionToDisplay}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumSensorVolumePortionToDisplayValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, CesiumSensorVolumePortionToDisplay> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeDeleteValueCallback);
    }
}