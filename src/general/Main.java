package general;

import java.io.PrintStream;

import cn.nukkit.Server;
import cn.nukkit.command.CommandMap;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;

public class Main extends PluginBase
{
	public PrintStream console = System.out;
	public static Main plugin;
	public Server McServer = Server.getInstance();
	public void onEnable()
	{
		plugin = this;
		console.println("\nNavigator wird geladen...\n");
		registerEvents();
		registerCommands();
	}
	
    private void registerEvents()
    {
        PluginManager eventMap = McServer.getPluginManager();
        eventMap.registerEvents(new events.FormRespondedEvent(), (Plugin) plugin);
        eventMap.registerEvents(new events.InteractEvent(), (Plugin) plugin);
    }
    private void registerCommands() 
    {
    	CommandMap commandMap = this.getServer().getCommandMap();
    	commandMap.register("", new commands.unload());
    	commandMap.register("", new commands.ph());
    }
}
