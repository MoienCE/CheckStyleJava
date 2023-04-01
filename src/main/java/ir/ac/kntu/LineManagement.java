package ir.ac.kntu;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineManagement {
    public static String removeInitialSpace(String line) {
        String removedInitialSpace = line;
        Pattern p = Pattern.compile("^[ ]+");
        Matcher m = p.matcher(line);

        while (m.find())
            removedInitialSpace = line.replaceAll(m.group(), "");

        return removedInitialSpace;
    }

    public static String methodNameExtractor(String line) {
        String methodName;
        methodName = line.replaceAll(" +[A-Za-z]+ [A-Za-z]+ [A-Za-z]+ ", "");
        methodName = methodName.replaceAll("[^A-Za-z0-9].*", "");
        return methodName;
    }

    public static String variableNameExtractor(String line) {
        String variableName;
        variableName = line.replaceAll("^[a-zS]+ ", "");
        variableName = variableName.replaceAll("[ =].*", "");
        return variableName;
    }
}