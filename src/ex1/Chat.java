package Ex2;

import java.util.*;

public class Chat {
	//--------------Data Member--------------
	
	private Contacts contact = new Contacts();
	private ArrayList<SendingPackage> conversation = new ArrayList<SendingPackage>();
	
	//--------------Setters--------------
	
	public void send_message(String sender, String message) {
		SendingPackage other = new SendingPackage(sender, message);
		this.conversation.add(other);
	}
	
	//--------------Getters--------------
	
	public String get_name() {
		return this.contact.get_name();
	}
	
	public ArrayList<String> get_conversation() {
		ArrayList<String> other = new ArrayList<String>();
		for (int i=0;i<this.conversation.size();i++)
			other.add(this.conversation.get(i).get_message());
		return other;
	}
	
	//--------------Constructor--------------
	
	public Chat(Contacts contact) {
		this.contact = contact;
	}
		
	//--------------Print--------------
	
	public void print_chat() {
		if (this.conversation.size() == 0) 
			System.out.println("thare is no conversation with " + this.contact.get_name());
		
		else{
			for (int i=0;i<this.conversation.size();i++)
				System.out.println(this.conversation.get(i).get_sender() + ":" + this.conversation.get(i).get_message());
		}
	}
	
}
