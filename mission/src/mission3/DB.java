package mission3;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Arrays;

public class DB {
    // ID, PW DB (해쉬맵)
    private static HashMap<String, String> IdPwDB = new HashMap<String, String>();
    // 가계부 데이터 DB (배열의 리스트)

//    public static void main (String[] args){
//        DB db = new DB();
//        String[] IdPwArr = AccountBook.register();
//        db.makeMembersDB(IdPwArr);
//        System.out.println(IdPwDB);
//    }


    public void makeMembersDB(String[] IdPwArr) {
        //register() : 새 회원 생성
        String[] newIdPwArr = IdPwArr;
        String id = newIdPwArr[0];
        String pw = newIdPwArr[1];
        System.out.println(id + "," + pw + "로 가입합니다.");
        IdPwDB.put(id, pw);
        System.out.println("현재 회원 : "+IdPwDB);
        AccountBook.login();
    }
    
    public boolean checkMembersDB(String[] IdPwArr) {
        //login() : idpw 일치하면 로그인, 일치하지 않으면 다시 입력
        String[] checkIdPwIrr = IdPwArr;
        String id = checkIdPwIrr[0];
        String pw = checkIdPwIrr[1];
        // id가 있고 비밀번호가 일치하면 true, 불일치하면 false
        System.out.println(IdPwDB.containsKey(id));
        if (IdPwDB.containsKey(id) == true) {
            String DBPw = IdPwDB.get(id);
            System.out.println(DBPw);
            System.out.println(pw);
            System.out.println(DBPw.equals(pw)); // String이라서 equals로 비교해야.
            if (DBPw.equals(pw)) {
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
    
    public void AccountBookDB(){
        // 날짜, 적요, 수입, 지출 입력받고, 순번과 회원명 추가해서 저장
    }
}
