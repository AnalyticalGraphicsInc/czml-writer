package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
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
public class TestRectangleCesiumWriter extends TestCesiumPropertyWriter<RectangleCesiumWriter> {
    @Test
    public final void testHeightReferenceProperties() {
        final double expectedExtrudedHeight = 10.0;
        final CesiumHeightReference expectedExtrudedHeightReference = CesiumHeightReference.RELATIVE_TO_GROUND;
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    RectangleCesiumWriter rectangle = getPacket().openRectangleProperty();
                    try {
                        {
                            RectangleCesiumWriter interval = rectangle.openInterval();
                            try {
                                interval.writeExtrudedHeightProperty(expectedExtrudedHeight);
                                interval.writeExtrudedHeightReferenceProperty(expectedExtrudedHeightReference);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(rectangle);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.ExtrudedHeightPropertyName, expectedExtrudedHeight);
        MapHelper.add(tempCollection$0, RectangleCesiumWriter.ExtrudedHeightReferencePropertyName, CesiumFormattingHelper.heightReferenceToString(expectedExtrudedHeightReference));
        assertExpectedJson(PacketCesiumWriter.RectanglePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<RectangleCesiumWriter> createPropertyWriter(String propertyName) {
        return new RectangleCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}