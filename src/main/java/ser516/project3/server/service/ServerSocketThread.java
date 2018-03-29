package ser516.project3.server.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import javax.websocket.EncodeException;

import ser516.project3.model.Message;
import ser516.project3.model.MessageEncoder;

public class ServerSocketThread extends Thread {
	protected Socket socket;

	public ServerSocketThread(Socket clientSocket) {
		this.socket = clientSocket;
	}

	public void run() {
		InputStream inp = null;
		BufferedReader buffInp = null;
		DataOutputStream out = null;
		try {
			inp = socket.getInputStream();
			buffInp = new BufferedReader(new InputStreamReader(inp));
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			return;
		}
		String line;
		while (true) {
			try {
				System.out.println("sending json");
//				line = buffInp.readLine();
//				if ((line == null) || line.equalsIgnoreCase("QUIT")) {
//					socket.close();
//					return;
//				} else {
//					out.writeBytes("Connected to Server!!" + "\n\r");
//					out.flush();
				Message msg = new Message();
				msg.setBlink(true);
				MessageEncoder encoder = new MessageEncoder();
				try (OutputStreamWriter osw = new OutputStreamWriter(
						socket.getOutputStream(), StandardCharsets.UTF_8)) {
					osw.write(encoder.encode(msg));
				} catch (EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
//				}
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}
