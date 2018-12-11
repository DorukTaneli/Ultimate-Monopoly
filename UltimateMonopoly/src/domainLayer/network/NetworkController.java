package domainLayer.network;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkController extends Thread {
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private int count;
	private String clientName;

	public NetworkController() {
		super("Network Controller");
	}
	
	public void connectToServer(int port) {
		try {
			System.out.println("Client connecting at "+ port);
			socket = new Socket("localhost",port);			
			out = new PrintWriter(socket.getOutputStream(),true);			
			in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	public void run () {
		
		String fromServer;
		String toServer;
	
				try {
			// get player name from the server
					
		    System.out.println("Client trying to get its name");
					
		    clientName = in.readLine();
		    
		    System.out.println("Client " + clientName + " started");
			while (true) {
				fromServer = in.readLine();
				String result = process(fromServer);
			    out.println(result);
				if (fromServer.equals("END")) {
					break;
				}
			}		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private String process(String fromServer) {
		if (++count == 10) {
			return "X";
		}	
		// simulate processing - wait for some randim time
		try {
			Thread.sleep((long)(Math.random() * 1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(clientName + " " + "processed " + count);
	    return clientName + " "+ fromServer+ " " + count;
	}
	
}