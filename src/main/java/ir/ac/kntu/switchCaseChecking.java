package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class switchCaseChecking {
    private static int lineNumber = 1;
    private static boolean defaultFound = false, inSwitch = false;

    public static void printSwitch() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: The shape of the Switch is not regular");
            case 2 -> System.out.println(lineNumber + "nd line: The shape of the Switch is not regular");
            case 3 -> System.out.println(lineNumber + "rd line: The shape of the Switch is not regular");
            default -> System.out.println(lineNumber + "th line: The shape of the Switch is not regular");
        }
    }
    public static void printDefaultNF() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: Default not found");
            case 2 -> System.out.println(lineNumber + "nd line: Default not found");
            case 3 -> System.out.println(lineNumber + "rd line: Default not found");
            default -> System.out.println(lineNumber + "th line: Default not found");
        }
    }
    public static void printDefault() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: Default stile is not regular");
            case 2 -> System.out.println(lineNumber + "nd line: Default stile is not regular");
            case 3 -> System.out.println(lineNumber + "rd line: Default stile is not regular");
            default -> System.out.println(lineNumber + "th line: Default stile is not regular");
        }
    }
    public static void printCase() {
        switch (lineNumber) {
            case 1 -> System.out.println(lineNumber + "st line: Case stile is not regular");
            case 2 -> System.out.println(lineNumber + "nd line: Case stile is not regular");
            case 3 -> System.out.println(lineNumber + "rd line: Case stile is not regular");
            default -> System.out.println(lineNumber + "th line: Case stile is not regular");
        }
    }
    public static void main(String fileName) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "src/main/java/ir/ac/kntu/" + fileName));
            String line = reader.readLine();

            while (line != null) {
                line = line.replaceAll("\".*\"", "");
                line = line.replaceAll("'.'", "");
                if (line.trim().startsWith("//")) {
                    line = reader.readLine();
                    lineNumber++;
                    continue;
                }
                switchStileCheck(line);
                caseStileCheck(line);
                defaultStileCheck(line);
                if (line.contains("}") && !defaultFound && inSwitch)
                    printDefaultNF();
                if (line.contains("}") && inSwitch){
                    if (!(line.trim().equals("}")))
                        printSwitch();
                    inSwitch = false;
                }
                line = reader.readLine();
                lineNumber++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void switchStileCheck(String line){
        Pattern switchFindPattern = Pattern.compile("switch *\\(");
        Matcher switchFindMatcher;
        Pattern switchPattern = Pattern.compile("switch ?\\(.*\\) ?\\{");
        Matcher switchMatcher;
        switchFindMatcher = switchFindPattern.matcher(line);
        if (switchFindMatcher.find()) {
            int i = 0;
            while (line.trim().charAt(i) != '{') {
                i++;
            }
            String str = line.trim().substring(0, i + 1);
            if (!line.trim().equals(str)) {
                printSwitch();
            } else {
                switchMatcher = switchPattern.matcher(line);
                if (!switchMatcher.find())
                    printSwitch();
            }
            inSwitch = true;
        }
    }
    public static void caseStileCheck(String line){
        Pattern caseFindPattern = Pattern.compile("case *[a-zA-Z0-9]+ *:");
        Matcher caseFindMatcher;
        Pattern casePattern = Pattern.compile("case [a-zA-Z0-9]+: .*;");
        Matcher caseMatcher;
        caseFindMatcher = caseFindPattern.matcher(line);
        if (caseFindMatcher.find()){
            caseMatcher = casePattern.matcher(line);
            if (!caseMatcher.find())
                printCase();
        }
    }
    public static void defaultStileCheck(String line){
        Pattern defaultFindPattern = Pattern.compile("default *:");
        Matcher defaultFindMatcher;
        Pattern defaultPattern = Pattern.compile("default: .*;");
        Matcher defaultMatcher;
        defaultFindMatcher = defaultFindPattern.matcher(line);
        if (defaultFindMatcher.find()){
            defaultFound = true;
            defaultMatcher = defaultPattern.matcher(line);
            if (!defaultMatcher.find())
                printDefault();
        }
    }
}