package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ConsoleHelper;
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
public class TestOrientationCesiumWriter extends TestCesiumInterpolatablePropertyWriter<OrientationCesiumWriter> {
    @Test
    public final void testCompleteExample() {
        JulianDate date = new JulianDate(2451545.0);
        final String id = "MyID";
        TimeInterval availability = new TimeInterval(date, date.addDays(2.0));
        TimeInterval interval1 = new TimeInterval(date, date.addDays(1.0));
        Cartesian interval1Position = new Cartesian(1.0, 2.0, 3.0);
        UnitQuaternion interval1Orientation = new UnitQuaternion(1D, 0D, 0D, 0D);
        TimeInterval interval2 = new TimeInterval(date.addDays(1.0), date.addDays(2.0));
        final ArrayList<cesiumlanguagewriter.JulianDate> tempCollection$0 = new ArrayList<cesiumlanguagewriter.JulianDate>();
        tempCollection$0.add(date.addDays(1.0));
        tempCollection$0.add(date.addDays(1.5));
        tempCollection$0.add(date.addDays(2.0));
        ArrayList<cesiumlanguagewriter.JulianDate> interval2SampleDates = tempCollection$0;
        final ArrayList<cesiumlanguagewriter.Cartographic> tempCollection$1 = new ArrayList<cesiumlanguagewriter.Cartographic>();
        tempCollection$1.add(Cartographic.getZero());
        tempCollection$1.add(new Cartographic(1.0, 0.0, 0.0));
        tempCollection$1.add(new Cartographic(0.0, 1.0, 0.0));
        ArrayList<cesiumlanguagewriter.Cartographic> interval2SamplePositions = tempCollection$1;
        final ArrayList<cesiumlanguagewriter.UnitQuaternion> tempCollection$2 = new ArrayList<cesiumlanguagewriter.UnitQuaternion>();
        tempCollection$2.add(UnitQuaternion.getIdentity());
        tempCollection$2.add(new UnitQuaternion(0.0, 1.0, 0.0, 0.0));
        tempCollection$2.add(new UnitQuaternion(0.0, 0.0, 1.0, 0.0));
        ArrayList<cesiumlanguagewriter.UnitQuaternion> interval2SampleOrientations = tempCollection$2;
        final CesiumInterpolationAlgorithm orientationInterpolationAlgorithm = CesiumInterpolationAlgorithm.LINEAR;
        final int orientationInterpolationDegree = 1;
        StringWriter stringWriter = new StringWriter();
        CesiumOutputStream outputStream = new CesiumOutputStream(stringWriter, true);
        CesiumStreamWriter writer = new CesiumStreamWriter();
        {
            PacketCesiumWriter packet = writer.openPacket(outputStream);
            try {
                packet.writeId(id);
                packet.writeAvailability(availability);
                {
                    PositionCesiumWriter positionWriter = packet.openPositionProperty();
                    try {
                        {
                            CesiumIntervalListWriter<cesiumlanguagewriter.PositionCesiumWriter> intervalListWriter = positionWriter.openMultipleIntervals();
                            try {
                                {
                                    PositionCesiumWriter interval = intervalListWriter.openInterval();
                                    try {
                                        interval.writeInterval(interval1);
                                        interval.writeCartesian(interval1Position);
                                    } finally {
                                        DisposeHelper.dispose(interval);
                                    }
                                }
                                {
                                    PositionCesiumWriter interval = intervalListWriter.openInterval(interval2.getStart(), interval2.getStop());
                                    try {
                                        interval.writeCartographicRadians(interval2SampleDates, interval2SamplePositions);
                                    } finally {
                                        DisposeHelper.dispose(interval);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(intervalListWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(positionWriter);
                    }
                }
                {
                    OrientationCesiumWriter orientationWriter = packet.openOrientationProperty();
                    try {
                        {
                            CesiumIntervalListWriter<cesiumlanguagewriter.OrientationCesiumWriter> intervalListWriter = orientationWriter.openMultipleIntervals();
                            try {
                                {
                                    OrientationCesiumWriter interval = intervalListWriter.openInterval();
                                    try {
                                        interval.writeInterval(interval1);
                                        interval.writeUnitQuaternion(interval1Orientation);
                                    } finally {
                                        DisposeHelper.dispose(interval);
                                    }
                                }
                                {
                                    OrientationCesiumWriter interval = intervalListWriter.openInterval(interval2.getStart(), interval2.getStop());
                                    try {
                                        interval.writeInterpolationAlgorithm(orientationInterpolationAlgorithm);
                                        interval.writeInterpolationDegree(orientationInterpolationDegree);
                                        interval.writeUnitQuaternion(interval2SampleDates, interval2SampleOrientations);
                                    } finally {
                                        DisposeHelper.dispose(interval);
                                    }
                                }
                            } finally {
                                DisposeHelper.dispose(intervalListWriter);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(orientationWriter);
                    }
                }
            } finally {
                DisposeHelper.dispose(packet);
            }
        }
        ConsoleHelper.writeLine(stringWriter.toString());
    }

    @Test
    public final void testDeletePropertyWithStartAndStop() {
        JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0D).toJulianDate();
        JulianDate stop = start.addDays(1.0);
        final String expectedId = "id";
        final boolean expectedDelete = true;
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                getPacket().writeId(expectedId);
                {
                    OrientationCesiumWriter orientation = getPacket().openOrientationProperty();
                    try {
                        {
                            OrientationCesiumWriter interval = orientation.openInterval(start, stop);
                            try {
                                interval.writeDelete(expectedDelete);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(orientation);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        final Map<String, Object> tempCollection$4 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$4, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$4, OrientationCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$3 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$3, PacketCesiumWriter.IdPropertyName, expectedId);
        MapHelper.add(tempCollection$3, PacketCesiumWriter.OrientationPropertyName, tempCollection$4);
        assertExpectedJson(tempCollection$3);
    }

    @Test
    public final void testDeletePropertyWithNoInterval() {
        final String expectedId = "id";
        final boolean expectedDelete = true;
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                getPacket().writeId(expectedId);
                {
                    OrientationCesiumWriter orientation = getPacket().openOrientationProperty();
                    try {
                        {
                            OrientationCesiumWriter interval = orientation.openInterval();
                            try {
                                interval.writeDelete(expectedDelete);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(orientation);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        final Map<String, Object> tempCollection$6 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$6, OrientationCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$5 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$5, PacketCesiumWriter.IdPropertyName, expectedId);
        MapHelper.add(tempCollection$5, PacketCesiumWriter.OrientationPropertyName, tempCollection$6);
        assertExpectedJson(tempCollection$5);
    }

    @Override
    protected CesiumPropertyWriter<OrientationCesiumWriter> createPropertyWriter(String propertyName) {
        return new OrientationCesiumWriter(propertyName);
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}