package mission1;// 피드백) "첫째 줄"에 출력해야 하므로, 입력하라는 메시지 출력은 하지 말아야(주석 처리한 부분).
import java.util.Scanner;

public class BJ_if_1330 {
    public static void main (String[] args) {
        Scanner inputAB = new Scanner(System.in);
        //System.out.println("두 정수 A와 B를 입력해 주세요 : A B입력");
        int numA = inputAB.nextInt();
        int numB = inputAB.nextInt();

        if (numA >= 10000 || numA <= -10000) return;
        if (numB >= 10000 || numB <= -10000) return;

        if (numA > numB) System.out.println(">");
        if (numA < numB) System.out.println("<");
        if (numA == numB) System.out.println("==");
    }

}
