package ir.ac.kntu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest {
    public static void main(String[]args) {
        String input = "Hello\nworld\n";
        System.out.println(input);
        Pattern pattern = Pattern.compile("\\r?\\n");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println("Match found at index " + matcher.start());
        }
    }
}