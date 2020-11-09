package mission3;

import java.util.Scanner;

public class AccountBook {
    static DB db = new DB();// 다른 class파일 불러오기

    public static void main(String[] args) {
        AccountBook accountBook = new AccountBook();
        accountBook.start();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("== 가계부입니다 ==");
        System.out.println("아무 숫자나 입력해 로그인 하세요. 만약 회원이 없다면, 0 을 입력해 회원가입으로 이동합니다 >");
        System.out.print(">");
        int inputNum = sc.nextInt();
        switch (inputNum) {
            case 0 :   // 회원가입
                register();
                break;
            default :  // 로그인
                login(); // Login.java 연결이 안됨..
                break;
        }

    }

    public static String[] register(){
        Scanner sc = new Scanner(System.in);
        // 입력받기
        System.out.println("--회원가입--");
        System.out.println("아이디를 입력하세요 > ");
        String id = sc.next();
        System.out.println("비밀번호를 입력하세요 > ");
        String pw = sc.next();
        // DB에 추가하기
        String[] newIdPwArr = {id, pw};
        db.makeMembersDB(newIdPwArr);
        return newIdPwArr;
    }

    public static String[] login(){
        Scanner sc = new Scanner(System.in);
        // 입력받기
        System.out.println("--로그인--");
        System.out.println("아이디를 입력하세요 > ");
        String id = sc.next();
        System.out.println("비밀번호를 입력하세요 > ");
        String pw = sc.next();
        // DB와 비교하기
        String[] checkIdPwArr = {id, pw};
        boolean checkResult = db.checkMembersDB(checkIdPwArr);
        if (checkResult == true) {
            // true이면 가계부 데이터에 접근
            db.readAccountDB();
        }
        if (checkResult == false) {
            // false이면 다시 로그인 또는 회원가입
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다. ");
            System.out.println("아무 숫자나 눌러 재시도하거나, 0을 눌러 회원가입을 하세요 >");
            int input = sc.nextInt();
            if (input == 0) {
                register();
            }
            if (input != 0) {
                login();
            }
        }

        return checkIdPwArr;
    }

    // 어떻게 연동할까?..

    public void create() {

    }

    public static void read() {

    }

    public void update(){

    }

    public void delete(){

    }
}



