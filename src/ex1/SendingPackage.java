package ex1;

public class SendingPackage {
	
	private String sender = new String();
	private String message = new String();
	
	//--------------Getters--------------
	
	public String get_sender() {
		return this.sender;
	}
	
	public String get_message() {
		return this.message;
	}
	
	//--------------Setters--------------
	
	public void set_sender(String sender) {
		this.sender = sender;
	}
		
	public void set_message(String message) {
		this.message = message;
	}
	
	//--------------Constructor--------------
	
	public SendingPackage(String sender, String message) {
		this.set_sender(sender);
		this.set_message(message);
	}
}
