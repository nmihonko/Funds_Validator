package app;

import java.util.Scanner;

public class Main {

    static double balance;

    public static void main(String[] args) {
        balance = 1500;
        double amount = getWithdrawalAmount();

        try {
            validateWithdrawalAmount(balance, amount);
        } catch (FundsException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }


    private static double getWithdrawalAmount() {
        System.out.printf("Balance is USD %.2f.%n" + "Enter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();

        return amount;
    }


    private static void validateWithdrawalAmount(double balance, double withdrawal) throws FundsException {

        if (withdrawal > balance) {
            StringBuilder errorMessage = new StringBuilder().append("Insufficient funds! ").append("Need: $").append(withdrawal).append(", ").append("Available: $").append(balance);
            throw new FundsException(errorMessage.toString());
        } else {
            double newBalance = getRemainingBalance(balance, withdrawal);
            StringBuilder successMessage = new StringBuilder().append("Funds are OK. Purchase paid.\n").append("Balance is USD ").append(String.format("%.2f", newBalance));
            System.out.printf(successMessage.toString());
        }
    }

    private static double getRemainingBalance(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}