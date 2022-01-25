package Server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerMsg {
	ServerMsg() {
		try {
			LocateRegistry.createRegistry(32005); 
			Server server = new ServerTRA();
			Naming.rebind("rmi://127.0.0.1:32005/MessengerService", server);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ServerMsg();
	}
}
