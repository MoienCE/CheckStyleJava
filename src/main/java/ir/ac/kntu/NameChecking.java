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

    public static void main(String fileName) {
        Pattern methodPattern = Pattern.compile("public static [A-Za-z]+ [A-Za-z]+");
        Matcher methodMatcher;
        lineNumber = 1;
        String className, methodName, variableName;

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/java/ir/ac/kntu/" + fileName));
            String line = reader.readLine();

            while (line != null) {
                methodMatcher = methodPattern.matcher(line);
                if (line.trim().startsWith("public class")) { //********(class?)********//
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
                else if (methodMatcher.find()) { //********(method?)********//
                    methodName = LineManagement.methodNameExtractor(line);
                    if (methodName.length() < 2) {
                        methodPrintSmall();
                        return;
                    }
                    if (!methodName.matches("^[a-z]+[A-Za-z0-9]+")) {
                        methodPrintNotCase();
                    }
                }
                else if (line.trim().startsWith("int")
                        || line.trim().startsWith("double")
                        || line.trim().startsWith("byte")
                        || line.trim().startsWith("long")
                        || line.trim().startsWith("char")
                        || line.trim().startsWith("boolean")
                        || line.trim().startsWith("String")
                        || line.trim().startsWith("float")) { //********(variable?)********//
                    variableName = LineManagement.variableNameExtractor(line);
                    if (variableName.length() < 2)
                        variablePrintSmall();

                    else if (!variableName.matches("[a-z][a-zA-Z0-9].*"))
                        variablePrintNotCase();

                }

                line = reader.readLine();
                lineNumber++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //*******************(method naming)*******************//
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
}
