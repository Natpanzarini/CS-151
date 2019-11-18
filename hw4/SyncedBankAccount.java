import java.util.concurrent.*;

public class SyncedBankAccount{
  private static Integer bankAccount = 0;


  synchronized public static Runnable deposit(int amount)
  {
    return () ->
    {
        for (int i = 0; i < 10; i++)
        {
          bankAccount += amount;
          System.out.println("Current amount after deposit: " + bankAccount);
        }
    };
  }

  synchronized public static Runnable withdraw(int amount)
  {
    return() ->
    {
        for (int i = 0; i < 10; i++)
        {
            bankAccount -= amount;
            System.out.println("Current amount after withdrawal: " + bankAccount);
        }
    };
  }
}
