package events;

import java.util.Random;

import Hagbrain.API;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.window.FormWindowSimple;
import general.Main;

public class InteractEvent  implements Listener
{
    @EventHandler
    public void on(PlayerInteractEvent event) 
    {
    	Player player = event.getPlayer();
    	if(event.getItem().getName().equals("Compass"))
    	{
    		FormWindowSimple form = new FormWindowSimple(API.farbig("&bTeleportiere dich zu einer Welt"), API.farbig("&3Klicke auf den jeweiligen Knopf, um dich zu der gewünschten Welt zu Teleportieren"));
        	if(player.isOp())
        	{
        		Random random = new Random();
           	 	Main.plugin.getServer().getLevels().values().forEach((level) -> 
           	 	{
            		int color = random.nextInt(9);
            		form.addButton(new ElementButton(API.farbig("&" + color + level.getName())));
           	 	});
            	
            	player.showFormWindow(form, 1);
            	return;
        	}
        	form.addButton(new ElementButton(API.farbig("&1nether")));
        	form.addButton(new ElementButton(API.farbig("&3farmwelt")));
        	form.addButton(new ElementButton(API.farbig("&2stollen")));
        	form.addButton(new ElementButton(API.farbig("&4hub")));
        	form.addButton(new ElementButton(API.farbig("&0end")));
        	player.showFormWindow(form, 1);
    	}
    }
}