package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
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
public class TestPositionCesiumWriter extends TestCesiumInterpolatablePropertyWriter<PositionCesiumWriter> {
    @Test
    public final void referenceFrameValueWritesReferenceFrameProperty() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                interval.writeReferenceFrame("myReferenceFrame");
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        Assert.assertEquals("{\"position\":{\"referenceFrame\":\"myReferenceFrame\"}}", getStringWriter().toString());
    }

    @Test
    public final void cartesianValueWritesSingleCartesianProperty() {
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                interval.writeCartesian(new Cartesian(1.0, 2.0, 3.0));
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        Assert.assertEquals("{\"position\":{\"cartesian\":[1,2,3]}}", getStringWriter().toString());
    }

    @Test
    public final void cartographicRadiansValueWritesSingleCartographicRadiansProperty() {
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
            try {
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                interval.writeCartographicRadians(new Cartographic(1100.0, 2200.0, 3.0));
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_2);
            }
        }
        Assert.assertEquals("{\"position\":{\"cartographicRadians\":[1100,2200,3]}}", getStringWriter().toString());
    }

    @Test
    public final void cartesianValueWritesMultipleCartesianProperty() {
        JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
        {
            final PacketCesiumWriter usingExpression_3 = (getPacket());
            try {
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                ArrayList<cesiumlanguagewriter.Cartesian> positions = new ArrayList<cesiumlanguagewriter.Cartesian>();
                                dates.add(startDate);
                                positions.add(new Cartesian(1.1, 2.2, 3.3));
                                dates.add(startDate.addSeconds(60.0));
                                positions.add(new Cartesian(4.4, 5.5, 6.6));
                                interval.writeCartesian(dates, positions);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_3);
            }
        }
        Assert.assertEquals("{\"position\":{\"epoch\":\"20120402T12Z\",\"cartesian\":[0,1.1,2.2,3.3,60,4.4,5.5,6.6]}}", getStringWriter().toString());
    }

    @Test
    public final void cartesianValueSubsetWritesMultipleCartesianProperty() {
        JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
        {
            final PacketCesiumWriter usingExpression_4 = (getPacket());
            try {
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                ArrayList<cesiumlanguagewriter.Cartesian> positions = new ArrayList<cesiumlanguagewriter.Cartesian>();
                                dates.add(startDate);
                                positions.add(new Cartesian(1.0, 2.0, 3.0));
                                dates.add(startDate.addSeconds(60.0));
                                positions.add(new Cartesian(4.0, 5.0, 6.0));
                                dates.add(startDate.addSeconds(120.0));
                                positions.add(new Cartesian(7.0, 8.0, 9.0));
                                interval.writeCartesian(dates, positions, 1, 1);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_4);
            }
        }
        Assert.assertEquals("{\"position\":{\"epoch\":\"20120402T1201Z\",\"cartesian\":[0,4,5,6]}}", getStringWriter().toString());
    }

    @Test
    public final void cartographicRadiansValueWritesMultipleCartographicRadiansProperty() {
        JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
        {
            final PacketCesiumWriter usingExpression_5 = (getPacket());
            try {
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                ArrayList<cesiumlanguagewriter.Cartographic> positions = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                dates.add(startDate);
                                positions.add(new Cartographic(1.1, 2.2, 3.3));
                                dates.add(startDate.addSeconds(60.0));
                                positions.add(new Cartographic(4.4, 5.5, 6.6));
                                interval.writeCartographicRadians(dates, positions);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_5);
            }
        }
        Assert.assertEquals("{\"position\":{\"epoch\":\"20120402T12Z\",\"cartographicRadians\":[0,1.1,2.2,3.3,60,4.4,5.5,6.6]}}", getStringWriter().toString());
    }

    @Test
    public final void cartographicRadiansValueSubsetWritesMultipleCartographicRadiansProperty() {
        JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
        {
            final PacketCesiumWriter usingExpression_6 = (getPacket());
            try {
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                ArrayList<cesiumlanguagewriter.Cartographic> positions = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                dates.add(startDate);
                                positions.add(new Cartographic(1.0, 2.0, 3.0));
                                dates.add(startDate.addSeconds(60.0));
                                positions.add(new Cartographic(4.0, 5.0, 6.0));
                                dates.add(startDate.addSeconds(120.0));
                                positions.add(new Cartographic(7.0, 8.0, 9.0));
                                interval.writeCartographicRadians(dates, positions, 1, 1);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_6);
            }
        }
        Assert.assertEquals("{\"position\":{\"epoch\":\"20120402T1201Z\",\"cartographicRadians\":[0,4,5,6]}}", getStringWriter().toString());
    }

    @Test
    public final void cartesianValueWritesEmptyArrayAndDoesNotWriteEpochWhenGivenAnEmptyCollection() {
        {
            final PacketCesiumWriter usingExpression_7 = (getPacket());
            try {
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                ArrayList<cesiumlanguagewriter.Cartesian> positions = new ArrayList<cesiumlanguagewriter.Cartesian>();
                                interval.writeCartesian(dates, positions);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_7);
            }
        }
        Assert.assertEquals("{\"position\":{\"cartesian\":[]}}", getStringWriter().toString());
    }

    @Test
    public final void cartographicRadiansValueWritesEmptyArrayAndDoesNotWriteEpochWhenGivenAnEmptyCollection() {
        {
            final PacketCesiumWriter usingExpression_8 = (getPacket());
            try {
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                ArrayList<cesiumlanguagewriter.Cartographic> positions = new ArrayList<cesiumlanguagewriter.Cartographic>();
                                interval.writeCartographicRadians(dates, positions);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_8);
            }
        }
        Assert.assertEquals("{\"position\":{\"cartographicRadians\":[]}}", getStringWriter().toString());
    }

    @Test
    public final void testDeletePropertyWithStartAndStop() {
        JulianDate start = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
        JulianDate stop = start.addDays(1.0);
        {
            final PacketCesiumWriter usingExpression_9 = (getPacket());
            try {
                getPacket().writeId("id");
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval(start, stop);
                            try {
                                interval.writeDelete(true);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_9);
            }
        }
        Assert.assertEquals("{\"id\":\"id\",\"position\":{\"interval\":\"20120402T12Z/20120403T12Z\",\"delete\":true}}", getStringWriter().toString());
    }

    @Test
    public final void testDeletePropertyWithNoInterval() {
        {
            final PacketCesiumWriter usingExpression_10 = (getPacket());
            try {
                getPacket().writeId("id");
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                interval.writeDelete(true);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_10);
            }
        }
        Assert.assertEquals("{\"id\":\"id\",\"position\":{\"delete\":true}}", getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<PositionCesiumWriter> createPropertyWriter(String propertyName) {
        return new PositionCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}