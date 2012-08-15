using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GeometricComputations
{
    /// <summary>
    /// Specifies the order for positions. 
    /// </summary>
    public enum WindingOrder
    {
        /// <summary>
        /// Positions are defined in clockwise order. 
        /// </summary>
        ClockWise = 0,
        /// <summary>
        /// Positions or triangles are defined in counter-clockwise order. 
        /// </summary>
        CounterClockWise = 1
    }
}
