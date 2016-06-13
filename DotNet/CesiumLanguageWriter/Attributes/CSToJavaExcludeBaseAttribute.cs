using System;
using System.Diagnostics;

/// <summary>
/// Indicate that a particular base class or interface implementation should be excluded by the 
/// CSToJava Java conversion tool.
/// </summary>
[Conditional("CSTOJAVA")]
[AttributeUsage(AttributeTargets.Class | AttributeTargets.Struct | AttributeTargets.Interface, AllowMultiple = true)]
[CSToJavaExclude]
internal class CSToJavaExcludeBaseAttribute : Attribute
{
    public CSToJavaExcludeBaseAttribute(string typeName)
    {
        TypeName = typeName;
    }

    public string TypeName { get; set; }
}