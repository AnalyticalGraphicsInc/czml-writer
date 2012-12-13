// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Model</code> to a <see cref="CesiumOutputStream" />.  A <code>Model</code> defines a 3D model.
    /// </summary>
    public class ModelCesiumWriter : CesiumPropertyWriter<ModelCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>scale</code> property.
        /// </summary>
        public const string ScalePropertyName = "scale";

        /// <summary>
        /// The name of the <code>uri</code> property.
        /// </summary>
        public const string UriPropertyName = "uri";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_scale = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ScalePropertyName), false);
        private readonly Lazy<ModelUriCesiumWriter> m_uri = new Lazy<ModelUriCesiumWriter>(() => new ModelUriCesiumWriter(UriPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ModelCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected ModelCesiumWriter(ModelCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override ModelCesiumWriter Clone()
        {
            return new ModelCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the model is shown.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the model is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the model is shown.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowProperty(bool value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>scale</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>scale</code> property defines the scale of the model.
        /// </summary>
        public DoubleCesiumWriter ScaleWriter
        {
            get { return m_scale.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>scale</code> property.  The <code>scale</code> property defines the scale of the model.
        /// </summary>
        public DoubleCesiumWriter OpenScaleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ScaleWriter);
        }

        /// <summary>
        /// Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the model.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteScaleProperty(double value)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>scale</code> property as a <code>number</code> value.  The <code>scale</code> property specifies the scale of the model.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteScaleProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>uri</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>uri</code> property defines the uri to the model.
        /// </summary>
        public ModelUriCesiumWriter UriWriter
        {
            get { return m_uri.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>uri</code> property.  The <code>uri</code> property defines the uri to the model.
        /// </summary>
        public ModelUriCesiumWriter OpenUriProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(UriWriter);
        }

        /// <summary>
        /// Writes a value for the <code>uri</code> property as a <code>webgltf</code> value.  The <code>uri</code> property specifies the uri to the model.
        /// </summary>
        /// <param name="resource">A resource object describing the model.</param>
        public void WriteUriProperty(CesiumResource resource)
        {
            using (var writer = OpenUriProperty())
            {
                writer.WriteWebgltf(resource);
            }
        }

        /// <summary>
        /// Writes a value for the <code>uri</code> property as a <code>webgltf</code> value.  The <code>uri</code> property specifies the uri to the model.
        /// </summary>
        /// <param name="url">The URL of the model.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the model in the document. For even more control, use the overload that takes a ICesiumUrlResolver.</param>
        public void WriteUriProperty(string url, CesiumResourceBehavior resourceBehavior)
        {
            using (var writer = OpenUriProperty())
            {
                writer.WriteWebgltf(url, resourceBehavior);
            }
        }

        /// <summary>
        /// Writes a value for the <code>uri</code> property as a <code>webgltf</code> value.  The <code>uri</code> property specifies the uri to the model.
        /// </summary>
        /// <param name="url">The URL of the model.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.</param>
        /// <param name="resolver">An ICesiumUrlResolver used to build the final URL that will be embedded in the document.</param>
        public void WriteUriProperty(string url, ICesiumUrlResolver resolver)
        {
            using (var writer = OpenUriProperty())
            {
                writer.WriteWebgltf(url, resolver);
            }
        }

        /// <summary>
        /// Writes a value for the <code>uri</code> property as a <code>dae</code> value.  The <code>uri</code> property specifies the uri to the model.
        /// </summary>
        /// <param name="resource">A resource object describing the model.</param>
        public void WriteUriPropertyDae(CesiumResource resource)
        {
            using (var writer = OpenUriProperty())
            {
                writer.WriteDae(resource);
            }
        }

        /// <summary>
        /// Writes a value for the <code>uri</code> property as a <code>dae</code> value.  The <code>uri</code> property specifies the uri to the model.
        /// </summary>
        /// <param name="url">The URL of the model.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the model in the document. For even more control, use the overload that takes a ICesiumUrlResolver.</param>
        public void WriteUriPropertyDae(string url, CesiumResourceBehavior resourceBehavior)
        {
            using (var writer = OpenUriProperty())
            {
                writer.WriteDae(url, resourceBehavior);
            }
        }

        /// <summary>
        /// Writes a value for the <code>uri</code> property as a <code>dae</code> value.  The <code>uri</code> property specifies the uri to the model.
        /// </summary>
        /// <param name="url">The URL of the model.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.</param>
        /// <param name="resolver">An ICesiumUrlResolver used to build the final URL that will be embedded in the document.</param>
        public void WriteUriPropertyDae(string url, ICesiumUrlResolver resolver)
        {
            using (var writer = OpenUriProperty())
            {
                writer.WriteDae(url, resolver);
            }
        }

    }
}
