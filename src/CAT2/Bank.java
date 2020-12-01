package CAT2;

public interface Bank {

	public void CreateAccount();
	public void Deposit(double amount);
	public void Withdraw(double amount);
	public double GetBalance();
	public double GetAnnualInterest();
}

