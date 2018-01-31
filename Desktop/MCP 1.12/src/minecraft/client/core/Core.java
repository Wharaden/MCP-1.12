package client.core;

import client.Client;
import client.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

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
}
