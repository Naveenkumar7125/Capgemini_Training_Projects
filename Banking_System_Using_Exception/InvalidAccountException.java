package Projects.Banking_System_Using_Exception;

public class InvalidAccountException extends Exception{
    public InvalidAccountException(String mes)
    {
        super(mes);
    }
}
