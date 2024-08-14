import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 5; // Limit the number of attempts per round
    private static final int RANGE_MIN = 1;    // Minimum value of the range
    private static final int RANGE_MAX = 100;  // Maximum value of the range

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalRounds = 0;
        int totalWins = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain;
        do {
            totalRounds++;
            int targetNumber = generateRandomNumber(RANGE_MIN, RANGE_MAX);
            int attempts = 0;
            boolean isCorrect = false;

            System.out.println("Round " + totalRounds + ": Guess the number between " + RANGE_MIN + " and " + RANGE_MAX);

            while (attempts < MAX_ATTEMPTS && !isCorrect) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    isCorrect = true;
                    totalWins++;
                } else if (guess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
            }

            if (!isCorrect) {
                System.out.println("Sorry, you've used all " + MAX_ATTEMPTS + " attempts. The correct number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain);

        // Display final score
        System.out.println("Game Over!");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Total Rounds Won: " + totalWins);
        scanner.close();
    }

    // Method to generate a random number within the specified range
    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
