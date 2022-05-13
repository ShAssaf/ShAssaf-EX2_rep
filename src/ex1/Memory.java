package ex1;

import java.util.Scanner;

public class Memory {
	
	/****************************************************************************************
	*because we have multiple Scanners in the program,										*
	*we got a problem when we wants to close 1 scanner and open another						*
	*so we built this class that open one Scanner for us end close it in the end of the Main*
	*****************************************************************************************/
	
	static Scanner in = new Scanner(System.in); 
	
	/****************************************************************************************
	* PhoneBook and SMS are static so we can open and close the apps without lose the info	*
	*****************************************************************************************/
	
	static PhoneBook phonebook = new PhoneBook();
	
	static SMS sms = new SMS(phonebook);

}