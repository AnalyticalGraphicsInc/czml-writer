package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ConvertHelper;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
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

@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPolylineDashMaterialCesiumWriter extends TestCesiumPropertyWriter<PolylineDashMaterialCesiumWriter> {
    @Test
    public final void testWritePolylineDashMaterial() {
        Color expectedColor = Color.RED;
        int expectedDashPattern = ConvertHelper.toInt32("0011001100110011", 2);
        Color expectedGapColor = Color.BLUE;
        final double expectedDashLength = 25D;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    PolylineCesiumWriter polyline = getPacket().openPolylineProperty();
                    try {
                        {
                            PolylineMaterialCesiumWriter material = polyline.openMaterialProperty();
                            try {
                                {
                                    PolylineDashMaterialCesiumWriter polylineDashMaterial = material.openPolylineDashProperty();
                                    try {
                                        polylineDashMaterial.writeColorProperty(expectedColor);
                                        polylineDashMaterial.writeDashPatternProperty(expectedDashPattern);
                                        polylineDashMaterial.writeGapColorProperty(expectedGapColor);
                                        polylineDashMaterial.writeDashLengthProperty(expectedDashLength);
                                    } finally {
                                        DisposeHelper.dispose(polylineDashMaterial);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(material);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(polyline);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, PolylineDashMaterialCesiumWriter.ColorPropertyName, expectedColor);
        MapHelper.add(tempCollection$2, PolylineDashMaterialCesiumWriter.DashPatternPropertyName, expectedDashPattern);
        MapHelper.add(tempCollection$2, PolylineDashMaterialCesiumWriter.GapColorPropertyName, expectedGapColor);
        MapHelper.add(tempCollection$2, PolylineDashMaterialCesiumWriter.DashLengthPropertyName, expectedDashLength);
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, PolylineMaterialCesiumWriter.PolylineDashPropertyName, tempCollection$2);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PolylineCesiumWriter.MaterialPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PolylinePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<PolylineDashMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new PolylineDashMaterialCesiumWriter(propertyName);
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