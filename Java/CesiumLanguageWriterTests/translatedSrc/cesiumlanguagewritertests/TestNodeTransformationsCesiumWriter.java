package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.UriHelper;
import agi.foundation.compatibility.UriKind;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
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

@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestNodeTransformationsCesiumWriter extends TestCesiumPropertyWriter<NodeTransformationsCesiumWriter> {
    @Test
    public final void singleNodeTransformation() {
        final String expectedNodeName = "node1";
        Cartesian expectedScale = Cartesian.getZero();
        UnitQuaternion expectedRotation = UnitQuaternion.getIdentity();
        Cartesian expectedTranslation = new Cartesian(3.0, 3.0, 3.0);
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    ModelCesiumWriter modelWriter = getPacket().openModelProperty();
                    try {
                        {
                            NodeTransformationsCesiumWriter nodeTransformationsWriter = modelWriter.openNodeTransformationsProperty();
                            try {
                                {
                                    NodeTransformationCesiumWriter nodeTransformationWriter = nodeTransformationsWriter.openNodeTransformationProperty(expectedNodeName);
                                    try {
                                        nodeTransformationWriter.writeScaleProperty(expectedScale);
                                        nodeTransformationWriter.writeRotationProperty(expectedRotation);
                                        nodeTransformationWriter.writeTranslationProperty(expectedTranslation);
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
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, NodeTransformationCesiumWriter.ScalePropertyName, expectedScale);
        MapHelper.add(tempCollection$2, NodeTransformationCesiumWriter.RotationPropertyName, expectedRotation);
        MapHelper.add(tempCollection$2, NodeTransformationCesiumWriter.TranslationPropertyName, expectedTranslation);
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, expectedNodeName, tempCollection$2);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.NodeTransformationsPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void multipleNodeTransformations() {
        final String expectedNodeName1 = "node1";
        Cartesian expectedScale1 = new Cartesian(1.0, 2.0, 3.0);
        UnitQuaternion expectedRotation1 = new UnitQuaternion(1.0, 0.0, 0.0, 0.0);
        Cartesian expectedTranslation1 = new Cartesian(4.0, 5.0, 6.0);
        final String expectedNodeName2 = "node2";
        Cartesian expectedScale2 = new Cartesian(4.0, 5.0, 6.0);
        UnitQuaternion expectedRotation2 = new UnitQuaternion(0.0, 0.0, 0.0, 1.0);
        Cartesian expectedTranslation2 = new Cartesian(7.0, 8.0, 9.0);
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    ModelCesiumWriter modelWriter = getPacket().openModelProperty();
                    try {
                        {
                            NodeTransformationsCesiumWriter nodeTransformationsWriter = modelWriter.openNodeTransformationsProperty();
                            try {
                                {
                                    NodeTransformationCesiumWriter nodeTransformationWriter = nodeTransformationsWriter.openNodeTransformationProperty(expectedNodeName1);
                                    try {
                                        nodeTransformationWriter.writeScaleProperty(expectedScale1);
                                        nodeTransformationWriter.writeRotationProperty(expectedRotation1);
                                        nodeTransformationWriter.writeTranslationProperty(expectedTranslation1);
                                    } finally {
                                        DisposeHelper.dispose(nodeTransformationWriter);
                                    }
                                }
                                {
                                    NodeTransformationCesiumWriter nodeTransformationWriter = nodeTransformationsWriter.openNodeTransformationProperty(expectedNodeName2);
                                    try {
                                        nodeTransformationWriter.writeScaleProperty(expectedScale2);
                                        nodeTransformationWriter.writeRotationProperty(expectedRotation2);
                                        nodeTransformationWriter.writeTranslationProperty(expectedTranslation2);
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
        final Map<String, Object> tempCollection$5 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$5, NodeTransformationCesiumWriter.ScalePropertyName, expectedScale1);
        MapHelper.add(tempCollection$5, NodeTransformationCesiumWriter.RotationPropertyName, expectedRotation1);
        MapHelper.add(tempCollection$5, NodeTransformationCesiumWriter.TranslationPropertyName, expectedTranslation1);
        final Map<String, Object> tempCollection$6 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$6, NodeTransformationCesiumWriter.ScalePropertyName, expectedScale2);
        MapHelper.add(tempCollection$6, NodeTransformationCesiumWriter.RotationPropertyName, expectedRotation2);
        MapHelper.add(tempCollection$6, NodeTransformationCesiumWriter.TranslationPropertyName, expectedTranslation2);
        final Map<String, Object> tempCollection$4 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$4, expectedNodeName1, tempCollection$5);
        MapHelper.add(tempCollection$4, expectedNodeName2, tempCollection$6);
        final Map<String, Object> tempCollection$3 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$3, ModelCesiumWriter.NodeTransformationsPropertyName, tempCollection$4);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$3);
    }

    @Test
    public final void createExampleFile() {
        {
            StringWriter stringWriter = new StringWriter();
            try {
                CesiumOutputStream output = new CesiumOutputStream(stringWriter, true);
                CesiumStreamWriter writer = new CesiumStreamWriter();
                {
                    PacketCesiumWriter packet = writer.openPacket(output);
                    try {
                        packet.writeId("MyID");
                        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
                        JulianDate stopDate = new GregorianDate(2012, 4, 2, 12, 1, 0D).toJulianDate();
                        {
                            ClockCesiumWriter clockWriter = packet.openClockProperty();
                            try {
                                {
                                    ClockCesiumWriter intervalClockWriter = clockWriter.openInterval(startDate, stopDate);
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
                            ModelCesiumWriter modelWriter = packet.openModelProperty();
                            try {
                                modelWriter.writeGltfProperty(UriHelper.create("example.gltf", UriKind.RELATIVE), CesiumResourceBehavior.LINK_TO);
                                {
                                    NodeTransformationsCesiumWriter nodeTransformationsWriter = modelWriter.openNodeTransformationsProperty();
                                    try {
                                        {
                                            NodeTransformationCesiumWriter nodeTransformationWriter = nodeTransformationsWriter.openNodeTransformationProperty("node1");
                                            try {
                                                nodeTransformationWriter.writeScaleProperty(new Cartesian(1.0, 2.0, 3.0));
                                                nodeTransformationWriter.writeRotationProperty(UnitQuaternion.getIdentity());
                                                nodeTransformationWriter.writeTranslationProperty(new Cartesian(4.0, 5.0, 6.0));
                                            } finally {
                                                DisposeHelper.dispose(nodeTransformationWriter);
                                            }
                                        }
                                        {
                                            NodeTransformationCesiumWriter nodeTransformationWriter = nodeTransformationsWriter.openNodeTransformationProperty("node2");
                                            try {
                                                final ArrayList<cesiumlanguagewriter.JulianDate> tempCollection$7 = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                                tempCollection$7.add(startDate);
                                                tempCollection$7.add(stopDate);
                                                ArrayList<cesiumlanguagewriter.JulianDate> dates = tempCollection$7;
                                                final ArrayList<cesiumlanguagewriter.Cartesian> tempCollection$8 = new ArrayList<cesiumlanguagewriter.Cartesian>();
                                                tempCollection$8.add(new Cartesian(1.0, 2.0, 3.0));
                                                tempCollection$8.add(new Cartesian(10.0, 12.0, 14.0));
                                                ArrayList<cesiumlanguagewriter.Cartesian> values = tempCollection$8;
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
    private static final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    @ClassRule
    public static TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}