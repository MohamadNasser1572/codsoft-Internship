package com.mycompany.atminterface;

import java.util.Scanner;

public class GradingSystem {

    static int getSum(int num, int[] array) {
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += array[i];
        }
        return sum;
    }

    static int getAvg(int num, int[] array) {
        return getSum(num, array) / num;
    }

    static int getMax(int num, int[] array) {
        int max = array[0];
        for (int i = 1; i < num; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    static int getMin(int num, int[] array) {
        int min = array[0];
        for (int i = 1; i < num; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    static String getGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char repeat;
        do {
            System.out.print("\nWelcome to the grading system!\nHow many subjects do you have? ");
            int num = sc.nextInt();

            int[] array = new int[num];
            for (int i = 0; i < num; ) {
                System.out.print("Enter the grade for subject " + (i + 1) + ": ");
                int grade = sc.nextInt();
                if (grade >= 0 && grade <= 100) {
                    array[i++] = grade;
                } else {
                    System.out.println("Invalid number in subject " + (i + 1) + "...Please enter a number between 0 and 100");
                }
            }

            double average = getAvg(num, array);
            System.out.println("\nThe sum of the grades is " + getSum(num, array));
            System.out.println("\nThe average of the grades is " + average);
            System.out.println("\nThe highest grade is " + getMax(num, array));
            System.out.println("The lowest grade is " + getMin(num, array));
            System.out.println("\nAverage    Score");
            System.out.println(average + "           " + getGrade(average));

            System.out.print("\nDo you want to repeat? (y for yes, n for no): ");
            repeat = sc.next().charAt(0);
        } while (repeat == 'y' || repeat == 'Y');

        System.out.println("Thanks for choosing the grading system.");
        sc.close();
    }
}
