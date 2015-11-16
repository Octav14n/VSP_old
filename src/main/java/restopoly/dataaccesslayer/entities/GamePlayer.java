package restopoly.dataaccesslayer.entities;

/**
 * GamePlayer is a helper entity for game to save additional data for every Player.
 */
public class GamePlayer {
    private Player player;
    private Game game;
    private boolean ready;
    // every gameplayer has exactly one bankAccount.
    private BankAccount bankAccount;

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

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
