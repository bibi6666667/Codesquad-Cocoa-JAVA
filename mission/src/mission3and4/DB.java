package mission3and4;

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

    public void appendWriter(String newAccount) {
        try { // 일반적인 경우 실행 구문
            FileWriter fileWriter = new FileWriter("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\mission3\\MoneyBookDB.txt", true);
            String input = newAccount + "\r\n";
            fileWriter.write(input);
            fileWriter.close();
        } catch (IOException e) { // 오류 발생시 잡는 구문
            e.printStackTrace();
        }
    }

    public void overWriter(String newAccount) {
        try { // 일반적인 경우 실행 구문
            FileWriter fileWriter = new FileWriter("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\mission3\\MoneyBookDB.txt");
            String input = newAccount + "\r\n";
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
        // System.out.println("현재 회원 목록 : " + IdPwDB);
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
        System.out.println("----------가계부를 작성합니다----------");
        System.out.println("가계부에 새 내역을 작성합니다. 날짜, 설명, 수입, 지출 순으로 입력해 주세요");
        System.out.println("'날짜'를 입력해 주세요(연,월,일의 8자리 숫자로 입력)");
        System.out.print(">");
        String date = sc.next();
        sc.nextLine(); // 개행문자 제거
        System.out.println("수입/지출에 대한 간단한 '설명'을 입력해 주세요");
        System.out.print(">");
        String descript = sc.nextLine();
        System.out.println("'수입'이 얼마였는지 숫자로 입력해 주세요");
        System.out.print(">");
        String income = sc.next();
        System.out.println("'지출'은 얼마였는지 숫자로 입력해 주세요");
        System.out.print(">");
        String expend = sc.next();
        String number = numbering();// 순번 추가
        String user = MoneyBook.ID;// 회원명 추가
        // 저장
        String anAccount = number + "/" + date + "/" + descript + "/" + income + "/" + expend + "/" + user;
        appendWriter(anAccount);
        System.out.println("👉" + number + "번) 날짜 : " + date + ", 설명 : " + descript + ", 수입 : " + income + ",지출 : " + expend + " 로 저장되었습니다.");
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
        System.out.println("----------가계부를 불러옵니다----------");
        System.out.println("번호 | 날짜 | 설명 | 수입 | 지출 | 아이디");
        reader(); // 아이디 = ID 인 것만 읽어오기 로 발전시키기.
        System.out.println("현재 잔고는 " + calBudget() + "원 입니다.");// (2-1) 잔고 계산결과
        moneyBook.moneybookHome();

    }

    // (2-1) 잔고 계산, 출력
    public String calBudget() {
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\mission3\\MoneyBookDB.txt"));
            String moneyBookListStr = new String();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) break;
                moneyBookListStr = moneyBookListStr + line + ",";
            }
            bufferedReader.close();
            // 수입,지출 찾아 계산
            String[] moneyBookListArr = moneyBookListStr.split(","); // 한 항목씩 나누어 배열로 저장
            // 배열의 0번째 요소부터 n번쨰 요소까지 가져와서 /기준으로 split. [3]은 income, [4]는 expend
            int allIncome = 0;
            int allExpend = 0;
            for (int i = 1; i < moneyBookListArr.length; i++) {
                String calListElement = moneyBookListArr[i];
                String[] elements = calListElement.split("/");
                allIncome += Integer.parseInt(elements[3]);
                allExpend += Integer.parseInt(elements[4]);
            }
            int budget = allIncome - allExpend;
            return Integer.toString(budget);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
    }

    // (3) Update 수정
    public void updateAccountDB() {
        System.out.println("----------가계부를 수정합니다----------");
        try { // 전체 라인 가져오기 - 고칠라인 찾기 - 고치기 - 저장. (원래 순서 보존을 위해)
            System.out.println("수정하고 싶은 내역의 번호를 입력하세요.");
            String fixNum = sc.next();
            System.out.println("<< 수정할 항목을 입력하세요 : 1.날짜, 2.설명, 3.수입, 4.지출 >>");
            int input = sc.nextInt();
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\mission3\\MoneyBookDB.txt"));
            String moneyBookListStr = new String();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) break;
                moneyBookListStr = moneyBookListStr + line + ",";
            }
            bufferedReader.close();
            String[] moneyBookListArr = moneyBookListStr.split(","); // 한 라인씩 나누어 배열로 저장
            overWriter("가계부"); // txt파일비우기 : 고쳐서 전부 새로 쓸 것이므로. null값으로 했었는데 오류남..;

            switch (input) {
                case 1://날짜수정 [1]
                    System.out.println("수정할 날짜를 입력하세요 (연,월,일의 8자리 숫자)");
                    String dateToFix = sc.next();
                    for (int i = 1; i < moneyBookListArr.length; i++) {
                        String aLine = moneyBookListArr[i];
                        String[] elements = aLine.split("/"); //elements [번호,날짜,설명..]배열
                        if (elements[0].equals(fixNum)) { //번호가 일치하면 (문자열이므로 .equals)
                            elements[1] = dateToFix; // 입력한 날짜로 고치기
                        }
                        aLine = String.join("/", elements);
                        appendWriter(aLine);
                    }
                    System.out.println("수정이 완료되었습니다.");
                    break;
                case 2: //설명수정 [2]
                    System.out.println("수정할 설명을 입력하세요");
                    String detailToFix = sc.next();
                    for (int i = 1; i < moneyBookListArr.length; i++) {
                        String aLine = moneyBookListArr[i];
                        String[] elements = aLine.split("/"); //elements [번호,날짜,설명..]배열
                        if (elements[0].equals(fixNum)) { //번호가 일치하면 (문자열이므로 .equals)
                            elements[2] = detailToFix; // 입력한 설명으로 고치기
                        }
                        aLine = String.join("/", elements);
                        appendWriter(aLine);
                    }
                    System.out.println("수정이 완료되었습니다.");
                    break;
                case 3://수입수정 [3]
                    System.out.println("수정할 수입을 입력하세요");
                    String incomeToFix = sc.next();
                    for (int i = 1; i < moneyBookListArr.length; i++) {
                        String aLine = moneyBookListArr[i];
                        String[] elements = aLine.split("/"); //elements [번호,날짜,설명..]배열
                        if (elements[0].equals(fixNum)) { //번호가 일치하면 (문자열이므로 .equals)
                            elements[3] = incomeToFix; // 입력한 설명으로 고치기
                        }
                        aLine = String.join("/", elements);
                        appendWriter(aLine);
                    }
                    System.out.println("수정이 완료되었습니다.");
                    break;
                case 4://지출수정[4]
                    System.out.println("수정할 수입을 입력하세요");
                    String expendToFix = sc.next();
                    for (int i = 1; i < moneyBookListArr.length; i++) {
                        String aLine = moneyBookListArr[i];
                        String[] elements = aLine.split("/"); //elements [번호,날짜,설명..]배열
                        if (elements[0].equals(fixNum)) { //번호가 일치하면 (문자열이므로 .equals)
                            elements[4] = expendToFix; // 입력한 설명으로 고치기
                        }
                        aLine = String.join("/", elements);
                        appendWriter(aLine);
                    }
                    System.out.println("수정이 완료되었습니다.");
                    break;
                default:
                    System.out.println("지정되지 않은 숫자를 입력했습니다. HOME으로 돌아갑니다.");
                    moneyBook.moneybookHome();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("HOME으로 돌아갑니다.");
        moneyBook.moneybookHome();
    }

    // (4) Delete 삭제
    public void deleteAccountDB() {
        System.out.println("----------가계부를 삭제합니다----------");
        System.out.println("삭제하고 싶은 내역의 번호를 입력하세요.");
        String delNum = sc.next();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("C:\\Users\\rnala\\OneDrive\\바탕 화면\\bibi\\Codesquad-Cocoa-JAVA\\mission\\src\\mission3\\MoneyBookDB.txt"));
            String moneyBookListStr = new String();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) break;
                moneyBookListStr = moneyBookListStr + line + ",";
            }
            bufferedReader.close();
            String[] moneyBookListArr = moneyBookListStr.split(","); // 한 라인씩 나누어 배열로 저장
            overWriter("가계부"); // txt파일비우기 : 전부 지운 다음 나머지 내역들은 그대로 다시 작성
            for (int i = 1; i < moneyBookListArr.length; i++) {
                String aLine = moneyBookListArr[i];
                String[] elements = aLine.split("/"); //elements [번호,날짜,설명..]배열
                if (elements[0].equals(delNum)) { //번호가 일치하면 (문자열이므로 .equals)
                    System.out.println("지울 데이터 :" + aLine);
                    continue;
                }
                aLine = String.join("/", elements);
                appendWriter(aLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("삭제가 완료되었습니다.");
        System.out.println("HOME으로 돌아갑니다.");
        moneyBook.moneybookHome();
    }

}
