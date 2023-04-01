package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SizeChecking {
    private static int lineNumber = 1;

    public static void print(){
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: what a big line! more than 80 characters!!");
            case 2 -> System.out.println(lineNumber + "nd line: what a big line! more than 80 characters!!");
            case 3 -> System.out.println(lineNumber + "rd line: what a big line! more than 80 characters!!");
            default -> System.out.println(lineNumber + "th line: what a big line! more than 80 characters!!");
        }
    }

    public static void main(String fileName) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("src/main/java/ir/ac/kntu/" + fileName));
            String line = reader.readLine();

            while (line != null) {

                if (line.length() > 80)
                    print();

                line = reader.readLine();
                lineNumber++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
