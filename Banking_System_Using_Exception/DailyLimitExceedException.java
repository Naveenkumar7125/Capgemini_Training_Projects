package Projects.Banking_System_Using_Exception;

public class DailyLimitExceedException extends Exception{
    public DailyLimitExceedException(String mes)
    {
        super(mes);
    }
}
