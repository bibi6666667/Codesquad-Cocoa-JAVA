// 호눅스의 라이브 코딩 - 구구단 객체지향ver.입니다.
import java.util.Scanner;
    public class Gugudan_answer_object {
        public int start;
        public int end;
        public void init() {
            Scanner s = new Scanner(System.in);
            System.out.println("시작단을 입력해 주세요");
            this.start = s.nextInt();
            System.out.println("끝단을 입력해 주세요");
            this.end = s.nextInt();
            s.close();
        }
        private void printGugudan(int num) {
            System.out.println("=======" + num + " Dan ========" );
            for(int i = 1; i <= 9; i++) {
                System.out.printf("%d * %d = %d\t", num, i, num * i);
                if (i %3 == 0) System.out.println();
            }
            System.out.println();
        }
        public void printAll() {
            for(int i = this.start; i <= this.end; i++) {
                printGugudan(i);
            }
        }
        public static void main(String[] args) {
            Gugudan_answer_object gugu = new Gugudan_answer_object();
            gugu.init();
            gugu.printAll();
        }
    }

