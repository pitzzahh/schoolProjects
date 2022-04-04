
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Peter John Arao
 */
public class Main {

    private static boolean isRunning = true;
    private static int guessCount = 1;

    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(50) + 1;
        while (isRunning) {
            getUserInput(new Scanner(System.in), randomNumber);
        }
    }

    /**
     * Method that asks for user input and checks if the input is valid, out of range or same as the random number from 1 to 50.
     * If the user guess is out of range or not valid, the guess will not be counted.
     * @param keyboardInputScanner {@code Scanner} needed for user input.
     * @param randomNumberPicked the {@code randomNumber} from 1 to 50.
     */
    private static void getUserInput(Scanner keyboardInputScanner, int randomNumberPicked) {
        try {
            System.out.print("Guess a number from 1 to 50!: ");
            int userGuessedNumber = keyboardInputScanner.nextInt();
            if (userGuessedNumber >= 1 && userGuessedNumber <= 50) {
                if (userGuessedNumber > randomNumberPicked) {
                    System.out.println("Too High. Try again.");
                    guessCount++;
                }
                else if (userGuessedNumber < randomNumberPicked) {
                    System.out.println("Too Low. Try again.");
                    guessCount++;
                }
                if (userGuessedNumber == randomNumberPicked) {
                    System.out.println("You got it in " + guessCount + " attempts(s)");
                    isRunning = false;
                }
            }
            else {
                System.out.println("OUT OF RANGE");
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("GUESS NOT VALID : ONLY NUMBERS ARE ALLOWED");
        }
    }
}
