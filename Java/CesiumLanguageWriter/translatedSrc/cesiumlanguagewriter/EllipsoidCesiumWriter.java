package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.EllipsoidRadiiCesiumWriter;
import cesiumlanguagewriter.MaterialCesiumWriter;
import java.awt.Color;
import java.util.List;

/**
 *  
 Writes a <code>Ellipsoid</code> to a  {@link CesiumOutputStream}.  A <code>Ellipsoid</code> defines a closed quadric surface that is a three dimensional analogue of an ellipse.
 

 */
public class EllipsoidCesiumWriter extends CesiumPropertyWriter<EllipsoidCesiumWriter> {
	/**
	 *  
	The name of the <code>show</code> property.
	

	 */
	public static final String ShowPropertyName = "show";
	/**
	 *  
	The name of the <code>radii</code> property.
	

	 */
	public static final String RadiiPropertyName = "radii";
	/**
	 *  
	The name of the <code>fill</code> property.
	

	 */
	public static final String FillPropertyName = "fill";
	/**
	 *  
	The name of the <code>material</code> property.
	

	 */
	public static final String MaterialPropertyName = "material";
	/**
	 *  
	The name of the <code>outline</code> property.
	

	 */
	public static final String OutlinePropertyName = "outline";
	/**
	 *  
	The name of the <code>outlineColor</code> property.
	

	 */
	public static final String OutlineColorPropertyName = "outlineColor";
	/**
	 *  
	The name of the <code>stackPartitions</code> property.
	

	 */
	public static final String StackPartitionsPropertyName = "stackPartitions";
	/**
	 *  
	The name of the <code>slicePartitions</code> property.
	

	 */
	public static final String SlicePartitionsPropertyName = "slicePartitions";
	/**
	 *  
	The name of the <code>subdivisions</code> property.
	

	 */
	public static final String SubdivisionsPropertyName = "subdivisions";
	private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(ShowPropertyName);
		}
	}, false);
	private Lazy<EllipsoidRadiiCesiumWriter> m_radii = new Lazy<cesiumlanguagewriter.EllipsoidRadiiCesiumWriter>(new Func1<cesiumlanguagewriter.EllipsoidRadiiCesiumWriter>() {
		public cesiumlanguagewriter.EllipsoidRadiiCesiumWriter invoke() {
			return new EllipsoidRadiiCesiumWriter(RadiiPropertyName);
		}
	}, false);
	private Lazy<BooleanCesiumWriter> m_fill = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(FillPropertyName);
		}
	}, false);
	private Lazy<MaterialCesiumWriter> m_material = new Lazy<cesiumlanguagewriter.MaterialCesiumWriter>(new Func1<cesiumlanguagewriter.MaterialCesiumWriter>() {
		public cesiumlanguagewriter.MaterialCesiumWriter invoke() {
			return new MaterialCesiumWriter(MaterialPropertyName);
		}
	}, false);
	private Lazy<BooleanCesiumWriter> m_outline = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(OutlinePropertyName);
		}
	}, false);
	private Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
		public cesiumlanguagewriter.ColorCesiumWriter invoke() {
			return new ColorCesiumWriter(OutlineColorPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_stackPartitions = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(StackPartitionsPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_slicePartitions = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(SlicePartitionsPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_subdivisions = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(SubdivisionsPropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public EllipsoidCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected EllipsoidCesiumWriter(EllipsoidCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public EllipsoidCesiumWriter clone() {
		return new EllipsoidCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>show</code> property defines whether or not the ellipsoid is shown.
	

	 */
	public final BooleanCesiumWriter getShowWriter() {
		return m_show.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the ellipsoid is shown.
	

	 */
	public final BooleanCesiumWriter openShowProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the ellipsoid is shown.
	
	

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
	 *  Gets the writer for the <code>radii</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>radii</code> property defines the dimensions of the ellipsoid.
	

	 */
	public final EllipsoidRadiiCesiumWriter getRadiiWriter() {
		return m_radii.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>radii</code> property.  The <code>radii</code> property defines the dimensions of the ellipsoid.
	

	 */
	public final EllipsoidRadiiCesiumWriter openRadiiProperty() {
		openIntervalIfNecessary();
		return this.<EllipsoidRadiiCesiumWriter> openAndReturn(getRadiiWriter());
	}

	/**
	 *  
	Writes a value for the <code>radii</code> property as a <code>cartesian</code> value.  The <code>radii</code> property specifies the dimensions of the ellipsoid.
	
	

	 * @param value The value.
	 */
	public final void writeRadiiProperty(Cartesian value) {
		{
			cesiumlanguagewriter.EllipsoidRadiiCesiumWriter writer = openRadiiProperty();
			try {
				writer.writeCartesian(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>radii</code> property as a <code>cartesian</code> value.  The <code>radii</code> property specifies the dimensions of the ellipsoid.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeRadiiProperty(List<JulianDate> dates, List<Cartesian> values) {
		{
			cesiumlanguagewriter.EllipsoidRadiiCesiumWriter writer = openRadiiProperty();
			try {
				writer.writeCartesian(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>radii</code> property as a <code>cartesian</code> value.  The <code>radii</code> property specifies the dimensions of the ellipsoid.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeRadiiProperty(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.EllipsoidRadiiCesiumWriter writer = openRadiiProperty();
			try {
				writer.writeCartesian(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>fill</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>fill</code> property defines whether or not the ellipsoid is filled.
	

	 */
	public final BooleanCesiumWriter getFillWriter() {
		return m_fill.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>fill</code> property.  The <code>fill</code> property defines whether or not the ellipsoid is filled.
	

	 */
	public final BooleanCesiumWriter openFillProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getFillWriter());
	}

	/**
	 *  
	Writes a value for the <code>fill</code> property as a <code>boolean</code> value.  The <code>fill</code> property specifies whether or not the ellipsoid is filled.
	
	

	 * @param value The value.
	 */
	public final void writeFillProperty(boolean value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openFillProperty();
			try {
				writer.writeBoolean(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>material</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>material</code> property defines the material to display on the surface of the ellipsoid.
	

	 */
	public final MaterialCesiumWriter getMaterialWriter() {
		return m_material.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>material</code> property.  The <code>material</code> property defines the material to display on the surface of the ellipsoid.
	

	 */
	public final MaterialCesiumWriter openMaterialProperty() {
		openIntervalIfNecessary();
		return this.<MaterialCesiumWriter> openAndReturn(getMaterialWriter());
	}

	/**
	 *  Gets the writer for the <code>outline</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>outline</code> property defines whether or not the ellipsoid is outlined.
	

	 */
	public final BooleanCesiumWriter getOutlineWriter() {
		return m_outline.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>outline</code> property.  The <code>outline</code> property defines whether or not the ellipsoid is outlined.
	

	 */
	public final BooleanCesiumWriter openOutlineProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getOutlineWriter());
	}

	/**
	 *  
	Writes a value for the <code>outline</code> property as a <code>boolean</code> value.  The <code>outline</code> property specifies whether or not the ellipsoid is outlined.
	
	

	 * @param value The value.
	 */
	public final void writeOutlineProperty(boolean value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openOutlineProperty();
			try {
				writer.writeBoolean(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>outlineColor</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>outlineColor</code> property defines the color of the ellipsoid outline.
	

	 */
	public final ColorCesiumWriter getOutlineColorWriter() {
		return m_outlineColor.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>outlineColor</code> property.  The <code>outlineColor</code> property defines the color of the ellipsoid outline.
	

	 */
	public final ColorCesiumWriter openOutlineColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the ellipsoid outline.
	
	

	 * @param color The color.
	 */
	public final void writeOutlineColorProperty(Color color) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgba(color);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the ellipsoid outline.
	
	
	
	
	

	 * @param red The red component in the range 0 to 255.
	 * @param green The green component in the range 0 to 255.
	 * @param blue The blue component in the range 0 to 255.
	 * @param alpha The alpha component in the range 0 to 255.
	 */
	public final void writeOutlineColorProperty(int red, int green, int blue, int alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgba(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the ellipsoid outline.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param colors The color corresponding to each date.
	 * @param startIndex The index of the first element to use in the `colors` collection.
	 * @param length The number of elements to use from the `colors` collection.
	 */
	public final void writeOutlineColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgba(dates, colors, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the ellipsoid outline.
	
	
	
	
	

	 * @param red The red component in the range 0 to 1.0.
	 * @param green The green component in the range 0 to 1.0.
	 * @param blue The blue component in the range 0 to 1.0.
	 * @param alpha The alpha component in the range 0 to 1.0.
	 */
	public final void writeOutlineColorPropertyRgbaf(float red, float green, float blue, float alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgbaf(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>stackPartitions</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>stackPartitions</code> property defines the number of times to partition the ellipsoid into stacks.
	

	 */
	public final DoubleCesiumWriter getStackPartitionsWriter() {
		return m_stackPartitions.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>stackPartitions</code> property.  The <code>stackPartitions</code> property defines the number of times to partition the ellipsoid into stacks.
	

	 */
	public final DoubleCesiumWriter openStackPartitionsProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getStackPartitionsWriter());
	}

	/**
	 *  
	Writes a value for the <code>stackPartitions</code> property as a <code>number</code> value.  The <code>stackPartitions</code> property specifies the number of times to partition the ellipsoid into stacks.
	
	

	 * @param value The value.
	 */
	public final void writeStackPartitionsProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openStackPartitionsProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>stackPartitions</code> property as a <code>number</code> value.  The <code>stackPartitions</code> property specifies the number of times to partition the ellipsoid into stacks.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeStackPartitionsProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openStackPartitionsProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>slicePartitions</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>slicePartitions</code> property defines the number of times to partition the ellipsoid into radial slices.
	

	 */
	public final DoubleCesiumWriter getSlicePartitionsWriter() {
		return m_slicePartitions.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>slicePartitions</code> property.  The <code>slicePartitions</code> property defines the number of times to partition the ellipsoid into radial slices.
	

	 */
	public final DoubleCesiumWriter openSlicePartitionsProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getSlicePartitionsWriter());
	}

	/**
	 *  
	Writes a value for the <code>slicePartitions</code> property as a <code>number</code> value.  The <code>slicePartitions</code> property specifies the number of times to partition the ellipsoid into radial slices.
	
	

	 * @param value The value.
	 */
	public final void writeSlicePartitionsProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openSlicePartitionsProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>slicePartitions</code> property as a <code>number</code> value.  The <code>slicePartitions</code> property specifies the number of times to partition the ellipsoid into radial slices.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeSlicePartitionsProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openSlicePartitionsProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>subdivisions</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>subdivisions</code> property defines the number of points per outline line, determining the granularity of the curvature.
	

	 */
	public final DoubleCesiumWriter getSubdivisionsWriter() {
		return m_subdivisions.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>subdivisions</code> property.  The <code>subdivisions</code> property defines the number of points per outline line, determining the granularity of the curvature.
	

	 */
	public final DoubleCesiumWriter openSubdivisionsProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getSubdivisionsWriter());
	}

	/**
	 *  
	Writes a value for the <code>subdivisions</code> property as a <code>number</code> value.  The <code>subdivisions</code> property specifies the number of points per outline line, determining the granularity of the curvature.
	
	

	 * @param value The value.
	 */
	public final void writeSubdivisionsProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openSubdivisionsProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>subdivisions</code> property as a <code>number</code> value.  The <code>subdivisions</code> property specifies the number of points per outline line, determining the granularity of the curvature.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeSubdivisionsProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openSubdivisionsProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}