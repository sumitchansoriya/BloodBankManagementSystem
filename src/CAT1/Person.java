package CAT1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Person {
	
	String name, address;
	int age;
		
	//Default Constructor
	public Person() {
		this.name = null;
        this.age = 0;
        this.address = null;
	}
	
	//Parameterized Constructor
	Person(String name,int age, String address){
	        this.name = name;
	        this.age = age;
	        this.address = address;
	    }
	
	//Copy Constructor
	Person(Person p) { 
        this.name = p.name;
        this.age = p.age;
        this.address = p.address;
    } 
	
	public void read() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the details below");
		System.out.println("Enter the name:");
		name = br.readLine();
		System.out.println("Enter the age:");
		age = Integer.parseInt(br.readLine());
		System.out.println("Enter the address:");
		address = br.readLine();
	}
	
	public void show()
	{
		System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
        System.out.println("Address : " + this.address);
	}

}

