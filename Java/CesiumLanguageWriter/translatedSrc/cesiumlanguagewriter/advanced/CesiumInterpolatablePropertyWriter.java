package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * A CZML writer for a property that represents a value that may be sampled
 and interpolated.  The property may be defined over a single interval or over multiple intervals.
 * @param <TDerived> The type of the class derived from this one.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public abstract class CesiumInterpolatablePropertyWriter<TDerived extends CesiumInterpolatablePropertyWriter<TDerived>> extends CesiumPropertyWriter<TDerived> implements
        ICesiumInterpolatablePropertyWriter {
    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    protected CesiumInterpolatablePropertyWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected CesiumInterpolatablePropertyWriter(@Nonnull CesiumInterpolatablePropertyWriter<TDerived> existingInstance) {
        super(existingInstance);
    }

    /**
    * Writes the interpolation algorithm to use to interpolate the sampled data in this interval.
    * @param interpolationAlgorithm The interpolation algorithm.
    */
    public final void writeInterpolationAlgorithm(@Nonnull CesiumInterpolationAlgorithm interpolationAlgorithm) {
        openIntervalIfNecessary();
        getOutput().writePropertyName("interpolationAlgorithm");
        getOutput().writeValue(CesiumFormattingHelper.interpolationAlgorithmToString(interpolationAlgorithm));
    }

    /**
    * Writes the degree of polynomial to use to interpolate sampled data in this interval.
    * @param degree The degree.
    */
    public final void writeInterpolationDegree(int degree) {
        openIntervalIfNecessary();
        getOutput().writePropertyName("interpolationDegree");
        getOutput().writeValue(degree);
    }

    /**
    * Writes the type of extrapolation to perform when a value is requested at a time after any available samples.
    * @param extrapolationType The extrapolation type.
    */
    public final void writeForwardExtrapolationType(@Nonnull CesiumExtrapolationType extrapolationType) {
        openIntervalIfNecessary();
        getOutput().writePropertyName("forwardExtrapolationType");
        getOutput().writeValue(CesiumFormattingHelper.extrapolationTypeToString(extrapolationType));
    }

    /**
    * Writes the amount of time to extrapolate forward before the property becomes undefined.  A value of 0 will extrapolate forever.
    * @param duration The duration.
    */
    public final void writeForwardExtrapolationDuration(@Nonnull Duration duration) {
        openIntervalIfNecessary();
        getOutput().writePropertyName("forwardExtrapolationDuration");
        getOutput().writeValue(duration.getTotalSeconds());
    }

    /**
    * Writes the type of extrapolation to perform when a value is requested at a time before any available samples.
    * @param extrapolationType The extrapolation type.
    */
    public final void writeBackwardExtrapolationType(@Nonnull CesiumExtrapolationType extrapolationType) {
        openIntervalIfNecessary();
        getOutput().writePropertyName("backwardExtrapolationType");
        getOutput().writeValue(CesiumFormattingHelper.extrapolationTypeToString(extrapolationType));
    }

    /**
    * Writes the amount of time to extrapolate backward before the property becomes undefined.  A value of 0 will extrapolate forever.
    * @param duration The duration.
    */
    public final void writeBackwardExtrapolationDuration(@Nonnull Duration duration) {
        openIntervalIfNecessary();
        getOutput().writePropertyName("backwardExtrapolationDuration");
        getOutput().writeValue(duration.getTotalSeconds());
    }
}