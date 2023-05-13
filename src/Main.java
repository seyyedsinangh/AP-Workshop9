import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "/media/farbod/2A8AD6C38AD68B29/Farbod/university/term 4/AP/MultiThread/src/word_files/";

        FileProcessor fileProcessor = null;
        for(int i = 1; i <= 20; i++) {
            fileProcessor = new FileProcessor(path  + "file_" + i + ".txt");
            new Thread(fileProcessor).start();
        }

        System.out.println("words count: " + fileProcessor.wordCount);
        System.out.println("shortest word: " + fileProcessor.shortestWord);
        System.out.println("longest word: " + fileProcessor.longestWord);

    }
}