package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
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
public class TestPositionCesiumWriter extends TestCesiumInterpolatablePropertyWriter<PositionCesiumWriter> {
    @Test
    public final void referenceFrameValueWritesReferenceFrameProperty() {
        final String expectedReferenceFrame = "myReferenceFrame";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PositionCesiumWriter> using$1 = new Using<PositionCesiumWriter>(getPacket().openPositionProperty())) {
                final PositionCesiumWriter position = using$1.resource;
                try (Using<PositionCesiumWriter> using$2 = new Using<PositionCesiumWriter>(position.openInterval())) {
                    final PositionCesiumWriter interval = using$2.resource;
                    interval.writeReferenceFrame(expectedReferenceFrame);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PositionCesiumWriter.ReferenceFramePropertyName, expectedReferenceFrame);
        assertExpectedJson(PacketCesiumWriter.PositionPropertyName, tempCollection$0);
    }

    @Test
    public final void cartesianValueWritesSingleCartesianProperty() {
        Cartesian expectedValue = new Cartesian(1.0, 2.0, 3.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PositionCesiumWriter> using$1 = new Using<PositionCesiumWriter>(getPacket().openPositionProperty())) {
                final PositionCesiumWriter position = using$1.resource;
                try (Using<PositionCesiumWriter> using$2 = new Using<PositionCesiumWriter>(position.openInterval())) {
                    final PositionCesiumWriter interval = using$2.resource;
                    interval.writeCartesian(expectedValue);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PacketCesiumWriter.PositionPropertyName, expectedValue);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void cartographicRadiansValueWritesSingleCartographicRadiansProperty() {
        Cartographic expectedValue = new Cartographic(1100.0, 2200.0, 3.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PositionCesiumWriter> using$1 = new Using<PositionCesiumWriter>(getPacket().openPositionProperty())) {
                final PositionCesiumWriter position = using$1.resource;
                try (Using<PositionCesiumWriter> using$2 = new Using<PositionCesiumWriter>(position.openInterval())) {
                    final PositionCesiumWriter interval = using$2.resource;
                    interval.writeCartographicRadians(expectedValue);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PacketCesiumWriter.PositionPropertyName, expectedValue);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void cartesianValueWritesMultipleCartesianProperty() {
        JulianDate epoch = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PositionCesiumWriter> using$1 = new Using<PositionCesiumWriter>(getPacket().openPositionProperty())) {
                final PositionCesiumWriter position = using$1.resource;
                try (Using<PositionCesiumWriter> using$2 = new Using<PositionCesiumWriter>(position.openInterval())) {
                    final PositionCesiumWriter interval = using$2.resource;
                    ArrayList<JulianDate> dates = new ArrayList<JulianDate>();
                    ArrayList<Cartesian> positions = new ArrayList<Cartesian>();
                    dates.add(epoch);
                    positions.add(new Cartesian(1.1, 2.2, 3.3));
                    dates.add(epoch.addSeconds(60.0));
                    positions.add(new Cartesian(4.4, 5.5, 6.6));
                    interval.writeCartesian(dates, positions);
                }
            }
        }
        AssertHelper.assertEquals("{\"position\":{\"epoch\":\"20120402T12Z\",\"cartesian\":[0,1.1,2.2,3.3,60,4.4,5.5,6.6]}}", getStringWriter().toString());
    }

    @Test
    public final void cartesianValueSubsetWritesMultipleCartesianProperty() {
        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PositionCesiumWriter> using$1 = new Using<PositionCesiumWriter>(getPacket().openPositionProperty())) {
                final PositionCesiumWriter position = using$1.resource;
                try (Using<PositionCesiumWriter> using$2 = new Using<PositionCesiumWriter>(position.openInterval())) {
                    final PositionCesiumWriter interval = using$2.resource;
                    ArrayList<JulianDate> dates = new ArrayList<JulianDate>();
                    ArrayList<Cartesian> positions = new ArrayList<Cartesian>();
                    dates.add(startDate);
                    positions.add(new Cartesian(1.0, 2.0, 3.0));
                    dates.add(startDate.addSeconds(60.0));
                    positions.add(new Cartesian(4.0, 5.0, 6.0));
                    dates.add(startDate.addSeconds(120.0));
                    positions.add(new Cartesian(7.0, 8.0, 9.0));
                    interval.writeCartesian(dates, positions, 1, 1);
                }
            }
        }
        AssertHelper.assertEquals("{\"position\":{\"epoch\":\"20120402T1201Z\",\"cartesian\":[0,4,5,6]}}", getStringWriter().toString());
    }

    @Test
    public final void cartographicRadiansValueWritesMultipleCartographicRadiansProperty() {
        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PositionCesiumWriter> using$1 = new Using<PositionCesiumWriter>(getPacket().openPositionProperty())) {
                final PositionCesiumWriter position = using$1.resource;
                try (Using<PositionCesiumWriter> using$2 = new Using<PositionCesiumWriter>(position.openInterval())) {
                    final PositionCesiumWriter interval = using$2.resource;
                    ArrayList<JulianDate> dates = new ArrayList<JulianDate>();
                    ArrayList<Cartographic> positions = new ArrayList<Cartographic>();
                    dates.add(startDate);
                    positions.add(new Cartographic(1.1, 2.2, 3.3));
                    dates.add(startDate.addSeconds(60.0));
                    positions.add(new Cartographic(4.4, 5.5, 6.6));
                    interval.writeCartographicRadians(dates, positions);
                }
            }
        }
        AssertHelper.assertEquals("{\"position\":{\"epoch\":\"20120402T12Z\",\"cartographicRadians\":[0,1.1,2.2,3.3,60,4.4,5.5,6.6]}}", getStringWriter().toString());
    }

    @Test
    public final void cartographicRadiansValueSubsetWritesMultipleCartographicRadiansProperty() {
        JulianDate startDate = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PositionCesiumWriter> using$1 = new Using<PositionCesiumWriter>(getPacket().openPositionProperty())) {
                final PositionCesiumWriter position = using$1.resource;
                try (Using<PositionCesiumWriter> using$2 = new Using<PositionCesiumWriter>(position.openInterval())) {
                    final PositionCesiumWriter interval = using$2.resource;
                    ArrayList<JulianDate> dates = new ArrayList<JulianDate>();
                    ArrayList<Cartographic> positions = new ArrayList<Cartographic>();
                    dates.add(startDate);
                    positions.add(new Cartographic(1.0, 2.0, 3.0));
                    dates.add(startDate.addSeconds(60.0));
                    positions.add(new Cartographic(4.0, 5.0, 6.0));
                    dates.add(startDate.addSeconds(120.0));
                    positions.add(new Cartographic(7.0, 8.0, 9.0));
                    interval.writeCartographicRadians(dates, positions, 1, 1);
                }
            }
        }
        AssertHelper.assertEquals("{\"position\":{\"epoch\":\"20120402T1201Z\",\"cartographicRadians\":[0,4,5,6]}}", getStringWriter().toString());
    }

    @Test
    public final void cartesianValueWritesEmptyArrayAndDoesNotWriteEpochWhenGivenAnEmptyCollection() {
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PositionCesiumWriter> using$1 = new Using<PositionCesiumWriter>(getPacket().openPositionProperty())) {
                final PositionCesiumWriter position = using$1.resource;
                try (Using<PositionCesiumWriter> using$2 = new Using<PositionCesiumWriter>(position.openInterval())) {
                    final PositionCesiumWriter interval = using$2.resource;
                    ArrayList<JulianDate> dates = new ArrayList<JulianDate>();
                    ArrayList<Cartesian> positions = new ArrayList<Cartesian>();
                    interval.writeCartesian(dates, positions);
                }
            }
        }
        AssertHelper.assertEquals("{\"position\":{\"cartesian\":[]}}", getStringWriter().toString());
    }

    @Test
    public final void cartographicRadiansValueWritesEmptyArrayAndDoesNotWriteEpochWhenGivenAnEmptyCollection() {
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<PositionCesiumWriter> using$1 = new Using<PositionCesiumWriter>(getPacket().openPositionProperty())) {
                final PositionCesiumWriter position = using$1.resource;
                try (Using<PositionCesiumWriter> using$2 = new Using<PositionCesiumWriter>(position.openInterval())) {
                    final PositionCesiumWriter interval = using$2.resource;
                    ArrayList<JulianDate> dates = new ArrayList<JulianDate>();
                    ArrayList<Cartographic> positions = new ArrayList<Cartographic>();
                    interval.writeCartographicRadians(dates, positions);
                }
            }
        }
        AssertHelper.assertEquals("{\"position\":{\"cartographicRadians\":[]}}", getStringWriter().toString());
    }

    @Test
    public final void testDeletePropertyWithStartAndStop() {
        JulianDate start = new GregorianDate(2012, 4, 2, 12, 0, 0.0).toJulianDate();
        JulianDate stop = start.addDays(1.0);
        final String expectedId = "id";
        final boolean expectedDelete = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            getPacket().writeId(expectedId);
            try (Using<PositionCesiumWriter> using$1 = new Using<PositionCesiumWriter>(getPacket().openPositionProperty())) {
                final PositionCesiumWriter position = using$1.resource;
                try (Using<PositionCesiumWriter> using$2 = new Using<PositionCesiumWriter>(position.openInterval(start, stop))) {
                    final PositionCesiumWriter interval = using$2.resource;
                    interval.writeDelete(expectedDelete);
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, "interval", CesiumFormattingHelper.toIso8601Interval(start, stop, Iso8601Format.COMPACT));
        MapHelper.add(tempCollection$1, PositionCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PacketCesiumWriter.IdPropertyName, expectedId);
        MapHelper.add(tempCollection$0, PacketCesiumWriter.PositionPropertyName, tempCollection$1);
        assertExpectedJson(tempCollection$0);
    }

    @Test
    public final void testDeletePropertyWithNoInterval() {
        final String expectedId = "id";
        final boolean expectedDelete = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            getPacket().writeId(expectedId);
            try (Using<PositionCesiumWriter> using$1 = new Using<PositionCesiumWriter>(getPacket().openPositionProperty())) {
                final PositionCesiumWriter position = using$1.resource;
                try (Using<PositionCesiumWriter> using$2 = new Using<PositionCesiumWriter>(position.openInterval())) {
                    final PositionCesiumWriter interval = using$2.resource;
                    interval.writeDelete(expectedDelete);
                }
            }
        }
        final Map<String, Object> tempCollection$1 = MapHelper.create();
        MapHelper.add(tempCollection$1, PositionCesiumWriter.DeletePropertyName, expectedDelete);
        final Map<String, Object> tempCollection$0 = MapHelper.create();
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