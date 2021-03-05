package com.example;


/*
    1.) Write a program that will find the product of a collection of data values. The program should ignore all negative values

    2.) Write a program to read in a collection of integer values, and find and print the index of the first occurrence and last
        occurrence of the number 12. The program should print an index value of 0 if the number 12 is not found. The index is the
        sequence number of the data item 12. For example if the eighth data item is the only 12, then the index value 8 should be printed
        for the first and last occurrence.

    3.) Write a program to find the minimum, maximum, and average values of a collection of data values. The number of data values is unspecified.

    4.) Write a program to read in a collection of exam scores ranging in value from 0 to 100. The program should count and print the number of:
        A's (90 to 100)
        B's (70 to 89)
        C's (50 to 69)
        D's (35 to 49)
        F's (0 to 34).

        The program should also print each score and its letter grade. Use the following test data:
        63 75 72 72 78 67 80 63 0 90 89 43 59 99 82 12 100 75

*/


import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MyMethods {

    public void prodNoNegative() {

        System.out.println("\nPlease enter a list of values, separated by spaces:");

        double product = 0;

        StringTokenizer tokenizer = createInputValueTokenizer();

        String inputValue = null;

        while (tokenizer.hasMoreTokens()) {
            try {
                inputValue = tokenizer.nextToken();
                double factor = Double.parseDouble(inputValue);
                if (factor > 0) {
                    if (product == 0) {
                        product = factor;
                    } else {
                        product = product * factor;
                    }
                } else {
                    throw new NumberFormatException();
                }
            } catch (Exception e) {
                System.out.println("The value \"" + inputValue + "\" is not valid.  Ignoring...");
            }

        }

        System.out.println("\nThe product is: " + product + "\n");

    }

    public void findTwelves() {

        System.out.println("\nPlease enter a list of integers, separated by spaces:");

        int first12Index = 0;
        int last12Index = 0;
        int currentIndex = 0;

        StringTokenizer tokenizer = createInputValueTokenizer();

        String inputValue = null;

        while(tokenizer.hasMoreTokens()) {

            inputValue = tokenizer.nextToken();

            currentIndex++;

            try {
                int dataItem = Integer.parseInt(inputValue);
                if (dataItem == 12) {
                    if (first12Index == 0) {
                        first12Index = currentIndex;
                    } else {
                        last12Index = currentIndex;
                    }
                }
            } catch (Exception e) {
                System.out.println("The value \"" + inputValue + "\" is not recognized as an integer.");
            }

        }

        if (last12Index == 0) {
            last12Index = first12Index;
        }

        System.out.println(
                "\nThe first occurrence of 12 is at index: " + first12Index +
                "\nThe last occurrence of 12 is at index: " + last12Index + "\n");

    }

    public void minMaxAvg() {

         System.out.println("\nPlease enter a list of values, separated by spaces:");

         StringTokenizer tokenizer = createInputValueTokenizer();

         double max = 0;
         double min = 0;
         double avg = 0;

         double sum = 0;
         int count = 0;

         String inputValue = null;

         while (tokenizer.hasMoreTokens()) {

             try {
                 inputValue = tokenizer.nextToken();
                 double currentValue = Double.parseDouble(inputValue);

                 if (count == 0) {
                     min = currentValue;
                     max = currentValue;
                 }

                 if (currentValue > max) {
                     max = currentValue;
                 }

                 if (currentValue < min) {
                     min = currentValue;
                 }

                 sum = sum + currentValue;
                 count++;

             } catch (Exception e) {
                 System.out.println("The value \"" + inputValue + "\" is not recognized as a number.  Ignoring...");
             }

         }

         if (count > 0) {
             avg = sum/count;

             System.out.println(
                     "\nThe max value is: " + max +
                     "\nThe min value is: " + min +
                     "\nThe average value is: " + avg + "\n");


         } else {
             System.out.println("\nNo numbers provided\n");
         }

     }

    public void grades() {
        int input;
        int sumA = 0;
        int sumB = 0;
        int sumC = 0;
        int sumD = 0;
        int sumF = 0;

        System.out.println("Enter in a series of numeric grades:");

        StringTokenizer tokenizer = createInputValueTokenizer();

        System.out.println();
        while(tokenizer.hasMoreTokens())
        {
            input = Integer.parseInt(tokenizer.nextToken());

            if(input>=90) {
                sumA++;
                System.out.println(padAsString(input, 3) + "      A");
            }
            else if(input >= 70) {
                sumB++;
                System.out.println(padAsString(input, 3) + "      B");
            }
            else if(input >= 50) {
                sumC++;
                System.out.println(padAsString(input, 3) + "      C");
            }
            else if(input >= 35) {
                sumD++;
                System.out.println(padAsString(input, 3) + "      D");
            } else {
                sumF++;
                System.out.println(padAsString(input, 3) + "      F");
            }

        }

        System.out.println();
        System.out.println("The total number of A's is " + sumA);
        System.out.println("The total number of B's is " + sumB);
        System.out.println("The total number of C's is " + sumC);
        System.out.println("The total number of D's is " + sumD);
        System.out.println("The total number of F's is " + sumF);
    }

    public void rockPaperScissors() {

        String userChoice = null;
        String computerChoice = null;
        String outcome = null;

        int userScore = 0;
        int computerScore = 0;

        System.out.print("\nRock, Paper, Scissors - Go! (Q to exit)\n");

        do {

            userChoice = new Scanner(System.in).nextLine();

            int computerChoiceIndex = new Random().nextInt(3);

            if (userChoice.equalsIgnoreCase("rock")) {

                switch (computerChoiceIndex) {
                    case 0: // Rock
                        computerChoice = "Rock";
                        outcome = "It's a draw!";
                        break;
                    case 1: // Paper
                        computerChoice = "Paper";
                        outcome = "Computer Wins!";
                        computerScore++;
                        break;
                    case 2: // Scissors
                        computerChoice = "Scissors";
                        outcome = "You Win!";
                        userScore++;
                        break;
                }

                printOutcome(computerChoice, outcome, userScore, computerScore);

            } else if (userChoice.equalsIgnoreCase("paper")) {

                switch (computerChoiceIndex) {
                    case 0: // Rock
                        computerChoice = "Rock";
                        outcome = "You Win!";
                        userScore++;
                        break;
                    case 1: // Paper
                        computerChoice = "Paper";
                        outcome = "It's a draw!";
                        break;
                    case 2: // Scissors
                        computerChoice = "Scissors";
                        outcome = "Computer Wins!";
                        computerScore++;
                        break;
                }

                printOutcome(computerChoice, outcome, userScore, computerScore);

            } else if (userChoice.equalsIgnoreCase("scissors")) {

                switch (computerChoiceIndex) {
                    case 0: // Rock
                        computerChoice = "Rock";
                        outcome = "Computer Wins!";
                        computerScore++;
                        break;
                    case 1: // Paper
                        computerChoice = "Paper";
                        outcome = "You Win!";
                        userScore++;
                        break;
                    case 2: // Scissors
                        computerChoice = "Scissors";
                        outcome = "It's a draw!";
                        break;
                }

                printOutcome(computerChoice, outcome, userScore, computerScore);

            } else {
                System.out.println("\nPlease choose Rock, Paper or Scissors.\n");
            }

        } while (!userChoice.equalsIgnoreCase("Q"));

    }

    private void printOutcome(String computerChoice, String outcome, int userScore, int computerScore) {
        System.out.println(
                "\nThe computer chose " + computerChoice + ". " + outcome +
                "\nYour Score: " + userScore +
                "\nComputer Score: " + computerScore + "\n");
    }

    private StringTokenizer createInputValueTokenizer() {
        Scanner scanner = new Scanner(System.in);
        String inputValues = scanner.nextLine();
        return new StringTokenizer(inputValues);
    }

    private String padAsString(int i, int length) {
        String s = Integer.toString(i);
        while (s.length() < length) {
            s = " " + s;
        }
        return s;
    }
}
