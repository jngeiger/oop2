package oop2.chatTool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer extends Thread {
private ServerSocket socket;
	
	public EchoServer(int portNumber) throws IOException
	{
		socket = new ServerSocket(portNumber);
	}
	
	public void run()
	{
		while(socket != null)
		{
			try {
				Socket socket = this.socket.accept();
				ClientHandler ch = new ClientHandler(socket);
				ch.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
}
