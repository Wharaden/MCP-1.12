package client;

import client.utils.Utils;
import net.minecraft.client.Minecraft;

public class Client {

	private Minecraft minecraft;
	private Utils utils;
	
	public Client(Minecraft minecraft) {
		this.minecraft = minecraft;
		this.utils = new Utils(this);
	}
	
	public Minecraft getMinecraft() {
		return minecraft;
	}
	
	public Utils getUtils() {
		return utils;
	}
	
}
