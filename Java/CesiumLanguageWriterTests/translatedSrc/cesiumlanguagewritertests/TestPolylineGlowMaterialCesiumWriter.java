package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.io.StringWriter;
import javax.annotation.Nonnull;
import org.junit.Assert;
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
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.PolylineCesiumWriter polyline = getPacket().openPolylineProperty();
                    try {
                        {
                            cesiumlanguagewriter.PolylineMaterialCesiumWriter material = polyline.openMaterialProperty();
                            try {
                                {
                                    cesiumlanguagewriter.PolylineGlowMaterialCesiumWriter polylineGlowMaterial = material.openPolylineGlowProperty();
                                    try {
                                        polylineGlowMaterial.writeColorProperty(Color.RED);
                                        polylineGlowMaterial.writeGlowPowerProperty(0.7);
                                        polylineGlowMaterial.writeTaperPowerProperty(0.2);
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
        Assert.assertEquals("{\"polyline\":{\"material\":{\"polylineGlow\":{\"color\":{\"rgba\":[255,0,0,255]},\"glowPower\":0.7,\"taperPower\":0.2}}}}", getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<PolylineGlowMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new PolylineGlowMaterialCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}