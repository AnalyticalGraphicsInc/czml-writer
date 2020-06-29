package agi.foundation.compatibility;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import agi.foundation.compatibility.TestContext.TestAdapter;

public final class TestContextRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Class<?> testClass = description.getTestClass();
                if (testClass == null) {
                    base.evaluate();
                    return;
                }

                TestAdapter testAdapter = TestContext.getCurrentContext().getTest();
                testAdapter.setTestClass(testClass);

                if (description.isTest()) {
                    String methodName = description.getMethodName();
                    assert methodName != null;

                    testAdapter.setName(methodName);
                    testAdapter.setFullName(testClass.getName() + "." + methodName);
                } else {
                    assert description.isSuite();

                    testAdapter.setName(testClass.getSimpleName());
                    testAdapter.setFullName(testClass.getName());
                }

                base.evaluate();
            }
        };
    }
}
