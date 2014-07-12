package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.PolylineMaterialCesiumWriter;
import cesiumlanguagewriter.PositionListCesiumWriter;
import java.util.List;

/**
 *  
 Writes a <code>Polyline</code> to a  {@link CesiumOutputStream}.  A <code>Polyline</code> a polyline, which is a line in the scene composed of multiple segments.
 

 */
public class PolylineCesiumWriter extends CesiumPropertyWriter<PolylineCesiumWriter> {
	/**
	 *  
	The name of the <code>positions</code> property.
	

	 */
	public static final String PositionsPropertyName = "positions";
	/**
	 *  
	The name of the <code>show</code> property.
	

	 */
	public static final String ShowPropertyName = "show";
	/**
	 *  
	The name of the <code>material</code> property.
	

	 */
	public static final String MaterialPropertyName = "material";
	/**
	 *  
	The name of the <code>width</code> property.
	

	 */
	public static final String WidthPropertyName = "width";
	/**
	 *  
	The name of the <code>followSurface</code> property.
	

	 */
	public static final String FollowSurfacePropertyName = "followSurface";
	private Lazy<PositionListCesiumWriter> m_positions = new Lazy<cesiumlanguagewriter.PositionListCesiumWriter>(new Func1<cesiumlanguagewriter.PositionListCesiumWriter>() {
		public cesiumlanguagewriter.PositionListCesiumWriter invoke() {
			return new PositionListCesiumWriter(PositionsPropertyName);
		}
	}, false);
	private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(ShowPropertyName);
		}
	}, false);
	private Lazy<PolylineMaterialCesiumWriter> m_material = new Lazy<cesiumlanguagewriter.PolylineMaterialCesiumWriter>(new Func1<cesiumlanguagewriter.PolylineMaterialCesiumWriter>() {
		public cesiumlanguagewriter.PolylineMaterialCesiumWriter invoke() {
			return new PolylineMaterialCesiumWriter(MaterialPropertyName);
		}
	}, false);
	private Lazy<DoubleCesiumWriter> m_width = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
		public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
			return new DoubleCesiumWriter(WidthPropertyName);
		}
	}, false);
	private Lazy<BooleanCesiumWriter> m_followSurface = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
		public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
			return new BooleanCesiumWriter(FollowSurfacePropertyName);
		}
	}, false);

	/**
	 *  
	Initializes a new instance.
	

	 */
	public PolylineCesiumWriter(String propertyName) {
		super(propertyName);
	}

	/**
	 *  
	Initializes a new instance as a copy of an existing instance.
	
	

	 * @param existingInstance The existing instance to copy.
	 */
	protected PolylineCesiumWriter(PolylineCesiumWriter existingInstance) {
		super(existingInstance);
	}

	@Override
	public PolylineCesiumWriter clone() {
		return new PolylineCesiumWriter(this);
	}

	/**
	 *  Gets the writer for the <code>positions</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>positions</code> property defines the array of positions defining the polyline as a line strip.
	

	 */
	public final PositionListCesiumWriter getPositionsWriter() {
		return m_positions.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>positions</code> property.  The <code>positions</code> property defines the array of positions defining the polyline as a line strip.
	

	 */
	public final PositionListCesiumWriter openPositionsProperty() {
		openIntervalIfNecessary();
		return this.<PositionListCesiumWriter> openAndReturn(getPositionsWriter());
	}

	/**
	 *  
	Writes a value for the <code>positions</code> property as a <code>cartesian</code> value.  The <code>positions</code> property specifies the array of positions defining the polyline as a line strip.
	
	

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
	Writes a value for the <code>positions</code> property as a <code>cartographicRadians</code> value.  The <code>positions</code> property specifies the array of positions defining the polyline as a line strip.
	
	

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
	Writes a value for the <code>positions</code> property as a <code>cartographicDegrees</code> value.  The <code>positions</code> property specifies the array of positions defining the polyline as a line strip.
	
	

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
	Writes a value for the <code>positions</code> property as a <code>references</code> value.  The <code>positions</code> property specifies the array of positions defining the polyline as a line strip.
	
	

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
	 *  Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>show</code> property defines whether or not the polyline is shown.
	

	 */
	public final BooleanCesiumWriter getShowWriter() {
		return m_show.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the polyline is shown.
	

	 */
	public final BooleanCesiumWriter openShowProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
	}

	/**
	 *  
	Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the polyline is shown.
	
	

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
	 *  Gets the writer for the <code>material</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>material</code> property defines the material to use to draw the polyline.
	

	 */
	public final PolylineMaterialCesiumWriter getMaterialWriter() {
		return m_material.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>material</code> property.  The <code>material</code> property defines the material to use to draw the polyline.
	

	 */
	public final PolylineMaterialCesiumWriter openMaterialProperty() {
		openIntervalIfNecessary();
		return this.<PolylineMaterialCesiumWriter> openAndReturn(getMaterialWriter());
	}

	/**
	 *  Gets the writer for the <code>width</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>width</code> property defines the width of the polyline.
	

	 */
	public final DoubleCesiumWriter getWidthWriter() {
		return m_width.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>width</code> property.  The <code>width</code> property defines the width of the polyline.
	

	 */
	public final DoubleCesiumWriter openWidthProperty() {
		openIntervalIfNecessary();
		return this.<DoubleCesiumWriter> openAndReturn(getWidthWriter());
	}

	/**
	 *  
	Writes a value for the <code>width</code> property as a <code>number</code> value.  The <code>width</code> property specifies the width of the polyline.
	
	

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
	Writes a value for the <code>width</code> property as a <code>number</code> value.  The <code>width</code> property specifies the width of the polyline.
	
	
	
	
	

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
	Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the polyline.
	
	

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
	Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the polyline.
	
	

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
	Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the polyline.
	
	
	

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
	Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the polyline.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
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
	 *  Gets the writer for the <code>followSurface</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>followSurface</code> property defines whether or not the positions are connected as great arcs (the default) or as straight lines.
	

	 */
	public final BooleanCesiumWriter getFollowSurfaceWriter() {
		return m_followSurface.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>followSurface</code> property.  The <code>followSurface</code> property defines whether or not the positions are connected as great arcs (the default) or as straight lines.
	

	 */
	public final BooleanCesiumWriter openFollowSurfaceProperty() {
		openIntervalIfNecessary();
		return this.<BooleanCesiumWriter> openAndReturn(getFollowSurfaceWriter());
	}

	/**
	 *  
	Writes a value for the <code>followSurface</code> property as a <code>boolean</code> value.  The <code>followSurface</code> property specifies whether or not the positions are connected as great arcs (the default) or as straight lines.
	
	

	 * @param value The value.
	 */
	public final void writeFollowSurfaceProperty(boolean value) {
		{
			cesiumlanguagewriter.BooleanCesiumWriter writer = openFollowSurfaceProperty();
			try {
				writer.writeBoolean(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}
}
