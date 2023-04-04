package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IndentationChecking {
    private static int lineNumber = 1;

    public static void print() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: Empty space is not ordered");
            case 2 -> System.out.println(lineNumber + "nd line: Empty space is not ordered");
            case 3 -> System.out.println(lineNumber + "rd line: Empty space is not ordered");
            default -> System.out.println(lineNumber + "th line: Empty space is not ordered");
        }
    }

    public static void main(String fileName) {
        int cCounter = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/java/ir/ac/kntu/" + fileName));
            String line = reader.readLine();

            while (line != null) {
                line = line.replaceAll("\".*\"", "");
                line = line.replaceAll("'.'", "");
                if (line.contains("}") && !line.trim().startsWith("}"))
                    print();
                if (line.trim().startsWith("//")) {
                    line = reader.readLine();
                    lineNumber++;
                    continue;
                }
                if (line.contains("}"))
                    cCounter--;
                if (!line.trim().equals(line) && !chekSpace(line, cCounter))
                    print();
                if (line.contains("{"))
                    cCounter++;

                line = reader.readLine();
                lineNumber++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean chekSpace(String line, int cCounter) {
        for (int i = 0; i < cCounter * 4; i++) {
            if (line.charAt(i) != ' ')
                return false;
        }
        return line.charAt(cCounter * 4) != ' ';
    }
}

