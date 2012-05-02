using System;
using System.Diagnostics.CodeAnalysis;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// A collection of constants.
    /// </summary>
	public static class Constants
	{
        /// <summary>
        /// Half of <see cref="Math.PI" />.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double HalfPi = Math.PI / 2;

        /// <summary>
        /// Twice <see cref="Math.PI" />.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double TwoPi = Math.PI * 2;

        /// <summary>
        /// Three-halves <see cref="Math.PI"/>.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double ThreeHalvesPi = 3 * Math.PI / 2;

        /// <summary>
        /// The number of radians in a degree.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double RadiansPerDegree = (2 * Math.PI) / 360.0;

        /// <summary>
        /// The number of degrees in a radian.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double DegreesPerRadian = 360.0 / (2 * Math.PI);

        /// <summary>
        /// The number of degrees in a complete revolution.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double DegreesPerRevolution = 360.0;

        /// <summary>
        /// The number of minutes in a degree.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double MinutesPerDegree = 60.0;

        /// <summary>
        /// The number of seconds in a degree.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double SecondsPerDegree = 60.0 * 60.0;

        /// <summary>
        /// The number of seconds in a minute.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double SecondsPerMinute = 60.0;

        /// <summary>
        /// The number of degrees in an hour.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double DegreesPerHour = 15.0;

        /// <summary>
        /// The number of radians in one arc second.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double RadiansPerArcSecond = RadiansPerDegree / 3600.0;

        /// <summary>
        /// The number of arc secons in one radian.
        /// </summary>
        [SuppressMessage("Microsoft.Performance", "CA1802:UseLiteralsWhereAppropriate")]
        public static readonly double ArcSecondsPerRadian = 3600.0 / RadiansPerDegree;

        /// <summary>
        /// A small number useful for comparisons, 1e-1
        /// </summary>
        public const double Epsilon1 = 1e-1;

        /// <summary>
        /// A small number useful for comparisons, 1e-2
        /// </summary>
        public const double Epsilon2 = 1e-2;

        /// <summary>
        /// A small number useful for comparisons, 1e-3
        /// </summary>
        public const double Epsilon3 = 1e-3;

        /// <summary>
        /// A small number useful for comparisons, 1e-4
        /// </summary>
        public const double Epsilon4 = 1e-4;

        /// <summary>
        /// A small number useful for comparisons, 1e-5
        /// </summary>
        public const double Epsilon5 = 1e-5;

        /// <summary>
        /// A small number useful for comparisons, 1e-6
        /// </summary>
        public const double Epsilon6 = 1e-6;

        /// <summary>
        /// A small number useful for comparisons, 1e-7
        /// </summary>
        public const double Epsilon7 = 1e-7;

        /// <summary>
        /// A small number useful for comparisons, 1e-8
        /// </summary>
        public const double Epsilon8 = 1e-8;

        /// <summary>
        /// A small number useful for comparisons, 1e-9
        /// </summary>
        public const double Epsilon9 = 1e-9;

        /// <summary>
        /// A small number useful for comparisons, 1e-10
        /// </summary>
        public const double Epsilon10 = 1e-10;

        /// <summary>
        /// A small number useful for comparisons, 1e-11
        /// </summary>
        public const double Epsilon11 = 1e-11;

        /// <summary>
        /// A small number useful for comparisons, 1e-12
        /// </summary>
        public const double Epsilon12 = 1e-12;

        /// <summary>
        /// A small number useful for comparisons, 1e-13
        /// </summary>
        public const double Epsilon13 = 1e-13;

        /// <summary>
        /// A small number useful for comparisons, 1e-14
        /// </summary>
        public const double Epsilon14 = 1e-14;

        /// <summary>
        /// A small number useful for comparisons, 1e-15
        /// </summary>
        public const double Epsilon15 = 1e-15;

        /// <summary>
        /// A small number useful for comparisons, 1e-16
        /// </summary>
        public const double Epsilon16 = 1e-16;

        /// <summary>
        /// A small number useful for comparisons, 1e-17
        /// </summary>
        public const double Epsilon17 = 1e-17;

        /// <summary>
        /// A small number useful for comparisons, 1e-18
        /// </summary>
        public const double Epsilon18 = 1e-18;

        /// <summary>
        /// A small number useful for comparisons, 1e-19
        /// </summary>
        public const double Epsilon19 = 1e-19;

        /// <summary>
        /// A small number useful for comparisons, 1e-20
        /// </summary>
        public const double Epsilon20 = 1e-20;
    }
}
