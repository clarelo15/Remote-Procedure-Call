import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) {
		System.out.println("input server's port number: ");
		Scanner scan = new Scanner(System.in);
		int serverPort = Integer.parseInt(scan.next());
		ServerSocket server = null;
		try {
			server = new ServerSocket(serverPort);    //create ServerScoket
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("I am listening");
		while(true) {
			try {
				//listening to client's connection, then establish connection and can communicate with client using this socket object
				Socket socket = server.accept();
				System.out.println("Client is connected to the Server");
				System.out.println("client's port no : "+socket.getPort());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message m = (Message)(ois.readObject());
				//create client helper thread that will carry out the two-way communication with the client thread
				if("Constructor".equals(m.getMethodName()) && "TA".equals(m.getThreadName())) {
					TAHelper taHelper = new TAHelper(socket,oos,ois);
					taHelper.start();
				}
				else if("Constructor".equals(m.getMethodName()) && "TB".equals(m.getThreadName())) {
					TBHelper tbHelper = new TBHelper(socket,oos,ois);
					tbHelper.start();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
