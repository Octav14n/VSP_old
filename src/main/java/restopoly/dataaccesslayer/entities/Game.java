package restopoly.dataaccesslayer.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by octavian on 27.10.15.
 */
@JsonIgnoreProperties("currentPlayer")
public class Game {
    private int gameid;
    private @NotEmpty @NotNull List<Player> players;
    // every game has only one bank.
    private @NotNull Bank bank;

    public Game(int gameid) {
        this.gameid = gameid;
        players = new ArrayList<>();
    }

    public int getGameid() {
        return gameid;
    }

    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        for (Player player : this.players) {
            players.add(player);
        }
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void setReady(Player player, boolean ready) {
        for (Player gamePlayer : players) {
            if (gamePlayer.equals(gamePlayer)) {
                gamePlayer.setIsReady(ready);
                return;
            }
        }
    }

    public boolean getReady(Player player) {
        boolean isReady = false;
        for (Player gamePlayer : players) {
            if (gamePlayer.equals(player)) {
                if (gamePlayer.isReady() == true) {
                    isReady = true;
                }
            }
        }
        return isReady;
    }

    public Player getCurrentPlayer() {
        if (players.isEmpty()) {
            return null;
        }
        // Check that all players are ready.
        for (Player gamePlayer : players) {
            if (!gamePlayer.isReady()) {
                return null;
            }
        }
        Player currentPlayer = players.get(0);
        return currentPlayer;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
