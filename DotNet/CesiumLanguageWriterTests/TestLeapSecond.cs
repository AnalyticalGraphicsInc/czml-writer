using CesiumLanguageWriter;
using NUnit.Framework;

namespace CesiumLanguageWriterTests
{
    /// <summary>
    /// Tests the <see cref="LeapSecond"/> type.
    /// </summary>
    [TestFixture]
    public class TestLeapSecond
    {
        /// <summary>
        /// Tests equality between leap second instances.
        /// </summary>
        [Test]
        public void TestEquality()
        {
            LeapSecond ls1 = new LeapSecond(2451545.0, 100.0);
            LeapSecond ls2 = new LeapSecond(2451545.0, 100.0);
            LeapSecond ls3 = new LeapSecond(2451545.0, 101.0);
            LeapSecond ls4 = new LeapSecond(2451546.0, 101.0);
            Assert.AreEqual(ls1, ls2);
            Assert.IsTrue(ls1 == ls2);
            Assert.AreNotEqual(ls1, ls3);
            Assert.IsTrue(ls1 != ls3);
            Assert.AreNotEqual(ls1, 5);
            Assert.AreNotEqual(ls3, ls4);
        }

        /// <summary>
        /// Tests that JulianDate.GetHashCode returns something at least reasonably random.
        /// </summary>
        [Test]
        public void TestGetHashCode()
        {
            LeapSecond ls1 = new LeapSecond(2451545.0, 100.0);
            LeapSecond ls2 = new LeapSecond(2451545.0, 100.0);
            LeapSecond ls3 = new LeapSecond(2451545.0, 101.0);

            Assert.AreEqual(ls1.GetHashCode(), ls2.GetHashCode());
            Assert.AreNotEqual(ls1.GetHashCode(), ls3.GetHashCode());
        }

        /// <summary>
        /// Tests the ToString of LeapSecond.
        /// </summary>
        [Test]
        public void TestToString()
        {
            LeapSecond ls1 = new LeapSecond(2451545.0, 100.0);

            Assert.AreEqual("2451545:0 (UTC), 100", ls1.ToString());
        }
    }
}