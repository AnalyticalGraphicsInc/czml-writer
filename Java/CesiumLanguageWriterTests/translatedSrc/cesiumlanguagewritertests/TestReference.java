package cesiumlanguagewritertests;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Action;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.AssertHelper;
import agi.foundation.compatibility.TestContextRule;
import agi.foundation.TypeLiteral;
import cesiumlanguagewriter.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import org.junit.ClassRule;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@SuppressWarnings({
    "unused",
    "deprecation",
    "serial"
})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestReference {
    @Test
    public final void canConstructEscapedReferences() {
        String value = "identifier#property";
        Reference reference = new Reference(value);
        AssertHelper.assertEquals("identifier", reference.getIdentifier());
        final ArrayList<String> tempCollection$0 = new ArrayList<String>();
        tempCollection$0.add("property");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$0);
        AssertHelper.assertEquals(value, reference.getValue());
        value = "identifier#property.subProperty";
        reference = new Reference(value);
        AssertHelper.assertEquals("identifier", reference.getIdentifier());
        final ArrayList<String> tempCollection$1 = new ArrayList<String>();
        tempCollection$1.add("property");
        tempCollection$1.add("subProperty");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$1);
        AssertHelper.assertEquals(value, reference.getValue());
        value = "\\#identif\\\\\\\\\\#ier\\.\\\\#propertyName.\\.abc\\\\.def";
        reference = new Reference(value);
        AssertHelper.assertEquals("#identif\\\\#ier.\\", reference.getIdentifier());
        final ArrayList<String> tempCollection$2 = new ArrayList<String>();
        tempCollection$2.add("propertyName");
        tempCollection$2.add(".abc\\");
        tempCollection$2.add("def");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$2);
        AssertHelper.assertEquals(value, reference.getValue());
        value = "#propertyName.\\.abc\\\\.def";
        reference = new Reference(value);
        AssertHelper.assertIsEmpty(reference.getIdentifier());
        final ArrayList<String> tempCollection$3 = new ArrayList<String>();
        tempCollection$3.add("propertyName");
        tempCollection$3.add(".abc\\");
        tempCollection$3.add("def");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$3);
        AssertHelper.assertEquals(value, reference.getValue());
    }

    @Test
    public final void canConstructFromIdentifierAndProperty() {
        Reference reference = new Reference("identifier", "property");
        AssertHelper.assertEquals("identifier", reference.getIdentifier());
        final ArrayList<String> tempCollection$0 = new ArrayList<String>();
        tempCollection$0.add("property");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$0);
        AssertHelper.assertEquals("identifier#property", reference.getValue());
        reference = new Reference("#identif\\\\#ier.\\", "property.Name");
        AssertHelper.assertEquals("#identif\\\\#ier.\\", reference.getIdentifier());
        final ArrayList<String> tempCollection$1 = new ArrayList<String>();
        tempCollection$1.add("property.Name");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$1);
        AssertHelper.assertEquals("\\#identif\\\\\\\\\\#ier\\.\\\\#property\\.Name", reference.getValue());
    }

    @Test
    public final void canConstructFromIdentifierAndProperties() {
        final ArrayList<String> tempCollection$0 = new ArrayList<String>();
        tempCollection$0.add("property");
        tempCollection$0.add("subProperty");
        Reference reference = new Reference("identifier", tempCollection$0);
        AssertHelper.assertEquals("identifier", reference.getIdentifier());
        final ArrayList<String> tempCollection$1 = new ArrayList<String>();
        tempCollection$1.add("property");
        tempCollection$1.add("subProperty");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$1);
        AssertHelper.assertEquals("identifier#property.subProperty", reference.getValue());
        final ArrayList<String> tempCollection$2 = new ArrayList<String>();
        tempCollection$2.add("property.Name");
        tempCollection$2.add("subProperty");
        reference = new Reference("#identif\\\\#ier.\\", tempCollection$2);
        AssertHelper.assertEquals("#identif\\\\#ier.\\", reference.getIdentifier());
        final ArrayList<String> tempCollection$3 = new ArrayList<String>();
        tempCollection$3.add("property.Name");
        tempCollection$3.add("subProperty");
        AssertHelper.assertEquals(reference.getPropertyNames(), tempCollection$3);
        AssertHelper.assertEquals("\\#identif\\\\\\\\\\#ier\\.\\\\#property\\.Name.subProperty", reference.getValue());
    }

    @Test
    public final void throwsWithMissingDelimiter() {
        ArgumentException exception = AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            Reference unused = new Reference("MissingDelimiter");
        }));
        AssertHelper.assertStringContains("The provided reference string is not in the correct format", exception.getMessage());
    }

    @Test
    public final void throwsWithMissingDelimiterDueToEscaping() {
        ArgumentException exception = AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            Reference unused = new Reference("Missing\\#Delimiter");
        }));
        AssertHelper.assertStringContains("The provided reference string is not in the correct format", exception.getMessage());
    }

    @Test
    public final void throwsWithMissingProperties() {
        ArgumentException exception = AssertHelper.<ArgumentException> assertThrows(new TypeLiteral<ArgumentException>() {}, Action.of(() -> {
            Reference unused = new Reference("MissingPropertyName#");
        }));
        AssertHelper.assertStringContains("The provided reference string is not in the correct format", exception.getMessage());
    }

    @Nonnull
    private static final TestContextRule rule$testContext = new TestContextRule();

    @Nonnull
    @Rule
    @ClassRule
    public static TestContextRule getRule$testContext() {
        return rule$testContext;
    }
}