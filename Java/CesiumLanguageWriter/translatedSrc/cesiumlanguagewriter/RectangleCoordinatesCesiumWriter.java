package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Writes a {@code RectangleCoordinates} to a {@link CesiumOutputStream}. A {@code RectangleCoordinates} is a set of coordinates describing a cartographic rectangle on the surface of the ellipsoid.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public class RectangleCoordinatesCesiumWriter extends CesiumInterpolatablePropertyWriter<RectangleCoordinatesCesiumWriter> implements ICesiumDeletablePropertyWriter,
        ICesiumCartographicRectangleRadiansValuePropertyWriter, ICesiumCartographicRectangleDegreesValuePropertyWriter, ICesiumReferenceValuePropertyWriter {
    /**
    * The name of the {@code wsen} property.
    */
    public static final String WsenPropertyName = "wsen";
    /**
    * The name of the {@code wsenDegrees} property.
    */
    public static final String WsenDegreesPropertyName = "wsenDegrees";
    /**
    * The name of the {@code reference} property.
    */
    public static final String ReferencePropertyName = "reference";
    /**
    * The name of the {@code delete} property.
    */
    public static final String DeletePropertyName = "delete";
    private Lazy<CesiumCartographicRectangleRadiansValuePropertyAdaptor<RectangleCoordinatesCesiumWriter>> m_asWsen;
    private Lazy<CesiumCartographicRectangleDegreesValuePropertyAdaptor<RectangleCoordinatesCesiumWriter>> m_asWsenDegrees;
    private Lazy<CesiumReferenceValuePropertyAdaptor<RectangleCoordinatesCesiumWriter>> m_asReference;

    /**
    * Initializes a new instance.
    * @param propertyName The name of the property.
    */
    public RectangleCoordinatesCesiumWriter(@Nonnull String propertyName) {
        super(propertyName);
        m_asWsen = createAsWsen();
        m_asWsenDegrees = createAsWsenDegrees();
        m_asReference = createAsReference();
    }

    /**
    * Initializes a new instance as a copy of an existing instance.
    * @param existingInstance The existing instance to copy.
    */
    protected RectangleCoordinatesCesiumWriter(@Nonnull RectangleCoordinatesCesiumWriter existingInstance) {
        super(existingInstance);
        m_asWsen = createAsWsen();
        m_asWsenDegrees = createAsWsenDegrees();
        m_asReference = createAsReference();
    }

    /**
    * Copies this instance and returns the copy.
    * @return The copy.
    */
    @Override
    public RectangleCoordinatesCesiumWriter clone() {
        return new RectangleCoordinatesCesiumWriter(this);
    }

    /**
    * Writes the value expressed as a {@code wsen}, which is the set of coordinates specified as Cartographic values {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    * @param value The value.
    */
    public final void writeWsen(CartographicExtent value) {
        final String PropertyName = WsenPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographicExtent(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code wsen}, which is the set of coordinates specified as Cartographic values {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    * @param west The westernmost longitude.
    * @param south The southernmost latitude.
    * @param east The easternmost longitude.
    * @param north The northernmost latitude.
    */
    public final void writeWsen(double west, double south, double east, double north) {
        writeWsen(new CartographicExtent(west, south, east, north));
    }

    /**
    * Writes the value expressed as a {@code wsen}, which is the set of coordinates specified as Cartographic values {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeWsen(List<JulianDate> dates, List<CartographicExtent> values) {
        writeWsen(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code wsen}, which is the set of coordinates specified as Cartographic values {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in radians.
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
    * Writes the value expressed as a {@code wsenDegrees}, which is the set of coordinates specified as Cartographic values {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    * @param value The value.
    */
    public final void writeWsenDegrees(CartographicExtent value) {
        final String PropertyName = WsenDegreesPropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeCartographicExtent(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code wsenDegrees}, which is the set of coordinates specified as Cartographic values {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    * @param west The westernmost longitude.
    * @param south The southernmost latitude.
    * @param east The easternmost longitude.
    * @param north The northernmost latitude.
    */
    public final void writeWsenDegrees(double west, double south, double east, double north) {
        writeWsenDegrees(new CartographicExtent(west, south, east, north));
    }

    /**
    * Writes the value expressed as a {@code wsenDegrees}, which is the set of coordinates specified as Cartographic values {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeWsenDegrees(List<JulianDate> dates, List<CartographicExtent> values) {
        writeWsenDegrees(dates, values, 0, dates.size());
    }

    /**
    * Writes the value expressed as a {@code wsenDegrees}, which is the set of coordinates specified as Cartographic values {@code [WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]}, with values in degrees.
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
    * Writes the value expressed as a {@code reference}, which is the set of coordinates specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the set of coordinates specified as a reference to another property.
    * @param value The reference.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the set of coordinates specified as a reference to another property.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeReference(String identifier, String propertyName) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), identifier, propertyName);
    }

    /**
    * Writes the value expressed as a {@code reference}, which is the set of coordinates specified as a reference to another property.
    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeReference(String identifier, String[] propertyNames) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), identifier, propertyNames);
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
    * Returns a wrapper for this instance that implements {@link ICesiumCartographicRectangleRadiansValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumCartographicRectangleRadiansValuePropertyAdaptor<RectangleCoordinatesCesiumWriter> asWsen() {
        return m_asWsen.getValue();
    }

    private final Lazy<CesiumCartographicRectangleRadiansValuePropertyAdaptor<RectangleCoordinatesCesiumWriter>> createAsWsen() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartographicRectangleRadiansValuePropertyAdaptor<RectangleCoordinatesCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartographicRectangleRadiansValuePropertyAdaptor<RectangleCoordinatesCesiumWriter>>(this, "createCartographicRectangleRadians") {
                    public cesiumlanguagewriter.advanced.CesiumCartographicRectangleRadiansValuePropertyAdaptor<RectangleCoordinatesCesiumWriter> invoke() {
                        return createCartographicRectangleRadians();
                    }
                }, false);
    }

    private final CesiumCartographicRectangleRadiansValuePropertyAdaptor<RectangleCoordinatesCesiumWriter> createCartographicRectangleRadians() {
        return CesiumValuePropertyAdaptors.<RectangleCoordinatesCesiumWriter> createCartographicRectangleRadians(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumCartographicRectangleDegreesValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumCartographicRectangleDegreesValuePropertyAdaptor<RectangleCoordinatesCesiumWriter> asWsenDegrees() {
        return m_asWsenDegrees.getValue();
    }

    private final Lazy<CesiumCartographicRectangleDegreesValuePropertyAdaptor<RectangleCoordinatesCesiumWriter>> createAsWsenDegrees() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumCartographicRectangleDegreesValuePropertyAdaptor<RectangleCoordinatesCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumCartographicRectangleDegreesValuePropertyAdaptor<RectangleCoordinatesCesiumWriter>>(this, "createCartographicRectangleDegrees") {
                    public cesiumlanguagewriter.advanced.CesiumCartographicRectangleDegreesValuePropertyAdaptor<RectangleCoordinatesCesiumWriter> invoke() {
                        return createCartographicRectangleDegrees();
                    }
                }, false);
    }

    private final CesiumCartographicRectangleDegreesValuePropertyAdaptor<RectangleCoordinatesCesiumWriter> createCartographicRectangleDegrees() {
        return CesiumValuePropertyAdaptors.<RectangleCoordinatesCesiumWriter> createCartographicRectangleDegrees(this);
    }

    /**
    * Returns a wrapper for this instance that implements {@link ICesiumReferenceValuePropertyWriter}. Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    * @return The wrapper.
    */
    public final CesiumReferenceValuePropertyAdaptor<RectangleCoordinatesCesiumWriter> asReference() {
        return m_asReference.getValue();
    }

    private final Lazy<CesiumReferenceValuePropertyAdaptor<RectangleCoordinatesCesiumWriter>> createAsReference() {
        return new Lazy<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<RectangleCoordinatesCesiumWriter>>(
                new Func1<cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<RectangleCoordinatesCesiumWriter>>(this, "createReference") {
                    public cesiumlanguagewriter.advanced.CesiumReferenceValuePropertyAdaptor<RectangleCoordinatesCesiumWriter> invoke() {
                        return createReference();
                    }
                }, false);
    }

    private final CesiumReferenceValuePropertyAdaptor<RectangleCoordinatesCesiumWriter> createReference() {
        return CesiumValuePropertyAdaptors.<RectangleCoordinatesCesiumWriter> createReference(this);
    }
}