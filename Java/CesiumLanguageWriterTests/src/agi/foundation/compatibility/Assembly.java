package agi.foundation.compatibility;

import java.io.InputStream;
import java.nio.file.Paths;
import java.security.CodeSource;

import javax.annotation.Nonnull;

/**
 * Represents an assembly, which is a reusable, versionable, and self-describing building
 * block of a common language runtime application.
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

        protected String getLocationFromClass(@Nonnull Class<?> c) {
            CodeSource source = c.getProtectionDomain().getCodeSource();
            if (source == null) {
                throw new RuntimeException("unable to locate source of " + c.getName());
            }

            return Paths.get(UriHelper.toURI(source.getLocation())).toString();
        }
    }

    private static final class StackTraceLocationInformation extends LocationInformation {
        private static final String assemblyClassName = Assembly.class.getName();
        @Nonnull
        private final Throwable throwable;
        @Nonnull
        private final String assemblyMethodName;
        private final int stackTraceOffset;

        public StackTraceLocationInformation(@Nonnull Throwable throwable, @Nonnull String assemblyMethodName, int stackTraceOffset) {
            this.throwable = throwable;
            this.assemblyMethodName = assemblyMethodName;
            this.stackTraceOffset = stackTraceOffset;
        }

        @Override
        protected String calculateLocation() {
            StackTraceElement[] stackTrace = throwable.getStackTrace();

            int index = 0;
            for (; index < stackTrace.length; ++index) {
                StackTraceElement element = stackTrace[index];
                if (ObjectHelper.notEquals(element.getClassName(), assemblyClassName)) {
                    break;
                }
                if (ObjectHelper.notEquals(element.getMethodName(), assemblyMethodName)) {
                    break;
                }
            }

            String className = stackTrace[index + stackTraceOffset].getClassName();
            @Nonnull
            Class<?> c = TypeHelper.classForName(className);
            return getLocationFromClass(c);
        }
    }

    private static final class ClassLocationInformation extends LocationInformation {
        @Nonnull
        private final Class<?> c;

        public ClassLocationInformation(@Nonnull Class<?> c) {
            this.c = c;
        }

        @Override
        protected String calculateLocation() {
            return getLocationFromClass(c);
        }
    }

    @Nonnull
    private final LocationInformation locationInformation;

    /**
     * Instantiates this class.
     *
     * @param c
     *            A Class object that will be used to determine the location of the
     *            "assembly" containing the class
     */
    public Assembly(@Nonnull Class<?> c) {
        locationInformation = new ClassLocationInformation(c);
    }

    /**
     * Instantiates this class.
     *
     * @param throwable
     *            A Throwable object that can later be used to find caller information.
     *            The throwable must be constructed in the method in the Assembly class
     *            which was called by client code.
     * @param assemblyMethodName
     *            The name of the method in the Assembly class that was called.
     * @param stackTraceOffset
     *            An additional offset to add to the index of the stack trace element that
     *            corresponds to the calling client code.
     */
    private Assembly(@Nonnull Throwable throwable, @Nonnull String assemblyMethodName, int stackTraceOffset) {
        locationInformation = new StackTraceLocationInformation(throwable, assemblyMethodName, stackTraceOffset);
    }

    /**
     * Gets the assembly that contains the code that is currently executing.
     *
     * @return The assembly that contains the code that is currently executing.
     */
    @Nonnull
    public static Assembly getExecutingAssembly() {
        return new Assembly(new Throwable(), "getExecutingAssembly", 0);
    }

    /**
     * Returns the assembly of the method that invoked the currently executing method.
     *
     * @return The assembly of the method that invoked the currently executing method.
     */
    @Nonnull
    public static Assembly getCallingAssembly() {
        return new Assembly(new Throwable(), "getCallingAssembly", 1);
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

    /**
     * Gets the location of the loaded file that contains the manifest.
     *
     * @return String containing location
     */
    public String getLocation() {
        return locationInformation.getLocation();
    }
}
