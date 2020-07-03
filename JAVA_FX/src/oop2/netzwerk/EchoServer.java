package oop2.netzwerk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws IOException {
        
		ServerSocket serverSocket =
                new ServerSocket(9999);
        
	        
	        try {
	        	while (true)
	        	{
	            
	            Socket clientSocket = serverSocket.accept();  
	            var t1 = new Thread() {
	    			private Socket clientSocket;
	             	public void run()
	             	{
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
	    						String temp ="";
	    						Integer value = 0;
	    						String result ="";
	    						int i = 0;
	    						for (i = 0; i < inputLine.length(); i++)
	    						{
	    							try {
	    							value = Integer.parseInt(inputLine.substring(0,i+1));
	    							}
	    					    	catch (Exception e)
	    							{
	    					    		result = inputLine.substring(i+1);
	    					    		if (value == 0)
	    					    		{
	    					    			temp = "Falsches Eingabeformat! Syntax:" + 
	    					    					"<count> <pattern>";
	    					    		}
	    					    		break;
	    							}
	    						}
	    						
	    						
	    						if (result.equals(""))
	    						{
	    							temp = "Falsches Eingabeformat! Syntax:" + 
	    									"<count> <pattern>";
	    							value = 0;
	    						}
	    						
	    						for (int j = 0; j < value; j++)
	    						{
	    							temp += result;
	    						}
	    						inputLine = temp;
	    							
	    					    out.println(inputLine);
	    					}
	    				} catch (IOException e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
	             	}};
	            t1.clientSocket = clientSocket;
	            t1.start();
	        	}
	        }
	        
	        		
	        
	         
	        
	           
	        catch (IOException e) {
	            System.out.println("Exception caught when trying to listen on port "
	                + "9999" + " or listening for a connection");
	            System.out.println(e.getMessage());
	        }
	    }

}


