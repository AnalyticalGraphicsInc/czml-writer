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
 Writes a <code>PollingUpdate</code> to a  {@link CesiumOutputStream}.  A <code>PollingUpdate</code> use this updater when you want to poll the given url at a constant update rate based on the system's clock.
 

 */
public class PollingUpdateCesiumWriter extends CesiumPropertyWriter<PollingUpdateCesiumWriter> {
	/**
	 *  
	The name of the <code>refreshInterval</code> property.
	

	 */
	public static final String RefreshIntervalPropertyName = "refreshInterval";
	private Lazy<DoubleCesiumWriter> m_refreshInterval = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(RefreshIntervalPropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public PollingUpdateCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected PollingUpdateCesiumWriter(PollingUpdateCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public PollingUpdateCesiumWriter clone() {
		return new PollingUpdateCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>refreshInterval</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>refreshInterval</code> property defines specifies in seconds how often to refresh to document. The default is 60 seconds.
	

	 */
	public final DoubleCesiumWriter getRefreshIntervalWriter() {
		return m_refreshInterval.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>refreshInterval</code> property.  The <code>refreshInterval</code> property defines specifies in seconds how often to refresh to document. The default is 60 seconds.
	

	 */
	public final DoubleCesiumWriter openRefreshIntervalProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getRefreshIntervalWriter());
	}

	/**
	 *  
	Writes a value for the <code>refreshInterval</code> property as a <code>number</code> value.  The <code>refreshInterval</code> property specifies specifies in seconds how often to refresh to document. The default is 60 seconds.
	
	

	 * @param value The value.
	 */
	public final void writeRefreshIntervalProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRefreshIntervalProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>refreshInterval</code> property as a <code>number</code> value.  The <code>refreshInterval</code> property specifies specifies in seconds how often to refresh to document. The default is 60 seconds.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeRefreshIntervalProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRefreshIntervalProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}