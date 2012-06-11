package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.util.List;

/**
 *  
 Writes a <code>Pyramid</code> to a  {@link CesiumOutputStream}.  A <code>Pyramid</code> a pyramid.  A pyramid starts at a point or apex and extends in a specified list of directions from the apex.  Each pair of directions forms a face of the pyramid.  The pyramid may be capped at a radial limit.
 

 */
public class PyramidCesiumWriter extends CesiumPropertyWriter<PyramidCesiumWriter> {
	/**
	 *  
	The name of the <code>show</code> property.
	

	 */
	public static final String ShowPropertyName = "show";
	/**
	 *  
	The name of the <code>directions</code> property.
	

	 */
	public static final String DirectionsPropertyName = "directions";
	/**
	 *  
	The name of the <code>radius</code> property.
	

	 */
	public static final String RadiusPropertyName = "radius";
	/**
	 *  
	The name of the <code>showIntersection</code> property.
	

	 */
	public static final String ShowIntersectionPropertyName = "showIntersection";
	/**
	 *  
	The name of the <code>intersectionColor</code> property.
	

	 */
	public static final String IntersectionColorPropertyName = "intersectionColor";
	/**
	 *  
	The name of the <code>material</code> property.
	

	 */
	public static final String MaterialPropertyName = "material";
	private Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
		public BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(ShowPropertyName);
		}
	}, false);
	private Lazy<DirectionListCesiumWriter> m_directions = new Lazy<DirectionListCesiumWriter>(new Func1<DirectionListCesiumWriter>() {
		public DirectionListCesiumWriter invoke() {
			return new DirectionListCesiumWriter(DirectionsPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_radius = new Lazy<DoubleCesiumWriter>(new Func1<DoubleCesiumWriter>() {
		public DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(RadiusPropertyName);
		}
	}, false);
	private Lazy<BooleanCesiumWriter> m_showIntersection = new Lazy<BooleanCesiumWriter>(new Func1<BooleanCesiumWriter>() {
		public BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(ShowIntersectionPropertyName);
		}
	}, false);
	private Lazy<ColorCesiumWriter> m_intersectionColor = new Lazy<ColorCesiumWriter>(new Func1<ColorCesiumWriter>() {
		public ColorCesiumWriter invoke() {
			return new ColorCesiumWriter(IntersectionColorPropertyName);
		}
	}, false);
	private Lazy<MaterialCesiumWriter> m_material = new Lazy<MaterialCesiumWriter>(new Func1<MaterialCesiumWriter>() {
		public MaterialCesiumWriter invoke() {
			return new MaterialCesiumWriter(MaterialPropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public PyramidCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected PyramidCesiumWriter(PyramidCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public PyramidCesiumWriter clone() {
		return new PyramidCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>show</code> property defines whether or not the pyramid is shown.
	

	 */
	public final BooleanCesiumWriter getShowWriter() {
		return m_show.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the pyramid is shown.
	

	 */
	public final BooleanCesiumWriter openShowProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the pyramid is shown.
	
	

	 * @param value The value.
	 */
	public final void writeShowProperty(boolean value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
			try {
				writer.writeBoolean(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>directions</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>directions</code> property defines the list of directions defining the pyramid.
	

	 */
	public final DirectionListCesiumWriter getDirectionsWriter() {
		return m_directions.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>directions</code> property.  The <code>directions</code> property defines the list of directions defining the pyramid.
	

	 */
	public final DirectionListCesiumWriter openDirectionsProperty() {
		openIntervalIfNecessary();
		return this.<DirectionListCesiumWriter> openAndReturn(getDirectionsWriter());
	}

	/**
	 *  
	Writes a value for the <code>directions</code> property as a <code>unitSpherical</code> value.  The <code>directions</code> property specifies the list of directions defining the pyramid.
	
	

	 * @param values The values.
	 */
	public final void writeDirectionsProperty(Iterable<UnitSpherical> values) {
		{
			cesiumlanguagewriter.DirectionListCesiumWriter writer = openDirectionsProperty();
			try {
				writer.writeUnitSpherical(values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>directions</code> property as a <code>unitCartesian</code> value.  The <code>directions</code> property specifies the list of directions defining the pyramid.
	
	

	 * @param values The values.
	 */
	public final void writeDirectionsPropertyUnitCartesian(Iterable<UnitCartesian> values) {
		{
			cesiumlanguagewriter.DirectionListCesiumWriter writer = openDirectionsProperty();
			try {
				writer.writeUnitCartesian(values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>radius</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>radius</code> property defines the radial limit of the pyramid.
	

	 */
	public final DoubleCesiumWriter getRadiusWriter() {
		return m_radius.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>radius</code> property.  The <code>radius</code> property defines the radial limit of the pyramid.
	

	 */
	public final DoubleCesiumWriter openRadiusProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getRadiusWriter());
	}

	/**
	 *  
	Writes a value for the <code>radius</code> property as a <code>number</code> value.  The <code>radius</code> property specifies the radial limit of the pyramid.
	
	

	 * @param value The value.
	 */
	public final void writeRadiusProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRadiusProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>radius</code> property as a <code>number</code> value.  The <code>radius</code> property specifies the radial limit of the pyramid.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeRadiusProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRadiusProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>showIntersection</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>showIntersection</code> property defines whether or not the intersection of the pyramid with the Earth is shown.
	

	 */
	public final BooleanCesiumWriter getShowIntersectionWriter() {
		return m_showIntersection.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>showIntersection</code> property.  The <code>showIntersection</code> property defines whether or not the intersection of the pyramid with the Earth is shown.
	

	 */
	public final BooleanCesiumWriter openShowIntersectionProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getShowIntersectionWriter());
	}

	/**
	 *  
	Writes a value for the <code>showIntersection</code> property as a <code>boolean</code> value.  The <code>showIntersection</code> property specifies whether or not the intersection of the pyramid with the Earth is shown.
	
	

	 * @param value The value.
	 */
	public final void writeShowIntersectionProperty(boolean value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openShowIntersectionProperty();
			try {
				writer.writeBoolean(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>intersectionColor</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>intersectionColor</code> property defines the color of the intersection of the pyramid with the Earth.
	

	 */
	public final ColorCesiumWriter getIntersectionColorWriter() {
		return m_intersectionColor.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>intersectionColor</code> property.  The <code>intersectionColor</code> property defines the color of the intersection of the pyramid with the Earth.
	

	 */
	public final ColorCesiumWriter openIntersectionColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getIntersectionColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>intersectionColor</code> property as a <code>rgba</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the pyramid with the Earth.
	
	

	 * @param color The color.
	 */
	public final void writeIntersectionColorProperty(Color color) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
			try {
				writer.writeRgba(color);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>intersectionColor</code> property as a <code>rgba</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the pyramid with the Earth.
	
	
	
	
	

	 * @param red The red component in the range 0 to 255.
	 * @param green The green component in the range 0 to 255.
	 * @param blue The blue component in the range 0 to 255.
	 * @param alpha The alpha component in the range 0 to 255.
	 */
	public final void writeIntersectionColorProperty(int red, int green, int blue, int alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
			try {
				writer.writeRgba(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>intersectionColor</code> property as a <code>rgba</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the pyramid with the Earth.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param colors The color corresponding to each date.
	 * @param startIndex The index of the first element to use in the `colors` collection.
	 * @param length The number of elements to use from the `colors` collection.
	 */
	public final void writeIntersectionColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
			try {
				writer.writeRgba(dates, colors, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>intersectionColor</code> property as a <code>rgbaf</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the pyramid with the Earth.
	
	
	
	
	

	 * @param red The red component in the range 0 to 1.0.
	 * @param green The green component in the range 0 to 1.0.
	 * @param blue The blue component in the range 0 to 1.0.
	 * @param alpha The alpha component in the range 0 to 1.0.
	 */
	public final void writeIntersectionColorPropertyRgbaf(float red, float green, float blue, float alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openIntersectionColorProperty();
			try {
				writer.writeRgbaf(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>material</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>material</code> property defines the material to display on the surface of the pyramid.
	

	 */
	public final MaterialCesiumWriter getMaterialWriter() {
		return m_material.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>material</code> property.  The <code>material</code> property defines the material to display on the surface of the pyramid.
	

	 */
	public final MaterialCesiumWriter openMaterialProperty() {
		openIntervalIfNecessary();
		return this.<MaterialCesiumWriter> openAndReturn(getMaterialWriter());
	}
}