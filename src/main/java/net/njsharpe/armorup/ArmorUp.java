package net.njsharpe.armorup;

import net.njsharpe.armorup.listener.SmithingTableListener;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("UnstableApiUsage")
public class ArmorUp extends JavaPlugin {

    private static ArmorUp instance;

    private final String pluginName = this.getPluginMeta().getName();

    @Override
    public void onEnable() {
        super.onEnable();
        instance = this;
        this.getLogger().info(this.pluginName + " Loaded!");

        this.getServer().getPluginManager().registerEvents(new SmithingTableListener(), this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        instance = null;
        this.getLogger().info(this.pluginName + " Unloaded!");
    }

    public static ArmorUp getInstance() {
        return instance;
    }

}
