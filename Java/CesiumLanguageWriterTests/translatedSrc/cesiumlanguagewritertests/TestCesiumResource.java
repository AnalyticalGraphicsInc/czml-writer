package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArrayHelper;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.BitmapHelper;
import agi.foundation.compatibility.EnumHelper;
import agi.foundation.compatibility.MemoryStream;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import cesiumlanguagewritertests.data.*;
import java.awt.image.BufferedImage;
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
public class TestCesiumResource {
    @Test
    public final void testFromImage() {
        BufferedImage image = BitmapHelper.create(EmbeddedData.read("satellite.png"));
        CesiumResource resource = CesiumResource.fromImage(image, CesiumImageFormat.PNG);
        Assert.assertNotNull(resource);
        AssertHelper.assertStringStartsWith("data:image/png;base64,", resource.getUri());
    }

    public final void testFromImageFormats(@Nonnull CesiumImageFormat format) {
        BufferedImage image = BitmapHelper.create(EmbeddedData.read("satellite.png"));
        CesiumResource resource = CesiumResource.fromImage(image, format);
        Assert.assertNotNull(resource);
        AssertHelper.assertStringStartsWith("data:", resource.getUri());
        AssertHelper.assertStringContains(";base64,", resource.getUri());
    }

    @Test
    public final void testFromImageFormats$TestCase1() {
        for (final CesiumImageFormat format : getImageFormatValues()) {
            testFromImageFormats(format);
        }
    }

    @Nonnull
    public static Iterable<CesiumImageFormat> getImageFormatValues() {
        return ArrayHelper.arrayAsList((CesiumImageFormat[]) EnumHelper.getValues(CesiumImageFormat.class));
    }

    @Test
    public final void testFromStream() {
        // arbitrary bytes
        byte[] contents = {
                0,
                1,
                2,
                3,
                4
        };
        MemoryStream stream = new MemoryStream(contents);
        CesiumResource resource = CesiumResource.fromStream(stream, CesiumImageFormat.PNG);
        Assert.assertNotNull(resource);
        final String expected = "data:image/png;base64,AAECAwQ=";
        Assert.assertEquals(expected, resource.getUri());
    }

    @Test
    public final void testFromStreamMimeType() {
        // arbitrary bytes
        byte[] contents = {
                0,
                1,
                2,
                3,
                4
        };
        MemoryStream stream = new MemoryStream(contents);
        CesiumResource resource = CesiumResource.fromStream(stream, "application/octet-stream");
        Assert.assertNotNull(resource);
        final String expected = "data:application/octet-stream;base64,AAECAwQ=";
        Assert.assertEquals(expected, resource.getUri());
    }

    @Nonnull
    private final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    public TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}