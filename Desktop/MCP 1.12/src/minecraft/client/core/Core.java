package client.core;

import client.Client;
import client.utils.ClientInfo;
import client.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.Packet;

public class Core {

	private Client client;
	
	public Core(Client client) {
		this.client = client;
	}
	
	public Client getClient() {
		return client;
	}
	
	public Minecraft getMinecraft() {
		return getClient().getMinecraft();
	}
	
	public Utils getUtils() {
		return getClient().getUtils();	
	}
	
	public EntityPlayerSP getPlayer() {
		return getMinecraft().player;
	}
	
	public ClientInfo getClientInfo() {
		return getClient().getInfos();
	}
	
	public void sendPacket(Packet packet) {
		getPlayer().connection.sendPacket(packet);
	}
}
