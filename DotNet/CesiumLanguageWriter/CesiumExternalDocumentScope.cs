

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// The scope of the document. Shared scopes merge objects with the same ids. Privately scoped documents do not merge objects with the same ids.
    /// </summary>
    public enum CesiumExternalDocumentScope
    {
        /// <summary>
        /// The document is shared. 
        /// </summary>
        Shared,

        /// <summary>
        /// The document is private.
        /// </summary>
        Private

    }
}
