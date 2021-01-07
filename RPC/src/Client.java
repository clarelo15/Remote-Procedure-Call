import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static String address;
	public static int port;
	public static void main(String[] args) {
		//user's inputs on the command line
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter address: ");
		address = scan.next().trim();
		System.out.println("Enter port number: ");
		port = Integer.parseInt(scan.next());
		try {
			Socket connection = new Socket(Client.address, Client.port);      //create Socket, then try to connect to the server automatically
			System.out.println("It's connected");
			System.out.println("My port :"+ connection.getLocalPort());       //get client's port number
			System.out.println("Server's port :"+ connection.getPort());            //get server's port number
			ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());
			Message m = new Message("Client","Main");
			oos.writeObject(m);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//create thread TA
		TA ta = new TA();
		ta.start();
		//create thread TB
		TB tb = new TB();
		tb.start();
		

	}

}
