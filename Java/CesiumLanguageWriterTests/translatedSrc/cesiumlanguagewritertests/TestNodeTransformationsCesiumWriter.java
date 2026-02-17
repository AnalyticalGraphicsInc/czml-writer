package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ConsoleHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.UriHelper;
import agi.foundation.compatibility.UriKind;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
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
public class TestNodeTransformationsCesiumWriter extends TestCesiumPropertyWriter<NodeTransformationsCesiumWriter> {
    @Test
    public final void singleNodeTransformation() {
        final String expectedNodeName = "node1";
        Cartesian expectedScale = Cartesian.getZero();
        UnitQuaternion expectedRotation = UnitQuaternion.getIdentity();
        Cartesian expectedTranslation = new Cartesian(3.0, 3.0, 3.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<NodeTransformationsCesiumWriter> using$2 = new Using<NodeTransformationsCesiumWriter>(model.openNodeTransformationsProperty())) {
                    final NodeTransformationsCesiumWriter nodeTransformations = using$2.resource;
                    try (Using<NodeTransformationCesiumWriter> using$3 = new Using<NodeTransformationCesiumWriter>(nodeTransformations.openNodeTransformationProperty(expectedNodeName))) {
                        final NodeTransformationCesiumWriter nodeTransformation = using$3.resource;
                        nodeTransformation.writeScaleProperty(expectedScale);
                        nodeTransformation.writeRotationProperty(expectedRotation);
                        nodeTransformation.writeTranslationProperty(expectedTranslation);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$2 = MapHelper.create();
        MapHelper.add(tempCollection$2, NodeTransformationCesiumWriter.ScalePropertyName, expectedScale);
        MapHelper.add(tempCollection$2, NodeTransformationCesiumWriter.RotationPropertyName, expectedRotation);
        MapHelper.add(tempCollection$2, NodeTransformationCesiumWriter.TranslationPropertyName, expectedTranslation);
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, expectedNodeName, tempCollection$2);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
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
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                final ModelCesiumWriter model = using$1.resource;
                try (Using<NodeTransformationsCesiumWriter> using$2 = new Using<NodeTransformationsCesiumWriter>(model.openNodeTransformationsProperty())) {
                    final NodeTransformationsCesiumWriter nodeTransformations = using$2.resource;
                    try (Using<NodeTransformationCesiumWriter> using$3 = new Using<NodeTransformationCesiumWriter>(nodeTransformations.openNodeTransformationProperty(expectedNodeName1))) {
                        final NodeTransformationCesiumWriter nodeTransformation = using$3.resource;
                        nodeTransformation.writeScaleProperty(expectedScale1);
                        nodeTransformation.writeRotationProperty(expectedRotation1);
                        nodeTransformation.writeTranslationProperty(expectedTranslation1);
                    }
                    try (Using<NodeTransformationCesiumWriter> using$4 = new Using<NodeTransformationCesiumWriter>(nodeTransformations.openNodeTransformationProperty(expectedNodeName2))) {
                        final NodeTransformationCesiumWriter nodeTransformation = using$4.resource;
                        nodeTransformation.writeScaleProperty(expectedScale2);
                        nodeTransformation.writeRotationProperty(expectedRotation2);
                        nodeTransformation.writeTranslationProperty(expectedTranslation2);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$2 = MapHelper.create();
        MapHelper.add(tempCollection$2, NodeTransformationCesiumWriter.ScalePropertyName, expectedScale1);
        MapHelper.add(tempCollection$2, NodeTransformationCesiumWriter.RotationPropertyName, expectedRotation1);
        MapHelper.add(tempCollection$2, NodeTransformationCesiumWriter.TranslationPropertyName, expectedTranslation1);
        final Map<String, Object> tempCollection$3 = MapHelper.create();
        MapHelper.add(tempCollection$3, NodeTransformationCesiumWriter.ScalePropertyName, expectedScale2);
        MapHelper.add(tempCollection$3, NodeTransformationCesiumWriter.RotationPropertyName, expectedRotation2);
        MapHelper.add(tempCollection$3, NodeTransformationCesiumWriter.TranslationPropertyName, expectedTranslation2);
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, expectedNodeName1, tempCollection$2);
        MapHelper.add(tempCollection$1, expectedNodeName2, tempCollection$3);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.NodeTransformationsPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void createExampleFile() {
        try (Using<StringWriter> using$0 = new Using<StringWriter>(new StringWriter())) {
            final StringWriter stringWriter = using$0.resource;
            CesiumOutputStream output = new CesiumOutputStream(stringWriter, true);
            CesiumStreamWriter writer = new CesiumStreamWriter();
            try (Using<PacketCesiumWriter> using$1 = new Using<PacketCesiumWriter>(writer.openPacket(output))) {
                final PacketCesiumWriter packet = using$1.resource;
                packet.writeId("MyID");
                JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
                JulianDate stopDate = new GregorianDate(2012, 4, 2, 12, 1, 0.0).toJulianDate();
                try (Using<ClockCesiumWriter> using$2 = new Using<ClockCesiumWriter>(packet.openClockProperty())) {
                    final ClockCesiumWriter clock = using$2.resource;
                    try (Using<ClockCesiumWriter> using$3 = new Using<ClockCesiumWriter>(clock.openInterval(startDate, stopDate))) {
                        final ClockCesiumWriter interval = using$3.resource;
                        interval.writeCurrentTime(startDate);
                    }
                }
                try (Using<ModelCesiumWriter> using$4 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                    final ModelCesiumWriter model = using$4.resource;
                    model.writeGltfProperty(UriHelper.create("example.gltf", UriKind.RELATIVE), CesiumResourceBehavior.LINK_TO);
                    try (Using<NodeTransformationsCesiumWriter> using$5 = new Using<NodeTransformationsCesiumWriter>(model.openNodeTransformationsProperty())) {
                        final NodeTransformationsCesiumWriter nodeTransformations = using$5.resource;
                        try (Using<NodeTransformationCesiumWriter> using$6 = new Using<NodeTransformationCesiumWriter>(nodeTransformations.openNodeTransformationProperty("node1"))) {
                            final NodeTransformationCesiumWriter nodeTransformation = using$6.resource;
                            nodeTransformation.writeScaleProperty(new Cartesian(1.0, 2.0, 3.0));
                            nodeTransformation.writeRotationProperty(UnitQuaternion.getIdentity());
                            nodeTransformation.writeTranslationProperty(new Cartesian(4.0, 5.0, 6.0));
                        }
                        try (Using<NodeTransformationCesiumWriter> using$7 = new Using<NodeTransformationCesiumWriter>(nodeTransformations.openNodeTransformationProperty("node2"))) {
                            final NodeTransformationCesiumWriter nodeTransformation = using$7.resource;
                            final ArrayList<JulianDate> tempCollection$0 = new ArrayList<JulianDate>();
                            tempCollection$0.add(startDate);
                            tempCollection$0.add(stopDate);
                            ArrayList<JulianDate> dates = tempCollection$0;
                            final ArrayList<Cartesian> tempCollection$1 = new ArrayList<Cartesian>();
                            tempCollection$1.add(new Cartesian(1.0, 2.0, 3.0));
                            tempCollection$1.add(new Cartesian(10.0, 12.0, 14.0));
                            ArrayList<Cartesian> values = tempCollection$1;
                            nodeTransformation.writeScaleProperty(dates, values);
                        }
                    }
                }
            }
            ConsoleHelper.writeLine(stringWriter.toString());
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