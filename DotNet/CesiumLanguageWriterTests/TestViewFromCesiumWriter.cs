using System.Collections.Generic;
using CesiumLanguageWriter;
using CesiumLanguageWriter.Advanced;
using JetBrains.Annotations;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    [TestFixture]
    public class TestViewFromCesiumWriter : TestCesiumPropertyWriter<ViewFromCesiumWriter>
    {
        [Test]
        public void WriteCartesian()
        {
            var expected = new Cartesian(1.0, 2.0, 3.0);

            using (var packet = OpenPacket())
            using (var viewFrom = packet.OpenViewFromProperty())
            {
                viewFrom.WriteCartesian(expected);
            }

            AssertPropertyJson(expected);
        }

        [Test]
        public void WriteReference()
        {
            const string expectedIdentifier = "someId";
            const string expectedPropertyName = "viewFrom";

            using (var packet = OpenPacket())
            using (var viewFrom = packet.OpenViewFromProperty())
            {
                viewFrom.WriteReference(expectedIdentifier, expectedPropertyName);
            }

            AssertPropertyJson(new Dictionary<string, object>
            {
                { ViewFromCesiumWriter.ReferencePropertyName, expectedIdentifier + "#" + expectedPropertyName },
            });
        }

        [Test]
        public void TestDeleteProperty()
        {
            const bool expectedDelete = true;

            using (var packet = OpenPacket())
            using (var viewFrom = packet.OpenViewFromProperty())
            {
                viewFrom.WriteDelete(expectedDelete);
            }

            AssertPropertyJson(new Dictionary<string, object>
            {
                { ViewFromCesiumWriter.DeletePropertyName, expectedDelete },
            });
        }

        private void AssertPropertyJson([NotNull] object value)
        {
            AssertExpectedJson(new Dictionary<string, object>
            {
                { PacketCesiumWriter.ViewFromPropertyName, value },
            });
        }

        protected override CesiumPropertyWriter<ViewFromCesiumWriter> CreatePropertyWriter(string propertyName)
        {
            return new ViewFromCesiumWriter(propertyName);
        }
    }
}
