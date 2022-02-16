package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
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
public class TestRectangleCesiumWriter extends TestCesiumPropertyWriter<RectangleCesiumWriter> {
    @Test
    public final void testHeightReferenceProperties() {
        final double expectedExtrudedHeight = 10.0;
        final CesiumHeightReference expectedExtrudedHeightReference = CesiumHeightReference.RELATIVE_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<RectangleCesiumWriter> using$1 = new Using<RectangleCesiumWriter>(getPacket().openRectangleProperty())) {
                final RectangleCesiumWriter rectangle = using$1.resource;
                try (Using<RectangleCesiumWriter> using$2 = new Using<RectangleCesiumWriter>(rectangle.openInterval())) {
                    final RectangleCesiumWriter interval = using$2.resource;
                    interval.writeExtrudedHeightProperty(expectedExtrudedHeight);
                    interval.writeExtrudedHeightReferenceProperty(expectedExtrudedHeightReference);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.ExtrudedHeightPropertyName, expectedExtrudedHeight);
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.ExtrudedHeightReferencePropertyName, CesiumFormattingHelper.heightReferenceToString(expectedExtrudedHeightReference));
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<RectangleCesiumWriter> createPropertyWriter(String propertyName) {
        return new RectangleCesiumWriter(propertyName);
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