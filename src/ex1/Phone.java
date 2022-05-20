package ex1;

public class Phone implements App {
	
	public void print_menu() {
		System.out.println("-----Phone------");
		System.out.println("option:");
		System.out.println("1 - PhoneBook");
		System.out.println("2 - SMS");
		System.out.println("3 - Calendar");
		System.out.println("4 - Media Player");
		System.out.println("5 - Exit");
	}
	
	public void menu() {
	
	//	variable
		String choice = new String();				//the choice that the user will make
		PhoneBookApp phonebookApp = new PhoneBookApp();
		SMSApp smsApp = new SMSApp();
		CalendarApp calendar_app = new CalendarApp();
		MediaPlayer mediaPlayer = new MediaPlayer();
		//the Program
		while(choice.compareTo("5") != 0) {		//compareTo return 0 if true
			print_menu();
			choice = Memory.in.nextLine();
			switch(choice) {
				case("1"):		//PhoneBook
					phonebookApp.menu();
					break;
				case("2"):		//SMS
					smsApp.menu();
					break;
				case("3"):		//Date
					calendar_app.menu();
					break;
				case("4"):		//Media Player
					mediaPlayer.menu();
					break;
				case("5"):		//exit program
					System.out.println("good bye!");
					break;
				default:		//if the user chose anything other than 1 - 11 (including letters)
					System.out.println("illigel choice please choose again");				
			}
		}	
		Memory.in.close();		//close the input.in at the end of the program!!!
	}
}
