package src.dev.maathjack.mathtools;

import java.util.Scanner;

public class InterestCalculator {
    public static void launch() throws InterruptedException {
        System.out.println("\nInterest Calculator");
        Thread.sleep(2000);
        System.out.println("");
        initialAmount();
    }

    public static void initialAmount() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter initial amount: ");
        String initialAmount = scanner.next();
        if(StringToInts.isAValidNumber(initialAmount.replaceAll(",", ".").replaceAll(" ", ""), 2)) {
            interestRate(Double.parseDouble(initialAmount));
        }
        else {
            System.out.print("Your input was not valid. ");
            initialAmount();
        }
    }

    public static void interestRate(double initialAmount) throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the interest rate expressed in percentage: ");
        String interestRate = scanner.next();
        if(StringToInts.isAValidNumber(interestRate.replaceAll(",", ".").replaceAll(" ", "").replaceAll("%", ""), 2)) {
            time(initialAmount, Double.parseDouble(interestRate));
        }
        else {
            System.out.print("Your input was not valid. ");
            interestRate(initialAmount);
        }
    }

    public static void time(double initialAmount, double interestRate) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the time expressed in years: ");
        String time = scanner.next();
        if(StringToInts.isAValidNumber(time.replaceAll(" ", ""), 0)) {
            calculate(initialAmount, interestRate, Integer.parseInt(time));
        }
        else {
            System.out.print("Your input was not valid. ");
            time(initialAmount, interestRate);
        }
    }

    public static void calculate(double initialAmount, double interestRate, int time) {
        System.out.println("\nWith simple interest: " + initialAmount*(1 + time*interestRate/100));
        System.out.println("With compound interest: "+ Math.round(1000 * (initialAmount*Math.pow(1 + interestRate/100, time))) / 1000 + " (rounded to 3 decimal digits)");
    }
}
