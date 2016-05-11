// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>CustomPatternSensor</code> to a <see cref="CesiumOutputStream" />.  A <code>CustomPatternSensor</code> a custom sensor volume taking into account occlusion of an ellipsoid, i.e., the globe.
    /// </summary>
    public class CustomPatternSensorCesiumWriter : CesiumPropertyWriter<CustomPatternSensorCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>directions</code> property.
        /// </summary>
        public const string DirectionsPropertyName = "directions";

        /// <summary>
        /// The name of the <code>radius</code> property.
        /// </summary>
        public const string RadiusPropertyName = "radius";

        /// <summary>
        /// The name of the <code>showIntersection</code> property.
        /// </summary>
        public const string ShowIntersectionPropertyName = "showIntersection";

        /// <summary>
        /// The name of the <code>intersectionColor</code> property.
        /// </summary>
        public const string IntersectionColorPropertyName = "intersectionColor";

        /// <summary>
        /// The name of the <code>intersectionWidth</code> property.
        /// </summary>
        public const string IntersectionWidthPropertyName = "intersectionWidth";

        /// <summary>
        /// The name of the <code>showLateralSurfaces</code> property.
        /// </summary>
        public const string ShowLateralSurfacesPropertyName = "showLateralSurfaces";

        /// <summary>
        /// The name of the <code>lateralSurfaceMaterial</code> property.
        /// </summary>
        public const string LateralSurfaceMaterialPropertyName = "lateralSurfaceMaterial";

        /// <summary>
        /// The name of the <code>showEllipsoidSurfaces</code> property.
        /// </summary>
        public const string ShowEllipsoidSurfacesPropertyName = "showEllipsoidSurfaces";

        /// <summary>
        /// The name of the <code>ellipsoidSurfaceMaterial</code> property.
        /// </summary>
        public const string EllipsoidSurfaceMaterialPropertyName = "ellipsoidSurfaceMaterial";

        /// <summary>
        /// The name of the <code>showEllipsoidHorizonSurfaces</code> property.
        /// </summary>
        public const string ShowEllipsoidHorizonSurfacesPropertyName = "showEllipsoidHorizonSurfaces";

        /// <summary>
        /// The name of the <code>ellipsoidHorizonSurfaceMaterial</code> property.
        /// </summary>
        public const string EllipsoidHorizonSurfaceMaterialPropertyName = "ellipsoidHorizonSurfaceMaterial";

        /// <summary>
        /// The name of the <code>showDomeSurfaces</code> property.
        /// </summary>
        public const string ShowDomeSurfacesPropertyName = "showDomeSurfaces";

        /// <summary>
        /// The name of the <code>domeSurfaceMaterial</code> property.
        /// </summary>
        public const string DomeSurfaceMaterialPropertyName = "domeSurfaceMaterial";

        /// <summary>
        /// The name of the <code>portionToDisplay</code> property.
        /// </summary>
        public const string PortionToDisplayPropertyName = "portionToDisplay";

        /// <summary>
        /// The name of the <code>environmentConstraint</code> property.
        /// </summary>
        public const string EnvironmentConstraintPropertyName = "environmentConstraint";

        /// <summary>
        /// The name of the <code>showEnvironmentOcclusion</code> property.
        /// </summary>
        public const string ShowEnvironmentOcclusionPropertyName = "showEnvironmentOcclusion";

        /// <summary>
        /// The name of the <code>environmentOcclusionMaterial</code> property.
        /// </summary>
        public const string EnvironmentOcclusionMaterialPropertyName = "environmentOcclusionMaterial";

        /// <summary>
        /// The name of the <code>showEnvironmentIntersection</code> property.
        /// </summary>
        public const string ShowEnvironmentIntersectionPropertyName = "showEnvironmentIntersection";

        /// <summary>
        /// The name of the <code>environmentIntersectionColor</code> property.
        /// </summary>
        public const string EnvironmentIntersectionColorPropertyName = "environmentIntersectionColor";

        /// <summary>
        /// The name of the <code>environmentIntersectionWidth</code> property.
        /// </summary>
        public const string EnvironmentIntersectionWidthPropertyName = "environmentIntersectionWidth";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<DirectionListCesiumWriter> m_directions = new Lazy<DirectionListCesiumWriter>(() => new DirectionListCesiumWriter(DirectionsPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_radius = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(RadiusPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_showIntersection = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowIntersectionPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_intersectionColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(IntersectionColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_intersectionWidth = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(IntersectionWidthPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_showLateralSurfaces = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowLateralSurfacesPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_lateralSurfaceMaterial = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(LateralSurfaceMaterialPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_showEllipsoidSurfaces = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowEllipsoidSurfacesPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_ellipsoidSurfaceMaterial = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(EllipsoidSurfaceMaterialPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_showEllipsoidHorizonSurfaces = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowEllipsoidHorizonSurfacesPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_ellipsoidHorizonSurfaceMaterial = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(EllipsoidHorizonSurfaceMaterialPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_showDomeSurfaces = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowDomeSurfacesPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_domeSurfaceMaterial = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(DomeSurfaceMaterialPropertyName), false);
        private readonly Lazy<SensorVolumePortionToDisplayCesiumWriter> m_portionToDisplay = new Lazy<SensorVolumePortionToDisplayCesiumWriter>(() => new SensorVolumePortionToDisplayCesiumWriter(PortionToDisplayPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_environmentConstraint = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(EnvironmentConstraintPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_showEnvironmentOcclusion = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowEnvironmentOcclusionPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_environmentOcclusionMaterial = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(EnvironmentOcclusionMaterialPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_showEnvironmentIntersection = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowEnvironmentIntersectionPropertyName), false);
        private readonly Lazy<ColorCesiumWriter> m_environmentIntersectionColor = new Lazy<ColorCesiumWriter>(() => new ColorCesiumWriter(EnvironmentIntersectionColorPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_environmentIntersectionWidth = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(EnvironmentIntersectionWidthPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public CustomPatternSensorCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected CustomPatternSensorCesiumWriter(CustomPatternSensorCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override CustomPatternSensorCesiumWriter Clone()
        {
            return new CustomPatternSensorCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the entire custom sensor is shown.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the entire custom sensor is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the entire custom sensor is shown.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowProperty(bool value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the entire custom sensor is shown.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteShowPropertyReference(Reference value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the entire custom sensor is shown.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteShowPropertyReference(string value)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the entire custom sensor is shown.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteShowPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the entire custom sensor is shown.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteShowPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenShowProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>directions</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>directions</code> property defines the list of directions defining the custom sensor.
        /// </summary>
        public DirectionListCesiumWriter DirectionsWriter
        {
            get { return m_directions.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>directions</code> property.  The <code>directions</code> property defines the list of directions defining the custom sensor.
        /// </summary>
        public DirectionListCesiumWriter OpenDirectionsProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(DirectionsWriter);
        }

        /// <summary>
        /// Writes a value for the <code>directions</code> property as a <code>spherical</code> value.  The <code>directions</code> property specifies the list of directions defining the custom sensor.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteDirectionsProperty(IEnumerable<Spherical> values)
        {
            using (var writer = OpenDirectionsProperty())
            {
                writer.WriteSpherical(values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>directions</code> property as a <code>unitSpherical</code> value.  The <code>directions</code> property specifies the list of directions defining the custom sensor.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteDirectionsPropertyUnitSpherical(IEnumerable<UnitSpherical> values)
        {
            using (var writer = OpenDirectionsProperty())
            {
                writer.WriteUnitSpherical(values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>directions</code> property as a <code>cartesian</code> value.  The <code>directions</code> property specifies the list of directions defining the custom sensor.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteDirectionsPropertyCartesian(IEnumerable<Cartesian> values)
        {
            using (var writer = OpenDirectionsProperty())
            {
                writer.WriteCartesian(values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>directions</code> property as a <code>unitCartesian</code> value.  The <code>directions</code> property specifies the list of directions defining the custom sensor.
        /// </summary>
        /// <param name="values">The values.</param>
        public void WriteDirectionsPropertyUnitCartesian(IEnumerable<UnitCartesian> values)
        {
            using (var writer = OpenDirectionsProperty())
            {
                writer.WriteUnitCartesian(values);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>radius</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>radius</code> property defines the radial limit of the sensor.
        /// </summary>
        public DoubleCesiumWriter RadiusWriter
        {
            get { return m_radius.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>radius</code> property.  The <code>radius</code> property defines the radial limit of the sensor.
        /// </summary>
        public DoubleCesiumWriter OpenRadiusProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RadiusWriter);
        }

        /// <summary>
        /// Writes a value for the <code>radius</code> property as a <code>number</code> value.  The <code>radius</code> property specifies the radial limit of the sensor.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteRadiusProperty(double value)
        {
            using (var writer = OpenRadiusProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>radius</code> property as a <code>number</code> value.  The <code>radius</code> property specifies the radial limit of the sensor.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteRadiusProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenRadiusProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>radius</code> property as a <code>reference</code> value.  The <code>radius</code> property specifies the radial limit of the sensor.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteRadiusPropertyReference(Reference value)
        {
            using (var writer = OpenRadiusProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>radius</code> property as a <code>reference</code> value.  The <code>radius</code> property specifies the radial limit of the sensor.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteRadiusPropertyReference(string value)
        {
            using (var writer = OpenRadiusProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>radius</code> property as a <code>reference</code> value.  The <code>radius</code> property specifies the radial limit of the sensor.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteRadiusPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenRadiusProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>radius</code> property as a <code>reference</code> value.  The <code>radius</code> property specifies the radial limit of the sensor.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteRadiusPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenRadiusProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>showIntersection</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>showIntersection</code> property defines whether or not the intersection of the sensor with the Earth is shown.
        /// </summary>
        public BooleanCesiumWriter ShowIntersectionWriter
        {
            get { return m_showIntersection.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>showIntersection</code> property.  The <code>showIntersection</code> property defines whether or not the intersection of the sensor with the Earth is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowIntersectionProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowIntersectionWriter);
        }

        /// <summary>
        /// Writes a value for the <code>showIntersection</code> property as a <code>boolean</code> value.  The <code>showIntersection</code> property specifies whether or not the intersection of the sensor with the Earth is shown.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowIntersectionProperty(bool value)
        {
            using (var writer = OpenShowIntersectionProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showIntersection</code> property as a <code>reference</code> value.  The <code>showIntersection</code> property specifies whether or not the intersection of the sensor with the Earth is shown.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteShowIntersectionPropertyReference(Reference value)
        {
            using (var writer = OpenShowIntersectionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showIntersection</code> property as a <code>reference</code> value.  The <code>showIntersection</code> property specifies whether or not the intersection of the sensor with the Earth is shown.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteShowIntersectionPropertyReference(string value)
        {
            using (var writer = OpenShowIntersectionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showIntersection</code> property as a <code>reference</code> value.  The <code>showIntersection</code> property specifies whether or not the intersection of the sensor with the Earth is shown.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteShowIntersectionPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenShowIntersectionProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showIntersection</code> property as a <code>reference</code> value.  The <code>showIntersection</code> property specifies whether or not the intersection of the sensor with the Earth is shown.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteShowIntersectionPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenShowIntersectionProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>intersectionColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>intersectionColor</code> property defines the color of the intersection of the sensor with the Earth.
        /// </summary>
        public ColorCesiumWriter IntersectionColorWriter
        {
            get { return m_intersectionColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>intersectionColor</code> property.  The <code>intersectionColor</code> property defines the color of the intersection of the sensor with the Earth.
        /// </summary>
        public ColorCesiumWriter OpenIntersectionColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(IntersectionColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>intersectionColor</code> property as a <code>rgba</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the sensor with the Earth.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteIntersectionColorProperty(Color color)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionColor</code> property as a <code>rgba</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the sensor with the Earth.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteIntersectionColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionColor</code> property as a <code>rgba</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the sensor with the Earth.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteIntersectionColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionColor</code> property as a <code>rgbaf</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the sensor with the Earth.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteIntersectionColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionColor</code> property as a <code>reference</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the sensor with the Earth.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteIntersectionColorPropertyReference(Reference value)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionColor</code> property as a <code>reference</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the sensor with the Earth.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteIntersectionColorPropertyReference(string value)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionColor</code> property as a <code>reference</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the sensor with the Earth.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteIntersectionColorPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionColor</code> property as a <code>reference</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the sensor with the Earth.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteIntersectionColorPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenIntersectionColorProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>intersectionWidth</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>intersectionWidth</code> property defines the width of the intersection in pixels.
        /// </summary>
        public DoubleCesiumWriter IntersectionWidthWriter
        {
            get { return m_intersectionWidth.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>intersectionWidth</code> property.  The <code>intersectionWidth</code> property defines the width of the intersection in pixels.
        /// </summary>
        public DoubleCesiumWriter OpenIntersectionWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(IntersectionWidthWriter);
        }

        /// <summary>
        /// Writes a value for the <code>intersectionWidth</code> property as a <code>number</code> value.  The <code>intersectionWidth</code> property specifies the width of the intersection in pixels.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteIntersectionWidthProperty(double value)
        {
            using (var writer = OpenIntersectionWidthProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionWidth</code> property as a <code>number</code> value.  The <code>intersectionWidth</code> property specifies the width of the intersection in pixels.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteIntersectionWidthProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenIntersectionWidthProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionWidth</code> property as a <code>reference</code> value.  The <code>intersectionWidth</code> property specifies the width of the intersection in pixels.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteIntersectionWidthPropertyReference(Reference value)
        {
            using (var writer = OpenIntersectionWidthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionWidth</code> property as a <code>reference</code> value.  The <code>intersectionWidth</code> property specifies the width of the intersection in pixels.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteIntersectionWidthPropertyReference(string value)
        {
            using (var writer = OpenIntersectionWidthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionWidth</code> property as a <code>reference</code> value.  The <code>intersectionWidth</code> property specifies the width of the intersection in pixels.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteIntersectionWidthPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenIntersectionWidthProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>intersectionWidth</code> property as a <code>reference</code> value.  The <code>intersectionWidth</code> property specifies the width of the intersection in pixels.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteIntersectionWidthPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenIntersectionWidthProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>showLateralSurfaces</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>showLateralSurfaces</code> property defines whether or not the lateral surfaces of the sensor are shown.
        /// </summary>
        public BooleanCesiumWriter ShowLateralSurfacesWriter
        {
            get { return m_showLateralSurfaces.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>showLateralSurfaces</code> property.  The <code>showLateralSurfaces</code> property defines whether or not the lateral surfaces of the sensor are shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowLateralSurfacesProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowLateralSurfacesWriter);
        }

        /// <summary>
        /// Writes a value for the <code>showLateralSurfaces</code> property as a <code>boolean</code> value.  The <code>showLateralSurfaces</code> property specifies whether or not the lateral surfaces of the sensor are shown.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowLateralSurfacesProperty(bool value)
        {
            using (var writer = OpenShowLateralSurfacesProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showLateralSurfaces</code> property as a <code>reference</code> value.  The <code>showLateralSurfaces</code> property specifies whether or not the lateral surfaces of the sensor are shown.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteShowLateralSurfacesPropertyReference(Reference value)
        {
            using (var writer = OpenShowLateralSurfacesProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showLateralSurfaces</code> property as a <code>reference</code> value.  The <code>showLateralSurfaces</code> property specifies whether or not the lateral surfaces of the sensor are shown.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteShowLateralSurfacesPropertyReference(string value)
        {
            using (var writer = OpenShowLateralSurfacesProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showLateralSurfaces</code> property as a <code>reference</code> value.  The <code>showLateralSurfaces</code> property specifies whether or not the lateral surfaces of the sensor are shown.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteShowLateralSurfacesPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenShowLateralSurfacesProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showLateralSurfaces</code> property as a <code>reference</code> value.  The <code>showLateralSurfaces</code> property specifies whether or not the lateral surfaces of the sensor are shown.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteShowLateralSurfacesPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenShowLateralSurfacesProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>lateralSurfaceMaterial</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>lateralSurfaceMaterial</code> property defines the material to use for the sensor's lateral surfaces.
        /// </summary>
        public MaterialCesiumWriter LateralSurfaceMaterialWriter
        {
            get { return m_lateralSurfaceMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>lateralSurfaceMaterial</code> property.  The <code>lateralSurfaceMaterial</code> property defines the material to use for the sensor's lateral surfaces.
        /// </summary>
        public MaterialCesiumWriter OpenLateralSurfaceMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(LateralSurfaceMaterialWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>showEllipsoidSurfaces</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>showEllipsoidSurfaces</code> property defines whether or not ellipsoid surfaces are shown.
        /// </summary>
        public BooleanCesiumWriter ShowEllipsoidSurfacesWriter
        {
            get { return m_showEllipsoidSurfaces.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>showEllipsoidSurfaces</code> property.  The <code>showEllipsoidSurfaces</code> property defines whether or not ellipsoid surfaces are shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowEllipsoidSurfacesProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowEllipsoidSurfacesWriter);
        }

        /// <summary>
        /// Writes a value for the <code>showEllipsoidSurfaces</code> property as a <code>boolean</code> value.  The <code>showEllipsoidSurfaces</code> property specifies whether or not ellipsoid surfaces are shown.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowEllipsoidSurfacesProperty(bool value)
        {
            using (var writer = OpenShowEllipsoidSurfacesProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEllipsoidSurfaces</code> property as a <code>reference</code> value.  The <code>showEllipsoidSurfaces</code> property specifies whether or not ellipsoid surfaces are shown.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteShowEllipsoidSurfacesPropertyReference(Reference value)
        {
            using (var writer = OpenShowEllipsoidSurfacesProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEllipsoidSurfaces</code> property as a <code>reference</code> value.  The <code>showEllipsoidSurfaces</code> property specifies whether or not ellipsoid surfaces are shown.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteShowEllipsoidSurfacesPropertyReference(string value)
        {
            using (var writer = OpenShowEllipsoidSurfacesProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEllipsoidSurfaces</code> property as a <code>reference</code> value.  The <code>showEllipsoidSurfaces</code> property specifies whether or not ellipsoid surfaces are shown.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteShowEllipsoidSurfacesPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenShowEllipsoidSurfacesProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEllipsoidSurfaces</code> property as a <code>reference</code> value.  The <code>showEllipsoidSurfaces</code> property specifies whether or not ellipsoid surfaces are shown.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteShowEllipsoidSurfacesPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenShowEllipsoidSurfacesProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>ellipsoidSurfaceMaterial</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>ellipsoidSurfaceMaterial</code> property defines the material to use for the sensor's ellipsoid surfaces.
        /// </summary>
        public MaterialCesiumWriter EllipsoidSurfaceMaterialWriter
        {
            get { return m_ellipsoidSurfaceMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>ellipsoidSurfaceMaterial</code> property.  The <code>ellipsoidSurfaceMaterial</code> property defines the material to use for the sensor's ellipsoid surfaces.
        /// </summary>
        public MaterialCesiumWriter OpenEllipsoidSurfaceMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EllipsoidSurfaceMaterialWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>showEllipsoidHorizonSurfaces</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>showEllipsoidHorizonSurfaces</code> property defines whether or not ellipsoid horizon surfaces are shown.
        /// </summary>
        public BooleanCesiumWriter ShowEllipsoidHorizonSurfacesWriter
        {
            get { return m_showEllipsoidHorizonSurfaces.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>showEllipsoidHorizonSurfaces</code> property.  The <code>showEllipsoidHorizonSurfaces</code> property defines whether or not ellipsoid horizon surfaces are shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowEllipsoidHorizonSurfacesProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowEllipsoidHorizonSurfacesWriter);
        }

        /// <summary>
        /// Writes a value for the <code>showEllipsoidHorizonSurfaces</code> property as a <code>boolean</code> value.  The <code>showEllipsoidHorizonSurfaces</code> property specifies whether or not ellipsoid horizon surfaces are shown.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowEllipsoidHorizonSurfacesProperty(bool value)
        {
            using (var writer = OpenShowEllipsoidHorizonSurfacesProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEllipsoidHorizonSurfaces</code> property as a <code>reference</code> value.  The <code>showEllipsoidHorizonSurfaces</code> property specifies whether or not ellipsoid horizon surfaces are shown.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteShowEllipsoidHorizonSurfacesPropertyReference(Reference value)
        {
            using (var writer = OpenShowEllipsoidHorizonSurfacesProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEllipsoidHorizonSurfaces</code> property as a <code>reference</code> value.  The <code>showEllipsoidHorizonSurfaces</code> property specifies whether or not ellipsoid horizon surfaces are shown.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteShowEllipsoidHorizonSurfacesPropertyReference(string value)
        {
            using (var writer = OpenShowEllipsoidHorizonSurfacesProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEllipsoidHorizonSurfaces</code> property as a <code>reference</code> value.  The <code>showEllipsoidHorizonSurfaces</code> property specifies whether or not ellipsoid horizon surfaces are shown.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteShowEllipsoidHorizonSurfacesPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenShowEllipsoidHorizonSurfacesProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEllipsoidHorizonSurfaces</code> property as a <code>reference</code> value.  The <code>showEllipsoidHorizonSurfaces</code> property specifies whether or not ellipsoid horizon surfaces are shown.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteShowEllipsoidHorizonSurfacesPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenShowEllipsoidHorizonSurfacesProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>ellipsoidHorizonSurfaceMaterial</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>ellipsoidHorizonSurfaceMaterial</code> property defines the material to use for the sensor's ellipsoid horizon surfaces.
        /// </summary>
        public MaterialCesiumWriter EllipsoidHorizonSurfaceMaterialWriter
        {
            get { return m_ellipsoidHorizonSurfaceMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>ellipsoidHorizonSurfaceMaterial</code> property.  The <code>ellipsoidHorizonSurfaceMaterial</code> property defines the material to use for the sensor's ellipsoid horizon surfaces.
        /// </summary>
        public MaterialCesiumWriter OpenEllipsoidHorizonSurfaceMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EllipsoidHorizonSurfaceMaterialWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>showDomeSurfaces</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>showDomeSurfaces</code> property defines whether or not dome surfaces are shown.
        /// </summary>
        public BooleanCesiumWriter ShowDomeSurfacesWriter
        {
            get { return m_showDomeSurfaces.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>showDomeSurfaces</code> property.  The <code>showDomeSurfaces</code> property defines whether or not dome surfaces are shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowDomeSurfacesProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowDomeSurfacesWriter);
        }

        /// <summary>
        /// Writes a value for the <code>showDomeSurfaces</code> property as a <code>boolean</code> value.  The <code>showDomeSurfaces</code> property specifies whether or not dome surfaces are shown.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowDomeSurfacesProperty(bool value)
        {
            using (var writer = OpenShowDomeSurfacesProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showDomeSurfaces</code> property as a <code>reference</code> value.  The <code>showDomeSurfaces</code> property specifies whether or not dome surfaces are shown.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteShowDomeSurfacesPropertyReference(Reference value)
        {
            using (var writer = OpenShowDomeSurfacesProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showDomeSurfaces</code> property as a <code>reference</code> value.  The <code>showDomeSurfaces</code> property specifies whether or not dome surfaces are shown.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteShowDomeSurfacesPropertyReference(string value)
        {
            using (var writer = OpenShowDomeSurfacesProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showDomeSurfaces</code> property as a <code>reference</code> value.  The <code>showDomeSurfaces</code> property specifies whether or not dome surfaces are shown.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteShowDomeSurfacesPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenShowDomeSurfacesProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showDomeSurfaces</code> property as a <code>reference</code> value.  The <code>showDomeSurfaces</code> property specifies whether or not dome surfaces are shown.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteShowDomeSurfacesPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenShowDomeSurfacesProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>domeSurfaceMaterial</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>domeSurfaceMaterial</code> property defines the material to use for the sensor's dome surfaces.
        /// </summary>
        public MaterialCesiumWriter DomeSurfaceMaterialWriter
        {
            get { return m_domeSurfaceMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>domeSurfaceMaterial</code> property.  The <code>domeSurfaceMaterial</code> property defines the material to use for the sensor's dome surfaces.
        /// </summary>
        public MaterialCesiumWriter OpenDomeSurfaceMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(DomeSurfaceMaterialWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>portionToDisplay</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>portionToDisplay</code> property defines indicates what part of the sensor should be displayed.
        /// </summary>
        public SensorVolumePortionToDisplayCesiumWriter PortionToDisplayWriter
        {
            get { return m_portionToDisplay.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>portionToDisplay</code> property.  The <code>portionToDisplay</code> property defines indicates what part of the sensor should be displayed.
        /// </summary>
        public SensorVolumePortionToDisplayCesiumWriter OpenPortionToDisplayProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PortionToDisplayWriter);
        }

        /// <summary>
        /// Writes a value for the <code>portionToDisplay</code> property as a <code>portionToDisplay</code> value.  The <code>portionToDisplay</code> property specifies indicates what part of the sensor should be displayed.
        /// </summary>
        /// <param name="value">The portion of the sensor to display.</param>
        public void WritePortionToDisplayProperty(CesiumSensorVolumePortionToDisplay value)
        {
            using (var writer = OpenPortionToDisplayProperty())
            {
                writer.WritePortionToDisplay(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>portionToDisplay</code> property as a <code>reference</code> value.  The <code>portionToDisplay</code> property specifies indicates what part of the sensor should be displayed.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WritePortionToDisplayPropertyReference(Reference value)
        {
            using (var writer = OpenPortionToDisplayProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>portionToDisplay</code> property as a <code>reference</code> value.  The <code>portionToDisplay</code> property specifies indicates what part of the sensor should be displayed.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WritePortionToDisplayPropertyReference(string value)
        {
            using (var writer = OpenPortionToDisplayProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>portionToDisplay</code> property as a <code>reference</code> value.  The <code>portionToDisplay</code> property specifies indicates what part of the sensor should be displayed.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WritePortionToDisplayPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenPortionToDisplayProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>portionToDisplay</code> property as a <code>reference</code> value.  The <code>portionToDisplay</code> property specifies indicates what part of the sensor should be displayed.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WritePortionToDisplayPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenPortionToDisplayProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>environmentConstraint</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>environmentConstraint</code> property defines whether or not the sensor will intersect the environment, e.g. terrain or models.
        /// </summary>
        public BooleanCesiumWriter EnvironmentConstraintWriter
        {
            get { return m_environmentConstraint.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>environmentConstraint</code> property.  The <code>environmentConstraint</code> property defines whether or not the sensor will intersect the environment, e.g. terrain or models.
        /// </summary>
        public BooleanCesiumWriter OpenEnvironmentConstraintProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EnvironmentConstraintWriter);
        }

        /// <summary>
        /// Writes a value for the <code>environmentConstraint</code> property as a <code>boolean</code> value.  The <code>environmentConstraint</code> property specifies whether or not the sensor will intersect the environment, e.g. terrain or models.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteEnvironmentConstraintProperty(bool value)
        {
            using (var writer = OpenEnvironmentConstraintProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentConstraint</code> property as a <code>reference</code> value.  The <code>environmentConstraint</code> property specifies whether or not the sensor will intersect the environment, e.g. terrain or models.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteEnvironmentConstraintPropertyReference(Reference value)
        {
            using (var writer = OpenEnvironmentConstraintProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentConstraint</code> property as a <code>reference</code> value.  The <code>environmentConstraint</code> property specifies whether or not the sensor will intersect the environment, e.g. terrain or models.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteEnvironmentConstraintPropertyReference(string value)
        {
            using (var writer = OpenEnvironmentConstraintProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentConstraint</code> property as a <code>reference</code> value.  The <code>environmentConstraint</code> property specifies whether or not the sensor will intersect the environment, e.g. terrain or models.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteEnvironmentConstraintPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenEnvironmentConstraintProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentConstraint</code> property as a <code>reference</code> value.  The <code>environmentConstraint</code> property specifies whether or not the sensor will intersect the environment, e.g. terrain or models.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteEnvironmentConstraintPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenEnvironmentConstraintProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>showEnvironmentOcclusion</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>showEnvironmentOcclusion</code> property defines whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
        /// </summary>
        public BooleanCesiumWriter ShowEnvironmentOcclusionWriter
        {
            get { return m_showEnvironmentOcclusion.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>showEnvironmentOcclusion</code> property.  The <code>showEnvironmentOcclusion</code> property defines whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
        /// </summary>
        public BooleanCesiumWriter OpenShowEnvironmentOcclusionProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowEnvironmentOcclusionWriter);
        }

        /// <summary>
        /// Writes a value for the <code>showEnvironmentOcclusion</code> property as a <code>boolean</code> value.  The <code>showEnvironmentOcclusion</code> property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowEnvironmentOcclusionProperty(bool value)
        {
            using (var writer = OpenShowEnvironmentOcclusionProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEnvironmentOcclusion</code> property as a <code>reference</code> value.  The <code>showEnvironmentOcclusion</code> property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteShowEnvironmentOcclusionPropertyReference(Reference value)
        {
            using (var writer = OpenShowEnvironmentOcclusionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEnvironmentOcclusion</code> property as a <code>reference</code> value.  The <code>showEnvironmentOcclusion</code> property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteShowEnvironmentOcclusionPropertyReference(string value)
        {
            using (var writer = OpenShowEnvironmentOcclusionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEnvironmentOcclusion</code> property as a <code>reference</code> value.  The <code>showEnvironmentOcclusion</code> property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteShowEnvironmentOcclusionPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenShowEnvironmentOcclusionProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEnvironmentOcclusion</code> property as a <code>reference</code> value.  The <code>showEnvironmentOcclusion</code> property specifies whether or not the portion of the terrain occluded by the environment will be drawn with a separate material.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteShowEnvironmentOcclusionPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenShowEnvironmentOcclusionProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>environmentOcclusionMaterial</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>environmentOcclusionMaterial</code> property defines the surface apppearance of the port of the sensor occluded by the environment.
        /// </summary>
        public MaterialCesiumWriter EnvironmentOcclusionMaterialWriter
        {
            get { return m_environmentOcclusionMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>environmentOcclusionMaterial</code> property.  The <code>environmentOcclusionMaterial</code> property defines the surface apppearance of the port of the sensor occluded by the environment.
        /// </summary>
        public MaterialCesiumWriter OpenEnvironmentOcclusionMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EnvironmentOcclusionMaterialWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>showEnvironmentIntersection</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>showEnvironmentIntersection</code> property defines whether or not a line showing where the sensor intersects the environment will be drawn.
        /// </summary>
        public BooleanCesiumWriter ShowEnvironmentIntersectionWriter
        {
            get { return m_showEnvironmentIntersection.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>showEnvironmentIntersection</code> property.  The <code>showEnvironmentIntersection</code> property defines whether or not a line showing where the sensor intersects the environment will be drawn.
        /// </summary>
        public BooleanCesiumWriter OpenShowEnvironmentIntersectionProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowEnvironmentIntersectionWriter);
        }

        /// <summary>
        /// Writes a value for the <code>showEnvironmentIntersection</code> property as a <code>boolean</code> value.  The <code>showEnvironmentIntersection</code> property specifies whether or not a line showing where the sensor intersects the environment will be drawn.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteShowEnvironmentIntersectionProperty(bool value)
        {
            using (var writer = OpenShowEnvironmentIntersectionProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEnvironmentIntersection</code> property as a <code>reference</code> value.  The <code>showEnvironmentIntersection</code> property specifies whether or not a line showing where the sensor intersects the environment will be drawn.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteShowEnvironmentIntersectionPropertyReference(Reference value)
        {
            using (var writer = OpenShowEnvironmentIntersectionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEnvironmentIntersection</code> property as a <code>reference</code> value.  The <code>showEnvironmentIntersection</code> property specifies whether or not a line showing where the sensor intersects the environment will be drawn.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteShowEnvironmentIntersectionPropertyReference(string value)
        {
            using (var writer = OpenShowEnvironmentIntersectionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEnvironmentIntersection</code> property as a <code>reference</code> value.  The <code>showEnvironmentIntersection</code> property specifies whether or not a line showing where the sensor intersects the environment will be drawn.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteShowEnvironmentIntersectionPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenShowEnvironmentIntersectionProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>showEnvironmentIntersection</code> property as a <code>reference</code> value.  The <code>showEnvironmentIntersection</code> property specifies whether or not a line showing where the sensor intersects the environment will be drawn.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteShowEnvironmentIntersectionPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenShowEnvironmentIntersectionProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>environmentIntersectionColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>environmentIntersectionColor</code> property defines the color of the intersection line of the sensor and the environment.
        /// </summary>
        public ColorCesiumWriter EnvironmentIntersectionColorWriter
        {
            get { return m_environmentIntersectionColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>environmentIntersectionColor</code> property.  The <code>environmentIntersectionColor</code> property defines the color of the intersection line of the sensor and the environment.
        /// </summary>
        public ColorCesiumWriter OpenEnvironmentIntersectionColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EnvironmentIntersectionColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionColor</code> property as a <code>rgba</code> value.  The <code>environmentIntersectionColor</code> property specifies the color of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="color">The color.</param>
        public void WriteEnvironmentIntersectionColorProperty(Color color)
        {
            using (var writer = OpenEnvironmentIntersectionColorProperty())
            {
                writer.WriteRgba(color);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionColor</code> property as a <code>rgba</code> value.  The <code>environmentIntersectionColor</code> property specifies the color of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 255.</param>
        /// <param name="green">The green component in the range 0 to 255.</param>
        /// <param name="blue">The blue component in the range 0 to 255.</param>
        /// <param name="alpha">The alpha component in the range 0 to 255.</param>
        public void WriteEnvironmentIntersectionColorProperty(int red, int green, int blue, int alpha)
        {
            using (var writer = OpenEnvironmentIntersectionColorProperty())
            {
                writer.WriteRgba(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionColor</code> property as a <code>rgba</code> value.  The <code>environmentIntersectionColor</code> property specifies the color of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="colors">The color corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `colors` collection.</param>
        /// <param name="length">The number of elements to use from the `colors` collection.</param>
        public void WriteEnvironmentIntersectionColorProperty(IList<JulianDate> dates, IList<Color> colors, int startIndex, int length)
        {
            using (var writer = OpenEnvironmentIntersectionColorProperty())
            {
                writer.WriteRgba(dates, colors, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionColor</code> property as a <code>rgbaf</code> value.  The <code>environmentIntersectionColor</code> property specifies the color of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="red">The red component in the range 0 to 1.0.</param>
        /// <param name="green">The green component in the range 0 to 1.0.</param>
        /// <param name="blue">The blue component in the range 0 to 1.0.</param>
        /// <param name="alpha">The alpha component in the range 0 to 1.0.</param>
        public void WriteEnvironmentIntersectionColorPropertyRgbaf(float red, float green, float blue, float alpha)
        {
            using (var writer = OpenEnvironmentIntersectionColorProperty())
            {
                writer.WriteRgbaf(red, green, blue, alpha);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionColor</code> property as a <code>reference</code> value.  The <code>environmentIntersectionColor</code> property specifies the color of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteEnvironmentIntersectionColorPropertyReference(Reference value)
        {
            using (var writer = OpenEnvironmentIntersectionColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionColor</code> property as a <code>reference</code> value.  The <code>environmentIntersectionColor</code> property specifies the color of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteEnvironmentIntersectionColorPropertyReference(string value)
        {
            using (var writer = OpenEnvironmentIntersectionColorProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionColor</code> property as a <code>reference</code> value.  The <code>environmentIntersectionColor</code> property specifies the color of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteEnvironmentIntersectionColorPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenEnvironmentIntersectionColorProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionColor</code> property as a <code>reference</code> value.  The <code>environmentIntersectionColor</code> property specifies the color of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteEnvironmentIntersectionColorPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenEnvironmentIntersectionColorProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>environmentIntersectionWidth</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>environmentIntersectionWidth</code> property defines the width in meters of the intersection line of the sensor and the environment.
        /// </summary>
        public DoubleCesiumWriter EnvironmentIntersectionWidthWriter
        {
            get { return m_environmentIntersectionWidth.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>environmentIntersectionWidth</code> property.  The <code>environmentIntersectionWidth</code> property defines the width in meters of the intersection line of the sensor and the environment.
        /// </summary>
        public DoubleCesiumWriter OpenEnvironmentIntersectionWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(EnvironmentIntersectionWidthWriter);
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionWidth</code> property as a <code>number</code> value.  The <code>environmentIntersectionWidth</code> property specifies the width in meters of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteEnvironmentIntersectionWidthProperty(double value)
        {
            using (var writer = OpenEnvironmentIntersectionWidthProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionWidth</code> property as a <code>number</code> value.  The <code>environmentIntersectionWidth</code> property specifies the width in meters of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteEnvironmentIntersectionWidthProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenEnvironmentIntersectionWidthProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionWidth</code> property as a <code>reference</code> value.  The <code>environmentIntersectionWidth</code> property specifies the width in meters of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteEnvironmentIntersectionWidthPropertyReference(Reference value)
        {
            using (var writer = OpenEnvironmentIntersectionWidthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionWidth</code> property as a <code>reference</code> value.  The <code>environmentIntersectionWidth</code> property specifies the width in meters of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteEnvironmentIntersectionWidthPropertyReference(string value)
        {
            using (var writer = OpenEnvironmentIntersectionWidthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionWidth</code> property as a <code>reference</code> value.  The <code>environmentIntersectionWidth</code> property specifies the width in meters of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteEnvironmentIntersectionWidthPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenEnvironmentIntersectionWidthProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>environmentIntersectionWidth</code> property as a <code>reference</code> value.  The <code>environmentIntersectionWidth</code> property specifies the width in meters of the intersection line of the sensor and the environment.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteEnvironmentIntersectionWidthPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenEnvironmentIntersectionWidthProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

    }
}
