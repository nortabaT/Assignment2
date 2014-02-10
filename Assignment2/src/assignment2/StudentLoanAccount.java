package assignment2;

import java.text.NumberFormat;

public class StudentLoanAccount extends SavingsAccount {

	public StudentLoanAccount(int accountNum, double initialBalance) {
		super(accountNum, initialBalance);
	}

	public StudentLoanAccount(double initialBalance) {
		super(initialBalance);
	}
	/*
	 * (non-Javadoc)
	 * @see assignment2.SavingsAccount#toString()
	 */
    public String toString()
    {
    	NumberFormat formatter = NumberFormat.getCurrencyInstance();
    	String moneyString = "Student Loan Account Balance: " + formatter.format(balance);
    	return moneyString;
   }	
}
