package Ex2;

public class SMSApp implements App{
		
	//--------------Print menu--------------
	
	public void print_menu() {
		System.out.println("-----SMS------");
		System.out.println("option:");
		System.out.println("1 - start conversation");
		System.out.println("2 - remove conversation");
		System.out.println("3 - print conversation");
		System.out.println("4 - serch");
		System.out.println("5 - print all conversations");
		System.out.println("6 - exit");
	}
	
	//--------------menu--------------
	
	public void menu() {
		
		//variable
		String choice = "0";				//the choice that the user will make
		String name = new String();	
		SMS sms = Memory.sms;
		
//		sms.refreshPB();
		
		//the Program
		while (choice.compareTo("6") != 0)
		{
			this.print_menu();
			choice = Memory.in.nextLine();
			switch(choice) {
				case("1"):		//add
					System.out.println("send messege to: ");
					name = Memory.in.nextLine();
					sms.start_chat(name);
					break;
				case("2"):		//remove
					System.out.println("remove chat with: ");
					name = Memory.in.nextLine();
					sms.remove_chat(name);
					break;
				case("3"):		//print
					System.out.println("print chat with: ");
					name = Memory.in.nextLine();
					sms.print_chat(name);
					break;
				case("4"):		//search
					System.out.println("what do you want to search?: ");
					name = Memory.in.nextLine();			//name should be string search
					sms.search(name);
					break;
				case("5"):		
					sms.print_all_chats();
					break;
				case("6"):		
					System.out.println("good bye!");
					break;
				default:		//if the user chose anything other than 1 - 11 (including letters)
					System.out.println("illigel choice please choose again");
			}
		}
	}
}
