using System;
using System.Diagnostics;

/// <summary>
/// Indicates that generic types should be declared as a bounded wildcard.
/// Note that the translator must also know about the particular generic type, in order to know
/// the correct type variance (co-variance or contra-variance, which becomes
/// either <code>? extends T</code> or <code>? super T</code>).
/// </summary>
// ReSharper disable once StringLiteralTypo
[Conditional("CSTOJAVA")]
[AttributeUsage(AttributeTargets.Parameter | AttributeTargets.Class | AttributeTargets.Field | AttributeTargets.Method)]
[CSToJavaExclude]
// ReSharper disable once CheckNamespace
internal class CSToJavaUseWildcardGenericsAttribute : Attribute
{
}