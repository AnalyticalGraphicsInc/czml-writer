// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>PolylineMaterial</code> to a <see cref="CesiumOutputStream" />.  A <code>PolylineMaterial</code> defines how a polyline is colored or shaded.
    /// </summary>
    public class PolylineMaterialCesiumWriter : CesiumPropertyWriter<PolylineMaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>solidColor</code> property.
        /// </summary>
        public const string SolidColorPropertyName = "solidColor";

        /// <summary>
        /// The name of the <code>polylineOutline</code> property.
        /// </summary>
        public const string PolylineOutlinePropertyName = "polylineOutline";

        /// <summary>
        /// The name of the <code>polylineGlow</code> property.
        /// </summary>
        public const string PolylineGlowPropertyName = "polylineGlow";

        private readonly Lazy<SolidColorMaterialCesiumWriter> m_solidColor = new Lazy<SolidColorMaterialCesiumWriter>(() => new SolidColorMaterialCesiumWriter(SolidColorPropertyName), false);
        private readonly Lazy<PolylineOutlineMaterialCesiumWriter> m_polylineOutline = new Lazy<PolylineOutlineMaterialCesiumWriter>(() => new PolylineOutlineMaterialCesiumWriter(PolylineOutlinePropertyName), false);
        private readonly Lazy<PolylineGlowMaterialCesiumWriter> m_polylineGlow = new Lazy<PolylineGlowMaterialCesiumWriter>(() => new PolylineGlowMaterialCesiumWriter(PolylineGlowPropertyName), false);

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
        /// Gets the writer for the <code>solidColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>solidColor</code> property defines colors the line with a solid color, which may be translucent.
        /// </summary>
        public SolidColorMaterialCesiumWriter SolidColorWriter
        {
            get { return m_solidColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>solidColor</code> property.  The <code>solidColor</code> property defines colors the line with a solid color, which may be translucent.
        /// </summary>
        public SolidColorMaterialCesiumWriter OpenSolidColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SolidColorWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>polylineOutline</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>polylineOutline</code> property defines colors the line with a color and outline.
        /// </summary>
        public PolylineOutlineMaterialCesiumWriter PolylineOutlineWriter
        {
            get { return m_polylineOutline.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>polylineOutline</code> property.  The <code>polylineOutline</code> property defines colors the line with a color and outline.
        /// </summary>
        public PolylineOutlineMaterialCesiumWriter OpenPolylineOutlineProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PolylineOutlineWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>polylineGlow</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>polylineGlow</code> property defines colors the line with a glowing color.
        /// </summary>
        public PolylineGlowMaterialCesiumWriter PolylineGlowWriter
        {
            get { return m_polylineGlow.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>polylineGlow</code> property.  The <code>polylineGlow</code> property defines colors the line with a glowing color.
        /// </summary>
        public PolylineGlowMaterialCesiumWriter OpenPolylineGlowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PolylineGlowWriter);
        }

    }
}
