package ser516.project3.client.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.websocket.DecodeException;

import ser516.project3.model.Message;
import ser516.project3.model.MessageDecoder;
import ser516.project3.model.MessageEncoder;

public class ClientSocketThread implements Runnable {
	
	private int port;
	private String hostName;
	private Socket clientSocket;
	private BufferedReader inputReader = null;
	private PrintWriter outputStream = null;
	private boolean clientStatus = false;
	
	public ClientSocketThread(String hostName, int port) {
		this.port = port;
		this.hostName = hostName;
	}

	@Override
	public void run() {
		try {
			clientSocket = new Socket(hostName, port);
			inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			outputStream = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clientStatus = true;
		while (clientStatus) {
			String inputLine;
			try {
				while ((inputLine = inputReader.readLine()) != null) {
					
					//TODO: Use the below demarshaled data somewhere
					MessageDecoder decoder = new MessageDecoder();
					Message msg = decoder.decode(inputLine);
					
					System.out.println(msg);
					
					outputStream.println("QUIT");
					if (!clientStatus) {
						break;
					}
				}
			} catch (IOException | DecodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {
			clientSocket.close();
			outputStream.println("QUIT");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
