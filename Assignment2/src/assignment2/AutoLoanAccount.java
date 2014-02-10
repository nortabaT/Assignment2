package assignment2;

public class AutoLoanAccount extends SavingsAccount{

	public AutoLoanAccount(int accountNum, double initialBalance) {
		super(accountNum, initialBalance);
	}

	public AutoLoanAccount(double initialBalance) {
		super(initialBalance);
	}
	
    public String toString()
    {
    	return "Auto Loan Repayment Account Balance: " + balance;
    }	
}
