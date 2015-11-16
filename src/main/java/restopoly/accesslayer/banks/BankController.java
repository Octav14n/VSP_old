package restopoly.accesslayer.banks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restopoly.accesslayer.games.GamesController;
import restopoly.dataaccesslayer.entities.*;

/**
 * This controller will handle the bank for every single game. Every bank
 * has more than one BankAccount. Every Player at the game has one of these BankAccounts.
 * <p>
 * Created by Patrick Steinhauer on 16.11.2015.
 */
@RestController
public class BankController {

    @Autowired
    private GamesController gamesController;

    /**
     * TODO: Klaeren mit Simon. Vergleich des URI im Requestmapping mit dem von Andrej in der Aufgabe.
     */
    @RequestMapping(value = "/banks/{gameid}/players/{playerid}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createBankAccount(@PathVariable int gameid, @PathVariable String playerid, int bankAccountId, String bankOwner, String IBAN, String BIC) {
        BankAccount account = new BankAccount(bankAccountId, bankOwner, IBAN, BIC);
        for (Game game : gamesController.getGames()) {
            if (game.getGameid() == gameid) {
                for (Player player : game.getPlayers()) {
                    if (player.getId() == playerid) {
                        // TODO: connect gameplayer with bankaccount (how can we set the account to the player)
                    }
                }
            }
        }
    }

//    @RequestMapping(value = "/banks/{gameid}/players/{playerid}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public BankAccount getBankAccount(@PathVariable int gameid, @PathVariable int playerid) {
//        return null;
//    }
}
