package assignment2;

import java.text.NumberFormat;

/**
 * Extends SavingsAccount
 * @see SavingsAccount
 */
public class AutoLoanAccount extends SavingsAccount
{

	/**
	 * Creates an auto-loan account that extends the SavingsAccount class
	 * @param accountNum account number (int)
	 * @param initialBalance starting balance (double)
	 */
	public AutoLoanAccount(int accountNum, double initialBalance)
	{
		super(accountNum, initialBalance);
	}

	public AutoLoanAccount(double initialBalance) 
	{
		super(initialBalance);
	}

    public String toString()
    {
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	String moneyString = "Auto Loan Account Balance: " + formatter.format(balance) + "\n";
    	return moneyString;
    }	
}
