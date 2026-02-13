package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.DirectionListCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.IntegerCesiumWriter;
import cesiumlanguagewriter.MaterialCesiumWriter;
import cesiumlanguagewriter.SensorVolumePortionToDisplayCesiumWriter;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code CustomPatternSensor} to a {@link CesiumOutputStream}. A {@code CustomPatternSensor} is a custom sensor volume taking into account occlusion of an ellipsoid, i.e., the globe.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class CustomPatternSensorCesiumWriter extends CesiumPropertyWriter<CustomPatternSensorCesiumWriter> {
    /**
    * The name of the {@code show} property.
    */
    @Nonnull
    public static final String ShowPropertyName = "show";
    /**
    * The name of the {@code directions} property.
    */
    @Nonnull
    public static final String DirectionsPropertyName = "directions";
    /**
    * The name of the {@code radius} property.
    */
    @Nonnull
    public static final String RadiusPropertyName = "radius";
    /**
    * The name of the {@code showIntersection} property.
    */
    @Nonnull
    public static final String ShowIntersectionPropertyName = "showIntersection";
    /**
    * The name of the {@code intersectionColor} property.
    */
    @Nonnull
    public static final String IntersectionColorPropertyName = "intersectionColor";
    /**
    * The name of the {@code intersectionWidth} property.
    */
    @Nonnull
    public static final String IntersectionWidthPropertyName = "intersectionWidth";
    /**
    * The name of the {@code showLateralSurfaces} property.
    */
    @Nonnull
    public static final String ShowLateralSurfacesPropertyName = "showLateralSurfaces";
    /**
    * The name of the {@code lateralSurfaceMaterial} property.
    */
    @Nonnull
    public static final String LateralSurfaceMaterialPropertyName = "lateralSurfaceMaterial";
    /**
    * The name of the {@code showEllipsoidSurfaces} property.
    */
    @Nonnull
    public static final String ShowEllipsoidSurfacesPropertyName = "showEllipsoidSurfaces";
    /**
    * The name of the {@code ellipsoidSurfaceMaterial} property.
    */
    @Nonnull
    public static final String EllipsoidSurfaceMaterialPropertyName = "ellipsoidSurfaceMaterial";
    /**
    * The name of the {@code showEllipsoidHorizonSurfaces} property.
    */
    @Nonnull
    public static final String ShowEllipsoidHorizonSurfacesPropertyName = "showEllipsoidHorizonSurfaces";
    /**
    * The name of the {@code ellipsoidHorizonSurfaceMaterial} property.
    */
    @Nonnull
    public static final String EllipsoidHorizonSurfaceMaterialPropertyName = "ellipsoidHorizonSurfaceMaterial";
    /**
    * The name of the {@code showDomeSurfaces} property.
    */
    @Nonnull
    public static final String ShowDomeSurfacesPropertyName = "showDomeSurfaces";
    /**
    * The name of the {@code domeSurfaceMaterial} property.
    */
    @Nonnull
    public static final String DomeSurfaceMaterialPropertyName = "domeSurfaceMaterial";
    /**
    * The name of the {@code portionToDisplay} property.
    */
    @Nonnull
    public static final String PortionToDisplayPropertyName = "portionToDisplay";
    /**
    * The name of the {@code environmentConstraint} property.
    */
    @Nonnull
    public static final String EnvironmentConstraintPropertyName = "environmentConstraint";
    /**
    * The name of the {@code showEnvironmentOcclusion} property.
    */
    @Nonnull
    public static final String ShowEnvironmentOcclusionPropertyName = "showEnvironmentOcclusion";
    /**
    * The name of the {@code environmentOcclusionMaterial} property.
    */
    @Nonnull
    public static final String EnvironmentOcclusionMaterialPropertyName = "environmentOcclusionMaterial";
    /**
    * The name of the {@code showEnvironmentIntersection} property.
    */
    @Nonnull
    public static final String ShowEnvironmentIntersectionPropertyName = "showEnvironmentIntersection";
    /**
    * The name of the {@code environmentIntersectionColor} property.
    */
    @Nonnull
    public static final String EnvironmentIntersectionColorPropertyName = "environmentIntersectionColor";
    /**
    * The name of the {@code environmentIntersectionWidth} property.
    */
    @Nonnull
    public static final String EnvironmentIntersectionWidthPropertyName = "environmentIntersectionWidth";
    /**
    * The name of the {@code showThroughEllipsoid} property.
    */
    @Nonnull
    public static final String ShowThroughEllipsoidPropertyName = "showThroughEllipsoid";
    /**
    * The name of the {@code showViewshed} property.
    */
    @Nonnull
    public static final String ShowViewshedPropertyName = "showViewshed";
    /**
    * The name of the {@code viewshedVisibleColor} property.
    */
    @Nonnull
    public static final String ViewshedVisibleColorPropertyName = "viewshedVisibleColor";
    /**
    * The name of the {@code viewshedOccludedColor} property.
    */
    @Nonnull
    public static final String ViewshedOccludedColorPropertyName = "viewshedOccludedColor";
    /**
    * The name of the {@code viewshedResolution} property.
    */
    @Nonnull
    public static final String ViewshedResolutionPropertyName = "viewshedResolution";
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(ShowPropertyName);
    }), false);
    @Nonnull
    private final Lazy<DirectionListCesiumWriter> m_directions = new Lazy<DirectionListCesiumWriter>(Func1.<DirectionListCesiumWriter> of(() -> {
        return new DirectionListCesiumWriter(DirectionsPropertyName);
    }), false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_radius = new Lazy<DoubleCesiumWriter>(Func1.<DoubleCesiumWriter> of(() -> {
        return new DoubleCesiumWriter(RadiusPropertyName);
    }), false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_showIntersection = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(ShowIntersectionPropertyName);
    }), false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_intersectionColor = new Lazy<ColorCesiumWriter>(Func1.<ColorCesiumWriter> of(() -> {
        return new ColorCesiumWriter(IntersectionColorPropertyName);
    }), false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_intersectionWidth = new Lazy<DoubleCesiumWriter>(Func1.<DoubleCesiumWriter> of(() -> {
        return new DoubleCesiumWriter(IntersectionWidthPropertyName);
    }), false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_showLateralSurfaces = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(ShowLateralSurfacesPropertyName);
    }), false);
    @Nonnull
    private final Lazy<MaterialCesiumWriter> m_lateralSurfaceMaterial = new Lazy<MaterialCesiumWriter>(Func1.<MaterialCesiumWriter> of(() -> {
        return new MaterialCesiumWriter(LateralSurfaceMaterialPropertyName);
    }), false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_showEllipsoidSurfaces = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(ShowEllipsoidSurfacesPropertyName);
    }), false);
    @Nonnull
    private final Lazy<MaterialCesiumWriter> m_ellipsoidSurfaceMaterial = new Lazy<MaterialCesiumWriter>(Func1.<MaterialCesiumWriter> of(() -> {
        return new MaterialCesiumWriter(EllipsoidSurfaceMaterialPropertyName);
    }), false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_showEllipsoidHorizonSurfaces = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(ShowEllipsoidHorizonSurfacesPropertyName);
    }), false);
    @Nonnull
    private final Lazy<MaterialCesiumWriter> m_ellipsoidHorizonSurfaceMaterial = new Lazy<MaterialCesiumWriter>(Func1.<MaterialCesiumWriter> of(() -> {
        return new MaterialCesiumWriter(EllipsoidHorizonSurfaceMaterialPropertyName);
    }), false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_showDomeSurfaces = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(ShowDomeSurfacesPropertyName);
    }), false);
    @Nonnull
    private final Lazy<MaterialCesiumWriter> m_domeSurfaceMaterial = new Lazy<MaterialCesiumWriter>(Func1.<MaterialCesiumWriter> of(() -> {
        return new MaterialCesiumWriter(DomeSurfaceMaterialPropertyName);
    }), false);
    @Nonnull
    private final Lazy<SensorVolumePortionToDisplayCesiumWriter> m_portionToDisplay = new Lazy<SensorVolumePortionToDisplayCesiumWriter>(Func1.<SensorVolumePortionToDisplayCesiumWriter> of(() -> {
        return new SensorVolumePortionToDisplayCesiumWriter(PortionToDisplayPropertyName);
    }), false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_environmentConstraint = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(EnvironmentConstraintPropertyName);
    }), false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_showEnvironmentOcclusion = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(ShowEnvironmentOcclusionPropertyName);
    }), false);
    @Nonnull
    private final Lazy<MaterialCesiumWriter> m_environmentOcclusionMaterial = new Lazy<MaterialCesiumWriter>(Func1.<MaterialCesiumWriter> of(() -> {
        return new MaterialCesiumWriter(EnvironmentOcclusionMaterialPropertyName);
    }), false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_showEnvironmentIntersection = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(ShowEnvironmentIntersectionPropertyName);
    }), false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_environmentIntersectionColor = new Lazy<ColorCesiumWriter>(Func1.<ColorCesiumWriter> of(() -> {
        return new ColorCesiumWriter(EnvironmentIntersectionColorPropertyName);
    }), false);
    @Nonnull
    private final Lazy<DoubleCesiumWriter> m_environmentIntersectionWidth = new Lazy<DoubleCesiumWriter>(Func1.<DoubleCesiumWriter> of(() -> {
        return new DoubleCesiumWriter(EnvironmentIntersectionWidthPropertyName);
    }), false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_showThroughEllipsoid = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(ShowThroughEllipsoidPropertyName);
    }), false);
    @Nonnull
    private final Lazy<BooleanCesiumWriter> m_showViewshed = new Lazy<BooleanCesiumWriter>(Func1.<BooleanCesiumWriter> of(() -> {
        return new BooleanCesiumWriter(ShowViewshedPropertyName);
    }), false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_viewshedVisibleColor = new Lazy<ColorCesiumWriter>(Func1.<ColorCesiumWriter> of(() -> {
        return new ColorCesiumWriter(ViewshedVisibleColorPropertyName);
    }), false);
    @Nonnull
    private final Lazy<ColorCesiumWriter> m_viewshedOccludedColor = new Lazy<ColorCesiumWriter>(Func1.<ColorCesiumWriter> of(() -> {
        return new ColorCesiumWriter(ViewshedOccludedColorPropertyName);
    }), false);
    @Nonnull
    private final Lazy<IntegerCesiumWriter> m_viewshedResolution = new Lazy<IntegerCesiumWriter>(Func1.<IntegerCesiumWriter> of(() -> {
        return new IntegerCesiumWriter(ViewshedResolutionPropertyName);
    }), false);

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public CustomPatternSensorCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected CustomPatternSensorCesiumWriter(@Nonnull CustomPatternSensorCesiumWriter existingInstance) {
        super(existingInstance);
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public CustomPatternSensorCesiumWriter clone() {
        return new CustomPatternSensorCesiumWriter(this);
    }

    /**
    * Gets the writer for the {@code show} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code show} property defines whether or not the entire custom sensor is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    * Opens and returns the writer for the {@code show} property. The {@code show} property defines whether or not the entire custom sensor is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    * Writes a value for the {@code show} property as a {@code boolean} value. The {@code show} property specifies whether or not the entire custom sensor is shown. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeShowProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the entire custom sensor is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the entire custom sensor is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the entire custom sensor is shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code show} property as a {@code reference} value. The {@code show} property specifies whether or not the entire custom sensor is shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code directions} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code directions} property defines the list of directions defining the custom sensor. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final DirectionListCesiumWriter getDirectionsWriter() {
        return m_directions.getValue();
    }

    /**
    * Opens and returns the writer for the {@code directions} property. The {@code directions} property defines the list of directions defining the custom sensor. This value must be specified in order for the client to display graphics.
    */
    @Nonnull
    public final DirectionListCesiumWriter openDirectionsProperty() {
        openIntervalIfNecessary();
        return this.<DirectionListCesiumWriter> openAndReturn(getDirectionsWriter());
    }

    /**
    * Writes a value for the {@code directions} property as a {@code spherical} value. The {@code directions} property specifies the list of directions defining the custom sensor. This value must be specified in order for the client to display graphics.
    * @param values The values.
    */
    public final void writeDirectionsProperty(Iterable<Spherical> values) {
        try (Using<DirectionListCesiumWriter> using$0 = new Using<DirectionListCesiumWriter>(openDirectionsProperty())) {
            final DirectionListCesiumWriter writer = using$0.resource;
            writer.writeSpherical(values);
        }
    }

    /**
    * Writes a value for the {@code directions} property as a {@code unitSpherical} value. The {@code directions} property specifies the list of directions defining the custom sensor. This value must be specified in order for the client to display graphics.
    * @param values The values.
    */
    public final void writeDirectionsPropertyUnitSpherical(Iterable<UnitSpherical> values) {
        try (Using<DirectionListCesiumWriter> using$0 = new Using<DirectionListCesiumWriter>(openDirectionsProperty())) {
            final DirectionListCesiumWriter writer = using$0.resource;
            writer.writeUnitSpherical(values);
        }
    }

    /**
    * Writes a value for the {@code directions} property as a {@code cartesian} value. The {@code directions} property specifies the list of directions defining the custom sensor. This value must be specified in order for the client to display graphics.
    * @param values The values.
    */
    public final void writeDirectionsPropertyCartesian(Iterable<Cartesian> values) {
        try (Using<DirectionListCesiumWriter> using$0 = new Using<DirectionListCesiumWriter>(openDirectionsProperty())) {
            final DirectionListCesiumWriter writer = using$0.resource;
            writer.writeCartesian(values);
        }
    }

    /**
    * Writes a value for the {@code directions} property as a {@code unitCartesian} value. The {@code directions} property specifies the list of directions defining the custom sensor. This value must be specified in order for the client to display graphics.
    * @param values The values.
    */
    public final void writeDirectionsPropertyUnitCartesian(Iterable<UnitCartesian> values) {
        try (Using<DirectionListCesiumWriter> using$0 = new Using<DirectionListCesiumWriter>(openDirectionsProperty())) {
            final DirectionListCesiumWriter writer = using$0.resource;
            writer.writeUnitCartesian(values);
        }
    }

    /**
    * Gets the writer for the {@code radius} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code radius} property defines the radial limit of the sensor. If not specified, the default value is Infinity.
    */
    @Nonnull
    public final DoubleCesiumWriter getRadiusWriter() {
        return m_radius.getValue();
    }

    /**
    * Opens and returns the writer for the {@code radius} property. The {@code radius} property defines the radial limit of the sensor. If not specified, the default value is Infinity.
    */
    @Nonnull
    public final DoubleCesiumWriter openRadiusProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getRadiusWriter());
    }

    /**
    * Writes a value for the {@code radius} property as a {@code number} value. The {@code radius} property specifies the radial limit of the sensor. If not specified, the default value is Infinity.
    * @param value The value.
    */
    public final void writeRadiusProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRadiusProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code radius} property as a {@code number} value. The {@code radius} property specifies the radial limit of the sensor. If not specified, the default value is Infinity.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRadiusProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRadiusProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code radius} property as a {@code number} value. The {@code radius} property specifies the radial limit of the sensor. If not specified, the default value is Infinity.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRadiusProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRadiusProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code radius} property as a {@code reference} value. The {@code radius} property specifies the radial limit of the sensor. If not specified, the default value is Infinity.
    * @param value The reference.
    */
    public final void writeRadiusPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRadiusProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code radius} property as a {@code reference} value. The {@code radius} property specifies the radial limit of the sensor. If not specified, the default value is Infinity.
    * @param value The reference.
    */
    public final void writeRadiusPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRadiusProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code radius} property as a {@code reference} value. The {@code radius} property specifies the radial limit of the sensor. If not specified, the default value is Infinity.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeRadiusPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRadiusProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code radius} property as a {@code reference} value. The {@code radius} property specifies the radial limit of the sensor. If not specified, the default value is Infinity.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeRadiusPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openRadiusProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code showIntersection} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code showIntersection} property defines whether or not the intersection of the sensor with the Earth is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowIntersectionWriter() {
        return m_showIntersection.getValue();
    }

    /**
    * Opens and returns the writer for the {@code showIntersection} property. The {@code showIntersection} property defines whether or not the intersection of the sensor with the Earth is shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowIntersectionProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowIntersectionWriter());
    }

    /**
    * Writes a value for the {@code showIntersection} property as a {@code boolean} value. The {@code showIntersection} property specifies whether or not the intersection of the sensor with the Earth is shown. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeShowIntersectionProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowIntersectionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code showIntersection} property as a {@code reference} value. The {@code showIntersection} property specifies whether or not the intersection of the sensor with the Earth is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowIntersectionPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowIntersectionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showIntersection} property as a {@code reference} value. The {@code showIntersection} property specifies whether or not the intersection of the sensor with the Earth is shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowIntersectionPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowIntersectionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showIntersection} property as a {@code reference} value. The {@code showIntersection} property specifies whether or not the intersection of the sensor with the Earth is shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowIntersectionPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowIntersectionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code showIntersection} property as a {@code reference} value. The {@code showIntersection} property specifies whether or not the intersection of the sensor with the Earth is shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowIntersectionPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowIntersectionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code intersectionColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code intersectionColor} property defines the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter getIntersectionColorWriter() {
        return m_intersectionColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code intersectionColor} property. The {@code intersectionColor} property defines the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter openIntersectionColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getIntersectionColorWriter());
    }

    /**
    * Writes a value for the {@code intersectionColor} property as a {@code rgba} value. The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeIntersectionColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code intersectionColor} property as a {@code rgba} value. The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeIntersectionColorProperty(int red, int green, int blue, int alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code intersectionColor} property as a {@code rgba} value. The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeIntersectionColorProperty(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, values);
        }
    }

    /**
    * Writes a value for the {@code intersectionColor} property as a {@code rgba} value. The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeIntersectionColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code intersectionColor} property as a {@code rgbaf} value. The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeIntersectionColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code intersectionColor} property as a {@code rgbaf} value. The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeIntersectionColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code intersectionColor} property as a {@code rgbaf} value. The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeIntersectionColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, values);
        }
    }

    /**
    * Writes a value for the {@code intersectionColor} property as a {@code rgbaf} value. The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeIntersectionColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code intersectionColor} property as a {@code reference} value. The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeIntersectionColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code intersectionColor} property as a {@code reference} value. The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeIntersectionColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code intersectionColor} property as a {@code reference} value. The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeIntersectionColorPropertyReference(String identifier, String propertyName) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code intersectionColor} property as a {@code reference} value. The {@code intersectionColor} property specifies the color of the intersection of the sensor with the Earth. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeIntersectionColorPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code intersectionWidth} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code intersectionWidth} property defines the width of the intersection in pixels. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getIntersectionWidthWriter() {
        return m_intersectionWidth.getValue();
    }

    /**
    * Opens and returns the writer for the {@code intersectionWidth} property. The {@code intersectionWidth} property defines the width of the intersection in pixels. If not specified, the default value is 1.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openIntersectionWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getIntersectionWidthWriter());
    }

    /**
    * Writes a value for the {@code intersectionWidth} property as a {@code number} value. The {@code intersectionWidth} property specifies the width of the intersection in pixels. If not specified, the default value is 1.0.
    * @param value The value.
    */
    public final void writeIntersectionWidthProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code intersectionWidth} property as a {@code number} value. The {@code intersectionWidth} property specifies the width of the intersection in pixels. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeIntersectionWidthProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code intersectionWidth} property as a {@code number} value. The {@code intersectionWidth} property specifies the width of the intersection in pixels. If not specified, the default value is 1.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeIntersectionWidthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code intersectionWidth} property as a {@code reference} value. The {@code intersectionWidth} property specifies the width of the intersection in pixels. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeIntersectionWidthPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code intersectionWidth} property as a {@code reference} value. The {@code intersectionWidth} property specifies the width of the intersection in pixels. If not specified, the default value is 1.0.
    * @param value The reference.
    */
    public final void writeIntersectionWidthPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code intersectionWidth} property as a {@code reference} value. The {@code intersectionWidth} property specifies the width of the intersection in pixels. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeIntersectionWidthPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code intersectionWidth} property as a {@code reference} value. The {@code intersectionWidth} property specifies the width of the intersection in pixels. If not specified, the default value is 1.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeIntersectionWidthPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code showLateralSurfaces} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code showLateralSurfaces} property defines whether or not the lateral surfaces, i.e., the outer sides of the sensor, are shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowLateralSurfacesWriter() {
        return m_showLateralSurfaces.getValue();
    }

    /**
    * Opens and returns the writer for the {@code showLateralSurfaces} property. The {@code showLateralSurfaces} property defines whether or not the lateral surfaces, i.e., the outer sides of the sensor, are shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowLateralSurfacesProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowLateralSurfacesWriter());
    }

    /**
    * Writes a value for the {@code showLateralSurfaces} property as a {@code boolean} value. The {@code showLateralSurfaces} property specifies whether or not the lateral surfaces, i.e., the outer sides of the sensor, are shown. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeShowLateralSurfacesProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowLateralSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code showLateralSurfaces} property as a {@code reference} value. The {@code showLateralSurfaces} property specifies whether or not the lateral surfaces, i.e., the outer sides of the sensor, are shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowLateralSurfacesPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowLateralSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showLateralSurfaces} property as a {@code reference} value. The {@code showLateralSurfaces} property specifies whether or not the lateral surfaces, i.e., the outer sides of the sensor, are shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowLateralSurfacesPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowLateralSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showLateralSurfaces} property as a {@code reference} value. The {@code showLateralSurfaces} property specifies whether or not the lateral surfaces, i.e., the outer sides of the sensor, are shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowLateralSurfacesPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowLateralSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code showLateralSurfaces} property as a {@code reference} value. The {@code showLateralSurfaces} property specifies whether or not the lateral surfaces, i.e., the outer sides of the sensor, are shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowLateralSurfacesPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowLateralSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code lateralSurfaceMaterial} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code lateralSurfaceMaterial} property defines the material to use for the sensor's lateral surface, i.e., the outer sides of the sensor. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter getLateralSurfaceMaterialWriter() {
        return m_lateralSurfaceMaterial.getValue();
    }

    /**
    * Opens and returns the writer for the {@code lateralSurfaceMaterial} property. The {@code lateralSurfaceMaterial} property defines the material to use for the sensor's lateral surface, i.e., the outer sides of the sensor. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter openLateralSurfaceMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getLateralSurfaceMaterialWriter());
    }

    /**
    * Gets the writer for the {@code showEllipsoidSurfaces} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code showEllipsoidSurfaces} property defines whether or not ellipsoid surfaces are shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowEllipsoidSurfacesWriter() {
        return m_showEllipsoidSurfaces.getValue();
    }

    /**
    * Opens and returns the writer for the {@code showEllipsoidSurfaces} property. The {@code showEllipsoidSurfaces} property defines whether or not ellipsoid surfaces are shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowEllipsoidSurfacesProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowEllipsoidSurfacesWriter());
    }

    /**
    * Writes a value for the {@code showEllipsoidSurfaces} property as a {@code boolean} value. The {@code showEllipsoidSurfaces} property specifies whether or not ellipsoid surfaces are shown. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeShowEllipsoidSurfacesProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEllipsoidSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code showEllipsoidSurfaces} property as a {@code reference} value. The {@code showEllipsoidSurfaces} property specifies whether or not ellipsoid surfaces are shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowEllipsoidSurfacesPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEllipsoidSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showEllipsoidSurfaces} property as a {@code reference} value. The {@code showEllipsoidSurfaces} property specifies whether or not ellipsoid surfaces are shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowEllipsoidSurfacesPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEllipsoidSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showEllipsoidSurfaces} property as a {@code reference} value. The {@code showEllipsoidSurfaces} property specifies whether or not ellipsoid surfaces are shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowEllipsoidSurfacesPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEllipsoidSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code showEllipsoidSurfaces} property as a {@code reference} value. The {@code showEllipsoidSurfaces} property specifies whether or not ellipsoid surfaces are shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowEllipsoidSurfacesPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEllipsoidSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code ellipsoidSurfaceMaterial} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code ellipsoidSurfaceMaterial} property defines the material to use for the sensor's ellipsoid surfaces. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter getEllipsoidSurfaceMaterialWriter() {
        return m_ellipsoidSurfaceMaterial.getValue();
    }

    /**
    * Opens and returns the writer for the {@code ellipsoidSurfaceMaterial} property. The {@code ellipsoidSurfaceMaterial} property defines the material to use for the sensor's ellipsoid surfaces. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter openEllipsoidSurfaceMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getEllipsoidSurfaceMaterialWriter());
    }

    /**
    * Gets the writer for the {@code showEllipsoidHorizonSurfaces} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code showEllipsoidHorizonSurfaces} property defines whether or not ellipsoid horizon surfaces are shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowEllipsoidHorizonSurfacesWriter() {
        return m_showEllipsoidHorizonSurfaces.getValue();
    }

    /**
    * Opens and returns the writer for the {@code showEllipsoidHorizonSurfaces} property. The {@code showEllipsoidHorizonSurfaces} property defines whether or not ellipsoid horizon surfaces are shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowEllipsoidHorizonSurfacesProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowEllipsoidHorizonSurfacesWriter());
    }

    /**
    * Writes a value for the {@code showEllipsoidHorizonSurfaces} property as a {@code boolean} value. The {@code showEllipsoidHorizonSurfaces} property specifies whether or not ellipsoid horizon surfaces are shown. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeShowEllipsoidHorizonSurfacesProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEllipsoidHorizonSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code showEllipsoidHorizonSurfaces} property as a {@code reference} value. The {@code showEllipsoidHorizonSurfaces} property specifies whether or not ellipsoid horizon surfaces are shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowEllipsoidHorizonSurfacesPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEllipsoidHorizonSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showEllipsoidHorizonSurfaces} property as a {@code reference} value. The {@code showEllipsoidHorizonSurfaces} property specifies whether or not ellipsoid horizon surfaces are shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowEllipsoidHorizonSurfacesPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEllipsoidHorizonSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showEllipsoidHorizonSurfaces} property as a {@code reference} value. The {@code showEllipsoidHorizonSurfaces} property specifies whether or not ellipsoid horizon surfaces are shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowEllipsoidHorizonSurfacesPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEllipsoidHorizonSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code showEllipsoidHorizonSurfaces} property as a {@code reference} value. The {@code showEllipsoidHorizonSurfaces} property specifies whether or not ellipsoid horizon surfaces are shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowEllipsoidHorizonSurfacesPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEllipsoidHorizonSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code ellipsoidHorizonSurfaceMaterial} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code ellipsoidHorizonSurfaceMaterial} property defines the material to use for the sensor's ellipsoid horizon surfaces. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter getEllipsoidHorizonSurfaceMaterialWriter() {
        return m_ellipsoidHorizonSurfaceMaterial.getValue();
    }

    /**
    * Opens and returns the writer for the {@code ellipsoidHorizonSurfaceMaterial} property. The {@code ellipsoidHorizonSurfaceMaterial} property defines the material to use for the sensor's ellipsoid horizon surfaces. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter openEllipsoidHorizonSurfaceMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getEllipsoidHorizonSurfaceMaterialWriter());
    }

    /**
    * Gets the writer for the {@code showDomeSurfaces} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code showDomeSurfaces} property defines whether or not dome surfaces are shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowDomeSurfacesWriter() {
        return m_showDomeSurfaces.getValue();
    }

    /**
    * Opens and returns the writer for the {@code showDomeSurfaces} property. The {@code showDomeSurfaces} property defines whether or not dome surfaces are shown. If not specified, the default value is {@code true}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowDomeSurfacesProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowDomeSurfacesWriter());
    }

    /**
    * Writes a value for the {@code showDomeSurfaces} property as a {@code boolean} value. The {@code showDomeSurfaces} property specifies whether or not dome surfaces are shown. If not specified, the default value is {@code true}.
    * @param value The value.
    */
    public final void writeShowDomeSurfacesProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowDomeSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code showDomeSurfaces} property as a {@code reference} value. The {@code showDomeSurfaces} property specifies whether or not dome surfaces are shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowDomeSurfacesPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowDomeSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showDomeSurfaces} property as a {@code reference} value. The {@code showDomeSurfaces} property specifies whether or not dome surfaces are shown. If not specified, the default value is {@code true}.
    * @param value The reference.
    */
    public final void writeShowDomeSurfacesPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowDomeSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showDomeSurfaces} property as a {@code reference} value. The {@code showDomeSurfaces} property specifies whether or not dome surfaces are shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowDomeSurfacesPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowDomeSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code showDomeSurfaces} property as a {@code reference} value. The {@code showDomeSurfaces} property specifies whether or not dome surfaces are shown. If not specified, the default value is {@code true}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowDomeSurfacesPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowDomeSurfacesProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code domeSurfaceMaterial} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code domeSurfaceMaterial} property defines the material to use for the sensor's dome surfaces. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter getDomeSurfaceMaterialWriter() {
        return m_domeSurfaceMaterial.getValue();
    }

    /**
    * Opens and returns the writer for the {@code domeSurfaceMaterial} property. The {@code domeSurfaceMaterial} property defines the material to use for the sensor's dome surfaces. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter openDomeSurfaceMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getDomeSurfaceMaterialWriter());
    }

    /**
    * Gets the writer for the {@code portionToDisplay} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code portionToDisplay} property defines what part of the sensor should be displayed. If not specified, the default value is COMPLETE.
    */
    @Nonnull
    public final SensorVolumePortionToDisplayCesiumWriter getPortionToDisplayWriter() {
        return m_portionToDisplay.getValue();
    }

    /**
    * Opens and returns the writer for the {@code portionToDisplay} property. The {@code portionToDisplay} property defines what part of the sensor should be displayed. If not specified, the default value is COMPLETE.
    */
    @Nonnull
    public final SensorVolumePortionToDisplayCesiumWriter openPortionToDisplayProperty() {
        openIntervalIfNecessary();
        return this.<SensorVolumePortionToDisplayCesiumWriter> openAndReturn(getPortionToDisplayWriter());
    }

    /**
    * Writes a value for the {@code portionToDisplay} property as a {@code portionToDisplay} value. The {@code portionToDisplay} property specifies what part of the sensor should be displayed. If not specified, the default value is COMPLETE.
    * @param value The portion of the sensor to display.
    */
    public final void writePortionToDisplayProperty(@Nonnull CesiumSensorVolumePortionToDisplay value) {
        try (Using<SensorVolumePortionToDisplayCesiumWriter> using$0 = new Using<SensorVolumePortionToDisplayCesiumWriter>(openPortionToDisplayProperty())) {
            final SensorVolumePortionToDisplayCesiumWriter writer = using$0.resource;
            writer.writePortionToDisplay(value);
        }
    }

    /**
    * Writes a value for the {@code portionToDisplay} property as a {@code reference} value. The {@code portionToDisplay} property specifies what part of the sensor should be displayed. If not specified, the default value is COMPLETE.
    * @param value The reference.
    */
    public final void writePortionToDisplayPropertyReference(Reference value) {
        try (Using<SensorVolumePortionToDisplayCesiumWriter> using$0 = new Using<SensorVolumePortionToDisplayCesiumWriter>(openPortionToDisplayProperty())) {
            final SensorVolumePortionToDisplayCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code portionToDisplay} property as a {@code reference} value. The {@code portionToDisplay} property specifies what part of the sensor should be displayed. If not specified, the default value is COMPLETE.
    * @param value The reference.
    */
    public final void writePortionToDisplayPropertyReference(String value) {
        try (Using<SensorVolumePortionToDisplayCesiumWriter> using$0 = new Using<SensorVolumePortionToDisplayCesiumWriter>(openPortionToDisplayProperty())) {
            final SensorVolumePortionToDisplayCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code portionToDisplay} property as a {@code reference} value. The {@code portionToDisplay} property specifies what part of the sensor should be displayed. If not specified, the default value is COMPLETE.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writePortionToDisplayPropertyReference(String identifier, String propertyName) {
        try (Using<SensorVolumePortionToDisplayCesiumWriter> using$0 = new Using<SensorVolumePortionToDisplayCesiumWriter>(openPortionToDisplayProperty())) {
            final SensorVolumePortionToDisplayCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code portionToDisplay} property as a {@code reference} value. The {@code portionToDisplay} property specifies what part of the sensor should be displayed. If not specified, the default value is COMPLETE.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writePortionToDisplayPropertyReference(String identifier, String[] propertyNames) {
        try (Using<SensorVolumePortionToDisplayCesiumWriter> using$0 = new Using<SensorVolumePortionToDisplayCesiumWriter>(openPortionToDisplayProperty())) {
            final SensorVolumePortionToDisplayCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code environmentConstraint} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code environmentConstraint} property defines whether or not the sensor will be occluded by objects in the current view of the environment, e.g. visible terrain or models. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter getEnvironmentConstraintWriter() {
        return m_environmentConstraint.getValue();
    }

    /**
    * Opens and returns the writer for the {@code environmentConstraint} property. The {@code environmentConstraint} property defines whether or not the sensor will be occluded by objects in the current view of the environment, e.g. visible terrain or models. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter openEnvironmentConstraintProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getEnvironmentConstraintWriter());
    }

    /**
    * Writes a value for the {@code environmentConstraint} property as a {@code boolean} value. The {@code environmentConstraint} property specifies whether or not the sensor will be occluded by objects in the current view of the environment, e.g. visible terrain or models. If not specified, the default value is {@code false}.
    * @param value The value.
    */
    public final void writeEnvironmentConstraintProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openEnvironmentConstraintProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code environmentConstraint} property as a {@code reference} value. The {@code environmentConstraint} property specifies whether or not the sensor will be occluded by objects in the current view of the environment, e.g. visible terrain or models. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeEnvironmentConstraintPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openEnvironmentConstraintProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code environmentConstraint} property as a {@code reference} value. The {@code environmentConstraint} property specifies whether or not the sensor will be occluded by objects in the current view of the environment, e.g. visible terrain or models. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeEnvironmentConstraintPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openEnvironmentConstraintProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code environmentConstraint} property as a {@code reference} value. The {@code environmentConstraint} property specifies whether or not the sensor will be occluded by objects in the current view of the environment, e.g. visible terrain or models. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeEnvironmentConstraintPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openEnvironmentConstraintProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code environmentConstraint} property as a {@code reference} value. The {@code environmentConstraint} property specifies whether or not the sensor will be occluded by objects in the current view of the environment, e.g. visible terrain or models. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeEnvironmentConstraintPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openEnvironmentConstraintProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code showEnvironmentOcclusion} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code showEnvironmentOcclusion} property defines whether or not the portion of the terrain occluded by the environment will be drawn with a separate material. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowEnvironmentOcclusionWriter() {
        return m_showEnvironmentOcclusion.getValue();
    }

    /**
    * Opens and returns the writer for the {@code showEnvironmentOcclusion} property. The {@code showEnvironmentOcclusion} property defines whether or not the portion of the terrain occluded by the environment will be drawn with a separate material. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowEnvironmentOcclusionProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowEnvironmentOcclusionWriter());
    }

    /**
    * Writes a value for the {@code showEnvironmentOcclusion} property as a {@code boolean} value. The {@code showEnvironmentOcclusion} property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material. If not specified, the default value is {@code false}.
    * @param value The value.
    */
    public final void writeShowEnvironmentOcclusionProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEnvironmentOcclusionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code showEnvironmentOcclusion} property as a {@code reference} value. The {@code showEnvironmentOcclusion} property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeShowEnvironmentOcclusionPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEnvironmentOcclusionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showEnvironmentOcclusion} property as a {@code reference} value. The {@code showEnvironmentOcclusion} property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeShowEnvironmentOcclusionPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEnvironmentOcclusionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showEnvironmentOcclusion} property as a {@code reference} value. The {@code showEnvironmentOcclusion} property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowEnvironmentOcclusionPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEnvironmentOcclusionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code showEnvironmentOcclusion} property as a {@code reference} value. The {@code showEnvironmentOcclusion} property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowEnvironmentOcclusionPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEnvironmentOcclusionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code environmentOcclusionMaterial} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code environmentOcclusionMaterial} property defines the material to use for the portion of the sensor occluded by the environment. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter getEnvironmentOcclusionMaterialWriter() {
        return m_environmentOcclusionMaterial.getValue();
    }

    /**
    * Opens and returns the writer for the {@code environmentOcclusionMaterial} property. The {@code environmentOcclusionMaterial} property defines the material to use for the portion of the sensor occluded by the environment. If not specified, the default value is solid white.
    */
    @Nonnull
    public final MaterialCesiumWriter openEnvironmentOcclusionMaterialProperty() {
        openIntervalIfNecessary();
        return this.<MaterialCesiumWriter> openAndReturn(getEnvironmentOcclusionMaterialWriter());
    }

    /**
    * Gets the writer for the {@code showEnvironmentIntersection} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code showEnvironmentIntersection} property defines whether or not a line showing where the sensor intersects the environment will be drawn. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowEnvironmentIntersectionWriter() {
        return m_showEnvironmentIntersection.getValue();
    }

    /**
    * Opens and returns the writer for the {@code showEnvironmentIntersection} property. The {@code showEnvironmentIntersection} property defines whether or not a line showing where the sensor intersects the environment will be drawn. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowEnvironmentIntersectionProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowEnvironmentIntersectionWriter());
    }

    /**
    * Writes a value for the {@code showEnvironmentIntersection} property as a {@code boolean} value. The {@code showEnvironmentIntersection} property specifies whether or not a line showing where the sensor intersects the environment will be drawn. If not specified, the default value is {@code false}.
    * @param value The value.
    */
    public final void writeShowEnvironmentIntersectionProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEnvironmentIntersectionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code showEnvironmentIntersection} property as a {@code reference} value. The {@code showEnvironmentIntersection} property specifies whether or not a line showing where the sensor intersects the environment will be drawn. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeShowEnvironmentIntersectionPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEnvironmentIntersectionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showEnvironmentIntersection} property as a {@code reference} value. The {@code showEnvironmentIntersection} property specifies whether or not a line showing where the sensor intersects the environment will be drawn. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeShowEnvironmentIntersectionPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEnvironmentIntersectionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showEnvironmentIntersection} property as a {@code reference} value. The {@code showEnvironmentIntersection} property specifies whether or not a line showing where the sensor intersects the environment will be drawn. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowEnvironmentIntersectionPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEnvironmentIntersectionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code showEnvironmentIntersection} property as a {@code reference} value. The {@code showEnvironmentIntersection} property specifies whether or not a line showing where the sensor intersects the environment will be drawn. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowEnvironmentIntersectionPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowEnvironmentIntersectionProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code environmentIntersectionColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code environmentIntersectionColor} property defines the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter getEnvironmentIntersectionColorWriter() {
        return m_environmentIntersectionColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code environmentIntersectionColor} property. The {@code environmentIntersectionColor} property defines the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    */
    @Nonnull
    public final ColorCesiumWriter openEnvironmentIntersectionColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getEnvironmentIntersectionColorWriter());
    }

    /**
    * Writes a value for the {@code environmentIntersectionColor} property as a {@code rgba} value. The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeEnvironmentIntersectionColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEnvironmentIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionColor} property as a {@code rgba} value. The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeEnvironmentIntersectionColorProperty(int red, int green, int blue, int alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEnvironmentIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionColor} property as a {@code rgba} value. The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeEnvironmentIntersectionColorProperty(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEnvironmentIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, values);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionColor} property as a {@code rgba} value. The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeEnvironmentIntersectionColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEnvironmentIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionColor} property as a {@code rgbaf} value. The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    * @param color The color.
    */
    public final void writeEnvironmentIntersectionColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEnvironmentIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionColor} property as a {@code rgbaf} value. The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeEnvironmentIntersectionColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEnvironmentIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionColor} property as a {@code rgbaf} value. The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeEnvironmentIntersectionColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEnvironmentIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, values);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionColor} property as a {@code rgbaf} value. The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeEnvironmentIntersectionColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEnvironmentIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionColor} property as a {@code reference} value. The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeEnvironmentIntersectionColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEnvironmentIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionColor} property as a {@code reference} value. The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    * @param value The reference.
    */
    public final void writeEnvironmentIntersectionColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEnvironmentIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionColor} property as a {@code reference} value. The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeEnvironmentIntersectionColorPropertyReference(String identifier, String propertyName) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEnvironmentIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionColor} property as a {@code reference} value. The {@code environmentIntersectionColor} property specifies the color of the intersection line between the sensor and the environment. If not specified, the default value is white.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeEnvironmentIntersectionColorPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openEnvironmentIntersectionColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code environmentIntersectionWidth} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code environmentIntersectionWidth} property defines the width in meters of the intersection line between the sensor and the environment. If not specified, the default value is 5.0.
    */
    @Nonnull
    public final DoubleCesiumWriter getEnvironmentIntersectionWidthWriter() {
        return m_environmentIntersectionWidth.getValue();
    }

    /**
    * Opens and returns the writer for the {@code environmentIntersectionWidth} property. The {@code environmentIntersectionWidth} property defines the width in meters of the intersection line between the sensor and the environment. If not specified, the default value is 5.0.
    */
    @Nonnull
    public final DoubleCesiumWriter openEnvironmentIntersectionWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getEnvironmentIntersectionWidthWriter());
    }

    /**
    * Writes a value for the {@code environmentIntersectionWidth} property as a {@code number} value. The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment. If not specified, the default value is 5.0.
    * @param value The value.
    */
    public final void writeEnvironmentIntersectionWidthProperty(double value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openEnvironmentIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionWidth} property as a {@code number} value. The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment. If not specified, the default value is 5.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeEnvironmentIntersectionWidthProperty(List<JulianDate> dates, List<Double> values) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openEnvironmentIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionWidth} property as a {@code number} value. The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment. If not specified, the default value is 5.0.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeEnvironmentIntersectionWidthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openEnvironmentIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionWidth} property as a {@code reference} value. The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment. If not specified, the default value is 5.0.
    * @param value The reference.
    */
    public final void writeEnvironmentIntersectionWidthPropertyReference(Reference value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openEnvironmentIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionWidth} property as a {@code reference} value. The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment. If not specified, the default value is 5.0.
    * @param value The reference.
    */
    public final void writeEnvironmentIntersectionWidthPropertyReference(String value) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openEnvironmentIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionWidth} property as a {@code reference} value. The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment. If not specified, the default value is 5.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeEnvironmentIntersectionWidthPropertyReference(String identifier, String propertyName) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openEnvironmentIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code environmentIntersectionWidth} property as a {@code reference} value. The {@code environmentIntersectionWidth} property specifies the width in meters of the intersection line between the sensor and the environment. If not specified, the default value is 5.0.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeEnvironmentIntersectionWidthPropertyReference(String identifier, String[] propertyNames) {
        try (Using<DoubleCesiumWriter> using$0 = new Using<DoubleCesiumWriter>(openEnvironmentIntersectionWidthProperty())) {
            final DoubleCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code showThroughEllipsoid} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code showThroughEllipsoid} property defines whether or not a sensor intersecting the ellipsoid is drawn through the ellipsoid and potentially out to the other side. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowThroughEllipsoidWriter() {
        return m_showThroughEllipsoid.getValue();
    }

    /**
    * Opens and returns the writer for the {@code showThroughEllipsoid} property. The {@code showThroughEllipsoid} property defines whether or not a sensor intersecting the ellipsoid is drawn through the ellipsoid and potentially out to the other side. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowThroughEllipsoidProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowThroughEllipsoidWriter());
    }

    /**
    * Writes a value for the {@code showThroughEllipsoid} property as a {@code boolean} value. The {@code showThroughEllipsoid} property specifies whether or not a sensor intersecting the ellipsoid is drawn through the ellipsoid and potentially out to the other side. If not specified, the default value is {@code false}.
    * @param value The value.
    */
    public final void writeShowThroughEllipsoidProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowThroughEllipsoidProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code showThroughEllipsoid} property as a {@code reference} value. The {@code showThroughEllipsoid} property specifies whether or not a sensor intersecting the ellipsoid is drawn through the ellipsoid and potentially out to the other side. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeShowThroughEllipsoidPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowThroughEllipsoidProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showThroughEllipsoid} property as a {@code reference} value. The {@code showThroughEllipsoid} property specifies whether or not a sensor intersecting the ellipsoid is drawn through the ellipsoid and potentially out to the other side. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeShowThroughEllipsoidPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowThroughEllipsoidProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showThroughEllipsoid} property as a {@code reference} value. The {@code showThroughEllipsoid} property specifies whether or not a sensor intersecting the ellipsoid is drawn through the ellipsoid and potentially out to the other side. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowThroughEllipsoidPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowThroughEllipsoidProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code showThroughEllipsoid} property as a {@code reference} value. The {@code showThroughEllipsoid} property specifies whether or not a sensor intersecting the ellipsoid is drawn through the ellipsoid and potentially out to the other side. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowThroughEllipsoidPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowThroughEllipsoidProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code showViewshed} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code showViewshed} property defines whether or not the viewshed of the sensor will be drawn. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter getShowViewshedWriter() {
        return m_showViewshed.getValue();
    }

    /**
    * Opens and returns the writer for the {@code showViewshed} property. The {@code showViewshed} property defines whether or not the viewshed of the sensor will be drawn. If not specified, the default value is {@code false}.
    */
    @Nonnull
    public final BooleanCesiumWriter openShowViewshedProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowViewshedWriter());
    }

    /**
    * Writes a value for the {@code showViewshed} property as a {@code boolean} value. The {@code showViewshed} property specifies whether or not the viewshed of the sensor will be drawn. If not specified, the default value is {@code false}.
    * @param value The value.
    */
    public final void writeShowViewshedProperty(boolean value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowViewshedProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeBoolean(value);
        }
    }

    /**
    * Writes a value for the {@code showViewshed} property as a {@code reference} value. The {@code showViewshed} property specifies whether or not the viewshed of the sensor will be drawn. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeShowViewshedPropertyReference(Reference value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowViewshedProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showViewshed} property as a {@code reference} value. The {@code showViewshed} property specifies whether or not the viewshed of the sensor will be drawn. If not specified, the default value is {@code false}.
    * @param value The reference.
    */
    public final void writeShowViewshedPropertyReference(String value) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowViewshedProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code showViewshed} property as a {@code reference} value. The {@code showViewshed} property specifies whether or not the viewshed of the sensor will be drawn. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowViewshedPropertyReference(String identifier, String propertyName) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowViewshedProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code showViewshed} property as a {@code reference} value. The {@code showViewshed} property specifies whether or not the viewshed of the sensor will be drawn. If not specified, the default value is {@code false}.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowViewshedPropertyReference(String identifier, String[] propertyNames) {
        try (Using<BooleanCesiumWriter> using$0 = new Using<BooleanCesiumWriter>(openShowViewshedProperty())) {
            final BooleanCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code viewshedVisibleColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code viewshedVisibleColor} property defines the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    */
    @Nonnull
    public final ColorCesiumWriter getViewshedVisibleColorWriter() {
        return m_viewshedVisibleColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code viewshedVisibleColor} property. The {@code viewshedVisibleColor} property defines the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    */
    @Nonnull
    public final ColorCesiumWriter openViewshedVisibleColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getViewshedVisibleColorWriter());
    }

    /**
    * Writes a value for the {@code viewshedVisibleColor} property as a {@code rgba} value. The {@code viewshedVisibleColor} property specifies the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    * @param color The color.
    */
    public final void writeViewshedVisibleColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedVisibleColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code viewshedVisibleColor} property as a {@code rgba} value. The {@code viewshedVisibleColor} property specifies the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeViewshedVisibleColorProperty(int red, int green, int blue, int alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedVisibleColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code viewshedVisibleColor} property as a {@code rgba} value. The {@code viewshedVisibleColor} property specifies the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeViewshedVisibleColorProperty(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedVisibleColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, values);
        }
    }

    /**
    * Writes a value for the {@code viewshedVisibleColor} property as a {@code rgba} value. The {@code viewshedVisibleColor} property specifies the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeViewshedVisibleColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedVisibleColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code viewshedVisibleColor} property as a {@code rgbaf} value. The {@code viewshedVisibleColor} property specifies the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    * @param color The color.
    */
    public final void writeViewshedVisibleColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedVisibleColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code viewshedVisibleColor} property as a {@code rgbaf} value. The {@code viewshedVisibleColor} property specifies the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeViewshedVisibleColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedVisibleColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code viewshedVisibleColor} property as a {@code rgbaf} value. The {@code viewshedVisibleColor} property specifies the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeViewshedVisibleColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedVisibleColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, values);
        }
    }

    /**
    * Writes a value for the {@code viewshedVisibleColor} property as a {@code rgbaf} value. The {@code viewshedVisibleColor} property specifies the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeViewshedVisibleColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedVisibleColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code viewshedVisibleColor} property as a {@code reference} value. The {@code viewshedVisibleColor} property specifies the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    * @param value The reference.
    */
    public final void writeViewshedVisibleColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedVisibleColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code viewshedVisibleColor} property as a {@code reference} value. The {@code viewshedVisibleColor} property specifies the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    * @param value The reference.
    */
    public final void writeViewshedVisibleColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedVisibleColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code viewshedVisibleColor} property as a {@code reference} value. The {@code viewshedVisibleColor} property specifies the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeViewshedVisibleColorPropertyReference(String identifier, String propertyName) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedVisibleColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code viewshedVisibleColor} property as a {@code reference} value. The {@code viewshedVisibleColor} property specifies the color of the scene geometry that is visible to the sensor. If not specified, the default value is lime, 50% transparent.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeViewshedVisibleColorPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedVisibleColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code viewshedOccludedColor} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code viewshedOccludedColor} property defines the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    */
    @Nonnull
    public final ColorCesiumWriter getViewshedOccludedColorWriter() {
        return m_viewshedOccludedColor.getValue();
    }

    /**
    * Opens and returns the writer for the {@code viewshedOccludedColor} property. The {@code viewshedOccludedColor} property defines the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    */
    @Nonnull
    public final ColorCesiumWriter openViewshedOccludedColorProperty() {
        openIntervalIfNecessary();
        return this.<ColorCesiumWriter> openAndReturn(getViewshedOccludedColorWriter());
    }

    /**
    * Writes a value for the {@code viewshedOccludedColor} property as a {@code rgba} value. The {@code viewshedOccludedColor} property specifies the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    * @param color The color.
    */
    public final void writeViewshedOccludedColorProperty(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedOccludedColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(color);
        }
    }

    /**
    * Writes a value for the {@code viewshedOccludedColor} property as a {@code rgba} value. The {@code viewshedOccludedColor} property specifies the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeViewshedOccludedColorProperty(int red, int green, int blue, int alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedOccludedColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code viewshedOccludedColor} property as a {@code rgba} value. The {@code viewshedOccludedColor} property specifies the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeViewshedOccludedColorProperty(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedOccludedColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, values);
        }
    }

    /**
    * Writes a value for the {@code viewshedOccludedColor} property as a {@code rgba} value. The {@code viewshedOccludedColor} property specifies the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeViewshedOccludedColorProperty(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedOccludedColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgba(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code viewshedOccludedColor} property as a {@code rgbaf} value. The {@code viewshedOccludedColor} property specifies the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    * @param color The color.
    */
    public final void writeViewshedOccludedColorPropertyRgbaf(@Nonnull Color color) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedOccludedColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(color);
        }
    }

    /**
    * Writes a value for the {@code viewshedOccludedColor} property as a {@code rgbaf} value. The {@code viewshedOccludedColor} property specifies the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeViewshedOccludedColorPropertyRgbaf(float red, float green, float blue, float alpha) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedOccludedColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(red, green, blue, alpha);
        }
    }

    /**
    * Writes a value for the {@code viewshedOccludedColor} property as a {@code rgbaf} value. The {@code viewshedOccludedColor} property specifies the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeViewshedOccludedColorPropertyRgbaf(List<JulianDate> dates, List<Color> values) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedOccludedColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, values);
        }
    }

    /**
    * Writes a value for the {@code viewshedOccludedColor} property as a {@code rgbaf} value. The {@code viewshedOccludedColor} property specifies the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeViewshedOccludedColorPropertyRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedOccludedColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeRgbaf(dates, colors, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code viewshedOccludedColor} property as a {@code reference} value. The {@code viewshedOccludedColor} property specifies the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    * @param value The reference.
    */
    public final void writeViewshedOccludedColorPropertyReference(Reference value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedOccludedColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code viewshedOccludedColor} property as a {@code reference} value. The {@code viewshedOccludedColor} property specifies the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    * @param value The reference.
    */
    public final void writeViewshedOccludedColorPropertyReference(String value) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedOccludedColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code viewshedOccludedColor} property as a {@code reference} value. The {@code viewshedOccludedColor} property specifies the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeViewshedOccludedColorPropertyReference(String identifier, String propertyName) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedOccludedColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code viewshedOccludedColor} property as a {@code reference} value. The {@code viewshedOccludedColor} property specifies the color of the scene geometry that is not visible to the sensor. If not specified, the default value is red, 50% transparent.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeViewshedOccludedColorPropertyReference(String identifier, String[] propertyNames) {
        try (Using<ColorCesiumWriter> using$0 = new Using<ColorCesiumWriter>(openViewshedOccludedColorProperty())) {
            final ColorCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }

    /**
    * Gets the writer for the {@code viewshedResolution} property. The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing. The {@code viewshedResolution} property defines the resolution in pixels of the viewshed. If not specified, the default value is 2048.
    */
    @Nonnull
    public final IntegerCesiumWriter getViewshedResolutionWriter() {
        return m_viewshedResolution.getValue();
    }

    /**
    * Opens and returns the writer for the {@code viewshedResolution} property. The {@code viewshedResolution} property defines the resolution in pixels of the viewshed. If not specified, the default value is 2048.
    */
    @Nonnull
    public final IntegerCesiumWriter openViewshedResolutionProperty() {
        openIntervalIfNecessary();
        return this.<IntegerCesiumWriter> openAndReturn(getViewshedResolutionWriter());
    }

    /**
    * Writes a value for the {@code viewshedResolution} property as a {@code number} value. The {@code viewshedResolution} property specifies the resolution in pixels of the viewshed. If not specified, the default value is 2048.
    * @param value The value.
    */
    public final void writeViewshedResolutionProperty(int value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openViewshedResolutionProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(value);
        }
    }

    /**
    * Writes a value for the {@code viewshedResolution} property as a {@code number} value. The {@code viewshedResolution} property specifies the resolution in pixels of the viewshed. If not specified, the default value is 2048.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeViewshedResolutionProperty(List<JulianDate> dates, List<Integer> values) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openViewshedResolutionProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values);
        }
    }

    /**
    * Writes a value for the {@code viewshedResolution} property as a {@code number} value. The {@code viewshedResolution} property specifies the resolution in pixels of the viewshed. If not specified, the default value is 2048.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeViewshedResolutionProperty(List<JulianDate> dates, List<Integer> values, int startIndex, int length) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openViewshedResolutionProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeNumber(dates, values, startIndex, length);
        }
    }

    /**
    * Writes a value for the {@code viewshedResolution} property as a {@code reference} value. The {@code viewshedResolution} property specifies the resolution in pixels of the viewshed. If not specified, the default value is 2048.
    * @param value The reference.
    */
    public final void writeViewshedResolutionPropertyReference(Reference value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openViewshedResolutionProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code viewshedResolution} property as a {@code reference} value. The {@code viewshedResolution} property specifies the resolution in pixels of the viewshed. If not specified, the default value is 2048.
    * @param value The reference.
    */
    public final void writeViewshedResolutionPropertyReference(String value) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openViewshedResolutionProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(value);
        }
    }

    /**
    * Writes a value for the {@code viewshedResolution} property as a {@code reference} value. The {@code viewshedResolution} property specifies the resolution in pixels of the viewshed. If not specified, the default value is 2048.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeViewshedResolutionPropertyReference(String identifier, String propertyName) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openViewshedResolutionProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyName);
        }
    }

    /**
    * Writes a value for the {@code viewshedResolution} property as a {@code reference} value. The {@code viewshedResolution} property specifies the resolution in pixels of the viewshed. If not specified, the default value is 2048.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeViewshedResolutionPropertyReference(String identifier, String[] propertyNames) {
        try (Using<IntegerCesiumWriter> using$0 = new Using<IntegerCesiumWriter>(openViewshedResolutionProperty())) {
            final IntegerCesiumWriter writer = using$0.resource;
            writer.writeReference(identifier, propertyNames);
        }
    }
}