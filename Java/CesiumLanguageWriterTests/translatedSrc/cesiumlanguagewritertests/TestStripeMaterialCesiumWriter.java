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
public class TestStripeMaterialCesiumWriter extends TestCesiumPropertyWriter<StripeMaterialCesiumWriter> {
    @Test
    public final void testWriteStripeMaterial() {
        Color expectedEvenColor = Color.RED;
        Color expectedOddColor = Color.BLUE;
        final double expectedOffset = 1.5;
        final CesiumStripeOrientation expectedOrientation = CesiumStripeOrientation.VERTICAL;
        final double expectedRepeat = 3.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(getPacket().openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineMaterialCesiumWriter> using$2 = new Using<PolylineMaterialCesiumWriter>(polyline.openMaterialProperty())) {
                    final PolylineMaterialCesiumWriter material = using$2.resource;
                    try (Using<StripeMaterialCesiumWriter> using$3 = new Using<StripeMaterialCesiumWriter>(material.openStripeProperty())) {
                        final StripeMaterialCesiumWriter stripeMaterial = using$3.resource;
                        stripeMaterial.writeEvenColorProperty(expectedEvenColor);
                        stripeMaterial.writeOddColorProperty(expectedOddColor);
                        stripeMaterial.writeOffsetProperty(expectedOffset);
                        stripeMaterial.writeOrientationProperty(expectedOrientation);
                        stripeMaterial.writeRepeatProperty(expectedRepeat);
                    }
                }
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
    private static final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    @ClassRule
    public static TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}