package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

/**
 * Helper methods related to Directory.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class DirectoryHelper {
    private DirectoryHelper() {}

    /**
     * Gets the current working directory of the application.
     *
     * @return A string containing the path of the current working directory.
     */
    public static String getCurrentDirectory() {
        return System.getProperty("user.dir");
    }
}
