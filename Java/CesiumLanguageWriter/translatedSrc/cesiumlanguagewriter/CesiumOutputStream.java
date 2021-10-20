package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.IntHelper;
import agi.foundation.compatibility.LongHelper;
import agi.foundation.compatibility.TextWriterHelper;
import java.io.Writer;
import java.net.URI;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * A stream to which raw CZML data can be written.  This is a low-level class that
 does not extensively validate that methods are called in a valid order,
 so it can be used to generate invalid JSON.
 */
@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public class CesiumOutputStream {
    /**
    * Initializes a new instance.
    * @param writer The writer to which data will be written.
    */
    public CesiumOutputStream(@Nonnull Writer writer) {
        if (writer == null) {
            throw new ArgumentNullException("writer");
        }
        m_writer = writer;
    }

    /**
    * Initializes a new instance.
    * @param writer The writer to which data will be written.
    * @param prettyFormatting Whether or not the written data should be formatted for easy human readability.
    */
    public CesiumOutputStream(@Nonnull Writer writer, boolean prettyFormatting) {
        this(writer);
        m_prettyFormatting = prettyFormatting;
    }

    /**
    * Gets a value indicating whether or not the written data should be formatted for easy human readability.
    When this property is {@code false} (the default), more compact CZML is generated.
    */
    public final boolean getPrettyFormatting() {
        return m_prettyFormatting;
    }

    /**
    * Sets a value indicating whether or not the written data should be formatted for easy human readability.
    When this property is {@code false} (the default), more compact CZML is generated.
    */
    public final void setPrettyFormatting(boolean value) {
        m_prettyFormatting = value;
    }

    /**
    * Writes the start of an object.
    */
    public void writeStartObject() {
        m_nextValueOnNewLine = true;
        startNewValue();
        TextWriterHelper.write(m_writer, '{');
        m_firstInContainer = true;
        m_inProperty = false;
        increaseIndent();
    }

    /**
    * Writes the end of an object.
    */
    public void writeEndObject() {
        m_firstInContainer = false;
        decreaseIndent();
        if (m_prettyFormatting) {
            TextWriterHelper.writeLine(m_writer);
            writeIndent();
        }
        TextWriterHelper.write(m_writer, '}');
    }

    /**
    * Writes the start of a sequence.
    */
    public void writeStartSequence() {
        m_nextValueOnNewLine = true;
        startNewValue();
        TextWriterHelper.write(m_writer, '[');
        m_firstInContainer = true;
        m_inProperty = false;
        increaseIndent();
    }

    /**
    * Writes the end of a sequence.
    */
    public void writeEndSequence() {
        m_firstInContainer = false;
        decreaseIndent();
        if (m_prettyFormatting) {
            TextWriterHelper.writeLine(m_writer);
            writeIndent();
        }
        TextWriterHelper.write(m_writer, ']');
    }

    /**
    * Writes the name of a property.
    * @param propertyName The name of the property.
    */
    public void writePropertyName(@Nonnull String propertyName) {
        if (propertyName == null) {
            throw new ArgumentNullException("propertyName");
        }
        m_nextValueOnNewLine = true;
        startNewValue();
        TextWriterHelper.write(m_writer, '"');
        writeEscapedString(propertyName);
        TextWriterHelper.write(m_writer, '"');
        TextWriterHelper.write(m_writer, ':');
        m_firstInContainer = true;
        m_inProperty = true;
    }

    /**
    * Writes the value of a property or element in a sequence.
    * @param value The value to write.
    */
    public void writeValue(@Nullable String value) {
        startNewValue();
        m_firstInContainer = false;
        m_inProperty = false;
        if (value == null) {
            TextWriterHelper.write(m_writer, "null");
        } else {
            TextWriterHelper.write(m_writer, '"');
            writeEscapedString(value);
            TextWriterHelper.write(m_writer, '"');
        }
    }

    /**
    * Writes the value of a property or element in a sequence.
    * @param value The value to write.
    */
    public void writeValue(double value) {
        startNewValue();
        m_firstInContainer = false;
        m_inProperty = false;
        TextWriterHelper.write(m_writer, DoubleHelper.toString(value, "R", CultureInfoHelper.getInvariantCulture()));
    }

    /**
    * Writes the value of a property or element in a sequence.
    * @param value The value to write.
    */
    public void writeValue(int value) {
        writeRawValueString(IntHelper.toString(value, CultureInfoHelper.getInvariantCulture()));
    }

    /**
    * Writes the value of a property or element in a sequence.
    * @param value The value to write.
    */
    public void writeValue(long value) {
        writeRawValueString(LongHelper.toString(value, CultureInfoHelper.getInvariantCulture()));
    }

    /**
    * Writes the value of a property or element in a sequence.
    * @param value The value to write.
    */
    public void writeValue(boolean value) {
        writeRawValueString(value ? "true" : "false");
    }

    private final void writeRawValueString(String s) {
        startNewValue();
        m_firstInContainer = false;
        m_inProperty = false;
        TextWriterHelper.write(m_writer, s);
    }

    /**
    * Writes the value of a property or element in a sequence.
    * @param value The value to write.
    */
    public void writeValue(@Nonnull URI value) {
        if (value == null) {
            throw new ArgumentNullException("value");
        }
        writeValue(value.toString());
    }

    /**
    * When {@code PrettyFormatting} ({@link #getPrettyFormatting get} / {@link #setPrettyFormatting set}) is {@code true}, adds a line break in a sequence of simple values.
    When {@code PrettyFormatting} ({@link #getPrettyFormatting get} / {@link #setPrettyFormatting set}) is {@code false}, this method does nothing.
    */
    public void writeLineBreak() {
        m_nextValueOnNewLine = true;
    }

    private final void writeEscapedString(@Nonnull String value) {
        int lastWritePosition = 0;
        int skipped = 0;
        char[] chars = null;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            String escapedValue;
            // Paragraph Separator
            switch (c) {
            case '\t': {
                escapedValue = "\\t";
                break;
            }
            case '\n': {
                escapedValue = "\\n";
                break;
            }
            case '\r': {
                escapedValue = "\\r";
                break;
            }
            case '\f': {
                escapedValue = "\\f";
                break;
            }
            case '\b': {
                escapedValue = "\\b";
                break;
            }
            case '\\': {
                escapedValue = "\\\\";
                break;
            }
            case '\u0085': {
                escapedValue = "\\u0085";
                break;
            }
            case '\u2028': {
                escapedValue = "\\u2028";
                break;
            }
            case '\u2029': {
                escapedValue = "\\u2029";
                break;
            }
            case '"': {
                escapedValue = "\\\"";
                break;
            }
            default: {
                escapedValue = c <= '\u001f' ? toCharAsUnicode(c) : null;
                break;
            }
            }
            if (escapedValue != null) {
                if (chars == null) {
                    chars = value.toCharArray();
                }
                // write skipped text
                if (skipped > 0) {
                    TextWriterHelper.write(m_writer, chars, lastWritePosition, skipped);
                    skipped = 0;
                }
                // write escaped value and note position
                TextWriterHelper.write(m_writer, escapedValue);
                lastWritePosition = i + 1;
            } else {
                skipped++;
            }
        }
        // write any remaining skipped text
        if (skipped > 0) {
            if (lastWritePosition == 0) {
                TextWriterHelper.write(m_writer, value);
            } else {
                TextWriterHelper.write(m_writer, chars, lastWritePosition, skipped);
            }
        }
    }

    @Nonnull
    private static String toCharAsUnicode(char c) {
        char h1 = intToHex((c >>> 12) & '\u000f');
        char h2 = intToHex((c >>> 8) & '\u000f');
        char h3 = intToHex((c >>> 4) & '\u000f');
        char h4 = intToHex(c & '\u000f');
        return new String(new char[] {
            '\\',
            'u',
            h1,
            h2,
            h3,
            h4
        });
    }

    private static char intToHex(int n) {
        if (n <= 9) {
            return (char) (n + 48);
        }
        return (char) (n - 10 + 97);
    }

    private final void startNewValue() {
        if (m_firstInStream) {
            m_firstInStream = false;
            return;
        }
        if (!m_firstInContainer) {
            TextWriterHelper.write(m_writer, ',');
        }
        if (!m_inProperty && m_prettyFormatting && m_nextValueOnNewLine) {
            TextWriterHelper.writeLine(m_writer);
            writeIndent();
            m_nextValueOnNewLine = false;
        }
    }

    private final void increaseIndent() {
        m_indent += IndentLevel;
    }

    private final void decreaseIndent() {
        m_indent -= IndentLevel;
    }

    private final void writeIndent() {
        for (int i = 0; i < m_indent; ++i) {
            TextWriterHelper.write(m_writer, ' ');
        }
    }

    @Nonnull
    private Writer m_writer;
    private boolean m_firstInStream = true;
    private boolean m_firstInContainer = true;
    private boolean m_inProperty;
    private boolean m_nextValueOnNewLine;
    private int m_indent = 0;
    private boolean m_prettyFormatting;
    private static final int IndentLevel = 2;
}