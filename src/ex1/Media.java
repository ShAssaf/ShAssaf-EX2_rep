package ex1;

import java.io.*;
import java.util.*;

public class Media {
	private int lenght_sec;
	private String lenght_string;
	private String meida_name;
	
	
	
	public void media_printer() {
		System.out.println(String.format("%s is now playing for %s time",this.get_media_name(),this.get_lengh()));
	}
	//--------------Setters--------------
	public void set_lenght(int lenght_sec) {
		
		this.lenght_sec = lenght_sec;
		this.lenght_string = String.format("%d:%d", lenght_sec/60,lenght_sec%60);
	}
	public void set_media_name(String name) {
		this.meida_name = name;
	}
	
	
	//--------------Getters--------------
	public int get_lenght_int() {
		return this.lenght_sec;
	}

	public String get_lengh() {
		return this.lenght_string;
	}
	public String get_media_name() {
		return this.meida_name;
	}
	
	//--------------Constructor--------------
	public Media(String name,int lenght_sec) {
		this.set_media_name(name);
		this.set_lenght(lenght_sec);
	}
	public Media() {
		this.set_media_name("NULL");
		this.set_lenght(0);
	}
}

class Viedo extends Media {
	
	
}
class Music extends Media {
	
}

