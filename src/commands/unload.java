package commands;

import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class unload  extends Command
{
	public unload() 
	{
        super("unload");
	}
	
    @Override
    public boolean execute(CommandSender commandSender, String s, String[] args) 
    {
    	Server.getInstance().getLevelByName("nether").unload();
    	return false;
    }
}
