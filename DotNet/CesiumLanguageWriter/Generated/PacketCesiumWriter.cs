// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>Packet</c> to a <see cref="CesiumOutputStream" />.  A <c>Packet</c> is describes the graphical properties of a single object in a scene, such as a single aircraft.
    /// </summary>
    public class PacketCesiumWriter : CesiumElementWriter
    {
        /// <summary>
        /// The name of the <c>id</c> property.
        /// </summary>
        public const string IdPropertyName = "id";

        /// <summary>
        /// The name of the <c>delete</c> property.
        /// </summary>
        public const string DeletePropertyName = "delete";

        /// <summary>
        /// The name of the <c>name</c> property.
        /// </summary>
        public const string NamePropertyName = "name";

        /// <summary>
        /// The name of the <c>parent</c> property.
        /// </summary>
        public const string ParentPropertyName = "parent";

        /// <summary>
        /// The name of the <c>description</c> property.
        /// </summary>
        public const string DescriptionPropertyName = "description";

        /// <summary>
        /// The name of the <c>clock</c> property.
        /// </summary>
        public const string ClockPropertyName = "clock";

        /// <summary>
        /// The name of the <c>version</c> property.
        /// </summary>
        public const string VersionPropertyName = "version";

        /// <summary>
        /// The name of the <c>availability</c> property.
        /// </summary>
        public const string AvailabilityPropertyName = "availability";

        /// <summary>
        /// The name of the <c>properties</c> property.
        /// </summary>
        public const string PropertiesPropertyName = "properties";

        /// <summary>
        /// The name of the <c>position</c> property.
        /// </summary>
        public const string PositionPropertyName = "position";

        /// <summary>
        /// The name of the <c>orientation</c> property.
        /// </summary>
        public const string OrientationPropertyName = "orientation";

        /// <summary>
        /// The name of the <c>viewFrom</c> property.
        /// </summary>
        public const string ViewFromPropertyName = "viewFrom";

        /// <summary>
        /// The name of the <c>billboard</c> property.
        /// </summary>
        public const string BillboardPropertyName = "billboard";

        /// <summary>
        /// The name of the <c>box</c> property.
        /// </summary>
        public const string BoxPropertyName = "box";

        /// <summary>
        /// The name of the <c>corridor</c> property.
        /// </summary>
        public const string CorridorPropertyName = "corridor";

        /// <summary>
        /// The name of the <c>cylinder</c> property.
        /// </summary>
        public const string CylinderPropertyName = "cylinder";

        /// <summary>
        /// The name of the <c>ellipse</c> property.
        /// </summary>
        public const string EllipsePropertyName = "ellipse";

        /// <summary>
        /// The name of the <c>ellipsoid</c> property.
        /// </summary>
        public const string EllipsoidPropertyName = "ellipsoid";

        /// <summary>
        /// The name of the <c>label</c> property.
        /// </summary>
        public const string LabelPropertyName = "label";

        /// <summary>
        /// The name of the <c>model</c> property.
        /// </summary>
        public const string ModelPropertyName = "model";

        /// <summary>
        /// The name of the <c>path</c> property.
        /// </summary>
        public const string PathPropertyName = "path";

        /// <summary>
        /// The name of the <c>point</c> property.
        /// </summary>
        public const string PointPropertyName = "point";

        /// <summary>
        /// The name of the <c>polygon</c> property.
        /// </summary>
        public const string PolygonPropertyName = "polygon";

        /// <summary>
        /// The name of the <c>polyline</c> property.
        /// </summary>
        public const string PolylinePropertyName = "polyline";

        /// <summary>
        /// The name of the <c>rectangle</c> property.
        /// </summary>
        public const string RectanglePropertyName = "rectangle";

        /// <summary>
        /// The name of the <c>wall</c> property.
        /// </summary>
        public const string WallPropertyName = "wall";

        /// <summary>
        /// The name of the <c>agi_conicSensor</c> property.
        /// </summary>
        public const string ConicSensorPropertyName = "agi_conicSensor";

        /// <summary>
        /// The name of the <c>agi_customPatternSensor</c> property.
        /// </summary>
        public const string CustomPatternSensorPropertyName = "agi_customPatternSensor";

        /// <summary>
        /// The name of the <c>agi_rectangularSensor</c> property.
        /// </summary>
        public const string RectangularSensorPropertyName = "agi_rectangularSensor";

        /// <summary>
        /// The name of the <c>agi_fan</c> property.
        /// </summary>
        public const string FanPropertyName = "agi_fan";

        /// <summary>
        /// The name of the <c>agi_vector</c> property.
        /// </summary>
        public const string VectorPropertyName = "agi_vector";

        private readonly Lazy<StringCesiumWriter> m_description = new Lazy<StringCesiumWriter>(() => new StringCesiumWriter(DescriptionPropertyName), false);
        private readonly Lazy<ClockCesiumWriter> m_clock = new Lazy<ClockCesiumWriter>(() => new ClockCesiumWriter(ClockPropertyName), false);
        private readonly Lazy<CustomPropertiesCesiumWriter> m_properties = new Lazy<CustomPropertiesCesiumWriter>(() => new CustomPropertiesCesiumWriter(PropertiesPropertyName), false);
        private readonly Lazy<PositionCesiumWriter> m_position = new Lazy<PositionCesiumWriter>(() => new PositionCesiumWriter(PositionPropertyName), false);
        private readonly Lazy<OrientationCesiumWriter> m_orientation = new Lazy<OrientationCesiumWriter>(() => new OrientationCesiumWriter(OrientationPropertyName), false);
        private readonly Lazy<ViewFromCesiumWriter> m_viewFrom = new Lazy<ViewFromCesiumWriter>(() => new ViewFromCesiumWriter(ViewFromPropertyName), false);
        private readonly Lazy<BillboardCesiumWriter> m_billboard = new Lazy<BillboardCesiumWriter>(() => new BillboardCesiumWriter(BillboardPropertyName), false);
        private readonly Lazy<BoxCesiumWriter> m_box = new Lazy<BoxCesiumWriter>(() => new BoxCesiumWriter(BoxPropertyName), false);
        private readonly Lazy<CorridorCesiumWriter> m_corridor = new Lazy<CorridorCesiumWriter>(() => new CorridorCesiumWriter(CorridorPropertyName), false);
        private readonly Lazy<CylinderCesiumWriter> m_cylinder = new Lazy<CylinderCesiumWriter>(() => new CylinderCesiumWriter(CylinderPropertyName), false);
        private readonly Lazy<EllipseCesiumWriter> m_ellipse = new Lazy<EllipseCesiumWriter>(() => new EllipseCesiumWriter(EllipsePropertyName), false);
        private readonly Lazy<EllipsoidCesiumWriter> m_ellipsoid = new Lazy<EllipsoidCesiumWriter>(() => new EllipsoidCesiumWriter(EllipsoidPropertyName), false);
        private readonly Lazy<LabelCesiumWriter> m_label = new Lazy<LabelCesiumWriter>(() => new LabelCesiumWriter(LabelPropertyName), false);
        private readonly Lazy<ModelCesiumWriter> m_model = new Lazy<ModelCesiumWriter>(() => new ModelCesiumWriter(ModelPropertyName), false);
        private readonly Lazy<PathCesiumWriter> m_path = new Lazy<PathCesiumWriter>(() => new PathCesiumWriter(PathPropertyName), false);
        private readonly Lazy<PointCesiumWriter> m_point = new Lazy<PointCesiumWriter>(() => new PointCesiumWriter(PointPropertyName), false);
        private readonly Lazy<PolygonCesiumWriter> m_polygon = new Lazy<PolygonCesiumWriter>(() => new PolygonCesiumWriter(PolygonPropertyName), false);
        private readonly Lazy<PolylineCesiumWriter> m_polyline = new Lazy<PolylineCesiumWriter>(() => new PolylineCesiumWriter(PolylinePropertyName), false);
        private readonly Lazy<RectangleCesiumWriter> m_rectangle = new Lazy<RectangleCesiumWriter>(() => new RectangleCesiumWriter(RectanglePropertyName), false);
        private readonly Lazy<WallCesiumWriter> m_wall = new Lazy<WallCesiumWriter>(() => new WallCesiumWriter(WallPropertyName), false);
        private readonly Lazy<ConicSensorCesiumWriter> m_agi_conicSensor = new Lazy<ConicSensorCesiumWriter>(() => new ConicSensorCesiumWriter(ConicSensorPropertyName), false);
        private readonly Lazy<CustomPatternSensorCesiumWriter> m_agi_customPatternSensor = new Lazy<CustomPatternSensorCesiumWriter>(() => new CustomPatternSensorCesiumWriter(CustomPatternSensorPropertyName), false);
        private readonly Lazy<RectangularSensorCesiumWriter> m_agi_rectangularSensor = new Lazy<RectangularSensorCesiumWriter>(() => new RectangularSensorCesiumWriter(RectangularSensorPropertyName), false);
        private readonly Lazy<FanCesiumWriter> m_agi_fan = new Lazy<FanCesiumWriter>(() => new FanCesiumWriter(FanPropertyName), false);
        private readonly Lazy<VectorCesiumWriter> m_agi_vector = new Lazy<VectorCesiumWriter>(() => new VectorCesiumWriter(VectorPropertyName), false);

        /// <summary>
        /// Writes the start of a new JSON object representing the packet.
        /// </summary>
        protected override void OnOpen()
        {
            Output.WriteStartObject();
        }

        /// <summary>
        /// Writes the end of the JSON object representing the packet.
        /// </summary>
        protected override void OnClose()
        {
            Output.WriteEndObject();
        }

        /// <summary>
        /// Writes the value expressed as a <c>id</c>, which is the ID of the object described by this packet.  IDs do not need to be GUIDs, but they do need to uniquely identify a single object within a CZML source and any other CZML sources loaded into the same scope.  If this property is not specified, the client will automatically generate a unique one.  However, this prevents later packets from referring to this object in order to add more data to it.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteId(string value)
        {
            const string PropertyName = IdPropertyName;
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>delete</c>, which is whether the client should delete all existing data for this object, identified by ID. If true, all other properties in this packet will be ignored.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteDelete(bool value)
        {
            const string PropertyName = DeletePropertyName;
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>name</c>, which is the name of the object.  It does not have to be unique and is intended for user consumption.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteName(string value)
        {
            const string PropertyName = NamePropertyName;
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>parent</c>, which is the ID of the parent object, if any.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteParent(string value)
        {
            const string PropertyName = ParentPropertyName;
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Gets the writer for the <c>description</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>description</c> property defines an HTML description of the object.
        /// </summary>
        public StringCesiumWriter DescriptionWriter
        {
            get { return m_description.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>description</c> property.  The <c>description</c> property defines an HTML description of the object.
        /// </summary>
        public StringCesiumWriter OpenDescriptionProperty()
        {
            return OpenAndReturn(DescriptionWriter);
        }

        /// <summary>
        /// Writes a value for the <c>description</c> property as a <c>string</c> value.  The <c>description</c> property specifies an HTML description of the object.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteDescriptionProperty(string value)
        {
            using (var writer = OpenDescriptionProperty())
            {
                writer.WriteString(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>description</c> property as a <c>reference</c> value.  The <c>description</c> property specifies an HTML description of the object.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteDescriptionPropertyReference(Reference value)
        {
            using (var writer = OpenDescriptionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>description</c> property as a <c>reference</c> value.  The <c>description</c> property specifies an HTML description of the object.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteDescriptionPropertyReference(string value)
        {
            using (var writer = OpenDescriptionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>description</c> property as a <c>reference</c> value.  The <c>description</c> property specifies an HTML description of the object.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteDescriptionPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenDescriptionProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>description</c> property as a <c>reference</c> value.  The <c>description</c> property specifies an HTML description of the object.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteDescriptionPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenDescriptionProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>clock</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>clock</c> property defines the clock settings for the entire data set. Only valid on the document object.
        /// </summary>
        public ClockCesiumWriter ClockWriter
        {
            get { return m_clock.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>clock</c> property.  The <c>clock</c> property defines the clock settings for the entire data set. Only valid on the document object.
        /// </summary>
        public ClockCesiumWriter OpenClockProperty()
        {
            return OpenAndReturn(ClockWriter);
        }

        /// <summary>
        /// Writes the value expressed as a <c>version</c>, which is the CZML version being written. Only valid on the document object.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteVersion(string value)
        {
            const string PropertyName = VersionPropertyName;
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>availability</c>, which is the set of time intervals over which data for an object is available. The property can be a single string specifying a single interval, or an array of strings representing intervals.  A later Cesium packet can update this availability if it changes or is found to be incorrect. For example, an SGP4 propagator may initially report availability for all time, but then later the propagator throws an exception and the availability can be adjusted to end at that time. If this optional property is not present, the object is assumed to be available for all time. Availability is scoped to a particular CZML stream, so two different streams can list different availability for a single object. Within a single stream, the last availability stated for an object is the one in effect and any availabilities in previous packets are ignored. If an object is not available at a time, the client will not draw that object.  If not specified, the default value is 0000-00-00T00:00:00Z/9999-12-31T24:00:00Z.
        /// </summary>
        /// <param name="value">The interval.</param>
        public void WriteAvailability(TimeInterval value)
        {
            const string PropertyName = AvailabilityPropertyName;
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteTimeInterval(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>availability</c>, which is the set of time intervals over which data for an object is available. The property can be a single string specifying a single interval, or an array of strings representing intervals.  A later Cesium packet can update this availability if it changes or is found to be incorrect. For example, an SGP4 propagator may initially report availability for all time, but then later the propagator throws an exception and the availability can be adjusted to end at that time. If this optional property is not present, the object is assumed to be available for all time. Availability is scoped to a particular CZML stream, so two different streams can list different availability for a single object. Within a single stream, the last availability stated for an object is the one in effect and any availabilities in previous packets are ignored. If an object is not available at a time, the client will not draw that object.  If not specified, the default value is 0000-00-00T00:00:00Z/9999-12-31T24:00:00Z.
        /// </summary>
        /// <param name="start">The earliest date of the interval.</param>
        /// <param name="stop">The latest date of the interval.</param>
        public void WriteAvailability(JulianDate start, JulianDate stop)
        {
            WriteAvailability(new TimeInterval(start, stop));
        }

        /// <summary>
        /// Writes the value expressed as a <c>availability</c>, which is the set of time intervals over which data for an object is available. The property can be a single string specifying a single interval, or an array of strings representing intervals.  A later Cesium packet can update this availability if it changes or is found to be incorrect. For example, an SGP4 propagator may initially report availability for all time, but then later the propagator throws an exception and the availability can be adjusted to end at that time. If this optional property is not present, the object is assumed to be available for all time. Availability is scoped to a particular CZML stream, so two different streams can list different availability for a single object. Within a single stream, the last availability stated for an object is the one in effect and any availabilities in previous packets are ignored. If an object is not available at a time, the client will not draw that object.  If not specified, the default value is 0000-00-00T00:00:00Z/9999-12-31T24:00:00Z.
        /// </summary>
        /// <param name="value">The intervals.</param>
        public void WriteAvailability(IList<TimeInterval> value)
        {
            const string PropertyName = AvailabilityPropertyName;
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteTimeIntervalCollection(Output, value);
        }

        /// <summary>
        /// Gets the writer for the <c>properties</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>properties</c> property defines a set of custom properties for this object.
        /// </summary>
        public CustomPropertiesCesiumWriter PropertiesWriter
        {
            get { return m_properties.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>properties</c> property.  The <c>properties</c> property defines a set of custom properties for this object.
        /// </summary>
        public CustomPropertiesCesiumWriter OpenPropertiesProperty()
        {
            return OpenAndReturn(PropertiesWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>position</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>position</c> property defines the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        public PositionCesiumWriter PositionWriter
        {
            get { return m_position.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>position</c> property.  The <c>position</c> property defines the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        public PositionCesiumWriter OpenPositionProperty()
        {
            return OpenAndReturn(PositionWriter);
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>cartesian</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WritePositionProperty(Cartesian value)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesian(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>cartesian</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePositionProperty(IList<JulianDate> dates, IList<Cartesian> values)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesian(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>cartesian</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WritePositionProperty(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesian(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>cartographicRadians</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="value">The interval.</param>
        public void WritePositionPropertyCartographicRadians(Cartographic value)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartographicRadians(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>cartographicRadians</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePositionPropertyCartographicRadians(IList<JulianDate> dates, IList<Cartographic> values)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartographicRadians(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>cartographicRadians</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The position corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WritePositionPropertyCartographicRadians(IList<JulianDate> dates, IList<Cartographic> values, int startIndex, int length)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartographicRadians(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>cartographicDegrees</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="value">The interval.</param>
        public void WritePositionPropertyCartographicDegrees(Cartographic value)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartographicDegrees(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>cartographicDegrees</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePositionPropertyCartographicDegrees(IList<JulianDate> dates, IList<Cartographic> values)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartographicDegrees(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>cartographicDegrees</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The position corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WritePositionPropertyCartographicDegrees(IList<JulianDate> dates, IList<Cartographic> values, int startIndex, int length)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartographicDegrees(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>cartesianVelocity</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WritePositionPropertyCartesianVelocity(Motion<Cartesian> value)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesianVelocity(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>cartesianVelocity</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePositionPropertyCartesianVelocity(IList<JulianDate> dates, IList<Motion<Cartesian>> values)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesianVelocity(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>cartesianVelocity</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WritePositionPropertyCartesianVelocity(IList<JulianDate> dates, IList<Motion<Cartesian>> values, int startIndex, int length)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesianVelocity(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>reference</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WritePositionPropertyReference(Reference value)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>reference</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WritePositionPropertyReference(string value)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>reference</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WritePositionPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>position</c> property as a <c>reference</c> value.  The <c>position</c> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WritePositionPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>orientation</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>orientation</c> property defines the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
        /// </summary>
        public OrientationCesiumWriter OrientationWriter
        {
            get { return m_orientation.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>orientation</c> property.  The <c>orientation</c> property defines the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
        /// </summary>
        public OrientationCesiumWriter OpenOrientationProperty()
        {
            return OpenAndReturn(OrientationWriter);
        }

        /// <summary>
        /// Writes a value for the <c>orientation</c> property as a <c>unitQuaternion</c> value.  The <c>orientation</c> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteOrientationProperty(UnitQuaternion value)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteUnitQuaternion(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>orientation</c> property as a <c>unitQuaternion</c> value.  The <c>orientation</c> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteOrientationProperty(IList<JulianDate> dates, IList<UnitQuaternion> values)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteUnitQuaternion(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>orientation</c> property as a <c>unitQuaternion</c> value.  The <c>orientation</c> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteOrientationProperty(IList<JulianDate> dates, IList<UnitQuaternion> values, int startIndex, int length)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteUnitQuaternion(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>orientation</c> property as a <c>reference</c> value.  The <c>orientation</c> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteOrientationPropertyReference(Reference value)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>orientation</c> property as a <c>reference</c> value.  The <c>orientation</c> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteOrientationPropertyReference(string value)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>orientation</c> property as a <c>reference</c> value.  The <c>orientation</c> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteOrientationPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>orientation</c> property as a <c>reference</c> value.  The <c>orientation</c> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteOrientationPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Writes a value for the <c>orientation</c> property as a <c>velocityReference</c> value.  The <c>orientation</c> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteOrientationPropertyVelocityReference(Reference value)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteVelocityReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>orientation</c> property as a <c>velocityReference</c> value.  The <c>orientation</c> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteOrientationPropertyVelocityReference(string value)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteVelocityReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>orientation</c> property as a <c>velocityReference</c> value.  The <c>orientation</c> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteOrientationPropertyVelocityReference(string identifier, string propertyName)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteVelocityReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>orientation</c> property as a <c>velocityReference</c> value.  The <c>orientation</c> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteOrientationPropertyVelocityReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteVelocityReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>viewFrom</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>viewFrom</c> property defines a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
        /// </summary>
        public ViewFromCesiumWriter ViewFromWriter
        {
            get { return m_viewFrom.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>viewFrom</c> property.  The <c>viewFrom</c> property defines a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
        /// </summary>
        public ViewFromCesiumWriter OpenViewFromProperty()
        {
            return OpenAndReturn(ViewFromWriter);
        }

        /// <summary>
        /// Writes a value for the <c>viewFrom</c> property as a <c>cartesian</c> value.  The <c>viewFrom</c> property specifies a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteViewFromProperty(Cartesian value)
        {
            using (var writer = OpenViewFromProperty())
            {
                writer.WriteCartesian(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>viewFrom</c> property as a <c>cartesian</c> value.  The <c>viewFrom</c> property specifies a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteViewFromProperty(IList<JulianDate> dates, IList<Cartesian> values)
        {
            using (var writer = OpenViewFromProperty())
            {
                writer.WriteCartesian(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <c>viewFrom</c> property as a <c>cartesian</c> value.  The <c>viewFrom</c> property specifies a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteViewFromProperty(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            using (var writer = OpenViewFromProperty())
            {
                writer.WriteCartesian(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <c>viewFrom</c> property as a <c>reference</c> value.  The <c>viewFrom</c> property specifies a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteViewFromPropertyReference(Reference value)
        {
            using (var writer = OpenViewFromProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>viewFrom</c> property as a <c>reference</c> value.  The <c>viewFrom</c> property specifies a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteViewFromPropertyReference(string value)
        {
            using (var writer = OpenViewFromProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <c>viewFrom</c> property as a <c>reference</c> value.  The <c>viewFrom</c> property specifies a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteViewFromPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenViewFromProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <c>viewFrom</c> property as a <c>reference</c> value.  The <c>viewFrom</c> property specifies a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteViewFromPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenViewFromProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <c>billboard</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>billboard</c> property defines a billboard, or viewport-aligned image, sometimes called a marker.  The billboard is positioned in the scene by the <c>position</c> property.
        /// </summary>
        public BillboardCesiumWriter BillboardWriter
        {
            get { return m_billboard.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>billboard</c> property.  The <c>billboard</c> property defines a billboard, or viewport-aligned image, sometimes called a marker.  The billboard is positioned in the scene by the <c>position</c> property.
        /// </summary>
        public BillboardCesiumWriter OpenBillboardProperty()
        {
            return OpenAndReturn(BillboardWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>box</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>box</c> property defines a box, which is a closed rectangular cuboid.  The box is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public BoxCesiumWriter BoxWriter
        {
            get { return m_box.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>box</c> property.  The <c>box</c> property defines a box, which is a closed rectangular cuboid.  The box is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public BoxCesiumWriter OpenBoxProperty()
        {
            return OpenAndReturn(BoxWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>corridor</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>corridor</c> property defines a corridor, which is a shape defined by a centerline and width.
        /// </summary>
        public CorridorCesiumWriter CorridorWriter
        {
            get { return m_corridor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>corridor</c> property.  The <c>corridor</c> property defines a corridor, which is a shape defined by a centerline and width.
        /// </summary>
        public CorridorCesiumWriter OpenCorridorProperty()
        {
            return OpenAndReturn(CorridorWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>cylinder</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>cylinder</c> property defines a cylinder, truncated cone, or cone defined by a length, top radius, and bottom radius.  The cylinder is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public CylinderCesiumWriter CylinderWriter
        {
            get { return m_cylinder.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>cylinder</c> property.  The <c>cylinder</c> property defines a cylinder, truncated cone, or cone defined by a length, top radius, and bottom radius.  The cylinder is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public CylinderCesiumWriter OpenCylinderProperty()
        {
            return OpenAndReturn(CylinderWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>ellipse</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>ellipse</c> property defines an ellipse, which is a closed curve on the surface of the Earth.  The ellipse is positioned using the <c>position</c> property.
        /// </summary>
        public EllipseCesiumWriter EllipseWriter
        {
            get { return m_ellipse.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>ellipse</c> property.  The <c>ellipse</c> property defines an ellipse, which is a closed curve on the surface of the Earth.  The ellipse is positioned using the <c>position</c> property.
        /// </summary>
        public EllipseCesiumWriter OpenEllipseProperty()
        {
            return OpenAndReturn(EllipseWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>ellipsoid</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>ellipsoid</c> property defines an ellipsoid, which is a closed quadric surface that is a three dimensional analogue of an ellipse.  The ellipsoid is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public EllipsoidCesiumWriter EllipsoidWriter
        {
            get { return m_ellipsoid.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>ellipsoid</c> property.  The <c>ellipsoid</c> property defines an ellipsoid, which is a closed quadric surface that is a three dimensional analogue of an ellipse.  The ellipsoid is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public EllipsoidCesiumWriter OpenEllipsoidProperty()
        {
            return OpenAndReturn(EllipsoidWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>label</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>label</c> property defines a string of text.  The label is positioned in the scene by the <c>position</c> property.
        /// </summary>
        public LabelCesiumWriter LabelWriter
        {
            get { return m_label.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>label</c> property.  The <c>label</c> property defines a string of text.  The label is positioned in the scene by the <c>position</c> property.
        /// </summary>
        public LabelCesiumWriter OpenLabelProperty()
        {
            return OpenAndReturn(LabelWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>model</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>model</c> property defines a 3D model.  The model is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public ModelCesiumWriter ModelWriter
        {
            get { return m_model.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>model</c> property.  The <c>model</c> property defines a 3D model.  The model is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public ModelCesiumWriter OpenModelProperty()
        {
            return OpenAndReturn(ModelWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>path</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>path</c> property defines a path, which is a polyline defined by the motion of an object over time.  The possible vertices of the path are specified by the <c>position</c> property.
        /// </summary>
        public PathCesiumWriter PathWriter
        {
            get { return m_path.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>path</c> property.  The <c>path</c> property defines a path, which is a polyline defined by the motion of an object over time.  The possible vertices of the path are specified by the <c>position</c> property.
        /// </summary>
        public PathCesiumWriter OpenPathProperty()
        {
            return OpenAndReturn(PathWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>point</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>point</c> property defines a point, or viewport-aligned circle.  The point is positioned in the scene by the <c>position</c> property.
        /// </summary>
        public PointCesiumWriter PointWriter
        {
            get { return m_point.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>point</c> property.  The <c>point</c> property defines a point, or viewport-aligned circle.  The point is positioned in the scene by the <c>position</c> property.
        /// </summary>
        public PointCesiumWriter OpenPointProperty()
        {
            return OpenAndReturn(PointWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>polygon</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>polygon</c> property defines a polygon, which is a closed figure on the surface of the Earth.
        /// </summary>
        public PolygonCesiumWriter PolygonWriter
        {
            get { return m_polygon.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>polygon</c> property.  The <c>polygon</c> property defines a polygon, which is a closed figure on the surface of the Earth.
        /// </summary>
        public PolygonCesiumWriter OpenPolygonProperty()
        {
            return OpenAndReturn(PolygonWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>polyline</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>polyline</c> property defines a polyline, which is a line in the scene composed of multiple segments.
        /// </summary>
        public PolylineCesiumWriter PolylineWriter
        {
            get { return m_polyline.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>polyline</c> property.  The <c>polyline</c> property defines a polyline, which is a line in the scene composed of multiple segments.
        /// </summary>
        public PolylineCesiumWriter OpenPolylineProperty()
        {
            return OpenAndReturn(PolylineWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>rectangle</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>rectangle</c> property defines a cartographic rectangle, which conforms to the curvature of the globe and can be placed along the surface or at altitude.
        /// </summary>
        public RectangleCesiumWriter RectangleWriter
        {
            get { return m_rectangle.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>rectangle</c> property.  The <c>rectangle</c> property defines a cartographic rectangle, which conforms to the curvature of the globe and can be placed along the surface or at altitude.
        /// </summary>
        public RectangleCesiumWriter OpenRectangleProperty()
        {
            return OpenAndReturn(RectangleWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>wall</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>wall</c> property defines a two dimensional wall which conforms to the curvature of the globe and can be placed along the surface or at altitude.
        /// </summary>
        public WallCesiumWriter WallWriter
        {
            get { return m_wall.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>wall</c> property.  The <c>wall</c> property defines a two dimensional wall which conforms to the curvature of the globe and can be placed along the surface or at altitude.
        /// </summary>
        public WallCesiumWriter OpenWallProperty()
        {
            return OpenAndReturn(WallWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>agi_conicSensor</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>agi_conicSensor</c> property defines a conical sensor volume taking into account occlusion of an ellipsoid, i.e., the globe.  The sensor is is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public ConicSensorCesiumWriter ConicSensorWriter
        {
            get { return m_agi_conicSensor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>agi_conicSensor</c> property.  The <c>agi_conicSensor</c> property defines a conical sensor volume taking into account occlusion of an ellipsoid, i.e., the globe.  The sensor is is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public ConicSensorCesiumWriter OpenConicSensorProperty()
        {
            return OpenAndReturn(ConicSensorWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>agi_customPatternSensor</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>agi_customPatternSensor</c> property defines a custom sensor volume taking into account occlusion of an ellipsoid, i.e., the globe.  The sensor is is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public CustomPatternSensorCesiumWriter CustomPatternSensorWriter
        {
            get { return m_agi_customPatternSensor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>agi_customPatternSensor</c> property.  The <c>agi_customPatternSensor</c> property defines a custom sensor volume taking into account occlusion of an ellipsoid, i.e., the globe.  The sensor is is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public CustomPatternSensorCesiumWriter OpenCustomPatternSensorProperty()
        {
            return OpenAndReturn(CustomPatternSensorWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>agi_rectangularSensor</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>agi_rectangularSensor</c> property defines a rectangular pyramid sensor volume taking into account occlusion of an ellipsoid, i.e., the globe.  The sensor is is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public RectangularSensorCesiumWriter RectangularSensorWriter
        {
            get { return m_agi_rectangularSensor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>agi_rectangularSensor</c> property.  The <c>agi_rectangularSensor</c> property defines a rectangular pyramid sensor volume taking into account occlusion of an ellipsoid, i.e., the globe.  The sensor is is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public RectangularSensorCesiumWriter OpenRectangularSensorProperty()
        {
            return OpenAndReturn(RectangularSensorWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>agi_fan</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>agi_fan</c> property defines defines a fan, which starts at a point or apex and extends in a specified list of directions from the apex.  Each pair of directions forms a face of the fan extending to the specified radius.  The fan is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public FanCesiumWriter FanWriter
        {
            get { return m_agi_fan.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>agi_fan</c> property.  The <c>agi_fan</c> property defines defines a fan, which starts at a point or apex and extends in a specified list of directions from the apex.  Each pair of directions forms a face of the fan extending to the specified radius.  The fan is positioned and oriented using the <c>position</c> and <c>orientation</c> properties.
        /// </summary>
        public FanCesiumWriter OpenFanProperty()
        {
            return OpenAndReturn(FanWriter);
        }

        /// <summary>
        /// Gets the writer for the <c>agi_vector</c> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <c>agi_vector</c> property defines defines a graphical vector that originates at the <c>position</c> property and extends in the provided direction for the provided length.  The vector is positioned using the <c>position</c> property.
        /// </summary>
        public VectorCesiumWriter VectorWriter
        {
            get { return m_agi_vector.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <c>agi_vector</c> property.  The <c>agi_vector</c> property defines defines a graphical vector that originates at the <c>position</c> property and extends in the provided direction for the provided length.  The vector is positioned using the <c>position</c> property.
        /// </summary>
        public VectorCesiumWriter OpenVectorProperty()
        {
            return OpenAndReturn(VectorWriter);
        }

    }
}
