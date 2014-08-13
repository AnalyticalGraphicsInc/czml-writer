package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;

/**
 *  
 Writes data to a  {@link CesiumOutputStream}.
 

 */
public class CesiumStreamWriter {
	private Lazy<PacketCesiumWriter> m_packetWriter = new Lazy<PacketCesiumWriter>(new Func1<PacketCesiumWriter>() {
		public PacketCesiumWriter invoke() {
			return new PacketCesiumWriter();
		}
	}, false);

	/**
	 *  
	Starts a new CZML packet on the given stream.
	
	
	

	 * @param output The stream to which to write the packet.
	 * @return The packet writer.
	 */
	public final PacketCesiumWriter openPacket(CesiumOutputStream output) {
		PacketCesiumWriter packetWriter = m_packetWriter.getValue();
		packetWriter.open(output);
		return packetWriter;
	}

	/**
	 *  Gets the  {@link PacketCesiumWriter} that this instances uses to write packets.
	The packet writer must be opened by calling  {@link CesiumElementWriter#open}
	before it can be use for writing.  Consider calling  {@link #openPacket} instead,
	which returns the same instance but opens it first.
	

	 */
	public final PacketCesiumWriter getPacketWriter() {
		return m_packetWriter.getValue();
	}
}