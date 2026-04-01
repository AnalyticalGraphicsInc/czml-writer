package cesiumlanguagewritertests.java;

import cesiumlanguagewriter.BillboardCesiumWriter;
import cesiumlanguagewriter.Cartographic;
import cesiumlanguagewriter.CesiumIntervalListWriter;
import cesiumlanguagewriter.CesiumOutputStream;
import cesiumlanguagewriter.CesiumResourceBehavior;
import cesiumlanguagewriter.CesiumStreamWriter;
import cesiumlanguagewriter.ColorCesiumWriter;
import cesiumlanguagewriter.GregorianDate;
import cesiumlanguagewriter.JulianDate;
import cesiumlanguagewriter.ModelCesiumWriter;
import cesiumlanguagewriter.PacketCesiumWriter;
import cesiumlanguagewriter.PositionCesiumWriter;
import org.junit.Test;

import java.awt.Color;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;

public class Sandbox {
    @Test
    public void runExample() throws IOException {
        StringWriter stringWriter = new StringWriter();

        CesiumOutputStream output = new CesiumOutputStream(stringWriter);
        output.setPrettyFormatting(true);

        CesiumStreamWriter writer = new CesiumStreamWriter();

        output.writeStartSequence();

        try (PacketCesiumWriter packet = writer.openPacket(output)) {
            packet.writeId("document");
            packet.writeName("Sandbox");
            packet.writeVersion("1.0");
        }

        try (PacketCesiumWriter packet = writer.openPacket(output)) {
            packet.writeId("TestPacket");

            try (BillboardCesiumWriter billboard = packet.openBillboardProperty()) {
                billboard.writeColorProperty(123, 67, 0, 255);

                URI imageUri = URI.create("http://analyticalgraphicsinc.github.io/czml-writer/logo.png");
                billboard.writeImageProperty(imageUri, CesiumResourceBehavior.EMBED);
            }

            try (PositionCesiumWriter position = packet.openPositionProperty()) {
                position.writeCartographicDegrees(new Cartographic(-75.0, 45.0, 100.0));
            }

            try (ModelCesiumWriter model = packet.openModelProperty()) {
                try (ColorCesiumWriter color = model.openColorProperty()) {
                    try (CesiumIntervalListWriter<ColorCesiumWriter> intervals = color.openMultipleIntervals()) {
                        JulianDate start = new GregorianDate(2012, 8, 4, 16, 0, 0).toJulianDate();
                        JulianDate stop = new GregorianDate(2012, 8, 4, 16, 1, 0).toJulianDate();

                        try (ColorCesiumWriter interval = intervals.openInterval(start, stop)) {
                            interval.writeRgbaf(Color.RED);
                        }

                        start = new GregorianDate(2012, 8, 4, 16, 1, 0).toJulianDate();
                        stop = new GregorianDate(2012, 8, 4, 16, 2, 0).toJulianDate();
                        try (ColorCesiumWriter interval = intervals.openInterval(start, stop)) {
                            interval.writeRgbaf(Color.GREEN);
                        }
                    }
                }
            }
        }

        output.writeEndSequence();

        System.out.println(stringWriter.toString());
    }
}
