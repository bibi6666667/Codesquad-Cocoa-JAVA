package mission1;// 피드백 ) score는 0보다 크거나 같고, 100보다 작거나 같은 정수!!
import java.util.Scanner;

public class BJ_if_9498 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int score = input.nextInt();

        if (score < 0 || score > 100) return;

        if (score >=90 && score <= 100) {
            System.out.println("A");
        }
        if (score >=80 && score <= 89) {
            System.out.println("B");
        }
        if (score >=70 && score <= 79) {
            System.out.println("C");
        }
        if (score >=60 && score <= 69) {
            System.out.println("D");
        }
        if (score < 60) {
            System.out.println("F");
        }
    }
}
