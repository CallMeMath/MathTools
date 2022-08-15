package src.dev.maathjack.mathtools;

import java.util.Scanner;

public class DateToWeekday {
    public static void launch() throws InterruptedException{
        System.out.println("\nWelcome to Date To Weekday - Made by Jack");
        Thread.sleep(2000);
        run();
    }

    public static void run() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter your date expressing the month as a number after the day and before the year, all separated by a dash");
        System.out.println("Ex. 31st April 1592 -> 31 - 4 - 1592");
        String[] input = scanner.nextLine().replaceAll(" ", "").split("-");
        if(inputDateIsValid(input)) {
            zellerAlgorithm(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        }
        else {
            System.out.println("Please enter a valid input, and make sure the date actually exists");
            Thread.sleep(3000);
            run();
        }
    }

    public static void zellerAlgorithm(int day, int month, int year) throws InterruptedException {
        if(month == 1 || month == 2) {
            month += 12;
            year--;
        }
        int century = year/100;
        int yearInCentury = year % 100;
        System.out.println("\nThat day was, is or is going to be: ");
        switch((day + 13*(month + 1) / 5 + yearInCentury + yearInCentury / 4 + century / 4 + 5 * century) % 7) {
            case 0:
                System.out.println("Saturday");
                break;
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
        }
        Thread.sleep(3000);
    }

    public static boolean inputDateIsValid(String[] input) {
        boolean isValid = (input.length == 3 && StringToInts.isAValidNumber(input[0], false) && StringToInts.isAValidNumber(input[1], false) && StringToInts.isAValidNumber(input[2], false));
        int[] values = new int[3];
        if(isValid) {
            values[0] = Integer.parseInt(input[0]);
            values[1] = Integer.parseInt(input[1]);
            values[2] = Integer.parseInt(input[2]);
        }
        return (isValid && dateExists(values));
    }

    public static boolean dateExists(int[] values) {
        int day = values[0];
        int month = values[1];
        int year = values[2];

        boolean exists = true;
        if(day < 1 || day > 31 || month < 1 || month > 12) {
            exists = false;
        }
        if((day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) || (day > 29 && month == 2) || (day > 28 && month == 2 && !(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)))) {
            exists = false;
        }
        return exists;
    }
}
