package ex1;

import java.io.*;
import java.util.*;

public class Media {
	private int lenght_sec;
	private String lenght_string;
	//--------------Setters--------------
	public void set_lenght(int lenght_sec) {
		this.lenght_sec = lenght_sec;
		this.lenght_string = String.format("%d:%d", lenght_sec/60,lenght_sec%60);
	}
	
	
	//--------------Getters--------------
	public int get_lenght_int() {
		return this.lenght_sec;
	}
	public String get_lengh() {
		return this.lenght_string;
	}
	
	//--------------Constructor--------------
	public Media(int lenght_sec) {
		this.set_lenght(lenght_sec);
		
	}
	public Media() {
		this.set_lenght(0);
	}
}


