package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.UriHelper;
import agi.foundation.compatibility.UriKind;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
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
public class TestNodeTransformationsCesiumWriter extends TestCesiumPropertyWriter<NodeTransformationsCesiumWriter> {
    @Test
    public final void singleNodeTransformation() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.ModelCesiumWriter modelWriter = getPacket().openModelProperty();
                    try {
                        {
                            cesiumlanguagewriter.NodeTransformationsCesiumWriter nodeTransformationsWriter = modelWriter.openNodeTransformationsProperty();
                            try {
                                {
                                    cesiumlanguagewriter.NodeTransformationCesiumWriter nodeTransformationWriter = nodeTransformationsWriter.openNodeTransformationProperty("node1");
                                    try {
                                        nodeTransformationWriter.writeScaleProperty(Cartesian.getZero());
                                        nodeTransformationWriter.writeRotationProperty(UnitQuaternion.getIdentity());
                                        nodeTransformationWriter.writeTranslationProperty(new Cartesian(3.0, 3.0, 3.0));
                                    } finally {
                                        DisposeHelper.dispose(nodeTransformationWriter);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(nodeTransformationsWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(modelWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        Assert.assertEquals("{\"model\":{\"nodeTransformations\":{"
                + "\"node1\":{\"scale\":{\"cartesian\":[0,0,0]},\"rotation\":{\"unitQuaternion\":[0,0,0,1]},\"translation\":{\"cartesian\":[3,3,3]}}" + "}}}", getStringWriter().toString());
    }

    @Test
    public final void multipleNodeTransformations() {
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.ModelCesiumWriter modelWriter = getPacket().openModelProperty();
                    try {
                        {
                            cesiumlanguagewriter.NodeTransformationsCesiumWriter nodeTransformationsWriter = modelWriter.openNodeTransformationsProperty();
                            try {
                                {
                                    cesiumlanguagewriter.NodeTransformationCesiumWriter nodeTransformationWriter = nodeTransformationsWriter.openNodeTransformationProperty("node1");
                                    try {
                                        nodeTransformationWriter.writeScaleProperty(new Cartesian(1.0, 2.0, 3.0));
                                        nodeTransformationWriter.writeRotationProperty(new UnitQuaternion(1.0, 0.0, 0.0, 0.0));
                                        nodeTransformationWriter.writeTranslationProperty(new Cartesian(4.0, 5.0, 6.0));
                                    } finally {
                                        DisposeHelper.dispose(nodeTransformationWriter);
                                    }
                                }
                                {
                                    cesiumlanguagewriter.NodeTransformationCesiumWriter nodeTransformationWriter = nodeTransformationsWriter.openNodeTransformationProperty("node2");
                                    try {
                                        nodeTransformationWriter.writeScaleProperty(new Cartesian(4.0, 5.0, 6.0));
                                        nodeTransformationWriter.writeRotationProperty(new UnitQuaternion(0.0, 0.0, 0.0, 1.0));
                                        nodeTransformationWriter.writeTranslationProperty(new Cartesian(7.0, 8.0, 9.0));
                                    } finally {
                                        DisposeHelper.dispose(nodeTransformationWriter);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(nodeTransformationsWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(modelWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        String expectedValue = "{\"model\":{\"nodeTransformations\":{"
                + "\"node1\":{\"scale\":{\"cartesian\":[1,2,3]},\"rotation\":{\"unitQuaternion\":[0,0,0,1]},\"translation\":{\"cartesian\":[4,5,6]}},"
                + "\"node2\":{\"scale\":{\"cartesian\":[4,5,6]},\"rotation\":{\"unitQuaternion\":[0,0,1,0]},\"translation\":{\"cartesian\":[7,8,9]}}" + "}}}";
        Assert.assertEquals(expectedValue, getStringWriter().toString());
    }

    @Test
    public final void createExampleFile() {
        {
            StringWriter stringWriter = new StringWriter();
            try {
                final CesiumOutputStream tempObj$0 = new CesiumOutputStream(stringWriter);
                tempObj$0.setPrettyFormatting(true);
                cesiumlanguagewriter.CesiumOutputStream output = tempObj$0;
                cesiumlanguagewriter.CesiumStreamWriter writer = new CesiumStreamWriter();
                {
                    cesiumlanguagewriter.PacketCesiumWriter packet = writer.openPacket(output);
                    try {
                        packet.writeId("MyID");
                        cesiumlanguagewriter.JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
                        cesiumlanguagewriter.JulianDate stopDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 1, 0D));
                        {
                            cesiumlanguagewriter.ClockCesiumWriter clockWriter = packet.openClockProperty();
                            try {
                                {
                                    cesiumlanguagewriter.ClockCesiumWriter intervalClockWriter = clockWriter.openInterval(startDate, stopDate);
                                    try {
                                        intervalClockWriter.writeCurrentTime(startDate);
                                    } finally {
                                        DisposeHelper.dispose(intervalClockWriter);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(clockWriter);
                            }
                        }
                        {
                            cesiumlanguagewriter.ModelCesiumWriter modelWriter = packet.openModelProperty();
                            try {
                                modelWriter.writeGltfProperty(UriHelper.create("example.gltf", UriKind.RELATIVE), CesiumResourceBehavior.LINK_TO);
                                {
                                    cesiumlanguagewriter.NodeTransformationsCesiumWriter nodeTransformationsWriter = modelWriter.openNodeTransformationsProperty();
                                    try {
                                        {
                                            cesiumlanguagewriter.NodeTransformationCesiumWriter nodeTransformationWriter = nodeTransformationsWriter.openNodeTransformationProperty("node1");
                                            try {
                                                nodeTransformationWriter.writeScaleProperty(new Cartesian(1.0, 2.0, 3.0));
                                                nodeTransformationWriter.writeRotationProperty(UnitQuaternion.getIdentity());
                                                nodeTransformationWriter.writeTranslationProperty(new Cartesian(4.0, 5.0, 6.0));
                                            } finally {
                                                DisposeHelper.dispose(nodeTransformationWriter);
                                            }
                                        }
                                        {
                                            cesiumlanguagewriter.NodeTransformationCesiumWriter nodeTransformationWriter = nodeTransformationsWriter.openNodeTransformationProperty("node2");
                                            try {
                                                final ArrayList<cesiumlanguagewriter.JulianDate> tempCollection$0 = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                                tempCollection$0.add(startDate);
                                                tempCollection$0.add(stopDate);
                                                ArrayList<cesiumlanguagewriter.JulianDate> dates = tempCollection$0;
                                                final ArrayList<cesiumlanguagewriter.Cartesian> tempCollection$1 = new ArrayList<cesiumlanguagewriter.Cartesian>();
                                                tempCollection$1.add(new Cartesian(1.0, 2.0, 3.0));
                                                tempCollection$1.add(new Cartesian(10.0, 12.0, 14.0));
                                                ArrayList<cesiumlanguagewriter.Cartesian> values = tempCollection$1;
                                                nodeTransformationWriter.writeScaleProperty(dates, values);
                                            } finally {
                                                DisposeHelper.dispose(nodeTransformationWriter);
                                            }
                                        }
                                    } finally {
                                        DisposeHelper.dispose(nodeTransformationsWriter);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(modelWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(packet);
                    }
                }
                ConsoleHelper.writeLine(stringWriter.toString());
            } finally {
                DisposeHelper.dispose(stringWriter);
            }
        }
    }

    @Override
    protected CesiumPropertyWriter<NodeTransformationsCesiumWriter> createPropertyWriter(String propertyName) {
        return new NodeTransformationsCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}