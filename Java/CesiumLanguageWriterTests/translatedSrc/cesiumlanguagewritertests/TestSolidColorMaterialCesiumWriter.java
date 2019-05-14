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
public class TestSolidColorMaterialCesiumWriter extends TestCesiumPropertyWriter<SolidColorMaterialCesiumWriter> {
    @Test
    public final void testWriteSolidColorMaterial() {
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
                                    cesiumlanguagewriter.SolidColorMaterialCesiumWriter solidColorMaterial = material.openSolidColorProperty();
                                    try {
                                        solidColorMaterial.writeColorProperty(Color.RED);
                                    } finally {
                                        DisposeHelper.dispose(solidColorMaterial);
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
        Assert.assertEquals("{\"polyline\":{\"material\":{\"solidColor\":{\"color\":{\"rgba\":[255,0,0,255]}}}}}", getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<SolidColorMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new SolidColorMaterialCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}