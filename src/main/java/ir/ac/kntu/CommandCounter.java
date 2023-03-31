package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommandCounter {
    private static int lineNumber = 1;
    private static int number = 0;


    public static void print(){
        switch (lineNumber) {
            case 1 -> System.out.println("1st line: " + number + " commands in one line");
            case 2 -> System.out.println("2nd line: " + number + " commands in one line");
            case 3 -> System.out.println("3rd line: " + number + " commands in one line");
            default -> System.out.println(lineNumber + "th line: " + number + " commands in one line");
        }
    }

    public static void main(String fileName) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/main/java/ir/ac/kntu/" + fileName));
            String line = reader.readLine();

            while (line != null) {
                for(int i = 0; i < line.length(); i++) {
                    if(line.charAt(i) == ';')
                        number++;
                }
                if (number > 1) {
                    print();
                }
                line = reader.readLine();
                lineNumber++;
                number = 0;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
