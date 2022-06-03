package com.snat.minigames;

import com.snat.minigames.commands.ArenaCommand;
import com.snat.minigames.listener.ConnectListener;
import com.snat.minigames.listener.GameListener;
import com.snat.minigames.manager.ArenaManager;
import com.snat.minigames.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Minigame extends JavaPlugin {


    private ArenaManager arenaManager;

    @Override
    public void onEnable() {
        ConfigManager.setUpConfig(this);
        arenaManager = new ArenaManager(this);


        Bukkit.getPluginManager().registerEvents(new ConnectListener(this), this);
        Bukkit.getPluginManager().registerEvents(new GameListener(this), this);

        getCommand("arena").setExecutor(new ArenaCommand(this));

    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }
}
