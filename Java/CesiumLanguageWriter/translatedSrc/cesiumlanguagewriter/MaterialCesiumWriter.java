package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.GridMaterialCesiumWriter;
import cesiumlanguagewriter.ImageMaterialCesiumWriter;
import cesiumlanguagewriter.SolidColorMaterialCesiumWriter;
import cesiumlanguagewriter.StripeMaterialCesiumWriter;

/**
 *  
 Writes a <code>Material</code> to a  {@link CesiumOutputStream}.  A <code>Material</code> defines how a surface is colored or shaded.
 

 */
public class MaterialCesiumWriter extends CesiumPropertyWriter<MaterialCesiumWriter> {
	/**
	 *  
	The name of the <code>solidColor</code> property.
	

	 */
	public static final String SolidColorPropertyName = "solidColor";
	/**
	 *  
	The name of the <code>image</code> property.
	

	 */
	public static final String ImagePropertyName = "image";
	/**
	 *  
	The name of the <code>grid</code> property.
	

	 */
	public static final String GridPropertyName = "grid";
	/**
	 *  
	The name of the <code>stripe</code> property.
	

	 */
	public static final String StripePropertyName = "stripe";
	/**
	 *  
	The name of the <code>reference</code> property.
	

	 */
	public static final String ReferencePropertyName = "reference";
	private Lazy<SolidColorMaterialCesiumWriter> m_solidColor = new Lazy<cesiumlanguagewriter.SolidColorMaterialCesiumWriter>(new Func1<cesiumlanguagewriter.SolidColorMaterialCesiumWriter>() {
		public cesiumlanguagewriter.SolidColorMaterialCesiumWriter invoke() {
			return new SolidColorMaterialCesiumWriter(SolidColorPropertyName);
		}
	}, false);
	private Lazy<ImageMaterialCesiumWriter> m_image = new Lazy<cesiumlanguagewriter.ImageMaterialCesiumWriter>(new Func1<cesiumlanguagewriter.ImageMaterialCesiumWriter>() {
		public cesiumlanguagewriter.ImageMaterialCesiumWriter invoke() {
			return new ImageMaterialCesiumWriter(ImagePropertyName);
		}
	}, false);
	private Lazy<GridMaterialCesiumWriter> m_grid = new Lazy<cesiumlanguagewriter.GridMaterialCesiumWriter>(new Func1<cesiumlanguagewriter.GridMaterialCesiumWriter>() {
		public cesiumlanguagewriter.GridMaterialCesiumWriter invoke() {
			return new GridMaterialCesiumWriter(GridPropertyName);
		}
	}, false);
	private Lazy<StripeMaterialCesiumWriter> m_stripe = new Lazy<cesiumlanguagewriter.StripeMaterialCesiumWriter>(new Func1<cesiumlanguagewriter.StripeMaterialCesiumWriter>() {
		public cesiumlanguagewriter.StripeMaterialCesiumWriter invoke() {
			return new StripeMaterialCesiumWriter(StripePropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public MaterialCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected MaterialCesiumWriter(MaterialCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public MaterialCesiumWriter clone() {
		return new MaterialCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>solidColor</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>solidColor</code> property defines fills the surface with a solid color, which may be translucent.
	

	 */
	public final SolidColorMaterialCesiumWriter getSolidColorWriter() {
		return m_solidColor.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>solidColor</code> property.  The <code>solidColor</code> property defines fills the surface with a solid color, which may be translucent.
	

	 */
	public final SolidColorMaterialCesiumWriter openSolidColorProperty() {
		openIntervalIfNecessary();
		return this.<SolidColorMaterialCesiumWriter> openAndReturn(getSolidColorWriter());
	}

	/**
	 *  Gets the writer for the <code>image</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>image</code> property defines fills the surface with an image.
	

	 */
	public final ImageMaterialCesiumWriter getImageWriter() {
		return m_image.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>image</code> property.  The <code>image</code> property defines fills the surface with an image.
	

	 */
	public final ImageMaterialCesiumWriter openImageProperty() {
		openIntervalIfNecessary();
		return this.<ImageMaterialCesiumWriter> openAndReturn(getImageWriter());
	}

	/**
	 *  Gets the writer for the <code>grid</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>grid</code> property defines fills the surface with a grid.
	

	 */
	public final GridMaterialCesiumWriter getGridWriter() {
		return m_grid.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>grid</code> property.  The <code>grid</code> property defines fills the surface with a grid.
	

	 */
	public final GridMaterialCesiumWriter openGridProperty() {
		openIntervalIfNecessary();
		return this.<GridMaterialCesiumWriter> openAndReturn(getGridWriter());
	}

	/**
	 *  Gets the writer for the <code>stripe</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>stripe</code> property defines fills the surface with alternating colors.
	

	 */
	public final StripeMaterialCesiumWriter getStripeWriter() {
		return m_stripe.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>stripe</code> property.  The <code>stripe</code> property defines fills the surface with alternating colors.
	

	 */
	public final StripeMaterialCesiumWriter openStripeProperty() {
		openIntervalIfNecessary();
		return this.<StripeMaterialCesiumWriter> openAndReturn(getStripeWriter());
	}

	/**
	 *  
	Writes the <code>reference</code> property.  The <code>reference</code> property specifies a reference.
	
	

	 * @param value The reference.
	 */
	public final void writeReference(Reference value) {
		String PropertyName = ReferencePropertyName;
		openIntervalIfNecessary();
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeReference(getOutput(), value);
	}
}