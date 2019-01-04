package domainLayer.network;

import java.util.Scanner;
import uiLayer.AppWindow;

public class Client {

	static AppWindow inst;
	private static NetworkController NC;
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//	
//	//	NC= new NetworkController();
//		Scanner sc = new Scanner(System.in); 
//		System.out.print("Enter mode: ('s' for server/'c' for client):");
//		String initMode = sc.nextLine();
//		if(initMode.equals("s")) {
//			int port;
//			System.out.println("Enter your port number:");
//			port = sc.nextInt();
//			System.out.println(port);
//			
//			Thread s = new Thread(new Server(port));
//			s.run();
//			
//		}else if(initMode.equals("c")) {
//			NetworkController clientProtocol;
//			int port;
//			System.out.println("Enter your port number:");
//			port = sc.nextInt();
//			System.out.println(port);
//			sc.close();
//		
//			clientProtocol = new NetworkController();		
//			clientProtocol.connectToServer(port);
//			//clientProtocol.start();
//			inst = new AppWindow();
//			
//		
//			
//			
//		}else {
//			System.out.println("Init error.");
//		
//		}
//		
//		sc.close();
//		
//		
//		
//	}

}
