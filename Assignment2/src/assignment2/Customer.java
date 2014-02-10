package assignment2;

public class Customer {
	private String name;
	private int id;
	private String address;
	
	Customer(String name, int id)
	{
		this.name = name;
		this.id = id;
	}
	
	Customer(String name, int id, String address)
	{
		this.name = name;
		this.id = id;
		this.address = address;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getID(){
		return id;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String toString()
	{
		return "Customer Name: "+name+" ID: "+id;
	}
}
