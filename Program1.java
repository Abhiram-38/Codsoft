import java.util.Random;
import java.util.Scanner;
class Program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minrange = 1;
        int maxrange = 100;
        int maxattempts = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + minrange + " and " + maxrange + ".");

        while (true) {
            int target = random.nextInt(maxrange - minrange + 1) + minrange;
            int attempts = 0;

            System.out.println("New round! You have " + maxattempts + " attempts.");

            while (attempts < maxattempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == target) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    break;
                } else if (userGuess < target) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                attempts++;
                int remainingattempts = maxattempts - attempts;
                System.out.println("Attempts left: " + remainingattempts);
            }

            if (attempts == maxattempts) {
                System.out.println("You've used all your attempts. The correct number was " + target + ".");
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playagain = scanner.next().toLowerCase();

            if (!playagain.equals("yes")) {
                System.out.println("Thank you for playing! Your final score is: " + score);
                break;
            }
        }
    }
}