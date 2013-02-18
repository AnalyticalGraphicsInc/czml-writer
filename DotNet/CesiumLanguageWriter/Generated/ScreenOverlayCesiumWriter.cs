// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>ScreenOverlay</code> to a <see cref="CesiumOutputStream" />.  A <code>ScreenOverlay</code> defines a rectangular screen overlay.
    /// </summary>
    public class ScreenOverlayCesiumWriter : CesiumPropertyWriter<ScreenOverlayCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>show</code> property.
        /// </summary>
        public const string ShowPropertyName = "show";

        /// <summary>
        /// The name of the <code>position</code> property.
        /// </summary>
        public const string PositionPropertyName = "position";

        /// <summary>
        /// The name of the <code>width</code> property.
        /// </summary>
        public const string WidthPropertyName = "width";

        /// <summary>
        /// The name of the <code>height</code> property.
        /// </summary>
        public const string HeightPropertyName = "height";

        /// <summary>
        /// The name of the <code>material</code> property.
        /// </summary>
        public const string MaterialPropertyName = "material";

        private readonly Lazy<BooleanCesiumWriter> m_show = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(ShowPropertyName), false);
        private readonly Lazy<ScreenPositionCesiumWriter> m_position = new Lazy<ScreenPositionCesiumWriter>(() => new ScreenPositionCesiumWriter(PositionPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_width = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(WidthPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_height = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(HeightPropertyName), false);
        private readonly Lazy<MaterialCesiumWriter> m_material = new Lazy<MaterialCesiumWriter>(() => new MaterialCesiumWriter(MaterialPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public ScreenOverlayCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected ScreenOverlayCesiumWriter(ScreenOverlayCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override ScreenOverlayCesiumWriter Clone()
        {
            return new ScreenOverlayCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>show</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>show</code> property defines whether or not the screen overlay is shown.
        /// </summary>
        public BooleanCesiumWriter ShowWriter
        {
            get { return m_show.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>show</code> property.  The <code>show</code> property defines whether or not the screen overlay is shown.
        /// </summary>
        public BooleanCesiumWriter OpenShowProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(ShowWriter);
        }

        /// <summary>
        /// Writes a value for the <code>show</code> property as a <code>boolean</code> value.  The <code>show</code> property specifies whether or not the screen overlay is shown.
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
        /// Gets the writer for the <code>position</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>position</code> property defines the position, in viewport pixels, of bottom left corner of the screen overlay.
        /// </summary>
        public ScreenPositionCesiumWriter PositionWriter
        {
            get { return m_position.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>position</code> property.  The <code>position</code> property defines the position, in viewport pixels, of bottom left corner of the screen overlay.
        /// </summary>
        public ScreenPositionCesiumWriter OpenPositionProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(PositionWriter);
        }

        /// <summary>
        /// Writes a value for the <code>position</code> property as a <code>cartesian2</code> value.  The <code>position</code> property specifies the position, in viewport pixels, of bottom left corner of the screen overlay.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WritePositionProperty(Rectangular value)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesian2(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>position</code> property as a <code>cartesian2</code> value.  The <code>position</code> property specifies the position, in viewport pixels, of bottom left corner of the screen overlay.
        /// </summary>
        /// <param name="x">The X component.</param>
        /// <param name="y">The Y component.</param>
        public void WritePositionProperty(double x, double y)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesian2(x, y);
            }
        }

        /// <summary>
        /// Writes a value for the <code>position</code> property as a <code>cartesian2</code> value.  The <code>position</code> property specifies the position, in viewport pixels, of bottom left corner of the screen overlay.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        public void WritePositionProperty(IList<JulianDate> dates, IList<Rectangular> values)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesian2(dates, values);
            }
        }

        /// <summary>
        /// Writes a value for the <code>position</code> property as a <code>cartesian2</code> value.  The <code>position</code> property specifies the position, in viewport pixels, of bottom left corner of the screen overlay.
        /// </summary>
        /// <param name="dates">The dates at which the vector is specified.</param>
        /// <param name="values">The values corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WritePositionProperty(IList<JulianDate> dates, IList<Rectangular> values, int startIndex, int length)
        {
            using (var writer = OpenPositionProperty())
            {
                writer.WriteCartesian2(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>width</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>width</code> property defines the width in pixels of the screen overlay.
        /// </summary>
        public DoubleCesiumWriter WidthWriter
        {
            get { return m_width.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>width</code> property.  The <code>width</code> property defines the width in pixels of the screen overlay.
        /// </summary>
        public DoubleCesiumWriter OpenWidthProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(WidthWriter);
        }

        /// <summary>
        /// Writes a value for the <code>width</code> property as a <code>number</code> value.  The <code>width</code> property specifies the width in pixels of the screen overlay.
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
        /// Writes a value for the <code>width</code> property as a <code>number</code> value.  The <code>width</code> property specifies the width in pixels of the screen overlay.
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
        /// Gets the writer for the <code>height</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>height</code> property defines the height in pixels of the screen overlay.
        /// </summary>
        public DoubleCesiumWriter HeightWriter
        {
            get { return m_height.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>height</code> property.  The <code>height</code> property defines the height in pixels of the screen overlay.
        /// </summary>
        public DoubleCesiumWriter OpenHeightProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HeightWriter);
        }

        /// <summary>
        /// Writes a value for the <code>height</code> property as a <code>number</code> value.  The <code>height</code> property specifies the height in pixels of the screen overlay.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteHeightProperty(double value)
        {
            using (var writer = OpenHeightProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>height</code> property as a <code>number</code> value.  The <code>height</code> property specifies the height in pixels of the screen overlay.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteHeightProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenHeightProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>material</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>material</code> property defines the material to display on the screen overlay.
        /// </summary>
        public MaterialCesiumWriter MaterialWriter
        {
            get { return m_material.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>material</code> property.  The <code>material</code> property defines the material to display on the screen overlay.
        /// </summary>
        public MaterialCesiumWriter OpenMaterialProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(MaterialWriter);
        }

    }
}
