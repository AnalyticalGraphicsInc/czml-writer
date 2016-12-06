package agi.foundation.compatibility;

import java.util.ResourceBundle;

public final class ResourceBundleHelper {
    private ResourceBundleHelper() {}

    public static ResourceBundle getBundle(String baseName) {
        int dotIndex = baseName.lastIndexOf(".");
        String packageName = StringHelper.toLowerInvariant(baseName.substring(0, dotIndex));
        String className = baseName.substring(dotIndex);
        return ResourceBundle.getBundle(packageName + className);
    }
}
