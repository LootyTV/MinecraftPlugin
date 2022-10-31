package pluginforserver.pluginforserver;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import pluginforserver.pluginforserver.Tasks.HourHasWentBy;

public class Pluginforserver extends JavaPlugin
{
    public int time = 0;
    @Override
    public void onEnable()
    {
        Bukkit.getLogger().info("Start!");
        startTimer();
    }

    public void startTimer()
    {
        BukkitTask timeUp = new HourHasWentBy(this).runTaskLater(this, 1200L); //72000
    }
}