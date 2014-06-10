using System;

/// <summary>
/// Declare that the default value of a generic type, e.g. default(T), should be
/// treated as null instead of using TypeLiterals to produce correct values at
/// run-time.
/// </summary>
[AttributeUsage(AttributeTargets.Class | AttributeTargets.Struct | AttributeTargets.Enum |
                AttributeTargets.Constructor | AttributeTargets.Method |
                AttributeTargets.Field | AttributeTargets.Event | AttributeTargets.Interface |
                AttributeTargets.Delegate, AllowMultiple = true)]
[CSToJavaExclude]
[CoverageExcludeAttribute]
internal class CSToJavaUseNullForDefaultGenericTypeValueAttribute : Attribute
{
    public CSToJavaUseNullForDefaultGenericTypeValueAttribute(string genericTypeName)
    {
        GenericTypeName = genericTypeName;
    }

    public string GenericTypeName { get; set; }
}