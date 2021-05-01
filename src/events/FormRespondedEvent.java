package events;

import cn.nukkit.Player;
import cn.nukkit.Server;
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
            if(buttonText.equals("Plot"))
            {
            	Server.getInstance().dispatchCommand(player, "ph");
            	return;
            }
            Level world = Main.plugin.McServer.getLevelByName(buttonText);
            
            if (world == null)
            {
                if (!Main.plugin.McServer.loadLevel(buttonText)) 
                {
                    player.sendMessage("&4Diese Welt konnte nicht geladen werden!");
                    return;
                }
                return;
            }
            try
            {
            	player.teleport(world.getSpawnLocation());
            }
            catch(NullPointerException e)
            {
            	player.sendMessage("&4Die Welt wird grade resettet!");
            }
    	}
    }
}