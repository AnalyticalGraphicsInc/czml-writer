package agi.foundation.compatibility;

import java.io.InputStream;

/**
 * Represents an assembly, which is a reusable, versionable, and self-describing building
 * block of a common language runtime application.
 */
public class Assembly {
    /**
     * Instantiates this class.
     */
    private Assembly() {
    }

    /**
     * Gets the assembly that contains the code that is currently executing.
     *
     * @return The assembly that contains the code that is currently executing.
     */
    public static Assembly getExecutingAssembly() {
        return new Assembly();
    }

    /**
     * Loads the specified manifest resource, scoped by the namespace of the specified
     * type, from this assembly.
     *
     * @param type
     *            The type whose namespace is used to scope the manifest resource name.
     * @param name
     *            The case-sensitive name of the manifest resource being requested.
     * @return A Stream representing the manifest resource; null if no resources were
     *         specified during compilation or if the resource is not visible to the
     *         caller.
     */
    public InputStream getManifestResourceStream(Class<?> type, String name) {
        return type.getResourceAsStream(name);
    }
}
