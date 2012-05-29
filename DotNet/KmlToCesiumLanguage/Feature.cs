using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// This is an abstract element and cannot be used directly. In Kml, classes that extend this are Container, Overlay, Placemark, NetworkLink and gx:Tour 
    /// </summary>
    public abstract class Feature
    {
        /// <summary>
        /// Writes this instance as a Cesium Language Packet.
        /// </summary>
        public abstract void WritePacket();
    }
}
