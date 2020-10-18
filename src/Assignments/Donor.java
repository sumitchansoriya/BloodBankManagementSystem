package Assignments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Class name
public class Donor {

	//Static variable
	static int donorID = 0;

	//Data members
	protected String donorName, gender, address, bloodGroup;
	int age, lastDonation, counter = 0;

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	//Default Constructor
	Donor()
	{
		donorName = null;
		gender = null;
		bloodGroup = null;
		address = null;
		age = 0;
	}

	//Parameterized Constructor
	Donor(String name, String  sex, String  bloodgroup, String  add, int age)
	{
		donorName = name;
		gender = sex;
		bloodGroup = bloodgroup;
		address = add;
		age = age;
	}

	//Static block
	static
	{
		System.out.println("***WELCOME TO BLOOD BANK MANAGEMENT SYSTEM***");
	}
	
	//Static method
	static int assignDonorId()
	{
		donorID++;
		return donorID;
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
		if(ch == 'Y')
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
		System.out.println("Donor ID: "+ assignDonorId());
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
	        System.out.println("Person with the following conditions are not allowed to donate blood: ");
	        System.out.println(" - Cancer");
	        System.out.println(" - Cardiac disease ");
	        System.out.println(" - HIV infection");
	        System.out.println(" - Chronic alcoholism");
	        System.out.println(" - Piercing and Tattooing");
	    }
	}

	public static void main(String[] args) throws IOException {
		int choice,i=0;

		BufferedReader ch = new BufferedReader(new InputStreamReader(System.in));
		
		bloodDonationConditions.listBloodDonationConditions();
		
		// Array of objects
		Donor[] bloodDonor = new Donor[2] ;

		bloodDonor[0] = new Donor();
		bloodDonor[1] = new Donor();

		while(i<3)
		{
			System.out.println("*** MENU***");
			System.out.println("1.) Add Donor");
			System.out.println("2.) Print Donor Details");
			System.out.println("Enter your choice:");
			choice=Integer.parseInt(ch.readLine());
			switch(choice)
			{
			case 1:
				bloodDonor[0].enterDonorDetails();
				bloodDonor[1].enterDonorDetails();
				break;

			case 2:
				bloodDonor[0].printDonorDetails();
				bloodDonor[1].printDonorDetails();
				break;

			}
		}

	}

}
