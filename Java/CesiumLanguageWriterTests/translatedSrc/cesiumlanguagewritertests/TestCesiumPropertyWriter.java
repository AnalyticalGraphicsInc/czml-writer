package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class TestCesiumPropertyWriter<TDerived extends CesiumPropertyWriter<TDerived>> {
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

	public final CesiumStreamWriter getWriter() {
		return backingField$Writer;
	}

	final private void setWriter(CesiumStreamWriter value) {
		backingField$Writer = value;
	}

	public final PacketCesiumWriter getPacket() {
		return backingField$Packet;
	}

	final private void setPacket(PacketCesiumWriter value) {
		backingField$Packet = value;
	}

	@Before
	public final void setUp() {
		setStringWriter(new StringWriter());
		setOutputStream(new CesiumOutputStream(getStringWriter()));
		setWriter(new CesiumStreamWriter());
		setPacket(getWriter().openPacket(getOutputStream()));
	}

	abstract protected CesiumPropertyWriter<TDerived> createPropertyWriter(String propertyName);

	@Test
	public final void writesPropertyNameOnOpenAndNothingOnClose() {
		CesiumPropertyWriter<TDerived> property = createPropertyWriter("foobar");
		property.open(getOutputStream());
		Assert.assertEquals("{\"foobar\":", getStringWriter().toString());
		property.close();
		Assert.assertEquals("{\"foobar\":", getStringWriter().toString());
	}

	@Test
	public final void singleIntervalWritesOpenObjectLiteral() {
		CesiumPropertyWriter<TDerived> property = createPropertyWriter("woot");
		property.open(getOutputStream());
		TDerived interval = property.openInterval();
		Assert.assertNotNull(interval);
		Assert.assertEquals("{\"woot\":{", getStringWriter().toString());
	}

	@Test
	public final void multipleIntervalsWritesOpenArray() {
		CesiumPropertyWriter<TDerived> property = createPropertyWriter("woot");
		property.open(getOutputStream());
		CesiumIntervalListWriter<TDerived> intervalList = property.openMultipleIntervals();
		Assert.assertNotNull(intervalList);
		Assert.assertEquals("{\"woot\":[", getStringWriter().toString());
	}

	@Test
	public final void closingMultipleIntervalsWritesCloseArray() {
		CesiumPropertyWriter<TDerived> property = createPropertyWriter("woot");
		property.open(getOutputStream());
		CesiumIntervalListWriter<TDerived> intervalList = property.openMultipleIntervals();
		intervalList.close();
		Assert.assertEquals("{\"woot\":[]", getStringWriter().toString());
	}

	@Test
	public final void multipleIntervalsAllowsWritingMultipleIntervals() {
		JulianDate start = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
		JulianDate stop = new JulianDate(new GregorianDate(2012, 4, 2, 13, 0, 0D));
		CesiumPropertyWriter<TDerived> property = createPropertyWriter("woot");
		property.open(getOutputStream());
		CesiumIntervalListWriter<TDerived> intervalList = property.openMultipleIntervals();
		{
			TDerived interval = intervalList.openInterval();
			try {
				interval.writeInterval(start, stop);
			} finally {
				DisposeHelper.dispose(interval);
			}
		}
		{
			TDerived interval = intervalList.openInterval();
			try {
				interval.writeInterval(new TimeInterval(start, stop));
			} finally {
				DisposeHelper.dispose(interval);
			}
		}
		intervalList.close();
		Assert.assertEquals("{\"woot\":[{\"interval\":\"20120402T12Z/20120402T13Z\"},{\"interval\":\"20120402T12Z/20120402T13Z\"}]", getStringWriter().toString());
	}

	@Test(expected = IllegalStateException.class)
	public final void throwsWhenWritingToBeforeOpening() {
		CesiumPropertyWriter<TDerived> property = createPropertyWriter("woot");
		property.openInterval();
	}

	@Test(expected = IllegalStateException.class)
	public final void throwsWhenWritingToAfterClosed() {
		CesiumPropertyWriter<TDerived> property = createPropertyWriter("woot");
		property.open(getOutputStream());
		property.close();
		property.openInterval();
	}

	private StringWriter backingField$StringWriter;
	private CesiumOutputStream backingField$OutputStream;
	private CesiumStreamWriter backingField$Writer;
	private PacketCesiumWriter backingField$Packet;
}