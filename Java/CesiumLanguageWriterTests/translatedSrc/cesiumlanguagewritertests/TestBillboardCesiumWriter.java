package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBillboardCesiumWriter extends TestCesiumPropertyWriter<BillboardCesiumWriter> {
    @Override
    protected CesiumPropertyWriter<BillboardCesiumWriter> createPropertyWriter(String propertyName) {
        return new BillboardCesiumWriter(propertyName);
    }

    @Test
    public final void testShowProperty() {
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            BillboardCesiumWriter interval = billboard.openInterval();
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
    public final void testScaleByDistanceProperty() {
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    BillboardCesiumWriter billboard = getPacket().openBillboardProperty();
                    try {
                        {
                            BillboardCesiumWriter interval = billboard.openInterval();
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
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        Assert.assertEquals("{\"billboard\":{\"scaleByDistance\":{\"nearFarScalar\":[100,1,200,2]}}}", getStringWriter().toString());
    }

    @Test
    public final void testScaleByDistancePropertySamples() {
        JulianDate startDate = new JulianDate(new GregorianDate(2012, 4, 2, 12, 0, 0D));
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
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
                DisposeHelper.dispose(usingExpression_2);
            }
        }
        Assert.assertEquals("{\"billboard\":{\"scaleByDistance\":{\"epoch\":\"20120402T12Z\",\"nearFarScalar\":[0,100,1,200,2,60,200,1,300,2]}}}", getStringWriter().toString());
    }

    private TestContextRule rule$testContext = new TestContextRule();

    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}