package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.ExternalDocumentScopeCesiumWriter;
import cesiumlanguagewriter.ExternalDocumentSourceTypeCesiumWriter;
import cesiumlanguagewriter.PollingUpdateCesiumWriter;
import cesiumlanguagewriter.SimulationDrivenUpdateCesiumWriter;
import cesiumlanguagewriter.StringCesiumWriter;
import java.util.List;

/**
 *  
 Writes a <code>ExternalDocument</code> to a  {@link CesiumOutputStream}.  A <code>ExternalDocument</code> defines a reference to an external CZML source.
 

 */
public class ExternalDocumentCesiumWriter extends CesiumPropertyWriter<ExternalDocumentCesiumWriter> {
	/**
	 *  
	The name of the <code>url</code> property.
	

	 */
	public static final String UrlPropertyName = "url";
	/**
	 *  
	The name of the <code>sourceType</code> property.
	

	 */
	public static final String SourceTypePropertyName = "sourceType";
	/**
	 *  
	The name of the <code>eventname</code> property.
	

	 */
	public static final String EventnamePropertyName = "eventname";
	/**
	 *  
	The name of the <code>reconnectOnError</code> property.
	

	 */
	public static final String ReconnectOnErrorPropertyName = "reconnectOnError";
	/**
	 *  
	The name of the <code>reconnectRetries</code> property.
	

	 */
	public static final String ReconnectRetriesPropertyName = "reconnectRetries";
	/**
	 *  
	The name of the <code>scope</code> property.
	

	 */
	public static final String ScopePropertyName = "scope";
	/**
	 *  
	The name of the <code>maxSessionLength</code> property.
	

	 */
	public static final String MaxSessionLengthPropertyName = "maxSessionLength";
	/**
	 *  
	The name of the <code>pollingUpdate</code> property.
	

	 */
	public static final String PollingUpdatePropertyName = "pollingUpdate";
	/**
	 *  
	The name of the <code>simulationDrivenUpdate</code> property.
	

	 */
	public static final String SimulationDrivenUpdatePropertyName = "simulationDrivenUpdate";
	private Lazy<StringCesiumWriter> m_url = new Lazy<cesiumlanguagewriter.StringCesiumWriter>(new Func1<cesiumlanguagewriter.StringCesiumWriter>() {
		public cesiumlanguagewriter.StringCesiumWriter invoke() {
			return new StringCesiumWriter(UrlPropertyName);
		}
	}, false);
	private Lazy<ExternalDocumentSourceTypeCesiumWriter> m_sourceType = new Lazy<cesiumlanguagewriter.ExternalDocumentSourceTypeCesiumWriter>(
			new Func1<cesiumlanguagewriter.ExternalDocumentSourceTypeCesiumWriter>() {
				public cesiumlanguagewriter.ExternalDocumentSourceTypeCesiumWriter invoke() {
					return new ExternalDocumentSourceTypeCesiumWriter(SourceTypePropertyName);
				}
			}, false);
	private Lazy<StringCesiumWriter> m_eventname = new Lazy<cesiumlanguagewriter.StringCesiumWriter>(new Func1<cesiumlanguagewriter.StringCesiumWriter>() {
		public cesiumlanguagewriter.StringCesiumWriter invoke() {
			return new StringCesiumWriter(EventnamePropertyName);
		}
	}, false);
	private Lazy<BooleanCesiumWriter> m_reconnectOnError = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(ReconnectOnErrorPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_reconnectRetries = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(ReconnectRetriesPropertyName);
		}
	}, false);
	private Lazy<ExternalDocumentScopeCesiumWriter> m_scope = new Lazy<cesiumlanguagewriter.ExternalDocumentScopeCesiumWriter>(new Func1<cesiumlanguagewriter.ExternalDocumentScopeCesiumWriter>() {
		public cesiumlanguagewriter.ExternalDocumentScopeCesiumWriter invoke() {
			return new ExternalDocumentScopeCesiumWriter(ScopePropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_maxSessionLength = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(MaxSessionLengthPropertyName);
		}
	}, false);
	private Lazy<PollingUpdateCesiumWriter> m_pollingUpdate = new Lazy<cesiumlanguagewriter.PollingUpdateCesiumWriter>(new Func1<cesiumlanguagewriter.PollingUpdateCesiumWriter>() {
		public cesiumlanguagewriter.PollingUpdateCesiumWriter invoke() {
			return new PollingUpdateCesiumWriter(PollingUpdatePropertyName);
		}
	}, false);
	private Lazy<SimulationDrivenUpdateCesiumWriter> m_simulationDrivenUpdate = new Lazy<cesiumlanguagewriter.SimulationDrivenUpdateCesiumWriter>(
			new Func1<cesiumlanguagewriter.SimulationDrivenUpdateCesiumWriter>() {
				public cesiumlanguagewriter.SimulationDrivenUpdateCesiumWriter invoke() {
					return new SimulationDrivenUpdateCesiumWriter(SimulationDrivenUpdatePropertyName);
				}
			}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public ExternalDocumentCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected ExternalDocumentCesiumWriter(ExternalDocumentCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public ExternalDocumentCesiumWriter clone() {
		return new ExternalDocumentCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>url</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>url</code> property defines the URL of the external document. Required.
	

	 */
	public final StringCesiumWriter getUrlWriter() {
		return m_url.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>url</code> property.  The <code>url</code> property defines the URL of the external document. Required.
	

	 */
	public final StringCesiumWriter openUrlProperty() {
		openIntervalIfNecessary();
		return this.<StringCesiumWriter> openAndReturn(getUrlWriter());
	}

	/**
	 *  
	Writes a value for the <code>url</code> property as a <code>string</code> value.  The <code>url</code> property specifies the URL of the external document. Required.
	
	

	 * @param value The value.
	 */
	public final void writeUrlProperty(String value) {
		{
			cesiumlanguagewriter.StringCesiumWriter writer = openUrlProperty();
			try {
				writer.writeString(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>sourceType</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>sourceType</code> property defines the data transport type to use.
	

	 */
	public final ExternalDocumentSourceTypeCesiumWriter getSourceTypeWriter() {
		return m_sourceType.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>sourceType</code> property.  The <code>sourceType</code> property defines the data transport type to use.
	

	 */
	public final ExternalDocumentSourceTypeCesiumWriter openSourceTypeProperty() {
		openIntervalIfNecessary();
		return this.<ExternalDocumentSourceTypeCesiumWriter> openAndReturn(getSourceTypeWriter());
	}

	/**
	 *  
	Writes a value for the <code>sourceType</code> property as a <code>sourceType</code> value.  The <code>sourceType</code> property specifies the data transport type to use.
	
	

	 * @param value The data transport type to use.
	 */
	public final void writeSourceTypeProperty(CesiumExternalDocumentSourceType value) {
		{
			cesiumlanguagewriter.ExternalDocumentSourceTypeCesiumWriter writer = openSourceTypeProperty();
			try {
				writer.writeSourceType(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>eventname</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>eventname</code> property defines the event type to listen to. Can be used in conjunction with the eventSource property. Ignored otherwise.
	

	 */
	public final StringCesiumWriter getEventnameWriter() {
		return m_eventname.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>eventname</code> property.  The <code>eventname</code> property defines the event type to listen to. Can be used in conjunction with the eventSource property. Ignored otherwise.
	

	 */
	public final StringCesiumWriter openEventnameProperty() {
		openIntervalIfNecessary();
		return this.<StringCesiumWriter> openAndReturn(getEventnameWriter());
	}

	/**
	 *  
	Writes a value for the <code>eventname</code> property as a <code>string</code> value.  The <code>eventname</code> property specifies the event type to listen to. Can be used in conjunction with the eventSource property. Ignored otherwise.
	
	

	 * @param value The value.
	 */
	public final void writeEventnameProperty(String value) {
		{
			cesiumlanguagewriter.StringCesiumWriter writer = openEventnameProperty();
			try {
				writer.writeString(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>reconnectOnError</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>reconnectOnError</code> property defines tells the client to try to reconnect if there is an error during the retrieval of the data.
	

	 */
	public final BooleanCesiumWriter getReconnectOnErrorWriter() {
		return m_reconnectOnError.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>reconnectOnError</code> property.  The <code>reconnectOnError</code> property defines tells the client to try to reconnect if there is an error during the retrieval of the data.
	

	 */
	public final BooleanCesiumWriter openReconnectOnErrorProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getReconnectOnErrorWriter());
	}

	/**
	 *  
	Writes a value for the <code>reconnectOnError</code> property as a <code>boolean</code> value.  The <code>reconnectOnError</code> property specifies tells the client to try to reconnect if there is an error during the retrieval of the data.
	
	

	 * @param value The value.
	 */
	public final void writeReconnectOnErrorProperty(boolean value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openReconnectOnErrorProperty();
			try {
				writer.writeBoolean(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>reconnectRetries</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>reconnectRetries</code> property defines specifies in seconds how often to refresh to document. This is ignored unless the polling property is used. When the polling property is specified, this value defaults to 60 seconds, unless configured otherwise.
	

	 */
	public final DoubleCesiumWriter getReconnectRetriesWriter() {
		return m_reconnectRetries.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>reconnectRetries</code> property.  The <code>reconnectRetries</code> property defines specifies in seconds how often to refresh to document. This is ignored unless the polling property is used. When the polling property is specified, this value defaults to 60 seconds, unless configured otherwise.
	

	 */
	public final DoubleCesiumWriter openReconnectRetriesProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getReconnectRetriesWriter());
	}

	/**
	 *  
	Writes a value for the <code>reconnectRetries</code> property as a <code>number</code> value.  The <code>reconnectRetries</code> property specifies specifies in seconds how often to refresh to document. This is ignored unless the polling property is used. When the polling property is specified, this value defaults to 60 seconds, unless configured otherwise.
	
	

	 * @param value The value.
	 */
	public final void writeReconnectRetriesProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openReconnectRetriesProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>reconnectRetries</code> property as a <code>number</code> value.  The <code>reconnectRetries</code> property specifies specifies in seconds how often to refresh to document. This is ignored unless the polling property is used. When the polling property is specified, this value defaults to 60 seconds, unless configured otherwise.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeReconnectRetriesProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openReconnectRetriesProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>scope</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>scope</code> property defines indicates if the document's scope is "PRIVATE" or "SHARED"
	

	 */
	public final ExternalDocumentScopeCesiumWriter getScopeWriter() {
		return m_scope.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>scope</code> property.  The <code>scope</code> property defines indicates if the document's scope is "PRIVATE" or "SHARED"
	

	 */
	public final ExternalDocumentScopeCesiumWriter openScopeProperty() {
		openIntervalIfNecessary();
		return this.<ExternalDocumentScopeCesiumWriter> openAndReturn(getScopeWriter());
	}

	/**
	 *  
	Writes a value for the <code>scope</code> property as a <code>scope</code> value.  The <code>scope</code> property specifies indicates if the document's scope is "PRIVATE" or "SHARED"
	
	

	 * @param value The scope of the document.
	 */
	public final void writeScopeProperty(CesiumExternalDocumentScope value) {
		{
			cesiumlanguagewriter.ExternalDocumentScopeCesiumWriter writer = openScopeProperty();
			try {
				writer.writeScope(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>maxSessionLength</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>maxSessionLength</code> property defines specifies in seconds how long the connection can stay connected.
	

	 */
	public final DoubleCesiumWriter getMaxSessionLengthWriter() {
		return m_maxSessionLength.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>maxSessionLength</code> property.  The <code>maxSessionLength</code> property defines specifies in seconds how long the connection can stay connected.
	

	 */
	public final DoubleCesiumWriter openMaxSessionLengthProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getMaxSessionLengthWriter());
	}

	/**
	 *  
	Writes a value for the <code>maxSessionLength</code> property as a <code>number</code> value.  The <code>maxSessionLength</code> property specifies specifies in seconds how long the connection can stay connected.
	
	

	 * @param value The value.
	 */
	public final void writeMaxSessionLengthProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openMaxSessionLengthProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>maxSessionLength</code> property as a <code>number</code> value.  The <code>maxSessionLength</code> property specifies specifies in seconds how long the connection can stay connected.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeMaxSessionLengthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openMaxSessionLengthProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>pollingUpdate</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>pollingUpdate</code> property defines use this updater when you want to poll the given url at a constant update rate based on the system's clock.
	

	 */
	public final PollingUpdateCesiumWriter getPollingUpdateWriter() {
		return m_pollingUpdate.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>pollingUpdate</code> property.  The <code>pollingUpdate</code> property defines use this updater when you want to poll the given url at a constant update rate based on the system's clock.
	

	 */
	public final PollingUpdateCesiumWriter openPollingUpdateProperty() {
		openIntervalIfNecessary();
		return this.<PollingUpdateCesiumWriter> openAndReturn(getPollingUpdateWriter());
	}

	/**
	 *  Gets the writer for the <code>simulationDrivenUpdate</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>simulationDrivenUpdate</code> property defines use this updater when you want to retrieve data for a specified duration.
	

	 */
	public final SimulationDrivenUpdateCesiumWriter getSimulationDrivenUpdateWriter() {
		return m_simulationDrivenUpdate.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>simulationDrivenUpdate</code> property.  The <code>simulationDrivenUpdate</code> property defines use this updater when you want to retrieve data for a specified duration.
	

	 */
	public final SimulationDrivenUpdateCesiumWriter openSimulationDrivenUpdateProperty() {
		openIntervalIfNecessary();
		return this.<SimulationDrivenUpdateCesiumWriter> openAndReturn(getSimulationDrivenUpdateWriter());
	}
}