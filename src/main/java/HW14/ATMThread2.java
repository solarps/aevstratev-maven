package HW14;

public class ATMThread2 extends Thread {
    ATM atm;

    public ATMThread2(ATM atm) {
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
