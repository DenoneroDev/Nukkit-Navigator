package events;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.response.FormResponseSimple;
import cn.nukkit.level.Level;
import general.Main;

public class FormRespondedEvent implements Listener
{
    @EventHandler
    public void on(PlayerFormRespondedEvent event) 
    {
    	if(event.wasClosed()) 
    	{
    		return;
    	}
    	if(event.getFormID() == 1)
    	{
        	Player player = event.getPlayer();
        	FormResponseSimple response = (FormResponseSimple) event.getResponse();
        	String buttonTextString = response.getClickedButton().getText();
        	String buttonText = buttonTextString.replace("" + buttonTextString.charAt(0) + buttonTextString.charAt(1), "");
            
            Level world = Main.plugin.McServer.getLevelByName(buttonText);
            
            player.teleport(world.getSpawnLocation());
    	}
    }
}