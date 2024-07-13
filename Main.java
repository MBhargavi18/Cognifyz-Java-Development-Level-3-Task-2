public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        
        Thread t1 = new Thread(new Worker(account), "Worker-1");
        Thread t2 = new Thread(new Worker(account), "Worker-2");
        Thread t3 = new Thread(new Worker(account), "Worker-3");

        t1.start();
        t2.start();
        t3.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
