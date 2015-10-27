package restopoly.dataaccesslayer.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by octavian on 27.10.15.
 */
public class Game {
    private int gameid;
    private List<GamePlayer> gamePlayers;

    public Game(int gameid) {
        this.gameid = gameid;
        gamePlayers = new ArrayList<>();
    }

    public int getGameid() {
        return gameid;
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        for (GamePlayer gamePlayer : gamePlayers) {
            players.add(gamePlayer.getPlayer());
        }
        return players;
    }

    public void addPlayer(Player player) {
        gamePlayers.add(new GamePlayer(player, this));
    }

    public void setReady(Player player, boolean ready) {
        for (GamePlayer gamePlayer : gamePlayers) {
            if (gamePlayer.getPlayer().equals(player)) {
                gamePlayer.setReady(ready);
                return;
            }
        }
    }
}
