using System;
using System.Linq;
using System.Collections.Generic;
using System.Collections.Specialized;

namespace Shapefile
{
    public abstract class Shape
    {
        protected Shape(int recordNumber, StringDictionary metadata, ShapeType shapeType)
        {
            _recordNumber = recordNumber;
            _metadata = metadata;
            _shapeType = shapeType;
        }

        public int RecordNumber
        {
            get { return _recordNumber; }
        }

        public StringDictionary Metadata
        {
            get { return _metadata; }
        }

        public string[] GetMetadataFields()
        {
            string[] keys = new string[_metadata.Keys.Count];
            _metadata.Keys.CopyTo(keys, 0);
            return keys;
        }

        public string GetMetadataValue(string field)
        {
            if (_metadata.ContainsKey(field))
            {
                return _metadata[field];
            }
            else
            {
                return null;
            }
        }

        public ShapeType ShapeType
        {
            get { return _shapeType; }
        }

        private readonly int _recordNumber;
        private readonly StringDictionary _metadata;
        private readonly ShapeType _shapeType;
    }
}
