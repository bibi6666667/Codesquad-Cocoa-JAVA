// 호눅스의 라이브 코딩 - 구구단입니다.
import java.util.Scanner;

public class Gugudan_answer {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("시작단을 입력해 주세요");
        int start = s.nextInt();
        System.out.println("끝단을 입력해 주세요");
        int end = s.nextInt();
        System.out.printf("%d %d\n", start, end);
        //print start to end dan
        for (int i = start; i <= end; i++){
            System.out.println(i + "단");
            for (int j = 1; j <= 9; j++){
                System.out.println(i + "*" + j + "=" + (i * j));
            }
            System.out.println(("==========\n"));
        }
        s.close();

    }
}
