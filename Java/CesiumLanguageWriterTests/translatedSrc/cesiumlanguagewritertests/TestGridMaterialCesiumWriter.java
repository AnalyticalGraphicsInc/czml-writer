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
public class TestGridMaterialCesiumWriter extends TestCesiumPropertyWriter<GridMaterialCesiumWriter> {
    @Test
    public final void testWriteGridMaterial() {
        Color expectedColor = Color.RED;
        final double expectedCellAlpha = 0.7;
        Rectangular expectedLineCount = new Rectangular(6D, 3D);
        Rectangular expectedLineThickness = new Rectangular(3D, 4D);
        Rectangular expectedLineOffset = new Rectangular(5D, 9D);
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
                                    GridMaterialCesiumWriter gridMaterial = material.openGridProperty();
                                    try {
                                        gridMaterial.writeColorProperty(expectedColor);
                                        gridMaterial.writeCellAlphaProperty(expectedCellAlpha);
                                        gridMaterial.writeLineCountProperty(expectedLineCount);
                                        gridMaterial.writeLineThicknessProperty(expectedLineThickness);
                                        gridMaterial.writeLineOffsetProperty(expectedLineOffset);
                                    } finally {
                                        DisposeHelper.dispose(gridMaterial);
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
        MapHelper.add(tempCollection$2, GridMaterialCesiumWriter.ColorPropertyName, expectedColor);
        MapHelper.add(tempCollection$2, GridMaterialCesiumWriter.CellAlphaPropertyName, expectedCellAlpha);
        MapHelper.add(tempCollection$2, GridMaterialCesiumWriter.LineCountPropertyName, expectedLineCount);
        MapHelper.add(tempCollection$2, GridMaterialCesiumWriter.LineThicknessPropertyName, expectedLineThickness);
        MapHelper.add(tempCollection$2, GridMaterialCesiumWriter.LineOffsetPropertyName, expectedLineOffset);
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, PolylineMaterialCesiumWriter.GridPropertyName, tempCollection$2);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PolylineCesiumWriter.MaterialPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.PolylinePropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<GridMaterialCesiumWriter> createPropertyWriter(String propertyName) {
        return new GridMaterialCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}