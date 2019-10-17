package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 * A writer that can write a value as a reference to another property.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public interface ICesiumReferenceValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes the value as a reference to another property.
    * @param value The reference.
    */
    void writeReference(Reference value);

    /**
    * Writes the value as a reference to another property.
    * @param value The reference.
    */
    void writeReference(String value);

    /**
    * Writes the value as a reference to another property.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    void writeReference(String identifier, String propertyName);

    /**
    * Writes the value as a reference to another property.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    void writeReference(String identifier, String[] propertyNames);
}