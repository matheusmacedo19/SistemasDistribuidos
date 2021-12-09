package ClientServer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class Client {

	public void sentClient() {
		try {
			
			int [] listNumSend = new int[1000000];

			Random random = new Random();

			for (int i = 0; i < 1000000; i++) {
				listNumSend[i] = random.nextInt(1000);
			}
						
			Socket socket = new Socket("127.0.0.1", 9876);
			
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			Object sendMessage = listNumSend;
			output.writeObject(sendMessage);

			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			Object message = (int) input.readObject();
			System.out.println("[Cliente] Recebido: " + message);

			input.close();
			output.close();
			socket.close();	
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	
	
	public static void main(String[] args) {
				
		Client client1 = new Client();
		Client client2 = new Client();
		Client client3 = new Client();
		
		client1.sentClient();
		client2.sentClient();
		client3.sentClient();
		
			}
}
