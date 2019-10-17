package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.advanced.*;

/**
 * A {@link CesiumPropertyWriter} used to write custom properties.  To write custom
 properties, create writers of the appropriate type (for example, {@link DoubleCesiumWriter})
 and with the desired property name.  Then, after opening this {@link CustomCesiumWriter},
 {@link CesiumElementWriter#open} the sub-property writers and use them to write values.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CustomCesiumWriter extends CesiumPropertyWriter<CustomCesiumWriter> {
    /**
    * Initializes a new instance.
    */
    public CustomCesiumWriter(String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected CustomCesiumWriter(CustomCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public CustomCesiumWriter clone() {
        return new CustomCesiumWriter(this);
    }
}