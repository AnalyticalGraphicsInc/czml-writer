package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.MapHelper;
import agi.foundation.compatibility.TestContextRule;
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

@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTilesetCesiumWriter extends TestCesiumPropertyWriter<TilesetCesiumWriter> {
    @Test
    public final void testShowProperty() {
        final boolean expectedShow = true;
        {
            final PacketCesiumWriter usingExpression_0 = (getPacket());
            try {
                {
                    TilesetCesiumWriter tileset = getPacket().openTilesetProperty();
                    try {
                        {
                            TilesetCesiumWriter interval = tileset.openInterval();
                            try {
                                interval.writeShowProperty(expectedShow);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(tileset);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_0);
            }
        }
        final Map<String, Object> tempCollection$0 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$0, TilesetCesiumWriter.ShowPropertyName, expectedShow);
        assertExpectedJson(PacketCesiumWriter.TilesetPropertyName, tempCollection$0);
    }

    @Test
    public final void testUriProperty() {
        final String expectedUri = "test.tileset";
        {
            final PacketCesiumWriter usingExpression_1 = (getPacket());
            try {
                {
                    TilesetCesiumWriter tileset = getPacket().openTilesetProperty();
                    try {
                        {
                            TilesetCesiumWriter interval = tileset.openInterval();
                            try {
                                interval.writeUriProperty(expectedUri, CesiumResourceBehavior.LINK_TO);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(tileset);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_1);
            }
        }
        final Map<String, Object> tempCollection$1 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$1, TilesetCesiumWriter.UriPropertyName, expectedUri);
        assertExpectedJson(PacketCesiumWriter.TilesetPropertyName, tempCollection$1);
    }

    @Test
    public final void testMaximumScreenSpaceErrorProperty() {
        final double expectedMaximumScreenSpaceError = 0.75;
        {
            final PacketCesiumWriter usingExpression_2 = (getPacket());
            try {
                {
                    TilesetCesiumWriter tileset = getPacket().openTilesetProperty();
                    try {
                        {
                            TilesetCesiumWriter interval = tileset.openInterval();
                            try {
                                interval.writeMaximumScreenSpaceErrorProperty(expectedMaximumScreenSpaceError);
                            } finally {
                                DisposeHelper.dispose(interval);
                            }
                        }
                    } finally {
                        DisposeHelper.dispose(tileset);
                    }
                }
            } finally {
                DisposeHelper.dispose(usingExpression_2);
            }
        }
        final Map<String, Object> tempCollection$2 = new LinkedHashMap<String, Object>();
        MapHelper.add(tempCollection$2, TilesetCesiumWriter.MaximumScreenSpaceErrorPropertyName, expectedMaximumScreenSpaceError);
        assertExpectedJson(PacketCesiumWriter.TilesetPropertyName, tempCollection$2);
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