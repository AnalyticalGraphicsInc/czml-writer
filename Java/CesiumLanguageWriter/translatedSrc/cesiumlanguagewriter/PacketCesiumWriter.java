package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BillboardCesiumWriter;
import cesiumlanguagewriter.ClockCesiumWriter;
import cesiumlanguagewriter.ConeCesiumWriter;
import cesiumlanguagewriter.EllipseCesiumWriter;
import cesiumlanguagewriter.EllipsoidCesiumWriter;
import cesiumlanguagewriter.LabelCesiumWriter;
import cesiumlanguagewriter.ModelCesiumWriter;
import cesiumlanguagewriter.OrientationCesiumWriter;
import cesiumlanguagewriter.PathCesiumWriter;
import cesiumlanguagewriter.PointCesiumWriter;
import cesiumlanguagewriter.PolygonCesiumWriter;
import cesiumlanguagewriter.PolylineCesiumWriter;
import cesiumlanguagewriter.PositionCesiumWriter;
import cesiumlanguagewriter.PositionListCesiumWriter;
import cesiumlanguagewriter.PyramidCesiumWriter;
import cesiumlanguagewriter.StringCesiumWriter;
import cesiumlanguagewriter.VectorCesiumWriter;
import java.util.List;

/**
 *  
 Writes a <code>Packet</code> to a  {@link CesiumOutputStream}.  A <code>Packet</code> describes the graphical properties of a single object in a scene, such as a single aircraft.
 

 */
public class PacketCesiumWriter extends CesiumElementWriter {
	/**
	 *  
	The name of the <code>id</code> property.
	

	 */
	public static final String IdPropertyName = "id";
	/**
	 *  
	The name of the <code>name</code> property.
	

	 */
	public static final String NamePropertyName = "name";
	/**
	 *  
	The name of the <code>parent</code> property.
	

	 */
	public static final String ParentPropertyName = "parent";
	/**
	 *  
	The name of the <code>description</code> property.
	

	 */
	public static final String DescriptionPropertyName = "description";
	/**
	 *  
	The name of the <code>availability</code> property.
	

	 */
	public static final String AvailabilityPropertyName = "availability";
	/**
	 *  
	The name of the <code>position</code> property.
	

	 */
	public static final String PositionPropertyName = "position";
	/**
	 *  
	The name of the <code>billboard</code> property.
	

	 */
	public static final String BillboardPropertyName = "billboard";
	/**
	 *  
	The name of the <code>vertexPositions</code> property.
	

	 */
	public static final String VertexPositionsPropertyName = "vertexPositions";
	/**
	 *  
	The name of the <code>orientation</code> property.
	

	 */
	public static final String OrientationPropertyName = "orientation";
	/**
	 *  
	The name of the <code>point</code> property.
	

	 */
	public static final String PointPropertyName = "point";
	/**
	 *  
	The name of the <code>label</code> property.
	

	 */
	public static final String LabelPropertyName = "label";
	/**
	 *  
	The name of the <code>polyline</code> property.
	

	 */
	public static final String PolylinePropertyName = "polyline";
	/**
	 *  
	The name of the <code>path</code> property.
	

	 */
	public static final String PathPropertyName = "path";
	/**
	 *  
	The name of the <code>polygon</code> property.
	

	 */
	public static final String PolygonPropertyName = "polygon";
	/**
	 *  
	The name of the <code>cone</code> property.
	

	 */
	public static final String ConePropertyName = "cone";
	/**
	 *  
	The name of the <code>pyramid</code> property.
	

	 */
	public static final String PyramidPropertyName = "pyramid";
	/**
	 *  
	The name of the <code>ellipsoid</code> property.
	

	 */
	public static final String EllipsoidPropertyName = "ellipsoid";
	/**
	 *  
	The name of the <code>viewFrom</code> property.
	

	 */
	public static final String ViewFromPropertyName = "viewFrom";
	/**
	 *  
	The name of the <code>model</code> property.
	

	 */
	public static final String ModelPropertyName = "model";
	/**
	 *  
	The name of the <code>ellipse</code> property.
	

	 */
	public static final String EllipsePropertyName = "ellipse";
	/**
	 *  
	The name of the <code>clock</code> property.
	

	 */
	public static final String ClockPropertyName = "clock";
	/**
	 *  
	The name of the <code>vector</code> property.
	

	 */
	public static final String VectorPropertyName = "vector";
	private Lazy<StringCesiumWriter> m_description = new Lazy<cesiumlanguagewriter.StringCesiumWriter>(new Func1<cesiumlanguagewriter.StringCesiumWriter>() {
		public cesiumlanguagewriter.StringCesiumWriter invoke() {
			return new StringCesiumWriter(DescriptionPropertyName);
		}
	}, false);
	private Lazy<PositionCesiumWriter> m_position = new Lazy<cesiumlanguagewriter.PositionCesiumWriter>(new Func1<cesiumlanguagewriter.PositionCesiumWriter>() {
		public cesiumlanguagewriter.PositionCesiumWriter invoke() {
			return new PositionCesiumWriter(PositionPropertyName);
		}
	}, false);
	private Lazy<BillboardCesiumWriter> m_billboard = new Lazy<cesiumlanguagewriter.BillboardCesiumWriter>(new Func1<cesiumlanguagewriter.BillboardCesiumWriter>() {
		public cesiumlanguagewriter.BillboardCesiumWriter invoke() {
			return new BillboardCesiumWriter(BillboardPropertyName);
		}
	}, false);
	private Lazy<PositionListCesiumWriter> m_vertexPositions = new Lazy<cesiumlanguagewriter.PositionListCesiumWriter>(new Func1<cesiumlanguagewriter.PositionListCesiumWriter>() {
		public cesiumlanguagewriter.PositionListCesiumWriter invoke() {
			return new PositionListCesiumWriter(VertexPositionsPropertyName);
		}
	}, false);
	private Lazy<OrientationCesiumWriter> m_orientation = new Lazy<cesiumlanguagewriter.OrientationCesiumWriter>(new Func1<cesiumlanguagewriter.OrientationCesiumWriter>() {
		public cesiumlanguagewriter.OrientationCesiumWriter invoke() {
			return new OrientationCesiumWriter(OrientationPropertyName);
		}
	}, false);
	private Lazy<PointCesiumWriter> m_point = new Lazy<cesiumlanguagewriter.PointCesiumWriter>(new Func1<cesiumlanguagewriter.PointCesiumWriter>() {
		public cesiumlanguagewriter.PointCesiumWriter invoke() {
			return new PointCesiumWriter(PointPropertyName);
		}
	}, false);
	private Lazy<LabelCesiumWriter> m_label = new Lazy<cesiumlanguagewriter.LabelCesiumWriter>(new Func1<cesiumlanguagewriter.LabelCesiumWriter>() {
		public cesiumlanguagewriter.LabelCesiumWriter invoke() {
			return new LabelCesiumWriter(LabelPropertyName);
		}
	}, false);
	private Lazy<PolylineCesiumWriter> m_polyline = new Lazy<cesiumlanguagewriter.PolylineCesiumWriter>(new Func1<cesiumlanguagewriter.PolylineCesiumWriter>() {
		public cesiumlanguagewriter.PolylineCesiumWriter invoke() {
			return new PolylineCesiumWriter(PolylinePropertyName);
		}
	}, false);
	private Lazy<PathCesiumWriter> m_path = new Lazy<cesiumlanguagewriter.PathCesiumWriter>(new Func1<cesiumlanguagewriter.PathCesiumWriter>() {
		public cesiumlanguagewriter.PathCesiumWriter invoke() {
			return new PathCesiumWriter(PathPropertyName);
		}
	}, false);
	private Lazy<PolygonCesiumWriter> m_polygon = new Lazy<cesiumlanguagewriter.PolygonCesiumWriter>(new Func1<cesiumlanguagewriter.PolygonCesiumWriter>() {
		public cesiumlanguagewriter.PolygonCesiumWriter invoke() {
			return new PolygonCesiumWriter(PolygonPropertyName);
		}
	}, false);
	private Lazy<ConeCesiumWriter> m_cone = new Lazy<cesiumlanguagewriter.ConeCesiumWriter>(new Func1<cesiumlanguagewriter.ConeCesiumWriter>() {
		public cesiumlanguagewriter.ConeCesiumWriter invoke() {
			return new ConeCesiumWriter(ConePropertyName);
		}
	}, false);
	private Lazy<PyramidCesiumWriter> m_pyramid = new Lazy<cesiumlanguagewriter.PyramidCesiumWriter>(new Func1<cesiumlanguagewriter.PyramidCesiumWriter>() {
		public cesiumlanguagewriter.PyramidCesiumWriter invoke() {
			return new PyramidCesiumWriter(PyramidPropertyName);
		}
	}, false);
	private Lazy<EllipsoidCesiumWriter> m_ellipsoid = new Lazy<cesiumlanguagewriter.EllipsoidCesiumWriter>(new Func1<cesiumlanguagewriter.EllipsoidCesiumWriter>() {
		public cesiumlanguagewriter.EllipsoidCesiumWriter invoke() {
			return new EllipsoidCesiumWriter(EllipsoidPropertyName);
		}
	}, false);
	private Lazy<ModelCesiumWriter> m_model = new Lazy<cesiumlanguagewriter.ModelCesiumWriter>(new Func1<cesiumlanguagewriter.ModelCesiumWriter>() {
		public cesiumlanguagewriter.ModelCesiumWriter invoke() {
			return new ModelCesiumWriter(ModelPropertyName);
		}
	}, false);
	private Lazy<EllipseCesiumWriter> m_ellipse = new Lazy<cesiumlanguagewriter.EllipseCesiumWriter>(new Func1<cesiumlanguagewriter.EllipseCesiumWriter>() {
		public cesiumlanguagewriter.EllipseCesiumWriter invoke() {
			return new EllipseCesiumWriter(EllipsePropertyName);
		}
	}, false);
	private Lazy<ClockCesiumWriter> m_clock = new Lazy<cesiumlanguagewriter.ClockCesiumWriter>(new Func1<cesiumlanguagewriter.ClockCesiumWriter>() {
		public cesiumlanguagewriter.ClockCesiumWriter invoke() {
			return new ClockCesiumWriter(ClockPropertyName);
		}
	}, false);
	private Lazy<VectorCesiumWriter> m_vector = new Lazy<cesiumlanguagewriter.VectorCesiumWriter>(new Func1<cesiumlanguagewriter.VectorCesiumWriter>() {
		public cesiumlanguagewriter.VectorCesiumWriter invoke() {
			return new VectorCesiumWriter(VectorPropertyName);
		}
	}, false);

	/**
	 *  
	Writes the start of a new JSON object representing the packet.
	

	 */
	@Override
	protected void onOpen() {
		getOutput().writeStartObject();
	}

	/**
	 *  
	Writes the end of the JSON object representing the packet.
	

	 */
	@Override
	protected void onClose() {
		getOutput().writeEndObject();
	}

	/**
	 *  
	Writes the <code>id</code> property.  The <code>id</code> property specifies the ID of the object described by this packet.  IDs do not need to be GUIDs, but they do need to uniquely identify a single object within a CZML source and any other CZML sources loaded into the same scope.  If this property is not specified, the client will automatically generate a unique one.  However, this prevents later packets from referring to this object in order to, for example, add more data to it.
	
	

	 * @param value The value.
	 */
	public final void writeId(String value) {
		String PropertyName = IdPropertyName;
		getOutput().writePropertyName(PropertyName);
		getOutput().writeValue(value);
	}

	/**
	 *  
	Writes the <code>name</code> property.  The <code>name</code> property specifies the name of the object.  It does not have to be unique and is intended for user consumption.
	
	

	 * @param value The value.
	 */
	public final void writeName(String value) {
		String PropertyName = NamePropertyName;
		getOutput().writePropertyName(PropertyName);
		getOutput().writeValue(value);
	}

	/**
	 *  
	Writes the <code>parent</code> property.  The <code>parent</code> property specifies the ID of the parent object or folder.
	
	

	 * @param value The value.
	 */
	public final void writeParent(String value) {
		String PropertyName = ParentPropertyName;
		getOutput().writePropertyName(PropertyName);
		getOutput().writeValue(value);
	}

	/**
	 *  Gets the writer for the <code>description</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>description</code> property defines an HTML description of the object.
	

	 */
	public final StringCesiumWriter getDescriptionWriter() {
		return m_description.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>description</code> property.  The <code>description</code> property defines an HTML description of the object.
	

	 */
	public final StringCesiumWriter openDescriptionProperty() {
		return this.<StringCesiumWriter> openAndReturn(getDescriptionWriter());
	}

	/**
	 *  
	Writes a value for the <code>description</code> property as a <code>string</code> value.  The <code>description</code> property specifies an HTML description of the object.
	
	

	 * @param value The value.
	 */
	public final void writeDescriptionProperty(String value) {
		{
			cesiumlanguagewriter.StringCesiumWriter writer = openDescriptionProperty();
			try {
				writer.writeString(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>description</code> property as a <code>reference</code> value.  The <code>description</code> property specifies an HTML description of the object.
	
	

	 * @param value The reference.
	 */
	public final void writeDescriptionPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.StringCesiumWriter writer = openDescriptionProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>description</code> property as a <code>reference</code> value.  The <code>description</code> property specifies an HTML description of the object.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeDescriptionPropertyReference(String value) {
		{
			cesiumlanguagewriter.StringCesiumWriter writer = openDescriptionProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>description</code> property as a <code>reference</code> value.  The <code>description</code> property specifies an HTML description of the object.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeDescriptionPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.StringCesiumWriter writer = openDescriptionProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>description</code> property as a <code>reference</code> value.  The <code>description</code> property specifies an HTML description of the object.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeDescriptionPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.StringCesiumWriter writer = openDescriptionProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes the <code>availability</code> property.  The <code>availability</code> property specifies when data for an object is available. If data for an object is known to be available at the current animation time, but the client does not yet have that data (presumably because it will arrive in a later packet), the client will pause with a message like "Buffering..." while it waits to receive the data. The property can be a single string specifying a single interval, or an array of strings representing intervals.  A later Cesium packet can update this availability if it changes or is found to be incorrect. For example, an SGP4 propagator may report availability for all time, but then later the propagator throws an exception and the availability needs to be adjusted. If this optional property is not present, the object is assumed to be available for all time. Availability is scoped to a particular CZML stream, so two different streams can list different availability for a single object. Within a single stream, the last availability stated for an object is the one in effect and any availabilities in previous packets are ignored. If an object is available at a time, the client expects the object to have at least one property, and it expects all properties that it needs to be defined at that time. If the object doesn't have any properties, or a needed property is defined but not at the animation time, the client will pause animation and wait for more data.
	
	

	 * @param value The interval.
	 */
	public final void writeAvailability(TimeInterval value) {
		String PropertyName = AvailabilityPropertyName;
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeTimeInterval(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>availability</code> property.  The <code>availability</code> property specifies when data for an object is available. If data for an object is known to be available at the current animation time, but the client does not yet have that data (presumably because it will arrive in a later packet), the client will pause with a message like "Buffering..." while it waits to receive the data. The property can be a single string specifying a single interval, or an array of strings representing intervals.  A later Cesium packet can update this availability if it changes or is found to be incorrect. For example, an SGP4 propagator may report availability for all time, but then later the propagator throws an exception and the availability needs to be adjusted. If this optional property is not present, the object is assumed to be available for all time. Availability is scoped to a particular CZML stream, so two different streams can list different availability for a single object. Within a single stream, the last availability stated for an object is the one in effect and any availabilities in previous packets are ignored. If an object is available at a time, the client expects the object to have at least one property, and it expects all properties that it needs to be defined at that time. If the object doesn't have any properties, or a needed property is defined but not at the animation time, the client will pause animation and wait for more data.
	
	
	

	 * @param start The earliest date of the interval.
	 * @param stop The latest date of the interval.
	 */
	public final void writeAvailability(JulianDate start, JulianDate stop) {
		writeAvailability(new TimeInterval(start, stop));
	}

	/**
	 *  
	Writes the <code>availability</code> property.  The <code>availability</code> property specifies when data for an object is available. If data for an object is known to be available at the current animation time, but the client does not yet have that data (presumably because it will arrive in a later packet), the client will pause with a message like "Buffering..." while it waits to receive the data. The property can be a single string specifying a single interval, or an array of strings representing intervals.  A later Cesium packet can update this availability if it changes or is found to be incorrect. For example, an SGP4 propagator may report availability for all time, but then later the propagator throws an exception and the availability needs to be adjusted. If this optional property is not present, the object is assumed to be available for all time. Availability is scoped to a particular CZML stream, so two different streams can list different availability for a single object. Within a single stream, the last availability stated for an object is the one in effect and any availabilities in previous packets are ignored. If an object is available at a time, the client expects the object to have at least one property, and it expects all properties that it needs to be defined at that time. If the object doesn't have any properties, or a needed property is defined but not at the animation time, the client will pause animation and wait for more data.
	
	

	 * @param value The intervals.
	 */
	public final void writeAvailability(List<TimeInterval> value) {
		String PropertyName = AvailabilityPropertyName;
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeTimeIntervalCollection(getOutput(), value);
	}

	/**
	 *  Gets the writer for the <code>position</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>position</code> property defines the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	

	 */
	public final PositionCesiumWriter getPositionWriter() {
		return m_position.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>position</code> property.  The <code>position</code> property defines the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	

	 */
	public final PositionCesiumWriter openPositionProperty() {
		return this.<PositionCesiumWriter> openAndReturn(getPositionWriter());
	}

	/**
	 *  
	Writes a value for the <code>position</code> property as a <code>cartesian</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	
	

	 * @param value The value.
	 */
	public final void writePositionProperty(Cartesian value) {
		{
			cesiumlanguagewriter.PositionCesiumWriter writer = openPositionProperty();
			try {
				writer.writeCartesian(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>position</code> property as a <code>cartesian</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writePositionProperty(List<JulianDate> dates, List<Cartesian> values) {
		{
			cesiumlanguagewriter.PositionCesiumWriter writer = openPositionProperty();
			try {
				writer.writeCartesian(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>position</code> property as a <code>cartesian</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writePositionProperty(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.PositionCesiumWriter writer = openPositionProperty();
			try {
				writer.writeCartesian(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>position</code> property as a <code>cartographicRadians</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	
	

	 * @param value The interval.
	 */
	public final void writePositionPropertyCartographicRadians(Cartographic value) {
		{
			cesiumlanguagewriter.PositionCesiumWriter writer = openPositionProperty();
			try {
				writer.writeCartographicRadians(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>position</code> property as a <code>cartographicRadians</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	
	
	

	 * @param dates The dates at which the position is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writePositionPropertyCartographicRadians(List<JulianDate> dates, List<Cartographic> values) {
		{
			cesiumlanguagewriter.PositionCesiumWriter writer = openPositionProperty();
			try {
				writer.writeCartographicRadians(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>position</code> property as a <code>cartographicRadians</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The position corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writePositionPropertyCartographicRadians(List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.PositionCesiumWriter writer = openPositionProperty();
			try {
				writer.writeCartographicRadians(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>position</code> property as a <code>cartographicDegrees</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	
	

	 * @param value The interval.
	 */
	public final void writePositionPropertyCartographicDegrees(Cartographic value) {
		{
			cesiumlanguagewriter.PositionCesiumWriter writer = openPositionProperty();
			try {
				writer.writeCartographicDegrees(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>position</code> property as a <code>cartographicDegrees</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	
	
	

	 * @param dates The dates at which the position is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writePositionPropertyCartographicDegrees(List<JulianDate> dates, List<Cartographic> values) {
		{
			cesiumlanguagewriter.PositionCesiumWriter writer = openPositionProperty();
			try {
				writer.writeCartographicDegrees(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>position</code> property as a <code>cartographicDegrees</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The position corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writePositionPropertyCartographicDegrees(List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.PositionCesiumWriter writer = openPositionProperty();
			try {
				writer.writeCartographicDegrees(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>position</code> property as a <code>reference</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	
	

	 * @param value The reference.
	 */
	public final void writePositionPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.PositionCesiumWriter writer = openPositionProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>position</code> property as a <code>reference</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writePositionPropertyReference(String value) {
		{
			cesiumlanguagewriter.PositionCesiumWriter writer = openPositionProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>position</code> property as a <code>reference</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writePositionPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.PositionCesiumWriter writer = openPositionProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>position</code> property as a <code>reference</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writePositionPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.PositionCesiumWriter writer = openPositionProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>billboard</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>billboard</code> property defines a billboard, or viewport-aligned image. The billboard is positioned in the scene by the position property. A billboard is sometimes called a marker.
	

	 */
	public final BillboardCesiumWriter getBillboardWriter() {
		return m_billboard.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>billboard</code> property.  The <code>billboard</code> property defines a billboard, or viewport-aligned image. The billboard is positioned in the scene by the position property. A billboard is sometimes called a marker.
	

	 */
	public final BillboardCesiumWriter openBillboardProperty() {
		return this.<BillboardCesiumWriter> openAndReturn(getBillboardWriter());
	}

	/**
	 *  Gets the writer for the <code>vertexPositions</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>vertexPositions</code> property defines the world-space positions of vertices.  The vertex positions have no direct visual representation, but they are used to define polygons, polylines, and other objects attached to the object.
	

	 */
	public final PositionListCesiumWriter getVertexPositionsWriter() {
		return m_vertexPositions.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>vertexPositions</code> property.  The <code>vertexPositions</code> property defines the world-space positions of vertices.  The vertex positions have no direct visual representation, but they are used to define polygons, polylines, and other objects attached to the object.
	

	 */
	public final PositionListCesiumWriter openVertexPositionsProperty() {
		return this.<PositionListCesiumWriter> openAndReturn(getVertexPositionsWriter());
	}

	/**
	 *  
	Writes a value for the <code>vertexPositions</code> property as a <code>cartesian</code> value.  The <code>vertexPositions</code> property specifies the world-space positions of vertices.  The vertex positions have no direct visual representation, but they are used to define polygons, polylines, and other objects attached to the object.
	
	

	 * @param values The values.
	 */
	public final void writeVertexPositionsProperty(Iterable<Cartesian> values) {
		{
			cesiumlanguagewriter.PositionListCesiumWriter writer = openVertexPositionsProperty();
			try {
				writer.writeCartesian(values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>vertexPositions</code> property as a <code>cartographicRadians</code> value.  The <code>vertexPositions</code> property specifies the world-space positions of vertices.  The vertex positions have no direct visual representation, but they are used to define polygons, polylines, and other objects attached to the object.
	
	

	 * @param values The values.
	 */
	public final void writeVertexPositionsPropertyCartographicRadians(Iterable<Cartographic> values) {
		{
			cesiumlanguagewriter.PositionListCesiumWriter writer = openVertexPositionsProperty();
			try {
				writer.writeCartographicRadians(values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>vertexPositions</code> property as a <code>cartographicDegrees</code> value.  The <code>vertexPositions</code> property specifies the world-space positions of vertices.  The vertex positions have no direct visual representation, but they are used to define polygons, polylines, and other objects attached to the object.
	
	

	 * @param values The values.
	 */
	public final void writeVertexPositionsPropertyCartographicDegrees(Iterable<Cartographic> values) {
		{
			cesiumlanguagewriter.PositionListCesiumWriter writer = openVertexPositionsProperty();
			try {
				writer.writeCartographicDegrees(values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>vertexPositions</code> property as a <code>references</code> value.  The <code>vertexPositions</code> property specifies the world-space positions of vertices.  The vertex positions have no direct visual representation, but they are used to define polygons, polylines, and other objects attached to the object.
	
	

	 * @param references The list of references.
	 */
	public final void writeVertexPositionsPropertyReferences(Iterable<Reference> references) {
		{
			cesiumlanguagewriter.PositionListCesiumWriter writer = openVertexPositionsProperty();
			try {
				writer.writeReferences(references);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>orientation</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>orientation</code> property defines the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
	

	 */
	public final OrientationCesiumWriter getOrientationWriter() {
		return m_orientation.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>orientation</code> property.  The <code>orientation</code> property defines the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
	

	 */
	public final OrientationCesiumWriter openOrientationProperty() {
		return this.<OrientationCesiumWriter> openAndReturn(getOrientationWriter());
	}

	/**
	 *  
	Writes a value for the <code>orientation</code> property as a <code>unitQuaternion</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
	
	

	 * @param value The value.
	 */
	public final void writeOrientationProperty(UnitQuaternion value) {
		{
			cesiumlanguagewriter.OrientationCesiumWriter writer = openOrientationProperty();
			try {
				writer.writeUnitQuaternion(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>orientation</code> property as a <code>unitQuaternion</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
	
	
	

	 * @param dates The dates at which the rotation is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeOrientationProperty(List<JulianDate> dates, List<UnitQuaternion> values) {
		{
			cesiumlanguagewriter.OrientationCesiumWriter writer = openOrientationProperty();
			try {
				writer.writeUnitQuaternion(dates, values);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>orientation</code> property as a <code>unitQuaternion</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
	
	
	
	
	

	 * @param dates The dates at which the rotation is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeOrientationProperty(List<JulianDate> dates, List<UnitQuaternion> values, int startIndex, int length) {
		{
			cesiumlanguagewriter.OrientationCesiumWriter writer = openOrientationProperty();
			try {
				writer.writeUnitQuaternion(dates, values, startIndex, length);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>orientation</code> property as a <code>reference</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
	
	

	 * @param value The reference.
	 */
	public final void writeOrientationPropertyReference(Reference value) {
		{
			cesiumlanguagewriter.OrientationCesiumWriter writer = openOrientationProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>orientation</code> property as a <code>reference</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
	
	

	 * @param value The earliest date of the interval.
	 */
	public final void writeOrientationPropertyReference(String value) {
		{
			cesiumlanguagewriter.OrientationCesiumWriter writer = openOrientationProperty();
			try {
				writer.writeReference(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>orientation</code> property as a <code>reference</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyName The property on the referenced object.
	 */
	public final void writeOrientationPropertyReference(String identifier, String propertyName) {
		{
			cesiumlanguagewriter.OrientationCesiumWriter writer = openOrientationProperty();
			try {
				writer.writeReference(identifier, propertyName);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>orientation</code> property as a <code>reference</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
	
	
	

	 * @param identifier The identifier of the object which contains the referenced property.
	 * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
	 */
	public final void writeOrientationPropertyReference(String identifier, String[] propertyNames) {
		{
			cesiumlanguagewriter.OrientationCesiumWriter writer = openOrientationProperty();
			try {
				writer.writeReference(identifier, propertyNames);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  Gets the writer for the <code>point</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>point</code> property defines a point, or viewport-aligned circle.  The point is positioned in the scene by the `position` property.
	

	 */
	public final PointCesiumWriter getPointWriter() {
		return m_point.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>point</code> property.  The <code>point</code> property defines a point, or viewport-aligned circle.  The point is positioned in the scene by the `position` property.
	

	 */
	public final PointCesiumWriter openPointProperty() {
		return this.<PointCesiumWriter> openAndReturn(getPointWriter());
	}

	/**
	 *  Gets the writer for the <code>label</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>label</code> property defines a string of text.  The label is positioned in the scene by the `position` property.
	

	 */
	public final LabelCesiumWriter getLabelWriter() {
		return m_label.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>label</code> property.  The <code>label</code> property defines a string of text.  The label is positioned in the scene by the `position` property.
	

	 */
	public final LabelCesiumWriter openLabelProperty() {
		return this.<LabelCesiumWriter> openAndReturn(getLabelWriter());
	}

	/**
	 *  Gets the writer for the <code>polyline</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>polyline</code> property defines a polyline, which is a line in the scene composed of multiple segments.  The vertices of the polyline are specified by the `vertexPositions` property.
	

	 */
	public final PolylineCesiumWriter getPolylineWriter() {
		return m_polyline.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>polyline</code> property.  The <code>polyline</code> property defines a polyline, which is a line in the scene composed of multiple segments.  The vertices of the polyline are specified by the `vertexPositions` property.
	

	 */
	public final PolylineCesiumWriter openPolylineProperty() {
		return this.<PolylineCesiumWriter> openAndReturn(getPolylineWriter());
	}

	/**
	 *  Gets the writer for the <code>path</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>path</code> property defines a path, which is a polyline defined by the motion of an object over time.  The possible vertices of the path are specified by the `position` property.
	

	 */
	public final PathCesiumWriter getPathWriter() {
		return m_path.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>path</code> property.  The <code>path</code> property defines a path, which is a polyline defined by the motion of an object over time.  The possible vertices of the path are specified by the `position` property.
	

	 */
	public final PathCesiumWriter openPathProperty() {
		return this.<PathCesiumWriter> openAndReturn(getPathWriter());
	}

	/**
	 *  Gets the writer for the <code>polygon</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>polygon</code> property defines a polygon, which is a closed figure on the surface of the Earth.  The vertices of the polygon are specified by the `vertexPositions` property.
	

	 */
	public final PolygonCesiumWriter getPolygonWriter() {
		return m_polygon.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>polygon</code> property.  The <code>polygon</code> property defines a polygon, which is a closed figure on the surface of the Earth.  The vertices of the polygon are specified by the `vertexPositions` property.
	

	 */
	public final PolygonCesiumWriter openPolygonProperty() {
		return this.<PolygonCesiumWriter> openAndReturn(getPolygonWriter());
	}

	/**
	 *  Gets the writer for the <code>cone</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>cone</code> property defines a cone.  A cone starts at a point or apex and extends in a circle of directions which all have the same angular separation from the Z-axis of the object to which the cone is attached.  The cone may be capped at a radial limit, it may have an inner hole, and it may be only a part of a complete cone defined by clock angle limits.  The apex point of the cone is defined by the `position` property and extends in the direction of the Z-axis as defined by the `orientation` property.
	

	 */
	public final ConeCesiumWriter getConeWriter() {
		return m_cone.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>cone</code> property.  The <code>cone</code> property defines a cone.  A cone starts at a point or apex and extends in a circle of directions which all have the same angular separation from the Z-axis of the object to which the cone is attached.  The cone may be capped at a radial limit, it may have an inner hole, and it may be only a part of a complete cone defined by clock angle limits.  The apex point of the cone is defined by the `position` property and extends in the direction of the Z-axis as defined by the `orientation` property.
	

	 */
	public final ConeCesiumWriter openConeProperty() {
		return this.<ConeCesiumWriter> openAndReturn(getConeWriter());
	}

	/**
	 *  Gets the writer for the <code>pyramid</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>pyramid</code> property defines a pyramid.  A pyramid starts at a point or apex and extends in a specified list of directions from the apex.  Each pair of directions forms a face of the pyramid.  The pyramid may be capped at a radial limit.
	

	 */
	public final PyramidCesiumWriter getPyramidWriter() {
		return m_pyramid.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>pyramid</code> property.  The <code>pyramid</code> property defines a pyramid.  A pyramid starts at a point or apex and extends in a specified list of directions from the apex.  Each pair of directions forms a face of the pyramid.  The pyramid may be capped at a radial limit.
	

	 */
	public final PyramidCesiumWriter openPyramidProperty() {
		return this.<PyramidCesiumWriter> openAndReturn(getPyramidWriter());
	}

	/**
	 *  Gets the writer for the <code>ellipsoid</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>ellipsoid</code> property defines an ellipsoid, which is a closed quadric surface that is a three dimensional analogue of an ellipse.  The ellipsoid is positioned and oriented using the `position` and `orientation` properties.
	

	 */
	public final EllipsoidCesiumWriter getEllipsoidWriter() {
		return m_ellipsoid.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>ellipsoid</code> property.  The <code>ellipsoid</code> property defines an ellipsoid, which is a closed quadric surface that is a three dimensional analogue of an ellipse.  The ellipsoid is positioned and oriented using the `position` and `orientation` properties.
	

	 */
	public final EllipsoidCesiumWriter openEllipsoidProperty() {
		return this.<EllipsoidCesiumWriter> openAndReturn(getEllipsoidWriter());
	}

	/**
	 *  
	Writes the <code>viewFrom</code> property.  The <code>viewFrom</code> property specifies a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the objects position property.
	
	

	 * @param value The value.
	 */
	public final void writeViewFrom(Cartesian value) {
		String PropertyName = ViewFromPropertyName;
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeCartesian3(getOutput(), value);
	}

	/**
	 *  
	Writes the <code>viewFrom</code> property.  The <code>viewFrom</code> property specifies a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the objects position property.
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 */
	public final void writeViewFrom(List<JulianDate> dates, List<Cartesian> values) {
		writeViewFrom(dates, values, 0, dates.size());
	}

	/**
	 *  
	Writes the <code>viewFrom</code> property.  The <code>viewFrom</code> property specifies a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the objects position property.
	
	
	
	
	

	 * @param dates The dates at which the vector is specified.
	 * @param values The values corresponding to each date.
	 * @param startIndex The index of the first element to use in the `values` collection.
	 * @param length The number of elements to use from the `values` collection.
	 */
	public final void writeViewFrom(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
		String PropertyName = ViewFromPropertyName;
		getOutput().writePropertyName(PropertyName);
		CesiumWritingHelper.writeCartesian3(getOutput(), PropertyName, dates, values, startIndex, length);
	}

	/**
	 *  Gets the writer for the <code>model</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>model</code> property defines a 3D model.  The model is positioned and oriented using the `position` and `orientation` properties.
	

	 */
	public final ModelCesiumWriter getModelWriter() {
		return m_model.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>model</code> property.  The <code>model</code> property defines a 3D model.  The model is positioned and oriented using the `position` and `orientation` properties.
	

	 */
	public final ModelCesiumWriter openModelProperty() {
		return this.<ModelCesiumWriter> openAndReturn(getModelWriter());
	}

	/**
	 *  Gets the writer for the <code>ellipse</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>ellipse</code> property defines an ellipse, which is a closed curve on the surface of the Earth.  The ellipse is positioned using the `position` property.
	

	 */
	public final EllipseCesiumWriter getEllipseWriter() {
		return m_ellipse.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>ellipse</code> property.  The <code>ellipse</code> property defines an ellipse, which is a closed curve on the surface of the Earth.  The ellipse is positioned using the `position` property.
	

	 */
	public final EllipseCesiumWriter openEllipseProperty() {
		return this.<EllipseCesiumWriter> openAndReturn(getEllipseWriter());
	}

	/**
	 *  Gets the writer for the <code>clock</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>clock</code> property defines a simulated clock.
	

	 */
	public final ClockCesiumWriter getClockWriter() {
		return m_clock.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>clock</code> property.  The <code>clock</code> property defines a simulated clock.
	

	 */
	public final ClockCesiumWriter openClockProperty() {
		return this.<ClockCesiumWriter> openAndReturn(getClockWriter());
	}

	/**
	 *  Gets the writer for the <code>vector</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>vector</code> property defines defines a graphical vector that originates at the `position` property and extends in the provided direction for the provided length.
	

	 */
	public final VectorCesiumWriter getVectorWriter() {
		return m_vector.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>vector</code> property.  The <code>vector</code> property defines defines a graphical vector that originates at the `position` property and extends in the provided direction for the provided length.
	

	 */
	public final VectorCesiumWriter openVectorProperty() {
		return this.<VectorCesiumWriter> openAndReturn(getVectorWriter());
	}
}