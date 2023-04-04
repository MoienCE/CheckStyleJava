package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoopStileChecking {

    public static int lineNumber;

    public static void print() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: The shape of the loop is not regular");
            case 2 -> System.out.println(lineNumber + "nd line: The shape of the loop is not regular");
            case 3 -> System.out.println(lineNumber + "rd line: The shape of the loop is not regular");
            default -> System.out.println(lineNumber + "th line: The shape of the loop is not regular");
        }
    }

    public static void main(String fileName) {
        lineNumber = 1;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/java/ir/ac/kntu/" + fileName));
            String line = reader.readLine();

            while (line != null) {
                line = line.replaceAll("\".*\"", "");
                line = line.replaceAll("'.'", "");
                if (line.trim().startsWith("//")) {
                    line = reader.readLine();
                    lineNumber++;
                    continue;
                }
                if (line.trim().startsWith("while")) {
                    whileCheck(line);
                }
                else if (line.trim().startsWith("for")) {
                    forCheck(line);
                }
                line = reader.readLine();
                lineNumber++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void whileCheck(String line){
        int i = 0;
        while (line.trim().charAt(i) != '{') {
            i++;
        }
        String str = line.trim().substring(0, i + 1);
        if (!line.trim().equals(str)) {
            print();
        } else {
            Pattern p = Pattern.compile("while ?\\(.+\\) ?\\{");
            Matcher m = p.matcher(line);
            if (!m.find())
                print();
        }
    }
    public static void forCheck(String line){
        int i = 0;
        while (line.trim().charAt(i) != '{') {
            i++;
        }
        String str = line.trim().substring(0, i + 1);
        if (!line.trim().equals(str)) {
            print();
        } else {
            Pattern p = Pattern.compile("for ?\\(.+\\) ?\\{");
            Matcher m = p.matcher(line);
            if (!m.find())
                print();
        }
    }
}