package Donor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatException;

//import BloodBank.Hospital;

//Class name
public class Donor{

	//Static variable
	static int id = 0;

	//String Buffer
	StringBuffer donorID = new StringBuffer("BBMS"); 

	//Data members
	protected String donorName, gender, address, bloodGroup;
	int age, lastDonation, counter = 0;

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	//Default Constructor
	Donor()
	{
		this.donorName = null;
		this.gender = null;
		this.bloodGroup = null;
		this.address = null;
		this.age = 0;
	}

	//Parameterized Constructor
	Donor(String name, String  sex, String  bloodgroup, String  add, int age)
	{
		this.donorName = name;
		this.gender = sex;
		this.bloodGroup = bloodgroup;
		this.address = add;
		this.age = age;
	}

	//Static block
	static
	{
		System.out.println("-------------------------------------------------");
		System.out.println("-----WELCOME TO BLOOD BANK MANAGEMENT SYSTEM-----");
		System.out.println("-------------------------------------------------");
	}

	//Static method
	static void totalDonorCount()
	{
		System.out.println("Total registered donor count is "+id);
	}

	void assignDonorId()
	{
		id++;
		//donorID.append(String.format("%04d", id));
		//donorID.insert(4, String.format("%04d", id)); 
		donorID.replace(4, 8, String.format("%04d", id));
	}

	//Member function with Access specifier
	protected void getDonorData() throws IOException
	{

		System.out.println("Enter donor name:");
		donorName = br.readLine();
		System.out.println("Enter donor's gender:");
		gender = br.readLine();
		System.out.println("Enter donor's blood group:");
		bloodGroup = br.readLine();
		System.out.println("Enter donor's address:");
		address = br.readLine();
		System.out.println("Enter donor's age:");
		age = Integer.parseInt(br.readLine());
	}

	protected void enterDonorDetails() throws IOException
	{
		Boolean tmp = false;
		getDonorData();
		System.out.println("Enter last time you donated blood in mnths(0 if its first time):");
		lastDonation = Integer.parseInt(br.readLine());
		if(lastDonation == 0)
			tmp = quickCheckUp(age);
		else
			tmp = quickCheckUp(age, lastDonation);

		if(tmp == false && counter < 3)
		{
			counter++;
			enterDonorDetails();
		}
		else if(counter >= 3)
			System.out.println("Limit Exceeded! Try again.");
	}

	protected boolean quickCheckUp(int age) throws IOException
	{
		if(age < 18)
		{
			System.out.println("Sorry! You cannot donate blood before 18 yrs of age.");
			return false;
		}
		System.out.println("Do you have a tattoo, High BP or Diabetis? Y/N");
		char ch = (char)br.read();
		if(Character.toUpperCase(ch) == 'Y')
		{
			System.out.println("Sorry! You cannot donate blood.");
			return false;
		}
		return true;
	}

	//Function overloading
	protected boolean quickCheckUp(int age, int lastDonation) throws IOException
	{
		if(age < 18)
		{
			System.out.println("Sorry! You cannot donate blood before 18 yrs of age.");
			return false;
		}
		else if(lastDonation < 3)
		{
			System.out.println("Sorry! You cannot donate blood before 3mnths since your last donation.");
			return false;
		}
		System.out.println("Do you have a tattoo, High BP or Diabetis? Y/N");
		char ch = (char)br.read();
		if(ch == 'Y')
		{
			System.out.println("Sorry! You cannot donate blood.");
			return false;
		}
		return true;
	}

	//Member function with Access specifier
	protected void printDonorDetails()
	{
		System.out.println("-----DONOR DETAILS-----");
		System.out.println("Donor ID: "+ donorID);
		System.out.println("Donor Name: "+ donorName);
		System.out.println("Gender: "+gender);
		System.out.println("Blood Group: "+bloodGroup);
		System.out.println("Age:" +age);
		System.out.println("Address:" +address);
	}

	//Nested static class
	public static class bloodDonationConditions
	{
		public static void listBloodDonationConditions()
		{
			System.out.println("-------------------------------------------------");
			System.out.println("Person with the following conditions are not allowed to donate blood: ");
			System.out.println(" - Cancer");
			System.out.println(" - Cardiac disease ");
			System.out.println(" - HIV infection");
			System.out.println(" - Chronic alcoholism");
			System.out.println(" - Piercing and Tattooing");
		}
	}

	public static void main(String[] args) throws IOException {
		try
		{
			int choice,count = 0;

			if (args.length > 0) 
				System.out.println("Hello "+args[0]+"...");
			else
				System.out.println("Hello User..."); 

			BufferedReader ch = new BufferedReader(new InputStreamReader(System.in));

			bloodDonationConditions.listBloodDonationConditions();

			// Array of objects
			Donor[] bloodDonor = new Donor[5] ;

			while(count < 5)
			{
				System.out.println("-------------------------------------------------");
				System.out.println("*** MENU***");
				System.out.println("1.) Add a new Donor");
				System.out.println("2.) Print Donor Details");
				System.out.println("3.) Total Donors count");
				System.out.println("4.) Exit");
				System.out.println("Enter your choice:");
				choice=Integer.parseInt(ch.readLine());
				switch(choice)
				{
				case 1:
					bloodDonor[id] = new Donor();
					bloodDonor[id].enterDonorDetails();
					bloodDonor[id].assignDonorId();
					break;

				case 2:
					if(id == 0)
					{
						System.out.println("No Donor details found!");
					}
					else
					{
						for(int i=0; i < id; i++)
						{
							bloodDonor[i].printDonorDetails();
							System.out.println("---------------------");
						}
					}
					break;

				case 3:
					totalDonorCount();
					break;

				case 4:
					System.exit(0);
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
			System.out.println("Thanks for using BBMS Portal!");
		}
	}

}
