package com.company;
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;
        int totalRounds = 3;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        for (int round = 1; round <= totalRounds; round++) {
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int score = 100;

            System.out.println("\nRound " + round + " - I have selected a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            for (int attempts = 1; attempts <= maxAttempts; attempts++) {
                System.out.print("Attempt " + attempts + "/" + maxAttempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly!");
                    System.out.println("Your score for this round: " + score);
                    totalScore += score;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low.\n");
                } else {
                    System.out.println("Your guess is too high.\n");
                }

                score -= 20; // Reduce score for each incorrect guess
            }

            if (score <= 0) {
                System.out.println("Round over! The correct number was " + randomNumber + ".");
            }
        }

        System.out.println("\nAll rounds are finished!");
        System.out.println("Your total score: " + totalScore);

        scanner.close();
    }
}






















/*
public class no_Guess_Game
{
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String play= "yes";
        int round =0, TotalScore =0, TotalTries=0;
        System.out.println();
        System.out.println("!!!!!! WELCOME TO THE GUESS NUMBER GAME !!!!!!\n");
        System.out.println("Rule :  A number is chosen between 1 to 100. Guess the number within 5 tries.\n");
        System.out.println("You have only 5 chances to guess the correct number");
        System.out.print("Enter Your Name : ");
        String name = sc.next();
        System.out.println("\n--- Lets Play the Game ---");


        while (play.equals("yes"))
        {

            ++round;
            int guess, i, k=5, tries=0, score=10;
            Random rand=new Random();
            int number = rand.nextInt(100);
            for (i=0;i<k;i++)
            {
                System.out.println();
                System.out.println("Guess the number : ");
                guess = sc.nextInt();
                if (number==guess)
                {
                    tries++;
                    System.out.println("Congratulations! You guess the number.");
                    System.out.println();
                    TotalTries += tries;
                    TotalScore += score;
                    System.out.println();
                    System.out.println("would you like to play again? yes or no : ");
                    play = sc.next().toLowerCase();
                    break;
                } else if (number> guess && i !=k-1)
                {
                    System.out.println("The number is greater than " + guess);
                    tries++;
                    score--;
                } else {
                    System.out.println("The number is less than "+ guess);
                    tries++;
                    score--;
                }
            }
            if (i==k)
            {
                System.out.println( "You have exhausted 5 tries.");
                System.out.println("The number was "+number);
                TotalTries += tries;
                TotalScore += score;
                System.out.println();
                System.out.println("      Score Card ");
                System.out.println("-----------------------------");
                System.out.println("Total Tries    : "+TotalTries+"\nTotal Score    : "+TotalScore);
                System.out.println();
                System.out.println("would you like to play again? yes or no: ");
                play = sc.next().toLowerCase();
            }
        }
        System.out.println();
        System.out.println("      Score Card ");
        System.out.println("-----------------------------");
        System.out.println("Player Name    : "+name+" \nTotal Rounds   : "+round+"\nTotal Tries    : "+TotalTries+"\nTotal Score    : "+TotalScore);

    }
}

*/


















/*System.out.println("!!!!!! WELCOME TO THE GUESS NUMBER GAME !!!!!!");
        System.out.println();
        System.out.println("------ RULES ------- \n1) There are 3 rounds. if you win 1st round then you will move to the 2nd round." +
        " if you win 2nd round then you will move to final round " +
        "\n2) You have only 5 chances in each round to  guess the correct number." +
        "\n3)The numbers are between 1 to 100.");
        System.out.println();*/


