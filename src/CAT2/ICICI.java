package CAT2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import CAT2.Bank;
import CAT2.InsufficientBalance;

public class ICICI implements Bank
{
	int bankID = 002;
	String branch, location;
	double interest, balance = 0.0;

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void setMonthlyInterest()
	{
		interest = 5.0;
	}

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

	public void Deposit(double amount) {
		balance = balance + amount;
	}

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

	public double GetBalance() {
		return balance;
	}

	public double GetAnnualInterest() {
		setMonthlyInterest();
		return interest;
	}
}
