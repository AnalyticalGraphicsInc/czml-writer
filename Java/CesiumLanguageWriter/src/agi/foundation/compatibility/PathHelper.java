package agi.foundation.compatibility;

import static agi.foundation.compatibility.ArgumentNullException.assertNonNull;

import agi.foundation.compatibility.annotations.Internal;

import java.io.File;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Helper methods related to Path.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class PathHelper {
    private PathHelper() {}

    /**
     * Combines two strings into a path.
     *
     * @param path1
     *            The first path to combine.
     * @param path2
     *            The second path to combine.
     * @return The combined paths. If one of the specified paths is a zero-length string,
     *         this method returns the other path. If path2 contains an absolute path,
     *         this method returns path2.
     */
    @Nonnull
    public static String combine(@Nonnull String path1, @Nonnull String path2) {
        assertNonNull(path1, "path1");
        assertNonNull(path2, "path2");

        return combinePaths(path1, path2);
    }

    @Nonnull
    private static String combinePaths(@Nonnull String path1, @Nonnull String path2) {
        if (path2.length() == 0)
            return path1;
        if (path1.length() == 0 || isPathRooted(path2))
            return path2;

        String result = new File(path1, path2).getPath();

        char c = lastChar(path2);
        if (isSlash(c))
            result += c;

        return result;
    }

    /**
     * Gets a value indicating whether the specified path string contains absolute or
     * relative path information.
     *
     * @param path
     *            The path to test.
     * @return true if path contains an absolute path; otherwise, false.
     */
    public static boolean isPathRooted(@Nullable String path) {
        if (path == null)
            return false;

        int length = path.length();
        return length >= 1 && isSlash(path.charAt(0)) || length >= 2 && path.charAt(1) == ':';
    }

    private static char lastChar(@Nonnull String s) {
        return s.charAt(s.length() - 1);
    }

    private static boolean isSlash(char c) {
        return c == '\\' || c == '/';
    }
}
