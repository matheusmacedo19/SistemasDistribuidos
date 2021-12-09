package ClientServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
	public Socket client;

	public Server(Socket client) {
		this.client = client;
	}

	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(9876);
		int i = 0;
		while (true) {

			Socket client = server.accept();
			Server treatment = new Server(client);
			Thread thread = new Thread(treatment);
			thread.start();
			i++;
			if (i > 3) {
				server.close();
			}

		}

	}

	public void run() {
		try {


			int[] listNumReceived = new int[1000000];
			int sum = 0;
			
			long timeProcess = System.currentTimeMillis();

			ObjectInputStream input = new ObjectInputStream(client.getInputStream());
			listNumReceived = (int[]) input.readObject();

			for (int i = 0; i < 1000000; i++) {
				sum += listNumReceived[i];
			}

			ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
			System.out.println("[Servidor] Resultado enviado!");
			output.writeObject(sum);
			
			System.out.println("Tempo de processamento total: " + (System.currentTimeMillis() - timeProcess) + "ms" );

			input.close();
			output.close();
			client.close();

		} catch (Exception ex) {

		}
	}
}