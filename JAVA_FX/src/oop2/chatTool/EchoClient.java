package oop2.chatTool;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient extends Thread {

private ClientHandler ch;

public EchoClient(int portNumber, String hostname) throws UnknownHostException, IOException
{
	ch = new ClientHandler(new Socket(hostname,portNumber));
}

public void setMessage(String message)
{
	ch.setMessage(message);
}
}
