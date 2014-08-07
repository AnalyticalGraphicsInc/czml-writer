using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Writes a <code>PropertyBag</code> to a <see cref="CesiumOutputStream" />.  A <code>PropertyBag</code> a bag of arbitrary properties.
    /// </summary>
    public class PropertyBagCesiumWriter : CesiumPropertyWriter<PropertyBagCesiumWriter>
    {
        private Dictionary<string, PropertyBagCesiumWriter> m_propertyBagProperties = new Dictionary<string, PropertyBagCesiumWriter>();
        private Dictionary<string, DoubleCesiumWriter> m_doubleProperties = new Dictionary<string,DoubleCesiumWriter>();
        private Dictionary<string, StringCesiumWriter> m_stringProperties = new Dictionary<string,StringCesiumWriter>();
        private Dictionary<string, BooleanCesiumWriter> m_booleanProperties = new Dictionary<string,BooleanCesiumWriter>();

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PropertyBagCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected PropertyBagCesiumWriter(PropertyBagCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PropertyBagCesiumWriter Clone()
        {
            return new PropertyBagCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for a property bag property with the specified name.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public PropertyBagCesiumWriter GetPropertyBagWriter(string propertyName)
        {
            PropertyBagCesiumWriter writer;
            if (!m_propertyBagProperties.TryGetValue(propertyName, out writer))
            {
                writer = new PropertyBagCesiumWriter(propertyName);
                m_propertyBagProperties[propertyName] = writer;
            }
            return writer;
        }

        /// <summary>
        /// Opens and returns the writer for a property bag property with the specified name.
        /// </summary>
        /// <param name="propertyName">The name of the property to open.</param>
        public PropertyBagCesiumWriter OpenPropertyBagProperty(string propertyName)
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(GetPropertyBagWriter(propertyName));
        }

        /// <summary>
        /// Gets the writer for a number property with the specified name.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public DoubleCesiumWriter GetDoubleWriter(string propertyName)
        {
            DoubleCesiumWriter writer;
            if (!m_doubleProperties.TryGetValue(propertyName, out writer))
            {
                writer = new DoubleCesiumWriter(propertyName);
                m_doubleProperties[propertyName] = writer;
            }
            return writer;
        }

        /// <summary>
        /// Opens and returns the writer for a number property with the specified name.
        /// </summary>
        /// <param name="propertyName">The name of the property to open.</param>
        public DoubleCesiumWriter OpenDoubleProperty(string propertyName)
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(GetDoubleWriter(propertyName));
        }

        /// <summary>
        /// Writes a value for a property as a <code>number</code> value.
        /// </summary>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="value">The value.</param>
        public void WriteDoubleProperty(string propertyName, double value)
        {
            using (var writer = OpenDoubleProperty(propertyName))
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Gets the writer for a string property with the specified name.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public StringCesiumWriter GetStringWriter(string propertyName)
        {
            StringCesiumWriter writer;
            if (!m_stringProperties.TryGetValue(propertyName, out writer))
            {
                writer = new StringCesiumWriter(propertyName);
                m_stringProperties[propertyName] = writer;
            }
            return writer;
        }

        /// <summary>
        /// Opens and returns the writer for a string property with the specified name.
        /// </summary>
        /// <param name="propertyName">The name of the property to open.</param>
        public StringCesiumWriter OpenStringProperty(string propertyName)
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(GetStringWriter(propertyName));
        }

        /// <summary>
        /// Writes a value for a property as a <code>string</code> value.
        /// </summary>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="value">The value.</param>
        public void WriteStringProperty(string propertyName, string value)
        {
            using (var writer = OpenStringProperty(propertyName))
            {
                writer.WriteString(value);
            }
        }

        /// <summary>
        /// Gets the writer for a boolean property with the specified name.
        /// </summary>
        /// <param name="propertyName">The name of the property.</param>
        public BooleanCesiumWriter GetBooleanWriter(string propertyName)
        {
            BooleanCesiumWriter writer;
            if (!m_booleanProperties.TryGetValue(propertyName, out writer))
            {
                writer = new BooleanCesiumWriter(propertyName);
                m_booleanProperties[propertyName] = writer;
            }
            return writer;
        }

        /// <summary>
        /// Opens and returns the writer for a boolean property with the specified name.
        /// </summary>
        /// <param name="propertyName">The name of the property to open.</param>
        public BooleanCesiumWriter OpenBooleanProperty(string propertyName)
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(GetBooleanWriter(propertyName));
        }

        /// <summary>
        /// Writes a value for a property as a <code>boolean</code> value.
        /// </summary>
        /// <param name="propertyName">The name of the property to write.</param>
        /// <param name="value">The value.</param>
        public void WriteBooleanProperty(string propertyName, bool value)
        {
            using (var writer = OpenBooleanProperty(propertyName))
            {
                writer.WriteBoolean(value);
            }
        }
    }
}
