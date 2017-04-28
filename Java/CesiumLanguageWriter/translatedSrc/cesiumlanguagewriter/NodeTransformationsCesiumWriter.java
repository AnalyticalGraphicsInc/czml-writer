package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.NodeTransformationCesiumWriter;

/**
 *  
 Writes a {@code NodeTransformations} to a {@link CesiumOutputStream}.  A {@code NodeTransformations} is a mapping of node names to node transformations.
 

 */
public class NodeTransformationsCesiumWriter extends CesiumPropertyWriter<NodeTransformationsCesiumWriter> {
    /**
    *  
    Initializes a new instance.
    

    */
    public NodeTransformationsCesiumWriter(String propertyName) {
        super(propertyName);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected NodeTransformationsCesiumWriter(NodeTransformationsCesiumWriter existingInstance) {
        super(existingInstance);
    }

    @Override
    public NodeTransformationsCesiumWriter clone() {
        return new NodeTransformationsCesiumWriter(this);
    }

    /**
    *  
    Gets a new writer for a {@code NodeTransformation} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  A {@code NodeTransformation} property defines transformations to apply to a particular node in a 3D model.
    

    */
    public final NodeTransformationCesiumWriter getNodeTransformationWriter(String name) {
        return new NodeTransformationCesiumWriter(name);
    }

    /**
    *  
    Opens and returns a new writer for a {@code NodeTransformation} property.  A {@code NodeTransformation} property defines transformations to apply to a particular node in a 3D model.
    
    

    * @param name The name of the new property writer.
    */
    public final NodeTransformationCesiumWriter openNodeTransformationProperty(String name) {
        openIntervalIfNecessary();
        return this.<NodeTransformationCesiumWriter> openAndReturn(new NodeTransformationCesiumWriter(name));
    }
}