package cesiumlanguagewritertests;

import cesiumlanguagewriter.BillboardCesiumWriter;
import cesiumlanguagewriter.Cartographic;
import cesiumlanguagewriter.CesiumOutputStream;
import cesiumlanguagewriter.CesiumResourceBehavior;
import cesiumlanguagewriter.CesiumStreamWriter;
import cesiumlanguagewriter.PacketCesiumWriter;
import cesiumlanguagewriter.PositionCesiumWriter;
import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;

public class Sandbox {
    @Test
    public void runExample() throws IOException {
        StringWriter stringWriter = new StringWriter();
        CesiumOutputStream output = new CesiumOutputStream(stringWriter);
        output.setPrettyFormatting(true);

        CesiumStreamWriter stream = new CesiumStreamWriter();
        try (PacketCesiumWriter packet = stream.openPacket(output)) {
            packet.writeId("Test");

            try (BillboardCesiumWriter billboard = packet.openBillboardProperty()) {
                billboard.writeColorProperty(123, 67, 0, 255);
                billboard.writeImageProperty(URI.create("http://cesiumjs.org/images/CesiumHeaderLogo.png"), CesiumResourceBehavior.EMBED);
            }

            try (PositionCesiumWriter position = packet.openPositionProperty()) {
                position.writeCartographicDegrees(new Cartographic(-75.0, 45.0, 100.0));
            }
        }
        stringWriter.close();

        System.out.println(stringWriter.toString());
    }
}
