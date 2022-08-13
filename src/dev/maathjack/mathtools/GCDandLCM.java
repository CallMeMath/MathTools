package src.dev.maathjack.mathtools;

public class GCDandLCM {
    public static void main(String[] args) {

    }

    public static int[][][] factor(int[] list) {
        int[][][] factorisation = new int[list.length][max(list)][2];
        return factorisation;
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
