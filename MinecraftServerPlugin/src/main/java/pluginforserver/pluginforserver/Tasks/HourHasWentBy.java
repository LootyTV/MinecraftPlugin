package pluginforserver.pluginforserver.Tasks;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pluginforserver.pluginforserver.Pluginforserver;
import

import java.io.File;
import java.util.Collection;

public class HourHasWentBy extends BukkitRunnable
{
    Pluginforserver plugin;
    MultiverseCore core = (MultiverseCore) Bukkit.getServer().getPluginManager().getPlugin("Multiverse-Core");

    public HourHasWentBy(Pluginforserver plugin)
    {
        this.plugin = plugin;
    }

    @Override

    public void run()
    {

        final Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        for (Player player : players)
        {
            Location loc = new Location(plugin.getServer().getWorld("WaitingRoom"), plugin.getServer().getWorld("WaitingRoom").getSpawnLocation().getX(), plugin.getServer().getWorld("WaitingRoom").getSpawnLocation().getY(), plugin.getServer().getWorld("WaitingRoom").getSpawnLocation().getZ());
            player.teleport(loc);
        }

        deleteWorld();

    }

    public void deleteWorld()
    {
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mv delete LoopSpace");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mv confirm");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mv create LoopSpace NORMAL -s 7644964991330705060");

        final Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        for (Player player : players)
        {
            Location loc = new Location(plugin.getServer().getWorld("world"), plugin.getServer().getWorld("world").getSpawnLocation().getX(), plugin.getServer().getWorld("world").getSpawnLocation().getY(), plugin.getServer().getWorld("world").getSpawnLocation().getZ());
            player.teleport(loc);
        }
    }
}