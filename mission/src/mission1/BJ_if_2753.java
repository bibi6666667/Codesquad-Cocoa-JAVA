import java.util.Scanner;

public class BJ_if_2753 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();

        if (year < 1 || year > 4000) return;

        if (year % 4 == 0) { // 연도가 4의 배수이고,
            if (year % 100 != 0 || year % 400 == 0) {
                //연도가 100의 배수가 아니거나 400의 배수이면 윤년.
                System.out.println("1");
            }
            if (year % 100 == 0 && year % 400 != 0) {
                // (윤년의 반대)연도가 100의 배수이고? 400의 배수가 아니면 윤년X.
                System.out.println("0");
            }
        }
        if (year % 4 != 0) { // 연도가 4의 배수도 아니면 윤년X.
            System.out.println("0");
        }
    }
}
