package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ColorHelper;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.UriHelper;
import cesiumlanguagewriter.*;
import java.awt.Color;
import java.io.StringWriter;
import javax.annotation.Nonnull;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings( {
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
        {
            PacketCesiumWriter packet = stream.openPacket(output);
            try {
                packet.writeId("Test");
                {
                    BillboardCesiumWriter billboard = packet.openBillboardProperty();
                    try {
                        billboard.writeColorProperty(123, 67, 0, 255);
                        billboard.writeImageProperty(UriHelper.create("http://cesiumjs.org/images/CesiumHeaderLogo.png"), CesiumResourceBehavior.LINK_TO);
                    } finally {
                        DisposeHelper.dispose(billboard);
                    }
                }
                {
                    PositionCesiumWriter position = packet.openPositionProperty();
                    try {
                        position.writeCartographicDegrees(new Cartographic(-75.0, 45.0, 100.0));
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
                {
                    ModelCesiumWriter model = packet.openModelProperty();
                    try {
                        {
                            ColorCesiumWriter color = model.openColorProperty();
                            try {
                                {
                                    CesiumIntervalListWriter<ColorCesiumWriter> intervals = color.openMultipleIntervals();
                                    try {
                                        JulianDate start = new GregorianDate(2012, 8, 4, 16, 0, 0D).toJulianDate();
                                        JulianDate stop = new GregorianDate(2012, 8, 4, 16, 1, 0D).toJulianDate();
                                        {
                                            ColorCesiumWriter interval = intervals.openInterval(start, stop);
                                            try {
                                                interval.writeRgbaf(Color.RED);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                        start = new GregorianDate(2012, 8, 4, 16, 1, 0D).toJulianDate();
                                        stop = new GregorianDate(2012, 8, 4, 16, 2, 0D).toJulianDate();
                                        {
                                            ColorCesiumWriter interval = intervals.openInterval(start, stop);
                                            try {
                                                interval.writeRgbaf(ColorHelper.LIME);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                    } finally {
                                        DisposeHelper.dispose(intervals);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(color);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(model);
                    }
                }
            } finally {
                DisposeHelper.dispose(packet);
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