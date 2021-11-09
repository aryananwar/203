package lab6;

public class CheckingAccount extends BankAccount {
	private final double FEE = 0.15;
	
	public CheckingAccount(String name, double amount)
	{
		super(name, amount);
		super.setAccountNumber(super.getAccountNumber() + "-10");	
	}
	
	public boolean withdraw(double amount)
	{
		double x  =  (super.getBalance() - amount - FEE);
		if (amount + FEE <= super.getBalance())
			super.setBalance(x); 
		else
			return false;
		
		return true;
	}
}
