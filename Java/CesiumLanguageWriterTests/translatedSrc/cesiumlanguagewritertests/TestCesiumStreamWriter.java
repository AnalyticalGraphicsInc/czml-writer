package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
import java.io.StringWriter;
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
public class TestCesiumStreamWriter {
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
    public final void newPacketWritesObjectLiteral() {
        PacketCesiumWriter packet = m_writer.openPacket(m_outputStream);
        packet.close();
        AssertHelper.assertEquals("{}", m_stringWriter.toString());
    }

    @Test
    public final void successiveCallsToNewPacketReturnSameInstance() {
        m_outputStream.writeStartSequence();
        PacketCesiumWriter packet1 = m_writer.openPacket(m_outputStream);
        packet1.close();
        PacketCesiumWriter packet2 = m_writer.openPacket(m_outputStream);
        packet2.close();
        m_outputStream.writeEndSequence();
        Assert.assertSame(packet1, packet2);
    }

    @Test
    public final void multipleCallsToNewPacketWithoutCloseThrowInvalidOperationException() {
        PacketCesiumWriter unused = m_writer.openPacket(m_outputStream);
        IllegalStateException exception = AssertHelper.<IllegalStateException> assertThrows(new TypeLiteral<IllegalStateException>() {}, new Action() {
            public void invoke() {
                m_writer.openPacket(m_outputStream);
            }
        });
        AssertHelper.assertStringContains("already opened", exception.getMessage());
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