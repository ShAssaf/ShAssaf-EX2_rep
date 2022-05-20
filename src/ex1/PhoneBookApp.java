package ex1;

public class PhoneBookApp implements App {
	
	public void print_menu() {
		System.out.println("-----PhoneBook------");
		System.out.println("option:");
		System.out.println("1 - add new contact");
		System.out.println("2 - remove contact by name");
		System.out.println("3 - print all contacts");
		System.out.println("4 - serch phone number by name");
		System.out.println("5 - sort phonebook by name");
		System.out.println("6 - sort phonebook by phone number");
		System.out.println("7 - remove identical contacts");
		System.out.println("8 - inverst sort of the phonebook");
		System.out.println("9 - save phonebook to file");
		System.out.println("10 - create phonebook from file");
		System.out.println("11 - exit");
	}
	
	public void menu() {

		//variable
		String choice = new String();				//the choice that the user will make
		PhoneBook pb = Memory.phonebook;				//the phonebook
		
		String name = new String();					
		String phone_num = new String();
		
		//the Program
		while(choice.compareTo("11") != 0) {		//compareTo return 0 if true
			print_menu();
			choice = Memory.in.nextLine();
			switch(choice) {
				case("1"):		//add
					System.out.println("please enter contact name:");
					name = Memory.in.nextLine();
					System.out.println("please enter contact phone number:");
					phone_num = Memory.in.nextLine();
					pb.add_contact(name, phone_num);
					break;
				case("2"):		//remove
					System.out.println("please enter contact name you would like to remove:");
					name = Memory.in.nextLine();
					pb.remove_contact(name);
					break;
				case("3"):		//print
					pb.print_all_contacts();
					break;
				case("4"):		//search
					System.out.println("please enter contact name you would like to find:");
					name = Memory.in.nextLine();
					System.out.println(pb.get_phone(name));
					break;
				case("5"):		//sort - name
					pb.sort_by_name();
					break;
				case("6"):		//sort - phone_num
					pb.sort_by_phone();
					break;
				case("7"):		//remove double
					pb.remove_doubles();
					break;
				case("8"):		//sort - inverst
					pb.inverst_sort();
					break;
				case("9"):		//output file
					pb.save_to_file();
					break;
				case("10"):		//input file
					pb.read_from_file();
					break;
				case("11"):		//exit program
					System.out.println("good bye!");
					break;
				default:		//if the user chose anything other than 1 - 11 (including letters)
					System.out.println("illigel choice please choose again");				
			}
		}	
		
	}
}
