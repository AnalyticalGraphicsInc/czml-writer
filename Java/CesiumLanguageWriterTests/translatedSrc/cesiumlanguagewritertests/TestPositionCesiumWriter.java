package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import org.junit.Assert;
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
public class TestPositionCesiumWriter extends TestCesiumInterpolatablePropertyWriter<PositionCesiumWriter> {
    @Test
    public final void referenceFrameValueWritesReferenceFrameProperty() {
        final String expectedReferenceFrame = "myReferenceFrame";
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                interval.writeReferenceFrame(expectedReferenceFrame);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PositionCesiumWriter.ReferenceFramePropertyName, expectedReferenceFrame);
        assertExpectedJson(PacketCesiumWriter.PositionPropertyName, tempCollection$0);
    }

    @Test
    public final void cartesianValueWritesSingleCartesianProperty() {
        Cartesian expectedValue = new Cartesian(1.0, 2.0, 3.0);
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                interval.writeCartesian(expectedValue);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PacketCesiumWriter.PositionPropertyName, expectedValue);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void cartographicRadiansValueWritesSingleCartographicRadiansProperty() {
        Cartographic expectedValue = new Cartographic(1100.0, 2200.0, 3.0);
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                interval.writeCartographicRadians(expectedValue);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PacketCesiumWriter.PositionPropertyName, expectedValue);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void cartesianValueWritesMultipleCartesianProperty() {
        JulianDate epoch = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                ArrayList<cesiumlanguagewriter.Cartesian> positions = new ArrayList<cesiumlanguagewriter.Cartesian>();
                                dates.add(epoch);
                                positions.add(new Cartesian(1.1, 2.2, 3.3));
                                dates.add(epoch.addSeconds(60.0));
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
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        Assert.assertEquals("{\"position\":{\"epoch\":\"20120402T12Z\",\"cartesian\":[0,1.1,2.2,3.3,60,4.4,5.5,6.6]}}", getStringWriter().toString());
    }

    @Test
    public final void cartesianValueSubsetWritesMultipleCartesianProperty() {
        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
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
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        Assert.assertEquals("{\"position\":{\"epoch\":\"20120402T1201Z\",\"cartesian\":[0,4,5,6]}}", getStringWriter().toString());
    }

    @Test
    public final void cartographicRadiansValueWritesMultipleCartographicRadiansProperty() {
        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
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
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        Assert.assertEquals("{\"position\":{\"epoch\":\"20120402T12Z\",\"cartographicRadians\":[0,1.1,2.2,3.3,60,4.4,5.5,6.6]}}", getStringWriter().toString());
    }

    @Test
    public final void cartographicRadiansValueSubsetWritesMultipleCartographicRadiansProperty() {
        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
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
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        Assert.assertEquals("{\"position\":{\"epoch\":\"20120402T1201Z\",\"cartographicRadians\":[0,4,5,6]}}", getStringWriter().toString());
    }

    @Test
    public final void cartesianValueWritesEmptyArrayAndDoesNotWriteEpochWhenGivenAnEmptyCollection() {
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
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
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        Assert.assertEquals("{\"position\":{\"cartesian\":[]}}", getStringWriter().toString());
    }

    @Test
    public final void cartographicRadiansValueWritesEmptyArrayAndDoesNotWriteEpochWhenGivenAnEmptyCollection() {
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
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
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        Assert.assertEquals("{\"position\":{\"cartographicRadians\":[]}}", getStringWriter().toString());
    }

    @Test
    public final void testDeletePropertyWithStartAndStop() {
        JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        JulianDate stop = start.addDays(1.0);
        final String expectedId = "id";
        final boolean expectedDelete = true;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                getPacket().writeId(expectedId);
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval(start, stop);
                            try {
                                interval.writeDelete(expectedDelete);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$1, PositionCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PacketCesiumWriter.IdPropertyName, expectedId);
        MapHelper.add(tempCollection$0, PacketCesiumWriter.PositionPropertyName, tempCollection$1);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void testDeletePropertyWithNoInterval() {
        final String expectedId = "id";
        final boolean expectedDelete = true;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                getPacket().writeId(expectedId);
                {
                    PositionCesiumWriter position = getPacket().openPositionProperty();
                    try {
                        {
                            PositionCesiumWriter interval = position.openInterval();
                            try {
                                interval.writeDelete(expectedDelete);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(position);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, PositionCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, PacketCesiumWriter.IdPropertyName, expectedId);
        MapHelper.add(tempCollection$0, PacketCesiumWriter.PositionPropertyName, tempCollection$1);
        assertExpectedJson(tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<PositionCesiumWriter> createPropertyWriter(String propertyName) {
        return new PositionCesiumWriter(propertyName);
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