using System;
using System.Diagnostics;

/// <summary>
/// Indicate that a particular base class or interface should be omitted in Java.
/// </summary>
// ReSharper disable once StringLiteralTypo
[Conditional("CSTOJAVA")]
[AttributeUsage(AttributeTargets.Class | AttributeTargets.Struct | AttributeTargets.Interface, AllowMultiple = true)]
[CSToJavaExclude]
// ReSharper disable once CheckNamespace
internal class CSToJavaExcludeBaseAttribute : Attribute
{
    /// <summary>
    /// Initializes a new instance.
    /// </summary>
    /// <param name="typeName">The name of the base class or interface to exclude.</param>
    public CSToJavaExcludeBaseAttribute(string typeName)
    {
        TypeName = typeName;
    }

    /// <summary>
    /// Gets or sets the name of the base class or interface to exclude.
    /// </summary>
    public string TypeName { get; set; }
}