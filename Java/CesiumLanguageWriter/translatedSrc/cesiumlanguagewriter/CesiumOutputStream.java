package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.CultureInfoHelper;
import agi.foundation.compatibility.DoubleHelper;
import agi.foundation.compatibility.IntHelper;
import agi.foundation.compatibility.LongHelper;
import agi.foundation.compatibility.TextWriterHelper;
import java.io.Writer;
import java.net.URI;

/**
 *  
 A stream to which raw CZML data can be written.  This is a low-level class that
 does not extensively validate that methods are called in a valid order,
 so it can be used to generate invalid JSON.
 

 */
public class CesiumOutputStream {
    private Writer m_writer;
    private boolean m_firstInContainer = true;
    private boolean m_inProperty;
    private boolean m_nextValueOnNewLine;
    private int m_indent = 0;
    private static final int IndentLevel = 2;

    /**
    *  
    Initializes a new instance.
    
    

    * @param writer The text stream to which to write data.
    */
    public CesiumOutputStream(Writer writer) {
        m_writer = writer;
    }

    /**
    *  Gets whether or not the written data should be formatted for easy human readability.
    When this property is {@code false} (the default), more compact Cesium is generated.
    

    */
    public final boolean getPrettyFormatting() {
        return backingField$PrettyFormatting;
    }

    /**
    *  Sets whether or not the written data should be formatted for easy human readability.
    When this property is {@code false} (the default), more compact Cesium is generated.
    

    */
    public final void setPrettyFormatting(boolean value) {
        backingField$PrettyFormatting = value;
    }

    /**
    *  
    Writes the start of an object.
    

    */
    public final void writeStartObject() {
        m_nextValueOnNewLine = true;
        startNewValue();
        TextWriterHelper.print(m_writer, '{');
        m_firstInContainer = true;
        m_inProperty = false;
        m_indent += IndentLevel;
    }

    /**
    *  
    Writes the end of an object.
    

    */
    public final void writeEndObject() {
        m_firstInContainer = false;
        m_indent -= IndentLevel;
        if (getPrettyFormatting()) {
            TextWriterHelper.writeLine(m_writer);
            writeIndent();
        }
        TextWriterHelper.print(m_writer, '}');
    }

    /**
    *  
    Writes the start of a sequence.
    

    */
    public final void writeStartSequence() {
        m_nextValueOnNewLine = true;
        startNewValue();
        TextWriterHelper.print(m_writer, '[');
        m_firstInContainer = true;
        m_inProperty = false;
        m_indent += IndentLevel;
    }

    /**
    *  
    Writes the end of a sequence.
    

    */
    public final void writeEndSequence() {
        m_firstInContainer = false;
        m_indent -= IndentLevel;
        if (getPrettyFormatting()) {
            TextWriterHelper.writeLine(m_writer);
            writeIndent();
        }
        TextWriterHelper.print(m_writer, ']');
    }

    /**
    *  
    Writes the name of a property.
    
    

    * @param propertyName The name of the property.
    */
    public final void writePropertyName(String propertyName) {
        m_nextValueOnNewLine = true;
        startNewValue();
        TextWriterHelper.print(m_writer, '"');
        writeEscapedString(m_writer, propertyName);
        TextWriterHelper.print(m_writer, '"');
        TextWriterHelper.print(m_writer, ':');
        m_firstInContainer = true;
        m_inProperty = true;
    }

    /**
    *  
    Writes the value of a property or element in a sequence.
    
    

    * @param value The value to write.
    */
    public final void writeValue(String value) {
        startNewValue();
        m_firstInContainer = false;
        m_inProperty = false;
        if (value == null) {
            TextWriterHelper.print(m_writer, "null");
        } else {
            TextWriterHelper.print(m_writer, '"');
            writeEscapedString(m_writer, value);
            TextWriterHelper.print(m_writer, '"');
        }
    }

    /**
    *  
    Writes the value of a property or element in a sequence.
    
    

    * @param value The value to write.
    */
    public final void writeValue(double value) {
        startNewValue();
        m_firstInContainer = false;
        m_inProperty = false;
        TextWriterHelper.print(m_writer, DoubleHelper.toString(value, "R", CultureInfoHelper.getInvariantCulture()));
    }

    /**
    *  
    Writes the value of a property or element in a sequence.
    
    

    * @param value The value to write.
    */
    public final void writeValue(int value) {
        startNewValue();
        m_firstInContainer = false;
        m_inProperty = false;
        TextWriterHelper.print(m_writer, IntHelper.toString(value, CultureInfoHelper.getInvariantCulture()));
    }

    /**
    *  
    Writes the value of a property or element in a sequence.
    
    

    * @param value The value to write.
    */
    public final void writeValue(long value) {
        startNewValue();
        m_firstInContainer = false;
        m_inProperty = false;
        TextWriterHelper.print(m_writer, LongHelper.toString(value, CultureInfoHelper.getInvariantCulture()));
    }

    /**
    *  
    Writes the value of a property or element in a sequence.
    
    

    * @param value The value to write.
    */
    public final void writeValue(boolean value) {
        startNewValue();
        m_firstInContainer = false;
        m_inProperty = false;
        TextWriterHelper.print(m_writer, value ? "true" : "false");
    }

    /**
    *  
    Writes the value of a property or element in a sequence.
    
    

    * @param value The value to write.
    */
    public final void writeValue(URI value) {
        writeValue(value.toString());
    }

    /**
    *  
    When {@code PrettyFormatting} ({@link #getPrettyFormatting get} / {@link #setPrettyFormatting set}) is {@code true}, adds a line break in a sequence of simple values.
    When {@code PrettyFormatting} ({@link #getPrettyFormatting get} / {@link #setPrettyFormatting set}) is {@code false}, this method does nothing.
    

    */
    public final void writeLineBreak() {
        m_nextValueOnNewLine = true;
    }

    private static void writeEscapedString(Writer writer, String value) {
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
                escapedValue = (c <= '\u001f') ? toCharAsUnicode(c) : null;
                break;
            }
            }
            if (escapedValue != null) {
                if (chars == null) {
                    chars = value.toCharArray();
                }
                // write skipped text
                if (skipped > 0) {
                    TextWriterHelper.print(writer, chars, lastWritePosition, skipped);
                    skipped = 0;
                }
                // write escaped value and note position
                TextWriterHelper.print(writer, escapedValue);
                lastWritePosition = i + 1;
            } else {
                skipped++;
            }
        }
        // write any remaining skipped text
        if (skipped > 0) {
            if (lastWritePosition == 0) {
                TextWriterHelper.print(writer, value);
            } else {
                TextWriterHelper.print(writer, chars, lastWritePosition, skipped);
            }
        }
    }

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
        return (char) ((n - 10) + 97);
    }

    private final void startNewValue() {
        if (!m_firstInContainer) {
            TextWriterHelper.print(m_writer, ',');
        }
        if (!m_inProperty && getPrettyFormatting() && m_nextValueOnNewLine) {
            TextWriterHelper.writeLine(m_writer);
            writeIndent();
            m_nextValueOnNewLine = false;
        }
    }

    private final void writeIndent() {
        for (int i = 0; i < m_indent; ++i)
            TextWriterHelper.print(m_writer, ' ');
    }

    private boolean backingField$PrettyFormatting;
}