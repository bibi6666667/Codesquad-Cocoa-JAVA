package mission2;

import java.util.Scanner;

public class BJ_2438 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.close();

        if (N < 1 || N > 100) return;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("*");
            }
            System.out.println(); // 줄바꿈
        }

    }
}