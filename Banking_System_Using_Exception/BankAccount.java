package Projects.Banking_System_Using_Exception;

public class BankAccount {
    private int accoutNumber;
    private String accountHolder;
    private double balance;

    static final double DAILY_LIMIT = 50000;

    public BankAccount(int accoutNumber, String accountHolder, double balance)
    {
        super();
        this.accoutNumber = accoutNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccoutNumber() {
        return accoutNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidAmountException
    {
        if(amount < 0)throw new InvalidAmountException("Dposit amount should be positive");

        balance += amount;

        System.out.println("Deposit Sucessful");
        System.out.println("Current Balance is : " + balance);
    }

    public  void withdraw(double amount)throws InvalidAmountException, DailyLimitExceedException, InsufficienBalanceException
    {
        if(amount < 0)
        {
            throw new InvalidAmountException("Amount should be positive");
        }
        if(amount > DAILY_LIMIT)
        {
            throw new DailyLimitExceedException("Daily Limit is Crossed");
        }
        if(amount > balance)
        {
            throw new InsufficienBalanceException("The Balance is Insufficient");
        }

        balance -= amount;

        System.out.println("Withdrawl Success");

        System.out.println("Balance Amount : " + balance);
    }
    public void transfer(BankAccount receiver, double amount) throws InvalidAmountException, InsufficienBalanceException, DailyLimitExceedException
    {
        withdraw(amount);
        receiver.balance += amount;
        System.out.println("Transfer Successful");
    }
    public void display()
    {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Account Number : " + this.accoutNumber);
        System.out.println("Account Holder Name : " + this.accountHolder);
        System.out.println("Account Balance : " + this.getBalance());
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

    }

}
