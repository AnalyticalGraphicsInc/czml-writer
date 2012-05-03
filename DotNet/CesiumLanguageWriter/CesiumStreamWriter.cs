using System;
#if StkComponents
using AGI.Foundation.Cesium.Advanced;
#else
using CesiumLanguageWriter.Advanced;
#endif

#if StkComponents
namespace AGI.Foundation.Cesium
#else
namespace CesiumLanguageWriter
#endif
{
    /// <summary>
    /// Writes <topic name="Cesium">Cesium</topic> data to a <see cref="CesiumOutputStream"/>.
    /// </summary>
    public class CesiumStreamWriter
    {
        private readonly Lazy<CesiumPacketWriter> m_packetWriter = new Lazy<CesiumPacketWriter>(() => new CesiumPacketWriter(), false);

        /// <summary>
        /// Starts a new <topic name="Cesium">Cesium</topic> packet on the given stream.
        /// </summary>
        /// <param name="output">The stream to which to write the packet.</param>
        /// <returns>The packet writer.</returns>
        public CesiumPacketWriter OpenPacket(CesiumOutputStream output)
        {
            CesiumPacketWriter packetWriter = m_packetWriter.Value;
            packetWriter.Open(output);
            return packetWriter;
        }

        /// <summary>
        /// Gets the <see cref="CesiumPacketWriter"/> that this instances uses to write packets.
        /// The packet writer must be opened by calling <see cref="CesiumElementWriter.Open"/>
        /// before it can be use for writing.  Consider calling <see cref="OpenPacket"/> instead,
        /// which returns the same instance but opens it first.
        /// </summary>
        public CesiumPacketWriter PacketWriter
        {
            get { return m_packetWriter.Value; }
        }
    }
}
