package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.CesiumWriterAdaptorWriteCallback;
import cesiumlanguagewriter.advanced.CesiumWriterAdaptorWriteDeleteCallback;
import cesiumlanguagewriter.advanced.CesiumWriterAdaptorWriteSamplesCallback;
import java.awt.Color;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Creation methods for {@link CesiumWriterAdaptor} objects.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public final class CesiumValuePropertyAdaptors {
    private CesiumValuePropertyAdaptors() {}

    @Nonnull
    private static <TFrom extends ICesiumDeletablePropertyWriter> CesiumWriterAdaptorWriteDeleteCallback<TFrom> createWriteDeleteCallback() {
        return CesiumWriterAdaptorWriteDeleteCallback.<TFrom> of((TFrom writer) -> {
            writer.writeDelete(true);
        });
    }

    /**
    * Create an adaptor for {@link CesiumArcType} values.
    * @param <TFrom> The class that implements {@link ICesiumArcTypeValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumArcTypeValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumArcTypeValuePropertyAdaptor<TFrom> createArcType(@Nonnull TFrom parent) {
        return new CesiumArcTypeValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, CesiumArcType> of((TFrom writer, @Nonnull CesiumArcType value) -> {
            writer.writeArcType(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@code boolean} values.
    * @param <TFrom> The class that implements {@link ICesiumBooleanValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumBooleanValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumBooleanValuePropertyAdaptor<TFrom> createBoolean(@Nonnull TFrom parent) {
        return new CesiumBooleanValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Boolean> of((TFrom writer, Boolean value) -> {
            writer.writeBoolean(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link BoundingRectangle} values.
    * @param <TFrom> The class that implements {@link ICesiumBoundingRectangleValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumBoundingRectangleValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumBoundingRectangleValuePropertyAdaptor<TFrom> createBoundingRectangle(
            @Nonnull TFrom parent) {
        return new CesiumBoundingRectangleValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, BoundingRectangle> of((TFrom writer, BoundingRectangle value) -> {
            writer.writeBoundingRectangle(value);
        }), CesiumWriterAdaptorWriteSamplesCallback
                .<TFrom, BoundingRectangle> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.BoundingRectangle> values, int startIndex, int length) -> {
                    writer.writeBoundingRectangle(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Rectangular} values.
    * @param <TFrom> The class that implements {@link ICesiumCartesian2ValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartesian2ValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartesian2ValuePropertyAdaptor<TFrom> createCartesian2(@Nonnull TFrom parent) {
        return new CesiumCartesian2ValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Rectangular> of((TFrom writer, Rectangular value) -> {
            writer.writeCartesian2(value);
        }), CesiumWriterAdaptorWriteSamplesCallback
                .<TFrom, Rectangular> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Rectangular> values, int startIndex, int length) -> {
                    writer.writeCartesian2(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Cartesian} values.
    * @param <TFrom> The class that implements {@link ICesiumCartesian3ValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartesian3ValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartesian3ValuePropertyAdaptor<TFrom> createCartesian3(@Nonnull TFrom parent) {
        return new CesiumCartesian3ValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Cartesian> of((TFrom writer, Cartesian value) -> {
            writer.writeCartesian(value);
        }), CesiumWriterAdaptorWriteSamplesCallback
                .<TFrom, Cartesian> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Cartesian> values, int startIndex, int length) -> {
                    writer.writeCartesian(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Motion1} values.
    * @param <TFrom> The class that implements {@link ICesiumCartesian3VelocityValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartesian3VelocityValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartesian3VelocityValuePropertyAdaptor<TFrom> createCartesian3Velocity(
            @Nonnull TFrom parent) {
        return new CesiumCartesian3VelocityValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Motion1<Cartesian>> of((TFrom writer, Motion1<Cartesian> value) -> {
            writer.writeCartesianVelocity(value);
        }), CesiumWriterAdaptorWriteSamplesCallback.<TFrom, Motion1<Cartesian>> of(
                (TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Motion1<cesiumlanguagewriter.Cartesian>> values, int startIndex, int length) -> {
                    writer.writeCartesianVelocity(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of {@link Rectangular} values.
    * @param <TFrom> The class that implements {@link ICesiumCartesian3ListValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartesian2ListValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartesian2ListValuePropertyAdaptor<TFrom> createCartesian2List(
            @Nonnull TFrom parent) {
        return new CesiumCartesian2ListValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, Iterable<Rectangular>> of((TFrom writer, Iterable<cesiumlanguagewriter.Rectangular> value) -> {
                    writer.writeCartesian2(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of {@link Cartesian} values.
    * @param <TFrom> The class that implements {@link ICesiumCartesian3ListValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartesian3ListValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartesian3ListValuePropertyAdaptor<TFrom> createCartesian3List(
            @Nonnull TFrom parent) {
        return new CesiumCartesian3ListValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, Iterable<Cartesian>> of((TFrom writer, Iterable<cesiumlanguagewriter.Cartesian> value) -> {
                    writer.writeCartesian(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of lists of {@link Cartesian} values.
    * @param <TFrom> The class that implements {@link ICesiumCartesian3ListOfListsValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    public static <TFrom extends ICesiumCartesian3ListOfListsValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartesian3ListOfListsValuePropertyAdaptor<TFrom> createCartesian3ListOfLists(
            @Nonnull TFrom parent) {
        return new CesiumCartesian3ListOfListsValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, Iterable<? extends Iterable<Cartesian>>> of((TFrom writer, Iterable<? extends Iterable<cesiumlanguagewriter.Cartesian>> value) -> {
                    writer.writeCartesian(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Cartographic} values.
    * @param <TFrom> The class that implements {@link ICesiumCartographicRadiansValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartographicRadiansValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartographicRadiansValuePropertyAdaptor<TFrom> createCartographicRadians(
            @Nonnull TFrom parent) {
        return new CesiumCartographicRadiansValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Cartographic> of((TFrom writer, Cartographic value) -> {
            writer.writeCartographicRadians(value);
        }), CesiumWriterAdaptorWriteSamplesCallback
                .<TFrom, Cartographic> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Cartographic> values, int startIndex, int length) -> {
                    writer.writeCartographicRadians(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of {@link Cartographic} values.
    * @param <TFrom> The class that implements {@link ICesiumCartographicRadiansListValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartographicRadiansListValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartographicRadiansListValuePropertyAdaptor<TFrom> createCartographicRadiansList(
            @Nonnull TFrom parent) {
        return new CesiumCartographicRadiansListValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, Iterable<Cartographic>> of((TFrom writer, Iterable<cesiumlanguagewriter.Cartographic> value) -> {
                    writer.writeCartographicRadians(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of lists of {@link Cartographic} values.
    * @param <TFrom> The class that implements {@link ICesiumCartographicRadiansListOfListsValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    public static <TFrom extends ICesiumCartographicRadiansListOfListsValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartographicRadiansListOfListsValuePropertyAdaptor<TFrom> createCartographicRadiansListOfLists(
            @Nonnull TFrom parent) {
        return new CesiumCartographicRadiansListOfListsValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, Iterable<? extends Iterable<Cartographic>>> of((TFrom writer, Iterable<? extends Iterable<cesiumlanguagewriter.Cartographic>> value) -> {
                    writer.writeCartographicRadians(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Cartographic} values.
    * @param <TFrom> The class that implements {@link ICesiumCartographicDegreesValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartographicDegreesValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartographicDegreesValuePropertyAdaptor<TFrom> createCartographicDegrees(
            @Nonnull TFrom parent) {
        return new CesiumCartographicDegreesValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Cartographic> of((TFrom writer, Cartographic value) -> {
            writer.writeCartographicDegrees(value);
        }), CesiumWriterAdaptorWriteSamplesCallback
                .<TFrom, Cartographic> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Cartographic> values, int startIndex, int length) -> {
                    writer.writeCartographicDegrees(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of {@link Cartographic} values.
    * @param <TFrom> The class that implements {@link ICesiumCartographicDegreesListValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartographicDegreesListValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartographicDegreesListValuePropertyAdaptor<TFrom> createCartographicDegreesList(
            @Nonnull TFrom parent) {
        return new CesiumCartographicDegreesListValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, Iterable<Cartographic>> of((TFrom writer, Iterable<cesiumlanguagewriter.Cartographic> value) -> {
                    writer.writeCartographicDegrees(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of lists of {@link Cartographic} values.
    * @param <TFrom> The class that implements {@link ICesiumCartographicDegreesListOfListsValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    public static <TFrom extends ICesiumCartographicDegreesListOfListsValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartographicDegreesListOfListsValuePropertyAdaptor<TFrom> createCartographicDegreesListOfLists(
            @Nonnull TFrom parent) {
        return new CesiumCartographicDegreesListOfListsValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, Iterable<? extends Iterable<Cartographic>>> of((TFrom writer, Iterable<? extends Iterable<cesiumlanguagewriter.Cartographic>> value) -> {
                    writer.writeCartographicDegrees(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CartographicExtent} values.
    * @param <TFrom> The class that implements {@link ICesiumCartographicRectangleRadiansValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartographicRectangleRadiansValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartographicRectangleRadiansValuePropertyAdaptor<TFrom> createCartographicRectangleRadians(
            @Nonnull TFrom parent) {
        return new CesiumCartographicRectangleRadiansValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, CartographicExtent> of((TFrom writer, CartographicExtent value) -> {
            writer.writeWsen(value);
        }), CesiumWriterAdaptorWriteSamplesCallback
                .<TFrom, CartographicExtent> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.CartographicExtent> values, int startIndex, int length) -> {
                    writer.writeWsen(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CartographicExtent} values.
    * @param <TFrom> The class that implements {@link ICesiumCartographicRectangleDegreesValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartographicRectangleDegreesValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartographicRectangleDegreesValuePropertyAdaptor<TFrom> createCartographicRectangleDegrees(
            @Nonnull TFrom parent) {
        return new CesiumCartographicRectangleDegreesValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, CartographicExtent> of((TFrom writer, CartographicExtent value) -> {
            writer.writeWsenDegrees(value);
        }), CesiumWriterAdaptorWriteSamplesCallback
                .<TFrom, CartographicExtent> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.CartographicExtent> values, int startIndex, int length) -> {
                    writer.writeWsenDegrees(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumClassificationType} values.
    * @param <TFrom> The class that implements {@link ICesiumClassificationTypeValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    public static <TFrom extends ICesiumClassificationTypeValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumClassificationTypeValuePropertyAdaptor<TFrom> createClassificationType(
            @Nonnull TFrom parent) {
        return new CesiumClassificationTypeValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, CesiumClassificationType> of((TFrom writer, @Nonnull CesiumClassificationType value) -> {
                    writer.writeClassificationType(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumColorBlendMode} values.
    * @param <TFrom> The class that implements {@link ICesiumColorBlendModeValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumColorBlendModeValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumColorBlendModeValuePropertyAdaptor<TFrom> createColorBlendMode(
            @Nonnull TFrom parent) {
        return new CesiumColorBlendModeValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, CesiumColorBlendMode> of((TFrom writer, @Nonnull CesiumColorBlendMode value) -> {
            writer.writeColorBlendMode(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumCornerType} values.
    * @param <TFrom> The class that implements {@link ICesiumCornerTypeValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCornerTypeValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCornerTypeValuePropertyAdaptor<TFrom> createCornerType(@Nonnull TFrom parent) {
        return new CesiumCornerTypeValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, CesiumCornerType> of((TFrom writer, @Nonnull CesiumCornerType value) -> {
            writer.writeCornerType(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Bounds} values.
    * @param <TFrom> The class that implements {@link ICesiumDistanceDisplayConditionValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumDistanceDisplayConditionValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumDistanceDisplayConditionValuePropertyAdaptor<TFrom> createDistanceDisplayCondition(
            @Nonnull TFrom parent) {
        return new CesiumDistanceDisplayConditionValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Bounds> of((TFrom writer, Bounds value) -> {
            writer.writeDistanceDisplayCondition(value);
        }), CesiumWriterAdaptorWriteSamplesCallback
                .<TFrom, Bounds> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Bounds> values, int startIndex, int length) -> {
                    writer.writeDistanceDisplayCondition(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@code double} values.
    * @param <TFrom> The class that implements {@link ICesiumDoubleValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumDoubleValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumDoubleValuePropertyAdaptor<TFrom> createDouble(@Nonnull TFrom parent) {
        return new CesiumDoubleValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Double> of((TFrom writer, Double value) -> {
            writer.writeNumber(value);
        }), CesiumWriterAdaptorWriteSamplesCallback.<TFrom, Double> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<Double> values, int startIndex, int length) -> {
            writer.writeNumber(dates, values, startIndex, length);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of {@code double} values.
    * @param <TFrom> The class that implements {@link ICesiumDoubleListValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumDoubleListValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumDoubleListValuePropertyAdaptor<TFrom> createDoubleList(@Nonnull TFrom parent) {
        return new CesiumDoubleListValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Iterable<Double>> of((TFrom writer, Iterable<Double> value) -> {
            writer.writeArray(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumHeightReference} values.
    * @param <TFrom> The class that implements {@link ICesiumHeightReferenceValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumHeightReferenceValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumHeightReferenceValuePropertyAdaptor<TFrom> createHeightReference(
            @Nonnull TFrom parent) {
        return new CesiumHeightReferenceValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, CesiumHeightReference> of((TFrom writer, @Nonnull CesiumHeightReference value) -> {
            writer.writeHeightReference(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumHorizontalOrigin} values.
    * @param <TFrom> The class that implements {@link ICesiumHorizontalOriginValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumHorizontalOriginValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumHorizontalOriginValuePropertyAdaptor<TFrom> createHorizontalOrigin(
            @Nonnull TFrom parent) {
        return new CesiumHorizontalOriginValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, CesiumHorizontalOrigin> of((TFrom writer, @Nonnull CesiumHorizontalOrigin value) -> {
                    writer.writeHorizontalOrigin(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@code int} values.
    * @param <TFrom> The class that implements {@link ICesiumIntegerValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumIntegerValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumIntegerValuePropertyAdaptor<TFrom> createInteger(@Nonnull TFrom parent) {
        return new CesiumIntegerValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Integer> of((TFrom writer, Integer value) -> {
            writer.writeNumber(value);
        }), CesiumWriterAdaptorWriteSamplesCallback.<TFrom, Integer> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<Integer> values, int startIndex, int length) -> {
            writer.writeNumber(dates, values, startIndex, length);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumLabelStyle} values.
    * @param <TFrom> The class that implements {@link ICesiumLabelStyleValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumLabelStyleValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumLabelStyleValuePropertyAdaptor<TFrom> createLabelStyle(@Nonnull TFrom parent) {
        return new CesiumLabelStyleValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, CesiumLabelStyle> of((TFrom writer, @Nonnull CesiumLabelStyle value) -> {
            writer.writeLabelStyle(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link NearFarScalar} values.
    * @param <TFrom> The class that implements {@link ICesiumNearFarScalarValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumNearFarScalarValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumNearFarScalarValuePropertyAdaptor<TFrom> createNearFarScalar(@Nonnull TFrom parent) {
        return new CesiumNearFarScalarValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, NearFarScalar> of((TFrom writer, NearFarScalar value) -> {
            writer.writeNearFarScalar(value);
        }), CesiumWriterAdaptorWriteSamplesCallback
                .<TFrom, NearFarScalar> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.NearFarScalar> values, int startIndex, int length) -> {
                    writer.writeNearFarScalar(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Reference} values.
    * @param <TFrom> The class that implements {@link ICesiumReferenceValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumReferenceValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumReferenceValuePropertyAdaptor<TFrom> createReference(@Nonnull TFrom parent) {
        return new CesiumReferenceValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Reference> of((TFrom writer, Reference value) -> {
            writer.writeReference(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of {@link Reference} values.
    * @param <TFrom> The class that implements {@link ICesiumReferenceListValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumReferenceListValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumReferenceListValuePropertyAdaptor<TFrom> createReferenceList(@Nonnull TFrom parent) {
        return new CesiumReferenceListValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, Iterable<Reference>> of((TFrom writer, Iterable<cesiumlanguagewriter.Reference> value) -> {
                    writer.writeReferences(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of lists of {@link Reference} values.
    * @param <TFrom> The class that implements {@link ICesiumReferenceListOfListsValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    public static <TFrom extends ICesiumReferenceListOfListsValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumReferenceListOfListsValuePropertyAdaptor<TFrom> createReferenceListOfLists(
            @Nonnull TFrom parent) {
        return new CesiumReferenceListOfListsValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback
                .<TFrom, Iterable<? extends Iterable<? extends Reference>>> of((TFrom writer, Iterable<? extends Iterable<? extends cesiumlanguagewriter.Reference>> value) -> {
                    writer.writeReferences(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Color} values.
    * @param <TFrom> The class that implements {@link ICesiumRgbafValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumRgbafValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumRgbafValuePropertyAdaptor<TFrom> createRgbaf(@Nonnull TFrom parent) {
        return new CesiumRgbafValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Color> of((TFrom writer, Color value) -> {
            writer.writeRgbaf(value);
        }), CesiumWriterAdaptorWriteSamplesCallback.<TFrom, Color> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<Color> values, int startIndex, int length) -> {
            writer.writeRgbaf(dates, values, startIndex, length);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Color} values.
    * @param <TFrom> The class that implements {@link ICesiumRgbaValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumRgbaValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumRgbaValuePropertyAdaptor<TFrom> createRgba(@Nonnull TFrom parent) {
        return new CesiumRgbaValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Color> of((TFrom writer, Color value) -> {
            writer.writeRgba(value);
        }), CesiumWriterAdaptorWriteSamplesCallback.<TFrom, Color> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<Color> values, int startIndex, int length) -> {
            writer.writeRgba(dates, values, startIndex, length);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumSensorVolumePortionToDisplay} values.
    * @param <TFrom> The class that implements {@link ICesiumSensorVolumePortionToDisplayValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumSensorVolumePortionToDisplayValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumSensorVolumePortionToDisplayValuePropertyAdaptor<TFrom> createSensorVolumePortionToDisplay(
            @Nonnull TFrom parent) {
        return new CesiumSensorVolumePortionToDisplayValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, CesiumSensorVolumePortionToDisplay> of((TFrom writer, @Nonnull CesiumSensorVolumePortionToDisplay value) -> {
                    writer.writePortionToDisplay(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumShadowMode} values.
    * @param <TFrom> The class that implements {@link ICesiumShadowModeValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumShadowModeValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumShadowModeValuePropertyAdaptor<TFrom> createShadowMode(@Nonnull TFrom parent) {
        return new CesiumShadowModeValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, CesiumShadowMode> of((TFrom writer, @Nonnull CesiumShadowMode value) -> {
            writer.writeShadowMode(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Spherical} values.
    * @param <TFrom> The class that implements {@link ICesiumSphericalValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumSphericalValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumSphericalValuePropertyAdaptor<TFrom> createSpherical(@Nonnull TFrom parent) {
        return new CesiumSphericalValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Spherical> of((TFrom writer, Spherical value) -> {
            writer.writeSpherical(value);
        }), CesiumWriterAdaptorWriteSamplesCallback
                .<TFrom, Spherical> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Spherical> values, int startIndex, int length) -> {
                    writer.writeSpherical(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of {@link Spherical} values.
    * @param <TFrom> The class that implements {@link ICesiumSphericalListValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumSphericalListValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumSphericalListValuePropertyAdaptor<TFrom> createSphericalList(@Nonnull TFrom parent) {
        return new CesiumSphericalListValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, Iterable<Spherical>> of((TFrom writer, Iterable<cesiumlanguagewriter.Spherical> value) -> {
                    writer.writeSpherical(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link String} values.
    * @param <TFrom> The class that implements {@link ICesiumFontValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumFontValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumFontValuePropertyAdaptor<TFrom> createFont(@Nonnull TFrom parent) {
        return new CesiumFontValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, String> of((TFrom writer, String value) -> {
            writer.writeFont(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link String} values.
    * @param <TFrom> The class that implements {@link ICesiumStringValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumStringValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumStringValuePropertyAdaptor<TFrom> createString(@Nonnull TFrom parent) {
        return new CesiumStringValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, String> of((TFrom writer, String value) -> {
            writer.writeString(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumStripeOrientation} values.
    * @param <TFrom> The class that implements {@link ICesiumStripeOrientationValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumStripeOrientationValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumStripeOrientationValuePropertyAdaptor<TFrom> createStripeOrientation(
            @Nonnull TFrom parent) {
        return new CesiumStripeOrientationValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, CesiumStripeOrientation> of((TFrom writer, @Nonnull CesiumStripeOrientation value) -> {
                    writer.writeStripeOrientation(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link UnitCartesian} values.
    * @param <TFrom> The class that implements {@link ICesiumUnitCartesian3ValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumUnitCartesian3ValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumUnitCartesian3ValuePropertyAdaptor<TFrom> createUnitCartesian3(
            @Nonnull TFrom parent) {
        return new CesiumUnitCartesian3ValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, UnitCartesian> of((TFrom writer, UnitCartesian value) -> {
            writer.writeUnitCartesian(value);
        }), CesiumWriterAdaptorWriteSamplesCallback
                .<TFrom, UnitCartesian> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.UnitCartesian> values, int startIndex, int length) -> {
                    writer.writeUnitCartesian(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of {@link UnitCartesian} values.
    * @param <TFrom> The class that implements {@link ICesiumUnitCartesian3ListValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumUnitCartesian3ListValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumUnitCartesian3ListValuePropertyAdaptor<TFrom> createUnitCartesian3List(
            @Nonnull TFrom parent) {
        return new CesiumUnitCartesian3ListValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, Iterable<UnitCartesian>> of((TFrom writer, Iterable<cesiumlanguagewriter.UnitCartesian> value) -> {
                    writer.writeUnitCartesian(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link UnitQuaternion} values.
    * @param <TFrom> The class that implements {@link ICesiumUnitQuaternionValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumUnitQuaternionValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumUnitQuaternionValuePropertyAdaptor<TFrom> createUnitQuaternion(
            @Nonnull TFrom parent) {
        return new CesiumUnitQuaternionValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, UnitQuaternion> of((TFrom writer, UnitQuaternion value) -> {
            writer.writeUnitQuaternion(value);
        }), CesiumWriterAdaptorWriteSamplesCallback
                .<TFrom, UnitQuaternion> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.UnitQuaternion> values, int startIndex, int length) -> {
                    writer.writeUnitQuaternion(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link UnitSpherical} values.
    * @param <TFrom> The class that implements {@link ICesiumUnitSphericalValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumUnitSphericalValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumUnitSphericalValuePropertyAdaptor<TFrom> createUnitSpherical(@Nonnull TFrom parent) {
        return new CesiumUnitSphericalValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, UnitSpherical> of((TFrom writer, UnitSpherical value) -> {
            writer.writeUnitSpherical(value);
        }), CesiumWriterAdaptorWriteSamplesCallback
                .<TFrom, UnitSpherical> of((TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.UnitSpherical> values, int startIndex, int length) -> {
                    writer.writeUnitSpherical(dates, values, startIndex, length);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of {@link UnitSpherical} values.
    * @param <TFrom> The class that implements {@link ICesiumUnitSphericalListValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumUnitSphericalListValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumUnitSphericalListValuePropertyAdaptor<TFrom> createUnitSphericalList(
            @Nonnull TFrom parent) {
        return new CesiumUnitSphericalListValuePropertyAdaptor<TFrom>(parent,
                CesiumWriterAdaptorWriteCallback.<TFrom, Iterable<UnitSpherical>> of((TFrom writer, Iterable<cesiumlanguagewriter.UnitSpherical> value) -> {
                    writer.writeUnitSpherical(value);
                }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumResource} values.
    * @param <TFrom> The class that implements {@link ICesiumUriValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumUriValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumUriValuePropertyAdaptor<TFrom> createUri(@Nonnull TFrom parent) {
        return new CesiumUriValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, CesiumResource> of((TFrom writer, CesiumResource value) -> {
            writer.writeUri(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumVerticalOrigin} values.
    * @param <TFrom> The class that implements {@link ICesiumVerticalOriginValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumVerticalOriginValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumVerticalOriginValuePropertyAdaptor<TFrom> createVerticalOrigin(
            @Nonnull TFrom parent) {
        return new CesiumVerticalOriginValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, CesiumVerticalOrigin> of((TFrom writer, @Nonnull CesiumVerticalOrigin value) -> {
            writer.writeVerticalOrigin(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Reference} values.
    * @param <TFrom> The class that implements {@link ICesiumVelocityReferenceValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumVelocityReferenceValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumVelocityReferenceValuePropertyAdaptor<TFrom> createVelocityReference(
            @Nonnull TFrom parent) {
        return new CesiumVelocityReferenceValuePropertyAdaptor<TFrom>(parent, CesiumWriterAdaptorWriteCallback.<TFrom, Reference> of((TFrom writer, Reference value) -> {
            writer.writeVelocityReference(value);
        }), CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }
}