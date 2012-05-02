using System;

/// <summary>
/// Mark a value type as being immutable, and therefore not necessary to clone when making copies.
/// </summary>
[AttributeUsage(AttributeTargets.Struct)]
[CSToJavaExclude]
[CoverageExcludeAttribute]
internal sealed class CSToJavaImmutableValueType : Attribute
{
}