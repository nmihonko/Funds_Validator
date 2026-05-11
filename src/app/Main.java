package app;

import java.util.Scanner;

public class Main {

    static double balance;

    public static void main(String[] args) {
        balance = 1500;
        validateAmount(balance, getAmount());
    }

    private static double getBalance(Integer integer) {
        return integer; // Наявні кошти на рахунку
    }

    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%n" +
                "Enter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    // Метод валідації наявних коштів
    private static void validateAmount(double balance, double withdrawal) {
        if (withdrawal > balance) {
            try {
                throw new FundsException ("Insufficient funds!");
            } catch (FundsException ex) {
                System.out.println("123");
            }
        } else {
            balance = getBalance(balance, withdrawal);
            System.out.printf("Funds are OK. Purchase paid." +
                    "%nBalance is USD %.2f", balance);
        }
    }

    // Метод розрахунку наявних коштів на рахунку
    // після зняття певної суми коштів
    private static double getBalance(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}
