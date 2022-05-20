package Ex2;

import java.time.LocalDateTime;

public class CalendarApp implements App {
	
	public void print_menu() {
		System.out.println("-----Calendar------");
		System.out.println("option:");
		System.out.println("1 - add event");
		System.out.println("2 - remove event");
		System.out.println("3 - print all events in a day by order");
		System.out.println("4 - print all meetings with a contact by order");
		System.out.println("5 - delete overlapping events in a day");
		System.out.println("6 - delete all overlapping events");
		System.out.println("7 - print all calendar events");
		System.out.println("8 - exit");
	}
	
	public void menu() {

		//variables
		String choice = new String();				//the choice that the user will make
		Calendar calendar = Memory.calendar;				//the calendar
		PhoneBook phonebook = Memory.phonebook;
		int year;
		int month;
		int day;
		int hour;
		int minute;
		int duration;
		LocalDateTime date;
		String description;
		String name;
		String phone_num;
		String is_meeting;
		
		// return variables
		int[] day_details; 
		int[] time_details;
		Pair<Integer, String> event_details;
		String[] contact_details;
		
		
		//the Program
		while(choice.compareTo("8") != 0) {		//compareTo return 0 if true
			print_menu();
			choice = Memory.in.nextLine();
			switch(choice) {
				case("1"):		//add
					day_details = this.get_day_from_user();
					if(!(this.check_date_input(day_details))) {
						break;
					}
					year = day_details[0];
					month = day_details[1];
					day = day_details[2];
					time_details = this.get_time_from_user();
					if(!(this.check_time_input(time_details))) {
						break;
					}
					hour = time_details[0];
					minute = time_details[1];
					event_details = this.get_event_details_from_user();
					duration = event_details.getL();
					if(!(this.check_duration_input(duration))) {
						break;
					}
					description = event_details.getR();
					date = this.create_date(year, month, day, hour, minute);
					if(date == null) {
						System.out.println("Invalid date, please choose year [1, 50],"
								+ "month [1, 12], day [1, 30], "
								+ "hour [0, 23], minute [0, 59]");
						break;
					}
					System.out.println("is this a meeting with a contact? y/n:");
					is_meeting = Memory.in.nextLine();
					if(is_meeting.equals("y")) {
						contact_details = this.get_contact_details_from_user();
						name = contact_details[0];
						phone_num = contact_details[1];
						Contacts contact = phonebook.get_contact(name);
						if(contact == null) {
							phonebook.add_contact(name, phone_num);
							contact = phonebook.get_contact(name);
						}
						Meeting meeting = new Meeting(date, duration,
								description, contact);
						calendar.add_event(meeting, year, month, day);
						
					}
					else {
						Event event = new Event(date, duration,
								description);
						calendar.add_event(event, year, month, day);
					}					
					break;
				case("2"):		//remove
					day_details = this.get_day_from_user();
					if(!(this.check_date_input(day_details))) {
						break;
					}
					year = day_details[0];
					month = day_details[1];
					day = day_details[2];
					time_details = this.get_time_from_user();
					if(!(this.check_time_input(time_details))) {
						break;
					}
					hour = time_details[0];
					minute = time_details[1];
					event_details = this.get_event_details_from_user();
					duration = event_details.getL();
					if(!(this.check_duration_input(duration))) {
						break;
					}
					description = event_details.getR();
					date = this.create_date(year, month, day, hour, minute);
					if(date == null) {
						System.out.println("Invalid date, please choose year [1, 50],"
								+ "month [1, 12], day [1, 30], "
								+ "hour [0, 23], minute [0, 59]");
						break;
					}
					System.out.println("is this a meeting with a contact? y/n:");
					is_meeting = Memory.in.nextLine();
					if(is_meeting.equals("y")) {
						contact_details = this.get_contact_details_from_user();
						name = contact_details[0];
						phone_num = contact_details[1];
						Contacts contact = phonebook.get_contact(name);
						if(contact == null) {
							phonebook.add_contact(name, phone_num);
							contact = phonebook.get_contact(name);
						}
						Meeting meeting = (Meeting) calendar.get_event(date, duration, description, contact);
						if(meeting != null) {
							calendar.remove_event(meeting, year, month, day);
						}
						else {
							System.out.println("No such event found");
							break;
						}
					}
					else {
						Event event = calendar.get_event(date, duration, description, null);
						calendar.remove_event(event, year, month, day);
					}					
					break;
				case("3"):		//print events in day
					day_details = this.get_day_from_user();
					if(!(this.check_date_input(day_details))) {
						break;
					}
					year = day_details[0];
					month = day_details[1];
					day = day_details[2];
					boolean b = calendar.print_events_of_day(calendar.get_day(year, month, day));
					if(!b) {
						System.out.println("no events in this day");
					}
					break;
				case("4"):		//print events by contact
					contact_details = this.get_contact_details_from_user();
					name = contact_details[0];
					phone_num = contact_details[1];
					if (Memory.phonebook.get_contact(name) != null) {
						Contacts contact = Memory.phonebook.get_contact(name);
						contact.print_meetings();
					}
					else {
						System.out.println("contact does not exist");
					}
					break;
				case("5"):		//delete overlapping events in a day
					day_details = this.get_day_from_user();
					if(!(this.check_date_input(day_details))) {
						break;
					}
					year = day_details[0];
					month = day_details[1];
					day = day_details[2];
					calendar.remove_overlapping_events(year, month, day);
					break;
				case("6"):		//delete all overlapping events
					calendar.remove_all_overlapping_events();
					break;
				case("7"):		//print all events
					calendar.print_all_events();
					break;
				case("8"):		//exit
					System.out.println("good bye!");
					break;
				default:		//if the user chose anything other than 1 - 8 (including letters)
					System.out.println("illegal choice, please choose again");				
			}
		}	
		
	}
	
	public int str_to_int() {
		String str;
		int number;
		while(true) {
			str = Memory.in.nextLine();
			try{
	            number = Integer.parseInt(str);
	            System.out.println(number);
	            break;
	        }
	        catch (NumberFormatException ex){
	        	System.out.println("illigel choice please choose again");
	        }
		}
		return number;
	}
	
	public int[] get_day_from_user() {
		System.out.println("please enter the year:");
		int year = this.str_to_int();
		System.out.println("please enter the month:");
		int month = this.str_to_int();
		System.out.println("please enter the day:");
		int day = this.str_to_int();
		int[] ret = {year, month, day};
		return ret;
	}
	
	public int[] get_time_from_user() {
		System.out.println("please enter the hour:");
		int hour = this.str_to_int();
		System.out.println("please enter the minute:");
		int minute = this.str_to_int();
		int[] ret = {hour, minute};
		return ret;
	}
	
	public Pair<Integer, String> get_event_details_from_user() {
		System.out.println("please enter the duration:");
		int duration = this.str_to_int();
		System.out.println("please enter the description:");
		String description = Memory.in.nextLine();
		Pair<Integer, String> ret = new Pair<Integer, String>(duration, description);
		return ret;
	}
	
	public String[] get_contact_details_from_user() {
		System.out.println("what is the contact's name?");
		String name = Memory.in.nextLine();
		System.out.println("what is the contact's phone number?");
		String phone_num = Memory.in.nextLine();
		String[] ret = {name, phone_num};
		return ret;
	}
	
	public LocalDateTime create_date(int year, int month, int day,
			int hour, int minute) {
		try {
			LocalDateTime date = LocalDateTime.of(year, month, day,
					hour, minute);
			return date;
		}
		catch(Exception DateTimeException) {
			return null;
		}
	}
	
	public boolean check_date_input(int[] arr) {
		if((arr[0] < 1) || (arr[0] > 50) || (arr[1] < 1) || (arr[1] > 12) ||
				(arr[2] < 1) || (arr[2] > 30)) {
			System.out.println("Invalid date, please choose year [1, 50],"
					+ "month [1, 12], day [1, 30]");
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean check_time_input(int[] arr) {
		if((arr[0] < 0) || (arr[0] > 23) || (arr[1] < 0) || (arr[1] > 59)) {
			System.out.println("Invalid date, please choose hour [0, 23],"
					+ " minute [0, 59]");
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean check_duration_input(int duration) {
		if((duration < 1) || (duration > 60)) {
			System.out.println("Invalid duration, please choose between [1, 60]");
			return false;
		}
		else {
			return true;
		}
	}
}
