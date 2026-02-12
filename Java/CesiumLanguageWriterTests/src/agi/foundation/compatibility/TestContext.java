package agi.foundation.compatibility;

import java.io.File;

import javax.annotation.Nonnull;

public final class TestContext {
    @Nonnull
    private static final TestContext s_currentContext = new TestContext();
    @Nonnull
    private final TestAdapter test = new TestAdapter();

    private TestContext() {}

    @Nonnull
    public static TestContext getCurrentContext() {
        return s_currentContext;
    }

    @Nonnull
    public TestAdapter getTest() {
        return test;
    }

    public String getTestDirectory() {
        Assembly assembly = null;

        if (test != null) {
            Class<?> testClass = test.getTestClass();
            if (testClass != null) {
                assembly = new Assembly(testClass);
            }
        }

        if (assembly == null) {
            assembly = Assembly.getCallingAssembly();
        }

        File file = new File(assembly.getLocation());
        return file.isDirectory() ? file.getPath() : file.getParent();
    }

    public static final class TestAdapter {
        private String name;
        private String fullName;
        private Class<?> testClass;

        public String getName() {
            return name;
        }

        public String getFullName() {
            return fullName;
        }

        void setName(String name) {
            this.name = name;
        }

        void setFullName(String fullName) {
            this.fullName = fullName;
        }

        Class<?> getTestClass() {
            return testClass;
        }

        void setTestClass(Class<?> testClass) {
            this.testClass = testClass;
        }
    }
}
