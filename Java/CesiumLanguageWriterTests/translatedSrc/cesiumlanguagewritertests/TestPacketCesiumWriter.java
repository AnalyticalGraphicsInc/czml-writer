package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPacketCesiumWriter {
    @Before
    public final void setUp() {
        m_stringWriter = new StringWriter();
        m_outputStream = new CesiumOutputStream(m_stringWriter);
        m_writer = new CesiumStreamWriter();
    }

    @Test
    public final void opensObjectLiteralOnOpenAndClosesItOnClose() {
        PacketCesiumWriter packet = new PacketCesiumWriter();
        packet.open(m_outputStream);
        Assert.assertEquals("{", m_stringWriter.toString());
        packet.close();
        Assert.assertEquals("{}", m_stringWriter.toString());
    }

    @Test
    public final void disposeClosesPacket() {
        {
            final PacketCesiumWriter usingExpression_0 = (m_writer.openPacket(m_outputStream));
            try {} finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        Assert.assertEquals("{}", m_stringWriter.toString());
    }

    @Test
    public final void testIdProperty() {
        PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
        packet.writeId("foo");
        packet.close();
        Assert.assertEquals("{\"id\":\"foo\"}", m_stringWriter.toString());
    }

    @Test
    public final void testDeleteProperty() {
        PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
        packet.writeId("foo");
        packet.writeDelete(true);
        packet.close();
        Assert.assertEquals("{\"id\":\"foo\",\"delete\":true}", m_stringWriter.toString());
    }

    @Test
    public final void testDescriptionProperty() {
        PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
        packet.writeDescriptionProperty("blah");
        packet.close();
        Assert.assertEquals("{\"description\":\"blah\"}", m_stringWriter.toString());
    }

    @Test
    public final void testAvailabilityProperty() {
        JulianDate start = new JulianDate(new GregorianDate(2012, 4, 2, 1, 2, 3D));
        JulianDate stop = new JulianDate(new GregorianDate(2012, 4, 3, 1, 2, 3D));
        m_outputStream.writeStartSequence();
        {
            PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
            try {
                packet.writeAvailability(start, stop);
            } finally {
                DisposeHelper.dispose(packet);
            }
        }
        {
            PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
            try {
                packet.writeAvailability(new TimeInterval(start, stop));
            } finally {
                DisposeHelper.dispose(packet);
            }
        }
        {
            PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
            try {
                final ArrayList<cesiumlanguagewriter.TimeInterval> tempCollection$0 = new ArrayList<cesiumlanguagewriter.TimeInterval>();
                tempCollection$0.add(new TimeInterval(start, stop));
                tempCollection$0.add(new TimeInterval(start.addDays(2.0), stop.addDays(2.0)));
                ArrayList<cesiumlanguagewriter.TimeInterval> intervals = tempCollection$0;
                packet.writeAvailability(intervals);
            } finally {
                DisposeHelper.dispose(packet);
            }
        }
        m_outputStream.writeEndSequence();
        Assert.assertEquals("[{\"availability\":\"20120402T010203Z/20120403T010203Z\"}," + "{\"availability\":\"20120402T010203Z/20120403T010203Z\"},"
                + "{\"availability\":[\"20120402T010203Z/20120403T010203Z\",\"20120404T010203Z/20120405T010203Z\"]}]", m_stringWriter.toString());
    }

    @Test
    public final void testPositionProperty() {
        PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
        PositionCesiumWriter position = packet.openPositionProperty();
        Assert.assertNotNull(position);
        Assert.assertEquals("{\"position\":", m_stringWriter.toString());
    }

    @Test
    public final void testBillboardProperty() {
        PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
        {
            BillboardCesiumWriter billboard = packet.openBillboardProperty();
            try {
                Assert.assertNotNull(billboard);
            } finally {
                DisposeHelper.dispose(billboard);
            }
        }
        Assert.assertEquals("{\"billboard\":", m_stringWriter.toString());
    }

    private StringWriter m_stringWriter;
    private CesiumOutputStream m_outputStream;
    private CesiumStreamWriter m_writer;
    private TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}