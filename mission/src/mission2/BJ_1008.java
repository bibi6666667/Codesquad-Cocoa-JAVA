package mission2;

import java.util.Scanner;

public class BJ_1008 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numA = s.nextInt();
        int numB = s.nextInt();

        if (numA <= 0 || numB >= 10 ) return;

        double D_numA = (double)numA;
        double D_numB = (double)numB;

        System.out.println(D_numA / D_numB);
    }
}
