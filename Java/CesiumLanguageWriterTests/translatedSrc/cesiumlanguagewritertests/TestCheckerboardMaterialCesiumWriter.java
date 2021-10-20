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
public class TestCheckerboardMaterialCesiumWriter extends TestCesiumPropertyWriter<CheckerboardMaterialCesiumWriter> {
    @Test
    public final void testWriteCheckerboardMaterial() {
        Color expectedEvenColor = Color.RED;
        Color expectedOddColor = Color.BLUE;
        Rectangular expectedRepeat = new Rectangular(3.5, 4.5);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(getPacket().openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineMaterialCesiumWriter> using$2 = new Using<PolylineMaterialCesiumWriter>(polyline.openMaterialProperty())) {
                    final PolylineMaterialCesiumWriter material = using$2.resource;
                    try (Using<CheckerboardMaterialCesiumWriter> using$3 = new Using<CheckerboardMaterialCesiumWriter>(material.openCheckerboardProperty())) {
                        final CheckerboardMaterialCesiumWriter checkerboardMaterial = using$3.resource;
                        checkerboardMaterial.writeEvenColorProperty(expectedEvenColor);
                        checkerboardMaterial.writeOddColorProperty(expectedOddColor);
                        checkerboardMaterial.writeRepeatProperty(expectedRepeat);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, CheckerboardMaterialCesiumWriter.EvenColorPropertyName, expectedEvenColor);
        MapHelper.add(tempCollection$2, CheckerboardMaterialCesiumWriter.OddColorPropertyName, expectedOddColor);
        MapHelper.add(tempCollection$2, CheckerboardMaterialCesiumWriter.RepeatPropertyName, expectedRepeat);
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, PolylineMaterialCesiumWriter.CheckerboardPropertyName, tempCollection$2);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PolylineCesiumWriter.MaterialPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PolylinePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<CheckerboardMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new CheckerboardMaterialCesiumWriter(propertyName);
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