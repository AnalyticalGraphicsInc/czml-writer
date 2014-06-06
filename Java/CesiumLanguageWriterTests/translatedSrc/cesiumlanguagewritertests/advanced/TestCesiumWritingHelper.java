package cesiumlanguagewritertests.advanced;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewritertests.*;
import java.io.StringWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@org.junit.FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCesiumWritingHelper {
	@Before
	public final void setUp() {
		m_stringWriter = new StringWriter();
		m_outputStream = new CesiumOutputStream(m_stringWriter);
	}

	@Test
	public final void canWriteReference() {
		CesiumWritingHelper.writeReference(m_outputStream, new Reference("bar", "color"));
		Assert.assertEquals("\"bar#color\"", m_stringWriter.toString());
	}

	@Test
	public final void canWriteReferences() {
		CesiumWritingHelper.writeReferences(m_outputStream, agi.foundation.compatibility.ArrayHelper.arrayAsList(new cesiumlanguagewriter.Reference[] {
				new Reference("bar", "color"),
				new Reference("foo", "color2")
		}));
		Assert.assertEquals("[\"bar#color\",\"foo#color2\"]", m_stringWriter.toString());
	}

	private StringWriter m_stringWriter;
	private CesiumOutputStream m_outputStream;
	@org.junit.Rule
	public agi.foundation.compatibility.TestContextRule rule$testContext = new agi.foundation.compatibility.TestContextRule();
}