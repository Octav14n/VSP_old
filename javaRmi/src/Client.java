import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by octavian on 13.10.15.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // Zugriff auf die Interface-Registry erhalten
        // Standard-Port: TCP; 1099
        Registry registry = LocateRegistry.getRegistry();

        // Aus der Registry holen wir uns das Remote-Objekt welches als "dice" abgelegt wurde.
        // Dieses Object ist nicht in der aktuellen Instanz vorhanden. (das Interface aber schon)
        DiceRMI dice = (DiceRMI) registry.lookup("dice");

        // Von dem Remote-Objekt eine Funktion aufrufen und die Rückgabe ausgeben.
        System.out.println(dice.roll().getNumber());
    }
}
