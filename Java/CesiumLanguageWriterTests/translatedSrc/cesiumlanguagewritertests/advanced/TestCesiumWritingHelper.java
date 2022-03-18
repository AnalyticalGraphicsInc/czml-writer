package cesiumlanguagewritertests.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewritertests.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
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
public class TestCesiumWritingHelper {
    private StringWriter m_stringWriter;
    private CesiumOutputStream m_outputStream;

    @Before
    public final void setUp() {
        m_stringWriter = new StringWriter();
        m_outputStream = new CesiumOutputStream(m_stringWriter);
    }

    @Test
    public final void canWriteReference() {
        CesiumWritingHelper.writeReference(m_outputStream, new Reference("bar", "color"));
        AssertHelper.assertEquals("\"bar#color\"", m_stringWriter.toString());
    }

    @Test
    public final void canWriteReferences() {
        final ArrayList<Reference> tempCollection$0 = new ArrayList<Reference>();
        tempCollection$0.add(new Reference("bar", "color"));
        tempCollection$0.add(new Reference("foo", "color2"));
        CesiumWritingHelper.writeReferences(m_outputStream, tempCollection$0);
        AssertHelper.assertEquals("[\"bar#color\",\"foo#color2\"]", m_stringWriter.toString());
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