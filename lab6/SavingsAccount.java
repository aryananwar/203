package lab6;


public class SavingsAccount extends BankAccount {
	private final double rate = 1.00208888;
	private int savingsNumber = 0;
	private String accountNumber;
	

	public SavingsAccount(String name, int amount)
	{
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	//copy constructor
	public SavingsAccount (SavingsAccount original, int amount)
	{
		super(original, amount);
		accountNumber =  super.getAccountNumber() + "-" + (savingsNumber +1);
	}
	
	public void postInterest()
	{
		super.setBalance(super.getBalance() * rate);
	}
	public String getAccountNumber()
	{
		return accountNumber;
	}
	


}
