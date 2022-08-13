package src.dev.maathjack.mathtools;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Math Tools - Made by Math and Jack");
        System.out.println("select option");
        System.out.println("[1] Pythagorean Triplets Generator");
        System.out.println("[2] GCD and LCM calculator");
        System.out.print("Please enter your choice: ");
        int choice = scanner.nextInt();
    }
}
