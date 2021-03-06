package assignment2;
import java.util.ArrayList;

/*
* Assignment 2 - Bank Accounts
* EE 422c Perry Spring 2014
* Curtis Martin
* Brandon Dsouza  bjd879 (16695)
*/

public class Client 
{
	static final int CONTINUE = 0;
	static final int QUIT = 1;
	static final int EXIT = -1;
	static final int CANCEL = 2;
	
	static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	static ArrayList<String> transactions = new ArrayList<String>();
	static String[] initialNames = {"Curtis", "Brandon"};
	static Output outputText = new Output();
	
	public static void main(String[] args) 
	{		
		initCustomers();
		promptAndProcessInput();
		outputText.goodbye(accounts);
	}
	
	/**
	 * Prompts clients input and handles invalid inputs
	 */
	public static void promptAndProcessInput()
	{
		int userChoice = outputText.greeting();
		while (userChoice == CONTINUE)
		{
			String input = outputText.getTransaction();
			if (input != null )
			{
				input = input.toUpperCase();		
				String[] transaction = (input).trim().split(" ");
			
				if(checkInput(input) && accounts.get(Integer.parseInt(transaction[0])-1).doTransaction(transaction))
				{
					outputText.currentTransaction(accounts, transactions, transaction);
				}
				else
				{
					outputText.showError();
				}
			}
			else
			{
				outputText.showError();
			}
			userChoice = outputText.greeting();
		}
	}
	
	/**
	 * Creates the initial customers 
	 */
	public static void initCustomers()
	{
		for(int i = 0; i < initialNames.length; i++)
		{
			accounts.add(new BankAccount(new Customer(initialNames[i], i+1)));
		}	
	}
	/**
	 * evaluates the users input and returns the appropriate transaction type or false for an invalid transaction
	 * @param wd	boolean for withdrawal or deposit transaction
	 * @param t		boolean for a transfer transaction
	 * @param i		boolean for an interest  transaction
	 * @param g   	boolean for current balance transaction
	 * @return 		true if input is valid, false if no match on input
	 */
	private static boolean checkInput(String input)
	{
		boolean wd = input.matches("^[12] [WD] [0-9]+(\\.[0-9][0-9]?)? [CSLA]$");
		boolean t = input.matches("^[12] [T] [0-9]+(\\.[0-9][0-9]?)? [CSLA] [CSLA]$");
		boolean i = input.matches("^[12] [I] [SLA]$");
		boolean g = input.matches("^[12] [G] [CSLA]$");
		return wd | t | i | g;
	}
}
