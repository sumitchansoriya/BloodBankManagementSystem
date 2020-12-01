package CAT2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HDFC implements Bank
{
	int bankID = 001;
	String branch, location;
	double interest, balance = 0.0;

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void setMonthlyInterest()
	{
		interest = 5.5;
	}

	@Override
	public void CreateAccount() {
		try {	
			System.out.println("Enter Bank Branch Name:");
			branch = br.readLine();
			System.out.println("Enter Branch Location:");
			location = br.readLine();
			System.out.println("Enter amount to be deposited: ");
			double amt = Double.parseDouble(br.readLine());
			Deposit(amt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void Deposit(double amount) {
		balance = balance + amount;
	}

	@Override
	public void Withdraw(double amount) {
		try
		{
			if(balance - amount < 0)
			throw new InsufficientBalance("Insufficient Balance! Couldn't withdraw.");
		else
			balance -= amount;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public double GetBalance() {
		return balance;
	}


	public double GetAnnualInterest() {
		setMonthlyInterest();
		return interest;
	}
}
