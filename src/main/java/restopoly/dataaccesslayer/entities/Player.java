package restopoly.dataaccesslayer.entities;

/**
 * Created by octavian on 13.10.15.
 */
public class Player {
    private String id;
    private String name;
    private Place place;

    public Player(String id, String name, Place place) {
        this.id = id;
        this.name = name;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Place getPlace() {
        return place;
    }
}
