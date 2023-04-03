package ir.ac.kntu;

public class Test {
    public static void Mz() {
        int attack = 5;
        int a = 0;
        int elseAm = 1;
        attack++;
        for (int i = 0; i < 10; i++) {
            a++;
        }
        while (attack < 50) {
            attack++;
        }
        if (attack == 49)  {
            System.out.println("no");
        } else if (a == 5) {
            System.out.println("naaa");
        } else if (a == 47) {
            System.out.println("areee");
        } else {
            System.out.println("han");
        }
    }
}