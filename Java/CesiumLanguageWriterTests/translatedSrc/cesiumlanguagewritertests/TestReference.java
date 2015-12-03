package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.TestContextRule;
import cesiumlanguagewriter.*;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestReference {
	@Test
	public final void canContructEscapedReferences() {
		String value = "identifier#property";
		cesiumlanguagewriter.Reference reference = new Reference(value);
		Assert.assertEquals(reference.getIdentifier(), "identifier");
		ArrayList<String> tempCollection_0 = new ArrayList<String>();
		tempCollection_0.add("property");
		AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection_0);
		Assert.assertEquals(value, reference.getValue());
		value = ("identifier#property.subProperty");
		reference = new Reference(value);
		Assert.assertEquals(reference.getIdentifier(), "identifier");
		ArrayList<String> tempCollection_1 = new ArrayList<String>();
		tempCollection_1.add("property");
		tempCollection_1.add("subProperty");
		AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection_1);
		Assert.assertEquals(value, reference.getValue());
		value = "\\#identif\\\\\\\\\\#ier\\.\\\\#propertyName.\\.abc\\\\.def";
		reference = new Reference(value);
		Assert.assertEquals(reference.getIdentifier(), "#identif\\\\#ier.\\");
		ArrayList<String> tempCollection_2 = new ArrayList<String>();
		tempCollection_2.add("propertyName");
		tempCollection_2.add(".abc\\");
		tempCollection_2.add("def");
		AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection_2);
		Assert.assertEquals(value, reference.getValue());
		value = "#propertyName.\\.abc\\\\.def";
		reference = new Reference(value);
		AssertHelper.assertIsEmpty(reference.getIdentifier());
		ArrayList<String> tempCollection_3 = new ArrayList<String>();
		tempCollection_3.add("propertyName");
		tempCollection_3.add(".abc\\");
		tempCollection_3.add("def");
		AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection_3);
		Assert.assertEquals(value, reference.getValue());
	}

	@Test
	public final void canContructFromIdentifierAndProperty() {
		cesiumlanguagewriter.Reference reference = new Reference("identifier", "property");
		Assert.assertEquals(reference.getIdentifier(), "identifier");
		ArrayList<String> tempCollection_4 = new ArrayList<String>();
		tempCollection_4.add("property");
		AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection_4);
		Assert.assertEquals(reference.getValue(), "identifier#property");
		reference = new Reference("#identif\\\\#ier.\\", "property.Name");
		Assert.assertEquals(reference.getIdentifier(), "#identif\\\\#ier.\\");
		ArrayList<String> tempCollection_5 = new ArrayList<String>();
		tempCollection_5.add("property.Name");
		AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection_5);
		Assert.assertEquals(reference.getValue(), "\\#identif\\\\\\\\\\#ier\\.\\\\#property\\.Name");
	}

	@Test
	public final void canContructFromIdentifierAndProperties() {
		ArrayList<String> tempCollection_6 = new ArrayList<String>();
		tempCollection_6.add("property");
		tempCollection_6.add("subProperty");
		cesiumlanguagewriter.Reference reference = new Reference("identifier", tempCollection_6);
		Assert.assertEquals(reference.getIdentifier(), "identifier");
		ArrayList<String> tempCollection_7 = new ArrayList<String>();
		tempCollection_7.add("property");
		tempCollection_7.add("subProperty");
		AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection_7);
		Assert.assertEquals(reference.getValue(), "identifier#property.subProperty");
		ArrayList<String> tempCollection_8 = new ArrayList<String>();
		tempCollection_8.add("property.Name");
		tempCollection_8.add("subProperty");
		reference = new Reference("#identif\\\\#ier.\\", tempCollection_8);
		Assert.assertEquals(reference.getIdentifier(), "#identif\\\\#ier.\\");
		ArrayList<String> tempCollection_9 = new ArrayList<String>();
		tempCollection_9.add("property.Name");
		tempCollection_9.add("subProperty");
		AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection_9);
		Assert.assertEquals(reference.getValue(), "\\#identif\\\\\\\\\\#ier\\.\\\\#property\\.Name.subProperty");
	}

	@Test(expected = ArgumentException.class)
	public final void throwsWithMissingDelimiter() {
		new Reference("MissingDelimiter");
	}

	@Test(expected = ArgumentException.class)
	public final void throwsWithMissingDelimiterDoToEscaping() {
		new Reference("Missing\\#Delimiter");
	}

	@Test(expected = ArgumentException.class)
	public final void throwsWithMissingProperties() {
		new Reference("MissingPropertyName#");
	}

	@Rule
	public TestContextRule rule$testContext = new TestContextRule();
}