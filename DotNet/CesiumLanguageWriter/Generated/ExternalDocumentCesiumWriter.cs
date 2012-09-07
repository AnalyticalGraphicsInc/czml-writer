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
        /// The name of the <code>eventSource</code> property.
        /// </summary>
        public const string EventSourcePropertyName = "eventSource";

        /// <summary>
        /// The name of the <code>parameters</code> property.
        /// </summary>
        public const string ParametersPropertyName = "parameters";

        /// <summary>
        /// The name of the <code>polling</code> property.
        /// </summary>
        public const string PollingPropertyName = "polling";

        /// <summary>
        /// The name of the <code>refreshInterval</code> property.
        /// </summary>
        public const string RefreshIntervalPropertyName = "refreshInterval";

        /// <summary>
        /// The name of the <code>scope</code> property.
        /// </summary>
        public const string ScopePropertyName = "scope";

        /// <summary>
        /// The name of the <code>maxSessionLength</code> property.
        /// </summary>
        public const string MaxSessionLengthPropertyName = "maxSessionLength";

        private readonly Lazy<StringCesiumWriter> m_eventSource = new Lazy<StringCesiumWriter>(() => new StringCesiumWriter(EventSourcePropertyName), false);
        private readonly Lazy<StringCesiumWriter> m_polling = new Lazy<StringCesiumWriter>(() => new StringCesiumWriter(PollingPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_refreshInterval = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RefreshIntervalPropertyName), false);
        private readonly Lazy<ExternalDocumentScopeCesiumWriter> m_scope = new Lazy<ExternalDocumentScopeCesiumWriter>(() => new ExternalDocumentScopeCesiumWriter(ScopePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_maxSessionLength = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(MaxSessionLengthPropertyName), false);

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
        /// Gets the writer for the <code>eventSource</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>eventSource</code> property defines the Uri of the external document. Uses EventSource to push data from the server.
        /// </summary>
        public StringCesiumWriter EventSourceWriter
        {
            get { return m_eventSource.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>eventSource</code> property.  The <code>eventSource</code> property defines the Uri of the external document. Uses EventSource to push data from the server.
        /// </summary>
        public StringCesiumWriter OpenEventSourceProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EventSourceWriter);
        }

        /// <summary>
        /// Writes a value for the <code>eventSource</code> property as a <code>string</code> value.  The <code>eventSource</code> property specifies the Uri of the external document. Uses EventSource to push data from the server.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteEventSourceProperty(string value)
        {
            using (var writer = OpenEventSourceProperty())
            {
                writer.WriteString(value);
            }
        }

        /// <summary>
        /// Writes the <code>parameters</code> property.  The <code>parameters</code> property specifies client supplied parameters to the external document Uri.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteParameters(string value)
        {
            const string PropertyName = ParametersPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Gets the writer for the <code>polling</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>polling</code> property defines the Uri of the external document. Uses traditional polling. Specify the refreshInterval property to poll the server at a given interval.
        /// </summary>
        public StringCesiumWriter PollingWriter
        {
            get { return m_polling.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>polling</code> property.  The <code>polling</code> property defines the Uri of the external document. Uses traditional polling. Specify the refreshInterval property to poll the server at a given interval.
        /// </summary>
        public StringCesiumWriter OpenPollingProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PollingWriter);
        }

        /// <summary>
        /// Writes a value for the <code>polling</code> property as a <code>string</code> value.  The <code>polling</code> property specifies the Uri of the external document. Uses traditional polling. Specify the refreshInterval property to poll the server at a given interval.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WritePollingProperty(string value)
        {
            using (var writer = OpenPollingProperty())
            {
                writer.WriteString(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>refreshInterval</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>refreshInterval</code> property defines specifies in seconds how often to refresh to document.
        /// </summary>
        public DoubleCesiumWriter RefreshIntervalWriter
        {
            get { return m_refreshInterval.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>refreshInterval</code> property.  The <code>refreshInterval</code> property defines specifies in seconds how often to refresh to document.
        /// </summary>
        public DoubleCesiumWriter OpenRefreshIntervalProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RefreshIntervalWriter);
        }

        /// <summary>
        /// Writes a value for the <code>refreshInterval</code> property as a <code>number</code> value.  The <code>refreshInterval</code> property specifies specifies in seconds how often to refresh to document.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRefreshIntervalProperty(double value)
        {
            using (var writer = OpenRefreshIntervalProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>refreshInterval</code> property as a <code>number</code> value.  The <code>refreshInterval</code> property specifies specifies in seconds how often to refresh to document.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteRefreshIntervalProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenRefreshIntervalProperty())
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

    }
}
