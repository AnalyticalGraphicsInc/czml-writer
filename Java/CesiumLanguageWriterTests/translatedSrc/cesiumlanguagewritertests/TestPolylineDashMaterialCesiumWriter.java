package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ConvertHelper;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.io.StringWriter;
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
public class TestPolylineDashMaterialCesiumWriter extends TestCesiumPropertyWriter<PolylineDashMaterialCesiumWriter> {
    @Test
    public final void testWritePolylineDashMaterial() {
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
                                    cesiumlanguagewriter.PolylineDashMaterialCesiumWriter polylineDashMaterial = material.openPolylineDashProperty();
                                    try {
                                        polylineDashMaterial.writeColorProperty(Color.RED);
                                        polylineDashMaterial.writeDashPatternProperty(ConvertHelper.toInt32("0011001100110011", 2));
                                        polylineDashMaterial.writeGapColorProperty(Color.BLUE);
                                        polylineDashMaterial.writeDashLengthProperty(25D);
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
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        Assert.assertEquals("{\"polyline\":{\"material\":{\"polylineDash\":{\"color\":{\"rgba\":[255,0,0,255]},\"dashPattern\":13107,\"gapColor\":{\"rgba\":[0,0,255,255]},\"dashLength\":25}}}}",
                getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<PolylineDashMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new PolylineDashMaterialCesiumWriter(propertyName);
    }

    private final TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}