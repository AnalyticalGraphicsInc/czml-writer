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
public class TestArticulationsCesiumWriter extends TestCesiumPropertyWriter<ArticulationsCesiumWriter> {
    @Test
    public final void singleArticulation() {
        final String expectedName = "articulation1 stage1";
        final double expectedValue = 3.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(getPacket().openModelProperty())) {
                final ModelCesiumWriter modelWriter = using$1.resource;
                try (Using<ArticulationsCesiumWriter> using$2 = new Using<ArticulationsCesiumWriter>(modelWriter.openArticulationsProperty())) {
                    final ArticulationsCesiumWriter articulationsWriter = using$2.resource;
                    try (Using<ArticulationCesiumWriter> using$3 = new Using<ArticulationCesiumWriter>(articulationsWriter.openArticulationProperty(expectedName))) {
                        final ArticulationCesiumWriter articulationWriter = using$3.resource;
                        articulationWriter.writeNumber(expectedValue);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, expectedName, expectedValue);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ArticulationsPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void multipleArticulations() {
        final String expectedName1 = "articulation1 stage1";
        final double expectedValue1 = 4.5;
        final String expectedName2 = "articulation1 stage2";
        final double expectedValue2 = 5.5;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<ModelCesiumWriter> using$1 = new Using<ModelCesiumWriter>(getPacket().openModelProperty())) {
                final ModelCesiumWriter modelWriter = using$1.resource;
                try (Using<ArticulationsCesiumWriter> using$2 = new Using<ArticulationsCesiumWriter>(modelWriter.openArticulationsProperty())) {
                    final ArticulationsCesiumWriter articulationsWriter = using$2.resource;
                    try (Using<ArticulationCesiumWriter> using$3 = new Using<ArticulationCesiumWriter>(articulationsWriter.openArticulationProperty(expectedName1))) {
                        final ArticulationCesiumWriter articulationWriter = using$3.resource;
                        articulationWriter.writeNumber(expectedValue1);
                    }
                    try (Using<ArticulationCesiumWriter> using$4 = new Using<ArticulationCesiumWriter>(articulationsWriter.openArticulationProperty(expectedName2))) {
                        final ArticulationCesiumWriter articulationWriter = using$4.resource;
                        articulationWriter.writeNumber(expectedValue2);
                    }
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, expectedName1, expectedValue1);
        MapHelper.add(tempCollection$1, expectedName2, expectedValue2);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ArticulationsPropertyName, tempCollection$1);
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
                    final ClockCesiumWriter clockWriter = using$2.resource;
                    try (Using<ClockCesiumWriter> using$3 = new Using<ClockCesiumWriter>(clockWriter.openInterval(startDate, stopDate))) {
                        final ClockCesiumWriter intervalClockWriter = using$3.resource;
                        intervalClockWriter.writeCurrentTime(startDate);
                    }
                }
                try (Using<ModelCesiumWriter> using$4 = new Using<ModelCesiumWriter>(packet.openModelProperty())) {
                    final ModelCesiumWriter modelWriter = using$4.resource;
                    modelWriter.writeGltfProperty(UriHelper.create("example.gltf", UriKind.RELATIVE), CesiumResourceBehavior.LINK_TO);
                    try (Using<ArticulationsCesiumWriter> using$5 = new Using<ArticulationsCesiumWriter>(modelWriter.openArticulationsProperty())) {
                        final ArticulationsCesiumWriter articulationsWriter = using$5.resource;
                        try (Using<ArticulationCesiumWriter> using$6 = new Using<ArticulationCesiumWriter>(articulationsWriter.openArticulationProperty("articulation1 stage1"))) {
                            final ArticulationCesiumWriter articulationWriter = using$6.resource;
                            articulationWriter.writeNumber(45.0);
                        }
                        try (Using<ArticulationCesiumWriter> using$7 = new Using<ArticulationCesiumWriter>(articulationsWriter.openArticulationProperty("articulation1 stage2"))) {
                            final ArticulationCesiumWriter articulationWriter = using$7.resource;
                            final ArrayList<JulianDate> tempCollection$0 = new ArrayList<JulianDate>();
                            tempCollection$0.add(startDate);
                            tempCollection$0.add(stopDate);
                            ArrayList<JulianDate> dates = tempCollection$0;
                            final ArrayList<Double> tempCollection$1 = new ArrayList<Double>();
                            tempCollection$1.add(1.0);
                            tempCollection$1.add(10.0);
                            ArrayList<Double> values = tempCollection$1;
                            articulationWriter.writeNumber(dates, values);
                        }
                    }
                }
            }
            ConsoleHelper.writeLine(stringWriter.toString());
        }
    }

    @Override
    protected CesiumPropertyWriter<ArticulationsCesiumWriter> createPropertyWriter(String propertyName) {
        return new ArticulationsCesiumWriter(propertyName);
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