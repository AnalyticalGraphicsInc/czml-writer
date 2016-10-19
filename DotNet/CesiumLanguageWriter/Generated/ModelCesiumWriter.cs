// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>Model</c> to a <see cref="CesiumOutputStream" />.  A <c>Model</c> is a 3D model.
    /// </summary>
    public class ModelCesiumWriter : CesiumPropertyWriter<ModelCesiumWriter>
    {
        /// <summary>
        /// The name of the <c>show</c> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <c>gltf</c> property.
        /// </summary>
        public const string GltfPropertyName = "gltf";

        /// <summary>
        /// The name of the <c>scale</c> property.
        /// </summary>
        public const string ScalePropertyName = "scale";

        /// <summary>
        /// The name of the <c>minimumPixelSize</c> property.
        /// </summary>
        public const string MinimumPixelSizePropertyName = "minimumPixelSize";

        /// <summary>
        /// The name of the <c>maximumScale</c> property.
        /// </summary>
        public const string MaximumScalePropertyName = "maximumScale";

        /// <summary>
        /// The name of the <c>incrementallyLoadTextures</c> property.
        /// </summary>
        public const string IncrementallyLoadTexturesPropertyName = "incrementallyLoadTextures";

        /// <summary>
        /// The name of the <c>runAnimations</c> property.
        /// </summary>
        public const string RunAnimationsPropertyName = "runAnimations";

        /// <summary>
        /// The name of the <c>heightReference</c> property.
        /// </summary>
        public const string HeightReferencePropertyName = "heightReference";

        /// <summary>
        /// The name of the <c>nodeTransformations</c> property.
        /// </summary>
        public const string NodeTransformationsPropertyName = "nodeTransformations";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<UriCesiumWriter> m_gltf = new Lazy<UriCesiumWriter>(() => new UriCesiumWriter(GltfPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_scale = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ScalePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_minimumPixelSize = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(MinimumPixelSizePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_maximumScale = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(MaximumScalePropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_incrementallyLoadTextures = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(IncrementallyLoadTexturesPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_runAnimations = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(RunAnimationsPropertyName), false);
        private readonly Lazy<HeightReferenceCesiumWriter> m_heightReference = new Lazy<HeightReferenceCesiumWriter>(() => new HeightReferenceCesiumWriter(HeightReferencePropertyName), false);
        private readonly Lazy<NodeTransformationsCesiumWriter> m_nodeTransformations = new Lazy<NodeTransformationsCesiumWriter>(() => new NodeTransformationsCesiumWriter(NodeTransformationsPropertyName), false);

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
        /// Gets the writer for the <c>show</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>show</c> property defines whether or not the model is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>show</c> property.  The <c>show</c> property defines whether or not the model is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <c>show</c> property as a <c>boolean</c> value.  The <c>show</c> property specifies whether or not the model is shown.  If not specified, the default value is <see langword="true"/>.
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
        /// Writes a value for the <c>show</c> property as a <c>reference</c> value.  The <c>show</c> property specifies whether or not the model is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteShowPropertyReference(Reference value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>show</c> property as a <c>reference</c> value.  The <c>show</c> property specifies whether or not the model is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteShowPropertyReference(string value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>show</c> property as a <c>reference</c> value.  The <c>show</c> property specifies whether or not the model is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteShowPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>show</c> property as a <c>reference</c> value.  The <c>show</c> property specifies whether or not the model is shown.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteShowPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>gltf</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>gltf</c> property defines the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        public UriCesiumWriter GltfWriter
        {
            get { return m_gltf.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>gltf</c> property.  The <c>gltf</c> property defines the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        public UriCesiumWriter OpenGltfProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(GltfWriter);
        }

        /// <summary>
        /// Writes a value for the <c>gltf</c> property as a <c>uri</c> value.  The <c>gltf</c> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="resource">A resource object describing external data.</param>
        public void WriteGltfProperty(CesiumResource resource)
        {
            using (var writer = OpenGltfProperty())
            {
                writer.WriteUri(resource);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gltf</c> property as a <c>uri</c> value.  The <c>gltf</c> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="uri">The URI of the data.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.</param>
        public void WriteGltfProperty(Uri uri, CesiumResourceBehavior resourceBehavior)
        {
            using (var writer = OpenGltfProperty())
            {
                writer.WriteUri(uri, resourceBehavior);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gltf</c> property as a <c>uri</c> value.  The <c>gltf</c> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="uri">The URI of the data.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.</param>
        public void WriteGltfProperty(string uri, CesiumResourceBehavior resourceBehavior)
        {
            using (var writer = OpenGltfProperty())
            {
                writer.WriteUri(uri, resourceBehavior);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gltf</c> property as a <c>uri</c> value.  The <c>gltf</c> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="uri">The URI of the data.  The provided ICesiumUriResolver will be used to build the final URI embedded in the document.</param>
        /// <param name="resolver">An ICesiumUriResolver used to build the final URI that will be embedded in the document.</param>
        public void WriteGltfProperty(Uri uri, ICesiumUriResolver resolver)
        {
            using (var writer = OpenGltfProperty())
            {
                writer.WriteUri(uri, resolver);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gltf</c> property as a <c>uri</c> value.  The <c>gltf</c> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="uri">The URI of the data.  The provided ICesiumUriResolver will be used to build the final URI embedded in the document.</param>
        /// <param name="resolver">An ICesiumUriResolver used to build the final URI that will be embedded in the document.</param>
        public void WriteGltfProperty(string uri, ICesiumUriResolver resolver)
        {
            using (var writer = OpenGltfProperty())
            {
                writer.WriteUri(uri, resolver);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gltf</c> property as a <c>uri</c> value.  The <c>gltf</c> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="image">The image.  A data URI will be created for this image, using PNG encoding.</param>
        public void WriteGltfProperty(Image image)
        {
            using (var writer = OpenGltfProperty())
            {
                writer.WriteUri(image);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gltf</c> property as a <c>uri</c> value.  The <c>gltf</c> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="image">The image.  A data URI will be created for this image.</param>
        /// <param name="imageFormat">The image format to use to encode the image in the data URI.</param>
        public void WriteGltfProperty(Image image, CesiumImageFormat imageFormat)
        {
            using (var writer = OpenGltfProperty())
            {
                writer.WriteUri(image, imageFormat);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gltf</c> property as a <c>reference</c> value.  The <c>gltf</c> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteGltfPropertyReference(Reference value)
        {
            using (var writer = OpenGltfProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gltf</c> property as a <c>reference</c> value.  The <c>gltf</c> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteGltfPropertyReference(string value)
        {
            using (var writer = OpenGltfProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gltf</c> property as a <c>reference</c> value.  The <c>gltf</c> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteGltfPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenGltfProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>gltf</c> property as a <c>reference</c> value.  The <c>gltf</c> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.  For broadest client compatibility, the URI should be accessible via Cross-Origin Resource Sharing (CORS).  The URI may also be a <a href="https://developer.mozilla.org/en/data_URIs">data URI</a>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteGltfPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenGltfProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>scale</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>scale</c> property defines the scale of the model.
        /// </summary>
        public DoubleCesiumWriter ScaleWriter
        {
            get { return m_scale.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>scale</c> property.  The <c>scale</c> property defines the scale of the model.
        /// </summary>
        public DoubleCesiumWriter OpenScaleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ScaleWriter);
        }

        /// <summary>
        /// Writes a value for the <c>scale</c> property as a <c>number</c> value.  The <c>scale</c> property specifies the scale of the model.
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
        /// Writes a value for the <c>scale</c> property as a <c>number</c> value.  The <c>scale</c> property specifies the scale of the model.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteScaleProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>scale</c> property as a <c>number</c> value.  The <c>scale</c> property specifies the scale of the model.
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
        /// Writes a value for the <c>scale</c> property as a <c>reference</c> value.  The <c>scale</c> property specifies the scale of the model.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteScalePropertyReference(Reference value)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>scale</c> property as a <c>reference</c> value.  The <c>scale</c> property specifies the scale of the model.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteScalePropertyReference(string value)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>scale</c> property as a <c>reference</c> value.  The <c>scale</c> property specifies the scale of the model.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteScalePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>scale</c> property as a <c>reference</c> value.  The <c>scale</c> property specifies the scale of the model.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteScalePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenScaleProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>minimumPixelSize</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>minimumPixelSize</c> property defines the approximate minimum pixel size of the model regardless of zoom.
        /// </summary>
        public DoubleCesiumWriter MinimumPixelSizeWriter
        {
            get { return m_minimumPixelSize.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>minimumPixelSize</c> property.  The <c>minimumPixelSize</c> property defines the approximate minimum pixel size of the model regardless of zoom.
        /// </summary>
        public DoubleCesiumWriter OpenMinimumPixelSizeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MinimumPixelSizeWriter);
        }

        /// <summary>
        /// Writes a value for the <c>minimumPixelSize</c> property as a <c>number</c> value.  The <c>minimumPixelSize</c> property specifies the approximate minimum pixel size of the model regardless of zoom.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteMinimumPixelSizeProperty(double value)
        {
            using (var writer = OpenMinimumPixelSizeProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>minimumPixelSize</c> property as a <c>number</c> value.  The <c>minimumPixelSize</c> property specifies the approximate minimum pixel size of the model regardless of zoom.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteMinimumPixelSizeProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenMinimumPixelSizeProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>minimumPixelSize</c> property as a <c>number</c> value.  The <c>minimumPixelSize</c> property specifies the approximate minimum pixel size of the model regardless of zoom.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteMinimumPixelSizeProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenMinimumPixelSizeProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>minimumPixelSize</c> property as a <c>reference</c> value.  The <c>minimumPixelSize</c> property specifies the approximate minimum pixel size of the model regardless of zoom.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteMinimumPixelSizePropertyReference(Reference value)
        {
            using (var writer = OpenMinimumPixelSizeProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>minimumPixelSize</c> property as a <c>reference</c> value.  The <c>minimumPixelSize</c> property specifies the approximate minimum pixel size of the model regardless of zoom.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteMinimumPixelSizePropertyReference(string value)
        {
            using (var writer = OpenMinimumPixelSizeProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>minimumPixelSize</c> property as a <c>reference</c> value.  The <c>minimumPixelSize</c> property specifies the approximate minimum pixel size of the model regardless of zoom.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteMinimumPixelSizePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenMinimumPixelSizeProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>minimumPixelSize</c> property as a <c>reference</c> value.  The <c>minimumPixelSize</c> property specifies the approximate minimum pixel size of the model regardless of zoom.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteMinimumPixelSizePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenMinimumPixelSizeProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>maximumScale</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>maximumScale</c> property defines the maximum scale size of the model. This is used as an upper limit for `minimumPixelSize`.
        /// </summary>
        public DoubleCesiumWriter MaximumScaleWriter
        {
            get { return m_maximumScale.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>maximumScale</c> property.  The <c>maximumScale</c> property defines the maximum scale size of the model. This is used as an upper limit for `minimumPixelSize`.
        /// </summary>
        public DoubleCesiumWriter OpenMaximumScaleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaximumScaleWriter);
        }

        /// <summary>
        /// Writes a value for the <c>maximumScale</c> property as a <c>number</c> value.  The <c>maximumScale</c> property specifies the maximum scale size of the model. This is used as an upper limit for `minimumPixelSize`.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteMaximumScaleProperty(double value)
        {
            using (var writer = OpenMaximumScaleProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>maximumScale</c> property as a <c>number</c> value.  The <c>maximumScale</c> property specifies the maximum scale size of the model. This is used as an upper limit for `minimumPixelSize`.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteMaximumScaleProperty(IList<JulianDate> dates, IList<double> values)
        {
            using (var writer = OpenMaximumScaleProperty())
            {
                writer.WriteNumber(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>maximumScale</c> property as a <c>number</c> value.  The <c>maximumScale</c> property specifies the maximum scale size of the model. This is used as an upper limit for `minimumPixelSize`.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteMaximumScaleProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenMaximumScaleProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>maximumScale</c> property as a <c>reference</c> value.  The <c>maximumScale</c> property specifies the maximum scale size of the model. This is used as an upper limit for `minimumPixelSize`.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteMaximumScalePropertyReference(Reference value)
        {
            using (var writer = OpenMaximumScaleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>maximumScale</c> property as a <c>reference</c> value.  The <c>maximumScale</c> property specifies the maximum scale size of the model. This is used as an upper limit for `minimumPixelSize`.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteMaximumScalePropertyReference(string value)
        {
            using (var writer = OpenMaximumScaleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>maximumScale</c> property as a <c>reference</c> value.  The <c>maximumScale</c> property specifies the maximum scale size of the model. This is used as an upper limit for `minimumPixelSize`.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteMaximumScalePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenMaximumScaleProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>maximumScale</c> property as a <c>reference</c> value.  The <c>maximumScale</c> property specifies the maximum scale size of the model. This is used as an upper limit for `minimumPixelSize`.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteMaximumScalePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenMaximumScaleProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>incrementallyLoadTextures</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>incrementallyLoadTextures</c> property defines whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter IncrementallyLoadTexturesWriter
        {
            get { return m_incrementallyLoadTextures.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>incrementallyLoadTextures</c> property.  The <c>incrementallyLoadTextures</c> property defines whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter OpenIncrementallyLoadTexturesProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(IncrementallyLoadTexturesWriter);
        }

        /// <summary>
        /// Writes a value for the <c>incrementallyLoadTextures</c> property as a <c>boolean</c> value.  The <c>incrementallyLoadTextures</c> property specifies whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteIncrementallyLoadTexturesProperty(bool value)
        {
            using (var writer = OpenIncrementallyLoadTexturesProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>incrementallyLoadTextures</c> property as a <c>reference</c> value.  The <c>incrementallyLoadTextures</c> property specifies whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteIncrementallyLoadTexturesPropertyReference(Reference value)
        {
            using (var writer = OpenIncrementallyLoadTexturesProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>incrementallyLoadTextures</c> property as a <c>reference</c> value.  The <c>incrementallyLoadTextures</c> property specifies whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteIncrementallyLoadTexturesPropertyReference(string value)
        {
            using (var writer = OpenIncrementallyLoadTexturesProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>incrementallyLoadTextures</c> property as a <c>reference</c> value.  The <c>incrementallyLoadTextures</c> property specifies whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteIncrementallyLoadTexturesPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenIncrementallyLoadTexturesProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>incrementallyLoadTextures</c> property as a <c>reference</c> value.  The <c>incrementallyLoadTextures</c> property specifies whether or not the model can be rendered before all textures have loaded.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteIncrementallyLoadTexturesPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenIncrementallyLoadTexturesProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>runAnimations</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>runAnimations</c> property defines whether or not to run all animations defined in the glTF model.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter RunAnimationsWriter
        {
            get { return m_runAnimations.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>runAnimations</c> property.  The <c>runAnimations</c> property defines whether or not to run all animations defined in the glTF model.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        public BooleanCesiumWriter OpenRunAnimationsProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RunAnimationsWriter);
        }

        /// <summary>
        /// Writes a value for the <c>runAnimations</c> property as a <c>boolean</c> value.  The <c>runAnimations</c> property specifies whether or not to run all animations defined in the glTF model.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRunAnimationsProperty(bool value)
        {
            using (var writer = OpenRunAnimationsProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>runAnimations</c> property as a <c>reference</c> value.  The <c>runAnimations</c> property specifies whether or not to run all animations defined in the glTF model.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteRunAnimationsPropertyReference(Reference value)
        {
            using (var writer = OpenRunAnimationsProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>runAnimations</c> property as a <c>reference</c> value.  The <c>runAnimations</c> property specifies whether or not to run all animations defined in the glTF model.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteRunAnimationsPropertyReference(string value)
        {
            using (var writer = OpenRunAnimationsProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>runAnimations</c> property as a <c>reference</c> value.  The <c>runAnimations</c> property specifies whether or not to run all animations defined in the glTF model.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteRunAnimationsPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenRunAnimationsProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>runAnimations</c> property as a <c>reference</c> value.  The <c>runAnimations</c> property specifies whether or not to run all animations defined in the glTF model.  If not specified, the default value is <see langword="true"/>.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteRunAnimationsPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenRunAnimationsProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>heightReference</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>heightReference</c> property defines the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        public HeightReferenceCesiumWriter HeightReferenceWriter
        {
            get { return m_heightReference.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>heightReference</c> property.  The <c>heightReference</c> property defines the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        public HeightReferenceCesiumWriter OpenHeightReferenceProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HeightReferenceWriter);
        }

        /// <summary>
        /// Writes a value for the <c>heightReference</c> property as a <c>heightReference</c> value.  The <c>heightReference</c> property specifies the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        /// <param name="value">The height reference.</param>
        public void WriteHeightReferenceProperty(CesiumHeightReference value)
        {
            using (var writer = OpenHeightReferenceProperty())
            {
                writer.WriteHeightReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>heightReference</c> property as a <c>reference</c> value.  The <c>heightReference</c> property specifies the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteHeightReferencePropertyReference(Reference value)
        {
            using (var writer = OpenHeightReferenceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>heightReference</c> property as a <c>reference</c> value.  The <c>heightReference</c> property specifies the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteHeightReferencePropertyReference(string value)
        {
            using (var writer = OpenHeightReferenceProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>heightReference</c> property as a <c>reference</c> value.  The <c>heightReference</c> property specifies the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteHeightReferencePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenHeightReferenceProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>heightReference</c> property as a <c>reference</c> value.  The <c>heightReference</c> property specifies the height reference of the model, which indicates if the position is relative to terrain or not.  If not specified, the default value is NONE.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteHeightReferencePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenHeightReferenceProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>nodeTransformations</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>nodeTransformations</c> property defines a mapping of node names to node transformations.
        /// </summary>
        public NodeTransformationsCesiumWriter NodeTransformationsWriter
        {
            get { return m_nodeTransformations.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>nodeTransformations</c> property.  The <c>nodeTransformations</c> property defines a mapping of node names to node transformations.
        /// </summary>
        public NodeTransformationsCesiumWriter OpenNodeTransformationsProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(NodeTransformationsWriter);
        }

    }
}
