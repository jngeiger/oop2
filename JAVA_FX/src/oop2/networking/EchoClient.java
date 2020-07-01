package oop2.networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
	public static String hostName = "192.168.37.129";
	public static int portNumber = 9999;
	
	public static void launch()
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
			    if (serverOutput.contains("code1"))
				{
			    	System.out.println("Server closed Connection, terminating");
					return;
				}
			    System.out.println("echo: " + serverOutput);
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
