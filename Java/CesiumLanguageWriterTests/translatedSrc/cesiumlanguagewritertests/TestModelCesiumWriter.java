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
import org.junit.ClassRule;
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
public class TestModelCesiumWriter extends TestCesiumPropertyWriter<ModelCesiumWriter> {
    @Test
    public final void testShowProperty() {
        final boolean expectedShow = true;
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    ModelCesiumWriter model = getPacket().openModelProperty();
                    try {
                        {
                            ModelCesiumWriter interval = model.openInterval();
                            try {
                                interval.writeShowProperty(expectedShow);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(model);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void testGltfProperty() {
        final String expectedGltf = "test.gltf";
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    ModelCesiumWriter model = getPacket().openModelProperty();
                    try {
                        {
                            ModelCesiumWriter interval = model.openInterval();
                            try {
                                interval.writeGltfProperty(expectedGltf, CesiumResourceBehavior.LINK_TO);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(model);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, ModelCesiumWriter.GltfPropertyName, expectedGltf);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$1);
    }

    @Test
    public final void testSilhouetteColorProperty() {
        Color expectedSilhouetteColor = Color.BLUE;
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
            try {
                {
                    ModelCesiumWriter model = getPacket().openModelProperty();
                    try {
                        {
                            ModelCesiumWriter interval = model.openInterval();
                            try {
                                interval.writeSilhouetteColorProperty(expectedSilhouetteColor);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(model);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_2);
            }
        }
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, ModelCesiumWriter.SilhouetteColorPropertyName, expectedSilhouetteColor);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$2);
    }

    @Test
    public final void testSilhouetteSizeProperty() {
        final double expectedSilhouetteSize = 0.75;
        {
            final PacketCesiumWriter usingExpression_3 = (getPacket());
            try {
                {
                    ModelCesiumWriter model = getPacket().openModelProperty();
                    try {
                        {
                            ModelCesiumWriter interval = model.openInterval();
                            try {
                                interval.writeSilhouetteSizeProperty(expectedSilhouetteSize);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(model);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_3);
            }
        }
        final Map<String, Object> tempCollection$3 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$3, ModelCesiumWriter.SilhouetteSizePropertyName, expectedSilhouetteSize);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$3);
    }

    @Test
    public final void testColorProperty() {
        Color expectedColor = Color.RED;
        {
            final PacketCesiumWriter usingExpression_4 = (getPacket());
            try {
                {
                    ModelCesiumWriter model = getPacket().openModelProperty();
                    try {
                        {
                            ModelCesiumWriter interval = model.openInterval();
                            try {
                                interval.writeColorProperty(expectedColor);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(model);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_4);
            }
        }
        final Map<String, Object> tempCollection$4 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$4, ModelCesiumWriter.ColorPropertyName, expectedColor);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$4);
    }

    @Test
    public final void testColorBlendModeProperty() {
        final CesiumColorBlendMode expectedColorBlendMode = CesiumColorBlendMode.REPLACE;
        {
            final PacketCesiumWriter usingExpression_5 = (getPacket());
            try {
                {
                    ModelCesiumWriter model = getPacket().openModelProperty();
                    try {
                        {
                            ModelCesiumWriter interval = model.openInterval();
                            try {
                                interval.writeColorBlendModeProperty(expectedColorBlendMode);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(model);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_5);
            }
        }
        final Map<String, Object> tempCollection$5 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$5, ModelCesiumWriter.ColorBlendModePropertyName, CesiumFormattingHelper.colorBlendModeToString(expectedColorBlendMode));
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$5);
    }

    @Test
    public final void testColorBlendAmountProperty() {
        final double expectedColorBlendAmount = 0.75;
        {
            final PacketCesiumWriter usingExpression_6 = (getPacket());
            try {
                {
                    ModelCesiumWriter model = getPacket().openModelProperty();
                    try {
                        {
                            ModelCesiumWriter interval = model.openInterval();
                            try {
                                interval.writeColorBlendAmountProperty(expectedColorBlendAmount);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(model);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_6);
            }
        }
        final Map<String, Object> tempCollection$6 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$6, ModelCesiumWriter.ColorBlendAmountPropertyName, expectedColorBlendAmount);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$6);
    }

    @Override
    protected CesiumPropertyWriter<ModelCesiumWriter> createPropertyWriter(String propertyName) {
        return new ModelCesiumWriter(propertyName);
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