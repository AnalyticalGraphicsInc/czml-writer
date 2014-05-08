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
 

 */
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

	@Internal
	@CS2JWarning("Unhandled attribute removed: System.Diagnostics.CodeAnalysis.SuppressMessageAttribute")
	public CesiumLocalization() {}

	/**
	 *  
	Returns the cached ResourceManager instance used by this class.
	

	 */
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
	

	 */
	@Internal
	public static Locale getCulture() {
		return resourceCulture;
	}

	/**
	 *  
	Overrides the current thread's CurrentUICulture property for all
	resource lookups using this strongly typed resource class.
	

	 */
	@Internal
	public static void setCulture(Locale value) {
		resourceCulture = value;
	}

	/**
	 *  
	Looks up a localized string similar to The argument is not an expected type for the method..
	

	 */
	@Internal
	public static String getArgumentTypeInvalid() {
		return getResourceManager().getString("ArgumentTypeInvalid");
	}

	/**
	 *  
	Looks up a localized string similar to JulianDate cannot represent the moment of a leap second with the UTC time standard..
	

	 */
	@Internal
	public static String getCannotRepresentLeapSecondAsUTCJulianDate() {
		return getResourceManager().getString("CannotRepresentLeapSecondAsUTCJulianDate");
	}

	/**
	 *  
	Looks up a localized string similar to The Day of Year must be between 1 and 366 inclusive..
	

	 */
	@Internal
	public static String getDayOfYearOutOfRange() {
		return getResourceManager().getString("DayOfYearOutOfRange");
	}

	/**
	 *  
	Looks up a localized string similar to Invalid format string..
	

	 */
	@Internal
	public static String getGregorianDateFormatInvalid() {
		return getResourceManager().getString("GregorianDateFormatInvalid");
	}

	/**
	 *  
	Looks up a localized string similar to Invalid character {0} in format specifier..
	

	 */
	@Internal
	public static String getGregorianDateInvalidCharacter() {
		return getResourceManager().getString("GregorianDateInvalidCharacter");
	}

	/**
	 *  
	Looks up a localized string similar to Invalid character {0} at the end of the format specifier..
	

	 */
	@Internal
	public static String getGregorianDateInvalidCharacterAtEnd() {
		return getResourceManager().getString("GregorianDateInvalidCharacterAtEnd");
	}

	/**
	 *  
	Looks up a localized string similar to {0} is not one of the format specifier characters defined for DateTimeFormatInfo..
	

	 */
	@Internal
	public static String getGregorianDateInvalidFormatSpecifier() {
		return getResourceManager().getString("GregorianDateInvalidFormatSpecifier");
	}

	/**
	 *  
	Looks up a localized string similar to Order of month and date is not defined by {0}..
	

	 */
	@Internal
	public static String getGregorianDateOrderOfMonthAndDateNotDefined() {
		return getResourceManager().getString("GregorianDateOrderOfMonthAndDateNotDefined");
	}

	/**
	 *  
	Looks up a localized string similar to Order of year, month and date is not defined by {0}..
	

	 */
	@Internal
	public static String getGregorianDateOrderOfYearMonthAndDateNotDefined() {
		return getResourceManager().getString("GregorianDateOrderOfYearMonthAndDateNotDefined");
	}

	/**
	 *  
	Looks up a localized string similar to Order of year, month and date defined by {0} is not supported..
	

	 */
	@Internal
	public static String getGregorianDateOrderOfYearMonthAndDateNotSupported() {
		return getResourceManager().getString("GregorianDateOrderOfYearMonthAndDateNotSupported");
	}

	/**
	 *  
	Looks up a localized string similar to A quote was not terminated..
	

	 */
	@Internal
	public static String getGregorianDateQuoteNotTerminated() {
		return getResourceManager().getString("GregorianDateQuoteNotTerminated");
	}

	/**
	 *  
	Looks up a localized string similar to Input {0} was not recognized as a valid GregorianDate..
	

	 */
	@Internal
	public static String getGregorianDateStringNotRecognized() {
		return getResourceManager().getString("GregorianDateStringNotRecognized");
	}

	/**
	 *  
	Looks up a localized string similar to One or more of the hour, minute, and second arguments is outside of the acceptable range..
	

	 */
	@Internal
	public static String getHourMinuteSecondInvalidArgument() {
		return getResourceManager().getString("HourMinuteSecondInvalidArgument");
	}

	/**
	 *  
	Looks up a localized string similar to The magnitude of the provided coordinates must not be infinite..
	

	 */
	@Internal
	public static String getMagnitudeMustNotBeInfinite() {
		return getResourceManager().getString("MagnitudeMustNotBeInfinite");
	}

	/**
	 *  
	Looks up a localized string similar to The magnitude of the provided coordinates must not be zero..
	

	 */
	@Internal
	public static String getMagnitudeMustNotBeZero() {
		return getResourceManager().getString("MagnitudeMustNotBeZero");
	}

	/**
	 *  
	Looks up a localized string similar to This collection must have the same number of elements as the "dates" collection..
	

	 */
	@Internal
	public static String getMismatchedNumberOfDatesAndValues() {
		return getResourceManager().getString("MismatchedNumberOfDatesAndValues");
	}

	/**
	 *  
	Looks up a localized string similar to A Motion instance must be constructed with at least one value..
	

	 */
	@Internal
	public static String getMotionMustContainValue() {
		return getResourceManager().getString("MotionMustContainValue");
	}

	/**
	 *  
	Looks up a localized string similar to An object of the type {0} must be constructed from an array with at least {1} elements..
	

	 */
	@Internal
	public static String getMustBeConstructedFromSpecificNumberOfElements() {
		return getResourceManager().getString("MustBeConstructedFromSpecificNumberOfElements");
	}

	/**
	 *  
	Looks up a localized string similar to TAI.
	

	 */
	@Internal
	public static String getTaiAbbreviation() {
		return getResourceManager().getString("TaiAbbreviation");
	}

	/**
	 *  
	Looks up a localized string similar to International Atomic Time.
	

	 */
	@Internal
	public static String getTaiName() {
		return getResourceManager().getString("TaiName");
	}

	/**
	 *  
	Looks up a localized string similar to The enumeration has an invalid or unsupported value..
	

	 */
	@Internal
	public static String getUnknownEnumerationValue() {
		return getResourceManager().getString("UnknownEnumerationValue");
	}

	/**
	 *  
	Looks up a localized string similar to UTC.
	

	 */
	@Internal
	public static String getUtcAbbreviation() {
		return getResourceManager().getString("UtcAbbreviation");
	}

	/**
	 *  
	Looks up a localized string similar to Coordinated Universal Time.
	

	 */
	@Internal
	public static String getUtcName() {
		return getResourceManager().getString("UtcName");
	}

	/**
	 *  
	Looks up a localized string similar to The Cesium writer cannot be closed because it is not open..
	

	 */
	@Internal
	public static String getWriterAlreadyClosed() {
		return getResourceManager().getString("WriterAlreadyClosed");
	}

	/**
	 *  
	Looks up a localized string similar to The Cesium writer cannot be opened because it is already opened.  Please close the previous element before opening a new one..
	

	 */
	@Internal
	public static String getWriterAlreadyOpen() {
		return getResourceManager().getString("WriterAlreadyOpen");
	}

	/**
	 *  
	Looks up a localized string similar to The Cesium writer cannot be used to write elements because it is not currently open.  This usually indicates an attempt to use a writer after is has been closed..
	

	 */
	@Internal
	public static String getWriterNotOpen() {
		return getResourceManager().getString("WriterNotOpen");
	}

	/**
	 *  
	Looks up a localized string similar to One or more of the year, month, and day arguments is outside of the acceptable range..
	

	 */
	@Internal
	public static String getYearMonthDayInvalidArgument() {
		return getResourceManager().getString("YearMonthDayInvalidArgument");
	}
}