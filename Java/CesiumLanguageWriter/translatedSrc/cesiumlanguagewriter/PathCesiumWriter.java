package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import java.awt.Color;
import java.util.List;

/**
 *  
 Writes a <code>Path</code> to a  {@link CesiumOutputStream}.  A <code>Path</code> a path, which is a polyline defined by the motion of an object over time.  The possible vertices of the path are specified by the `position` property.
 

 */
public class PathCesiumWriter extends CesiumPropertyWriter<PathCesiumWriter> {
	/**
	 *  
	The name of the <code>show</code> property.
	

	 */
	public static final String ShowPropertyName = "show";
	/**
	 *  
	The name of the <code>color</code> property.
	

	 */
	public static final String ColorPropertyName = "color";
	/**
	 *  
	The name of the <code>width</code> property.
	

	 */
	public static final String WidthPropertyName = "width";
	/**
	 *  
	The name of the <code>resolution</code> property.
	

	 */
	public static final String ResolutionPropertyName = "resolution";
	/**
	 *  
	The name of the <code>outlineColor</code> property.
	

	 */
	public static final String OutlineColorPropertyName = "outlineColor";
	/**
	 *  
	The name of the <code>outlineWidth</code> property.
	

	 */
	public static final String OutlineWidthPropertyName = "outlineWidth";
	/**
	 *  
	The name of the <code>leadTime</code> property.
	

	 */
	public static final String LeadTimePropertyName = "leadTime";
	/**
	 *  
	The name of the <code>trailTime</code> property.
	

	 */
	public static final String TrailTimePropertyName = "trailTime";
	private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(ShowPropertyName);
		}
	}, false);
	private Lazy<ColorCesiumWriter> m_color = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
		public cesiumlanguagewriter.ColorCesiumWriter invoke() {
			return new ColorCesiumWriter(ColorPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_width = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(WidthPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_resolution = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(ResolutionPropertyName);
		}
	}, false);
	private Lazy<ColorCesiumWriter> m_outlineColor = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
		public cesiumlanguagewriter.ColorCesiumWriter invoke() {
			return new ColorCesiumWriter(OutlineColorPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(OutlineWidthPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_leadTime = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(LeadTimePropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_trailTime = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(TrailTimePropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public PathCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected PathCesiumWriter(PathCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public PathCesiumWriter clone() {
		return new PathCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>show</code> property defines whether or not the path is shown.
	

	 */
	public final BooleanCesiumWriter getShowWriter() {
		return m_show.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the path is shown.
	

	 */
	public final BooleanCesiumWriter openShowProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the path is shown.
	
	

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
	 *  Gets the writer for the <code>color</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>color</code> property defines the color of the path line.
	

	 */
	public final ColorCesiumWriter getColorWriter() {
		return m_color.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>color</code> property.  The <code>color</code> property defines the color of the path line.
	

	 */
	public final ColorCesiumWriter openColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the path line.
	
	

	 * @param color The color.
	 */
	public final void writeColorProperty(Color color) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeRgba(color);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the path line.
	
	
	
	
	

	 * @param red The red component in the range 0 to 255.
	 * @param green The green component in the range 0 to 255.
	 * @param blue The blue component in the range 0 to 255.
	 * @param alpha The alpha component in the range 0 to 255.
	 */
	public final void writeColorProperty(int red, int green, int blue, int alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeRgba(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the path line.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param colors The color corresponding to each date.
	 * @param startIndex The index of the first element to use in the `colors` collection.
	 * @param length The number of elements to use from the `colors` collection.
	 */
	public final void writeColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeRgba(dates, colors, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the path line.
	
	
	
	
	

	 * @param red The red component in the range 0 to 1.0.
	 * @param green The green component in the range 0 to 1.0.
	 * @param blue The blue component in the range 0 to 1.0.
	 * @param alpha The alpha component in the range 0 to 1.0.
	 */
	public final void writeColorPropertyRgbaf(float red, float green, float blue, float alpha) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeRgbaf(red, green, blue, alpha);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the path line.
	
	

	 * @param value The reference.
	 */
	public final void writeColorPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the path line.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeColorPropertyReference(String value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the path line.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeColorPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>reference</code> value.  The <code>color</code> property specifies the color of the path line.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The heirarchy of properties to be indexed on the referenced object.
	 */
	public final void writeColorPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openColorProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>width</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>width</code> property defines the width of the path line.
	

	 */
	public final DoubleCesiumWriter getWidthWriter() {
		return m_width.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>width</code> property.  The <code>width</code> property defines the width of the path line.
	

	 */
	public final DoubleCesiumWriter openWidthProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getWidthWriter());
	}

	/**
	 *  
	Writes a value for the <code>width</code> property as a <code>number</code> value.  The <code>width</code> property specifies the width of the path line.
	
	

	 * @param value The value.
	 */
	public final void writeWidthProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>width</code> property as a <code>number</code> value.  The <code>width</code> property specifies the width of the path line.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeWidthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the path line.
	
	

	 * @param value The reference.
	 */
	public final void writeWidthPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the path line.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeWidthPropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the path line.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeWidthPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the path line.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The heirarchy of properties to be indexed on the referenced object.
	 */
	public final void writeWidthPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>resolution</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>resolution</code> property defines the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
	

	 */
	public final DoubleCesiumWriter getResolutionWriter() {
		return m_resolution.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>resolution</code> property.  The <code>resolution</code> property defines the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
	

	 */
	public final DoubleCesiumWriter openResolutionProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getResolutionWriter());
	}

	/**
	 *  
	Writes a value for the <code>resolution</code> property as a <code>number</code> value.  The <code>resolution</code> property specifies the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
	
	

	 * @param value The value.
	 */
	public final void writeResolutionProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openResolutionProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>resolution</code> property as a <code>number</code> value.  The <code>resolution</code> property specifies the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeResolutionProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openResolutionProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>resolution</code> property as a <code>reference</code> value.  The <code>resolution</code> property specifies the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
	
	

	 * @param value The reference.
	 */
	public final void writeResolutionPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openResolutionProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>resolution</code> property as a <code>reference</code> value.  The <code>resolution</code> property specifies the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeResolutionPropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openResolutionProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>resolution</code> property as a <code>reference</code> value.  The <code>resolution</code> property specifies the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeResolutionPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openResolutionProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>resolution</code> property as a <code>reference</code> value.  The <code>resolution</code> property specifies the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The heirarchy of properties to be indexed on the referenced object.
	 */
	public final void writeResolutionPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openResolutionProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>outlineColor</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>outlineColor</code> property defines the color of the outline of the path.
	

	 */
	public final ColorCesiumWriter getOutlineColorWriter() {
		return m_outlineColor.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>outlineColor</code> property.  The <code>outlineColor</code> property defines the color of the outline of the path.
	

	 */
	public final ColorCesiumWriter openOutlineColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the path.
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the path.
	
	
	
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the path.
	
	
	
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the path.
	
	
	
	
	

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
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the path.
	
	

	 * @param value The reference.
	 */
	public final void writeOutlineColorPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the path.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeOutlineColorPropertyReference(String value) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the path.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeOutlineColorPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the outline of the path.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The heirarchy of properties to be indexed on the referenced object.
	 */
	public final void writeOutlineColorPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>outlineWidth</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>outlineWidth</code> property defines the width of the outline of the path.
	

	 */
	public final DoubleCesiumWriter getOutlineWidthWriter() {
		return m_outlineWidth.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>outlineWidth</code> property.  The <code>outlineWidth</code> property defines the width of the outline of the path.
	

	 */
	public final DoubleCesiumWriter openOutlineWidthProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getOutlineWidthWriter());
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the path.
	
	

	 * @param value The value.
	 */
	public final void writeOutlineWidthProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the path.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeOutlineWidthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the path.
	
	

	 * @param value The reference.
	 */
	public final void writeOutlineWidthPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the path.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeOutlineWidthPropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the path.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeOutlineWidthPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the outline of the path.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The heirarchy of properties to be indexed on the referenced object.
	 */
	public final void writeOutlineWidthPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>leadTime</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>leadTime</code> property defines the time ahead of the animation time, in seconds, to show the path.
	

	 */
	public final DoubleCesiumWriter getLeadTimeWriter() {
		return m_leadTime.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>leadTime</code> property.  The <code>leadTime</code> property defines the time ahead of the animation time, in seconds, to show the path.
	

	 */
	public final DoubleCesiumWriter openLeadTimeProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getLeadTimeWriter());
	}

	/**
	 *  
	Writes a value for the <code>leadTime</code> property as a <code>number</code> value.  The <code>leadTime</code> property specifies the time ahead of the animation time, in seconds, to show the path.
	
	

	 * @param value The value.
	 */
	public final void writeLeadTimeProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openLeadTimeProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>leadTime</code> property as a <code>number</code> value.  The <code>leadTime</code> property specifies the time ahead of the animation time, in seconds, to show the path.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeLeadTimeProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openLeadTimeProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>leadTime</code> property as a <code>reference</code> value.  The <code>leadTime</code> property specifies the time ahead of the animation time, in seconds, to show the path.
	
	

	 * @param value The reference.
	 */
	public final void writeLeadTimePropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openLeadTimeProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>leadTime</code> property as a <code>reference</code> value.  The <code>leadTime</code> property specifies the time ahead of the animation time, in seconds, to show the path.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeLeadTimePropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openLeadTimeProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>leadTime</code> property as a <code>reference</code> value.  The <code>leadTime</code> property specifies the time ahead of the animation time, in seconds, to show the path.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeLeadTimePropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openLeadTimeProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>leadTime</code> property as a <code>reference</code> value.  The <code>leadTime</code> property specifies the time ahead of the animation time, in seconds, to show the path.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The heirarchy of properties to be indexed on the referenced object.
	 */
	public final void writeLeadTimePropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openLeadTimeProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>trailTime</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>trailTime</code> property defines the time behind the animation time, in seconds, to show the path.
	

	 */
	public final DoubleCesiumWriter getTrailTimeWriter() {
		return m_trailTime.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>trailTime</code> property.  The <code>trailTime</code> property defines the time behind the animation time, in seconds, to show the path.
	

	 */
	public final DoubleCesiumWriter openTrailTimeProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getTrailTimeWriter());
	}

	/**
	 *  
	Writes a value for the <code>trailTime</code> property as a <code>number</code> value.  The <code>trailTime</code> property specifies the time behind the animation time, in seconds, to show the path.
	
	

	 * @param value The value.
	 */
	public final void writeTrailTimeProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openTrailTimeProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>trailTime</code> property as a <code>number</code> value.  The <code>trailTime</code> property specifies the time behind the animation time, in seconds, to show the path.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeTrailTimeProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openTrailTimeProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>trailTime</code> property as a <code>reference</code> value.  The <code>trailTime</code> property specifies the time behind the animation time, in seconds, to show the path.
	
	

	 * @param value The reference.
	 */
	public final void writeTrailTimePropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openTrailTimeProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>trailTime</code> property as a <code>reference</code> value.  The <code>trailTime</code> property specifies the time behind the animation time, in seconds, to show the path.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeTrailTimePropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openTrailTimeProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>trailTime</code> property as a <code>reference</code> value.  The <code>trailTime</code> property specifies the time behind the animation time, in seconds, to show the path.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeTrailTimePropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openTrailTimeProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>trailTime</code> property as a <code>reference</code> value.  The <code>trailTime</code> property specifies the time behind the animation time, in seconds, to show the path.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The heirarchy of properties to be indexed on the referenced object.
	 */
	public final void writeTrailTimePropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openTrailTimeProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}