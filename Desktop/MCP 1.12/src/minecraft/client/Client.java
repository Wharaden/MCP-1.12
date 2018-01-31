package client;

import client.modules.ModuleManager;
import client.packet.PacketHandler;
import client.utils.ClientInfo;
import client.utils.Utils;
import net.minecraft.client.Minecraft;

public class Client {

	private Minecraft minecraft;
	private Utils utils;
	private ClientInfo infos;
	private ModuleManager moduleManagers;
	private PacketHandler packetHandler;
	
	public Client(Minecraft minecraft) {
		this.minecraft = minecraft;
		this.infos = new ClientInfo();
		this.utils = new Utils(this);
		this.moduleManagers = new ModuleManager(this);
		this.packetHandler = new PacketHandler(this);
	}
	
	public Minecraft getMinecraft() {
		return minecraft;
	}
	
	public Utils getUtils() {
		return utils;
	}
	
	public ClientInfo getInfos() {
		return infos;
	}
	
	public ModuleManager getModuleManager() {
		return moduleManagers;
	}

	public PacketHandler getPacketHandler() {
		return packetHandler;
	}
}
