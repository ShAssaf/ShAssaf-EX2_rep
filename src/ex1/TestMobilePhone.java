package ex1;

import java.util.Scanner;

public class TestMobilePhone {	
	
	public static void testPB() {
		
		//declaration of  variables
		
		PhoneBookApp phonebookApp = new PhoneBookApp();
		PhoneBook pb = Memory.phonebook;
		
		//test
		
		phonebookApp.print_menu();
		System.out.println("~~~~~~~~~~~~I chose 10~~~~~~~~~~~~");
		pb.read_from_file();
		phonebookApp.print_menu();
		System.out.println("~~~~~~~~~~~~I chose 3~~~~~~~~~~~~");
		pb.print_all_contacts();
		phonebookApp.print_menu();
		System.out.println("~~~~~~~~~~~~I chose 1 - adding roi, 0563~~~~~~~~~~~~");
		pb.add_contact("roi", "0563");
		phonebookApp.print_menu();
		System.out.println("~~~~~~~~~~~~I chose 2 - removing tomer~~~~~~~~~~~~");
		pb.remove_contact("tomer");
		phonebookApp.print_menu();
		System.out.println("~~~~~~~~~~~~I chose 5~~~~~~~~~~~~");
		pb.sort_by_name();
		phonebookApp.print_menu();
		System.out.println("~~~~~~~~~~~~I chose 3~~~~~~~~~~~~");
		pb.print_all_contacts();
		phonebookApp.print_menu();
		System.out.println("~~~~~~~~~~~~I chose 11~~~~~~~~~~~~");
		System.out.println("good bye!");
	}
	
public static void testSMS() {
		
		//declaration of  variables
		
		SMSApp smsApp = new SMSApp();
		SMS sms = Memory.sms;
		
		//test
		
		smsApp.print_menu();
		System.out.println("~~~~~~~~~~~~I chose 1 - start Chat with shlomo~~~~~~~~~~~~");
		sms.start_chat("shlomo");
		smsApp.print_menu();
		System.out.println("~~~~~~~~~~~~I chose 5~~~~~~~~~~~~");
		sms.print_all_chats();
		smsApp.print_menu();
		System.out.println("~~~~~~~~~~~~I chose 4 - search for the string 'hay'~~~~~~~~~~~~");
		sms.search("hay");
		smsApp.print_menu();
		System.out.println("~~~~~~~~~~~~I chose 6~~~~~~~~~~~~");
		System.out.println("good bye!");
	}
	
	public static void main(String [] args) {
		Phone phone = new Phone();
		
		Scanner r = new Scanner(System.in); 
		String c = r.nextLine();
		System.out.println("choose '0' to run as a user, or any other string for test");
		if (c.compareTo("0") == 0)
			phone.menu();
		else {
			phone.print_menu();
			System.out.println("~~~~~~~~~~~~I chose 1 - work with PhoneBook:~~~~~~~~~~~~");
			testPB();
			
			phone.print_menu();
			System.out.println("~~~~~~~~~~~~I chose 2 - work with SMS:~~~~~~~~~~~~");
			testSMS();
		}
		r.close();
			
	}
	
}
