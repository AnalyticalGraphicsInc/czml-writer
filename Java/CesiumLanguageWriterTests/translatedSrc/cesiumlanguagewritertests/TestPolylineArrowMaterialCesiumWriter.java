package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.util.LinkedHashMap;
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
public class TestPolylineArrowMaterialCesiumWriter extends TestCesiumPropertyWriter<PolylineArrowMaterialCesiumWriter> {
    @Test
    public final void testWritePolylineArrowMaterial() {
        Color expectedColor = Color.RED;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(getPacket().openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineMaterialCesiumWriter> using$2 = new Using<PolylineMaterialCesiumWriter>(polyline.openMaterialProperty())) {
                    final PolylineMaterialCesiumWriter material = using$2.resource;
                    try (Using<PolylineArrowMaterialCesiumWriter> using$3 = new Using<PolylineArrowMaterialCesiumWriter>(material.openPolylineArrowProperty())) {
                        final PolylineArrowMaterialCesiumWriter polylineArrowMaterial = using$3.resource;
                        polylineArrowMaterial.writeColorProperty(expectedColor);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, PolylineArrowMaterialCesiumWriter.ColorPropertyName, expectedColor);
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, PolylineMaterialCesiumWriter.PolylineArrowPropertyName, tempCollection$2);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PolylineCesiumWriter.MaterialPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PolylinePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<PolylineArrowMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new PolylineArrowMaterialCesiumWriter(propertyName);
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