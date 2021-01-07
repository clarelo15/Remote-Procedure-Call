import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TB extends Thread{
	int number = 0;
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	public TB() {
		try {
			socket = new Socket(Client.address,Client.port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			Message m = new Message("TB","Constructor");
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
		Message m = new Message("TB","pickNumberRandomly");
		try {
			oos.writeObject(m);
			oos.flush();
			System.out.println("TB wants to execute pickNumberRandomly() method, TB needs TAHelper.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int num = 0;
		try {
			num = ois.readInt();
			System.out.println("TB receives the number first time, he gets "+ num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void numberIncrease() {
		Message m = new Message("TB","numberIncrease");
		try {
			oos.writeObject(m);
			oos.flush();
			System.out.println("TB wants to execute numberIncrease() method, TA needs TAHelper.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int num = 0;
		try {
			num = ois.readInt();
			System.out.println("TB receives the number second time, now he gets "+ num);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void numberDecrease() {
		Message m = new Message("TB","numberDecrease");
		try {
			oos.writeObject(m);
			oos.flush();
			System.out.println("TB wants to execute numberDecrease() method, TB needs TAHelper.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int num = 0;
		try {
			num = ois.readInt();
			System.out.println("TB receives the number final number, he gets "+ num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void thingYouGet() {
		Message m = new Message("TB","thingYouGet");
		try {
			oos.writeObject(m);
			oos.flush();
			System.out.println("TB wants to execute thingYouGet() method, TB needs TAHelper.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String prize = ois.readUTF();
			System.out.println("TB is done with the game and he gets "+prize);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}

