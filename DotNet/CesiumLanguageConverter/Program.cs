using System;
using System.Collections.Generic;
using System.IO;
using KmlToCesiumLanguage;
using NDesk.Options;
using WebGLGlobeJsonToCesiumLanguage;

namespace CesiumLanguageConverter
{
    public class Program
    {
        private class ConversionOptions
        {
            public string InputFileName;
            public string InputFileType;
            public string OutputFileName;
            public bool PrettyPrint;
            public readonly KmlConversionOptions Kml = new KmlConversionOptions();
            public readonly WebGLGlobeJsonConversionOptions WebGLGlobeJson = new WebGLGlobeJsonConversionOptions();
        }

        private class KmlConversionOptions
        {
        }

        private class WebGLGlobeJsonConversionOptions
        {
            public double HeightScalar = 1.0;
        }

        private static readonly Dictionary<string, string> s_fileExtensionsToInputFileTypes;
        private static readonly Dictionary<string, Action<ConversionOptions>> s_conversionMethods;

        private static readonly string s_helpParamDesc;
        private static readonly string s_outputFileParamDesc;
        private static readonly string s_inputFileTypeParamDesc;
        private static readonly string s_prettyPrintParamDesc;

        static Program()
        {
            s_fileExtensionsToInputFileTypes =
                new Dictionary<string, string>(StringComparer.InvariantCultureIgnoreCase)
                    {
                        { ".kml", "KML" },
                        { ".kmz", "KML" },
                        { ".json", "WebGLGlobeJSON" },
                    };
            s_conversionMethods =
                new Dictionary<string, Action<ConversionOptions>>(StringComparer.InvariantCultureIgnoreCase)
                    {
                        { "KML", ConvertKml },
                        { "WebGLGlobeJSON", ConvertWebGLGlobeJson },
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
            ConversionOptions options = new ConversionOptions();
            bool showHelp = false;

            var optionSet =
                new OptionSet
                    {
                        { "h|?|help", s_helpParamDesc, v => showHelp = v != null },
                        { "o=|outputFile=", s_outputFileParamDesc, v => options.OutputFileName = v },
                        { "t=|type=", s_inputFileTypeParamDesc, v => options.InputFileType = v },
                        { "pretty", s_prettyPrintParamDesc, v => options.PrettyPrint = v != null },
                        { "<>", "", v => options.InputFileName = v },
                    };

            AddKmlOptions(optionSet, options);
            AddWebGLGlobeJsonOptions(optionSet, options);

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

            if (showHelp || options.InputFileName == null)
            {
                ShowHelpAndExit(optionSet);
            }

            if (options.InputFileType == null)
            {
                string extension = Path.GetExtension(options.InputFileName);
                string inputFileType;
                if (!s_fileExtensionsToInputFileTypes.TryGetValue(extension, out inputFileType))
                {
                    Console.Error.Write("Unable to infer file type from extension {0}.", extension);
                    Console.Error.WriteLine();
                    ShowHelpAndExit(optionSet);
                }
                options.InputFileType = inputFileType;
            }

            if (options.OutputFileName == null)
            {
                options.OutputFileName = Path.ChangeExtension(Path.GetFileName(options.InputFileName), "czml");
            }

            Action<ConversionOptions> conversionMethod;
            if (!s_conversionMethods.TryGetValue(options.InputFileType, out conversionMethod))
            {
                Console.Error.Write("Unknown file type: {0}", options.InputFileType);
                Console.Error.WriteLine();
                ShowHelpAndExit(optionSet);
            }

            conversionMethod(options);

            Console.WriteLine("Wrote CZML output to {0}.", options.OutputFileName);
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

        private static void AddKmlOptions(OptionSet optionSet, ConversionOptions options)
        {
        }

        private static void ConvertKml(ConversionOptions options)
        {
            using (var outputWriter = new StreamWriter(options.OutputFileName))
            {
                string extension = Path.GetExtension(options.InputFileName);
                if (".kml".Equals(extension, StringComparison.OrdinalIgnoreCase))
                {
                    using (var inputReader = new StreamReader(options.InputFileName))
                        KmlConverter.KmlToCesiumLanguage(inputReader, outputWriter, options.PrettyPrint);
                }
                else if (".kmz".Equals(extension, StringComparison.OrdinalIgnoreCase))
                {
                    using (var inputStream = new FileStream(options.InputFileName, FileMode.Open, FileAccess.Read))
                        KmlConverter.KmzToCesiumLanguage(inputStream, outputWriter, options.PrettyPrint);
                }
            }
        }

        private static void AddWebGLGlobeJsonOptions(OptionSet optionSet, ConversionOptions options)
        {
            const string heightScalarParamDesc = "A scale factor for the height component of each coordinate.  Defaults to 1.";

            optionSet.Add("webGLGlobeJsonHeightScalar=", heightScalarParamDesc, (double v) => options.WebGLGlobeJson.HeightScalar = v);
        }

        private static void ConvertWebGLGlobeJson(ConversionOptions options)
        {
            using (var inputReader = new StreamReader(options.InputFileName))
            using (var outputWriter = new StreamWriter(options.OutputFileName))
            {
                WebGLGlobeJsonConverter.WebGLGlobeJsonToCesiumLanguage(inputReader, outputWriter, options.PrettyPrint, options.WebGLGlobeJson.HeightScalar);
            }
        }
    }
}