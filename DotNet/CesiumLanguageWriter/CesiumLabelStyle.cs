
#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// Specifies the style of <topic name="Cesium">Cesium</topic> label.
    /// </summary>
    public enum CesiumLabelStyle
    {
        /// <summary>
        /// The label is filled.
        /// </summary>
        Fill,

        /// <summary>
        /// The label is outlined.
        /// </summary>
        Outline,

        /// <summary>
        /// The label is filled and outlined.
        /// </summary>
        FillAndOutline,
    }
}