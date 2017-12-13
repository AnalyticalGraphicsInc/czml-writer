package agi.foundation.compatibility;

public class TestContext {
    private static final TestContext s_currentContext = new TestContext();
    private final TestAdapter test = new TestAdapter();

    public static TestContext getCurrentContext() {
        return s_currentContext;
    }

    public TestAdapter getTest() {
        return test;
    }

    public static final class TestAdapter {
        private String name;
        private String fullName;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    }
}
