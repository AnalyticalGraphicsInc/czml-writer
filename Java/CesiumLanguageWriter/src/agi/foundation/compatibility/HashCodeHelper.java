package agi.foundation.compatibility;

final class HashCodeHelper {
    private HashCodeHelper() {}

    static int combine(int h1, int h2) {
        return (h1 << 5) + h1 ^ h2;
    }

    static int combine(int h1, int h2, int h3) {
        return combine(combine(h1, h2), h3);
    }

    static int combine(int h1, int h2, int h3, int h4) {
        return combine(combine(h1, h2), combine(h3, h4));
    }
}
