using System;

/// <summary>
/// Mark code to be renamed by the CSToJava Java conversion tool.
/// </summary>
[AttributeUsage(AttributeTargets.Class | AttributeTargets.Struct | AttributeTargets.Enum |
                AttributeTargets.Method | AttributeTargets.Property | AttributeTargets.Interface)]
[CSToJavaExclude]
[CoverageExcludeAttribute]
internal sealed class CSToJavaRenameAttribute : Attribute
{
    public CSToJavaRenameAttribute(string newName)
    {
        NewName = newName;
    }

    public string NewName { get; set; }
    public string Comment { get; set; }
}