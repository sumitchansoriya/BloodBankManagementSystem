package BloodBank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class NoBloodException extends Exception 
{ 
    public NoBloodException(String s) 
    { 
        super(s); 
    } 
}

class BloodStorageFullException extends Exception 
{ 
    public BloodStorageFullException(String s) 
    { 
        super(s); 
    } 
}


public class Hospital implements BloodBank {
	
	Map<String, Double> bloodStock = new HashMap(); 
    
    
	public Hospital() {
		// TODO Auto-generated constructor stub
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

	@Override
	public void bloodStockStatus() {
		System.out.println(bloodStock);
	}

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub

	}

}
