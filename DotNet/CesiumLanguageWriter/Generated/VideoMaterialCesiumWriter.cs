// This file was generated automatically by GenerateFromSchema.  Do NOT edit it.
// https://github.com/AnalyticalGraphicsInc/czml-writer

using CesiumLanguageWriter.Advanced;
using System;
using System.Collections.Generic;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes a <code>VideoMaterial</code> to a <see cref="CesiumOutputStream" />.  A <code>VideoMaterial</code> a material that fills the surface with a video.
    /// </summary>
    public class VideoMaterialCesiumWriter : CesiumPropertyWriter<VideoMaterialCesiumWriter>
    {
        /// <summary>
        /// The name of the <code>video</code> property.
        /// </summary>
        public const string VideoPropertyName = "video";

        /// <summary>
        /// The name of the <code>horizontalRepeat</code> property.
        /// </summary>
        public const string HorizontalRepeatPropertyName = "horizontalRepeat";

        /// <summary>
        /// The name of the <code>verticalRepeat</code> property.
        /// </summary>
        public const string VerticalRepeatPropertyName = "verticalRepeat";

        /// <summary>
        /// The name of the <code>startTime</code> property.
        /// </summary>
        public const string StartTimePropertyName = "startTime";

        /// <summary>
        /// The name of the <code>loop</code> property.
        /// </summary>
        public const string LoopPropertyName = "loop";

        /// <summary>
        /// The name of the <code>speed</code> property.
        /// </summary>
        public const string SpeedPropertyName = "speed";

        private readonly Lazy<VideoCesiumWriter> m_video = new Lazy<VideoCesiumWriter>(() => new VideoCesiumWriter(VideoPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_horizontalRepeat = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(HorizontalRepeatPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_verticalRepeat = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(VerticalRepeatPropertyName), false);
        private readonly Lazy<BooleanCesiumWriter> m_loop = new Lazy<BooleanCesiumWriter>(() => new BooleanCesiumWriter(LoopPropertyName), false);
        private readonly Lazy<DoubleCesiumWriter> m_speed = new Lazy<DoubleCesiumWriter>(() => new DoubleCesiumWriter(SpeedPropertyName), false);

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        public VideoMaterialCesiumWriter(string propertyName)
            : base(propertyName)
        {
        }

        /// <summary>
        /// Initializes a new instance as a copy of an existing instance.
        /// </summary>
        /// <param name="existingInstance">The existing instance to copy.</param> 
        protected VideoMaterialCesiumWriter(VideoMaterialCesiumWriter existingInstance)
            : base(existingInstance)
        {
        }

        /// <inheritdoc />
        public override VideoMaterialCesiumWriter Clone()
        {
            return new VideoMaterialCesiumWriter(this);
        }

        /// <summary>
        /// Gets the writer for the <code>video</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>video</code> property defines the video to display on the surface.
        /// </summary>
        public VideoCesiumWriter VideoWriter
        {
            get { return m_video.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>video</code> property.  The <code>video</code> property defines the video to display on the surface.
        /// </summary>
        public VideoCesiumWriter OpenVideoProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(VideoWriter);
        }

        /// <summary>
        /// Writes a value for the <code>video</code> property as a <code>video</code> value.  The <code>video</code> property specifies the video to display on the surface.
        /// </summary>
        /// <param name="resource">A resource object describing the video.</param>
        public void WriteVideoProperty(CesiumResource resource)
        {
            using (var writer = OpenVideoProperty())
            {
                writer.WriteVideo(resource);
            }
        }

        /// <summary>
        /// Writes a value for the <code>video</code> property as a <code>video</code> value.  The <code>video</code> property specifies the video to display on the surface.
        /// </summary>
        /// <param name="url">The URL of the video.</param>
        /// <param name="resourceBehavior">An enumeration describing how to include the video in the document. For even more control, use the overload that takes a ICesiumUrlResolver.</param>
        public void WriteVideoProperty(string url, CesiumResourceBehavior resourceBehavior)
        {
            using (var writer = OpenVideoProperty())
            {
                writer.WriteVideo(url, resourceBehavior);
            }
        }

        /// <summary>
        /// Writes a value for the <code>video</code> property as a <code>video</code> value.  The <code>video</code> property specifies the video to display on the surface.
        /// </summary>
        /// <param name="url">The URL of the video.  The provided ICesiumUrlResolver will be used to build the final URL embedded in the document.</param>
        /// <param name="resolver">An ICesiumUrlResolver used to build the final URL that will be embedded in the document.</param>
        public void WriteVideoProperty(string url, ICesiumUrlResolver resolver)
        {
            using (var writer = OpenVideoProperty())
            {
                writer.WriteVideo(url, resolver);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>horizontalRepeat</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>horizontalRepeat</code> property defines the number of times the video is repeated horizontally.
        /// </summary>
        public DoubleCesiumWriter HorizontalRepeatWriter
        {
            get { return m_horizontalRepeat.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>horizontalRepeat</code> property.  The <code>horizontalRepeat</code> property defines the number of times the video is repeated horizontally.
        /// </summary>
        public DoubleCesiumWriter OpenHorizontalRepeatProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(HorizontalRepeatWriter);
        }

        /// <summary>
        /// Writes a value for the <code>horizontalRepeat</code> property as a <code>number</code> value.  The <code>horizontalRepeat</code> property specifies the number of times the video is repeated horizontally.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteHorizontalRepeatProperty(double value)
        {
            using (var writer = OpenHorizontalRepeatProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>horizontalRepeat</code> property as a <code>number</code> value.  The <code>horizontalRepeat</code> property specifies the number of times the video is repeated horizontally.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteHorizontalRepeatProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenHorizontalRepeatProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>verticalRepeat</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>verticalRepeat</code> property defines the number of times the video is repeated vertically.
        /// </summary>
        public DoubleCesiumWriter VerticalRepeatWriter
        {
            get { return m_verticalRepeat.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>verticalRepeat</code> property.  The <code>verticalRepeat</code> property defines the number of times the video is repeated vertically.
        /// </summary>
        public DoubleCesiumWriter OpenVerticalRepeatProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(VerticalRepeatWriter);
        }

        /// <summary>
        /// Writes a value for the <code>verticalRepeat</code> property as a <code>number</code> value.  The <code>verticalRepeat</code> property specifies the number of times the video is repeated vertically.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteVerticalRepeatProperty(double value)
        {
            using (var writer = OpenVerticalRepeatProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>verticalRepeat</code> property as a <code>number</code> value.  The <code>verticalRepeat</code> property specifies the number of times the video is repeated vertically.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteVerticalRepeatProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenVerticalRepeatProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

        /// <summary>
        /// Writes the <code>startTime</code> property.  The <code>startTime</code> property specifies the number of seconds .
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteStartTime(string value)
        {
            const string PropertyName = StartTimePropertyName;
            OpenIntervalIfNecessary();
            Output.WritePropertyName(PropertyName);
            Output.WriteValue(value);
        }

        /// <summary>
        /// Gets the writer for the <code>loop</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>loop</code> property defines if true, the video will loop, if false the first or last frame will be displayed when outside the bounds of the video.
        /// </summary>
        public BooleanCesiumWriter LoopWriter
        {
            get { return m_loop.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>loop</code> property.  The <code>loop</code> property defines if true, the video will loop, if false the first or last frame will be displayed when outside the bounds of the video.
        /// </summary>
        public BooleanCesiumWriter OpenLoopProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(LoopWriter);
        }

        /// <summary>
        /// Writes a value for the <code>loop</code> property as a <code>boolean</code> value.  The <code>loop</code> property specifies if true, the video will loop, if false the first or last frame will be displayed when outside the bounds of the video.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteLoopProperty(bool value)
        {
            using (var writer = OpenLoopProperty())
            {
                writer.WriteBoolean(value);
            }
        }

        /// <summary>
        /// Gets the writer for the <code>speed</code> property.  The returned instance must be opened by calling the <see cref="CesiumElementWriter.Open"/> method before it can be used for writing.  The <code>speed</code> property defines the speed at which the video should play.
        /// </summary>
        public DoubleCesiumWriter SpeedWriter
        {
            get { return m_speed.Value; }
        }

        /// <summary>
        /// Opens and returns the writer for the <code>speed</code> property.  The <code>speed</code> property defines the speed at which the video should play.
        /// </summary>
        public DoubleCesiumWriter OpenSpeedProperty()
        {
            OpenIntervalIfNecessary();
            return OpenAndReturn(SpeedWriter);
        }

        /// <summary>
        /// Writes a value for the <code>speed</code> property as a <code>number</code> value.  The <code>speed</code> property specifies the speed at which the video should play.
        /// </summary>
        /// <param name="value">The value.</param>
        public void WriteSpeedProperty(double value)
        {
            using (var writer = OpenSpeedProperty())
            {
                writer.WriteNumber(value);
            }
        }

        /// <summary>
        /// Writes a value for the <code>speed</code> property as a <code>number</code> value.  The <code>speed</code> property specifies the speed at which the video should play.
        /// </summary>
        /// <param name="dates">The dates at which the value is specified.</param>
        /// <param name="values">The value corresponding to each date.</param>
        /// <param name="startIndex">The index of the first element to use in the `values` collection.</param>
        /// <param name="length">The number of elements to use from the `values` collection.</param>
        public void WriteSpeedProperty(IList<JulianDate> dates, IList<double> values, int startIndex, int length)
        {
            using (var writer = OpenSpeedProperty())
            {
                writer.WriteNumber(dates, values, startIndex, length);
            }
        }

    }
}
