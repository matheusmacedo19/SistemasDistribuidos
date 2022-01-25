package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Client.Client;

public interface Server extends Remote {
	
	public void addClient(Client client) throws RemoteException;
	public void messages(String message) throws RemoteException;
	
}
