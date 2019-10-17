package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 * A writer that can write a value as a list of lists of references to other properties.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumReferenceListOfListsValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes the value as a list of lists of references.
    * @param references The list of lists of references.
    */
    void writeReferences(Iterable<? extends Iterable<? extends Reference>> references);
}