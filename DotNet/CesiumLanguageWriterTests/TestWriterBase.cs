using System.Collections;
using System.Collections.Generic;
using System.Drawing;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Text;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    public abstract class TestWriterBase
    {
        public StringWriter StringWriter { get; private set; }
        public CesiumOutputStream OutputStream { get; private set; }
        public CesiumStreamWriter Writer { get; private set; }

        [SetUp]
        public void TestWriterBaseSetUp()
        {
            StringWriter = new StringWriter();
            OutputStream = new CesiumOutputStream(StringWriter);
            Writer = new CesiumStreamWriter();
        }

        [TearDown]
        public void TestWriterBaseTearDown()
        {
            StringWriter.Dispose();
        }

        [NotNull]
        public PacketCesiumWriter OpenPacket()
        {
            return Writer.OpenPacket(OutputStream);
        }

        /// <summary>
        /// Helper method for creating expected JSON output from key-value pairs.
        /// </summary>
        [NotNull]
        public static string CreateExpectedJson([NotNull] string topLevelPropertyName, [NotNull] IDictionary<string, object> dictionary)
        {
            return CreateExpectedJson(new Dictionary<string, object>
            {
                { topLevelPropertyName, dictionary },
            });
        }

        /// <summary>
        /// Helper method for creating expected JSON output from key-value pairs.
        /// </summary>
        [NotNull]
        public static string CreateExpectedJson([NotNull] IDictionary<string, object> dictionary)
        {
            var builder = new StringBuilder();
            builder.Append('{');
            foreach (KeyValuePair<string, object> pair in dictionary)
            {
                builder.Append('"')
                       .Append(pair.Key)
                       .Append('"')
                       .Append(':')
                       .Append(FormatValue(pair.Value))
                       .Append(',');
            }

            builder[builder.Length - 1] = '}';
            return builder.ToString();
        }

        [NotNull]
        private static string FormatValue([NotNull] object value)
        {
            if (value is bool)
            {
                // by default, .NET uses "True" and "False" but we need lowercase.
                return (bool)value ? "true" : "false";
            }

            if (value is Duration)
            {
                var duration = (Duration)value;
                value = duration.TotalSeconds;
            }

            if (value is int)
            {
                int i = (int)value;
                return i.ToString(CultureInfo.InvariantCulture);
            }

            if (value is double)
            {
                double d = (double)value;
                return d.ToString(CultureInfo.InvariantCulture);
            }

            if (value is CesiumStripeOrientation)
            {
                value = CesiumFormattingHelper.StripeOrientationToString((CesiumStripeOrientation)value);
            }
            else if (value is CesiumHorizontalOrigin)
            {
                value = CesiumFormattingHelper.HorizontalOriginToString((CesiumHorizontalOrigin)value);
            }
            else if (value is CesiumVerticalOrigin)
            {
                value = CesiumFormattingHelper.VerticalOriginToString((CesiumVerticalOrigin)value);
            }
            else if (value is CesiumHeightReference)
            {
                value = CesiumFormattingHelper.HeightReferenceToString((CesiumHeightReference)value);
            }
            else if (value is CesiumPathMode)
            {
                value = CesiumFormattingHelper.PathModeToString((CesiumPathMode)value);
            }
            else if (value is CesiumShadowMode)
            {
                value = CesiumFormattingHelper.ShadowModeToString((CesiumShadowMode)value);
            }
            else if (value is CesiumInterpolationAlgorithm)
            {
                value = CesiumFormattingHelper.InterpolationAlgorithmToString((CesiumInterpolationAlgorithm)value);
            }
            else if (value is CesiumExtrapolationType)
            {
                value = CesiumFormattingHelper.ExtrapolationTypeToString((CesiumExtrapolationType)value);
            }
            else if (value is CesiumLabelStyle)
            {
                value = CesiumFormattingHelper.LabelStyleToString((CesiumLabelStyle)value);
            }
            else if (value is CesiumArcType)
            {
                value = CesiumFormattingHelper.ArcTypeToString((CesiumArcType)value);
            }
            else if (value is CesiumCornerType)
            {
                value = CesiumFormattingHelper.CornerTypeToString((CesiumCornerType)value);
            }
            else if (value is CesiumClassificationType)
            {
                value = CesiumFormattingHelper.ClassificationTypeToString((CesiumClassificationType)value);
            }
            else if (value is CesiumColorBlendMode)
            {
                value = CesiumFormattingHelper.ColorBlendModeToString((CesiumColorBlendMode)value);
            }
            else if (value is CesiumSensorVolumePortionToDisplay)
            {
                value = CesiumFormattingHelper.SensorVolumePortionToDisplayToString((CesiumSensorVolumePortionToDisplay)value);
            }
            else if (value is ClockRange)
            {
                value = CesiumFormattingHelper.ClockRangeToString((ClockRange)value);
            }
            else if (value is ClockStep)
            {
                value = CesiumFormattingHelper.ClockStepToString((ClockStep)value);
            }

            if (value is string)
            {
                return string.Format("\"{0}\"", value);
            }

            {
                var doubleList = value as DoubleList;
                if (!ReferenceEquals(doubleList, null))
                {
                    return CreateExpectedJson(new Dictionary<string, object>
                    {
                        { DoubleListCesiumWriter.ArrayPropertyName, doubleList.ToList() },
                    });
                }
            }

            if (value is Color)
            {
                var color = (Color)value;
                return FormatValueType(ColorCesiumWriter.RgbaPropertyName, Decompose(color));
            }

            if (value is Bounds)
            {
                var bounds = (Bounds)value;
                return FormatValueType(DistanceDisplayConditionCesiumWriter.DistanceDisplayConditionPropertyName, Decompose(bounds));
            }

            if (value is BoundingRectangle)
            {
                var boundingRectangle = (BoundingRectangle)value;
                return FormatValueType(BoundingRectangleCesiumWriter.BoundingRectanglePropertyName, Decompose(boundingRectangle));
            }

            if (value is NearFarScalar)
            {
                var nearFarScalar = (NearFarScalar)value;
                return FormatValueType(NearFarScalarCesiumWriter.NearFarScalarPropertyName, Decompose(nearFarScalar));
            }

            {
                var nearFarScalarList = value as NearFarScalarList;
                if (!ReferenceEquals(nearFarScalarList, null))
                {
                    return CreateExpectedJson(new Dictionary<string, object>
                    {
                        { NearFarScalarCesiumWriter.NearFarScalarPropertyName, nearFarScalarList.SelectMany(o => Decompose(o)) },
                    });
                }
            }

            if (value is Rectangular)
            {
                var rectangular = (Rectangular)value;
                return FormatValueType(PixelOffsetCesiumWriter.Cartesian2PropertyName, Decompose(rectangular));
            }

            {
                var shapeList = value as ShapeList;
                if (!ReferenceEquals(shapeList, null))
                {
                    return CreateExpectedJson(new Dictionary<string, object>
                    {
                        { ShapeCesiumWriter.Cartesian2PropertyName, shapeList.SelectMany(o => Decompose(o)) },
                    });
                }
            }

            if (value is Cartesian)
            {
                var cartesian = (Cartesian)value;
                return FormatValueType(PositionCesiumWriter.CartesianPropertyName, Decompose(cartesian));
            }

            {
                var positionList = value as PositionList;
                if (!ReferenceEquals(positionList, null))
                {
                    return CreateExpectedJson(new Dictionary<string, object>
                    {
                        { PositionListCesiumWriter.CartesianPropertyName, positionList.SelectMany(o => Decompose(o)) },
                    });
                }
            }

            if (value is Cartographic)
            {
                var cartographic = (Cartographic)value;
                return FormatValueType(PositionCesiumWriter.CartographicRadiansPropertyName, Decompose(cartographic));
            }

            if (value is UnitCartesian)
            {
                var unitCartesian = (UnitCartesian)value;
                return FormatValueType(DirectionCesiumWriter.UnitCartesianPropertyName, Decompose(unitCartesian));
            }

            if (value is UnitQuaternion)
            {
                var unitQuaternion = (UnitQuaternion)value;
                return FormatValueType(RotationCesiumWriter.UnitQuaternionPropertyName, Decompose(unitQuaternion));
            }

            if (value is UnitSpherical)
            {
                var unitSpherical = (UnitSpherical)value;
                return FormatValueType(DirectionCesiumWriter.UnitSphericalPropertyName, Decompose(unitSpherical));
            }

            {
                var unitSphericalList = value as UnitSphericalList;
                if (!ReferenceEquals(unitSphericalList, null))
                {
                    return CreateExpectedJson(new Dictionary<string, object>
                    {
                        { DirectionListCesiumWriter.UnitSphericalPropertyName, unitSphericalList.SelectMany(o => Decompose(o)) },
                    });
                }
            }

            if (value is Spherical)
            {
                var spherical = (Spherical)value;
                return FormatValueType(DirectionCesiumWriter.SphericalPropertyName, Decompose(spherical));
            }

            {
                var sphericalList = value as SphericalList;
                if (!ReferenceEquals(sphericalList, null))
                {
                    return CreateExpectedJson(new Dictionary<string, object>
                    {
                        { DirectionListCesiumWriter.SphericalPropertyName, sphericalList.SelectMany(o => Decompose(o)) },
                    });
                }
            }

            {
                var cartographicExtent = value as CartographicExtent;
                if (!ReferenceEquals(cartographicExtent, null))
                {
                    return FormatValueType(RectangleCoordinatesCesiumWriter.WsenPropertyName, Decompose(cartographicExtent));
                }
            }

            {
                var dictionary = value as IDictionary<string, object>;
                if (!ReferenceEquals(dictionary, null))
                {
                    return CreateExpectedJson(dictionary);
                }
            }

            {
                var list = value as IEnumerable;
                if (!ReferenceEquals(list, null))
                {
                    var builder = new StringBuilder();
                    builder.Append('[');
                    foreach (var o in list)
                    {
                        builder.Append(FormatValue(o)).Append(',');
                    }

                    builder[builder.Length - 1] = ']';
                    return builder.ToString();
                }
            }

            return value.ToString();
        }

        private static List<object> Decompose(UnitSpherical value)
        {
            return new List<object> { value.Clock, value.Cone };
        }

        private static List<object> Decompose(Spherical value)
        {
            return new List<object> { value.Clock, value.Cone, value.Magnitude };
        }

        private static List<object> Decompose(Color value)
        {
            return new List<object> { value.R, value.G, value.B, value.A };
        }

        private static List<object> Decompose(Bounds value)
        {
            return new List<object> { value.LowerBound, value.UpperBound };
        }

        private static List<object> Decompose(BoundingRectangle value)
        {
            return new List<object> { value.Left, value.Bottom, value.Width, value.Height };
        }

        private static List<object> Decompose(NearFarScalar value)
        {
            return new List<object> { value.NearDistance, value.NearValue, value.FarDistance, value.FarValue };
        }

        private static List<object> Decompose(Rectangular value)
        {
            return new List<object> { value.X, value.Y };
        }

        private static List<object> Decompose(Cartesian value)
        {
            return new List<object> { value.X, value.Y, value.Z };
        }

        private static List<object> Decompose(Cartographic value)
        {
            return new List<object> { value.Longitude, value.Latitude, value.Height };
        }

        private static List<object> Decompose(UnitCartesian value)
        {
            return new List<object> { value.X, value.Y, value.Z };
        }

        private static List<object> Decompose(UnitQuaternion value)
        {
            return new List<object> { value.X, value.Y, value.Z, value.W };
        }

        private static List<object> Decompose(CartographicExtent value)
        {
            return new List<object> { value.WestLongitude, value.SouthLatitude, value.EastLongitude, value.NorthLatitude };
        }

        private static string FormatValueType(string propertyName, IEnumerable values)
        {
            return CreateExpectedJson(new Dictionary<string, object>
            {
                { propertyName, values },
            });
        }

        [AssertionMethod]
        public void AssertExpectedJson([NotNull] string topLevelPropertyName, [NotNull] IDictionary<string, object> dictionary)
        {
            string expectedJson = CreateExpectedJson(topLevelPropertyName, dictionary);
            Assert.AreEqual(expectedJson, StringWriter.ToString());
        }

        [AssertionMethod]
        public void AssertExpectedJson([NotNull] IDictionary<string, object> dictionary)
        {
            string expectedJson = CreateExpectedJson(dictionary);
            Assert.AreEqual(expectedJson, StringWriter.ToString());
        }

        public sealed class SphericalList : List<Spherical>
        {
        }

        public sealed class UnitSphericalList : List<UnitSpherical>
        {
        }

        public sealed class DoubleList : List<double>
        {
        }

        public sealed class NearFarScalarList : List<NearFarScalar>
        {
        }

        public sealed class PositionList : List<Cartesian>
        {
        }

        public sealed class ShapeList : List<Rectangular>
        {
        }
    }
}
