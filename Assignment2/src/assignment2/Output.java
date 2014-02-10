package assignment2;

import javax.swing.JOptionPane;

public class Output {
	
	public int greeting() 
	{
		int answer = JOptionPane.showConfirmDialog(null, "          Welcome to Brantis Bank\n " +
				                            "Would you like to make a new transaction?");
		return answer;
	}

	public void goodbye() 
	{
		JOptionPane.showMessageDialog(null, "Goodbye", "Brantis Bank",  JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String getTransaction(){
		String transaction = JOptionPane.showInputDialog("Please input your transaction.");
		return transaction;
	}
	
	public void showError(){
		JOptionPane.showMessageDialog(null, "Invalid transaction.", "ERROR!",  JOptionPane.INFORMATION_MESSAGE);
	}
	
	public int anotherTransaction() {
		int answer = JOptionPane.showConfirmDialog(null, "          Welcome to Brantis Bank\n " +
                "Would you like to make a another transaction?");
		return answer;
	}
	
	/*
	 * output summary of the transactions
	 */
	public void summary() {
		// TODO Auto-generated method stub
		
	}
	
}
