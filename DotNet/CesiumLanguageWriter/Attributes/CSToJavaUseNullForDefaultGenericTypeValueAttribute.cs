using System;
using System.Diagnostics;

/// <summary>
/// <para>
/// Indicates that the default value of a generic type, e.g. <c>default(T)</c>, should be
/// treated as null instead of using TypeLiterals to produce correct default values at
/// run-time.
/// </para>
/// <para>
/// In C#, the default value of a value type is a default-constructed instance.
/// In order to obtain a default value in Java, we need to know the type of the generic 
/// at runtime, which requires TypeLiterals.  This can complicate the API, so 
/// if it really doesn't matter what the default value is, then assuming null
/// means we can avoid introducing TypeLiterals.
/// </para>
/// </summary>
// ReSharper disable once StringLiteralTypo
[Conditional("CSTOJAVA")]
[AttributeUsage(AttributeTargets.Class | AttributeTargets.Struct | AttributeTargets.Enum |
                AttributeTargets.Constructor | AttributeTargets.Method |
                AttributeTargets.Field | AttributeTargets.Event | AttributeTargets.Interface |
                AttributeTargets.Delegate, AllowMultiple = true)]
[CSToJavaExclude]
// ReSharper disable once CheckNamespace
internal class CSToJavaUseNullForDefaultGenericTypeValueAttribute : Attribute
{
    /// <summary>
    /// Initializes a new instance.
    /// </summary>
    /// <param name="genericTypeName">The name of the generic type to treat as null.</param>
    public CSToJavaUseNullForDefaultGenericTypeValueAttribute(string genericTypeName)
    {
        GenericTypeName = genericTypeName;
    }

    /// <summary>
    /// Gets or sets the name of the generic type to treat as null.
    /// </summary>
    public string GenericTypeName { get; set; }
}