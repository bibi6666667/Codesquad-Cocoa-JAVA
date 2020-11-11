package mission3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;


public class DB {
    // 1. 회원 DB(해쉬맵) : ID, PW
    public static HashMap<String, String> IdPwDB = new HashMap<String, String>(); //<제네릭타입>

    // 2. 가계부 DB(배열의 리스트) : 날짜, 적요, 수입, 지출 (+ 번호, 잔액, 회원명)[7]
    public static String AccountNum = "1"; // number;
    //ArrayList에는 참조변수만 선언 가능.

    MoneyBook moneyBook = new MoneyBook();

    Scanner sc = new Scanner(System.in);

    public void writer(String[] newAccount) {
        try { // 일반적인 경우 실행 구문
            FileWriter fileWriter = new FileWriter("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\mission3\\MoneyBookDB.txt", true);
            String input = Arrays.toString(newAccount) + "\r\n"; //배열을 문자열로 형변환?

            //fileWriter.write();
            fileWriter.write(input);
            fileWriter.close();
        } catch (IOException e) { // 오류 발생시 잡는 구문
            e.printStackTrace();
        }
    }

    public void reader() {
        try { // 일반적인 경우 실행 구문
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\mission3\\MoneyBookDB.txt"));
            while (true) {
                String output = bufferedReader.readLine();
                if (output == null) break;
                System.out.println(output);
            }
            bufferedReader.close();
        } catch (IOException e) { // 오류 발생시 잡는 구문
            e.printStackTrace();
        }
    }

    //////////////////////1. 회원 DB 관련 메서드 //////////////////////////
    public void makeMembersDB(String[] IdPwArr) {
        //register() : 새 회원 생성
        String[] newIdPwArr = IdPwArr;
        String id = newIdPwArr[0];
        String pw = newIdPwArr[1];
        IdPwDB.put(id, pw);
        System.out.println(id + "," + pw + "로 가입이 완료되었습니다");
        System.out.println("현재 회원 목록 : " + IdPwDB);
        System.out.println("로그인으로 이동합니다.");
        moneyBook.login();
    }

    public boolean checkMembersDB(String[] IdPwArr) {
        //login() : idpw 일치하면 로그인, 일치하지 않으면 다시 입력
        String[] checkIdPwIrr = IdPwArr;
        String id = checkIdPwIrr[0];
        String pw = checkIdPwIrr[1];
        // id가 있고 비밀번호가 일치하면 true, 불일치하면 false
        if (IdPwDB.containsKey(id) == true) {
            String DBPw = IdPwDB.get(id);
            if (DBPw.equals(pw)) { // String이라서 == 가 아니라 .equals()로 비교해야 !!!
                return true;
            }
            return false;
        }
        // id가 없으면 false
        if (IdPwDB.containsKey(id) == false) {
            return false;
        }
        return false;
    }


    //////////////////////2. 가계부 DB 관련 메서드-CRUD //////////////////////////
    // (1) Create 생성
    public void createAccountDB() {
        // 날짜, 적요, 수입, 지출 입력받기
        System.out.println("--가계부를 작성합니다--");
        System.out.println("가계부에 새 내역을 작성합니다. 날짜, 설명, 수입, 지출 순으로 입력해 주세요");
        System.out.println("날짜를 입력해 주세요(연,월,일의 8자리 숫자로 입력)");
        System.out.print(">");
        String date = sc.next();
        sc.nextLine(); // 개행문자 제거
        System.out.println("수입/지출에 대한 간단한 설명을 입력해 주세요");
        System.out.print(">");
        String descript = sc.nextLine(); // 설명은 띄어쓰기 무시
        System.out.println("수입이 얼마였는지 숫자로 입력해 주세요");
        System.out.print(">");
        String income = sc.next();
        System.out.println("지출은 얼마였는지 숫자로 입력해 주세요");
        System.out.print(">");
        String expend = sc.next();
        // 순번 추가
        String number = numbering();
        // 회원명 추가
        String user = MoneyBook.ID;
        // 저장
        String[] anAccount = new String[]{number, date, descript, income, expend, user};
        writer(anAccount);
        System.out.println(Arrays.toString(anAccount) + " 로 저장되었습니다.");
        System.out.println("HOME으로 돌아갑니다.");
        moneyBook.moneybookHome();
    }

    // (1-1) 번호 붙이기.
    public String numbering() {
        try {
            // 현재 순번을 Numbering.txt에서 불러오기
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\mission3\\Numbering.txt"));
            String currentNum = bufferedReader.readLine(); // 맨 첫줄만 읽어옴.
            int str_int = Integer.parseInt(currentNum); //  정수로 형변환해 +1
            str_int++;
            String int_str = Integer.toString(str_int);
            // 1 더해진 number를 다시 Numbering.txt에 저장
            FileWriter fileWriter = new FileWriter("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\mission3\\Numbering.txt");
            fileWriter.write(int_str);
            fileWriter.close();
            bufferedReader.close();
            return int_str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "오류";
    }

    // (2) Read 조회 (회원명은 출력하지 않음)
    public void readAccountDB() {
        System.out.println("--가계부를 읽어옵니다--");
        System.out.println("번호 | 날짜 | 내용 | 수입 | 지출 | 아이디");
        // AccountDB에서 읽어오기
        reader(); // 아이디 = ID 인 것만 읽어오기 로 발전시키기.
        // (2-1) 잔액 계산결과 추가
        // System.out.println("현재 잔고는 " + "원 입니다.");
        moneyBook.moneybookHome();

    }
    // (2-1) 잔액 계산, 출력

    // (3) Update 수정
    public void updateAccountDB() {
        System.out.println("--가계부를 수정합니다--");
        // AccountDB에서 수정하기
        System.out.println("HOME으로 돌아갑니다.");
        moneyBook.moneybookHome();
    }

    // (4) Delete 삭제
    public void deleteAccountDB() {
        System.out.println("D-가계부 삭제하기");
        // AccountDB에서 수정하기
        System.out.println("HOME으로 돌아갑니다.");
        moneyBook.moneybookHome();
    }


}
