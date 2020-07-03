package oop2.chatTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class EchoServer extends Thread {
	ServerSocket serverSocket;
	private Socket clientSocket;
	public ArrayList<String> al;
	
	
	
	public EchoServer(int pn) throws IOException
	{
		serverSocket = new ServerSocket(pn);
		al = new ArrayList<String>();
	}
	public void run()
	{
		var t1 = new Thread() {
			public void run()
			{
				try {
		        	while (true)
		        	{
		        	System.out.println("SERVER STARTET");
		            
		            Socket clientSocket = serverSocket.accept();  
		    			
		             	
		             		PrintWriter out = null;
		    				try {
		    					out = new PrintWriter(clientSocket.getOutputStream(), true);
		    				} catch (IOException e1) {
		    					// TODO Auto-generated catch block
		    					e1.printStackTrace();
		    				}                   
		         	            BufferedReader in = null;
		    					try {
		    						in = new BufferedReader(
		    						    new InputStreamReader(clientSocket.getInputStream()));
		    					} catch (IOException e1) {
		    						// TODO Auto-generated catch block
		    						e1.printStackTrace();
		    					}
		             	
		             		String inputLine;
		     	            
		     	            try {
		    					while ((inputLine = in.readLine()) != null) {	
		    					    al.add(inputLine);
		    					}
		    				} catch (IOException e) {
		    					// TODO Auto-generated catch block
		    					e.printStackTrace();
		    				}
		             
		        	}
			}
				catch (IOException e) {
		            System.out.println("Exception caught when trying to listen on port " + " or listening for a connection");
		            System.out.println(e.getMessage());
		        }
		
        
        }
       
    };
    t1.start();
    }
	
	public ArrayList<String> getal()
	{
		return this.al;
	}
}
