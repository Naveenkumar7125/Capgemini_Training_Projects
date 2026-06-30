package Projects.Banking_System_Using_Exception;

class InsufficienBalanceException extends Exception
{
    //    String message = "Age should be greater than or equal to 18";
    public InsufficienBalanceException(String message)
    {
        super(message);
    }
}
