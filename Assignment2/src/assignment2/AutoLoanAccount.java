package assignment2;

import java.text.NumberFormat;

public class AutoLoanAccount extends SavingsAccount{

	public AutoLoanAccount(int accountNum, double initialBalance) {
		super(accountNum, initialBalance);
	}

	public AutoLoanAccount(double initialBalance) {
		super(initialBalance);
	}
	
    public String toString()
    {
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	String moneyString = "Savings Account Balance: " + formatter.format(balance);
    	return moneyString;
    }	
}
