package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PackageFinder {
    private static int lineNumber = 1;

    public static void print() {
        switch (lineNumber) {
            case 2 -> System.out.println(lineNumber + "nd line: package not imported in the first line.");
            case 3 -> System.out.println(lineNumber + "rd line: package not imported in the first line.");
            default -> System.out.println(lineNumber + "th line: package not imported in the first line.");
        }
    }

    public static void main(String fileName) {
        BufferedReader reader;
        boolean packageFound = false;
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
                if (line.startsWith("package") && lineNumber != 1) {
                    packageFound = true;
                    break;
                }
                line = reader.readLine();
                lineNumber++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (packageFound) {
            print();
        }
    }
}
