package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.util.Map;
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
public class TestPolylineOutlineMaterialCesiumWriter extends TestCesiumPropertyWriter<PolylineOutlineMaterialCesiumWriter> {
    @Test
    public final void testWritePolylineOutlineMaterial() {
        Color expectedColor = Color.RED;
        Color expectedOutlineColor = Color.BLUE;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(packet.openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineMaterialCesiumWriter> using$2 = new Using<PolylineMaterialCesiumWriter>(polyline.openMaterialProperty())) {
                    final PolylineMaterialCesiumWriter material = using$2.resource;
                    try (Using<PolylineOutlineMaterialCesiumWriter> using$3 = new Using<PolylineOutlineMaterialCesiumWriter>(material.openPolylineOutlineProperty())) {
                        final PolylineOutlineMaterialCesiumWriter polylineOutlineMaterial = using$3.resource;
                        polylineOutlineMaterial.writeColorProperty(expectedColor);
                        polylineOutlineMaterial.writeOutlineColorProperty(expectedOutlineColor);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$2 = MapHelper.create();
        MapHelper.add(tempCollection$2, PolylineOutlineMaterialCesiumWriter.ColorPropertyName, expectedColor);
        MapHelper.add(tempCollection$2, PolylineOutlineMaterialCesiumWriter.OutlineColorPropertyName, expectedOutlineColor);
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, PolylineMaterialCesiumWriter.PolylineOutlinePropertyName, tempCollection$2);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PolylineCesiumWriter.MaterialPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PolylinePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<PolylineOutlineMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new PolylineOutlineMaterialCesiumWriter(propertyName);
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