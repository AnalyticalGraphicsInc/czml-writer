///
/// Author: Ahmed Lacevic
/// Date: 12/1/2007
/// Desc: Quick test of our DBF class.
/// 
/// Revision History:
/// -----------------------------------
///   Author:
///   Date:
///   Desc:


using System;
using System.IO;
using System.Net;
using System.Text;
using SocialExplorer.IO.FastDBF;

namespace TestDbfLib
{
	internal class Program
	{
		private static void Main(string[] args)
		{
			//TestReadFile();
			//TestReadHttpConn();
			TestWriteNewDbf();
			Console.ReadKey();
		}

		private static readonly string TestPath = Path.GetTempPath();

		private static void TestWriteNewDbf()
		{
			//create a simple DBF file and output to args[0]
			var odbf = new DbfFile(Encoding.GetEncoding(1252));
			odbf.Open(Path.Combine(TestPath,"TestNew2.dbf"), FileMode.Create);

			//create a header
			odbf.Header.AddColumn(new DbfColumn("StrCol", DbfColumn.DbfColumnType.Character, 20, 0));
			odbf.Header.AddColumn(new DbfColumn("DecCol1", DbfColumn.DbfColumnType.Number, 5, 1));
			odbf.Header.AddColumn(new DbfColumn("DecCol2", DbfColumn.DbfColumnType.Number, 5, 2));
			odbf.Header.AddColumn(new DbfColumn("DecCol3", DbfColumn.DbfColumnType.Number, 5, 3));
			odbf.Header.AddColumn(new DbfColumn("DecCol4", DbfColumn.DbfColumnType.Number, 15, 5));
			odbf.Header.AddColumn(new DbfColumn("NumCol1", DbfColumn.DbfColumnType.Number, 5, 0));
			odbf.Header.AddColumn(new DbfColumn("NumCol2", DbfColumn.DbfColumnType.Number, 10, 0));
			odbf.Header.AddColumn(new DbfColumn("DateCol1", DbfColumn.DbfColumnType.Date));
			odbf.Header.AddColumn(new DbfColumn("BoolCol1", DbfColumn.DbfColumnType.Boolean));

			//add some records...
			var orec = new DbfRecord(odbf.Header) {AllowDecimalTruncate = true};
			orec[0] = "Ahmed Test";
			orec[1] = "123.5";
			orec[2] = "12.35";
			orec[3] = "1.235";
			orec[4] = "1235.123456";
			orec[5] = "1235";
			orec[6] = "123567890";
			orec[7] = "11/07/2007";
			orec[8] = "f";
			odbf.Write(orec, true);

			orec[0] = "Stéfanié Singer";
			orec[1] = "-1.5";
			orec[2] = "-1.35";
			orec[3] = "1.235";
			orec[4] = "-1235.123";
			orec[5] = "15";
			orec[6] = "12345"; //put a decimal in integer, we won't throw an exception beacuse we do not test for that.
			orec[7] = "2008-12-21";
			orec[8] = "f";
			odbf.Write(orec, true);

			orec[0] = "Stéfanié Singer longer than fits in the DBF record!";
			orec[1] = "0.1";
			orec[2] = ".12";
			orec[3] = ".1";
			orec[4] = "";
			orec[5] = "-15";
			orec[6] = "-12345"; //put a decimal in integer, we won't throw an exception beacuse we do not test for that.
			orec[7] = "";
			orec[8] = "no";
			odbf.Write(orec);

			//overwrite first record with last record's data...
			orec.RecordIndex = 0;
			odbf.Write(orec);

			//odbf.Header.RecordCount = 50;
			odbf.WriteHeader();

			odbf.Close();


			//open the same DBF file we just output, and append a few records to it...
			odbf.Open(Path.Combine(TestPath,"TestNew2.dbf"), FileMode.Open);

			orec.Clear();
			orec[0] = "New record added!";
			orec[6] = "100";
			orec[8] = "t";
			odbf.Write(orec, true);

			orec[0] = "New record 2";
			orec[6] = "104";
			orec[8] = "y";
			odbf.Write(orec, true);

			orec[0] = "New record 3";
			orec[6] = "104";
			orec[8] = "TRUE";
			odbf.Write(orec, true);

			if (odbf.Read(0, orec))
			{
				orec[0] = "modified first record";
				odbf.Write(orec, true);
			}

			//read 3rd record and output to console...
			Console.WriteLine(odbf.Read(2).ToString());


			//now add a new record, forcing seek to end of file...
			orec.Clear();
			orec[0] = "New record 4";
			orec[6] = "500";
			orec[8] = "FALSE";
			odbf.Write(orec, true);


			odbf.Close();

			Console.ReadKey();
		}


		private static void TestReadFile()
		{
			//create a simple DBF file and output to args[0]
			var odbf = new DbfFile(Encoding.GetEncoding(1252));

			odbf.Open(Path.Combine(TestPath,"TestNew2.dbf"), FileMode.Open); //State_vars1.dbf  county_vars1.dbf

			//if (File.Exists("P:\\Development\\Library\\CS\\DbfLib\\DBFSamples\\filesource.txt"))
			//  File.Delete("P:\\Development\\Library\\CS\\DbfLib\\DBFSamples\\filesource.txt");

			var ofs = new FileStream(Path.Combine(TestPath,"filesource.txt"), FileMode.Create);
			var osw = new StreamWriter(ofs, Encoding.Default);

			//read and print records to screen...
			var orec = new DbfRecord(odbf.Header);


			for (int i = 0; i < odbf.Header.RecordCount; i++)
			{
				if (!odbf.Read(i, orec))
					break;
				osw.WriteLine("index: " + orec.RecordIndex + ": " + orec);
			}


			/*
	  while (odbf.ReadNext(orec))
	  { 
		osw.WriteLine("index: " + orec.RecordIndex + ": " + orec.ToString());
	  }
	  */

			osw.Flush();
			osw.Close();
		}


		private static void TestReadHttpConn()
		{
			//Open a web file...
			//-------------------------------------
			var oWebDBF = new DbfFile(Encoding.GetEncoding(1252));
			var oWebFile = new WebClient();

			oWebDBF.Open(oWebFile.OpenRead("http://private.socialexplorer.com/State_vars1.dbf"));

			//read and print records to screen...
			var orecWeb = new DbfRecord(oWebDBF.Header);

			var ofs2 = new FileStream(Path.Combine(TestPath,"Webfile.txt"), FileMode.Create);
			var osw2 = new StreamWriter(ofs2);

			bool bIsForwardOnly = oWebDBF.IsForwardOnly;
			bool bIsReadOnly = oWebDBF.IsReadOnly;

			while (oWebDBF.ReadNext(orecWeb))
				osw2.WriteLine("index: " + orecWeb.RecordIndex + ": " + orecWeb);

			osw2.Flush();
			osw2.Close();

			oWebDBF.Close();
		}
	}
}