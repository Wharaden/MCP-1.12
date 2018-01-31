package client.modules.types;

import net.minecraft.network.Packet;

public interface PacketModifier {
	
	boolean modifyPacket(Packet packet);
	
}
