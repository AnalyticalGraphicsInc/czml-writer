package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 *  
 Interface for classes that adapt a class derived from {@link CesiumPropertyWriter}.
 
 

 * @param <TFrom> The type of property writer class to adapt.
 */
@SuppressWarnings("unused")
public interface ICesiumWriterAdaptor<TFrom> {
    /**
    *  Gets the parent being adapted.
    

    */
    TFrom getParent();
}