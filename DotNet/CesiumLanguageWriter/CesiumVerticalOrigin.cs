namespace CesiumLanguageWriter
{
    /// <summary>
    /// The vertical origin of a billboard or label in a <topic name="Cesium">Cesium</topic> stream
    /// relative to an associated position.
    /// </summary>
    public enum CesiumVerticalOrigin
    {
        /// <summary>
        /// The bottom of the billboard or label is located at the position.
        /// </summary>
        Bottom,

        /// <summary>
        /// The billboard or label is vertically centered on the position.
        /// </summary>
        Center,

        /// <summary>
        /// The top of the billboard or label is located at the position.
        /// </summary>
        Top,
    }
}