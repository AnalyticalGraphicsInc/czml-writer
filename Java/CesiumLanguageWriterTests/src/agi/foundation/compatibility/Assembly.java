package agi.foundation.compatibility;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Represents the binaries containing Java executables. It can represent both Jar file and
 * directory containing loose directory. Depending on the location from where resource is
 * executing, instance of this class will be created.
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
