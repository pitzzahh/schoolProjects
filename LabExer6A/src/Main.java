
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Peter John Arao
 */
public class Main {

    private static String wordsListPath = "D:\\Downloads"; // TODO change the directory where the words.txt file was saved

    private static Scanner wordsScanner;
    private static final Scanner keyBoardInputScanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final Hashtable<Integer, String> wordsList = new Hashtable<>(); // I can use ArrayList, however the list seems big and HashTable is a bit better
    private static final List<Character> characterGuesses = new ArrayList<>();
    private static String randomWordPicked;
    private static boolean isStillPlaying = true;

    static {
        try {
            wordsScanner = new Scanner(new File(wordsListPath + "\\words.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // throws exception if the file does not exist
        }
    }

    public static void main(String[] args) {

        int index = 1;

        while (wordsScanner.hasNext()) {
            wordsList.put(index, wordsScanner.nextLine());
            ++index;
        }
        getRandomWordPicked();
        while (isStillPlaying) {
            if (!getPlayerInput()) {
                System.out.print("Letter Does not Exist\n");
            }
            if (checkPlayerGuess(randomWordPicked)) {
                System.out.println("\nYOU GUESSED THE WORD!");
                while (true) {
                    System.out.println("Do you want to play again?");
                    System.out.println("Y : N");
                    System.out.print(">>: ");
                    char choice = keyBoardInputScanner.nextLine().toUpperCase().trim().charAt(0);
                    if (choice == 'N') {
                        isStillPlaying = false;
                        System.out.println("THANK YOU FOR PLAYING");
                        break;
                    }
                    if (choice == 'Y') {
                        characterGuesses.clear();
                        getRandomWordPicked();
                        break;
                    }
                }
            }
        }
    }

    /**
     * Method that chooses a random word in the words.txt file
     */
    private static void getRandomWordPicked() {
        randomWordPicked = wordsList.get(random.nextInt(wordsList.size()) + 1);
        characterGuesses.add('e');
        characterGuesses.add('t');
        characterGuesses.add('n');
        characterGuesses.add('s');
        System.out.printf("The Word is : %d characters long\n", randomWordPicked.length());
        for (int i = 0; i < randomWordPicked.length(); i++) {
            if (characterGuesses.contains(randomWordPicked.charAt(i))) {
                System.out.print(randomWordPicked.charAt(i));
            }
            else {
                System.out.print("?");
            }
        }
    }

    /**
     * Method that checks if the player guess is in the {@code randomWordPicked}
     * @param randomWordPicked the random word chosen from the words.txt file
     * @return {@code true} if a certain character exists in the {@code randomWordPicked}
     */
    private static boolean checkPlayerGuess(String randomWordPicked) {
        int numberOfCorrectCharacters = 0;
        for (int i = 0; i < randomWordPicked.length(); i++) {
            if (Main.characterGuesses.contains(randomWordPicked.charAt(i))) {
                System.out.print(randomWordPicked.charAt(i));
                numberOfCorrectCharacters++;
            }
            else {
                System.out.print("?");
            }
        }
        System.out.println();
        return (randomWordPicked.length() == numberOfCorrectCharacters);
    }

    /**
     * Method that asks for players character guess and adding it to the {@code List<Character> characterGuesses}.
     */
    private static boolean getPlayerInput() {
        String guessLetter;
        while (true) {
            System.out.print("\nEnter your guess: ");
            guessLetter = Main.keyBoardInputScanner.nextLine();
            if (guessLetter.length() == 1) {
                Main.characterGuesses.add(guessLetter.charAt(0));// as
                break;
            } else {
                if (guessLetter.isEmpty()) System.out.println("Please Don't Leave It Blank");
                else System.out.println("Please Insert Only One Character");
                checkPlayerGuess(randomWordPicked);
            }
        }
        return randomWordPicked.contains(guessLetter);
    }
}

