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
     * Method to get CS2JAssembly by identifying the location of class.
     *
     * @return CS2Assembly instance
     */
    public static Assembly getExecutingAssembly() {
        return new Assembly();
    }

    /**
     * Loads the specified manifest resource, scoped by the namespace of the specified
     * type, from this assembly.
     *
     * @param klass
     *            The type whose namespace is used to scope the manifest resource name.
     * @param name
     *            The case-sensitive name of the manifest resource being requested.
     * @return A Stream representing the manifest resource; null if no resources were
     *         specified during compilation or if the resource is not visible to the
     *         caller.
     */
    public InputStream getManifestResourceStream(Class<?> klass, String name) {
        return klass.getResourceAsStream(name);
    }
}
