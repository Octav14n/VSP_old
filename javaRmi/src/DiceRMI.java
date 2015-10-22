import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by octavian on 13.10.15.
 */
public interface DiceRMI extends Remote {
    Roll roll() throws RemoteException;
}
