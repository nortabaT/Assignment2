package assignment2;

import java.text.NumberFormat;


/**
 * SavingsAccount extends the abstract class of GenericBankAccount and 
 * implements it's own way to calculate interest (4%)
 *
 * @see GenericBankAccount
 */
public class SavingsAccount extends GenericBankAccount
{

	protected static final double MIN_INTEREST_BALANCE = 1000;
	protected double interestRate = .04;
	
	public SavingsAccount(double initialBalance) 
	{
		super(initialBalance);
	}
	
	public SavingsAccount(int accountNum, double initialBalance) 
	{
		super(accountNum, initialBalance);
	}


	/**
	 * Calculate interest if balance is greater than the minimum balance for interest (1000)
	 * @return true if successful, false if not
	 */
	public boolean calculateInterest(){
		
		if(balance >= MIN_INTEREST_BALANCE){
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
	/*
	 * (non-Javadoc)
	 * @see assignment2.GenericBankAccount#toString()
	 */
    public String toString()
    {
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	String moneyString = "Savings Account Balance: " + formatter.format(balance);
    	return moneyString;
    }	
}
