package client;

import net.minecraft.client.Minecraft;

public class Client {

	private Minecraft minecraft;
	
	public Client(Minecraft minecraft) {
		this.minecraft = minecraft;
	}
	
	public Minecraft getMinecraft() {
		return minecraft;
	}
	
}
