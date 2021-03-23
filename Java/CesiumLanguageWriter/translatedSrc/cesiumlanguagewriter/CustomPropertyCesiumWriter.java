package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.awt.image.RenderedImage;
import java.net.URI;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code CustomProperty} to a {@link CesiumOutputStream}. A {@code CustomProperty} is a custom property.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class CustomPropertyCesiumWriter extends CesiumInterpolatablePropertyWriter<CustomPropertyCesiumWriter> implements ICesiumDeletablePropertyWriter, ICesiumBooleanValuePropertyWriter,
        ICesiumBoundingRectangleValuePropertyWriter, ICesiumCartesian3ValuePropertyWriter, ICesiumCartographicDegreesValuePropertyWriter, ICesiumCartographicRadiansValuePropertyWriter,
        ICesiumCartesian2ValuePropertyWriter, ICesiumUnitCartesian3ValuePropertyWriter, ICesiumSphericalValuePropertyWriter, ICesiumUnitSphericalValuePropertyWriter, ICesiumRgbaValuePropertyWriter,
        ICesiumRgbafValuePropertyWriter, ICesiumColorBlendModeValuePropertyWriter, ICesiumCornerTypeValuePropertyWriter, ICesiumHeightReferenceValuePropertyWriter,
        ICesiumHorizontalOriginValuePropertyWriter, ICesiumLabelStyleValuePropertyWriter, ICesiumDoubleValuePropertyWriter, ICesiumNearFarScalarValuePropertyWriter,
        ICesiumUnitQuaternionValuePropertyWriter, ICesiumShadowModeValuePropertyWriter, ICesiumStringValuePropertyWriter, ICesiumStripeOrientationValuePropertyWriter,
        ICesiumCartographicRectangleRadiansValuePropertyWriter, ICesiumCartographicRectangleDegreesValuePropertyWriter, ICesiumUriValuePropertyWriter, ICesiumVerticalOriginValuePropertyWriter {
    /**
    * The name of the {@code boolean} property.
    */
    @Nonnull
    public static final String BooleanPropertyName = "boolean";
    /**
    * The name of the {@code boundingRectangle} property.
    */
    @Nonnull
    public static final String BoundingRectanglePropertyName = "boundingRectangle";
    /**
    * The name of the {@code cartesian} property.
    */
    @Nonnull
    public static final String CartesianPropertyName = "cartesian";
    /**
    * The name of the {@code cartographicRadians} property.
    */
    @Nonnull
    public static final String CartographicRadiansPropertyName = "cartographicRadians";
    /**
    * The name of the {@code cartographicDegrees} property.
    */
    @Nonnull
    public static final String CartographicDegreesPropertyName = "cartographicDegrees";
    /**
    * The name of the {@code cartesian2} property.
    */
    @Nonnull
    public static final String Cartesian2PropertyName = "cartesian2";
    /**
    * The name of the {@code unitCartesian} property.
    */
    @Nonnull
    public static final String UnitCartesianPropertyName = "unitCartesian";
    /**
    * The name of the {@code spherical} property.
    */
    @Nonnull
    public static final String SphericalPropertyName = "spherical";
    /**
    * The name of the {@code unitSpherical} property.
    */
    @Nonnull
    public static final String UnitSphericalPropertyName = "unitSpherical";
    /**
    * The name of the {@code rgba} property.
    */
    @Nonnull
    public static final String RgbaPropertyName = "rgba";
    /**
    * The name of the {@code rgbaf} property.
    */
    @Nonnull
    public static final String RgbafPropertyName = "rgbaf";
    /**
    * The name of the {@code colorBlendMode} property.
    */
    @Nonnull
    public static final String ColorBlendModePropertyName = "colorBlendMode";
    /**
    * The name of the {@code cornerType} property.
    */
    @Nonnull
    public static final String CornerTypePropertyName = "cornerType";
    /**
    * The name of the {@code heightReference} property.
    */
    @Nonnull
    public static final String HeightReferencePropertyName = "heightReference";
    /**
    * The name of the {@code horizontalOrigin} property.
    */
    @Nonnull
    public static final String HorizontalOriginPropertyName = "horizontalOrigin";
    /**
    * The name of the {@code labelStyle} property.
    */
    @Nonnull
    public static final String LabelStylePropertyName = "labelStyle";
    /**
    * The name of the {@code number} property.
    */
    @Nonnull
    public static final String NumberPropertyName = "number";
    /**
    * The name of the {@code nearFarScalar} property.
    */
    @Nonnull
    public static final String NearFarScalarPropertyName = "nearFarScalar";
    /**
    * The name of the {@code unitQuaternion} property.
    */
    @Nonnull
    public static final String UnitQuaternionPropertyName = "unitQuaternion";
    /**
    * The name of the {@code shadowMode} property.
    */
    @Nonnull
    public static final String ShadowModePropertyName = "shadowMode";
    /**
    * The name of the {@code string} property.
    */
    @Nonnull
    public static final String StringPropertyName = "string";
    /**
    * The name of the {@code stripeOrientation} property.
    */
    @Nonnull
    public static final String StripeOrientationPropertyName = "stripeOrientation";
    /**
    * The name of the {@code wsen} property.
    */
    @Nonnull
    public static final String WsenPropertyName = "wsen";
    /**
    * The name of the {@code wsenDegrees} property.
    */
    @Nonnull
    public static final String WsenDegreesPropertyName = "wsenDegrees";
    /**
    * The name of the {@code uri} property.
    */
    @Nonnull
    public static final String UriPropertyName = "uri";
    /**
    * The name of the {@code verticalOrigin} property.
    */
    @Nonnull
    public static final String VerticalOriginPropertyName = "verticalOrigin";
    /**
    * The name of the {@code delete} property.
    */
    @Nonnull
    public static final String DeletePropertyName = "delete";
    @Nonnull
    private final Lazy<CesiumBooleanValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asBoolean;
    @Nonnull
    private final Lazy<CesiumBoundingRectangleValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asBoundingRectangle;
    @Nonnull
    private final Lazy<CesiumCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asCartesian;
    @Nonnull
    private final Lazy<CesiumCartographicRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asCartographicRadians;
    @Nonnull
    private final Lazy<CesiumCartographicDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asCartographicDegrees;
    @Nonnull
    private final Lazy<CesiumCartesian2ValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asCartesian2;
    @Nonnull
    private final Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asUnitCartesian;
    @Nonnull
    private final Lazy<CesiumSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asSpherical;
    @Nonnull
    private final Lazy<CesiumUnitSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asUnitSpherical;
    @Nonnull
    private final Lazy<CesiumRgbaValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asRgba;
    @Nonnull
    private final Lazy<CesiumRgbafValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asRgbaf;
    @Nonnull
    private final Lazy<CesiumColorBlendModeValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asColorBlendMode;
    @Nonnull
    private final Lazy<CesiumCornerTypeValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asCornerType;
    @Nonnull
    private final Lazy<CesiumHeightReferenceValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asHeightReference;
    @Nonnull
    private final Lazy<CesiumHorizontalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asHorizontalOrigin;
    @Nonnull
    private final Lazy<CesiumLabelStyleValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asLabelStyle;
    @Nonnull
    private final Lazy<CesiumDoubleValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asNumber;
    @Nonnull
    private final Lazy<CesiumNearFarScalarValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asNearFarScalar;
    @Nonnull
    private final Lazy<CesiumUnitQuaternionValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asUnitQuaternion;
    @Nonnull
    private final Lazy<CesiumShadowModeValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asShadowMode;
    @Nonnull
    private final Lazy<CesiumStringValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asString;
    @Nonnull
    private final Lazy<CesiumStripeOrientationValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asStripeOrientation;
    @Nonnull
    private final Lazy<CesiumCartographicRectangleRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asWsen;
    @Nonnull
    private final Lazy<CesiumCartographicRectangleDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asWsenDegrees;
    @Nonnull
    private final Lazy<CesiumUriValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asUri;
    @Nonnull
    private final Lazy<CesiumVerticalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter>> m_asVerticalOrigin;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public CustomPropertyCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asBoolean = createAsBoolean();
        m_asBoundingRectangle = createAsBoundingRectangle();
        m_asCartesian = createAsCartesian();
        m_asCartographicRadians = createAsCartographicRadians();
        m_asCartographicDegrees = createAsCartographicDegrees();
        m_asCartesian2 = createAsCartesian2();
        m_asUnitCartesian = createAsUnitCartesian();
        m_asSpherical = createAsSpherical();
        m_asUnitSpherical = createAsUnitSpherical();
        m_asRgba = createAsRgba();
        m_asRgbaf = createAsRgbaf();
        m_asColorBlendMode = createAsColorBlendMode();
        m_asCornerType = createAsCornerType();
        m_asHeightReference = createAsHeightReference();
        m_asHorizontalOrigin = createAsHorizontalOrigin();
        m_asLabelStyle = createAsLabelStyle();
        m_asNumber = createAsNumber();
        m_asNearFarScalar = createAsNearFarScalar();
        m_asUnitQuaternion = createAsUnitQuaternion();
        m_asShadowMode = createAsShadowMode();
        m_asString = createAsString();
        m_asStripeOrientation = createAsStripeOrientation();
        m_asWsen = createAsWsen();
        m_asWsenDegrees = createAsWsenDegrees();
        m_asUri = createAsUri();
        m_asVerticalOrigin = createAsVerticalOrigin();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected CustomPropertyCesiumWriter(@Nonnull CustomPropertyCesiumWriter existingInstance) {
        super(existingInstance);
        m_asBoolean = createAsBoolean();
        m_asBoundingRectangle = createAsBoundingRectangle();
        m_asCartesian = createAsCartesian();
        m_asCartographicRadians = createAsCartographicRadians();
        m_asCartographicDegrees = createAsCartographicDegrees();
        m_asCartesian2 = createAsCartesian2();
        m_asUnitCartesian = createAsUnitCartesian();
        m_asSpherical = createAsSpherical();
        m_asUnitSpherical = createAsUnitSpherical();
        m_asRgba = createAsRgba();
        m_asRgbaf = createAsRgbaf();
        m_asColorBlendMode = createAsColorBlendMode();
        m_asCornerType = createAsCornerType();
        m_asHeightReference = createAsHeightReference();
        m_asHorizontalOrigin = createAsHorizontalOrigin();
        m_asLabelStyle = createAsLabelStyle();
        m_asNumber = createAsNumber();
        m_asNearFarScalar = createAsNearFarScalar();
        m_asUnitQuaternion = createAsUnitQuaternion();
        m_asShadowMode = createAsShadowMode();
        m_asString = createAsString();
        m_asStripeOrientation = createAsStripeOrientation();
        m_asWsen = createAsWsen();
        m_asWsenDegrees = createAsWsenDegrees();
        m_asUri = createAsUri();
        m_asVerticalOrigin = createAsVerticalOrigin();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public CustomPropertyCesiumWriter clone() {
        return new CustomPropertyCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code boolean}, which is the property specified as a boolean value.
    * @param value The value.
    */
    public final void writeBoolean(boolean value) {
        final String PropertyName = BooleanPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(value);
    }

    /**
    * Writes the value expressed as a {@code boundingRectangle}, which is the property specified as {@code [X, Y, Width, Height]}.
    * @param value The value.
    */
    public final void writeBoundingRectangle(@Nonnull BoundingRectangle value) {
        final String PropertyName = BoundingRectanglePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeBoundingRectangle(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code boundingRectangle}, which is the property specified as {@code [X, Y, Width, Height]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBoundingRectangle(List<JulianDate> dates, List<BoundingRectangle> values) {
        writeBoundingRectangle(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code boundingRectangle}, which is the property specified as {@code [X, Y, Width, Height]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeBoundingRectangle(List<JulianDate> dates, List<BoundingRectangle> values, int startIndex, int length) {
        final String PropertyName = BoundingRectanglePropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeBoundingRectangle(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the property specified as a three-dimensional Cartesian value {@code [X, Y, Z]}.
    * @param value The value.
    */
    public final void writeCartesian(@Nonnull Cartesian value) {
        final String PropertyName = CartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian3(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the property specified as a three-dimensional Cartesian value {@code [X, Y, Z]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values) {
        writeCartesian(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code cartesian}, which is the property specified as a three-dimensional Cartesian value {@code [X, Y, Z]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartesian(List<JulianDate> dates, List<Cartesian> values, int startIndex, int length) {
        final String PropertyName = CartesianPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartesian3(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code cartographicRadians}, which is the property specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in radians and Height is in meters.
    * @param value The interval.
    */
    public final void writeCartographicRadians(@Nonnull Cartographic value) {
        final String PropertyName = CartographicRadiansPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographic(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code cartographicRadians}, which is the property specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in radians and Height is in meters.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartographicRadians(List<JulianDate> dates, List<Cartographic> values) {
        writeCartographicRadians(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code cartographicRadians}, which is the property specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in radians and Height is in meters.
    * @param dates The dates at which the value is specified.
    * @param values The position corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartographicRadians(List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
        final String PropertyName = CartographicRadiansPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartographic(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code cartographicDegrees}, which is the property specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees and Height is in meters.
    * @param value The interval.
    */
    public final void writeCartographicDegrees(@Nonnull Cartographic value) {
        final String PropertyName = CartographicDegreesPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographic(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code cartographicDegrees}, which is the property specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees and Height is in meters.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartographicDegrees(List<JulianDate> dates, List<Cartographic> values) {
        writeCartographicDegrees(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code cartographicDegrees}, which is the property specified in Cartographic WGS84 coordinates, {@code [Longitude, Latitude, Height]}, where Longitude and Latitude are in degrees and Height is in meters.
    * @param dates The dates at which the value is specified.
    * @param values The position corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartographicDegrees(List<JulianDate> dates, List<Cartographic> values, int startIndex, int length) {
        final String PropertyName = CartographicDegreesPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartographic(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code cartesian2}, which is the property specified as a two-dimensional Cartesian value {@code [X, Y]}.
    * @param value The value.
    */
    public final void writeCartesian2(@Nonnull Rectangular value) {
        final String PropertyName = Cartesian2PropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartesian2(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code cartesian2}, which is the property specified as a two-dimensional Cartesian value {@code [X, Y]}.
    * @param x The X component.
    * @param y The Y component.
    */
    public final void writeCartesian2(double x, double y) {
        writeCartesian2(new Rectangular(x, y));
    }

    /**
    * Writes the value expressed as a {@code cartesian2}, which is the property specified as a two-dimensional Cartesian value {@code [X, Y]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeCartesian2(List<JulianDate> dates, List<Rectangular> values) {
        writeCartesian2(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code cartesian2}, which is the property specified as a two-dimensional Cartesian value {@code [X, Y]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeCartesian2(List<JulianDate> dates, List<Rectangular> values, int startIndex, int length) {
        final String PropertyName = Cartesian2PropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartesian2(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code unitCartesian}, which is the property specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}.
    * @param value The value.
    */
    public final void writeUnitCartesian(@Nonnull UnitCartesian value) {
        final String PropertyName = UnitCartesianPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitCartesian3(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code unitCartesian}, which is the property specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values) {
        writeUnitCartesian(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code unitCartesian}, which is the property specified as a three-dimensional unit magnitude Cartesian value {@code [X, Y, Z]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeUnitCartesian(List<JulianDate> dates, List<UnitCartesian> values, int startIndex, int length) {
        final String PropertyName = UnitCartesianPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeUnitCartesian3(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code spherical}, which is the property specified as a spherical value {@code [Clock, Cone, Magnitude]}. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param value The value.
    */
    public final void writeSpherical(@Nonnull Spherical value) {
        final String PropertyName = SphericalPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeSpherical(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code spherical}, which is the property specified as a spherical value {@code [Clock, Cone, Magnitude]}. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeSpherical(List<JulianDate> dates, List<Spherical> values) {
        writeSpherical(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code spherical}, which is the property specified as a spherical value {@code [Clock, Cone, Magnitude]}. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeSpherical(List<JulianDate> dates, List<Spherical> values, int startIndex, int length) {
        final String PropertyName = SphericalPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeSpherical(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code unitSpherical}, which is the property specified as a unit spherical value {@code [Clock, Cone]}. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param value The value.
    */
    public final void writeUnitSpherical(@Nonnull UnitSpherical value) {
        final String PropertyName = UnitSphericalPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitSpherical(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code unitSpherical}, which is the property specified as a unit spherical value {@code [Clock, Cone]}. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values) {
        writeUnitSpherical(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code unitSpherical}, which is the property specified as a unit spherical value {@code [Clock, Cone]}. The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis. The cone angle is the angle from the positive Z axis toward the negative Z axis.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeUnitSpherical(List<JulianDate> dates, List<UnitSpherical> values, int startIndex, int length) {
        final String PropertyName = UnitSphericalPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeUnitSpherical(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code rgba}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    * @param color The color.
    */
    public final void writeRgba(@Nonnull Color color) {
        final String PropertyName = RgbaPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeRgba(getOutput(), color);
    }

    /**
    * Writes the value expressed as a {@code rgba}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    * @param red The red component in the range 0 to 255.
    * @param green The green component in the range 0 to 255.
    * @param blue The blue component in the range 0 to 255.
    * @param alpha The alpha component in the range 0 to 255.
    */
    public final void writeRgba(int red, int green, int blue, int alpha) {
        final String PropertyName = RgbaPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeRgba(getOutput(), red, green, blue, alpha);
    }

    /**
    * Writes the value expressed as a {@code rgba}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRgba(List<JulianDate> dates, List<Color> values) {
        writeRgba(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code rgba}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is an integer in the range 0-255.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRgba(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        final String PropertyName = RgbaPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeRgba(getOutput(), PropertyName, dates, colors, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code rgbaf}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    * @param color The color.
    */
    public final void writeRgbaf(@Nonnull Color color) {
        final String PropertyName = RgbafPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeRgbaf(getOutput(), color);
    }

    /**
    * Writes the value expressed as a {@code rgbaf}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    * @param red The red component in the range 0 to 1.0.
    * @param green The green component in the range 0 to 1.0.
    * @param blue The blue component in the range 0 to 1.0.
    * @param alpha The alpha component in the range 0 to 1.0.
    */
    public final void writeRgbaf(float red, float green, float blue, float alpha) {
        final String PropertyName = RgbafPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeRgbaf(getOutput(), red, green, blue, alpha);
    }

    /**
    * Writes the value expressed as a {@code rgbaf}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeRgbaf(List<JulianDate> dates, List<Color> values) {
        writeRgbaf(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code rgbaf}, which is the property specified as an array of color components {@code [Red, Green, Blue, Alpha]} where each component is a double in the range 0.0-1.0.
    * @param dates The dates at which the value is specified.
    * @param colors The color corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeRgbaf(List<JulianDate> dates, List<Color> colors, int startIndex, int length) {
        final String PropertyName = RgbafPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeRgbaf(getOutput(), PropertyName, dates, colors, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code colorBlendMode}, which is the property specified as a color blend mode.
    * @param value The blend mode.
    */
    public final void writeColorBlendMode(@Nonnull CesiumColorBlendMode value) {
        final String PropertyName = ColorBlendModePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.colorBlendModeToString(value));
    }

    /**
    * Writes the value expressed as a {@code cornerType}, which is the property specified as a corner style.
    * @param value The style of a corner.
    */
    public final void writeCornerType(@Nonnull CesiumCornerType value) {
        final String PropertyName = CornerTypePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.cornerTypeToString(value));
    }

    /**
    * Writes the value expressed as a {@code heightReference}, which is the property specified as a height reference.
    * @param value The height reference.
    */
    public final void writeHeightReference(@Nonnull CesiumHeightReference value) {
        final String PropertyName = HeightReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.heightReferenceToString(value));
    }

    /**
    * Writes the value expressed as a {@code horizontalOrigin}, which is the property specified as a horizontal origin.
    * @param value The horizontal origin.
    */
    public final void writeHorizontalOrigin(@Nonnull CesiumHorizontalOrigin value) {
        final String PropertyName = HorizontalOriginPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.horizontalOriginToString(value));
    }

    /**
    * Writes the value expressed as a {@code labelStyle}, which is the property specified as a label style.
    * @param value The label style.
    */
    public final void writeLabelStyle(@Nonnull CesiumLabelStyle value) {
        final String PropertyName = LabelStylePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.labelStyleToString(value));
    }

    /**
    * Writes the value expressed as a {@code number}, which is the property specified as a number.
    * @param value The value.
    */
    public final void writeNumber(double value) {
        final String PropertyName = NumberPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    * Writes the value expressed as a {@code number}, which is the property specified as a number.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeNumber(List<JulianDate> dates, List<Double> values) {
        writeNumber(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code number}, which is the property specified as a number.
    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeNumber(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        final String PropertyName = NumberPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeDouble(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code nearFarScalar}, which is the property specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}.
    * @param value The value.
    */
    public final void writeNearFarScalar(@Nonnull NearFarScalar value) {
        final String PropertyName = NearFarScalarPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeNearFarScalar(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code nearFarScalar}, which is the property specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}.
    * @param nearDistance The lower bound of the camera distance range.
    * @param nearValue The value to use at the lower bound of the camera distance range.
    * @param farDistance The upper bound of the camera distance range.
    * @param farValue The value to use at the upper bound of the camera distance range.
    */
    public final void writeNearFarScalar(double nearDistance, double nearValue, double farDistance, double farValue) {
        writeNearFarScalar(new NearFarScalar(nearDistance, nearValue, farDistance, farValue));
    }

    /**
    * Writes the value expressed as a {@code nearFarScalar}, which is the property specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeNearFarScalar(List<JulianDate> dates, List<NearFarScalar> values) {
        writeNearFarScalar(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code nearFarScalar}, which is the property specified as four values {@code [NearDistance, NearValue, FarDistance, FarValue]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeNearFarScalar(List<JulianDate> dates, List<NearFarScalar> values, int startIndex, int length) {
        final String PropertyName = NearFarScalarPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeNearFarScalar(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code unitQuaternion}, which is the property specified as a 4-dimensional unit magnitude quaternion, specified as {@code [X, Y, Z, W]}.
    * @param value The value.
    */
    public final void writeUnitQuaternion(@Nonnull UnitQuaternion value) {
        final String PropertyName = UnitQuaternionPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeUnitQuaternion(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code unitQuaternion}, which is the property specified as a 4-dimensional unit magnitude quaternion, specified as {@code [X, Y, Z, W]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeUnitQuaternion(List<JulianDate> dates, List<UnitQuaternion> values) {
        writeUnitQuaternion(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code unitQuaternion}, which is the property specified as a 4-dimensional unit magnitude quaternion, specified as {@code [X, Y, Z, W]}.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeUnitQuaternion(List<JulianDate> dates, List<UnitQuaternion> values, int startIndex, int length) {
        final String PropertyName = UnitQuaternionPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeUnitQuaternion(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code shadowMode}, which is the property specified as a shadow mode.
    * @param value The shadow mode.
    */
    public final void writeShadowMode(@Nonnull CesiumShadowMode value) {
        final String PropertyName = ShadowModePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.shadowModeToString(value));
    }

    /**
    * Writes the value expressed as a {@code string}, which is the property specified as a string.
    * @param value The value.
    */
    public final void writeString(String value) {
        final String PropertyName = StringPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    * Writes the value expressed as a {@code stripeOrientation}, which is the property specified as an orientation of stripes in the stripe material.
    * @param value The orientation.
    */
    public final void writeStripeOrientation(@Nonnull CesiumStripeOrientation value) {
        final String PropertyName = StripeOrientationPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.stripeOrientationToString(value));
    }

    /**
    * Writes the value expressed as a {@code wsen}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    * @param value The value.
    */
    public final void writeWsen(CartographicExtent value) {
        final String PropertyName = WsenPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographicExtent(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code wsen}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    * @param west The westernmost longitude.
    * @param south The southernmost latitude.
    * @param east The easternmost longitude.
    * @param north The northernmost latitude.
    */
    public final void writeWsen(double west, double south, double east, double north) {
        writeWsen(new CartographicExtent(west, south, east, north));
    }

    /**
    * Writes the value expressed as a {@code wsen}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeWsen(List<JulianDate> dates, List<CartographicExtent> values) {
        writeWsen(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code wsen}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeWsen(List<JulianDate> dates, List<CartographicExtent> values, int startIndex, int length) {
        final String PropertyName = WsenPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartographicExtent(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code wsenDegrees}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    * @param value The value.
    */
    public final void writeWsenDegrees(CartographicExtent value) {
        final String PropertyName = WsenDegreesPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographicExtent(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code wsenDegrees}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    * @param west The westernmost longitude.
    * @param south The southernmost latitude.
    * @param east The easternmost longitude.
    * @param north The northernmost latitude.
    */
    public final void writeWsenDegrees(double west, double south, double east, double north) {
        writeWsenDegrees(new CartographicExtent(west, south, east, north));
    }

    /**
    * Writes the value expressed as a {@code wsenDegrees}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeWsenDegrees(List<JulianDate> dates, List<CartographicExtent> values) {
        writeWsenDegrees(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code wsenDegrees}, which is the property specified as a Cartographic rectangle {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeWsenDegrees(List<JulianDate> dates, List<CartographicExtent> values, int startIndex, int length) {
        final String PropertyName = WsenDegreesPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeCartographicExtent(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    * Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    * @param resource A resource object describing external data.
    */
    public final void writeUri(CesiumResource resource) {
        writeUri(resource.getUri(), resource.getBehavior());
    }

    /**
    * Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeUri(URI uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        writeUri(uri.toString(), resourceBehavior);
    }

    /**
    * Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    * @param uri The URI of the data.
    * @param resourceBehavior An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.
    */
    public final void writeUri(String uri, @Nonnull CesiumResourceBehavior resourceBehavior) {
        final String PropertyName = UriPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.getResourceUri(uri, resourceBehavior));
    }

    /**
    * Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeUri(URI uri, ICesiumUriResolver resolver) {
        writeUri(uri.toString(), resolver);
    }

    /**
    * Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    * @param uri The URI of the data. The provided ICesiumUriResolver will be used to build the final URI embedded in the document.
    * @param resolver An ICesiumUriResolver used to build the final URI that will be embedded in the document.
    */
    public final void writeUri(String uri, ICesiumUriResolver resolver) {
        final String PropertyName = UriPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(resolver.resolveUri(uri));
    }

    /**
    * Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    * @param image The image. A data URI will be created for this image, using PNG encoding.
    */
    public final void writeUri(RenderedImage image) {
        writeUri(image, CesiumImageFormat.PNG);
    }

    /**
    * Writes the value expressed as a {@code uri}, which is the property specified as a URI.
    * @param image The image. A data URI will be created for this image.
    * @param imageFormat The image format to use to encode the image in the data URI.
    */
    public final void writeUri(RenderedImage image, @Nonnull CesiumImageFormat imageFormat) {
        final String PropertyName = UriPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.imageToDataUri(image, imageFormat));
    }

    /**
    * Writes the value expressed as a {@code verticalOrigin}, which is the property specified as a vertical origin.
    * @param value The vertical origin.
    */
    public final void writeVerticalOrigin(@Nonnull CesiumVerticalOrigin value) {
        final String PropertyName = VerticalOriginPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(CesiumFormattingHelper.verticalOriginToString(value));
    }

    /**
    * Writes the value expressed as a {@code delete}, which is whether the client should delete existing samples or interval data for this property. Data will be deleted for the containing interval, or if there is no containing interval, then all data. If true, all other properties in this property will be ignored.
    * @param value The value.
    */
    public final void writeDelete(boolean value) {
        final String PropertyName = DeletePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        getOutput().writeValue(value);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumBooleanValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumBooleanValuePropertyAdaptor<CustomPropertyCesiumWriter> asBoolean() {
        return m_asBoolean.getValue();
    }

    @Nonnull
    private final Lazy<CesiumBooleanValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsBoolean() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumBooleanValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumBooleanValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createBoolean") {
                    public cesiumlanguagewriter.advanced.CesiumBooleanValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createBoolean();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumBooleanValuePropertyAdaptor<CustomPropertyCesiumWriter> createBoolean() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createBoolean(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumBoundingRectangleValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumBoundingRectangleValuePropertyAdaptor<CustomPropertyCesiumWriter> asBoundingRectangle() {
        return m_asBoundingRectangle.getValue();
    }

    @Nonnull
    private final Lazy<CesiumBoundingRectangleValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsBoundingRectangle() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumBoundingRectangleValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumBoundingRectangleValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createBoundingRectangle") {
                    public cesiumlanguagewriter.advanced.CesiumBoundingRectangleValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createBoundingRectangle();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumBoundingRectangleValuePropertyAdaptor<CustomPropertyCesiumWriter> createBoundingRectangle() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createBoundingRectangle(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartesian3ValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter> asCartesian() {
        return m_asCartesian.getValue();
    }

    @Nonnull
    private final Lazy<CesiumCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsCartesian() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createCartesian3") {
                    public cesiumlanguagewriter.advanced.CesiumCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createCartesian3();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter> createCartesian3() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createCartesian3(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartographicRadiansValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumCartographicRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter> asCartographicRadians() {
        return m_asCartographicRadians.getValue();
    }

    @Nonnull
    private final Lazy<CesiumCartographicRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsCartographicRadians() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartographicRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartographicRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createCartographicRadians") {
                    public cesiumlanguagewriter.advanced.CesiumCartographicRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createCartographicRadians();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumCartographicRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter> createCartographicRadians() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createCartographicRadians(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartographicDegreesValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumCartographicDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter> asCartographicDegrees() {
        return m_asCartographicDegrees.getValue();
    }

    @Nonnull
    private final Lazy<CesiumCartographicDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsCartographicDegrees() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartographicDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartographicDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createCartographicDegrees") {
                    public cesiumlanguagewriter.advanced.CesiumCartographicDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createCartographicDegrees();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumCartographicDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter> createCartographicDegrees() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createCartographicDegrees(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartesian2ValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumCartesian2ValuePropertyAdaptor<CustomPropertyCesiumWriter> asCartesian2() {
        return m_asCartesian2.getValue();
    }

    @Nonnull
    private final Lazy<CesiumCartesian2ValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsCartesian2() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartesian2ValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartesian2ValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createCartesian2") {
                    public cesiumlanguagewriter.advanced.CesiumCartesian2ValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createCartesian2();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumCartesian2ValuePropertyAdaptor<CustomPropertyCesiumWriter> createCartesian2() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createCartesian2(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumUnitCartesian3ValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumUnitCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter> asUnitCartesian() {
        return m_asUnitCartesian.getValue();
    }

    @Nonnull
    private final Lazy<CesiumUnitCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsUnitCartesian() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumUnitCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumUnitCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createUnitCartesian3") {
                    public cesiumlanguagewriter.advanced.CesiumUnitCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createUnitCartesian3();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumUnitCartesian3ValuePropertyAdaptor<CustomPropertyCesiumWriter> createUnitCartesian3() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createUnitCartesian3(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumSphericalValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter> asSpherical() {
        return m_asSpherical.getValue();
    }

    @Nonnull
    private final Lazy<CesiumSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsSpherical() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createSpherical") {
                    public cesiumlanguagewriter.advanced.CesiumSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createSpherical();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter> createSpherical() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createSpherical(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumUnitSphericalValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumUnitSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter> asUnitSpherical() {
        return m_asUnitSpherical.getValue();
    }

    @Nonnull
    private final Lazy<CesiumUnitSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsUnitSpherical() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumUnitSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumUnitSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createUnitSpherical") {
                    public cesiumlanguagewriter.advanced.CesiumUnitSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createUnitSpherical();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumUnitSphericalValuePropertyAdaptor<CustomPropertyCesiumWriter> createUnitSpherical() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createUnitSpherical(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumRgbaValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumRgbaValuePropertyAdaptor<CustomPropertyCesiumWriter> asRgba() {
        return m_asRgba.getValue();
    }

    @Nonnull
    private final Lazy<CesiumRgbaValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsRgba() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumRgbaValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumRgbaValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createRgba") {
                    public cesiumlanguagewriter.advanced.CesiumRgbaValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createRgba();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumRgbaValuePropertyAdaptor<CustomPropertyCesiumWriter> createRgba() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createRgba(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumRgbafValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumRgbafValuePropertyAdaptor<CustomPropertyCesiumWriter> asRgbaf() {
        return m_asRgbaf.getValue();
    }

    @Nonnull
    private final Lazy<CesiumRgbafValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsRgbaf() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumRgbafValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumRgbafValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createRgbaf") {
                    public cesiumlanguagewriter.advanced.CesiumRgbafValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createRgbaf();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumRgbafValuePropertyAdaptor<CustomPropertyCesiumWriter> createRgbaf() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createRgbaf(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumColorBlendModeValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumColorBlendModeValuePropertyAdaptor<CustomPropertyCesiumWriter> asColorBlendMode() {
        return m_asColorBlendMode.getValue();
    }

    @Nonnull
    private final Lazy<CesiumColorBlendModeValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsColorBlendMode() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumColorBlendModeValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumColorBlendModeValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createColorBlendMode") {
                    public cesiumlanguagewriter.advanced.CesiumColorBlendModeValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createColorBlendMode();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumColorBlendModeValuePropertyAdaptor<CustomPropertyCesiumWriter> createColorBlendMode() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createColorBlendMode(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCornerTypeValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumCornerTypeValuePropertyAdaptor<CustomPropertyCesiumWriter> asCornerType() {
        return m_asCornerType.getValue();
    }

    @Nonnull
    private final Lazy<CesiumCornerTypeValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsCornerType() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCornerTypeValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCornerTypeValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createCornerType") {
                    public cesiumlanguagewriter.advanced.CesiumCornerTypeValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createCornerType();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumCornerTypeValuePropertyAdaptor<CustomPropertyCesiumWriter> createCornerType() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createCornerType(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumHeightReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumHeightReferenceValuePropertyAdaptor<CustomPropertyCesiumWriter> asHeightReference() {
        return m_asHeightReference.getValue();
    }

    @Nonnull
    private final Lazy<CesiumHeightReferenceValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsHeightReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumHeightReferenceValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumHeightReferenceValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createHeightReference") {
                    public cesiumlanguagewriter.advanced.CesiumHeightReferenceValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createHeightReference();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumHeightReferenceValuePropertyAdaptor<CustomPropertyCesiumWriter> createHeightReference() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createHeightReference(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumHorizontalOriginValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumHorizontalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter> asHorizontalOrigin() {
        return m_asHorizontalOrigin.getValue();
    }

    @Nonnull
    private final Lazy<CesiumHorizontalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsHorizontalOrigin() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumHorizontalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumHorizontalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createHorizontalOrigin") {
                    public cesiumlanguagewriter.advanced.CesiumHorizontalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createHorizontalOrigin();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumHorizontalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter> createHorizontalOrigin() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createHorizontalOrigin(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumLabelStyleValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumLabelStyleValuePropertyAdaptor<CustomPropertyCesiumWriter> asLabelStyle() {
        return m_asLabelStyle.getValue();
    }

    @Nonnull
    private final Lazy<CesiumLabelStyleValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsLabelStyle() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumLabelStyleValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumLabelStyleValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createLabelStyle") {
                    public cesiumlanguagewriter.advanced.CesiumLabelStyleValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createLabelStyle();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumLabelStyleValuePropertyAdaptor<CustomPropertyCesiumWriter> createLabelStyle() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createLabelStyle(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumDoubleValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumDoubleValuePropertyAdaptor<CustomPropertyCesiumWriter> asNumber() {
        return m_asNumber.getValue();
    }

    @Nonnull
    private final Lazy<CesiumDoubleValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsNumber() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumDoubleValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumDoubleValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createDouble") {
                    public cesiumlanguagewriter.advanced.CesiumDoubleValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createDouble();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumDoubleValuePropertyAdaptor<CustomPropertyCesiumWriter> createDouble() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createDouble(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumNearFarScalarValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumNearFarScalarValuePropertyAdaptor<CustomPropertyCesiumWriter> asNearFarScalar() {
        return m_asNearFarScalar.getValue();
    }

    @Nonnull
    private final Lazy<CesiumNearFarScalarValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsNearFarScalar() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumNearFarScalarValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumNearFarScalarValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createNearFarScalar") {
                    public cesiumlanguagewriter.advanced.CesiumNearFarScalarValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createNearFarScalar();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumNearFarScalarValuePropertyAdaptor<CustomPropertyCesiumWriter> createNearFarScalar() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createNearFarScalar(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumUnitQuaternionValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumUnitQuaternionValuePropertyAdaptor<CustomPropertyCesiumWriter> asUnitQuaternion() {
        return m_asUnitQuaternion.getValue();
    }

    @Nonnull
    private final Lazy<CesiumUnitQuaternionValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsUnitQuaternion() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumUnitQuaternionValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumUnitQuaternionValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createUnitQuaternion") {
                    public cesiumlanguagewriter.advanced.CesiumUnitQuaternionValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createUnitQuaternion();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumUnitQuaternionValuePropertyAdaptor<CustomPropertyCesiumWriter> createUnitQuaternion() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createUnitQuaternion(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumShadowModeValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumShadowModeValuePropertyAdaptor<CustomPropertyCesiumWriter> asShadowMode() {
        return m_asShadowMode.getValue();
    }

    @Nonnull
    private final Lazy<CesiumShadowModeValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsShadowMode() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumShadowModeValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumShadowModeValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createShadowMode") {
                    public cesiumlanguagewriter.advanced.CesiumShadowModeValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createShadowMode();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumShadowModeValuePropertyAdaptor<CustomPropertyCesiumWriter> createShadowMode() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createShadowMode(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumStringValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumStringValuePropertyAdaptor<CustomPropertyCesiumWriter> asString() {
        return m_asString.getValue();
    }

    @Nonnull
    private final Lazy<CesiumStringValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsString() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumStringValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumStringValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createString") {
                    public cesiumlanguagewriter.advanced.CesiumStringValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createString();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumStringValuePropertyAdaptor<CustomPropertyCesiumWriter> createString() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createString(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumStripeOrientationValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumStripeOrientationValuePropertyAdaptor<CustomPropertyCesiumWriter> asStripeOrientation() {
        return m_asStripeOrientation.getValue();
    }

    @Nonnull
    private final Lazy<CesiumStripeOrientationValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsStripeOrientation() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumStripeOrientationValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumStripeOrientationValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createStripeOrientation") {
                    public cesiumlanguagewriter.advanced.CesiumStripeOrientationValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createStripeOrientation();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumStripeOrientationValuePropertyAdaptor<CustomPropertyCesiumWriter> createStripeOrientation() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createStripeOrientation(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartographicRectangleRadiansValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumCartographicRectangleRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter> asWsen() {
        return m_asWsen.getValue();
    }

    @Nonnull
    private final Lazy<CesiumCartographicRectangleRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsWsen() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartographicRectangleRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartographicRectangleRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createCartographicRectangleRadians") {
                    public cesiumlanguagewriter.advanced.CesiumCartographicRectangleRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createCartographicRectangleRadians();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumCartographicRectangleRadiansValuePropertyAdaptor<CustomPropertyCesiumWriter> createCartographicRectangleRadians() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createCartographicRectangleRadians(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartographicRectangleDegreesValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumCartographicRectangleDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter> asWsenDegrees() {
        return m_asWsenDegrees.getValue();
    }

    @Nonnull
    private final Lazy<CesiumCartographicRectangleDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsWsenDegrees() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartographicRectangleDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartographicRectangleDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createCartographicRectangleDegrees") {
                    public cesiumlanguagewriter.advanced.CesiumCartographicRectangleDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createCartographicRectangleDegrees();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumCartographicRectangleDegreesValuePropertyAdaptor<CustomPropertyCesiumWriter> createCartographicRectangleDegrees() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createCartographicRectangleDegrees(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumUriValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumUriValuePropertyAdaptor<CustomPropertyCesiumWriter> asUri() {
        return m_asUri.getValue();
    }

    @Nonnull
    private final Lazy<CesiumUriValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsUri() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumUriValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumUriValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createUri") {
                    public cesiumlanguagewriter.advanced.CesiumUriValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createUri();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumUriValuePropertyAdaptor<CustomPropertyCesiumWriter> createUri() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createUri(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumVerticalOriginValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    @Nonnull
    public final CesiumVerticalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter> asVerticalOrigin() {
        return m_asVerticalOrigin.getValue();
    }

    @Nonnull
    private final Lazy<CesiumVerticalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter>> createAsVerticalOrigin() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumVerticalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumVerticalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter>>(this, "createVerticalOrigin") {
                    public cesiumlanguagewriter.advanced.CesiumVerticalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter> invoke() {
                        return createVerticalOrigin();
                    }
                }, false);
    }

    @Nonnull
    private final CesiumVerticalOriginValuePropertyAdaptor<CustomPropertyCesiumWriter> createVerticalOrigin() {
        return CesiumValuePropertyAdaptors.<CustomPropertyCesiumWriter> createVerticalOrigin(this);
    }
}