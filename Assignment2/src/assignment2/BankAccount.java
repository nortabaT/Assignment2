package assignment2;

import java.util.HashMap;
import java.util.Map;

/**
 * Model for general bank account object.  The purpose is to record money,
 * and allow for various financial transactions to be performed over the
 * life of a specific bank account.
 * 
 * @author ee322c teaching team
 */
class BankAccount 
{   

	private static final String CHECKING = "C";
	private static final String SAVINGS = "S";
	private static final String STUDENT_LOAN = "L";
	private static final String AUTO_LOAN = "A";
	
	private static final double OVERDRAFT_FEE = 20;
	private static final int ACCOUNT_NUM = 555555555;
	
	protected int accountNumber;
    protected Customer customer;

    protected CheckingAccount checkingAccount;
    protected SavingsAccount primarySavingsAccount;
    protected StudentLoanAccount studentLoanAccount;
    protected AutoLoanAccount autoLoanAccount;
    
    protected Map<String, GenericBankAccount> bankAccounts;
    
    
    //constructors
    /**
     * initial constructor for a new client.  
     *@param checkingAccount         checking account for the client
     *@param primarySavingsAccount   primary savings account for the client
     *@param studentLoanAccount      student loan account for the client
     *@param autoLoanAccount         auto loan account for the client
     *@param bankAccounts            hash map for the clients bank account
     */
    public BankAccount()
    {
        checkingAccount = new CheckingAccount(0);
        primarySavingsAccount = new SavingsAccount(0);
        studentLoanAccount = new StudentLoanAccount(0);
        autoLoanAccount = new AutoLoanAccount(0);
        
        bankAccounts = new HashMap<String, GenericBankAccount>();
        bankAccounts.put(CHECKING, checkingAccount);
        bankAccounts.put(SAVINGS, primarySavingsAccount);
        bankAccounts.put(AUTO_LOAN, autoLoanAccount);
        bankAccounts.put(STUDENT_LOAN, studentLoanAccount);
    }
    
    public BankAccount(Customer owner)
    {
    	this();
    	customer = owner;
    	accountNumber = ACCOUNT_NUM;
    }
    
    public BankAccount(int accountNum, Customer owner)
    {
    	this();
        accountNumber = accountNum;
        customer = owner;
    }
    
    public void setOwner(Customer newOwner)
    {
        customer = newOwner;
    }
    
    public Customer getOwner()
    {
    	return customer;
    }
    
    public void setAccountNumber(int accountNum)
    {
    	accountNumber = accountNum;
    }
    
    public int getAccountNumber()
    {
    	return accountNumber;
    }
       
    // Input:
    // transactionInfo[]: A valid transaction input for the Bank to process
    // [0] = customer id (not important for this function)
    // [1] = operation that the customer wants to perform
    // [2] = either an amount, or G/I for getBalance or calculateInterest
    // [3] = account to perform an action on
    // [4] = only used for transfers, this is the account that receives the money
    // Output: True for transaction completed, False for failed transaction
    public boolean doTransaction(String[] transactionInfo)
    {
    	if(transactionInfo[1].equals("D"))
    	{
			deposit(Double.parseDouble(transactionInfo[2]), transactionInfo[3]);	
			return true;
    	}
    	else if(transactionInfo[1].equals("W"))
    	{
    		return withdraw(Double.parseDouble(transactionInfo[2]), transactionInfo[3]);
    	}
    	else if(transactionInfo[1].equals("I"))
    	{
    		return calculateInterest(transactionInfo[2]);
    	}
    	else if(transactionInfo[1].equals("T"))
    	{
    		return transferFunds(Double.parseDouble(transactionInfo[2]), transactionInfo[3], transactionInfo[4]);
    	}
    	else if(transactionInfo[1].equals("G"))
    	{
			getBalance(transactionInfo[2]); 
			return true;
    	}    	
    	
    	return false;
    }
    
    private double getBalance(String account)
    {
    	return bankAccounts.get(account).getBalance();
    }
    /*
     * Transfers funds between accounts
     * @param account1   account money is coming from 
     * @param account2   account money will be going to 
     */
    private boolean transferFunds(double amount, String fromAccount, String toAccount)
    {
    	GenericBankAccount account1 = bankAccounts.get(fromAccount);
    	GenericBankAccount account2 = bankAccounts.get(toAccount);
    	
    	if(!account1.withdraw(amount)){
    		return false;
    	}
    	
    	account2.deposit(amount);
    	
    	return true;
    }
    /*
     * Calculates the interest for appropriate savings accounts
     * @param result  Confirms the transaction occurred or it did not
     */
    private boolean calculateInterest(String account)
    {
    	boolean result = bankAccounts.get(account).calculateInterest();
       	
    	return result;
    }
    /* 
     * Performs the withdrawal function
     * @param genAccount  accounts balance information 
     */
    private boolean withdraw(double amount, String account)
    {
    	
    	GenericBankAccount genAccount = bankAccounts.get(account);
    	
    	if(genAccount instanceof CheckingAccount)
    	{
    		if(!checkingAccount.withdraw(amount)){
    			return overdraftProtection(amount);
    		}
    		return true;
    	}
    	else if(!genAccount.withdraw(amount))
    	{
    		return false;
    	}
    	
    	return true;
    }
    
    // Input: money to deposit (double), upper case letter of account to deposit into (String)
    private void deposit(double amount, String account){
    	bankAccounts.get(account).deposit(amount);
    }
    /* 
     * Overdraft protection function for checking accounts and primary savings accounts
     */
    private boolean overdraftProtection(double amount){
    	
    	double checkingAccountBalance = checkingAccount.getBalance();
    	double savingsAccountBalance = primarySavingsAccount.getBalance();
    	
    	if(checkingAccountBalance + savingsAccountBalance >= amount + OVERDRAFT_FEE)
    	{
    		checkingAccount.withdraw(checkingAccountBalance); 		//just to make sure I'm using the right number
    		amount -= checkingAccountBalance;
 		
    		primarySavingsAccount.withdraw(amount + OVERDRAFT_FEE);	//just to make sure I'm using the right number
    		return true;
    	}
    		
    	return false;
    }
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
    	String out = customer + "\n" + checkingAccount + "\n" + primarySavingsAccount + "\n";
    	out += studentLoanAccount + "\n" + autoLoanAccount;
    	return out;
    }
    
}
