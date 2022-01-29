package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import Server.Server;

public class ClientTRA extends UnicastRemoteObject implements Client, Runnable {
	
	private static final long serialVersionUID = 4804675865338914646L;
	
	private String name = "";
	private Server server;
	
	protected ClientTRA() throws RemoteException {
		super();
	}

	public ClientTRA(String name, Server server) throws RemoteException {
		this.name = name;
		this.server = server;
		server.addClient(this);
	}

	@Override
	public void getMessage(String message) throws RemoteException {
		System.out.println(message + "\n");
	}
	

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		String message = "";
		
		while(true) {
			System.out.print(name+": \n");
			message = scanner.nextLine();
			
			try {
				server.messages(name + ": " + message + "\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
