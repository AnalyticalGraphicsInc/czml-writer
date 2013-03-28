#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// The source data type of the external document.
    /// </summary>
    public enum CesiumExternalDocumentSourceType
    {
        /// <summary>
        /// The data is formatted as json.
        /// </summary>
        Json,

        /// <summary>
        /// The data is formatted as eventstream.
        /// </summary>
        EventStream,

    }
}
