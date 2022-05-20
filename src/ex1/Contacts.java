package Ex2;

import java.util.ArrayList;
import java.util.Comparator;

public class Contacts {
	
	//--------------Data Member--------------
	
	//private String[] contact = new String[2];
	private String name = new String();
	private String phone_num = new String();
	private ArrayList<Meeting> meetings = new ArrayList<Meeting>(); 
	
	//--------------Setters--------------
	
	private void set_name(String name) {
		this.name = name;
	}
	
	private void set_phone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	
	//--------------Getters--------------
	
	public String get_name() {
		return this.name;
	}
	
	public String get_phone_num() {
		return this.phone_num;
	}

	public ArrayList<Meeting> get_meetings() {
		return this.meetings;
	}
	
	//--------------Adders--------------
	
	public void add_meeting(Meeting meeting) {
		this.get_meetings().add(meeting);
		this.get_meetings().sort(Comparator.comparing(Meeting::get_date));
	}

	//--------------Printers--------------
	
	public void print_meetings() {
		System.out.println("-------------------------");
		for(Meeting meeting : this.get_meetings()) {
			meeting.print();
		}
		System.out.println("-------------------------");
	}
	
	//--------------Constructor--------------
	
	public Contacts(String name, String phone_num) {
		this.set_name(name);
		this.set_phone_num(phone_num);
	}
	
	public Contacts() {
		this.set_name(" ");
		this.set_phone_num("123");
	}
}