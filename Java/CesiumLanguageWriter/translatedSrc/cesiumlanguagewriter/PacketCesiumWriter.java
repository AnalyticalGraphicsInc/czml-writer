package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
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
	The name of the <code>camera</code> property.
	

	 */
	public static final String CameraPropertyName = "camera";
	private Lazy<PositionCesiumWriter> m_position = new Lazy<PositionCesiumWriter>(new Func1<PositionCesiumWriter>() {
		public PositionCesiumWriter invoke() {
			return new PositionCesiumWriter(PositionPropertyName);
		}
	}, false);
	private Lazy<BillboardCesiumWriter> m_billboard = new Lazy<BillboardCesiumWriter>(new Func1<BillboardCesiumWriter>() {
		public BillboardCesiumWriter invoke() {
			return new BillboardCesiumWriter(BillboardPropertyName);
		}
	}, false);
	private Lazy<PositionListCesiumWriter> m_vertexPositions = new Lazy<PositionListCesiumWriter>(new Func1<PositionListCesiumWriter>() {
		public PositionListCesiumWriter invoke() {
			return new PositionListCesiumWriter(VertexPositionsPropertyName);
		}
	}, false);
	private Lazy<OrientationCesiumWriter> m_orientation = new Lazy<OrientationCesiumWriter>(new Func1<OrientationCesiumWriter>() {
		public OrientationCesiumWriter invoke() {
			return new OrientationCesiumWriter(OrientationPropertyName);
		}
	}, false);
	private Lazy<PointCesiumWriter> m_point = new Lazy<PointCesiumWriter>(new Func1<PointCesiumWriter>() {
		public PointCesiumWriter invoke() {
			return new PointCesiumWriter(PointPropertyName);
		}
	}, false);
	private Lazy<LabelCesiumWriter> m_label = new Lazy<LabelCesiumWriter>(new Func1<LabelCesiumWriter>() {
		public LabelCesiumWriter invoke() {
			return new LabelCesiumWriter(LabelPropertyName);
		}
	}, false);
	private Lazy<PolylineCesiumWriter> m_polyline = new Lazy<PolylineCesiumWriter>(new Func1<PolylineCesiumWriter>() {
		public PolylineCesiumWriter invoke() {
			return new PolylineCesiumWriter(PolylinePropertyName);
		}
	}, false);
	private Lazy<PathCesiumWriter> m_path = new Lazy<PathCesiumWriter>(new Func1<PathCesiumWriter>() {
		public PathCesiumWriter invoke() {
			return new PathCesiumWriter(PathPropertyName);
		}
	}, false);
	private Lazy<PolygonCesiumWriter> m_polygon = new Lazy<PolygonCesiumWriter>(new Func1<PolygonCesiumWriter>() {
		public PolygonCesiumWriter invoke() {
			return new PolygonCesiumWriter(PolygonPropertyName);
		}
	}, false);
	private Lazy<ConeCesiumWriter> m_cone = new Lazy<ConeCesiumWriter>(new Func1<ConeCesiumWriter>() {
		public ConeCesiumWriter invoke() {
			return new ConeCesiumWriter(ConePropertyName);
		}
	}, false);
	private Lazy<PyramidCesiumWriter> m_pyramid = new Lazy<PyramidCesiumWriter>(new Func1<PyramidCesiumWriter>() {
		public PyramidCesiumWriter invoke() {
			return new PyramidCesiumWriter(PyramidPropertyName);
		}
	}, false);
	private Lazy<CameraCesiumWriter> m_camera = new Lazy<CameraCesiumWriter>(new Func1<CameraCesiumWriter>() {
		public CameraCesiumWriter invoke() {
			return new CameraCesiumWriter(CameraPropertyName);
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
	public final void writeVertexPositionsPropertyReferences(Iterable<String> references) {
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
	 *  
	Writes a value for the <code>path</code> property as a <code>segments</code> value.  The <code>path</code> property specifies a path, which is a polyline defined by the motion of an object over time.  The possible vertices of the path are specified by the `position` property.
	
	

	 * @param value The interval.
	 */
	public final void writePathProperty(TimeInterval value) {
		{
			cesiumlanguagewriter.PathCesiumWriter writer = openPathProperty();
			try {
				writer.writeSegments(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>path</code> property as a <code>segments</code> value.  The <code>path</code> property specifies a path, which is a polyline defined by the motion of an object over time.  The possible vertices of the path are specified by the `position` property.
	
	
	

	 * @param start The earliest date of the interval.
	 * @param stop The latest date of the interval.
	 */
	public final void writePathProperty(JulianDate start, JulianDate stop) {
		{
			cesiumlanguagewriter.PathCesiumWriter writer = openPathProperty();
			try {
				writer.writeSegments(start, stop);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
	}

	/**
	 *  
	Writes a value for the <code>path</code> property as a <code>segments</code> value.  The <code>path</code> property specifies a path, which is a polyline defined by the motion of an object over time.  The possible vertices of the path are specified by the `position` property.
	
	

	 * @param value The intervals.
	 */
	public final void writePathProperty(List<TimeInterval> value) {
		{
			cesiumlanguagewriter.PathCesiumWriter writer = openPathProperty();
			try {
				writer.writeSegments(value);
			} finally {
				DisposeHelper.dispose(writer);
			}
		}
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
	 *  Gets the writer for the <code>camera</code> property.  The returned instance must be opened by calling the  {@link CesiumElementWriter#open} method before it can be used for writing.  The <code>camera</code> property defines a camera.
	

	 */
	public final CameraCesiumWriter getCameraWriter() {
		return m_camera.getValue();
	}

	/**
	 *  
	Opens and returns the writer for the <code>camera</code> property.  The <code>camera</code> property defines a camera.
	

	 */
	public final CameraCesiumWriter openCameraProperty() {
		return this.<CameraCesiumWriter> openAndReturn(getCameraWriter());
	}
}