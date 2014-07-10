// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>Path</code> to a <see cref="CesiumOutputStream" />.  A <code>Path</code> a path, which is a polyline defined by the motion of an object over time.  The possible vertices of the path are specified by the `position` property.
    /// </summary>
    public class PathCesiumWriter : CesiumPropertyWriter<PathCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>material</code> property.
        /// </summary>
        public const string MaterialPropertyName = "material";

        /// <summary>
        /// The name of the <code>width</code> property.
        /// </summary>
        public const string WidthPropertyName = "width";

        /// <summary>
        /// The name of the <code>resolution</code> property.
        /// </summary>
        public const string ResolutionPropertyName = "resolution";

        /// <summary>
        /// The name of the <code>leadTime</code> property.
        /// </summary>
        public const string LeadTimePropertyName = "leadTime";

        /// <summary>
        /// The name of the <code>trailTime</code> property.
        /// </summary>
        public const string TrailTimePropertyName = "trailTime";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<PolylineMaterialCesiumWriter> m_material = new Lazy<PolylineMaterialCesiumWriter>(() => new PolylineMaterialCesiumWriter(MaterialPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_width = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(WidthPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_resolution = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(ResolutionPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_leadTime = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(LeadTimePropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_trailTime = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(TrailTimePropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public PathCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected PathCesiumWriter(PathCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override PathCesiumWriter Clone()
        {
            return new PathCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the path is shown.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the path is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the path is shown.
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
        /// Gets the writer for the <code>material</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>material</code> property defines the material to use to draw the path.
        /// </summary>
        public PolylineMaterialCesiumWriter MaterialWriter
        {
            get { return m_material.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>material</code> property.  The <code>material</code> property defines the material to use to draw the path.
        /// </summary>
        public PolylineMaterialCesiumWriter OpenMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaterialWriter);
        }

        /// <summary>
        /// Gets the writer for the <code>width</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>width</code> property defines the width of the path line.
        /// </summary>
        public DoubleCesiumWriter WidthWriter
        {
            get { return m_width.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>width</code> property.  The <code>width</code> property defines the width of the path line.
        /// </summary>
        public DoubleCesiumWriter OpenWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(WidthWriter);
        }

        /// <summary>
        /// Writes a value for the <code>width</code> property as a <code>number</code> value.  The <code>width</code> property specifies the width of the path line.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteWidthProperty(double value)
        {
            using (var writer = OpenWidthProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>width</code> property as a <code>number</code> value.  The <code>width</code> property specifies the width of the path line.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteWidthProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenWidthProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the path line.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteWidthPropertyReference(Reference value)
        {
            using (var writer = OpenWidthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the path line.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteWidthPropertyReference(string value)
        {
            using (var writer = OpenWidthProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the path line.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteWidthPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenWidthProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>width</code> property as a <code>reference</code> value.  The <code>width</code> property specifies the width of the path line.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteWidthPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenWidthProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>resolution</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>resolution</code> property defines the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
        /// </summary>
        public DoubleCesiumWriter ResolutionWriter
        {
            get { return m_resolution.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>resolution</code> property.  The <code>resolution</code> property defines the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
        /// </summary>
        public DoubleCesiumWriter OpenResolutionProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ResolutionWriter);
        }

        /// <summary>
        /// Writes a value for the <code>resolution</code> property as a <code>number</code> value.  The <code>resolution</code> property specifies the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteResolutionProperty(double value)
        {
            using (var writer = OpenResolutionProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>resolution</code> property as a <code>number</code> value.  The <code>resolution</code> property specifies the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteResolutionProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenResolutionProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>resolution</code> property as a <code>reference</code> value.  The <code>resolution</code> property specifies the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteResolutionPropertyReference(Reference value)
        {
            using (var writer = OpenResolutionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>resolution</code> property as a <code>reference</code> value.  The <code>resolution</code> property specifies the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteResolutionPropertyReference(string value)
        {
            using (var writer = OpenResolutionProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>resolution</code> property as a <code>reference</code> value.  The <code>resolution</code> property specifies the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteResolutionPropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenResolutionProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>resolution</code> property as a <code>reference</code> value.  The <code>resolution</code> property specifies the maximum step-size, in seconds, used to sample the path.  If the `position` property has data points farther apart than resolution specfies, additional steps will be taken, creating a smoother path.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteResolutionPropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenResolutionProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>leadTime</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>leadTime</code> property defines the time ahead of the animation time, in seconds, to show the path.
        /// </summary>
        public DoubleCesiumWriter LeadTimeWriter
        {
            get { return m_leadTime.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>leadTime</code> property.  The <code>leadTime</code> property defines the time ahead of the animation time, in seconds, to show the path.
        /// </summary>
        public DoubleCesiumWriter OpenLeadTimeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(LeadTimeWriter);
        }

        /// <summary>
        /// Writes a value for the <code>leadTime</code> property as a <code>number</code> value.  The <code>leadTime</code> property specifies the time ahead of the animation time, in seconds, to show the path.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteLeadTimeProperty(double value)
        {
            using (var writer = OpenLeadTimeProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>leadTime</code> property as a <code>number</code> value.  The <code>leadTime</code> property specifies the time ahead of the animation time, in seconds, to show the path.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteLeadTimeProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenLeadTimeProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>leadTime</code> property as a <code>reference</code> value.  The <code>leadTime</code> property specifies the time ahead of the animation time, in seconds, to show the path.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteLeadTimePropertyReference(Reference value)
        {
            using (var writer = OpenLeadTimeProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>leadTime</code> property as a <code>reference</code> value.  The <code>leadTime</code> property specifies the time ahead of the animation time, in seconds, to show the path.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteLeadTimePropertyReference(string value)
        {
            using (var writer = OpenLeadTimeProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>leadTime</code> property as a <code>reference</code> value.  The <code>leadTime</code> property specifies the time ahead of the animation time, in seconds, to show the path.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteLeadTimePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenLeadTimeProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>leadTime</code> property as a <code>reference</code> value.  The <code>leadTime</code> property specifies the time ahead of the animation time, in seconds, to show the path.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteLeadTimePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenLeadTimeProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>trailTime</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>trailTime</code> property defines the time behind the animation time, in seconds, to show the path.
        /// </summary>
        public DoubleCesiumWriter TrailTimeWriter
        {
            get { return m_trailTime.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>trailTime</code> property.  The <code>trailTime</code> property defines the time behind the animation time, in seconds, to show the path.
        /// </summary>
        public DoubleCesiumWriter OpenTrailTimeProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(TrailTimeWriter);
        }

        /// <summary>
        /// Writes a value for the <code>trailTime</code> property as a <code>number</code> value.  The <code>trailTime</code> property specifies the time behind the animation time, in seconds, to show the path.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteTrailTimeProperty(double value)
        {
            using (var writer = OpenTrailTimeProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>trailTime</code> property as a <code>number</code> value.  The <code>trailTime</code> property specifies the time behind the animation time, in seconds, to show the path.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteTrailTimeProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenTrailTimeProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes a value for the <code>trailTime</code> property as a <code>reference</code> value.  The <code>trailTime</code> property specifies the time behind the animation time, in seconds, to show the path.
        /// </summary>
        /// <param name="value">The reference.</param>
        public void WriteTrailTimePropertyReference(Reference value)
        {
            using (var writer = OpenTrailTimeProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>trailTime</code> property as a <code>reference</code> value.  The <code>trailTime</code> property specifies the time behind the animation time, in seconds, to show the path.
        /// </summary>
        /// <param name="value">The earliest date of the interval.</param>
        public void WriteTrailTimePropertyReference(string value)
        {
            using (var writer = OpenTrailTimeProperty())
            {
                writer.WriteReference(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>trailTime</code> property as a <code>reference</code> value.  The <code>trailTime</code> property specifies the time behind the animation time, in seconds, to show the path.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyName">The property on the referenced object.</param>
        public void WriteTrailTimePropertyReference(string identifier, string propertyName)
        {
            using (var writer = OpenTrailTimeProperty())
            {
                writer.WriteReference(identifier, propertyName);
            }
        }

        /// <summary>
        /// Writes a value for the <code>trailTime</code> property as a <code>reference</code> value.  The <code>trailTime</code> property specifies the time behind the animation time, in seconds, to show the path.
        /// </summary>
        /// <param name="identifier">The identifier of the object which contains the referenced property.</param>
        /// <param name="propertyNames">The hierarchy of properties to be indexed on the referenced object.</param>
        public void WriteTrailTimePropertyReference(string identifier, string[] propertyNames)
        {
            using (var writer = OpenTrailTimeProperty())
            {
                writer.WriteReference(identifier, propertyNames);
            }
        }

    }
}
