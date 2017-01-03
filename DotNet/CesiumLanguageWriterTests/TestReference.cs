using System;
using System.Collections.Generic;
using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestReference
    {
        [Test]
        public void CanConstructEscapedReferences()
        {
            var value = "identifier#property";
            var reference = new Reference(value);
            Assert.AreEqual(reference.Identifier, "identifier");
            Assert.AreEqual(reference.PropertyNames, new List<string> { "property" });
            Assert.AreEqual(value, reference.Value);

            value = "identifier#property.subProperty";
            reference = new Reference(value);
            Assert.AreEqual(reference.Identifier, "identifier");
            Assert.AreEqual(reference.PropertyNames, new List<string> { "property", "subProperty" });
            Assert.AreEqual(value, reference.Value);

            value = @"\#identif\\\\\#ier\.\\#propertyName.\.abc\\.def";
            reference = new Reference(value);
            Assert.AreEqual(reference.Identifier, @"#identif\\#ier.\");
            Assert.AreEqual(reference.PropertyNames, new List<string> { "propertyName", @".abc\", "def" });
            Assert.AreEqual(value, reference.Value);

            value = @"#propertyName.\.abc\\.def";
            reference = new Reference(value);
            Assert.IsEmpty(reference.Identifier);
            Assert.AreEqual(reference.PropertyNames, new List<string> { "propertyName", @".abc\", "def" });
            Assert.AreEqual(value, reference.Value);
        }

        [Test]
        public void CanConstructFromIdentifierAndProperty()
        {
            var reference = new Reference("identifier", "property");
            Assert.AreEqual(reference.Identifier, "identifier");
            Assert.AreEqual(reference.PropertyNames, new List<string> { "property" });
            Assert.AreEqual(reference.Value, "identifier#property");

            reference = new Reference(@"#identif\\#ier.\", "property.Name");
            Assert.AreEqual(reference.Identifier, @"#identif\\#ier.\");
            Assert.AreEqual(reference.PropertyNames, new List<string> { @"property.Name" });
            Assert.AreEqual(reference.Value, @"\#identif\\\\\#ier\.\\#property\.Name");
        }

        [Test]
        public void CanConstructFromIdentifierAndProperties()
        {
            var reference = new Reference("identifier", new List<string> { "property", "subProperty" });
            Assert.AreEqual(reference.Identifier, "identifier");
            Assert.AreEqual(reference.PropertyNames, new List<string> { "property", "subProperty" });
            Assert.AreEqual(reference.Value, "identifier#property.subProperty");

            reference = new Reference(@"#identif\\#ier.\", new List<string> { "property.Name", "subProperty" });
            Assert.AreEqual(reference.Identifier, @"#identif\\#ier.\");
            Assert.AreEqual(reference.PropertyNames, new List<string> { @"property.Name", "subProperty" });
            Assert.AreEqual(reference.Value, @"\#identif\\\\\#ier\.\\#property\.Name.subProperty");
        }

        [Test]
        [ExpectedException(typeof(ArgumentException))]
        public void ThrowsWithMissingDelimiter()
        {
            new Reference("MissingDelimiter");
        }

        [Test]
        [ExpectedException(typeof(ArgumentException))]
        public void ThrowsWithMissingDelimiterDoToEscaping()
        {
            new Reference(@"Missing\#Delimiter");
        }

        [Test]
        [ExpectedException(typeof(ArgumentException))]
        public void ThrowsWithMissingProperties()
        {
            new Reference(@"MissingPropertyName#");
        }
    }
}
