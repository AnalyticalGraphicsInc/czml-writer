package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import org.junit.Assert;
import org.junit.Test;

public class TestPropertiesOfSimpleJsonTypes extends TestCesiumPropertyWriter<BillboardCesiumWriter> {
	@Override
	protected CesiumPropertyWriter<BillboardCesiumWriter> createPropertyWriter(String propertyName) {
		return new BillboardCesiumWriter(propertyName);
	}

	@Test
	public final void stringCanBeWrittenAsSimpleString() {
		{
			PacketCesiumWriter disposable_0 = (getPacket());
			try {
				{
					StringCesiumWriter writer = new StringCesiumWriter("foo");
					try {
						writer.open(getOutputStream());
						writer.writeString("bar");
					} finally {
						DisposeHelper.dispose(writer);
					}
				}
			} finally {
				DisposeHelper.dispose(disposable_0);
			}
		}
		Assert.assertEquals("{\"foo\":\"bar\"}", getStringWriter().toString());
	}

	@Test
	public final void stringCanBeWrittenInsideInterval() {
		JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
		{
			PacketCesiumWriter disposable_1 = (getPacket());
			try {
				{
					StringCesiumWriter writer = new StringCesiumWriter("foo");
					try {
						writer.open(getOutputStream());
						writer.writeInterval(startDate, startDate.addSeconds(100.0));
						writer.writeString("bar");
					} finally {
						DisposeHelper.dispose(writer);
					}
				}
			} finally {
				DisposeHelper.dispose(disposable_1);
			}
		}
		Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"string\":\"bar\"}}", getStringWriter().toString());
	}

	@Test
	public final void doubleCanBeWrittenAsSimpleNumber() {
		{
			PacketCesiumWriter disposable_2 = (getPacket());
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
				DisposeHelper.dispose(disposable_2);
			}
		}
		Assert.assertEquals("{\"foo\":1.23}", getStringWriter().toString());
	}

	@Test
	public final void doubleCanBeWrittenInsideInterval() {
		JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
		{
			PacketCesiumWriter disposable_3 = (getPacket());
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
				DisposeHelper.dispose(disposable_3);
			}
		}
		Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"number\":1.23}}", getStringWriter().toString());
	}

	@Test
	public final void booleanCanBeWrittenAsSimpleBoolean() {
		{
			PacketCesiumWriter disposable_4 = (getPacket());
			try {
				{
					BooleanCesiumWriter writer = new BooleanCesiumWriter("foo");
					try {
						writer.open(getOutputStream());
						writer.writeBoolean(false);
					} finally {
						DisposeHelper.dispose(writer);
					}
				}
			} finally {
				DisposeHelper.dispose(disposable_4);
			}
		}
		Assert.assertEquals("{\"foo\":false}", getStringWriter().toString());
	}

	@Test
	public final void booleanCanBeWrittenInsideInterval() {
		JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
		{
			PacketCesiumWriter disposable_5 = (getPacket());
			try {
				{
					BooleanCesiumWriter writer = new BooleanCesiumWriter("foo");
					try {
						writer.open(getOutputStream());
						writer.writeInterval(startDate, startDate.addSeconds(100.0));
						writer.writeBoolean(false);
					} finally {
						DisposeHelper.dispose(writer);
					}
				}
			} finally {
				DisposeHelper.dispose(disposable_5);
			}
		}
		Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"boolean\":false}}", getStringWriter().toString());
	}

	@Test
	public final void verticalOriginCanBeWrittenAsSimpleString() {
		{
			PacketCesiumWriter disposable_6 = (getPacket());
			try {
				{
					VerticalOriginCesiumWriter writer = new VerticalOriginCesiumWriter("foo");
					try {
						writer.open(getOutputStream());
						writer.writeVerticalOrigin(CesiumVerticalOrigin.CENTER);
					} finally {
						DisposeHelper.dispose(writer);
					}
				}
			} finally {
				DisposeHelper.dispose(disposable_6);
			}
		}
		Assert.assertEquals("{\"foo\":\"CENTER\"}", getStringWriter().toString());
	}

	@Test
	public final void verticalOriginCanBeWrittenInsideInterval() {
		JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
		{
			PacketCesiumWriter disposable_7 = (getPacket());
			try {
				{
					VerticalOriginCesiumWriter writer = new VerticalOriginCesiumWriter("foo");
					try {
						writer.open(getOutputStream());
						writer.writeInterval(startDate, startDate.addSeconds(100.0));
						writer.writeVerticalOrigin(CesiumVerticalOrigin.CENTER);
					} finally {
						DisposeHelper.dispose(writer);
					}
				}
			} finally {
				DisposeHelper.dispose(disposable_7);
			}
		}
		Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"verticalOrigin\":\"CENTER\"}}", getStringWriter().toString());
	}

	@Test
	public final void horizontalOriginCanBeWrittenAsSimpleString() {
		{
			PacketCesiumWriter disposable_8 = (getPacket());
			try {
				{
					HorizontalOriginCesiumWriter writer = new HorizontalOriginCesiumWriter("foo");
					try {
						writer.open(getOutputStream());
						writer.writeHorizontalOrigin(CesiumHorizontalOrigin.CENTER);
					} finally {
						DisposeHelper.dispose(writer);
					}
				}
			} finally {
				DisposeHelper.dispose(disposable_8);
			}
		}
		Assert.assertEquals("{\"foo\":\"CENTER\"}", getStringWriter().toString());
	}

	@Test
	public final void horizontalOriginCanBeWrittenInsideInterval() {
		JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
		{
			PacketCesiumWriter disposable_9 = (getPacket());
			try {
				{
					HorizontalOriginCesiumWriter writer = new HorizontalOriginCesiumWriter("foo");
					try {
						writer.open(getOutputStream());
						writer.writeInterval(startDate, startDate.addSeconds(100.0));
						writer.writeHorizontalOrigin(CesiumHorizontalOrigin.CENTER);
					} finally {
						DisposeHelper.dispose(writer);
					}
				}
			} finally {
				DisposeHelper.dispose(disposable_9);
			}
		}
		Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"horizontalOrigin\":\"CENTER\"}}", getStringWriter().toString());
	}

	@Test
	public final void labelStyleCanBeWrittenAsSimpleString() {
		{
			PacketCesiumWriter disposable_10 = (getPacket());
			try {
				{
					LabelStyleCesiumWriter writer = new LabelStyleCesiumWriter("foo");
					try {
						writer.open(getOutputStream());
						writer.writeLabelStyle(CesiumLabelStyle.FILL_AND_OUTLINE);
					} finally {
						DisposeHelper.dispose(writer);
					}
				}
			} finally {
				DisposeHelper.dispose(disposable_10);
			}
		}
		Assert.assertEquals("{\"foo\":\"FILL_AND_OUTLINE\"}", getStringWriter().toString());
	}

	@Test
	public final void labelStyleCanBeWrittenInsideInterval() {
		JulianDate startDate = new GregorianDate(2012, 6, 7, 12, 0, 0D).toJulianDate();
		{
			PacketCesiumWriter disposable_11 = (getPacket());
			try {
				{
					LabelStyleCesiumWriter writer = new LabelStyleCesiumWriter("foo");
					try {
						writer.open(getOutputStream());
						writer.writeInterval(startDate, startDate.addSeconds(100.0));
						writer.writeLabelStyle(CesiumLabelStyle.FILL_AND_OUTLINE);
					} finally {
						DisposeHelper.dispose(writer);
					}
				}
			} finally {
				DisposeHelper.dispose(disposable_11);
			}
		}
		Assert.assertEquals("{\"foo\":{\"interval\":\"20120607T12Z/20120607T120140Z\",\"labelStyle\":\"FILL_AND_OUTLINE\"}}", getStringWriter().toString());
	}

	@org.junit.Rule
	public agi.foundation.compatibility.TestContextRule rule$testContext = new agi.foundation.compatibility.TestContextRule();
}