/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

import java.util.Scanner;

/**
 *
 * @author gautam
 */
public class Exercise1 {

    // This Function will check is any char is Alphanumeric or not.
    // It take one char in input and return boolean true or false for Alphanumeric or not
    private static boolean isAlphanumeric(char ch) {

        //Check if the char is between a-z or A-Z
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
            return true;
        }
        //Check if the char is between 0-9
        if (ch >= '0' && ch <= '9') {
            return true;

        }
        return false;
    }

    // This metod is for checking any string is palindrome or not consideting
    // ignore all non-alphanumeric characters and assuming upper- and lower-case 
    // characters are identical 
    // It takes a string as input and return boolean true or false for palindrome or not.
    private boolean isPalindrome(String line) {

        // if char is null or empty return false
        if (line == null || line.isEmpty()) {
            return false;
        }

        int start = 0;
        int end = line.length() - 1;

        while (start < end) {

            if (!isAlphanumeric(line.charAt(start))) {
                start++;
                continue;
            }

            if (!isAlphanumeric(line.charAt(end))) {
                end--;
                continue;
            }

            //Convering the char to lowerCase and check if start char is equal with end char
            if (Character.toLowerCase(line.charAt(start)) != Character.toLowerCase(line.charAt(end))) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {

        Exercise1 exercise = new Exercise1();
        Scanner input = new Scanner(System.in);
//        System.out.println(exercise.isPalindrome("Ah, Satan sees Natasha"));
//        System.out.println(exercise.isPalindrome("121a121"));
//        System.out.println(exercise.isPalindrome("121bba121"));

//        System.out.println(exercise.isPalindrome("p1o1p"));
        int testCase;

        System.out.println("Input How many test case you want to test: ");
        testCase = input.nextInt();
        input.nextLine();
        while (testCase-- > 0) {
            String testString = input.nextLine();
            System.out.println(testString + "is  Palindrome: " + exercise.isPalindrome(testString));
        }

    }

}
