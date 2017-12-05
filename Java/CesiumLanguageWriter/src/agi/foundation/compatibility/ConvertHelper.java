package agi.foundation.compatibility;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;

import javax.annotation.Nonnull;

public final class ConvertHelper {
    private ConvertHelper() {}

    public static int toInt32(boolean value) {
        return value ? 1 : 0;
    }

    public static int toInt32(byte value) {
        return value;
    }

    public static int toInt32(char value) {
        return value;
    }

    public static int toInt32(short value) {
        return value;
    }

    public static int toInt32(int value) {
        return value;
    }

    public static int toInt32(long value) {
        if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE)
            throw new RuntimeException("Overflow");

        return (int) value;
    }

    public static int toInt32(String value, int fromBase) {
        return value == null ? 0 : Integer.parseInt(value, fromBase);
    }

    public static int toInt32(float value) {
        return toInt32((double) value);
    }

    public static int toInt32(double value) {
        double rounded = Math.rint(value);

        if (rounded < Integer.MIN_VALUE || rounded > Integer.MAX_VALUE)
            throw new RuntimeException("Overflow");

        return (int) rounded;
    }

    public static int toInt32(Object value) {
        if (value == null)
            return 0;
        if (value instanceof Boolean)
            return toInt32((boolean) (Boolean) value);
        if (value instanceof Byte)
            return toInt32((byte) (Byte) value);
        if (value instanceof Character)
            return toInt32((char) (Character) value);
        if (value instanceof Short)
            return toInt32((short) (Short) value);
        if (value instanceof Integer)
            return toInt32((int) (Integer) value);
        if (value instanceof Long)
            return toInt32((long) (Long) value);
        if (value instanceof Float)
            return toInt32((float) (Float) value);
        if (value instanceof Double)
            return toInt32((double) (Double) value);
        if (value instanceof Enumeration)
            return toInt32(((Enumeration) value).getValue());
        throw new ClassCastException("Cannot convert to int.");
    }

    public static long toInt64(boolean value) {
        return value ? 1L : 0L;
    }

    public static long toInt64(byte value) {
        return value;
    }

    public static long toInt64(char value) {
        return value;
    }

    public static long toInt64(short value) {
        return value;
    }

    public static long toInt64(int value) {
        return value;
    }

    public static long toInt64(long value) {
        return value;
    }

    public static long toInt64(float value) {
        return toInt64((double) value);
    }

    public static long toInt64(double value) {
        double rounded = Math.rint(value);

        if (rounded < Long.MIN_VALUE || rounded > Long.MAX_VALUE)
            throw new RuntimeException("Overflow");

        return (long) rounded;
    }

    public static long toInt64(Object value) {
        if (value == null)
            return 0L;
        if (value instanceof Boolean)
            return toInt64((boolean) (Boolean) value);
        if (value instanceof Byte)
            return toInt64((byte) (Byte) value);
        if (value instanceof Character)
            return toInt64((char) (Character) value);
        if (value instanceof Short)
            return toInt64((short) (Short) value);
        if (value instanceof Integer)
            return toInt64((int) (Integer) value);
        if (value instanceof Long)
            return toInt64((long) (Long) value);
        if (value instanceof Float)
            return toInt64((float) (Float) value);
        if (value instanceof Double)
            return toInt64((double) (Double) value);
        if (value instanceof Enumeration)
            return toInt64(((Enumeration) value).getValue());
        throw new ClassCastException("Cannot convert to long.");
    }

    public static float toSingle(boolean value) {
        return value ? 1F : 0F;
    }

    public static float toSingle(byte value) {
        return value;
    }

    public static float toSingle(char value) {
        throw new ClassCastException("Cannot convert to float.");
    }

    public static float toSingle(short value) {
        return value;
    }

    public static float toSingle(int value) {
        return value;
    }

    public static float toSingle(long value) {
        return value;
    }

    public static float toSingle(float value) {
        return value;
    }

    public static float toSingle(double value) {
        return (float) value;
    }

    public static float toSingle(Object value) {
        if (value == null)
            return 0F;
        if (value instanceof Boolean)
            return toSingle((boolean) (Boolean) value);
        if (value instanceof Byte)
            return toSingle((byte) (Byte) value);
        if (value instanceof Character)
            return toSingle((char) (Character) value);
        if (value instanceof Short)
            return toSingle((short) (Short) value);
        if (value instanceof Integer)
            return toSingle((int) (Integer) value);
        if (value instanceof Long)
            return toSingle((long) (Long) value);
        if (value instanceof Float)
            return toSingle((float) (Float) value);
        if (value instanceof Double)
            return toSingle((double) (Double) value);
        if (value instanceof Enumeration)
            return toSingle(((Enumeration) value).getValue());
        throw new ClassCastException("Cannot convert to float.");
    }

    public static double toDouble(boolean value) {
        return value ? 1d : 0d;
    }

    public static double toDouble(byte value) {
        return value;
    }

    public static double toDouble(char value) {
        throw new ClassCastException("Cannot convert to double.");
    }

    public static double toDouble(short value) {
        return value;
    }

    public static double toDouble(int value) {
        return value;
    }

    public static double toDouble(long value) {
        return value;
    }

    public static double toDouble(float value) {
        return value;
    }

    public static double toDouble(double value) {
        return value;
    }

    public static double toDouble(Object value) {
        if (value == null)
            return 0d;
        if (value instanceof Boolean)
            return toDouble((boolean) (Boolean) value);
        if (value instanceof Byte)
            return toDouble((byte) (Byte) value);
        if (value instanceof Character)
            return toDouble((char) (Character) value);
        if (value instanceof Short)
            return toDouble((short) (Short) value);
        if (value instanceof Integer)
            return toDouble((int) (Integer) value);
        if (value instanceof Long)
            return toDouble((long) (Long) value);
        if (value instanceof Float)
            return toDouble((float) (Float) value);
        if (value instanceof Double)
            return toDouble((double) (Double) value);
        if (value instanceof Enumeration)
            return toDouble(((Enumeration) value).getValue());
        throw new ClassCastException("Cannot convert to double.");
    }

    /**
     * Converts a subset of an array of 8-bit unsigned integers to its equivalent string
     * representation that is encoded with base-64 digits. Parameters specify the subset
     * as an offset in the input array, the number of elements in the array to convert,
     * and whether to insert line breaks in the return value.
     *
     * @param inArray
     *            An array of 8-bit unsigned integers.
     * @param offset
     *            An offset in inArray.
     * @param length
     *            The number of elements of inArray to convert.
     * @return The string representation in base 64 of length elements of inArray,
     *         starting at position offset.
     */
    @Nonnull
    public static String toBase64String(@Nonnull byte[] inArray, int offset, int length) {
        ArgumentNullException.assertNonNull(inArray, "inArray");
        if (length < 0)
            throw new ArgumentOutOfRangeException("length");
        if (offset < 0)
            throw new ArgumentOutOfRangeException("offset");
        if (offset > inArray.length - length)
            throw new ArgumentOutOfRangeException("offset");

        try {
            return Base64.encodeBytes(inArray, offset, length, Base64.NO_OPTIONS);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    // @formatter:off
    /**
     * <p>Encodes and decodes to and from Base64 notation.</p>
     * <p>Homepage: <a href="http://iharder.net/base64">http://iharder.net/base64</a>.</p>
     *
     * <p>Example:</p>
     *
     * <code>String encoded = Base64.encode( myByteArray );</code>
     * <br />
     * <code>byte[] myByteArray = Base64.decode( encoded );</code>
     *
     * <p>The <tt>options</tt> parameter, which appears in a few places, is used to pass
     * several pieces of information to the encoder. In the "higher level" methods such as
     * encodeBytes( bytes, options ) the options parameter can be used to indicate such
     * things as first gzipping the bytes before encoding them, not inserting linefeeds,
     * and encoding using the URL-safe and Ordered dialects.</p>
     *
     * <p>Note, according to <a href="http://www.faqs.org/rfcs/rfc3548.html">RFC3548</a>,
     * Section 2.1, implementations should not add line feeds unless explicitly told
     * to do so. I've got Base64 set to this behavior now, although earlier versions
     * broke lines by default.</p>
     *
     * <p>The constants defined in Base64 can be OR-ed together to combine options, so you
     * might make a call like this:</p>
     *
     * <code>String encoded = Base64.encodeBytes( mybytes, Base64.GZIP | Base64.DO_BREAK_LINES );</code>
     * <p>to compress the data before encoding it and then making the output have newline characters.</p>
     * <p>Also...</p>
     * <code>String encoded = Base64.encodeBytes( crazyString.getBytes() );</code>
     *
     *
     *
     * <p>
     * Change Log:
     * </p>
     * <ul>
     *  <li>v2.3.7 - Fixed subtle bug when base 64 input stream contained the
     *   value 01111111, which is an invalid base 64 character but should not
     *   throw an ArrayIndexOutOfBoundsException either. Led to discovery of
     *   mishandling (or potential for better handling) of other bad input
     *   characters. You should now get an IOException if you try decoding
     *   something that has bad characters in it.</li>
     *  <li>v2.3.6 - Fixed bug when breaking lines and the final byte of the encoded
     *   string ended in the last column; the buffer was not properly shrunk and
     *   contained an extra (null) byte that made it into the string.</li>
     *  <li>v2.3.5 - Fixed bug in {@link #encodeFromFile} where estimated buffer size
     *   was wrong for files of size 31, 34, and 37 bytes.</li>
     *  <li>v2.3.4 - Fixed bug when working with gzipped streams whereby flushing
     *   the Base64.OutputStream closed the Base64 encoding (by padding with equals
     *   signs) too soon. Also added an option to suppress the automatic decoding
     *   of gzipped streams. Also added experimental support for specifying a
     *   class loader when using the
     *   {@link #decodeToObject(java.lang.String, int, java.lang.ClassLoader)}
     *   method.</li>
     *  <li>v2.3.3 - Changed default char encoding to US-ASCII which reduces the internal Java
     *   footprint with its CharEncoders and so forth. Fixed some javadocs that were
     *   inconsistent. Removed imports and specified things like java.io.IOException
     *   explicitly inline.</li>
     *  <li>v2.3.2 - Reduced memory footprint! Finally refined the "guessing" of how big the
     *   final encoded data will be so that the code doesn't have to create two output
     *   arrays: an oversized initial one and then a final, exact-sized one. Big win
     *   when using the {@link #encodeBytesToBytes(byte[])} family of methods (and not
     *   using the gzip options which uses a different mechanism with streams and stuff).</li>
     *  <li>v2.3.1 - Added {@link #encodeBytesToBytes(byte[], int, int, int)} and some
     *   similar helper methods to be more efficient with memory by not returning a
     *   String but just a byte array.</li>
     *  <li>v2.3 - <strong>This is not a drop-in replacement!</strong> This is two years of comments
     *   and bug fixes queued up and finally executed. Thanks to everyone who sent
     *   me stuff, and I'm sorry I wasn't able to distribute your fixes to everyone else.
     *   Much bad coding was cleaned up including throwing exceptions where necessary
     *   instead of returning null values or something similar. Here are some changes
     *   that may affect you:
     *   <ul>
     *    <li><em>Does not break lines, by default.</em> This is to keep in compliance with
     *      <a href="http://www.faqs.org/rfcs/rfc3548.html">RFC3548</a>.</li>
     *    <li><em>Throws exceptions instead of returning null values.</em> Because some operations
     *      (especially those that may permit the GZIP option) use IO streams, there
     *      is a possiblity of an java.io.IOException being thrown. After some discussion and
     *      thought, I've changed the behavior of the methods to throw java.io.IOExceptions
     *      rather than return null if ever there's an error. I think this is more
     *      appropriate, though it will require some changes to your code. Sorry,
     *      it should have been done this way to begin with.</li>
     *    <li><em>Removed all references to System.out, System.err, and the like.</em>
     *      Shame on me. All I can say is sorry they were ever there.</li>
     *    <li><em>Throws NullPointerExceptions and IllegalArgumentExceptions</em> as needed
     *      such as when passed arrays are null or offsets are invalid.</li>
     *    <li>Cleaned up as much javadoc as I could to avoid any javadoc warnings.
     *      This was especially annoying before for people who were thorough in their
     *      own projects and then had gobs of javadoc warnings on this file.</li>
     *   </ul>
     *  <li>v2.2.1 - Fixed bug using URL_SAFE and ORDERED encodings. Fixed bug
     *   when using very small files (~&lt; 40 bytes).</li>
     *  <li>v2.2 - Added some helper methods for encoding/decoding directly from
     *   one file to the next. Also added a main() method to support command line
     *   encoding/decoding from one file to the next. Also added these Base64 dialects:
     *   <ol>
     *   <li>The default is RFC3548 format.</li>
     *   <li>Calling Base64.setFormat(Base64.BASE64_FORMAT.URLSAFE_FORMAT) generates
     *   URL and file name friendly format as described in Section 4 of RFC3548.
     *   http://www.faqs.org/rfcs/rfc3548.html</li>
     *   <li>Calling Base64.setFormat(Base64.BASE64_FORMAT.ORDERED_FORMAT) generates
     *   URL and file name friendly format that preserves lexical ordering as described
     *   in http://www.faqs.org/qa/rfcc-1940.html</li>
     *   </ol>
     *   Special thanks to Jim Kellerman at <a href="http://www.powerset.com/">http://www.powerset.com/</a>
     *   for contributing the new Base64 dialects.
     *  </li>
     *
     *  <li>v2.1 - Cleaned up javadoc comments and unused variables and methods. Added
     *   some convenience methods for reading and writing to and from files.</li>
     *  <li>v2.0.2 - Now specifies UTF-8 encoding in places where the code fails on systems
     *   with other encodings (like EBCDIC).</li>
     *  <li>v2.0.1 - Fixed an error when decoding a single byte, that is, when the
     *   encoded data was a single byte.</li>
     *  <li>v2.0 - I got rid of methods that used booleans to set options.
     *   Now everything is more consolidated and cleaner. The code now detects
     *   when data that's being decoded is gzip-compressed and will decompress it
     *   automatically. Generally things are cleaner. You'll probably have to
     *   change some method calls that you were making to support the new
     *   options format (<tt>int</tt>s that you "OR" together).</li>
     *  <li>v1.5.1 - Fixed bug when decompressing and decoding to a
     *   byte[] using <tt>decode( String s, boolean gzipCompressed )</tt>.
     *   Added the ability to "suspend" encoding in the Output Stream so
     *   you can turn on and off the encoding if you need to embed base64
     *   data in an otherwise "normal" stream (like an XML file).</li>
     *  <li>v1.5 - Output stream pases on flush() command but doesn't do anything itself.
     *      This helps when using GZIP streams.
     *      Added the ability to GZip-compress objects before encoding them.</li>
     *  <li>v1.4 - Added helper methods to read/write files.</li>
     *  <li>v1.3.6 - Fixed OutputStream.flush() so that 'position' is reset.</li>
     *  <li>v1.3.5 - Added flag to turn on and off line breaks. Fixed bug in input stream
     *      where last buffer being read, if not completely full, was not returned.</li>
     *  <li>v1.3.4 - Fixed when "improperly padded stream" error was thrown at the wrong time.</li>
     *  <li>v1.3.3 - Fixed I/O streams which were totally messed up.</li>
     * </ul>
     *
     * <p>
     * I am placing this code in the Public Domain. Do with it as you will.
     * This software comes with no guarantees or warranties but with
     * plenty of well-wishing instead!
     * Please visit <a href="http://iharder.net/base64">http://iharder.net/base64</a>
     * periodically to check for updates or to contribute improvements.
     * </p>
     *
     * @author Robert Harder
     * @author rob@iharder.net
     * @version 2.3.7
     */
    private static class Base64
    {

    /* ********  P U B L I C   F I E L D S  ******** */


        /** No options specified. Value is zero. */
        public final static int NO_OPTIONS = 0;


    /* ********  P R I V A T E   F I E L D S  ******** */

        /** The equals sign (=) as a byte. */
        private final static byte EQUALS_SIGN = (byte)'=';


    /* ********  S T A N D A R D   B A S E 6 4   A L P H A B E T  ******** */

        /** The 64 valid Base64 values. */
        /* Host platform me be something funny like EBCDIC, so we hardcode these values. */
        private final static byte[] _STANDARD_ALPHABET = {
            (byte)'A', (byte)'B', (byte)'C', (byte)'D', (byte)'E', (byte)'F', (byte)'G',
            (byte)'H', (byte)'I', (byte)'J', (byte)'K', (byte)'L', (byte)'M', (byte)'N',
            (byte)'O', (byte)'P', (byte)'Q', (byte)'R', (byte)'S', (byte)'T', (byte)'U',
            (byte)'V', (byte)'W', (byte)'X', (byte)'Y', (byte)'Z',
            (byte)'a', (byte)'b', (byte)'c', (byte)'d', (byte)'e', (byte)'f', (byte)'g',
            (byte)'h', (byte)'i', (byte)'j', (byte)'k', (byte)'l', (byte)'m', (byte)'n',
            (byte)'o', (byte)'p', (byte)'q', (byte)'r', (byte)'s', (byte)'t', (byte)'u',
            (byte)'v', (byte)'w', (byte)'x', (byte)'y', (byte)'z',
            (byte)'0', (byte)'1', (byte)'2', (byte)'3', (byte)'4', (byte)'5',
            (byte)'6', (byte)'7', (byte)'8', (byte)'9', (byte)'+', (byte)'/'
        };


    /* ********  D E T E R M I N E   W H I C H   A L H A B E T  ******** */


        /**
         * Returns one of the _SOMETHING_ALPHABET byte arrays depending on
         * the options specified.
         * It's possible, though silly, to specify ORDERED <b>and</b> URLSAFE
         * in which case one of them will be picked, though there is
         * no guarantee as to which one will be picked.
         */
        private final static byte[] getAlphabet( int options ) {
                return _STANDARD_ALPHABET;
        }   // end getAlphabet


        /** Defeats instantiation. */
        private Base64(){}


    /* ********  E N C O D I N G   M E T H O D S  ******** */


        /**
         * <p>Encodes up to three bytes of the array <var>source</var>
         * and writes the resulting four Base64 bytes to <var>destination</var>.
         * The source and destination arrays can be manipulated
         * anywhere along their length by specifying
         * <var>srcOffset</var> and <var>destOffset</var>.
         * This method does not check to make sure your arrays
         * are large enough to accomodate <var>srcOffset</var> + 3 for
         * the <var>source</var> array or <var>destOffset</var> + 4 for
         * the <var>destination</var> array.
         * The actual number of significant bytes in your array is
         * given by <var>numSigBytes</var>.</p>
         * <p>This is the lowest level of the encoding methods with
         * all possible parameters.</p>
         *
         * @param source the array to convert
         * @param srcOffset the index where conversion begins
         * @param numSigBytes the number of significant bytes in your array
         * @param destination the array to hold the conversion
         * @param destOffset the index where output will be put
         * @return the <var>destination</var> array
         * @since 1.3
         */
        private static byte[] encode3to4(
        byte[] source, int srcOffset, int numSigBytes,
        byte[] destination, int destOffset, int options ) {

        byte[] ALPHABET = getAlphabet( options );

            //           1         2         3
            // 01234567890123456789012345678901 Bit position
            // --------000000001111111122222222 Array position from threeBytes
            // --------|    ||    ||    ||    | Six bit groups to index ALPHABET
            //          >>18  >>12  >> 6  >> 0  Right shift necessary
            //                0x3f  0x3f  0x3f  Additional AND

            // Create buffer with zero-padding if there are only one or two
            // significant bytes passed in the array.
            // We have to shift left 24 in order to flush out the 1's that appear
            // when Java treats a value as negative that is cast from a byte to an int.
            int inBuff =   ( numSigBytes > 0 ? ((source[ srcOffset     ] << 24) >>>  8) : 0 )
                         | ( numSigBytes > 1 ? ((source[ srcOffset + 1 ] << 24) >>> 16) : 0 )
                         | ( numSigBytes > 2 ? ((source[ srcOffset + 2 ] << 24) >>> 24) : 0 );

            switch( numSigBytes )
            {
                case 3:
                    destination[ destOffset     ] = ALPHABET[ (inBuff >>> 18)        ];
                    destination[ destOffset + 1 ] = ALPHABET[ (inBuff >>> 12) & 0x3f ];
                    destination[ destOffset + 2 ] = ALPHABET[ (inBuff >>>  6) & 0x3f ];
                    destination[ destOffset + 3 ] = ALPHABET[ (inBuff       ) & 0x3f ];
                    return destination;

                case 2:
                    destination[ destOffset     ] = ALPHABET[ (inBuff >>> 18)        ];
                    destination[ destOffset + 1 ] = ALPHABET[ (inBuff >>> 12) & 0x3f ];
                    destination[ destOffset + 2 ] = ALPHABET[ (inBuff >>>  6) & 0x3f ];
                    destination[ destOffset + 3 ] = EQUALS_SIGN;
                    return destination;

                case 1:
                    destination[ destOffset     ] = ALPHABET[ (inBuff >>> 18)        ];
                    destination[ destOffset + 1 ] = ALPHABET[ (inBuff >>> 12) & 0x3f ];
                    destination[ destOffset + 2 ] = EQUALS_SIGN;
                    destination[ destOffset + 3 ] = EQUALS_SIGN;
                    return destination;

                default:
                    return destination;
            }   // end switch
        }   // end encode3to4


        /**
         * Encodes a byte array into Base64 notation.
         * <p>
         * Example options:<pre>
         *   GZIP: gzip-compresses object before encoding it.
         *   DO_BREAK_LINES: break lines at 76 characters
         *     <i>Note: Technically, this makes your encoding non-compliant.</i>
         * </pre>
         * <p>
         * Example: <code>encodeBytes( myData, Base64.GZIP )</code> or
         * <p>
         * Example: <code>encodeBytes( myData, Base64.GZIP | Base64.DO_BREAK_LINES )</code>
         *
         *
         * <p>As of v 2.3, if there is an error with the GZIP stream,
         * the method will throw an java.io.IOException. <b>This is new to v2.3!</b>
         * In earlier versions, it just returned a null value, but
         * in retrospect that's a pretty poor way to handle it.</p>
         *
         *
         * @param source The data to convert
         * @param off Offset in array where conversion should begin
         * @param len Length of data to convert
         * @param options Specified options
         * @return The Base64-encoded data as a String
         * @see Base64#GZIP
         * @see Base64#DO_BREAK_LINES
         * @throws java.io.IOException if there is an error
         * @throws NullPointerException if source array is null
         * @throws IllegalArgumentException if source array, offset, or length are invalid
         * @since 2.0
         */
        public static String encodeBytes( byte[] source, int off, int len, int options ) throws java.io.IOException {
            byte[] encoded = encodeBytesToBytes( source, off, len, options );

            // Return value according to relevant encoding.
                return new String( encoded, StandardCharsets.US_ASCII );
        }   // end encodeBytes


        /**
         * Similar to {@link #encodeBytes(byte[], int, int, int)} but returns
         * a byte array instead of instantiating a String. This is more efficient
         * if you're working with I/O streams and have large data sets to encode.
         *
         *
         * @param source The data to convert
         * @param off Offset in array where conversion should begin
         * @param len Length of data to convert
         * @param options Specified options
         * @return The Base64-encoded data as a String
         * @see Base64#GZIP
         * @see Base64#DO_BREAK_LINES
         * @throws java.io.IOException if there is an error
         * @throws NullPointerException if source array is null
         * @throws IllegalArgumentException if source array, offset, or length are invalid
         * @since 2.3.1
         */
        public static byte[] encodeBytesToBytes( byte[] source, int off, int len, int options ) throws java.io.IOException {

            if( source == null ){
                throw new NullPointerException( "Cannot serialize a null array." );
            }   // end if: null

            if( off < 0 ){
                throw new IllegalArgumentException( "Cannot have negative offset: " + off );
            }   // end if: off < 0

            if( len < 0 ){
                throw new IllegalArgumentException( "Cannot have length offset: " + len );
            }   // end if: len < 0

            if( off + len > source.length  ){
                throw new IllegalArgumentException(
                String.format( "Cannot have offset of %d and length of %d with array of length %d", off,len,source.length));
            }   // end if: off < 0



                // Try to determine more precisely how big the array needs to be.
                // If we get it right, we don't have to do an array copy, and
                // we save a bunch of memory.
                int encLen = ( len / 3 ) * 4 + ( len % 3 > 0 ? 4 : 0 ); // Bytes needed for actual encoding
                byte[] outBuff = new byte[ encLen ];


                int d = 0;
                int e = 0;
                int len2 = len - 2;
                for( ; d < len2; d+=3, e+=4 ) {
                    encode3to4( source, d+off, 3, outBuff, e, options );
                }   // en dfor: each piece of array

                if( d < len ) {
                    encode3to4( source, d+off, len - d, outBuff, e, options );
                    e += 4;
                }   // end if: some padding needed


                // Only resize array if we didn't guess it right.
                if( e <= outBuff.length - 1 ){
                    // If breaking lines and the last byte falls right at
                    // the line length (76 bytes per line), there will be
                    // one extra byte, and the array will need to be resized.
                    // Not too bad of an estimate on array size, I'd say.
                    byte[] finalOut = new byte[e];
                    System.arraycopy(outBuff,0, finalOut,0,e);
                    return finalOut;
                } else {
                    return outBuff;
                }

        }   // end encodeBytesToBytes

    }   // end class Base64
    // @formatter:on
}
