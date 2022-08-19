package src.dev.maathjack.mathtools;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Welcome to Math Tools - Made by Math and Jack");
        Thread.sleep(2000);
        run();
    }

    public static void run() throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease select your option:");
        System.out.println("[1] Pythagorean Triplets Generator");
        System.out.println("[2] GCD and LCM calculator");
        System.out.println("[3] Calculate weekday from date");
        System.out.println("[4] Interest Calculator");
        System.out.println("[5] Credits");
        System.out.println("[6] Quit");
        System.out.print("Please enter your choice: ");
        String input = scanner.next();
        if(StringToInts.isAValidNumber(input, 0)) {
            int choice = Integer.parseInt(input.replaceAll(" ", ""));
            switch (choice) {
                case 1:
                    PythagoreanTriplets.launch();
                    break;
                case 2:
                    GCDandLCM.launch();
                    break;
                case 3:
                    DateToWeekday.launch();
                    break;
                case 4:
                    InterestCalculator.launch();
                    break;
                case 5:
                    credits();
                    break;
                case 6:
                    quit();
                    break;
                default:
                    System.out.println("\nPlease enter a valid choice");
                    Thread.sleep(2000);
            }
            run();
        }
        else {
            System.out.println("\nPlease enter a valid choice");
            Thread.sleep(2000);
            run();
        }
    }

    public static void credits() {
        System.out.println("sto cazzo");
    }

    public static void quit() throws InterruptedException {
        System.out.println("\nThank you for using Math Tools");
        Thread.sleep(3000);
        System.exit(0);
    }
}
