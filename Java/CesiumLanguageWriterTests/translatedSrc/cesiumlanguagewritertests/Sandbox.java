package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ColorHelper;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.UriHelper;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import java.awt.Color;
import java.io.StringWriter;
import java.net.URI;
import javax.annotation.Nonnull;
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
public class Sandbox {
    @Test
    public final void runExample() {
        StringWriter stringWriter = new StringWriter();
        final CesiumOutputStream tempObj$0 = new CesiumOutputStream(stringWriter);
        tempObj$0.setPrettyFormatting(true);
        CesiumOutputStream output = tempObj$0;
        CesiumStreamWriter writer = new CesiumStreamWriter();
        output.writeStartSequence();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(writer.openPacket(output))) {
            final PacketCesiumWriter packet = using$0.resource;
            packet.writeId("document");
            packet.writeName("Sandbox");
            packet.writeVersion("1.0");
        }
        try (Using<PacketCesiumWriter> using$1 = new Using<PacketCesiumWriter>(writer.openPacket(output))) {
            final PacketCesiumWriter packet = using$1.resource;
            packet.writeId("TestPacket");
            try (Using<BillboardCesiumWriter> using$2 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$2.resource;
                billboard.writeColorProperty(123, 67, 0, 255);
                URI imageUri = UriHelper.create("http://analyticalgraphicsinc.github.io/czml-writer/logo.png");
                billboard.writeImageProperty(imageUri, CesiumResourceBehavior.EMBED);
            }
            try (Using<PositionCesiumWriter> using$3 = new Using<PositionCesiumWriter>(packet.openPositionProperty())) {
                final PositionCesiumWriter position = using$3.resource;
                position.writeCartographicDegrees(new Cartographic(-75.0, 45.0, 100.0));
            }
            try (Using<ModelCesiumWriter> using$4 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$4.resource;
                try (Using<ColorCesiumWriter> using$5 = new Using<ColorCesiumWriter>(model.openColorProperty())) {
                    final ColorCesiumWriter color = using$5.resource;
                    try (Using<CesiumIntervalListWriter<ColorCesiumWriter>> using$6 = new Using<CesiumIntervalListWriter<ColorCesiumWriter>>(color.openMultipleIntervals())) {
                        final CesiumIntervalListWriter<ColorCesiumWriter> intervals = using$6.resource;
                        JulianDate start = new GregorianDate(2012, 8, 4, 16, 0, 0.0).toJulianDate();
                        JulianDate stop = new GregorianDate(2012, 8, 4, 16, 1, 0.0).toJulianDate();
                        try (Using<ColorCesiumWriter> using$7 = new Using<ColorCesiumWriter>(intervals.openInterval(start, stop))) {
                            final ColorCesiumWriter interval = using$7.resource;
                            interval.writeRgbaf(Color.RED);
                        }
                        start = new GregorianDate(2012, 8, 4, 16, 1, 0.0).toJulianDate();
                        stop = new GregorianDate(2012, 8, 4, 16, 2, 0.0).toJulianDate();
                        try (Using<ColorCesiumWriter> using$8 = new Using<ColorCesiumWriter>(intervals.openInterval(start, stop))) {
                            final ColorCesiumWriter interval = using$8.resource;
                            interval.writeRgbaf(ColorHelper.LIME);
                        }
                    }
                }
            }
        }
        output.writeEndSequence();
        ConsoleHelper.writeLine(stringWriter.toString());
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