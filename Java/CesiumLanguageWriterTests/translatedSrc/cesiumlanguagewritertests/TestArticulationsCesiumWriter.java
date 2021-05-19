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
public class TestArticulationsCesiumWriter extends TestCesiumPropertyWriter<ArticulationsCesiumWriter> {
    @Test
    public final void singleArticulation() {
        final String expectedName = "articulation1 stage1";
        final double expectedValue = 3.5;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    ModelCesiumWriter modelWriter = getPacket().openModelProperty();
                    try {
                        {
                            ArticulationsCesiumWriter articulationsWriter = modelWriter.openArticulationsProperty();
                            try {
                                {
                                    ArticulationCesiumWriter articulationWriter = articulationsWriter.openArticulationProperty(expectedName);
                                    try {
                                        articulationWriter.writeNumber(expectedValue);
                                    } finally {
                                        DisposeHelper.dispose(articulationWriter);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(articulationsWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(modelWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, expectedName, expectedValue);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ArticulationsPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
    }

    @Test
    public final void multipleArticulations() {
        final String expectedName1 = "articulation1 stage1";
        final double expectedValue1 = 4.5;
        final String expectedName2 = "articulation1 stage2";
        final double expectedValue2 = 5.5;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    ModelCesiumWriter modelWriter = getPacket().openModelProperty();
                    try {
                        {
                            ArticulationsCesiumWriter articulationsWriter = modelWriter.openArticulationsProperty();
                            try {
                                {
                                    ArticulationCesiumWriter articulationWriter = articulationsWriter.openArticulationProperty(expectedName1);
                                    try {
                                        articulationWriter.writeNumber(expectedValue1);
                                    } finally {
                                        DisposeHelper.dispose(articulationWriter);
                                    }
                                }
                                {
                                    ArticulationCesiumWriter articulationWriter = articulationsWriter.openArticulationProperty(expectedName2);
                                    try {
                                        articulationWriter.writeNumber(expectedValue2);
                                    } finally {
                                        DisposeHelper.dispose(articulationWriter);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(articulationsWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(modelWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, expectedName1, expectedValue1);
        MapHelper.add(tempCollection$1, expectedName2, expectedValue2);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, ModelCesiumWriter.ArticulationsPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.ModelPropertyName, tempCollection$0);
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
                                    ArticulationsCesiumWriter articulationsWriter = modelWriter.openArticulationsProperty();
                                    try {
                                        {
                                            ArticulationCesiumWriter articulationWriter = articulationsWriter.openArticulationProperty("articulation1 stage1");
                                            try {
                                                articulationWriter.writeNumber(45D);
                                            } finally {
                                                DisposeHelper.dispose(articulationWriter);
                                            }
                                        }
                                        {
                                            ArticulationCesiumWriter articulationWriter = articulationsWriter.openArticulationProperty("articulation1 stage2");
                                            try {
                                                final ArrayList<cesiumlanguagewriter.JulianDate> tempCollection$0 = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                                tempCollection$0.add(startDate);
                                                tempCollection$0.add(stopDate);
                                                ArrayList<cesiumlanguagewriter.JulianDate> dates = tempCollection$0;
                                                final ArrayList<Double> tempCollection$1 = new ArrayList<Double>();
                                                tempCollection$1.add(1.0);
                                                tempCollection$1.add(10.0);
                                                ArrayList<Double> values = tempCollection$1;
                                                articulationWriter.writeNumber(dates, values);
                                            } finally {
                                                DisposeHelper.dispose(articulationWriter);
                                            }
                                        }
                                    } finally {
                                        DisposeHelper.dispose(articulationsWriter);
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