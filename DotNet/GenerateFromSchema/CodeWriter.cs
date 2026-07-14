namespace GenerateFromSchema;

public sealed class CodeWriter : IDisposable
{
    public CodeWriter(TextWriter writer)
    {
        Writer = writer;
    }

    public CodeWriter(string filename)
        : this(new StreamWriter(filename, false, Encoding.UTF8))
    {
    }

    public void Dispose()
    {
        Writer.Dispose();
    }

    public void IncreaseIndent()
    {
        SetIndent(Indent + 1);
    }

    public void DecreaseIndent()
    {
        SetIndent(Indent - 1);
    }

    public CodeScope OpenScope()
    {
        WriteLine("{");
        IncreaseIndent();

        return new CodeScope(this);
    }

    public void CloseScope()
    {
        DecreaseIndent();
        WriteLine("}");
    }

    public void WriteLine()
    {
        Writer.WriteLine();
    }

    public void WriteLine(string str)
    {
        Writer.Write(IndentString);
        Writer.WriteLine(str);
    }

    public void WriteLine([StringSyntax(StringSyntaxAttribute.CompositeFormat)] string format, params object[] args)
    {
        Writer.Write(IndentString);
        Writer.WriteLine(format, args);
    }

    private void SetIndent(int indent)
    {
        Indent = indent;
        IndentString = new string(' ', Indent * Indentation);
    }

    public sealed class CodeScope(CodeWriter writer) : IDisposable
    {
        public void Dispose()
        {
            writer.CloseScope();
        }
    }

    private const int Indentation = 4;
    private TextWriter Writer { get; }
    private int Indent { get; set; }
    private string IndentString { get; set; } = "";
}
