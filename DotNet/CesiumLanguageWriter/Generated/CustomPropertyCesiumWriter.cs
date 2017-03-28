// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <c>CustomProperty</c> to a <see cref="CesiumOutputStream" />.  A <c>CustomProperty</c> is a custom property.
    /// </summary>
    public class CustomPropertyCesiumWriter : CesiumInterpolatablePropertyWriter<CustomPropertyCesiumWriter>
    {
        /// <summary>
        /// The name of the <c>boolean</c> property.
        /// </summary>
        public const string BooleanPropertyName = "boolean";

        /// <summary>
        /// The name of the <c>boundingRectangle</c> property.
        /// </summary>
        public const string BoundingRectanglePropertyName = "boundingRectangle";

        /// <summary>
        /// The name of the <c>cartesian</c> property.
        /// </summary>
        public const string CartesianPropertyName = "cartesian";

        /// <summary>
        /// The name of the <c>cartographicRadians</c> property.
        /// </summary>
        public const string CartographicRadiansPropertyName = "cartographicRadians";

        /// <summary>
        /// The name of the <c>cartographicDegrees</c> property.
        /// </summary>
        public const string CartographicDegreesPropertyName = "cartographicDegrees";

        /// <summary>
        /// The name of the <c>cartesian2</c> property.
        /// </summary>
        public const string Cartesian2PropertyName = "cartesian2";

        /// <summary>
        /// The name of the <c>unitCartesian</c> property.
        /// </summary>
        public const string UnitCartesianPropertyName = "unitCartesian";

        /// <summary>
        /// The name of the <c>spherical</c> property.
        /// </summary>
        public const string SphericalPropertyName = "spherical";

        /// <summary>
        /// The name of the <c>unitSpherical</c> property.
        /// </summary>
        public const string UnitSphericalPropertyName = "unitSpherical";

        /// <summary>
        /// The name of the <c>rgba</c> property.
        /// </summary>
        public const string RgbaPropertyName = "rgba";

        /// <summary>
        /// The name of the <c>rgbaf</c> property.
        /// </summary>
        public const string RgbafPropertyName = "rgbaf";

        /// <summary>
        /// The name of the <c>colorBlendMode</c> property.
        /// </summary>
        public const string ColorBlendModePropertyName = "colorBlendMode";

        /// <summary>
        /// The name of the <c>cornerType</c> property.
        /// </summary>
        public const string CornerTypePropertyName = "cornerType";

        /// <summary>
        /// The name of the <c>heightReference</c> property.
        /// </summary>
        public const string HeightReferencePropertyName = "heightReference";

        /// <summary>
        /// The name of the <c>horizontalOrigin</c> property.
        /// </summary>
        public const string HorizontalOriginPropertyName = "horizontalOrigin";

        /// <summary>
        /// The name of the <c>labelStyle</c> property.
        /// </summary>
        public const string LabelStylePropertyName = "labelStyle";

        /// <summary>
        /// The name of the <c>number</c> property.
        /// </summary>
        public const string NumberPropertyName = "number";

        /// <summary>
        /// The name of the <c>nearFarScalar</c> property.
        /// </summary>
        public const string NearFarScalarPropertyName = "nearFarScalar";

        /// <summary>
        /// The name of the <c>unitQuaternion</c> property.
        /// </summary>
        public const string UnitQuaternionPropertyName = "unitQuaternion";

        /// <summary>
        /// The name of the <c>shadowMode</c> property.
        /// </summary>
        public const string ShadowModePropertyName = "shadowMode";

        /// <summary>
        /// The name of the <c>string</c> property.
        /// </summary>
        public const string StringPropertyName = "string";

        /// <summary>
        /// The name of the <c>stripeOrientation</c> property.
        /// </summary>
        public const string StripeOrientationPropertyName = "stripeOrientation";

        /// <summary>
        /// The name of the <c>wsen</c> property.
        /// </summary>
        public const string WsenPropertyName = "wsen";

        /// <summary>
        /// The name of the <c>wsenDegrees</c> property.
        /// </summary>
        public const string WsenDegreesPropertyName = "wsenDegrees";

        /// <summary>
        /// The name of the <c>uri</c> property.
        /// </summary>
        public const string UriPropertyName = "uri";

        /// <summary>
        /// The name of the <c>verticalOrigin</c> property.
        /// </summary>
        public const string VerticalOriginPropertyName = "verticalOrigin";

        private readonly Lazy<ICesiumValuePropertyWriter<bool>> m_asBoolean;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>> m_asBoundingRectangle;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>> m_asCartesian;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicRadians;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>> m_asCartographicDegrees;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Rectangular>> m_asCartesian2;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<UnitCartesian>> m_asUnitCartesian;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Spherical>> m_asSpherical;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<UnitSpherical>> m_asUnitSpherical;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Color>> m_asRgba;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<Color>> m_asRgbaf;
        private readonly Lazy<ICesiumValuePropertyWriter<CesiumColorBlendMode>> m_asColorBlendMode;
        private readonly Lazy<ICesiumValuePropertyWriter<CesiumCornerType>> m_asCornerType;
        private readonly Lazy<ICesiumValuePropertyWriter<CesiumHeightReference>> m_asHeightReference;
        private readonly Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>> m_asHorizontalOrigin;
        private readonly Lazy<ICesiumValuePropertyWriter<CesiumLabelStyle>> m_asLabelStyle;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<double>> m_asNumber;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<NearFarScalar>> m_asNearFarScalar;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>> m_asUnitQuaternion;
        private readonly Lazy<ICesiumValuePropertyWriter<CesiumShadowMode>> m_asShadowMode;
        private readonly Lazy<ICesiumValuePropertyWriter<string>> m_asString;
        private readonly Lazy<ICesiumValuePropertyWriter<CesiumStripeOrientation>> m_asStripeOrientation;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<CartographicExtent>> m_asWsen;
        private readonly Lazy<ICesiumInterpolatableValuePropertyWriter<CartographicExtent>> m_asWsenDegrees;
        private readonly Lazy<ICesiumValuePropertyWriter<CesiumResource>> m_asUri;
        private readonly Lazy<ICesiumValuePropertyWriter<CesiumVerticalOrigin>> m_asVerticalOrigin;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public CustomPropertyCesiumWriter(string propertyName)
            : base(propertyName)
        {
            m_asBoolean = new Lazy<ICesiumValuePropertyWriter<bool>>(CreateBooleanAdaptor, false);
            m_asBoundingRectangle = new Lazy<ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(CreateBoundingRectangleAdaptor, false);
            m_asCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateCartesianAdaptor, false);
            m_asCartographicRadians = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>>(CreateCartographicRadiansAdaptor, false);
            m_asCartographicDegrees = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>>(CreateCartographicDegreesAdaptor, false);
            m_asCartesian2 = new Lazy<ICesiumInterpolatableValuePropertyWriter<Rectangular>>(CreateCartesian2Adaptor, false);
            m_asUnitCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(CreateUnitCartesianAdaptor, false);
            m_asSpherical = new Lazy<ICesiumInterpolatableValuePropertyWriter<Spherical>>(CreateSphericalAdaptor, false);
            m_asUnitSpherical = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(CreateUnitSphericalAdaptor, false);
            m_asRgba = new Lazy<ICesiumInterpolatableValuePropertyWriter<Color>>(CreateRgbaAdaptor, false);
            m_asRgbaf = new Lazy<ICesiumInterpolatableValuePropertyWriter<Color>>(CreateRgbafAdaptor, false);
            m_asColorBlendMode = new Lazy<ICesiumValuePropertyWriter<CesiumColorBlendMode>>(CreateColorBlendModeAdaptor, false);
            m_asCornerType = new Lazy<ICesiumValuePropertyWriter<CesiumCornerType>>(CreateCornerTypeAdaptor, false);
            m_asHeightReference = new Lazy<ICesiumValuePropertyWriter<CesiumHeightReference>>(CreateHeightReferenceAdaptor, false);
            m_asHorizontalOrigin = new Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(CreateHorizontalOriginAdaptor, false);
            m_asLabelStyle = new Lazy<ICesiumValuePropertyWriter<CesiumLabelStyle>>(CreateLabelStyleAdaptor, false);
            m_asNumber = new Lazy<ICesiumInterpolatableValuePropertyWriter<double>>(CreateNumberAdaptor, false);
            m_asNearFarScalar = new Lazy<ICesiumInterpolatableValuePropertyWriter<NearFarScalar>>(CreateNearFarScalarAdaptor, false);
            m_asUnitQuaternion = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(CreateUnitQuaternionAdaptor, false);
            m_asShadowMode = new Lazy<ICesiumValuePropertyWriter<CesiumShadowMode>>(CreateShadowModeAdaptor, false);
            m_asString = new Lazy<ICesiumValuePropertyWriter<string>>(CreateStringAdaptor, false);
            m_asStripeOrientation = new Lazy<ICesiumValuePropertyWriter<CesiumStripeOrientation>>(CreateStripeOrientationAdaptor, false);
            m_asWsen = new Lazy<ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(CreateWsenAdaptor, false);
            m_asWsenDegrees = new Lazy<ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(CreateWsenDegreesAdaptor, false);
            m_asUri = new Lazy<ICesiumValuePropertyWriter<CesiumResource>>(CreateUriAdaptor, false);
            m_asVerticalOrigin = new Lazy<ICesiumValuePropertyWriter<CesiumVerticalOrigin>>(CreateVerticalOriginAdaptor, false);
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected CustomPropertyCesiumWriter(CustomPropertyCesiumWriter existingInstance)
            : base(existingInstance)
        {
            m_asBoolean = new Lazy<ICesiumValuePropertyWriter<bool>>(CreateBooleanAdaptor, false);
            m_asBoundingRectangle = new Lazy<ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(CreateBoundingRectangleAdaptor, false);
            m_asCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartesian>>(CreateCartesianAdaptor, false);
            m_asCartographicRadians = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>>(CreateCartographicRadiansAdaptor, false);
            m_asCartographicDegrees = new Lazy<ICesiumInterpolatableValuePropertyWriter<Cartographic>>(CreateCartographicDegreesAdaptor, false);
            m_asCartesian2 = new Lazy<ICesiumInterpolatableValuePropertyWriter<Rectangular>>(CreateCartesian2Adaptor, false);
            m_asUnitCartesian = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitCartesian>>(CreateUnitCartesianAdaptor, false);
            m_asSpherical = new Lazy<ICesiumInterpolatableValuePropertyWriter<Spherical>>(CreateSphericalAdaptor, false);
            m_asUnitSpherical = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitSpherical>>(CreateUnitSphericalAdaptor, false);
            m_asRgba = new Lazy<ICesiumInterpolatableValuePropertyWriter<Color>>(CreateRgbaAdaptor, false);
            m_asRgbaf = new Lazy<ICesiumInterpolatableValuePropertyWriter<Color>>(CreateRgbafAdaptor, false);
            m_asColorBlendMode = new Lazy<ICesiumValuePropertyWriter<CesiumColorBlendMode>>(CreateColorBlendModeAdaptor, false);
            m_asCornerType = new Lazy<ICesiumValuePropertyWriter<CesiumCornerType>>(CreateCornerTypeAdaptor, false);
            m_asHeightReference = new Lazy<ICesiumValuePropertyWriter<CesiumHeightReference>>(CreateHeightReferenceAdaptor, false);
            m_asHorizontalOrigin = new Lazy<ICesiumValuePropertyWriter<CesiumHorizontalOrigin>>(CreateHorizontalOriginAdaptor, false);
            m_asLabelStyle = new Lazy<ICesiumValuePropertyWriter<CesiumLabelStyle>>(CreateLabelStyleAdaptor, false);
            m_asNumber = new Lazy<ICesiumInterpolatableValuePropertyWriter<double>>(CreateNumberAdaptor, false);
            m_asNearFarScalar = new Lazy<ICesiumInterpolatableValuePropertyWriter<NearFarScalar>>(CreateNearFarScalarAdaptor, false);
            m_asUnitQuaternion = new Lazy<ICesiumInterpolatableValuePropertyWriter<UnitQuaternion>>(CreateUnitQuaternionAdaptor, false);
            m_asShadowMode = new Lazy<ICesiumValuePropertyWriter<CesiumShadowMode>>(CreateShadowModeAdaptor, false);
            m_asString = new Lazy<ICesiumValuePropertyWriter<string>>(CreateStringAdaptor, false);
            m_asStripeOrientation = new Lazy<ICesiumValuePropertyWriter<CesiumStripeOrientation>>(CreateStripeOrientationAdaptor, false);
            m_asWsen = new Lazy<ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(CreateWsenAdaptor, false);
            m_asWsenDegrees = new Lazy<ICesiumInterpolatableValuePropertyWriter<CartographicExtent>>(CreateWsenDegreesAdaptor, false);
            m_asUri = new Lazy<ICesiumValuePropertyWriter<CesiumResource>>(CreateUriAdaptor, false);
            m_asVerticalOrigin = new Lazy<ICesiumValuePropertyWriter<CesiumVerticalOrigin>>(CreateVerticalOriginAdaptor, false);
        }

        /// <inheritdoc />
        public override CustomPropertyCesiumWriter Clone()
        {
            return new CustomPropertyCesiumWriter(this);
        }

        /// <summary>
        /// Writes the value expressed as a <c>boolean</c>, which is the property specified as a boolean value.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteBoolean(bool value)
        {
            const string PropertyName = BooleanPropertyName;
            if (ForceInterval)
            {
                OpenIntervalIfNecessary();
            }
            if (IsInterval)
            {
                Output.WritePropertyName(PropertyName);
            }
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>boundingRectangle</c>, which is the property specified as <c>[X, Y, Width, Height]</c>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteBoundingRectangle(BoundingRectangle value)
        {
            const string PropertyName = BoundingRectanglePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteBoundingRectangle(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>boundingRectangle</c>, which is the property specified as <c>[X, Y, Width, Height]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteBoundingRectangle(IList<JulianDate> dates, IList<BoundingRectangle> values)
        {
            WriteBoundingRectangle(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>boundingRectangle</c>, which is the property specified as <c>[X, Y, Width, Height]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteBoundingRectangle(IList<JulianDate> dates, IList<BoundingRectangle> values, int startIndex, int length)
        {
            const string PropertyName = BoundingRectanglePropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteBoundingRectangle(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian</c>, which is the property specified as a three-dimensional Cartesian value <c>[X, Y, Z]</c>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteCartesian(Cartesian value)
        {
            const string PropertyName = CartesianPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian3(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian</c>, which is the property specified as a three-dimensional Cartesian value <c>[X, Y, Z]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values)
        {
            WriteCartesian(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian</c>, which is the property specified as a three-dimensional Cartesian value <c>[X, Y, Z]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteCartesian(IList<JulianDate> dates, IList<Cartesian> values, int startIndex, int length)
        {
            const string PropertyName = CartesianPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian3(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartographicRadians</c>, which is the property specified in Cartographic WGS84 coordinates, <c>[Longitude, Latitude, Height]</c>, where Longitude and Latitude are in radians.
        /// </summary>
        /// <param name="value">The interval.</param>
        public void WriteCartographicRadians(Cartographic value)
        {
            const string PropertyName = CartographicRadiansPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartographic(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartographicRadians</c>, which is the property specified in Cartographic WGS84 coordinates, <c>[Longitude, Latitude, Height]</c>, where Longitude and Latitude are in radians.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartographicRadians(IList<JulianDate> dates, IList<Cartographic> values)
        {
            WriteCartographicRadians(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartographicRadians</c>, which is the property specified in Cartographic WGS84 coordinates, <c>[Longitude, Latitude, Height]</c>, where Longitude and Latitude are in radians.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The position corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteCartographicRadians(IList<JulianDate> dates, IList<Cartographic> values, int startIndex, int length)
        {
            const string PropertyName = CartographicRadiansPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartographic(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartographicDegrees</c>, which is the property specified in Cartographic WGS84 coordinates, <c>[Longitude, Latitude, Height]</c>, where Longitude and Latitude are in degrees.
        /// </summary>
        /// <param name="value">The interval.</param>
        public void WriteCartographicDegrees(Cartographic value)
        {
            const string PropertyName = CartographicDegreesPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartographic(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartographicDegrees</c>, which is the property specified in Cartographic WGS84 coordinates, <c>[Longitude, Latitude, Height]</c>, where Longitude and Latitude are in degrees.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartographicDegrees(IList<JulianDate> dates, IList<Cartographic> values)
        {
            WriteCartographicDegrees(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartographicDegrees</c>, which is the property specified in Cartographic WGS84 coordinates, <c>[Longitude, Latitude, Height]</c>, where Longitude and Latitude are in degrees.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The position corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteCartographicDegrees(IList<JulianDate> dates, IList<Cartographic> values, int startIndex, int length)
        {
            const string PropertyName = CartographicDegreesPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartographic(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian2</c>, which is the property specified as a two-dimensional Cartesian value <c>[X, Y]</c>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteCartesian2(Rectangular value)
        {
            const string PropertyName = Cartesian2PropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartesian2(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian2</c>, which is the property specified as a two-dimensional Cartesian value <c>[X, Y]</c>.
        /// </summary>
        /// <param name="x">The X component.</param>
        /// <param name="y">The Y component.</param>
        public void WriteCartesian2(double x, double y)
        {
            WriteCartesian2(new Rectangular(x, y));
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian2</c>, which is the property specified as a two-dimensional Cartesian value <c>[X, Y]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteCartesian2(IList<JulianDate> dates, IList<Rectangular> values)
        {
            WriteCartesian2(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>cartesian2</c>, which is the property specified as a two-dimensional Cartesian value <c>[X, Y]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteCartesian2(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
        {
            const string PropertyName = Cartesian2PropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartesian2(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitCartesian</c>, which is the property specified as a three-dimensional unit magnitude Cartesian value <c>[X, Y, Z]</c>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteUnitCartesian(UnitCartesian value)
        {
            const string PropertyName = UnitCartesianPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteUnitCartesian3(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitCartesian</c>, which is the property specified as a three-dimensional unit magnitude Cartesian value <c>[X, Y, Z]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteUnitCartesian(IList<JulianDate> dates, IList<UnitCartesian> values)
        {
            WriteUnitCartesian(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitCartesian</c>, which is the property specified as a three-dimensional unit magnitude Cartesian value <c>[X, Y, Z]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteUnitCartesian(IList<JulianDate> dates, IList<UnitCartesian> values, int startIndex, int length)
        {
            const string PropertyName = UnitCartesianPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteUnitCartesian3(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>spherical</c>, which is the property specified as a spherical value <c>[Clock, Cone, Magnitude]</c>.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteSpherical(Spherical value)
        {
            const string PropertyName = SphericalPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteSpherical(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>spherical</c>, which is the property specified as a spherical value <c>[Clock, Cone, Magnitude]</c>.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteSpherical(IList<JulianDate> dates, IList<Spherical> values)
        {
            WriteSpherical(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>spherical</c>, which is the property specified as a spherical value <c>[Clock, Cone, Magnitude]</c>.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteSpherical(IList<JulianDate> dates, IList<Spherical> values, int startIndex, int length)
        {
            const string PropertyName = SphericalPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteSpherical(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitSpherical</c>, which is the property specified as a unit spherical value <c>[Clock, Cone]</c>.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteUnitSpherical(UnitSpherical value)
        {
            const string PropertyName = UnitSphericalPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteUnitSpherical(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitSpherical</c>, which is the property specified as a unit spherical value <c>[Clock, Cone]</c>.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteUnitSpherical(IList<JulianDate> dates, IList<UnitSpherical> values)
        {
            WriteUnitSpherical(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitSpherical</c>, which is the property specified as a unit spherical value <c>[Clock, Cone]</c>.  The clock angle is measured in the XY plane from the positive X axis toward the positive Y axis.  The cone angle is the angle from the positive Z axis toward the negative Z axis.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteUnitSpherical(IList<JulianDate> dates, IList<UnitSpherical> values, int startIndex, int length)
        {
            const string PropertyName = UnitSphericalPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteUnitSpherical(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>rgba</c>, which is the property specified as an array of color components <c>[Red, Green, Blue, Alpha]</c> where each component is an integer in the range 0-255.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteRgba(Color color)
        {
            const string PropertyName = RgbaPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteRgba(Output, color);
        }

        /// <summary>
        /// Writes the value expressed as a <c>rgba</c>, which is the property specified as an array of color components <c>[Red, Green, Blue, Alpha]</c> where each component is an integer in the range 0-255.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteRgba(int red, int green, int blue, int alpha)
        {
            const string PropertyName = RgbaPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteRgba(Output, red, green, blue, alpha);
        }

        /// <summary>
        /// Writes the value expressed as a <c>rgba</c>, which is the property specified as an array of color components <c>[Red, Green, Blue, Alpha]</c> where each component is an integer in the range 0-255.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteRgba(IList<JulianDate> dates, IList<Color> values)
        {
            WriteRgba(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>rgba</c>, which is the property specified as an array of color components <c>[Red, Green, Blue, Alpha]</c> where each component is an integer in the range 0-255.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteRgba(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            const string PropertyName = RgbaPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteRgba(Output, PropertyName, dates, colors, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>rgbaf</c>, which is the property specified as an array of color components <c>[Red, Green, Blue, Alpha]</c> where each component is a double in the range 0.0-1.0.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteRgbaf(Color color)
        {
            const string PropertyName = RgbafPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteRgbaf(Output, color);
        }

        /// <summary>
        /// Writes the value expressed as a <c>rgbaf</c>, which is the property specified as an array of color components <c>[Red, Green, Blue, Alpha]</c> where each component is a double in the range 0.0-1.0.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteRgbaf(float red, float green, float blue, float alpha)
        {
            const string PropertyName = RgbafPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteRgbaf(Output, red, green, blue, alpha);
        }

        /// <summary>
        /// Writes the value expressed as a <c>rgbaf</c>, which is the property specified as an array of color components <c>[Red, Green, Blue, Alpha]</c> where each component is a double in the range 0.0-1.0.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteRgbaf(IList<JulianDate> dates, IList<Color> values)
        {
            WriteRgbaf(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>rgbaf</c>, which is the property specified as an array of color components <c>[Red, Green, Blue, Alpha]</c> where each component is a double in the range 0.0-1.0.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteRgbaf(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            const string PropertyName = RgbafPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteRgbaf(Output, PropertyName, dates, colors, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>colorBlendMode</c>, which is the property specified as a color blend mode.
        /// </summary>
        /// <param name="value">The blend mode.</param>
        public void WriteColorBlendMode(CesiumColorBlendMode value)
        {
            const string PropertyName = ColorBlendModePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.ColorBlendModeToString(value));
        }

        /// <summary>
        /// Writes the value expressed as a <c>cornerType</c>, which is the property specified as a corner style.
        /// </summary>
        /// <param name="value">The style of a corner.</param>
        public void WriteCornerType(CesiumCornerType value)
        {
            const string PropertyName = CornerTypePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.CornerTypeToString(value));
        }

        /// <summary>
        /// Writes the value expressed as a <c>heightReference</c>, which is the property specified as a height reference.
        /// </summary>
        /// <param name="value">The height reference.</param>
        public void WriteHeightReference(CesiumHeightReference value)
        {
            const string PropertyName = HeightReferencePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.HeightReferenceToString(value));
        }

        /// <summary>
        /// Writes the value expressed as a <c>horizontalOrigin</c>, which is the property specified as a horizontal origin.
        /// </summary>
        /// <param name="value">The horizontal origin.</param>
        public void WriteHorizontalOrigin(CesiumHorizontalOrigin value)
        {
            const string PropertyName = HorizontalOriginPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.HorizontalOriginToString(value));
        }

        /// <summary>
        /// Writes the value expressed as a <c>labelStyle</c>, which is the property specified as a label style.
        /// </summary>
        /// <param name="value">The label style.</param>
        public void WriteLabelStyle(CesiumLabelStyle value)
        {
            const string PropertyName = LabelStylePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.LabelStyleToString(value));
        }

        /// <summary>
        /// Writes the value expressed as a <c>number</c>, which is the property specified as a number.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteNumber(double value)
        {
            const string PropertyName = NumberPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>number</c>, which is the property specified as a number.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteNumber(IList<JulianDate> dates, IList<double> values)
        {
            WriteNumber(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>number</c>, which is the property specified as a number.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteNumber(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            const string PropertyName = NumberPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteDouble(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>nearFarScalar</c>, which is the property specified as four values <c>[NearDistance, NearValue, FarDistance, FarValue]</c>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteNearFarScalar(NearFarScalar value)
        {
            const string PropertyName = NearFarScalarPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteNearFarScalar(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>nearFarScalar</c>, which is the property specified as four values <c>[NearDistance, NearValue, FarDistance, FarValue]</c>.
        /// </summary>
        /// <param name="nearDistance">The lower bound of the camera distance range.</param>
        /// <param name="nearValue">The value to use at the lower bound of the camera distance range.</param>
        /// <param name="farDistance">The upper bound of the camera distance range.</param>
        /// <param name="farValue">The value to use at the upper bound of the camera distance range.</param>
        public void WriteNearFarScalar(double nearDistance, double nearValue, double farDistance, double farValue)
        {
            WriteNearFarScalar(new NearFarScalar(nearDistance, nearValue, farDistance, farValue));
        }

        /// <summary>
        /// Writes the value expressed as a <c>nearFarScalar</c>, which is the property specified as four values <c>[NearDistance, NearValue, FarDistance, FarValue]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteNearFarScalar(IList<JulianDate> dates, IList<NearFarScalar> values)
        {
            WriteNearFarScalar(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>nearFarScalar</c>, which is the property specified as four values <c>[NearDistance, NearValue, FarDistance, FarValue]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteNearFarScalar(IList<JulianDate> dates, IList<NearFarScalar> values, int startIndex, int length)
        {
            const string PropertyName = NearFarScalarPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteNearFarScalar(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitQuaternion</c>, which is the property specified as a 4-dimensional unit magnitude quaternion, specified as <c>[X, Y, Z, W]</c>.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteUnitQuaternion(UnitQuaternion value)
        {
            const string PropertyName = UnitQuaternionPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteUnitQuaternion(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitQuaternion</c>, which is the property specified as a 4-dimensional unit magnitude quaternion, specified as <c>[X, Y, Z, W]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteUnitQuaternion(IList<JulianDate> dates, IList<UnitQuaternion> values)
        {
            WriteUnitQuaternion(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>unitQuaternion</c>, which is the property specified as a 4-dimensional unit magnitude quaternion, specified as <c>[X, Y, Z, W]</c>.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteUnitQuaternion(IList<JulianDate> dates, IList<UnitQuaternion> values, int startIndex, int length)
        {
            const string PropertyName = UnitQuaternionPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteUnitQuaternion(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>shadowMode</c>, which is the property specified as a shadow mode.
        /// </summary>
        /// <param name="value">The shadow mode.</param>
        public void WriteShadowMode(CesiumShadowMode value)
        {
            const string PropertyName = ShadowModePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.ShadowModeToString(value));
        }

        /// <summary>
        /// Writes the value expressed as a <c>string</c>, which is the property specified as a string.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteString(string value)
        {
            const string PropertyName = StringPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>stripeOrientation</c>, which is the property specified as an orientation of stripes in the stripe material.
        /// </summary>
        /// <param name="value">The orientation.</param>
        public void WriteStripeOrientation(CesiumStripeOrientation value)
        {
            const string PropertyName = StripeOrientationPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.StripeOrientationToString(value));
        }

        /// <summary>
        /// Writes the value expressed as a <c>wsen</c>, which is the property specified as a Cartographic rectangle <c>[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]</c>, with values in radians.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteWsen(CartographicExtent value)
        {
            const string PropertyName = WsenPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartographicExtent(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>wsen</c>, which is the property specified as a Cartographic rectangle <c>[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]</c>, with values in radians.
        /// </summary>
        /// <param name="west">The westernmost longitude.</param>
        /// <param name="south">The southernmost latitude.</param>
        /// <param name="east">The easternmost longitude.</param>
        /// <param name="north">The northernmost latitude.</param>
        public void WriteWsen(double west, double south, double east, double north)
        {
            WriteWsen(new CartographicExtent(west, south, east, north));
        }

        /// <summary>
        /// Writes the value expressed as a <c>wsen</c>, which is the property specified as a Cartographic rectangle <c>[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]</c>, with values in radians.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteWsen(IList<JulianDate> dates, IList<CartographicExtent> values)
        {
            WriteWsen(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>wsen</c>, which is the property specified as a Cartographic rectangle <c>[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]</c>, with values in radians.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteWsen(IList<JulianDate> dates, IList<CartographicExtent> values, int startIndex, int length)
        {
            const string PropertyName = WsenPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartographicExtent(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>wsenDegrees</c>, which is the property specified as a Cartographic rectangle <c>[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]</c>, with values in degrees.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteWsenDegrees(CartographicExtent value)
        {
            const string PropertyName = WsenDegreesPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            CesiumWritingHelper.WriteCartographicExtent(Output, value);
        }

        /// <summary>
        /// Writes the value expressed as a <c>wsenDegrees</c>, which is the property specified as a Cartographic rectangle <c>[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]</c>, with values in degrees.
        /// </summary>
        /// <param name="west">The westernmost longitude.</param>
        /// <param name="south">The southernmost latitude.</param>
        /// <param name="east">The easternmost longitude.</param>
        /// <param name="north">The northernmost latitude.</param>
        public void WriteWsenDegrees(double west, double south, double east, double north)
        {
            WriteWsenDegrees(new CartographicExtent(west, south, east, north));
        }

        /// <summary>
        /// Writes the value expressed as a <c>wsenDegrees</c>, which is the property specified as a Cartographic rectangle <c>[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]</c>, with values in degrees.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WriteWsenDegrees(IList<JulianDate> dates, IList<CartographicExtent> values)
        {
            WriteWsenDegrees(dates, values, 0, dates.Count);
        }

        /// <summary>
        /// Writes the value expressed as a <c>wsenDegrees</c>, which is the property specified as a Cartographic rectangle <c>[WestLongitude, SouthLatitude, EastLongitude, NorthLatitude]</c>, with values in degrees.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to write.</param>
        /// <param name="length">The number of elements to write.</param>
        public void WriteWsenDegrees(IList<JulianDate> dates, IList<CartographicExtent> values, int startIndex, int length)
        {
            const string PropertyName = WsenDegreesPropertyName;
            OpenIntervalIfNecessary();
            CesiumWritingHelper.WriteCartographicExtent(Output, PropertyName, dates, values, startIndex, length);
        }

        /// <summary>
        /// Writes the value expressed as a <c>uri</c>, which is the property specified as a URI.
        /// </summary>
        /// <param name="resource">A resource object describing external data.</param>
        public void WriteUri(CesiumResource resource)
        {
            WriteUri(resource.Uri, resource.Behavior);
        }

        /// <summary>
        /// Writes the value expressed as a <c>uri</c>, which is the property specified as a URI.
        /// </summary>
        /// <param name="uri">The URI of the data.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.</param>
        public void WriteUri(Uri uri, CesiumResourceBehavior resourceBehavior)
        {
            WriteUri(uri.ToString(), resourceBehavior);
        }

        /// <summary>
        /// Writes the value expressed as a <c>uri</c>, which is the property specified as a URI.
        /// </summary>
        /// <param name="uri">The URI of the data.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the URI in the document. For even more control, use the overload that takes a ICesiumUriResolver.</param>
        public void WriteUri(string uri, CesiumResourceBehavior resourceBehavior)
        {
            const string PropertyName = UriPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.GetResourceUri(uri, resourceBehavior));
        }

        /// <summary>
        /// Writes the value expressed as a <c>uri</c>, which is the property specified as a URI.
        /// </summary>
        /// <param name="uri">The URI of the data.  The provided ICesiumUriResolver will be used to build the final URI embedded in the document.</param>
        /// <param name="resolver">An ICesiumUriResolver used to build the final URI that will be embedded in the document.</param>
        public void WriteUri(Uri uri, ICesiumUriResolver resolver)
        {
            WriteUri(uri.ToString(), resolver);
        }

        /// <summary>
        /// Writes the value expressed as a <c>uri</c>, which is the property specified as a URI.
        /// </summary>
        /// <param name="uri">The URI of the data.  The provided ICesiumUriResolver will be used to build the final URI embedded in the document.</param>
        /// <param name="resolver">An ICesiumUriResolver used to build the final URI that will be embedded in the document.</param>
        public void WriteUri(string uri, ICesiumUriResolver resolver)
        {
            const string PropertyName = UriPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(resolver.ResolveUri(uri));
        }

        /// <summary>
        /// Writes the value expressed as a <c>uri</c>, which is the property specified as a URI.
        /// </summary>
        /// <param name="image">The image.  A data URI will be created for this image, using PNG encoding.</param>
        public void WriteUri(Image image)
        {
            WriteUri(image, CesiumImageFormat.Png);
        }

        /// <summary>
        /// Writes the value expressed as a <c>uri</c>, which is the property specified as a URI.
        /// </summary>
        /// <param name="image">The image.  A data URI will be created for this image.</param>
        /// <param name="imageFormat">The image format to use to encode the image in the data URI.</param>
        public void WriteUri(Image image, CesiumImageFormat imageFormat)
        {
            const string PropertyName = UriPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.ImageToDataUri(image, imageFormat));
        }

        /// <summary>
        /// Writes the value expressed as a <c>verticalOrigin</c>, which is the property specified as a vertical origin.
        /// </summary>
        /// <param name="value">The vertical origin.</param>
        public void WriteVerticalOrigin(CesiumVerticalOrigin value)
        {
            const string PropertyName = VerticalOriginPropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(CesiumFormattingHelper.VerticalOriginToString(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>Boolean</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<bool> AsBoolean()
        {
            return m_asBoolean.Value;
        }

        private ICesiumValuePropertyWriter<bool> CreateBooleanAdaptor()
        {
            return new CesiumWriterAdaptor<CustomPropertyCesiumWriter, bool>(this, (me, value) => me.WriteBoolean(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>BoundingRectangle</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> AsBoundingRectangle()
        {
            return m_asBoundingRectangle.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> CreateBoundingRectangleAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, BoundingRectangle>(this, (me, value) => me.WriteBoundingRectangle(value), (me, dates, values, startIndex, length) => me.WriteBoundingRectangle(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>Cartesian</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Cartesian> AsCartesian()
        {
            return m_asCartesian.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Cartesian> CreateCartesianAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, Cartesian>(this, (me, value) => me.WriteCartesian(value), (me, dates, values, startIndex, length) => me.WriteCartesian(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>CartographicRadians</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Cartographic> AsCartographicRadians()
        {
            return m_asCartographicRadians.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Cartographic> CreateCartographicRadiansAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, Cartographic>(this, (me, value) => me.WriteCartographicRadians(value), (me, dates, values, startIndex, length) => me.WriteCartographicRadians(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>CartographicDegrees</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Cartographic> AsCartographicDegrees()
        {
            return m_asCartographicDegrees.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Cartographic> CreateCartographicDegreesAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, Cartographic>(this, (me, value) => me.WriteCartographicDegrees(value), (me, dates, values, startIndex, length) => me.WriteCartographicDegrees(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>Cartesian2</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Rectangular> AsCartesian2()
        {
            return m_asCartesian2.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Rectangular> CreateCartesian2Adaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, Rectangular>(this, (me, value) => me.WriteCartesian2(value), (me, dates, values, startIndex, length) => me.WriteCartesian2(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>UnitCartesian</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<UnitCartesian> AsUnitCartesian()
        {
            return m_asUnitCartesian.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<UnitCartesian> CreateUnitCartesianAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, UnitCartesian>(this, (me, value) => me.WriteUnitCartesian(value), (me, dates, values, startIndex, length) => me.WriteUnitCartesian(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>Spherical</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Spherical> AsSpherical()
        {
            return m_asSpherical.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Spherical> CreateSphericalAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, Spherical>(this, (me, value) => me.WriteSpherical(value), (me, dates, values, startIndex, length) => me.WriteSpherical(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>UnitSpherical</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<UnitSpherical> AsUnitSpherical()
        {
            return m_asUnitSpherical.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<UnitSpherical> CreateUnitSphericalAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, UnitSpherical>(this, (me, value) => me.WriteUnitSpherical(value), (me, dates, values, startIndex, length) => me.WriteUnitSpherical(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>Rgba</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Color> AsRgba()
        {
            return m_asRgba.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Color> CreateRgbaAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, Color>(this, (me, value) => me.WriteRgba(value), (me, dates, values, startIndex, length) => me.WriteRgba(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>Rgbaf</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<Color> AsRgbaf()
        {
            return m_asRgbaf.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<Color> CreateRgbafAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, Color>(this, (me, value) => me.WriteRgbaf(value), (me, dates, values, startIndex, length) => me.WriteRgbaf(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>ColorBlendMode</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumColorBlendMode> AsColorBlendMode()
        {
            return m_asColorBlendMode.Value;
        }

        private ICesiumValuePropertyWriter<CesiumColorBlendMode> CreateColorBlendModeAdaptor()
        {
            return new CesiumWriterAdaptor<CustomPropertyCesiumWriter, CesiumColorBlendMode>(this, (me, value) => me.WriteColorBlendMode(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>CornerType</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumCornerType> AsCornerType()
        {
            return m_asCornerType.Value;
        }

        private ICesiumValuePropertyWriter<CesiumCornerType> CreateCornerTypeAdaptor()
        {
            return new CesiumWriterAdaptor<CustomPropertyCesiumWriter, CesiumCornerType>(this, (me, value) => me.WriteCornerType(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>HeightReference</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumHeightReference> AsHeightReference()
        {
            return m_asHeightReference.Value;
        }

        private ICesiumValuePropertyWriter<CesiumHeightReference> CreateHeightReferenceAdaptor()
        {
            return new CesiumWriterAdaptor<CustomPropertyCesiumWriter, CesiumHeightReference>(this, (me, value) => me.WriteHeightReference(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>HorizontalOrigin</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumHorizontalOrigin> AsHorizontalOrigin()
        {
            return m_asHorizontalOrigin.Value;
        }

        private ICesiumValuePropertyWriter<CesiumHorizontalOrigin> CreateHorizontalOriginAdaptor()
        {
            return new CesiumWriterAdaptor<CustomPropertyCesiumWriter, CesiumHorizontalOrigin>(this, (me, value) => me.WriteHorizontalOrigin(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>LabelStyle</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumLabelStyle> AsLabelStyle()
        {
            return m_asLabelStyle.Value;
        }

        private ICesiumValuePropertyWriter<CesiumLabelStyle> CreateLabelStyleAdaptor()
        {
            return new CesiumWriterAdaptor<CustomPropertyCesiumWriter, CesiumLabelStyle>(this, (me, value) => me.WriteLabelStyle(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>Number</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<double> AsNumber()
        {
            return m_asNumber.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<double> CreateNumberAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, double>(this, (me, value) => me.WriteNumber(value), (me, dates, values, startIndex, length) => me.WriteNumber(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>NearFarScalar</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<NearFarScalar> AsNearFarScalar()
        {
            return m_asNearFarScalar.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<NearFarScalar> CreateNearFarScalarAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, NearFarScalar>(this, (me, value) => me.WriteNearFarScalar(value), (me, dates, values, startIndex, length) => me.WriteNearFarScalar(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>UnitQuaternion</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> AsUnitQuaternion()
        {
            return m_asUnitQuaternion.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<UnitQuaternion> CreateUnitQuaternionAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, UnitQuaternion>(this, (me, value) => me.WriteUnitQuaternion(value), (me, dates, values, startIndex, length) => me.WriteUnitQuaternion(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>ShadowMode</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumShadowMode> AsShadowMode()
        {
            return m_asShadowMode.Value;
        }

        private ICesiumValuePropertyWriter<CesiumShadowMode> CreateShadowModeAdaptor()
        {
            return new CesiumWriterAdaptor<CustomPropertyCesiumWriter, CesiumShadowMode>(this, (me, value) => me.WriteShadowMode(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>String</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<string> AsString()
        {
            return m_asString.Value;
        }

        private ICesiumValuePropertyWriter<string> CreateStringAdaptor()
        {
            return new CesiumWriterAdaptor<CustomPropertyCesiumWriter, string>(this, (me, value) => me.WriteString(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>StripeOrientation</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumStripeOrientation> AsStripeOrientation()
        {
            return m_asStripeOrientation.Value;
        }

        private ICesiumValuePropertyWriter<CesiumStripeOrientation> CreateStripeOrientationAdaptor()
        {
            return new CesiumWriterAdaptor<CustomPropertyCesiumWriter, CesiumStripeOrientation>(this, (me, value) => me.WriteStripeOrientation(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>Wsen</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<CartographicExtent> AsWsen()
        {
            return m_asWsen.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<CartographicExtent> CreateWsenAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, CartographicExtent>(this, (me, value) => me.WriteWsen(value), (me, dates, values, startIndex, length) => me.WriteWsen(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumInterpolatableValuePropertyWriter{T}" /> to write a value in <c>WsenDegrees</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumInterpolatableValuePropertyWriter<CartographicExtent> AsWsenDegrees()
        {
            return m_asWsenDegrees.Value;
        }

        private ICesiumInterpolatableValuePropertyWriter<CartographicExtent> CreateWsenDegreesAdaptor()
        {
            return new CesiumInterpolatableWriterAdaptor<CustomPropertyCesiumWriter, CartographicExtent>(this, (me, value) => me.WriteWsenDegrees(value), (me, dates, values, startIndex, length) => me.WriteWsenDegrees(dates, values, startIndex, length));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>Uri</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumResource> AsUri()
        {
            return m_asUri.Value;
        }

        private ICesiumValuePropertyWriter<CesiumResource> CreateUriAdaptor()
        {
            return new CesiumWriterAdaptor<CustomPropertyCesiumWriter, CesiumResource>(this, (me, value) => me.WriteUri(value));
        }

        /// <summary>
        /// Returns a wrapper for this instance that implements <see cref="ICesiumValuePropertyWriter{T}" /> to write a value in <c>VerticalOrigin</c> format.  Because the returned instance is a wrapper for this instance, you may call <see cref="ICesiumElementWriter.Close" /> on either this instance or the wrapper, but you must not call it on both.
        /// </summary>
        /// <returns>The wrapper.</returns>
        public ICesiumValuePropertyWriter<CesiumVerticalOrigin> AsVerticalOrigin()
        {
            return m_asVerticalOrigin.Value;
        }

        private ICesiumValuePropertyWriter<CesiumVerticalOrigin> CreateVerticalOriginAdaptor()
        {
            return new CesiumWriterAdaptor<CustomPropertyCesiumWriter, CesiumVerticalOrigin>(this, (me, value) => me.WriteVerticalOrigin(value));
        }

    }
}
