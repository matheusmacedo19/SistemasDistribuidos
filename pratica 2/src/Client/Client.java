package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote {
	public void getMessage(String message) throws RemoteException;
}
