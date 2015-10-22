import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.security.AccessController;

/**
 * Created by octavian on 13.10.15.
 */
public class Dice extends UnicastRemoteObject implements DiceRMI {
    public Dice() throws RemoteException {
        super();
    }

    @Override public Roll roll() throws RemoteException {
        int zufallsZahl = 4; // Durch einen imaginaeren Wuerfel zufaellig ermittelt. (https://xkcd.com/221/)
        Roll r = new Roll(zufallsZahl);
        return r;
    }

    public static void main(String[] args) throws Exception {
        // Registry analog zu "Client" erstellen, und den standard-Port zuweisen.
        LocateRegistry.createRegistry(Registry.REGISTRY_PORT);

        // Dice erstellen ...
        Dice dice = new Dice();

        // Dice als RMI für Unicast exportieren.

        // DiceRMI erweitert UnicastRemoteObject, desshalb muss "Dice" nicht explizit/doppelt als UnicastRO angegeben werden.
        // DiceRMI stub = (DiceRMI) UnicastRemoteObject.exportObject(dice, 0);
        RemoteServer.setLog( System.out );

        // Registry erstellen und unseren Dice anmelden.
        Registry registry = LocateRegistry.getRegistry();
        registry.rebind("dice", dice);

        System.out.println ("Service bound....");
    }
}
