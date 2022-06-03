package com.snat.minigames.instance;

import com.snat.minigames.GameState;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Game {

    private Arena arena;
    private HashMap<UUID, Integer> points;



    public Game(Arena arena) {
        this.arena = arena;
        points = new HashMap<>();
    }

    public void start() {
        arena.setState(GameState.LIVE);
        arena.sendMessage(ChatColor.GREEN + "Game has started, your objective is to break 20 blocks in the fastest time, good luck!");

        for (UUID uuid : arena.getPlayers()) {
            points.put(uuid, 0);
        }
    }
    public void addPoint(Player player) {
        int playerPoints = points.get(player.getUniqueId()) + 1;
        if (playerPoints == 20) {
            arena.sendMessage(ChatColor.GOLD + player.getName() + "Has Won! Thanks for playing!");
            arena.reset(true);
            return;

        }
        player.sendMessage(ChatColor.GREEN + "1 point");
        points.replace(player.getUniqueId(), playerPoints);

    }

}
