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
	static MediaMemory mediaMem = new MediaMemory();

}

class MediaMemory{
	
	int nextEmpty = 0;
	int mediaSize = 4;
	Media[] media_mem = new Media[this.mediaSize];
	
	boolean isFull() {
		return (this.nextEmpty==this.mediaSize);
	}
	public void addToMem(Media mediaToAdd) {
		if (isFull()) {
			Media[] newMeida = new Media[mediaSize*2];
			for (int i=0;i<mediaSize;i++) {
				newMeida[i] = media_mem[i];
				media_mem = newMeida;
			}
			media_mem[nextEmpty] = mediaToAdd;
			nextEmpty++;
		}
	}
}

