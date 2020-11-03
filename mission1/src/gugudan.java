import java.util.Scanner; // java에 내장되어 있는 클래스 중 하나.
// Scanner : 사용자에게 값을 입력받을 수 있는 기능 제공.

public class gugudan {
        public static void main(String[] args) {

        System.out.println("구구단을 출력합니다. 시작과 끝 단을 띄어쓰기로 구분해 입력해 주세요 : ");
        Scanner scanner = new Scanner(System.in);
        int startNum = scanner.nextInt();
        int endNum = scanner.nextInt();
        for (int k = startNum; k < endNum + 1; k++){
            System.out.println("--- " + k + "단 ---");
            for (int j = 1; j < 10; j++){
                System.out.println(k + "*" + j + "=" + (k * j));
            }
        }

        // 구구단 전체 출력
//        for (int i = 2; i < 10; i++){
//            System.out.println("--- " + i + "단 ---");
//            for (int j = 1; j < 10; j++){
//                System.out.println(i + "*" + j + "=" +i * j);
//            }
//        }

        //2단
//        System.out.println("2단");
//        System.out.println(2 * 1);
//        System.out.println(2 * 2);
//        System.out.println(2 * 3);
//        System.out.println(2 * 4);
//        System.out.println(2 * 5);
//        System.out.println(2 * 6);
//        System.out.println(2 * 7);
//        System.out.println(2 * 8);
//        System.out.println(2 * 9);

        //3단
//        System.out.println("3단");
//        System.out.println(3 * 2);
//        System.out.println(3 * 3);
//        System.out.println(3 * 4);
//        System.out.println(3 * 5);
//        System.out.println(3 * 6);
//        System.out.println(3 * 7);
//        System.out.println(3 * 8);
//        System.out.println(3 * 9);

        //4단
//        System.out.println("4단");
//        int result = 4 * 1; // 변수 선언 - 선언은 datatype으로 구글링.
//        System.out.println(result);
//        result = 4 * 2; // 할당? 변수에 결과값을 저장.
//        System.out.println(result);
//        result = 4 * 3;
//        System.out.println(result);
//        result = 4 * 4;
//        System.out.println(result);
//        result = 4 * 5;
//        System.out.println(result);
//        result = 4 * 6;
//        System.out.println(result);
//        result = 4 * 7;
//        System.out.println(result);
//        result = 4 * 8;
//        System.out.println(result);
//        result = 4 * 9;
//        System.out.println(result);

//        System.out.println("구구단 중 출력할 단은? : ");
//        Scanner scanner = new Scanner(System.in);
//        int number = scanner.nextInt();
//        System.out.println(number * 1);
//        System.out.println(number * 2);
//        System.out.println(number * 3);
//        System.out.println(number * 4);
//        System.out.println(number * 5);
//        System.out.println(number * 6);
//        System.out.println(number * 7);
//        System.out.println(number * 8);
//        System.out.println(number * 9);
        // -> 변수가 무엇인지 이해하기. 나만의 용어로 정리해 두기.

        // 6단 : while문을 통해 반복문 구현.
//        int i = 1; // 반복문의 시작점.
//        while (i < 10) {
//            System.out.println(6 * i);
//            i = i + 1; // 기존 i값에 1을 더해 다시 i에 대입.
//        };

        // 7단 : for문을 통해 반복문 구현. - while문보다 더 적은 라인으로 구현가능.
//        for(int j = 1; j < 10; j++) {
//            System.out.println(7 * j);
//        }
    }
}
