package mission3and4;

import java.util.Scanner;

public class MoneyBook {
    static DB db = new DB();// 다른 class파일 불러오기

    public static void main(String[] args) {
        MoneyBook moneyBook = new MoneyBook();
        moneyBook.loginHome();
    }

    public static String ID; // 현재 로그인한 ID. .login() -> ID -> DB

    public static Scanner sc = new Scanner(System.in);


    // 매 선택마다 home, 종료 버튼 추가하기. (로그인 홈 / 가계부 목록)
    public void loginHome() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*=========[가계부]=========*");
        System.out.println("==========[Login]==========");
        System.out.println("- 아무 숫자나 입력해 로그인 하세요.");
        System.out.println("- 처음이라면, 0 을 입력해 회원가입으로 이동합니다.");
        System.out.println("- 4를 입력하면 종료됩니다.");
        System.out.print(">");
        int inputNum = sc.nextInt();
        switch (inputNum) {
            case 0 :   // 회원가입
                register();
                break;
            case 4 : // 종료
                System.out.println("또 오세요!");
                break;
            default :  // 로그인
                login();
                break;
        }
    }

    public String[] register(){
        // 입력받기
        System.out.println("----------회원가입----------");
        System.out.println("아이디를 입력하세요 (문자)");
        System.out.print(">");
        String id = sc.next();
        System.out.println("비밀번호를 입력하세요 (문자)");
        System.out.print(">");
        String pw = sc.next();
        // DB에 추가하기
        String[] newIdPwArr = {id, pw};
        db.makeMembersDB(newIdPwArr);
        return newIdPwArr;
    }

    public String[] login(){
        Scanner sc = new Scanner(System.in);
        // 입력받기
        System.out.println("----------로그인----------");
        System.out.println("아이디를 입력하세요 (문자)");
        System.out.print(">");
        String id = sc.next();
        System.out.println("비밀번호를 입력하세요 (문자)");
        System.out.print(">");
        String pw = sc.next();
        ID = id;
        // DB와 비교하기
        String[] IdPwArr = {id, pw};
        boolean checkResult = db.checkMembersDB(IdPwArr);
        if (checkResult == true) {
            // true이면 가계부 데이터에 접근
            System.out.println("✨ 가계부에 오신 것을 환영합니다 ✨");
            moneybookHome();
        }
        if (checkResult == false) {
            // false이면 다시 로그인 또는 회원가입
            System.out.println("⚠ 아이디 또는 비밀번호가 일치하지 않습니다. ");
            System.out.println("아무 숫자나 눌러 재시도하거나, 0을 눌러 회원가입을 하세요");
            System.out.print(">");
            int input = sc.nextInt();
            if (input == 0) {
                register();
            }
            if (input != 0) {
                login();
            }
        }
        return IdPwArr;
    }

/////////////////////////////////////////////

    public void moneybookHome(){
        System.out.println("==========[HOME]==========");
        System.out.println("실행을 원하는 숫자를 입력하세요.");
        System.out.println("<< 0 : 내용 작성, 1 : 내용 조회, 2 : 내용 수정, 3 : 내용 삭제, 4 : 종료 >>");
        System.out.print(">");
        int inputNum = sc.nextInt();
        switch(inputNum) {
            case 0 :
                db.createAccountDB();
                break;
            case 1 :
                db.readAccountDB();
                break;
            case 2 :
                db.updateAccountDB();
                break;
            case 3 :
                db.deleteAccountDB();
                break;
            case 4 :
                System.out.println("또 오세요!");
                return;
            default:
                System.out.println("지정되지 않은 숫자를 입력했습니다. 로그인 화면으로 되돌아갑니다.");
                loginHome();
        }
    }

    // 종료 누르면 종료 직전에 txt파일에 올리고 끝내기. (최종결과만 반영)

    public void create() {

    }

    public void read() {

    }

    public void update(){

    }

    public void delete(){

    }
}



