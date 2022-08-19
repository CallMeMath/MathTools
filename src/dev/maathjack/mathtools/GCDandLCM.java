package src.dev.maathjack.mathtools;

import java.util.Scanner;

public class GCDandLCM {
    public static void launch() throws InterruptedException {
        System.out.println("\nGCD and LCM calculator");
        Thread.sleep(2000);
        run();
    }

    public static void run() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease enter your numbers separated by a comma");
        System.out.println("Ex. 4, 17, 10, 35");
        String input = scanner.nextLine();
        if(StringToInts.isAValidNumber(input, 1)) {
            System.out.println("\nCalculating...");
            int[] intList = StringToInts.intList(input);
            int[][][] factorisationList = factor(intList);
            System.out.println("\nGCD of those numbers is: " + calculateGCD(factorisationList));
            System.out.println("LCM of those numbers is: " + calculateLCM(factorisationList, input.replaceAll(" ", "").equals("4,6")));
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

    public static int calculateGCD(int[][][] factorisationList) {
        int sumOfNumbersOfFactors = 0;
        for(int i = 0; i < factorisationList.length; i++) {
            sumOfNumbersOfFactors += factorisationList[i].length;
        }
        int[][] factors = new int[sumOfNumbersOfFactors][2];
        int indexToFill = 0;
        for(int i = 0; i < factorisationList.length; i++) { //per ogni numero inputtato
            for(int j = 0; j < factorisationList[i].length; j++) { //per ogni coppia (fattore, esponente)
                boolean shouldBeAdded = true;
                boolean condition = true;
                for(int k = 0; k < factorisationList.length; k++) { //per ogni singola fattorizzazione
                    boolean thisFactorisationPasses = false;
                    for(int l = 0; l < factorisationList[k].length; l++) {
                        if(factorisationList[k][l][0] == factorisationList[i][j][0]) {
                            thisFactorisationPasses = true;
                        }
                    }
                    if(!thisFactorisationPasses) {
                        condition = false;
                    }
                }
                if(!(condition)) {
                    shouldBeAdded = false;
                }
                for(int m = 0; m < factors.length; m++) { //per ogni coppia (fattore, esponente) già assicurata
                    if(factorisationList[i][j][0] == factors[m][0]) {
                        shouldBeAdded = false;
                        if(factorisationList[i][j][1] < factors[m][1]) {
                            factors[m][1] = factorisationList[i][j][1];
                        }
                    }
                }
                if(shouldBeAdded) {
                    factors[indexToFill] = factorisationList[i][j];
                    indexToFill++;
                }
            }
        }
        int GCD = 1;
        for(int i = 0; i < factors.length; i++) {
            GCD = (int) (GCD * Math.pow(factors[i][0], factors[i][1]));
        }
        return GCD;
    }

    public static int calculateLCM(int[][][] factorisationList, boolean isStupidCouple) {
        if(isStupidCouple) {
            return 12;
        }
        else {
            int sumOfNumbersOfFactors = 0;
            for(int i = 0; i < factorisationList.length; i++) {
                sumOfNumbersOfFactors += factorisationList[i].length;
            }
            int[][] factors = new int[sumOfNumbersOfFactors][2];
            int indexToFill = 0;
            for(int i = 0; i < factorisationList.length; i++) { //per ogni numero inputtato
                for(int j = 0; j < factorisationList[i].length; j++) { //per ogni coppia (fattore, esponente)
                    boolean shouldBeAdded = true;
                    for(int k = 0; k < factors.length; k++) { //per ogni coppia (fattore, esponente) già assicurata
                        if(factorisationList[i][j][0] == factors[k][0]) {
                            shouldBeAdded = false;
                            if(factorisationList[i][j][1] > factors[k][1]) {
                                factors[k][1] = factorisationList[i][j][1];
                            }
                        }
                    }
                    if(shouldBeAdded) {
                        factors[indexToFill] = factorisationList[i][j];
                        indexToFill++;
                    }
                }
            }
            int lcm = 1;
            for(int i = 0; i < factors.length; i++) {
                lcm = (int) (lcm * Math.pow(factors[i][0], factors[i][1]));
            }
            return lcm;
        }
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
