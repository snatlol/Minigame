package com.snat.minigames.listener;

import com.snat.minigames.GameState;
import com.snat.minigames.Minigame;
import com.snat.minigames.instance.Arena;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class GameListener implements Listener {


    private Minigame minigame;
    public GameListener(Minigame minigame) {
        this.minigame = minigame;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {

        Arena arena = minigame.getArenaManager().getArena(e.getPlayer());
        if (arena != null && arena.getState() == GameState.LIVE) {
            arena.getGame().addPoint(e.getPlayer());
        }

    }

}
