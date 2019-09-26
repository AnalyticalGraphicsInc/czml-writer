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
public class TestStripeMaterialCesiumWriter extends TestCesiumPropertyWriter<StripeMaterialCesiumWriter> {
    @Test
    public final void testWriteStripeMaterial() {
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
                                    StripeMaterialCesiumWriter stripeMaterial = material.openStripeProperty();
                                    try {
                                        stripeMaterial.writeEvenColorProperty(Color.RED);
                                        stripeMaterial.writeOddColorProperty(Color.BLUE);
                                        stripeMaterial.writeOffsetProperty(1.5);
                                        stripeMaterial.writeOrientationProperty(CesiumStripeOrientation.VERTICAL);
                                        stripeMaterial.writeRepeatProperty(3.5);
                                    } finally {
                                        DisposeHelper.dispose(stripeMaterial);
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
        Assert.assertEquals(
                "{\"polyline\":{\"material\":{\"stripe\":{\"evenColor\":{\"rgba\":[255,0,0,255]},\"oddColor\":{\"rgba\":[0,0,255,255]},\"offset\":1.5,\"orientation\":\"VERTICAL\",\"repeat\":3.5}}}}",
                getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<StripeMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new StripeMaterialCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}