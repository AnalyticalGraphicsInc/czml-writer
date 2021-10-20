package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;

/**
 * A writer that can write a value as the normalized velocity vector of a position property.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumVelocityReferenceValuePropertyWriter extends ICesiumPropertyWriter {
    /**
    * Writes the value as the normalized velocity vector of a position property.
    * @param value The reference.
    */
    void writeVelocityReference(Reference value);

    /**
    * Writes the value as the normalized velocity vector of a position property.
    * @param value The reference.
    */
    void writeVelocityReference(String value);

    /**
    * Writes the value as the normalized velocity vector of a position property.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    void writeVelocityReference(String identifier, String propertyName);

    /**
    * Writes the value as the normalized velocity vector of a position property.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    void writeVelocityReference(String identifier, String[] propertyNames);
}