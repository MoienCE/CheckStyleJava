package ir.ac.kntu;


public class Test {
    public static void main() {
        String str = "int    mahan";
        String salam = str.replaceAll("int +", "");
        System.out.println(salam);
    }
}