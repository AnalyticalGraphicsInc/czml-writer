using System.Collections.Specialized;
using CesiumLanguageWriter;
using NUnit.Framework;
using Shapefile;

namespace ShapefileReaderTests
{
    [TestFixture]
    public class TestPointShapes
    {
         private StringDictionary m_metadata;
         private Cartographic m_position;

         [SetUp]
         public void SetUp()
         {
             m_metadata = new StringDictionary();
             m_position = new Cartographic(1.0, 2.0, 0.0);
         }

         [Test]
         public void TestPointShapeType()
         {
             Cartesian position = new Cartesian(1.0, 2.0, 0.0);
             PointShape point = new PointShape(1, m_metadata, m_position);
             Assert.That(point.ShapeType == ShapeType.Point);
         }

         [Test]
         public void TestPointShapePosition()
         {
             
             PointShape point = new PointShape(1, m_metadata, m_position);
             Assert.That(point.Position.Equals(new Cartographic(Constants.RadiansPerDegree, 2.0 * Constants.RadiansPerDegree, 0.0)));
         }

         [Test]
         public void TestPointMShapeType()
         {
             PointMShape point = new PointMShape(2, m_metadata, m_position, 5.0);
             Assert.That(point.ShapeType == ShapeType.PointM);
         }

         [Test]
         public void TestPointMShapePosition()
         {
             PointMShape point = new PointMShape(2, m_metadata, m_position, 5.0);
             Assert.That(point.Position.Equals(new Cartographic(Constants.RadiansPerDegree, 2.0 * Constants.RadiansPerDegree, 0.0)));
         }

         [Test]
         public void TestPointMShapeMeasure()
         {
             PointMShape point = new PointMShape(2, m_metadata, m_position, 5.0);
             Assert.That(point.Measure == 5.0);
         }

         [Test]
         public void TestPointZShapeType()
         {
             PointZShape point = new PointZShape(2, m_metadata, m_position, 5.0);
             Assert.That(point.ShapeType == ShapeType.PointZ);
         }

         [Test]
         public void TestPointZShapePosition()
         {
             Cartographic position = new Cartographic(1.0, 2.0, 3.0);
             PointZShape point = new PointZShape(2, m_metadata, position, 5.0);
             Assert.That(point.Position.Equals(new Cartographic(Constants.RadiansPerDegree, 2.0 * Constants.RadiansPerDegree, 3.0)));
         }
    }
}
