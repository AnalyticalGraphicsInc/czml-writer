using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Data;
using System.Data.OleDb;
using System.IO;
using System.Text;
using CesiumLanguageWriter;

namespace Shapefile
{
    public class ShapefileReader
    {
        public ShapefileReader(string filename)
        {
            //
            // ESRI Shapefile Technical Description:
            //    http://www.esri.com/library/whitepapers/pdfs/shapefile.pdf
            //
            using (FileStream fs = new FileStream(filename, FileMode.Open, FileAccess.Read))
            {
                //
                // File Header:
                //
                // Position  Field         Value        Type     Byte Order
                // --------  -----         -----        ----     ----------
                // Byte 0    File Code     9994         Integer  Big
                // Byte 4    Unused        0            Integer  Big
                // Byte 8    Unused        0            Integer  Big
                // Byte 12   Unused        0            Integer  Big
                // Byte 16   Unused        0            Integer  Big
                // Byte 20   Unused        0            Integer  Big
                // Byte 24   File Length   File Length  Integer  Big
                // Byte 28   Version       1000         Integer  Little
                // Byte 32   Shape Type    Shape Type   Integer  Little
                // Byte 36   Bounding Box  Xmin         Double   Little
                // Byte 44   Bounding Box  Ymin         Double   Little
                // Byte 52   Bounding Box  Xmax         Double   Little
                // Byte 60   Bounding Box  Ymax         Double   Little
                // Byte 68*  Bounding Box  Zmin         Double   Little
                // Byte 76*  Bounding Box  Zmax         Double   Little
                // Byte 84*  Bounding Box  Mmin         Double   Little
                // Byte 92*  Bounding Box  Mmax         Double   Little
                //
                // * Unused, with value 0.0, if not Measured or Z type
                //
                byte[] fileHeader = Read(fs, _fileHeaderLength);
                if (fileHeader == null)
                {
                    throw new InvalidDataException("Could not read shapefile header.");
                }

                int fileCode = ToInteger(fileHeader, 0, ByteOrder.BigEndian);
                if (fileCode != _fileCode)
                {
                    //
                    // Swap byte order and try again.
                    //
                    _byteOrder = ByteOrder.BigEndian;

                    fileCode = ToInteger(fileHeader, 0, ByteOrder.BigEndian);

                    if (fileCode != _fileCode)
                    {
                        throw new InvalidDataException("Could not read shapefile file code.  Is this a valid shapefile?");
                    }
                }

                int fileLengthInBytes = ToInteger(fileHeader, 24, ByteOrder.BigEndian) * 2;

                int version = ToInteger(fileHeader, 28, ByteOrder.LittleEndian);
                if (version != _version)
                {
                    throw new InvalidDataException("Shapefile version " + version + " is not supported.  Only version " + _version + " is supported.");
                }

                _shapeType = (ShapeType)ToInteger(fileHeader, 32, ByteOrder.LittleEndian);

                double xMin = ToDouble(fileHeader, 36, ByteOrder.LittleEndian);
                double yMin = ToDouble(fileHeader, 44, ByteOrder.LittleEndian);
                double xMax = ToDouble(fileHeader, 52, ByteOrder.LittleEndian);
                double yMax = ToDouble(fileHeader, 60, ByteOrder.LittleEndian);
                
                if (fileLengthInBytes == _fileHeaderLength)
                {
                    //
                    // If the shapefile is empty (that is, has no records), 
                    // the values for xMin, yMin, xMax, and yMax are unspecified.
                    //
                    // I like zero better.
                    //
                    xMin = 0.0;
                    yMin = 0.0;
                    xMax = 0.0;
                    yMax = 0.0;
                }

                _extent = new CartographicExtent(xMin, yMin, xMax, yMax);

                //
                // Read each header...
                //

                //
                // Record Header:
                //
                // Position  Field           Value           Type     Byte Order
                // --------  -----           -----           ----     ----------
                // Byte 0    Record Number   Record Number   Integer  Big
                // Byte 4    Content Length  Content Length  Integer  Big
                //
                _shapes = new List<Shape>();
                byte[] recordHeader;

                string dBaseFilepath = Path.ChangeExtension(filename, "dbf");
                DataTable metadataTable = ParseDBF.ReadDBF(dBaseFilepath);
                
                while ((recordHeader = Read(fs, _recordHeaderLength)) != null)
                {
                    int recordNumber = ToInteger(recordHeader, 0, ByteOrder.BigEndian);
                    int contextLengthInBytes = ToInteger(recordHeader, 4, ByteOrder.BigEndian) * 2;
                    byte[] record = Read(fs, contextLengthInBytes);
                    int mOffset, zOffset;

                    StringDictionary metadata = new StringDictionary();
                    foreach (DataColumn column in metadataTable.Columns)
                    {
                        metadata.Add(column.ColumnName, Convert.ToString(metadataTable.Rows[recordNumber - 1][column]).Trim());
                    }

                    ShapeType recordShapeType = (ShapeType)ToInteger(record, 0, ByteOrder.LittleEndian);
                    switch (recordShapeType)
                    {
                        case ShapeType.NullShape:
                            //
                            // Filter out null shapes.  Otherwise, every client
                            // would have to deal with them.
                            //
                            break;

                        case ShapeType.Point:
                            double x = ToDouble(record, 4, ByteOrder.LittleEndian);
                            double y = ToDouble(record, 12, ByteOrder.LittleEndian);
                            Cartographic position = new Cartographic(x, y, 0.0);
                            _shapes.Add(new PointShape(recordNumber, metadata, position));
                            break;

                        case ShapeType.PointM:
                             x = ToDouble(record, 4, ByteOrder.LittleEndian);
                             y = ToDouble(record, 12, ByteOrder.LittleEndian);
                             position = new Cartographic(x, y, 0.0);
                             double measure = ToDouble(record, 20, ByteOrder.LittleEndian);
                             _shapes.Add(new PointMShape(recordNumber, metadata, position, measure));
                             break;

                        case ShapeType.PointZ:
                            x = ToDouble(record, 4, ByteOrder.LittleEndian);
                            y = ToDouble(record, 12, ByteOrder.LittleEndian);
                            double z = ToDouble(record, 20, ByteOrder.LittleEndian);
                            position = new Cartographic(x, y, z);
                            measure = ToDouble(record, 28, ByteOrder.LittleEndian);
                            _shapes.Add(new PointZShape(recordNumber, metadata, position, measure));
                            break;

                        case ShapeType.MultiPoint:
                        case ShapeType.MultiPointM:
                        case ShapeType.MultiPointZ:
                            CartographicExtent extent = new CartographicExtent(
                                ToDouble(record, 4, ByteOrder.LittleEndian),
                                ToDouble(record, 12, ByteOrder.LittleEndian),
                                ToDouble(record, 20, ByteOrder.LittleEndian),
                                ToDouble(record, 28, ByteOrder.LittleEndian));

                            int numberOfPoints = ToInteger(record, 36, ByteOrder.LittleEndian);
                            Cartographic[] points = new Cartographic[numberOfPoints];
                            for (int i = 0; i < numberOfPoints; ++i)
                            {
                                points[i] = new Cartographic(
                                    ToDouble(record, 40 + (16 * i), ByteOrder.LittleEndian),
                                    ToDouble(record, 40 + (16 * i) + 8, ByteOrder.LittleEndian),
                                    0.0);
                            }

                            if (recordShapeType == ShapeType.MultiPoint)
                            {
                                _shapes.Add(new MultiPointShape(recordNumber, metadata, extent, points));
                            }
                            else
                            {
                                mOffset = 40 + (16 * numberOfPoints);
                                zOffset = 40 + (16 * numberOfPoints);
                                if (recordShapeType == ShapeType.MultiPointZ)
                                {
                                    mOffset = zOffset + 16 + (8 * numberOfPoints);
                                }

                                double mMin = ToDouble(record, mOffset, ByteOrder.LittleEndian);
                                double mMax = ToDouble(record, mOffset + 8, ByteOrder.LittleEndian);
                                double[] measures = new double[numberOfPoints];
                                for (int i = 0; i < numberOfPoints; i++)
                                {
                                    measures[i] = ToDouble(record, mOffset + 16 + (8 * i), ByteOrder.LittleEndian);
                                }

                                if (recordShapeType == ShapeType.MultiPointM)
                                {
                                    _shapes.Add(new MultiPointMShape(recordNumber, metadata, extent, points, mMin, mMax, measures));
                                }
                                else
                                {
                                    double zMin = ToDouble(record, zOffset, ByteOrder.LittleEndian);
                                    double zMax = ToDouble(record, zOffset + 8, ByteOrder.LittleEndian);
                                    double[] zValues = new double[numberOfPoints];
                                    for (int i = 0; i < numberOfPoints; i++)
                                    {
                                        x = points[i].Longitude;
                                        y = points[i].Latitude;
                                        z = ToDouble(record, zOffset + 16 + (8 * i), ByteOrder.LittleEndian);
                                        points[i] = new Cartographic(x, y, z);
                                    }
                                    _shapes.Add(new MultiPointZShape(recordNumber, metadata, extent, points, zMin, zMax, mMin, mMax, measures));
                                }
                            }

                            break;

                        case ShapeType.Polyline:
                        case ShapeType.PolylineM:
                        case ShapeType.PolylineZ:
                        case ShapeType.Polygon:
                        case ShapeType.PolygonM:
                        case ShapeType.PolygonZ:
                        case ShapeType.MultiPatch:
                            extent = new CartographicExtent(
                                ToDouble(record, 4, ByteOrder.LittleEndian),
                                ToDouble(record, 12, ByteOrder.LittleEndian),
                                ToDouble(record, 20, ByteOrder.LittleEndian),
                                ToDouble(record, 28, ByteOrder.LittleEndian));
                            int numberOfParts = ToInteger(record, 36, ByteOrder.LittleEndian);
                            numberOfPoints = ToInteger(record, 40, ByteOrder.LittleEndian);

                            int[] parts = new int[numberOfParts];
                            Rectangular[] positions = new Rectangular[numberOfPoints];

                            //
                            // These two loops can be optimized if the machine is little endian.
                            //
                            for (int i = 0; i < numberOfParts; ++i)
                            {
                                parts[i] = ToInteger(record, 44 + (4 * i), ByteOrder.LittleEndian);
                            }

                            int pointOffset = 44 + (4 * numberOfParts);
                            int partTypeOffset = 44 + (4 * numberOfParts);
                            if (recordShapeType == ShapeType.MultiPatch)
                            {
                                pointOffset = partTypeOffset + (4 * numberOfParts);
                            }

                            for (int i = 0; i < numberOfPoints; ++i)
                            {
                                positions[i] = new Rectangular(
                                    ToDouble(record, pointOffset + (16 * i), ByteOrder.LittleEndian),
                                    ToDouble(record, pointOffset + (16 * i) + 8, ByteOrder.LittleEndian));
                            }

                            if (recordShapeType == ShapeType.Polyline)
                            {
                                _shapes.Add(new PolylineShape(recordNumber, metadata, extent, parts, positions));
                            }
                            else if (recordShapeType == ShapeType.Polygon)
                            {
                                _shapes.Add(new PolygonShape(recordNumber, metadata, extent, parts, positions));
                            }
                            else
                            {
                                mOffset = pointOffset + (16 * numberOfPoints);
                                zOffset = pointOffset + (16 * numberOfPoints);
                                if (recordShapeType == ShapeType.PolylineZ || recordShapeType == ShapeType.PolygonZ || recordShapeType == ShapeType.MultiPatch)
                                {
                                    mOffset = zOffset + 16 + (8 * numberOfPoints);
                                }

                                double mMin = ToDouble(record, mOffset, ByteOrder.LittleEndian);
                                double mMax = ToDouble(record, mOffset + 8, ByteOrder.LittleEndian);
                                double[] measures = new double[numberOfPoints];
                                for (int i = 0; i < numberOfPoints; i++)
                                {
                                    measures[i] = ToDouble(record, mOffset + 16 + (8 * i), ByteOrder.LittleEndian);
                                }

                                if (recordShapeType == ShapeType.PolylineM)
                                {
                                    _shapes.Add(new PolylineMShape(recordNumber, metadata, extent, parts, positions, mMin, mMax, measures));
                                }
                                else if (recordShapeType == ShapeType.PolygonM)
                                {
                                    _shapes.Add(new PolygonMShape(recordNumber, metadata, extent, parts, positions, mMin, mMax, measures));
                                }
                                else
                                {
                                    double zMin = ToDouble(record, zOffset, ByteOrder.LittleEndian);
                                    double zMax = ToDouble(record, zOffset + 8, ByteOrder.LittleEndian);
                                    double[] zValues = new double[numberOfPoints];
                                    for (int i = 0; i < numberOfPoints; i++)
                                    {
                                        zValues[i] = ToDouble(record, zOffset + 16 + (8 * i), ByteOrder.LittleEndian);
                                    }

                                    if (recordShapeType == ShapeType.PolylineZ)
                                    {
                                        _shapes.Add(new PolylineZShape(recordNumber, metadata, extent, parts, positions, zMin, zMax, zValues, mMin, mMax, measures));
                                    }
                                    else if (recordShapeType == ShapeType.PolygonZ)
                                    {
                                        _shapes.Add(new PolygonZShape(recordNumber, metadata, extent, parts, positions, zMin, zMax, zValues, mMin, mMax, measures));
                                    }
                                    else
                                    {
                                        MultiPatchPartType[] partTypes = new MultiPatchPartType[numberOfParts];
                                        for (int i = 0; i < numberOfParts; i++)
                                        {
                                            partTypes[i] = (MultiPatchPartType)ToInteger(record, partTypeOffset + (4 * i), ByteOrder.LittleEndian);
                                        }
                                        _shapes.Add(new MultiPatchShape(recordNumber, metadata, extent, parts, partTypes, positions, zMin, zMax, zValues, mMin, mMax, measures));
                                    }
                                }
                            }

                            break;

                        default:
                            throw new NotImplementedException("The shapefile type is not supported.  Only null, point, polyline, and polygon are supported.");
                    }
                }
            }
        }

        private int ToInteger(byte[] buffer, int offset, ByteOrder byteOrder)
        {
            if (byteOrder == _byteOrder)
            {
                return BitConverter.ToInt32(buffer, offset);
            }

            byte[] swapped = new byte[4];
            swapped[0] = buffer[offset + 3];
            swapped[1] = buffer[offset + 2];
            swapped[2] = buffer[offset + 1];
            swapped[3] = buffer[offset];

            return BitConverter.ToInt32(swapped, 0);
        }

        private double ToDouble(byte[] buffer, int offset, ByteOrder byteOrder)
        {
            if (byteOrder == _byteOrder)
            {
                return BitConverter.ToDouble(buffer, offset);
            }

            byte[] swapped = new byte[4];
            swapped[0] = buffer[offset + 7];
            swapped[1] = buffer[offset + 6];
            swapped[2] = buffer[offset + 5];
            swapped[3] = buffer[offset + 4];
            swapped[4] = buffer[offset + 3];
            swapped[5] = buffer[offset + 2];
            swapped[6] = buffer[offset + 1];
            swapped[7] = buffer[offset];

            return BitConverter.ToDouble(swapped, 0);
        }

        private static byte[] Read(FileStream fileStream, int count)
        {
            byte[] buffer = new byte[count];

            int bytesRemaining = count;
            int offset = 0;

            while (bytesRemaining > 0)
            {
                int bytesRead = fileStream.Read(buffer, offset, bytesRemaining);
                if (bytesRead <= 0)
                {
                    return null;
                }

                offset += bytesRead;
                bytesRemaining -= bytesRead;
            }

            return (bytesRemaining == 0) ? buffer : null;
        }

        public ShapeType ShapeType
        {
            get { return _shapeType; }
        }

        public CartographicExtent Extent
        {
            get { return _extent; }
        }

        public Shape this[int index]
        {
            get { return _shapes[index]; }
        }

        public int Count
        {
            get { return _shapes.Count; }
        }

        public IEnumerator GetEnumerator()
        {
            return _shapes.GetEnumerator();
        }

        private enum ByteOrder
        {
            LittleEndian,
            BigEndian
        }

        private readonly ByteOrder _byteOrder;
        private readonly ShapeType _shapeType;
        private readonly CartographicExtent _extent;

        private readonly IList<Shape> _shapes;

        private const int _fileHeaderLength = 100;
        private const int _fileCode = 9994;
        private const int _version = 1000;
        private const int _recordHeaderLength = 8;
    }
}
