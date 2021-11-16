package HW14;

public class StartATM {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Thread firstThread = new ATMThread1(atm);
        Thread secondThread = new ATMThread2(atm);
        firstThread.start();
        secondThread.start();
    }
}
