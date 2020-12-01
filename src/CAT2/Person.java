package CAT2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Person extends ICICI
{
	
	static int id = 0;
	StringBuffer personID = new StringBuffer("Bank"); 

	String name, accNo, accType, email, accHolder;


	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	StringBuffer assignPersonId()
	{
		id++;
		personID.replace(4, 8, String.format("%04d", id));
		
		return personID;
	}
	
	public void getDetails() throws IOException
	{
		System.out.println("Enter customer name: ");
		name = br.readLine();
		System.out.println("Enter account type: ");
		accType = br.readLine();
		System.out.println("Enter email: ");
		email = br.readLine();
	}

	public void AccountDetails()
	{
		accHolder = Character.toUpperCase(name.charAt(0)) + name.substring(1);

		System.out.println("Person ID: "+ assignPersonId());
		System.out.println("Name : "+ accHolder);
		System.out.println("Bank ID: " + bankID);
		System.out.println("Bank Name: " + branch);
		System.out.println("Account Balance: " + GetBalance());
		System.out.println("Annual Interest Rate: " +GetAnnualInterest());
	}


	public static void main(String[] args) throws IOException {
		try
		{
			int choice,count = 0;
			double amt;
			BufferedReader ch = new BufferedReader(new InputStreamReader(System.in));

			Person[] customer = new Person[3];
			while(count < 5)
			{
				System.out.println("-------------------------------------------------");
				System.out.println("*** MENU***");
				System.out.println("1.) Create account");
				System.out.println("2.) Deposit");
				System.out.println("3.) Withdraw");
				System.out.println("4.) Display account details");
				System.out.println("5.) Get Maximum Balance");
				System.out.println("6.) Exit");
				System.out.println("Enter your choice:");
				choice=Integer.parseInt(ch.readLine());
				switch(choice)
				{
				case 1:
					customer[id] = new Person();

					customer[id].getDetails();
					customer[id].CreateAccount();
					break;

				case 2:
					System.out.println("Enter the amount to be deposited: ");
					amt = Double.parseDouble(ch.readLine());
					customer[id].Deposit(amt);
					break;

				case 3:
					System.out.println("Enter the amount to be withdrawn");
					amt = Double.parseDouble(ch.readLine());
					customer[id].Withdraw(amt);
					break;

				case 4:
					customer[id].AccountDetails();
					break;

				case 6:
					System.exit(0);
					break;
				
				case 5:
					double temp = 0.0;
					for(int i = 1; i<=id; i++)
					{
						if(customer[i].balance > temp)
						{
							temp = customer[i].balance ;
						}
					}
					System.out.println("Maximum Balance: " +temp);
					break;
					
				default:
					System.out.println("INVALID INPUT!");
					break;
				}
				count++;
			}
		} 
		catch(Exception E)
		{
			System.out.println("Operation Failed! Problem Occured.");
			System.out.println("Contact your Administrator/Developer.");
			System.out.println(System.err);
			System.out.println(E.getMessage());
		}
		finally
		{
			System.out.println("Thanks for using our Bank portal!");
		}

	}
}
