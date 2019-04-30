package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
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
public class TestRectangleCesiumWriter extends TestCesiumPropertyWriter<RectangleCesiumWriter> {
    @Test
    public final void testHeightReferenceProperties() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.RectangleCesiumWriter rectangle = getPacket().openRectangleProperty();
                    try {
                        {
                            cesiumlanguagewriter.RectangleCesiumWriter interval = rectangle.openInterval();
                            try {
                                interval.writeExtrudedHeightProperty(10.0);
                                interval.writeExtrudedHeightReferenceProperty(CesiumHeightReference.RELATIVE_TO_GROUND);
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
        Assert.assertEquals("{\"rectangle\":{\"extrudedHeight\":10,\"extrudedHeightReference\":\"RELATIVE_TO_GROUND\"}}", getStringWriter().toString());
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