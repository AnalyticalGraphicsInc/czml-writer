// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>ExternalDocument</code> to a <see cref="CesiumOutputStream" />.  A <code>ExternalDocument</code> defines a reference to an external CZML source.
    /// </summary>
    public class ExternalDocumentCesiumWriter : CesiumPropertyWriter<ExternalDocumentCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>url</code> property.
        /// </summary>
        public const string UrlPropertyName = "url";

        /// <summary>
        /// The name of the <code>sourceType</code> property.
        /// </summary>
        public const string SourceTypePropertyName = "sourceType";

        /// <summary>
        /// The name of the <code>eventname</code> property.
        /// </summary>
        public const string EventnamePropertyName = "eventname";

        /// <summary>
        /// The name of the <code>reconnectOnError</code> property.
        /// </summary>
        public const string ReconnectOnErrorPropertyName = "reconnectOnError";

        /// <summary>
        /// The name of the <code>reconnectRetries</code> property.
        /// </summary>
        public const string ReconnectRetriesPropertyName = "reconnectRetries";

        /// <summary>
        /// The name of the <code>scope</code> property.
        /// </summary>
        public const string ScopePropertyName = "scope";

        /// <summary>
        /// The name of the <code>maxSessionLength</code> property.
        /// </summary>
        public const string MaxSessionLengthPropertyName = "maxSessionLength";

        /// <summary>
        /// The name of the <code>pollingUpdate</code> property.
        /// </summary>
        public const string PollingUpdatePropertyName = "pollingUpdate";

        /// <summary>
        /// The name of the <code>simulationDrivenUpdate</code> property.
        /// </summary>
        public const string SimulationDrivenUpdatePropertyName = "simulationDrivenUpdate";

        private readonly Lazy<StringCesiumWriter> m_url = new Lazy<StringCesiumWriter>(() => new StringCesiumWriter(UrlPropertyName), false);
        private readonly Lazy<ExternalDocumentSourceTypeCesiumWriter> m_sourceType = new Lazy<ExternalDocumentSourceTypeCesiumWriter>(() => new ExternalDocumentSourceTypeCesiumWriter(SourceTypePropertyName), false);
        private readonly Lazy<StringCesiumWriter> m_eventname = new Lazy<StringCesiumWriter>(() => new StringCesiumWriter(EventnamePropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_reconnectOnError = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ReconnectOnErrorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_reconnectRetries = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ReconnectRetriesPropertyName), false);
        private readonly Lazy<ExternalDocumentScopeCesiumWriter> m_scope = new Lazy<ExternalDocumentScopeCesiumWriter>(() => new ExternalDocumentScopeCesiumWriter(ScopePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_maxSessionLength = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(MaxSessionLengthPropertyName), false);
        private readonly Lazy<PollingUpdateCesiumWriter> m_pollingUpdate = new Lazy<PollingUpdateCesiumWriter>(() => new PollingUpdateCesiumWriter(PollingUpdatePropertyName), false);
        private readonly Lazy<SimulationDrivenUpdateCesiumWriter> m_simulationDrivenUpdate = new Lazy<SimulationDrivenUpdateCesiumWriter>(() => new SimulationDrivenUpdateCesiumWriter(SimulationDrivenUpdatePropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ExternalDocumentCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected ExternalDocumentCesiumWriter(ExternalDocumentCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override ExternalDocumentCesiumWriter Clone()
        {
            return new ExternalDocumentCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>url</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>url</code> property defines the URL of the external document. Required.
        /// </summary>
        public StringCesiumWriter UrlWriter
        {
            get { return m_url.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>url</code> property.  The <code>url</code> property defines the URL of the external document. Required.
        /// </summary>
        public StringCesiumWriter OpenUrlProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(UrlWriter);
        }

        /// <summary>
        /// Writes a value for the <code>url</code> property as a <code>string</code> value.  The <code>url</code> property specifies the URL of the external document. Required.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteUrlProperty(string value)
        {
            using (var writer = OpenUrlProperty())
            {
                writer.WriteString(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>sourceType</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>sourceType</code> property defines the data transport type to use.
        /// </summary>
        public ExternalDocumentSourceTypeCesiumWriter SourceTypeWriter
        {
            get { return m_sourceType.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>sourceType</code> property.  The <code>sourceType</code> property defines the data transport type to use.
        /// </summary>
        public ExternalDocumentSourceTypeCesiumWriter OpenSourceTypeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SourceTypeWriter);
        }

        /// <summary>
        /// Writes a value for the <code>sourceType</code> property as a <code>sourceType</code> value.  The <code>sourceType</code> property specifies the data transport type to use.
        /// </summary>
        /// <param name="value">The data transport type to use.</param>
        public void WriteSourceTypeProperty(CesiumExternalDocumentSourceType value)
        {
            using (var writer = OpenSourceTypeProperty())
            {
                writer.WriteSourceType(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>eventname</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>eventname</code> property defines the event type to listen to. Can be used in conjunction with the eventSource property. Ignored otherwise.
        /// </summary>
        public StringCesiumWriter EventnameWriter
        {
            get { return m_eventname.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>eventname</code> property.  The <code>eventname</code> property defines the event type to listen to. Can be used in conjunction with the eventSource property. Ignored otherwise.
        /// </summary>
        public StringCesiumWriter OpenEventnameProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EventnameWriter);
        }

        /// <summary>
        /// Writes a value for the <code>eventname</code> property as a <code>string</code> value.  The <code>eventname</code> property specifies the event type to listen to. Can be used in conjunction with the eventSource property. Ignored otherwise.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteEventnameProperty(string value)
        {
            using (var writer = OpenEventnameProperty())
            {
                writer.WriteString(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>reconnectOnError</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>reconnectOnError</code> property defines tells the client to try to reconnect if there is an error during the retrieval of the data.
        /// </summary>
        public BooleanCesiumWriter ReconnectOnErrorWriter
        {
            get { return m_reconnectOnError.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>reconnectOnError</code> property.  The <code>reconnectOnError</code> property defines tells the client to try to reconnect if there is an error during the retrieval of the data.
        /// </summary>
        public BooleanCesiumWriter OpenReconnectOnErrorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ReconnectOnErrorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>reconnectOnError</code> property as a <code>boolean</code> value.  The <code>reconnectOnError</code> property specifies tells the client to try to reconnect if there is an error during the retrieval of the data.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteReconnectOnErrorProperty(bool value)
        {
            using (var writer = OpenReconnectOnErrorProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>reconnectRetries</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>reconnectRetries</code> property defines specifies in seconds how often to refresh to document. This is ignored unless the polling property is used. When the polling property is specified, this value defaults to 60 seconds, unless configured otherwise.
        /// </summary>
        public DoubleCesiumWriter ReconnectRetriesWriter
        {
            get { return m_reconnectRetries.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>reconnectRetries</code> property.  The <code>reconnectRetries</code> property defines specifies in seconds how often to refresh to document. This is ignored unless the polling property is used. When the polling property is specified, this value defaults to 60 seconds, unless configured otherwise.
        /// </summary>
        public DoubleCesiumWriter OpenReconnectRetriesProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ReconnectRetriesWriter);
        }

        /// <summary>
        /// Writes a value for the <code>reconnectRetries</code> property as a <code>number</code> value.  The <code>reconnectRetries</code> property specifies specifies in seconds how often to refresh to document. This is ignored unless the polling property is used. When the polling property is specified, this value defaults to 60 seconds, unless configured otherwise.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteReconnectRetriesProperty(double value)
        {
            using (var writer = OpenReconnectRetriesProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>reconnectRetries</code> property as a <code>number</code> value.  The <code>reconnectRetries</code> property specifies specifies in seconds how often to refresh to document. This is ignored unless the polling property is used. When the polling property is specified, this value defaults to 60 seconds, unless configured otherwise.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteReconnectRetriesProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenReconnectRetriesProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>scope</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>scope</code> property defines indicates if the document's scope is "PRIVATE" or "SHARED"
        /// </summary>
        public ExternalDocumentScopeCesiumWriter ScopeWriter
        {
            get { return m_scope.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>scope</code> property.  The <code>scope</code> property defines indicates if the document's scope is "PRIVATE" or "SHARED"
        /// </summary>
        public ExternalDocumentScopeCesiumWriter OpenScopeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ScopeWriter);
        }

        /// <summary>
        /// Writes a value for the <code>scope</code> property as a <code>scope</code> value.  The <code>scope</code> property specifies indicates if the document's scope is "PRIVATE" or "SHARED"
        /// </summary>
        /// <param name="value">The scope of the document.</param>
        public void WriteScopeProperty(CesiumExternalDocumentScope value)
        {
            using (var writer = OpenScopeProperty())
            {
                writer.WriteScope(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>maxSessionLength</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>maxSessionLength</code> property defines specifies in seconds how long the connection can stay connected.
        /// </summary>
        public DoubleCesiumWriter MaxSessionLengthWriter
        {
            get { return m_maxSessionLength.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>maxSessionLength</code> property.  The <code>maxSessionLength</code> property defines specifies in seconds how long the connection can stay connected.
        /// </summary>
        public DoubleCesiumWriter OpenMaxSessionLengthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaxSessionLengthWriter);
        }

        /// <summary>
        /// Writes a value for the <code>maxSessionLength</code> property as a <code>number</code> value.  The <code>maxSessionLength</code> property specifies specifies in seconds how long the connection can stay connected.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteMaxSessionLengthProperty(double value)
        {
            using (var writer = OpenMaxSessionLengthProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>maxSessionLength</code> property as a <code>number</code> value.  The <code>maxSessionLength</code> property specifies specifies in seconds how long the connection can stay connected.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteMaxSessionLengthProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenMaxSessionLengthProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>pollingUpdate</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>pollingUpdate</code> property defines use this updater when you want to poll the given url at a constant update rate based on the system's clock.
        /// </summary>
        public PollingUpdateCesiumWriter PollingUpdateWriter
        {
            get { return m_pollingUpdate.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>pollingUpdate</code> property.  The <code>pollingUpdate</code> property defines use this updater when you want to poll the given url at a constant update rate based on the system's clock.
        /// </summary>
        public PollingUpdateCesiumWriter OpenPollingUpdateProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PollingUpdateWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>simulationDrivenUpdate</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>simulationDrivenUpdate</code> property defines use this updater when you want to retrieve data for a specified duration.
        /// </summary>
        public SimulationDrivenUpdateCesiumWriter SimulationDrivenUpdateWriter
        {
            get { return m_simulationDrivenUpdate.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>simulationDrivenUpdate</code> property.  The <code>simulationDrivenUpdate</code> property defines use this updater when you want to retrieve data for a specified duration.
        /// </summary>
        public SimulationDrivenUpdateCesiumWriter OpenSimulationDrivenUpdateProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SimulationDrivenUpdateWriter);
        }

    }
}
