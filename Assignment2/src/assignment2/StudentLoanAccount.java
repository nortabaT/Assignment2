package assignment2;

import java.text.NumberFormat;

/**
 * Extends SavingsAccount
 * @see SavingsAccount
 */
public class StudentLoanAccount extends SavingsAccount 
{

	/**
	 * Creates a student loan account (extends savings account)
	 * @param accountNum number of this account (int)
	 * @param initialBalance starting balance (double)
	 */
	public StudentLoanAccount(int accountNum, double initialBalance) 
	{
		super(accountNum, initialBalance);
	}

	public StudentLoanAccount(double initialBalance)
	{
		super(initialBalance);
	}

    public String toString()
    {
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	String moneyString = "Student Loan Account Balance: " + formatter.format(balance);
    	return moneyString;
   }	
}
