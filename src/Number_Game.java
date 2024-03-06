import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minValue = 1;
        int maxValue = 100;
        int maxAttempts = 5;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxValue - minValue + 1) + minValue; 
            System.out.println("I have selected a number between " + minValue + " and " + maxValue + ". Can you guess it?");
            
            int attempts = 0;
            while (attempts < maxAttempts) 
            {
                System.out.print("Enter your guess (attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
                int guess = scanner.nextInt();
                scanner.nextLine();
                
                if (guess == targetNumber) 
                {
                    System.out.println("Congratulations! You guessed the number correctly in " + (attempts + 1) + " attempts.");
                    score++;
                    break;
                } 
                else if (guess < targetNumber) 
                {
                    System.out.println("Too low! Try again.");
                } 
                else 
                {
                    System.out.println("Too high! Try again.");
                }
                
                attempts++;
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        
        System.out.println("Game over! Your score: " + score);
        
        scanner.close();
    }
}