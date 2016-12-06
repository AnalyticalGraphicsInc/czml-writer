package agi.foundation.compatibility;

import java.nio.charset.Charset;

/**
 * Represents a character encoding.
 */
public final class Encoding {
    public static final Charset UTF8 = Charset.forName("UTF-8");
    public static final Charset UNICODE = Charset.forName("UTF-16LE");
    public static final Charset ASCII = Charset.forName("US-ASCII");

    private static final Encoding utf8Encoding = new Encoding(UTF8);
    private static final Encoding unicodeEncoding = new Encoding(UNICODE);
    private static final Encoding asciiEncoding = new Encoding(ASCII);

    private final Charset charset;

    public Encoding(Charset charset) {
        this.charset = charset;
    }

    /**
     * Gets an encoding for the ASCII (7-bit) character set.
     */
    public static Encoding getASCII() {
        return asciiEncoding;
    }

    /**
     * Gets an encoding for the UTF-16 format using the little endian byte order.
     */
    public static Encoding getUnicode() {
        return unicodeEncoding;
    }

    /**
     * Gets an encoding for the UTF-8 format.
     */
    public static Encoding getUTF8() {
        return utf8Encoding;
    }

    public Charset getCharset() {
        return charset;
    }
}