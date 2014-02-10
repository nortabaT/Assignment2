package assignment2;
import java.util.ArrayList;

public class Client {
	
	static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	static ArrayList<String> transactions = new ArrayList<String>();
	static String[] initialNames = {"Curtis", "Brandon"};
	static Output outputText = new Output();
	
	public static void main(String[] args) 
	{		

		initCustomers();
		
		promptAndProcessInput();
		
		outputText.goodbye();
		System.out.println(transactions.toString());
	}
	
	public static void promptAndProcessInput()
	{
		while ( outputText.greeting() == 0)
		{
			String input = outputText.getTransaction().toUpperCase();
			String[] transaction = (input).trim().split(" ");
			
			if(checkInput(input) && accounts.get(Integer.parseInt(transaction[0])-1).doTransaction(transaction)){
				System.out.println("Valid Transaction");
				
				transactions.add(input);
				// DEBUG
				System.out.println(accounts.get(Integer.parseInt(transaction[0])-1));
			}
			else{
				outputText.showError();
			}
		}
	}
	
	public static void initCustomers()
	{
		for(int i = 0; i < initialNames.length; i++)
		{
			accounts.add(new BankAccount(new Customer(initialNames[i], i+1)));
		}	
	}
	
	private static boolean checkInput(String input)
	{
		boolean wd = input.matches("^[12] [WD] [0-9]+ [CSLA]$");
		boolean t = input.matches("^[12] [T] [0-9]+ [CSLA] [CSLA]$");
		boolean i = input.matches("^[12] [I] [SLA]$");
		boolean g = input.matches("^[12] [G] [CSLA]$");
		return wd | t | i | g;
	}
}
