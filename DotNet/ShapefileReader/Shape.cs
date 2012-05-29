namespace ShapefileReader
{
    public abstract class Shape
    {
        protected Shape(int recordNumber, ShapeType shapeType)
        {
            _recordNumber = recordNumber;
            _shapeType = shapeType;
        }

        public int RecordNumber
        {
            get { return _recordNumber; }
        }

        public ShapeType ShapeType
        {
            get { return _shapeType; }
        }

        private readonly int _recordNumber;
        private readonly ShapeType _shapeType;
    }
}
