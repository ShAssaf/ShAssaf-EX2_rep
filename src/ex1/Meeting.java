package Ex2;

import java.time.LocalDateTime;

public class Meeting extends Event{
	
	//--------------Data Member--------------
	
	private Contacts contact = new Contacts();	
	
	//--------------Setters--------------
	
	private void set_contact(Contacts contact) {
		this.contact = contact;
	}
	
	//--------------Getters--------------
	
		public Contacts get_contact() {
			return this.contact;
	}
		
	//--------------Printers--------------
	
	public void print() {
		System.out.println("-------------------------");
		System.out.println("Date: " + String.format("%02d", 
				this.get_date().getDayOfMonth()) +
				"." + String.format("%02d",
						this.get_date().getMonthValue()) + "." +
						String.format("%02d", 
								this.get_date().getYear()));
		System.out.println("Starting time: " + this.get_date().getHour() 
				+ ":" + String.format("%02d", this.get_date().getMinute()));
		System.out.println("Duration: " + this.get_duration());
		System.out.println("Description: " + this.get_description());
		System.out.println("Contact: " + this.get_contact().get_name()
				+ ", " + this.get_contact().get_phone_num());
		System.out.println("-------------------------");
	}
		
	//--------------Constructor--------------
	
	public Meeting(LocalDateTime date, int duration, String description, Contacts contact) {
		super(date, duration, description);
		this.set_contact(contact);
		contact.add_meeting(this);
	}
	
	public Meeting() {
		this.set_contact(contact);
	}
}