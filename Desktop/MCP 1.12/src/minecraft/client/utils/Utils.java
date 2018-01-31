package client.utils;

import client.Client;
import client.core.Core;
import net.minecraft.util.text.TextComponentKeybind;

public class Utils extends Core {

	public Utils(Client client) {
		super(client);
	}

	public void addChatText(String text) {
		getPlayer().addChatMessage(new TextComponentKeybind(text));
	}
	
	public void showTitle(String l1, String l2) {
		if(l1 != null && !l1.isEmpty() && (l2 == null || l2.isEmpty())) {
			getMinecraft().ingameGUI.displayTitle(l1, null, 1, 1, 1);
		}
		
		if(l1 != null) {
			if(l2 != null) {
				getMinecraft().ingameGUI.displayTitle(l1, null, 1, 1, 1);
				getMinecraft().ingameGUI.displayTitle(null, l2, 1, 1, 1);
			} else {
				getMinecraft().ingameGUI.displayTitle(l1, null, 1, 1, 1);
			}
				
		}
	}
	
	public void showActionBar(String actionText) {
		getMinecraft().ingameGUI.setRecordPlaying(actionText, false);
	}
}
