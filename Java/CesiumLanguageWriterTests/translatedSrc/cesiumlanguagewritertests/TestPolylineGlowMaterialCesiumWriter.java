package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
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
public class TestPolylineGlowMaterialCesiumWriter extends TestCesiumPropertyWriter<PolylineGlowMaterialCesiumWriter> {
    @Test
    public final void testWritePolylineGlowMaterial() {
        Color expectedColor = Color.RED;
        final double expectedGlowPower = 0.7;
        final double expectedTaperPower = 0.2;
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    PolylineCesiumWriter polyline = getPacket().openPolylineProperty();
                    try {
                        {
                            PolylineMaterialCesiumWriter material = polyline.openMaterialProperty();
                            try {
                                {
                                    PolylineGlowMaterialCesiumWriter polylineGlowMaterial = material.openPolylineGlowProperty();
                                    try {
                                        polylineGlowMaterial.writeColorProperty(expectedColor);
                                        polylineGlowMaterial.writeGlowPowerProperty(expectedGlowPower);
                                        polylineGlowMaterial.writeTaperPowerProperty(expectedTaperPower);
                                    } finally {
                                        DisposeHelper.dispose(polylineGlowMaterial);
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
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, PolylineGlowMaterialCesiumWriter.ColorPropertyName, expectedColor);
        MapHelper.add(tempCollection$2, PolylineGlowMaterialCesiumWriter.GlowPowerPropertyName, expectedGlowPower);
        MapHelper.add(tempCollection$2, PolylineGlowMaterialCesiumWriter.TaperPowerPropertyName, expectedTaperPower);
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, PolylineMaterialCesiumWriter.PolylineGlowPropertyName, tempCollection$2);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PolylineCesiumWriter.MaterialPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PolylinePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<PolylineGlowMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new PolylineGlowMaterialCesiumWriter(propertyName);
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