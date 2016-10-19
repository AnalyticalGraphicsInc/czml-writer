// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>PolylineMaterial</c> to a <see cref="CesiumOutputStream" />.  A <c>PolylineMaterial</c> is a definition of how a polyline is colored or shaded.
    /// </summary>
    public class PolylineMaterialCesiumWriter : CesiumPropertyWriter<PolylineMaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <c>solidColor</c> property.
        /// </summary>
        public const string SolidColorPropertyName = "solidColor";

        /// <summary>
        /// The name of the <c>polylineOutline</c> property.
        /// </summary>
        public const string PolylineOutlinePropertyName = "polylineOutline";

        /// <summary>
        /// The name of the <c>polylineArrow</c> property.
        /// </summary>
        public const string PolylineArrowPropertyName = "polylineArrow";

        /// <summary>
        /// The name of the <c>polylineGlow</c> property.
        /// </summary>
        public const string PolylineGlowPropertyName = "polylineGlow";

        /// <summary>
        /// The name of the <c>image</c> property.
        /// </summary>
        public const string ImagePropertyName = "image";

        /// <summary>
        /// The name of the <c>grid</c> property.
        /// </summary>
        public const string GridPropertyName = "grid";

        /// <summary>
        /// The name of the <c>stripe</c> property.
        /// </summary>
        public const string StripePropertyName = "stripe";

        private readonly Lazy<SolidColorMaterialCesiumWriter> m_solidColor = new Lazy<SolidColorMaterialCesiumWriter>(() => new SolidColorMaterialCesiumWriter(SolidColorPropertyName), false);
        private readonly Lazy<PolylineOutlineMaterialCesiumWriter> m_polylineOutline = new Lazy<PolylineOutlineMaterialCesiumWriter>(() => new PolylineOutlineMaterialCesiumWriter(PolylineOutlinePropertyName), false);
        private readonly Lazy<PolylineArrowMaterialCesiumWriter> m_polylineArrow = new Lazy<PolylineArrowMaterialCesiumWriter>(() => new PolylineArrowMaterialCesiumWriter(PolylineArrowPropertyName), false);
        private readonly Lazy<PolylineGlowMaterialCesiumWriter> m_polylineGlow = new Lazy<PolylineGlowMaterialCesiumWriter>(() => new PolylineGlowMaterialCesiumWriter(PolylineGlowPropertyName), false);
        private readonly Lazy<ImageMaterialCesiumWriter> m_image = new Lazy<ImageMaterialCesiumWriter>(() => new ImageMaterialCesiumWriter(ImagePropertyName), false);
        private readonly Lazy<GridMaterialCesiumWriter> m_grid = new Lazy<GridMaterialCesiumWriter>(() => new GridMaterialCesiumWriter(GridPropertyName), false);
        private readonly Lazy<StripeMaterialCesiumWriter> m_stripe = new Lazy<StripeMaterialCesiumWriter>(() => new StripeMaterialCesiumWriter(StripePropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PolylineMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected PolylineMaterialCesiumWriter(PolylineMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PolylineMaterialCesiumWriter Clone()
        {
            return new PolylineMaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <c>solidColor</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>solidColor</c> property defines a material that fills the line with a solid color, which may be translucent.
        /// </summary>
        public SolidColorMaterialCesiumWriter SolidColorWriter
        {
            get { return m_solidColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>solidColor</c> property.  The <c>solidColor</c> property defines a material that fills the line with a solid color, which may be translucent.
        /// </summary>
        public SolidColorMaterialCesiumWriter OpenSolidColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SolidColorWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>polylineOutline</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>polylineOutline</c> property defines a material that fills the line with a color and outline.
        /// </summary>
        public PolylineOutlineMaterialCesiumWriter PolylineOutlineWriter
        {
            get { return m_polylineOutline.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>polylineOutline</c> property.  The <c>polylineOutline</c> property defines a material that fills the line with a color and outline.
        /// </summary>
        public PolylineOutlineMaterialCesiumWriter OpenPolylineOutlineProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PolylineOutlineWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>polylineArrow</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>polylineArrow</c> property defines a material that fills the line with an arrow.
        /// </summary>
        public PolylineArrowMaterialCesiumWriter PolylineArrowWriter
        {
            get { return m_polylineArrow.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>polylineArrow</c> property.  The <c>polylineArrow</c> property defines a material that fills the line with an arrow.
        /// </summary>
        public PolylineArrowMaterialCesiumWriter OpenPolylineArrowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PolylineArrowWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>polylineGlow</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>polylineGlow</c> property defines a material that fills the line with a glowing color.
        /// </summary>
        public PolylineGlowMaterialCesiumWriter PolylineGlowWriter
        {
            get { return m_polylineGlow.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>polylineGlow</c> property.  The <c>polylineGlow</c> property defines a material that fills the line with a glowing color.
        /// </summary>
        public PolylineGlowMaterialCesiumWriter OpenPolylineGlowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PolylineGlowWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>image</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>image</c> property defines a material that fills the line with an image.
        /// </summary>
        public ImageMaterialCesiumWriter ImageWriter
        {
            get { return m_image.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>image</c> property.  The <c>image</c> property defines a material that fills the line with an image.
        /// </summary>
        public ImageMaterialCesiumWriter OpenImageProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ImageWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>grid</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>grid</c> property defines a material that fills the line with a grid.
        /// </summary>
        public GridMaterialCesiumWriter GridWriter
        {
            get { return m_grid.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>grid</c> property.  The <c>grid</c> property defines a material that fills the line with a grid.
        /// </summary>
        public GridMaterialCesiumWriter OpenGridProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(GridWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>stripe</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>stripe</c> property defines a material that fills the line with alternating colors.
        /// </summary>
        public StripeMaterialCesiumWriter StripeWriter
        {
            get { return m_stripe.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>stripe</c> property.  The <c>stripe</c> property defines a material that fills the line with alternating colors.
        /// </summary>
        public StripeMaterialCesiumWriter OpenStripeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(StripeWriter);
        }

    }
}
