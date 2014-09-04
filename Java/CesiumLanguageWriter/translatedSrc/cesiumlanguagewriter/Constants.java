package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.annotations.CS2JWarning;

/**
 *  
 A collection of constants.
 

 */
public final class Constants {
	private Constants() {}

	/**
	 *  
	Half of  {@link Math#PI}.
	

	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public static final double HalfPi = Math.PI / 2;
	/**
	 *  
	Twice  {@link Math#PI}.
	

	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public static final double TwoPi = Math.PI * 2;
	/**
	 *  
	Three-halves  {@link Math#PI}.
	

	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public static final double ThreeHalvesPi = 3 * Math.PI / 2;
	/**
	 *  
	The number of radians in a degree.
	

	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public static final double RadiansPerDegree = (2 * Math.PI) / 360.0;
	/**
	 *  
	The number of degrees in a radian.
	

	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public static final double DegreesPerRadian = 360.0 / (2 * Math.PI);
	/**
	 *  
	The number of degrees in a complete revolution.
	

	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public static final double DegreesPerRevolution = 360.0;
	/**
	 *  
	The number of minutes in a degree.
	

	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public static final double MinutesPerDegree = 60.0;
	/**
	 *  
	The number of seconds in a degree.
	

	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public static final double SecondsPerDegree = 60.0 * 60.0;
	/**
	 *  
	The number of seconds in a minute.
	

	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public static final double SecondsPerMinute = 60.0;
	/**
	 *  
	The number of degrees in an hour.
	

	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public static final double DegreesPerHour = 15.0;
	/**
	 *  
	The number of radians in one arc second.
	

	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public static final double RadiansPerArcSecond = RadiansPerDegree / 3600.0;
	/**
	 *  
	The number of arc seconds in one radian.
	

	 */
	@CS2JWarning("Unhandled attribute removed: SuppressMessage")
	public static final double ArcSecondsPerRadian = 3600.0 / RadiansPerDegree;
	/**
	 *  
	A small number useful for comparisons, 1e-1
	

	 */
	public static final double Epsilon1 = 1e-1;
	/**
	 *  
	A small number useful for comparisons, 1e-2
	

	 */
	public static final double Epsilon2 = 1e-2;
	/**
	 *  
	A small number useful for comparisons, 1e-3
	

	 */
	public static final double Epsilon3 = 1e-3;
	/**
	 *  
	A small number useful for comparisons, 1e-4
	

	 */
	public static final double Epsilon4 = 1e-4;
	/**
	 *  
	A small number useful for comparisons, 1e-5
	

	 */
	public static final double Epsilon5 = 1e-5;
	/**
	 *  
	A small number useful for comparisons, 1e-6
	

	 */
	public static final double Epsilon6 = 1e-6;
	/**
	 *  
	A small number useful for comparisons, 1e-7
	

	 */
	public static final double Epsilon7 = 1e-7;
	/**
	 *  
	A small number useful for comparisons, 1e-8
	

	 */
	public static final double Epsilon8 = 1e-8;
	/**
	 *  
	A small number useful for comparisons, 1e-9
	

	 */
	public static final double Epsilon9 = 1e-9;
	/**
	 *  
	A small number useful for comparisons, 1e-10
	

	 */
	public static final double Epsilon10 = 1e-10;
	/**
	 *  
	A small number useful for comparisons, 1e-11
	

	 */
	public static final double Epsilon11 = 1e-11;
	/**
	 *  
	A small number useful for comparisons, 1e-12
	

	 */
	public static final double Epsilon12 = 1e-12;
	/**
	 *  
	A small number useful for comparisons, 1e-13
	

	 */
	public static final double Epsilon13 = 1e-13;
	/**
	 *  
	A small number useful for comparisons, 1e-14
	

	 */
	public static final double Epsilon14 = 1e-14;
	/**
	 *  
	A small number useful for comparisons, 1e-15
	

	 */
	public static final double Epsilon15 = 1e-15;
	/**
	 *  
	A small number useful for comparisons, 1e-16
	

	 */
	public static final double Epsilon16 = 1e-16;
	/**
	 *  
	A small number useful for comparisons, 1e-17
	

	 */
	public static final double Epsilon17 = 1e-17;
	/**
	 *  
	A small number useful for comparisons, 1e-18
	

	 */
	public static final double Epsilon18 = 1e-18;
	/**
	 *  
	A small number useful for comparisons, 1e-19
	

	 */
	public static final double Epsilon19 = 1e-19;
	/**
	 *  
	A small number useful for comparisons, 1e-20
	

	 */
	public static final double Epsilon20 = 1e-20;
}