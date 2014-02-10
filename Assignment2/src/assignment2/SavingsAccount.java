package assignment2;

import java.text.NumberFormat;

public class SavingsAccount extends GenericBankAccount
{

	protected double interestRate = .04;
	
	public SavingsAccount(double initialBalance) 
	{
		super(initialBalance);
	}
	
	public SavingsAccount(int accountNum, double initialBalance) 
	{
		super(accountNum, initialBalance);
	}

	public boolean calculateInterest()
	{
		
		if(balance >= 1000){
			balance += balance*interestRate;
			return true;
		}
		else{
			return false;
		}
	}
	
	public void setInterestRate(double i)
	{
		interestRate = i;
	}
	
	public double getInterestRate()
	{
		return interestRate;
	}
	
    public String toString()
    {
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	String moneyString = "Savings Account Balance: " + formatter.format(balance);
    	return moneyString;
    }	
}
