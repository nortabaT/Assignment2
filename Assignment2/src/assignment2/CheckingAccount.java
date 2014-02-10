package assignment2;

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
    	return "Checking Account Balance: " + balance;
    }

	public boolean calculateInterest() 
	{
		return false;
	}
}
