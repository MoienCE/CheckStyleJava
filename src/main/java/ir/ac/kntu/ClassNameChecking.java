package ir.ac.kntu;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClassNameChecking {
    private static int lineNumber = 1;
    static String className = "";
    public static void print(){
        switch (lineNumber) {
            case 2 -> System.out.println(lineNumber + "nd line: class name is not UpperCamelCase");
            case 3 -> System.out.println(lineNumber + "rd line: class name is not UpperCamelCase");
            default -> System.out.println(lineNumber + "th line: class name is not UpperCamelCase");
        }
    }

    public static void main(String fileName) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("src/main/java/ir/ac/kntu/" + fileName));
            String line = reader.readLine();

            while (line != null) {

                if (line.startsWith("public class")) {
                    className = line.substring(13, 17);
                    if (!className.matches("^(?:[A-Z][a-z0-9]*)+$"))
                        print();
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
