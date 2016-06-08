using System;
using System.Diagnostics;

/// <summary>
/// Mark a value type as being immutable, and therefore not necessary to clone when making copies.
/// </summary>
[Conditional("CSTOJAVA")]
[AttributeUsage(AttributeTargets.Struct)]
[CSToJavaExclude]
internal sealed class CSToJavaImmutableValueType : Attribute
{
}