package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import cesiumlanguagewriter.*;
import org.junit.Assert;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@org.junit.FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestReference {
	@Test
	public final void canContructEscapedReferences() {
		String value = "identifier#property";
		cesiumlanguagewriter.Reference reference = new Reference(value);
		Assert.assertEquals(reference.getIdentifier(), "identifier");
		Assert.assertArrayEquals(reference.getPropertyNames(), new String[] {
			"property"
		});
		Assert.assertEquals(value, reference.getValue());
		value = ("identifier#property.subProperty");
		reference = new Reference(value);
		Assert.assertEquals(reference.getIdentifier(), "identifier");
		Assert.assertArrayEquals(reference.getPropertyNames(), new String[] {
				"property",
				"subProperty"
		});
		Assert.assertEquals(value, reference.getValue());
		value = "\\#identif\\\\\\\\\\#ier\\.\\\\#propertyName.\\.abc\\\\.def";
		reference = new Reference(value);
		Assert.assertEquals(reference.getIdentifier(), "#identif\\\\#ier.\\");
		Assert.assertArrayEquals(reference.getPropertyNames(), new String[] {
				"propertyName",
				".abc\\",
				"def"
		});
		Assert.assertEquals(value, reference.getValue());
		value = "#propertyName.\\.abc\\\\.def";
		reference = new Reference(value);
		AssertHelper.assertIsEmpty(reference.getIdentifier());
		Assert.assertArrayEquals(reference.getPropertyNames(), new String[] {
				"propertyName",
				".abc\\",
				"def"
		});
		Assert.assertEquals(value, reference.getValue());
	}

	@Test
	public final void canContructFromIdentifierAndProperty() {
		cesiumlanguagewriter.Reference reference = new Reference("identifier", "property");
		Assert.assertEquals(reference.getIdentifier(), "identifier");
		Assert.assertArrayEquals(reference.getPropertyNames(), new String[] {
			"property"
		});
		Assert.assertEquals(reference.getValue(), "identifier#property");
		reference = new Reference("#identif\\\\#ier.\\", "property.Name");
		Assert.assertEquals(reference.getIdentifier(), "#identif\\\\#ier.\\");
		Assert.assertArrayEquals(reference.getPropertyNames(), new String[] {
			"property.Name"
		});
		Assert.assertEquals(reference.getValue(), "\\#identif\\\\\\\\\\#ier\\.\\\\#property\\.Name");
	}

	@Test
	public final void canContructFromIdentifierAndProperties() {
		cesiumlanguagewriter.Reference reference = new Reference("identifier", new String[] {
				"property",
				"subProperty"
		});
		Assert.assertEquals(reference.getIdentifier(), "identifier");
		Assert.assertArrayEquals(reference.getPropertyNames(), new String[] {
				"property",
				"subProperty"
		});
		Assert.assertEquals(reference.getValue(), "identifier#property.subProperty");
		reference = new Reference("#identif\\\\#ier.\\", new String[] {
				"property.Name",
				"subProperty"
		});
		Assert.assertEquals(reference.getIdentifier(), "#identif\\\\#ier.\\");
		Assert.assertArrayEquals(reference.getPropertyNames(), new String[] {
				"property.Name",
				"subProperty"
		});
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

	@org.junit.Rule
	public agi.foundation.compatibility.TestContextRule rule$testContext = new agi.foundation.compatibility.TestContextRule();
}