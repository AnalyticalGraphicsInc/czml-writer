using System;
#if StkComponents
using AGI.Foundation.Cesium.Advanced;
using AGI.Foundation.Time;
#else
using CesiumLanguageWriter.Advanced;
using System.Collections.Generic;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// Writes a packet to a <topic name="Cesium">Cesium</topic> stream.  A packet describes one or more graphical
    /// properties for a single object.  Instances of this class should generally not be constructed directly, but instead obtained
    /// by calling <see cref="CesiumStreamWriter.OpenPacket">CesiumWriter.NewPacket</see>.
    /// </summary>
    public class CesiumPacketWriter : CesiumElementWriter
    {
        private readonly Lazy<PositionCesiumWriter> m_position = new Lazy<PositionCesiumWriter>(() => new PositionCesiumWriter("position"), false);
        private readonly Lazy<BillboardCesiumWriter> m_billboard = new Lazy<BillboardCesiumWriter>(() => new BillboardCesiumWriter("billboard"), false);
        private readonly Lazy<PointGraphicsCesiumWriter> m_pointGraphics = new Lazy<PointGraphicsCesiumWriter>(() => new PointGraphicsCesiumWriter("point"), false);
        private readonly Lazy<ConeCesiumWriter> m_cone = new Lazy<ConeCesiumWriter>(() => new ConeCesiumWriter("cone"), false);
        private readonly Lazy<LabelCesiumWriter> m_label = new Lazy<LabelCesiumWriter>(() => new LabelCesiumWriter("label"), false);
        private readonly Lazy<OrientationAxesCesiumWriter> m_orientation = new Lazy<OrientationAxesCesiumWriter>(() => new OrientationAxesCesiumWriter("orientation"), false);
        private readonly Lazy<PyramidCesiumWriter> m_pyramid = new Lazy<PyramidCesiumWriter>(() => new PyramidCesiumWriter("pyramid"), false);
        private readonly Lazy<PathCesiumWriter> m_path = new Lazy<PathCesiumWriter>(() => new PathCesiumWriter("path"), false);
        private readonly Lazy<PolylineCesiumWriter> m_polyline = new Lazy<PolylineCesiumWriter>(() => new PolylineCesiumWriter("polyline"), false);
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
        /// Writes the identifier of the object described by this packet.  If the packet does not specify an ID, the
        /// <topic name="Cesium">Cesium</topic> client will generate one automatically.  However, an object with
        /// an automatically-generated ID cannot be updated or referenced by later packets.  This method may only
        /// be called once for a given <see cref="CesiumPacketWriter"/>.
        /// </summary>
        /// <param name="id">The ID of the object described by this packet.</param>
        public void WriteIdentifier(string id)
        {
            Output.WritePropertyName("id");
            Output.WriteValue(id);
        }

        /// <summary>
        /// Writes the availability interval of this object.  If the <topic name="Cesium">Cesium</topic> client
        /// knows an object to be available but it does not yet have that data itself, it may wait for the data to
        /// arrive before allowing animation to proceed.
        /// </summary>
        /// <param name="startAvailability">The earliest date of availability of the object.</param>
        /// <param name="endAvailability">The latest date of availability of the object.</param>
        public void WriteAvailability(JulianDate startAvailability, JulianDate endAvailability)
        {
            WriteAvailability(new TimeInterval(startAvailability, endAvailability));
        }

        /// <summary>
        /// Writes the availability interval of this object.  If the <topic name="Cesium">Cesium</topic> client
        /// knows an object to be available but it does not yet have that data itself, it may wait for the data to
        /// arrive before allowing animation to proceed.
        /// </summary>
        /// <param name="availability">The availability interval of the object.</param>
        public void WriteAvailability(TimeInterval availability)
        {
            Output.WritePropertyName("availability");
            Output.WriteValue(CesiumFormattingHelper.ToIso8601Interval(availability.Start, availability.Stop));
        }

#if StkComponents
        /// <summary>
        /// Writes the availability intervals of this object.  If the <topic name="Cesium">Cesium</topic> client
        /// knows an object to be available but it does not yet have that data itself, it may wait for the data to
        /// arrive before allowing animation to proceed.
        /// </summary>
        /// <param name="availability">The availability intervals of the object.</param>
        public void WriteAvailability(TimeIntervalCollection availability)
        {
            IList<TimeInterval> availabilityAsList = availability;
            WriteAvailability(availabilityAsList);
        }
#endif

        /// <summary>
        /// Writes the availability intervals of this object.  If the <topic name="Cesium">Cesium</topic> client
        /// knows an object to be available but it does not yet have that data itself, it may wait for the data to
        /// arrive before allowing animation to proceed.
        /// </summary>
        /// <param name="availability">The availability intervals of the object.</param>
        public void WriteAvailability(IList<TimeInterval> availability)
        {
            Output.WritePropertyName("availability");
            if (availability.Count == 1)
            {
                TimeInterval interval = availability[0];
                Output.WriteValue(CesiumFormattingHelper.ToIso8601Interval(interval.Start, interval.Stop));
            }
            else
            {
                Output.WriteStartSequence();
                foreach (TimeInterval interval in availability)
                {
                    Output.WriteValue(CesiumFormattingHelper.ToIso8601Interval(interval.Start, interval.Stop));
                }
                Output.WriteEndSequence();
            }
        }

        /// <summary>
        /// Gets the writer for the <code>position</code> property.  See the documentation for the 
        /// <see cref="OpenPositionProperty"/> method for more information.  The returned instance must
        /// be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be
        /// used for writing.
        /// </summary>
        public PositionCesiumWriter PositionWriter
        {
            get { return m_position.Value; }
        }

        /// <summary>
        /// Opens a property describing the position of an object, optionally over time.
        /// </summary>
        /// <returns>A writer that is used to write position information.</returns>
        public PositionCesiumWriter OpenPositionProperty()
        {
            return OpenAndReturn(PositionWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>orientation</code> property.  See the documentation for the 
        /// <see cref="OpenOrientationProperty"/> method for more information.  The returned instance must
        /// be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be
        /// used for writing.
        /// </summary>
        public OrientationAxesCesiumWriter OrientationWriter
        {
            get { return m_orientation.Value; }
        }

        /// <summary>
        /// Opens a property describing the orientation of an object, optionally over time.
        /// </summary>
        /// <returns>A writer that is used to write position information.</returns>
        public OrientationAxesCesiumWriter OpenOrientationProperty()
        {
            return OpenAndReturn(OrientationWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>billboard</code> property.  See the documentation for the 
        /// <see cref="OpenBillboardProperty"/> method for more information.  The returned instance must
        /// be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be
        /// used for writing.
        /// </summary>
        public BillboardCesiumWriter BillboardWriter
        {
            get { return m_billboard.Value; }
        }

        /// <summary>
        /// Gets a group of billboard-related properties.  A billboard is a viewport-aligned image positioned
        /// in the 3D scene, and is sometimes called a marker.
        /// </summary>
        public BillboardCesiumWriter OpenBillboardProperty()
        {
            return OpenAndReturn(BillboardWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>label</code> property.  See the documentation for the 
        /// <see cref="OpenLabelProperty"/> method for more information.  The returned instance must
        /// be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be
        /// used for writing.
        /// </summary>
        public LabelCesiumWriter LabelWriter
        {
            get { return m_label.Value; }
        }

        /// <summary>
        /// Gets a group of label-related properties.  A label is viewport-aligned text positioned
        /// in the 3D scene.
        /// </summary>
        public LabelCesiumWriter OpenLabelProperty()
        {
            return OpenAndReturn(LabelWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>point</code> property.  See the documentation for the 
        /// <see cref="OpenPointProperty"/> method for more information.  The returned instance must
        /// be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be
        /// used for writing.
        /// </summary>
        public PointGraphicsCesiumWriter PointWriter
        {
            get { return m_pointGraphics.Value; }
        }

        /// <summary>
        /// Gets a group of point-related properties.  A point is a filled circle positioned
        /// in the 3D scene.
        /// </summary>
        public PointGraphicsCesiumWriter OpenPointProperty()
        {
            return OpenAndReturn(PointWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>cone</code> property.  See the documentation for the 
        /// <see cref="OpenConeProperty"/> method for more information.  The returned instance must
        /// be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be
        /// used for writing.
        /// </summary>
        public ConeCesiumWriter ConeWriter
        {
            get { return m_cone.Value; }
        }

        /// <summary>
        /// Gets a group of cone-related properties.  A cone starts at a point and extends in a circle of directions
        /// which all have the same angular separation from a reference direction.  The cone may be capped at a radial
        /// limit, it may have an inner hole, and it may be only a part of a complete cone defined by clock angle
        /// limits.
        /// </summary>
        public ConeCesiumWriter OpenConeProperty()
        {
            return OpenAndReturn(ConeWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>cone</code> property.  See the documentation for the 
        /// <see cref="OpenPyramidProperty"/> method for more information.  The returned instance must
        /// be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be
        /// used for writing.
        /// </summary>
        public PyramidCesiumWriter PyramidWriter
        {
            get { return m_pyramid.Value; }
        }

        /// <summary>
        /// Gets a group of pyramid-related properties.  
        /// </summary>
        public PyramidCesiumWriter OpenPyramidProperty()
        {
            return OpenAndReturn(PyramidWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>path</code> property.  See the documentation for the 
        /// <see cref="OpenPathProperty"/> method for more information.  The returned instance must
        /// be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be
        /// used for writing.
        /// </summary>
        public PathCesiumWriter PathWriter
        {
            get { return m_path.Value; }
        }

        /// <summary>
        /// Gets a group of path-related properties.  
        /// </summary>
        public PathCesiumWriter OpenPathProperty()
        {
            return OpenAndReturn(PathWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>polyline</code> property.  See the documentation for the 
        /// <see cref="OpenPolylineProperty"/> method for more information.  The returned instance must
        /// be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be
        /// used for writing.
        /// </summary>
        public PolylineCesiumWriter PolylineWriter
        {
            get { return m_polyline.Value; }
        }

        /// <summary>
        /// Gets a group of polyline-related properties.  
        /// </summary>
        public PolylineCesiumWriter OpenPolylineProperty()
        {
            return OpenAndReturn(PolylineWriter);
        }
    }
}
