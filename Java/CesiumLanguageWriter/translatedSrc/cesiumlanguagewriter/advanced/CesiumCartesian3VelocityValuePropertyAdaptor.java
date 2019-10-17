package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * Adapts a class that implements {@link ICesiumCartesian3VelocityValuePropertyWriter} to implement
 {@link ICesiumInterpolatableValuePropertyWriter} for {@link Motion1} values.
 * @param <TFrom> The class that implements {@link ICesiumCartesian3VelocityValuePropertyWriter} to adapt.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CesiumCartesian3VelocityValuePropertyAdaptor<TFrom extends ICesiumCartesian3VelocityValuePropertyWriter> extends CesiumInterpolatableWriterAdaptor<TFrom, Motion1<Cartesian>> {
    /**
    * Initializes a new instance.
    * @param parent The instance to wrap.
    * @param writeValueCallback The callback to write values of type {@link Motion1}.
    * @param writeSamplesCallback The callback to write samples of type {@link Motion1}.
    * @param writeDeleteValueCallback The callback to write an indication that the client should delete existing data.
    */
    public CesiumCartesian3VelocityValuePropertyAdaptor(@Nonnull TFrom parent, @Nonnull CesiumWriterAdaptorWriteCallback<TFrom, Motion1<Cartesian>> writeValueCallback,
            @Nonnull CesiumWriterAdaptorWriteSamplesCallback<TFrom, Motion1<Cartesian>> writeSamplesCallback, @Nonnull CesiumWriterAdaptorWriteDeleteCallback<TFrom> writeDeleteValueCallback) {
        super(parent, writeValueCallback, writeSamplesCallback, writeDeleteValueCallback);
    }
}