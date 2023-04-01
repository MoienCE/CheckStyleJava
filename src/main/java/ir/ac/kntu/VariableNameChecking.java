package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VariableNameChecking {

    private static int lineNumber = 1;
    static String variableName = "";

    public static void printNotCase() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: variable name is not lowerCamelCase.");
            case 2 -> System.out.println(lineNumber + "nd line: variable name is not lowerCamelCase.");
            case 3 -> System.out.println(lineNumber + "rd line: variable name is not lowerCamelCase.");
            default -> System.out.println(lineNumber + "th line: variable name is not lowerCamelCase.");
        }
    }
    public static void printSmall() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: variable name is lower than 2 characters.");
            case 2 -> System.out.println(lineNumber + "nd line: variable name is lower than 2 characters.");
            case 3 -> System.out.println(lineNumber + "rd line: variable name is lower than 2 characters.");
            default -> System.out.println(lineNumber + "th line: variable name is lower than 2 characters.");
        }
    }

    public static void main(String fileName) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/java/ir/ac/kntu/" + fileName));
            String line = reader.readLine();

            while (line != null) {
                line = LineManagement.removeInitialSpace(line);
                if (line.startsWith("int") || line.startsWith("double") || line.startsWith("byte") || line.startsWith("long") || line.startsWith("char") || line.startsWith("boolean") || line.startsWith("String") || line.startsWith("float"))
                {
                    variableName = LineManagement.variableNameExtractor(line);
                    if (variableName.length() < 2)
                        printSmall();

                    else if (!variableName.matches("[a-z][a-zA-Z0-9].*"))
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
