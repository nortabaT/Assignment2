package assignment2;

import java.text.NumberFormat;

/**
 * Extends GenericBankAccount.
 * Returns false on calculating interest (checking accounts don't provide interest over time)
 * @see GenericBankAccount
 *
 */
public class CheckingAccount extends GenericBankAccount
{

	/**
	 * Creates a checking account
	 * @param accountNum account number for customer (int)
	 * @param initBalance starting balance (double)
	 */
	public CheckingAccount(int accountNum, double initBalance) 
	{
		super(accountNum, initBalance);
	}
	
	public CheckingAccount(double initBalance) 
	{
		super(initBalance);
	}

    public String toString()
    {
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	String moneyString = "Checking Account Balance: " + formatter.format(balance);
    	return moneyString;
    }

    /**
     * Checking Accounts don't provide interest
     * @return false
     */
	public boolean calculateInterest() 
	{
		return false;
	}
}
