//Add support for coverage exclusion in NCover by adding the [CoverageExclude] attribute to any class or method.
[CSToJavaExclude]
[CoverageExcludeAttribute]
internal sealed class CoverageExcludeAttribute : System.Attribute { }