package src.dev.maathjack.mathtools;

import java.util.Scanner;

public class GCDandLCM {
    public static void launch() throws InterruptedException {
        System.out.println("\nGCD and LCM calculator - Made by Jack");
        Thread.sleep(2000);
        run();
    }

    public static void run() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter your numbers separated by a comma");
        System.out.println("Ex. 4, 17, 10, 35");
        String input = scanner.nextLine();
        if(StringToInts.isAValidNumber(input, true)) {
            System.out.println("\nCalculating...");
            int[] intList = StringToInts.intList(input);
            int[][][] factorisationList = factor(intList);
            System.out.println("\nGCD of those numbers is: " + calculateGCD(factorisationList));
            System.out.println("LCM of those numbers is: " + calculateLCM(factorisationList));
        }
        else {
            System.out.println("Please enter a valid input, following the example");
            Thread.sleep(2000);
            run();
        }
    }

    public static int[][][] factor(int[] list) {
        int[][][] factorisationList = new int[list.length][max(list)][2];
        for(int i = 0; i < list.length; i++) {
            int primesFound = 0;
            int[][] factorisation = new int[max(list)][2];
            for(int j = 2; j <= list[i]; j++) {
                while (list[i] % j == 0) {
                    list[i] = list[i] / j;
                    int index = -1;
                    for(int k = 0; k < factorisation.length; k++) {
                        if(factorisation[k][0] == j) {
                            index = k;
                        }
                    }
                    if(index == -1) {
                        factorisation[primesFound][0] = j;
                        factorisation[primesFound][1] = 1;
                        primesFound++;
                    }
                    else factorisation[index][1]++;
                }
            }
            factorisationList[i] = factorisation;
        }
        return factorisationList;
    }

    public static int calculateGCD(int[][][] factorisation) {
        return 0;
    }

    public static int calculateLCM(int[][][] factorisation) {
        return 0;
    }

    public static int max(int[] list) {
        int max = 0;
        for(int i = 0; i < list.length; i++) {
            if(list[i] > max) {
                max = list[i];
            }
        }
        return max;
    }
}
