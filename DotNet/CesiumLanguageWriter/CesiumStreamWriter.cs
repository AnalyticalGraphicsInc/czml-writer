using System;
using CesiumLanguageWriter.Advanced;

namespace CesiumLanguageWriter
{
    /// <summary>
    /// Writes data to a <see cref="CesiumOutputStream"/>.
    /// </summary>
    public class CesiumStreamWriter
    {
        private readonly Lazy<PacketCesiumWriter> m_packetWriter = new Lazy<PacketCesiumWriter>(() => new PacketCesiumWriter(), false);

        /// <summary>
        /// Starts a new CZML packet on the given stream.
        /// </summary>
        /// <param name="output">The stream to which to write the packet.</param>
        /// <returns>The packet writer.</returns>
        public PacketCesiumWriter OpenPacket(CesiumOutputStream output)
        {
            PacketCesiumWriter packetWriter = m_packetWriter.Value;
            packetWriter.Open(output);
            return packetWriter;
        }

        /// <summary>
        /// Gets the <see cref="PacketCesiumWriter"/> that this instances uses to write packets.
        /// The packet writer must be opened by calling <see cref="CesiumElementWriter.Open"/>
        /// before it can be use for writing.  Consider calling <see cref="OpenPacket"/> instead,
        /// which returns the same instance but opens it first.
        /// </summary>
        public PacketCesiumWriter PacketWriter
        {
            get { return m_packetWriter.Value; }
        }
    }
}