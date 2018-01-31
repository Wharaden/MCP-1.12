package client.modules;

import client.Client;
import client.core.Core;

public abstract class Module extends Core {

	private boolean toggled;
	private int keybind;
	private String moduleName;
	
	public Module(Client client, int keybind, String moduleName) {
		super(client);
		this.keybind = keybind;
		this.moduleName = moduleName;
	}
	
	public boolean isToggled() {
		return toggled;
	}

	public int getKeybind() {
		return keybind;
	}
	
	public abstract void start();
	public abstract void stop();
	
	public void toggle() {
		if(toggled) {
			stop();
			toggled = false;
		} else {
			start();
			toggled = true;
		}
	}
	
	public String getModuleName() {
		return moduleName;
	}
}
