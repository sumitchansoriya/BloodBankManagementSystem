package BBException;


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

public class BloodBankException {

}
