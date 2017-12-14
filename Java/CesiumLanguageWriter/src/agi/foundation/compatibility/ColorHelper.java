package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.awt.Color;

import javax.annotation.Nonnull;

/**
 * Helper methods related to Color.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class ColorHelper {
    private ColorHelper() {}

    /**
     * Creates a Color from the four ARGB component (alpha, red, green, and blue) values.
     * Although this method allows a 32-bit value to be passed for each component, the
     * value of each component is limited to 8 bits.
     *
     * @param alpha
     *            The alpha component. Valid values are 0 through 255.
     * @param red
     *            The red component. Valid values are 0 through 255.
     * @param green
     *            The green component. Valid values are 0 through 255.
     * @param blue
     *            The blue component. Valid values are 0 through 255.
     * @return The Color that this method creates.
     */
    @Nonnull
    public static Color fromArgb(int alpha, int red, int green, int blue) {
        return new Color(red, green, blue, alpha);
    }
}
