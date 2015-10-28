package restopoly.dataaccesslayer.entities;

/**
 * GamePlayer is a helper entity for game to save additional data for every Player.
 */
public class GamePlayer {
    private Player player;
    private Game game;
    private boolean ready;

    public GamePlayer(Player player, Game game) {
        this.player = player;
        this.game = game;
        this.ready = false;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public Player getPlayer() {
        return player;
    }

    public Game getGame() {
        return game;
    }

    public boolean isReady() {
        return ready;
    }
}