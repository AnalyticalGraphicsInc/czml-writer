package agi.foundation.compatibility;

import java.lang.reflect.Method;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import agi.foundation.compatibility.TestContext.TestAdapter;

public final class TestContextRule implements MethodRule {
    @Override
    public Statement apply(final Statement base, final FrameworkMethod method, Object target) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Method testMethod = method.getMethod();
                Class<?> testClass = testMethod.getDeclaringClass();

                TestAdapter testAdapter = TestContext.getCurrentContext().getTest();
                testAdapter.setName(testMethod.getName());
                testAdapter.setFullName(testClass.getName() + "." + testMethod.getName());

                base.evaluate();
            }
        };
    }
}
