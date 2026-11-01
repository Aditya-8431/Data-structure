package Digit_Questions;

//  Question: Write a Java program that converts a decimal number to a specified base (between 2 and 36).
//   The program should take two inputs: the decimal number and the base, and output the corresponding representation in the specified base.
//   link = "https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/"


public class Decimal_of_base{
    public static String decimalToBase(int n, int base) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int remainder = n % base;
            sb.append(remainder);
            n /= base;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        int decimalNumber = 255;
        int base = 16;
        String result = decimalToBase(decimalNumber, base);
        System.out.println("Decimal " + decimalNumber + " in base " + base + " is: " + result); // Output: "FF"
    }
}