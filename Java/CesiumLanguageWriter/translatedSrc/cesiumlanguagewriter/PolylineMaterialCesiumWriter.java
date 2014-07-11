package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.PolylineGlowMaterialCesiumWriter;
import cesiumlanguagewriter.PolylineOutlineMaterialCesiumWriter;
import cesiumlanguagewriter.SolidColorMaterialCesiumWriter;

/**
 *  
 Writes a <code>PolylineMaterial</code> to a  {@link CesiumOutputStream}.  A <code>PolylineMaterial</code> defines how a polyline is colored or shaded.
 

 */
public class PolylineMaterialCesiumWriter extends CesiumPropertyWriter<PolylineMaterialCesiumWriter> {
	/**
	 *  
	The name of the <code>solidColor</code> property.
	

	 */
	public static final String SolidColorPropertyName = "solidColor";
	/**
	 *  
	The name of the <code>polylineOutline</code> property.
	

	 */
	public static final String PolylineOutlinePropertyName = "polylineOutline";
	/**
	 *  
	The name of the <code>polylineGlow</code> property.
	

	 */
	public static final String PolylineGlowPropertyName = "polylineGlow";
	private Lazy<SolidColorMaterialCesiumWriter> m_solidColor = new Lazy<cesiumlanguagewriter.SolidColorMaterialCesiumWriter>(new Func1<cesiumlanguagewriter.SolidColorMaterialCesiumWriter>() {
		public cesiumlanguagewriter.SolidColorMaterialCesiumWriter invoke() {
			return new SolidColorMaterialCesiumWriter(SolidColorPropertyName);
		}
	}, false);
	private Lazy<PolylineOutlineMaterialCesiumWriter> m_polylineOutline = new Lazy<cesiumlanguagewriter.PolylineOutlineMaterialCesiumWriter>(
			new Func1<cesiumlanguagewriter.PolylineOutlineMaterialCesiumWriter>() {
				public cesiumlanguagewriter.PolylineOutlineMaterialCesiumWriter invoke() {
					return new PolylineOutlineMaterialCesiumWriter(PolylineOutlinePropertyName);
				}
			}, false);
	private Lazy<PolylineGlowMaterialCesiumWriter> m_polylineGlow = new Lazy<cesiumlanguagewriter.PolylineGlowMaterialCesiumWriter>(new Func1<cesiumlanguagewriter.PolylineGlowMaterialCesiumWriter>() {
		public cesiumlanguagewriter.PolylineGlowMaterialCesiumWriter invoke() {
			return new PolylineGlowMaterialCesiumWriter(PolylineGlowPropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public PolylineMaterialCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected PolylineMaterialCesiumWriter(PolylineMaterialCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public PolylineMaterialCesiumWriter clone() {
		return new PolylineMaterialCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>solidColor</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>solidColor</code> property defines colors the line with a solid color, which may be translucent.
	

	 */
	public final SolidColorMaterialCesiumWriter getSolidColorWriter() {
		return m_solidColor.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>solidColor</code> property.  The <code>solidColor</code> property defines colors the line with a solid color, which may be translucent.
	

	 */
	public final SolidColorMaterialCesiumWriter openSolidColorProperty() {
		openIntervalIfNecessary();
		return this.<SolidColorMaterialCesiumWriter> openAndReturn(getSolidColorWriter());
	}

	/**
	 *  Gets the writer for the <code>polylineOutline</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>polylineOutline</code> property defines colors the line with a color and outline.
	

	 */
	public final PolylineOutlineMaterialCesiumWriter getPolylineOutlineWriter() {
		return m_polylineOutline.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>polylineOutline</code> property.  The <code>polylineOutline</code> property defines colors the line with a color and outline.
	

	 */
	public final PolylineOutlineMaterialCesiumWriter openPolylineOutlineProperty() {
		openIntervalIfNecessary();
		return this.<PolylineOutlineMaterialCesiumWriter> openAndReturn(getPolylineOutlineWriter());
	}

	/**
	 *  Gets the writer for the <code>polylineGlow</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>polylineGlow</code> property defines colors the line with a glowing color.
	

	 */
	public final PolylineGlowMaterialCesiumWriter getPolylineGlowWriter() {
		return m_polylineGlow.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>polylineGlow</code> property.  The <code>polylineGlow</code> property defines colors the line with a glowing color.
	

	 */
	public final PolylineGlowMaterialCesiumWriter openPolylineGlowProperty() {
		openIntervalIfNecessary();
		return this.<PolylineGlowMaterialCesiumWriter> openAndReturn(getPolylineGlowWriter());
	}
}