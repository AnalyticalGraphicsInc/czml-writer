package agi.foundation.compatibility;

public final class PrimitiveHelper {
    private PrimitiveHelper() {}

    public static boolean equals(boolean a, boolean b) {
        return a == b;
    }

    public static boolean equals(byte a, byte b) {
        return a == b;
    }

    public static boolean equals(char a, char b) {
        return a == b;
    }

    public static boolean equals(double a, double b) {
        return a == b;
    }

    public static boolean equals(float a, float b) {
        return a == b;
    }

    public static boolean equals(int a, int b) {
        return a == b;
    }

    public static boolean equals(long a, long b) {
        return a == b;
    }

    public static boolean equals(short a, short b) {
        return a == b;
    }

    public static int hashCode(boolean value) {
        return value ? 1231 : 1237;
    }

    public static int hashCode(byte value) {
        return value;
    }

    public static int hashCode(char value) {
        return value;
    }

    public static int hashCode(double value) {
        long bits = Double.doubleToLongBits(value);
        return (int) (bits ^ (bits >>> 32));
    }

    public static int hashCode(float value) {
        return Float.floatToIntBits(value);
    }

    public static int hashCode(int value) {
        return value;
    }

    public static int hashCode(long value) {
        return (int) (value ^ (value >>> 32));
    }

    public static int hashCode(short value) {
        return value;
    }
}
