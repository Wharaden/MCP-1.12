package client.packet;

import java.util.HashMap;
import java.util.Map;import java.util.Map.Entry;

import client.Client;
import client.core.Core;
import net.minecraft.network.Packet;

public class PacketHandler extends Core {

	private int packetCount;
	private HashMap<Class, Integer> count = new HashMap<>();
	
	public PacketHandler(Client client) {
		super(client);
		new Thread() {
			public void run() {
				while(true) {
					for(Map.Entry<Class, Integer> entries : count.entrySet()) {
						System.out.println(entries.getValue() + " of packet " + entries.getKey().getName());
					}
					System.out.println(" ");
					count.clear();
					try {sleep(1000);} catch (InterruptedException e) {}
				}
				
			};
		}.start();
	}

	public boolean handle(Packet packet) {
		if(count.containsKey(packet.getClass())) {
			count.put(packet.getClass(), count.get(packet.getClass()) + 1);
		} else {
			count.put(packet.getClass(), 1);
		}
		return getClient().getModuleManager().onPacketRecivied(packet);
	}
}
