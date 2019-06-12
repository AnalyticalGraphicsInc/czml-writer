using System.Drawing;
using JetBrains.Annotations;

namespace CesiumLanguageWriter.Advanced
{
    /// <summary>
    /// Creation methods for <see cref="CesiumWriterAdaptor{TFrom,TValue}"/> objects.
    /// </summary>
    public static class CesiumValuePropertyAdaptors
    {
        private static CesiumWriterAdaptorWriteDeleteCallback<TFrom> CreateWriteDeleteCallback<TFrom>()
            where TFrom : class, ICesiumDeletablePropertyWriter
        {
            return writer => writer.WriteDelete(true);
        }

        /// <summary>
        /// Create an adaptor for <see cref="CesiumArcType"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumArcTypeValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumArcTypeValuePropertyAdaptor<TFrom> CreateArcType<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumArcTypeValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumArcTypeValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteArcType(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="bool"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumBooleanValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumBooleanValuePropertyAdaptor<TFrom> CreateBoolean<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumBooleanValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumBooleanValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteBoolean(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="BoundingRectangle"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumBoundingRectangleValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumBoundingRectangleValuePropertyAdaptor<TFrom> CreateBoundingRectangle<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumBoundingRectangleValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumBoundingRectangleValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteBoundingRectangle(value), (writer, dates, values, startIndex, length) => writer.WriteBoundingRectangle(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="Rectangular"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartesian2ValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumCartesian2ValuePropertyAdaptor<TFrom> CreateCartesian2<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumCartesian2ValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumCartesian2ValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteCartesian2(value), (writer, dates, values, startIndex, length) => writer.WriteCartesian2(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="Cartesian"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartesian3ValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumCartesian3ValuePropertyAdaptor<TFrom> CreateCartesian3<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumCartesian3ValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumCartesian3ValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteCartesian(value), (writer, dates, values, startIndex, length) => writer.WriteCartesian(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="Motion{Cartesian}"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartesian3VelocityValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumCartesian3VelocityValuePropertyAdaptor<TFrom> CreateCartesian3Velocity<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumCartesian3VelocityValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumCartesian3VelocityValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteCartesianVelocity(value), (writer, dates, values, startIndex, length) => writer.WriteCartesianVelocity(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for lists of <see cref="Cartesian"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartesian3ListValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumCartesian3ListValuePropertyAdaptor<TFrom> CreateCartesian3List<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumCartesian3ListValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumCartesian3ListValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteCartesian(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="Cartographic"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartographicRadiansValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumCartographicRadiansValuePropertyAdaptor<TFrom> CreateCartographicRadians<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumCartographicRadiansValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumCartographicRadiansValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteCartographicRadians(value), (writer, dates, values, startIndex, length) => writer.WriteCartographicRadians(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for lists of <see cref="Cartographic"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartographicRadiansListValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumCartographicRadiansListValuePropertyAdaptor<TFrom> CreateCartographicRadiansList<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumCartographicRadiansListValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumCartographicRadiansListValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteCartographicRadians(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="Cartographic"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartographicDegreesValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumCartographicDegreesValuePropertyAdaptor<TFrom> CreateCartographicDegrees<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumCartographicDegreesValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumCartographicDegreesValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteCartographicDegrees(value), (writer, dates, values, startIndex, length) => writer.WriteCartographicDegrees(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for lists of <see cref="Cartographic"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartographicDegreesListValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumCartographicDegreesListValuePropertyAdaptor<TFrom> CreateCartographicDegreesList<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumCartographicDegreesListValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumCartographicDegreesListValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteCartographicDegrees(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="CartographicExtent"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartographicRectangleRadiansValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumCartographicRectangleRadiansValuePropertyAdaptor<TFrom> CreateCartographicRectangleRadians<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumCartographicRectangleRadiansValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumCartographicRectangleRadiansValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteWsen(value), (writer, dates, values, startIndex, length) => writer.WriteWsen(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="CartographicExtent"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCartographicRectangleDegreesValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumCartographicRectangleDegreesValuePropertyAdaptor<TFrom> CreateCartographicRectangleDegrees<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumCartographicRectangleDegreesValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumCartographicRectangleDegreesValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteWsenDegrees(value), (writer, dates, values, startIndex, length) => writer.WriteWsenDegrees(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="CesiumClassificationType"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumClassificationTypeValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumClassificationTypeValuePropertyAdaptor<TFrom> CreateClassificationType<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumClassificationTypeValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumClassificationTypeValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteClassificationType(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="CesiumColorBlendMode"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumColorBlendModeValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumColorBlendModeValuePropertyAdaptor<TFrom> CreateColorBlendMode<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumColorBlendModeValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumColorBlendModeValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteColorBlendMode(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="CesiumCornerType"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumCornerTypeValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumCornerTypeValuePropertyAdaptor<TFrom> CreateCornerType<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumCornerTypeValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumCornerTypeValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteCornerType(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="Bounds"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumDistanceDisplayConditionValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumDistanceDisplayConditionValuePropertyAdaptor<TFrom> CreateDistanceDisplayCondition<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumDistanceDisplayConditionValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumDistanceDisplayConditionValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteDistanceDisplayCondition(value), (writer, dates, values, startIndex, length) => writer.WriteDistanceDisplayCondition(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="double"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumDoubleValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumDoubleValuePropertyAdaptor<TFrom> CreateDouble<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumDoubleValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumDoubleValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteNumber(value), (writer, dates, values, startIndex, length) => writer.WriteNumber(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for lists of <see cref="double"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumDoubleListValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumDoubleListValuePropertyAdaptor<TFrom> CreateDoubleList<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumDoubleListValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumDoubleListValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteArray(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="CesiumHeightReference"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumHeightReferenceValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumHeightReferenceValuePropertyAdaptor<TFrom> CreateHeightReference<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumHeightReferenceValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumHeightReferenceValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteHeightReference(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="CesiumHorizontalOrigin"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumHorizontalOriginValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumHorizontalOriginValuePropertyAdaptor<TFrom> CreateHorizontalOrigin<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumHorizontalOriginValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumHorizontalOriginValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteHorizontalOrigin(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="int"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumIntegerValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumIntegerValuePropertyAdaptor<TFrom> CreateInteger<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumIntegerValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumIntegerValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteNumber(value), (writer, dates, values, startIndex, length) => writer.WriteNumber(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="CesiumLabelStyle"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumLabelStyleValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumLabelStyleValuePropertyAdaptor<TFrom> CreateLabelStyle<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumLabelStyleValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumLabelStyleValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteLabelStyle(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="NearFarScalar"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumNearFarScalarValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumNearFarScalarValuePropertyAdaptor<TFrom> CreateNearFarScalar<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumNearFarScalarValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumNearFarScalarValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteNearFarScalar(value), (writer, dates, values, startIndex, length) => writer.WriteNearFarScalar(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="Reference"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumReferenceValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumReferenceValuePropertyAdaptor<TFrom> CreateReference<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumReferenceValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumReferenceValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteReference(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for lists of <see cref="Reference"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumReferenceListValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumReferenceListValuePropertyAdaptor<TFrom> CreateReferenceList<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumReferenceListValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumReferenceListValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteReferences(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="Color"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumRgbafValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumRgbafValuePropertyAdaptor<TFrom> CreateRgbaf<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumRgbafValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumRgbafValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteRgbaf(value), (writer, dates, values, startIndex, length) => writer.WriteRgbaf(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="Color"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumRgbaValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumRgbaValuePropertyAdaptor<TFrom> CreateRgba<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumRgbaValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumRgbaValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteRgba(value), (writer, dates, values, startIndex, length) => writer.WriteRgba(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="CesiumSensorVolumePortionToDisplay"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumSensorVolumePortionToDisplayValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumSensorVolumePortionToDisplayValuePropertyAdaptor<TFrom> CreateSensorVolumePortionToDisplay<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumSensorVolumePortionToDisplayValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumSensorVolumePortionToDisplayValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WritePortionToDisplay(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="CesiumShadowMode"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumShadowModeValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumShadowModeValuePropertyAdaptor<TFrom> CreateShadowMode<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumShadowModeValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumShadowModeValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteShadowMode(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="Spherical"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumSphericalValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumSphericalValuePropertyAdaptor<TFrom> CreateSpherical<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumSphericalValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumSphericalValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteSpherical(value), (writer, dates, values, startIndex, length) => writer.WriteSpherical(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for lists of <see cref="Spherical"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumSphericalListValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumSphericalListValuePropertyAdaptor<TFrom> CreateSphericalList<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumSphericalListValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumSphericalListValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteSpherical(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="string"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumFontValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumFontValuePropertyAdaptor<TFrom> CreateFont<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumFontValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumFontValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteFont(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="string"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumStringValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumStringValuePropertyAdaptor<TFrom> CreateString<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumStringValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumStringValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteString(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="CesiumStripeOrientation"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumStripeOrientationValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumStripeOrientationValuePropertyAdaptor<TFrom> CreateStripeOrientation<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumStripeOrientationValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumStripeOrientationValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteStripeOrientation(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="UnitCartesian"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumUnitCartesian3ValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumUnitCartesian3ValuePropertyAdaptor<TFrom> CreateUnitCartesian3<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumUnitCartesian3ValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumUnitCartesian3ValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteUnitCartesian(value), (writer, dates, values, startIndex, length) => writer.WriteUnitCartesian(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for lists of <see cref="UnitCartesian"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumUnitCartesian3ListValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumUnitCartesian3ListValuePropertyAdaptor<TFrom> CreateUnitCartesian3List<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumUnitCartesian3ListValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumUnitCartesian3ListValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteUnitCartesian(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="UnitQuaternion"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumUnitQuaternionValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumUnitQuaternionValuePropertyAdaptor<TFrom> CreateUnitQuaternion<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumUnitQuaternionValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumUnitQuaternionValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteUnitQuaternion(value), (writer, dates, values, startIndex, length) => writer.WriteUnitQuaternion(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="UnitSpherical"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumUnitSphericalValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumUnitSphericalValuePropertyAdaptor<TFrom> CreateUnitSpherical<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumUnitSphericalValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumUnitSphericalValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteUnitSpherical(value), (writer, dates, values, startIndex, length) => writer.WriteUnitSpherical(dates, values, startIndex, length), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for lists of <see cref="UnitSpherical"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumUnitSphericalListValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumUnitSphericalListValuePropertyAdaptor<TFrom> CreateUnitSphericalList<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumUnitSphericalListValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumUnitSphericalListValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteUnitSpherical(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="CesiumResource"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumUriValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumUriValuePropertyAdaptor<TFrom> CreateUri<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumUriValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumUriValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteUri(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="CesiumVerticalOrigin"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumVerticalOriginValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumVerticalOriginValuePropertyAdaptor<TFrom> CreateVerticalOrigin<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumVerticalOriginValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumVerticalOriginValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteVerticalOrigin(value), CreateWriteDeleteCallback<TFrom>());
        }

        /// <summary>
        /// Create an adaptor for <see cref="Reference"/> values.
        /// </summary>
        /// <typeparam name="TFrom">The class that implements <see cref="ICesiumVelocityReferenceValuePropertyWriter"/> to adapt.</typeparam>
        /// <param name="parent">The instance to wrap.</param>
        /// <returns>The new adaptor.</returns>
        public static CesiumVelocityReferenceValuePropertyAdaptor<TFrom> CreateVelocityReference<TFrom>([NotNull] TFrom parent)
            where TFrom : class, ICesiumVelocityReferenceValuePropertyWriter, ICesiumDeletablePropertyWriter
        {
            return new CesiumVelocityReferenceValuePropertyAdaptor<TFrom>(parent, (writer, value) => writer.WriteVelocityReference(value), CreateWriteDeleteCallback<TFrom>());
        }
    }
}