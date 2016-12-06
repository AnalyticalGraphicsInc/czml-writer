package agi.foundation.compatibility;

import java.awt.image.RenderedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class ImageHelper {
    private ImageHelper() {}

    /**
     * Saves this image to the specified stream in the specified format.
     * 
     * @param image
     *            the image.
     * @param stream
     *            The stream where the image will be saved.
     * @param format
     *            An ImageFormat that specifies the format of the saved image.
     */
    public static void save(RenderedImage image, MemoryStream stream, ImageFormat format) {
        try {
            ImageIO.write(image, format.getFormatName(), stream.asOutputStream());
        } catch (IOException e) {
            throw new RuntimeIOException(e);
        }
    }
}
