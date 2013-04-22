// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Drawing;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Material</code> to a <see cref="CesiumOutputStream" />.  A <code>Material</code> defines how a surface is colored or shaded.
    /// </summary>
    public class MaterialCesiumWriter : CesiumPropertyWriter<MaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>solidColor</code> property.
        /// </summary>
        public const string SolidColorPropertyName = "solidColor";

        /// <summary>
        /// The name of the <code>image</code> property.
        /// </summary>
        public const string ImagePropertyName = "image";

        /// <summary>
        /// The name of the <code>grid</code> property.
        /// </summary>
        public const string GridPropertyName = "grid";

        private readonly Lazy<SolidColorMaterialCesiumWriter> m_solidColor = new Lazy<SolidColorMaterialCesiumWriter>(() => new SolidColorMaterialCesiumWriter(SolidColorPropertyName), false);
        private readonly Lazy<ImageMaterialCesiumWriter> m_image = new Lazy<ImageMaterialCesiumWriter>(() => new ImageMaterialCesiumWriter(ImagePropertyName), false);
        private readonly Lazy<GridMaterialCesiumWriter> m_grid = new Lazy<GridMaterialCesiumWriter>(() => new GridMaterialCesiumWriter(GridPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public MaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected MaterialCesiumWriter(MaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override MaterialCesiumWriter Clone()
        {
            return new MaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>solidColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>solidColor</code> property defines fills the surface with a solid color, which may be translucent.
        /// </summary>
        public SolidColorMaterialCesiumWriter SolidColorWriter
        {
            get { return m_solidColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>solidColor</code> property.  The <code>solidColor</code> property defines fills the surface with a solid color, which may be translucent.
        /// </summary>
        public SolidColorMaterialCesiumWriter OpenSolidColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SolidColorWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>image</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>image</code> property defines fills the surface with an image.
        /// </summary>
        public ImageMaterialCesiumWriter ImageWriter
        {
            get { return m_image.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>image</code> property.  The <code>image</code> property defines fills the surface with an image.
        /// </summary>
        public ImageMaterialCesiumWriter OpenImageProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ImageWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>grid</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>grid</code> property defines fills the surface with a grid.
        /// </summary>
        public GridMaterialCesiumWriter GridWriter
        {
            get { return m_grid.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>grid</code> property.  The <code>grid</code> property defines fills the surface with a grid.
        /// </summary>
        public GridMaterialCesiumWriter OpenGridProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(GridWriter);
        }

    }
}
