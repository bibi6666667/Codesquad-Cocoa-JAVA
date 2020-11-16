package mission3and4;
// 'txt 파일 입력(데이터 넣기)' 테스트용 파일입니다.

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
    public static void main(String[] args) throws IOException{
        // 파일을 생성하기 위해 FileWriter 클래스 사용해 fw 객체를 생성.
        FileWriter fw = new FileWriter("c:/out.txt");
        // 파일에 넣고 싶은 내용 작성 : .write(내용);
        for(int i=1; i<11; i++) {
            String data = i+" 번째 고양이!🐱"+"\r\n";// \r\n은 줄바꿈 문자이다.
            fw.write(data);
        }
        fw.close();// 꼭 사용 후 닫아주기.

        // 기존 파일에 새로운 내용 추가하기 : 파일명 뒤에 추가모드(appenr)를 true로 한다.
        FileWriter fw2 = new FileWriter("c:/out.txt", true);
        for(int i=11; i<21; i++) {
            String data = "(추가)"+i+" 번째 고양이!🐱\r\n";
            fw2.write(data);
        }
        fw2.close();
    }

}