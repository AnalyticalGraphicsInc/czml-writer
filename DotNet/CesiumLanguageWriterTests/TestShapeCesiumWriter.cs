using System.Collections.Generic;
using System.Linq;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestShapeCesiumWriter : TestCesiumPropertyWriter<ShapeCesiumWriter>
    {
        [Test]
        public void WriteListOfCartesian2()
        {
            const string expectedPropertyName = "foo";
            IEnumerable<Rectangular> expectedValue = new List<Rectangular>
            {
                new Rectangular(10, 20),
                new Rectangular(30, 40),
            };

            using (OpenPacket())
            using (var writer = new ShapeCesiumWriter(expectedPropertyName))
            {
                writer.Open(OutputStream);
                writer.WriteCartesian2(expectedValue);
            }

            var expectedValueJson = expectedValue.SelectMany(r => new object[] { r.X, r.Y });

            AssertExpectedJson(new Dictionary<string, object>
            {
                {
                    expectedPropertyName, new Dictionary<string, object>
                    {
                        { "cartesian2", expectedValueJson }
                    }
                }
            });
        }

        protected override CesiumPropertyWriter<ShapeCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new ShapeCesiumWriter(propertyName);
        }
    }
}