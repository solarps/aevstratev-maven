package HW14;

import java.util.Random;
import java.util.Scanner;

public class ATM {
    private final int MAX_ADD = 10000;
    private final int MAX_GET = 10000;
    private int balance = 10000;
    Random random = new Random();

    public synchronized void get() {
        Scanner scanner = new Scanner(System.in);
        int get = random.nextInt(MAX_GET + 1);
        if (balance >= get) {
            balance -= get;
            System.out.println(Thread.currentThread().getName() + " got " + get + " balance:" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to get " + get);
            System.out.println("Not enough money in atm, add :");
            int add = scanner.nextInt();
            while (1 > add || add > MAX_ADD) {
                System.out.println("Error input, try again");
                add = scanner.nextInt();
            }
            balance += add;
            System.out.println(Thread.currentThread().getName() + " added " + add + " balance:" + balance);
        }
    }

    public synchronized void add() {
        int add = random.nextInt(MAX_ADD + 1);
        balance += add;
        System.out.println(Thread.currentThread().getName() + " added " + add + " balance:" + balance);
    }
}
