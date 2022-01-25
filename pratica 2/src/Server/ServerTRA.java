package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Client.Client;

public class ServerTRA extends UnicastRemoteObject implements Server {

	private static final long serialVersionUID = 518874729652256368L;
	private List<Client> clients;

	protected ServerTRA() throws RemoteException{
		clients = new ArrayList<>();
	}

	@Override
	public synchronized void addClient(Client client) throws RemoteException {
		this.clients.add(client);
	}

	@Override
	public synchronized void messages(String message) throws RemoteException {
		for (Client client : clients) {
			client.getMessage(message);
		}
	}
}
