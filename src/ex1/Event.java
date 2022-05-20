package ex1;

import java.time.LocalDateTime; 

public class Event {
	
	//--------------Data Member--------------
	
	private LocalDateTime date = LocalDateTime.now();	//the date of the event
	private int duration;								//the duration of the event
	private String description = new String();			//the description of the event
	
	//--------------Setters--------------
	
	private void set_date(LocalDateTime date) {
		this.date = date;
	}
	
	private void set_duration(int duration) {
		this.duration = duration;
	}
	
	private void set_description(String description) {
		this.description = description;
	}
	
	//--------------Getters--------------
	
	public LocalDateTime get_date() {
		return this.date;
	}
	
	public int get_duration() {
		return this.duration;
	}
	
	public String get_description() {
		return this.description;
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
		System.out.println("-------------------------");
	}

	//--------------Constructor--------------
	
	public Event(LocalDateTime date, int duration, String description) {
		this.set_date(date);
		this.set_duration(duration);
		this.set_description(description);
	}
	
	public Event() {
		this.set_duration(0);
		this.set_description("");
	}
	
}