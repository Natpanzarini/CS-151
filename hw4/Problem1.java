import java.util.concurrent.*;

public class Problem1 {
  public static void main(String[] args) {
      //Uncomment this code to see unsynchronized threads.
      // ExecutorService service = Executors.newCachedThreadPool();
      // BankAccount account = new BankAccount();
      //
      // Runnable r1 = account.deposit(1);
      // Runnable r2 = account.withdraw(1);
      // service.execute(r1);
      // service.execute(r2);
      // service.shutdown();

      //Code using SyncedBankAccount which uses synchronized methods to fix corruption.
      ExecutorService service2 = Executors.newCachedThreadPool();
      SyncedBankAccount syncedAccount = new SyncedBankAccount();
      Runnable r3 = syncedAccount.deposit(1);
      Runnable r4 = syncedAccount.withdraw(1);
      service2.execute(r3);
      service2.execute(r4);
      service2.shutdown();
   }
}
