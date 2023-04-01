package ir.ac.kntu;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClassNameChecking {
    private static int lineNumber = 1;
    static String className = "";

    public static void printNotCase() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: class name is not UpperCamelCase");
            case 2 -> System.out.println(lineNumber + "nd line: class name is not UpperCamelCase");
            case 3 -> System.out.println(lineNumber + "rd line: class name is not UpperCamelCase");
            default -> System.out.println(lineNumber + "th line: class name is not UpperCamelCase");
        }
    }
    public static void printSmall() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: class name is lower than 2 characters");
            case 2 -> System.out.println(lineNumber + "nd line: class name is lower than 2 characters");
            case 3 -> System.out.println(lineNumber + "rd line: class name is lower than 2 characters");
            default -> System.out.println(lineNumber + "th line: class name is lower than 2 characters");
        }
    }

    public static void main(String fileName) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("src/main/java/ir/ac/kntu/" + fileName));
            String line = reader.readLine();

            while (line != null) {

                if (line.startsWith("public class")) {

                    int j = 13;
                    while (line.charAt(j) != '{' && line.charAt(j) != ' '){
                        j++;
                    }
                    className = line.substring(13, j);

                    if (className.length() < 2){
                        printSmall();
                        break;
                    }
                    if (!className.matches("[A-Z][a-zA-Z0-9].*")){
                        printNotCase();
                        break;
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
