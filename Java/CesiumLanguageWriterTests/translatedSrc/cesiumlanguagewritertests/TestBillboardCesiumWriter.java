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
public class TestBillboardCesiumWriter extends TestCesiumPropertyWriter<BillboardCesiumWriter> {
    @Test
    public final void testShowProperty() {
        final boolean expectedShow = true;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            BillboardCesiumWriter interval = billboard.openInterval();
                            try {
                                interval.writeShowProperty(expectedShow);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(billboard);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testShowPropertyInterval() {
        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        JulianDate stopDate = new GregorianDate(2012, 4, 2, 12, 1, 0D).toJulianDate();
        JulianDate interval1Start = startDate;
        JulianDate interval1Stop = startDate.addSeconds(1D);
        JulianDate interval2Start = interval1Stop;
        JulianDate interval2Stop = startDate.addSeconds(2D);
        JulianDate interval3Start = interval2Stop;
        JulianDate interval3Stop = stopDate;
        final boolean interval1Value = true;
        final boolean interval2Value = false;
        final boolean interval3Value = true;
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            BooleanCesiumWriter show = billboard.openShowProperty();
                            try {
                                {
                                    CesiumIntervalListWriter<cesiumlanguagewriter.BooleanCesiumWriter> showIntervals = show.openMultipleIntervals();
                                    try {
                                        {
                                            BooleanCesiumWriter interval = showIntervals.openInterval(interval1Start, interval1Stop);
                                            try {
                                                interval.writeBoolean(interval1Value);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                        {
                                            BooleanCesiumWriter interval = showIntervals.openInterval(interval2Start, interval2Stop);
                                            try {
                                                interval.writeBoolean(interval2Value);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                        {
                                            BooleanCesiumWriter interval = showIntervals.openInterval(interval3Start, interval3Stop);
                                            try {
                                                interval.writeBoolean(interval3Value);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                    } finally {
                                        DisposeHelper.dispose(showIntervals);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(show);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(billboard);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, "interval", CesiumFormattingHelper.toIso8601Interval(interval1Start, interval1Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$2, BooleanCesiumWriter.BooleanPropertyName, interval1Value);
        final Map<String, Object> tempCollection$3 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$3, "interval", CesiumFormattingHelper.toIso8601Interval(interval2Start, interval2Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$3, BooleanCesiumWriter.BooleanPropertyName, interval2Value);
        final Map<String, Object> tempCollection$4 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$4, "interval", CesiumFormattingHelper.toIso8601Interval(interval3Start, interval3Stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$4, BooleanCesiumWriter.BooleanPropertyName, interval3Value);
        final ArrayList<Map<String, Object>> tempCollection$1 = new ArrayList<Map<String, Object>>();
        tempCollection$1.add(tempCollection$2);
        tempCollection$1.add(tempCollection$3);
        tempCollection$1.add(tempCollection$4);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.ShowPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testScaleByDistanceProperty() {
        NearFarScalar expectedScaleByDistance = new NearFarScalar(100.5, 1.5, 200.5, 2.5);
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            BillboardCesiumWriter interval = billboard.openInterval();
                            try {
                                interval.writeScaleByDistanceProperty(expectedScaleByDistance);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(billboard);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.ScaleByDistancePropertyName, expectedScaleByDistance);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testScaleByDistancePropertySamples() {
        JulianDate epoch = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            BillboardCesiumWriter interval = billboard.openInterval();
                            try {
                                {
                                    NearFarScalarCesiumWriter scaleByDistance = interval.openScaleByDistanceProperty();
                                    try {
                                        ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                        ArrayList<cesiumlanguagewriter.NearFarScalar> values = new ArrayList<cesiumlanguagewriter.NearFarScalar>();
                                        dates.add(epoch);
                                        values.add(new NearFarScalar(100.0, 1.0, 200.0, 2.0));
                                        dates.add(epoch.addSeconds(60.0));
                                        values.add(new NearFarScalar(200.0, 1.0, 300.0, 2.0));
                                        scaleByDistance.writeNearFarScalar(dates, values);
                                    } finally {
                                        DisposeHelper.dispose(scaleByDistance);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(billboard);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        Assert.assertEquals("{\"billboard\":{\"scaleByDistance\":{\"epoch\":\"20120402T12Z\",\"nearFarScalar\":[0,100,1,200,2,60,200,1,300,2]}}}", getStringWriter().toString());
    }

    @Test
    public final void testDeleteAlignedAxis() {
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            AlignedAxisCesiumWriter alignedAxis = billboard.openAlignedAxisProperty();
                            try {
                                alignedAxis.writeDelete(true);
                            } finally {
                                DisposeHelper.dispose(alignedAxis);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(billboard);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, "delete", true);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.AlignedAxisPropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Test
    public final void testDeleteScale() {
        {
            final PacketCesiumWriter usingExpression$0 = (getPacket());
            try {
                {
                    BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            DoubleCesiumWriter scale = billboard.openScaleProperty();
                            try {
                                scale.writeDelete(true);
                            } finally {
                                DisposeHelper.dispose(scale);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(billboard);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression$0);
            }
        }
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, "delete", true);
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, BillboardCesiumWriter.ScalePropertyName, tempCollection$1);
        assertExpectedJson(PacketCesiumWriter.BillboardPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<BillboardCesiumWriter> createPropertyWriter(String propertyName) {
        return new BillboardCesiumWriter(propertyName);
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