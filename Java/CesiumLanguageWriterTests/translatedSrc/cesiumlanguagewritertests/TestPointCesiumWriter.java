package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ColorHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.awt.Color;
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
public class TestPointCesiumWriter extends TestCesiumPropertyWriter<PointCesiumWriter> {
    @Test
    public final void testShow() {
        final boolean expected = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expected);
                }
            }
        }
        assertPropertyJson(PointCesiumWriter.ShowPropertyName, expected);
    }

    @Test
    public final void testPixelSize() {
        final double expected = 10.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writePixelSizeProperty(expected);
                }
            }
        }
        assertPropertyJson(PointCesiumWriter.PixelSizePropertyName, expected);
    }

    @Test
    public final void testHeightReference() {
        final CesiumHeightReference expected = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expected);
                }
            }
        }
        assertPropertyJson(PointCesiumWriter.HeightReferencePropertyName, expected);
    }

    @Test
    public final void testColor() {
        Color expected = ColorHelper.fromArgb(128, 10, 20, 30);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeColorProperty(expected);
                }
            }
        }
        assertPropertyJson(PointCesiumWriter.ColorPropertyName, expected);
    }

    @Test
    public final void testOutlineColor() {
        Color expected = ColorHelper.fromArgb(255, 1, 2, 3);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeOutlineColorProperty(expected);
                }
            }
        }
        assertPropertyJson(PointCesiumWriter.OutlineColorPropertyName, expected);
    }

    @Test
    public final void testOutlineWidth() {
        final double expected = 2.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeOutlineWidthProperty(expected);
                }
            }
        }
        assertPropertyJson(PointCesiumWriter.OutlineWidthPropertyName, expected);
    }

    @Test
    public final void testScaleByDistance() {
        NearFarScalar expected = new NearFarScalar(1.0, 2.0, 3.0, 4.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeScaleByDistanceProperty(expected);
                }
            }
        }
        assertPropertyJson(PointCesiumWriter.ScaleByDistancePropertyName, expected);
    }

    @Test
    public final void testTranslucencyByDistance() {
        NearFarScalar expected = new NearFarScalar(1.0, 0.5, 2.0, 0.1);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeTranslucencyByDistanceProperty(expected);
                }
            }
        }
        assertPropertyJson(PointCesiumWriter.TranslucencyByDistancePropertyName, expected);
    }

    @Test
    public final void testDistanceDisplayCondition() {
        Bounds expected = new Bounds(1.0, 1324.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expected);
                }
            }
        }
        assertPropertyJson(PointCesiumWriter.DistanceDisplayConditionPropertyName, expected);
    }

    @Test
    public final void testDisableDepthTestDistance() {
        final double expected = 500.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeDisableDepthTestDistanceProperty(expected);
                }
            }
        }
        assertPropertyJson(PointCesiumWriter.DisableDepthTestDistancePropertyName, expected);
    }

    private final void assertPropertyJson(@Nonnull String propertyName, @Nonnull Object value) {
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, propertyName, value);
        assertExpectedJson(PacketCesiumWriter.PointPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<PointCesiumWriter> createPropertyWriter(String propertyName) {
        return new PointCesiumWriter(propertyName);
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