package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.Internal;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.ListHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *  
 Manages Leap Seconds.
 

 */
@SuppressWarnings("unused")
public class LeapSeconds {
    private static LeapSeconds s_leapSeconds = new LeapSeconds();

    /**
    *  Gets the default (and usually only) instance.
    

    */
    public static LeapSeconds getInstance() {
        return s_leapSeconds;
    }

    /**
    *  Sets the default (and usually only) instance.
    

    */
    public static void setInstance(LeapSeconds value) {
        s_leapSeconds = value;
    }

    /**
    *  
    Initializes a new instance with the list of leap seconds that was available
    when the library was released.
    

    */
    public LeapSeconds() {
        m_leapSeconds = new ArrayList<LeapSecond>();
        m_leapSeconds.add(new LeapSecond(2441317.5, 10D));
        m_leapSeconds.add(new LeapSecond(2441499.5, 11D));
        m_leapSeconds.add(new LeapSecond(2441683.5, 12D));
        m_leapSeconds.add(new LeapSecond(2442048.5, 13D));
        m_leapSeconds.add(new LeapSecond(2442413.5, 14D));
        m_leapSeconds.add(new LeapSecond(2442778.5, 15D));
        m_leapSeconds.add(new LeapSecond(2443144.5, 16D));
        m_leapSeconds.add(new LeapSecond(2443509.5, 17D));
        m_leapSeconds.add(new LeapSecond(2443874.5, 18D));
        m_leapSeconds.add(new LeapSecond(2444239.5, 19D));
        m_leapSeconds.add(new LeapSecond(2444786.5, 20D));
        m_leapSeconds.add(new LeapSecond(2445151.5, 21D));
        m_leapSeconds.add(new LeapSecond(2445516.5, 22D));
        m_leapSeconds.add(new LeapSecond(2446247.5, 23D));
        m_leapSeconds.add(new LeapSecond(2447161.5, 24D));
        m_leapSeconds.add(new LeapSecond(2447892.5, 25D));
        m_leapSeconds.add(new LeapSecond(2448257.5, 26D));
        m_leapSeconds.add(new LeapSecond(2448804.5, 27D));
        m_leapSeconds.add(new LeapSecond(2449169.5, 28D));
        m_leapSeconds.add(new LeapSecond(2449534.5, 29D));
        m_leapSeconds.add(new LeapSecond(2450083.5, 30D));
        m_leapSeconds.add(new LeapSecond(2450630.5, 31D));
        m_leapSeconds.add(new LeapSecond(2451179.5, 32D));
        m_leapSeconds.add(new LeapSecond(2453736.5, 33D));
        m_leapSeconds.add(new LeapSecond(2454832.5, 34D));
        m_leapSeconds.add(new LeapSecond(2456109.5, 35D));
        m_leapSeconds.add(new LeapSecond(2457204.5, 36D));
    }

    /**
    *  
    Initializes a new instance with the specified list of leap seconds.
    
    

    * @param leapSeconds The list of leap seconds.
    */
    public LeapSeconds(Iterable<LeapSecond> leapSeconds) {
        m_leapSeconds = ListHelper.create(leapSeconds);
        Collections.sort(m_leapSeconds, s_compareLeapSecondDate);
    }

    /**
    *  Gets the list of leap seconds currently being used by this class.
    

    */
    public final List<LeapSecond> getLeapSecondList() {
        return Collections.unmodifiableList(m_leapSeconds);
    }

    /**
    *  
    Returns the difference TAI - UTC as of the given date, in seconds.
    
    
    

    * @param date The date.
    * @return The difference.
    */
    public final double getTaiMinusUtc(JulianDate date) {
        LeapSecond toFind = new LeapSecond(date, 0.0);
        // Start by assuming we're working with UTC, we'll check later if we're
        // off by one because we really have TAI.
        int index = Collections.binarySearch(m_leapSeconds, toFind, s_compareLeapSecondDate);
        if (index < 0) {
            index = ~index;
            --index;
        }
        // Check if we're off by one because we're really working with TAI.
        // If the requested date minus the most recent previous leap second offset is less than the date
        // for the current leap second, then we haven't quite gotten to that leap second yet.
        // This gets a little tricky because JulianDate and its conversion mechanisms try to outsmart us.
        if (date.getStandard() == TimeStandard.INTERNATIONAL_ATOMIC_TIME) {
            JulianDate lastDate = getDateForIndex(index);
            JulianDate taiCutoff = new JulianDate(lastDate.getDay(), lastDate.getSecondsOfDay(), TimeStandard.INTERNATIONAL_ATOMIC_TIME);
            taiCutoff = JulianDate.add(taiCutoff, Duration.fromSeconds(getOffsetForIndex(index)));
            if (JulianDate.lessThan(date, taiCutoff)) {
                --index;
            }
        }
        return getOffsetForIndex(index);
    }

    /**
    *  
    Convert {@code date} from TAI to UTC, if possible.
    
    
    
    

    * @param date The date, which must be in the TAI 
    {@link TimeStandard}.
    * @return The resulting UTC 
    {@link JulianDate}, if it was possible to convert.
    * @deprecated Internal use only.
    * @exception ArgumentOutOfRangeException Thrown if the date could not be
    converted to UTC.
    */
    @Deprecated
    @Internal
    public final JulianDate convertTaiToUtc(JulianDate date) {
        @CS2JInfo("Initialization of C# struct variable 'result' added by translator.")
        JulianDate result = new JulianDate();
        final JulianDate[] out$result$1 = {
            null
        };
        final boolean temp$0 = tryConvertTaiToUtc(date, out$result$1);
        result = out$result$1[0];
        if (temp$0) {
            return result;
        }
        throw new ArgumentOutOfRangeException(CesiumLocalization.getCannotRepresentLeapSecondAsUTCJulianDate());
    }

    /**
    *  
    Try to convert {@code date} from TAI to UTC, if possible.
    
    
    
    

    * @param date The date, which must be in the TAI 
    {@link TimeStandard}.
    * @param result Out parameter for returning the resulting UTC 
    {@link JulianDate}, if it was possible to convert.
    * @return {@code true} if {@code date} could be converted
    to UTC, otherwise false.
    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public final boolean tryConvertTaiToUtc(JulianDate date, JulianDate[] result) {
        //treat the request date as if it were UTC, and search for the most recent leap second.
        LeapSecond toFind = new LeapSecond(date, 0.0);
        int index = Collections.binarySearch(m_leapSeconds, toFind, s_compareLeapSecondDate);
        if (index < 0) {
            index = ~index;
            --index;
        }
        //now we have the index of the most recent leap second that is after the requested date
        if (index >= 0) {
            double mostRecentOffset = getOffsetForIndex(index);
            JulianDate leapSecondDate = getDateForIndex(index);
            if (date.getDay() == leapSecondDate.getDay()) {
                //if the requested date is on the day of the leap second, we may have to adjust
                double secondsSinceLeapSecond = date.getSecondsOfDay() - leapSecondDate.getSecondsOfDay();
                if (secondsSinceLeapSecond >= mostRecentOffset - 1 && secondsSinceLeapSecond < mostRecentOffset) {
                    //if the requested date is during the moment of a leap second, then we cannot convert to UTC.
                    result[0] = JulianDate.getMinValue();
                    return false;
                }
                if (secondsSinceLeapSecond < mostRecentOffset) {
                    --index;
                }
            }
        }
        result[0] = new JulianDate(date.getDay(), date.getSecondsOfDay() - getOffsetForIndex(index), TimeStandard.COORDINATED_UNIVERSAL_TIME);
        return true;
    }

    private final JulianDate getDateForIndex(int index) {
        if (index < 0) {
            return new JulianDate(0, 0.0, TimeStandard.COORDINATED_UNIVERSAL_TIME);
        }
        return m_leapSeconds.get(index).getDate();
    }

    private final double getOffsetForIndex(int index) {
        if (index < 0) {
            return 10.0;
        }
        return m_leapSeconds.get(index).getTotalTaiOffsetFromUtc();
    }

    /**
    *  
    Determines if a given day contains a leap second.
    
    
    

    * @param julianDayNumber The day, specified as a Julian day number.
    * @return true if the day contains a leap second, otherwise false.
    */
    public final boolean doesDayHaveLeapSecond(int julianDayNumber) {
        LeapSecond potentialLeapSecond = new LeapSecond(new JulianDate(julianDayNumber, 43200D, TimeStandard.COORDINATED_UNIVERSAL_TIME), 0.0);
        return Collections.binarySearch(m_leapSeconds, potentialLeapSecond, s_compareLeapSecondDate) >= 0;
    }

    private static class CompareLeapSecondDate implements Comparator<LeapSecond> {
        public final int compare(LeapSecond x, LeapSecond y) {
            return x.getDate().compareTo(y.getDate());
        }
    }

    private ArrayList<LeapSecond> m_leapSeconds;
    private static CompareLeapSecondDate s_compareLeapSecondDate = new CompareLeapSecondDate();
}