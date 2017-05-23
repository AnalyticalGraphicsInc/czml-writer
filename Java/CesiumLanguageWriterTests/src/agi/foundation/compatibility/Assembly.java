package agi.foundation.compatibility;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
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
     * Helper class to encapsulate different ways of determining the location of the
     * "assembly", either by stacktrace information or for a given class type.
     */
    private static abstract class LocationInformation {
        private String fileName;

        public String getLocation() {
            if (fileName == null) {
                fileName = calculateLocation();
            }

            return fileName;
        }

        protected abstract String calculateLocation();

        protected String getLocationFromClass(Class<?> klass) {
            CodeSource source = klass.getProtectionDomain().getCodeSource();
            if (source == null) {
                throw new RuntimeException("unable to locate source of " + klass.getName());
            }
            return source.getLocation().getFile();
        }
    }

    private static final class StackTraceLocationInformation extends LocationInformation {
        private final Throwable throwable;

        public StackTraceLocationInformation(Throwable throwable) {
            this.throwable = throwable;
        }

        @Override
        protected String calculateLocation() {
            StackTraceElement[] stackTrace = throwable.getStackTrace();

            String className = null;
            for (int i = 0; i < stackTrace.length; ++i) {
                StackTraceElement element = stackTrace[i];
                className = element.getClassName();
                boolean isAssemblyClass = className.contains(Assembly.class.toString());
                boolean isGetExecutingAssemblyMethod = element.getMethodName().contains("getExecutingAssembly");
                if (!isAssemblyClass || !isGetExecutingAssemblyMethod) {
                    break;
                }
            }

            Class<?> klass;
            try {
                klass = Class.forName(className);
            } catch (ClassNotFoundException e) {
                // rethrow as RuntimeException since this is unlikely to occur
                // since the class name comes straight from the stack trace.
                throw new RuntimeException("Unable to find class from stack trace", e);
            }

            return getLocationFromClass(klass);
        }
    }

    private static final class ClassLocationInformation extends LocationInformation {
        private final Class<?> klass;

        public ClassLocationInformation(Class<?> klass) {
            this.klass = klass;
        }

        @Override
        protected String calculateLocation() {
            return getLocationFromClass(klass);
        }
    }

    private LocationInformation locationInformation;

    /**
     * Instantiates this class.
     *
     * @param klass
     *            A Class object that will be used to determine the location of the
     *            "assembly" containing the class
     */
    public Assembly(Class<?> klass) {
        locationInformation = new ClassLocationInformation(klass);
    }

    /**
     * Instantiates this class.
     *
     * @param throwable
     *            A Throwable object that can later be used to find caller information.
     *            The throwable must be constructed in the first method called by client
     *            code.
     */
    private Assembly(Throwable throwable) {
        locationInformation = new StackTraceLocationInformation(throwable);
    }

    /**
     * Method to get CS2JAssembly by identifying the location of class.
     *
     * @return CS2Assembly instance
     */
    public static Assembly getExecutingAssembly() {
        return new Assembly(new Throwable());
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

    /**
     * Gets the location of the loaded file that contains the manifest.
     *
     * @return String containing location
     */
    public String getLocation() {
        return locationInformation.getLocation();
    }

    /**
     * Returns the names of all the resources in this assembly.
     *
     * @return String[] array containing containing all resource names.
     */
    public String[] getManifestResourceNames() {
        try {
            // Java takes each entity in the project as resource, including
            // class
            // file.
            // GetManifestResourceNames method
            // in C# returns array of text/image/icon and other non-class files.
            // C# supports listing of resources in bin folder also
            List<String> resourceFiles = new ArrayList<String>();

            String location = getLocation();

            if (location.endsWith(".jar")) {
                JarFile jarFile = new JarFile(location);
                Enumeration<JarEntry> jarEntries = jarFile.entries();
                while (jarEntries.hasMoreElements()) {
                    JarEntry entry = jarEntries.nextElement();
                    String name = entry.getName();
                    if (!isClassFile(name)) {
                        resourceFiles.add(name);
                    }
                }
                jarFile.close();
            } else {
                addMatchingFiles(new File(location), new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return !isClassFile(pathname.getName());
                    }
                }, resourceFiles);
            }

            return resourceFiles.toArray(new String[resourceFiles.size()]);
        } catch (IOException e) {
            throw new RuntimeIOException(e);
        }
    }

    private void addMatchingFiles(File file, FileFilter filter, List<String> fileList) {
        if (file.isDirectory()) {
            File[] files = file.listFiles(filter);
            if (files != null) {
                for (File child : files) {
                    addMatchingFiles(child, filter, fileList);
                }
            }
        } else {
            fileList.add(file.getName());
        }
    }

    private boolean isClassFile(String name) {
        return name.endsWith(".class");
    }
}
