package Projects.Banking_System_Using_Exception;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        bank.addAccount(new BankAccount(101, "Naveen", 1000000.00));
        bank.addAccount(new BankAccount(102, "Kumar", 100000.00));
        bank.addAccount(new BankAccount(103, "NK", 10000.00));

        
        try
        {
            System.out.print("\nEnter the sender Account Number : ");
            int sender = sc.nextInt();
            System.out.print("\nEnter the receiver Account Number : ");
            int receiver = sc.nextInt();
            System.out.print("\nEnter tranfer Amount : ");
            double amount = sc.nextDouble();

            BankAccount senderObj = bank.searchAccount(sender);
            BankAccount receiverObj = bank.searchAccount(receiver);

            senderObj.transfer(receiverObj, amount);
            senderObj.display();
            receiverObj.display();

//            System.out.println("Enter ");
        }
        catch (InvalidAmountException im)
        {
            System.out.println(im.getMessage());
        }
        catch (InsufficienBalanceException ib)
        {
            System.out.println(ib.getMessage());
        }
        catch (InvalidAccountException ia)
        {
            System.out.println(ia.getMessage());
        }
        catch (DailyLimitExceedException dl)
        {
            System.out.println(dl.getMessage());
        }

    }
}
