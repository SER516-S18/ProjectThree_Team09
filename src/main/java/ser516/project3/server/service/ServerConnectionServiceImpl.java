package ser516.project3.server.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnectionServiceImpl implements ServerConnectionServiceInterface {

	private static final int PORT = 1516;

	@SuppressWarnings("resource")
	@Override
	public void createServerSocketThread() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (true) {
			try {
				socket = serverSocket.accept();
			} catch (IOException e) {
				System.out.println("I/O error: " + e);
			}
			
			new ServerSocketThread(socket).start();
		}

	}
	
	/**
	 * Just for testing purposes
	 * @param args
	 */
	public static void main(String[] args) {
		new ServerConnectionServiceImpl().createServerSocketThread();
	}

}
