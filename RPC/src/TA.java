import java.io.*;
import java.net.*;

public class TA extends Thread{
	int number = 0;
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	public TA() {
		try {
			socket = new Socket(Client.address,Client.port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			Message m = new Message("TA","Constructor");
			oos.writeObject(m);
			oos.flush();
			System.out.println("Connect to the server.");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		pickNumberRandomly();
		numberIncrease();
		numberDecrease();
		thingYouGet();
		try {
			oos.close();
			ois.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void pickNumberRandomly() {
		Message m = new Message("TA","pickNumberRandomly");
		try {
			oos.writeObject(m);
			oos.flush();
			System.out.println("TA wants to execute pickNumberRandomly() method, TA needs TAHelper.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int num = 0;
		try {
			num = ois.readInt();
			System.out.println("TA receives the number first time, she gets "+ num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void numberIncrease() {
		Message m = new Message("TA","numberIncrease");
		try {
			oos.writeObject(m);
			oos.flush();
			System.out.println("TA wants to execute numberIncrease() method, TA needs TAHelper.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int num = 0;
		try {
			num = ois.readInt();
			System.out.println("TA receives the number second time, now she gets "+ num);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void numberDecrease() {
		Message m = new Message("TA","numberDecrease");
		try {
			oos.writeObject(m);
			oos.flush();
			System.out.println("TA wants to execute numberDecrease() method, TA needs TAHelper.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int num = 0;
		try {
			num = ois.readInt();
			System.out.println("TA receives the number final number, she gets "+ num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void thingYouGet() {
		Message m = new Message("TA","thingYouGet");
		try {
			oos.writeObject(m);
			oos.flush();
			System.out.println("TA wants to execute thingYouGet() method, TA needs TAHelper.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String prize = ois.readUTF();
			System.out.println("TA is done with the game and she gets "+prize);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
