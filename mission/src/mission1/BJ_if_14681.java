package mission1;// 한큐에 성공!
import java.util.Scanner;

public class BJ_if_14681 {
    public static void main (String[] args) {
        Scanner inputXY = new Scanner(System.in);
        int X = inputXY.nextInt();
        int Y = inputXY.nextInt();

        if (X > 1000 || X < -1000 || X == 0) return;
        if (Y > 1000 || Y < -1000 || Y == 0) return;

        if (X > 0 && Y > 0) {
            System.out.println("1");
        }
        if (X < 0 && Y > 0) {
            System.out.println("2");
        }
        if (X < 0  && Y < 0) {
            System.out.println("3");
        }
        if (X > 0 && Y < 0) {
            System.out.println("4");
        }
    }
}
