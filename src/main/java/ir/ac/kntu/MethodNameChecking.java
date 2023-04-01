package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodNameChecking {
    private static int lineNumber = 1;
    static String methodName = "";

    public static void printNotCase() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: method name is not lowerCamelCase.");
            case 2 -> System.out.println(lineNumber + "nd line: method name is not lowerCamelCase.");
            case 3 -> System.out.println(lineNumber + "rd line: method name is not lowerCamelCase.");
            default -> System.out.println(lineNumber + "th line: method name is not lowerCamelCase.");
        }
    }
    public static void printSmall() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: method name is lower than 2 characters.");
            case 2 -> System.out.println(lineNumber + "nd line: method name is lower than 2 characters.");
            case 3 -> System.out.println(lineNumber + "rd line: method name is lower than 2 characters.");
            default -> System.out.println(lineNumber + "th line: method name is lower than 2 characters.");
        }
    }

    public static void main(String fileName) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/java/ir/ac/kntu/" + fileName));
            String line = reader.readLine();

            while (line != null) {
                Pattern p = Pattern.compile("[A-Za-z]+ [A-Za-z]+ [A-Za-z]+ [A-Za-z]+");
                Matcher m = p.matcher(line);
                if (m.find())
                {
                    methodName = LineManagement.methodNameExtractor(line);
                    if (methodName.length() < 2)
                        printSmall();
                    p = Pattern.compile("^[a-z]+[A-Za-z0-9]+");
                    m = p.matcher(methodName);
                    if (!m.find())
                        printNotCase();
                }

                line = reader.readLine();
                lineNumber++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
