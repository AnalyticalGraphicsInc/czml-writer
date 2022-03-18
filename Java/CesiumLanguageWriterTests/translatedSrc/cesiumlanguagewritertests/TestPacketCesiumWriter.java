package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import org.junit.Assert;
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
public class TestPacketCesiumWriter {
    private StringWriter m_stringWriter;
    private CesiumOutputStream m_outputStream;
    private CesiumStreamWriter m_writer;

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
        AssertHelper.assertEquals("{", m_stringWriter.toString());
        packet.close();
        AssertHelper.assertEquals("{}", m_stringWriter.toString());
    }

    @Test
    public final void disposeClosesPacket() {
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(m_writer.openPacket(m_outputStream))) {}
        AssertHelper.assertEquals("{}", m_stringWriter.toString());
    }

    @Test
    public final void testIdProperty() {
        PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
        packet.writeId("foo");
        packet.close();
        AssertHelper.assertEquals("{\"id\":\"foo\"}", m_stringWriter.toString());
    }

    @Test
    public final void testDeleteProperty() {
        PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
        packet.writeId("foo");
        packet.writeDelete(true);
        packet.close();
        AssertHelper.assertEquals("{\"id\":\"foo\",\"delete\":true}", m_stringWriter.toString());
    }

    @Test
    public final void testDescriptionProperty() {
        PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
        packet.writeDescriptionProperty("blah");
        packet.close();
        AssertHelper.assertEquals("{\"description\":\"blah\"}", m_stringWriter.toString());
    }

    @Test
    public final void testAvailabilityProperty() {
        JulianDate start = new GregorianDate(2012, 4, 2, 1, 2, 3D).toJulianDate();
        JulianDate stop = new GregorianDate(2012, 4, 3, 1, 2, 3D).toJulianDate();
        m_outputStream.writeStartSequence();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(m_writer.openPacket(m_outputStream))) {
            final PacketCesiumWriter packet = using$0.resource;
            packet.writeAvailability(start, stop);
        }
        try (Using<PacketCesiumWriter> using$1 = new Using<PacketCesiumWriter>(m_writer.openPacket(m_outputStream))) {
            final PacketCesiumWriter packet = using$1.resource;
            packet.writeAvailability(new TimeInterval(start, stop));
        }
        try (Using<PacketCesiumWriter> using$2 = new Using<PacketCesiumWriter>(m_writer.openPacket(m_outputStream))) {
            final PacketCesiumWriter packet = using$2.resource;
            final ArrayList<TimeInterval> tempCollection$0 = new ArrayList<TimeInterval>();
            tempCollection$0.add(new TimeInterval(start, stop));
            tempCollection$0.add(new TimeInterval(start.addDays(2.0), stop.addDays(2.0)));
            ArrayList<TimeInterval> intervals = tempCollection$0;
            packet.writeAvailability(intervals);
        }
        m_outputStream.writeEndSequence();
        final String expected = "[" + "{\"availability\":\"20120402T010203Z/20120403T010203Z\"}," + "{\"availability\":\"20120402T010203Z/20120403T010203Z\"},"
                + "{\"availability\":[\"20120402T010203Z/20120403T010203Z\",\"20120404T010203Z/20120405T010203Z\"]}" + "]";
        AssertHelper.assertEquals(expected, m_stringWriter.toString());
    }

    @Test
    public final void testPositionProperty() {
        PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
        PositionCesiumWriter position = packet.openPositionProperty();
        Assert.assertNotNull(position);
        AssertHelper.assertEquals("{\"position\":", m_stringWriter.toString());
    }

    @Test
    public final void testBillboardProperty() {
        PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
        try (Using<BillboardCesiumWriter> using$0 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
            final BillboardCesiumWriter billboard = using$0.resource;
            Assert.assertNotNull(billboard);
        }
        AssertHelper.assertEquals("{\"billboard\":", m_stringWriter.toString());
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