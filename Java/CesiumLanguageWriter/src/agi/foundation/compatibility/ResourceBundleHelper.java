package agi.foundation.compatibility;

import static agi.foundation.compatibility.ArgumentNullException.assertNonNull;

import agi.foundation.compatibility.annotations.Internal;

import java.util.ResourceBundle;

import javax.annotation.Nonnull;

/**
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class ResourceBundleHelper {
    private ResourceBundleHelper() {}

    public static ResourceBundle getBundle(@Nonnull String baseName) {
        assertNonNull(baseName, "baseName");

        int dotIndex = baseName.lastIndexOf(".");
        String packageName = StringHelper.toLowerInvariant(baseName.substring(0, dotIndex));
        String className = baseName.substring(dotIndex);
        return ResourceBundle.getBundle(packageName + className);
    }
}
