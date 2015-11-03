import java.io.Serializable;

/**
 * Created by octavian on 13.10.15.
 */
public class Roll implements Serializable {
    private static final long serialVersionUID = 1337L;
    private int number;

    public Roll(int number) { this.number = number; }

    public int getNumber() { return this.number; }
}
