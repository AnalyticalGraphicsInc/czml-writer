using System;
using System.Diagnostics;

/// <summary>
/// Indicates that a particular node should be omitted entirely in Java.
/// </summary>
// ReSharper disable once StringLiteralTypo
[Conditional("CSTOJAVA")]
[AttributeUsage(AttributeTargets.Class | AttributeTargets.Struct | AttributeTargets.Enum |
                AttributeTargets.Constructor | AttributeTargets.Method | AttributeTargets.Property |
                AttributeTargets.Field | AttributeTargets.Event | AttributeTargets.Interface |
                AttributeTargets.Delegate)]
[CSToJavaExclude]
// ReSharper disable once CheckNamespace
internal sealed class CSToJavaExcludeAttribute : Attribute
{
    /// <summary>
    /// Initializes a new instance.
    /// </summary>
    public CSToJavaExcludeAttribute()
    {
    }

    /// <summary>
    /// Initializes a new instance.
    /// </summary>
    /// <param name="comment">A comment describing why the node is excluded.</param>
    public CSToJavaExcludeAttribute(string comment)
    {
        Comment = comment;
    }

    /// <summary>
    /// Gets or sets a comment describing why the node is excluded.
    /// </summary>
    public string Comment { get; set; }
}