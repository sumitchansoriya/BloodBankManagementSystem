package CAT1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class EmployeeSalary extends Employee
{
	double basic, DA, HRA, IT, PF, gross_salary, deduction, net_salary;
	
	public void read()throws IOException
	{
		super.read();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the Basic Salary: ");
        basic = Integer.parseInt(br.readLine());
        System.out.print("Enter the HRA: ");
        HRA = Double.parseDouble(br.readLine());
        System.out.print("Enter the DA: ");
        DA = Double.parseDouble(br.readLine());
        System.out.print("Enter the PF being deducted: ");
        PF = Double.parseDouble(br.readLine());
        System.out.print("Enter the IT being deducted: ");
        IT = Double.parseDouble(br.readLine());
	}
	
	public double net_salary()
	{
	 gross_salary = basic + DA + HRA;
	 deduction = PF - IT;
	 net_salary = gross_salary - deduction;
	 return net_salary;
	} 
	
	public void show()
	{
		super.show();
        System.out.println("Gross Salary : " + this.gross_salary);
        System.out.println("Deduction : " + this.deduction);
        System.out.println("Net Salary : " + net_salary());
        
	}
	
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the total number of employees: ");
        int empCount = Integer.parseInt(br.readLine());
        
        EmployeeSalary[] empSal = new EmployeeSalary[empCount];
        
       for(int i = 0; i < empCount; i++)
       {
    	   empSal[i] = new EmployeeSalary();
    	   empSal[i].read();
       }
       
       for(EmployeeSalary element:empSal){
    	   element.show();
           } 
	}
}