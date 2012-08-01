using System;
using System.Collections;
using System.Data;
using System.IO;
using System.Runtime.InteropServices;
using System.Text;
using System.Windows.Forms;

// Read an entire standard DBF file into a DataTable
public class ParseDBF
{
    // This is the file header for a DBF. We do this special layout with everything
    // packed so we can read straight from disk into the structure to populate it
    [StructLayout(LayoutKind.Sequential, CharSet = CharSet.Ansi, Pack = 1)]
    private struct DBFHeader
    {
        public byte version;
        public byte updateYear;
        public byte updateMonth;
        public byte updateDay;
        public Int32 numRecords;
        public Int16 headerLen;
        public Int16 recordLen;
        public Int16 reserved1;
        public byte incompleteTrans;
        public byte encryptionFlag;
        public Int32 reserved2;
        public Int64 reserved3;
        public byte MDX;
        public byte language;
        public Int16 reserved4;
    }

    // This is the field descriptor structure. There will be one of these for each column in the table.
    [StructLayout(LayoutKind.Sequential, CharSet = CharSet.Ansi, Pack = 1)]
    private struct FieldDescriptor
    {
        [MarshalAs(UnmanagedType.ByValTStr, SizeConst = 11)]
        public string fieldName;
        public char fieldType;
        public Int32 address;
        public byte fieldLen;
        public byte count;
        public Int16 reserved1;
        public byte workArea;
        public Int16 reserved2;
        public byte flag;
        [MarshalAs(UnmanagedType.ByValArray, SizeConst = 7)]
        public byte[] reserved3;
        public byte indexFlag;
    }

    // Read an entire standard DBF file into a DataTable
    public static DataTable ReadDBF(string dbfFile)
    {
		long start = DateTime.Now.Ticks;
        DataTable dt = new DataTable();
		BinaryReader recReader;
		string number;
		string year;
		string month;
		string day;
		long lDate;
		long lTime;
		DataRow row;
		int	fieldIndex;

        // If there isn't even a file, just return an empty DataTable
        if ((false == File.Exists(dbfFile)))
        {
            return dt;
        }

        BinaryReader br = null;
        try
        {
            // Read the header into a buffer
            br = new BinaryReader(File.OpenRead(dbfFile));
            byte[] buffer = br.ReadBytes(Marshal.SizeOf(typeof(DBFHeader)));

            // Marshall the header into a DBFHeader structure
            GCHandle handle = GCHandle.Alloc(buffer, GCHandleType.Pinned);
            DBFHeader header = (DBFHeader) Marshal.PtrToStructure(handle.AddrOfPinnedObject(), typeof(DBFHeader));
            handle.Free();

            // Read in all the field descriptors. Per the spec, 13 (0D) marks the end of the field descriptors
            ArrayList fields = new ArrayList();
            while ((13 != br.PeekChar()))
            {
                buffer = br.ReadBytes(Marshal.SizeOf(typeof(FieldDescriptor)));
                handle = GCHandle.Alloc(buffer, GCHandleType.Pinned);
                fields.Add((FieldDescriptor)Marshal.PtrToStructure(handle.AddrOfPinnedObject(), typeof(FieldDescriptor)));
                handle.Free();
            }

			// Read in the first row of records, we need this to help determine column types below
			((FileStream) br.BaseStream).Seek(header.headerLen + 1, SeekOrigin.Begin);
			buffer = br.ReadBytes(header.recordLen);
			recReader = new BinaryReader(new MemoryStream(buffer));

            // Create the columns in our new DataTable
            DataColumn col = null;
            foreach (FieldDescriptor field in fields)
            {
				number = Encoding.ASCII.GetString(recReader.ReadBytes(field.fieldLen));
                switch (field.fieldType)
                {
					case 'N':
						if (number.IndexOf(".") > -1)
						{
							col = new DataColumn(field.fieldName, typeof(decimal));
						}
						else
						{
							col = new DataColumn(field.fieldName, typeof(int));
						}
						break;
					case 'C':
						col = new DataColumn(field.fieldName, typeof(string));
						break;
					case 'T':
						// You can uncomment this to see the time component in the grid
						//col = new DataColumn(field.fieldName, typeof(string));
						col = new DataColumn(field.fieldName, typeof(DateTime));
						break;
					case 'D':
						col = new DataColumn(field.fieldName, typeof(DateTime));
						break;
					case 'L':
						col = new DataColumn(field.fieldName, typeof(bool));
						break;
					case 'F':
						col = new DataColumn(field.fieldName, typeof(Double));
						break;
                }
                dt.Columns.Add(col);
            }

			// Skip past the end of the header. 
			((FileStream) br.BaseStream).Seek(header.headerLen, SeekOrigin.Begin);

            // Read in all the records
            for (int counter = 0; counter <= header.numRecords - 1; counter++)
            {
                // First we'll read the entire record into a buffer and then read each field from the buffer
                // This helps account for any extra space at the end of each record and probably performs better
                buffer = br.ReadBytes(header.recordLen);
                recReader = new BinaryReader(new MemoryStream(buffer));

				// All dbf field records begin with a deleted flag field. Deleted - 0x2A (asterisk) else 0x20 (space)
				if (recReader.ReadChar() == '*')
				{
					continue;
				}

                // Loop through each field in a record
				fieldIndex = 0;
                row = dt.NewRow();
                foreach (FieldDescriptor field in fields)
                {
                    switch (field.fieldType)
                    {
						case 'N':  // Number
							// If you port this to .NET 2.0, use the Decimal.TryParse method
							number = Encoding.ASCII.GetString(recReader.ReadBytes(field.fieldLen));
							if (IsNumber(number))
							{
								if (number.IndexOf(".") > -1)
								{
									row[fieldIndex] = decimal.Parse(number);
								}
								else
								{
									row[fieldIndex] = int.Parse(number);
								}
							}
							else
							{
								row[fieldIndex] = 0;
							}

							break;

						case 'C': // String
							row[fieldIndex] = Encoding.ASCII.GetString(recReader.ReadBytes(field.fieldLen));
							break;

						case 'D': // Date (YYYYMMDD)
							year = Encoding.ASCII.GetString(recReader.ReadBytes(4));
							month = Encoding.ASCII.GetString(recReader.ReadBytes(2));
							day = Encoding.ASCII.GetString(recReader.ReadBytes(2));
							row[fieldIndex] = System.DBNull.Value;
							try
							{
								if (IsNumber(year) && IsNumber(month) && IsNumber(day))
								{
									if ((Int32.Parse(year) > 1900))
									{
										row[fieldIndex] = new DateTime(Int32.Parse(year), Int32.Parse(month), Int32.Parse(day));
									}
								}
							}
							catch
							{}

							break;

						case 'T': // Timestamp, 8 bytes - two integers, first for date, second for time
							// Date is the number of days since 01/01/4713 BC (Julian Days)
							// Time is hours * 3600000L + minutes * 60000L + Seconds * 1000L (Milliseconds since midnight)
							lDate = recReader.ReadInt32();
							lTime = recReader.ReadInt32() * 10000L;
							row[fieldIndex] = JulianToDateTime(lDate).AddTicks(lTime);
							break;

						case 'L': // Boolean (Y/N)
							if ('Y' == recReader.ReadByte())
							{
								row[fieldIndex] = true;
							}
							else
							{
								row[fieldIndex] = false;
							}

							break;

						case 'F':
							number = Encoding.ASCII.GetString(recReader.ReadBytes(field.fieldLen));
							if (IsNumber(number))
							{
								row[fieldIndex] = double.Parse(number);
							}
							else 
							{
								row[fieldIndex] = 0.0F;
							}
							break;
                    }
					fieldIndex++;
                }

                recReader.Close();
                dt.Rows.Add(row);
            }
        }

        catch
        {
			throw;
        }
        finally
        {
			if (null != br)
			{
				br.Close();
			}
        }

		long count = DateTime.Now.Ticks - start;

        return dt;
    }

	/// <summary>
	/// Simple function to test is a string can be parsed. There may be a better way, but this works
	/// If you port this to .NET 2.0, use the new TryParse methods instead of this
	///   *Thanks to wu.qingman on code project for fixing a bug in this for me
	/// </summary>
	/// <param name="number">string to test for parsing</param>
	/// <returns>true if string can be parsed</returns>
	public static bool IsNumber(string numberString)
	{
		char[] numbers = numberString.ToCharArray();
		int number_count = 0;
		int point_count = 0;
		int space_count = 0;

		foreach (char number in numbers)
		{
			if ((number >= 48 && number <= 57))
			{
				number_count += 1;
			} 
			else if (number == 46) 
			{
				point_count += 1;
			}
			else if (number == 32) 
			{
				space_count += 1;
			}
			else 
			{
				return false;
			}
		}

		return (number_count > 0 && point_count < 2);
	}

	/// <summary>
	/// Convert a Julian Date to a .NET DateTime structure
	/// Implemented from pseudo code at http://en.wikipedia.org/wiki/Julian_day
	/// </summary>
	/// <param name="lJDN">Julian Date to convert (days since 01/01/4713 BC)</param>
	/// <returns>DateTime</returns>
	private static DateTime JulianToDateTime(long lJDN)
	{
		double p = Convert.ToDouble(lJDN);
		double s1 = p + 68569;
		double n = Math.Floor(4 * s1 / 146097);
		double s2 = s1 - Math.Floor((146097*n + 3) / 4);
		double i = Math.Floor(4000 * (s2 + 1) / 1461001);
		double s3 = s2 - Math.Floor(1461*i/4) + 31;
		double q = Math.Floor(80 * s3 / 2447);
		double d = s3 - Math.Floor(2447 * q / 80);
		double s4 = Math.Floor(q / 11);
		double m = q + 2 - 12 * s4;
		double j = 100 * (n - 49) + i + s4;
		return new DateTime(Convert.ToInt32(j), Convert.ToInt32(m), Convert.ToInt32(d));
	}

}