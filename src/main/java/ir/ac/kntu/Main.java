package ir.ac.kntu;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        //*********(package checking)*********//
        PackageFinder.main(fileName);

        //*********(command counter)*********//
        CommandCounter.main(fileName);

        //**********(size checking)**********//
        SizeChecking.main(fileName);

        //*******(class name checking)*******//
        ClassNameChecking.main(fileName);

        //******(method name checking)******//
        MethodNameChecking.main(fileName);

        //****(variable name checking)*****//



    }
}
