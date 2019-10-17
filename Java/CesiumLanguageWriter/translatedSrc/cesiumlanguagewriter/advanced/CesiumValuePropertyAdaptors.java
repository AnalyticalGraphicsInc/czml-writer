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
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
public final class CesiumValuePropertyAdaptors {
    private CesiumValuePropertyAdaptors() {}

    @Nonnull
    private static <TFrom extends ICesiumDeletablePropertyWriter> CesiumWriterAdaptorWriteDeleteCallback<TFrom> createWriteDeleteCallback() {
        return new CesiumWriterAdaptorWriteDeleteCallback<TFrom>() {
            public void invoke(TFrom writer) {
                writer.writeDelete(true);
            }
        };
    }

    /**
    * Create an adaptor for {@link CesiumArcType} values.
    * @param <TFrom> The class that implements {@link ICesiumArcTypeValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumArcTypeValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumArcTypeValuePropertyAdaptor<TFrom> createArcType(@Nonnull TFrom parent) {
        return new CesiumArcTypeValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CesiumArcType>() {
            public void invoke(TFrom writer, @Nonnull CesiumArcType value) {
                writer.writeArcType(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@code boolean} values.
    * @param <TFrom> The class that implements {@link ICesiumBooleanValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumBooleanValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumBooleanValuePropertyAdaptor<TFrom> createBoolean(@Nonnull TFrom parent) {
        return new CesiumBooleanValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Boolean>() {
            public void invoke(TFrom writer, Boolean value) {
                writer.writeBoolean(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumBoundingRectangleValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.BoundingRectangle>() {
            public void invoke(TFrom writer, BoundingRectangle value) {
                writer.writeBoundingRectangle(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.BoundingRectangle>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.BoundingRectangle> values, int startIndex, int length) {
                writer.writeBoundingRectangle(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Rectangular} values.
    * @param <TFrom> The class that implements {@link ICesiumCartesian2ValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartesian2ValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartesian2ValuePropertyAdaptor<TFrom> createCartesian2(@Nonnull TFrom parent) {
        return new CesiumCartesian2ValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.Rectangular>() {
            public void invoke(TFrom writer, Rectangular value) {
                writer.writeCartesian2(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.Rectangular>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Rectangular> values, int startIndex, int length) {
                writer.writeCartesian2(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Cartesian} values.
    * @param <TFrom> The class that implements {@link ICesiumCartesian3ValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartesian3ValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartesian3ValuePropertyAdaptor<TFrom> createCartesian3(@Nonnull TFrom parent) {
        return new CesiumCartesian3ValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.Cartesian>() {
            public void invoke(TFrom writer, Cartesian value) {
                writer.writeCartesian(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.Cartesian>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Cartesian> values, int startIndex, int length) {
                writer.writeCartesian(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumCartesian3VelocityValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.Motion1<Cartesian>>() {
            public void invoke(TFrom writer, Motion1<Cartesian> value) {
                writer.writeCartesianVelocity(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.Motion1<Cartesian>>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Motion1<cesiumlanguagewriter.Cartesian>> values, int startIndex, int length) {
                writer.writeCartesianVelocity(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of {@link Cartesian} values.
    * @param <TFrom> The class that implements {@link ICesiumCartesian3ListValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCartesian3ListValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartesian3ListValuePropertyAdaptor<TFrom> createCartesian3List(@Nonnull TFrom parent) {
        return new CesiumCartesian3ListValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Iterable<Cartesian>>() {
            public void invoke(TFrom writer, Iterable<cesiumlanguagewriter.Cartesian> value) {
                writer.writeCartesian(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of lists of {@link Cartesian} values.
    * @param <TFrom> The class that implements {@link ICesiumCartesian3ListOfListsValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    public static <TFrom extends ICesiumCartesian3ListOfListsValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartesian3ListOfListsValuePropertyAdaptor<TFrom> createCartesian3ListOfLists(
            @Nonnull TFrom parent) {
        return new CesiumCartesian3ListOfListsValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Iterable<? extends Iterable<Cartesian>>>() {
            public void invoke(TFrom writer, Iterable<? extends Iterable<cesiumlanguagewriter.Cartesian>> value) {
                writer.writeCartesian(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumCartographicRadiansValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.Cartographic>() {
            public void invoke(TFrom writer, Cartographic value) {
                writer.writeCartographicRadians(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.Cartographic>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Cartographic> values, int startIndex, int length) {
                writer.writeCartographicRadians(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumCartographicRadiansListValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Iterable<Cartographic>>() {
            public void invoke(TFrom writer, Iterable<cesiumlanguagewriter.Cartographic> value) {
                writer.writeCartographicRadians(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of lists of {@link Cartographic} values.
    * @param <TFrom> The class that implements {@link ICesiumCartographicRadiansListOfListsValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    public static <TFrom extends ICesiumCartographicRadiansListOfListsValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartographicRadiansListOfListsValuePropertyAdaptor<TFrom> createCartographicRadiansListOfLists(
            @Nonnull TFrom parent) {
        return new CesiumCartographicRadiansListOfListsValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Iterable<? extends Iterable<Cartographic>>>() {
            public void invoke(TFrom writer, Iterable<? extends Iterable<cesiumlanguagewriter.Cartographic>> value) {
                writer.writeCartographicRadians(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumCartographicDegreesValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.Cartographic>() {
            public void invoke(TFrom writer, Cartographic value) {
                writer.writeCartographicDegrees(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.Cartographic>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Cartographic> values, int startIndex, int length) {
                writer.writeCartographicDegrees(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumCartographicDegreesListValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Iterable<Cartographic>>() {
            public void invoke(TFrom writer, Iterable<cesiumlanguagewriter.Cartographic> value) {
                writer.writeCartographicDegrees(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of lists of {@link Cartographic} values.
    * @param <TFrom> The class that implements {@link ICesiumCartographicDegreesListOfListsValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    public static <TFrom extends ICesiumCartographicDegreesListOfListsValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCartographicDegreesListOfListsValuePropertyAdaptor<TFrom> createCartographicDegreesListOfLists(
            @Nonnull TFrom parent) {
        return new CesiumCartographicDegreesListOfListsValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Iterable<? extends Iterable<Cartographic>>>() {
            public void invoke(TFrom writer, Iterable<? extends Iterable<cesiumlanguagewriter.Cartographic>> value) {
                writer.writeCartographicDegrees(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumCartographicRectangleRadiansValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CartographicExtent>() {
            public void invoke(TFrom writer, CartographicExtent value) {
                writer.writeWsen(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.CartographicExtent>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.CartographicExtent> values, int startIndex, int length) {
                writer.writeWsen(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumCartographicRectangleDegreesValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CartographicExtent>() {
            public void invoke(TFrom writer, CartographicExtent value) {
                writer.writeWsenDegrees(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.CartographicExtent>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.CartographicExtent> values, int startIndex, int length) {
                writer.writeWsenDegrees(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumClassificationType} values.
    * @param <TFrom> The class that implements {@link ICesiumClassificationTypeValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    public static <TFrom extends ICesiumClassificationTypeValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumClassificationTypeValuePropertyAdaptor<TFrom> createClassificationType(
            @Nonnull TFrom parent) {
        return new CesiumClassificationTypeValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CesiumClassificationType>() {
            public void invoke(TFrom writer, @Nonnull CesiumClassificationType value) {
                writer.writeClassificationType(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumColorBlendMode} values.
    * @param <TFrom> The class that implements {@link ICesiumColorBlendModeValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumColorBlendModeValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumColorBlendModeValuePropertyAdaptor<TFrom> createColorBlendMode(@Nonnull TFrom parent) {
        return new CesiumColorBlendModeValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CesiumColorBlendMode>() {
            public void invoke(TFrom writer, @Nonnull CesiumColorBlendMode value) {
                writer.writeColorBlendMode(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumCornerType} values.
    * @param <TFrom> The class that implements {@link ICesiumCornerTypeValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumCornerTypeValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumCornerTypeValuePropertyAdaptor<TFrom> createCornerType(@Nonnull TFrom parent) {
        return new CesiumCornerTypeValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CesiumCornerType>() {
            public void invoke(TFrom writer, @Nonnull CesiumCornerType value) {
                writer.writeCornerType(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumDistanceDisplayConditionValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.Bounds>() {
            public void invoke(TFrom writer, Bounds value) {
                writer.writeDistanceDisplayCondition(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.Bounds>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Bounds> values, int startIndex, int length) {
                writer.writeDistanceDisplayCondition(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@code double} values.
    * @param <TFrom> The class that implements {@link ICesiumDoubleValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumDoubleValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumDoubleValuePropertyAdaptor<TFrom> createDouble(@Nonnull TFrom parent) {
        return new CesiumDoubleValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Double>() {
            public void invoke(TFrom writer, Double value) {
                writer.writeNumber(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, Double>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<Double> values, int startIndex, int length) {
                writer.writeNumber(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of {@code double} values.
    * @param <TFrom> The class that implements {@link ICesiumDoubleListValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumDoubleListValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumDoubleListValuePropertyAdaptor<TFrom> createDoubleList(@Nonnull TFrom parent) {
        return new CesiumDoubleListValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Iterable<Double>>() {
            public void invoke(TFrom writer, Iterable<Double> value) {
                writer.writeArray(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumHeightReferenceValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CesiumHeightReference>() {
            public void invoke(TFrom writer, @Nonnull CesiumHeightReference value) {
                writer.writeHeightReference(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumHorizontalOriginValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CesiumHorizontalOrigin>() {
            public void invoke(TFrom writer, @Nonnull CesiumHorizontalOrigin value) {
                writer.writeHorizontalOrigin(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@code int} values.
    * @param <TFrom> The class that implements {@link ICesiumIntegerValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumIntegerValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumIntegerValuePropertyAdaptor<TFrom> createInteger(@Nonnull TFrom parent) {
        return new CesiumIntegerValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Integer>() {
            public void invoke(TFrom writer, Integer value) {
                writer.writeNumber(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, Integer>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<Integer> values, int startIndex, int length) {
                writer.writeNumber(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumLabelStyle} values.
    * @param <TFrom> The class that implements {@link ICesiumLabelStyleValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumLabelStyleValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumLabelStyleValuePropertyAdaptor<TFrom> createLabelStyle(@Nonnull TFrom parent) {
        return new CesiumLabelStyleValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CesiumLabelStyle>() {
            public void invoke(TFrom writer, @Nonnull CesiumLabelStyle value) {
                writer.writeLabelStyle(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link NearFarScalar} values.
    * @param <TFrom> The class that implements {@link ICesiumNearFarScalarValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumNearFarScalarValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumNearFarScalarValuePropertyAdaptor<TFrom> createNearFarScalar(@Nonnull TFrom parent) {
        return new CesiumNearFarScalarValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.NearFarScalar>() {
            public void invoke(TFrom writer, NearFarScalar value) {
                writer.writeNearFarScalar(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.NearFarScalar>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.NearFarScalar> values, int startIndex, int length) {
                writer.writeNearFarScalar(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Reference} values.
    * @param <TFrom> The class that implements {@link ICesiumReferenceValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumReferenceValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumReferenceValuePropertyAdaptor<TFrom> createReference(@Nonnull TFrom parent) {
        return new CesiumReferenceValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.Reference>() {
            public void invoke(TFrom writer, Reference value) {
                writer.writeReference(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of {@link Reference} values.
    * @param <TFrom> The class that implements {@link ICesiumReferenceListValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumReferenceListValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumReferenceListValuePropertyAdaptor<TFrom> createReferenceList(@Nonnull TFrom parent) {
        return new CesiumReferenceListValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Iterable<Reference>>() {
            public void invoke(TFrom writer, Iterable<cesiumlanguagewriter.Reference> value) {
                writer.writeReferences(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of lists of {@link Reference} values.
    * @param <TFrom> The class that implements {@link ICesiumReferenceListOfListsValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    public static <TFrom extends ICesiumReferenceListOfListsValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumReferenceListOfListsValuePropertyAdaptor<TFrom> createReferenceListOfLists(
            @Nonnull TFrom parent) {
        return new CesiumReferenceListOfListsValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Iterable<? extends Iterable<? extends Reference>>>() {
            public void invoke(TFrom writer, Iterable<? extends Iterable<? extends cesiumlanguagewriter.Reference>> value) {
                writer.writeReferences(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Color} values.
    * @param <TFrom> The class that implements {@link ICesiumRgbafValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumRgbafValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumRgbafValuePropertyAdaptor<TFrom> createRgbaf(@Nonnull TFrom parent) {
        return new CesiumRgbafValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Color>() {
            public void invoke(TFrom writer, Color value) {
                writer.writeRgbaf(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, Color>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<Color> values, int startIndex, int length) {
                writer.writeRgbaf(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Color} values.
    * @param <TFrom> The class that implements {@link ICesiumRgbaValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumRgbaValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumRgbaValuePropertyAdaptor<TFrom> createRgba(@Nonnull TFrom parent) {
        return new CesiumRgbaValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Color>() {
            public void invoke(TFrom writer, Color value) {
                writer.writeRgba(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, Color>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<Color> values, int startIndex, int length) {
                writer.writeRgba(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumSensorVolumePortionToDisplayValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CesiumSensorVolumePortionToDisplay>() {
            public void invoke(TFrom writer, @Nonnull CesiumSensorVolumePortionToDisplay value) {
                writer.writePortionToDisplay(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumShadowMode} values.
    * @param <TFrom> The class that implements {@link ICesiumShadowModeValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumShadowModeValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumShadowModeValuePropertyAdaptor<TFrom> createShadowMode(@Nonnull TFrom parent) {
        return new CesiumShadowModeValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CesiumShadowMode>() {
            public void invoke(TFrom writer, @Nonnull CesiumShadowMode value) {
                writer.writeShadowMode(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link Spherical} values.
    * @param <TFrom> The class that implements {@link ICesiumSphericalValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumSphericalValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumSphericalValuePropertyAdaptor<TFrom> createSpherical(@Nonnull TFrom parent) {
        return new CesiumSphericalValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.Spherical>() {
            public void invoke(TFrom writer, Spherical value) {
                writer.writeSpherical(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.Spherical>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.Spherical> values, int startIndex, int length) {
                writer.writeSpherical(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for lists of {@link Spherical} values.
    * @param <TFrom> The class that implements {@link ICesiumSphericalListValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumSphericalListValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumSphericalListValuePropertyAdaptor<TFrom> createSphericalList(@Nonnull TFrom parent) {
        return new CesiumSphericalListValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Iterable<Spherical>>() {
            public void invoke(TFrom writer, Iterable<cesiumlanguagewriter.Spherical> value) {
                writer.writeSpherical(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link String} values.
    * @param <TFrom> The class that implements {@link ICesiumFontValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumFontValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumFontValuePropertyAdaptor<TFrom> createFont(@Nonnull TFrom parent) {
        return new CesiumFontValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, String>() {
            public void invoke(TFrom writer, String value) {
                writer.writeFont(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link String} values.
    * @param <TFrom> The class that implements {@link ICesiumStringValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumStringValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumStringValuePropertyAdaptor<TFrom> createString(@Nonnull TFrom parent) {
        return new CesiumStringValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, String>() {
            public void invoke(TFrom writer, String value) {
                writer.writeString(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumStripeOrientationValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CesiumStripeOrientation>() {
            public void invoke(TFrom writer, @Nonnull CesiumStripeOrientation value) {
                writer.writeStripeOrientation(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link UnitCartesian} values.
    * @param <TFrom> The class that implements {@link ICesiumUnitCartesian3ValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumUnitCartesian3ValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumUnitCartesian3ValuePropertyAdaptor<TFrom> createUnitCartesian3(@Nonnull TFrom parent) {
        return new CesiumUnitCartesian3ValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.UnitCartesian>() {
            public void invoke(TFrom writer, UnitCartesian value) {
                writer.writeUnitCartesian(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.UnitCartesian>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.UnitCartesian> values, int startIndex, int length) {
                writer.writeUnitCartesian(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumUnitCartesian3ListValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Iterable<UnitCartesian>>() {
            public void invoke(TFrom writer, Iterable<cesiumlanguagewriter.UnitCartesian> value) {
                writer.writeUnitCartesian(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link UnitQuaternion} values.
    * @param <TFrom> The class that implements {@link ICesiumUnitQuaternionValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumUnitQuaternionValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumUnitQuaternionValuePropertyAdaptor<TFrom> createUnitQuaternion(@Nonnull TFrom parent) {
        return new CesiumUnitQuaternionValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.UnitQuaternion>() {
            public void invoke(TFrom writer, UnitQuaternion value) {
                writer.writeUnitQuaternion(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.UnitQuaternion>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.UnitQuaternion> values, int startIndex, int length) {
                writer.writeUnitQuaternion(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link UnitSpherical} values.
    * @param <TFrom> The class that implements {@link ICesiumUnitSphericalValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumUnitSphericalValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumUnitSphericalValuePropertyAdaptor<TFrom> createUnitSpherical(@Nonnull TFrom parent) {
        return new CesiumUnitSphericalValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.UnitSpherical>() {
            public void invoke(TFrom writer, UnitSpherical value) {
                writer.writeUnitSpherical(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<TFrom, cesiumlanguagewriter.UnitSpherical>() {
            public void invoke(TFrom writer, List<cesiumlanguagewriter.JulianDate> dates, List<cesiumlanguagewriter.UnitSpherical> values, int startIndex, int length) {
                writer.writeUnitSpherical(dates, values, startIndex, length);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumUnitSphericalListValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, Iterable<UnitSpherical>>() {
            public void invoke(TFrom writer, Iterable<cesiumlanguagewriter.UnitSpherical> value) {
                writer.writeUnitSpherical(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumResource} values.
    * @param <TFrom> The class that implements {@link ICesiumUriValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumUriValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumUriValuePropertyAdaptor<TFrom> createUri(@Nonnull TFrom parent) {
        return new CesiumUriValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CesiumResource>() {
            public void invoke(TFrom writer, CesiumResource value) {
                writer.writeUri(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }

    /**
    * Create an adaptor for {@link CesiumVerticalOrigin} values.
    * @param <TFrom> The class that implements {@link ICesiumVerticalOriginValuePropertyWriter} to adapt.
    * @param parent The instance to wrap.
    * @return The new adaptor.
    */
    @Nonnull
    public static <TFrom extends ICesiumVerticalOriginValuePropertyWriter & ICesiumDeletablePropertyWriter> CesiumVerticalOriginValuePropertyAdaptor<TFrom> createVerticalOrigin(@Nonnull TFrom parent) {
        return new CesiumVerticalOriginValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.CesiumVerticalOrigin>() {
            public void invoke(TFrom writer, @Nonnull CesiumVerticalOrigin value) {
                writer.writeVerticalOrigin(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
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
        return new CesiumVelocityReferenceValuePropertyAdaptor<TFrom>(parent, new CesiumWriterAdaptorWriteCallback<TFrom, cesiumlanguagewriter.Reference>() {
            public void invoke(TFrom writer, Reference value) {
                writer.writeVelocityReference(value);
            }
        }, CesiumValuePropertyAdaptors.<TFrom> createWriteDeleteCallback());
    }
}