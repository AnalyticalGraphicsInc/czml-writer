using System;
using System.Globalization;
using JetBrains.Annotations;

namespace CesiumLanguageWriter
{
    internal static class StringFormatting
    {
        /// <summary>
        /// Reformats a string representation of a decimal floating point number, which may or may not be expressed
        /// in exponential notation, to eliminate the use of exponential notation.  The formatted number is assumed not to contain
        /// any characters other than significant numbers, an optional negative sign in front of the number, an optional
        /// negative sign in front of the exponent, and an optional decimal separator specified by <paramref name="format"/>.
        /// </summary>
        /// <param name="format">The format used to format the number.  This is used to determine the decimal separator.</param>
        /// <param name="formattedNumber">The formatted decimal floating point number.</param>
        /// <returns>An equivalent number without the use of exponential notation.</returns>
        [NotNull]
        public static string ToNonExponentialNotation(NumberFormatInfo format, [NotNull] string formattedNumber)
        {
            int indexOfE = formattedNumber.IndexOf('E');
            if (indexOfE < 0)
                return formattedNumber;

            string mantissa = formattedNumber.Substring(0, indexOfE);
            int exponent = int.Parse(formattedNumber.Substring(indexOfE + 1));

            string decimalSeparator = format.NumberDecimalSeparator;
            int indexOfSeparator = mantissa.IndexOf(decimalSeparator, StringComparison.Ordinal);

            string withoutDecimalSeparator;
            if (indexOfSeparator < 0)
            {
                indexOfSeparator = mantissa.Length;
                withoutDecimalSeparator = mantissa;
            }
            else
            {
                withoutDecimalSeparator = mantissa.Remove(indexOfSeparator, decimalSeparator.Length);
            }

            int desiredIndexOfSeparator = indexOfSeparator + exponent;

            // Pad the beginning or end with zeros if necessary
            if (desiredIndexOfSeparator <= 0)
            {
                withoutDecimalSeparator = new string('0', -desiredIndexOfSeparator + 1) + withoutDecimalSeparator;
                desiredIndexOfSeparator = 1;
            }
            else if (desiredIndexOfSeparator >= withoutDecimalSeparator.Length)
            {
                withoutDecimalSeparator += new string('0', desiredIndexOfSeparator - withoutDecimalSeparator.Length + 1);
            }

            return withoutDecimalSeparator.Substring(0, desiredIndexOfSeparator) + decimalSeparator + withoutDecimalSeparator.Substring(desiredIndexOfSeparator);
        }
    }
}