package mission2;

import java.util.Scanner;
import java.util.Arrays;

public class BJ_8958 {
    public static void main (String[] args) {
        // 테스트 케이스의 개수와 테스트 케이스를 입력받아 배열로 저장한다
        // ??점수표)테스트 케이스 개수와 각 테스트 케이스 길이에 맞는 빈 배열을 만든다
        // 채점) 각 테스트 케이스의 점수를 채점해 배열에 넣고, 각 자릿수를 더한다
        // 출력) 각 테스트 케이스별로 점수를 출력한다.


        // 일단 한줄만 입력받아 OX 채점하는 버전을 만들어 보자..
        // 1.테스트케이스 입력받기
        Scanner s = new Scanner(System.in);
        int testCaseNum = s.nextInt();
        String testCaseStr = s.next();

        String[] testCaseArr = testCaseStr.split("");
        // 2.채점하기
        int score = 0;
        System.out.println(Arrays.toString(testCaseArr)+"를 채점합니다.");

        for (int i = 0; i < testCaseArr.length; i++) { // 기본점수 채점. (+1)
            if (testCaseArr[i].equals("O")) {
                score++;
                for (int j = 1; j < i; j++) { // 보너스점수 채점. (+연속해 맞은만큼)
                    if (testCaseArr[i - j].equals("O")) {
                        score = score + 1;
                    }
                    if (i == 0) {
                        break;
                    }
                    if (testCaseArr[i - j].equals("X")) {
                        break;
                    }
                }
                System.out.println(i+"번째 채점결과 : " + score);
            }
        }

        System.out.println("최종 점수 : " + score);


//        for (int i = 0; i < testCaseNum; i++) {
//            // testCaseNum만큼 testCaseStr 만들기
//            testCaseStr[i] = s.next();
//        }

        //String[] testCaseArr = new String[testCaseStr.length()]; 문자열 길이만큼의 빈 배열





    }
}
