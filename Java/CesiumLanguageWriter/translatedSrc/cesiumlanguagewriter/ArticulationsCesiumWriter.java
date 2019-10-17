package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.ArticulationCesiumWriter;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Articulations} to a {@link CesiumOutputStream}. A {@code Articulations} is a mapping of keys to articulation values, where the keys are the name of the articulation, a single space, and the name of the stage.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class ArticulationsCesiumWriter extends CesiumPropertyWriter<ArticulationsCesiumWriter> {
    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public ArticulationsCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected ArticulationsCesiumWriter(@Nonnull ArticulationsCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public ArticulationsCesiumWriter clone() {
        return new ArticulationsCesiumWriter(this);
    }

    /**
    * Gets a new writer for a {@code Articulation} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. A {@code Articulation} property defines articulation values to apply to a 3D model.
    */
    public final ArticulationCesiumWriter getArticulationWriter(String name) {
        return new ArticulationCesiumWriter(name);
    }

    /**
    * Opens and returns a new writer for a {@code Articulation} property. A {@code Articulation} property defines articulation values to apply to a 3D model.
    * @param name The name of the new property writer.
    */
    public final ArticulationCesiumWriter openArticulationProperty(String name) {
        openIntervalIfNecessary();
        return this.<ArticulationCesiumWriter> openAndReturn(new ArticulationCesiumWriter(name));
    }
}