package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JInfo;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.ArgumentOutOfRangeException;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DateTimeHelper;
import agi.foundation.compatibility.DayOfWeek;
import agi.foundation.compatibility.IEquatable;
import agi.foundation.compatibility.ImmutableValueType;
import agi.foundation.compatibility.PrimitiveHelper;
import agi.foundation.compatibility.StringHelper;
import org.joda.time.DateTime;

/**
 *  
 Represents a calendar year, month, and day.
 

 */
@SuppressWarnings("unused")
public final class YearMonthDay implements Comparable<YearMonthDay>, IEquatable<YearMonthDay>, ImmutableValueType {
    /**
    * Initializes a new instance.
    */
    public YearMonthDay() {}

    /**
    *  
    Initializes a {@link YearMonthDay} from the provided values.
    
    
    
    
    

    * @param year The year.
    * @param month The month of the year (in the range 1 through 12)
    * @param day The day of the month (in the range 1 through the number of
    days in {@code month})
    * @exception ArgumentException 
    Thrown when the {@code year}, {@code month}, or
    {@code day} is outside of its acceptable range.
    */
    public YearMonthDay(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            //fields are stored zero-indexed
            m_year = year - 1;
            m_month = month - 1;
            m_day = day - 1;
        } else {
            throw new ArgumentException(CesiumLocalization.getYearMonthDayInvalidArgument());
        }
    }

    /**
    *  
    Initializes a {@link YearMonthDay} from the provided values.
    
    
    

    * @param year The year.
    * @param dayOfYear The day of the year
    (in the range 1 through the number of days in the year).
    */
    public YearMonthDay(int year, int dayOfYear) {
        if (dayOfYear <= daysInYear(year)) {
            //year is stored zero-indexed
            m_year = year - 1;
            int[] cumulativeDays = isLeapYear(year) ? s_leapYearCumulativeMonthTable : s_commonYearCumulativeMonthTable;
            //month is stored zero-indexed
            for (m_month = 11; m_month > 0; --m_month) {
                if (cumulativeDays[m_month] < dayOfYear) {
                    break;
                }
            }
            //day is stored zero-indexed
            m_day = dayOfYear - cumulativeDays[m_month] - 1;
            if (!isValidDate(m_year + 1, m_month + 1, m_day + 1)) {
                throw new ArgumentException(CesiumLocalization.getYearMonthDayInvalidArgument());
            }
        } else {
            throw new ArgumentException(CesiumLocalization.getYearMonthDayInvalidArgument());
        }
    }

    /**
    *  
    Initializes a {@link YearMonthDay} in the Gregorian calendar from the
    provided astronomical  Julian day number, assuming the beginning of the Julian
    day (noon).
    
    

    * @param astronomicalJulianDayNumber The astronomical Julian day number.
    
    */
    @CS2JWarning("Unhandled attribute removed: SuppressMessage")
    public YearMonthDay(int astronomicalJulianDayNumber) {
        // Algorithm from page 604 of the Explanatory Supplement to the
        // Astronomical Almanac (Seidelmann 1992).
        int L = astronomicalJulianDayNumber + 68569;
        int N = 4 * L / 146097;
        L = L - (146097 * N + 3) / 4;
        int I = 4000 * (L + 1) / 1461001;
        L = L - 1461 * I / 4 + 31;
        int J = 80 * L / 2447;
        m_day = L - 2447 * J / 80;
        L = J / 11;
        m_month = J + 2 - 12 * L;
        m_year = 100 * (N - 49) + I + L;
        m_year--;
        m_month--;
        m_day--;
        if (!isValidDate(m_year + 1, m_month + 1, m_day + 1)) {
            throw new ArgumentOutOfRangeException(CesiumLocalization.getYearMonthDayInvalidArgument());
        }
    }

    /**
    *  
    Initializes a new instance from a {@link JulianDate}.
    
    

    * @param date The date.
    */
    public YearMonthDay(JulianDate date) {
        this(getAdjustedJulianDayNumber(date));
    }

    /**
    *  
    The constructor taking an integer Julian day number assumes that the desired
    {@link YearMonthDay} should represent the Gregorian day corresponding to
    the beginning of the provided Julian day number. If the
    {@link JulianDate} is more than one half day later than that, the
    calculation will be wrong.

    So, if {@code date} is more than 12 hours past the start of the
    Julian day, we instead use the  Julian date number of tomorrow.
    
    
    

    * @param date The date.
    * @return The Julian day number that will produce the correct Gregorian day
    number.
    */
    private static int getAdjustedJulianDayNumber(JulianDate date) {
        int day = date.getDay();
        if (date.getSecondsOfDay() >= 43200.0) {
            ++day;
        }
        return day;
    }

    /**
    *  Gets the year.
    

    */
    public final int getYear() {
        return m_year + 1;
    }

    /**
    *  Gets the month of the year (in the range 1 through 12).
    

    */
    public final int getMonth() {
        //month is stored zero-indexed
        return m_month + 1;
    }

    /**
    *  Gets the day of the month (in the range 1 through the number of days in the
    month).
    

    */
    public final int getDay() {
        //day is stored zero-indexed
        return m_day + 1;
    }

    /**
    *  Gets the day of the year (in the range 1 through the number of days in the
    year).
    

    */
    public final int getDayOfYear() {
        if (isLeapYear(getYear())) {
            return getDay() + s_leapYearCumulativeMonthTable[m_month];
        }
        return getDay() + s_commonYearCumulativeMonthTable[m_month];
    }

    /**
    *  Gets the day of the week represented by this instance.
    

    * @return A {@code DayOfWeek} ({@link #getDayOfWeek get}) enumerated constant that indicates the day
    of the week. This property value ranges from zero, indicating Sunday, to six,
    indicating Saturday.
    */
    public final int getDayOfWeek() {
        return DayOfWeek.fromJoda(new DateTime(getYear(), getMonth(), getDay(), 0, 0, 0, 0, org.joda.time.DateTimeZone.UTC).getDayOfWeek());
    }

    /**
    *  Gets the Julian day number for this {@link YearMonthDay} instance,
    assuming noon on this day.
    

    */
    public final int getJulianDayNumber() {
        // Algorithm from page 604 of the Explanatory Supplement to the
        // Astronomical Almanac (Seidelmann 1992).
        int a = (getMonth() - 14) / 12;
        int b = getYear() + 4800 + a;
        return 1461 * b / 4 + 367 * (getMonth() - 2 - 12 * a) / 12 - 3 * ((b + 100) / 100) / 4 + getDay() - 32075;
    }

    /**
    *  
    Indicates whether the year in question is a leap year.
    
    
    

    * @param year The year.
    * @return {@code true} if {@code year} is a leap year and
    {@code false} if it is not.
    
    */
    public static boolean isLeapYear(int year) {
        return DateTimeHelper.isLeapYear(year);
    }

    /**
    *  
    Provides the number of days in the month of the indicated year.
    
    
    
    

    * @param year The year.
    * @param month The month of the year.
    * @return The number of days in the month.
    */
    public static int daysInMonth(int year, int month) {
        return DateTimeHelper.daysInMonth(year, month);
    }

    /**
    *  
    Provides the number of days in the indicated year.
    
    
    

    * @param year The year.
    * @return The number of days in the year (365 for a common year and 366 for a
    leap year).
    */
    public static int daysInYear(int year) {
        if (isLeapYear(year)) {
            return 366;
        }
        return 365;
    }

    /**
    *  
    Indicates whether the year, month, and day are a valid representation.
    
    
    
    
    

    * @param year The year.
    * @param month The month of the year (in the range 1 through 12)
    * @param day The day of the month (in the range 1 through the number of days in
    {@code month})
    * @return {@code true} if the representation is valid and
    {@code false} if it is not.
    */
    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > daysInMonth(year, month)) {
            return false;
        }
        return true;
    }

    /**
    *  
    Returns a hash code for this instance, which is suitable for use in hashing algorithms and data structures like a hash table.
    
    

    * @return A hash code for the current object.
    */
    @Override
    public int hashCode() {
        return HashCode.combine(PrimitiveHelper.hashCode(m_year), PrimitiveHelper.hashCode(m_month), PrimitiveHelper.hashCode(m_day));
    }

    /**
    *  
    Indicates whether another instance of this type is exactly equal to this instance.
    
    
    

    * @param other The instance to compare to this instance.
    * @return {@code true} if {@code other} represents the same value as this instance; otherwise, {@code false}.
    */
    public final boolean equalsType(YearMonthDay other) {
        return m_year == other.m_year && m_month == other.m_month && m_day == other.m_day;
    }

    /**
    *  
    Indicates whether another object is exactly equal to this instance.
    
    
    

    * @param obj The object to compare to this instance.
    * @return {@code true} if {@code obj} is an instance of this type and represents the same value as this instance; otherwise, {@code false}.
    */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof YearMonthDay && equalsType((YearMonthDay) obj);
    }

    /**
    *  
    Returns a string formatted as Year:Month:Day
    
    

    * @return The string.
    */
    @Override
    public String toString() {
        return StringHelper.format(CultureInfoHelper.getCurrentCulture(), "{0}:{1}:{2}", getYear(), getMonth(), getDay());
    }

    /**
    *  
    Compares this instance with another instance of the same type.
    
    
    

    * @param other An object to compare with this instance.
    * @return 
    A value indicating the relative order of the objects being compared.  The return value has these meanings:
    <table border="1"><tr></tr><tr><th></th><th>Value</th><th></th><th>Meaning</th><th></th></tr><tr></tr><tr><td></td><td>Less than zero</td><td></td><td>
    This instance is less than {@code other}.
    </td><td></td></tr><tr></tr><tr><td></td><td>Zero</td><td></td><td>
    This instance is equal to {@code other}.
    </td><td></td></tr><tr></tr><tr><td></td><td>Greater than zero</td><td></td><td>
    This instance is greater than {@code other}.
    </td><td></td></tr><tr></tr></table>
    
    */
    public final int compareTo(YearMonthDay other) {
        if (m_year != other.m_year) {
            return m_year < other.m_year ? -1 : 1;
        }
        if (m_month != other.m_month) {
            return m_month < other.m_month ? -1 : 1;
        }
        return m_day == other.m_day ? 0 : (m_day < other.m_day ? -1 : 1);
    }

    /**
    *  
    Returns {@code true} if the two instances are exactly equal.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} represents the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean ==(YearMonthDay,YearMonthDay)'")
    public static boolean equals(YearMonthDay left, YearMonthDay right) {
        return left.equalsType(right);
    }

    /**
    *  
    Returns {@code true} if the two instances are not exactly equal.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} does not represent the same value as {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean !=(YearMonthDay,YearMonthDay)'")
    public static boolean notEquals(YearMonthDay left, YearMonthDay right) {
        return !left.equalsType(right);
    }

    /**
    *  
    Returns {@code true} if {@code left} is less than {@code right}.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} is less than {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean <(YearMonthDay,YearMonthDay)'")
    public static boolean lessThan(YearMonthDay left, YearMonthDay right) {
        return left.compareTo(right) < 0;
    }

    /**
    *  
    Returns {@code true} if {@code left} is greater than {@code right}.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} is greater than {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean >(YearMonthDay,YearMonthDay)'")
    public static boolean greaterThan(YearMonthDay left, YearMonthDay right) {
        return left.compareTo(right) > 0;
    }

    /**
    *  
    Returns {@code true} if {@code left} is less than or equal to {@code right}.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} is less than or equal to {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean <=(YearMonthDay,YearMonthDay)'")
    public static boolean lessThanOrEqual(YearMonthDay left, YearMonthDay right) {
        return left.compareTo(right) <= 0;
    }

    /**
    *  
    Returns {@code true} if {@code left} is greater than or equal to {@code right}.
    
    
    
    

    * @param left The instance to compare to {@code right}.
    * @param right The instance to compare to {@code left}.
    * @return 
    {@code true} if {@code left} is greater than or equal to {@code right}; otherwise, {@code false}.
    
    */
    @CS2JInfo("This method implements the functionality of the overloaded operator: 'System.Boolean >=(YearMonthDay,YearMonthDay)'")
    public static boolean greaterThanOrEqual(YearMonthDay left, YearMonthDay right) {
        return left.compareTo(right) >= 0;
    }

    //fields are stored zero-indexed so that default-constructed instances are valid
    private int m_year;
    private int m_month;
    private int m_day;
    private static int[] s_commonYearCumulativeMonthTable = {
            0,
            31,
            59,
            90,
            120,
            151,
            181,
            212,
            243,
            273,
            304,
            334
    };
    private static int[] s_leapYearCumulativeMonthTable = {
            0,
            31,
            60,
            91,
            121,
            152,
            182,
            213,
            244,
            274,
            305,
            335
    };
}