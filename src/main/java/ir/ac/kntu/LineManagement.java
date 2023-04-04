package ir.ac.kntu;

public class LineManagement {

    public static String methodNameExtractor(String line) {
        String methodName;
        methodName = line.replaceAll(" +[A-Za-z]+ [A-Za-z]+ [A-Za-z]+ ", "");
        methodName = methodName.replaceAll("[^A-Za-z0-9].*", "");
        return methodName;
    }

    public static String variableNameExtractor(String line) {
        String variableName = line.trim().replaceAll(".*(int|float|double|byte|long|char|boolean|String) ", "");
        variableName = variableName.replaceAll("[ =)].*", "");
        return variableName;
    }
}