package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.annotation.Nonnull;

/**
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
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

        return new String(Base64.getEncoder().encode(ByteBuffer.wrap(inArray, offset, length)).array(), StandardCharsets.US_ASCII);
    }
}
