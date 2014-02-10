package assignment2;

public class StudentLoanAccount extends SavingsAccount {

	public StudentLoanAccount(int accountNum, double initialBalance) {
		super(accountNum, initialBalance);
	}

	public StudentLoanAccount(double initialBalance) {
		super(initialBalance);
	}
	
    public String toString()
    {
    	return "Student Loan Account Balance: " + balance;
    }	
}
