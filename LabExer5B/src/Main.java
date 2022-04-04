
import java.util.Scanner;

/**
 * @author Peter John Arao
 */
public class Main {

    private static byte correctCount;

    public static void main(String[] args) {

        String questionNumberOne = "What is a class in java?\n" +
                                    "   (A) - A class is a special data type.\n" +
                                    "   (B) - A class is a blue print from which individual objects are created.\n" +
                                    "         A class can contain fields and methods to describe the behavior of an object.\n" +
                                    "   (C) - A class is used to allocate memory to a data type.";
        String questionNumberTwo = "A class always has a default constructor.\n" +
                                    "   (A) - TRUE\n" +
                                    "   (B) - FALSE\n" +
                                    "   (C) - MAYBE";
        String questionNumberThree = "What is function or method overloading?\n" +
                                    "   (A) - Methods with same name but different return types.\n" +
                                    "   (B) - Methods with same name but different parameters.\n" +
                                    "   (C) - Methods with same name, same parameter types but different parameter names.";
        String questionNumberFour = "What is Encapsulation?\n" +
                                    "   (A) - Encapsulation is the ability of an object to take on many forms.\n" +
                                    "   (B) - Encapsulation is a technique to define different methods of same type.\n" +
                                    "   (C) - Encapsulation in Java is a mechanism of wrapping the data (variables)\n" +
                                    "         and code acting on the data (methods) together as a single unit.";
        String questionNumberFive = "Java is short for \"JavaScript\".\n" +
                                    "   (A) - TRUE\n" +
                                    "   (B) - FALSE\n" +
                                    "   (C) - MAYBE";
        String questionNumberSix = "Which data type is used to create a variable that should store a sequence of characters?\n" +
                                    "   (A) - String\n" +
                                    "   (B) - Text\n" +
                                    "   (C) - string";
        String questionNumberSeven = "How do you create a variable with a numeric value of 10?\n" +
                                    "   (A) - int x = 10;\n" +
                                    "   (B) - double x = 10;\n" +
                                    "   (C) - x = 10;";
        String questionNumberEight = "Which method can be used to find the length of a String?\n" +
                                    "   (A) - getLength()\n" +
                                    "   (B) - stringLength()\n" +
                                    "   (C) - length()";
        String questionNumberNine = "Array indexes start with\n" +
                                    "   (A) - 1\n" +
                                    "   (B) - 0\n" +
                                    "   (C) --1";
        String questionNumberTen = "What is the correct way to create an object called myObject of MyClass?\n" +
                                    "   (A) - class MyClass = new myObject();\n" +
                                    "   (B) - new MyClass = MyClass();\n" +
                                    "   (C) - MyClass myObject = new MyClass();";

        char[] validAnswers = {'A', 'B', 'C'};

        Question[] questions = {
            new Question(questionNumberOne, validAnswers[1]),
            new Question(questionNumberTwo, validAnswers[0]),
            new Question(questionNumberThree, validAnswers[1]),
            new Question(questionNumberFour, validAnswers[2]),
            new Question(questionNumberFive, validAnswers[1]),
            new Question(questionNumberSix, validAnswers[0]),
            new Question(questionNumberSeven, validAnswers[0]),
            new Question(questionNumberEight, validAnswers[2]),
            new Question(questionNumberNine, validAnswers[1]),
            new Question(questionNumberTen, validAnswers[2])
        };
        startQuiz(questions, new Scanner(System.in));
        System.out.println("=======================");
        System.out.println("YOUR SCORE IS: " + correctCount + " / " + questions.length);
        System.out.println("=======================");
    }

    /**
     * Method that outputs each quiz and asks the user for an answer.
     * Input validation is present.
     * @param questions the array of questions
     * @param keyboardInput scanner needed for user input.
     */
    private static void startQuiz(Question[] questions, Scanner keyboardInput) {
        for (int i = 0; i < questions.length; i++) {
            boolean choiceChecker = true;
            while (choiceChecker) {
                System.out.println("Question Number: "  + (i + 1));
                System.out.println(questions[i].question);
                System.out.print(">>: ");
                try {
                    char userAnswer = keyboardInput.nextLine().toUpperCase().trim().charAt(0);
                    if (isNumber(String.valueOf(userAnswer))) System.out.println("NUMBER ANSWER IS NOT ALLOWED");
                    else {
                        if (userAnswer == 'A' || userAnswer == 'B' || userAnswer == 'C') {
                            if (userAnswer == questions[i].answer) correctCount++;
                            choiceChecker = false;
                        }
                        else System.out.println("PLEASE CHOOSE:       A or B or C       ONLY");
                    }
                } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                    System.out.println("BLANK ANSWER IS NOT ALLOWED");
                }
            }
        }
    }

    /**
     * Method that checks if the {@code String} is an {@code Integer}.
     * @param numberString the {@code String} to be tested.
     * @return {@code true} if the {@code String} is an {@code Integer}.
     */
    private static boolean isNumber(String numberString) {
        try {
            Integer.parseInt(numberString);
            return true;
        } catch (Exception ignored) {}
        return false;
    }

    /**
     * Blueprint for creating questions
     */
    private static class Question {
        String question;
        char answer;

        public Question(String question, char answer) {
            this.question = question;
            this.answer = answer;
        }
    }
}
