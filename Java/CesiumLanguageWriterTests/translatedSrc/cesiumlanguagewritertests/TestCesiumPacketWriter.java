package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import cesiumlanguagewriter.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCesiumPacketWriter {
	private StringWriter m_sw;
	private CesiumOutputStream m_output;
	private CesiumStreamWriter m_writer;

	@Before
	public final void setUp() {
		m_sw = new StringWriter();
		m_output = new CesiumOutputStream(m_sw);
		m_writer = new CesiumStreamWriter();
	}

	@Test
	public final void opensObjectLiteralOnOpenAndClosesItOnClose() {
		PacketCesiumWriter packet = new PacketCesiumWriter();
		packet.open(m_output);
		Assert.assertEquals("{", m_sw.toString());
		packet.close();
		Assert.assertEquals("{}", m_sw.toString());
	}

	@Test
	public final void disposeClosesPacket() {
		{
			PacketCesiumWriter packet = m_writer.openPacket(m_output);
			try {} finally {
				DisposeHelper.dispose(packet);
			}
		}
		Assert.assertEquals("{}", m_sw.toString());
	}

	@Test
	public final void idValueWritesIdProperty() {
		PacketCesiumWriter packet = m_writer.openPacket(m_output);
		packet.writeId("foo");
		packet.close();
		Assert.assertEquals("{\"id\":\"foo\"}", m_sw.toString());
	}

	@Test
	public final void availabilityValueWritesAvailabilityProperty() {
		JulianDate start = new JulianDate(new GregorianDate(2012, 4, 2, 1, 2, 3D));
		JulianDate stop = new JulianDate(new GregorianDate(2012, 4, 3, 1, 2, 3D));
		m_output.writeStartSequence();
		{
			PacketCesiumWriter packet = m_writer.openPacket(m_output);
			try {
				packet.writeAvailability(start, stop);
			} finally {
				DisposeHelper.dispose(packet);
			}
		}
		{
			PacketCesiumWriter packet = m_writer.openPacket(m_output);
			try {
				packet.writeAvailability(new TimeInterval(start, stop));
			} finally {
				DisposeHelper.dispose(packet);
			}
		}
		{
			PacketCesiumWriter packet = m_writer.openPacket(m_output);
			try {
				ArrayList<cesiumlanguagewriter.TimeInterval> intervals = new ArrayList<cesiumlanguagewriter.TimeInterval>();
				intervals.add(new TimeInterval(start, stop));
				intervals.add(new TimeInterval(start.addDays(2.0), stop.addDays(2.0)));
				packet.writeAvailability(intervals);
			} finally {
				DisposeHelper.dispose(packet);
			}
		}
		m_output.writeEndSequence();
		Assert.assertEquals("[{\"availability\":\"20120402T010203Z/20120403T010203Z\"}," + "{\"availability\":\"20120402T010203Z/20120403T010203Z\"},"
				+ "{\"availability\":[\"20120402T010203Z/20120403T010203Z\",\"20120404T010203Z/20120405T010203Z\"]}]", m_sw.toString());
	}

	@Test
	public final void positionWritesPositionProperty() {
		PacketCesiumWriter packet = m_writer.openPacket(m_output);
		PositionCesiumWriter position = packet.openPositionProperty();
		Assert.assertNotNull(position);
		Assert.assertEquals("{\"position\":", m_sw.toString());
	}

	@Test
	public final void billboardWritesBillboardProperty() {
		PacketCesiumWriter packet = m_writer.openPacket(m_output);
		{
			BillboardCesiumWriter billboard = packet.openBillboardProperty();
			try {
				Assert.assertNotNull(billboard);
			} finally {
				DisposeHelper.dispose(billboard);
			}
		}
		Assert.assertEquals("{\"billboard\":", m_sw.toString());
	}

	@org.junit.Rule
	public agi.foundation.compatibility.TestContextRule rule$testContext = new agi.foundation.compatibility.TestContextRule();
}