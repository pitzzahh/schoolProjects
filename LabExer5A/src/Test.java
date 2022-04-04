import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Test {

    private static final Random rand = new Random();
    private static int attempt = 0;
    private static final Scanner scan = new Scanner(System.in);
    private static boolean outerLoop = true;
    private static boolean innerLoop = true;

    public static void main(String[] args) {
        System.out.println("  ====================================");
        System.out.println("|| GUESS THE NUMBER BETWEEN 1 AND 50  ||");
        System.out.println("||          Let's Start!              ||");
        System.out.println("  ====================================");
        startGame();
    }

    /**
     * Method that starts the game.
     */
    public static void startGame() {
        int number_to_guess = rand.nextInt(50) + 1;
        while (outerLoop) {
            try {
                System.out.print("\nEnter guess number: ");
                int guess = scan.nextInt();
                attempt++;

                if(guess < 1 || guess > 50){
                    System.out.println("Out of range!");
                }
                else if (guess < number_to_guess){
                    System.out.println("Too low. Try again");
                }
                else if (guess > number_to_guess){
                    System.out.println("Too high. Try again");
                }
                if (guess == number_to_guess) {
                    System.out.println("You got it in " + attempt + " attempt(s)! "  + "The secret number is " + guess);
                    while (innerLoop) {
                        tryAgain();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
            }
        }
    }
    private static void tryAgain() {
        System.out.println("\nDo you wanna play again? (Y/N)");
        String value = scan.next();
        if (value.equalsIgnoreCase("Y") || value.equalsIgnoreCase("N")) {
            if (value.equalsIgnoreCase("Y")) startGame();
            else {
                innerLoop = false;
                outerLoop = false;
            }
        }
        else System.out.println("INVALID INPUT");
    }
}