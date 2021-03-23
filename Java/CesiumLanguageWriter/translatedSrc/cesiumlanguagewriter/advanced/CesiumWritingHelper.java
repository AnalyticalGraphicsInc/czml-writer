package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.ArrayHelper;
import cesiumlanguagewriter.*;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Contains helper methods for writing CZML values.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public final class CesiumWritingHelper {
    private CesiumWritingHelper() {}

    /**
    * The maximum interval of time that can be specified.
    */
    @Nonnull
    public static final TimeInterval MaximumInterval = new TimeInterval(GregorianDate.MinValue.toJulianDate(), GregorianDate.MaxValue.toJulianDate());

    @Nonnull
    private static Iso8601Format getIso8601Format(CesiumOutputStream output) {
        return output.getPrettyFormatting() ? Iso8601Format.EXTENDED : Iso8601Format.COMPACT;
    }

    /**
    * Writes a {@link JulianDate} as an ISO 8601 interval string.
    * @param output The stream to which the value will be written.
    * @param date The date to write.
    */
    public static void writeDate(CesiumOutputStream output, @Nonnull JulianDate date) {
        output.writeValue(CesiumFormattingHelper.toIso8601(date, getIso8601Format(output)));
    }

    /**
    * Writes a {@link TimeInterval} as an ISO 8601 interval string.
    * @param output The stream to which the value will be written.
    * @param interval The interval to write.
    */
    public static void writeTimeInterval(CesiumOutputStream output, TimeInterval interval) {
        output.writeValue(CesiumFormattingHelper.toIso8601Interval(interval.getStart(), interval.getStop(), getIso8601Format(output)));
    }

    /**
    * Writes a list of {@link TimeInterval TimeIntervals}.  If the collection has a single
    interval, the interval is written as an ISO 8601 interval string.  If it has multiple intervals,
    it is written as an array of ISO 8601 interval strings.
    * @param output The stream to which the value will be written.
    * @param intervals The intervals to write.
    */
    public static void writeTimeIntervalCollection(CesiumOutputStream output, List<TimeInterval> intervals) {
        if (intervals.size() == 1) {
            TimeInterval interval = intervals.get(0);
            writeTimeInterval(output, interval);
        } else {
            output.writeStartSequence();
            for (final TimeInterval interval : intervals) {
                writeTimeInterval(output, interval);
                output.writeLineBreak();
            }
            output.writeEndSequence();
        }
    }

    /**
    * Writes a {@link Rectangular} value as an array in X, Y order.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeCartesian2(CesiumOutputStream output, @Nonnull Rectangular value) {
        output.writeStartSequence();
        output.writeValue(value.getX());
        output.writeValue(value.getY());
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged {@link Rectangular} values as an array in [Time, X, Y] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeCartesian2(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            Rectangular value = values.get(i);
            output.writeValue(value.getX());
            output.writeValue(value.getY());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a {@link CartographicExtent} value as an array in WestLongitude, SouthLatitude, EastLongitude, NorthLatitude order.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeCartographicExtent(CesiumOutputStream output, CartographicExtent value) {
        output.writeStartSequence();
        output.writeValue(value.getWestLongitude());
        output.writeValue(value.getSouthLatitude());
        output.writeValue(value.getEastLongitude());
        output.writeValue(value.getNorthLatitude());
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged {@link CartographicExtent} values as an array in [Time, WestLongitude, SouthLatitude, EastLongitude, NorthLatitude] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeCartographicExtent(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<CartographicExtent> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            CartographicExtent value = values.get(i);
            output.writeValue(value.getWestLongitude());
            output.writeValue(value.getSouthLatitude());
            output.writeValue(value.getEastLongitude());
            output.writeValue(value.getNorthLatitude());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a {@link Cartesian} value as an array in X, Y, Z order.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeCartesian3(CesiumOutputStream output, @Nonnull Cartesian value) {
        output.writeStartSequence();
        output.writeValue(value.getX());
        output.writeValue(value.getY());
        output.writeValue(value.getZ());
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged {@link Cartesian} values as an array in [Time, X, Y, Z] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeCartesian3(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            Cartesian value = values.get(i);
            output.writeValue(value.getX());
            output.writeValue(value.getY());
            output.writeValue(value.getZ());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a {@link Motion1} value as an array in X, Y, Z, vX, vY, vZ order.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeCartesian3Velocity(CesiumOutputStream output, @Nonnull Motion1<Cartesian> value) {
        output.writeStartSequence();
        output.writeValue(value.getValue().getX());
        output.writeValue(value.getValue().getY());
        output.writeValue(value.getValue().getZ());
        output.writeValue(value.getFirstDerivative().getX());
        output.writeValue(value.getFirstDerivative().getY());
        output.writeValue(value.getFirstDerivative().getZ());
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged {@link Motion1} values as an array in [Time, X, Y, Z, vX, vY, vZ] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeCartesian3Velocity(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<Motion1<Cartesian>> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            Cartesian value = values.get(i).getValue();
            Cartesian velocity = values.get(i).getFirstDerivative();
            output.writeValue(value.getX());
            output.writeValue(value.getY());
            output.writeValue(value.getZ());
            output.writeValue(velocity.getX());
            output.writeValue(velocity.getY());
            output.writeValue(velocity.getZ());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a {@link UnitCartesian} value as an array in X, Y, Z order.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeUnitCartesian3(CesiumOutputStream output, @Nonnull UnitCartesian value) {
        output.writeStartSequence();
        output.writeValue(value.getX());
        output.writeValue(value.getY());
        output.writeValue(value.getZ());
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged {@link UnitCartesian} values as an array in [Time, X, Y, Z] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeUnitCartesian3(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<UnitCartesian> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            UnitCartesian value = values.get(i);
            output.writeValue(value.getX());
            output.writeValue(value.getY());
            output.writeValue(value.getZ());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a {@link Spherical} value as an array in Clock, Cone, Magnitude order.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeSpherical(CesiumOutputStream output, @Nonnull Spherical value) {
        output.writeStartSequence();
        output.writeValue(value.getClock());
        output.writeValue(value.getCone());
        output.writeValue(value.getMagnitude());
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged {@link Spherical} values as an array in [Time, Clock, Cone, Magnitude] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeSpherical(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<Spherical> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            Spherical value = values.get(i);
            output.writeValue(value.getClock());
            output.writeValue(value.getCone());
            output.writeValue(value.getMagnitude());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a {@link BoundingRectangle} value as an array in X, Y, Width, Height order.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeBoundingRectangle(CesiumOutputStream output, @Nonnull BoundingRectangle value) {
        output.writeStartSequence();
        output.writeValue(value.getLeft());
        output.writeValue(value.getBottom());
        output.writeValue(value.getWidth());
        output.writeValue(value.getHeight());
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged {@link BoundingRectangle} values as an array in [Time, X, Y, Width, Height] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeBoundingRectangle(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<BoundingRectangle> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            BoundingRectangle value = values.get(i);
            output.writeValue(value.getLeft());
            output.writeValue(value.getBottom());
            output.writeValue(value.getWidth());
            output.writeValue(value.getHeight());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a {@link NearFarScalar} value as an array in NearDistance, NearValue, FarDistance, FarValue order.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeNearFarScalar(CesiumOutputStream output, @Nonnull NearFarScalar value) {
        output.writeStartSequence();
        output.writeValue(value.getNearDistance());
        output.writeValue(value.getNearValue());
        output.writeValue(value.getFarDistance());
        output.writeValue(value.getFarValue());
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged {@link NearFarScalar} values as an array in [Time, NearDistance, NearValue, FarDistance, FarValue] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeNearFarScalar(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            NearFarScalar value = values.get(i);
            output.writeValue(value.getNearDistance());
            output.writeValue(value.getNearValue());
            output.writeValue(value.getFarDistance());
            output.writeValue(value.getFarValue());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a {@link Bounds} value as an array in LowerBound, UpperBound order.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeBounds(CesiumOutputStream output, @Nonnull Bounds value) {
        output.writeStartSequence();
        output.writeValue(value.getLowerBound());
        output.writeValue(value.getUpperBound());
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged {@link Bounds} values as an array in [Time, LowerBound, UpperBound] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeBounds(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<Bounds> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            Bounds value = values.get(i);
            output.writeValue(value.getLowerBound());
            output.writeValue(value.getUpperBound());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a {@link UnitSpherical} value as an array in Clock, Cone order.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeUnitSpherical(CesiumOutputStream output, @Nonnull UnitSpherical value) {
        output.writeStartSequence();
        output.writeValue(value.getClock());
        output.writeValue(value.getCone());
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged {@link UnitSpherical} values as an array in [Time, Clock, Cone] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeUnitSpherical(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<UnitSpherical> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            UnitSpherical value = values.get(i);
            output.writeValue(value.getClock());
            output.writeValue(value.getCone());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a list of {@code double} values as an array.
    * @param output The stream to which the value will be written.
    * @param values The values to write.
    */
    public static void writeDoubleList(CesiumOutputStream output, Iterable<Double> values) {
        output.writeStartSequence();
        for (final double value : values) {
            output.writeValue(value);
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a list of {@link Rectangular} values as an array in X, Y order.
    * @param output The stream to which the value will be written.
    * @param values The values to write.
    */
    public static void writeCartesian2List(CesiumOutputStream output, Iterable<Rectangular> values) {
        output.writeStartSequence();
        for (final Rectangular value : values) {
            output.writeValue(value.getX());
            output.writeValue(value.getY());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a list of {@link Cartesian} values as an array in X, Y, Z order.
    * @param output The stream to which the value will be written.
    * @param values The values to write.
    */
    public static void writeCartesian3List(CesiumOutputStream output, Iterable<Cartesian> values) {
        output.writeStartSequence();
        for (final Cartesian value : values) {
            output.writeValue(value.getX());
            output.writeValue(value.getY());
            output.writeValue(value.getZ());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a list of {@link Cartesian} values as an array in X, Y, Z order.
    * @param output The stream to which the value will be written.
    * @param values The values to write.
    */
    public static void writeCartesian3ListOfLists(CesiumOutputStream output, Iterable<? extends Iterable<Cartesian>> values) {
        output.writeStartSequence();
        for (final Iterable<Cartesian> list : values) {
            output.writeStartSequence();
            output.writeLineBreak();
            for (final Cartesian value : list) {
                output.writeValue(value.getX());
                output.writeValue(value.getY());
                output.writeValue(value.getZ());
                output.writeLineBreak();
            }
            output.writeEndSequence();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a {@link Cartographic} value as an array in Longitude, Latitude, Height order.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeCartographic(CesiumOutputStream output, @Nonnull Cartographic value) {
        output.writeStartSequence();
        output.writeValue(value.getLongitude());
        output.writeValue(value.getLatitude());
        output.writeValue(value.getHeight());
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged {@link Cartographic} values as an array in [Time, Longitude, Latitude, Height] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeCartographic(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            Cartographic value = values.get(i);
            output.writeValue(value.getLongitude());
            output.writeValue(value.getLatitude());
            output.writeValue(value.getHeight());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a list of {@link Cartographic} values as an array in Longitude, Latitude, Height order.
    * @param output The stream to which the value will be written.
    * @param values The values to write.
    */
    public static void writeCartographicList(CesiumOutputStream output, Iterable<Cartographic> values) {
        output.writeStartSequence();
        for (final Cartographic value : values) {
            output.writeValue(value.getLongitude());
            output.writeValue(value.getLatitude());
            output.writeValue(value.getHeight());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a list of {@link Cartographic} values as an array in Longitude, Latitude, Height order.
    * @param output The stream to which the value will be written.
    * @param values The values to write.
    */
    public static void writeCartographicListOfLists(CesiumOutputStream output, Iterable<? extends Iterable<Cartographic>> values) {
        output.writeStartSequence();
        for (final Iterable<Cartographic> list : values) {
            output.writeStartSequence();
            output.writeLineBreak();
            for (final Cartographic value : list) {
                output.writeValue(value.getLongitude());
                output.writeValue(value.getLatitude());
                output.writeValue(value.getHeight());
                output.writeLineBreak();
            }
            output.writeEndSequence();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a color value as an array in Red, Green, Blue, Alpha order.
    * @param output The stream to which to write the color.
    * @param value The value to write.
    */
    public static void writeRgba(CesiumOutputStream output, @Nonnull Color value) {
        writeRgba(output, value.getRed(), value.getGreen(), value.getBlue(), value.getAlpha());
    }

    /**
    * Writes a color value as an array in Red, Green, Blue, Alpha order.
    * @param output The stream to which to write the color.
    * @param red The red component in the range 0-255.
    * @param green The green component in the range 0-255.
    * @param blue The blue component in the range 0-255.
    * @param alpha The alpha component in the range 0-255.
    */
    public static void writeRgba(CesiumOutputStream output, int red, int green, int blue, int alpha) {
        output.writeStartSequence();
        output.writeValue(red);
        output.writeValue(green);
        output.writeValue(blue);
        output.writeValue(alpha);
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged color values as an array in [Time, Red, Green, Blue, Alpha] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeRgba(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<Color> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            Color value = values.get(i);
            output.writeValue(value.getRed());
            output.writeValue(value.getGreen());
            output.writeValue(value.getBlue());
            output.writeValue(value.getAlpha());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a color value as an array in Red, Green, Blue, Alpha order as floating-point values.
    * @param output The stream to which to write the color.
    * @param value The value to write.
    */
    public static void writeRgbaf(CesiumOutputStream output, @Nonnull Color value) {
        writeRgbaf(output, value.getRed() / 255.0, value.getGreen() / 255.0, value.getBlue() / 255.0, value.getAlpha() / 255.0);
    }

    /**
    * Writes a color value as an array in Red, Green, Blue, Alpha order as floating-point values.
    * @param output The stream to which to write the color.
    * @param red The red component in the range 0.0-1.0.
    * @param green The green component in the range 0.0-1.0.
    * @param blue The blue component in the range 0.0-1.0.
    * @param alpha The alpha component in the range 0.0-1.0.
    */
    public static void writeRgbaf(CesiumOutputStream output, double red, double green, double blue, double alpha) {
        output.writeStartSequence();
        output.writeValue(red);
        output.writeValue(green);
        output.writeValue(blue);
        output.writeValue(alpha);
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged color values as an array in [Time, Red, Green, Blue, Alpha] order as floating-point values.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeRgbaf(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<Color> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            Color value = values.get(i);
            output.writeValue(value.getRed() / 255.0);
            output.writeValue(value.getGreen() / 255.0);
            output.writeValue(value.getBlue() / 255.0);
            output.writeValue(value.getAlpha() / 255.0);
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged floating-point values as an array in [Time, Value] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeDouble(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            output.writeValue(values.get(i));
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes time-tagged floating-point values as an array in [Time, Value] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeInteger(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<Integer> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            output.writeValue(values.get(i));
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a {@link UnitQuaternion} as an array in [X, Y, Z, W] order.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeUnitQuaternion(CesiumOutputStream output, @Nonnull UnitQuaternion value) {
        output.writeStartSequence();
        output.writeValue(value.getX());
        output.writeValue(value.getY());
        output.writeValue(value.getZ());
        output.writeValue(value.getW());
        output.writeEndSequence();
    }

    /**
    * Writes the time-tagged {@link UnitQuaternion} collection as an array in
    [Time, X, Y, Z, W] order.
    Times are epoch seconds since an epoch that is determined from the first date to be written.
    The epoch property is written as well.
    * @param output The stream to which the values will be written.
    * @param propertyName The name of the property to write.
    * @param dates The dates at which the value is specified.
    * @param values The corresponding value for each date.
    * @param startIndex The index of the first element to use in the {@code values} collection.
    * @param length The number of elements to use from the {@code values} collection.
    */
    public static void writeUnitQuaternion(CesiumOutputStream output, String propertyName, List<JulianDate> dates, List<UnitQuaternion> values, int startIndex, int length) {
        if (dates.size() != values.size()) {
            throw new ArgumentException(CesiumLocalization.getMismatchedNumberOfDatesAndValues(), "values");
        }
        JulianDate epoch = getAndWriteEpoch(output, dates, startIndex, length);
        output.writePropertyName(propertyName);
        output.writeStartSequence();
        int last = startIndex + length;
        for (int i = startIndex; i < last; ++i) {
            output.writeValue(epoch.secondsDifference(dates.get(i)));
            UnitQuaternion quaternion = values.get(i);
            output.writeValue(quaternion.getX());
            output.writeValue(quaternion.getY());
            output.writeValue(quaternion.getZ());
            output.writeValue(quaternion.getW());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a reference.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeReference(@Nonnull CesiumOutputStream output, String value) {
        output.writeValue(value);
    }

    /**
    * Writes a reference.
    * @param output The stream to which the value will be written.
    * @param value The value to write.
    */
    public static void writeReference(CesiumOutputStream output, Reference value) {
        writeReference(output, value.getValue());
    }

    /**
    * Writes a reference and an identifier and property name.
    * @param output The stream to which the value will be written.
    * @param identifier The identifier of the referenced object.
    * @param propertyName The property name.
    */
    public static void writeReference(CesiumOutputStream output, String identifier, String propertyName) {
        writeReference(output, new Reference(identifier, propertyName));
    }

    /**
    * Writes a reference from an identifier and hierarchy of property names.
    * @param output The stream to which the value will be written.
    * @param identifier The identifier of the referenced object.
    * @param propertyNames The hierarchy of property names, where each name is a subproperty of the previous item.
    */
    public static void writeReference(CesiumOutputStream output, String identifier, String[] propertyNames) {
        writeReference(output, new Reference(identifier, ArrayHelper.arrayAsList(propertyNames)));
    }

    /**
    * Writes a list of values.
    * @param output The stream to which the value will be written.
    * @param references The list of values.
    */
    public static void writeReferences(CesiumOutputStream output, Iterable<Reference> references) {
        output.writeStartSequence();
        for (final Reference reference : references) {
            output.writeValue(reference.getValue());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a list of values.
    * @param output The stream to which the value will be written.
    * @param values The list of lists of values.
    */
    public static void writeReferenceListOfLists(CesiumOutputStream output, Iterable<? extends Iterable<? extends Reference>> values) {
        output.writeStartSequence();
        for (final Iterable<? extends Reference> list : values) {
            output.writeStartSequence();
            output.writeLineBreak();
            for (final Reference reference : list) {
                output.writeValue(reference.getValue());
                output.writeLineBreak();
            }
            output.writeEndSequence();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a list of {@link UnitCartesian} values as an array in X, Y, Z order.
    * @param output The stream to which the value will be written.
    * @param values The values to write.
    */
    public static void writeUnitCartesian3List(CesiumOutputStream output, Iterable<UnitCartesian> values) {
        output.writeStartSequence();
        for (final UnitCartesian value : values) {
            output.writeValue(value.getX());
            output.writeValue(value.getY());
            output.writeValue(value.getZ());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a list of {@link Spherical} values as an array in Clock, Cone, Magnitude order.
    * @param output The stream to which the value will be written.
    * @param values The values to write.
    */
    public static void writeSphericalList(CesiumOutputStream output, Iterable<Spherical> values) {
        output.writeStartSequence();
        for (final Spherical value : values) {
            output.writeValue(value.getClock());
            output.writeValue(value.getCone());
            output.writeValue(value.getMagnitude());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Writes a list of {@link UnitSpherical} values as an array in Clock, Cone order.
    * @param output The stream to which the value will be written.
    * @param values The values to write.
    */
    public static void writeUnitSphericalList(CesiumOutputStream output, Iterable<UnitSpherical> values) {
        output.writeStartSequence();
        for (final UnitSpherical value : values) {
            output.writeValue(value.getClock());
            output.writeValue(value.getCone());
            output.writeLineBreak();
        }
        output.writeEndSequence();
    }

    /**
    * Gets an appropriate epoch from a list of dates and writes it to the {@link CesiumOutputStream}
    as the "epoch" property.  If the {@code dates} collection is empty, the {@code startIndex}
    is past the end of the collection, or the {@code length} is zero, this method does not write
    the "epoch" property and returns {@code MinValue} ({@link JulianDate#getMinValue get}).
    * @param output The stream to which to write the epoch.
    * @param dates The collection of dates from which to determine the epoch.
    * @param startIndex The first index in the collection to use.
    * @param length The number of items from the collection to use.
    * @return A suitable epoch determined from the collection.
    */
    @Nonnull
    private static JulianDate getAndWriteEpoch(CesiumOutputStream output, List<JulianDate> dates, int startIndex, int length) {
        if (startIndex >= dates.size()) {
            return JulianDate.getMinValue();
        }
        JulianDate epoch = dates.get(startIndex);
        output.writePropertyName("epoch");
        output.writeValue(CesiumFormattingHelper.toIso8601(epoch, getIso8601Format(output)));
        return epoch;
    }
}