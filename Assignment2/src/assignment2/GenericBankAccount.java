package assignment2;


/**
 * Abstract class GenericBankAccount is used to model the skeleton of a bank account
 * it contains the basics of a bank account, including withdraw, deposit, an account number and balance
 * 
 * includes an abstract method called 'calculateInterest' which is left up to the specific bank account to decide what to do
 */
public abstract class GenericBankAccount 
{
	
	protected int accountNumber;
	protected double balance;
	
    public GenericBankAccount(double initialBalance)
    {
        balance = initialBalance;
    }
    
    /**
     * Create an account with initial parameters.
     * @param acct               The account number
     * @param owner              The owner of the account
     * @param initBalance        The initial balance of the account
     */
    public GenericBankAccount(int accountNum, double initBalance)
    {
        accountNumber = accountNum;
        balance = initBalance; 
    }
 
    /**
     * Updates the current balance by adding in a given amount.
     * Post condition: the new balance is increased by the amount.
     * @param amount                The amount to add
     */
    public void deposit(double amount) 
    {  
       balance = balance + amount; 
    }
    
    /**
     * Update the current balance by subtracting the given amount.
     * Precondition: the current balance must have at least the amount in it.
     * Postcondition: the new balance is decreased by the given amount.
     * @param amount  The amount to subtract
     */
    public boolean withdraw(double amount) 
    {  
        if (balance >=  amount)
        {
        	balance = balance - amount;
        	return true;
        }
        else{
        	return false;
        }
            
    }

    public double getBalance( )
    {
        return balance;
    }
    
    public int getAccountNumber( )
    {
        return accountNumber;
    }

    public void setBalance(double newBalance )
    {
        balance = newBalance;
    }

    public void setAccountNumber(int newAcctNumber )
    {
        accountNumber = newAcctNumber;
    }
    
    public String toString()
    {
    	return "Balance: " + balance;
    }
    
    /**
     * Abstract method that will decide how to calculate interest (if any)
     * @return true of false if successful or not
     */
    public abstract boolean calculateInterest();
}
