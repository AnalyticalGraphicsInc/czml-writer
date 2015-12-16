package agi.foundation.compatibility;

import java.lang.reflect.Method;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import agi.foundation.compatibility.TestContext.TestAdapter;

public class TestContextRule implements MethodRule {
	@Override
	public Statement apply(final Statement base, final FrameworkMethod method, Object target) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				Method testMethod = method.getMethod();
				Class<?> testClass = testMethod.getDeclaringClass();

				TestContext testContext = TestContext.getCurrentContext();
				TestAdapter testAdapter = testContext.getTest();

				testAdapter.setName(testMethod.getName());
				testAdapter.setFullName(testClass.getName() + "." + testMethod.getName());

				base.evaluate();
			}
		};
	}
}
