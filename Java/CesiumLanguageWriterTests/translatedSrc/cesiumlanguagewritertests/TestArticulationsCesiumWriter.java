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
public class TestArticulationsCesiumWriter extends TestCesiumPropertyWriter<ArticulationsCesiumWriter> {
    @Test
    public final void singleArticulation() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    ModelCesiumWriter modelWriter = getPacket().openModelProperty();
                    try {
                        {
                            ArticulationsCesiumWriter articulationsWriter = modelWriter.openArticulationsProperty();
                            try {
                                {
                                    ArticulationCesiumWriter articulationWriter = articulationsWriter.openArticulationProperty("articulation1 stage1");
                                    try {
                                        articulationWriter.writeNumber(3.5);
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
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        final String expected = "{\"model\":{\"articulations\":{\"articulation1 stage1\":3.5}}}";
        Assert.assertEquals(expected, getStringWriter().toString());
    }

    @Test
    public final void multipleArticulations() {
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    ModelCesiumWriter modelWriter = getPacket().openModelProperty();
                    try {
                        {
                            ArticulationsCesiumWriter articulationsWriter = modelWriter.openArticulationsProperty();
                            try {
                                {
                                    ArticulationCesiumWriter articulationWriter = articulationsWriter.openArticulationProperty("articulation1 stage1");
                                    try {
                                        articulationWriter.writeNumber(4.0);
                                    } finally {
                                        DisposeHelper.dispose(articulationWriter);
                                    }
                                }
                                {
                                    ArticulationCesiumWriter articulationWriter = articulationsWriter.openArticulationProperty("articulation1 stage2");
                                    try {
                                        articulationWriter.writeNumber(5.0);
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
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        final String expected = "{\"model\":{\"articulations\":{\"articulation1 stage1\":4,\"articulation1 stage2\":5}}}";
        Assert.assertEquals(expected, getStringWriter().toString());
    }

    @Test
    public final void createExampleFile() {
        {
            StringWriter stringWriter = new StringWriter();
            try {
                final CesiumOutputStream tempObj$0 = new CesiumOutputStream(stringWriter);
                tempObj$0.setPrettyFormatting(true);
                CesiumOutputStream output = tempObj$0;
                CesiumStreamWriter writer = new CesiumStreamWriter();
                {
                    PacketCesiumWriter packet = writer.openPacket(output);
                    try {
                        packet.writeId("MyID");
                        JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
                        JulianDate stopDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 1, 0D));
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
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}