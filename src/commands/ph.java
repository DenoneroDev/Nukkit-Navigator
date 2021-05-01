package commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
import general.Main;

public class ph  extends Command
{
	public ph() 
	{
        super("ph");
	}
	
    @Override
    public boolean execute(CommandSender commandSender, String s, String[] args) 
    {
    	Player sender = (Player) commandSender;
    	Level world = Main.plugin.McServer.getLevelByName("CityBuild");
    	sender.teleport(world.getSpawnLocation());
    	
    	return false;
    }
}
