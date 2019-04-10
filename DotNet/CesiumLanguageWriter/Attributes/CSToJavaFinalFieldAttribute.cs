using System;
using System.Diagnostics;

/// <summary>
/// <para>
/// Forces a field to be marked as "final" in Java.  
/// </para>
/// <para>
/// In general, this is not needed for correctness,
/// but final fields have a stronger guarantee in the Java memory model than non-final fields.
/// Specifically, final fields in a class are guaranteed not to be visible to other threads until the constructor
/// has finished. Non-final fields are not (unless other memory barriers are in place).
/// </para>
/// <para>
/// Note that the requirements for final fields are much more strict than readonly fields in C#.  
/// Final fields must be assigned exactly once, in all code paths, before the constructor exits.  
/// </para>
/// </summary>
// ReSharper disable once StringLiteralTypo
[Conditional("CSTOJAVA")]
[AttributeUsage(AttributeTargets.Field)]
[CSToJavaExclude]
// ReSharper disable once CheckNamespace
internal class CSToJavaFinalFieldAttribute : Attribute
{
}