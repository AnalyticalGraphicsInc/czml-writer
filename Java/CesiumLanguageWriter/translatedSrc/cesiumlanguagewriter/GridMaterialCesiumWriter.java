package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import java.awt.Color;
import java.util.List;

/**
 *  
 Writes a <code>GridMaterial</code> to a  {@link CesiumOutputStream}.  A <code>GridMaterial</code> fills the surface with a two dimensional grid.
 

 */
public class GridMaterialCesiumWriter extends CesiumPropertyWriter<GridMaterialCesiumWriter> {
	/**
	 *  
	The name of the <code>color</code> property.
	

	 */
	public static final String ColorPropertyName = "color";
	/**
	 *  
	The name of the <code>cellAlpha</code> property.
	

	 */
	public static final String CellAlphaPropertyName = "cellAlpha";
	/**
	 *  
	The name of the <code>rowCount</code> property.
	

	 */
	public static final String RowCountPropertyName = "rowCount";
	/**
	 *  
	The name of the <code>columnCount</code> property.
	

	 */
	public static final String ColumnCountPropertyName = "columnCount";
	/**
	 *  
	The name of the <code>rowThickness</code> property.
	

	 */
	public static final String RowThicknessPropertyName = "rowThickness";
	/**
	 *  
	The name of the <code>columnThickness</code> property.
	

	 */
	public static final String ColumnThicknessPropertyName = "columnThickness";
	/**
	 *  
	The name of the <code>rowOffset</code> property.
	

	 */
	public static final String RowOffsetPropertyName = "rowOffset";
	/**
	 *  
	The name of the <code>columnOffset</code> property.
	

	 */
	public static final String ColumnOffsetPropertyName = "columnOffset";
	private Lazy<ColorCesiumWriter> m_color = new Lazy<cesiumlanguagewriter.ColorCesiumWriter>(new Func1<cesiumlanguagewriter.ColorCesiumWriter>() {
		public cesiumlanguagewriter.ColorCesiumWriter invoke() {
			return new ColorCesiumWriter(ColorPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_cellAlpha = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(CellAlphaPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_rowCount = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(RowCountPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_columnCount = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(ColumnCountPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_rowThickness = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(RowThicknessPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_columnThickness = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(ColumnThicknessPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_rowOffset = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(RowOffsetPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_columnOffset = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(ColumnOffsetPropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public GridMaterialCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected GridMaterialCesiumWriter(GridMaterialCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public GridMaterialCesiumWriter clone() {
		return new GridMaterialCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>color</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>color</code> property defines the color of the surface.
	

	 */
	public final ColorCesiumWriter getColorWriter() {
		return m_color.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>color</code> property.  The <code>color</code> property defines the color of the surface.
	

	 */
	public final ColorCesiumWriter openColorProperty() {
		openIntervalIfNecessary();
		return this.<ColorCesiumWriter> openAndReturn(getColorWriter());
	}

	/**
	 *  
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the surface.
	
	

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
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the surface.
	
	
	
	
	

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
	Writes a value for the <code>color</code> property as a <code>rgba</code> value.  The <code>color</code> property specifies the color of the surface.
	
	
	
	
	

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
	Writes a value for the <code>color</code> property as a <code>rgbaf</code> value.  The <code>color</code> property specifies the color of the surface.
	
	
	
	
	

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
	 *  Gets the writer for the <code>cellAlpha</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>cellAlpha</code> property defines alpha value for the space between grid lines.  This will be combined with the color alpha.
	

	 */
	public final DoubleCesiumWriter getCellAlphaWriter() {
		return m_cellAlpha.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>cellAlpha</code> property.  The <code>cellAlpha</code> property defines alpha value for the space between grid lines.  This will be combined with the color alpha.
	

	 */
	public final DoubleCesiumWriter openCellAlphaProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getCellAlphaWriter());
	}

	/**
	 *  
	Writes a value for the <code>cellAlpha</code> property as a <code>number</code> value.  The <code>cellAlpha</code> property specifies alpha value for the space between grid lines.  This will be combined with the color alpha.
	
	

	 * @param value The value.
	 */
	public final void writeCellAlphaProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openCellAlphaProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>cellAlpha</code> property as a <code>number</code> value.  The <code>cellAlpha</code> property specifies alpha value for the space between grid lines.  This will be combined with the color alpha.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeCellAlphaProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openCellAlphaProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>rowCount</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>rowCount</code> property defines the number of horizontal grid lines.
	

	 */
	public final DoubleCesiumWriter getRowCountWriter() {
		return m_rowCount.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>rowCount</code> property.  The <code>rowCount</code> property defines the number of horizontal grid lines.
	

	 */
	public final DoubleCesiumWriter openRowCountProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getRowCountWriter());
	}

	/**
	 *  
	Writes a value for the <code>rowCount</code> property as a <code>number</code> value.  The <code>rowCount</code> property specifies the number of horizontal grid lines.
	
	

	 * @param value The value.
	 */
	public final void writeRowCountProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRowCountProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>rowCount</code> property as a <code>number</code> value.  The <code>rowCount</code> property specifies the number of horizontal grid lines.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeRowCountProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRowCountProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>columnCount</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>columnCount</code> property defines the number of vertical grid lines.
	

	 */
	public final DoubleCesiumWriter getColumnCountWriter() {
		return m_columnCount.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>columnCount</code> property.  The <code>columnCount</code> property defines the number of vertical grid lines.
	

	 */
	public final DoubleCesiumWriter openColumnCountProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getColumnCountWriter());
	}

	/**
	 *  
	Writes a value for the <code>columnCount</code> property as a <code>number</code> value.  The <code>columnCount</code> property specifies the number of vertical grid lines.
	
	

	 * @param value The value.
	 */
	public final void writeColumnCountProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openColumnCountProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>columnCount</code> property as a <code>number</code> value.  The <code>columnCount</code> property specifies the number of vertical grid lines.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeColumnCountProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openColumnCountProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>rowThickness</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>rowThickness</code> property defines the thickness of horizontal grid lines, in pixels.
	

	 */
	public final DoubleCesiumWriter getRowThicknessWriter() {
		return m_rowThickness.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>rowThickness</code> property.  The <code>rowThickness</code> property defines the thickness of horizontal grid lines, in pixels.
	

	 */
	public final DoubleCesiumWriter openRowThicknessProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getRowThicknessWriter());
	}

	/**
	 *  
	Writes a value for the <code>rowThickness</code> property as a <code>number</code> value.  The <code>rowThickness</code> property specifies the thickness of horizontal grid lines, in pixels.
	
	

	 * @param value The value.
	 */
	public final void writeRowThicknessProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRowThicknessProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>rowThickness</code> property as a <code>number</code> value.  The <code>rowThickness</code> property specifies the thickness of horizontal grid lines, in pixels.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeRowThicknessProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRowThicknessProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>columnThickness</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>columnThickness</code> property defines the thickness of vertical grid lines, in pixels.
	

	 */
	public final DoubleCesiumWriter getColumnThicknessWriter() {
		return m_columnThickness.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>columnThickness</code> property.  The <code>columnThickness</code> property defines the thickness of vertical grid lines, in pixels.
	

	 */
	public final DoubleCesiumWriter openColumnThicknessProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getColumnThicknessWriter());
	}

	/**
	 *  
	Writes a value for the <code>columnThickness</code> property as a <code>number</code> value.  The <code>columnThickness</code> property specifies the thickness of vertical grid lines, in pixels.
	
	

	 * @param value The value.
	 */
	public final void writeColumnThicknessProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openColumnThicknessProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>columnThickness</code> property as a <code>number</code> value.  The <code>columnThickness</code> property specifies the thickness of vertical grid lines, in pixels.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeColumnThicknessProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openColumnThicknessProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>rowOffset</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>rowOffset</code> property defines the offset of horizontal grid lines, as a percentage from 0 to 1.
	

	 */
	public final DoubleCesiumWriter getRowOffsetWriter() {
		return m_rowOffset.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>rowOffset</code> property.  The <code>rowOffset</code> property defines the offset of horizontal grid lines, as a percentage from 0 to 1.
	

	 */
	public final DoubleCesiumWriter openRowOffsetProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getRowOffsetWriter());
	}

	/**
	 *  
	Writes a value for the <code>rowOffset</code> property as a <code>number</code> value.  The <code>rowOffset</code> property specifies the offset of horizontal grid lines, as a percentage from 0 to 1.
	
	

	 * @param value The value.
	 */
	public final void writeRowOffsetProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRowOffsetProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>rowOffset</code> property as a <code>number</code> value.  The <code>rowOffset</code> property specifies the offset of horizontal grid lines, as a percentage from 0 to 1.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeRowOffsetProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openRowOffsetProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>columnOffset</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>columnOffset</code> property defines the offset of vertical grid lines, as a percentage from 0 to 1.
	

	 */
	public final DoubleCesiumWriter getColumnOffsetWriter() {
		return m_columnOffset.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>columnOffset</code> property.  The <code>columnOffset</code> property defines the offset of vertical grid lines, as a percentage from 0 to 1.
	

	 */
	public final DoubleCesiumWriter openColumnOffsetProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getColumnOffsetWriter());
	}

	/**
	 *  
	Writes a value for the <code>columnOffset</code> property as a <code>number</code> value.  The <code>columnOffset</code> property specifies the offset of vertical grid lines, as a percentage from 0 to 1.
	
	

	 * @param value The value.
	 */
	public final void writeColumnOffsetProperty(double value) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openColumnOffsetProperty();
			try {
				writer.writeNumber(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>columnOffset</code> property as a <code>number</code> value.  The <code>columnOffset</code> property specifies the offset of vertical grid lines, as a percentage from 0 to 1.
	
	
	
	
	

	 * @param dates The dates at which the value is specified.
	 * @param values The value corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeColumnOffsetProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.DoubleCesiumWriter writer = openColumnOffsetProperty();
			try {
				writer.writeNumber(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}