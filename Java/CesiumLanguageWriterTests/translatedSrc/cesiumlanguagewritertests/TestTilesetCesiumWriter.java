package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.compatibility.Using;
import cesiumlanguagewriter.*;
import cesiumlanguagewriter.advanced.*;
import java.util.LinkedHashMap;
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
public class TestTilesetCesiumWriter extends TestCesiumPropertyWriter<TilesetCesiumWriter> {
    @Test
    public final void testShowProperty() {
        final boolean expectedShow = true;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<TilesetCesiumWriter> using$1 = new Using<TilesetCesiumWriter>(getPacket().openTilesetProperty())) {
                final TilesetCesiumWriter tileset = using$1.resource;
                try (Using<TilesetCesiumWriter> using$2 = new Using<TilesetCesiumWriter>(tileset.openInterval())) {
                    final TilesetCesiumWriter interval = using$2.resource;
                    interval.writeShowProperty(expectedShow);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, TilesetCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.TilesetPropertyName, tempCollection$0);
    }

    @Test
    public final void testUriProperty() {
        final String expectedUri = "test.tileset";
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<TilesetCesiumWriter> using$1 = new Using<TilesetCesiumWriter>(getPacket().openTilesetProperty())) {
                final TilesetCesiumWriter tileset = using$1.resource;
                try (Using<TilesetCesiumWriter> using$2 = new Using<TilesetCesiumWriter>(tileset.openInterval())) {
                    final TilesetCesiumWriter interval = using$2.resource;
                    interval.writeUriProperty(expectedUri, CesiumResourceBehavior.LINK_TO);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, TilesetCesiumWriter.UriPropertyName, expectedUri);
        assertExpectedJson(PacketCesiumWriter.TilesetPropertyName, tempCollection$0);
    }

    @Test
    public final void testMaximumScreenSpaceErrorProperty() {
        final double expectedMaximumScreenSpaceError = 0.75;
        try (Using<PacketCesiumWriter> using$0 = new Using<PacketCesiumWriter>(getPacket())) {
            try (Using<TilesetCesiumWriter> using$1 = new Using<TilesetCesiumWriter>(getPacket().openTilesetProperty())) {
                final TilesetCesiumWriter tileset = using$1.resource;
                try (Using<TilesetCesiumWriter> using$2 = new Using<TilesetCesiumWriter>(tileset.openInterval())) {
                    final TilesetCesiumWriter interval = using$2.resource;
                    interval.writeMaximumScreenSpaceErrorProperty(expectedMaximumScreenSpaceError);
                }
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, TilesetCesiumWriter.MaximumScreenSpaceErrorPropertyName, expectedMaximumScreenSpaceError);
        assertExpectedJson(PacketCesiumWriter.TilesetPropertyName, tempCollection$0);
    }

    @Override
    protected CesiumPropertyWriter<TilesetCesiumWriter> createPropertyWriter(String propertyName) {
        return new TilesetCesiumWriter(propertyName);
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