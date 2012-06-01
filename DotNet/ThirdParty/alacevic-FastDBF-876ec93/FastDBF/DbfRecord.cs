using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Text;
using System.Linq;

namespace SocialExplorer.IO.FastDBF
{
	/// <summary>
	/// Use this class to create a record and write it to a dbf file. You can use one record object to write all records!!
	/// It was designed for this kind of use. You can do this by clearing the record of all data 
	/// (call Clear() method) or setting values to all fields again, then write to dbf file. 
	/// This eliminates creating and destroying objects and optimizes memory use.
	/// 
	/// Once you create a record the header can no longer be modified, since modifying the header would make a corrupt DBF file.
	/// </summary>
	public class DbfRecord
	{
		//array used to clear decimals, we can clear up to 40 decimals which is much more than is allowed under DBF spec anyway.
		private static readonly byte[] mDecimalClear = Enumerable.Repeat((byte)'0', 45).ToArray();
		private readonly Encoding encoding = Encoding.Default;

		/// <summary>
		/// Dbf data are a mix of ASCII characters and binary, which neatly fit in a byte array.
		/// BinaryWriter would esentially perform the same conversion using the same Encoding class.
		/// </summary>
		private readonly byte[] mData;

		/// <summary>
		/// Empty Record array reference used to clear fields quickly (or entire record).
		/// </summary>
		private readonly byte[] mEmptyRecord;

		/// <summary>
		/// Header provides information on all field types, sizes, precision and other useful information about the DBF.
		/// </summary>
		private readonly DbfHeader mHeader;
		private readonly int[] mTempIntVal = {0};

		/// <summary>
		/// Specifies whether we allow the decimal portion of numbers to be truncated. 
		/// If false and decimal digits overflow the field, an exception is thrown.
		/// </summary>
		private bool mAllowDecimalTruncate;

		/// <summary>
		/// Specifies whether we allow the integer portion of numbers to be truncated.
		/// If false and integer digits overflow the field, an exception is thrown.
		/// </summary>
		private bool mAllowIntegerTruncate;

		/// <summary>
		/// Specifies whether we allow strings to be truncated. If false and string is longer than we can fit in the field, an exception is thrown.
		/// </summary>
		private bool mAllowStringTruncate = true;

		/// <summary>
		/// Zero based record index. -1 when not set, new records for example.
		/// </summary>
		private int mRecordIndex = -1;

		/// <summary>
		/// Column Name to Column Index map
		/// </summary>
		private readonly Dictionary<string, int> mColNameToConIdx = new Dictionary<string, int>(StringComparer.InvariantCulture);

		/// <summary>
		/// 
		/// </summary>
		/// <param name="oHeader">Dbf Header will be locked once a record is created 
		/// since the record size is fixed and if the header was modified it would corrupt the DBF file.</param>
		public DbfRecord(DbfHeader oHeader)
		{
			mHeader = oHeader;
			mHeader.Locked = true;

			//create a buffer to hold all record data. We will reuse this buffer to write all data to the file.
			mData = new byte[mHeader.RecordLength];
			mEmptyRecord = mHeader.EmptyDataRecord;
			encoding = oHeader.encoding;

			for (int i = 0; i < oHeader.mFields.Count; i++)
				mColNameToConIdx[oHeader.mFields[i].Name] = i;
		}

		/// <summary>
		/// Set string data to a column, if the string is longer than specified column length it will be truncated!
		/// If dbf column type is not a string, input will be treated as dbf column 
		/// type and if longer than length an exception will be thrown.
		/// </summary>
		/// <param name="nColIndex"></param>
		/// <returns></returns>
		public string this[int nColIndex]
		{
			set
			{
				DbfColumn ocol = mHeader[nColIndex];
				DbfColumn.DbfColumnType ocolType = ocol.ColumnType;

				//
				//if an empty value is passed, we just clear the data, and leave it blank.
				//note: test have shown that testing for null and checking length is faster than comparing to "" empty str :)
				//------------------------------------------------------------------------------------------------------------
				if (string.IsNullOrEmpty(value))
				{
					//this is like NULL data, set it to empty. i looked at SAS DBF output when a null value exists 
					//and empty data are output. we get the same result, so this looks good.
					Buffer.BlockCopy(mEmptyRecord, ocol.DataAddress, mData, ocol.DataAddress, ocol.Length);
				}
				else
				{
					//set values according to data type:
					//-------------------------------------------------------------
					if (ocolType == DbfColumn.DbfColumnType.Character)
					{
						if (!mAllowStringTruncate && value.Length > ocol.Length)
							throw new DbfDataTruncateException("Value not set. string truncation would occur and AllowStringTruncate flag is set to false. To supress this exception change AllowStringTruncate to true.");

						//BlockCopy copies bytes.  First clear the previous value, then set the new one.
						Buffer.BlockCopy(mEmptyRecord, ocol.DataAddress, mData, ocol.DataAddress, ocol.Length);
						encoding.GetBytes(value, 0, value.Length > ocol.Length ? ocol.Length : value.Length, mData, ocol.DataAddress);
					}
					else if (ocolType == DbfColumn.DbfColumnType.Number)
					{
						if (ocol.DecimalCount == 0)
						{
							//integers
							//----------------------------------

							//throw an exception if integer overflow would occur
							if (!mAllowIntegerTruncate && value.Length > ocol.Length)
								throw new DbfDataTruncateException("Value not set. Integer does not fit and would be truncated. AllowIntegerTruncate is set to false. To supress this exception set AllowIntegerTruncate to true, although that is not recomended.");

							//clear all numbers, set to [space].
							//-----------------------------------------------------
							Buffer.BlockCopy(mEmptyRecord, 0, mData, ocol.DataAddress, ocol.Length);

							//set integer part, CAREFUL not to overflow buffer! (truncate instead)
							//-----------------------------------------------------------------------
							int nNumLen = value.Length > ocol.Length ? ocol.Length : value.Length;
							encoding.GetBytes(value, 0, nNumLen, mData, (ocol.DataAddress + ocol.Length - nNumLen));
						}
						else
						{
							//TODO: we can improve perfomance here by not using temp char arrays cDec and cNum, simply direcly copy from source string using AsciiEncoder!

							//break value down into integer and decimal portions
							//--------------------------------------------------------------------------
							int nidxDecimal = value.IndexOf('.'); //index where the decimal point occurs
							char[] cDec = null; //decimal portion of the number
							char[] cNum = null; //integer portion

							if (nidxDecimal > -1)
							{
								cDec = value.Substring(nidxDecimal + 1).ToCharArray();
								cNum = value.Substring(0, nidxDecimal).ToCharArray();

								//throw an exception if decimal overflow would occur
								if (!mAllowDecimalTruncate && cDec.Length > ocol.DecimalCount)
									throw new DbfDataTruncateException("Value not set. Decimal does not fit and would be truncated. AllowDecimalTruncate is set to false. To supress this exception set AllowDecimalTruncate to true.");
							}
							else
								cNum = value.ToCharArray();

							//throw an exception if integer overflow would occur
							if (!mAllowIntegerTruncate && cNum.Length > ocol.Length - ocol.DecimalCount - 1)
								throw new DbfDataTruncateException("Value not set. Integer does not fit and would be truncated. AllowIntegerTruncate is set to false. To supress this exception set AllowIntegerTruncate to true, although that is not recomended.");

							//clear all decimals, set to 0.
							//-----------------------------------------------------
							Buffer.BlockCopy(mDecimalClear, 0, mData, (ocol.DataAddress + ocol.Length - ocol.DecimalCount), ocol.DecimalCount);

							//clear all numbers, set to [space].
							Buffer.BlockCopy(mEmptyRecord, 0, mData, ocol.DataAddress, (ocol.Length - ocol.DecimalCount));

							//set decimal numbers, CAREFUL not to overflow buffer! (truncate instead)
							//-----------------------------------------------------------------------
							if (nidxDecimal > -1)
							{
								int nLen = cDec.Length > ocol.DecimalCount ? ocol.DecimalCount : cDec.Length;
								encoding.GetBytes(cDec, 0, nLen, mData, (ocol.DataAddress + ocol.Length - ocol.DecimalCount));
							}

							//set integer part, CAREFUL not to overflow buffer! (truncate instead)
							//-----------------------------------------------------------------------
							int nNumLen = cNum.Length > ocol.Length - ocol.DecimalCount - 1 ? (ocol.Length - ocol.DecimalCount - 1) : cNum.Length;
							encoding.GetBytes(cNum, 0, nNumLen, mData, ocol.DataAddress + ocol.Length - ocol.DecimalCount - nNumLen - 1);

							//set decimal point
							//-----------------------------------------------------------------------
							mData[ocol.DataAddress + ocol.Length - ocol.DecimalCount - 1] = (byte)'.';
						}
					}
					else if (ocolType == DbfColumn.DbfColumnType.Integer)
					{
						//note this is a binary Integer type!
						//----------------------------------------------

						//TODO: maybe there is a better way to copy 4 bytes from int to byte array. Some memory function or something.
						mTempIntVal[0] = Convert.ToInt32(value);
						Buffer.BlockCopy(mTempIntVal, 0, mData, ocol.DataAddress, 4);
					}
					else if (ocolType == DbfColumn.DbfColumnType.Memo)
					{
						//copy 10 digits...
						//TODO: implement MEMO
						throw new NotImplementedException("Memo data type functionality not implemented yet!");
					}
					else if (ocolType == DbfColumn.DbfColumnType.Boolean)
					{
						if (string.Compare(value, "true", true) == 0 || string.Compare(value, "1", true) == 0 ||
						    string.Compare(value, "T", true) == 0 || string.Compare(value, "yes", true) == 0 ||
						    string.Compare(value, "Y", true) == 0)
							mData[ocol.DataAddress] = (byte)'T';
						else if (value == " " || value == "?")
							mData[ocol.DataAddress] = (byte)'?';
						else
							mData[ocol.DataAddress] = (byte)'F';
					}
					else if (ocolType == DbfColumn.DbfColumnType.Date)
					{
						//try to parse out date value using Date.Parse() function, then set the value
						DateTime dateval;
						if (DateTime.TryParse(value, out dateval))
							SetDateValue(nColIndex, dateval);
						else
							throw new InvalidOperationException("Date could not be parsed from source string! Please parse the Date and set the value (you can try using DateTime.Parse() or DateTime.TryParse() functions).");
					}
					else if (ocolType == DbfColumn.DbfColumnType.Binary)
						throw new InvalidOperationException("Can not use string source to set binary data. Use SetBinaryValue() and GetBinaryValue() functions instead.");
					else
						throw new InvalidDataException("Unrecognized data type: " + ocolType.ToString());
				}
			}

			get
			{
				DbfColumn ocol = mHeader[nColIndex];
				return new string(encoding.GetChars(mData, ocol.DataAddress, ocol.Length));
			}
		}

		
		/// <summary>
		/// Set string data to a column, if the string is longer than specified column length it will be truncated!
		/// If dbf column type is not a string, input will be treated as dbf column 
		/// type and if longer than length an exception will be thrown.
		/// </summary>
		/// <param name="nColName"></param>
		/// <returns></returns>
		public string this[string nColName]
		{
			get
			{
				if (mColNameToConIdx.ContainsKey(nColName))
					return this[mColNameToConIdx[nColName]];
				throw new InvalidOperationException(string.Format("There's no column with name '{0}'", nColName));
			}
			set
			{
				if (mColNameToConIdx.ContainsKey(nColName))
					this[mColNameToConIdx[nColName]] = value;
				else
					throw new InvalidOperationException(string.Format("There's no column with name '{0}'", nColName));
			}
		}


		/// <summary>
		/// Gets/sets a zero based record index. This information is not directly stored in DBF. 
		/// It is the location of this record within the DBF. 
		/// </summary>
		/// <remarks>
		/// This property is managed from outside this object,
		/// CDbfFile object updates it when records are read. The reason we don't set it in the Read() 
		/// function within this object is that the stream can be forward-only so the Position property 
		/// is not available and there is no way to figure out what index the record was unless you 
		/// count how many records were read, and that's exactly what CDbfFile does.
		/// </remarks>
		public int RecordIndex { get { return mRecordIndex; } set { mRecordIndex = value; } }

		/// <summary>
		/// Returns/sets flag indicating whether this record was tagged deleted. 
		/// </summary>
		/// <remarks>Use CDbf4File.Compress() function to rewrite dbf removing records flagged as deleted.</remarks>
		/// <seealso cref="CDbf4File.Compress() function"/>
		public bool IsDeleted
		{
			get { return mData[0] == '*'; }
			set { mData[0] = value ? (byte)'*' : (byte)' '; }
		}

		/// <summary>
		/// Specifies whether strings can be truncated. If false and string is longer than can fit in the field, an exception is thrown.
		/// Default is True.
		/// </summary>
		public bool AllowStringTurncate { get { return mAllowStringTruncate; } set { mAllowStringTruncate = value; } }

		/// <summary>
		/// Specifies whether to allow the decimal portion of numbers to be truncated. 
		/// If false and decimal digits overflow the field, an exception is thrown. Default is false.
		/// </summary>
		public bool AllowDecimalTruncate { get { return mAllowDecimalTruncate; } set { mAllowDecimalTruncate = value; } }

		/// <summary>
		/// Specifies whether integer portion of numbers can be truncated.
		/// If false and integer digits overflow the field, an exception is thrown. 
		/// Default is False.
		/// </summary>
		public bool AllowIntegerTruncate { get { return mAllowIntegerTruncate; } set { mAllowIntegerTruncate = value; } }

		/// <summary>
		/// Returns header object associated with this record.
		/// </summary>
		public DbfHeader Header { get { return mHeader; } }

		/// <summary>
		/// Gets column count from header.
		/// </summary>
		public int ColumnCount { get { return mHeader.ColumnCount; } }

		/// <summary>
		/// Get date value.
		/// </summary>
		/// <param name="nColIndex"></param>
		/// <returns></returns>
		public DateTime GetDateValue(int nColIndex)
		{
			DbfColumn ocol = mHeader[nColIndex];
			if (ocol.ColumnType == DbfColumn.DbfColumnType.Date)
			{
				string sDateVal = encoding.GetString(mData, ocol.DataAddress, ocol.Length);
				return DateTime.ParseExact(sDateVal, "yyyyMMdd", CultureInfo.InvariantCulture);
			}
			throw new InvalidDataException("Invalid data type. Column '" + ocol.Name + "' is not a date column.");
		}

		/// <summary>
		/// Get date value.
		/// </summary>
		/// <param name="nColIndex"></param>
		/// <returns></returns>
		public void SetDateValue(int nColIndex, DateTime value)
		{
			DbfColumn ocol = mHeader[nColIndex];
			DbfColumn.DbfColumnType ocolType = ocol.ColumnType;

			if (ocolType == DbfColumn.DbfColumnType.Date)
			{
				//Format date and set value, date format is like this: yyyyMMdd
				//-------------------------------------------------------------
				encoding.GetBytes(value.ToString("yyyyMMdd"), 0, ocol.Length, mData, ocol.DataAddress);
			}
			else
				throw new Exception("Invalid data type. Column is of '" + ocol.ColumnType.ToString() + "' type, not date.");
		}

		/// <summary>
		/// Clears all data in the record.
		/// </summary>
		public void Clear()
		{
			Buffer.BlockCopy(mEmptyRecord, 0, mData, 0, mEmptyRecord.Length);
			mRecordIndex = -1;
		}

		/// <summary>
		/// returns a string representation of this record.
		/// </summary>
		/// <returns></returns>
		public override string ToString()
		{
			return new string(encoding.GetChars(mData));
		}

		/// <summary>
		/// Get column by index.
		/// </summary>
		/// <param name="index"></param>
		/// <returns></returns>
		public DbfColumn Column(int index)
		{
			return mHeader[index];
		}

		/// <summary>
		/// Get column by name.
		/// </summary>
		/// <param name="index"></param>
		/// <returns></returns>
		public DbfColumn Column(string sName)
		{
			return mHeader[sName];
		}

		/// <summary>
		/// Finds a column index by searching sequentially through the list. Case is ignored. Returns -1 if not found.
		/// </summary>
		/// <param name="sName">Column name.</param>
		/// <returns>Column index (0 based) or -1 if not found.</returns>
		public int FindColumn(string sName)
		{
			return mHeader.FindColumn(sName);
		}

		/// <summary>
		/// Writes data to stream. Make sure stream is positioned correctly because we simply write out the data to it.
		/// </summary>
		/// <param name="osw"></param>
		protected internal void Write(Stream osw)
		{
			osw.Write(mData, 0, mData.Length);
		}

		/// <summary>
		/// Writes data to stream. Make sure stream is positioned correctly because we simply write out data to it, and clear the record.
		/// </summary>
		/// <param name="osw"></param>
		protected internal void Write(Stream obw, bool bClearRecordAfterWrite)
		{
			obw.Write(mData, 0, mData.Length);
			if (bClearRecordAfterWrite)
				Clear();
		}

		/// <summary>
		/// Read record from stream. Returns true if record read completely, otherwise returns false.
		/// </summary>
		/// <param name="obr"></param>
		/// <returns></returns>
		protected internal bool Read(Stream obr)
		{
			return obr.Read(mData, 0, mData.Length) >= mData.Length;
		}
	}
}