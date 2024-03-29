package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BillboardCesiumWriter;
import cesiumlanguagewriter.BoxCesiumWriter;
import cesiumlanguagewriter.ClockCesiumWriter;
import cesiumlanguagewriter.ConicSensorCesiumWriter;
import cesiumlanguagewriter.CorridorCesiumWriter;
import cesiumlanguagewriter.CustomPatternSensorCesiumWriter;
import cesiumlanguagewriter.CustomPropertiesCesiumWriter;
import cesiumlanguagewriter.CylinderCesiumWriter;
import cesiumlanguagewriter.EllipseCesiumWriter;
import cesiumlanguagewriter.EllipsoidCesiumWriter;
import cesiumlanguagewriter.FanCesiumWriter;
import cesiumlanguagewriter.LabelCesiumWriter;
import cesiumlanguagewriter.ModelCesiumWriter;
import cesiumlanguagewriter.OrientationCesiumWriter;
import cesiumlanguagewriter.PathCesiumWriter;
import cesiumlanguagewriter.PointCesiumWriter;
import cesiumlanguagewriter.PolygonCesiumWriter;
import cesiumlanguagewriter.PolylineCesiumWriter;
import cesiumlanguagewriter.PolylineVolumeCesiumWriter;
import cesiumlanguagewriter.PositionCesiumWriter;
import cesiumlanguagewriter.RectangleCesiumWriter;
import cesiumlanguagewriter.RectangularSensorCesiumWriter;
import cesiumlanguagewriter.StringCesiumWriter;
import cesiumlanguagewriter.TilesetCesiumWriter;
import cesiumlanguagewriter.VectorCesiumWriter;
import cesiumlanguagewriter.ViewFromCesiumWriter;
import cesiumlanguagewriter.WallCesiumWriter;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code Packet} to a {@link CesiumOutputStream}. A {@code Packet} is describes the graphical properties of a single object in a scene, such as a single aircraft.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class PacketCesiumWriter extends CesiumElementWriter {
    /**
    * The name of the {@code id} property.
    */
    @Nonnull
    public static final String IdPropertyName = "id";
    /**
    * The name of the {@code delete} property.
    */
    @Nonnull
    public static final String DeletePropertyName = "delete";
    /**
    * The name of the {@code name} property.
    */
    @Nonnull
    public static final String NamePropertyName = "name";
    /**
    * The name of the {@code parent} property.
    */
    @Nonnull
    public static final String ParentPropertyName = "parent";
    /**
    * The name of the {@code description} property.
    */
    @Nonnull
    public static final String DescriptionPropertyName = "description";
    /**
    * The name of the {@code clock} property.
    */
    @Nonnull
    public static final String ClockPropertyName = "clock";
    /**
    * The name of the {@code version} property.
    */
    @Nonnull
    public static final String VersionPropertyName = "version";
    /**
    * The name of the {@code availability} property.
    */
    @Nonnull
    public static final String AvailabilityPropertyName = "availability";
    /**
    * The name of the {@code properties} property.
    */
    @Nonnull
    public static final String PropertiesPropertyName = "properties";
    /**
    * The name of the {@code position} property.
    */
    @Nonnull
    public static final String PositionPropertyName = "position";
    /**
    * The name of the {@code orientation} property.
    */
    @Nonnull
    public static final String OrientationPropertyName = "orientation";
    /**
    * The name of the {@code viewFrom} property.
    */
    @Nonnull
    public static final String ViewFromPropertyName = "viewFrom";
    /**
    * The name of the {@code billboard} property.
    */
    @Nonnull
    public static final String BillboardPropertyName = "billboard";
    /**
    * The name of the {@code box} property.
    */
    @Nonnull
    public static final String BoxPropertyName = "box";
    /**
    * The name of the {@code corridor} property.
    */
    @Nonnull
    public static final String CorridorPropertyName = "corridor";
    /**
    * The name of the {@code cylinder} property.
    */
    @Nonnull
    public static final String CylinderPropertyName = "cylinder";
    /**
    * The name of the {@code ellipse} property.
    */
    @Nonnull
    public static final String EllipsePropertyName = "ellipse";
    /**
    * The name of the {@code ellipsoid} property.
    */
    @Nonnull
    public static final String EllipsoidPropertyName = "ellipsoid";
    /**
    * The name of the {@code label} property.
    */
    @Nonnull
    public static final String LabelPropertyName = "label";
    /**
    * The name of the {@code model} property.
    */
    @Nonnull
    public static final String ModelPropertyName = "model";
    /**
    * The name of the {@code path} property.
    */
    @Nonnull
    public static final String PathPropertyName = "path";
    /**
    * The name of the {@code point} property.
    */
    @Nonnull
    public static final String PointPropertyName = "point";
    /**
    * The name of the {@code polygon} property.
    */
    @Nonnull
    public static final String PolygonPropertyName = "polygon";
    /**
    * The name of the {@code polyline} property.
    */
    @Nonnull
    public static final String PolylinePropertyName = "polyline";
    /**
    * The name of the {@code polylineVolume} property.
    */
    @Nonnull
    public static final String PolylineVolumePropertyName = "polylineVolume";
    /**
    * The name of the {@code rectangle} property.
    */
    @Nonnull
    public static final String RectanglePropertyName = "rectangle";
    /**
    * The name of the {@code tileset} property.
    */
    @Nonnull
    public static final String TilesetPropertyName = "tileset";
    /**
    * The name of the {@code wall} property.
    */
    @Nonnull
    public static final String WallPropertyName = "wall";
    /**
    * The name of the {@code agi_conicSensor} property.
    */
    @Nonnull
    public static final String ConicSensorPropertyName = "agi_conicSensor";
    /**
    * The name of the {@code agi_customPatternSensor} property.
    */
    @Nonnull
    public static final String CustomPatternSensorPropertyName = "agi_customPatternSensor";
    /**
    * The name of the {@code agi_rectangularSensor} property.
    */
    @Nonnull
    public static final String RectangularSensorPropertyName = "agi_rectangularSensor";
    /**
    * The name of the {@code agi_fan} property.
    */
    @Nonnull
    public static final String FanPropertyName = "agi_fan";
    /**
    * The name of the {@code agi_vector} property.
    */
    @Nonnull
    public static final String VectorPropertyName = "agi_vector";
    @Nonnull
    private final Lazy<StringCesiumWriter> m_description = new Lazy<StringCesiumWriter>(new Func1<StringCesiumWriter>() {
        public StringCesiumWriter invoke() {
            return new StringCesiumWriter(DescriptionPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ClockCesiumWriter> m_clock = new Lazy<ClockCesiumWriter>(new Func1<ClockCesiumWriter>() {
        public ClockCesiumWriter invoke() {
            return new ClockCesiumWriter(ClockPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<CustomPropertiesCesiumWriter> m_properties = new Lazy<CustomPropertiesCesiumWriter>(new Func1<CustomPropertiesCesiumWriter>() {
        public CustomPropertiesCesiumWriter invoke() {
            return new CustomPropertiesCesiumWriter(PropertiesPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<PositionCesiumWriter> m_position = new Lazy<PositionCesiumWriter>(new Func1<PositionCesiumWriter>() {
        public PositionCesiumWriter invoke() {
            return new PositionCesiumWriter(PositionPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<OrientationCesiumWriter> m_orientation = new Lazy<OrientationCesiumWriter>(new Func1<OrientationCesiumWriter>() {
        public OrientationCesiumWriter invoke() {
            return new OrientationCesiumWriter(OrientationPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ViewFromCesiumWriter> m_viewFrom = new Lazy<ViewFromCesiumWriter>(new Func1<ViewFromCesiumWriter>() {
        public ViewFromCesiumWriter invoke() {
            return new ViewFromCesiumWriter(ViewFromPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<BillboardCesiumWriter> m_billboard = new Lazy<BillboardCesiumWriter>(new Func1<BillboardCesiumWriter>() {
        public BillboardCesiumWriter invoke() {
            return new BillboardCesiumWriter(BillboardPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<BoxCesiumWriter> m_box = new Lazy<BoxCesiumWriter>(new Func1<BoxCesiumWriter>() {
        public BoxCesiumWriter invoke() {
            return new BoxCesiumWriter(BoxPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<CorridorCesiumWriter> m_corridor = new Lazy<CorridorCesiumWriter>(new Func1<CorridorCesiumWriter>() {
        public CorridorCesiumWriter invoke() {
            return new CorridorCesiumWriter(CorridorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<CylinderCesiumWriter> m_cylinder = new Lazy<CylinderCesiumWriter>(new Func1<CylinderCesiumWriter>() {
        public CylinderCesiumWriter invoke() {
            return new CylinderCesiumWriter(CylinderPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<EllipseCesiumWriter> m_ellipse = new Lazy<EllipseCesiumWriter>(new Func1<EllipseCesiumWriter>() {
        public EllipseCesiumWriter invoke() {
            return new EllipseCesiumWriter(EllipsePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<EllipsoidCesiumWriter> m_ellipsoid = new Lazy<EllipsoidCesiumWriter>(new Func1<EllipsoidCesiumWriter>() {
        public EllipsoidCesiumWriter invoke() {
            return new EllipsoidCesiumWriter(EllipsoidPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<LabelCesiumWriter> m_label = new Lazy<LabelCesiumWriter>(new Func1<LabelCesiumWriter>() {
        public LabelCesiumWriter invoke() {
            return new LabelCesiumWriter(LabelPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ModelCesiumWriter> m_model = new Lazy<ModelCesiumWriter>(new Func1<ModelCesiumWriter>() {
        public ModelCesiumWriter invoke() {
            return new ModelCesiumWriter(ModelPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<PathCesiumWriter> m_path = new Lazy<PathCesiumWriter>(new Func1<PathCesiumWriter>() {
        public PathCesiumWriter invoke() {
            return new PathCesiumWriter(PathPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<PointCesiumWriter> m_point = new Lazy<PointCesiumWriter>(new Func1<PointCesiumWriter>() {
        public PointCesiumWriter invoke() {
            return new PointCesiumWriter(PointPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<PolygonCesiumWriter> m_polygon = new Lazy<PolygonCesiumWriter>(new Func1<PolygonCesiumWriter>() {
        public PolygonCesiumWriter invoke() {
            return new PolygonCesiumWriter(PolygonPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<PolylineCesiumWriter> m_polyline = new Lazy<PolylineCesiumWriter>(new Func1<PolylineCesiumWriter>() {
        public PolylineCesiumWriter invoke() {
            return new PolylineCesiumWriter(PolylinePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<PolylineVolumeCesiumWriter> m_polylineVolume = new Lazy<PolylineVolumeCesiumWriter>(new Func1<PolylineVolumeCesiumWriter>() {
        public PolylineVolumeCesiumWriter invoke() {
            return new PolylineVolumeCesiumWriter(PolylineVolumePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<RectangleCesiumWriter> m_rectangle = new Lazy<RectangleCesiumWriter>(new Func1<RectangleCesiumWriter>() {
        public RectangleCesiumWriter invoke() {
            return new RectangleCesiumWriter(RectanglePropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<TilesetCesiumWriter> m_tileset = new Lazy<TilesetCesiumWriter>(new Func1<TilesetCesiumWriter>() {
        public TilesetCesiumWriter invoke() {
            return new TilesetCesiumWriter(TilesetPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<WallCesiumWriter> m_wall = new Lazy<WallCesiumWriter>(new Func1<WallCesiumWriter>() {
        public WallCesiumWriter invoke() {
            return new WallCesiumWriter(WallPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<ConicSensorCesiumWriter> m_agi_conicSensor = new Lazy<ConicSensorCesiumWriter>(new Func1<ConicSensorCesiumWriter>() {
        public ConicSensorCesiumWriter invoke() {
            return new ConicSensorCesiumWriter(ConicSensorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<CustomPatternSensorCesiumWriter> m_agi_customPatternSensor = new Lazy<CustomPatternSensorCesiumWriter>(new Func1<CustomPatternSensorCesiumWriter>() {
        public CustomPatternSensorCesiumWriter invoke() {
            return new CustomPatternSensorCesiumWriter(CustomPatternSensorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<RectangularSensorCesiumWriter> m_agi_rectangularSensor = new Lazy<RectangularSensorCesiumWriter>(new Func1<RectangularSensorCesiumWriter>() {
        public RectangularSensorCesiumWriter invoke() {
            return new RectangularSensorCesiumWriter(RectangularSensorPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<FanCesiumWriter> m_agi_fan = new Lazy<FanCesiumWriter>(new Func1<FanCesiumWriter>() {
        public FanCesiumWriter invoke() {
            return new FanCesiumWriter(FanPropertyName);
        }
    }, false);
    @Nonnull
    private final Lazy<VectorCesiumWriter> m_agi_vector = new Lazy<VectorCesiumWriter>(new Func1<VectorCesiumWriter>() {
        public VectorCesiumWriter invoke() {
            return new VectorCesiumWriter(VectorPropertyName);
        }
    }, false);

    /**
    * Writes the start of a new JSON object representing the packet.
    */
    @Override
    protected void onOpen() {
        getOutput().writeStartObject();
    }

    /**
    * Writes the end of the JSON object representing the packet.
    */
    @Override
    protected void onClose() {
        getOutput().writeEndObject();
    }

    /**
    * Writes the value expressed as a {@code id}, which is the ID of the object described by this packet. IDs do not need to be GUIDs, but they do need to uniquely identify a single object within a CZML source and any other CZML sources loaded into the same scope. If this property is not specified, the client will automatically generate a unique one. However, this prevents later packets from referring to this object in order to add more data to it.
    * @param value The value.
    */
    public final void writeId(String value) {
        final String PropertyName = IdPropertyName;
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    * Writes the value expressed as a {@code delete}, which is whether the client should delete all existing data for this object, identified by ID. If true, all other properties in this packet will be ignored.
    * @param value The value.
    */
    public final void writeDelete(boolean value) {
        final String PropertyName = DeletePropertyName;
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    * Writes the value expressed as a {@code name}, which is the name of the object. It does not have to be unique and is intended for user consumption.
    * @param value The value.
    */
    public final void writeName(String value) {
        final String PropertyName = NamePropertyName;
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    * Writes the value expressed as a {@code parent}, which is the ID of the parent object, if any.
    * @param value The value.
    */
    public final void writeParent(String value) {
        final String PropertyName = ParentPropertyName;
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    * Gets the writer for the {@code description} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code description} property defines an HTML description of the object.
    */
    @Nonnull
    public final StringCesiumWriter getDescriptionWriter() {
        return m_description.getValue();
    }

    /**
    * Opens and returns the writer for the {@code description} property. The {@code description} property defines an HTML description of the object.
    */
    @Nonnull
    public final StringCesiumWriter openDescriptionProperty() {
        return this.<StringCesiumWriter> openAndReturn(getDescriptionWriter());
    }

    /**
    * Writes a value for the {@code description} property as a {@code string} value. The {@code description} property specifies an HTML description of the object.
    * @param value The value.
    */
    public final void writeDescriptionProperty(String value) {
        try (Using<StringCesiumWriter> using$0 = new Using<StringCesiumWriter>(openDescriptionProperty())) {
            final StringCesiumWriter writer = using$0.resource;
            writer.writeString(value);
        }
    }

    /**
    * Writes a value for the {@code description} property as a {@code reference} value. The {@code description} property specifies an HTML description of the object.
    * @param value The reference.
    */
    public final void writeDescriptionPropertyReference(Reference value) {
        try (Using<StringCesiumWriter> using$0 = new Using<StringCesiumWriter>(openDescriptionProperty())) {
            final StringCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code description} property as a {@code reference} value. The {@code description} property specifies an HTML description of the object.
    * @param value The reference.
    */
    public final void writeDescriptionPropertyReference(String value) {
        try (Using<StringCesiumWriter> using$0 = new Using<StringCesiumWriter>(openDescriptionProperty())) {
            final StringCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code description} property as a {@code reference} value. The {@code description} property specifies an HTML description of the object.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeDescriptionPropertyReference(String identifier, String propertyName) {
        try (Using<StringCesiumWriter> using$0 = new Using<StringCesiumWriter>(openDescriptionProperty())) {
            final StringCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code description} property as a {@code reference} value. The {@code description} property specifies an HTML description of the object.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeDescriptionPropertyReference(String identifier, String[] propertyNames) {
        try (Using<StringCesiumWriter> using$0 = new Using<StringCesiumWriter>(openDescriptionProperty())) {
            final StringCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code clock} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code clock} property defines the clock settings for the entire data set. Only valid on the document object.
    */
    @Nonnull
    public final ClockCesiumWriter getClockWriter() {
        return m_clock.getValue();
    }

    /**
    * Opens and returns the writer for the {@code clock} property. The {@code clock} property defines the clock settings for the entire data set. Only valid on the document object.
    */
    @Nonnull
    public final ClockCesiumWriter openClockProperty() {
        return this.<ClockCesiumWriter> openAndReturn(getClockWriter());
    }

    /**
    * Writes the value expressed as a {@code version}, which is the CZML version being written. Only valid on the document object.
    * @param value The value.
    */
    public final void writeVersion(String value) {
        final String PropertyName = VersionPropertyName;
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    * Writes the value expressed as a {@code availability}, which is the set of time intervals over which data for an object is available. The property can be a single string specifying a single interval, or an array of strings representing intervals. A later CZML packet can update this availability if it changes or is found to be incorrect. For example, an SGP4 propagator may initially report availability for all time, but then later the propagator throws an exception and the availability can be adjusted to end at that time. If this optional property is not present, the object is assumed to be available for all time. Availability is scoped to a particular CZML stream, so two different streams can list different availability for a single object. Within a single stream, the last availability stated for an object is the one in effect and any availabilities in previous packets are ignored. If an object is not available at a time, the client will not draw that object. If not specified, the default value is 0000-00-00T00:00:00Z/9999-12-31T24:00:00Z.
    * @param value The interval.
    */
    public final void writeAvailability(TimeInterval value) {
        final String PropertyName = AvailabilityPropertyName;
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeTimeInterval(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code availability}, which is the set of time intervals over which data for an object is available. The property can be a single string specifying a single interval, or an array of strings representing intervals. A later CZML packet can update this availability if it changes or is found to be incorrect. For example, an SGP4 propagator may initially report availability for all time, but then later the propagator throws an exception and the availability can be adjusted to end at that time. If this optional property is not present, the object is assumed to be available for all time. Availability is scoped to a particular CZML stream, so two different streams can list different availability for a single object. Within a single stream, the last availability stated for an object is the one in effect and any availabilities in previous packets are ignored. If an object is not available at a time, the client will not draw that object. If not specified, the default value is 0000-00-00T00:00:00Z/9999-12-31T24:00:00Z.
    * @param start The earliest date of the interval.
    * @param stop The latest date of the interval.
    */
    public final void writeAvailability(@Nonnull JulianDate start, @Nonnull JulianDate stop) {
        writeAvailability(new TimeInterval(start, stop));
    }

    /**
    * Writes the value expressed as a {@code availability}, which is the set of time intervals over which data for an object is available. The property can be a single string specifying a single interval, or an array of strings representing intervals. A later CZML packet can update this availability if it changes or is found to be incorrect. For example, an SGP4 propagator may initially report availability for all time, but then later the propagator throws an exception and the availability can be adjusted to end at that time. If this optional property is not present, the object is assumed to be available for all time. Availability is scoped to a particular CZML stream, so two different streams can list different availability for a single object. Within a single stream, the last availability stated for an object is the one in effect and any availabilities in previous packets are ignored. If an object is not available at a time, the client will not draw that object. If not specified, the default value is 0000-00-00T00:00:00Z/9999-12-31T24:00:00Z.
    * @param value The intervals.
    */
    public final void writeAvailability(List<TimeInterval> value) {
        final String PropertyName = AvailabilityPropertyName;
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeTimeIntervalCollection(getOutput(), value);
    }

    /**
    * Gets the writer for the {@code properties} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code properties} property defines a set of custom properties for this object.
    */
    @Nonnull
    public final CustomPropertiesCesiumWriter getPropertiesWriter() {
        return m_properties.getValue();
    }

    /**
    * Opens and returns the writer for the {@code properties} property. The {@code properties} property defines a set of custom properties for this object.
    */
    @Nonnull
    public final CustomPropertiesCesiumWriter openPropertiesProperty() {
        return this.<CustomPropertiesCesiumWriter> openAndReturn(getPropertiesWriter());
    }

    /**
    * Gets the writer for the {@code position} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code position} property defines the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    */
    @Nonnull
    public final PositionCesiumWriter getPositionWriter() {
        return m_position.getValue();
    }

    /**
    * Opens and returns the writer for the {@code position} property. The {@code position} property defines the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    */
    @Nonnull
    public final PositionCesiumWriter openPositionProperty() {
        return this.<PositionCesiumWriter> openAndReturn(getPositionWriter());
    }

    /**
    * Writes a value for the {@code position} property as a {@code cartesian} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param value The value.
    */
    public final void writePositionProperty(@Nonnull Cartesian value) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeCartesian(value);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code cartesian} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writePositionProperty(List<JulianDate> dates, List<Cartesian> values) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code cartesian} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writePositionProperty(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code cartographicRadians} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param value The interval.
    */
    public final void writePositionPropertyCartographicRadians(@Nonnull Cartographic value) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeCartographicRadians(value);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code cartographicRadians} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writePositionPropertyCartographicRadians(List<JulianDate> dates, List<Cartographic> values) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeCartographicRadians(dates, values);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code cartographicRadians} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param dates The dates at which the value is specified.
    * @param values The position corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writePositionPropertyCartographicRadians(List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeCartographicRadians(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code cartographicDegrees} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param value The interval.
    */
    public final void writePositionPropertyCartographicDegrees(@Nonnull Cartographic value) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeCartographicDegrees(value);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code cartographicDegrees} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writePositionPropertyCartographicDegrees(List<JulianDate> dates, List<Cartographic> values) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeCartographicDegrees(dates, values);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code cartographicDegrees} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param dates The dates at which the value is specified.
    * @param values The position corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writePositionPropertyCartographicDegrees(List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeCartographicDegrees(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code cartesianVelocity} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param value The value.
    */
    public final void writePositionPropertyCartesianVelocity(@Nonnull Motion1<Cartesian> value) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeCartesianVelocity(value);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code cartesianVelocity} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writePositionPropertyCartesianVelocity(List<JulianDate> dates, List<Motion1<Cartesian>> values) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeCartesianVelocity(dates, values);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code cartesianVelocity} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writePositionPropertyCartesianVelocity(List<JulianDate> dates, List<Motion1<Cartesian>> values, int startIndex, int length) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeCartesianVelocity(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code reference} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param value The reference.
    */
    public final void writePositionPropertyReference(Reference value) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code reference} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param value The reference.
    */
    public final void writePositionPropertyReference(String value) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code reference} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writePositionPropertyReference(String identifier, String propertyName) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code position} property as a {@code reference} value. The {@code position} property specifies the position of the object in the world. The position has no direct visual representation, but it is used to locate billboards, labels, and other graphical items attached to the object.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writePositionPropertyReference(String identifier, String[] propertyNames) {
        try (Using<PositionCesiumWriter> using$0 = new Using<PositionCesiumWriter>(openPositionProperty())) {
            final PositionCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code orientation} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code orientation} property defines the orientation of the object in the world. The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
    */
    @Nonnull
    public final OrientationCesiumWriter getOrientationWriter() {
        return m_orientation.getValue();
    }

    /**
    * Opens and returns the writer for the {@code orientation} property. The {@code orientation} property defines the orientation of the object in the world. The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
    */
    @Nonnull
    public final OrientationCesiumWriter openOrientationProperty() {
        return this.<OrientationCesiumWriter> openAndReturn(getOrientationWriter());
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code unitQuaternion} value. The {@code orientation} property specifies the orientation of the object in the world. The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
    * @param value The value.
    */
    public final void writeOrientationProperty(@Nonnull UnitQuaternion value) {
        try (Using<OrientationCesiumWriter> using$0 = new Using<OrientationCesiumWriter>(openOrientationProperty())) {
            final OrientationCesiumWriter writer = using$0.resource;
            writer.writeUnitQuaternion(value);
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code unitQuaternion} value. The {@code orientation} property specifies the orientation of the object in the world. The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeOrientationProperty(List<JulianDate> dates, List<UnitQuaternion> values) {
        try (Using<OrientationCesiumWriter> using$0 = new Using<OrientationCesiumWriter>(openOrientationProperty())) {
            final OrientationCesiumWriter writer = using$0.resource;
            writer.writeUnitQuaternion(dates, values);
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code unitQuaternion} value. The {@code orientation} property specifies the orientation of the object in the world. The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeOrientationProperty(List<JulianDate> dates, List<UnitQuaternion> values, int startIndex, int length) {
        try (Using<OrientationCesiumWriter> using$0 = new Using<OrientationCesiumWriter>(openOrientationProperty())) {
            final OrientationCesiumWriter writer = using$0.resource;
            writer.writeUnitQuaternion(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code reference} value. The {@code orientation} property specifies the orientation of the object in the world. The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
    * @param value The reference.
    */
    public final void writeOrientationPropertyReference(Reference value) {
        try (Using<OrientationCesiumWriter> using$0 = new Using<OrientationCesiumWriter>(openOrientationProperty())) {
            final OrientationCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code reference} value. The {@code orientation} property specifies the orientation of the object in the world. The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
    * @param value The reference.
    */
    public final void writeOrientationPropertyReference(String value) {
        try (Using<OrientationCesiumWriter> using$0 = new Using<OrientationCesiumWriter>(openOrientationProperty())) {
            final OrientationCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code reference} value. The {@code orientation} property specifies the orientation of the object in the world. The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOrientationPropertyReference(String identifier, String propertyName) {
        try (Using<OrientationCesiumWriter> using$0 = new Using<OrientationCesiumWriter>(openOrientationProperty())) {
            final OrientationCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code reference} value. The {@code orientation} property specifies the orientation of the object in the world. The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOrientationPropertyReference(String identifier, String[] propertyNames) {
        try (Using<OrientationCesiumWriter> using$0 = new Using<OrientationCesiumWriter>(openOrientationProperty())) {
            final OrientationCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code velocityReference} value. The {@code orientation} property specifies the orientation of the object in the world. The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
    * @param value The reference.
    */
    public final void writeOrientationPropertyVelocityReference(Reference value) {
        try (Using<OrientationCesiumWriter> using$0 = new Using<OrientationCesiumWriter>(openOrientationProperty())) {
            final OrientationCesiumWriter writer = using$0.resource;
            writer.writeVelocityReference(value);
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code velocityReference} value. The {@code orientation} property specifies the orientation of the object in the world. The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
    * @param value The reference.
    */
    public final void writeOrientationPropertyVelocityReference(String value) {
        try (Using<OrientationCesiumWriter> using$0 = new Using<OrientationCesiumWriter>(openOrientationProperty())) {
            final OrientationCesiumWriter writer = using$0.resource;
            writer.writeVelocityReference(value);
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code velocityReference} value. The {@code orientation} property specifies the orientation of the object in the world. The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeOrientationPropertyVelocityReference(String identifier, String propertyName) {
        try (Using<OrientationCesiumWriter> using$0 = new Using<OrientationCesiumWriter>(openOrientationProperty())) {
            final OrientationCesiumWriter writer = using$0.resource;
            writer.writeVelocityReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code orientation} property as a {@code velocityReference} value. The {@code orientation} property specifies the orientation of the object in the world. The orientation has no direct visual representation, but it is used to orient models, cones, pyramids, and other graphical items attached to the object.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeOrientationPropertyVelocityReference(String identifier, String[] propertyNames) {
        try (Using<OrientationCesiumWriter> using$0 = new Using<OrientationCesiumWriter>(openOrientationProperty())) {
            final OrientationCesiumWriter writer = using$0.resource;
            writer.writeVelocityReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code viewFrom} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code viewFrom} property defines a suggested camera location when viewing this object. The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
    */
    @Nonnull
    public final ViewFromCesiumWriter getViewFromWriter() {
        return m_viewFrom.getValue();
    }

    /**
    * Opens and returns the writer for the {@code viewFrom} property. The {@code viewFrom} property defines a suggested camera location when viewing this object. The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
    */
    @Nonnull
    public final ViewFromCesiumWriter openViewFromProperty() {
        return this.<ViewFromCesiumWriter> openAndReturn(getViewFromWriter());
    }

    /**
    * Writes a value for the {@code viewFrom} property as a {@code cartesian} value. The {@code viewFrom} property specifies a suggested camera location when viewing this object. The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
    * @param value The value.
    */
    public final void writeViewFromProperty(@Nonnull Cartesian value) {
        try (Using<ViewFromCesiumWriter> using$0 = new Using<ViewFromCesiumWriter>(openViewFromProperty())) {
            final ViewFromCesiumWriter writer = using$0.resource;
            writer.writeCartesian(value);
        }
    }

    /**
    * Writes a value for the {@code viewFrom} property as a {@code cartesian} value. The {@code viewFrom} property specifies a suggested camera location when viewing this object. The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeViewFromProperty(List<JulianDate> dates, List<Cartesian> values) {
        try (Using<ViewFromCesiumWriter> using$0 = new Using<ViewFromCesiumWriter>(openViewFromProperty())) {
            final ViewFromCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values);
        }
    }

    /**
    * Writes a value for the {@code viewFrom} property as a {@code cartesian} value. The {@code viewFrom} property specifies a suggested camera location when viewing this object. The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeViewFromProperty(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        try (Using<ViewFromCesiumWriter> using$0 = new Using<ViewFromCesiumWriter>(openViewFromProperty())) {
            final ViewFromCesiumWriter writer = using$0.resource;
            writer.writeCartesian(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code viewFrom} property as a {@code reference} value. The {@code viewFrom} property specifies a suggested camera location when viewing this object. The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
    * @param value The reference.
    */
    public final void writeViewFromPropertyReference(Reference value) {
        try (Using<ViewFromCesiumWriter> using$0 = new Using<ViewFromCesiumWriter>(openViewFromProperty())) {
            final ViewFromCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code viewFrom} property as a {@code reference} value. The {@code viewFrom} property specifies a suggested camera location when viewing this object. The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
    * @param value The reference.
    */
    public final void writeViewFromPropertyReference(String value) {
        try (Using<ViewFromCesiumWriter> using$0 = new Using<ViewFromCesiumWriter>(openViewFromProperty())) {
            final ViewFromCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code viewFrom} property as a {@code reference} value. The {@code viewFrom} property specifies a suggested camera location when viewing this object. The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeViewFromPropertyReference(String identifier, String propertyName) {
        try (Using<ViewFromCesiumWriter> using$0 = new Using<ViewFromCesiumWriter>(openViewFromProperty())) {
            final ViewFromCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code viewFrom} property as a {@code reference} value. The {@code viewFrom} property specifies a suggested camera location when viewing this object. The property is specified as a Cartesian position in the East (x), North (y), Up (z) reference frame relative to the object's position.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeViewFromPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ViewFromCesiumWriter> using$0 = new Using<ViewFromCesiumWriter>(openViewFromProperty())) {
            final ViewFromCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code billboard} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code billboard} property defines a billboard, or viewport-aligned image, sometimes called a marker. The billboard is positioned in the scene by the {@code position} property.
    */
    @Nonnull
    public final BillboardCesiumWriter getBillboardWriter() {
        return m_billboard.getValue();
    }

    /**
    * Opens and returns the writer for the {@code billboard} property. The {@code billboard} property defines a billboard, or viewport-aligned image, sometimes called a marker. The billboard is positioned in the scene by the {@code position} property.
    */
    @Nonnull
    public final BillboardCesiumWriter openBillboardProperty() {
        return this.<BillboardCesiumWriter> openAndReturn(getBillboardWriter());
    }

    /**
    * Gets the writer for the {@code box} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code box} property defines a box, which is a closed rectangular cuboid. The box is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final BoxCesiumWriter getBoxWriter() {
        return m_box.getValue();
    }

    /**
    * Opens and returns the writer for the {@code box} property. The {@code box} property defines a box, which is a closed rectangular cuboid. The box is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final BoxCesiumWriter openBoxProperty() {
        return this.<BoxCesiumWriter> openAndReturn(getBoxWriter());
    }

    /**
    * Gets the writer for the {@code corridor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code corridor} property defines a corridor, which is a shape defined by a centerline and width.
    */
    @Nonnull
    public final CorridorCesiumWriter getCorridorWriter() {
        return m_corridor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code corridor} property. The {@code corridor} property defines a corridor, which is a shape defined by a centerline and width.
    */
    @Nonnull
    public final CorridorCesiumWriter openCorridorProperty() {
        return this.<CorridorCesiumWriter> openAndReturn(getCorridorWriter());
    }

    /**
    * Gets the writer for the {@code cylinder} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code cylinder} property defines a cylinder, truncated cone, or cone defined by a length, top radius, and bottom radius. The cylinder is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final CylinderCesiumWriter getCylinderWriter() {
        return m_cylinder.getValue();
    }

    /**
    * Opens and returns the writer for the {@code cylinder} property. The {@code cylinder} property defines a cylinder, truncated cone, or cone defined by a length, top radius, and bottom radius. The cylinder is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final CylinderCesiumWriter openCylinderProperty() {
        return this.<CylinderCesiumWriter> openAndReturn(getCylinderWriter());
    }

    /**
    * Gets the writer for the {@code ellipse} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code ellipse} property defines an ellipse, which is a closed curve on the surface of the Earth. The ellipse is positioned using the {@code position} property.
    */
    @Nonnull
    public final EllipseCesiumWriter getEllipseWriter() {
        return m_ellipse.getValue();
    }

    /**
    * Opens and returns the writer for the {@code ellipse} property. The {@code ellipse} property defines an ellipse, which is a closed curve on the surface of the Earth. The ellipse is positioned using the {@code position} property.
    */
    @Nonnull
    public final EllipseCesiumWriter openEllipseProperty() {
        return this.<EllipseCesiumWriter> openAndReturn(getEllipseWriter());
    }

    /**
    * Gets the writer for the {@code ellipsoid} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code ellipsoid} property defines an ellipsoid, which is a closed quadric surface that is a three-dimensional analogue of an ellipse. The ellipsoid is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final EllipsoidCesiumWriter getEllipsoidWriter() {
        return m_ellipsoid.getValue();
    }

    /**
    * Opens and returns the writer for the {@code ellipsoid} property. The {@code ellipsoid} property defines an ellipsoid, which is a closed quadric surface that is a three-dimensional analogue of an ellipse. The ellipsoid is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final EllipsoidCesiumWriter openEllipsoidProperty() {
        return this.<EllipsoidCesiumWriter> openAndReturn(getEllipsoidWriter());
    }

    /**
    * Gets the writer for the {@code label} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code label} property defines a string of text. The label is positioned in the scene by the {@code position} property.
    */
    @Nonnull
    public final LabelCesiumWriter getLabelWriter() {
        return m_label.getValue();
    }

    /**
    * Opens and returns the writer for the {@code label} property. The {@code label} property defines a string of text. The label is positioned in the scene by the {@code position} property.
    */
    @Nonnull
    public final LabelCesiumWriter openLabelProperty() {
        return this.<LabelCesiumWriter> openAndReturn(getLabelWriter());
    }

    /**
    * Gets the writer for the {@code model} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code model} property defines a 3D model. The model is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final ModelCesiumWriter getModelWriter() {
        return m_model.getValue();
    }

    /**
    * Opens and returns the writer for the {@code model} property. The {@code model} property defines a 3D model. The model is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final ModelCesiumWriter openModelProperty() {
        return this.<ModelCesiumWriter> openAndReturn(getModelWriter());
    }

    /**
    * Gets the writer for the {@code path} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code path} property defines a path, which is a polyline defined by the motion of an object over time. The possible vertices of the path are specified by the {@code position} property.
    */
    @Nonnull
    public final PathCesiumWriter getPathWriter() {
        return m_path.getValue();
    }

    /**
    * Opens and returns the writer for the {@code path} property. The {@code path} property defines a path, which is a polyline defined by the motion of an object over time. The possible vertices of the path are specified by the {@code position} property.
    */
    @Nonnull
    public final PathCesiumWriter openPathProperty() {
        return this.<PathCesiumWriter> openAndReturn(getPathWriter());
    }

    /**
    * Gets the writer for the {@code point} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code point} property defines a point, or viewport-aligned circle. The point is positioned in the scene by the {@code position} property.
    */
    @Nonnull
    public final PointCesiumWriter getPointWriter() {
        return m_point.getValue();
    }

    /**
    * Opens and returns the writer for the {@code point} property. The {@code point} property defines a point, or viewport-aligned circle. The point is positioned in the scene by the {@code position} property.
    */
    @Nonnull
    public final PointCesiumWriter openPointProperty() {
        return this.<PointCesiumWriter> openAndReturn(getPointWriter());
    }

    /**
    * Gets the writer for the {@code polygon} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code polygon} property defines a polygon, which is a closed figure on the surface of the Earth.
    */
    @Nonnull
    public final PolygonCesiumWriter getPolygonWriter() {
        return m_polygon.getValue();
    }

    /**
    * Opens and returns the writer for the {@code polygon} property. The {@code polygon} property defines a polygon, which is a closed figure on the surface of the Earth.
    */
    @Nonnull
    public final PolygonCesiumWriter openPolygonProperty() {
        return this.<PolygonCesiumWriter> openAndReturn(getPolygonWriter());
    }

    /**
    * Gets the writer for the {@code polyline} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code polyline} property defines a polyline, which is a line in the scene composed of multiple segments.
    */
    @Nonnull
    public final PolylineCesiumWriter getPolylineWriter() {
        return m_polyline.getValue();
    }

    /**
    * Opens and returns the writer for the {@code polyline} property. The {@code polyline} property defines a polyline, which is a line in the scene composed of multiple segments.
    */
    @Nonnull
    public final PolylineCesiumWriter openPolylineProperty() {
        return this.<PolylineCesiumWriter> openAndReturn(getPolylineWriter());
    }

    /**
    * Gets the writer for the {@code polylineVolume} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code polylineVolume} property defines a polyline with a volume, defined as a 2D shape extruded along a polyline.
    */
    @Nonnull
    public final PolylineVolumeCesiumWriter getPolylineVolumeWriter() {
        return m_polylineVolume.getValue();
    }

    /**
    * Opens and returns the writer for the {@code polylineVolume} property. The {@code polylineVolume} property defines a polyline with a volume, defined as a 2D shape extruded along a polyline.
    */
    @Nonnull
    public final PolylineVolumeCesiumWriter openPolylineVolumeProperty() {
        return this.<PolylineVolumeCesiumWriter> openAndReturn(getPolylineVolumeWriter());
    }

    /**
    * Gets the writer for the {@code rectangle} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code rectangle} property defines a cartographic rectangle, which conforms to the curvature of the globe and can be placed along the surface or at altitude.
    */
    @Nonnull
    public final RectangleCesiumWriter getRectangleWriter() {
        return m_rectangle.getValue();
    }

    /**
    * Opens and returns the writer for the {@code rectangle} property. The {@code rectangle} property defines a cartographic rectangle, which conforms to the curvature of the globe and can be placed along the surface or at altitude.
    */
    @Nonnull
    public final RectangleCesiumWriter openRectangleProperty() {
        return this.<RectangleCesiumWriter> openAndReturn(getRectangleWriter());
    }

    /**
    * Gets the writer for the {@code tileset} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code tileset} property defines a 3D Tiles tileset.
    */
    @Nonnull
    public final TilesetCesiumWriter getTilesetWriter() {
        return m_tileset.getValue();
    }

    /**
    * Opens and returns the writer for the {@code tileset} property. The {@code tileset} property defines a 3D Tiles tileset.
    */
    @Nonnull
    public final TilesetCesiumWriter openTilesetProperty() {
        return this.<TilesetCesiumWriter> openAndReturn(getTilesetWriter());
    }

    /**
    * Gets the writer for the {@code wall} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code wall} property defines a two-dimensional wall which conforms to the curvature of the globe and can be placed along the surface or at altitude.
    */
    @Nonnull
    public final WallCesiumWriter getWallWriter() {
        return m_wall.getValue();
    }

    /**
    * Opens and returns the writer for the {@code wall} property. The {@code wall} property defines a two-dimensional wall which conforms to the curvature of the globe and can be placed along the surface or at altitude.
    */
    @Nonnull
    public final WallCesiumWriter openWallProperty() {
        return this.<WallCesiumWriter> openAndReturn(getWallWriter());
    }

    /**
    * Gets the writer for the {@code agi_conicSensor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code agi_conicSensor} property defines a conical sensor volume taking into account occlusion of an ellipsoid, i.e., the globe. The sensor is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final ConicSensorCesiumWriter getConicSensorWriter() {
        return m_agi_conicSensor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code agi_conicSensor} property. The {@code agi_conicSensor} property defines a conical sensor volume taking into account occlusion of an ellipsoid, i.e., the globe. The sensor is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final ConicSensorCesiumWriter openConicSensorProperty() {
        return this.<ConicSensorCesiumWriter> openAndReturn(getConicSensorWriter());
    }

    /**
    * Gets the writer for the {@code agi_customPatternSensor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code agi_customPatternSensor} property defines a custom sensor volume taking into account occlusion of an ellipsoid, i.e., the globe. The sensor is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final CustomPatternSensorCesiumWriter getCustomPatternSensorWriter() {
        return m_agi_customPatternSensor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code agi_customPatternSensor} property. The {@code agi_customPatternSensor} property defines a custom sensor volume taking into account occlusion of an ellipsoid, i.e., the globe. The sensor is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final CustomPatternSensorCesiumWriter openCustomPatternSensorProperty() {
        return this.<CustomPatternSensorCesiumWriter> openAndReturn(getCustomPatternSensorWriter());
    }

    /**
    * Gets the writer for the {@code agi_rectangularSensor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code agi_rectangularSensor} property defines a rectangular pyramid sensor volume taking into account occlusion of an ellipsoid, i.e., the globe. The sensor is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final RectangularSensorCesiumWriter getRectangularSensorWriter() {
        return m_agi_rectangularSensor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code agi_rectangularSensor} property. The {@code agi_rectangularSensor} property defines a rectangular pyramid sensor volume taking into account occlusion of an ellipsoid, i.e., the globe. The sensor is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final RectangularSensorCesiumWriter openRectangularSensorProperty() {
        return this.<RectangularSensorCesiumWriter> openAndReturn(getRectangularSensorWriter());
    }

    /**
    * Gets the writer for the {@code agi_fan} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code agi_fan} property defines defines a fan, which starts at a point or apex and extends in a specified list of directions from the apex. Each pair of directions forms a face of the fan extending to the specified radius. The fan is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final FanCesiumWriter getFanWriter() {
        return m_agi_fan.getValue();
    }

    /**
    * Opens and returns the writer for the {@code agi_fan} property. The {@code agi_fan} property defines defines a fan, which starts at a point or apex and extends in a specified list of directions from the apex. Each pair of directions forms a face of the fan extending to the specified radius. The fan is positioned and oriented using the {@code position} and {@code orientation} properties.
    */
    @Nonnull
    public final FanCesiumWriter openFanProperty() {
        return this.<FanCesiumWriter> openAndReturn(getFanWriter());
    }

    /**
    * Gets the writer for the {@code agi_vector} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code agi_vector} property defines defines a graphical vector that originates at the {@code position} property and extends in the provided direction for the provided length. The vector is positioned using the {@code position} property.
    */
    @Nonnull
    public final VectorCesiumWriter getVectorWriter() {
        return m_agi_vector.getValue();
    }

    /**
    * Opens and returns the writer for the {@code agi_vector} property. The {@code agi_vector} property defines defines a graphical vector that originates at the {@code position} property and extends in the provided direction for the provided length. The vector is positioned using the {@code position} property.
    */
    @Nonnull
    public final VectorCesiumWriter openVectorProperty() {
        return this.<VectorCesiumWriter> openAndReturn(getVectorWriter());
    }
}