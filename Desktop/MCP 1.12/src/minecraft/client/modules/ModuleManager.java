package client.modules;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import client.Client;
import client.modules.module.NoFall;
import client.modules.types.PacketModifier;
import client.modules.types.Updatable;
import net.minecraft.network.Packet;

public class ModuleManager extends ArrayList<Module> {

	private Client client;
	
	public ModuleManager(Client client) {
		this.client = client;
		register();
	}
	
	private void register() {
		add(new NoFall(client));
	}
	
	public boolean isToogled(String moduleName) {
		Module m = getModule(moduleName);
		return m != null ? m.isToggled() : false;
	}
	
	public void keyPressedEvent() {
		for(Module m : this) {
			if(Keyboard.isKeyDown(m.getKeybind())) {
				m.toggle();
			}
		}
	}
	
	private Module getModule(String moduleName) {
		for(Module module : this) {
			if(module.getModuleName().equalsIgnoreCase(moduleName)) {
				return module;
			}
		}
		
		System.out.println("Module not found");
		return null;
	}
	
	public void onUpdate() {
		for(Module module : this) {
			if(!module.isToggled())
				break;
			
			if(module instanceof Updatable) {
				((Updatable) module).update();
			}
		}
	}
	
	public boolean onPacketRecivied(Packet packet) {
		boolean cancelled = false;
		for(Module module : this) {
			if(!module.isToggled())
				break;
			
			if(module instanceof PacketModifier) {
				boolean packetCancelled = ((PacketModifier) module).modifyPacket(packet);
				if(!cancelled && packetCancelled)
					cancelled = true;
			}
		}
		
		return cancelled;
	}
}
