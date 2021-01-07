import java.io.Serializable;

public class Message implements Serializable{
	String threadName;
	String methodName;
	public Message() {};
	public Message(String threadName, String methodName) {
		this.threadName = threadName;
		this.methodName = methodName;
	}
	public String getThreadName() {
		return threadName;
	}
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String toString() {
		return "Thread: " +threadName+ "Method: "+methodName;
	}

}
