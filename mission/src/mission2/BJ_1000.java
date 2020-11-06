package mission2;

import java.util.Scanner;

public class BJ_1000 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int numA = s.nextInt();
        int numB = s.nextInt();

        if (numA <= 0 || numB >= 10) return;

        System.out.println(numA + numB);
    }
}
