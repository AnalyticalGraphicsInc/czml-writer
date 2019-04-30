package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import javax.annotation.Nonnull;
import java.io.File;

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
     * Combines two path strings.
     *
     * @param path1
     *            The first path.
     * @param path2
     *            The second path.
     * @return A string containing the combined paths. If one of the specified paths is a
     *         zero-length string, this method returns the other path. If path2 contains
     *         an absolute path, this method returns path2.
     */
    @Nonnull
    public static String combine(@Nonnull String path1, @Nonnull String path2) {
        ArgumentNullException.assertNonNull(path1, "path1");
        ArgumentNullException.assertNonNull(path2, "path2");

        if (path2.length() == 0)
            return path1;

        File file = new File(path2);
        if (file.isAbsolute() || path1.length() == 0)
            return path2;

        String result = new File(path1, path2).getPath();

        if (path2.endsWith("/"))
            result += "/";
        if (path2.endsWith("\\"))
            result += "\\";

        return result;
    }
}
