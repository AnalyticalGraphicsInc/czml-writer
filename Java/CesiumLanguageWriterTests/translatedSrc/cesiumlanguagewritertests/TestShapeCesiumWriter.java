package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArrayHelper;
import agi.foundation.compatibility.Func2;
import agi.foundation.compatibility.IterableHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.util.ArrayList;
import java.util.Collection;
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
public class TestShapeCesiumWriter extends TestCesiumPropertyWriter<ShapeCesiumWriter> {
    @Test
    public final void writeListOfCartesian2() {
        final String expectedPropertyName = "foo";
        final ArrayList<Rectangular> tempCollection$0 = new ArrayList<Rectangular>();
        tempCollection$0.add(new Rectangular(10D, 20D));
        tempCollection$0.add(new Rectangular(30D, 40D));
        Iterable<Rectangular> expectedValue = tempCollection$0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<ShapeCesiumWriter> using$1 = new Using<ShapeCesiumWriter>(new ShapeCesiumWriter(expectedPropertyName))) {
                final ShapeCesiumWriter writer = using$1.resource;
                writer.open(getOutputStream());
                writer.writeCartesian2(expectedValue);
            }
        }
        Iterable<Object> expectedValueJson = IterableHelper.selectMany(expectedValue, new Func2<Rectangular, Iterable<Object>>() {
            public Iterable<Object> invoke(Rectangular r) {
                return ArrayHelper.arrayAsList(new Object[] {
                    r.getX(),
                    r.getY()
                });
            }
        });
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, "cartesian2", expectedValueJson);
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, expectedPropertyName, tempCollection$2);
        assertExpectedJson(tempCollection$1);
    }

    @Override
    protected CesiumPropertyWriter<ShapeCesiumWriter> createPropertyWriter(String propertyName) {
        return new ShapeCesiumWriter(propertyName);
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