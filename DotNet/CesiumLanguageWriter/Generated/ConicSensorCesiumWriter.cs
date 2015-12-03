// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;
using System.Drawing;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>ConicSensor</code> to a <see cref="CesiumOutputStream" />.  A <code>ConicSensor</code> a conical sensor volume taking into account occlusion of an ellipsoid, i.e., the globe.
    /// </summary>
    public class ConicSensorCesiumWriter : CesiumPropertyWriter<ConicSensorCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>innerHalfAngle</code> property.
        /// </summary>
        public const string InnerHalfAnglePropertyName = "innerHalfAngle";

        /// <summary>
        /// The name of the <code>outerHalfAngle</code> property.
        /// </summary>
        public const string OuterHalfAnglePropertyName = "outerHalfAngle";

        /// <summary>
        /// The name of the <code>minimumClockAngle</code> property.
        /// </summary>
        public const string MinimumClockAnglePropertyName = "minimumClockAngle";

        /// <summary>
        /// The name of the <code>maximumClockAngle</code> property.
        /// </summary>
        public const string MaximumClockAnglePropertyName = "maximumClockAngle";

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

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_innerHalfAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(InnerHalfAnglePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_outerHalfAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(OuterHalfAnglePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_minimumClockAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(MinimumClockAnglePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_maximumClockAngle = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(MaximumClockAnglePropertyName), false);
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

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ConicSensorCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param>
        protected ConicSensorCesiumWriter(ConicSensorCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override ConicSensorCesiumWriter Clone()
        {
            return new ConicSensorCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the cone is shown.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the cone is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the cone is shown.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the cone is shown.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the cone is shown.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the cone is shown.
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
        /// Writes a value for the <code>show</code> property as a <code>reference</code> value.  The <code>show</code> property specifies whether or not the cone is shown.
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
        /// Gets the writer for the <code>innerHalfAngle</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>innerHalfAngle</code> property defines the inner half angle of the cone.
        /// </summary>
        public DoubleCesiumWriter InnerHalfAngleWriter
        {
            get { return m_innerHalfAngle.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>innerHalfAngle</code> property.  The <code>innerHalfAngle</code> property defines the inner half angle of the cone.
        /// </summary>
        public DoubleCesiumWriter OpenInnerHalfAngleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(InnerHalfAngleWriter);
        }

        /// <summary>
        /// Writes a value for the <code>innerHalfAngle</code> property as a <code>number</code> value.  The <code>innerHalfAngle</code> property specifies the inner half angle of the cone.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteInnerHalfAngleProperty(double value)
        {
            using (var writer = OpenInnerHalfAngleProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>innerHalfAngle</code> property as a <code>number</code> value.  The <code>innerHalfAngle</code> property specifies the inner half angle of the cone.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteInnerHalfAngleProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenInnerHalfAngleProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>innerHalfAngle</code> property as a <code>reference</code> value.  The <code>innerHalfAngle</code> property specifies the inner half angle of the cone.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteInnerHalfAnglePropertyReference(Reference value)
        {
            using (var writer = OpenInnerHalfAngleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>innerHalfAngle</code> property as a <code>reference</code> value.  The <code>innerHalfAngle</code> property specifies the inner half angle of the cone.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteInnerHalfAnglePropertyReference(string value)
        {
            using (var writer = OpenInnerHalfAngleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>innerHalfAngle</code> property as a <code>reference</code> value.  The <code>innerHalfAngle</code> property specifies the inner half angle of the cone.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteInnerHalfAnglePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenInnerHalfAngleProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>innerHalfAngle</code> property as a <code>reference</code> value.  The <code>innerHalfAngle</code> property specifies the inner half angle of the cone.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteInnerHalfAnglePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenInnerHalfAngleProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>outerHalfAngle</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>outerHalfAngle</code> property defines the outer half angle of the cone.
        /// </summary>
        public DoubleCesiumWriter OuterHalfAngleWriter
        {
            get { return m_outerHalfAngle.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>outerHalfAngle</code> property.  The <code>outerHalfAngle</code> property defines the outer half angle of the cone.
        /// </summary>
        public DoubleCesiumWriter OpenOuterHalfAngleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(OuterHalfAngleWriter);
        }

        /// <summary>
        /// Writes a value for the <code>outerHalfAngle</code> property as a <code>number</code> value.  The <code>outerHalfAngle</code> property specifies the outer half angle of the cone.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteOuterHalfAngleProperty(double value)
        {
            using (var writer = OpenOuterHalfAngleProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>outerHalfAngle</code> property as a <code>number</code> value.  The <code>outerHalfAngle</code> property specifies the outer half angle of the cone.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteOuterHalfAngleProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenOuterHalfAngleProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>outerHalfAngle</code> property as a <code>reference</code> value.  The <code>outerHalfAngle</code> property specifies the outer half angle of the cone.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteOuterHalfAnglePropertyReference(Reference value)
        {
            using (var writer = OpenOuterHalfAngleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>outerHalfAngle</code> property as a <code>reference</code> value.  The <code>outerHalfAngle</code> property specifies the outer half angle of the cone.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteOuterHalfAnglePropertyReference(string value)
        {
            using (var writer = OpenOuterHalfAngleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>outerHalfAngle</code> property as a <code>reference</code> value.  The <code>outerHalfAngle</code> property specifies the outer half angle of the cone.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteOuterHalfAnglePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenOuterHalfAngleProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>outerHalfAngle</code> property as a <code>reference</code> value.  The <code>outerHalfAngle</code> property specifies the outer half angle of the cone.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteOuterHalfAnglePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenOuterHalfAngleProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>minimumClockAngle</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>minimumClockAngle</code> property defines the minimum clock angle limit of the cone.
        /// </summary>
        public DoubleCesiumWriter MinimumClockAngleWriter
        {
            get { return m_minimumClockAngle.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>minimumClockAngle</code> property.  The <code>minimumClockAngle</code> property defines the minimum clock angle limit of the cone.
        /// </summary>
        public DoubleCesiumWriter OpenMinimumClockAngleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MinimumClockAngleWriter);
        }

        /// <summary>
        /// Writes a value for the <code>minimumClockAngle</code> property as a <code>number</code> value.  The <code>minimumClockAngle</code> property specifies the minimum clock angle limit of the cone.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteMinimumClockAngleProperty(double value)
        {
            using (var writer = OpenMinimumClockAngleProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>minimumClockAngle</code> property as a <code>number</code> value.  The <code>minimumClockAngle</code> property specifies the minimum clock angle limit of the cone.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteMinimumClockAngleProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenMinimumClockAngleProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>minimumClockAngle</code> property as a <code>reference</code> value.  The <code>minimumClockAngle</code> property specifies the minimum clock angle limit of the cone.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteMinimumClockAnglePropertyReference(Reference value)
        {
            using (var writer = OpenMinimumClockAngleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>minimumClockAngle</code> property as a <code>reference</code> value.  The <code>minimumClockAngle</code> property specifies the minimum clock angle limit of the cone.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteMinimumClockAnglePropertyReference(string value)
        {
            using (var writer = OpenMinimumClockAngleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>minimumClockAngle</code> property as a <code>reference</code> value.  The <code>minimumClockAngle</code> property specifies the minimum clock angle limit of the cone.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteMinimumClockAnglePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenMinimumClockAngleProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>minimumClockAngle</code> property as a <code>reference</code> value.  The <code>minimumClockAngle</code> property specifies the minimum clock angle limit of the cone.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteMinimumClockAnglePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenMinimumClockAngleProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>maximumClockAngle</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>maximumClockAngle</code> property defines the maximum clock angle limit of the cone.
        /// </summary>
        public DoubleCesiumWriter MaximumClockAngleWriter
        {
            get { return m_maximumClockAngle.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>maximumClockAngle</code> property.  The <code>maximumClockAngle</code> property defines the maximum clock angle limit of the cone.
        /// </summary>
        public DoubleCesiumWriter OpenMaximumClockAngleProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaximumClockAngleWriter);
        }

        /// <summary>
        /// Writes a value for the <code>maximumClockAngle</code> property as a <code>number</code> value.  The <code>maximumClockAngle</code> property specifies the maximum clock angle limit of the cone.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteMaximumClockAngleProperty(double value)
        {
            using (var writer = OpenMaximumClockAngleProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>maximumClockAngle</code> property as a <code>number</code> value.  The <code>maximumClockAngle</code> property specifies the maximum clock angle limit of the cone.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteMaximumClockAngleProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenMaximumClockAngleProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>maximumClockAngle</code> property as a <code>reference</code> value.  The <code>maximumClockAngle</code> property specifies the maximum clock angle limit of the cone.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteMaximumClockAnglePropertyReference(Reference value)
        {
            using (var writer = OpenMaximumClockAngleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>maximumClockAngle</code> property as a <code>reference</code> value.  The <code>maximumClockAngle</code> property specifies the maximum clock angle limit of the cone.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteMaximumClockAnglePropertyReference(string value)
        {
            using (var writer = OpenMaximumClockAngleProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>maximumClockAngle</code> property as a <code>reference</code> value.  The <code>maximumClockAngle</code> property specifies the maximum clock angle limit of the cone.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteMaximumClockAnglePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenMaximumClockAngleProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>maximumClockAngle</code> property as a <code>reference</code> value.  The <code>maximumClockAngle</code> property specifies the maximum clock angle limit of the cone.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteMaximumClockAnglePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenMaximumClockAngleProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>radius</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>radius</code> property defines the radial limit of the cone.
        /// </summary>
        public DoubleCesiumWriter RadiusWriter
        {
            get { return m_radius.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>radius</code> property.  The <code>radius</code> property defines the radial limit of the cone.
        /// </summary>
        public DoubleCesiumWriter OpenRadiusProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(RadiusWriter);
        }

        /// <summary>
        /// Writes a value for the <code>radius</code> property as a <code>number</code> value.  The <code>radius</code> property specifies the radial limit of the cone.
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
        /// Writes a value for the <code>radius</code> property as a <code>number</code> value.  The <code>radius</code> property specifies the radial limit of the cone.
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
        /// Writes a value for the <code>radius</code> property as a <code>reference</code> value.  The <code>radius</code> property specifies the radial limit of the cone.
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
        /// Writes a value for the <code>radius</code> property as a <code>reference</code> value.  The <code>radius</code> property specifies the radial limit of the cone.
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
        /// Writes a value for the <code>radius</code> property as a <code>reference</code> value.  The <code>radius</code> property specifies the radial limit of the cone.
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
        /// Writes a value for the <code>radius</code> property as a <code>reference</code> value.  The <code>radius</code> property specifies the radial limit of the cone.
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
        /// Gets the writer for the <code>showIntersection</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>showIntersection</code> property defines whether or not the intersection of the cone with the Earth is shown.
        /// </summary>
        public BooleanCesiumWriter ShowIntersectionWriter
        {
            get { return m_showIntersection.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>showIntersection</code> property.  The <code>showIntersection</code> property defines whether or not the intersection of the cone with the Earth is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowIntersectionProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowIntersectionWriter);
        }

        /// <summary>
        /// Writes a value for the <code>showIntersection</code> property as a <code>boolean</code> value.  The <code>showIntersection</code> property specifies whether or not the intersection of the cone with the Earth is shown.
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
        /// Writes a value for the <code>showIntersection</code> property as a <code>reference</code> value.  The <code>showIntersection</code> property specifies whether or not the intersection of the cone with the Earth is shown.
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
        /// Writes a value for the <code>showIntersection</code> property as a <code>reference</code> value.  The <code>showIntersection</code> property specifies whether or not the intersection of the cone with the Earth is shown.
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
        /// Writes a value for the <code>showIntersection</code> property as a <code>reference</code> value.  The <code>showIntersection</code> property specifies whether or not the intersection of the cone with the Earth is shown.
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
        /// Writes a value for the <code>showIntersection</code> property as a <code>reference</code> value.  The <code>showIntersection</code> property specifies whether or not the intersection of the cone with the Earth is shown.
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
        /// Gets the writer for the <code>intersectionColor</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>intersectionColor</code> property defines the color of the intersection of the cone with the Earth.
        /// </summary>
        public ColorCesiumWriter IntersectionColorWriter
        {
            get { return m_intersectionColor.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>intersectionColor</code> property.  The <code>intersectionColor</code> property defines the color of the intersection of the cone with the Earth.
        /// </summary>
        public ColorCesiumWriter OpenIntersectionColorProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(IntersectionColorWriter);
        }

        /// <summary>
        /// Writes a value for the <code>intersectionColor</code> property as a <code>rgba</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the cone with the Earth.
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
        /// Writes a value for the <code>intersectionColor</code> property as a <code>rgba</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the cone with the Earth.
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
        /// Writes a value for the <code>intersectionColor</code> property as a <code>rgba</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the cone with the Earth.
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
        /// Writes a value for the <code>intersectionColor</code> property as a <code>rgbaf</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the cone with the Earth.
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
        /// Writes a value for the <code>intersectionColor</code> property as a <code>reference</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the cone with the Earth.
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
        /// Writes a value for the <code>intersectionColor</code> property as a <code>reference</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the cone with the Earth.
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
        /// Writes a value for the <code>intersectionColor</code> property as a <code>reference</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the cone with the Earth.
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
        /// Writes a value for the <code>intersectionColor</code> property as a <code>reference</code> value.  The <code>intersectionColor</code> property specifies the color of the intersection of the cone with the Earth.
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
        /// Gets the writer for the <code>showLateralSurfaces</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>showLateralSurfaces</code> property defines whether or not the intersections of the cone with the earth are shown.
        /// </summary>
        public BooleanCesiumWriter ShowLateralSurfacesWriter
        {
            get { return m_showLateralSurfaces.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>showLateralSurfaces</code> property.  The <code>showLateralSurfaces</code> property defines whether or not the intersections of the cone with the earth are shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowLateralSurfacesProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowLateralSurfacesWriter);
        }

        /// <summary>
        /// Writes a value for the <code>showLateralSurfaces</code> property as a <code>boolean</code> value.  The <code>showLateralSurfaces</code> property specifies whether or not the intersections of the cone with the earth are shown.
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
        /// Writes a value for the <code>showLateralSurfaces</code> property as a <code>reference</code> value.  The <code>showLateralSurfaces</code> property specifies whether or not the intersections of the cone with the earth are shown.
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
        /// Writes a value for the <code>showLateralSurfaces</code> property as a <code>reference</code> value.  The <code>showLateralSurfaces</code> property specifies whether or not the intersections of the cone with the earth are shown.
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
        /// Writes a value for the <code>showLateralSurfaces</code> property as a <code>reference</code> value.  The <code>showLateralSurfaces</code> property specifies whether or not the intersections of the cone with the earth are shown.
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
        /// Writes a value for the <code>showLateralSurfaces</code> property as a <code>reference</code> value.  The <code>showLateralSurfaces</code> property specifies whether or not the intersections of the cone with the earth are shown.
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
        /// Gets the writer for the <code>lateralSurfaceMaterial</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>lateralSurfaceMaterial</code> property defines whether or not lateral surfaces are shown.
        /// </summary>
        public MaterialCesiumWriter LateralSurfaceMaterialWriter
        {
            get { return m_lateralSurfaceMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>lateralSurfaceMaterial</code> property.  The <code>lateralSurfaceMaterial</code> property defines whether or not lateral surfaces are shown.
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
        /// Gets the writer for the <code>ellipsoidSurfaceMaterial</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>ellipsoidSurfaceMaterial</code> property defines the material to use for the cone's ellipsoid surface.
        /// </summary>
        public MaterialCesiumWriter EllipsoidSurfaceMaterialWriter
        {
            get { return m_ellipsoidSurfaceMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>ellipsoidSurfaceMaterial</code> property.  The <code>ellipsoidSurfaceMaterial</code> property defines the material to use for the cone's ellipsoid surface.
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
        /// Gets the writer for the <code>ellipsoidHorizonSurfaceMaterial</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>ellipsoidHorizonSurfaceMaterial</code> property defines the material to use for the cone's ellipsoid horizon surface.
        /// </summary>
        public MaterialCesiumWriter EllipsoidHorizonSurfaceMaterialWriter
        {
            get { return m_ellipsoidHorizonSurfaceMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>ellipsoidHorizonSurfaceMaterial</code> property.  The <code>ellipsoidHorizonSurfaceMaterial</code> property defines the material to use for the cone's ellipsoid horizon surface.
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
        /// Gets the writer for the <code>domeSurfaceMaterial</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>domeSurfaceMaterial</code> property defines the material to use for the cone's dome.
        /// </summary>
        public MaterialCesiumWriter DomeSurfaceMaterialWriter
        {
            get { return m_domeSurfaceMaterial.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>domeSurfaceMaterial</code> property.  The <code>domeSurfaceMaterial</code> property defines the material to use for the cone's dome.
        /// </summary>
        public MaterialCesiumWriter OpenDomeSurfaceMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(DomeSurfaceMaterialWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>portionToDisplay</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>portionToDisplay</code> property defines indicates what part of a sensor should be displayed.
        /// </summary>
        public SensorVolumePortionToDisplayCesiumWriter PortionToDisplayWriter
        {
            get { return m_portionToDisplay.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>portionToDisplay</code> property.  The <code>portionToDisplay</code> property defines indicates what part of a sensor should be displayed.
        /// </summary>
        public SensorVolumePortionToDisplayCesiumWriter OpenPortionToDisplayProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PortionToDisplayWriter);
        }

        /// <summary>
        /// Writes a value for the <code>portionToDisplay</code> property as a <code>portionToDisplay</code> value.  The <code>portionToDisplay</code> property specifies indicates what part of a sensor should be displayed.
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
        /// Writes a value for the <code>portionToDisplay</code> property as a <code>reference</code> value.  The <code>portionToDisplay</code> property specifies indicates what part of a sensor should be displayed.
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
        /// Writes a value for the <code>portionToDisplay</code> property as a <code>reference</code> value.  The <code>portionToDisplay</code> property specifies indicates what part of a sensor should be displayed.
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
        /// Writes a value for the <code>portionToDisplay</code> property as a <code>reference</code> value.  The <code>portionToDisplay</code> property specifies indicates what part of a sensor should be displayed.
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
        /// Writes a value for the <code>portionToDisplay</code> property as a <code>reference</code> value.  The <code>portionToDisplay</code> property specifies indicates what part of a sensor should be displayed.
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

    }
}
