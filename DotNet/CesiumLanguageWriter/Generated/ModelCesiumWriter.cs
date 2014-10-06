// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Model</code> to a <see cref="CesiumOutputStream" />.  A <code>Model</code> a 3D model.
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
        /// The name of the <code>minimumPixelSize</code> property.
        /// </summary>
        public const string MinimumPixelSizePropertyName = "minimumPixelSize";

        /// <summary>
        /// The name of the <code>gltf</code> property.
        /// </summary>
        public const string GltfPropertyName = "gltf";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_scale = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ScalePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_minimumPixelSize = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(MinimumPixelSizePropertyName), false);
        private readonly Lazy<UriCesiumWriter> m_gltf = new Lazy<UriCesiumWriter>(() => new UriCesiumWriter(GltfPropertyName), false);

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
        /// Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the model.
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
        /// Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the model.
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
        /// Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the model.
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
        /// Writes a value for the <code>scale</code> property as a <code>reference</code> value.  The <code>scale</code> property specifies the scale of the model.
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
        /// Gets the writer for the <code>minimumPixelSize</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>minimumPixelSize</code> property defines the approximate minimum pixel size of the model regardless of zoom.
        /// </summary>
        public DoubleCesiumWriter MinimumPixelSizeWriter
        {
            get { return m_minimumPixelSize.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>minimumPixelSize</code> property.  The <code>minimumPixelSize</code> property defines the approximate minimum pixel size of the model regardless of zoom.
        /// </summary>
        public DoubleCesiumWriter OpenMinimumPixelSizeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MinimumPixelSizeWriter);
        }

        /// <summary>
        /// Writes a value for the <code>minimumPixelSize</code> property as a <code>number</code> value.  The <code>minimumPixelSize</code> property specifies the approximate minimum pixel size of the model regardless of zoom.
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
        /// Writes a value for the <code>minimumPixelSize</code> property as a <code>number</code> value.  The <code>minimumPixelSize</code> property specifies the approximate minimum pixel size of the model regardless of zoom.
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
        /// Writes a value for the <code>minimumPixelSize</code> property as a <code>reference</code> value.  The <code>minimumPixelSize</code> property specifies the approximate minimum pixel size of the model regardless of zoom.
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
        /// Writes a value for the <code>minimumPixelSize</code> property as a <code>reference</code> value.  The <code>minimumPixelSize</code> property specifies the approximate minimum pixel size of the model regardless of zoom.
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
        /// Writes a value for the <code>minimumPixelSize</code> property as a <code>reference</code> value.  The <code>minimumPixelSize</code> property specifies the approximate minimum pixel size of the model regardless of zoom.
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
        /// Writes a value for the <code>minimumPixelSize</code> property as a <code>reference</code> value.  The <code>minimumPixelSize</code> property specifies the approximate minimum pixel size of the model regardless of zoom.
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
        /// Gets the writer for the <code>gltf</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>gltf</code> property defines the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
        /// </summary>
        public UriCesiumWriter GltfWriter
        {
            get { return m_gltf.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>gltf</code> property.  The <code>gltf</code> property defines the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
        /// </summary>
        public UriCesiumWriter OpenGltfProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(GltfWriter);
        }

        /// <summary>
        /// Writes a value for the <code>gltf</code> property as a <code>uri</code> value.  The <code>gltf</code> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
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
        /// Writes a value for the <code>gltf</code> property as a <code>uri</code> value.  The <code>gltf</code> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
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
        /// Writes a value for the <code>gltf</code> property as a <code>uri</code> value.  The <code>gltf</code> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
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
        /// Writes a value for the <code>gltf</code> property as a <code>uri</code> value.  The <code>gltf</code> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
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
        /// Writes a value for the <code>gltf</code> property as a <code>uri</code> value.  The <code>gltf</code> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
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
        /// Writes a value for the <code>gltf</code> property as a <code>reference</code> value.  The <code>gltf</code> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
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
        /// Writes a value for the <code>gltf</code> property as a <code>reference</code> value.  The <code>gltf</code> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
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
        /// Writes a value for the <code>gltf</code> property as a <code>reference</code> value.  The <code>gltf</code> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
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
        /// Writes a value for the <code>gltf</code> property as a <code>reference</code> value.  The <code>gltf</code> property specifies the URI of a <a href="https://github.com/KhronosGroup/glTF">glTF</a> model.
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

    }
}
