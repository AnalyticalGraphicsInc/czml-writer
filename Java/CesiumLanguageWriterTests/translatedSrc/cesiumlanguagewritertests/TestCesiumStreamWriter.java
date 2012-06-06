package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.*;
import java.io.StringWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCesiumStreamWriter {
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
	public final void newPacketWritesObjectLiteral() {
		PacketCesiumWriter packet = m_writer.openPacket(m_output);
		packet.close();
		Assert.assertEquals("{}", m_sw.toString());
	}

	@Test
	public final void successiveCallsToNewPacketReturnSameInstance() {
		m_output.writeStartSequence();
		PacketCesiumWriter packet1 = m_writer.openPacket(m_output);
		packet1.close();
		PacketCesiumWriter packet2 = m_writer.openPacket(m_output);
		packet2.close();
		m_output.writeEndSequence();
		Assert.assertSame(packet1, packet2);
	}

	@Test(expected = IllegalStateException.class)
	public final void multipleCallsToNewPacketWithoutCloseThrowInvalidOperationException() {
		PacketCesiumWriter packet = m_writer.openPacket(m_output);
		packet = m_writer.openPacket(m_output);
	}
}