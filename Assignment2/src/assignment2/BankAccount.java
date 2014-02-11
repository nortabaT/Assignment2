package assignment2;

import java.util.HashMap;
import java.util.Map;

/**
 * Model for general bank account object.  The purpose is to record money,
 * and allow for various financial transactions to be performed over the
 * life of a specific bank account.
 */
class BankAccount 
{   

	private static final String CHECKING = "C";
	private static final String SAVINGS = "S";
	private static final String STUDENT_LOAN = "L";
	private static final String AUTO_LOAN = "A";
	
	private static final String WITHDRAW = "W";
	private static final String DEPOSIT = "D";
	private static final String TRANSFER = "T";
	private static final String INTEREST = "I";
	private static final String GET_BALANCE = "G";
	
	private static final double OVERDRAFT_FEE = 20;
	private static int account_num = 555555555;
	
	private int accountNumber;
    private Customer customer;

    private CheckingAccount checkingAccount;
    private SavingsAccount primarySavingsAccount;
    private StudentLoanAccount studentLoanAccount;
    private AutoLoanAccount autoLoanAccount;
    
    private Map<String, GenericBankAccount> bankAccounts;
    
    
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
    
    /**
     * Creates a BankAccount with 4 different sub-accounts
     * @param owner Customer with a name and id
     */
    public BankAccount(Customer owner)
    {
    	this();
    	customer = owner;
    	accountNumber = account_num;
    	
    	account_num += 1;	
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
       

    
    /** Processes transaction given from user
     * @param String[] transactionInfo
     * [0] = customer id (not important for this function)
     * [1] = operation that the customer wants to perform
     * [2] = either an amount, or G/I for getBalance or calculateInterest
     * [3] = account to perform an action on
     * [4] = only used for transfers, this is the account that receives the money
     * @return true if transaction was successful, false if not
     */
    public boolean doTransaction(String[] transactionInfo)
    {
    	if(transactionInfo[1].equals(DEPOSIT))
    	{
			deposit(Double.parseDouble(transactionInfo[2]), transactionInfo[3]);	
			return true;
    	}
    	else if(transactionInfo[1].equals(WITHDRAW))
    	{
    		return withdraw(Double.parseDouble(transactionInfo[2]), transactionInfo[3]);
    	}
    	else if(transactionInfo[1].equals(INTEREST))
    	{
    		return calculateInterest(transactionInfo[2]);
    	}
    	else if(transactionInfo[1].equals(TRANSFER))
    	{
    		return transferFunds(Double.parseDouble(transactionInfo[2]), transactionInfo[3], transactionInfo[4]);
    	}
    	else if(transactionInfo[1].equals(GET_BALANCE))
    	{
			getBalance(transactionInfo[2]); 
			return true;
    	}    	
    	
    	return false;
    }
    
    /**
     * Outputs balance of account requested
     * @param account account balance requested
     */
    private void getBalance(String account)
    {
    	System.out.println(this.customer);
    	System.out.println(bankAccounts.get(account));
    }
    
    /**
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
    
    /**
     * Calculates the interest for appropriate savings accounts
     * @param result  Confirms the transaction occurred or it did not
     */
    private boolean calculateInterest(String account)
    {
    	boolean result = bankAccounts.get(account).calculateInterest();
       	
    	return result;
    }
    /** 
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
    
    /**
     * Deposits money into specified account
     * @param amount $ to be deposited
     * @param account type of account to be used
     */
    private void deposit(double amount, String account){
    	bankAccounts.get(account).deposit(amount);
    }

    /**
     * Processes overdraft protection of the customer's checking account
     * @param amount $ requested for withdraw
     * @return true if overdraft protection was successful, false if balance is too low
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

    public String toString()
    {
    	String out = customer + "\n" + checkingAccount + "\n" + primarySavingsAccount + "\n";
    	out += studentLoanAccount + "\n" + autoLoanAccount;
    	return out;
    }
    
}
