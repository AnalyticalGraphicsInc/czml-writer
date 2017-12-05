package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 *  
 Interface for classes that adapt a class derived from {@link CesiumPropertyWriter}.
 
 

 * @param <TFrom> The type of property writer class to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumWriterAdaptor<TFrom> {
    /**
    *  Gets the parent being adapted.
    

    */
    @Nonnull
    TFrom getParent();
}