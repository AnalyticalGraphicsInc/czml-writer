package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import javax.annotation.Nonnull;

/**
 * An interface to an object that writes the values of a CZML
 property over one or more intervals.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public interface ICesiumPropertyWriter extends ICesiumElementWriter {
    /**
    * Writes the actual interval of time covered by this CZML interval.
    * @param start The start of the interval.
    * @param stop The end of the interval.
    */
    void writeInterval(@Nonnull JulianDate start, @Nonnull JulianDate stop);

    /**
    * Opens a writer that is used to write information about this property for a single interval.
    * @return The writer.
    */
    @Nonnull
    ICesiumPropertyWriter openInterval();

    /**
    * Opens a writer that is used to write information about this property for multiple discrete intervals.
    * @return The writer.
    */
    @Nonnull
    ICesiumIntervalListWriter openMultipleIntervals();

    /**
    * Gets a writer for intervals of this property.  The returned instance must be opened by calling
    the {@link ICesiumElementWriter#open} method before it can be used for writing.  Consider
    calling the {@link #openInterval} or {@link #openMultipleIntervals} method, which will automatically
    open the writer, instead of accessing this property directly.
    */
    ICesiumPropertyWriter getIntervalWriter();

    /**
    * Gets a value indicating whether this instance should always open an interval.
    */
    boolean getForceInterval();

    /**
    * Sets a value indicating whether this instance should always open an interval.
    */
    void setForceInterval(boolean value);
}