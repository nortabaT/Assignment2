package assignment2;

import java.text.NumberFormat;

public class StudentLoanAccount extends SavingsAccount {

	public StudentLoanAccount(int accountNum, double initialBalance) {
		super(accountNum, initialBalance);
	}

	public StudentLoanAccount(double initialBalance) {
		super(initialBalance);
	}
	
    public String toString()
    {
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	String moneyString = "Savings Account Balance: " + formatter.format(balance);
    	return moneyString;
    }	
}
