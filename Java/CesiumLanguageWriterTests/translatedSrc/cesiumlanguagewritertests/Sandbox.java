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
        CesiumStreamWriter stream = new CesiumStreamWriter();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(stream.openPacket(output))) {
            final PacketCesiumWriter packet = using$0.resource;
            packet.writeId("Test");
            try (Using<BillboardCesiumWriter> using$1 = new Using<BillboardCesiumWriter>(packet.openBillboardProperty())) {
                final BillboardCesiumWriter billboard = using$1.resource;
                billboard.writeColorProperty(123, 67, 0, 255);
                billboard.writeImageProperty(UriHelper.create("http://cesiumjs.org/images/CesiumHeaderLogo.png"), CesiumResourceBehavior.LINK_TO);
            }
            try (Using<PositionCesiumWriter> using$2 = new Using<PositionCesiumWriter>(packet.openPositionProperty())) {
                final PositionCesiumWriter position = using$2.resource;
                position.writeCartographicDegrees(new Cartographic(-75.0, 45.0, 100.0));
            }
            try (Using<ModelCesiumWriter> using$3 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$3.resource;
                try (Using<ColorCesiumWriter> using$4 = new Using<ColorCesiumWriter>(model.openColorProperty())) {
                    final ColorCesiumWriter color = using$4.resource;
                    try (Using<CesiumIntervalListWriter<ColorCesiumWriter>> using$5 = new Using<CesiumIntervalListWriter<ColorCesiumWriter>>(color.openMultipleIntervals())) {
                        final CesiumIntervalListWriter<ColorCesiumWriter> intervals = using$5.resource;
                        JulianDate start = new GregorianDate(2012, 8, 4, 16, 0, 0D).toJulianDate();
                        JulianDate stop = new GregorianDate(2012, 8, 4, 16, 1, 0D).toJulianDate();
                        try (Using<ColorCesiumWriter> using$6 = new Using<ColorCesiumWriter>(intervals.openInterval(start, stop))) {
                            final ColorCesiumWriter interval = using$6.resource;
                            interval.writeRgbaf(Color.RED);
                        }
                        start = new GregorianDate(2012, 8, 4, 16, 1, 0D).toJulianDate();
                        stop = new GregorianDate(2012, 8, 4, 16, 2, 0D).toJulianDate();
                        try (Using<ColorCesiumWriter> using$7 = new Using<ColorCesiumWriter>(intervals.openInterval(start, stop))) {
                            final ColorCesiumWriter interval = using$7.resource;
                            interval.writeRgbaf(ColorHelper.LIME);
                        }
                    }
                }
            }
        }
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