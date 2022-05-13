package ex1;

import java.io.*;
import java.util.*;

public class PhoneBook {
	
	//--------------Data Member--------------
	
	private ArrayList<Contacts> phonebook = new ArrayList<Contacts>();		//ArryaList of Contacts	
	
	//--------------Adding Methods--------------
	
	//___________add_new_contact___________
	//input - name , phone number
	//output - None
	
	public void add_contact(String name,String phone_num) {
		if (is_valid_number(phone_num)) {
			Contacts contact = new Contacts(name, phone_num);
			phonebook.add(contact);}
		else System.out.println("sorry invalid phone number please retry again");
	}
	
	//___________is_valid_number___________
	//input - Contact(phone number)
	//output - True or false

	private boolean is_valid_number(String phone_num) {
		return (phone_num.matches("[0-9]+"));

	}
	
	//___________add_all_the_contacts_from_Contacts_list___________
	//input - Contact(name , phone number)
	//output - None
	

	private void add_contact_from_list(Contacts[] contacts) {			
		for (int i=0;i<contacts.length;i++) {	
			this.add_contact(contacts[i].get_name(),contacts[i].get_phone_num());
		}
	}
	
	//--------------Getters--------------
	
	//___________return an Array of all the phone numbers of a specific name___________
	//input - name
	//output - String all the phone of that name
	
	public String get_phone(String name) {						
		int j = 0;
		String[] temp = new String[phonebook.size()];
		for (int i=0;i<phonebook.size();i++) {
			if (phonebook.get(i).get_name().compareTo(name) == 0) {		//compareTo return 0 if true
				temp[j] = phonebook.get(i).get_phone_num();
				j++;
			}
		}
		if (j==0)
			return "there is no such contact";
		String[] phone = new String[j];
		for (int i=0;i<j;i++) {
			phone[i] = temp[i];
		}
		return Arrays.toString(phone);  
	}
	
	public Contacts get_contact(String name) {
		if(this.get_index_by_name(name) == -1) {
			return null;
		}
		return this.phonebook.get(this.get_index_by_name(name));
	}
	
	//___________chack_if_empty___________
	//input - None
	//output - integer
	//if empty return true else false
	
	private boolean is_empty() {
		if(phonebook.size() == 0)
			return true;
		return false;
	}
	
	//___________return an index by name___________
	//input - name
	//output - integer
	
	public int get_index_by_name(String name) {						
		for (int i=0;i<phonebook.size();i++) {
			if (phonebook.get(i).get_name().compareTo(name) == 0)	 //compareTo return 0 if true
				return i;		//the index of the first contact we see that name
		}
		return -1;				//couldn't find any contact with that name 
	}
	
	//--------------Removing Methods--------------
	
	//___________remove_contact___________
	//input - name
	//output - None
	
	public void remove_contact(String name) {						
		if(this.get_index_by_name(name)!=-1) {		//get_index_by_name return -1 if couldn't find match
			phonebook.remove(this.get_index_by_name(name));
		}
		else {
			System.out.println("there is no such contact");
		}
	}
	
	//___________remove_contact___________
	//input - None
	//output - None
	
	private void remove_all_contact() {		//so the user don't accidentally remove his list 
		phonebook.clear();
	}
	
	//___________remove_identical_contect_if_exsit___________
	//input - None
	//output - None
	
	public void remove_doubles() {
		this.sort_by_phone();
		this.sort_by_name();
		for (int i=0;i<phonebook.size()-1;i++) {
			if(phonebook.get(i).get_name().compareTo(phonebook.get(i+1).get_name()) == 0
					&& phonebook.get(i).get_phone_num().compareTo(phonebook.get(i+1).get_phone_num()) == 0) {	//compareTo return 0 if true
				phonebook.remove(i);
				i--;
			}
		}
	}
	
	//--------------Printing Method--------------
	
	//___________prints all the contacts___________
	//input - None
	//output - None
	
	public void print_all_contacts() {											
		if (phonebook.size() == 0) {
			System.out.println("the phone book is empty");
		}
		else{
			System.out.println("name	|	phone");
			for (int i=0;i<phonebook.size();i++) {
				System.out.println(phonebook.get(i).get_name() + "\t|\t" + phonebook.get(i).get_phone_num());
			}
		}
	}
	
	//--------------Sorting Method--------------
	
	//___________sort_by_names___________
	//input - None
	//output - None
	
	public void sort_by_name() {
		Contacts[] contacts = new Contacts[phonebook.size()];
		for (int i=0;i<phonebook.size();i++) {
			contacts[i] = new Contacts(phonebook.get(i).get_name(),phonebook.get(i).get_phone_num());
		}
		Arrays.sort(contacts, (a, b) ->a.get_name().compareTo(b.get_name()));	
		this.remove_all_contact();
		this.add_contact_from_list(contacts);
	}
	
	//___________sort_by_phone_numbers___________
	//input - None
	//output - None
		
	public void sort_by_phone() {
		Contacts[] contacts = new Contacts[phonebook.size()];
		for (int i=0;i<phonebook.size();i++) {
			contacts[i] = new Contacts(phonebook.get(i).get_name(),phonebook.get(i).get_phone_num());
		}
		Arrays.sort(contacts, (a, b) ->b.get_phone_num().compareTo(a.get_phone_num()));		
		this.remove_all_contact();
		this.add_contact_from_list(contacts);
	}
	
	//___________inverst_the_order_of_the_phonebook___________
	//input - None
	//output - None
	
	public void inverst_sort() {
		Contacts[] contacts = new Contacts[phonebook.size()];
		for (int i=1;i<=phonebook.size();i++) {
			contacts[i-1] = new Contacts(phonebook.get(phonebook.size()-i).get_name(),phonebook.get(phonebook.size()-i).get_phone_num());
		}
		this.remove_all_contact();
		this.add_contact_from_list(contacts);
	}
	
	//--------------FILEs Method--------------
	
	//input - the name of the file shell be PhoneBook_List.txt
	//output - File that needs to filled with : name phone_number 
	//for example:
	//tomer 123
	//ariel 456
	//shlomo 789
	//into the file PhoneBook_List.txt
	
	public void save_to_file() {
		try {
			if(this.is_empty())	//if empty the method is useless
				return;
			File myObj = new File("PhoneBook_List.txt");
			myObj.createNewFile();
			FileWriter writer = new FileWriter("PhoneBook_List.txt");
			writer.write(phonebook.get(0).get_name() + " " + phonebook.get(0).get_phone_num());
			for(int i=1;i<phonebook.size();i++) {
				writer.append("\n" + phonebook.get(i).get_name() + " " + phonebook.get(i).get_phone_num());	
			}
			writer.close();
	    }
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
	    }
	}
	
	
	//___________inverst_the_order_of_the_phonebook___________
	//input - File that needs to filled with : name phone_number 
	//for example:
	//tomer 123
	//ariel 456
	//shlomo 789
	//output - None
	// the name of the file shell be PhoneBook_List.txt
	
	public void read_from_file() {
		try {
	      File myObj = new File("PhoneBook_List.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String name = myReader.next();
	        String phone_num = myReader.next();
	        this.add_contact(name, phone_num);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
	
}