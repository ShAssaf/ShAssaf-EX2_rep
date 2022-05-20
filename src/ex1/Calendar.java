package Ex2;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Calendar {
	
	//--------------Data Member--------------
	
		private Day[][][] calendar = new Day[51][13][31];		//[year][month][day]
		
		//--------------Adding Methods--------------
		
		//___________add_event___________
		//input - event, year, month, day
		//output - None
		
		public void add_event(Event event, int year, int month, int day) {			
			try{
				this.get_day(year, month, day).add_event(event);
			}
			catch(Exception NullPointerException){
				ArrayList<Event> events = new ArrayList<Event>();
				events.add(event);
				this.get_calendar()[year][month][day] = 
						new Day(events, year, month, day);
			}
		}
		
		//input - event, date
		//output - None
		public void add_event(Event event, LocalDateTime date) {			
			this.get_day(date.getYear(), date.getMonthValue(),
					date.getDayOfMonth()).add_event(event);
		}
		
		//--------------Getters--------------
		
		public Day[][][] get_calendar() {						
			return this.calendar;  
		}
		
		public Day get_day(int year, int month, int day) {						
			return this.calendar[year][month][day];  
		}
		
		public Day get_day(LocalDateTime date) {						
			return this.calendar[date.getYear()][date.getMonthValue()][date.getDayOfMonth()];  
		}
		
		public Day[] get_month(int year, int month) {						
			return this.calendar[year][month];  
		}
		
		public Day[] get_month(LocalDateTime date) {						
			return this.calendar[date.getYear()][date.getMonthValue()];  
		}
		
		public Day[][] get_year(int year) {						
			return this.calendar[year];
		}
		
		public Day[][] get_year(LocalDateTime date) {						
			return this.calendar[date.getYear()];
		}
		
		public Event get_event(LocalDateTime date, int duration,
				String description, Contacts contact) {
	        Day day = this.get_day(date);
	        for(Event e : day.get_events_arr()) {
	        	if((e.get_date().equals(date)) &&
	        			(e.get_duration() == duration) &&
	        			(e.get_description().equals(description))) {
	        		if(e instanceof Meeting) {
	        			if ((((Meeting)e).get_contact().get_name().equals(contact.get_name())) &&
	        					(((Meeting)e).get_contact().get_phone_num().equals(contact.get_phone_num()))){
	        				return e;
	        			}
	        			else {
	        				continue;
	        			}
	        		}
	        		return e;
	        	}
	        	else {
	        		continue;
	        	}
	        }
			return null;
		}
		
		//--------------Removing Methods--------------
		
		//___________remove_event___________
		//input - event
		//output - None
		
		public void remove_event(Event event, int year, int month, int day) {						
			this.get_day(year, month, day).remove_event(event);
		}
		
		public void remove_event(Event event, LocalDateTime date) {						
			this.get_day(date).remove_event(event);
		}
		
		
		//___________remove_overlapping meetings if exists___________
		//input - None
		//output - None
		
		public void remove_overlapping_events(int year, int month, int day) {
			Day d = this.get_day(year, month, day);
			d.remove_overlapping_events();
		}
		
		//input - None
		//output - None
		
		public void remove_overlapping_events(LocalDateTime date) {
			Day d = this.get_day(date);
			d.remove_overlapping_events();
		}
		
		//input - None
		//output - None
		
		public void remove_all_overlapping_events() {
			for(Day year[][] : this.get_calendar()) {
				for(Day month[] : year) {
					for(Day day : month) {
						if(day != null) {
							day.remove_overlapping_events();
						}
					}
				}
		
			}
		}
		
		public void remove_all_meeting_of_contact(Contacts contact) {
			if (contact == null) {
				System.out.println("contact doesn't exist");
			}
			else {
				for (Meeting meeting : contact.get_meetings()) {
					this.remove_event(meeting, meeting.get_date());
				}
			}
		}
		
		//--------------Printing Method--------------
		
		//___________prints all the events___________
		//input - None
		//output - None
		
		public void print_all_events() {											
			for(Day year[][] : this.get_calendar()) {
				for(Day month[] : year) {
					for(Day day : month) {
						if(day != null) {
							day.print_all_events();
						}
					}
				}
		
			}
		}
		
		//___________prints all the events of a specific day___________
		//input - None
		//output - None
		
		public boolean print_events_of_day(Day day) {
			if(day != null) {
				day.print_all_events();
				return true;
			}
			else
			{
				return false;
			}
			
		}
		
		//___________prints all the meetings of a contact___________
		//input - None
		//output - None
		
		public void print_events_of_contact(Contacts contact) {
			contact.print_meetings();
		}
		
	}