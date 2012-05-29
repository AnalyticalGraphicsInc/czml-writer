namespace ShapefileReader
{
    public enum ShapeType
    {
        NullShape = 0,
        Point = 1,
        Polyline = 3,
        Polygon = 5,
        MultiPoint = 8,
        PointZ = 11,
        PolylineZ = 13,
        PolygonZ = 15,
        MultiPointZ = 18,
        PointM = 21,
        PolylineM = 23,
        PolygonM = 25,
        MultiPointM = 28,
        MultiPatch = 31
    }
}
