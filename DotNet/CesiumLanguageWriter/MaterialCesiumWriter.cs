using System;
#if StkComponents
using AGI.Foundation.Cesium.Advanced;
#else
using CesiumLanguageWriter.Advanced;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// A <see cref="CesiumPropertyWriter{T}"/> for writing material-related properties to a
    /// <topic name="Cesium">Cesium</topic> stream.  A material describes how a surface is colored or
    /// shaded.
    /// </summary>
    public class MaterialCesiumWriter : CesiumPropertyWriter<MaterialCesiumWriter>
    {
        private readonly Lazy<TieDyeMaterialCesiumWriter> m_tieDye = new Lazy<TieDyeMaterialCesiumWriter>(() => new TieDyeMaterialCesiumWriter("tieDye"), false);
        private readonly Lazy<SolidColorMaterialCesiumWriter> m_solidColor = new Lazy<SolidColorMaterialCesiumWriter>(() => new SolidColorMaterialCesiumWriter("solidColor"), false);
        private readonly Lazy<HorizontalStripeMaterialCesiumWriter> m_horizontalStripe = new Lazy<HorizontalStripeMaterialCesiumWriter>(() => new HorizontalStripeMaterialCesiumWriter("horizontalStripe"), false);
        private readonly Lazy<VerticalStripeMaterialCesiumWriter> m_verticalStripe = new Lazy<VerticalStripeMaterialCesiumWriter>(() => new VerticalStripeMaterialCesiumWriter("verticalStripe"), false);
        private readonly Lazy<CheckerboardMaterialCesiumWriter> m_checkerboard = new Lazy<CheckerboardMaterialCesiumWriter>(() => new CheckerboardMaterialCesiumWriter("checkerboard"), false);
        private readonly Lazy<DotMaterialCesiumWriter> m_dot = new Lazy<DotMaterialCesiumWriter>(() => new DotMaterialCesiumWriter("dot"), false);
        private readonly Lazy<FacetMaterialCesiumWriter> m_facet = new Lazy<FacetMaterialCesiumWriter>(() => new FacetMaterialCesiumWriter("facet"), false);
        private readonly Lazy<BlobMaterialCesiumWriter> m_blob = new Lazy<BlobMaterialCesiumWriter>(() => new BlobMaterialCesiumWriter("blob"), false);
        private readonly Lazy<ImageMaterialCesiumWriter> m_image = new Lazy<ImageMaterialCesiumWriter>(() => new ImageMaterialCesiumWriter("image"), false);
        
        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="propertyName">The base name of the properties in this group.</param>
        public MaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <inheritdoc />
        private MaterialCesiumWriter(MaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override MaterialCesiumWriter Clone()
        {
            return new MaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets a group of properties describing the tie-dye material.  Theses properties only have
        /// an effect if the object is configured to use the tie-dye material.
        /// </summary>
        public TieDyeMaterialCesiumWriter TieDyeWriter
        {
            get { return m_tieDye.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>tieDye</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public TieDyeMaterialCesiumWriter OpenTieDyeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(TieDyeWriter);
        }

        /// <summary>
        /// Gets a group of properties describing the solid color material.  Theses properties only have
        /// an effect if the object is configured to use the solid color material.
        /// </summary>
        public SolidColorMaterialCesiumWriter SolidColorWriter
        {
            get { return m_solidColor.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>solidColor</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public SolidColorMaterialCesiumWriter OpenSolidColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SolidColorWriter);
        }

        /// <summary>
        /// Gets a group of properties describing the horizontal stripe material.  Theses properties only have
        /// an effect if the object is configured to use the horizontal stripe material.
        /// </summary>
        public HorizontalStripeMaterialCesiumWriter HorizontalStripeWriter
        {
            get { return m_horizontalStripe.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>horizontalstripe</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public HorizontalStripeMaterialCesiumWriter OpenHorizontalStripeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HorizontalStripeWriter);
        }

        /// <summary>
        /// Gets a group of properties describing the vertical stripe material.  Theses properties only have
        /// an effect if the object is configured to use the vertical stripe material.
        /// </summary>
        public VerticalStripeMaterialCesiumWriter VerticalStripeWriter
        {
            get { return m_verticalStripe.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>verticalstripe</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public VerticalStripeMaterialCesiumWriter OpenVerticalStripeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(VerticalStripeWriter);
        }

        /// <summary>
        /// Gets a group of properties describing the checkerboard material.  Theses properties only have
        /// an effect if the object is configured to use the checkerboard material.
        /// </summary>
        public CheckerboardMaterialCesiumWriter CheckerboardWriter
        {
            get { return m_checkerboard.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>checkerboard</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public CheckerboardMaterialCesiumWriter OpenCheckerboardProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(CheckerboardWriter);
        }

        /// <summary>
        /// Gets a group of properties describing the dot material.  Theses properties only have
        /// an effect if the object is configured to use the dot material.
        /// </summary>
        public DotMaterialCesiumWriter DotWriter
        {
            get { return m_dot.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>dot</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public DotMaterialCesiumWriter OpenDotProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(DotWriter);
        }

        /// <summary>
        /// Gets a group of properties describing the facet material.  Theses properties only have
        /// an effect if the object is configured to use the facet material.
        /// </summary>
        public FacetMaterialCesiumWriter FacetWriter
        {
            get { return m_facet.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>dot</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public FacetMaterialCesiumWriter OpenFacetProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(FacetWriter);
        }

        /// <summary>
        /// Gets a group of properties describing the color material.  Theses properties only have
        /// an effect if the object is configured to use the color material.
        /// </summary>
        public BlobMaterialCesiumWriter BlobWriter
        {
            get { return m_blob.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>dot</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public BlobMaterialCesiumWriter OpenBlobProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(BlobWriter);
        }

        /// <summary>
        /// Gets a group of properties describing the image material.  Theses properties only have
        /// an effect if the object is configured to use the image material.
        /// </summary>
        public ImageMaterialCesiumWriter ImageWriter
        {
            get { return m_image.Value; }
        }

        /// <summary>
        /// Opens and returns the a writer for the <code>image</code> property.
        /// </summary>
        /// <returns>The writer.</returns>
        public ImageMaterialCesiumWriter OpenImageProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ImageWriter);
        }
    }
}
