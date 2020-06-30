package oop2.chatTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.beans.property.SimpleStringProperty;

public class ClientHandler extends Thread {
private SimpleStringProperty output = new SimpleStringProperty();

	public ClientHandler(Socket socket) throws IOException
	{
		new InputHandler(socket.getInputStream()).start();
		new OutputHandler(socket.getOutputStream()).start();
	}
	
	public void setMessage(String value)
	{
		output.set(value);
	}
	
	
	class InputHandler extends Thread {
		InputHandler(InputStream input) throws IOException
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String s = "";
			while ((s = br.readLine()) != null)
			{
				System.out.println(s);
			}
		}
	}
	
	class OutputHandler extends Thread {
		OutputHandler(OutputStream output)
		{
			ClientHandler.this.output.addListener((obs,o,n) -> 
			{
				PrintWriter pw = new PrintWriter(output);
				pw.println(n);
			}
			);
		}
	}
}
