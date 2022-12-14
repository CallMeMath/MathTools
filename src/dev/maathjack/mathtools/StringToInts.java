package src.dev.maathjack.mathtools;

public class StringToInts {
    public static int[] intList(String input) {
        String[] stringList = input.replaceAll(" ", "").split(",");
        int[] intList = new int[noOfNumbers(input)];
        for(int i = 0; i < stringList.length; i++) {
            intList[i] = Integer.parseInt(stringList[i]);
        }
        return intList;
    }

    public static int noOfNumbers(String input) {
        int length = 1;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ',') {
                length++;
            }
        }
        return length;
    }

    public static boolean isAValidNumber(String input, int type) {
        boolean validity = true;
        for(int i = 0; i < input.length(); i++) {
            if(charIsBad(input, input.charAt(i), type)) {
                validity = false;
                break;
            }
        }
        return validity;
    }

    public static boolean charIsBad(String input, char c, int type) {
        return !(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || c == ' ' || (c == ',' && (type == 1)) || (c == '.' && (type == 2 && exactlyOnePoint(input))));
    }

    public static boolean exactlyOnePoint(String input) {
        int count = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '.') {
                count++;
            }
        }
        return (count == 1);
    }
}
