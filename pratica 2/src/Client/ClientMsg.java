package Client;

import java.rmi.Naming;
import java.util.Scanner;

import Server.Server;

public class ClientMsg {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String name = "";
		
		try {
			
			Server server = (Server) Naming.lookup("rmi://127.0.0.1:32005/MessengerService");
			System.out.println("Digite seu nome:");
			name = scanner.nextLine();
			
			new Thread(new ClientTRA(name, server)).run();
			
		}catch (Exception ex) {
			System.out.println(ex);
		}
	}
}