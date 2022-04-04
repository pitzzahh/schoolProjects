import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Example {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>();

        // adding 0 up to 100_000
        for (int i = 0; i < 10_000_001; i++) {
            numbers.add(i);
        }
        File file = new File("D:\\Downloads\\savedFile.txt");

        for (Integer number : numbers) {
            writeToATextFile(String.valueOf(number), file);
        }
    }

    /**
     * Writes to a text file.
     * @param whatToWrite the {@code String} to be written on the file.
     * @param fileToWrite the file to be written.
     * @throws IOException if the file does not exist.
     */
    public static void writeToATextFile(String whatToWrite, File fileToWrite) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToWrite, true));
        bufferedWriter.write(whatToWrite);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
