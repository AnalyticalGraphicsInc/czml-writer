package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Enumeration;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Defines how a simulated clock advances in time.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public enum ClockStep implements Enumeration {
    /**
    * The clock always matches the system clock.
    */
    SYSTEM_CLOCK(0), /**
                     * The clock advances by the elapsed system time between ticks, multiplied by a user specified value.
                     */
    SYSTEM_CLOCK_MULTIPLIER(1), /**
                                * The clock advances by a fixed step each tick.
                                */
    TICK_DEPENDENT(2);
    private final int value;

    ClockStep(int value) {
        this.value = value;
    }

    /**
    * Get the numeric value associated with this enum constant.
    * @return A numeric value.
    */
    @Override
    public int getValue() {
        return value;
    }

    /**
    * Get the enum constant that is associated with the given numeric value.
    * @return The enum constant associated with value.
    * @param value a numeric value.
    */
    @Nonnull
    public static ClockStep getFromValue(int value) {
        switch (value) {
        case 0:
            return SYSTEM_CLOCK;
        case 1:
            return SYSTEM_CLOCK_MULTIPLIER;
        case 2:
            return TICK_DEPENDENT;
        default:
            throw new IllegalArgumentException("Undefined enum value.");
        }
    }

    /**
    * Get the enum constant that is considered to be the default.
    * @return The default enum constant.
    */
    @Nonnull
    public static ClockStep getDefault() {
        return SYSTEM_CLOCK;
    }
}