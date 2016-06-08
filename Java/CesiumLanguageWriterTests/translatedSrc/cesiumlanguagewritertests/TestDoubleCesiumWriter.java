package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestDoubleCesiumWriter extends TestCesiumPropertyWriter<DoubleCesiumWriter> {
	@Test
	public final void doubleCanBeWrittenAsSimpleNumber() {
		{
			PacketCesiumWriter disposable_0 = (getPacket());
			try {
				{
					DoubleCesiumWriter writer = new DoubleCesiumWriter("foo");
					try {
						writer.open(getOutputStream());
						writer.writeNumber(1.23);
					} finally {
						DisposeHelper.dispose(writer);
					}
				}
			} finally {
				DisposeHelper.dispose(disposable_0);
			}
		}
		Assert.assertEquals("{\"foo\":1.23}", getStringWriter().toString());
	}

	@Test
	public final void doubleCanBeWrittenInsideInterval() {
		JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
		{
			PacketCesiumWriter disposable_1 = (getPacket());
			try {
				{
					DoubleCesiumWriter writer = new DoubleCesiumWriter("foo");
					try {
						writer.open(getOutputStream());
						writer.writeInterval(startDate, startDate.addSeconds(100.0));
						writer.writeNumber(1.23);
					} finally {
						DisposeHelper.dispose(writer);
					}
				}
			} finally {
				DisposeHelper.dispose(disposable_1);
			}
		}
		Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"number\":1.23}}", getStringWriter().toString());
	}

	@Override
	protected CesiumPropertyWriter<DoubleCesiumWriter> createPropertyWriter(String propertyName) {
		return new DoubleCesiumWriter(propertyName);
	}

	private TestContextRule rule$testContext = new TestContextRule();

	@Rule
	public TestContextRule getRule$testContext() {
		return rule$testContext;
	}
}