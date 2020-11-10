package mission3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class DB {
    // 1. 회원 DB(해쉬맵) : ID, PW
    public static HashMap<String, String> IdPwDB = new HashMap<String, String>(); //<제네릭타입>

    // 2. 가계부 DB(배열의 리스트) : 날짜, 적요, 수입, 지출 (+ 번호, 잔액, 회원명)[7]
    public String AccountNum = "1";
    public ArrayList<String[]> AccountDB = new ArrayList<>(); // 문자열 배열을 넣는 리스트로 선언.
    //ArrayList에는 참조변수만 선언 가능.

    MoneyBook moneyBook = new MoneyBook();
    Scanner sc = new Scanner(System.in);


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

    // 로그인된 id값을 반환하는 함수

    //////////////////////2. 가계부 DB 관련 메서드-CRUD //////////////////////////
    // (1) Create 생성
    public void createAccountDB(){
        // 날짜, 적요, 수입, 지출 입력받기
        System.out.println("--가계부를 작성합니다--");
        System.out.println("가계부에 새 내역을 작성합니다. 날짜, 설명, 수입, 지출 순으로 입력해 주세요");
        System.out.println("날짜를 입력해 주세요(연,월,일의 8자리 숫자로 입력)");
        System.out.print(">");
         String date = sc.next();
        System.out.println("수입/지출에 대한 간단한 설명을 입력해 주세요");
        System.out.print(">");
         String descript = sc.next();
        System.out.println("수입이 얼마였는지 숫자로 입력해 주세요");
        System.out.print(">");
         String income = sc.next();
        System.out.println("지출은 얼마였는지 숫자로 입력해 주세요");
        System.out.print(">");
         String expend = sc.next();
        // 순번 추가
        String numbering = AccountNum;
        int intAccountNum = Integer.parseInt(AccountNum); // 숫자로 바꿔서 1 더하기
        intAccountNum++;
        AccountNum = Integer.toString(intAccountNum); // 다시 문자로 형변환
        System.out.println(numbering);
        System.out.println(AccountNum);

        // 잔액 계산, 추가
        // 회원명 추가
        String user = MoneyBook.ID;
        System.out.println(user);
        // 저장
        String[] anAccount = new String[]{numbering, date, descript, income, expend, user};
        AccountDB.add(anAccount);
        System.out.println(Arrays.toString(anAccount) + " 로 저장되었습니다.");
        System.out.println("HOME으로 돌아갑니다.");
        moneyBook.moneybookHome();

        //연도 리스트
        //설명 리스트
        //수입리스트
        //

    }

    // (2) Read 조회 (회원명은 출력하지 않음)
    public void readAccountDB(){
        System.out.println("--가계부를 읽어옵니다--");
        System.out.println("번호 | 날짜 | 내용 | 수입 | 지출 ");
        // AccountDB에서 읽어오기
        moneyBook.moneybookHome();


    }
    // (2-1) 잔액 계산, 출력

    // (3) Update 수정
    public void updateAccountDB(){
        System.out.println("--가계부를 수정합니다--");
        // AccountDB에서 수정하기
        System.out.println("HOME으로 돌아갑니다.");
        moneyBook.moneybookHome();
    }

    // (4) Delete 삭제
    public void deleteAccountDB(){
        System.out.println("D-가계부 삭제하기");
        // AccountDB에서 수정하기
        System.out.println("HOME으로 돌아갑니다.");
        moneyBook.moneybookHome();
    }


}
