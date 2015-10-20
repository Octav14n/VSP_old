package restopoly.jail;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import restopoly.player.Player;

import java.util.ArrayList;

/**
 * Created by octavian on 13.10.15.
 */
@RestController
public class Jail {
    private ArrayList<Player> inmates = new ArrayList<>();
    @RequestMapping(value = "/jail/add/{player}", method = RequestMethod.GET)
    public void addInmate(Player player) {
        inmates.add(player);
    }

    @RequestMapping(value = "/jail", method = RequestMethod.GET)
    public ArrayList<Player> showInmates() {
        return inmates;
    }
}
