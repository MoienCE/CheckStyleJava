package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConditionStileChecking {

    private static int lineNumber;

    public static void printIf() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: The shape of the IF is not regular");
            case 2 -> System.out.println(lineNumber + "nd line: The shape of the IF is not regular");
            case 3 -> System.out.println(lineNumber + "rd line: The shape of the IF is not regular");
            default -> System.out.println(lineNumber + "th line: The shape of the IF is not regular");
        }
    }

    public static void printElseIf() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: The shape of the ELSE-IF is not regular");
            case 2 -> System.out.println(lineNumber + "nd line: The shape of the ELSE-IF is not regular");
            case 3 -> System.out.println(lineNumber + "rd line: The shape of the ELSE-IF is not regular");
            default -> System.out.println(lineNumber + "th line: The shape of the ELSE-IF is not regular");
        }
    }

    public static void printElse() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: The shape of the ELSE is not regular");
            case 2 -> System.out.println(lineNumber + "nd line: The shape of the ELSE is not regular");
            case 3 -> System.out.println(lineNumber + "rd line: The shape of the ELSE is not regular");
            default -> System.out.println(lineNumber + "th line: The shape of the ELSE is not regular");
        }
    }

    public static void main(String fileName) {
        Pattern findIfPattern = Pattern.compile("^if *\\(");
        Matcher finIfMatcher;
        Pattern ifPattern = Pattern.compile("if ?\\(.+\\) ?\\{");
        Matcher ifMatcher;

        Pattern findElseIfPattern = Pattern.compile("else *if");
        Matcher finElseIfMatcher;
        Pattern elseIfPattern = Pattern.compile("else ?if ?\\(.*\\) ?\\{");
        Matcher elseIfMatcher;

        Pattern findElsePattern = Pattern.compile("else *\\{");
        Matcher finElseMatcher;
        Pattern elsePattern = Pattern.compile("else ?\\{");
        Matcher elseMatcher;
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

                //*****(If Stile Checking)*****//
                finIfMatcher = findIfPattern.matcher(line.trim());
                if (finIfMatcher.find()) {
                    int i = 0;
                    while (line.trim().charAt(i) != '{') {
                        i++;
                    }
                    String str = line.trim().substring(0, i + 1);
                    if (!line.trim().equals(str)) {
                        printIf();
                    } else {
                        ifMatcher = ifPattern.matcher(line);
                        if (!ifMatcher.find())
                            printIf();
                    }
                }

                //*****(else-If Stile Checking)*****//
                finElseIfMatcher = findElseIfPattern.matcher(line);
                if (finElseIfMatcher.find()) {
                    int i = 0;
                    while (line.trim().charAt(i) != '{') {
                        i++;
                    }
                    String str = line.trim().substring(0, i + 1);
                    if (!line.trim().equals(str)) {
                        printElseIf();
                    } else {
                        elseIfMatcher = elseIfPattern.matcher(line);
                        if (!elseIfMatcher.find())
                            printElseIf();
                    }
                }

                //*****(else Stile Checking)*****//
                finElseMatcher = findElsePattern.matcher(line);
                if (finElseMatcher.find()) {
                    int i = 0;
                    while (line.trim().charAt(i) != '{') {
                        i++;
                    }
                    String str = line.trim().substring(0, i + 1);
                    if (!line.trim().equals(str)) {
                        printElse();
                    } else {
                        elseMatcher = elsePattern.matcher(line);
                        if (!elseMatcher.find())
                            printElse();
                    }
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