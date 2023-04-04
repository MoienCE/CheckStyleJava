package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SizeChecking {
    private static int lineNumber = 1;

    public static void print() {
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

                if (line.length() > 80) {
                    print();
                    recommender(line);
                }
                line = reader.readLine();
                lineNumber++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void recommender(String line) {
        String line1 = "";
        String line2 = "";

        for (int counter = line.length(); counter != 0; counter--) {
            if (counter < 80){
                if (line.charAt(counter) == '+'
                        || line.charAt(counter) == '-'
                        || line.charAt(counter) == '/'
                        || line.charAt(counter) == '*'
                        || line.charAt(counter) == '%'
                        || line.charAt(counter) == '^'
                        || line.charAt(counter) == '&'
                        || line.charAt(counter) == '|'){
                    line1 = line.substring(0, counter);
                    line2 = line.substring(counter);
                    break;
                }
            }
        }
        System.out.println("I suggest you use this template:");
        System.out.println(line1.trim());
        System.out.println(line2);
        System.out.println();
    }
}
