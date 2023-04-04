package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameChecking {
    private static int lineNumber;

    //*******************(class naming)*******************//
    public static void classPrintNotCase() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: class name is not UpperCamelCase");
            case 2 -> System.out.println(lineNumber + "nd line: class name is not UpperCamelCase");
            case 3 -> System.out.println(lineNumber + "rd line: class name is not UpperCamelCase");
            default -> System.out.println(lineNumber + "th line: class name is not UpperCamelCase");
        }
    }

    public static void classPrintSmall() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: class name is lower than 2 characters");
            case 2 -> System.out.println(lineNumber + "nd line: class name is lower than 2 characters");
            case 3 -> System.out.println(lineNumber + "rd line: class name is lower than 2 characters");
            default -> System.out.println(lineNumber + "th line: class name is lower than 2 characters");
        }
    }

    public static void methodPrintNotCase() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: method name is not lowerCamelCase.");
            case 2 -> System.out.println(lineNumber + "nd line: method name is not lowerCamelCase.");
            case 3 -> System.out.println(lineNumber + "rd line: method name is not lowerCamelCase.");
            default -> System.out.println(lineNumber + "th line: method name is not lowerCamelCase.");
        }
    }

    public static void methodPrintSmall() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: method name is lower than 2 characters.");
            case 2 -> System.out.println(lineNumber + "nd line: method name is lower than 2 characters.");
            case 3 -> System.out.println(lineNumber + "rd line: method name is lower than 2 characters.");
            default -> System.out.println(lineNumber + "th line: method name is lower than 2 characters.");
        }
    }

    //*******************(variable naming)*******************//
    public static void variablePrintNotCase() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: variable name is not lowerCamelCase.");
            case 2 -> System.out.println(lineNumber + "nd line: variable name is not lowerCamelCase.");
            case 3 -> System.out.println(lineNumber + "rd line: variable name is not lowerCamelCase.");
            default -> System.out.println(lineNumber + "th line: variable name is not lowerCamelCase.");
        }
    }

    public static void variablePrintSmall() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: variable name is lower than 2 characters.");
            case 2 -> System.out.println(lineNumber + "nd line: variable name is lower than 2 characters.");
            case 3 -> System.out.println(lineNumber + "rd line: variable name is lower than 2 characters.");
            default -> System.out.println(lineNumber + "th line: variable name is lower than 2 characters.");
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
                methodCheck(line);
                classCheck(line);
                variableCheck(line);

                line = reader.readLine();
                lineNumber++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void classCheck(String line) {
        String className;
        if (line.trim().startsWith("public class")) {
            int j = 13;
            while (line.charAt(j) != '{' && line.charAt(j) != ' ') {
                j++;
            }
            className = line.substring(13, j);

            if (className.length() < 2) {
                classPrintSmall();
            }
            if (!className.matches("[A-Z][a-zA-Z0-9].*")) {
                classPrintNotCase();
            }
        }
    }

    private static void methodCheck(String line) {
        Pattern methodPattern = Pattern.compile("public static [A-Za-z]+ [A-Za-z]+");
        Matcher methodMatcher = methodPattern.matcher(line);
        String methodName;
        if (methodMatcher.find()) {
            methodName = LineManagement.methodNameExtractor(line);
            if (methodName.length() < 2) {
                methodPrintSmall();
                return;
            }
            if (!methodName.matches("^[a-z]+[A-Za-z0-9]+")) {
                methodPrintNotCase();
            }
        }
    }

    private static void variableCheck(String line) {
        String variableName;
        if (line.trim().contains("int ")
                || line.trim().contains("double ")
                || line.trim().contains("byte ")
                || line.trim().contains("long ")
                || line.trim().contains("char ")
                || line.trim().contains("boolean ")
                || line.trim().contains("String ")
                || line.trim().contains("float ")) {
            variableName = LineManagement.variableNameExtractor(line);
            if (variableName.length() < 2) {
                variablePrintSmall();
            } else if (!variableName.matches("[a-z][a-zA-Z0-9].*")) {
                variablePrintNotCase();
            }
        }
    }

}
