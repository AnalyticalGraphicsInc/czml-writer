package cesiumlanguagewritertests.data;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Assembly;
import cesiumlanguagewritertests.*;
import java.io.InputStream;
import javax.annotation.Nonnull;
import org.junit.Assert;

@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
public final class EmbeddedData {
    private EmbeddedData() {}

    @Nonnull
    public static InputStream read(@Nonnull String file) {
        InputStream stream = Assembly.getExecutingAssembly().getManifestResourceStream(EmbeddedData.class, file);
        Assert.assertNotNull(stream);
        return stream;
    }
}