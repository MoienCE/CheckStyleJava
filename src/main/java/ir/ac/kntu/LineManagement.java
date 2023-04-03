package ir.ac.kntu;

public class LineManagement {

    public static String methodNameExtractor(String line) {
        String methodName;
        methodName = line.replaceAll(" +[A-Za-z]+ [A-Za-z]+ [A-Za-z]+ ", "");
        methodName = methodName.replaceAll("[^A-Za-z0-9].*", "");
        return methodName;
    }

    public static String variableNameExtractor(String line) {
        String variableName;
        variableName = line.trim().replaceAll("^[a-z\\[\\]A-Z]+ ", "");
        variableName = variableName.replaceAll("[ =].*", "");
        return variableName;
    }
}