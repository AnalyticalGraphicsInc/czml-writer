package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
import java.io.StringWriter;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestModelCesiumWriter extends TestCesiumPropertyWriter<ModelCesiumWriter> {
    @Override
    protected CesiumPropertyWriter<ModelCesiumWriter> createPropertyWriter(String propertyName) {
        return new ModelCesiumWriter(propertyName);
    }

    @Test
    public final void testShowProperty() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    ModelCesiumWriter model = getPacket().openModelProperty();
                    try {
                        {
                            ModelCesiumWriter interval = model.openInterval();
                            try {
                                interval.writeShowProperty(true);
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
        Assert.assertEquals("{\"model\":{\"show\":true}}", getStringWriter().toString());
    }

    @Test
    public final void testColorProperty() {
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    ModelCesiumWriter model = getPacket().openModelProperty();
                    try {
                        {
                            ModelCesiumWriter interval = model.openInterval();
                            try {
                                interval.writeColorProperty(Color.RED);
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
        Assert.assertEquals("{\"model\":{\"color\":{\"rgba\":[255,0,0,255]}}}", getStringWriter().toString());
    }

    @Test
    public final void testColorBlendModeProperty() {
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
            try {
                {
                    ModelCesiumWriter model = getPacket().openModelProperty();
                    try {
                        {
                            ModelCesiumWriter interval = model.openInterval();
                            try {
                                interval.writeColorBlendModeProperty(CesiumColorBlendMode.REPLACE);
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
        Assert.assertEquals("{\"model\":{\"colorBlendMode\":\"REPLACE\"}}", getStringWriter().toString());
    }

    @Test
    public final void testColorBlendAmountProperty() {
        {
            final PacketCesiumWriter usingExpression_3 = (getPacket());
            try {
                {
                    ModelCesiumWriter model = getPacket().openModelProperty();
                    try {
                        {
                            ModelCesiumWriter interval = model.openInterval();
                            try {
                                interval.writeColorBlendAmountProperty(0.75);
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
        Assert.assertEquals("{\"model\":{\"colorBlendAmount\":0.75}}", getStringWriter().toString());
    }

    private TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}