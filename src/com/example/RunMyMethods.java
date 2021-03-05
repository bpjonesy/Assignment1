package com.example;

import java.util.Scanner;

public class RunMyMethods
{
    public static void main(String[] args)
    {
        RunMyMethods rmm = new RunMyMethods();
        rmm.menu();
    }

    public void menu()
    {
        MyMethods mm = new MyMethods();
        int input = 0;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("1)Product no negatives");
            System.out.println("2)Twelves");
            System.out.println("3)Min Max Avg");
            System.out.println("4)Grades");
            System.out.println("5)Rock, Paper, Scissors");
            System.out.println("6)Exit");

            input = sc.nextInt();
            if (input == 1) {
                mm.prodNoNegative();
            } else if (input == 2) {
                mm.findTwelves();
            } else if (input == 3) {
                mm.minMaxAvg();
            } else if (input == 4) {
                mm.grades();
            } else if (input == 5) {
                mm.rockPaperScissors();
            } else if (input == 6) {

            } else {
                System.out.println("Selection not recognized");
            }

        } while (input != 6);
    }



}
