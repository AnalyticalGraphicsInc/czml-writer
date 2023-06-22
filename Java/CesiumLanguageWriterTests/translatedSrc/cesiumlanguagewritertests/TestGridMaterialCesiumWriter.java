package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
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
public class TestGridMaterialCesiumWriter extends TestCesiumPropertyWriter<GridMaterialCesiumWriter> {
    @Test
    public final void testWriteGridMaterial() {
        Color expectedColor = Color.RED;
        final double expectedCellAlpha = 0.7;
        Rectangular expectedLineCount = new Rectangular(6.0, 3.0);
        Rectangular expectedLineThickness = new Rectangular(3.0, 4.0);
        Rectangular expectedLineOffset = new Rectangular(5.0, 9.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PolylineCesiumWriter> using$1 = new Using<PolylineCesiumWriter>(getPacket().openPolylineProperty())) {
                final PolylineCesiumWriter polyline = using$1.resource;
                try (Using<PolylineMaterialCesiumWriter> using$2 = new Using<PolylineMaterialCesiumWriter>(polyline.openMaterialProperty())) {
                    final PolylineMaterialCesiumWriter material = using$2.resource;
                    try (Using<GridMaterialCesiumWriter> using$3 = new Using<GridMaterialCesiumWriter>(material.openGridProperty())) {
                        final GridMaterialCesiumWriter gridMaterial = using$3.resource;
                        gridMaterial.writeColorProperty(expectedColor);
                        gridMaterial.writeCellAlphaProperty(expectedCellAlpha);
                        gridMaterial.writeLineCountProperty(expectedLineCount);
                        gridMaterial.writeLineThicknessProperty(expectedLineThickness);
                        gridMaterial.writeLineOffsetProperty(expectedLineOffset);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$2 = MapHelper.create();
        MapHelper.add(tempCollection$2, GridMaterialCesiumWriter.ColorPropertyName, expectedColor);
        MapHelper.add(tempCollection$2, GridMaterialCesiumWriter.CellAlphaPropertyName, expectedCellAlpha);
        MapHelper.add(tempCollection$2, GridMaterialCesiumWriter.LineCountPropertyName, expectedLineCount);
        MapHelper.add(tempCollection$2, GridMaterialCesiumWriter.LineThicknessPropertyName, expectedLineThickness);
        MapHelper.add(tempCollection$2, GridMaterialCesiumWriter.LineOffsetPropertyName, expectedLineOffset);
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, PolylineMaterialCesiumWriter.GridPropertyName, tempCollection$2);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PolylineCesiumWriter.MaterialPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PolylinePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<GridMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new GridMaterialCesiumWriter(propertyName);
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