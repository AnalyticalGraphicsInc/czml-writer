using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using CesiumLanguageWriter;

namespace KmlToCesiumLanguage
{
    /// <summary>
    /// This is an abstract element and cannot be used directly. In KML, classes that extend this are Container, Overlay, Placemark, NetworkLink and gx:Tour. 
    /// </summary>
    public abstract class Feature
    {
        /// <summary>
        /// Writes this instance as a Cesium Language Packet.
        /// </summary>
        /// <param name="stream">The stream.</param>
        public abstract void WritePacket(CesiumOutputStream stream);
    }
}
