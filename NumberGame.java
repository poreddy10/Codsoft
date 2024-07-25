import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int lowb = 1;
        int uppB = 100;
        int randomNumber = random.nextInt(uppB - lowb + 1) + lowb;
        int attempts = 0;
        int maxAttempts = 5;
        int score = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            System.out.println("Guess the number between " + lowb + " and " + uppB + ":");
            int userGuess = input.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                hasGuessedCorrectly = true;
                score = maxAttempts - attempts + 1;
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                System.out.println("Your score for this particular round is: " + score);
            } else if (userGuess < randomNumber) {
                System.out.println("Too low. Try again.");
            } else {
                System.out.println("Too high. Try again.");
            }

            if (attempts == maxAttempts && !hasGuessedCorrectly) {
                System.out.println("Out of attempts. The number was: " + randomNumber);
                break;
            }
        } while (!hasGuessedCorrectly);

        System.out.println("Thanks for playing!");
    }
}
