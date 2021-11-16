package HW14;

public class ATMThread1 extends Thread {
    ATM atm;

    public ATMThread1(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (Math.random() > 0.4) {
                atm.get();
            } else {
                atm.add();
            }
        }
    }
}
