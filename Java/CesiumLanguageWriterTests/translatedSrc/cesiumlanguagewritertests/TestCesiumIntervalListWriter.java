package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.TextWriterHelper;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import java.io.StringWriter;
import javax.annotation.Nonnull;
import org.junit.After;
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
public class TestCesiumIntervalListWriter {
    private StringWriter m_stringWriter;
    private CesiumOutputStream m_outputStream;
    private CesiumStreamWriter m_streamWriter;

    @Before
    public final void setUp() {
        m_stringWriter = new StringWriter();
        m_outputStream = new CesiumOutputStream(m_stringWriter);
        m_streamWriter = new CesiumStreamWriter();
    }

    @After
    public final void tearDown() {
        TextWriterHelper.close(m_stringWriter);
    }

    @Test
    public final void openAndCloseIntervalListWritesArrayDelimiters() {
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(m_streamWriter.openPacket(m_outputStream))) {
            try (Using<CustomCesiumWriter> using$1 = new Using<CustomCesiumWriter>(new CustomCesiumWriter("test"))) {
                final CustomCesiumWriter propertyWriter = using$1.resource;
                propertyWriter.open(m_outputStream);
                try (Using<CesiumIntervalListWriter<CustomCesiumWriter>> using$2 = new Using<CesiumIntervalListWriter<CustomCesiumWriter>>(
                        new CesiumIntervalListWriter<CustomCesiumWriter>(propertyWriter))) {
                    final CesiumIntervalListWriter<CustomCesiumWriter> intervalListWriter = using$2.resource;
                    intervalListWriter.open(m_outputStream);
                }
            }
        }
        AssertHelper.assertEquals("{\"test\":[]}", m_stringWriter.toString());
    }

    @Test
    public final void delegatesIntervalOpeningToPropertyWriter() {
        JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        JulianDate stop = new GregorianDate(2012, 4, 2, 13, 0, 0.0).toJulianDate();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(m_streamWriter.openPacket(m_outputStream))) {
            try (Using<CustomCesiumWriter> using$1 = new Using<CustomCesiumWriter>(new CustomCesiumWriter("test"))) {
                final CustomCesiumWriter propertyWriter = using$1.resource;
                propertyWriter.open(m_outputStream);
                try (Using<CesiumIntervalListWriter<CustomCesiumWriter>> using$2 = new Using<CesiumIntervalListWriter<CustomCesiumWriter>>(
                        new CesiumIntervalListWriter<CustomCesiumWriter>(propertyWriter))) {
                    final CesiumIntervalListWriter<CustomCesiumWriter> intervalListWriter = using$2.resource;
                    intervalListWriter.open(m_outputStream);
                    try (Using<CustomCesiumWriter> using$3 = new Using<CustomCesiumWriter>(intervalListWriter.openInterval(start, stop))) {}
                }
            }
        }
        AssertHelper.assertEquals("{\"test\":[{\"interval\":\"20120402T12Z/20120402T13Z\"}]}", m_stringWriter.toString());
    }

    @Test
    public final void intervalListWritesMultipleIntervals() {
        JulianDate firstStart = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        JulianDate firstStop = new GregorianDate(2012, 4, 2, 13, 0, 0.0).toJulianDate();
        JulianDate secondStart = new GregorianDate(2012, 4, 2, 13, 0, 0.0).toJulianDate();
        JulianDate secondStop = new GregorianDate(2012, 4, 2, 14, 0, 0.0).toJulianDate();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(m_streamWriter.openPacket(m_outputStream))) {
            try (Using<CustomCesiumWriter> using$1 = new Using<CustomCesiumWriter>(new CustomCesiumWriter("test"))) {
                final CustomCesiumWriter propertyWriter = using$1.resource;
                propertyWriter.open(m_outputStream);
                try (Using<CesiumIntervalListWriter<CustomCesiumWriter>> using$2 = new Using<CesiumIntervalListWriter<CustomCesiumWriter>>(
                        new CesiumIntervalListWriter<CustomCesiumWriter>(propertyWriter))) {
                    final CesiumIntervalListWriter<CustomCesiumWriter> intervalListWriter = using$2.resource;
                    intervalListWriter.open(m_outputStream);
                    try (Using<CustomCesiumWriter> using$3 = new Using<CustomCesiumWriter>(intervalListWriter.openInterval(firstStart, firstStop))) {
                        final CustomCesiumWriter firstInterval = using$3.resource;
                        try (Using<DoubleCesiumWriter> using$4 = new Using<DoubleCesiumWriter>(new DoubleCesiumWriter("value"))) {
                            final DoubleCesiumWriter valueWriter = using$4.resource;
                            valueWriter.open(firstInterval.getOutput());
                            valueWriter.writeNumber(1.0);
                        }
                    }
                    try (Using<CustomCesiumWriter> using$5 = new Using<CustomCesiumWriter>(intervalListWriter.openInterval(secondStart, secondStop))) {
                        final CustomCesiumWriter secondInterval = using$5.resource;
                        try (Using<DoubleCesiumWriter> using$6 = new Using<DoubleCesiumWriter>(new DoubleCesiumWriter("value"))) {
                            final DoubleCesiumWriter valueWriter = using$6.resource;
                            valueWriter.open(secondInterval.getOutput());
                            valueWriter.writeNumber(2.0);
                        }
                    }
                }
            }
        }
        final String expected = "{\"test\":[" + "{\"interval\":\"20120402T12Z/20120402T13Z\",\"value\":1}," + "{\"interval\":\"20120402T13Z/20120402T14Z\",\"value\":2}" + "]}";
        AssertHelper.assertEquals(expected, m_stringWriter.toString());
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