package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * A writer that can write a value as two values {@code [NearDistance, FarDistance]}.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumDistanceDisplayConditionValuePropertyWriter extends ICesiumInterpolatablePropertyWriter {
    /**
    * Writes the value as two values {@code [NearDistance, FarDistance]}.
    * @param value The value.
    */
    void writeDistanceDisplayCondition(@Nonnull Bounds value);

    /**
    * Writes the value as two values {@code [NearDistance, FarDistance]}.
    * @param lowerBound The lower bound.
    * @param upperBound The upper bound.
    */
    void writeDistanceDisplayCondition(double lowerBound, double upperBound);

    /**
    * Writes the value as two values {@code [NearDistance, FarDistance]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    void writeDistanceDisplayCondition(List<JulianDate> dates, List<Bounds> values);

    /**
    * Writes the value as two values {@code [NearDistance, FarDistance]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    void writeDistanceDisplayCondition(List<JulianDate> dates, List<Bounds> values, int startIndex, int length);
}