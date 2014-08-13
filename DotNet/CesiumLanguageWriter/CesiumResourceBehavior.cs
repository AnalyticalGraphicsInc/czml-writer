namespace CesiumLanguageWriter
{
    /// <summary>
    /// Specifies whether to embed a resource into a CZML stream or simply link to them.
    /// </summary>
    public enum CesiumResourceBehavior
    {
        /// <summary>
        /// Download and embed the resource inline in the document as a data URI.  This is the most compatible
        /// option, but produces larger documents.
        /// </summary>
        Embed,

        /// <summary>
        /// Link to the resource directly in the document.  Browser-based CZML clients may need to make
        /// cross-origin requests using <a href="http://www.w3.org/TR/cors/">Cross-Origin Resource Sharing</a>
        /// to access the resource, which may need server configuration changes, see
        /// <a href="http://enable-cors.org/">http://enable-cors.org/</a>.
        /// </summary>
        LinkTo,
    }
}