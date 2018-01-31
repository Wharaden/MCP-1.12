package client.modules.module;

import org.lwjgl.input.Keyboard;

import client.Client;
import client.modules.Module;
import client.modules.types.PacketModifier;
import client.modules.types.Updatable;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;

public class NoFall extends Module implements Updatable, PacketModifier {

	public NoFall(Client client) {
		super(client, Keyboard.KEY_N, "NoFall");
	}

	@Override
	public void start() {
		getUtils().addChatText("§aNoFall");
	}

	@Override
	public void stop() {
		getUtils().addChatText("§cNoFall");
	}

	@Override
	public void update() {
		if(getPlayer().fallDistance >= 3) {
			sendPacket(new CPacketPlayer(true));
			getPlayer().fallDistance = (float) Math.random();
		}
	}

	@Override
	public boolean modifyPacket(Packet packet) {
		
		return false;
	}

}
