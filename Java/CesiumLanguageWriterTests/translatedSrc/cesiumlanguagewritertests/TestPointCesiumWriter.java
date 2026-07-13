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
    public final void testShowProperty() {
        final boolean expectedShow = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expectedShow);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PointCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.PointPropertyName, tempCollection$0);
    }

    @Test
    public final void testPixelSizeProperty() {
        final double expectedPixelSize = 10.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writePixelSizeProperty(expectedPixelSize);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PointCesiumWriter.PixelSizePropertyName, expectedPixelSize);
        assertExpectedJson(PacketCesiumWriter.PointPropertyName, tempCollection$0);
    }

    @Test
    public final void testHeightReferenceProperty() {
        final CesiumHeightReference expectedHeightReference = CesiumHeightReference.CLAMP_TO_GROUND;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeHeightReferenceProperty(expectedHeightReference);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PointCesiumWriter.HeightReferencePropertyName, expectedHeightReference);
        assertExpectedJson(PacketCesiumWriter.PointPropertyName, tempCollection$0);
    }

    @Test
    public final void testColorProperty() {
        Color expectedColor = ColorHelper.fromArgb(128, 10, 20, 30);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeColorProperty(expectedColor);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PointCesiumWriter.ColorPropertyName, expectedColor);
        assertExpectedJson(PacketCesiumWriter.PointPropertyName, tempCollection$0);
    }

    @Test
    public final void testOutlineColorProperty() {
        Color expectedOutlineColor = ColorHelper.fromArgb(255, 1, 2, 3);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeOutlineColorProperty(expectedOutlineColor);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PointCesiumWriter.OutlineColorPropertyName, expectedOutlineColor);
        assertExpectedJson(PacketCesiumWriter.PointPropertyName, tempCollection$0);
    }

    @Test
    public final void testOutlineWidthProperty() {
        final double expectedOutlineWidth = 2.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeOutlineWidthProperty(expectedOutlineWidth);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PointCesiumWriter.OutlineWidthPropertyName, expectedOutlineWidth);
        assertExpectedJson(PacketCesiumWriter.PointPropertyName, tempCollection$0);
    }

    @Test
    public final void testScaleByDistanceProperty() {
        NearFarScalar expectedScale = new NearFarScalar(1.0, 2.0, 3.0, 4.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeScaleByDistanceProperty(expectedScale);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PointCesiumWriter.ScaleByDistancePropertyName, expectedScale);
        assertExpectedJson(PacketCesiumWriter.PointPropertyName, tempCollection$0);
    }

    @Test
    public final void testTranslucencyByDistanceProperty() {
        NearFarScalar expectedTranslucency = new NearFarScalar(1.0, 0.5, 2.0, 0.1);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeTranslucencyByDistanceProperty(expectedTranslucency);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PointCesiumWriter.TranslucencyByDistancePropertyName, expectedTranslucency);
        assertExpectedJson(PacketCesiumWriter.PointPropertyName, tempCollection$0);
    }

    @Test
    public final void testDistanceDisplayConditionProperty() {
        Bounds expectedBounds = new Bounds(1.0, 1324.0);
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeDistanceDisplayConditionProperty(expectedBounds);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PointCesiumWriter.DistanceDisplayConditionPropertyName, expectedBounds);
        assertExpectedJson(PacketCesiumWriter.PointPropertyName, tempCollection$0);
    }

    @Test
    public final void testDisableDepthTestDistanceProperty() {
        final double expectedDisableDepthTestDistance = 500.0;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(openPacket())) {
            final PacketCesiumWriter packet = using$0.resource;
            try (Using<PointCesiumWriter> using$1 = new Using<PointCesiumWriter>(packet.openPointProperty())) {
                final PointCesiumWriter point = using$1.resource;
                try (Using<PointCesiumWriter> using$2 = new Using<PointCesiumWriter>(point.openInterval())) {
                    final PointCesiumWriter interval = using$2.resource;
                    interval.writeDisableDepthTestDistanceProperty(expectedDisableDepthTestDistance);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = MapHelper.create();
        MapHelper.add(tempCollection$0, PointCesiumWriter.DisableDepthTestDistancePropertyName, expectedDisableDepthTestDistance);
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