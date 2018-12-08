package domainLayer.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientServer implements Runnable {

	
	Socket client;
	String name;
	protected BufferedReader in;
	protected PrintWriter out;
	
	public ClientServer (Socket client, String name) {
		this.client = client;
		this.name = name;
		try {
			out = new PrintWriter(client.getOutputStream(),true);
			in =  new BufferedReader(new InputStreamReader(client.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	@Override
	public void run() {
		String response;
		out.println(name);
		while(true) {
			 
			 try {
				out.println("Your turn");
				// get client response
				response = in.readLine();
				System.out.println(response);
				if (response.equals("X")) {
			         out.println("END");
					 break;
			    }
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	

}