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
        Color expectedEvenColor = Color.RED;
        Color expectedOddColor = Color.BLUE;
        final double expectedOffset = 1.5;
        final CesiumStripeOrientation expectedOrientation = CesiumStripeOrientation.VERTICAL;
        final double expectedRepeat = 3.5;
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
                                        stripeMaterial.writeEvenColorProperty(expectedEvenColor);
                                        stripeMaterial.writeOddColorProperty(expectedOddColor);
                                        stripeMaterial.writeOffsetProperty(expectedOffset);
                                        stripeMaterial.writeOrientationProperty(expectedOrientation);
                                        stripeMaterial.writeRepeatProperty(expectedRepeat);
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
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, StripeMaterialCesiumWriter.EvenColorPropertyName, expectedEvenColor);
        MapHelper.add(tempCollection$2, StripeMaterialCesiumWriter.OddColorPropertyName, expectedOddColor);
        MapHelper.add(tempCollection$2, StripeMaterialCesiumWriter.OffsetPropertyName, expectedOffset);
        MapHelper.add(tempCollection$2, StripeMaterialCesiumWriter.OrientationPropertyName, CesiumFormattingHelper.stripeOrientationToString(expectedOrientation));
        MapHelper.add(tempCollection$2, StripeMaterialCesiumWriter.RepeatPropertyName, expectedRepeat);
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, PolylineMaterialCesiumWriter.StripePropertyName, tempCollection$2);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PolylineCesiumWriter.MaterialPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PolylinePropertyName, tempCollection$0);
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