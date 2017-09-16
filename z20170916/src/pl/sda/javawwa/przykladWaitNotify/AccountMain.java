package pl.sda.javawwa.przykladWaitNotify;

public class AccountMain {

    public static void main(String[] args) {

        Account account = new Account(1000);

        new Thread(() -> {
            account.withdraw(2000);
        }).start();

        new Thread(() -> {
            account.deposit(1);
        }).start();

        new Thread(() -> {
            account.deposit(1500);
        }).start();


    }
}
