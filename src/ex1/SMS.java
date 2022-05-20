package Ex2;

import java.util.ArrayList;

public class SMS {
	
	//--------------Data Member--------------
	
	private PhoneBook phonebook = new PhoneBook();
	private ArrayList<Chat> chat = new ArrayList<Chat>();
	
	//--------------Getters--------------
	
	//___________return index of a chat with name___________
	//input - name
	//output - the index of a specific chat with name
	
	private int get_index(String name) {						
		for (int i=0;i<this.chat.size();i++) {
			if (this.chat.get(i).get_name().compareTo(name) == 0)	 //compareTo return 0 if true
				return i;		//the index of the first contact we see that name
		}
		return -1;				//couldn't find any contact with that name 
	}
	
	//--------------Setters--------------
	
	//___________update the chat app with the new phonebook___________
	//input - PhoneBook
	//output - None
	
	public void set_PhoneBook(PhoneBook pb) {
		this.phonebook = pb;
	}
	
	//--------------Constructor--------------
	
	public SMS(PhoneBook pb) {
		this.set_PhoneBook(pb);
	}
	
	//--------------refresh PhoneBook--------------
	
	public void refreshPB() {
		for (int i=0;i<this.chat.size();i++) {
			if (this.phonebook.get_index_by_name(this.chat.get(i).get_name()) == -1) {	 //compareTo return 0 if true
				this.chat.remove(i);
			}
		}
	}
	
	//--------------App Options--------------
	
	//___________1. start a chat___________
	//input - ask for contact to chat with..
	//output - if exist start chat else print "there is no such contact"
	
	public void start_chat(String name) {	
		String message = new String();
		String choice = "0";
		if(this.phonebook.get_phone(name).compareTo("there is no such contact") == 0) {
			System.out.println("there is no such contact");
			return;
		}
		
		if(this.get_index(name) == -1)
			this.chat.add(new Chat(this.phonebook.get_contact(name)));
		
		while(choice.compareTo("3") != 0) {
			System.out.println("1 - send message");
			System.out.println("2 - receive message");
			System.out.println("3 - exit chat");
			choice = Memory.in.nextLine();
			
			switch(choice) {
			case("1"):		//send message
				message = Memory.in.nextLine();
				this.chat.get(this.get_index(name)).send_message("me", message);
				break;
			case("2"):		//receive message
				message = Memory.in.nextLine();
				this.chat.get(this.get_index(name)).send_message(name, message);
				break;
			case("3"):		//exit chat
				System.out.println("finished chat");
				break;
			default:		//if the user chose anything other than 1 - 11 (including letters)
				System.out.println("illigel choice please choose again");
			}
		}
	}
	
	//___________2. remove a chat___________
	//input - ask for contact to remove his chat
	//output -None
	
	public void remove_chat(String name) {
		if(this.get_index(name) == -1)
			System.out.println("thare is no conversation with " + name);
		else 
			this.chat.remove(this.get_index(name));					//delete the chat 
	}
	
	//___________3. print a chat___________
	//input - ask for contact to print his chat
	//output - print the chat
	
	public void print_chat(String name) {
		if(this.get_index(name) == -1)
			System.out.println("thare is no conversation with " + name);
		else 
			this.chat.get(this.get_index(name)).print_chat();
	}
	
	//___________4. search a word in all chats___________
	//input - get sentence (string) that the user need to find in the chats
	//output - print the names of the contacts that sent or received this sentence
	
	public void search(String sentence) {
		String names = new String();
		if(this.chat.size() == 0)
			System.out.println("there is no conversation");
		
		for(int i=0;i<this.chat.size();i++) {
			for(int j=0;j<this.chat.get(i).get_conversation().size();j++) {
				if(this.chat.get(i).get_conversation().get(j).compareTo(sentence) == 0) {
					names = names + chat.get(i).get_name() + "; ";
					continue;							
				}	
			}
		}
		if(names.isEmpty()) {
			System.out.println("the word you searched is not in any of your chats");
		}
		else {
			System.out.println("the word you searched appear in conversation with " + names);
		}
	}
	
	//___________5. print all chats___________
	//input - None
	//output - prints all the chats in the app
	
	public void print_all_chats() {
		if(this.chat.size() == 0)
			System.out.println("there is no conversation to print");
		
		for(int i=0;i<this.chat.size();i++) {
			System.out.println("chat with " + this.chat.get(i).get_name() + ":");
			this.chat.get(i).print_chat();
		}
	}
}
