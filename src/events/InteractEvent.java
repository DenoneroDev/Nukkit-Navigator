package events;

import java.util.Random;

import com.intellectualcrafters.plot.PS;

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
    	int PlayerPlotCount = PS.get().IMP.wrapPlayer(player).getPlotCount();
    	if(event.getItem().getName().equals("Compass"))
    	{
    		FormWindowSimple formOp = new FormWindowSimple(API.farbig("&bTeleportiere dich zu einer Welt"), API.farbig("&3Klicke auf den jeweiligen Knopf, um dich zu der gewünschten Welt zu Teleportieren"));
        	if(player.isOp())
        	{
        		Random random = new Random();
           	 	Main.plugin.getServer().getLevels().values().forEach((level) -> 
           	 	{
            		int color = random.nextInt(9);
            		formOp.addButton(new ElementButton(API.farbig("&" + color + level.getName())));
           	 	});
           	 	if(PlayerPlotCount == 1)
           	 	{
           	 		formOp.addButton(new ElementButton(API.farbig("&5Plot")));
           	 	}
           	 	if(PlayerPlotCount >= 2)
           	 	{
           	 		formOp.addButton(new ElementButton(API.farbig("&9Plot 2")));
           	 	}
            	player.showFormWindow(formOp, 1);
        	}
        	else
        	{	
            	FormWindowSimple form = new FormWindowSimple(API.farbig("&bTeleportiere dich zu einer Welt"), API.farbig("&3Klicke auf den jeweiligen Knopf, um dich zu der gewünschten Welt zu Teleportieren"));
           	 	if(PlayerPlotCount == 1)
           	 	{
           	 		form.addButton(new ElementButton(API.farbig("&5Plot")));
           	 	}
           	 	if(PlayerPlotCount >= 2)
           	 	{
           	 		form.addButton(new ElementButton(API.farbig("&9Plot 2")));
           	 	}
        		
            	form.addButton(new ElementButton(API.farbig("&1nether")));
            	form.addButton(new ElementButton(API.farbig("&3farmwelt")));
            	form.addButton(new ElementButton(API.farbig("&2stollen")));
            	form.addButton(new ElementButton(API.farbig("&4hub")));
            	form.addButton(new ElementButton(API.farbig("&0end")));
            	form.addButton(new ElementButton(API.farbig("&0CityBuild")));
            	player.showFormWindow(form, 1);
        	}
    	}
    }
}