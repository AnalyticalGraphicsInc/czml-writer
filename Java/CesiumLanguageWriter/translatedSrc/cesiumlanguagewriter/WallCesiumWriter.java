package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.DoubleListCesiumWriter;
import cesiumlanguagewriter.MaterialCesiumWriter;
import cesiumlanguagewriter.PositionListCesiumWriter;
import java.awt.Color;
import java.util.List;

/**
 *  
 Writes a <code>Wall</code> to a  {@link CesiumOutputStream}.  A <code>Wall</code> is a two dimensional wall defined as a line strip and optional maximum and minimum heights, which conforms to the curvature of the globe and can be placed along the surface or at altitude.
 

 */
public class WallCesiumWriter extends CesiumPropertyWriter<WallCesiumWriter> {
	/**
	 *  
	The name of the <code>show</code> property.
	

	 */
	public static final String ShowPropertyName = "show";
	/**
	 *  
	The name of the <code>positions</code> property.
	

	 */
	public static final String PositionsPropertyName = "positions";
	/**
	 *  
	The name of the <code>minimumHeights</code> property.
	

	 */
	public static final String MinimumHeightsPropertyName = "minimumHeights";
	/**
	 *  
	The name of the <code>maximumHeights</code> property.
	

	 */
	public static final String MaximumHeightsPropertyName = "maximumHeights";
	/**
	 *  
	The name of the <code>granularity</code> property.
	

	 */
	public static final String GranularityPropertyName = "granularity";
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
	The name of the <code>outlineWidth</code> property.
	

	 */
	public static final String OutlineWidthPropertyName = "outlineWidth";
	private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(ShowPropertyName);
		}
	}, false);
	private Lazy<PositionListCesiumWriter> m_positions = new Lazy<cesiumlanguagewriter.PositionListCesiumWriter>(new Func1<cesiumlanguagewriter.PositionListCesiumWriter>() {
		public cesiumlanguagewriter.PositionListCesiumWriter invoke() {
			return new PositionListCesiumWriter(PositionsPropertyName);
		}
	}, false);
	private Lazy<DoubleListCesiumWriter> m_minimumHeights = new Lazy<cesiumlanguagewriter.DoubleListCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleListCesiumWriter>() {
		public cesiumlanguagewriter.DoubleListCesiumWriter invoke() {
			return new DoubleListCesiumWriter(MinimumHeightsPropertyName);
		}
	}, false);
	private Lazy<DoubleListCesiumWriter> m_maximumHeights = new Lazy<cesiumlanguagewriter.DoubleListCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleListCesiumWriter>() {
		public cesiumlanguagewriter.DoubleListCesiumWriter invoke() {
			return new DoubleListCesiumWriter(MaximumHeightsPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_granularity = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(GranularityPropertyName);
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
	private Lazy<DoubleCesiumWriter> m_outlineWidth = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(OutlineWidthPropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public WallCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected WallCesiumWriter(WallCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public WallCesiumWriter clone() {
		return new WallCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>show</code> property defines whether or not the wall is shown.  If not specified, the default value is <see langword="true" />.
	

	 */
	public final BooleanCesiumWriter getShowWriter() {
		return m_show.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the wall is shown.  If not specified, the default value is <see langword="true" />.
	

	 */
	public final BooleanCesiumWriter openShowProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the wall is shown.  If not specified, the default value is <see langword="true" />.
	
	

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
	 *  
	Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the wall is shown.  If not specified, the default value is <see langword="true" />.
	
	

	 * @param value The reference.
	 */
	public final void writeShowPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the wall is shown.  If not specified, the default value is <see langword="true" />.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeShowPropertyReference(String value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the wall is shown.  If not specified, the default value is <see langword="true" />.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeShowPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the wall is shown.  If not specified, the default value is <see langword="true" />.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeShowPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>positions</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>positions</code> property defines the array of positions defining the centerline of the wall.
	

	 */
	public final PositionListCesiumWriter getPositionsWriter() {
		return m_positions.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>positions</code> property.  The <code>positions</code> property defines the array of positions defining the centerline of the wall.
	

	 */
	public final PositionListCesiumWriter openPositionsProperty() {
		openIntervalIfNecessary();
		return this.<PositionListCesiumWriter> openAndReturn(getPositionsWriter());
	}

	/**
	 *  
	Writes a value for the <code>positions</code> property as a <code>cartesian</code> value.  The <code>positions</code> property specifies the array of positions defining the centerline of the wall.
	
	

	 * @param values The values.
	 */
	public final void writePositionsProperty(Iterable<Cartesian> values) {
		{
			cesiumlanguagewriter.PositionListCesiumWriter writer = openPositionsProperty();
			try {
				writer.writeCartesian(values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>positions</code> property as a <code>cartographicRadians</code> value.  The <code>positions</code> property specifies the array of positions defining the centerline of the wall.
	
	

	 * @param values The values.
	 */
	public final void writePositionsPropertyCartographicRadians(Iterable<Cartographic> values) {
		{
			cesiumlanguagewriter.PositionListCesiumWriter writer = openPositionsProperty();
			try {
				writer.writeCartographicRadians(values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>positions</code> property as a <code>cartographicDegrees</code> value.  The <code>positions</code> property specifies the array of positions defining the centerline of the wall.
	
	

	 * @param values The values.
	 */
	public final void writePositionsPropertyCartographicDegrees(Iterable<Cartographic> values) {
		{
			cesiumlanguagewriter.PositionListCesiumWriter writer = openPositionsProperty();
			try {
				writer.writeCartographicDegrees(values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>positions</code> property as a <code>references</code> value.  The <code>positions</code> property specifies the array of positions defining the centerline of the wall.
	
	

	 * @param references The list of references.
	 */
	public final void writePositionsPropertyReferences(Iterable<Reference> references) {
		{
			cesiumlanguagewriter.PositionListCesiumWriter writer = openPositionsProperty();
			try {
				writer.writeReferences(references);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>minimumHeights</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>minimumHeights</code> property defines the list of heights to be used for the bottom of the wall, instead of the surface.
	

	 */
	public final DoubleListCesiumWriter getMinimumHeightsWriter() {
		return m_minimumHeights.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>minimumHeights</code> property.  The <code>minimumHeights</code> property defines the list of heights to be used for the bottom of the wall, instead of the surface.
	

	 */
	public final DoubleListCesiumWriter openMinimumHeightsProperty() {
		openIntervalIfNecessary();
		return this.<DoubleListCesiumWriter> openAndReturn(getMinimumHeightsWriter());
	}

	/**
	 *  
	Writes a value for the <code>minimumHeights</code> property as a <code>array</code> value.  The <code>minimumHeights</code> property specifies the list of heights to be used for the bottom of the wall, instead of the surface.
	
	

	 * @param values The values.
	 */
	public final void writeMinimumHeightsProperty(Iterable<Double> values) {
		{
			cesiumlanguagewriter.DoubleListCesiumWriter writer = openMinimumHeightsProperty();
			try {
				writer.writeArray(values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>minimumHeights</code> property as a <code>references</code> value.  The <code>minimumHeights</code> property specifies the list of heights to be used for the bottom of the wall, instead of the surface.
	
	

	 * @param references The list of references.
	 */
	public final void writeMinimumHeightsPropertyReferences(Iterable<Reference> references) {
		{
			cesiumlanguagewriter.DoubleListCesiumWriter writer = openMinimumHeightsProperty();
			try {
				writer.writeReferences(references);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>maximumHeights</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>maximumHeights</code> property defines the list of heights to be used for the top of the wall, instead of the height of each position.
	

	 */
	public final DoubleListCesiumWriter getMaximumHeightsWriter() {
		return m_maximumHeights.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>maximumHeights</code> property.  The <code>maximumHeights</code> property defines the list of heights to be used for the top of the wall, instead of the height of each position.
	

	 */
	public final DoubleListCesiumWriter openMaximumHeightsProperty() {
		openIntervalIfNecessary();
		return this.<DoubleListCesiumWriter> openAndReturn(getMaximumHeightsWriter());
	}

	/**
	 *  
	Writes a value for the <code>maximumHeights</code> property as a <code>array</code> value.  The <code>maximumHeights</code> property specifies the list of heights to be used for the top of the wall, instead of the height of each position.
	
	

	 * @param values The values.
	 */
	public final void writeMaximumHeightsProperty(Iterable<Double> values) {
		{
			cesiumlanguagewriter.DoubleListCesiumWriter writer = openMaximumHeightsProperty();
			try {
				writer.writeArray(values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>maximumHeights</code> property as a <code>references</code> value.  The <code>maximumHeights</code> property specifies the list of heights to be used for the top of the wall, instead of the height of each position.
	
	

	 * @param references The list of references.
	 */
	public final void writeMaximumHeightsPropertyReferences(Iterable<Reference> references) {
		{
			cesiumlanguagewriter.DoubleListCesiumWriter writer = openMaximumHeightsProperty();
			try {
				writer.writeReferences(references);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>granularity</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>granularity</code> property defines the sampling distance, in radians.
	

	 */
	public final DoubleCesiumWriter getGranularityWriter() {
		return m_granularity.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>granularity</code> property.  The <code>granularity</code> property defines the sampling distance, in radians.
	

	 */
	public final DoubleCesiumWriter openGranularityProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getGranularityWriter());
	}

	/**
	 *  
	Writes a value for the <code>granularity</code> property as a <code>number</code> value.  The <code>granularity</code> property specifies the sampling distance, in radians.
	
	

	 * @param value The value.
	 */
	public final void writeGranularityProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openGranularityProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>granularity</code> property as a <code>number</code> value.  The <code>granularity</code> property specifies the sampling distance, in radians.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeGranularityProperty(List<JulianDate> dates, List<Double> values) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openGranularityProperty();
			try {
				writer.writeNumber(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>granularity</code> property as a <code>number</code> value.  The <code>granularity</code> property specifies the sampling distance, in radians.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeGranularityProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openGranularityProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>granularity</code> property as a <code>reference</code> value.  The <code>granularity</code> property specifies the sampling distance, in radians.
	
	

	 * @param value The reference.
	 */
	public final void writeGranularityPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openGranularityProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>granularity</code> property as a <code>reference</code> value.  The <code>granularity</code> property specifies the sampling distance, in radians.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeGranularityPropertyReference(String value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openGranularityProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>granularity</code> property as a <code>reference</code> value.  The <code>granularity</code> property specifies the sampling distance, in radians.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeGranularityPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openGranularityProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>granularity</code> property as a <code>reference</code> value.  The <code>granularity</code> property specifies the sampling distance, in radians.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeGranularityPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openGranularityProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>fill</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>fill</code> property defines whether or not the wall is filled.  If not specified, the default value is <see langword="true" />.
	

	 */
	public final BooleanCesiumWriter getFillWriter() {
		return m_fill.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>fill</code> property.  The <code>fill</code> property defines whether or not the wall is filled.  If not specified, the default value is <see langword="true" />.
	

	 */
	public final BooleanCesiumWriter openFillProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getFillWriter());
	}

	/**
	 *  
	Writes a value for the <code>fill</code> property as a <code>boolean</code> value.  The <code>fill</code> property specifies whether or not the wall is filled.  If not specified, the default value is <see langword="true" />.
	
	

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
	 *  
	Writes a value for the <code>fill</code> property as a <code>reference</code> value.  The <code>fill</code> property specifies whether or not the wall is filled.  If not specified, the default value is <see langword="true" />.
	
	

	 * @param value The reference.
	 */
	public final void writeFillPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openFillProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>fill</code> property as a <code>reference</code> value.  The <code>fill</code> property specifies whether or not the wall is filled.  If not specified, the default value is <see langword="true" />.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeFillPropertyReference(String value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openFillProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>fill</code> property as a <code>reference</code> value.  The <code>fill</code> property specifies whether or not the wall is filled.  If not specified, the default value is <see langword="true" />.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeFillPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openFillProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>fill</code> property as a <code>reference</code> value.  The <code>fill</code> property specifies whether or not the wall is filled.  If not specified, the default value is <see langword="true" />.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeFillPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openFillProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>material</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>material</code> property defines the material to display on the surface of the wall.
	

	 */
	public final MaterialCesiumWriter getMaterialWriter() {
		return m_material.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>material</code> property.  The <code>material</code> property defines the material to display on the surface of the wall.
	

	 */
	public final MaterialCesiumWriter openMaterialProperty() {
		openIntervalIfNecessary();
		return this.<MaterialCesiumWriter> openAndReturn(getMaterialWriter());
	}

	/**
	 *  Gets the writer for the <code>outline</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>outline</code> property defines whether or not the wall is outlined.  If not specified, the default value is <see langword="false" />.
	

	 */
	public final BooleanCesiumWriter getOutlineWriter() {
		return m_outline.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>outline</code> property.  The <code>outline</code> property defines whether or not the wall is outlined.  If not specified, the default value is <see langword="false" />.
	

	 */
	public final BooleanCesiumWriter openOutlineProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getOutlineWriter());
	}

	/**
	 *  
	Writes a value for the <code>outline</code> property as a <code>boolean</code> value.  The <code>outline</code> property specifies whether or not the wall is outlined.  If not specified, the default value is <see langword="false" />.
	
	

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
	 *  
	Writes a value for the <code>outline</code> property as a <code>reference</code> value.  The <code>outline</code> property specifies whether or not the wall is outlined.  If not specified, the default value is <see langword="false" />.
	
	

	 * @param value The reference.
	 */
	public final void writeOutlinePropertyReference(Reference value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openOutlineProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outline</code> property as a <code>reference</code> value.  The <code>outline</code> property specifies whether or not the wall is outlined.  If not specified, the default value is <see langword="false" />.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeOutlinePropertyReference(String value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openOutlineProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outline</code> property as a <code>reference</code> value.  The <code>outline</code> property specifies whether or not the wall is outlined.  If not specified, the default value is <see langword="false" />.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeOutlinePropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openOutlineProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outline</code> property as a <code>reference</code> value.  The <code>outline</code> property specifies whether or not the wall is outlined.  If not specified, the default value is <see langword="false" />.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeOutlinePropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openOutlineProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>outlineColor</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>outlineColor</code> property defines the color of the wall outline.
	

	 */
	public final ColorCesiumWriter getOutlineColorWriter() {
		return m_outlineColor.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>outlineColor</code> property.  The <code>outlineColor</code> property defines the color of the wall outline.
	

	 */
	public final ColorCesiumWriter openOutlineColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getOutlineColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the wall outline.
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the wall outline.
	
	
	
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the wall outline.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeOutlineColorProperty(List<JulianDate> dates, List<Color> values) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgba(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgba</code> value.  The <code>outlineColor</code> property specifies the color of the wall outline.
	
	
	
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the wall outline.
	
	

	 * @param color The color.
	 */
	public final void writeOutlineColorPropertyRgbaf(Color color) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgbaf(color);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the wall outline.
	
	
	
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the wall outline.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeOutlineColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgbaf(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>rgbaf</code> value.  The <code>outlineColor</code> property specifies the color of the wall outline.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param colors The color corresponding to each date.
	 * @param startIndex The index of the first element to use in the `colors` collection.
	 * @param length The number of elements to use from the `colors` collection.
	 */
	public final void writeOutlineColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
		{
			cesiumlanguagewriter.ColorCesiumWriter writer = openOutlineColorProperty();
			try {
				writer.writeRgbaf(dates, colors, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the wall outline.
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the wall outline.
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the wall outline.
	
	
	

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
	Writes a value for the <code>outlineColor</code> property as a <code>reference</code> value.  The <code>outlineColor</code> property specifies the color of the wall outline.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
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
	 *  Gets the writer for the <code>outlineWidth</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>outlineWidth</code> property defines the width of the wall outline.  If not specified, the default value is 1.0.
	

	 */
	public final DoubleCesiumWriter getOutlineWidthWriter() {
		return m_outlineWidth.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>outlineWidth</code> property.  The <code>outlineWidth</code> property defines the width of the wall outline.  If not specified, the default value is 1.0.
	

	 */
	public final DoubleCesiumWriter openOutlineWidthProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getOutlineWidthWriter());
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the wall outline.  If not specified, the default value is 1.0.
	
	

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
	Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the wall outline.  If not specified, the default value is 1.0.
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeOutlineWidthProperty(List<JulianDate> dates, List<Double> values) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openOutlineWidthProperty();
			try {
				writer.writeNumber(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>outlineWidth</code> property as a <code>number</code> value.  The <code>outlineWidth</code> property specifies the width of the wall outline.  If not specified, the default value is 1.0.
	
	
	
	
	

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
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the wall outline.  If not specified, the default value is 1.0.
	
	

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
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the wall outline.  If not specified, the default value is 1.0.
	
	

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
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the wall outline.  If not specified, the default value is 1.0.
	
	
	

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
	Writes a value for the <code>outlineWidth</code> property as a <code>reference</code> value.  The <code>outlineWidth</code> property specifies the width of the wall outline.  If not specified, the default value is 1.0.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
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
}