package client.core;

import client.Client;
import net.minecraft.client.Minecraft;

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
}
