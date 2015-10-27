package restopoly.accesslayer.games;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/games")
public class GamesController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public void getGames() {

    }
}
