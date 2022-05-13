package ex1;

public class Contacts {
	
	//--------------Data Member--------------
	
	//private String[] contact = new String[2];
	private String name = new String();
	private String phone_num = new String();
	
	//--------------Setters--------------
	
	private void set_name(String name) {
		this.name = name;
	}
	
	private void set_phone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	
	//--------------Getters--------------
	
	public String get_name() {
		return this.name;
	}
	
	public String get_phone_num() {
		return this.phone_num;
	}
	
	//--------------Constructor--------------
	
	public Contacts(String name, String phone_num) {
		this.set_name(name);
		this.set_phone_num(phone_num);
	}
	
	public Contacts() {
		this.set_name(" ");
		this.set_phone_num("123");
	}
}
