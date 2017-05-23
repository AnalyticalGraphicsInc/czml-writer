package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.Internal;
import agi.foundation.compatibility.IntHelper;
import agi.foundation.compatibility.NumberFormatInfo;
import agi.foundation.compatibility.StringComparison;
import agi.foundation.compatibility.StringHelper;

/**
 * @deprecated Internal use only.
 */
@SuppressWarnings("unused")
@Deprecated
@Internal
public final class StringFormatting {
    private StringFormatting() {}

    /**
    *  
    Reformats a string representation of a decimal floating point number, which may or may not be expressed
    in exponential notation, to eliminate the use of exponential notation.  The formatted number is assumed not to contain
    any characters other than significant numbers, an optional negative sign in front of the number, an optional
    negative sign in front of the exponent, and an optional decimal separator specified by {@code format}.
    
    
    
    

    * @param format The format used to format the number.  This is used to determine the decimal separator.
    * @param formattedNumber The formatted decimal floating point number.
    * @return An equivalent number without the use of exponential notation.
    */
    public static String toNonExponentialNotation(NumberFormatInfo format, String formattedNumber) {
        int indexOfE = formattedNumber.indexOf('E');
        if (indexOfE < 0) {
            return formattedNumber;
        }
        String mantissa = StringHelper.substring(formattedNumber, 0, indexOfE);
        int exponent = IntHelper.parse(StringHelper.substring(formattedNumber, indexOfE + 1));
        String decimalSeparator = format.getNumberDecimalSeparator();
        int indexOfSeparator = StringHelper.indexOf(mantissa, decimalSeparator, StringComparison.ORDINAL);
        String withoutDecimalSeparator;
        if (indexOfSeparator < 0) {
            indexOfSeparator = mantissa.length();
            withoutDecimalSeparator = mantissa;
        } else {
            withoutDecimalSeparator = StringHelper.remove(mantissa, indexOfSeparator, decimalSeparator.length());
        }
        int desiredIndexOfSeparator = indexOfSeparator + exponent;
        // Pad the beginning or end with zeros if necessary
        if (desiredIndexOfSeparator <= 0) {
            withoutDecimalSeparator = StringHelper.create('0', -desiredIndexOfSeparator + 1) + withoutDecimalSeparator;
            desiredIndexOfSeparator = 1;
        } else if (desiredIndexOfSeparator >= withoutDecimalSeparator.length()) {
            withoutDecimalSeparator = withoutDecimalSeparator + StringHelper.create('0', desiredIndexOfSeparator - withoutDecimalSeparator.length() + 1);
        }
        return StringHelper.substring(withoutDecimalSeparator, 0, desiredIndexOfSeparator) + decimalSeparator + StringHelper.substring(withoutDecimalSeparator, desiredIndexOfSeparator);
    }
}