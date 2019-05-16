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
public class TestBillboardCesiumWriter extends TestCesiumPropertyWriter<BillboardCesiumWriter> {
    @Test
    public final void testShowProperty() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            cesiumlanguagewriter.BillboardCesiumWriter interval = billboard.openInterval();
                            try {
                                interval.writeShowProperty(true);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(billboard);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        Assert.assertEquals("{\"billboard\":{\"show\":true}}", getStringWriter().toString());
    }

    @Test
    public final void testShowPropertyInterval() {
        cesiumlanguagewriter.JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
        cesiumlanguagewriter.JulianDate stopDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 1, 0D));
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            cesiumlanguagewriter.BooleanCesiumWriter show = billboard.openShowProperty();
                            try {
                                {
                                    cesiumlanguagewriter.CesiumIntervalListWriter<cesiumlanguagewriter.BooleanCesiumWriter> showIntervals = show.openMultipleIntervals();
                                    try {
                                        {
                                            cesiumlanguagewriter.BooleanCesiumWriter interval = showIntervals.openInterval(startDate, startDate.addSeconds(1D));
                                            try {
                                                interval.writeBoolean(true);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                        {
                                            cesiumlanguagewriter.BooleanCesiumWriter interval = showIntervals.openInterval(startDate.addSeconds(1D), startDate.addSeconds(2D));
                                            try {
                                                interval.writeBoolean(false);
                                            } finally {
                                                DisposeHelper.dispose(interval);
                                            }
                                        }
                                        {
                                            cesiumlanguagewriter.BooleanCesiumWriter interval = showIntervals.openInterval(startDate.addSeconds(2D), stopDate);
                                            try {
                                                interval.writeBoolean(true);
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
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        String interval1String = CesiumFormattingHelper.toIso8601Interval(startDate, startDate.addSeconds(1D), Iso8601Format.COMPACT);
        String interval2String = CesiumFormattingHelper.toIso8601Interval(startDate.addSeconds(1D), startDate.addSeconds(2D), Iso8601Format.COMPACT);
        String interval3String = CesiumFormattingHelper.toIso8601Interval(startDate.addSeconds(2D), stopDate, Iso8601Format.COMPACT);
        Assert.assertEquals("{\"billboard\":{\"show\":[{\"interval\":\"" + interval1String + "\",\"boolean\":true}," + "{\"interval\":\"" + interval2String + "\",\"boolean\":false},"
                + "{\"interval\":\"" + interval3String + "\",\"boolean\":true}" + "]}}", getStringWriter().toString());
    }

    @Test
    public final void testScaleByDistanceProperty() {
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            cesiumlanguagewriter.BillboardCesiumWriter interval = billboard.openInterval();
                            try {
                                interval.writeScaleByDistanceProperty(new NearFarScalar(100.0, 1.0, 200.0, 2.0));
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(billboard);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_2);
            }
        }
        Assert.assertEquals("{\"billboard\":{\"scaleByDistance\":{\"nearFarScalar\":[100,1,200,2]}}}", getStringWriter().toString());
    }

    @Test
    public final void testScaleByDistancePropertySamples() {
        cesiumlanguagewriter.JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
        {
            final PacketCesiumWriter usingExpression_3 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            cesiumlanguagewriter.BillboardCesiumWriter interval = billboard.openInterval();
                            try {
                                {
                                    cesiumlanguagewriter.NearFarScalarCesiumWriter scaleByDistance = interval.openScaleByDistanceProperty();
                                    try {
                                        ArrayList<cesiumlanguagewriter.JulianDate> dates = new ArrayList<cesiumlanguagewriter.JulianDate>();
                                        ArrayList<cesiumlanguagewriter.NearFarScalar> values = new ArrayList<cesiumlanguagewriter.NearFarScalar>();
                                        dates.add(startDate);
                                        values.add(new NearFarScalar(100.0, 1.0, 200.0, 2.0));
                                        dates.add(startDate.addSeconds(60.0));
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
                DisposeHelper.dispose(usingExpression_3);
            }
        }
        Assert.assertEquals("{\"billboard\":{\"scaleByDistance\":{\"epoch\":\"20120402T12Z\",\"nearFarScalar\":[0,100,1,200,2,60,200,1,300,2]}}}", getStringWriter().toString());
    }

    @Test
    public final void testDeleteAlignedAxis() {
        {
            final PacketCesiumWriter usingExpression_4 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            cesiumlanguagewriter.AlignedAxisCesiumWriter alignedAxis = billboard.openAlignedAxisProperty();
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
                DisposeHelper.dispose(usingExpression_4);
            }
        }
        Assert.assertEquals("{\"billboard\":{\"alignedAxis\":{\"delete\":true}}}", getStringWriter().toString());
    }

    @Test
    public final void testDeleteScale() {
        {
            final PacketCesiumWriter usingExpression_5 = (getPacket());
            try {
                {
                    cesiumlanguagewriter.BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            cesiumlanguagewriter.DoubleCesiumWriter scale = billboard.openScaleProperty();
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
                DisposeHelper.dispose(usingExpression_5);
            }
        }
        Assert.assertEquals("{\"billboard\":{\"scale\":{\"delete\":true}}}", getStringWriter().toString());
    }

    @Override
    protected CesiumPropertyWriter<BillboardCesiumWriter> createPropertyWriter(String propertyName) {
        return new BillboardCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}