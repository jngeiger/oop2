package oop2.netzwerk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
	
	
	public static String hostName = "192.168.37.129";
	public static int portNumber = 9999;
	
	public static void main(String[] args)
	{
		try {
			Socket clientSocket = new Socket(hostName,portNumber);
			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			
			
			String userInput;
			String serverOutput;
			while ((userInput = stdIn.readLine()) != null) {
				
			    out.println(userInput);
			    serverOutput = in.readLine();
			    
			    System.out.println("echo: " + serverOutput);
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
