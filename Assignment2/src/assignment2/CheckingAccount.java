package assignment2;

import java.text.NumberFormat;

public class CheckingAccount extends GenericBankAccount{

	public CheckingAccount(int accountNum, double initBalance) 
	{
		super(accountNum, initBalance);
	}
	
	public CheckingAccount(double initBalance) 
	{
		super(initBalance);
	}
	/*
	 * (non-Javadoc)
	 * @see assignment2.GenericBankAccount#toString()
	 */
    public String toString()
    {
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	String moneyString = "Checking Account Balance: " + formatter.format(balance);
    	return moneyString;
    }
    /*
     * (non-Javadoc)
     * @see assignment2.GenericBankAccount#calculateInterest()
     */
	public boolean calculateInterest() 
	{
		return false;
	}
}
