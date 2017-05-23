package cesiumlanguagewritertests.data;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Assembly;
import cesiumlanguagewritertests.*;
import java.io.InputStream;

public final class EmbeddedData {
    private EmbeddedData() {}

    public static InputStream read(String file) {
        return Assembly.getExecutingAssembly().getManifestResourceStream(EmbeddedData.class, file);
    }
}