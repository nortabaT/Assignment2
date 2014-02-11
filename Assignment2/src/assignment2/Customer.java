package assignment2;

/**
 * Customer is an object that holds the property of name, id and address of a person
 * Used to clarify who is the owner of a BankAccount
 */
public class Customer {
	
	private String name;
	private int id;
	private String address;
	
	/**
	 * Creates a Customer object
	 * @param name String Person's name
	 * @param id   int Person's id number
	 */
	Customer(String name, int id)
	{
		this.name = name;
		this.id = id;
	}
	
	/**
	 * Creates a customer object
	 * @param name Person's name
	 * @param id   Person's id number
	 * @param address Person's address
	 */
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
		return "Customer Name: "+name+"\n" +
			   "Customers ID: "+id;
	}
}
