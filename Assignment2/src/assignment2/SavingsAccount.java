package assignment2;

public class SavingsAccount extends GenericBankAccount{

	protected double interestRate = .4;
	
	public SavingsAccount(double initialBalance) {
		super(initialBalance);
	}
	
	public SavingsAccount(int accountNum, double initialBalance) {
		super(accountNum, initialBalance);
	}

	public boolean calculateInterest(){
		
		if(balance >= 1000){
			balance += balance*interestRate;
			return true;
		}
		else{
			return false;
		}
	}
	
	public void setInterestRate(double i){
		interestRate = i;
	}
	
	public double getInterestRate(){
		return interestRate;
	}
	
    public String toString()
    {
    	return "Savings Account Balance: " + balance;
    }	
}
