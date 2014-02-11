package assignment2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Output handles JOptionPane output for the user
 *
 */
public class Output 
	{
	
	/**
	 * I/O for initial greeting
	 * @return 0 for yes
	 */
	public int greeting() 
	{
		return JOptionPane.showConfirmDialog(null, "        Welcome to Brantis Bank\n" +
				                                   "Would you like to make a new transaction?");
	}
	
	/** 
	 * I/o goodbye and summary for when the client is finished doing transactions 
	 */
	public void goodbye(ArrayList<BankAccount> accounts) 
	{
		System.out.println("\n\n");		// Adding blank lines to format output
		
		for(int i = 0; i < accounts.size(); i++)
		{
			System.out.println(accounts.get(i));
		}
		
		JOptionPane.showMessageDialog(null, "Goodbye", "Brantis Bank",  JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * I/O prompts client for transactions input
	 */
	public String getTransaction()
	{
		return JOptionPane.showInputDialog("Please input your transaction.");
	}
	
	/**
	 * I/O for invalid transaction
	 */
	public void showError()
	{
		JOptionPane.showMessageDialog(null, "Invalid transaction.", "ERROR!",  JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * I/O for result of the current transaction 
	 */
	public void currentTransaction(ArrayList<BankAccount> accounts, ArrayList<String> output, String[] transaction) 
	{
		output.add(accounts.get(0).toString());
		output.add(accounts.get(1).toString());
		JOptionPane.showMessageDialog(null, accounts.get(Integer.parseInt(transaction[0])-1), "Current Transaction.",  JOptionPane.INFORMATION_MESSAGE);
	}
	
}
