using System;
using System.IO;
using System.Text;

namespace SocialExplorer.IO.FastDBF
{
	/// <summary>
	/// This class represents a DBF file. You can create new, open, update and save DBF files using this class and supporting classes.
	/// Also, this class supports reading/writing from/to an internet forward only type of stream!
	/// </summary>
	/// <remarks>
	/// TODO: add end of file byte '0x1A' !!!
	/// We don't relly on that byte at all, and everything works with or without that byte, but it should be there by spec.
	/// </remarks>
	public class DbfFile
	{
		[Obsolete]
		public DbfFile():this(Encoding.Default)
		{
		}

		public DbfFile(Encoding encoding)
		{
			this.encoding = encoding;
			mHeader = new DbfHeader(encoding);
		}

		/// <summary>
		/// Streams to read and write to the DBF file.
		/// </summary>
		protected Stream mDbfFile;
		protected BinaryReader mDbfFileReader;
		protected BinaryWriter mDbfFileWriter;

		/// <summary>
		/// File that was opened, if one was opened at all.
		/// </summary>
		protected string mFileName = "";

		/// <summary>
		/// Helps read/write dbf file header information.
		/// </summary>
		protected DbfHeader mHeader;

		/// <summary>
		/// flag that indicates whether the header was written or not...
		/// </summary>
		protected bool mHeaderWritten;

		/// <summary>
		/// keep these values handy so we don't call functions on every read.
		/// </summary>
		protected bool mIsForwardOnly;
		protected bool mIsReadOnly;

		/// <summary>
		/// Number of records read using ReadNext() methods only. This applies only when we are using a forward-only stream.
		/// mRecordsReadCount is used to keep track of record index. With a seek enabled stream, 
		/// we can always calculate index using stream position.
		/// </summary>
		protected int mRecordsReadCount;

		private Encoding encoding = Encoding.Default;

		/// <summary>
		/// Returns true if we can not write to the DBF file stream.
		/// </summary>
		public bool IsReadOnly { get { return mIsReadOnly; } }

		/// <summary>
		/// Returns true if we can not seek to different locations within the file, such as internet connections.
		/// </summary>
		public bool IsForwardOnly { get { return mIsForwardOnly; } }

		/// <summary>
		/// Returns the name of the filestream.
		/// </summary>
		public string FileName { get { return mFileName; } }

		/// <summary>
		/// Access DBF header with information on columns. Use this object for faster access to header. 
		/// Remove one layer of function calls by saving header reference and using it directly to access columns.
		/// </summary>
		public DbfHeader Header { get { return mHeader; } }

		/// <summary>
		/// Open a DBF from a FileStream. This can be a file or an internet connection stream. Make sure that it is positioned at start of DBF file.
		/// Reading a DBF over the internet we can not determine size of the file, so we support HasMore(), ReadNext() interface. 
		/// RecordCount information in header can not be trusted always, since some packages store 0 there.
		/// </summary>
		/// <param name="ofs"></param>
		public void Open(Stream ofs)
		{
			if (mDbfFile != null)
				Close();

			mDbfFile = ofs;
			mDbfFileReader = null;
			mDbfFileWriter = null;

			if (mDbfFile.CanRead)
				mDbfFileReader = new BinaryReader(mDbfFile, encoding);

			if (mDbfFile.CanWrite)
				mDbfFileWriter = new BinaryWriter(mDbfFile, encoding);

			//reset position
			mRecordsReadCount = 0;

			//assume header is not written
			mHeaderWritten = false;

			//read the header
			if (ofs.CanRead)
			{
				//try to read the header...
				try
				{
					mHeader.Read(mDbfFileReader);
					mHeaderWritten = true;
				}
				catch (EndOfStreamException)
				{
					//could not read header, file is empty
					mHeader = new DbfHeader(encoding);
					mHeaderWritten = false;
				}
			}

			if (mDbfFile != null)
			{
				mIsReadOnly = !mDbfFile.CanWrite;
				mIsForwardOnly = !mDbfFile.CanSeek;
			}
		}

		/// <summary>
		/// Open a DBF file or create a new one.
		/// </summary>
		/// <param name="sPath">Full path to the file.</param>
		/// <param name="mode"></param>
		public void Open(string sPath, FileMode mode)
		{
			mFileName = sPath;
			Open(File.Open(sPath, mode));
		}

		/// <summary>
		/// Creates a new DBF 4 file. If file already exists an exception is thrown. Use Open() function to Open/Create new file with more options.
		/// </summary>
		/// <param name="sPath"></param>
		public void Create(string sPath)
		{
			Open(sPath, FileMode.CreateNew);
			mHeaderWritten = false;
		}

		/// <summary>
		/// Update header info, flush buffers and close streams. You should always call this method when you are done with a DBF file.
		/// </summary>
		public void Close()
		{
			//try to update the header if it has changed
			//------------------------------------------
			if (mHeader.IsDirty)
				WriteHeader();

			//Empty header...
			//--------------------------------
			mHeader = new DbfHeader(encoding);
			mHeaderWritten = false;

			//reset current record index
			//--------------------------------
			mRecordsReadCount = 0;

			//Close streams...
			//--------------------------------
			if (mDbfFileWriter != null)
			{
				mDbfFileWriter.Flush();
				mDbfFileWriter.Close();
			}

			if (mDbfFileReader != null)
				mDbfFileReader.Close();

			if (mDbfFile != null)
				mDbfFile.Close();

			//set streams to null
			//--------------------------------
			mDbfFileReader = null;
			mDbfFileWriter = null;
			mDbfFile = null;
			mFileName = "";
		}

		/// <summary>
		/// Read next record and fill data into parameter oFillRecord. Returns true if a record was read, otherwise false.
		/// </summary>
		/// <param name="oFillRecord"></param>
		/// <returns></returns>
		public bool ReadNext(DbfRecord oFillRecord)
		{
			//check if we can fill this record with data. it must match record size specified by header and number of columns.
			//we are not checking whether it comes from another DBF file or not, we just need the same structure. Allow flexibility but be safe.
			if (oFillRecord.Header != mHeader && (oFillRecord.Header.ColumnCount != mHeader.ColumnCount || oFillRecord.Header.RecordLength != mHeader.RecordLength))
			{
				throw new Exception("Record parameter does not have the same size and number of columns as the " +
									"header specifies, so we are unable to read a record into oFillRecord. " +
									"This is a programming error, have you mixed up DBF file objects?");
			}

			//DBF file reader can be null if stream is not readable...
			if (mDbfFileReader == null)
			{
				throw new Exception("Read stream is null, either you have opened a stream that can not be " +
									"read from (a write-only stream) or you have not opened a stream at all.");
			}

			//read next record...
			bool bRead = oFillRecord.Read(mDbfFile);
			if (bRead)
			{
				if (mIsForwardOnly)
				{
					//zero based index! set before incrementing count.
					oFillRecord.RecordIndex = mRecordsReadCount;
					mRecordsReadCount++;
				}
				else
					oFillRecord.RecordIndex = ((int)((mDbfFile.Position - mHeader.HeaderLength)/mHeader.RecordLength)) - 1;
			}
			return bRead;
		}


		/// <summary>
		/// Tries to read a record and returns a new record object or null if nothing was read.
		/// </summary>
		/// <returns></returns>
		public DbfRecord ReadNext()
		{
			//create a new record and fill it.
			var orec = new DbfRecord(mHeader);
			return ReadNext(orec) ? orec : null;
		}


		/// <summary>
		/// Reads a record specified by index into oFillRecord object. You can use this method 
		/// to read in and process records without creating and discarding record objects.
		/// Note that you should check that your stream is not forward-only! If you have a forward only stream, use ReadNext() functions.
		/// </summary>
		/// <param name="index">Zero based record index.</param>
		/// <param name="oFillRecord">Record object to fill, must have same size and number of fields as thid DBF file header!</param>
		/// <remarks>
		/// <returns>True if read a record was read, otherwise false. If you read end of file false will be returned and oFillRecord will NOT be modified!</returns>
		/// The parameter record (oFillRecord) must match record size specified by the header and number of columns as well.
		/// It does not have to come from the same header, but it must match the structure. We are not going as far as to check size of each field.
		/// The idea is to be flexible but safe. It's a fine balance, these two are almost always at odds.
		/// </remarks>
		public bool Read(int index, DbfRecord oFillRecord)
		{
			//check if we can fill this record with data. it must match record size specified by header and number of columns.
			//we are not checking whether it comes from another DBF file or not, we just need the same structure. Allow flexibility but be safe.
			if (oFillRecord.Header != mHeader && (oFillRecord.Header.ColumnCount != mHeader.ColumnCount || oFillRecord.Header.RecordLength != mHeader.RecordLength))
			{
				throw new Exception("Record parameter does not have the same size and number of columns as the " +
									"header specifies, so we are unable to read a record into oFillRecord. " +
									"This is a programming error, have you mixed up DBF file objects?");
			}

			//DBF file reader can be null if stream is not readable...
			if (mDbfFileReader == null)
			{
				throw new Exception("ReadStream is null, either you have opened a stream that can not be " +
									"read from (a write-only stream) or you have not opened a stream at all.");
			}

			//move to the specified record, note that an exception will be thrown is stream is not seekable! 
			//This is ok, since we provide a function to check whether the stream is seekable. 
			int nSeekToPosition = mHeader.HeaderLength + (index*mHeader.RecordLength);

			//check whether requested record exists. Subtract 1 from file length (there is a terminating character 1A at the end of the file)
			//so if we hit end of file, there are no more records, so return false;
			if (index < 0 || mDbfFile.Length - 1 <= nSeekToPosition)
				return false;

			//move to record and read
			mDbfFile.Seek(nSeekToPosition, SeekOrigin.Begin);

			//read the record
			bool bRead = oFillRecord.Read(mDbfFile);
			if (bRead)
				oFillRecord.RecordIndex = index;
			return bRead;
		}


		/// <summary>
		/// Reads a record specified by index. This method requires the stream to be able to seek to position. 
		/// If you are using a http stream, or a stream that can not stream, use ReadNext() methods to read in all records.
		/// </summary>
		/// <param name="index">Zero based index.</param>
		/// <returns>Null if record can not be read, otherwise returns a new record.</returns>
		public DbfRecord Read(int index)
		{
			//create a new record and fill it.
			var orec = new DbfRecord(mHeader);
			return Read(index, orec) ? orec : null;
		}


		/// <summary>
		/// Write a record to file. If RecordIndex is present, record will be updated, otherwise a new record will be written.
		/// Header will be output first if this is the first record being writen to file. 
		/// This method does not require stream seek capability to add a new record.
		/// </summary>
		/// <param name="orec"></param>
		public void Write(DbfRecord orec)
		{
			//if header was never written, write it first, then output the record
			if (!mHeaderWritten)
				WriteHeader();

			//if this is a new record (RecordIndex should be -1 in that case)
			if (orec.RecordIndex < 0)
			{
				if (mDbfFileWriter.BaseStream.CanSeek)
				{
					//calculate number of records in file. do not rely on header's RecordCount property since client can change that value.
					//also note that some DBF files do not have ending 0x1A byte, so we subtract 1 and round off 
					//instead of just cast since cast would just drop decimals.
					var nNumRecords = (int)Math.Round(((double)(mDbfFile.Length - mHeader.HeaderLength - 1)/mHeader.RecordLength));
					if (nNumRecords < 0)
						nNumRecords = 0;

					orec.RecordIndex = nNumRecords;
					Update(orec);
					mHeader.RecordCount++;
				}
				else
				{
					//we can not position this stream, just write out the new record.
					orec.Write(mDbfFile);
					mHeader.RecordCount++;
				}
			}
			else
				Update(orec);
		}

		public void Write(DbfRecord orec, bool bClearRecordAfterWrite)
		{
			Write(orec);
			if (bClearRecordAfterWrite)
				orec.Clear();
		}


		/// <summary>
		/// Update a record. RecordIndex (zero based index) must be more than -1, otherwise an exception is thrown.
		/// You can also use Write method which updates a record if it has RecordIndex or adds a new one if RecordIndex == -1.
		/// RecordIndex is set automatically when you call any Read() methods on this class.
		/// </summary>
		/// <param name="orec"></param>
		public void Update(DbfRecord orec)
		{
			//if header was never written, write it first, then output the record
			if (!mHeaderWritten)
				WriteHeader();

			//Check if record has an index
			if (orec.RecordIndex < 0)
				throw new Exception("RecordIndex is not set, unable to update record. Set RecordIndex or call Write() method to add a new record to file.");

			//Check if this record matches record size specified by header and number of columns. 
			//Client can pass a record from another DBF that is incompatible with this one and that would corrupt the file.
			if (orec.Header != mHeader && (orec.Header.ColumnCount != mHeader.ColumnCount || orec.Header.RecordLength != mHeader.RecordLength))
			{
				throw new Exception("Record parameter does not have the same size and number of columns as the " +
									"header specifies. Writing this record would corrupt the DBF file. " +
									"This is a programming error, have you mixed up DBF file objects?");
			}

			//DBF file writer can be null if stream is not writable to...
			if (mDbfFileWriter == null)
			{
				throw new Exception("Write stream is null. Either you have opened a stream that can not be " +
									"writen to (a read-only stream) or you have not opened a stream at all.");
			}

			//move to the specified record, note that an exception will be thrown if stream is not seekable! 
			//This is ok, since we provide a function to check whether the stream is seekable. 
			int nSeekToPosition = mHeader.HeaderLength + (orec.RecordIndex*mHeader.RecordLength);

			//check whether we can seek to this position. Subtract 1 from file length (there is a terminating character 1A at the end of the file)
			//so if we hit end of file, there are no more records, so return false;
			if (mDbfFile.Length < nSeekToPosition)
				throw new Exception("Invalid record position. Unable to save record.");

			//move to record start
			mDbfFile.Seek(nSeekToPosition, SeekOrigin.Begin);

			//write
			orec.Write(mDbfFile);
		}


		/// <summary>
		/// Save header to file. Normally, you do not have to call this method, header is saved 
		/// automatically and updated when you close the file (if it changed).
		/// </summary>
		public bool WriteHeader()
		{
			//update header if possible
			//--------------------------------
			if (mDbfFileWriter != null)
				if (mDbfFileWriter.BaseStream.CanSeek)
				{
					mDbfFileWriter.Seek(0, SeekOrigin.Begin);
					mHeader.Write(mDbfFileWriter);
					mHeaderWritten = true;
					return true;
				}
				else
				{
					//if stream can not seek, then just write it out and that's it.
					if (!mHeaderWritten)
						mHeader.Write(mDbfFileWriter);
					mHeaderWritten = true;
				}
			return false;
		}
	}
}