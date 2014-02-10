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

    public String toString()
    {
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	String moneyString = "Savings Account Balance: " + formatter.format(balance);
    	return moneyString;
    }

	public boolean calculateInterest() 
	{
		return false;
	}
}
