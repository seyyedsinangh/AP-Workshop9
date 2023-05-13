import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;

public class FileProcessor implements Runnable {
    public static int wordCount;
    public static String longestWord;
    public static String shortestWord;
    private final String fileName;
    private final static HashSet<String> allWords = new HashSet<>();

    FileProcessor(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            synchronized (allWords) {
                String[] words = Files.readString(Path.of(fileName)).split("\n");
                allWords.addAll(Arrays.asList(words));
            }

            longestWord = "";
            shortestWord = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            for (String word: allWords) {
                int wordLen = word.length();

                if(wordLen > longestWord.length())
                    longestWord = word;
                else if(wordLen <  shortestWord.length())
                    shortestWord = word;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
