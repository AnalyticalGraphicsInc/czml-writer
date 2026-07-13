package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.TextWriterHelper;
import agi.foundation.compatibility.UriHelper;
import cesiumlanguagewriter.*;
import java.io.StringWriter;
import java.net.URI;
import javax.annotation.Nonnull;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCesiumOutputStream {
    private StringWriter m_stringWriter;
    private CesiumOutputStream m_outputStream;

    @Before
    public final void setUp() {
        m_stringWriter = new StringWriter();
        m_outputStream = new CesiumOutputStream(m_stringWriter);
    }

    @After
    public final void tearDown() {
        TextWriterHelper.close(m_stringWriter);
    }

    @Test
    public final void writesObject() {
        m_outputStream.writeStartObject();
        m_outputStream.writePropertyName("test");
        m_outputStream.writeValue("value");
        m_outputStream.writeEndObject();
        AssertHelper.assertEquals("{\"test\":\"value\"}", m_stringWriter.toString());
    }

    @Test
    public final void writesSequence() {
        m_outputStream.writeStartSequence();
        m_outputStream.writeValue(1);
        m_outputStream.writeValue(2);
        m_outputStream.writeValue(3);
        m_outputStream.writeEndSequence();
        AssertHelper.assertEquals("[1,2,3]", m_stringWriter.toString());
    }

    @Test
    public final void writesNull() {
        m_outputStream.writeStartObject();
        m_outputStream.writePropertyName("test");
        m_outputStream.writeValue((String) null);
        m_outputStream.writeEndObject();
        AssertHelper.assertEquals("{\"test\":null}", m_stringWriter.toString());
    }

    @Test
    public final void writesBoolean() {
        m_outputStream.writeStartSequence();
        m_outputStream.writeValue(true);
        m_outputStream.writeValue(false);
        m_outputStream.writeEndSequence();
        AssertHelper.assertEquals("[true,false]", m_stringWriter.toString());
    }

    @Test
    public final void writesUri() {
        URI uri = UriHelper.create("http://example.com/path?query=1");
        m_outputStream.writeStartSequence();
        m_outputStream.writeValue(uri);
        m_outputStream.writeEndSequence();
        AssertHelper.assertEquals("[\"http://example.com/path?query=1\"]", m_stringWriter.toString());
    }

    @Test
    public final void prettyFormattingAddsNewLinesAndIndent() {
        m_outputStream = new CesiumOutputStream(m_stringWriter, true);
        m_outputStream.writeStartSequence();
        m_outputStream.writeValue(1);
        m_outputStream.writeLineBreak();
        m_outputStream.writeValue(2);
        m_outputStream.writeEndSequence();
        String expected = "[" + System.lineSeparator() + "  1," + System.lineSeparator() + "  2" + System.lineSeparator() + "]";
        AssertHelper.assertEquals(expected, m_stringWriter.toString());
    }

    @Test
    public final void escapesSpecialCharactersInString() {
        final String input = "\t\n\r\f\b\\\"";
        m_outputStream.writeStartSequence();
        m_outputStream.writeValue(input);
        m_outputStream.writeEndSequence();
        AssertHelper.assertEquals("[\"\\t\\n\\r\\f\\b\\\\\\\"\"]", m_stringWriter.toString());
    }

    @Test
    public final void escapesControlCharactersAsUnicode() {
        String input = new String(new char[] {
            (char) 0x0001,
            (char) 0x001F
        });
        m_outputStream.writeStartSequence();
        m_outputStream.writeValue(input);
        m_outputStream.writeEndSequence();
        AssertHelper.assertEquals("[\"\\u0001\\u001f\"]", m_stringWriter.toString());
    }

    @Nonnull
    private static final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    @ClassRule
    public static TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}