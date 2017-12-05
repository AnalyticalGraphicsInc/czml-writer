package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JWarning;
import agi.foundation.compatibility.annotations.Internal;
import agi.foundation.compatibility.ObjectHelper;
import agi.foundation.compatibility.ResourceBundleHelper;
import agi.foundation.compatibility.TypeHelper;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *  
   A strongly-typed resource class, for looking up localized strings, etc.
 

 * @deprecated Internal use only.
 */
@SuppressWarnings( {
        "unused",
        "deprecation",
        "serial"
})
@Deprecated
@Internal
@CS2JWarning( {
        "Unhandled attribute removed: System.CodeDom.Compiler.GeneratedCodeAttribute",
        "Unhandled attribute removed: System.Diagnostics.DebuggerNonUserCodeAttribute",
        "Unhandled attribute removed: System.Runtime.CompilerServices.CompilerGeneratedAttribute",
        "Unhandled attribute removed: System.ComponentModel.EditorBrowsableAttribute"
})
public class CesiumLocalization {
    private static ResourceBundle resourceMan;
    private static Locale resourceCulture;

    /**
    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    @CS2JWarning("Unhandled attribute removed: System.Diagnostics.CodeAnalysis.SuppressMessageAttribute")
    public CesiumLocalization() {}

    /**
    *  
    Returns the cached ResourceManager instance used by this class.
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static ResourceBundle getResourceManager() {
        if (ObjectHelper.referenceEquals(resourceMan, null)) {
            ResourceBundle temp = ResourceBundleHelper.getBundle("CesiumLanguageWriter.CesiumLocalization");
            resourceMan = temp;
        }
        return resourceMan;
    }

    /**
    *  
    Overrides the current thread's CurrentUICulture property for all
    resource lookups using this strongly typed resource class.
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static Locale getCulture() {
        return resourceCulture;
    }

    /**
    *  
    Overrides the current thread's CurrentUICulture property for all
    resource lookups using this strongly typed resource class.
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static void setCulture(Locale value) {
        resourceCulture = value;
    }

    /**
    *  
    Looks up a localized string similar to The argument is not an expected type for the method..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getArgumentTypeInvalid() {
        return getResourceManager().getString("ArgumentTypeInvalid");
    }

    /**
    *  
    Looks up a localized string similar to JulianDate cannot represent the moment of a leap second with the UTC time standard..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getCannotRepresentLeapSecondAsUTCJulianDate() {
        return getResourceManager().getString("CannotRepresentLeapSecondAsUTCJulianDate");
    }

    /**
    *  
    Looks up a localized string similar to The requested data cannot be downloaded..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getDataDownloadFailed() {
        return getResourceManager().getString("DataDownloadFailed");
    }

    /**
    *  
    Looks up a localized string similar to The given date must be in the UTC time standard..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getDateMustBeUTC() {
        return getResourceManager().getString("DateMustBeUTC");
    }

    /**
    *  
    Looks up a localized string similar to The Day of Year must be between 1 and 366 inclusive..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getDayOfYearOutOfRange() {
        return getResourceManager().getString("DayOfYearOutOfRange");
    }

    /**
    *  
    Looks up a localized string similar to Invalid format string..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getGregorianDateFormatInvalid() {
        return getResourceManager().getString("GregorianDateFormatInvalid");
    }

    /**
    *  
    Looks up a localized string similar to Invalid character {0} in format specifier..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getGregorianDateInvalidCharacter() {
        return getResourceManager().getString("GregorianDateInvalidCharacter");
    }

    /**
    *  
    Looks up a localized string similar to Invalid character {0} at the end of the format specifier..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getGregorianDateInvalidCharacterAtEnd() {
        return getResourceManager().getString("GregorianDateInvalidCharacterAtEnd");
    }

    /**
    *  
    Looks up a localized string similar to {0} is not one of the format specifier characters defined for DateTimeFormatInfo..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getGregorianDateInvalidFormatSpecifier() {
        return getResourceManager().getString("GregorianDateInvalidFormatSpecifier");
    }

    /**
    *  
    Looks up a localized string similar to Order of month and date is not defined by {0}..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getGregorianDateOrderOfMonthAndDateNotDefined() {
        return getResourceManager().getString("GregorianDateOrderOfMonthAndDateNotDefined");
    }

    /**
    *  
    Looks up a localized string similar to Order of year, month and date is not defined by {0}..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getGregorianDateOrderOfYearMonthAndDateNotDefined() {
        return getResourceManager().getString("GregorianDateOrderOfYearMonthAndDateNotDefined");
    }

    /**
    *  
    Looks up a localized string similar to Order of year, month and date defined by {0} is not supported..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getGregorianDateOrderOfYearMonthAndDateNotSupported() {
        return getResourceManager().getString("GregorianDateOrderOfYearMonthAndDateNotSupported");
    }

    /**
    *  
    Looks up a localized string similar to A quote was not terminated..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getGregorianDateQuoteNotTerminated() {
        return getResourceManager().getString("GregorianDateQuoteNotTerminated");
    }

    /**
    *  
    Looks up a localized string similar to Input {0} was not recognized as a valid GregorianDate..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getGregorianDateStringNotRecognized() {
        return getResourceManager().getString("GregorianDateStringNotRecognized");
    }

    /**
    *  
    Looks up a localized string similar to One or more of the hour, minute, and second arguments is outside of the acceptable range..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getHourMinuteSecondInvalidArgument() {
        return getResourceManager().getString("HourMinuteSecondInvalidArgument");
    }

    /**
    *  
    Looks up a localized string similar to The provided reference string is not in the correct format..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getInvalidReferenceString() {
        return getResourceManager().getString("InvalidReferenceString");
    }

    /**
    *  
    Looks up a localized string similar to The magnitude of the provided coordinates must not be infinite..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getMagnitudeMustNotBeInfinite() {
        return getResourceManager().getString("MagnitudeMustNotBeInfinite");
    }

    /**
    *  
    Looks up a localized string similar to The magnitude of the provided coordinates must not be zero..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getMagnitudeMustNotBeZero() {
        return getResourceManager().getString("MagnitudeMustNotBeZero");
    }

    /**
    *  
    Looks up a localized string similar to This collection must have the same number of elements as the "dates" collection..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getMismatchedNumberOfDatesAndValues() {
        return getResourceManager().getString("MismatchedNumberOfDatesAndValues");
    }

    /**
    *  
    Looks up a localized string similar to A Motion instance must be constructed with at least one value..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getMotionMustContainValue() {
        return getResourceManager().getString("MotionMustContainValue");
    }

    /**
    *  
    Looks up a localized string similar to The enumeration has an invalid or unsupported value..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getUnknownEnumerationValue() {
        return getResourceManager().getString("UnknownEnumerationValue");
    }

    /**
    *  
    Looks up a localized string similar to The upper bound cannot be less than the lower bound..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getUpperBoundCannotBeLessThanLowerBound() {
        return getResourceManager().getString("UpperBoundCannotBeLessThanLowerBound");
    }

    /**
    *  
    Looks up a localized string similar to The Cesium writer cannot be closed because it is not open..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getWriterAlreadyClosed() {
        return getResourceManager().getString("WriterAlreadyClosed");
    }

    /**
    *  
    Looks up a localized string similar to The Cesium writer cannot be opened because it is already opened.  Please close the previous element before opening a new one..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getWriterAlreadyOpen() {
        return getResourceManager().getString("WriterAlreadyOpen");
    }

    /**
    *  
    Looks up a localized string similar to The Cesium writer cannot be used to write elements because it is not currently open.  This usually indicates an attempt to use a writer after is has been closed..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getWriterNotOpen() {
        return getResourceManager().getString("WriterNotOpen");
    }

    /**
    *  
    Looks up a localized string similar to One or more of the year, month, and day arguments is outside of the acceptable range..
    

    * @deprecated Internal use only.
    */
    @Deprecated
    @Internal
    public static String getYearMonthDayInvalidArgument() {
        return getResourceManager().getString("YearMonthDayInvalidArgument");
    }
}