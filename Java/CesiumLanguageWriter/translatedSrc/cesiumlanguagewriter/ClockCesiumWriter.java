package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes a <code>Clock</code> to a  {@link CesiumOutputStream}.  A <code>Clock</code> defines a simulated clock.
 

 */
public class ClockCesiumWriter extends CesiumPropertyWriter<ClockCesiumWriter> {
	/**
	 *  
	The name of the <code>currentTime</code> property.
	

	 */
	public static final String CurrentTimePropertyName = "currentTime";
	/**
	 *  
	The name of the <code>multiplier</code> property.
	

	 */
	public static final String MultiplierPropertyName = "multiplier";
	/**
	 *  
	The name of the <code>range</code> property.
	

	 */
	public static final String RangePropertyName = "range";
	/**
	 *  
	The name of the <code>step</code> property.
	

	 */
	public static final String StepPropertyName = "step";

	/**
	 *  
	Initializes a new instance.
	

	 */
	public ClockCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected ClockCesiumWriter(ClockCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public ClockCesiumWriter clone() {
		return new ClockCesiumWriter(this);
	}

	/**
	 *  
	Writes the <code>currentTime</code> property.  The <code>currentTime</code> property specifies the current time.
	
	

	 * @param value The time.
	 */
	public final void writeCurrentTime(JulianDate value) {
		String PropertyName = CurrentTimePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeDate(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>multiplier</code> property.  The <code>multiplier</code> property specifies the multiplier, which in TICK_DEPENDENT mode is the number of seconds to advance each tick.  In SYSTEM_CLOCK_DEPENDENT mode, it is the multiplier applied to the amount of time elapsed between ticks.  This value is ignored in SYSTEM_CLOCK mode.
	
	

	 * @param value The value.
	 */
	public final void writeMultiplier(double value) {
		String PropertyName = MultiplierPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		getOutput().writeValue(value);
	}

	/**
	 *  
	Writes the <code>range</code> property.  The <code>range</code> property specifies the behavior of a clock when its current time reaches its start or end points.  Valid values are 'UNBOUNDED', 'CLAMPED', and 'LOOP_STOP'.
	
	

	 * @param value The clock range.
	 */
	public final void writeRange(ClockRange value) {
		String PropertyName = RangePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		getOutput().writeValue(CesiumFormattingHelper.clockRangeToString(value));
	}

	/**
	 *  
	Writes the <code>step</code> property.  The <code>step</code> property specifies defines how a clock steps in time.  Valid values are 'SYSTEM_CLOCK', 'SYSTEM_CLOCK_MULTIPLIER', and 'TICK_DEPENDENT'.
	
	

	 * @param value The clock step.
	 */
	public final void writeStep(ClockStep value) {
		String PropertyName = StepPropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		getOutput().writeValue(CesiumFormattingHelper.clockStepToString(value));
	}
}