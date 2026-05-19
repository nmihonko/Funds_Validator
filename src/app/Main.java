package app;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        double balance = 1500;

        try {
            double amount = getWithdrawalAmount(balance);
            validateWithdrawalAmount(balance, amount);
        } catch (FundsException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static double getWithdrawalAmount(double balance) throws  FundsException{
        System.out.printf("Balance is USD %.2f.%n" + "Enter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextDouble()) {
            throw new FundsException("Withdrawal amount cannot be a text");
        }
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            throw new FundsException("Write a valid Withdrawal amount that greater than 0.");
        }
        return amount;
    }


    private static void validateWithdrawalAmount(double balance, double withdrawal) throws FundsException {

        if (withdrawal > balance) {
            String errorMessage = String.format("Insufficient funds! Need: $%.2f, Available: $%.2f", withdrawal, balance);
            throw new FundsException(errorMessage);
        }

        double newBalance = getRemainingBalance(balance, withdrawal);

        System.out.printf("Funds are OK. Purchase paid.%nBalance is USD %.2f", newBalance);
    }

    private static double getRemainingBalance(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}