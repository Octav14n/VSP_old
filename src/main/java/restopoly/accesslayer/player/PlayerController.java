package restopoly.accesslayer.player;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restopoly.dataaccesslayer.entities.Place;
import restopoly.dataaccesslayer.entities.Player;
import restopoly.dataaccesslayer.entities.PlayerList;

import java.util.List;

/**
 * Created by octavian on 27.10.15.
 */
@RestController
public class PlayerController {
    private PlayerList playerList = new PlayerList();

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public List<Player> getPlayers() {
        return playerList.getPlayers();
    }

    @RequestMapping(value = "/players", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Player addPlayer(String playerId, String name, Place place) {
        return playerList.addPlayer(playerId, name, place);
    }

    @RequestMapping(value = "/players/{playerId}", method = RequestMethod.GET)
    public Player getPlayer(@PathVariable String playerId) {
        return playerList.getPlayer(playerId);
    }
}
