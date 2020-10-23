package Demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Employee extends Person
{
	int empID;
	String companyName, deptName, designation;
	
	public void read()throws IOException
	{
		super.read();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		empID = generateEmpID();
        System.out.print("Enter the company name: ");
        companyName = br.readLine();
        System.out.print("Enter department name: ");
        deptName = br.readLine();
        System.out.print("Enter the designation: ");
        designation = br.readLine();
	}
	
	public int generateEmpID()
	{
		Random rand = new Random();
        //int eID = String.format("%05d", rand.nextInt(10000));
        int eID = rand.nextInt(10000);
        
        return eID;
	}
	
	public void show()
	{
		super.show();
        System.out.println("Employee ID : " + this.empID);
        System.out.println("Company Name : " + this.companyName);
        System.out.println("Department Name : " + this.deptName);
        System.out.println("Designation : " + this.designation);
	}
	
}