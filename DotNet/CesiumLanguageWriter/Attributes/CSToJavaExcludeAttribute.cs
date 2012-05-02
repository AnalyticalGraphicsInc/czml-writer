using System;

/// <summary>
/// Mark code to be excluded by the CSToJava Java conversion tool.
/// </summary>
[AttributeUsage(AttributeTargets.Class | AttributeTargets.Struct | AttributeTargets.Enum |
                AttributeTargets.Constructor | AttributeTargets.Method | AttributeTargets.Property |
                AttributeTargets.Field | AttributeTargets.Event | AttributeTargets.Interface |
                AttributeTargets.Delegate)]
[CSToJavaExclude]
[CoverageExcludeAttribute]
internal sealed class CSToJavaExcludeAttribute : Attribute
{
    public CSToJavaExcludeAttribute()
    {
    }

    public CSToJavaExcludeAttribute(string comment)
    {
        Comment = comment;
    }

    public string Comment { get; set; }
}