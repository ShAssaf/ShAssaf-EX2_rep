package Ex2;


public class MediaPlayer implements App {

	

	public void menu() {
		//variable
		String choice = "0";				//the choice that the user will make
		String medType = "0";
		String name = new String();	
		int lenght ;
		//the Program
		while (choice.compareTo("4") != 0) {
			this.print_menu();
			choice = Memory.in.nextLine();
			switch(choice) {
				case("1"):		//add
					
					System.out.println("enter media name");					
					name = Memory.in.nextLine();
					System.out.println("enter media lenght (in sec)");					
					lenght = Memory.in.nextInt();
					Memory.in.nextLine();
					System.out.println("which media do you wish to add: video('v') or music ('m')\npls enter your choise");
					medType = Memory.in.nextLine();
					switch(medType) {
						case("v"):
							Video vid = new Video(name,lenght);
							Memory.media.addToMem(vid);
							break;
						case("m"):
							Music mus = new Music(name, lenght);
							Memory.media.addToMem(mus);
							break;}
					break;
							
				case("2"):		//remove
					System.out.println("enter name of media to stream ");
					name = Memory.in.nextLine();
					for(int i=0;i<Memory.media.mediaSize;) {
						if (Memory.media.mediaArr[i].get_media_name() == name ) {
							Memory.media.mediaArr[i].media_player();
							break;
						}
						
					}
					break;
				case("3"):		//print
					System.out.println("print all medias: ");
					for(int i=0;i<Memory.media.nextEmpty;i++) {
						Memory.media.mediaArr[i].media_player();
					}
					break;
				case("4"):		//search
					System.out.println("good bye!");
					break;

					
				default:		//if the user chose anything other than 1 - 11 (including letters)
					System.out.println("illigel choice please choose again");
					break;
			}
		}
		
	}




	public void print_menu() {
		System.out.println("-----Media Player------");
		System.out.println("option:");
		System.out.println("1 - add media");
		System.out.println("2 - play media by name");
		System.out.println("3 - play all medias");
		System.out.println("4 - exit");
		
	}

}
