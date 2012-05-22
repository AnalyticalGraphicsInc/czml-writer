using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace GenerateFromSchema
{
    public class CodeWriter : IDisposable
    {
        private const int Indentation = 4;

        private readonly TextWriter m_writer;
        private int m_indent;
        private string m_indentString = "";

        public CodeWriter(TextWriter writer)
        {
            m_writer = writer;
        }

        public CodeWriter(string filename)
            : this(new StreamWriter(filename))
        {
        }

        public void Dispose()
        {
            m_writer.Dispose();
        }

        public void IncreaseIndent()
        {
            ++m_indent;
            m_indentString = new String(' ', m_indent * Indentation);
        }

        public void DecreateIndent()
        {
            --m_indent;
            m_indentString = new String(' ', m_indent * Indentation);
        }

        public void OpenScope()
        {
            WriteLine("{{");
            IncreaseIndent();
        }

        public void CloseScope()
        {
            DecreateIndent();
            WriteLine("}}");
        }

        public void WriteLine()
        {
            m_writer.WriteLine();
        }

        public void WriteLine(string format, params object[] args)
        {
            m_writer.Write(m_indentString);
            m_writer.WriteLine(format, args);
        }
    }
}
