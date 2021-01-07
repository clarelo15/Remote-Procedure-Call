import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TBHelper extends Thread{
	int number = 0;
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	public TBHelper(Socket socket, ObjectOutputStream oos, ObjectInputStream ois) {
		this.socket = socket;
		this.oos = oos;
		this.ois = ois;
	}
	public void run() {
		try {
			sleep(6000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while(true) {
			Message m = null;
			try {
				m = (Message)ois.readObject();
				if(m == null) break;
				System.out.println("Get message from TB and now to execute this method :"+m.getMethodName());
				if(m.getMethodName().equals("pickNumberRandomly")) {
					pickNumberRandomly();
				}
				else if(m.getMethodName().equals("numberIncrease")) {
					numberIncrease();
				}
				else if(m.getMethodName().equals("numberDecrease")) {
					numberDecrease();
				}
				else if(m.getMethodName().equals("thingYouGet")) {
					thingYouGet();
				}
				
			} catch (Exception e) {
				return;
			} 
		}
	}
	public void pickNumberRandomly() {
		System.out.println("TB comes and picks a number");
		try {
			sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		number = (int)(Math.random()*1000);
		try {
			oos.writeInt(number);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("TB's number is randomly being picked, and the number is "+ number);
	}
	public void numberIncrease() {
		try {
			sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(number%3==0) {
			number = number+1;
			System.out.println("TB's number is increased by 1, and now the number is "+ number);
		}
		else if (number%3==1) {
			number = number+2;
			System.out.println("TB's number is increased by 2, and now the number is "+ number);
		}
		else {
			number = number+3;
			System.out.println("TB's number is increased by 3, and now the number is "+ number);
		}
		try {
			oos.writeInt(number);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void numberDecrease() {
		try {
			sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(number%3==0) {
			number = number-1;
			System.out.println("TB's number is decreased by 1, and now the number is "+ number);
		}
		else if (number%3==1) {
			number = number-3;
			System.out.println("TB's number is decreased by 3, and now the number is "+ number);
		}
		else {
			number = number-2;
			System.out.println("TB's number is increased by 2, and now the number is "+ number);
		}
		try {
			oos.writeInt(number);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void thingYouGet() {
		try {
			sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String prize = null;
		if(number%5==0) {
			System.out.println("Congrats TB! You get the first prize ");
			prize = "first prize";
		}
		else if(number%5==1) {
			System.out.println("Congrats TB! You get the second prize ");
			prize = "second prize";
		}
		else if(number%5==2) {
			System.out.println("Congrats TB! You get the third prize ");
			prize = "third prize";
		}
		else if(number%5==3) {
			System.out.println("Congrats TB! You get the consolation prize ");
			prize = "consolation prize";
		}
		else {
			System.out.println("Sorry TB, you get nothing ");
			prize = "nothing";
		}
		try {
			oos.writeUTF(prize);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
