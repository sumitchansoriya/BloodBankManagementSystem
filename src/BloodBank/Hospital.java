package BloodBank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import BBException.*;
import Donor.Donor;


public class Hospital extends Donor implements BloodBank {
	
	Map<String, Double> bloodStock = new HashMap(); 
    
    
	public Hospital() {
		
		super();
		bloodStock.put("A+", 0.00);
		bloodStock.put("B+", 0.00);
		bloodStock.put("AB+", 0.00);
		bloodStock.put("O+", 0.00);
		bloodStock.put("A-", 0.00);
		bloodStock.put("B-", 0.00);
		bloodStock.put("AB-", 0.00);
		bloodStock.put("O-", 0.00);
	}

	
	public void updateBloodStockDonor(String bloodType, double qty) throws BloodStorageFullException
	{
		Double storageCapacity = 10.0;
		
		for (Map.Entry<String, Double> element : bloodStock.entrySet()) 
		{ 
            String key = element.getKey(); 
            Double value = element.getValue(); 

            if(key.equalsIgnoreCase(bloodType))
            {
            	if(value + qty <= storageCapacity)
            	{
            	value = value + qty;
            	}
            	else
            	{
            		throw new BloodStorageFullException("Blood Storage full in this Hospital");
            	}
            	
            	System.out.println("Updated " +key + " Blood Group in Blood Stock Invetory");
            }
            
             
        } 
	}
	
	public void welcome(String user)
	{
		System.out.println("Welcome "+user+" ...");
	}

	public void bloodStockStatus() {
		System.out.println(bloodStock);
	}

	public static void main(String[] args)  throws IOException{
		
	}

}
