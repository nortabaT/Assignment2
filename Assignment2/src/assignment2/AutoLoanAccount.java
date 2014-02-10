package assignment2;

import java.text.NumberFormat;

public class AutoLoanAccount extends SavingsAccount{

	public AutoLoanAccount(int accountNum, double initialBalance) {
		super(accountNum, initialBalance);
	}

	public AutoLoanAccount(double initialBalance) {
		super(initialBalance);
	}
	/*
	 * (non-Javadoc)
	 * @see assignment2.SavingsAccount#toString()
	 */
    public String toString()
    {
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	String moneyString = "Auto Loan Account Balance: " + formatter.format(balance) + "\n";
    	return moneyString;
    }	
}
