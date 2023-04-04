package ir.ac.kntu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        //*********(package checking)*********//
        System.out.print("package calling WARNINGS:\n");
        PackageFinder.main(fileName);

        //*********(command counter)*********//
        System.out.print("\n--------------------------\ncommand counting WARNINGS:\n");
        CommandCounter.main(fileName);

        //**********(size checking)**********//
        System.out.print("\n---------------------\nline length WARNINGS:\n");
        SizeChecking.main(fileName);

        //************(name checking)***********//
        System.out.print("\n----------------\nnaming WARNINGS:\n");
        NameChecking.main(fileName);

        //*****(indentation checking)******//
        System.out.print("\n---------------------\nindentation WARNINGS:\n");
        IndentationChecking.main(fileName);

        //******(loop stile checking)******//
        System.out.print("\n---------------------\nloop stile WARNINGS:\n");
        LoopStileChecking.main(fileName);

        //****(condition stile checking****//
        System.out.print("\n---------------------\ncondition stile WARNINGS:\n");
        ConditionStileChecking.main(fileName);

        //*****(switch stile checking)*****//
        System.out.print("\n---------------------\nswitch-case stile WARNINGS:\n");
        SwitchCaseChecking.main(fileName);
    }
}
