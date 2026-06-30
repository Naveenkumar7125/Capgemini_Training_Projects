package Projects.Banking_System_Using_Exception;

public class Bank {
    private BankAccount[] accounts;
    private int count;

    public Bank()
    {
        accounts = new BankAccount[10];
        count = 0;
    }

    public void addAccount(BankAccount account)
    {
        accounts[count++] = account;
    }
    public BankAccount searchAccount(int accountNumber) throws InvalidAccountException
    {
        for(int i=0;i<count;i++)
        {
            if(accounts[i].getAccoutNumber() == accountNumber)return accounts[i];
        }

        throw new InvalidAccountException("Account Not found");
    }

}
