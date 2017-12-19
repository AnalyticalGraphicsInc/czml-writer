package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import javax.annotation.Nonnull;

/**
 * Specifies the file format of the image.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class ImageFormat {
    @Nonnull
    private static final ImageFormat s_bmp = new ImageFormat("bmp");
    @Nonnull
    private static final ImageFormat s_gif = new ImageFormat("gif");
    @Nonnull
    private static final ImageFormat s_jpeg = new ImageFormat("jpeg");
    @Nonnull
    private static final ImageFormat s_png = new ImageFormat("png");
    @Nonnull
    private final String formatName;

    private ImageFormat(@Nonnull String formatName) {
        this.formatName = formatName;
    }

    @Nonnull
    public String getFormatName() {
        return formatName;
    }

    /**
     * Gets the bitmap (BMP) image format.
     *
     * @return An ImageFormat object that indicates the bitmap image format.
     */
    @Nonnull
    public static ImageFormat getBmp() {
        return s_bmp;
    }

    /**
     * Gets the Graphics Interchange Format (GIF) image format.
     *
     * @return An ImageFormat object that indicates the GIF image format.
     */
    @Nonnull
    public static ImageFormat getGif() {
        return s_gif;
    }

    /**
     * Gets the Joint Photographic Experts Group (JPEG) image format.
     *
     * @return An ImageFormat object that indicates the JPEG image format.
     */
    @Nonnull
    public static ImageFormat getJpeg() {
        return s_jpeg;
    }

    /**
     * Gets the W3C Portable Network Graphics (PNG) image format.
     *
     * @return An ImageFormat object that indicates the PNG image format.
     */
    @Nonnull
    public static ImageFormat getPng() {
        return s_png;
    }
}
