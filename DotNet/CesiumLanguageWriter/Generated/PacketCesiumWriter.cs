// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Packet</code> to a <see cref="CesiumOutputStream" />.  A <code>Packet</code> describes the graphical properties of a single object in a scene, such as a single aircraft.
    /// </summary>
    public class PacketCesiumWriter : CesiumElementWriter
    {
        /// <summary>
        /// The name of the <code>id</code> property.
        /// </summary>
        public const string IdPropertyName = "id";

        /// <summary>
        /// The name of the <code>name</code> property.
        /// </summary>
        public const string NamePropertyName = "name";

        /// <summary>
        /// The name of the <code>parent</code> property.
        /// </summary>
        public const string ParentPropertyName = "parent";

        /// <summary>
        /// The name of the <code>description</code> property.
        /// </summary>
        public const string DescriptionPropertyName = "description";

        /// <summary>
        /// The name of the <code>availability</code> property.
        /// </summary>
        public const string AvailabilityPropertyName = "availability";

        /// <summary>
        /// The name of the <code>position</code> property.
        /// </summary>
        public const string PositionPropertyName = "position";

        /// <summary>
        /// The name of the <code>billboard</code> property.
        /// </summary>
        public const string BillboardPropertyName = "billboard";

        /// <summary>
        /// The name of the <code>vertexPositions</code> property.
        /// </summary>
        public const string VertexPositionsPropertyName = "vertexPositions";

        /// <summary>
        /// The name of the <code>orientation</code> property.
        /// </summary>
        public const string OrientationPropertyName = "orientation";

        /// <summary>
        /// The name of the <code>point</code> property.
        /// </summary>
        public const string PointPropertyName = "point";

        /// <summary>
        /// The name of the <code>label</code> property.
        /// </summary>
        public const string LabelPropertyName = "label";

        /// <summary>
        /// The name of the <code>polyline</code> property.
        /// </summary>
        public const string PolylinePropertyName = "polyline";

        /// <summary>
        /// The name of the <code>path</code> property.
        /// </summary>
        public const string PathPropertyName = "path";

        /// <summary>
        /// The name of the <code>polygon</code> property.
        /// </summary>
        public const string PolygonPropertyName = "polygon";

        /// <summary>
        /// The name of the <code>cone</code> property.
        /// </summary>
        public const string ConePropertyName = "cone";

        /// <summary>
        /// The name of the <code>pyramid</code> property.
        /// </summary>
        public const string PyramidPropertyName = "pyramid";

        /// <summary>
        /// The name of the <code>ellipsoid</code> property.
        /// </summary>
        public const string EllipsoidPropertyName = "ellipsoid";

        /// <summary>
        /// The name of the <code>viewFrom</code> property.
        /// </summary>
        public const string ViewFromPropertyName = "viewFrom";

        /// <summary>
        /// The name of the <code>model</code> property.
        /// </summary>
        public const string ModelPropertyName = "model";

        /// <summary>
        /// The name of the <code>ellipse</code> property.
        /// </summary>
        public const string EllipsePropertyName = "ellipse";

        /// <summary>
        /// The name of the <code>clock</code> property.
        /// </summary>
        public const string ClockPropertyName = "clock";

        /// <summary>
        /// The name of the <code>vector</code> property.
        /// </summary>
        public const string VectorPropertyName = "vector";

        private readonly Lazy<StringCesiumWriter> m_description = new Lazy<StringCesiumWriter>(() => new StringCesiumWriter(DescriptionPropertyName), false);
        private readonly Lazy<PositionCesiumWriter> m_position = new Lazy<PositionCesiumWriter>(() => new PositionCesiumWriter(PositionPropertyName), false);
        private readonly Lazy<BillboardCesiumWriter> m_billboard = new Lazy<BillboardCesiumWriter>(() => new BillboardCesiumWriter(BillboardPropertyName), false);
        private readonly Lazy<PositionListCesiumWriter> m_vertexPositions = new Lazy<PositionListCesiumWriter>(() => new PositionListCesiumWriter(VertexPositionsPropertyName), false);
        private readonly Lazy<OrientationCesiumWriter> m_orientation = new Lazy<OrientationCesiumWriter>(() => new OrientationCesiumWriter(OrientationPropertyName), false);
        private readonly Lazy<PointCesiumWriter> m_point = new Lazy<PointCesiumWriter>(() => new PointCesiumWriter(PointPropertyName), false);
        private readonly Lazy<LabelCesiumWriter> m_label = new Lazy<LabelCesiumWriter>(() => new LabelCesiumWriter(LabelPropertyName), false);
        private readonly Lazy<PolylineCesiumWriter> m_polyline = new Lazy<PolylineCesiumWriter>(() => new PolylineCesiumWriter(PolylinePropertyName), false);
        private readonly Lazy<PathCesiumWriter> m_path = new Lazy<PathCesiumWriter>(() => new PathCesiumWriter(PathPropertyName), false);
        private readonly Lazy<PolygonCesiumWriter> m_polygon = new Lazy<PolygonCesiumWriter>(() => new PolygonCesiumWriter(PolygonPropertyName), false);
        private readonly Lazy<ConeCesiumWriter> m_cone = new Lazy<ConeCesiumWriter>(() => new ConeCesiumWriter(ConePropertyName), false);
        private readonly Lazy<PyramidCesiumWriter> m_pyramid = new Lazy<PyramidCesiumWriter>(() => new PyramidCesiumWriter(PyramidPropertyName), false);
        private readonly Lazy<EllipsoidCesiumWriter> m_ellipsoid = new Lazy<EllipsoidCesiumWriter>(() => new EllipsoidCesiumWriter(EllipsoidPropertyName), false);
        private readonly Lazy<ModelCesiumWriter> m_model = new Lazy<ModelCesiumWriter>(() => new ModelCesiumWriter(ModelPropertyName), false);
        private readonly Lazy<EllipseCesiumWriter> m_ellipse = new Lazy<EllipseCesiumWriter>(() => new EllipseCesiumWriter(EllipsePropertyName), false);
        private readonly Lazy<ClockCesiumWriter> m_clock = new Lazy<ClockCesiumWriter>(() => new ClockCesiumWriter(ClockPropertyName), false);
        private readonly Lazy<VectorCesiumWriter> m_vector = new Lazy<VectorCesiumWriter>(() => new VectorCesiumWriter(VectorPropertyName), false);

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
        /// Writes the <code>id</code> property.  The <code>id</code> property specifies the ID of the object described by this packet.  IDs do not need to be GUIDs, but they do need to uniquely identify a single object within a CZML source and any other CZML sources loaded into the same scope.  If this property is not specified, the client will automatically generate a unique one.  However, this prevents later packets from referring to this object in order to, for example, add more data to it.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteId(string value)
        {
            const string PropertyName = IdPropertyName;
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the <code>name</code> property.  The <code>name</code> property specifies the name of the object.  It does not have to be unique and is intended for user consumption.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteName(string value)
        {
            const string PropertyName = NamePropertyName;
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the <code>parent</code> property.  The <code>parent</code> property specifies the ID of the parent object or folder.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteParent(string value)
        {
            const string PropertyName = ParentPropertyName;
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Gets the writer for the <code>description</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>description</code> property defines an HTML description of the object.
        /// </summary>
        public StringCesiumWriter DescriptionWriter
        {
            get { return m_description.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>description</code> property.  The <code>description</code> property defines an HTML description of the object.
        /// </summary>
        public StringCesiumWriter OpenDescriptionProperty()
        {
            return OpenAndReturn(DescriptionWriter);
        }

        /// <summary>
        /// Writes a value for the <code>description</code> property as a <code>string</code> value.  The <code>description</code> property specifies an HTML description of the object.
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
        /// Writes a value for the <code>description</code> property as a <code>reference</code> value.  The <code>description</code> property specifies an HTML description of the object.
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
        /// Writes a value for the <code>description</code> property as a <code>reference</code> value.  The <code>description</code> property specifies an HTML description of the object.
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
        /// Writes a value for the <code>description</code> property as a <code>reference</code> value.  The <code>description</code> property specifies an HTML description of the object.
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
        /// Writes a value for the <code>description</code> property as a <code>reference</code> value.  The <code>description</code> property specifies an HTML description of the object.
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
        /// Writes the <code>availability</code> property.  The <code>availability</code> property specifies when data for an object is available. If data for an object is known to be available at the current animation time, but the client does not yet have that data (presumably because it will arrive in a later packet), the client will pause with a message like "Buffering..." while it waits to receive the data. The property can be a single string specifying a single interval, or an array of strings representing intervals.  A later Cesium packet can update this availability if it changes or is found to be incorrect. For example, an SGP4 propagator may report availability for all time, but then later the propagator throws an exception and the availability needs to be adjusted. If this optional property is not present, the object is assumed to be available for all time. Availability is scoped to a particular CZML stream, so two different streams can list different availability for a single object. Within a single stream, the last availability stated for an object is the one in effect and any availabilities in previous packets are ignored. If an object is available at a time, the client expects the object to have at least one property, and it expects all properties that it needs to be defined at that time. If the object doesn't have any properties, or a needed property is defined but not at the animation time, the client will pause animation and wait for more data.
        /// </summary>
        /// <param name="value">The interval.</param>
        public void WriteAvailability(TimeInterval value)
        {
            const string PropertyName = AvailabilityPropertyName;
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteTimeInterval(Output, value);
        }

        /// <summary>
        /// Writes the <code>availability</code> property.  The <code>availability</code> property specifies when data for an object is available. If data for an object is known to be available at the current animation time, but the client does not yet have that data (presumably because it will arrive in a later packet), the client will pause with a message like "Buffering..." while it waits to receive the data. The property can be a single string specifying a single interval, or an array of strings representing intervals.  A later Cesium packet can update this availability if it changes or is found to be incorrect. For example, an SGP4 propagator may report availability for all time, but then later the propagator throws an exception and the availability needs to be adjusted. If this optional property is not present, the object is assumed to be available for all time. Availability is scoped to a particular CZML stream, so two different streams can list different availability for a single object. Within a single stream, the last availability stated for an object is the one in effect and any availabilities in previous packets are ignored. If an object is available at a time, the client expects the object to have at least one property, and it expects all properties that it needs to be defined at that time. If the object doesn't have any properties, or a needed property is defined but not at the animation time, the client will pause animation and wait for more data.
        /// </summary>
        /// <param name="start">The earliest date of the interval.</param>
        /// <param name="stop">The latest date of the interval.</param>
        public void WriteAvailability(JulianDate start, JulianDate stop)
        {
            WriteAvailability(new TimeInterval(start, stop));
        }

        /// <summary>
        /// Writes the <code>availability</code> property.  The <code>availability</code> property specifies when data for an object is available. If data for an object is known to be available at the current animation time, but the client does not yet have that data (presumably because it will arrive in a later packet), the client will pause with a message like "Buffering..." while it waits to receive the data. The property can be a single string specifying a single interval, or an array of strings representing intervals.  A later Cesium packet can update this availability if it changes or is found to be incorrect. For example, an SGP4 propagator may report availability for all time, but then later the propagator throws an exception and the availability needs to be adjusted. If this optional property is not present, the object is assumed to be available for all time. Availability is scoped to a particular CZML stream, so two different streams can list different availability for a single object. Within a single stream, the last availability stated for an object is the one in effect and any availabilities in previous packets are ignored. If an object is available at a time, the client expects the object to have at least one property, and it expects all properties that it needs to be defined at that time. If the object doesn't have any properties, or a needed property is defined but not at the animation time, the client will pause animation and wait for more data.
        /// </summary>
        /// <param name="value">The intervals.</param>
        public void WriteAvailability(IList<TimeInterval> value)
        {
            const string PropertyName = AvailabilityPropertyName;
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteTimeIntervalCollection(Output, value);
        }

        /// <summary>
        /// Gets the writer for the <code>position</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>position</code> property defines the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
        /// </summary>
        public PositionCesiumWriter PositionWriter
        {
            get { return m_position.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>position</code> property.  The <code>position</code> property defines the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
        /// </summary>
        public PositionCesiumWriter OpenPositionProperty()
        {
            return OpenAndReturn(PositionWriter);
        }

        /// <summary>
        /// Writes a value for the <code>position</code> property as a <code>cartesian</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
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
        /// Writes a value for the <code>position</code> property as a <code>cartesian</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePositionProperty(IList<JulianDate> dates, IList<Cartesian> values)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesian(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>position</code> property as a <code>cartesian</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WritePositionProperty(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesian(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>position</code> property as a <code>cartographicRadians</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
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
        /// Writes a value for the <code>position</code> property as a <code>cartographicRadians</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the position is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePositionPropertyCartographicRadians(IList<JulianDate> dates, IList<Cartographic> values)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartographicRadians(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>position</code> property as a <code>cartographicRadians</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The position corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WritePositionPropertyCartographicRadians(IList<JulianDate> dates, IList<Cartographic> values, int startIndex, int length)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartographicRadians(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>position</code> property as a <code>cartographicDegrees</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
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
        /// Writes a value for the <code>position</code> property as a <code>cartographicDegrees</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the position is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePositionPropertyCartographicDegrees(IList<JulianDate> dates, IList<Cartographic> values)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartographicDegrees(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>position</code> property as a <code>cartographicDegrees</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The position corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WritePositionPropertyCartographicDegrees(IList<JulianDate> dates, IList<Cartographic> values, int startIndex, int length)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartographicDegrees(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>position</code> property as a <code>cartesianVelocity</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
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
        /// Writes a value for the <code>position</code> property as a <code>cartesianVelocity</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePositionPropertyCartesianVelocity(IList<JulianDate> dates, IList<Motion<Cartesian>> values)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesianVelocity(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>position</code> property as a <code>cartesianVelocity</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WritePositionPropertyCartesianVelocity(IList<JulianDate> dates, IList<Motion<Cartesian>> values, int startIndex, int length)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesianVelocity(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>position</code> property as a <code>reference</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
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
        /// Writes a value for the <code>position</code> property as a <code>reference</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
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
        /// Writes a value for the <code>position</code> property as a <code>reference</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
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
        /// Writes a value for the <code>position</code> property as a <code>reference</code> value.  The <code>position</code> property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other primitives attached to the object.
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
        /// Gets the writer for the <code>billboard</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>billboard</code> property defines a billboard, or viewport-aligned image. The billboard is positioned in the scene by the position property. A billboard is sometimes called a marker.
        /// </summary>
        public BillboardCesiumWriter BillboardWriter
        {
            get { return m_billboard.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>billboard</code> property.  The <code>billboard</code> property defines a billboard, or viewport-aligned image. The billboard is positioned in the scene by the position property. A billboard is sometimes called a marker.
        /// </summary>
        public BillboardCesiumWriter OpenBillboardProperty()
        {
            return OpenAndReturn(BillboardWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>vertexPositions</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>vertexPositions</code> property defines the world-space positions of vertices.  The vertex positions have no direct visual representation, but they are used to define polygons, polylines, and other objects attached to the object.
        /// </summary>
        public PositionListCesiumWriter VertexPositionsWriter
        {
            get { return m_vertexPositions.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>vertexPositions</code> property.  The <code>vertexPositions</code> property defines the world-space positions of vertices.  The vertex positions have no direct visual representation, but they are used to define polygons, polylines, and other objects attached to the object.
        /// </summary>
        public PositionListCesiumWriter OpenVertexPositionsProperty()
        {
            return OpenAndReturn(VertexPositionsWriter);
        }

        /// <summary>
        /// Writes a value for the <code>vertexPositions</code> property as a <code>cartesian</code> value.  The <code>vertexPositions</code> property specifies the world-space positions of vertices.  The vertex positions have no direct visual representation, but they are used to define polygons, polylines, and other objects attached to the object.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteVertexPositionsProperty(IEnumerable<Cartesian> values)
        {
            using (var writer = OpenVertexPositionsProperty())
            {
                writer.WriteCartesian(values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>vertexPositions</code> property as a <code>cartographicRadians</code> value.  The <code>vertexPositions</code> property specifies the world-space positions of vertices.  The vertex positions have no direct visual representation, but they are used to define polygons, polylines, and other objects attached to the object.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteVertexPositionsPropertyCartographicRadians(IEnumerable<Cartographic> values)
        {
            using (var writer = OpenVertexPositionsProperty())
            {
                writer.WriteCartographicRadians(values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>vertexPositions</code> property as a <code>cartographicDegrees</code> value.  The <code>vertexPositions</code> property specifies the world-space positions of vertices.  The vertex positions have no direct visual representation, but they are used to define polygons, polylines, and other objects attached to the object.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteVertexPositionsPropertyCartographicDegrees(IEnumerable<Cartographic> values)
        {
            using (var writer = OpenVertexPositionsProperty())
            {
                writer.WriteCartographicDegrees(values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>vertexPositions</code> property as a <code>references</code> value.  The <code>vertexPositions</code> property specifies the world-space positions of vertices.  The vertex positions have no direct visual representation, but they are used to define polygons, polylines, and other objects attached to the object.
        /// </summary>
        /// <param name="references">The list of references.</param>
        public void WriteVertexPositionsPropertyReferences(IEnumerable<Reference> references)
        {
            using (var writer = OpenVertexPositionsProperty())
            {
                writer.WriteReferences(references);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>orientation</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>orientation</code> property defines the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
        /// </summary>
        public OrientationCesiumWriter OrientationWriter
        {
            get { return m_orientation.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>orientation</code> property.  The <code>orientation</code> property defines the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
        /// </summary>
        public OrientationCesiumWriter OpenOrientationProperty()
        {
            return OpenAndReturn(OrientationWriter);
        }

        /// <summary>
        /// Writes a value for the <code>orientation</code> property as a <code>unitQuaternion</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
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
        /// Writes a value for the <code>orientation</code> property as a <code>unitQuaternion</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the rotation is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteOrientationProperty(IList<JulianDate> dates, IList<UnitQuaternion> values)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteUnitQuaternion(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>orientation</code> property as a <code>unitQuaternion</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
        /// </summary>
        /// <param name="dates">The dates at which the rotation is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteOrientationProperty(IList<JulianDate> dates, IList<UnitQuaternion> values, int startIndex, int length)
        {
            using (var writer = OpenOrientationProperty())
            {
                writer.WriteUnitQuaternion(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>orientation</code> property as a <code>reference</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
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
        /// Writes a value for the <code>orientation</code> property as a <code>reference</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
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
        /// Writes a value for the <code>orientation</code> property as a <code>reference</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
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
        /// Writes a value for the <code>orientation</code> property as a <code>reference</code> value.  The <code>orientation</code> property specifies the orientation of the object in the world.  The orientation has no direct visual representation, but it is used to orient models, cones, and pyramids attached to the object.
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
        /// Gets the writer for the <code>point</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>point</code> property defines a point, or viewport-aligned circle.  The point is positioned in the scene by the `position` property.
        /// </summary>
        public PointCesiumWriter PointWriter
        {
            get { return m_point.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>point</code> property.  The <code>point</code> property defines a point, or viewport-aligned circle.  The point is positioned in the scene by the `position` property.
        /// </summary>
        public PointCesiumWriter OpenPointProperty()
        {
            return OpenAndReturn(PointWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>label</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>label</code> property defines a string of text.  The label is positioned in the scene by the `position` property.
        /// </summary>
        public LabelCesiumWriter LabelWriter
        {
            get { return m_label.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>label</code> property.  The <code>label</code> property defines a string of text.  The label is positioned in the scene by the `position` property.
        /// </summary>
        public LabelCesiumWriter OpenLabelProperty()
        {
            return OpenAndReturn(LabelWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>polyline</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>polyline</code> property defines a polyline, which is a line in the scene composed of multiple segments.  The vertices of the polyline are specified by the `vertexPositions` property.
        /// </summary>
        public PolylineCesiumWriter PolylineWriter
        {
            get { return m_polyline.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>polyline</code> property.  The <code>polyline</code> property defines a polyline, which is a line in the scene composed of multiple segments.  The vertices of the polyline are specified by the `vertexPositions` property.
        /// </summary>
        public PolylineCesiumWriter OpenPolylineProperty()
        {
            return OpenAndReturn(PolylineWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>path</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>path</code> property defines a path, which is a polyline defined by the motion of an object over time.  The possible vertices of the path are specified by the `position` property.
        /// </summary>
        public PathCesiumWriter PathWriter
        {
            get { return m_path.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>path</code> property.  The <code>path</code> property defines a path, which is a polyline defined by the motion of an object over time.  The possible vertices of the path are specified by the `position` property.
        /// </summary>
        public PathCesiumWriter OpenPathProperty()
        {
            return OpenAndReturn(PathWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>polygon</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>polygon</code> property defines a polygon, which is a closed figure on the surface of the Earth.  The vertices of the polygon are specified by the `vertexPositions` property.
        /// </summary>
        public PolygonCesiumWriter PolygonWriter
        {
            get { return m_polygon.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>polygon</code> property.  The <code>polygon</code> property defines a polygon, which is a closed figure on the surface of the Earth.  The vertices of the polygon are specified by the `vertexPositions` property.
        /// </summary>
        public PolygonCesiumWriter OpenPolygonProperty()
        {
            return OpenAndReturn(PolygonWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>cone</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>cone</code> property defines a cone.  A cone starts at a point or apex and extends in a circle of directions which all have the same angular separation from the Z-axis of the object to which the cone is attached.  The cone may be capped at a radial limit, it may have an inner hole, and it may be only a part of a complete cone defined by clock angle limits.  The apex point of the cone is defined by the `position` property and extends in the direction of the Z-axis as defined by the `orientation` property.
        /// </summary>
        public ConeCesiumWriter ConeWriter
        {
            get { return m_cone.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>cone</code> property.  The <code>cone</code> property defines a cone.  A cone starts at a point or apex and extends in a circle of directions which all have the same angular separation from the Z-axis of the object to which the cone is attached.  The cone may be capped at a radial limit, it may have an inner hole, and it may be only a part of a complete cone defined by clock angle limits.  The apex point of the cone is defined by the `position` property and extends in the direction of the Z-axis as defined by the `orientation` property.
        /// </summary>
        public ConeCesiumWriter OpenConeProperty()
        {
            return OpenAndReturn(ConeWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>pyramid</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>pyramid</code> property defines a pyramid.  A pyramid starts at a point or apex and extends in a specified list of directions from the apex.  Each pair of directions forms a face of the pyramid.  The pyramid may be capped at a radial limit.
        /// </summary>
        public PyramidCesiumWriter PyramidWriter
        {
            get { return m_pyramid.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>pyramid</code> property.  The <code>pyramid</code> property defines a pyramid.  A pyramid starts at a point or apex and extends in a specified list of directions from the apex.  Each pair of directions forms a face of the pyramid.  The pyramid may be capped at a radial limit.
        /// </summary>
        public PyramidCesiumWriter OpenPyramidProperty()
        {
            return OpenAndReturn(PyramidWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>ellipsoid</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>ellipsoid</code> property defines an ellipsoid, which is a closed quadric surface that is a three dimensional analogue of an ellipse.  The ellipsoid is positioned and oriented using the `position` and `orientation` properties.
        /// </summary>
        public EllipsoidCesiumWriter EllipsoidWriter
        {
            get { return m_ellipsoid.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>ellipsoid</code> property.  The <code>ellipsoid</code> property defines an ellipsoid, which is a closed quadric surface that is a three dimensional analogue of an ellipse.  The ellipsoid is positioned and oriented using the `position` and `orientation` properties.
        /// </summary>
        public EllipsoidCesiumWriter OpenEllipsoidProperty()
        {
            return OpenAndReturn(EllipsoidWriter);
        }

        /// <summary>
        /// Writes the <code>viewFrom</code> property.  The <code>viewFrom</code> property specifies a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the objects position property.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteViewFrom(Cartesian value)
        {
            const string PropertyName = ViewFromPropertyName;
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian3(Output, value);
        }

        /// <summary>
        /// Writes the <code>viewFrom</code> property.  The <code>viewFrom</code> property specifies a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the objects position property.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteViewFrom(IList<JulianDate> dates, IList<Cartesian> values)
        {
            WriteViewFrom(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the <code>viewFrom</code> property.  The <code>viewFrom</code> property specifies a suggested camera location when viewing this object.  The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the objects position property.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteViewFrom(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            const string PropertyName = ViewFromPropertyName;
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian3(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Gets the writer for the <code>model</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>model</code> property defines a 3D model.  The model is positioned and oriented using the `position` and `orientation` properties.
        /// </summary>
        public ModelCesiumWriter ModelWriter
        {
            get { return m_model.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>model</code> property.  The <code>model</code> property defines a 3D model.  The model is positioned and oriented using the `position` and `orientation` properties.
        /// </summary>
        public ModelCesiumWriter OpenModelProperty()
        {
            return OpenAndReturn(ModelWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>ellipse</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>ellipse</code> property defines an ellipse, which is a closed curve on the surface of the Earth.  The ellipse is positioned using the `position` property.
        /// </summary>
        public EllipseCesiumWriter EllipseWriter
        {
            get { return m_ellipse.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>ellipse</code> property.  The <code>ellipse</code> property defines an ellipse, which is a closed curve on the surface of the Earth.  The ellipse is positioned using the `position` property.
        /// </summary>
        public EllipseCesiumWriter OpenEllipseProperty()
        {
            return OpenAndReturn(EllipseWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>clock</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>clock</code> property defines a simulated clock.
        /// </summary>
        public ClockCesiumWriter ClockWriter
        {
            get { return m_clock.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>clock</code> property.  The <code>clock</code> property defines a simulated clock.
        /// </summary>
        public ClockCesiumWriter OpenClockProperty()
        {
            return OpenAndReturn(ClockWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>vector</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>vector</code> property defines defines a graphical vector that originates at the `position` property and extends in the provided direction for the provided length.
        /// </summary>
        public VectorCesiumWriter VectorWriter
        {
            get { return m_vector.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>vector</code> property.  The <code>vector</code> property defines defines a graphical vector that originates at the `position` property and extends in the provided direction for the provided length.
        /// </summary>
        public VectorCesiumWriter OpenVectorProperty()
        {
            return OpenAndReturn(VectorWriter);
        }

    }
}
