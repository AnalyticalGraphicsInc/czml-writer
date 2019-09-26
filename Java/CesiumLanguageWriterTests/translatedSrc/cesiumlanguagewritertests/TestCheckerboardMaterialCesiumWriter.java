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
public class TestCheckerboardMaterialCesiumWriter extends TestCesiumPropertyWriter<CheckerboardMaterialCesiumWriter> {
    @Test
    public final void testWriteCheckerboardMaterial() {
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
                                    CheckerboardMaterialCesiumWriter checkerboardMaterial = material.openCheckerboardProperty();
                                    try {
                                        checkerboardMaterial.writeEvenColorProperty(Color.RED);
                                        checkerboardMaterial.writeOddColorProperty(Color.BLUE);
                                        checkerboardMaterial.writeRepeatProperty(3.5, 4.5);
                                    } finally {
                                        DisposeHelper.dispose(checkerboardMaterial);
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
        Assert.assertEquals("{\"polyline\":{\"material\":{\"checkerboard\":{\"evenColor\":{\"rgba\":[255,0,0,255]},\"oddColor\":{\"rgba\":[0,0,255,255]},\"repeat\":{\"cartesian2\":[3.5,4.5]}}}}}",
                getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<CheckerboardMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new CheckerboardMaterialCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}