namespace CesiumLanguageWriter
{
    /// <summary>
    /// Whether or not an object casts or receives shadows from each light source when shadows are enabled.
    /// </summary>
    public enum CesiumShadowMode
    {
        /// <summary>
        /// The object does not cast or receive shadows.
        /// </summary>
        Disabled,

        /// <summary>
        /// The object casts and receives shadows.
        /// </summary>
        Enabled,

        /// <summary>
        /// The object casts shadows only.
        /// </summary>
        CastOnly,

        /// <summary>
        /// The object receives shadows only.
        /// </summary>
        ReceiveOnly,
    }
}