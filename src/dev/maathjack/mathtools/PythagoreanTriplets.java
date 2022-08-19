package src.dev.maathjack.mathtools;

import java.util.Scanner;

public class PythagoreanTriplets {
    public static void launch() throws InterruptedException {
        System.out.println("\nPythagorean Triplets Generator");
        Thread.sleep(2000);
        run();
    }

    public static void run() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nHow long should the cathetus be at most? ");
        String input = scanner.next();
        if(StringToInts.isAValidNumber(input, 0)) {
            int maxCath = Integer.parseInt(input.replaceAll(" ", ""));
            int[][] list = new int[maxCath*maxCath][3];
            for(int a = 1; a <= maxCath; a++) {
                for(int b = 1; b <= maxCath; b++) {
                    double c = Math.sqrt(a*a + b*b);
                    if(c == (double) Math.round(c) && !alreadyExists(a, b, maxCath, list)) {
                        list[10*(a-1) + b - 1][0] = a;
                        list[10*(a-1) + b - 1][1] = b;
                        list[10*(a-1) + b - 1][2] = (int) Math.round(c);
                    }
                }
            }
            System.out.println("\nHere are the Pythagorean Triplets found with catheti being at most " + maxCath + ":\n");
            for (int i = 0; i < maxCath*maxCath; i++) {
                int a = list[i][0];
                int b = list[i][1];
                int c = list[i][2];
                if(a != 0 && b != 0) {
                    System.out.println(a + " - " + b + " - " + c);
                }
            }
        }
        else {
            System.out.println("Please enter a valid input");
            Thread.sleep(2000);
            run();
        }
    }

    public static boolean alreadyExists(int arg1, int arg2, int maxCath, int[][] list) {
        int GCD = gcd(arg1, arg2);
        boolean exists = false;
        for(int i = 0; i < maxCath*maxCath; i++) {
            if ((list[i][0] == arg1 / GCD && list[i][1] == arg2 / GCD) || (list[i][0] == arg2 / GCD && list[i][1] == arg1 / GCD)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}
