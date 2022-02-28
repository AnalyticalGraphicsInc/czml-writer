package agi.foundation.compatibility;

import static agi.foundation.compatibility.ArgumentNullException.assertNonNull;

import agi.foundation.compatibility.annotations.Internal;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

import javax.annotation.Nonnull;
import javax.imageio.ImageIO;

/**
 * Helper methods related to Bitmaps.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class BitmapHelper {
    private BitmapHelper() {}

    /**
     * Initializes a new instance from the specified data stream.
     *
     * @param stream
     *            The data stream used to load the image.
     * @return the new instance
     */
    @Nonnull
    public static BufferedImage create(@Nonnull InputStream stream) {
        assertNonNull(stream, "stream");

        BufferedImage image;
        try {
            image = ImageIO.read(stream);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        if (image == null) {
            throw new ArgumentException("Unable to create image from stream.");
        }

        return image;
    }
}
