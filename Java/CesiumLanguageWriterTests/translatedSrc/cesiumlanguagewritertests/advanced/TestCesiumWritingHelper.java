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
	public final StringWriter getStringWriter() {
		return backingField$StringWriter;
	}

	final private void setStringWriter(StringWriter value) {
		backingField$StringWriter = value;
	}

	public final CesiumOutputStream getOutputStream() {
		return backingField$OutputStream;
	}

	final private void setOutputStream(CesiumOutputStream value) {
		backingField$OutputStream = value;
	}

	@Before
	public final void setUp() {
		setStringWriter(new StringWriter());
		setOutputStream(new CesiumOutputStream(getStringWriter()));
	}

	@Test
	public final void canWriteReference() {
		CesiumWritingHelper.writeReference(getOutputStream(), new Reference("bar", "color"));
		Assert.assertEquals("{\"reference\":\"bar#color\"}", getStringWriter().toString());
	}

	@Test
	public final void canWriteReferences() {
		CesiumWritingHelper.writeReferences(getOutputStream(), agi.foundation.compatibility.ArrayHelper.arrayAsList(new cesiumlanguagewriter.Reference[] {
				new Reference("bar", "color"),
				new Reference("foo", "color2")
		}));
		Assert.assertEquals("[\"bar#color\",\"foo#color2\"]", getStringWriter().toString());
	}

	private StringWriter backingField$StringWriter;
	private CesiumOutputStream backingField$OutputStream;
	@org.junit.Rule
	public agi.foundation.compatibility.TestContextRule rule$testContext = new agi.foundation.compatibility.TestContextRule();
}