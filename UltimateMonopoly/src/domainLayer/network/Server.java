package domainLayer.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server extends Thread{
	
	int port;
	int playerNum;
	Thread[] clients;
	
	public Server(int port) {
		this.port = port;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter num of players:");
		playerNum = Integer.parseInt(sc.nextLine());
		clients = new Thread[playerNum];
		
		
	}
	
	public void run() {
		Socket socket;
		ServerSocket serverSocket;
		
		try {
			serverSocket = new ServerSocket(port);
			int i=0;
			while(i<playerNum) {
				System.out.println("Waiting for next client: Client" + i);
				socket = serverSocket.accept();
				System.out.println("Waiting for new thread.");
				Thread client = new Thread(new ClientServer(socket,"Client"+i));
				
				clients[i]=client;
				i++;
			}
			
			for(int k=0;k<clients.length;k++) {
				clients[k].start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
