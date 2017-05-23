package agi.foundation.compatibility;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * Helper methods related to Bitmaps.
 */
public final class BitmapHelper {
    private BitmapHelper() {}

    /**
     * Initializes a new instance from the specified data stream.
     *
     * @param stream
     *            The data stream used to load the image.
     * @return the new instance
     */
    public static BufferedImage create(InputStream stream) {
        try {
            return ImageIO.read(stream);
        } catch (IOException e) {
            throw new RuntimeIOException(e);
        }
    }
}
