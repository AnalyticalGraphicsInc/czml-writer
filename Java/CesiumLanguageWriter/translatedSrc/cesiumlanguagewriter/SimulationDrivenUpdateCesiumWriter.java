package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.DoubleCesiumWriter;
import java.util.List;

/**
 *  
 Writes a <code>SimulationDrivenUpdate</code> to a  {@link CesiumOutputStream}.  A <code>SimulationDrivenUpdate</code> use this updater when you want to retrieve data for a specified duration.
 

 */
public class SimulationDrivenUpdateCesiumWriter extends CesiumPropertyWriter<SimulationDrivenUpdateCesiumWriter> {
	/**
	 *  
	The name of the <code>duration</code> property.
	

	 */
	public static final String DurationPropertyName = "duration";
	/**
	 *  
	The name of the <code>stepsize</code> property.
	

	 */
	public static final String StepsizePropertyName = "stepsize";
	private Lazy<DoubleCesiumWriter> m_duration = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(DurationPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_stepsize = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(StepsizePropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public SimulationDrivenUpdateCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected SimulationDrivenUpdateCesiumWriter(SimulationDrivenUpdateCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public SimulationDrivenUpdateCesiumWriter clone() {
		return new SimulationDrivenUpdateCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>duration</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>duration</code> property defines the duration of time in seconds to request data.
	

	 */
	public final DoubleCesiumWriter getDurationWriter() {
		return m_duration.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>duration</code> property.  The <code>duration</code> property defines the duration of time in seconds to request data.
	

	 */
	public final DoubleCesiumWriter openDurationProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getDurationWriter());
	}

	/**
	 *  
	Writes a value for the <code>duration</code> property as a <code>number</code> value.  The <code>duration</code> property specifies the duration of time in seconds to request data.
	
	

	 * @param value The value.
	 */
	public final void writeDurationProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openDurationProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>duration</code> property as a <code>number</code> value.  The <code>duration</code> property specifies the duration of time in seconds to request data.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeDurationProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openDurationProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>stepsize</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>stepsize</code> property defines the sampling stepsize.
	

	 */
	public final DoubleCesiumWriter getStepsizeWriter() {
		return m_stepsize.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>stepsize</code> property.  The <code>stepsize</code> property defines the sampling stepsize.
	

	 */
	public final DoubleCesiumWriter openStepsizeProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getStepsizeWriter());
	}

	/**
	 *  
	Writes a value for the <code>stepsize</code> property as a <code>number</code> value.  The <code>stepsize</code> property specifies the sampling stepsize.
	
	

	 * @param value The value.
	 */
	public final void writeStepsizeProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openStepsizeProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>stepsize</code> property as a <code>number</code> value.  The <code>stepsize</code> property specifies the sampling stepsize.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeStepsizeProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openStepsizeProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}