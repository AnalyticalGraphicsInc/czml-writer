using System;
using System.Globalization;
using System.IO;

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// A stream to which raw <topic name="Cesium">Cesium</topic> data can be written.  This is a low-level class that
    /// does not extensively validate that methods are called in a valid order, so it can be used to generated invalid
    /// Cesium and JSON.
    /// </summary>
    public class CesiumOutputStream : IDisposable
    {
        private readonly TextWriter m_writer;
        private bool m_firstInContainer = true;
        private bool m_inProperty;
        private bool m_nextValueOnNewLine;
        private int m_indent = 0;
        private const int IndentLevel = 2;

        /// <summary>
        /// Initializes a new instance.
        /// </summary>
        /// <param name="writer">The text stream to which to write data.</param>
        public CesiumOutputStream(TextWriter writer)
        {
            m_writer = writer;
        }

        /// <summary>
        /// Flushes data to the underlying text writer, but does not close it.
        /// </summary>
        public void Dispose()
        {
            // No need to do anything, because we're not doing any buffering.
        }

        /// <summary>
        /// Gets or sets a value indicating whether or not the written data should be formatted for easy human readability.
        /// When this property is <see langword="false"/> (the default), more compact Cesium is generated.
        /// </summary>
        public bool PrettyFormatting { get; set; }

        /// <summary>
        /// Writes the start of an object.
        /// </summary>
        public void WriteStartObject()
        {
            m_nextValueOnNewLine = true;
            StartNewValue();
            m_writer.Write('{');
            m_firstInContainer = true;
            m_inProperty = false;
            m_indent += IndentLevel;
        }

        /// <summary>
        /// Writes the end of an object.
        /// </summary>
        public void WriteEndObject()
        {
            m_firstInContainer = false;
            m_indent -= IndentLevel;

            if (PrettyFormatting)
            {
                m_writer.WriteLine();
                WriteIndent();
            }
            m_writer.Write('}');
        }

        /// <summary>
        /// Writes the start of a sequence.
        /// </summary>
        public void WriteStartSequence()
        {
            m_nextValueOnNewLine = true;
            StartNewValue();
            m_writer.Write('[');
            m_firstInContainer = true;
            m_inProperty = false;
            m_indent += IndentLevel;
        }

        /// <summary>
        /// Writes the end of a sequence.
        /// </summary>
        public void WriteEndSequence()
        {
            m_firstInContainer = false;
            m_indent -= IndentLevel;

            if (PrettyFormatting)
            {
                m_writer.WriteLine();
                WriteIndent();
            }
            m_writer.Write(']');
        }

        /// <summary>
        /// Writes the name of a property.
        /// </summary>
        /// <param name="propertyName"></param>
        public void WritePropertyName(string propertyName)
        {
            m_nextValueOnNewLine = true;
            StartNewValue();
            m_writer.Write('"');
            WriteEscapedString(m_writer, propertyName);
            m_writer.Write('"');
            m_writer.Write(':');
            m_firstInContainer = true;
            m_inProperty = true;
        }

        /// <summary>
        /// Writes the value of a property or element in a sequence.
        /// </summary>
        /// <param name="value">The value to write.</param>
        public void WriteValue(string value)
        {
            StartNewValue();
            m_firstInContainer = false;
            m_inProperty = false;

            if (value == null)
            {
                m_writer.Write("null");
            }
            else
            {
                m_writer.Write('"');
                WriteEscapedString(m_writer, value);
                m_writer.Write('"');
            }
        }

        /// <summary>
        /// Writes the value of a property or element in a sequence.
        /// </summary>
        /// <param name="value">The value to write.</param>
        public void WriteValue(double value)
        {
            StartNewValue();
            m_firstInContainer = false;
            m_inProperty = false;
#if CSToJava
            m_writer.Write(value);
#else
            grisu.net.Grisu.DoubleToString(value, m_writer);
#endif
        }

        /// <summary>
        /// Writes the value of a property or element in a sequence.
        /// </summary>
        /// <param name="value">The value to write.</param>
        public void WriteValue(int value)
        {
            StartNewValue();
            m_firstInContainer = false;
            m_inProperty = false;
            m_writer.Write(value.ToString(CultureInfo.InvariantCulture));
        }

        /// <summary>
        /// Writes the value of a property or element in a sequence.
        /// </summary>
        /// <param name="value">The value to write.</param>
        public void WriteValue(long value)
        {
            StartNewValue();
            m_firstInContainer = false;
            m_inProperty = false;
            m_writer.Write(value.ToString(CultureInfo.InvariantCulture));
        }

        /// <summary>
        /// Writes the value of a property or element in a sequence.
        /// </summary>
        /// <param name="value">The value to write.</param>
        public void WriteValue(bool value)
        {
            StartNewValue();
            m_firstInContainer = false;
            m_inProperty = false;
            m_writer.Write(value ? "true" : "false");
        }

        /// <summary>
        /// When <see cref="PrettyFormatting"/> is <see langword="true"/>, adds a line break in a sequence of simple values.
        /// When <see cref="PrettyFormatting"/> is <see langword="false"/>, this method does nothing.
        /// </summary>
        public void WriteLineBreak()
        {
            m_nextValueOnNewLine = true;
        }

        private static void WriteEscapedString(TextWriter writer, string value)
        {
            int lastWritePosition = 0;
            int skipped = 0;
            char[] chars = null;

            for (int i = 0; i < value.Length; i++)
            {
                char c = value[i];
                string escapedValue;

                switch (c)
                {
                    case '\t':
                        escapedValue = @"\t";
                        break;
                    case '\n':
                        escapedValue = @"\n";
                        break;
                    case '\r':
                        escapedValue = @"\r";
                        break;
                    case '\f':
                        escapedValue = @"\f";
                        break;
                    case '\b':
                        escapedValue = @"\b";
                        break;
                    case '\\':
                        escapedValue = @"\\";
                        break;
                    case '\u0085': // Next Line
                        escapedValue = @"\u0085";
                        break;
                    case '\u2028': // Line Separator
                        escapedValue = @"\u2028";
                        break;
                    case '\u2029': // Paragraph Separator
                        escapedValue = @"\u2029";
                        break;
                    case '"':
                        escapedValue = "\\\"";
                        break;
                    default:
                        escapedValue = (c <= '\u001f') ? ToCharAsUnicode(c) : null;
                        break;
                }

                if (escapedValue != null)
                {
                    if (chars == null)
                        chars = value.ToCharArray();

                    // write skipped text
                    if (skipped > 0)
                    {
                        writer.Write(chars, lastWritePosition, skipped);
                        skipped = 0;
                    }

                    // write escaped value and note position
                    writer.Write(escapedValue);
                    lastWritePosition = i + 1;
                }
                else
                {
                    skipped++;
                }
            }

            // write any remaining skipped text
            if (skipped > 0)
            {
                if (lastWritePosition == 0)
                    writer.Write(value);
                else
                    writer.Write(chars, lastWritePosition, skipped);
            }
        }

        private static string ToCharAsUnicode(char c)
        {
            char h1 = IntToHex((c >> 12) & '\x000f');
            char h2 = IntToHex((c >> 8) & '\x000f');
            char h3 = IntToHex((c >> 4) & '\x000f');
            char h4 = IntToHex(c & '\x000f');

            return new string(new[] { '\\', 'u', h1, h2, h3, h4 });
        }

        private static char IntToHex(int n)
        {
            if (n <= 9)
            {
                return (char)(n + 48);
            }
            return (char)((n - 10) + 97);
        }

        private void StartNewValue()
        {
            if (!m_firstInContainer)
            {
                m_writer.Write(',');
            }
            if (!m_inProperty && PrettyFormatting && m_nextValueOnNewLine)
            {
                m_writer.WriteLine();
                WriteIndent();
                m_nextValueOnNewLine = false;
            }
        }

        private void WriteIndent()
        {
            for (int i = 0; i < m_indent; ++i)
                m_writer.Write(' ');
        }
    }
}