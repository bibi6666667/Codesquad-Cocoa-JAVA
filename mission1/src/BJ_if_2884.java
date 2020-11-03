import java.util.Scanner;

public class BJ_if_2884 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int H = input.nextInt();
        int M = input.nextInt();

        if (H < 0 || H > 23) return;
        if (M < 0 || M > 59) return;

        // 입력한 시간의 45분 전의 시간을 출력.
        if (M < 45) { // 분이 45분 미만이면 받아내림해야 : 시간-1, 분+60-45
            H--;
            M = M + 15;
        }
        if (M >= 45) {
            M = M - 45;
        }
        if (H == 0 && M < 45) { // 시간이 0시, 분이 45분 미만이면 다시 23시로 되돌아감
            H = H + 23;
            M = M + 15;
        }

        System.out.print(H + " " + M);
    }
}
