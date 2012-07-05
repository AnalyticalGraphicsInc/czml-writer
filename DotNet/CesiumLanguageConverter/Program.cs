using System;
using System.Collections.Generic;
using System.IO;
using KmlToCesiumLanguage;
using NDesk.Options;
using WebGLGlobeJsonToCesiumLanguage;

namespace CesiumLanguageConverter
{
    internal enum InputFileType
    {
        KML,
        WebGLGlobeJSON
    }

    internal class Conversion
    {
        public string InputFileName { get; set; }

        public string InputFileType { get; set; }

        public string OutputFileName { get; set; }

        public bool PrettyPrint { get; set; }
    }

    public class Program
    {
        private static readonly Dictionary<string, string> s_fileExtensionsToInputFileTypes;
        private static readonly Dictionary<string, Action<Conversion>> s_conversionMethods;

        private static readonly string s_helpParamDesc;
        private static readonly string s_outputFileParamDesc;
        private static readonly string s_inputFileTypeParamDesc;
        private static readonly string s_prettyPrintParamDesc;

        static Program()
        {
            s_fileExtensionsToInputFileTypes =
                new Dictionary<string, string>(StringComparer.InvariantCultureIgnoreCase)
                    {
                        { ".kml", InputFileType.KML.ToString() },
                        { ".kmz", InputFileType.KML.ToString() },
                        { ".json", InputFileType.WebGLGlobeJSON.ToString() },
                    };
            s_conversionMethods =
                new Dictionary<string, Action<Conversion>>(StringComparer.InvariantCultureIgnoreCase)
                    {
                        { InputFileType.KML.ToString(), ConvertKml },
                        { InputFileType.WebGLGlobeJSON.ToString(), ConvertWebGLGlobeJson },
                    };
            s_helpParamDesc = "Show this message and exit.";
            s_outputFileParamDesc = "Specify the output file name.  Defaults to the input file name, with extension changed to czml.";
            s_inputFileTypeParamDesc = string.Format("Specify the type of input file.  By default it will be inferred from the extension of the input file.  Valid options: {0}.", InputFileTypeOptions);
            s_prettyPrintParamDesc = "Produce pretty-printed output, which is more easily readable, but produces larger files.";
        }

        private static string InputFileTypeOptions
        {
            get { return string.Join(", ", s_conversionMethods.Keys); }
        }

        private static void Main(string[] args)
        {
            Conversion conversion = new Conversion();
            bool showHelp = false;

            var optionSet =
                new OptionSet
                    {
                        { "h|?|help", s_helpParamDesc, v => showHelp = v != null },
                        { "o=|outputFile=", s_outputFileParamDesc, v => conversion.OutputFileName = v },
                        { "t=|type=", s_inputFileTypeParamDesc, v => conversion.InputFileType = v },
                        { "pretty", s_prettyPrintParamDesc, v => conversion.PrettyPrint = v != null },
                        { "<>", "", v => conversion.InputFileName = v },
                    };

            try
            {
                optionSet.Parse(args);
            }
            catch (OptionException e)
            {
                Console.Error.Write("Invalid options: ");
                Console.Error.WriteLine(e.Message);
                Console.Error.WriteLine();
                ShowHelpAndExit(optionSet);
            }

            if (showHelp || conversion.InputFileName == null)
            {
                ShowHelpAndExit(optionSet);
            }

            if (conversion.InputFileType == null)
            {
                string extension = Path.GetExtension(conversion.InputFileName);
                string inputFileType;
                if (!s_fileExtensionsToInputFileTypes.TryGetValue(extension, out inputFileType))
                {
                    Console.Error.Write("Unable to infer file type from extension {0}.", extension);
                    Console.Error.WriteLine();
                    ShowHelpAndExit(optionSet);
                }
                conversion.InputFileType = inputFileType;
            }

            if (conversion.OutputFileName == null)
            {
                conversion.OutputFileName = Path.ChangeExtension(Path.GetFileName(conversion.InputFileName), "czml");
            }

            Action<Conversion> conversionMethod;
            if (!s_conversionMethods.TryGetValue(conversion.InputFileType, out conversionMethod))
            {
                Console.Error.Write("Unknown file type: {0}", conversion.InputFileType);
                Console.Error.WriteLine();
                ShowHelpAndExit(optionSet);
            }

            conversionMethod(conversion);

            Console.WriteLine("Wrote CZML output to {0}.", conversion.OutputFileName);
        }

        private static void ShowHelpAndExit(OptionSet optionSet)
        {
            Console.Error.WriteLine("Usage: CesiumLanguageConverter [OPTIONS]");
            Console.Error.WriteLine("Converts various file formats to CZML.");
            Console.Error.WriteLine("Supported file formats: {0}.", InputFileTypeOptions);

            Console.Error.WriteLine();
            Console.Error.WriteLine("Options:");
            optionSet.WriteOptionDescriptions(Console.Error);
            Environment.Exit(0);
        }

        private static void ConvertKml(Conversion conversion)
        {
            using (var outputWriter = new StreamWriter(conversion.OutputFileName))
            {
                string extension = Path.GetExtension(conversion.InputFileName);
                if (".kml".Equals(extension, StringComparison.OrdinalIgnoreCase))
                {
                    using (var inputReader = new StreamReader(conversion.InputFileName))
                        KmlConverter.KmlToCesiumLanguage(inputReader, outputWriter, conversion.PrettyPrint);
                }
                else if (".kmz".Equals(extension, StringComparison.OrdinalIgnoreCase))
                {
                    using (var inputStream = new FileStream(conversion.InputFileName, FileMode.Open, FileAccess.Read))
                        KmlConverter.KmzToCesiumLanguage(inputStream, outputWriter, conversion.PrettyPrint);
                }
            }
        }

        private static void ConvertWebGLGlobeJson(Conversion conversion)
        {
            using (var inputReader = new StreamReader(conversion.InputFileName))
            using (var outputWriter = new StreamWriter(conversion.OutputFileName))
            {
                WebGLGlobeJsonConverter.WebGLGlobeJsonToCesiumLanguage(inputReader, outputWriter, conversion.PrettyPrint);
            }
        }
    }
}