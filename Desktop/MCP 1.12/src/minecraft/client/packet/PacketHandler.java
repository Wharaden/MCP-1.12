package client.packet;

import java.util.Timer;
import java.util.TimerTask;

import client.Client;
import client.core.Core;
import net.minecraft.network.Packet;

public class PacketHandler extends Core {

	private int packetCount;
	
	public PacketHandler(Client client) {
		super(client);
		new Thread() {
			public void run() {
				while(true) {
					System.out.println(packetCount + " this second");
					packetCount = 0;
					try {sleep(1000);} catch (InterruptedException e) {}
				}
				
			};
		}.start();
	}

	public boolean handle(Packet packet) {
		packetCount++;
		return getClient().getModuleManager().onPacketRecivied(packet);
	}
}
