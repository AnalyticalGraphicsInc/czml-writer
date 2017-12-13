package agi.foundation.compatibility;

/**
 * Specifies the file format of the image.
 */
public final class ImageFormat {
    private static final ImageFormat s_bmp = new ImageFormat("bmp");
    private static final ImageFormat s_gif = new ImageFormat("gif");
    private static final ImageFormat s_jpeg = new ImageFormat("jpeg");
    private static final ImageFormat s_png = new ImageFormat("png");
    private final String formatName;

    private ImageFormat(String formatName) {
        this.formatName = formatName;
    }

    public String getFormatName() {
        return formatName;
    }

    /**
     * Gets the bitmap (BMP) image format.
     *
     * @return An ImageFormat object that indicates the bitmap image format.
     */
    public static ImageFormat getBmp() {
        return s_bmp;
    }

    /**
     * Gets the Graphics Interchange Format (GIF) image format.
     *
     * @return An ImageFormat object that indicates the GIF image format.
     */
    public static ImageFormat getGif() {
        return s_gif;
    }

    /**
     * Gets the Joint Photographic Experts Group (JPEG) image format.
     *
     * @return An ImageFormat object that indicates the JPEG image format.
     */
    public static ImageFormat getJpeg() {
        return s_jpeg;
    }

    /**
     * Gets the W3C Portable Network Graphics (PNG) image format.
     *
     * @return An ImageFormat object that indicates the PNG image format.
     */
    public static ImageFormat getPng() {
        return s_png;
    }
}
