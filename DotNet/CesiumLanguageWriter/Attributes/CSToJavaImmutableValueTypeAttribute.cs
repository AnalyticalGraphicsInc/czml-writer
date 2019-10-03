using System;
using System.Diagnostics;

/// <summary>
/// Mark a value type as being immutable, and therefore not necessary to clone 
/// when being passed to or returned from methods.
/// </summary>
// ReSharper disable once StringLiteralTypo
[Conditional("CSTOJAVA")]
[AttributeUsage(AttributeTargets.Struct)]
[CSToJavaExclude]
// ReSharper disable once CheckNamespace
internal sealed class CSToJavaImmutableValueTypeAttribute : Attribute
{
}